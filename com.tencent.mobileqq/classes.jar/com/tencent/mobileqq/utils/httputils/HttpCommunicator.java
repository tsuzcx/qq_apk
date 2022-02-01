package com.tencent.mobileqq.utils.httputils;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.RichMediaStrategy;
import com.tencent.mobileqq.transfile.RichMediaStrategy.NetPolicy;
import com.tencent.mobileqq.transfile.RichMediaStrategy.OldEngineDPCProfile.TimeoutParam;
import com.tencent.mobileqq.transfile.RichMediaUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.HttpsURLConnection;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;

public class HttpCommunicator
{
  public static final int MAX_REDIRECT_NUM = 5;
  public static final int STATUS_ADD = 0;
  public static final int STATUS_END = 5;
  public static final int STATUS_GOT_DATA = 4;
  public static final int STATUS_GOT_HEAD = 3;
  public static final int STATUS_ONGOING = 6;
  public static final int STATUS_OPEN = 1;
  public static final int STATUS_OPENED = 2;
  public static final boolean WHITE_SHARK_AVAILABLE = true;
  private static final String contentZero = "content-length zero";
  private static long statTotalDown = 0L;
  private static long statTotalUp = 1L;
  private static final String tag = "Q.richmedia.HttpCommunicator";
  private volatile boolean bDispose;
  private volatile boolean bRun;
  boolean forceDirect = true;
  String lastApn = null;
  private Object locker = new ReentrantLock();
  private Runnable mCheckThreadPoolIdleRunnable;
  private int mConcurrentLimit;
  private int mConcurrentRunningMsgs;
  private WeakReference<IHttpCommunicatorFlowCount> mFlowCounter;
  private HttpCommunicator.HttpCommunicatorHandler[] mHttpHandlers;
  private AtomicBoolean mPreemptEnabled = new AtomicBoolean(false);
  private HttpCommunicator.PriorityQueue mSendQueue = new HttpCommunicator.PriorityQueue();
  private MqqHandler mTimeoutCheckHandler;
  private int maxQueueLength;
  private final int maxThread = 4;
  private int seed;
  
  public HttpCommunicator() {}
  
  public HttpCommunicator(IHttpCommunicatorFlowCount paramIHttpCommunicatorFlowCount, int paramInt)
  {
    this.mFlowCounter = new WeakReference(paramIHttpCommunicatorFlowCount);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "construct HTTPcomm");
    }
    this.maxQueueLength = paramInt;
    this.mConcurrentLimit = 4;
    this.mConcurrentRunningMsgs = 0;
    if (Integer.parseInt(Build.VERSION.SDK) < 8) {
      System.setProperty("http.keepAlive", "false");
    }
    System.setProperty("http.maxConnections", "2");
  }
  
  private boolean checkThreadPoolIdle(boolean paramBoolean)
  {
    int j = 0;
    synchronized (this.locker)
    {
      if (this.bDispose) {
        return false;
      }
      if (!this.bRun) {
        return true;
      }
      if (this.mSendQueue.getQueueMsgNums() > 0) {
        return false;
      }
    }
    if ((this.mHttpHandlers == null) || (this.mHttpHandlers.length == 0)) {
      return false;
    }
    if (this.mConcurrentRunningMsgs > 0) {
      return false;
    }
    HttpCommunicator.HttpCommunicatorHandler[] arrayOfHttpCommunicatorHandler = this.mHttpHandlers;
    int k = arrayOfHttpCommunicatorHandler.length;
    int i = 0;
    for (;;)
    {
      if (i < k)
      {
        HttpCommunicator.HttpCommunicatorHandler localHttpCommunicatorHandler = arrayOfHttpCommunicatorHandler[i];
        if ((localHttpCommunicatorHandler != null) && (localHttpCommunicatorHandler.isProcReq != null) && (localHttpCommunicatorHandler.isProcReq.get())) {
          return false;
        }
      }
      else
      {
        if (paramBoolean)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator checkThreadPoolIdle ，ThreadPool Quit ");
          }
          arrayOfHttpCommunicatorHandler = this.mHttpHandlers;
          k = arrayOfHttpCommunicatorHandler.length;
          i = j;
          while (i < k)
          {
            arrayOfHttpCommunicatorHandler[i].sendEmptyMessage(1);
            i += 1;
          }
          this.mConcurrentRunningMsgs = 0;
          this.mConcurrentLimit = 0;
          this.bRun = false;
          this.mHttpHandlers = null;
        }
        return true;
      }
      i += 1;
    }
  }
  
  private HttpURLConnection getConnection(HttpMsg paramHttpMsg)
  {
    Object localObject1 = paramHttpMsg.getUrl();
    String str1 = (String)paramHttpMsg.requestPropertys.remove("mType");
    String str2;
    int i1;
    int k;
    int i;
    label52:
    Object localObject2;
    int j;
    if (str1 != null)
    {
      str1 = MsfSdkUtils.insertMtype(str1, (String)localObject1);
      localObject1 = null;
      str2 = android.net.Proxy.getDefaultHost();
      i1 = android.net.Proxy.getDefaultPort();
      k = 0;
      i = 0;
      if ((i != 0) || (k >= 2)) {
        break label955;
      }
      localObject2 = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      localObject1 = null;
      if (localObject2 == null) {
        break label964;
      }
      j = ((NetworkInfo)localObject2).getType();
      localObject1 = ((NetworkInfo)localObject2).getExtraInfo();
    }
    for (;;)
    {
      String str3 = PkgTools.getApnType((String)localObject1);
      paramHttpMsg.isRequestInCmwap = PkgTools.APN_TYPE_CMWAP.equals(str3);
      if (!str3.equals(this.lastApn))
      {
        if ((j == 1) || (str3.equals(PkgTools.APN_TYPE_CMWAP))) {
          this.forceDirect = false;
        }
      }
      else
      {
        label151:
        if ((j == 1) && (("10.0.0.172".equals(str2)) || ("10.0.0.200".equals(str2)))) {
          this.forceDirect = true;
        }
        if ((str2 == null) || (i1 <= 0)) {
          break label958;
        }
      }
      label289:
      label955:
      label958:
      for (int m = 1;; m = 0)
      {
        int i2;
        Object localObject3;
        int n;
        if ((!this.forceDirect) && (m != 0)) {
          if ((str3.equals(PkgTools.APN_TYPE_CMWAP)) || (str3.equals(PkgTools.APN_TYPE_UNIWAP)) || (str3.equals(PkgTools.APN_TYPE_3GWAP))) {
            if (!paramHttpMsg.isCmwapRetried) {
              switch (paramHttpMsg.mCmwapConnectionType)
              {
              default: 
                localObject1 = PkgTools.getConnectionWithXOnlineHost(str1, str2, i1);
                i = 1;
                httpsSSLProcess((HttpURLConnection)localObject1, paramHttpMsg);
                paramHttpMsg.netType = j;
                i2 = NetworkCenter.getInstance().getNetType();
                if (paramHttpMsg.timeoutParam == null)
                {
                  localObject3 = RichMediaStrategy.getPolicy(i2);
                  n = ((RichMediaStrategy.NetPolicy)localObject3).getConnectTimeout();
                  if ("POST".equals(paramHttpMsg.getRequestMethod())) {
                    j = 89500;
                  }
                }
                break;
              }
            }
          }
        }
        for (;;)
        {
          ((HttpURLConnection)localObject1).setConnectTimeout(n);
          ((HttpURLConnection)localObject1).setReadTimeout(j);
          logHttpCommunicator(paramHttpMsg, "gettingConn", "getConnection type:" + i2 + " activeNetworkInfo: " + localObject2 + " defaultHost:" + str2 + " defaultPort: " + i1 + " last apnType:" + this.lastApn + " forceDirect:" + this.forceDirect + ",connectTimeOut:" + n + ",readTimeout:" + j);
          ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
          localObject2 = paramHttpMsg.requestPropertys.entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (Map.Entry)((Iterator)localObject2).next();
            ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
          }
          str1 = MsfSdkUtils.insertMtype("Other", (String)localObject1);
          break;
          this.forceDirect = true;
          break label151;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection(java.net.Proxy.NO_PROXY);
          i = 0;
          break label289;
          localObject1 = PkgTools.getConnectionWithDefaultProxy(str1, str2, i1);
          i = 1;
          break label289;
          localObject1 = PkgTools.getConnectionWithXOnlineHost(str1, str2, i1);
          i = 1;
          break label289;
          if (str3.equals(PkgTools.APN_TYPE_CTWAP))
          {
            localObject1 = PkgTools.getConnectionWithDefaultProxy(str1, str2, i1);
            i = 1;
            break label289;
          }
          localObject1 = PkgTools.getConnectionWithDefaultProxy(str1, str2, i1);
          i = 1;
          break label289;
          localObject1 = (HttpURLConnection)new URL(str1).openConnection();
          i = 0;
          break label289;
          j = ((RichMediaStrategy.NetPolicy)localObject3).getReadTimeout();
          continue;
          n = paramHttpMsg.timeoutParam.getConnectTimeout(i2);
          j = paramHttpMsg.timeoutParam.getReadTimeout(i2);
        }
        if (paramHttpMsg.getRequestMethod().equals("POST"))
        {
          ((HttpURLConnection)localObject1).setDoOutput(true);
          if (paramHttpMsg.getSendData() != null) {
            ((HttpURLConnection)localObject1).setFixedLengthStreamingMode(paramHttpMsg.getSendData().length);
          }
        }
        paramHttpMsg.rawReqHeader = ((HttpURLConnection)localObject1).getRequestProperties().toString();
        try
        {
          ((HttpURLConnection)localObject1).connect();
          i = 1;
        }
        catch (Exception localException)
        {
          while (m != 0) {
            if ((i != 0) && (m != 0))
            {
              i = 0;
              this.forceDirect = true;
            }
            else if ((m != 0) && (i == 0))
            {
              i = 0;
              this.forceDirect = false;
            }
            else
            {
              throw localException;
            }
          }
          throw localException;
        }
        catch (AssertionError localAssertionError)
        {
          String str4;
          for (;;)
          {
            str4 = localAssertionError.getMessage();
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.HttpCommunicator", 2, "assertion:" + str4);
            }
            if (m == 0) {
              break;
            }
            if ((i != 0) && (m != 0))
            {
              i = 0;
              this.forceDirect = true;
            }
            else if ((m != 0) && (i == 0))
            {
              i = 0;
              this.forceDirect = false;
            }
            else
            {
              i = 1;
            }
          }
          throw new SocketException("AssertionError : " + str4);
        }
        this.lastApn = str3;
        k += 1;
        break label52;
        return localObject1;
      }
      label964:
      j = -1;
    }
  }
  
  private void httpsSSLProcess(HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    String str;
    HttpCommunicator.2 local2;
    if ((paramHttpMsg.mIsHttps) && ((paramHttpURLConnection instanceof HttpsURLConnection)))
    {
      paramHttpURLConnection = (HttpsURLConnection)paramHttpURLConnection;
      str = paramHttpMsg.mReqHost;
      local2 = new HttpCommunicator.2(this, str, paramHttpMsg);
      if (paramHttpMsg.mIsHostIP)
      {
        paramHttpURLConnection.setRequestProperty("host", str);
        paramHttpURLConnection.setSSLSocketFactory(new SniSSLSocketFactory(str, local2));
        paramHttpURLConnection.setHostnameVerifier(local2);
      }
    }
    else
    {
      return;
    }
    paramHttpURLConnection.setRequestProperty("host", str);
    paramHttpURLConnection.setHostnameVerifier(local2);
  }
  
  private void statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SSCM", 2, "msg statuschanged: " + paramInt);
    }
    paramHttpMsg1.getProcessor().statusChanged(paramHttpMsg1, paramHttpMsg2, paramInt);
  }
  
  public void cancelMsg(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg == null) {
      return;
    }
    synchronized (this.locker)
    {
      this.mSendQueue.removeHttpMsg(paramHttpMsg);
      paramHttpMsg.mIsCancel.set(true);
      return;
    }
  }
  
  void checkInterruptedBeforeBlock(HttpCommunicator.HttpCommunicatorHandler paramHttpCommunicatorHandler, HttpMsg paramHttpMsg)
  {
    if ((!this.bRun) && (!paramHttpMsg.mIsSync)) {
      throw new IOException("httpcommunicator closed");
    }
    if (paramHttpMsg.mIsCancel.get()) {
      throw new IOException("request cancelled");
    }
    if ((paramHttpCommunicatorHandler != null) && (paramHttpCommunicatorHandler.forceFinish.get())) {
      throw new RuntimeException("thread should close");
    }
    if (paramHttpMsg.mIsPreempted.get())
    {
      logHttpCommunicator(paramHttpMsg, "interrupt", "preempted");
      throw new IOException("preempted by higher msg");
    }
  }
  
  void checkReportLongRespEvent(long paramLong, int paramInt)
  {
    int i = 4;
    int j = (int)(2L * paramLong / 90000L);
    if (j > 4) {}
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_FailCode", String.valueOf(i + 9400));
      localHashMap.put("param_PostSize", String.valueOf(paramInt));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "LongHttpRespTime", false, paramLong, 0L, localHashMap, "");
      return;
      i = j;
    }
  }
  
  public void close()
  {
    this.mTimeoutCheckHandler.post(new HttpCommunicator.3(this));
  }
  
  public void close_inter()
  {
    int i = 0;
    long l;
    synchronized (this.locker)
    {
      l = System.currentTimeMillis();
      HttpMsg localHttpMsg;
      do
      {
        localHttpMsg = this.mSendQueue.getMaxPriortyMsg(true);
        if (localHttpMsg == null) {
          break;
        }
      } while ((localHttpMsg == null) || (localHttpMsg.getProcessor() == null));
      localHttpMsg.setHttpErrorCode(9366, -1, "httpcommunicator_close");
      localHttpMsg.getProcessor().handleError(localHttpMsg, localHttpMsg);
    }
    this.mSendQueue.clearMsgs();
    if (this.mHttpHandlers != null)
    {
      HttpCommunicator.HttpCommunicatorHandler[] arrayOfHttpCommunicatorHandler = this.mHttpHandlers;
      int j = arrayOfHttpCommunicatorHandler.length;
      while (i < j)
      {
        arrayOfHttpCommunicatorHandler[i].sendEmptyMessage(1);
        i += 1;
      }
    }
    this.mHttpHandlers = null;
    this.mConcurrentRunningMsgs = 0;
    this.mConcurrentLimit = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.richmedia.HttpCommunicator", 2, "HttpCommunicator close_inter.elapse:" + (System.currentTimeMillis() - l));
    }
  }
  
  void copyRespHeader(int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    if ((paramHttpURLConnection == null) || (paramHttpMsg == null)) {
      return;
    }
    paramHttpMsg.setResponseCode(paramInt);
    paramHttpMsg.setResponseProperty("Content-Type", paramHttpURLConnection.getContentType());
    paramHttpMsg.rawRespHeader = paramHttpURLConnection.getHeaderFields().toString();
    if (paramHttpURLConnection.getHeaderField("User-ReturnCode") != null) {
      paramHttpMsg.setResponseProperty("User-ReturnCode", paramHttpURLConnection.getHeaderField("User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("X-User-ReturnCode") != null) {
      paramHttpMsg.setResponseProperty("X-User-ReturnCode", paramHttpURLConnection.getHeaderField("X-User-ReturnCode"));
    }
    if (paramHttpURLConnection.getHeaderField("content-range") != null) {
      paramHttpMsg.setResponseProperty("content-range", paramHttpURLConnection.getHeaderField("content-range"));
    }
    if (paramHttpURLConnection.getHeaderField("Range") != null) {
      paramHttpMsg.setResponseProperty("Range", paramHttpURLConnection.getHeaderField("Range"));
    }
    if (paramHttpURLConnection.getHeaderField("X-Range") != null) {
      paramHttpMsg.setResponseProperty("X-Range", paramHttpURLConnection.getHeaderField("X-Range"));
    }
    if (paramHttpURLConnection.getHeaderField("Content-Encoding") != null) {
      paramHttpMsg.setResponseProperty("Content-Encoding", paramHttpURLConnection.getHeaderField("Content-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("Transfer-Encoding") != null) {
      paramHttpMsg.setResponseProperty("Transfer-Encoding", paramHttpURLConnection.getHeaderField("Transfer-Encoding"));
    }
    if (paramHttpURLConnection.getHeaderField("X-RtFlag") != null) {
      paramHttpMsg.setResponseProperty("X-RtFlag", paramHttpURLConnection.getHeaderField("X-RtFlag"));
    }
    if (paramHttpURLConnection.getHeaderField("X-httime") != null) {
      paramHttpMsg.setResponseProperty("X-httime", paramHttpURLConnection.getHeaderField("X-httime"));
    }
    if (paramHttpURLConnection.getHeaderField("X-piccachetime") != null) {
      paramHttpMsg.setResponseProperty("X-piccachetime", paramHttpURLConnection.getHeaderField("X-piccachetime"));
    }
    paramHttpMsg.totalLen = -1L;
    String str = paramHttpURLConnection.getHeaderField("content-range");
    int i;
    if (str != null) {
      i = str.lastIndexOf("/");
    }
    for (;;)
    {
      try
      {
        paramHttpMsg.totalLen = Long.valueOf(str.substring(i + 1)).longValue();
        paramHttpMsg.totalBlockLen = paramHttpURLConnection.getContentLength();
        logHttpCommunicator(paramHttpMsg, "copyRespHeader", "resultCode:" + paramInt + " totalLen:" + paramHttpMsg.totalLen + ",totalBlockLen:" + paramHttpMsg.totalBlockLen);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        continue;
      }
      paramHttpMsg.totalLen = paramHttpURLConnection.getContentLength();
      paramHttpMsg.totalBlockLen = paramHttpMsg.totalLen;
    }
  }
  
  public void disPatchMsg(String paramString)
  {
    int i = 0;
    if (this.bDispose) {
      return;
    }
    synchronized (this.locker)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpCommunicator", 2, "queueSize:" + this.mSendQueue.getQueueMsgNums() + " mConcurrentRunningMsgs:" + this.mConcurrentRunningMsgs + " mConcurrentLimit:" + this.mConcurrentLimit + " reason:" + paramString + " tid:" + Thread.currentThread().getId());
      }
      if (this.mSendQueue.getQueueMsgNums() == 0) {
        return;
      }
    }
    HttpCommunicator.HttpCommunicatorHandler[] arrayOfHttpCommunicatorHandler;
    int j;
    if (this.mConcurrentRunningMsgs < this.mConcurrentLimit)
    {
      paramString = this.mSendQueue.getMaxPriortyMsg(false);
      if (paramString != null)
      {
        arrayOfHttpCommunicatorHandler = this.mHttpHandlers;
        j = arrayOfHttpCommunicatorHandler.length;
      }
    }
    for (;;)
    {
      HttpCommunicator.HttpCommunicatorHandler localHttpCommunicatorHandler;
      HttpMsg localHttpMsg;
      if (i < j)
      {
        localHttpCommunicatorHandler = arrayOfHttpCommunicatorHandler[i];
        localHttpMsg = localHttpCommunicatorHandler.curReq;
        if (localHttpCommunicatorHandler.isProcReq.get()) {
          break label268;
        }
        this.mSendQueue.removeHttpMsg(paramString);
        paramString.refresh();
        localHttpCommunicatorHandler.isProcReq.set(true);
        localHttpCommunicatorHandler.curReq = paramString;
        localHttpCommunicatorHandler.sendRequestToProc(paramString);
        this.mConcurrentRunningMsgs += 1;
        paramString.inQueueCost = (SystemClock.uptimeMillis() - paramString.inQueueStartTime);
        if (QLog.isColorLevel()) {
          logHttpCommunicator(paramString, "attach", "");
        }
      }
      for (;;)
      {
        return;
        label268:
        if ((!this.mPreemptEnabled.get()) || (!localHttpCommunicatorHandler.isProcReq.get()) || (localHttpMsg == null) || (localHttpMsg.getPriority() <= paramString.getPriority())) {
          break;
        }
        localHttpCommunicatorHandler.interruptCurrentMsg();
      }
      i += 1;
    }
  }
  
  public String getFullQueue()
  {
    if (this.mSendQueue != null) {
      return this.mSendQueue.getFullSendQueue();
    }
    return "";
  }
  
  Exception getInjectException(int paramInt)
  {
    switch (paramInt % 10)
    {
    default: 
      return new Exception("inject Exception");
    case 0: 
      return new SocketTimeoutException("inject sockettimeout");
    case 1: 
      return new PortUnreachableException("inject PortUnreachableException");
    case 2: 
      return new ConnectException("inject ConnectException");
    case 3: 
      return new NoRouteToHostException("inject NoRouteToHostException");
    case 4: 
      return new IllegalArgumentException("inject IllegalArgumentException");
    case 5: 
      return new IllegalStateException("inject IllegalStateException");
    case 6: 
      return new IOException("inject IOException");
    case 7: 
      return new IOException("preempted by higher msg");
    case 8: 
      return new IOException("HttpCommunicator closed or msg caceled!");
    }
    return new IOException("content-length zero");
  }
  
  int getInjectionRespCode(int paramInt)
  {
    switch (paramInt % 5)
    {
    case 0: 
    default: 
      return 404;
    case 1: 
      return 416;
    case 2: 
      return 302;
    case 3: 
      return 501;
    }
    return 400;
  }
  
  public int getMaxQueueLength()
  {
    return this.maxQueueLength;
  }
  
  protected void logFlow(HttpMsg paramHttpMsg, boolean paramBoolean, long paramLong)
  {
    paramHttpMsg.flow = ((int)paramLong);
    int i = paramHttpMsg.fileType;
    int j = paramHttpMsg.busiType;
    int k = paramHttpMsg.netType;
    if (((i == -1) || (j == -1)) && (QLog.isColorLevel())) {
      QLog.e("flowstat", 2, "fileType:" + i + ",busiType:" + j);
    }
    if ((this.mFlowCounter != null) && (this.mFlowCounter.get() != null)) {
      ((IHttpCommunicatorFlowCount)this.mFlowCounter.get()).countFlow(paramBoolean, k, i, j, paramLong);
    }
  }
  
  void logHttpCommunicator(HttpMsg paramHttpMsg, String paramString1, String paramString2)
  {
    try
    {
      RichMediaUtil.log(RichMediaUtil.getUinDesc(paramHttpMsg.busiType), paramHttpMsg.getRequestMethod().equals("POST"), RichMediaUtil.getFileTypeDesc(paramHttpMsg.fileType), paramHttpMsg.msgId, paramString1, paramString2);
      return;
    }
    catch (OutOfMemoryError paramHttpMsg) {}
  }
  
  public void onResponseTimeout(HttpMsg paramHttpMsg, HttpCommunicator.HttpCommunicatorHandler paramHttpCommunicatorHandler)
  {
    int i = 0;
    if ((paramHttpMsg != null) && (paramHttpCommunicatorHandler != null)) {
      try
      {
        logHttpCommunicator(paramHttpMsg, "responseTimeout", "");
        if (paramHttpMsg.getSendData() == null) {}
        for (;;)
        {
          checkReportLongRespEvent(90000L, i);
          replaceNewThread(paramHttpCommunicatorHandler);
          paramHttpMsg.setHttpErrorCode(9014, 0, "response timeout");
          paramHttpMsg.getProcessor().handleError(paramHttpMsg, paramHttpMsg);
          return;
          i = paramHttpMsg.getSendData().length;
        }
        return;
      }
      catch (Exception paramHttpMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "onResponseTimeout", paramHttpMsg);
        }
      }
    }
  }
  
  void procBadResponse(int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    new StringBuilder().append("Response code: ").append(paramInt).toString();
    long l2 = 0L;
    String str = paramHttpURLConnection.getHeaderField("X-ErrNo");
    if ((str != null) && (!str.equals(""))) {}
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(str);
        paramHttpURLConnection = BaseTransProcessor.getHttpDataReason(paramInt, l1);
        paramHttpMsg.setResponseProperty(HttpMsg.Param_Reason, paramHttpURLConnection);
        paramHttpMsg.setHttpErrorCode(-9527, paramInt, paramHttpURLConnection);
        return;
      }
      catch (Exception paramHttpURLConnection)
      {
        paramHttpURLConnection.printStackTrace();
        l1 = l2;
        continue;
      }
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("User-ReturnCode");
      long l1 = l2;
      if (paramHttpURLConnection != null)
      {
        l1 = l2;
        if (!paramHttpURLConnection.equals("")) {
          try
          {
            l1 = Long.parseLong(paramHttpURLConnection);
          }
          catch (Exception paramHttpURLConnection)
          {
            paramHttpURLConnection.printStackTrace();
            l1 = l2;
          }
        }
      }
    }
  }
  
  public void replaceNewThread(HttpCommunicator.HttpCommunicatorHandler paramHttpCommunicatorHandler)
  {
    if (this.bDispose) {}
    int i;
    do
    {
      do
      {
        return;
      } while (paramHttpCommunicatorHandler == null);
      paramHttpCommunicatorHandler.forceFinish.set(true);
      i = paramHttpCommunicatorHandler.index;
      if ((i >= 0) && (i < 4))
      {
        ??? = new HandlerThread("httpcommunicator_norm_new_" + i, 5);
        ((HandlerThread)???).start();
        HttpCommunicator.HttpCommunicatorHandler localHttpCommunicatorHandler = new HttpCommunicator.HttpCommunicatorHandler(this, ((HandlerThread)???).getLooper());
        localHttpCommunicatorHandler.index = i;
        synchronized (this.locker)
        {
          this.mHttpHandlers[i] = localHttpCommunicatorHandler;
          if (paramHttpCommunicatorHandler.isProcReq.get()) {
            this.mConcurrentRunningMsgs -= 1;
          }
          disPatchMsg("replaceNewThread index:" + i);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.richmedia.HttpCommunicator", 2, "replaceNewThread,index error occurs. " + i);
  }
  
  /* Error */
  public void run(HttpMsg paramHttpMsg, HttpCommunicator.HttpCommunicatorHandler paramHttpCommunicatorHandler)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 519	com/tencent/mobileqq/utils/httputils/HttpMsg:getProcessor	()Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   4: astore 30
    //   6: aconst_null
    //   7: astore 23
    //   9: aconst_null
    //   10: astore 28
    //   12: aconst_null
    //   13: astore 26
    //   15: aconst_null
    //   16: astore 22
    //   18: aconst_null
    //   19: astore 29
    //   21: aconst_null
    //   22: astore 27
    //   24: iconst_m1
    //   25: istore_3
    //   26: lconst_0
    //   27: lstore 12
    //   29: lconst_0
    //   30: lstore 14
    //   32: iconst_0
    //   33: istore 10
    //   35: iconst_0
    //   36: istore 7
    //   38: iconst_0
    //   39: istore 6
    //   41: aload_0
    //   42: aload_1
    //   43: aconst_null
    //   44: iconst_1
    //   45: invokespecial 919	com/tencent/mobileqq/utils/httputils/HttpCommunicator:statusChanged	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;I)V
    //   48: iconst_0
    //   49: istore 5
    //   51: iconst_0
    //   52: istore 10
    //   54: aconst_null
    //   55: astore 24
    //   57: aload_0
    //   58: aload_1
    //   59: ldc_w 921
    //   62: ldc_w 593
    //   65: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_0
    //   69: aload_2
    //   70: aload_1
    //   71: invokevirtual 923	com/tencent/mobileqq/utils/httputils/HttpCommunicator:checkInterruptedBeforeBlock	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   74: aload_0
    //   75: aload_1
    //   76: invokespecial 925	com/tencent/mobileqq/utils/httputils/HttpCommunicator:getConnection	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)Ljava/net/HttpURLConnection;
    //   79: astore 25
    //   81: aload 25
    //   83: astore 23
    //   85: aload_1
    //   86: aload 23
    //   88: putfield 929	com/tencent/mobileqq/utils/httputils/HttpMsg:mConn	Ljava/net/HttpURLConnection;
    //   91: aload_1
    //   92: invokestatic 750	android/os/SystemClock:uptimeMillis	()J
    //   95: putfield 932	com/tencent/mobileqq/utils/httputils/HttpMsg:startTime	J
    //   98: aload_0
    //   99: aload_1
    //   100: ldc_w 934
    //   103: ldc_w 593
    //   106: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   109: iconst_1
    //   110: istore 10
    //   112: invokestatic 614	java/lang/System:currentTimeMillis	()J
    //   115: pop2
    //   116: aload_1
    //   117: invokevirtual 325	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   120: ldc_w 322
    //   123: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   126: ifeq +4840 -> 4966
    //   129: new 936	com/tencent/mobileqq/utils/httputils/HttpCommunicator$1
    //   132: dup
    //   133: aload_0
    //   134: aload_1
    //   135: aload_2
    //   136: invokespecial 939	com/tencent/mobileqq/utils/httputils/HttpCommunicator$1:<init>	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler;)V
    //   139: astore 25
    //   141: aload_0
    //   142: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   145: aload 25
    //   147: ldc2_w 570
    //   150: invokevirtual 943	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   153: pop
    //   154: aload_1
    //   155: invokevirtual 453	com/tencent/mobileqq/utils/httputils/HttpMsg:getSendData	()[B
    //   158: astore 31
    //   160: aload 23
    //   162: invokevirtual 947	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   165: astore 24
    //   167: aload_0
    //   168: aload_1
    //   169: ldc_w 949
    //   172: new 339	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   179: ldc_w 951
    //   182: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 31
    //   187: arraylength
    //   188: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   191: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   197: iconst_0
    //   198: istore 4
    //   200: iload 4
    //   202: aload 31
    //   204: arraylength
    //   205: if_icmpge +46 -> 251
    //   208: aload_0
    //   209: aload_2
    //   210: aload_1
    //   211: invokevirtual 923	com/tencent/mobileqq/utils/httputils/HttpCommunicator:checkInterruptedBeforeBlock	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   214: aload 24
    //   216: aload 31
    //   218: iload 4
    //   220: sipush 10240
    //   223: aload 31
    //   225: arraylength
    //   226: iload 4
    //   228: isub
    //   229: invokestatic 957	java/lang/Math:min	(II)I
    //   232: invokevirtual 963	java/io/OutputStream:write	([BII)V
    //   235: aload 24
    //   237: invokevirtual 966	java/io/OutputStream:flush	()V
    //   240: iload 4
    //   242: sipush 10240
    //   245: iadd
    //   246: istore 4
    //   248: goto -48 -> 200
    //   251: aload_2
    //   252: ifnull +13 -> 265
    //   255: aload_2
    //   256: getfield 551	com/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   259: invokevirtual 182	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   262: ifne +14 -> 276
    //   265: aload_0
    //   266: aload_1
    //   267: ldc_w 968
    //   270: ldc_w 593
    //   273: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   276: aload 23
    //   278: invokevirtual 972	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   281: invokevirtual 973	java/net/URL:toString	()Ljava/lang/String;
    //   284: invokevirtual 976	java/lang/String:length	()I
    //   287: i2l
    //   288: lstore 16
    //   290: aload 31
    //   292: arraylength
    //   293: istore 4
    //   295: lload 12
    //   297: iload 4
    //   299: i2l
    //   300: ldc2_w 977
    //   303: lload 16
    //   305: ladd
    //   306: ladd
    //   307: ladd
    //   308: lstore 12
    //   310: aload_0
    //   311: aload_2
    //   312: aload_1
    //   313: invokevirtual 923	com/tencent/mobileqq/utils/httputils/HttpCommunicator:checkInterruptedBeforeBlock	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   316: aload 23
    //   318: invokevirtual 981	java/net/HttpURLConnection:getResponseCode	()I
    //   321: istore 4
    //   323: aload_0
    //   324: iload 4
    //   326: aload 23
    //   328: aload_1
    //   329: invokevirtual 983	com/tencent/mobileqq/utils/httputils/HttpCommunicator:copyRespHeader	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   332: aload_2
    //   333: ifnull +235 -> 568
    //   336: aload_2
    //   337: getfield 551	com/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   340: invokevirtual 182	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   343: istore 11
    //   345: iload 11
    //   347: ifeq +221 -> 568
    //   350: iload 4
    //   352: sipush 200
    //   355: if_icmpeq +11 -> 366
    //   358: iload 4
    //   360: sipush 206
    //   363: if_icmpne +31 -> 394
    //   366: aload_0
    //   367: aload_1
    //   368: ldc_w 985
    //   371: new 339	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   378: ldc_w 987
    //   381: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: iconst_0
    //   385: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   394: aload_2
    //   395: ifnull +13 -> 408
    //   398: aload_2
    //   399: getfield 551	com/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   402: invokevirtual 182	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   405: ifne +47 -> 452
    //   408: aload_0
    //   409: aload_1
    //   410: ldc_w 989
    //   413: new 339	java/lang/StringBuilder
    //   416: dup
    //   417: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   420: ldc_w 991
    //   423: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: aload_1
    //   427: invokevirtual 994	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   430: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: ldc_w 996
    //   436: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload_1
    //   440: invokevirtual 999	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   443: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   449: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   452: aload_0
    //   453: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   456: ifnull +17 -> 473
    //   459: aload 25
    //   461: ifnull +12 -> 473
    //   464: aload_0
    //   465: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   468: aload 25
    //   470: invokevirtual 1003	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   473: lload 12
    //   475: lconst_0
    //   476: ladd
    //   477: lstore 12
    //   479: lload 12
    //   481: lconst_0
    //   482: lcmp
    //   483: ifeq +28 -> 511
    //   486: aload_1
    //   487: invokevirtual 325	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   490: ldc_w 322
    //   493: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   496: ifeq +60 -> 556
    //   499: iconst_1
    //   500: istore 10
    //   502: aload_0
    //   503: aload_1
    //   504: iload 10
    //   506: lload 12
    //   508: invokevirtual 1005	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logFlow	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   511: iconst_0
    //   512: ifeq +11 -> 523
    //   515: new 1007	java/lang/NullPointerException
    //   518: dup
    //   519: invokespecial 1008	java/lang/NullPointerException:<init>	()V
    //   522: athrow
    //   523: iconst_0
    //   524: ifeq +11 -> 535
    //   527: new 1007	java/lang/NullPointerException
    //   530: dup
    //   531: invokespecial 1008	java/lang/NullPointerException:<init>	()V
    //   534: athrow
    //   535: aload 24
    //   537: ifnull +8 -> 545
    //   540: aload 24
    //   542: invokevirtual 1010	java/io/OutputStream:close	()V
    //   545: aload 23
    //   547: ifnull +8 -> 555
    //   550: aload 23
    //   552: invokevirtual 1013	java/net/HttpURLConnection:disconnect	()V
    //   555: return
    //   556: iconst_0
    //   557: istore 10
    //   559: goto -57 -> 502
    //   562: astore_1
    //   563: aload_1
    //   564: invokevirtual 715	java/lang/Exception:printStackTrace	()V
    //   567: return
    //   568: aload_0
    //   569: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   572: ifnull +17 -> 589
    //   575: aload 25
    //   577: ifnull +12 -> 589
    //   580: aload_0
    //   581: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   584: aload 25
    //   586: invokevirtual 1003	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   589: aload_0
    //   590: aload_1
    //   591: ldc_w 1015
    //   594: new 339	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   601: ldc_w 1017
    //   604: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: iload 4
    //   609: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   612: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   618: iload 4
    //   620: sipush 302
    //   623: if_icmpeq +11 -> 634
    //   626: iload 4
    //   628: sipush 301
    //   631: if_icmpne +1592 -> 2223
    //   634: iload 5
    //   636: iconst_5
    //   637: if_icmpge +1298 -> 1935
    //   640: aload_0
    //   641: aload_1
    //   642: ldc_w 1019
    //   645: new 339	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   652: ldc_w 1021
    //   655: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload_1
    //   659: getfield 464	com/tencent/mobileqq/utils/httputils/HttpMsg:rawReqHeader	Ljava/lang/String;
    //   662: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: ldc_w 1023
    //   668: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: aload_1
    //   672: getfield 655	com/tencent/mobileqq/utils/httputils/HttpMsg:rawRespHeader	Ljava/lang/String;
    //   675: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   684: aload 23
    //   686: ldc_w 1025
    //   689: invokevirtual 660	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   692: astore 31
    //   694: aload 31
    //   696: ifnull +765 -> 1461
    //   699: aload 24
    //   701: ifnull +8 -> 709
    //   704: aload 24
    //   706: invokevirtual 1010	java/io/OutputStream:close	()V
    //   709: aload 23
    //   711: invokevirtual 1013	java/net/HttpURLConnection:disconnect	()V
    //   714: iload 5
    //   716: ifne +381 -> 1097
    //   719: aload_1
    //   720: getfield 1028	com/tencent/mobileqq/utils/httputils/HttpMsg:mIsPreStructPic	Z
    //   723: istore 11
    //   725: iload 11
    //   727: ifeq +370 -> 1097
    //   730: aload_1
    //   731: getfield 1031	com/tencent/mobileqq/utils/httputils/HttpMsg:mHaveIpConnect	Z
    //   734: ifeq +325 -> 1059
    //   737: aload_1
    //   738: invokevirtual 1035	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestPropertys	()Ljava/util/HashMap;
    //   741: ldc_w 495
    //   744: invokevirtual 1037	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   747: checkcast 214	java/lang/String
    //   750: astore 22
    //   752: aload 22
    //   754: invokestatic 1043	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   757: ifne +340 -> 1097
    //   760: aload 22
    //   762: ldc_w 1045
    //   765: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   768: ifeq +329 -> 1097
    //   771: new 414	java/net/URL
    //   774: dup
    //   775: aload 31
    //   777: invokespecial 417	java/net/URL:<init>	(Ljava/lang/String;)V
    //   780: invokevirtual 1048	java/net/URL:getHost	()Ljava/lang/String;
    //   783: invokestatic 1054	ayek:a	(Ljava/lang/String;)Z
    //   786: istore 11
    //   788: iload 11
    //   790: ifne +307 -> 1097
    //   793: iload 4
    //   795: sipush 200
    //   798: if_icmpeq +11 -> 809
    //   801: iload 4
    //   803: sipush 206
    //   806: if_icmpne +31 -> 837
    //   809: aload_0
    //   810: aload_1
    //   811: ldc_w 985
    //   814: new 339	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   821: ldc_w 987
    //   824: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: iconst_0
    //   828: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   831: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   837: aload_2
    //   838: ifnull +13 -> 851
    //   841: aload_2
    //   842: getfield 551	com/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   845: invokevirtual 182	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   848: ifne +101 -> 949
    //   851: aload_0
    //   852: aload_1
    //   853: ldc_w 989
    //   856: new 339	java/lang/StringBuilder
    //   859: dup
    //   860: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   863: ldc_w 991
    //   866: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   869: aload_1
    //   870: invokevirtual 994	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   873: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   876: ldc_w 996
    //   879: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   882: aload_1
    //   883: invokevirtual 999	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   886: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   889: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   892: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   895: aload_1
    //   896: getfield 1057	com/tencent/mobileqq/utils/httputils/HttpMsg:errCode	I
    //   899: sipush -9527
    //   902: if_icmpne +47 -> 949
    //   905: aload_0
    //   906: aload_1
    //   907: ldc_w 1059
    //   910: new 339	java/lang/StringBuilder
    //   913: dup
    //   914: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   917: ldc_w 1021
    //   920: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: aload_1
    //   924: getfield 464	com/tencent/mobileqq/utils/httputils/HttpMsg:rawReqHeader	Ljava/lang/String;
    //   927: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   930: ldc_w 1023
    //   933: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   936: aload_1
    //   937: getfield 655	com/tencent/mobileqq/utils/httputils/HttpMsg:rawRespHeader	Ljava/lang/String;
    //   940: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   943: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   946: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   949: aload_0
    //   950: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   953: ifnull +17 -> 970
    //   956: aload 25
    //   958: ifnull +12 -> 970
    //   961: aload_0
    //   962: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   965: aload 25
    //   967: invokevirtual 1003	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   970: lload 12
    //   972: lconst_0
    //   973: ladd
    //   974: lstore 12
    //   976: lload 12
    //   978: lconst_0
    //   979: lcmp
    //   980: ifeq +28 -> 1008
    //   983: aload_1
    //   984: invokevirtual 325	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   987: ldc_w 322
    //   990: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   993: ifeq +85 -> 1078
    //   996: iconst_1
    //   997: istore 10
    //   999: aload_0
    //   1000: aload_1
    //   1001: iload 10
    //   1003: lload 12
    //   1005: invokevirtual 1005	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logFlow	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1008: iconst_0
    //   1009: ifeq +11 -> 1020
    //   1012: new 1007	java/lang/NullPointerException
    //   1015: dup
    //   1016: invokespecial 1008	java/lang/NullPointerException:<init>	()V
    //   1019: athrow
    //   1020: iconst_0
    //   1021: ifeq +11 -> 1032
    //   1024: new 1007	java/lang/NullPointerException
    //   1027: dup
    //   1028: invokespecial 1008	java/lang/NullPointerException:<init>	()V
    //   1031: athrow
    //   1032: aload 24
    //   1034: ifnull +8 -> 1042
    //   1037: aload 24
    //   1039: invokevirtual 1010	java/io/OutputStream:close	()V
    //   1042: aload 23
    //   1044: ifnull -489 -> 555
    //   1047: aload 23
    //   1049: invokevirtual 1013	java/net/HttpURLConnection:disconnect	()V
    //   1052: return
    //   1053: astore_1
    //   1054: aload_1
    //   1055: invokevirtual 715	java/lang/Exception:printStackTrace	()V
    //   1058: return
    //   1059: new 414	java/net/URL
    //   1062: dup
    //   1063: aload_1
    //   1064: invokevirtual 200	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrl	()Ljava/lang/String;
    //   1067: invokespecial 417	java/net/URL:<init>	(Ljava/lang/String;)V
    //   1070: invokevirtual 1048	java/net/URL:getHost	()Ljava/lang/String;
    //   1073: astore 22
    //   1075: goto -323 -> 752
    //   1078: iconst_0
    //   1079: istore 10
    //   1081: goto -82 -> 999
    //   1084: astore 22
    //   1086: aload_0
    //   1087: aload_1
    //   1088: ldc_w 1061
    //   1091: ldc_w 1063
    //   1094: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1097: aload_1
    //   1098: invokevirtual 1066	com/tencent/mobileqq/utils/httputils/HttpMsg:isInstanceFollowRedirects	()Z
    //   1101: ifne +230 -> 1331
    //   1104: aload 30
    //   1106: aload 31
    //   1108: invokeinterface 1069 2 0
    //   1113: iload 4
    //   1115: sipush 200
    //   1118: if_icmpeq +11 -> 1129
    //   1121: iload 4
    //   1123: sipush 206
    //   1126: if_icmpne +31 -> 1157
    //   1129: aload_0
    //   1130: aload_1
    //   1131: ldc_w 985
    //   1134: new 339	java/lang/StringBuilder
    //   1137: dup
    //   1138: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   1141: ldc_w 987
    //   1144: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1147: iconst_0
    //   1148: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1151: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1154: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1157: aload_2
    //   1158: ifnull +13 -> 1171
    //   1161: aload_2
    //   1162: getfield 551	com/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1165: invokevirtual 182	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1168: ifne +47 -> 1215
    //   1171: aload_0
    //   1172: aload_1
    //   1173: ldc_w 989
    //   1176: new 339	java/lang/StringBuilder
    //   1179: dup
    //   1180: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   1183: ldc_w 991
    //   1186: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: aload_1
    //   1190: invokevirtual 994	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   1193: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: ldc_w 996
    //   1199: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1202: aload_1
    //   1203: invokevirtual 999	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   1206: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1212: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1215: aload_0
    //   1216: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   1219: ifnull +17 -> 1236
    //   1222: aload 25
    //   1224: ifnull +12 -> 1236
    //   1227: aload_0
    //   1228: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   1231: aload 25
    //   1233: invokevirtual 1003	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1236: lload 12
    //   1238: lconst_0
    //   1239: ladd
    //   1240: lstore 12
    //   1242: lload 12
    //   1244: lconst_0
    //   1245: lcmp
    //   1246: ifeq +28 -> 1274
    //   1249: aload_1
    //   1250: invokevirtual 325	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   1253: ldc_w 322
    //   1256: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1259: ifeq +66 -> 1325
    //   1262: iconst_1
    //   1263: istore 10
    //   1265: aload_0
    //   1266: aload_1
    //   1267: iload 10
    //   1269: lload 12
    //   1271: invokevirtual 1005	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logFlow	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1274: iconst_0
    //   1275: ifeq +11 -> 1286
    //   1278: new 1007	java/lang/NullPointerException
    //   1281: dup
    //   1282: invokespecial 1008	java/lang/NullPointerException:<init>	()V
    //   1285: athrow
    //   1286: iconst_0
    //   1287: ifeq +11 -> 1298
    //   1290: new 1007	java/lang/NullPointerException
    //   1293: dup
    //   1294: invokespecial 1008	java/lang/NullPointerException:<init>	()V
    //   1297: athrow
    //   1298: aload 24
    //   1300: ifnull +8 -> 1308
    //   1303: aload 24
    //   1305: invokevirtual 1010	java/io/OutputStream:close	()V
    //   1308: aload 23
    //   1310: ifnull -755 -> 555
    //   1313: aload 23
    //   1315: invokevirtual 1013	java/net/HttpURLConnection:disconnect	()V
    //   1318: return
    //   1319: astore_1
    //   1320: aload_1
    //   1321: invokevirtual 715	java/lang/Exception:printStackTrace	()V
    //   1324: return
    //   1325: iconst_0
    //   1326: istore 10
    //   1328: goto -63 -> 1265
    //   1331: aload_1
    //   1332: getfield 1072	com/tencent/mobileqq/utils/httputils/HttpMsg:bReportRedirects	Z
    //   1335: ifeq +12 -> 1347
    //   1338: aload 30
    //   1340: aload 31
    //   1342: invokeinterface 1069 2 0
    //   1347: aload_1
    //   1348: getfield 1075	com/tencent/mobileqq/utils/httputils/HttpMsg:mNeedNotReferer	Z
    //   1351: ifne +14 -> 1365
    //   1354: aload_1
    //   1355: ldc_w 1077
    //   1358: aload_1
    //   1359: invokevirtual 200	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrl	()Ljava/lang/String;
    //   1362: invokevirtual 1078	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1365: aload_1
    //   1366: aload 31
    //   1368: invokevirtual 1081	com/tencent/mobileqq/utils/httputils/HttpMsg:setUrl	(Ljava/lang/String;)V
    //   1371: aload_1
    //   1372: getfield 1031	com/tencent/mobileqq/utils/httputils/HttpMsg:mHaveIpConnect	Z
    //   1375: ifeq +56 -> 1431
    //   1378: aload 31
    //   1380: invokestatic 1086	com/tencent/mobileqq/transfile/dns/InnerDns:getHostFromUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   1383: astore 22
    //   1385: aload 22
    //   1387: invokestatic 1043	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1390: ifne +12 -> 1402
    //   1393: aload_1
    //   1394: ldc_w 495
    //   1397: aload 22
    //   1399: invokevirtual 1078	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1402: aload_0
    //   1403: aload_1
    //   1404: ldc_w 1019
    //   1407: new 339	java/lang/StringBuilder
    //   1410: dup
    //   1411: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   1414: ldc_w 1088
    //   1417: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1420: aload 22
    //   1422: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1425: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1428: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1431: aload_1
    //   1432: ldc_w 1090
    //   1435: invokevirtual 1093	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestMethod	(Ljava/lang/String;)V
    //   1438: iload 5
    //   1440: iconst_1
    //   1441: iadd
    //   1442: istore 5
    //   1444: iload 4
    //   1446: istore_3
    //   1447: aload 24
    //   1449: astore 22
    //   1451: iconst_1
    //   1452: istore 10
    //   1454: aload 25
    //   1456: astore 24
    //   1458: goto -1401 -> 57
    //   1461: new 543	java/io/IOException
    //   1464: dup
    //   1465: ldc_w 1095
    //   1468: invokespecial 546	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1471: athrow
    //   1472: astore 28
    //   1474: aload 25
    //   1476: astore 27
    //   1478: iconst_0
    //   1479: istore 5
    //   1481: iconst_1
    //   1482: istore 10
    //   1484: lconst_0
    //   1485: lstore 16
    //   1487: iload 4
    //   1489: istore_3
    //   1490: aload 23
    //   1492: astore 22
    //   1494: aconst_null
    //   1495: astore 23
    //   1497: aconst_null
    //   1498: astore 26
    //   1500: aload 24
    //   1502: astore 25
    //   1504: aload 23
    //   1506: astore 24
    //   1508: lload 12
    //   1510: lstore 14
    //   1512: lload 16
    //   1514: lstore 12
    //   1516: iload 5
    //   1518: istore 4
    //   1520: aload 27
    //   1522: astore 23
    //   1524: aload 28
    //   1526: astore 27
    //   1528: iconst_1
    //   1529: istore 5
    //   1531: aload 27
    //   1533: instanceof 543
    //   1536: istore 11
    //   1538: iload 11
    //   1540: ifeq +62 -> 1602
    //   1543: aload 22
    //   1545: ifnull +57 -> 1602
    //   1548: aconst_null
    //   1549: astore 29
    //   1551: aload 22
    //   1553: invokevirtual 1099	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   1556: astore 28
    //   1558: aload 28
    //   1560: astore 29
    //   1562: sipush 10240
    //   1565: newarray byte
    //   1567: astore 31
    //   1569: aload 28
    //   1571: ifnull +21 -> 1592
    //   1574: aload 28
    //   1576: astore 29
    //   1578: aload 28
    //   1580: aload 31
    //   1582: invokevirtual 1105	java/io/InputStream:read	([B)I
    //   1585: istore 6
    //   1587: iload 6
    //   1589: ifgt -15 -> 1574
    //   1592: aload 28
    //   1594: ifnull +8 -> 1602
    //   1597: aload 28
    //   1599: invokevirtual 1106	java/io/InputStream:close	()V
    //   1602: aload_0
    //   1603: iload 10
    //   1605: iload_3
    //   1606: aload 22
    //   1608: aload_1
    //   1609: aload 27
    //   1611: invokevirtual 1110	com/tencent/mobileqq/utils/httputils/HttpCommunicator:setExceptionInfo	(ZILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/Throwable;)V
    //   1614: iload 10
    //   1616: ifeq +46 -> 1662
    //   1619: iload_3
    //   1620: sipush 200
    //   1623: if_icmpeq +10 -> 1633
    //   1626: iload_3
    //   1627: sipush 206
    //   1630: if_icmpne +32 -> 1662
    //   1633: aload_0
    //   1634: aload_1
    //   1635: ldc_w 985
    //   1638: new 339	java/lang/StringBuilder
    //   1641: dup
    //   1642: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   1645: ldc_w 987
    //   1648: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1651: iload 4
    //   1653: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1656: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1659: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1662: aload_2
    //   1663: ifnull +13 -> 1676
    //   1666: aload_2
    //   1667: getfield 551	com/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1670: invokevirtual 182	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1673: ifne +101 -> 1774
    //   1676: aload_0
    //   1677: aload_1
    //   1678: ldc_w 989
    //   1681: new 339	java/lang/StringBuilder
    //   1684: dup
    //   1685: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   1688: ldc_w 991
    //   1691: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1694: aload_1
    //   1695: invokevirtual 994	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   1698: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1701: ldc_w 996
    //   1704: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1707: aload_1
    //   1708: invokevirtual 999	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   1711: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1714: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1717: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1720: aload_1
    //   1721: getfield 1057	com/tencent/mobileqq/utils/httputils/HttpMsg:errCode	I
    //   1724: sipush -9527
    //   1727: if_icmpne +47 -> 1774
    //   1730: aload_0
    //   1731: aload_1
    //   1732: ldc_w 1059
    //   1735: new 339	java/lang/StringBuilder
    //   1738: dup
    //   1739: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   1742: ldc_w 1021
    //   1745: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1748: aload_1
    //   1749: getfield 464	com/tencent/mobileqq/utils/httputils/HttpMsg:rawReqHeader	Ljava/lang/String;
    //   1752: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1755: ldc_w 1023
    //   1758: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1761: aload_1
    //   1762: getfield 655	com/tencent/mobileqq/utils/httputils/HttpMsg:rawRespHeader	Ljava/lang/String;
    //   1765: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1768: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1771: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1774: aload_0
    //   1775: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   1778: ifnull +17 -> 1795
    //   1781: aload 23
    //   1783: ifnull +12 -> 1795
    //   1786: aload_0
    //   1787: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   1790: aload 23
    //   1792: invokevirtual 1003	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1795: lload 14
    //   1797: lload 12
    //   1799: ladd
    //   1800: lstore 12
    //   1802: lload 12
    //   1804: lconst_0
    //   1805: lcmp
    //   1806: ifeq +28 -> 1834
    //   1809: aload_1
    //   1810: invokevirtual 325	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   1813: ldc_w 322
    //   1816: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1819: ifeq +2236 -> 4055
    //   1822: iconst_1
    //   1823: istore 10
    //   1825: aload_0
    //   1826: aload_1
    //   1827: iload 10
    //   1829: lload 12
    //   1831: invokevirtual 1005	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logFlow	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   1834: aload 24
    //   1836: ifnull +8 -> 1844
    //   1839: aload 24
    //   1841: invokevirtual 1113	java/io/ByteArrayOutputStream:close	()V
    //   1844: aload 26
    //   1846: ifnull +8 -> 1854
    //   1849: aload 26
    //   1851: invokevirtual 1106	java/io/InputStream:close	()V
    //   1854: aload 25
    //   1856: ifnull +8 -> 1864
    //   1859: aload 25
    //   1861: invokevirtual 1010	java/io/OutputStream:close	()V
    //   1864: iload 5
    //   1866: istore 4
    //   1868: aload 22
    //   1870: ifnull +12 -> 1882
    //   1873: aload 22
    //   1875: invokevirtual 1013	java/net/HttpURLConnection:disconnect	()V
    //   1878: iload 5
    //   1880: istore 4
    //   1882: aload_2
    //   1883: ifnull +13 -> 1896
    //   1886: aload_2
    //   1887: getfield 551	com/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1890: invokevirtual 182	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1893: ifne -1338 -> 555
    //   1896: aload_1
    //   1897: getfield 533	com/tencent/mobileqq/utils/httputils/HttpMsg:mIsCancel	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1900: invokevirtual 182	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1903: ifne -1348 -> 555
    //   1906: iload 4
    //   1908: ifeq +2181 -> 4089
    //   1911: aload 30
    //   1913: aload_1
    //   1914: aload_1
    //   1915: invokeinterface 628 3 0
    //   1920: return
    //   1921: astore_2
    //   1922: aload_0
    //   1923: aload_1
    //   1924: ldc_w 1115
    //   1927: aload_2
    //   1928: invokestatic 1121	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1931: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1934: return
    //   1935: new 192	java/lang/Exception
    //   1938: dup
    //   1939: ldc_w 1123
    //   1942: invokespecial 773	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1945: athrow
    //   1946: astore 22
    //   1948: iconst_0
    //   1949: istore_3
    //   1950: iload 6
    //   1952: istore 5
    //   1954: iload 10
    //   1956: ifeq +48 -> 2004
    //   1959: iload 4
    //   1961: sipush 200
    //   1964: if_icmpeq +11 -> 1975
    //   1967: iload 4
    //   1969: sipush 206
    //   1972: if_icmpne +32 -> 2004
    //   1975: aload_0
    //   1976: aload_1
    //   1977: ldc_w 985
    //   1980: new 339	java/lang/StringBuilder
    //   1983: dup
    //   1984: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   1987: ldc_w 987
    //   1990: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1993: iload 5
    //   1995: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1998: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2001: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2004: aload_2
    //   2005: ifnull +13 -> 2018
    //   2008: aload_2
    //   2009: getfield 551	com/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2012: invokevirtual 182	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2015: ifne +105 -> 2120
    //   2018: aload_0
    //   2019: aload_1
    //   2020: ldc_w 989
    //   2023: new 339	java/lang/StringBuilder
    //   2026: dup
    //   2027: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   2030: ldc_w 991
    //   2033: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2036: aload_1
    //   2037: invokevirtual 994	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   2040: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2043: ldc_w 996
    //   2046: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2049: aload_1
    //   2050: invokevirtual 999	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   2053: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2056: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2059: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2062: iload_3
    //   2063: ifeq +57 -> 2120
    //   2066: aload_1
    //   2067: getfield 1057	com/tencent/mobileqq/utils/httputils/HttpMsg:errCode	I
    //   2070: sipush -9527
    //   2073: if_icmpne +47 -> 2120
    //   2076: aload_0
    //   2077: aload_1
    //   2078: ldc_w 1059
    //   2081: new 339	java/lang/StringBuilder
    //   2084: dup
    //   2085: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   2088: ldc_w 1021
    //   2091: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2094: aload_1
    //   2095: getfield 464	com/tencent/mobileqq/utils/httputils/HttpMsg:rawReqHeader	Ljava/lang/String;
    //   2098: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2101: ldc_w 1023
    //   2104: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2107: aload_1
    //   2108: getfield 655	com/tencent/mobileqq/utils/httputils/HttpMsg:rawRespHeader	Ljava/lang/String;
    //   2111: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2114: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2117: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2120: aload_0
    //   2121: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   2124: ifnull +17 -> 2141
    //   2127: aload 25
    //   2129: ifnull +12 -> 2141
    //   2132: aload_0
    //   2133: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   2136: aload 25
    //   2138: invokevirtual 1003	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   2141: lload 12
    //   2143: lload 14
    //   2145: ladd
    //   2146: lstore 12
    //   2148: lload 12
    //   2150: lconst_0
    //   2151: lcmp
    //   2152: ifeq +28 -> 2180
    //   2155: aload_1
    //   2156: invokevirtual 325	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   2159: ldc_w 322
    //   2162: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2165: ifeq +1910 -> 4075
    //   2168: iconst_1
    //   2169: istore 10
    //   2171: aload_0
    //   2172: aload_1
    //   2173: iload 10
    //   2175: lload 12
    //   2177: invokevirtual 1005	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logFlow	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   2180: aload 27
    //   2182: ifnull +8 -> 2190
    //   2185: aload 27
    //   2187: invokevirtual 1113	java/io/ByteArrayOutputStream:close	()V
    //   2190: aload 26
    //   2192: ifnull +8 -> 2200
    //   2195: aload 26
    //   2197: invokevirtual 1106	java/io/InputStream:close	()V
    //   2200: aload 24
    //   2202: ifnull +8 -> 2210
    //   2205: aload 24
    //   2207: invokevirtual 1010	java/io/OutputStream:close	()V
    //   2210: aload 23
    //   2212: ifnull +8 -> 2220
    //   2215: aload 23
    //   2217: invokevirtual 1013	java/net/HttpURLConnection:disconnect	()V
    //   2220: aload 22
    //   2222: athrow
    //   2223: aload_0
    //   2224: aload_1
    //   2225: aconst_null
    //   2226: iconst_2
    //   2227: invokespecial 919	com/tencent/mobileqq/utils/httputils/HttpCommunicator:statusChanged	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;I)V
    //   2230: iload 4
    //   2232: sipush 200
    //   2235: if_icmpeq +11 -> 2246
    //   2238: iload 4
    //   2240: sipush 206
    //   2243: if_icmpne +1372 -> 3615
    //   2246: aload 23
    //   2248: invokevirtual 646	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2251: astore 22
    //   2253: aload 22
    //   2255: ifnonnull +135 -> 2390
    //   2258: ldc_w 593
    //   2261: astore 22
    //   2263: aload_1
    //   2264: getfield 1127	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2267: ifnull +227 -> 2494
    //   2270: aload_1
    //   2271: getfield 1127	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2274: arraylength
    //   2275: ifle +219 -> 2494
    //   2278: aload 22
    //   2280: invokevirtual 976	java/lang/String:length	()I
    //   2283: ifle +211 -> 2494
    //   2286: iconst_0
    //   2287: istore 7
    //   2289: aload_1
    //   2290: getfield 1127	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2293: arraylength
    //   2294: iconst_1
    //   2295: if_icmpne +105 -> 2400
    //   2298: aload_1
    //   2299: getfield 1127	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2302: iconst_0
    //   2303: aaload
    //   2304: ifnull +96 -> 2400
    //   2307: aload_1
    //   2308: getfield 1127	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2311: iconst_0
    //   2312: aaload
    //   2313: invokevirtual 1130	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2316: ldc_w 1132
    //   2319: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2322: ifeq +78 -> 2400
    //   2325: iconst_1
    //   2326: istore_3
    //   2327: iload_3
    //   2328: ifne +166 -> 2494
    //   2331: new 339	java/lang/StringBuilder
    //   2334: dup
    //   2335: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   2338: astore 29
    //   2340: aload_1
    //   2341: getfield 1127	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2344: astore 28
    //   2346: aload 28
    //   2348: arraylength
    //   2349: istore 5
    //   2351: iconst_0
    //   2352: istore_3
    //   2353: iload_3
    //   2354: iload 5
    //   2356: if_icmpge +95 -> 2451
    //   2359: aload 28
    //   2361: iload_3
    //   2362: aaload
    //   2363: astore 31
    //   2365: aload 31
    //   2367: ifnull +2610 -> 4977
    //   2370: aload 29
    //   2372: aload 31
    //   2374: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2377: pop
    //   2378: aload 29
    //   2380: ldc_w 1134
    //   2383: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2386: pop
    //   2387: goto +2590 -> 4977
    //   2390: aload 22
    //   2392: invokevirtual 1130	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2395: astore 22
    //   2397: goto -134 -> 2263
    //   2400: aload_1
    //   2401: getfield 1127	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2404: astore 29
    //   2406: aload 29
    //   2408: arraylength
    //   2409: istore 8
    //   2411: iconst_0
    //   2412: istore 5
    //   2414: iload 7
    //   2416: istore_3
    //   2417: iload 5
    //   2419: iload 8
    //   2421: if_icmpge -94 -> 2327
    //   2424: aload 29
    //   2426: iload 5
    //   2428: aaload
    //   2429: astore 28
    //   2431: aload 28
    //   2433: ifnull +2551 -> 4984
    //   2436: aload 22
    //   2438: aload 28
    //   2440: invokevirtual 1137	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2443: ifeq +2541 -> 4984
    //   2446: iconst_1
    //   2447: istore_3
    //   2448: goto -121 -> 2327
    //   2451: new 543	java/io/IOException
    //   2454: dup
    //   2455: new 339	java/lang/StringBuilder
    //   2458: dup
    //   2459: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   2462: ldc_w 1139
    //   2465: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2468: aload 22
    //   2470: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2473: ldc_w 1141
    //   2476: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2479: aload 29
    //   2481: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2484: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2487: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2490: invokespecial 546	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2493: athrow
    //   2494: aload_1
    //   2495: getfield 683	com/tencent/mobileqq/utils/httputils/HttpMsg:totalLen	J
    //   2498: lconst_0
    //   2499: lcmp
    //   2500: ifne +26 -> 2526
    //   2503: aload_1
    //   2504: invokevirtual 325	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   2507: ldc_w 322
    //   2510: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2513: ifne +13 -> 2526
    //   2516: new 543	java/io/IOException
    //   2519: dup
    //   2520: ldc 26
    //   2522: invokespecial 546	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2525: athrow
    //   2526: aload_0
    //   2527: aload_1
    //   2528: ldc_w 1143
    //   2531: new 339	java/lang/StringBuilder
    //   2534: dup
    //   2535: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   2538: ldc_w 1145
    //   2541: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2544: aload_1
    //   2545: getfield 683	com/tencent/mobileqq/utils/httputils/HttpMsg:totalLen	J
    //   2548: invokevirtual 636	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2551: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2554: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2557: aload_1
    //   2558: getfield 932	com/tencent/mobileqq/utils/httputils/HttpMsg:startTime	J
    //   2561: lconst_0
    //   2562: lcmp
    //   2563: ifeq +15 -> 2578
    //   2566: aload_1
    //   2567: invokestatic 750	android/os/SystemClock:uptimeMillis	()J
    //   2570: aload_1
    //   2571: getfield 932	com/tencent/mobileqq/utils/httputils/HttpMsg:startTime	J
    //   2574: lsub
    //   2575: putfield 1148	com/tencent/mobileqq/utils/httputils/HttpMsg:cost	J
    //   2578: aload 30
    //   2580: aload_1
    //   2581: aload_1
    //   2582: iconst_3
    //   2583: invokeinterface 524 4 0
    //   2588: istore 11
    //   2590: iload 11
    //   2592: ifeq +2360 -> 4952
    //   2595: lconst_0
    //   2596: ldc2_w 977
    //   2599: ladd
    //   2600: lstore 14
    //   2602: aload 23
    //   2604: invokevirtual 1151	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   2607: astore 22
    //   2609: invokestatic 1157	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   2612: astore 28
    //   2614: invokestatic 1160	com/tencent/commonsdk/pool/ByteArrayPool:getMaxBufInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   2617: astore 26
    //   2619: aload_1
    //   2620: getfield 1163	com/tencent/mobileqq/utils/httputils/HttpMsg:mUseByteArrayPool	Z
    //   2623: ifeq +243 -> 2866
    //   2626: aload_1
    //   2627: invokevirtual 1166	com/tencent/mobileqq/utils/httputils/HttpMsg:isDataSlice	()Z
    //   2630: ifne +236 -> 2866
    //   2633: new 1168	bfxe
    //   2636: dup
    //   2637: aload 26
    //   2639: aload_1
    //   2640: getfield 683	com/tencent/mobileqq/utils/httputils/HttpMsg:totalLen	J
    //   2643: l2i
    //   2644: invokespecial 1171	bfxe:<init>	(Lcom/tencent/commonsdk/pool/ByteArrayPool;I)V
    //   2647: astore 26
    //   2649: aload_1
    //   2650: getfield 1163	com/tencent/mobileqq/utils/httputils/HttpMsg:mUseByteArrayPool	Z
    //   2653: ifeq +282 -> 2935
    //   2656: aload 28
    //   2658: sipush 10240
    //   2661: invokevirtual 1175	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   2664: astore 27
    //   2666: iconst_0
    //   2667: istore 5
    //   2669: iconst_0
    //   2670: istore_3
    //   2671: iload_3
    //   2672: istore 8
    //   2674: lload 14
    //   2676: lstore 16
    //   2678: iload_3
    //   2679: istore 7
    //   2681: lload 14
    //   2683: lstore 18
    //   2685: aload 22
    //   2687: aload 27
    //   2689: iload 5
    //   2691: aload 27
    //   2693: arraylength
    //   2694: iload 5
    //   2696: isub
    //   2697: invokevirtual 1178	java/io/InputStream:read	([BII)I
    //   2700: istore 6
    //   2702: iload 6
    //   2704: ifle +277 -> 2981
    //   2707: iload_3
    //   2708: istore 8
    //   2710: lload 14
    //   2712: lstore 16
    //   2714: iload_3
    //   2715: istore 7
    //   2717: lload 14
    //   2719: lstore 18
    //   2721: aload_0
    //   2722: aload_2
    //   2723: aload_1
    //   2724: invokevirtual 923	com/tencent/mobileqq/utils/httputils/HttpCommunicator:checkInterruptedBeforeBlock	(Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   2727: lload 14
    //   2729: iload 6
    //   2731: i2l
    //   2732: ladd
    //   2733: lstore 20
    //   2735: iload 5
    //   2737: iload 6
    //   2739: iadd
    //   2740: istore 9
    //   2742: iload_3
    //   2743: iload 6
    //   2745: iadd
    //   2746: istore 6
    //   2748: iload 6
    //   2750: istore_3
    //   2751: lload 20
    //   2753: lstore 14
    //   2755: iload 9
    //   2757: istore 5
    //   2759: iload 6
    //   2761: istore 8
    //   2763: lload 20
    //   2765: lstore 16
    //   2767: iload 6
    //   2769: istore 7
    //   2771: lload 20
    //   2773: lstore 18
    //   2775: iload 9
    //   2777: aload 27
    //   2779: arraylength
    //   2780: if_icmplt -109 -> 2671
    //   2783: iload 6
    //   2785: istore 8
    //   2787: lload 20
    //   2789: lstore 16
    //   2791: iload 6
    //   2793: istore 7
    //   2795: lload 20
    //   2797: lstore 18
    //   2799: aload_1
    //   2800: invokevirtual 1166	com/tencent/mobileqq/utils/httputils/HttpMsg:isDataSlice	()Z
    //   2803: ifeq +142 -> 2945
    //   2806: iload 6
    //   2808: istore 8
    //   2810: lload 20
    //   2812: lstore 16
    //   2814: iload 6
    //   2816: istore 7
    //   2818: lload 20
    //   2820: lstore 18
    //   2822: aload_1
    //   2823: aload 27
    //   2825: invokevirtual 1182	com/tencent/mobileqq/utils/httputils/HttpMsg:setRecvData	([B)V
    //   2828: iload 6
    //   2830: istore 8
    //   2832: lload 20
    //   2834: lstore 16
    //   2836: iload 6
    //   2838: istore 7
    //   2840: lload 20
    //   2842: lstore 18
    //   2844: aload 30
    //   2846: aload_1
    //   2847: aload_1
    //   2848: invokeinterface 1185 3 0
    //   2853: iconst_0
    //   2854: istore 5
    //   2856: iload 6
    //   2858: istore_3
    //   2859: lload 20
    //   2861: lstore 14
    //   2863: goto -192 -> 2671
    //   2866: new 1112	java/io/ByteArrayOutputStream
    //   2869: dup
    //   2870: invokespecial 1186	java/io/ByteArrayOutputStream:<init>	()V
    //   2873: astore 26
    //   2875: goto -226 -> 2649
    //   2878: astore 27
    //   2880: iconst_0
    //   2881: istore 5
    //   2883: iconst_1
    //   2884: istore 10
    //   2886: lload 14
    //   2888: lstore 16
    //   2890: aload 22
    //   2892: astore 26
    //   2894: iload 4
    //   2896: istore_3
    //   2897: aconst_null
    //   2898: astore 29
    //   2900: aload 23
    //   2902: astore 22
    //   2904: lload 12
    //   2906: lstore 14
    //   2908: aload 24
    //   2910: astore 28
    //   2912: aload 25
    //   2914: astore 23
    //   2916: iload 5
    //   2918: istore 4
    //   2920: lload 16
    //   2922: lstore 12
    //   2924: aload 29
    //   2926: astore 24
    //   2928: aload 28
    //   2930: astore 25
    //   2932: goto -1404 -> 1528
    //   2935: sipush 10240
    //   2938: newarray byte
    //   2940: astore 27
    //   2942: goto -276 -> 2666
    //   2945: iload 6
    //   2947: istore 8
    //   2949: lload 20
    //   2951: lstore 16
    //   2953: iload 6
    //   2955: istore 7
    //   2957: lload 20
    //   2959: lstore 18
    //   2961: aload 26
    //   2963: aload 27
    //   2965: invokevirtual 1188	java/io/ByteArrayOutputStream:write	([B)V
    //   2968: iconst_0
    //   2969: istore 5
    //   2971: iload 6
    //   2973: istore_3
    //   2974: lload 20
    //   2976: lstore 14
    //   2978: goto -307 -> 2671
    //   2981: iload_3
    //   2982: istore 8
    //   2984: lload 14
    //   2986: lstore 16
    //   2988: iload_3
    //   2989: istore 7
    //   2991: lload 14
    //   2993: lstore 18
    //   2995: aload_1
    //   2996: invokevirtual 1166	com/tencent/mobileqq/utils/httputils/HttpMsg:isDataSlice	()Z
    //   2999: ifeq +468 -> 3467
    //   3002: iload 5
    //   3004: ifle +91 -> 3095
    //   3007: iload_3
    //   3008: istore 8
    //   3010: lload 14
    //   3012: lstore 16
    //   3014: iload_3
    //   3015: istore 7
    //   3017: lload 14
    //   3019: lstore 18
    //   3021: iload 5
    //   3023: newarray byte
    //   3025: astore 29
    //   3027: iload_3
    //   3028: istore 8
    //   3030: lload 14
    //   3032: lstore 16
    //   3034: iload_3
    //   3035: istore 7
    //   3037: lload 14
    //   3039: lstore 18
    //   3041: aload 27
    //   3043: iconst_0
    //   3044: aload 29
    //   3046: iconst_0
    //   3047: iload 5
    //   3049: invokestatic 1192	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3052: iload_3
    //   3053: istore 8
    //   3055: lload 14
    //   3057: lstore 16
    //   3059: iload_3
    //   3060: istore 7
    //   3062: lload 14
    //   3064: lstore 18
    //   3066: aload_1
    //   3067: aload 29
    //   3069: invokevirtual 1182	com/tencent/mobileqq/utils/httputils/HttpMsg:setRecvData	([B)V
    //   3072: iload_3
    //   3073: istore 8
    //   3075: lload 14
    //   3077: lstore 16
    //   3079: iload_3
    //   3080: istore 7
    //   3082: lload 14
    //   3084: lstore 18
    //   3086: aload 30
    //   3088: aload_1
    //   3089: aload_1
    //   3090: invokeinterface 1185 3 0
    //   3095: iload_3
    //   3096: istore 8
    //   3098: lload 14
    //   3100: lstore 16
    //   3102: iload_3
    //   3103: istore 7
    //   3105: lload 14
    //   3107: lstore 18
    //   3109: aload_1
    //   3110: getfield 1163	com/tencent/mobileqq/utils/httputils/HttpMsg:mUseByteArrayPool	Z
    //   3113: ifeq +24 -> 3137
    //   3116: iload_3
    //   3117: istore 8
    //   3119: lload 14
    //   3121: lstore 16
    //   3123: iload_3
    //   3124: istore 7
    //   3126: lload 14
    //   3128: lstore 18
    //   3130: aload 28
    //   3132: aload 27
    //   3134: invokevirtual 1195	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   3137: iload_3
    //   3138: istore 8
    //   3140: lload 14
    //   3142: lstore 16
    //   3144: iload_3
    //   3145: istore 7
    //   3147: lload 14
    //   3149: lstore 18
    //   3151: aload 26
    //   3153: invokevirtual 1113	java/io/ByteArrayOutputStream:close	()V
    //   3156: aload 26
    //   3158: astore 27
    //   3160: aload 22
    //   3162: astore 26
    //   3164: aload 27
    //   3166: astore 22
    //   3168: aload 30
    //   3170: aload_1
    //   3171: aload_1
    //   3172: iconst_4
    //   3173: invokeinterface 524 4 0
    //   3178: pop
    //   3179: iload_3
    //   3180: istore 5
    //   3182: iconst_0
    //   3183: istore_3
    //   3184: iload 4
    //   3186: sipush 200
    //   3189: if_icmpeq +11 -> 3200
    //   3192: iload 4
    //   3194: sipush 206
    //   3197: if_icmpne +32 -> 3229
    //   3200: aload_0
    //   3201: aload_1
    //   3202: ldc_w 985
    //   3205: new 339	java/lang/StringBuilder
    //   3208: dup
    //   3209: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   3212: ldc_w 987
    //   3215: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3218: iload 5
    //   3220: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3223: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3226: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3229: aload_2
    //   3230: ifnull +13 -> 3243
    //   3233: aload_2
    //   3234: getfield 551	com/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3237: invokevirtual 182	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3240: ifne +105 -> 3345
    //   3243: aload_0
    //   3244: aload_1
    //   3245: ldc_w 989
    //   3248: new 339	java/lang/StringBuilder
    //   3251: dup
    //   3252: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   3255: ldc_w 991
    //   3258: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3261: aload_1
    //   3262: invokevirtual 994	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   3265: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3268: ldc_w 996
    //   3271: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3274: aload_1
    //   3275: invokevirtual 999	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   3278: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3281: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3284: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3287: iload_3
    //   3288: ifeq +57 -> 3345
    //   3291: aload_1
    //   3292: getfield 1057	com/tencent/mobileqq/utils/httputils/HttpMsg:errCode	I
    //   3295: sipush -9527
    //   3298: if_icmpne +47 -> 3345
    //   3301: aload_0
    //   3302: aload_1
    //   3303: ldc_w 1059
    //   3306: new 339	java/lang/StringBuilder
    //   3309: dup
    //   3310: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   3313: ldc_w 1021
    //   3316: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3319: aload_1
    //   3320: getfield 464	com/tencent/mobileqq/utils/httputils/HttpMsg:rawReqHeader	Ljava/lang/String;
    //   3323: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3326: ldc_w 1023
    //   3329: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3332: aload_1
    //   3333: getfield 655	com/tencent/mobileqq/utils/httputils/HttpMsg:rawRespHeader	Ljava/lang/String;
    //   3336: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3339: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3342: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3345: aload_0
    //   3346: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   3349: ifnull +17 -> 3366
    //   3352: aload 25
    //   3354: ifnull +12 -> 3366
    //   3357: aload_0
    //   3358: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   3361: aload 25
    //   3363: invokevirtual 1003	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3366: lload 14
    //   3368: lload 12
    //   3370: ladd
    //   3371: lstore 12
    //   3373: lload 12
    //   3375: lconst_0
    //   3376: lcmp
    //   3377: ifeq +28 -> 3405
    //   3380: aload_1
    //   3381: invokevirtual 325	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   3384: ldc_w 322
    //   3387: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3390: ifeq +563 -> 3953
    //   3393: iconst_1
    //   3394: istore 10
    //   3396: aload_0
    //   3397: aload_1
    //   3398: iload 10
    //   3400: lload 12
    //   3402: invokevirtual 1005	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logFlow	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   3405: aload 22
    //   3407: ifnull +8 -> 3415
    //   3410: aload 22
    //   3412: invokevirtual 1113	java/io/ByteArrayOutputStream:close	()V
    //   3415: aload 26
    //   3417: ifnull +8 -> 3425
    //   3420: aload 26
    //   3422: invokevirtual 1106	java/io/InputStream:close	()V
    //   3425: aload 24
    //   3427: ifnull +8 -> 3435
    //   3430: aload 24
    //   3432: invokevirtual 1010	java/io/OutputStream:close	()V
    //   3435: iload_3
    //   3436: istore 4
    //   3438: aload 23
    //   3440: ifnull -1558 -> 1882
    //   3443: aload 23
    //   3445: invokevirtual 1013	java/net/HttpURLConnection:disconnect	()V
    //   3448: iload_3
    //   3449: istore 4
    //   3451: goto -1569 -> 1882
    //   3454: astore 22
    //   3456: aload 22
    //   3458: invokevirtual 715	java/lang/Exception:printStackTrace	()V
    //   3461: iload_3
    //   3462: istore 4
    //   3464: goto -1582 -> 1882
    //   3467: iload 5
    //   3469: ifle +27 -> 3496
    //   3472: iload_3
    //   3473: istore 8
    //   3475: lload 14
    //   3477: lstore 16
    //   3479: iload_3
    //   3480: istore 7
    //   3482: lload 14
    //   3484: lstore 18
    //   3486: aload 26
    //   3488: aload 27
    //   3490: iconst_0
    //   3491: iload 5
    //   3493: invokevirtual 1196	java/io/ByteArrayOutputStream:write	([BII)V
    //   3496: iload_3
    //   3497: istore 8
    //   3499: lload 14
    //   3501: lstore 16
    //   3503: iload_3
    //   3504: istore 7
    //   3506: lload 14
    //   3508: lstore 18
    //   3510: aload 26
    //   3512: invokevirtual 1197	java/io/ByteArrayOutputStream:flush	()V
    //   3515: iload_3
    //   3516: istore 8
    //   3518: lload 14
    //   3520: lstore 16
    //   3522: iload_3
    //   3523: istore 7
    //   3525: lload 14
    //   3527: lstore 18
    //   3529: aload_1
    //   3530: aload 26
    //   3532: invokevirtual 1200	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   3535: invokevirtual 1182	com/tencent/mobileqq/utils/httputils/HttpMsg:setRecvData	([B)V
    //   3538: iload_3
    //   3539: istore 8
    //   3541: lload 14
    //   3543: lstore 16
    //   3545: iload_3
    //   3546: istore 7
    //   3548: lload 14
    //   3550: lstore 18
    //   3552: aload 30
    //   3554: aload_1
    //   3555: aload_1
    //   3556: invokeinterface 1185 3 0
    //   3561: goto -466 -> 3095
    //   3564: astore 27
    //   3566: aload 22
    //   3568: astore 28
    //   3570: aload 25
    //   3572: astore 29
    //   3574: iload 4
    //   3576: istore_3
    //   3577: iconst_1
    //   3578: istore 10
    //   3580: aload 23
    //   3582: astore 22
    //   3584: aload 24
    //   3586: astore 25
    //   3588: lload 12
    //   3590: lstore 14
    //   3592: aload 26
    //   3594: astore 24
    //   3596: aload 29
    //   3598: astore 23
    //   3600: iload 8
    //   3602: istore 4
    //   3604: lload 16
    //   3606: lstore 12
    //   3608: aload 28
    //   3610: astore 26
    //   3612: goto -2084 -> 1528
    //   3615: aload_1
    //   3616: getfield 269	com/tencent/mobileqq/utils/httputils/HttpMsg:isRequestInCmwap	Z
    //   3619: ifeq +303 -> 3922
    //   3622: aload_1
    //   3623: getfield 285	com/tencent/mobileqq/utils/httputils/HttpMsg:mCmwapConnectionType	I
    //   3626: ifeq +296 -> 3922
    //   3629: aload_1
    //   3630: getfield 282	com/tencent/mobileqq/utils/httputils/HttpMsg:isCmwapRetried	Z
    //   3633: ifne +289 -> 3922
    //   3636: aload_0
    //   3637: aload_1
    //   3638: ldc_w 1201
    //   3641: ldc_w 1203
    //   3644: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3647: aload_1
    //   3648: iconst_1
    //   3649: putfield 282	com/tencent/mobileqq/utils/httputils/HttpMsg:isCmwapRetried	Z
    //   3652: aload_0
    //   3653: aload_1
    //   3654: aload_2
    //   3655: invokevirtual 1205	com/tencent/mobileqq/utils/httputils/HttpCommunicator:run	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler;)V
    //   3658: new 208	java/util/HashMap
    //   3661: dup
    //   3662: invokespecial 572	java/util/HashMap:<init>	()V
    //   3665: astore 22
    //   3667: aload 22
    //   3669: ldc_w 574
    //   3672: aload_1
    //   3673: getfield 285	com/tencent/mobileqq/utils/httputils/HttpMsg:mCmwapConnectionType	I
    //   3676: invokestatic 578	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   3679: invokevirtual 582	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3682: pop
    //   3683: invokestatic 233	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3686: invokestatic 589	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   3689: aconst_null
    //   3690: ldc_w 1207
    //   3693: iconst_0
    //   3694: lconst_0
    //   3695: lconst_0
    //   3696: aload 22
    //   3698: ldc_w 593
    //   3701: invokevirtual 597	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   3704: iload 4
    //   3706: sipush 200
    //   3709: if_icmpeq +11 -> 3720
    //   3712: iload 4
    //   3714: sipush 206
    //   3717: if_icmpne +31 -> 3748
    //   3720: aload_0
    //   3721: aload_1
    //   3722: ldc_w 985
    //   3725: new 339	java/lang/StringBuilder
    //   3728: dup
    //   3729: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   3732: ldc_w 987
    //   3735: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3738: iconst_0
    //   3739: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3742: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3745: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3748: aload_2
    //   3749: ifnull +13 -> 3762
    //   3752: aload_2
    //   3753: getfield 551	com/tencent/mobileqq/utils/httputils/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3756: invokevirtual 182	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3759: ifne +47 -> 3806
    //   3762: aload_0
    //   3763: aload_1
    //   3764: ldc_w 989
    //   3767: new 339	java/lang/StringBuilder
    //   3770: dup
    //   3771: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   3774: ldc_w 991
    //   3777: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3780: aload_1
    //   3781: invokevirtual 994	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   3784: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3787: ldc_w 996
    //   3790: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3793: aload_1
    //   3794: invokevirtual 999	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   3797: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3800: invokevirtual 372	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3803: invokevirtual 376	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3806: aload_0
    //   3807: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   3810: ifnull +17 -> 3827
    //   3813: aload 25
    //   3815: ifnull +12 -> 3827
    //   3818: aload_0
    //   3819: getfield 155	com/tencent/mobileqq/utils/httputils/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   3822: aload 25
    //   3824: invokevirtual 1003	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3827: lload 12
    //   3829: lconst_0
    //   3830: ladd
    //   3831: lstore 12
    //   3833: lload 12
    //   3835: lconst_0
    //   3836: lcmp
    //   3837: ifeq +28 -> 3865
    //   3840: aload_1
    //   3841: invokevirtual 325	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   3844: ldc_w 322
    //   3847: invokevirtual 266	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3850: ifeq +66 -> 3916
    //   3853: iconst_1
    //   3854: istore 10
    //   3856: aload_0
    //   3857: aload_1
    //   3858: iload 10
    //   3860: lload 12
    //   3862: invokevirtual 1005	com/tencent/mobileqq/utils/httputils/HttpCommunicator:logFlow	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;ZJ)V
    //   3865: iconst_0
    //   3866: ifeq +11 -> 3877
    //   3869: new 1007	java/lang/NullPointerException
    //   3872: dup
    //   3873: invokespecial 1008	java/lang/NullPointerException:<init>	()V
    //   3876: athrow
    //   3877: iconst_0
    //   3878: ifeq +11 -> 3889
    //   3881: new 1007	java/lang/NullPointerException
    //   3884: dup
    //   3885: invokespecial 1008	java/lang/NullPointerException:<init>	()V
    //   3888: athrow
    //   3889: aload 24
    //   3891: ifnull +8 -> 3899
    //   3894: aload 24
    //   3896: invokevirtual 1010	java/io/OutputStream:close	()V
    //   3899: aload 23
    //   3901: ifnull -3346 -> 555
    //   3904: aload 23
    //   3906: invokevirtual 1013	java/net/HttpURLConnection:disconnect	()V
    //   3909: return
    //   3910: astore_1
    //   3911: aload_1
    //   3912: invokevirtual 715	java/lang/Exception:printStackTrace	()V
    //   3915: return
    //   3916: iconst_0
    //   3917: istore 10
    //   3919: goto -63 -> 3856
    //   3922: iconst_1
    //   3923: istore_3
    //   3924: aload_0
    //   3925: iload 4
    //   3927: aload 23
    //   3929: aload_1
    //   3930: invokevirtual 1209	com/tencent/mobileqq/utils/httputils/HttpCommunicator:procBadResponse	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   3933: lconst_0
    //   3934: lstore 14
    //   3936: iconst_1
    //   3937: istore_3
    //   3938: iload 7
    //   3940: istore 5
    //   3942: aload 29
    //   3944: astore 22
    //   3946: aload 28
    //   3948: astore 26
    //   3950: goto -766 -> 3184
    //   3953: iconst_0
    //   3954: istore 10
    //   3956: goto -560 -> 3396
    //   3959: astore 28
    //   3961: aload 29
    //   3963: ifnull -2361 -> 1602
    //   3966: aload 29
    //   3968: invokevirtual 1106	java/io/InputStream:close	()V
    //   3971: goto -2369 -> 1602
    //   3974: astore 28
    //   3976: goto -2374 -> 1602
    //   3979: astore 27
    //   3981: aconst_null
    //   3982: astore 28
    //   3984: aload 28
    //   3986: ifnull +8 -> 3994
    //   3989: aload 28
    //   3991: invokevirtual 1106	java/io/InputStream:close	()V
    //   3994: aload 27
    //   3996: athrow
    //   3997: astore 27
    //   3999: lload 14
    //   4001: lstore 16
    //   4003: aload 25
    //   4005: astore 28
    //   4007: aload 22
    //   4009: astore 29
    //   4011: iload_3
    //   4012: istore 6
    //   4014: iconst_1
    //   4015: istore_3
    //   4016: aload 27
    //   4018: astore 22
    //   4020: aload 23
    //   4022: astore 25
    //   4024: iload 4
    //   4026: istore 5
    //   4028: iload 6
    //   4030: istore 4
    //   4032: lload 12
    //   4034: lstore 14
    //   4036: lload 16
    //   4038: lstore 12
    //   4040: aload 24
    //   4042: astore 27
    //   4044: aload 28
    //   4046: astore 24
    //   4048: aload 29
    //   4050: astore 23
    //   4052: goto -2098 -> 1954
    //   4055: iconst_0
    //   4056: istore 10
    //   4058: goto -2233 -> 1825
    //   4061: astore 22
    //   4063: aload 22
    //   4065: invokevirtual 715	java/lang/Exception:printStackTrace	()V
    //   4068: iload 5
    //   4070: istore 4
    //   4072: goto -2190 -> 1882
    //   4075: iconst_0
    //   4076: istore 10
    //   4078: goto -1907 -> 2171
    //   4081: astore_1
    //   4082: aload_1
    //   4083: invokevirtual 715	java/lang/Exception:printStackTrace	()V
    //   4086: goto -1866 -> 2220
    //   4089: aload 30
    //   4091: aload_1
    //   4092: aload_1
    //   4093: iconst_5
    //   4094: invokeinterface 524 4 0
    //   4099: pop
    //   4100: return
    //   4101: astore_1
    //   4102: goto -3579 -> 523
    //   4105: astore_1
    //   4106: goto -3571 -> 535
    //   4109: astore_1
    //   4110: goto -3565 -> 545
    //   4113: astore_1
    //   4114: goto -3094 -> 1020
    //   4117: astore_1
    //   4118: goto -3086 -> 1032
    //   4121: astore_1
    //   4122: goto -3080 -> 1042
    //   4125: astore_1
    //   4126: goto -2840 -> 1286
    //   4129: astore_1
    //   4130: goto -2832 -> 1298
    //   4133: astore_1
    //   4134: goto -2826 -> 1308
    //   4137: astore_1
    //   4138: goto -261 -> 3877
    //   4141: astore_1
    //   4142: goto -253 -> 3889
    //   4145: astore_1
    //   4146: goto -247 -> 3899
    //   4149: astore 22
    //   4151: goto -736 -> 3415
    //   4154: astore 22
    //   4156: goto -731 -> 3425
    //   4159: astore 22
    //   4161: goto -726 -> 3435
    //   4164: astore 28
    //   4166: goto -2564 -> 1602
    //   4169: astore 28
    //   4171: goto -177 -> 3994
    //   4174: astore 23
    //   4176: goto -2332 -> 1844
    //   4179: astore 23
    //   4181: goto -2327 -> 1854
    //   4184: astore 23
    //   4186: goto -2322 -> 1864
    //   4189: astore_1
    //   4190: goto -2000 -> 2190
    //   4193: astore_1
    //   4194: goto -1994 -> 2200
    //   4197: astore_1
    //   4198: goto -1988 -> 2210
    //   4201: astore 22
    //   4203: aconst_null
    //   4204: astore 25
    //   4206: iconst_0
    //   4207: istore 10
    //   4209: lconst_0
    //   4210: lstore 12
    //   4212: iconst_m1
    //   4213: istore 4
    //   4215: aconst_null
    //   4216: astore 24
    //   4218: aconst_null
    //   4219: astore 23
    //   4221: iconst_0
    //   4222: istore_3
    //   4223: iload 6
    //   4225: istore 5
    //   4227: goto -2273 -> 1954
    //   4230: astore 22
    //   4232: iload_3
    //   4233: istore 4
    //   4235: iconst_0
    //   4236: istore_3
    //   4237: iload 6
    //   4239: istore 5
    //   4241: goto -2287 -> 1954
    //   4244: astore 22
    //   4246: iload_3
    //   4247: istore 4
    //   4249: iconst_0
    //   4250: istore_3
    //   4251: iload 6
    //   4253: istore 5
    //   4255: goto -2301 -> 1954
    //   4258: astore 28
    //   4260: aload 24
    //   4262: astore 25
    //   4264: iload_3
    //   4265: istore 4
    //   4267: aload 22
    //   4269: astore 24
    //   4271: aload 28
    //   4273: astore 22
    //   4275: iconst_0
    //   4276: istore_3
    //   4277: iload 6
    //   4279: istore 5
    //   4281: goto -2327 -> 1954
    //   4284: astore 28
    //   4286: aload 24
    //   4288: astore 25
    //   4290: iload_3
    //   4291: istore 4
    //   4293: aload 22
    //   4295: astore 24
    //   4297: iconst_0
    //   4298: istore_3
    //   4299: aload 28
    //   4301: astore 22
    //   4303: iload 6
    //   4305: istore 5
    //   4307: goto -2353 -> 1954
    //   4310: astore 28
    //   4312: aload 24
    //   4314: astore 25
    //   4316: iload_3
    //   4317: istore 4
    //   4319: aload 22
    //   4321: astore 24
    //   4323: iconst_0
    //   4324: istore_3
    //   4325: aload 28
    //   4327: astore 22
    //   4329: iload 6
    //   4331: istore 5
    //   4333: goto -2379 -> 1954
    //   4336: astore 28
    //   4338: iload_3
    //   4339: istore 4
    //   4341: aload 22
    //   4343: astore 24
    //   4345: aload 28
    //   4347: astore 22
    //   4349: iconst_0
    //   4350: istore_3
    //   4351: iload 6
    //   4353: istore 5
    //   4355: goto -2401 -> 1954
    //   4358: astore 22
    //   4360: iconst_0
    //   4361: istore_3
    //   4362: iload 6
    //   4364: istore 5
    //   4366: goto -2412 -> 1954
    //   4369: astore 28
    //   4371: iconst_0
    //   4372: istore_3
    //   4373: aload 22
    //   4375: astore 26
    //   4377: aload 28
    //   4379: astore 22
    //   4381: iload 6
    //   4383: istore 5
    //   4385: goto -2431 -> 1954
    //   4388: astore 28
    //   4390: iconst_0
    //   4391: istore_3
    //   4392: aload 26
    //   4394: astore 27
    //   4396: aload 22
    //   4398: astore 26
    //   4400: aload 28
    //   4402: astore 22
    //   4404: iload 6
    //   4406: istore 5
    //   4408: goto -2454 -> 1954
    //   4411: astore 28
    //   4413: iload 7
    //   4415: istore 5
    //   4417: lload 18
    //   4419: lstore 14
    //   4421: aload 26
    //   4423: astore 27
    //   4425: aload 22
    //   4427: astore 26
    //   4429: iconst_0
    //   4430: istore_3
    //   4431: aload 28
    //   4433: astore 22
    //   4435: goto -2481 -> 1954
    //   4438: astore 28
    //   4440: iload_3
    //   4441: istore 5
    //   4443: aload 22
    //   4445: astore 27
    //   4447: aload 28
    //   4449: astore 22
    //   4451: iconst_0
    //   4452: istore_3
    //   4453: goto -2499 -> 1954
    //   4456: astore 22
    //   4458: iload 6
    //   4460: istore 5
    //   4462: goto -2508 -> 1954
    //   4465: astore 27
    //   4467: goto -483 -> 3984
    //   4470: astore 27
    //   4472: lconst_0
    //   4473: lstore 12
    //   4475: aconst_null
    //   4476: astore 24
    //   4478: aconst_null
    //   4479: astore 25
    //   4481: aconst_null
    //   4482: astore 23
    //   4484: aconst_null
    //   4485: astore 26
    //   4487: lconst_0
    //   4488: lstore 14
    //   4490: iconst_m1
    //   4491: istore_3
    //   4492: aconst_null
    //   4493: astore 22
    //   4495: iconst_0
    //   4496: istore 4
    //   4498: goto -2970 -> 1528
    //   4501: astore 27
    //   4503: aload 25
    //   4505: astore 26
    //   4507: iconst_0
    //   4508: istore 4
    //   4510: lconst_0
    //   4511: lstore 16
    //   4513: aload 24
    //   4515: astore 25
    //   4517: lload 12
    //   4519: lstore 14
    //   4521: iconst_1
    //   4522: istore 10
    //   4524: aconst_null
    //   4525: astore 28
    //   4527: aconst_null
    //   4528: astore 24
    //   4530: aload 23
    //   4532: astore 22
    //   4534: aload 26
    //   4536: astore 23
    //   4538: lload 16
    //   4540: lstore 12
    //   4542: aload 28
    //   4544: astore 26
    //   4546: goto -3018 -> 1528
    //   4549: astore 27
    //   4551: aload 25
    //   4553: astore 26
    //   4555: iconst_0
    //   4556: istore 4
    //   4558: iconst_1
    //   4559: istore 10
    //   4561: lconst_0
    //   4562: lstore 16
    //   4564: aload 24
    //   4566: astore 25
    //   4568: aload 23
    //   4570: astore 22
    //   4572: lload 12
    //   4574: lstore 14
    //   4576: aconst_null
    //   4577: astore 28
    //   4579: aconst_null
    //   4580: astore 24
    //   4582: aload 26
    //   4584: astore 23
    //   4586: lload 16
    //   4588: lstore 12
    //   4590: aload 28
    //   4592: astore 26
    //   4594: goto -3066 -> 1528
    //   4597: astore 27
    //   4599: lconst_0
    //   4600: lstore 16
    //   4602: aconst_null
    //   4603: astore 26
    //   4605: aload 22
    //   4607: astore 25
    //   4609: aconst_null
    //   4610: astore 28
    //   4612: lload 12
    //   4614: lstore 14
    //   4616: aload 23
    //   4618: astore 22
    //   4620: iconst_0
    //   4621: istore 4
    //   4623: aload 24
    //   4625: astore 23
    //   4627: lload 16
    //   4629: lstore 12
    //   4631: aload 26
    //   4633: astore 24
    //   4635: aload 28
    //   4637: astore 26
    //   4639: goto -3111 -> 1528
    //   4642: astore 27
    //   4644: iconst_0
    //   4645: istore 4
    //   4647: lconst_0
    //   4648: lstore 16
    //   4650: aconst_null
    //   4651: astore 26
    //   4653: aload 22
    //   4655: astore 25
    //   4657: lload 12
    //   4659: lstore 14
    //   4661: aconst_null
    //   4662: astore 28
    //   4664: aload 23
    //   4666: astore 22
    //   4668: aload 24
    //   4670: astore 23
    //   4672: lload 16
    //   4674: lstore 12
    //   4676: aload 26
    //   4678: astore 24
    //   4680: aload 28
    //   4682: astore 26
    //   4684: goto -3156 -> 1528
    //   4687: astore 27
    //   4689: iconst_0
    //   4690: istore 4
    //   4692: lconst_0
    //   4693: lstore 16
    //   4695: aload 22
    //   4697: astore 25
    //   4699: lload 12
    //   4701: lstore 14
    //   4703: aconst_null
    //   4704: astore 26
    //   4706: iconst_1
    //   4707: istore 10
    //   4709: aload 23
    //   4711: astore 22
    //   4713: aconst_null
    //   4714: astore 28
    //   4716: aload 24
    //   4718: astore 23
    //   4720: lload 16
    //   4722: lstore 12
    //   4724: aload 28
    //   4726: astore 24
    //   4728: goto -3200 -> 1528
    //   4731: astore 27
    //   4733: iconst_0
    //   4734: istore 4
    //   4736: iconst_1
    //   4737: istore 10
    //   4739: lconst_0
    //   4740: lstore 16
    //   4742: aload 22
    //   4744: astore 26
    //   4746: lload 12
    //   4748: lstore 14
    //   4750: aconst_null
    //   4751: astore 24
    //   4753: aconst_null
    //   4754: astore 28
    //   4756: aload 23
    //   4758: astore 22
    //   4760: aload 25
    //   4762: astore 23
    //   4764: lload 16
    //   4766: lstore 12
    //   4768: aload 26
    //   4770: astore 25
    //   4772: aload 28
    //   4774: astore 26
    //   4776: goto -3248 -> 1528
    //   4779: astore 27
    //   4781: aload 25
    //   4783: astore 26
    //   4785: iconst_0
    //   4786: istore 5
    //   4788: iconst_1
    //   4789: istore 10
    //   4791: aconst_null
    //   4792: astore 28
    //   4794: iload 4
    //   4796: istore_3
    //   4797: aconst_null
    //   4798: astore 29
    //   4800: lload 12
    //   4802: lstore 16
    //   4804: aload 23
    //   4806: astore 22
    //   4808: aload 24
    //   4810: astore 25
    //   4812: aload 26
    //   4814: astore 23
    //   4816: iload 5
    //   4818: istore 4
    //   4820: lload 14
    //   4822: lstore 12
    //   4824: lload 16
    //   4826: lstore 14
    //   4828: aload 29
    //   4830: astore 24
    //   4832: aload 28
    //   4834: astore 26
    //   4836: goto -3308 -> 1528
    //   4839: astore 27
    //   4841: iconst_0
    //   4842: istore 5
    //   4844: iconst_1
    //   4845: istore 10
    //   4847: lload 14
    //   4849: lstore 16
    //   4851: aload 22
    //   4853: astore 28
    //   4855: iload 4
    //   4857: istore_3
    //   4858: aload 23
    //   4860: astore 22
    //   4862: lload 12
    //   4864: lstore 14
    //   4866: aload 24
    //   4868: astore 29
    //   4870: aload 25
    //   4872: astore 23
    //   4874: iload 5
    //   4876: istore 4
    //   4878: lload 16
    //   4880: lstore 12
    //   4882: aload 26
    //   4884: astore 24
    //   4886: aload 29
    //   4888: astore 25
    //   4890: aload 28
    //   4892: astore 26
    //   4894: goto -3366 -> 1528
    //   4897: astore 27
    //   4899: iload_3
    //   4900: istore 5
    //   4902: lload 14
    //   4904: lstore 16
    //   4906: lload 12
    //   4908: lstore 14
    //   4910: iload 4
    //   4912: istore_3
    //   4913: aload 24
    //   4915: astore 28
    //   4917: aload 22
    //   4919: astore 24
    //   4921: iconst_1
    //   4922: istore 10
    //   4924: aload 23
    //   4926: astore 22
    //   4928: aload 25
    //   4930: astore 23
    //   4932: iload 5
    //   4934: istore 4
    //   4936: lload 16
    //   4938: lstore 12
    //   4940: aload 28
    //   4942: astore 25
    //   4944: goto -3416 -> 1528
    //   4947: astore 22
    //   4949: goto -4235 -> 714
    //   4952: iconst_0
    //   4953: istore_3
    //   4954: lconst_0
    //   4955: lstore 14
    //   4957: aconst_null
    //   4958: astore 22
    //   4960: aconst_null
    //   4961: astore 26
    //   4963: goto -1795 -> 3168
    //   4966: aload 24
    //   4968: astore 25
    //   4970: aload 22
    //   4972: astore 24
    //   4974: goto -4664 -> 310
    //   4977: iload_3
    //   4978: iconst_1
    //   4979: iadd
    //   4980: istore_3
    //   4981: goto -2628 -> 2353
    //   4984: iload 5
    //   4986: iconst_1
    //   4987: iadd
    //   4988: istore 5
    //   4990: goto -2576 -> 2414
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4993	0	this	HttpCommunicator
    //   0	4993	1	paramHttpMsg	HttpMsg
    //   0	4993	2	paramHttpCommunicatorHandler	HttpCommunicator.HttpCommunicatorHandler
    //   25	4956	3	i	int
    //   198	4737	4	j	int
    //   49	4940	5	k	int
    //   39	4420	6	m	int
    //   36	4378	7	n	int
    //   2409	1192	8	i1	int
    //   2740	41	9	i2	int
    //   33	4890	10	bool1	boolean
    //   343	2248	11	bool2	boolean
    //   27	4912	12	l1	long
    //   30	4926	14	l2	long
    //   288	4649	16	l3	long
    //   2683	1735	18	l4	long
    //   2733	242	20	l5	long
    //   16	1058	22	str	String
    //   1084	1	22	localException1	Exception
    //   1383	491	22	localObject1	Object
    //   1946	275	22	localObject2	Object
    //   2251	1160	22	localObject3	Object
    //   3454	113	22	localException2	Exception
    //   3582	437	22	localObject4	Object
    //   4061	3	22	localException3	Exception
    //   4149	1	22	localIOException1	IOException
    //   4154	1	22	localIOException2	IOException
    //   4159	1	22	localIOException3	IOException
    //   4201	1	22	localObject5	Object
    //   4230	1	22	localObject6	Object
    //   4244	24	22	localObject7	Object
    //   4273	75	22	localObject8	Object
    //   4358	16	22	localObject9	Object
    //   4379	71	22	localObject10	Object
    //   4456	1	22	localObject11	Object
    //   4493	434	22	localObject12	Object
    //   4947	1	22	localThrowable1	Throwable
    //   4958	13	22	localObject13	Object
    //   7	4044	23	localObject14	Object
    //   4174	1	23	localIOException4	IOException
    //   4179	1	23	localIOException5	IOException
    //   4184	1	23	localIOException6	IOException
    //   4219	712	23	localObject15	Object
    //   55	4918	24	localObject16	Object
    //   79	4890	25	localObject17	Object
    //   13	4949	26	localObject18	Object
    //   22	2802	27	localObject19	Object
    //   2878	1	27	localThrowable2	Throwable
    //   2940	549	27	localObject20	Object
    //   3564	1	27	localThrowable3	Throwable
    //   3979	16	27	localObject21	Object
    //   3997	20	27	localObject22	Object
    //   4042	404	27	localObject23	Object
    //   4465	1	27	localObject24	Object
    //   4470	1	27	localThrowable4	Throwable
    //   4501	1	27	localThrowable5	Throwable
    //   4549	1	27	localThrowable6	Throwable
    //   4597	1	27	localThrowable7	Throwable
    //   4642	1	27	localThrowable8	Throwable
    //   4687	1	27	localThrowable9	Throwable
    //   4731	1	27	localThrowable10	Throwable
    //   4779	1	27	localThrowable11	Throwable
    //   4839	1	27	localThrowable12	Throwable
    //   4897	1	27	localThrowable13	Throwable
    //   10	1	28	localObject25	Object
    //   1472	53	28	localThrowable14	Throwable
    //   1556	2391	28	localObject26	Object
    //   3959	1	28	localException4	Exception
    //   3974	1	28	localIOException7	IOException
    //   3982	63	28	localObject27	Object
    //   4164	1	28	localIOException8	IOException
    //   4169	1	28	localIOException9	IOException
    //   4258	14	28	localObject28	Object
    //   4284	16	28	localObject29	Object
    //   4310	16	28	localObject30	Object
    //   4336	10	28	localObject31	Object
    //   4369	9	28	localObject32	Object
    //   4388	13	28	localObject33	Object
    //   4411	21	28	localObject34	Object
    //   4438	10	28	localObject35	Object
    //   4525	416	28	localObject36	Object
    //   19	4868	29	localObject37	Object
    //   4	4086	30	localIHttpCommunicatorListener	IHttpCommunicatorListener
    //   158	2215	31	localObject38	Object
    // Exception table:
    //   from	to	target	type
    //   452	459	562	java/lang/Exception
    //   464	473	562	java/lang/Exception
    //   486	499	562	java/lang/Exception
    //   502	511	562	java/lang/Exception
    //   515	523	562	java/lang/Exception
    //   527	535	562	java/lang/Exception
    //   540	545	562	java/lang/Exception
    //   550	555	562	java/lang/Exception
    //   949	956	1053	java/lang/Exception
    //   961	970	1053	java/lang/Exception
    //   983	996	1053	java/lang/Exception
    //   999	1008	1053	java/lang/Exception
    //   1012	1020	1053	java/lang/Exception
    //   1024	1032	1053	java/lang/Exception
    //   1037	1042	1053	java/lang/Exception
    //   1047	1052	1053	java/lang/Exception
    //   730	752	1084	java/lang/Exception
    //   752	788	1084	java/lang/Exception
    //   1059	1075	1084	java/lang/Exception
    //   1215	1222	1319	java/lang/Exception
    //   1227	1236	1319	java/lang/Exception
    //   1249	1262	1319	java/lang/Exception
    //   1265	1274	1319	java/lang/Exception
    //   1278	1286	1319	java/lang/Exception
    //   1290	1298	1319	java/lang/Exception
    //   1303	1308	1319	java/lang/Exception
    //   1313	1318	1319	java/lang/Exception
    //   323	332	1472	java/lang/Throwable
    //   336	345	1472	java/lang/Throwable
    //   568	575	1472	java/lang/Throwable
    //   580	589	1472	java/lang/Throwable
    //   589	618	1472	java/lang/Throwable
    //   640	694	1472	java/lang/Throwable
    //   719	725	1472	java/lang/Throwable
    //   730	752	1472	java/lang/Throwable
    //   752	788	1472	java/lang/Throwable
    //   1059	1075	1472	java/lang/Throwable
    //   1086	1097	1472	java/lang/Throwable
    //   1097	1113	1472	java/lang/Throwable
    //   1331	1347	1472	java/lang/Throwable
    //   1347	1365	1472	java/lang/Throwable
    //   1365	1402	1472	java/lang/Throwable
    //   1402	1431	1472	java/lang/Throwable
    //   1431	1438	1472	java/lang/Throwable
    //   1461	1472	1472	java/lang/Throwable
    //   1935	1946	1472	java/lang/Throwable
    //   2223	2230	1472	java/lang/Throwable
    //   2246	2253	1472	java/lang/Throwable
    //   2263	2286	1472	java/lang/Throwable
    //   2289	2325	1472	java/lang/Throwable
    //   2331	2351	1472	java/lang/Throwable
    //   2370	2387	1472	java/lang/Throwable
    //   2390	2397	1472	java/lang/Throwable
    //   2400	2411	1472	java/lang/Throwable
    //   2436	2446	1472	java/lang/Throwable
    //   2451	2494	1472	java/lang/Throwable
    //   2494	2526	1472	java/lang/Throwable
    //   2526	2578	1472	java/lang/Throwable
    //   2578	2590	1472	java/lang/Throwable
    //   3615	3704	1472	java/lang/Throwable
    //   3924	3933	1472	java/lang/Throwable
    //   1911	1920	1921	java/lang/Exception
    //   4089	4100	1921	java/lang/Exception
    //   323	332	1946	finally
    //   336	345	1946	finally
    //   568	575	1946	finally
    //   580	589	1946	finally
    //   589	618	1946	finally
    //   640	694	1946	finally
    //   704	709	1946	finally
    //   709	714	1946	finally
    //   719	725	1946	finally
    //   730	752	1946	finally
    //   752	788	1946	finally
    //   1059	1075	1946	finally
    //   1086	1097	1946	finally
    //   1097	1113	1946	finally
    //   1331	1347	1946	finally
    //   1347	1365	1946	finally
    //   1365	1402	1946	finally
    //   1402	1431	1946	finally
    //   1431	1438	1946	finally
    //   1461	1472	1946	finally
    //   1935	1946	1946	finally
    //   2223	2230	1946	finally
    //   2246	2253	1946	finally
    //   2263	2286	1946	finally
    //   2289	2325	1946	finally
    //   2331	2351	1946	finally
    //   2370	2387	1946	finally
    //   2390	2397	1946	finally
    //   2400	2411	1946	finally
    //   2436	2446	1946	finally
    //   2451	2494	1946	finally
    //   2494	2526	1946	finally
    //   2526	2578	1946	finally
    //   2578	2590	1946	finally
    //   3615	3704	1946	finally
    //   2609	2649	2878	java/lang/Throwable
    //   2866	2875	2878	java/lang/Throwable
    //   3345	3352	3454	java/lang/Exception
    //   3357	3366	3454	java/lang/Exception
    //   3380	3393	3454	java/lang/Exception
    //   3396	3405	3454	java/lang/Exception
    //   3410	3415	3454	java/lang/Exception
    //   3420	3425	3454	java/lang/Exception
    //   3430	3435	3454	java/lang/Exception
    //   3443	3448	3454	java/lang/Exception
    //   2685	2702	3564	java/lang/Throwable
    //   2721	2727	3564	java/lang/Throwable
    //   2775	2783	3564	java/lang/Throwable
    //   2799	2806	3564	java/lang/Throwable
    //   2822	2828	3564	java/lang/Throwable
    //   2844	2853	3564	java/lang/Throwable
    //   2961	2968	3564	java/lang/Throwable
    //   2995	3002	3564	java/lang/Throwable
    //   3021	3027	3564	java/lang/Throwable
    //   3041	3052	3564	java/lang/Throwable
    //   3066	3072	3564	java/lang/Throwable
    //   3086	3095	3564	java/lang/Throwable
    //   3109	3116	3564	java/lang/Throwable
    //   3130	3137	3564	java/lang/Throwable
    //   3151	3156	3564	java/lang/Throwable
    //   3486	3496	3564	java/lang/Throwable
    //   3510	3515	3564	java/lang/Throwable
    //   3529	3538	3564	java/lang/Throwable
    //   3552	3561	3564	java/lang/Throwable
    //   3806	3813	3910	java/lang/Exception
    //   3818	3827	3910	java/lang/Exception
    //   3840	3853	3910	java/lang/Exception
    //   3856	3865	3910	java/lang/Exception
    //   3869	3877	3910	java/lang/Exception
    //   3881	3889	3910	java/lang/Exception
    //   3894	3899	3910	java/lang/Exception
    //   3904	3909	3910	java/lang/Exception
    //   1551	1558	3959	java/lang/Exception
    //   1562	1569	3959	java/lang/Exception
    //   1578	1587	3959	java/lang/Exception
    //   3966	3971	3974	java/io/IOException
    //   1551	1558	3979	finally
    //   1531	1538	3997	finally
    //   1597	1602	3997	finally
    //   1602	1614	3997	finally
    //   3966	3971	3997	finally
    //   3989	3994	3997	finally
    //   3994	3997	3997	finally
    //   1774	1781	4061	java/lang/Exception
    //   1786	1795	4061	java/lang/Exception
    //   1809	1822	4061	java/lang/Exception
    //   1825	1834	4061	java/lang/Exception
    //   1839	1844	4061	java/lang/Exception
    //   1849	1854	4061	java/lang/Exception
    //   1859	1864	4061	java/lang/Exception
    //   1873	1878	4061	java/lang/Exception
    //   2120	2127	4081	java/lang/Exception
    //   2132	2141	4081	java/lang/Exception
    //   2155	2168	4081	java/lang/Exception
    //   2171	2180	4081	java/lang/Exception
    //   2185	2190	4081	java/lang/Exception
    //   2195	2200	4081	java/lang/Exception
    //   2205	2210	4081	java/lang/Exception
    //   2215	2220	4081	java/lang/Exception
    //   515	523	4101	java/io/IOException
    //   527	535	4105	java/io/IOException
    //   540	545	4109	java/io/IOException
    //   1012	1020	4113	java/io/IOException
    //   1024	1032	4117	java/io/IOException
    //   1037	1042	4121	java/io/IOException
    //   1278	1286	4125	java/io/IOException
    //   1290	1298	4129	java/io/IOException
    //   1303	1308	4133	java/io/IOException
    //   3869	3877	4137	java/io/IOException
    //   3881	3889	4141	java/io/IOException
    //   3894	3899	4145	java/io/IOException
    //   3410	3415	4149	java/io/IOException
    //   3420	3425	4154	java/io/IOException
    //   3430	3435	4159	java/io/IOException
    //   1597	1602	4164	java/io/IOException
    //   3989	3994	4169	java/io/IOException
    //   1839	1844	4174	java/io/IOException
    //   1849	1854	4179	java/io/IOException
    //   1859	1864	4184	java/io/IOException
    //   2185	2190	4189	java/io/IOException
    //   2195	2200	4193	java/io/IOException
    //   2205	2210	4197	java/io/IOException
    //   41	48	4201	finally
    //   167	197	4230	finally
    //   200	240	4230	finally
    //   255	265	4230	finally
    //   265	276	4230	finally
    //   276	295	4230	finally
    //   310	323	4244	finally
    //   57	81	4258	finally
    //   85	109	4284	finally
    //   112	141	4310	finally
    //   141	167	4336	finally
    //   2602	2609	4358	finally
    //   2609	2649	4369	finally
    //   2866	2875	4369	finally
    //   2649	2666	4388	finally
    //   2935	2942	4388	finally
    //   2685	2702	4411	finally
    //   2721	2727	4411	finally
    //   2775	2783	4411	finally
    //   2799	2806	4411	finally
    //   2822	2828	4411	finally
    //   2844	2853	4411	finally
    //   2961	2968	4411	finally
    //   2995	3002	4411	finally
    //   3021	3027	4411	finally
    //   3041	3052	4411	finally
    //   3066	3072	4411	finally
    //   3086	3095	4411	finally
    //   3109	3116	4411	finally
    //   3130	3137	4411	finally
    //   3151	3156	4411	finally
    //   3486	3496	4411	finally
    //   3510	3515	4411	finally
    //   3529	3538	4411	finally
    //   3552	3561	4411	finally
    //   3168	3179	4438	finally
    //   3924	3933	4456	finally
    //   1562	1569	4465	finally
    //   1578	1587	4465	finally
    //   41	48	4470	java/lang/Throwable
    //   167	197	4501	java/lang/Throwable
    //   200	240	4501	java/lang/Throwable
    //   255	265	4501	java/lang/Throwable
    //   265	276	4501	java/lang/Throwable
    //   276	295	4501	java/lang/Throwable
    //   310	323	4549	java/lang/Throwable
    //   57	81	4597	java/lang/Throwable
    //   85	109	4642	java/lang/Throwable
    //   112	141	4687	java/lang/Throwable
    //   141	167	4731	java/lang/Throwable
    //   2602	2609	4779	java/lang/Throwable
    //   2649	2666	4839	java/lang/Throwable
    //   2935	2942	4839	java/lang/Throwable
    //   3168	3179	4897	java/lang/Throwable
    //   704	709	4947	java/lang/Throwable
    //   709	714	4947	java/lang/Throwable
  }
  
  public int sendMsg(HttpMsg paramHttpMsg)
  {
    int i = -1;
    int k = this.maxQueueLength;
    int j = 1;
    if (this.bDispose)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.richmedia.HttpCommunicator", 2, "sendMsg closed");
      }
      if ((paramHttpMsg != null) && (paramHttpMsg.getProcessor() != null))
      {
        paramHttpMsg.setHttpErrorCode(9366, -1, "close");
        paramHttpMsg.getProcessor().handleError(paramHttpMsg, paramHttpMsg);
        k = i;
        return k;
      }
    }
    if (!this.bRun) {
      start();
    }
    Object localObject = this.locker;
    if (paramHttpMsg != null) {}
    for (;;)
    {
      try
      {
        if (this.mSendQueue.getQueueMsgNums() < k)
        {
          i = this.seed + 1;
          this.seed = i;
          paramHttpMsg.setSerial(i);
          paramHttpMsg.inQueueStartTime = SystemClock.uptimeMillis();
          this.mSendQueue.addMsg(paramHttpMsg);
          paramHttpMsg.getProcessor().statusChanged(paramHttpMsg, null, 0);
          i = this.seed;
          k = i;
          if (j == 0) {
            break;
          }
          disPatchMsg("sendMsg");
          return i;
        }
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        }
        if ((paramHttpMsg != null) && (paramHttpMsg.getProcessor() != null))
        {
          paramHttpMsg.setHttpErrorCode(9367, -1, "queen full");
          paramHttpMsg.getProcessor().handleError(paramHttpMsg, paramHttpMsg);
        }
      }
      finally {}
      j = 0;
    }
  }
  
  public void sendMsgRealSync(HttpMsg paramHttpMsg)
  {
    run(paramHttpMsg, null);
  }
  
  @Deprecated
  public int sendMsgSync(HttpMsg paramHttpMsg)
  {
    int i = this.maxQueueLength;
    int j = -1;
    for (;;)
    {
      synchronized (this.locker)
      {
        if ((!this.bDispose) && (this.mSendQueue.getQueueMsgNums() < i))
        {
          i = this.seed + 1;
          this.seed = i;
          paramHttpMsg.setSerial(i);
          this.mSendQueue.addMsg(paramHttpMsg);
          paramHttpMsg.getProcessor().statusChanged(paramHttpMsg, null, 0);
          j = this.seed;
          i = j;
          if (!this.bRun)
          {
            start();
            i = j;
          }
          ??? = new Object();
          paramHttpMsg.lockForSyncSend = ???;
          paramHttpMsg.hasFinished = new AtomicBoolean(false);
          disPatchMsg("sendMsgSync");
          if (paramHttpMsg.hasFinished.get()) {}
        }
      }
      try
      {
        ???.wait();
        return i;
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        i = j;
        continue;
        paramHttpMsg = finally;
        throw paramHttpMsg;
      }
      catch (InterruptedException paramHttpMsg)
      {
        for (;;)
        {
          paramHttpMsg.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  public void setCouncurrentNumber(int paramInt)
  {
    localObject1 = this.locker;
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        this.mConcurrentLimit = 4;
        this.mPreemptEnabled.set(false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.richmedia.HttpCommunicator", 2, "netType:" + paramInt + " concurrent:" + this.mConcurrentLimit);
        }
        disPatchMsg("netChange");
        return;
      }
      finally {}
      this.mConcurrentLimit = 3;
      this.mPreemptEnabled.set(true);
    }
  }
  
  void setExceptionInfo(boolean paramBoolean, int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg, Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IllegalArgumentException))
    {
      paramHttpMsg.setHttpErrorCode(9020, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IllegalStateException))
    {
      paramHttpMsg.setHttpErrorCode(9057, paramInt, paramThrowable.toString());
      return;
    }
    if ((paramThrowable instanceof IOException))
    {
      if ("request cancelled".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.setHttpErrorCode(9037, paramInt, paramThrowable.toString());
        return;
      }
      if ("httpcommunicator closed".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.setHttpErrorCode(9366, paramInt, paramThrowable.getMessage());
        return;
      }
      if ("preempted by higher msg".equals(paramThrowable.getMessage()))
      {
        paramHttpMsg.setHttpErrorCode(9361, paramInt, paramThrowable.toString());
        return;
      }
      if ("content-length zero".equals(paramThrowable.getMessage()))
      {
        paramHttpURLConnection = BaseTransProcessor.getServerReason("Q", -9531L);
        paramHttpMsg.setResponseProperty(HttpMsg.Param_Reason, paramHttpURLConnection);
        paramHttpMsg.setHttpErrorCode(-9527, paramInt, "content zero");
        return;
      }
      if ((paramThrowable instanceof MalformedURLException))
      {
        paramHttpMsg.setHttpErrorCode(9048, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof InterruptedIOException))
      {
        if ((paramThrowable instanceof SocketTimeoutException))
        {
          if (paramBoolean)
          {
            paramHttpMsg.setHttpErrorCode(9014, paramInt, paramThrowable.toString());
            return;
          }
          paramHttpMsg.setHttpErrorCode(9050, paramInt, paramThrowable.toString());
          return;
        }
        paramHttpMsg.setHttpErrorCode(9049, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof SocketException))
      {
        paramHttpURLConnection = paramThrowable.toString();
        if (QLog.isColorLevel())
        {
          paramHttpURLConnection = new StringBuilder();
          StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
          int j = arrayOfStackTraceElement.length;
          int i = 0;
          while (i < j)
          {
            StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
            paramHttpURLConnection.append("\n").append(localStackTraceElement.toString());
            i += 1;
          }
          paramHttpURLConnection = paramHttpURLConnection.toString();
        }
        if ((paramThrowable instanceof ConnectException))
        {
          paramHttpMsg.setHttpErrorCode(9052, paramInt, paramHttpURLConnection);
          return;
        }
        if ((paramThrowable instanceof NoRouteToHostException))
        {
          paramHttpMsg.setHttpErrorCode(9053, paramInt, paramHttpURLConnection);
          return;
        }
        if ((paramThrowable instanceof PortUnreachableException))
        {
          paramHttpMsg.setHttpErrorCode(9054, paramInt, paramHttpURLConnection);
          return;
        }
        paramHttpMsg.setHttpErrorCode(9051, paramInt, paramHttpURLConnection);
        return;
      }
      if ((paramThrowable instanceof UnknownHostException))
      {
        paramHttpMsg.setHttpErrorCode(9055, paramInt, paramThrowable.toString());
        return;
      }
      if ((paramThrowable instanceof EOFException))
      {
        paramHttpMsg.setHttpErrorCode(9056, paramInt, paramThrowable.getMessage());
        return;
      }
      paramThrowable = paramThrowable.toString();
      if (paramThrowable.contains("unreachable)")) {
        paramHttpURLConnection = "N_" + -20005;
      }
      for (;;)
      {
        paramHttpMsg.setHttpErrorCode(9047, paramInt, paramThrowable);
        paramHttpMsg.setResponseProperty(HttpMsg.Param_Reason, paramHttpURLConnection);
        return;
        if (paramThrowable.contains("Connection refused"))
        {
          paramHttpURLConnection = "N_" + -20002;
        }
        else if (paramThrowable.contains("No route to host"))
        {
          if (paramThrowable.contains("SocketException")) {
            paramHttpURLConnection = "N_" + -20003;
          } else {
            paramHttpURLConnection = "N_" + -20004;
          }
        }
        else if (paramThrowable.contains("unexpected end of stream"))
        {
          paramHttpURLConnection = "N_" + -20005;
        }
        else if (paramThrowable.contains("Connection timed out"))
        {
          paramHttpURLConnection = "N_" + -20006;
        }
        else
        {
          if (paramThrowable.contains("unaccpet content type"))
          {
            paramHttpMsg.setHttpErrorCode(9064, paramInt, paramThrowable);
            return;
          }
          paramHttpURLConnection = "N_" + -20007;
        }
      }
    }
    if ((paramThrowable instanceof SecurityException))
    {
      paramHttpMsg.setHttpErrorCode(9022, paramInt, paramThrowable.toString());
      return;
    }
    paramHttpURLConnection = paramThrowable.getMessage();
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("FlowDecoderExp")))
    {
      paramHttpMsg.setHttpErrorCode(9058, paramInt, paramHttpURLConnection);
      return;
    }
    if ((!TextUtils.isEmpty(paramHttpURLConnection)) && (paramHttpURLConnection.contains("DecryptError")))
    {
      paramHttpMsg.setHttpErrorCode(9059, paramInt, paramHttpURLConnection);
      return;
    }
    try
    {
      paramHttpMsg.setHttpErrorCode(9322, paramInt, Log.getStackTraceString(paramThrowable));
      return;
    }
    catch (OutOfMemoryError paramHttpURLConnection) {}
  }
  
  public void start()
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.locker)
      {
        if ((this.bDispose) || (this.bRun)) {
          return;
        }
        if ((this.mTimeoutCheckHandler != null) && (this.mCheckThreadPoolIdleRunnable != null)) {
          this.mTimeoutCheckHandler.removeCallbacks(this.mCheckThreadPoolIdleRunnable);
        }
        this.bRun = true;
        this.mConcurrentRunningMsgs = 0;
        if (this.mTimeoutCheckHandler == null) {
          this.mTimeoutCheckHandler = ThreadManager.getSubThreadHandler();
        }
        if (this.mHttpHandlers == null)
        {
          this.mHttpHandlers = new HttpCommunicator.HttpCommunicatorHandler[4];
          if (i < 4)
          {
            HandlerThread localHandlerThread = ThreadManager.newFreeHandlerThread("httpcommunicator_norm_" + i, 5);
            localHandlerThread.start();
            this.mHttpHandlers[i] = new HttpCommunicator.HttpCommunicatorHandler(this, localHandlerThread.getLooper());
            this.mHttpHandlers[i].index = i;
            i += 1;
            continue;
          }
        }
        i = NetworkCenter.getInstance().getNetType();
        if ((i == 2) || (i == 3))
        {
          this.mConcurrentLimit = 3;
          return;
        }
      }
      this.mConcurrentLimit = 4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.httputils.HttpCommunicator
 * JD-Core Version:    0.7.0.1
 */