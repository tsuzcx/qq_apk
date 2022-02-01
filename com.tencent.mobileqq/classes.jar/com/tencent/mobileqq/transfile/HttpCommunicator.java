package com.tencent.mobileqq.transfile;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.utils.httputils.SniSSLSocketFactory;
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

public class HttpCommunicator
  implements IHttpCommunicator
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
  private volatile boolean bDispose = false;
  private volatile boolean bRun = false;
  boolean forceDirect = true;
  String lastApn = null;
  private Object locker = new ReentrantLock();
  private Runnable mCheckThreadPoolIdleRunnable;
  private int mConcurrentLimit;
  private int mConcurrentRunningMsgs;
  private HttpCommunicator.HttpCommunicatorHandler[] mHttpHandlers;
  private AtomicBoolean mPreemptEnabled = new AtomicBoolean(false);
  private PriorityQueue mSendQueue = new PriorityQueue();
  private MqqHandler mTimeoutCheckHandler = null;
  private int maxQueueLength;
  private final int maxThread = 4;
  private int seed = 0;
  
  public HttpCommunicator() {}
  
  public HttpCommunicator(int paramInt)
  {
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
  
  public static String getHttpDataReason(int paramInt, long paramLong)
  {
    return "H_" + paramInt + "_" + paramLong;
  }
  
  public static String getServerReason(String paramString, long paramLong)
  {
    return paramString + "_" + paramLong;
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
  
  void logHttpCommunicator(HttpMsg paramHttpMsg, String paramString1, String paramString2)
  {
    try
    {
      TransFileUtil.log(TransFileUtil.getUinDesc(paramHttpMsg.busiType), paramHttpMsg.getRequestMethod().equals("POST"), String.valueOf(paramHttpMsg.fileType), paramHttpMsg.msgId, paramString1, paramString2);
      return;
    }
    catch (OutOfMemoryError paramHttpMsg) {}
  }
  
  public void onResponseTimeout(HttpMsg paramHttpMsg, HttpCommunicator.HttpCommunicatorHandler paramHttpCommunicatorHandler)
  {
    if ((paramHttpMsg != null) && (paramHttpCommunicatorHandler != null)) {}
    try
    {
      logHttpCommunicator(paramHttpMsg, "responseTimeout", "");
      replaceNewThread(paramHttpCommunicatorHandler);
      paramHttpMsg.setHttpErrorCode(9014, 0, "response timeout");
      paramHttpMsg.getProcessor().handleError(paramHttpMsg, paramHttpMsg);
      return;
    }
    catch (Exception paramHttpMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.richmedia.HttpCommunicator", 2, "onResponseTimeout", paramHttpMsg);
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
        paramHttpURLConnection = getHttpDataReason(paramInt, l1);
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
    //   1: invokevirtual 525	com/tencent/mobileqq/utils/httputils/HttpMsg:getProcessor	()Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   4: astore 35
    //   6: aconst_null
    //   7: astore 33
    //   9: aconst_null
    //   10: astore 34
    //   12: aconst_null
    //   13: astore 31
    //   15: aconst_null
    //   16: astore 30
    //   18: aconst_null
    //   19: astore 32
    //   21: iconst_0
    //   22: istore 9
    //   24: lconst_0
    //   25: lstore 14
    //   27: lconst_0
    //   28: lstore 16
    //   30: iconst_0
    //   31: istore 24
    //   33: iconst_0
    //   34: istore 8
    //   36: iconst_0
    //   37: istore 12
    //   39: iconst_0
    //   40: istore 11
    //   42: iconst_0
    //   43: istore 10
    //   45: iconst_0
    //   46: istore 7
    //   48: aload_0
    //   49: aload_1
    //   50: aconst_null
    //   51: iconst_1
    //   52: invokespecial 868	com/tencent/mobileqq/transfile/HttpCommunicator:statusChanged	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;I)V
    //   55: iconst_0
    //   56: istore 6
    //   58: iconst_0
    //   59: istore 24
    //   61: aconst_null
    //   62: astore 29
    //   64: aconst_null
    //   65: astore 26
    //   67: aconst_null
    //   68: astore 27
    //   70: iconst_m1
    //   71: istore_3
    //   72: aload_0
    //   73: aload_1
    //   74: ldc_w 870
    //   77: ldc_w 733
    //   80: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_0
    //   84: aload_2
    //   85: aload_1
    //   86: invokevirtual 872	com/tencent/mobileqq/transfile/HttpCommunicator:checkInterruptedBeforeBlock	(Lcom/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   89: aload_0
    //   90: aload_1
    //   91: invokespecial 874	com/tencent/mobileqq/transfile/HttpCommunicator:getConnection	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)Ljava/net/HttpURLConnection;
    //   94: astore 28
    //   96: aload 28
    //   98: astore 26
    //   100: aload_1
    //   101: aload 26
    //   103: putfield 878	com/tencent/mobileqq/utils/httputils/HttpMsg:mConn	Ljava/net/HttpURLConnection;
    //   106: aload_1
    //   107: invokestatic 723	android/os/SystemClock:uptimeMillis	()J
    //   110: putfield 881	com/tencent/mobileqq/utils/httputils/HttpMsg:startTime	J
    //   113: aload_0
    //   114: aload_1
    //   115: ldc_w 883
    //   118: ldc_w 733
    //   121: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   124: iconst_1
    //   125: istore 24
    //   127: invokestatic 588	java/lang/System:currentTimeMillis	()J
    //   130: pop2
    //   131: aload_1
    //   132: invokevirtual 321	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   135: ldc_w 318
    //   138: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   141: ifeq +5160 -> 5301
    //   144: new 885	com/tencent/mobileqq/transfile/HttpCommunicator$1
    //   147: dup
    //   148: aload_0
    //   149: aload_1
    //   150: aload_2
    //   151: invokespecial 888	com/tencent/mobileqq/transfile/HttpCommunicator$1:<init>	(Lcom/tencent/mobileqq/transfile/HttpCommunicator;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler;)V
    //   154: astore 28
    //   156: aload_0
    //   157: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   160: aload 28
    //   162: ldc2_w 889
    //   165: invokevirtual 894	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   168: pop
    //   169: aload_1
    //   170: invokevirtual 448	com/tencent/mobileqq/utils/httputils/HttpMsg:getSendData	()[B
    //   173: astore 36
    //   175: aload 26
    //   177: invokevirtual 898	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   180: astore 29
    //   182: aload_0
    //   183: aload_1
    //   184: ldc_w 900
    //   187: new 334	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   194: ldc_w 902
    //   197: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload 36
    //   202: arraylength
    //   203: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   212: iconst_0
    //   213: istore 4
    //   215: iload 4
    //   217: aload 36
    //   219: arraylength
    //   220: if_icmpge +46 -> 266
    //   223: aload_0
    //   224: aload_2
    //   225: aload_1
    //   226: invokevirtual 872	com/tencent/mobileqq/transfile/HttpCommunicator:checkInterruptedBeforeBlock	(Lcom/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   229: aload 29
    //   231: aload 36
    //   233: iload 4
    //   235: sipush 10240
    //   238: aload 36
    //   240: arraylength
    //   241: iload 4
    //   243: isub
    //   244: invokestatic 908	java/lang/Math:min	(II)I
    //   247: invokevirtual 914	java/io/OutputStream:write	([BII)V
    //   250: aload 29
    //   252: invokevirtual 917	java/io/OutputStream:flush	()V
    //   255: iload 4
    //   257: sipush 10240
    //   260: iadd
    //   261: istore 4
    //   263: goto -48 -> 215
    //   266: aload_2
    //   267: ifnull +13 -> 280
    //   270: aload_2
    //   271: getfield 557	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   274: invokevirtual 178	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   277: ifne +14 -> 291
    //   280: aload_0
    //   281: aload_1
    //   282: ldc_w 919
    //   285: ldc_w 733
    //   288: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   291: aload 26
    //   293: invokevirtual 923	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   296: invokevirtual 924	java/net/URL:toString	()Ljava/lang/String;
    //   299: invokevirtual 927	java/lang/String:length	()I
    //   302: i2l
    //   303: lstore 18
    //   305: aload 36
    //   307: arraylength
    //   308: istore 4
    //   310: lload 14
    //   312: ldc2_w 928
    //   315: lload 18
    //   317: ladd
    //   318: iload 4
    //   320: i2l
    //   321: ladd
    //   322: ladd
    //   323: lstore 14
    //   325: aload 29
    //   327: astore 27
    //   329: aload 28
    //   331: astore 29
    //   333: aload 27
    //   335: astore 28
    //   337: iload_3
    //   338: istore 5
    //   340: lload 16
    //   342: lstore 20
    //   344: iload_3
    //   345: istore 4
    //   347: lload 16
    //   349: lstore 18
    //   351: aload 31
    //   353: astore 27
    //   355: aload_0
    //   356: aload_2
    //   357: aload_1
    //   358: invokevirtual 872	com/tencent/mobileqq/transfile/HttpCommunicator:checkInterruptedBeforeBlock	(Lcom/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   361: iload_3
    //   362: istore 5
    //   364: lload 16
    //   366: lstore 20
    //   368: iload_3
    //   369: istore 4
    //   371: lload 16
    //   373: lstore 18
    //   375: aload 31
    //   377: astore 27
    //   379: aload 26
    //   381: invokevirtual 932	java/net/HttpURLConnection:getResponseCode	()I
    //   384: istore_3
    //   385: iload_3
    //   386: istore 5
    //   388: lload 16
    //   390: lstore 20
    //   392: iload_3
    //   393: istore 4
    //   395: lload 16
    //   397: lstore 18
    //   399: aload 31
    //   401: astore 27
    //   403: aload_0
    //   404: iload_3
    //   405: aload 26
    //   407: aload_1
    //   408: invokevirtual 934	com/tencent/mobileqq/transfile/HttpCommunicator:copyRespHeader	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   411: aload_2
    //   412: ifnull +233 -> 645
    //   415: iload_3
    //   416: istore 5
    //   418: lload 16
    //   420: lstore 20
    //   422: iload_3
    //   423: istore 4
    //   425: lload 16
    //   427: lstore 18
    //   429: aload 31
    //   431: astore 27
    //   433: aload_2
    //   434: getfield 557	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   437: invokevirtual 178	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   440: istore 25
    //   442: iload 25
    //   444: ifeq +201 -> 645
    //   447: iload_3
    //   448: sipush 200
    //   451: if_icmpeq +10 -> 461
    //   454: iload_3
    //   455: sipush 206
    //   458: if_icmpne +31 -> 489
    //   461: aload_0
    //   462: aload_1
    //   463: ldc_w 936
    //   466: new 334	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   473: ldc_w 938
    //   476: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: iconst_0
    //   480: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   489: aload_2
    //   490: ifnull +13 -> 503
    //   493: aload_2
    //   494: getfield 557	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   497: invokevirtual 178	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   500: ifne +47 -> 547
    //   503: aload_0
    //   504: aload_1
    //   505: ldc_w 940
    //   508: new 334	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   515: ldc_w 942
    //   518: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: aload_1
    //   522: invokevirtual 945	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   525: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: ldc_w 947
    //   531: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_1
    //   535: invokevirtual 950	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   538: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   547: aload_0
    //   548: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   551: ifnull +17 -> 568
    //   554: aload 29
    //   556: ifnull +12 -> 568
    //   559: aload_0
    //   560: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   563: aload 29
    //   565: invokevirtual 954	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   568: lload 14
    //   570: lconst_0
    //   571: ladd
    //   572: lconst_0
    //   573: lcmp
    //   574: ifeq +20 -> 594
    //   577: aload_1
    //   578: invokevirtual 321	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   581: ldc_w 318
    //   584: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   587: istore 24
    //   589: iload 24
    //   591: ifeq +3 -> 594
    //   594: iconst_0
    //   595: ifeq +11 -> 606
    //   598: new 956	java/lang/NullPointerException
    //   601: dup
    //   602: invokespecial 957	java/lang/NullPointerException:<init>	()V
    //   605: athrow
    //   606: iconst_0
    //   607: ifeq +11 -> 618
    //   610: new 956	java/lang/NullPointerException
    //   613: dup
    //   614: invokespecial 957	java/lang/NullPointerException:<init>	()V
    //   617: athrow
    //   618: aload 28
    //   620: ifnull +8 -> 628
    //   623: aload 28
    //   625: invokevirtual 959	java/io/OutputStream:close	()V
    //   628: aload 26
    //   630: ifnull +8 -> 638
    //   633: aload 26
    //   635: invokevirtual 962	java/net/HttpURLConnection:disconnect	()V
    //   638: return
    //   639: astore_1
    //   640: aload_1
    //   641: invokevirtual 688	java/lang/Exception:printStackTrace	()V
    //   644: return
    //   645: iload_3
    //   646: istore 5
    //   648: lload 16
    //   650: lstore 20
    //   652: iload_3
    //   653: istore 4
    //   655: lload 16
    //   657: lstore 18
    //   659: aload 31
    //   661: astore 27
    //   663: aload_0
    //   664: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   667: ifnull +35 -> 702
    //   670: aload 29
    //   672: ifnull +30 -> 702
    //   675: iload_3
    //   676: istore 5
    //   678: lload 16
    //   680: lstore 20
    //   682: iload_3
    //   683: istore 4
    //   685: lload 16
    //   687: lstore 18
    //   689: aload 31
    //   691: astore 27
    //   693: aload_0
    //   694: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   697: aload 29
    //   699: invokevirtual 954	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   702: iload_3
    //   703: istore 5
    //   705: lload 16
    //   707: lstore 20
    //   709: iload_3
    //   710: istore 4
    //   712: lload 16
    //   714: lstore 18
    //   716: aload 31
    //   718: astore 27
    //   720: aload_0
    //   721: aload_1
    //   722: ldc_w 964
    //   725: new 334	java/lang/StringBuilder
    //   728: dup
    //   729: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   732: ldc_w 966
    //   735: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: iload_3
    //   739: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   742: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   748: iload_3
    //   749: sipush 302
    //   752: if_icmpeq +10 -> 762
    //   755: iload_3
    //   756: sipush 301
    //   759: if_icmpne +1480 -> 2239
    //   762: iload 6
    //   764: iconst_5
    //   765: if_icmpge +1164 -> 1929
    //   768: iload_3
    //   769: istore 5
    //   771: lload 16
    //   773: lstore 20
    //   775: iload_3
    //   776: istore 4
    //   778: lload 16
    //   780: lstore 18
    //   782: aload 31
    //   784: astore 27
    //   786: aload_0
    //   787: aload_1
    //   788: ldc_w 968
    //   791: new 334	java/lang/StringBuilder
    //   794: dup
    //   795: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   798: ldc_w 970
    //   801: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: aload_1
    //   805: getfield 459	com/tencent/mobileqq/utils/httputils/HttpMsg:rawReqHeader	Ljava/lang/String;
    //   808: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: ldc_w 972
    //   814: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: aload_1
    //   818: getfield 626	com/tencent/mobileqq/utils/httputils/HttpMsg:rawRespHeader	Ljava/lang/String;
    //   821: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   830: iload_3
    //   831: istore 5
    //   833: lload 16
    //   835: lstore 20
    //   837: iload_3
    //   838: istore 4
    //   840: lload 16
    //   842: lstore 18
    //   844: aload 31
    //   846: astore 27
    //   848: aload 26
    //   850: ldc_w 974
    //   853: invokevirtual 631	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   856: astore 36
    //   858: aload 36
    //   860: ifnull +611 -> 1471
    //   863: aload 28
    //   865: ifnull +19 -> 884
    //   868: iload_3
    //   869: istore 4
    //   871: lload 16
    //   873: lstore 18
    //   875: aload 31
    //   877: astore 27
    //   879: aload 28
    //   881: invokevirtual 959	java/io/OutputStream:close	()V
    //   884: iload_3
    //   885: istore 4
    //   887: lload 16
    //   889: lstore 18
    //   891: aload 31
    //   893: astore 27
    //   895: aload 26
    //   897: invokevirtual 962	java/net/HttpURLConnection:disconnect	()V
    //   900: iload_3
    //   901: istore 5
    //   903: lload 16
    //   905: lstore 20
    //   907: iload_3
    //   908: istore 4
    //   910: lload 16
    //   912: lstore 18
    //   914: aload 31
    //   916: astore 27
    //   918: aload_1
    //   919: invokevirtual 977	com/tencent/mobileqq/utils/httputils/HttpMsg:isInstanceFollowRedirects	()Z
    //   922: ifne +228 -> 1150
    //   925: iload_3
    //   926: istore 5
    //   928: lload 16
    //   930: lstore 20
    //   932: iload_3
    //   933: istore 4
    //   935: lload 16
    //   937: lstore 18
    //   939: aload 31
    //   941: astore 27
    //   943: aload 35
    //   945: aload 36
    //   947: invokeinterface 980 2 0
    //   952: iload_3
    //   953: sipush 200
    //   956: if_icmpeq +10 -> 966
    //   959: iload_3
    //   960: sipush 206
    //   963: if_icmpne +31 -> 994
    //   966: aload_0
    //   967: aload_1
    //   968: ldc_w 936
    //   971: new 334	java/lang/StringBuilder
    //   974: dup
    //   975: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   978: ldc_w 938
    //   981: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: iconst_0
    //   985: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   988: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   991: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   994: aload_2
    //   995: ifnull +13 -> 1008
    //   998: aload_2
    //   999: getfield 557	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1002: invokevirtual 178	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1005: ifne +47 -> 1052
    //   1008: aload_0
    //   1009: aload_1
    //   1010: ldc_w 940
    //   1013: new 334	java/lang/StringBuilder
    //   1016: dup
    //   1017: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   1020: ldc_w 942
    //   1023: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1026: aload_1
    //   1027: invokevirtual 945	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   1030: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: ldc_w 947
    //   1036: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1039: aload_1
    //   1040: invokevirtual 950	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   1043: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1049: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1052: aload_0
    //   1053: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   1056: ifnull +17 -> 1073
    //   1059: aload 29
    //   1061: ifnull +12 -> 1073
    //   1064: aload_0
    //   1065: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   1068: aload 29
    //   1070: invokevirtual 954	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1073: lload 14
    //   1075: lconst_0
    //   1076: ladd
    //   1077: lconst_0
    //   1078: lcmp
    //   1079: ifeq +20 -> 1099
    //   1082: aload_1
    //   1083: invokevirtual 321	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   1086: ldc_w 318
    //   1089: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1092: istore 24
    //   1094: iload 24
    //   1096: ifeq +3 -> 1099
    //   1099: iconst_0
    //   1100: ifeq +11 -> 1111
    //   1103: new 956	java/lang/NullPointerException
    //   1106: dup
    //   1107: invokespecial 957	java/lang/NullPointerException:<init>	()V
    //   1110: athrow
    //   1111: iconst_0
    //   1112: ifeq +11 -> 1123
    //   1115: new 956	java/lang/NullPointerException
    //   1118: dup
    //   1119: invokespecial 957	java/lang/NullPointerException:<init>	()V
    //   1122: athrow
    //   1123: aload 28
    //   1125: ifnull +8 -> 1133
    //   1128: aload 28
    //   1130: invokevirtual 959	java/io/OutputStream:close	()V
    //   1133: aload 26
    //   1135: ifnull -497 -> 638
    //   1138: aload 26
    //   1140: invokevirtual 962	java/net/HttpURLConnection:disconnect	()V
    //   1143: return
    //   1144: astore_1
    //   1145: aload_1
    //   1146: invokevirtual 688	java/lang/Exception:printStackTrace	()V
    //   1149: return
    //   1150: iload_3
    //   1151: istore 5
    //   1153: lload 16
    //   1155: lstore 20
    //   1157: iload_3
    //   1158: istore 4
    //   1160: lload 16
    //   1162: lstore 18
    //   1164: aload 31
    //   1166: astore 27
    //   1168: aload_1
    //   1169: getfield 983	com/tencent/mobileqq/utils/httputils/HttpMsg:bReportRedirects	Z
    //   1172: ifeq +30 -> 1202
    //   1175: iload_3
    //   1176: istore 5
    //   1178: lload 16
    //   1180: lstore 20
    //   1182: iload_3
    //   1183: istore 4
    //   1185: lload 16
    //   1187: lstore 18
    //   1189: aload 31
    //   1191: astore 27
    //   1193: aload 35
    //   1195: aload 36
    //   1197: invokeinterface 980 2 0
    //   1202: iload_3
    //   1203: istore 5
    //   1205: lload 16
    //   1207: lstore 20
    //   1209: iload_3
    //   1210: istore 4
    //   1212: lload 16
    //   1214: lstore 18
    //   1216: aload 31
    //   1218: astore 27
    //   1220: aload_1
    //   1221: getfield 986	com/tencent/mobileqq/utils/httputils/HttpMsg:mNeedNotReferer	Z
    //   1224: ifne +32 -> 1256
    //   1227: iload_3
    //   1228: istore 5
    //   1230: lload 16
    //   1232: lstore 20
    //   1234: iload_3
    //   1235: istore 4
    //   1237: lload 16
    //   1239: lstore 18
    //   1241: aload 31
    //   1243: astore 27
    //   1245: aload_1
    //   1246: ldc_w 988
    //   1249: aload_1
    //   1250: invokevirtual 196	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrl	()Ljava/lang/String;
    //   1253: invokevirtual 989	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1256: iload_3
    //   1257: istore 5
    //   1259: lload 16
    //   1261: lstore 20
    //   1263: iload_3
    //   1264: istore 4
    //   1266: lload 16
    //   1268: lstore 18
    //   1270: aload 31
    //   1272: astore 27
    //   1274: aload_1
    //   1275: aload 36
    //   1277: invokevirtual 992	com/tencent/mobileqq/utils/httputils/HttpMsg:setUrl	(Ljava/lang/String;)V
    //   1280: iload_3
    //   1281: istore 5
    //   1283: lload 16
    //   1285: lstore 20
    //   1287: iload_3
    //   1288: istore 4
    //   1290: lload 16
    //   1292: lstore 18
    //   1294: aload 31
    //   1296: astore 27
    //   1298: aload_1
    //   1299: getfield 995	com/tencent/mobileqq/utils/httputils/HttpMsg:mHaveIpConnect	Z
    //   1302: ifeq +128 -> 1430
    //   1305: iload_3
    //   1306: istore 5
    //   1308: lload 16
    //   1310: lstore 20
    //   1312: iload_3
    //   1313: istore 4
    //   1315: lload 16
    //   1317: lstore 18
    //   1319: aload 31
    //   1321: astore 27
    //   1323: aload 36
    //   1325: invokestatic 1000	com/tencent/mobileqq/transfile/dns/BaseInnerDns:getHostFromUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   1328: astore 36
    //   1330: iload_3
    //   1331: istore 5
    //   1333: lload 16
    //   1335: lstore 20
    //   1337: iload_3
    //   1338: istore 4
    //   1340: lload 16
    //   1342: lstore 18
    //   1344: aload 31
    //   1346: astore 27
    //   1348: aload 36
    //   1350: invokestatic 1006	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1353: ifne +30 -> 1383
    //   1356: iload_3
    //   1357: istore 5
    //   1359: lload 16
    //   1361: lstore 20
    //   1363: iload_3
    //   1364: istore 4
    //   1366: lload 16
    //   1368: lstore 18
    //   1370: aload 31
    //   1372: astore 27
    //   1374: aload_1
    //   1375: ldc_w 501
    //   1378: aload 36
    //   1380: invokevirtual 989	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   1383: iload_3
    //   1384: istore 5
    //   1386: lload 16
    //   1388: lstore 20
    //   1390: iload_3
    //   1391: istore 4
    //   1393: lload 16
    //   1395: lstore 18
    //   1397: aload 31
    //   1399: astore 27
    //   1401: aload_0
    //   1402: aload_1
    //   1403: ldc_w 968
    //   1406: new 334	java/lang/StringBuilder
    //   1409: dup
    //   1410: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   1413: ldc_w 1008
    //   1416: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1419: aload 36
    //   1421: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1424: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1427: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1430: iload_3
    //   1431: istore 5
    //   1433: lload 16
    //   1435: lstore 20
    //   1437: iload_3
    //   1438: istore 4
    //   1440: lload 16
    //   1442: lstore 18
    //   1444: aload 31
    //   1446: astore 27
    //   1448: aload_1
    //   1449: ldc_w 1010
    //   1452: invokevirtual 1013	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestMethod	(Ljava/lang/String;)V
    //   1455: iload 6
    //   1457: iconst_1
    //   1458: iadd
    //   1459: istore 6
    //   1461: aload 28
    //   1463: astore 27
    //   1465: iconst_1
    //   1466: istore 24
    //   1468: goto -1396 -> 72
    //   1471: iload_3
    //   1472: istore 5
    //   1474: lload 16
    //   1476: lstore 20
    //   1478: iload_3
    //   1479: istore 4
    //   1481: lload 16
    //   1483: lstore 18
    //   1485: aload 31
    //   1487: astore 27
    //   1489: new 549	java/io/IOException
    //   1492: dup
    //   1493: ldc_w 1015
    //   1496: invokespecial 552	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1499: athrow
    //   1500: astore 31
    //   1502: iconst_1
    //   1503: istore 24
    //   1505: aconst_null
    //   1506: astore 30
    //   1508: aconst_null
    //   1509: astore 32
    //   1511: aload 29
    //   1513: astore 27
    //   1515: iconst_0
    //   1516: istore 4
    //   1518: iload 5
    //   1520: istore_3
    //   1521: aload 28
    //   1523: astore 29
    //   1525: aload 32
    //   1527: astore 28
    //   1529: lload 14
    //   1531: lstore 16
    //   1533: lload 20
    //   1535: lstore 14
    //   1537: iconst_1
    //   1538: istore 5
    //   1540: aload 31
    //   1542: instanceof 549
    //   1545: istore 25
    //   1547: iload 25
    //   1549: ifeq +62 -> 1611
    //   1552: aload 26
    //   1554: ifnull +57 -> 1611
    //   1557: aconst_null
    //   1558: astore 33
    //   1560: aload 26
    //   1562: invokevirtual 1019	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   1565: astore 32
    //   1567: aload 32
    //   1569: astore 33
    //   1571: sipush 10240
    //   1574: newarray byte
    //   1576: astore 34
    //   1578: aload 32
    //   1580: ifnull +21 -> 1601
    //   1583: aload 32
    //   1585: astore 33
    //   1587: aload 32
    //   1589: aload 34
    //   1591: invokevirtual 1025	java/io/InputStream:read	([B)I
    //   1594: istore 6
    //   1596: iload 6
    //   1598: ifgt -15 -> 1583
    //   1601: aload 32
    //   1603: ifnull +8 -> 1611
    //   1606: aload 32
    //   1608: invokevirtual 1026	java/io/InputStream:close	()V
    //   1611: aload_0
    //   1612: iload 24
    //   1614: iload_3
    //   1615: aload 26
    //   1617: aload_1
    //   1618: aload 31
    //   1620: invokevirtual 1030	com/tencent/mobileqq/transfile/HttpCommunicator:setExceptionInfo	(ZILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/Throwable;)V
    //   1623: iload 24
    //   1625: ifeq +46 -> 1671
    //   1628: iload_3
    //   1629: sipush 200
    //   1632: if_icmpeq +10 -> 1642
    //   1635: iload_3
    //   1636: sipush 206
    //   1639: if_icmpne +32 -> 1671
    //   1642: aload_0
    //   1643: aload_1
    //   1644: ldc_w 936
    //   1647: new 334	java/lang/StringBuilder
    //   1650: dup
    //   1651: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   1654: ldc_w 938
    //   1657: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1660: iload 4
    //   1662: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1665: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1668: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1671: aload_2
    //   1672: ifnull +13 -> 1685
    //   1675: aload_2
    //   1676: getfield 557	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1679: invokevirtual 178	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1682: ifne +101 -> 1783
    //   1685: aload_0
    //   1686: aload_1
    //   1687: ldc_w 940
    //   1690: new 334	java/lang/StringBuilder
    //   1693: dup
    //   1694: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   1697: ldc_w 942
    //   1700: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1703: aload_1
    //   1704: invokevirtual 945	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   1707: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1710: ldc_w 947
    //   1713: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1716: aload_1
    //   1717: invokevirtual 950	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   1720: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1723: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1726: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1729: aload_1
    //   1730: getfield 1033	com/tencent/mobileqq/utils/httputils/HttpMsg:errCode	I
    //   1733: sipush -9527
    //   1736: if_icmpne +47 -> 1783
    //   1739: aload_0
    //   1740: aload_1
    //   1741: ldc_w 1035
    //   1744: new 334	java/lang/StringBuilder
    //   1747: dup
    //   1748: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   1751: ldc_w 970
    //   1754: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1757: aload_1
    //   1758: getfield 459	com/tencent/mobileqq/utils/httputils/HttpMsg:rawReqHeader	Ljava/lang/String;
    //   1761: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1764: ldc_w 972
    //   1767: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1770: aload_1
    //   1771: getfield 626	com/tencent/mobileqq/utils/httputils/HttpMsg:rawRespHeader	Ljava/lang/String;
    //   1774: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1777: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1780: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1783: aload_0
    //   1784: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   1787: ifnull +17 -> 1804
    //   1790: aload 27
    //   1792: ifnull +12 -> 1804
    //   1795: aload_0
    //   1796: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   1799: aload 27
    //   1801: invokevirtual 954	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1804: lload 16
    //   1806: lload 14
    //   1808: ladd
    //   1809: lconst_0
    //   1810: lcmp
    //   1811: ifeq +20 -> 1831
    //   1814: aload_1
    //   1815: invokevirtual 321	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   1818: ldc_w 318
    //   1821: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1824: istore 24
    //   1826: iload 24
    //   1828: ifeq +3 -> 1831
    //   1831: aload 28
    //   1833: ifnull +8 -> 1841
    //   1836: aload 28
    //   1838: invokevirtual 1038	java/io/ByteArrayOutputStream:close	()V
    //   1841: aload 30
    //   1843: ifnull +8 -> 1851
    //   1846: aload 30
    //   1848: invokevirtual 1026	java/io/InputStream:close	()V
    //   1851: aload 29
    //   1853: ifnull +8 -> 1861
    //   1856: aload 29
    //   1858: invokevirtual 959	java/io/OutputStream:close	()V
    //   1861: iload 5
    //   1863: istore_3
    //   1864: aload 26
    //   1866: ifnull +11 -> 1877
    //   1869: aload 26
    //   1871: invokevirtual 962	java/net/HttpURLConnection:disconnect	()V
    //   1874: iload 5
    //   1876: istore_3
    //   1877: aload_2
    //   1878: ifnull +13 -> 1891
    //   1881: aload_2
    //   1882: getfield 557	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1885: invokevirtual 178	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1888: ifne -1250 -> 638
    //   1891: aload_1
    //   1892: getfield 539	com/tencent/mobileqq/utils/httputils/HttpMsg:mIsCancel	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1895: invokevirtual 178	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1898: ifne -1260 -> 638
    //   1901: iload_3
    //   1902: ifeq +2695 -> 4597
    //   1905: aload 35
    //   1907: aload_1
    //   1908: aload_1
    //   1909: invokeinterface 602 3 0
    //   1914: return
    //   1915: astore_2
    //   1916: aload_0
    //   1917: aload_1
    //   1918: ldc_w 1040
    //   1921: aload_2
    //   1922: invokestatic 1046	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1925: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1928: return
    //   1929: iload_3
    //   1930: istore 5
    //   1932: lload 16
    //   1934: lstore 20
    //   1936: iload_3
    //   1937: istore 4
    //   1939: lload 16
    //   1941: lstore 18
    //   1943: aload 31
    //   1945: astore 27
    //   1947: new 188	java/lang/Exception
    //   1950: dup
    //   1951: ldc_w 1048
    //   1954: invokespecial 748	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1957: athrow
    //   1958: astore 33
    //   1960: iconst_0
    //   1961: istore_3
    //   1962: aload 27
    //   1964: astore 30
    //   1966: aload 32
    //   1968: astore 31
    //   1970: lload 18
    //   1972: lstore 16
    //   1974: iload 7
    //   1976: istore 5
    //   1978: aload 33
    //   1980: astore 27
    //   1982: iload 24
    //   1984: ifeq +48 -> 2032
    //   1987: iload 4
    //   1989: sipush 200
    //   1992: if_icmpeq +11 -> 2003
    //   1995: iload 4
    //   1997: sipush 206
    //   2000: if_icmpne +32 -> 2032
    //   2003: aload_0
    //   2004: aload_1
    //   2005: ldc_w 936
    //   2008: new 334	java/lang/StringBuilder
    //   2011: dup
    //   2012: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   2015: ldc_w 938
    //   2018: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2021: iload 5
    //   2023: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2026: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2029: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2032: aload_2
    //   2033: ifnull +13 -> 2046
    //   2036: aload_2
    //   2037: getfield 557	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2040: invokevirtual 178	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2043: ifne +105 -> 2148
    //   2046: aload_0
    //   2047: aload_1
    //   2048: ldc_w 940
    //   2051: new 334	java/lang/StringBuilder
    //   2054: dup
    //   2055: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   2058: ldc_w 942
    //   2061: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2064: aload_1
    //   2065: invokevirtual 945	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   2068: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2071: ldc_w 947
    //   2074: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2077: aload_1
    //   2078: invokevirtual 950	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   2081: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2084: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2087: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2090: iload_3
    //   2091: ifeq +57 -> 2148
    //   2094: aload_1
    //   2095: getfield 1033	com/tencent/mobileqq/utils/httputils/HttpMsg:errCode	I
    //   2098: sipush -9527
    //   2101: if_icmpne +47 -> 2148
    //   2104: aload_0
    //   2105: aload_1
    //   2106: ldc_w 1035
    //   2109: new 334	java/lang/StringBuilder
    //   2112: dup
    //   2113: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   2116: ldc_w 970
    //   2119: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2122: aload_1
    //   2123: getfield 459	com/tencent/mobileqq/utils/httputils/HttpMsg:rawReqHeader	Ljava/lang/String;
    //   2126: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2129: ldc_w 972
    //   2132: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2135: aload_1
    //   2136: getfield 626	com/tencent/mobileqq/utils/httputils/HttpMsg:rawRespHeader	Ljava/lang/String;
    //   2139: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2142: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2145: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2148: aload_0
    //   2149: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   2152: ifnull +17 -> 2169
    //   2155: aload 29
    //   2157: ifnull +12 -> 2169
    //   2160: aload_0
    //   2161: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   2164: aload 29
    //   2166: invokevirtual 954	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   2169: lload 14
    //   2171: lload 16
    //   2173: ladd
    //   2174: lconst_0
    //   2175: lcmp
    //   2176: ifeq +20 -> 2196
    //   2179: aload_1
    //   2180: invokevirtual 321	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   2183: ldc_w 318
    //   2186: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2189: istore 24
    //   2191: iload 24
    //   2193: ifeq +3 -> 2196
    //   2196: aload 31
    //   2198: ifnull +8 -> 2206
    //   2201: aload 31
    //   2203: invokevirtual 1038	java/io/ByteArrayOutputStream:close	()V
    //   2206: aload 30
    //   2208: ifnull +8 -> 2216
    //   2211: aload 30
    //   2213: invokevirtual 1026	java/io/InputStream:close	()V
    //   2216: aload 28
    //   2218: ifnull +8 -> 2226
    //   2221: aload 28
    //   2223: invokevirtual 959	java/io/OutputStream:close	()V
    //   2226: aload 26
    //   2228: ifnull +8 -> 2236
    //   2231: aload 26
    //   2233: invokevirtual 962	java/net/HttpURLConnection:disconnect	()V
    //   2236: aload 27
    //   2238: athrow
    //   2239: iload_3
    //   2240: istore 5
    //   2242: lload 16
    //   2244: lstore 20
    //   2246: iload_3
    //   2247: istore 4
    //   2249: lload 16
    //   2251: lstore 18
    //   2253: aload 31
    //   2255: astore 27
    //   2257: aload_0
    //   2258: aload_1
    //   2259: aconst_null
    //   2260: iconst_2
    //   2261: invokespecial 868	com/tencent/mobileqq/transfile/HttpCommunicator:statusChanged	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;I)V
    //   2264: iload_3
    //   2265: sipush 200
    //   2268: if_icmpeq +10 -> 2278
    //   2271: iload_3
    //   2272: sipush 206
    //   2275: if_icmpne +1836 -> 4111
    //   2278: iload_3
    //   2279: istore 5
    //   2281: lload 16
    //   2283: lstore 20
    //   2285: iload_3
    //   2286: istore 4
    //   2288: lload 16
    //   2290: lstore 18
    //   2292: aload 31
    //   2294: astore 27
    //   2296: aload 26
    //   2298: invokevirtual 617	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   2301: astore 30
    //   2303: aload 30
    //   2305: ifnonnull +338 -> 2643
    //   2308: ldc_w 733
    //   2311: astore 30
    //   2313: iload_3
    //   2314: istore 5
    //   2316: lload 16
    //   2318: lstore 20
    //   2320: iload_3
    //   2321: istore 4
    //   2323: lload 16
    //   2325: lstore 18
    //   2327: aload 31
    //   2329: astore 27
    //   2331: aload_1
    //   2332: getfield 1052	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2335: ifnull +504 -> 2839
    //   2338: iload_3
    //   2339: istore 5
    //   2341: lload 16
    //   2343: lstore 20
    //   2345: iload_3
    //   2346: istore 4
    //   2348: lload 16
    //   2350: lstore 18
    //   2352: aload 31
    //   2354: astore 27
    //   2356: aload_1
    //   2357: getfield 1052	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2360: arraylength
    //   2361: ifle +478 -> 2839
    //   2364: iload_3
    //   2365: istore 5
    //   2367: lload 16
    //   2369: lstore 20
    //   2371: iload_3
    //   2372: istore 4
    //   2374: lload 16
    //   2376: lstore 18
    //   2378: aload 31
    //   2380: astore 27
    //   2382: aload 30
    //   2384: invokevirtual 927	java/lang/String:length	()I
    //   2387: ifle +452 -> 2839
    //   2390: iconst_0
    //   2391: istore 12
    //   2393: iload_3
    //   2394: istore 5
    //   2396: lload 16
    //   2398: lstore 20
    //   2400: iload_3
    //   2401: istore 4
    //   2403: lload 16
    //   2405: lstore 18
    //   2407: aload 31
    //   2409: astore 27
    //   2411: aload_1
    //   2412: getfield 1052	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2415: arraylength
    //   2416: iconst_1
    //   2417: if_icmpne +254 -> 2671
    //   2420: iload_3
    //   2421: istore 5
    //   2423: lload 16
    //   2425: lstore 20
    //   2427: iload_3
    //   2428: istore 4
    //   2430: lload 16
    //   2432: lstore 18
    //   2434: aload 31
    //   2436: astore 27
    //   2438: aload_1
    //   2439: getfield 1052	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2442: iconst_0
    //   2443: aaload
    //   2444: ifnull +227 -> 2671
    //   2447: iload_3
    //   2448: istore 5
    //   2450: lload 16
    //   2452: lstore 20
    //   2454: iload_3
    //   2455: istore 4
    //   2457: lload 16
    //   2459: lstore 18
    //   2461: aload 31
    //   2463: astore 27
    //   2465: aload_1
    //   2466: getfield 1052	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2469: iconst_0
    //   2470: aaload
    //   2471: invokevirtual 1055	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2474: ldc_w 1057
    //   2477: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2480: ifeq +191 -> 2671
    //   2483: iconst_1
    //   2484: istore 4
    //   2486: iload 4
    //   2488: ifne +351 -> 2839
    //   2491: iload_3
    //   2492: istore 5
    //   2494: lload 16
    //   2496: lstore 20
    //   2498: iload_3
    //   2499: istore 4
    //   2501: lload 16
    //   2503: lstore 18
    //   2505: aload 31
    //   2507: astore 27
    //   2509: new 334	java/lang/StringBuilder
    //   2512: dup
    //   2513: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   2516: astore 34
    //   2518: iload_3
    //   2519: istore 5
    //   2521: lload 16
    //   2523: lstore 20
    //   2525: iload_3
    //   2526: istore 4
    //   2528: lload 16
    //   2530: lstore 18
    //   2532: aload 31
    //   2534: astore 27
    //   2536: aload_1
    //   2537: getfield 1052	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2540: astore 33
    //   2542: iload_3
    //   2543: istore 5
    //   2545: lload 16
    //   2547: lstore 20
    //   2549: iload_3
    //   2550: istore 4
    //   2552: lload 16
    //   2554: lstore 18
    //   2556: aload 31
    //   2558: astore 27
    //   2560: aload 33
    //   2562: arraylength
    //   2563: istore 8
    //   2565: iconst_0
    //   2566: istore 6
    //   2568: iload 6
    //   2570: iload 8
    //   2572: if_icmpge +206 -> 2778
    //   2575: aload 33
    //   2577: iload 6
    //   2579: aaload
    //   2580: astore 36
    //   2582: aload 36
    //   2584: ifnull +2724 -> 5308
    //   2587: iload_3
    //   2588: istore 5
    //   2590: lload 16
    //   2592: lstore 20
    //   2594: iload_3
    //   2595: istore 4
    //   2597: lload 16
    //   2599: lstore 18
    //   2601: aload 31
    //   2603: astore 27
    //   2605: aload 34
    //   2607: aload 36
    //   2609: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2612: pop
    //   2613: iload_3
    //   2614: istore 5
    //   2616: lload 16
    //   2618: lstore 20
    //   2620: iload_3
    //   2621: istore 4
    //   2623: lload 16
    //   2625: lstore 18
    //   2627: aload 31
    //   2629: astore 27
    //   2631: aload 34
    //   2633: ldc_w 1059
    //   2636: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2639: pop
    //   2640: goto +2668 -> 5308
    //   2643: iload_3
    //   2644: istore 5
    //   2646: lload 16
    //   2648: lstore 20
    //   2650: iload_3
    //   2651: istore 4
    //   2653: lload 16
    //   2655: lstore 18
    //   2657: aload 31
    //   2659: astore 27
    //   2661: aload 30
    //   2663: invokevirtual 1055	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   2666: astore 30
    //   2668: goto -355 -> 2313
    //   2671: iload_3
    //   2672: istore 5
    //   2674: lload 16
    //   2676: lstore 20
    //   2678: iload_3
    //   2679: istore 4
    //   2681: lload 16
    //   2683: lstore 18
    //   2685: aload 31
    //   2687: astore 27
    //   2689: aload_1
    //   2690: getfield 1052	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   2693: astore 34
    //   2695: iload_3
    //   2696: istore 5
    //   2698: lload 16
    //   2700: lstore 20
    //   2702: iload_3
    //   2703: istore 4
    //   2705: lload 16
    //   2707: lstore 18
    //   2709: aload 31
    //   2711: astore 27
    //   2713: aload 34
    //   2715: arraylength
    //   2716: istore 13
    //   2718: iconst_0
    //   2719: istore 6
    //   2721: iload 12
    //   2723: istore 4
    //   2725: iload 6
    //   2727: iload 13
    //   2729: if_icmpge -243 -> 2486
    //   2732: aload 34
    //   2734: iload 6
    //   2736: aaload
    //   2737: astore 33
    //   2739: aload 33
    //   2741: ifnull +2576 -> 5317
    //   2744: iload_3
    //   2745: istore 5
    //   2747: lload 16
    //   2749: lstore 20
    //   2751: iload_3
    //   2752: istore 4
    //   2754: lload 16
    //   2756: lstore 18
    //   2758: aload 31
    //   2760: astore 27
    //   2762: aload 30
    //   2764: aload 33
    //   2766: invokevirtual 1062	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   2769: ifeq +2548 -> 5317
    //   2772: iconst_1
    //   2773: istore 4
    //   2775: goto -289 -> 2486
    //   2778: iload_3
    //   2779: istore 5
    //   2781: lload 16
    //   2783: lstore 20
    //   2785: iload_3
    //   2786: istore 4
    //   2788: lload 16
    //   2790: lstore 18
    //   2792: aload 31
    //   2794: astore 27
    //   2796: new 549	java/io/IOException
    //   2799: dup
    //   2800: new 334	java/lang/StringBuilder
    //   2803: dup
    //   2804: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   2807: ldc_w 1064
    //   2810: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2813: aload 30
    //   2815: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2818: ldc_w 1066
    //   2821: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2824: aload 34
    //   2826: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2829: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2832: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2835: invokespecial 552	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2838: athrow
    //   2839: iload_3
    //   2840: istore 5
    //   2842: lload 16
    //   2844: lstore 20
    //   2846: iload_3
    //   2847: istore 4
    //   2849: lload 16
    //   2851: lstore 18
    //   2853: aload 31
    //   2855: astore 27
    //   2857: aload_1
    //   2858: getfield 654	com/tencent/mobileqq/utils/httputils/HttpMsg:totalLen	J
    //   2861: lconst_0
    //   2862: lcmp
    //   2863: ifne +62 -> 2925
    //   2866: iload_3
    //   2867: istore 5
    //   2869: lload 16
    //   2871: lstore 20
    //   2873: iload_3
    //   2874: istore 4
    //   2876: lload 16
    //   2878: lstore 18
    //   2880: aload 31
    //   2882: astore 27
    //   2884: aload_1
    //   2885: invokevirtual 321	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   2888: ldc_w 318
    //   2891: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2894: ifne +31 -> 2925
    //   2897: iload_3
    //   2898: istore 5
    //   2900: lload 16
    //   2902: lstore 20
    //   2904: iload_3
    //   2905: istore 4
    //   2907: lload 16
    //   2909: lstore 18
    //   2911: aload 31
    //   2913: astore 27
    //   2915: new 549	java/io/IOException
    //   2918: dup
    //   2919: ldc 28
    //   2921: invokespecial 552	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   2924: athrow
    //   2925: iload_3
    //   2926: istore 5
    //   2928: lload 16
    //   2930: lstore 20
    //   2932: iload_3
    //   2933: istore 4
    //   2935: lload 16
    //   2937: lstore 18
    //   2939: aload 31
    //   2941: astore 27
    //   2943: aload_0
    //   2944: aload_1
    //   2945: ldc_w 1068
    //   2948: new 334	java/lang/StringBuilder
    //   2951: dup
    //   2952: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   2955: ldc_w 1070
    //   2958: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2961: aload_1
    //   2962: getfield 654	com/tencent/mobileqq/utils/httputils/HttpMsg:totalLen	J
    //   2965: invokevirtual 481	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2968: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2971: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2974: iload_3
    //   2975: istore 5
    //   2977: lload 16
    //   2979: lstore 20
    //   2981: iload_3
    //   2982: istore 4
    //   2984: lload 16
    //   2986: lstore 18
    //   2988: aload 31
    //   2990: astore 27
    //   2992: aload_1
    //   2993: getfield 881	com/tencent/mobileqq/utils/httputils/HttpMsg:startTime	J
    //   2996: lconst_0
    //   2997: lcmp
    //   2998: ifeq +33 -> 3031
    //   3001: iload_3
    //   3002: istore 5
    //   3004: lload 16
    //   3006: lstore 20
    //   3008: iload_3
    //   3009: istore 4
    //   3011: lload 16
    //   3013: lstore 18
    //   3015: aload 31
    //   3017: astore 27
    //   3019: aload_1
    //   3020: invokestatic 723	android/os/SystemClock:uptimeMillis	()J
    //   3023: aload_1
    //   3024: getfield 881	com/tencent/mobileqq/utils/httputils/HttpMsg:startTime	J
    //   3027: lsub
    //   3028: putfield 1073	com/tencent/mobileqq/utils/httputils/HttpMsg:cost	J
    //   3031: iload_3
    //   3032: istore 5
    //   3034: lload 16
    //   3036: lstore 20
    //   3038: iload_3
    //   3039: istore 4
    //   3041: lload 16
    //   3043: lstore 18
    //   3045: aload 31
    //   3047: astore 27
    //   3049: aload 35
    //   3051: aload_1
    //   3052: aload_1
    //   3053: iconst_3
    //   3054: invokeinterface 530 4 0
    //   3059: ifeq +2230 -> 5289
    //   3062: lconst_0
    //   3063: ldc2_w 928
    //   3066: ladd
    //   3067: lstore 16
    //   3069: iload_3
    //   3070: istore 5
    //   3072: lload 16
    //   3074: lstore 20
    //   3076: iload_3
    //   3077: istore 4
    //   3079: lload 16
    //   3081: lstore 18
    //   3083: aload 31
    //   3085: astore 27
    //   3087: aload 26
    //   3089: invokevirtual 1076	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   3092: astore 30
    //   3094: iload_3
    //   3095: istore 4
    //   3097: lload 16
    //   3099: lstore 18
    //   3101: aload 30
    //   3103: astore 27
    //   3105: invokestatic 1082	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   3108: astore 33
    //   3110: iload_3
    //   3111: istore 4
    //   3113: lload 16
    //   3115: lstore 18
    //   3117: aload 30
    //   3119: astore 27
    //   3121: invokestatic 1085	com/tencent/commonsdk/pool/ByteArrayPool:getMaxBufInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   3124: pop
    //   3125: iload_3
    //   3126: istore 4
    //   3128: lload 16
    //   3130: lstore 18
    //   3132: aload 30
    //   3134: astore 27
    //   3136: aload_1
    //   3137: iconst_0
    //   3138: putfield 1088	com/tencent/mobileqq/utils/httputils/HttpMsg:mUseByteArrayPool	Z
    //   3141: iload_3
    //   3142: istore 4
    //   3144: lload 16
    //   3146: lstore 18
    //   3148: aload 30
    //   3150: astore 27
    //   3152: new 1037	java/io/ByteArrayOutputStream
    //   3155: dup
    //   3156: invokespecial 1089	java/io/ByteArrayOutputStream:<init>	()V
    //   3159: astore 31
    //   3161: iload 11
    //   3163: istore 6
    //   3165: lload 16
    //   3167: lstore 18
    //   3169: iload 10
    //   3171: istore 5
    //   3173: lload 16
    //   3175: lstore 20
    //   3177: aload_1
    //   3178: getfield 1088	com/tencent/mobileqq/utils/httputils/HttpMsg:mUseByteArrayPool	Z
    //   3181: ifeq +234 -> 3415
    //   3184: iload 11
    //   3186: istore 6
    //   3188: lload 16
    //   3190: lstore 18
    //   3192: iload 10
    //   3194: istore 5
    //   3196: lload 16
    //   3198: lstore 20
    //   3200: aload 33
    //   3202: sipush 10240
    //   3205: invokevirtual 1093	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   3208: astore 27
    //   3210: goto +2116 -> 5326
    //   3213: iload 4
    //   3215: istore 6
    //   3217: lload 16
    //   3219: lstore 18
    //   3221: iload 4
    //   3223: istore 5
    //   3225: lload 16
    //   3227: lstore 20
    //   3229: aload 30
    //   3231: aload 27
    //   3233: iload 7
    //   3235: aload 27
    //   3237: arraylength
    //   3238: iload 7
    //   3240: isub
    //   3241: invokevirtual 1096	java/io/InputStream:read	([BII)I
    //   3244: istore 8
    //   3246: iload 8
    //   3248: ifle +230 -> 3478
    //   3251: iload 4
    //   3253: istore 6
    //   3255: lload 16
    //   3257: lstore 18
    //   3259: iload 4
    //   3261: istore 5
    //   3263: lload 16
    //   3265: lstore 20
    //   3267: aload_0
    //   3268: aload_2
    //   3269: aload_1
    //   3270: invokevirtual 872	com/tencent/mobileqq/transfile/HttpCommunicator:checkInterruptedBeforeBlock	(Lcom/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   3273: lload 16
    //   3275: iload 8
    //   3277: i2l
    //   3278: ladd
    //   3279: lstore 22
    //   3281: iload 7
    //   3283: iload 8
    //   3285: iadd
    //   3286: istore 10
    //   3288: iload 4
    //   3290: iload 8
    //   3292: iadd
    //   3293: istore 8
    //   3295: iload 8
    //   3297: istore 4
    //   3299: iload 10
    //   3301: istore 7
    //   3303: lload 22
    //   3305: lstore 16
    //   3307: iload 8
    //   3309: istore 6
    //   3311: lload 22
    //   3313: lstore 18
    //   3315: iload 8
    //   3317: istore 5
    //   3319: lload 22
    //   3321: lstore 20
    //   3323: iload 10
    //   3325: aload 27
    //   3327: arraylength
    //   3328: if_icmplt -115 -> 3213
    //   3331: iload 8
    //   3333: istore 6
    //   3335: lload 22
    //   3337: lstore 18
    //   3339: iload 8
    //   3341: istore 5
    //   3343: lload 22
    //   3345: lstore 20
    //   3347: aload_1
    //   3348: invokevirtual 1099	com/tencent/mobileqq/utils/httputils/HttpMsg:isDataSlice	()Z
    //   3351: ifeq +90 -> 3441
    //   3354: iload 8
    //   3356: istore 6
    //   3358: lload 22
    //   3360: lstore 18
    //   3362: iload 8
    //   3364: istore 5
    //   3366: lload 22
    //   3368: lstore 20
    //   3370: aload_1
    //   3371: aload 27
    //   3373: invokevirtual 1103	com/tencent/mobileqq/utils/httputils/HttpMsg:setRecvData	([B)V
    //   3376: iload 8
    //   3378: istore 6
    //   3380: lload 22
    //   3382: lstore 18
    //   3384: iload 8
    //   3386: istore 5
    //   3388: lload 22
    //   3390: lstore 20
    //   3392: aload 35
    //   3394: aload_1
    //   3395: aload_1
    //   3396: invokeinterface 1106 3 0
    //   3401: iconst_0
    //   3402: istore 7
    //   3404: iload 8
    //   3406: istore 4
    //   3408: lload 22
    //   3410: lstore 16
    //   3412: goto -199 -> 3213
    //   3415: iload 11
    //   3417: istore 6
    //   3419: lload 16
    //   3421: lstore 18
    //   3423: iload 10
    //   3425: istore 5
    //   3427: lload 16
    //   3429: lstore 20
    //   3431: sipush 10240
    //   3434: newarray byte
    //   3436: astore 27
    //   3438: goto +1888 -> 5326
    //   3441: iload 8
    //   3443: istore 6
    //   3445: lload 22
    //   3447: lstore 18
    //   3449: iload 8
    //   3451: istore 5
    //   3453: lload 22
    //   3455: lstore 20
    //   3457: aload 31
    //   3459: aload 27
    //   3461: invokevirtual 1108	java/io/ByteArrayOutputStream:write	([B)V
    //   3464: iconst_0
    //   3465: istore 7
    //   3467: iload 8
    //   3469: istore 4
    //   3471: lload 22
    //   3473: lstore 16
    //   3475: goto -262 -> 3213
    //   3478: iload 4
    //   3480: istore 6
    //   3482: lload 16
    //   3484: lstore 18
    //   3486: iload 4
    //   3488: istore 5
    //   3490: lload 16
    //   3492: lstore 20
    //   3494: aload_1
    //   3495: invokevirtual 1099	com/tencent/mobileqq/utils/httputils/HttpMsg:isDataSlice	()Z
    //   3498: ifeq +468 -> 3966
    //   3501: iload 7
    //   3503: ifle +99 -> 3602
    //   3506: iload 4
    //   3508: istore 6
    //   3510: lload 16
    //   3512: lstore 18
    //   3514: iload 4
    //   3516: istore 5
    //   3518: lload 16
    //   3520: lstore 20
    //   3522: iload 7
    //   3524: newarray byte
    //   3526: astore 32
    //   3528: iload 4
    //   3530: istore 6
    //   3532: lload 16
    //   3534: lstore 18
    //   3536: iload 4
    //   3538: istore 5
    //   3540: lload 16
    //   3542: lstore 20
    //   3544: aload 27
    //   3546: iconst_0
    //   3547: aload 32
    //   3549: iconst_0
    //   3550: iload 7
    //   3552: invokestatic 1112	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   3555: iload 4
    //   3557: istore 6
    //   3559: lload 16
    //   3561: lstore 18
    //   3563: iload 4
    //   3565: istore 5
    //   3567: lload 16
    //   3569: lstore 20
    //   3571: aload_1
    //   3572: aload 32
    //   3574: invokevirtual 1103	com/tencent/mobileqq/utils/httputils/HttpMsg:setRecvData	([B)V
    //   3577: iload 4
    //   3579: istore 6
    //   3581: lload 16
    //   3583: lstore 18
    //   3585: iload 4
    //   3587: istore 5
    //   3589: lload 16
    //   3591: lstore 20
    //   3593: aload 35
    //   3595: aload_1
    //   3596: aload_1
    //   3597: invokeinterface 1106 3 0
    //   3602: iload 4
    //   3604: istore 6
    //   3606: lload 16
    //   3608: lstore 18
    //   3610: iload 4
    //   3612: istore 5
    //   3614: lload 16
    //   3616: lstore 20
    //   3618: aload_1
    //   3619: getfield 1088	com/tencent/mobileqq/utils/httputils/HttpMsg:mUseByteArrayPool	Z
    //   3622: ifeq +26 -> 3648
    //   3625: iload 4
    //   3627: istore 6
    //   3629: lload 16
    //   3631: lstore 18
    //   3633: iload 4
    //   3635: istore 5
    //   3637: lload 16
    //   3639: lstore 20
    //   3641: aload 33
    //   3643: aload 27
    //   3645: invokevirtual 1115	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   3648: iload 4
    //   3650: istore 6
    //   3652: lload 16
    //   3654: lstore 18
    //   3656: iload 4
    //   3658: istore 5
    //   3660: lload 16
    //   3662: lstore 20
    //   3664: aload 31
    //   3666: invokevirtual 1038	java/io/ByteArrayOutputStream:close	()V
    //   3669: aload 30
    //   3671: astore 27
    //   3673: aload 31
    //   3675: astore 30
    //   3677: aload 35
    //   3679: aload_1
    //   3680: aload_1
    //   3681: iconst_4
    //   3682: invokeinterface 530 4 0
    //   3687: pop
    //   3688: iload 4
    //   3690: istore 5
    //   3692: iload 9
    //   3694: istore 4
    //   3696: iload_3
    //   3697: sipush 200
    //   3700: if_icmpeq +10 -> 3710
    //   3703: iload_3
    //   3704: sipush 206
    //   3707: if_icmpne +32 -> 3739
    //   3710: aload_0
    //   3711: aload_1
    //   3712: ldc_w 936
    //   3715: new 334	java/lang/StringBuilder
    //   3718: dup
    //   3719: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   3722: ldc_w 938
    //   3725: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3728: iload 5
    //   3730: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3733: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3736: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3739: aload_2
    //   3740: ifnull +13 -> 3753
    //   3743: aload_2
    //   3744: getfield 557	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3747: invokevirtual 178	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3750: ifne +106 -> 3856
    //   3753: aload_0
    //   3754: aload_1
    //   3755: ldc_w 940
    //   3758: new 334	java/lang/StringBuilder
    //   3761: dup
    //   3762: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   3765: ldc_w 942
    //   3768: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3771: aload_1
    //   3772: invokevirtual 945	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   3775: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3778: ldc_w 947
    //   3781: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3784: aload_1
    //   3785: invokevirtual 950	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   3788: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3791: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3794: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3797: iload 4
    //   3799: ifeq +57 -> 3856
    //   3802: aload_1
    //   3803: getfield 1033	com/tencent/mobileqq/utils/httputils/HttpMsg:errCode	I
    //   3806: sipush -9527
    //   3809: if_icmpne +47 -> 3856
    //   3812: aload_0
    //   3813: aload_1
    //   3814: ldc_w 1035
    //   3817: new 334	java/lang/StringBuilder
    //   3820: dup
    //   3821: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   3824: ldc_w 970
    //   3827: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3830: aload_1
    //   3831: getfield 459	com/tencent/mobileqq/utils/httputils/HttpMsg:rawReqHeader	Ljava/lang/String;
    //   3834: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3837: ldc_w 972
    //   3840: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3843: aload_1
    //   3844: getfield 626	com/tencent/mobileqq/utils/httputils/HttpMsg:rawRespHeader	Ljava/lang/String;
    //   3847: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3850: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3853: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3856: aload_0
    //   3857: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   3860: ifnull +17 -> 3877
    //   3863: aload 29
    //   3865: ifnull +12 -> 3877
    //   3868: aload_0
    //   3869: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   3872: aload 29
    //   3874: invokevirtual 954	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3877: lload 14
    //   3879: lload 16
    //   3881: ladd
    //   3882: lconst_0
    //   3883: lcmp
    //   3884: ifeq +20 -> 3904
    //   3887: aload_1
    //   3888: invokevirtual 321	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   3891: ldc_w 318
    //   3894: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3897: istore 24
    //   3899: iload 24
    //   3901: ifeq +3 -> 3904
    //   3904: aload 30
    //   3906: ifnull +8 -> 3914
    //   3909: aload 30
    //   3911: invokevirtual 1038	java/io/ByteArrayOutputStream:close	()V
    //   3914: aload 27
    //   3916: ifnull +8 -> 3924
    //   3919: aload 27
    //   3921: invokevirtual 1026	java/io/InputStream:close	()V
    //   3924: aload 28
    //   3926: ifnull +8 -> 3934
    //   3929: aload 28
    //   3931: invokevirtual 959	java/io/OutputStream:close	()V
    //   3934: iload 4
    //   3936: istore_3
    //   3937: aload 26
    //   3939: ifnull -2062 -> 1877
    //   3942: aload 26
    //   3944: invokevirtual 962	java/net/HttpURLConnection:disconnect	()V
    //   3947: iload 4
    //   3949: istore_3
    //   3950: goto -2073 -> 1877
    //   3953: astore 26
    //   3955: aload 26
    //   3957: invokevirtual 688	java/lang/Exception:printStackTrace	()V
    //   3960: iload 4
    //   3962: istore_3
    //   3963: goto -2086 -> 1877
    //   3966: iload 7
    //   3968: ifle +29 -> 3997
    //   3971: iload 4
    //   3973: istore 6
    //   3975: lload 16
    //   3977: lstore 18
    //   3979: iload 4
    //   3981: istore 5
    //   3983: lload 16
    //   3985: lstore 20
    //   3987: aload 31
    //   3989: aload 27
    //   3991: iconst_0
    //   3992: iload 7
    //   3994: invokevirtual 1116	java/io/ByteArrayOutputStream:write	([BII)V
    //   3997: iload 4
    //   3999: istore 6
    //   4001: lload 16
    //   4003: lstore 18
    //   4005: iload 4
    //   4007: istore 5
    //   4009: lload 16
    //   4011: lstore 20
    //   4013: aload 31
    //   4015: invokevirtual 1117	java/io/ByteArrayOutputStream:flush	()V
    //   4018: iload 4
    //   4020: istore 6
    //   4022: lload 16
    //   4024: lstore 18
    //   4026: iload 4
    //   4028: istore 5
    //   4030: lload 16
    //   4032: lstore 20
    //   4034: aload_1
    //   4035: aload 31
    //   4037: invokevirtual 1120	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   4040: invokevirtual 1103	com/tencent/mobileqq/utils/httputils/HttpMsg:setRecvData	([B)V
    //   4043: iload 4
    //   4045: istore 6
    //   4047: lload 16
    //   4049: lstore 18
    //   4051: iload 4
    //   4053: istore 5
    //   4055: lload 16
    //   4057: lstore 20
    //   4059: aload 35
    //   4061: aload_1
    //   4062: aload_1
    //   4063: invokeinterface 1106 3 0
    //   4068: goto -466 -> 3602
    //   4071: astore 33
    //   4073: iconst_1
    //   4074: istore 24
    //   4076: aload 28
    //   4078: astore 32
    //   4080: aload 31
    //   4082: astore 28
    //   4084: lload 14
    //   4086: lstore 16
    //   4088: lload 18
    //   4090: lstore 14
    //   4092: aload 29
    //   4094: astore 27
    //   4096: iload 6
    //   4098: istore 4
    //   4100: aload 33
    //   4102: astore 31
    //   4104: aload 32
    //   4106: astore 29
    //   4108: goto -2571 -> 1537
    //   4111: iload_3
    //   4112: istore 5
    //   4114: lload 16
    //   4116: lstore 20
    //   4118: iload_3
    //   4119: istore 4
    //   4121: lload 16
    //   4123: lstore 18
    //   4125: aload 31
    //   4127: astore 27
    //   4129: aload_1
    //   4130: getfield 265	com/tencent/mobileqq/utils/httputils/HttpMsg:isRequestInCmwap	Z
    //   4133: ifeq +327 -> 4460
    //   4136: iload_3
    //   4137: istore 5
    //   4139: lload 16
    //   4141: lstore 20
    //   4143: iload_3
    //   4144: istore 4
    //   4146: lload 16
    //   4148: lstore 18
    //   4150: aload 31
    //   4152: astore 27
    //   4154: aload_1
    //   4155: getfield 281	com/tencent/mobileqq/utils/httputils/HttpMsg:mCmwapConnectionType	I
    //   4158: ifeq +302 -> 4460
    //   4161: iload_3
    //   4162: istore 5
    //   4164: lload 16
    //   4166: lstore 20
    //   4168: iload_3
    //   4169: istore 4
    //   4171: lload 16
    //   4173: lstore 18
    //   4175: aload 31
    //   4177: astore 27
    //   4179: aload_1
    //   4180: getfield 278	com/tencent/mobileqq/utils/httputils/HttpMsg:isCmwapRetried	Z
    //   4183: ifne +277 -> 4460
    //   4186: iload_3
    //   4187: istore 5
    //   4189: lload 16
    //   4191: lstore 20
    //   4193: iload_3
    //   4194: istore 4
    //   4196: lload 16
    //   4198: lstore 18
    //   4200: aload 31
    //   4202: astore 27
    //   4204: aload_0
    //   4205: aload_1
    //   4206: ldc_w 1121
    //   4209: ldc_w 1123
    //   4212: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   4215: iload_3
    //   4216: istore 5
    //   4218: lload 16
    //   4220: lstore 20
    //   4222: iload_3
    //   4223: istore 4
    //   4225: lload 16
    //   4227: lstore 18
    //   4229: aload 31
    //   4231: astore 27
    //   4233: aload_1
    //   4234: iconst_1
    //   4235: putfield 278	com/tencent/mobileqq/utils/httputils/HttpMsg:isCmwapRetried	Z
    //   4238: iload_3
    //   4239: istore 5
    //   4241: lload 16
    //   4243: lstore 20
    //   4245: iload_3
    //   4246: istore 4
    //   4248: lload 16
    //   4250: lstore 18
    //   4252: aload 31
    //   4254: astore 27
    //   4256: aload_0
    //   4257: aload_1
    //   4258: aload_2
    //   4259: invokevirtual 1125	com/tencent/mobileqq/transfile/HttpCommunicator:run	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler;)V
    //   4262: iload_3
    //   4263: sipush 200
    //   4266: if_icmpeq +10 -> 4276
    //   4269: iload_3
    //   4270: sipush 206
    //   4273: if_icmpne +31 -> 4304
    //   4276: aload_0
    //   4277: aload_1
    //   4278: ldc_w 936
    //   4281: new 334	java/lang/StringBuilder
    //   4284: dup
    //   4285: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   4288: ldc_w 938
    //   4291: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4294: iconst_0
    //   4295: invokevirtual 344	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4298: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4301: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   4304: aload_2
    //   4305: ifnull +13 -> 4318
    //   4308: aload_2
    //   4309: getfield 557	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4312: invokevirtual 178	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   4315: ifne +47 -> 4362
    //   4318: aload_0
    //   4319: aload_1
    //   4320: ldc_w 940
    //   4323: new 334	java/lang/StringBuilder
    //   4326: dup
    //   4327: invokespecial 335	java/lang/StringBuilder:<init>	()V
    //   4330: ldc_w 942
    //   4333: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4336: aload_1
    //   4337: invokevirtual 945	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   4340: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4343: ldc_w 947
    //   4346: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4349: aload_1
    //   4350: invokevirtual 950	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   4353: invokevirtual 341	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4356: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4359: invokevirtual 371	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   4362: aload_0
    //   4363: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   4366: ifnull +17 -> 4383
    //   4369: aload 29
    //   4371: ifnull +12 -> 4383
    //   4374: aload_0
    //   4375: getfield 76	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   4378: aload 29
    //   4380: invokevirtual 954	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   4383: lload 14
    //   4385: lconst_0
    //   4386: ladd
    //   4387: lconst_0
    //   4388: lcmp
    //   4389: ifeq +20 -> 4409
    //   4392: aload_1
    //   4393: invokevirtual 321	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   4396: ldc_w 318
    //   4399: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4402: istore 24
    //   4404: iload 24
    //   4406: ifeq +3 -> 4409
    //   4409: iconst_0
    //   4410: ifeq +11 -> 4421
    //   4413: new 956	java/lang/NullPointerException
    //   4416: dup
    //   4417: invokespecial 957	java/lang/NullPointerException:<init>	()V
    //   4420: athrow
    //   4421: iconst_0
    //   4422: ifeq +11 -> 4433
    //   4425: new 956	java/lang/NullPointerException
    //   4428: dup
    //   4429: invokespecial 957	java/lang/NullPointerException:<init>	()V
    //   4432: athrow
    //   4433: aload 28
    //   4435: ifnull +8 -> 4443
    //   4438: aload 28
    //   4440: invokevirtual 959	java/io/OutputStream:close	()V
    //   4443: aload 26
    //   4445: ifnull -3807 -> 638
    //   4448: aload 26
    //   4450: invokevirtual 962	java/net/HttpURLConnection:disconnect	()V
    //   4453: return
    //   4454: astore_1
    //   4455: aload_1
    //   4456: invokevirtual 688	java/lang/Exception:printStackTrace	()V
    //   4459: return
    //   4460: iconst_1
    //   4461: istore 6
    //   4463: iload_3
    //   4464: istore 5
    //   4466: lload 16
    //   4468: lstore 20
    //   4470: aload_0
    //   4471: iload_3
    //   4472: aload 26
    //   4474: aload_1
    //   4475: invokevirtual 1127	com/tencent/mobileqq/transfile/HttpCommunicator:procBadResponse	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   4478: iconst_1
    //   4479: istore 4
    //   4481: iload 12
    //   4483: istore 5
    //   4485: aload 34
    //   4487: astore 27
    //   4489: goto -793 -> 3696
    //   4492: astore 32
    //   4494: aload 33
    //   4496: ifnull -2885 -> 1611
    //   4499: aload 33
    //   4501: invokevirtual 1026	java/io/InputStream:close	()V
    //   4504: goto -2893 -> 1611
    //   4507: astore 32
    //   4509: goto -2898 -> 1611
    //   4512: astore 31
    //   4514: aconst_null
    //   4515: astore 32
    //   4517: aload 32
    //   4519: ifnull +8 -> 4527
    //   4522: aload 32
    //   4524: invokevirtual 1026	java/io/InputStream:close	()V
    //   4527: aload 31
    //   4529: athrow
    //   4530: astore 32
    //   4532: iconst_1
    //   4533: istore 6
    //   4535: lload 16
    //   4537: lstore 18
    //   4539: aload 28
    //   4541: astore 31
    //   4543: aload 29
    //   4545: astore 28
    //   4547: aload 27
    //   4549: astore 29
    //   4551: aload 32
    //   4553: astore 27
    //   4555: iload 4
    //   4557: istore 5
    //   4559: iload_3
    //   4560: istore 4
    //   4562: iload 6
    //   4564: istore_3
    //   4565: lload 14
    //   4567: lstore 16
    //   4569: lload 18
    //   4571: lstore 14
    //   4573: goto -2591 -> 1982
    //   4576: astore 26
    //   4578: aload 26
    //   4580: invokevirtual 688	java/lang/Exception:printStackTrace	()V
    //   4583: iload 5
    //   4585: istore_3
    //   4586: goto -2709 -> 1877
    //   4589: astore_1
    //   4590: aload_1
    //   4591: invokevirtual 688	java/lang/Exception:printStackTrace	()V
    //   4594: goto -2358 -> 2236
    //   4597: aload 35
    //   4599: aload_1
    //   4600: aload_1
    //   4601: iconst_5
    //   4602: invokeinterface 530 4 0
    //   4607: pop
    //   4608: return
    //   4609: astore_1
    //   4610: goto -4004 -> 606
    //   4613: astore_1
    //   4614: goto -3996 -> 618
    //   4617: astore_1
    //   4618: goto -3990 -> 628
    //   4621: astore_1
    //   4622: goto -3511 -> 1111
    //   4625: astore_1
    //   4626: goto -3503 -> 1123
    //   4629: astore_1
    //   4630: goto -3497 -> 1133
    //   4633: astore_1
    //   4634: goto -213 -> 4421
    //   4637: astore_1
    //   4638: goto -205 -> 4433
    //   4641: astore_1
    //   4642: goto -199 -> 4443
    //   4645: astore 29
    //   4647: goto -733 -> 3914
    //   4650: astore 27
    //   4652: goto -728 -> 3924
    //   4655: astore 27
    //   4657: goto -723 -> 3934
    //   4660: astore 32
    //   4662: goto -3051 -> 1611
    //   4665: astore 32
    //   4667: goto -140 -> 4527
    //   4670: astore 27
    //   4672: goto -2831 -> 1841
    //   4675: astore 27
    //   4677: goto -2826 -> 1851
    //   4680: astore 27
    //   4682: goto -2821 -> 1861
    //   4685: astore_1
    //   4686: goto -2480 -> 2206
    //   4689: astore_1
    //   4690: goto -2474 -> 2216
    //   4693: astore_1
    //   4694: goto -2468 -> 2226
    //   4697: astore 27
    //   4699: aconst_null
    //   4700: astore 28
    //   4702: aconst_null
    //   4703: astore 26
    //   4705: iconst_m1
    //   4706: istore 4
    //   4708: iconst_0
    //   4709: istore 24
    //   4711: aconst_null
    //   4712: astore 29
    //   4714: iconst_0
    //   4715: istore_3
    //   4716: iload 7
    //   4718: istore 5
    //   4720: aload 32
    //   4722: astore 31
    //   4724: aload 33
    //   4726: astore 30
    //   4728: goto -2746 -> 1982
    //   4731: astore 27
    //   4733: aload 29
    //   4735: astore 30
    //   4737: iconst_0
    //   4738: istore 6
    //   4740: aload 28
    //   4742: astore 29
    //   4744: iload 7
    //   4746: istore 5
    //   4748: iload_3
    //   4749: istore 4
    //   4751: iload 6
    //   4753: istore_3
    //   4754: aload 32
    //   4756: astore 31
    //   4758: aload 30
    //   4760: astore 28
    //   4762: aload 33
    //   4764: astore 30
    //   4766: goto -2784 -> 1982
    //   4769: astore 30
    //   4771: aload 27
    //   4773: astore 28
    //   4775: aload 30
    //   4777: astore 27
    //   4779: iconst_0
    //   4780: istore 6
    //   4782: iload 7
    //   4784: istore 5
    //   4786: iload_3
    //   4787: istore 4
    //   4789: iload 6
    //   4791: istore_3
    //   4792: aload 32
    //   4794: astore 31
    //   4796: aload 33
    //   4798: astore 30
    //   4800: goto -2818 -> 1982
    //   4803: astore 30
    //   4805: iconst_0
    //   4806: istore 6
    //   4808: aload 27
    //   4810: astore 28
    //   4812: aload 30
    //   4814: astore 27
    //   4816: iload 7
    //   4818: istore 5
    //   4820: iload_3
    //   4821: istore 4
    //   4823: iload 6
    //   4825: istore_3
    //   4826: aload 32
    //   4828: astore 31
    //   4830: aload 33
    //   4832: astore 30
    //   4834: goto -2852 -> 1982
    //   4837: astore 30
    //   4839: iconst_0
    //   4840: istore 6
    //   4842: aload 27
    //   4844: astore 28
    //   4846: aload 30
    //   4848: astore 27
    //   4850: iload 7
    //   4852: istore 5
    //   4854: iload_3
    //   4855: istore 4
    //   4857: iload 6
    //   4859: istore_3
    //   4860: aload 32
    //   4862: astore 31
    //   4864: aload 33
    //   4866: astore 30
    //   4868: goto -2886 -> 1982
    //   4871: astore 29
    //   4873: iconst_0
    //   4874: istore 6
    //   4876: aload 27
    //   4878: astore 30
    //   4880: aload 29
    //   4882: astore 27
    //   4884: aload 28
    //   4886: astore 29
    //   4888: iload 7
    //   4890: istore 5
    //   4892: iload_3
    //   4893: istore 4
    //   4895: iload 6
    //   4897: istore_3
    //   4898: aload 32
    //   4900: astore 31
    //   4902: aload 30
    //   4904: astore 28
    //   4906: aload 33
    //   4908: astore 30
    //   4910: goto -2928 -> 1982
    //   4913: astore 27
    //   4915: iconst_0
    //   4916: istore 6
    //   4918: iload_3
    //   4919: istore 4
    //   4921: iload 6
    //   4923: istore_3
    //   4924: lload 20
    //   4926: lstore 16
    //   4928: goto -2946 -> 1982
    //   4931: astore 31
    //   4933: aload 27
    //   4935: astore 32
    //   4937: aload 31
    //   4939: astore 27
    //   4941: iconst_0
    //   4942: istore 6
    //   4944: iload 4
    //   4946: istore 5
    //   4948: iload_3
    //   4949: istore 4
    //   4951: iload 6
    //   4953: istore_3
    //   4954: aload 30
    //   4956: astore 31
    //   4958: aload 32
    //   4960: astore 30
    //   4962: goto -2980 -> 1982
    //   4965: astore 27
    //   4967: iload 7
    //   4969: istore 5
    //   4971: iload_3
    //   4972: istore 4
    //   4974: iload 6
    //   4976: istore_3
    //   4977: aload 32
    //   4979: astore 31
    //   4981: aload 33
    //   4983: astore 30
    //   4985: goto -3003 -> 1982
    //   4988: astore 31
    //   4990: goto -473 -> 4517
    //   4993: astore 31
    //   4995: aconst_null
    //   4996: astore 28
    //   4998: aconst_null
    //   4999: astore 30
    //   5001: aconst_null
    //   5002: astore 29
    //   5004: lconst_0
    //   5005: lstore 14
    //   5007: aconst_null
    //   5008: astore 27
    //   5010: iconst_0
    //   5011: istore 4
    //   5013: iconst_m1
    //   5014: istore_3
    //   5015: aconst_null
    //   5016: astore 26
    //   5018: lconst_0
    //   5019: lstore 16
    //   5021: goto -3484 -> 1537
    //   5024: astore 31
    //   5026: aconst_null
    //   5027: astore 32
    //   5029: lload 14
    //   5031: lstore 16
    //   5033: lconst_0
    //   5034: lstore 14
    //   5036: iconst_0
    //   5037: istore 4
    //   5039: aload 28
    //   5041: astore 27
    //   5043: aconst_null
    //   5044: astore 30
    //   5046: iconst_1
    //   5047: istore 24
    //   5049: aload 32
    //   5051: astore 28
    //   5053: goto -3516 -> 1537
    //   5056: astore 31
    //   5058: aconst_null
    //   5059: astore 28
    //   5061: aconst_null
    //   5062: astore 32
    //   5064: aload 27
    //   5066: astore 30
    //   5068: lload 14
    //   5070: lstore 16
    //   5072: lconst_0
    //   5073: lstore 14
    //   5075: aload 29
    //   5077: astore 27
    //   5079: iconst_0
    //   5080: istore 4
    //   5082: aload 30
    //   5084: astore 29
    //   5086: aload 32
    //   5088: astore 30
    //   5090: goto -3553 -> 1537
    //   5093: astore 31
    //   5095: aconst_null
    //   5096: astore 28
    //   5098: aconst_null
    //   5099: astore 32
    //   5101: aload 27
    //   5103: astore 30
    //   5105: lload 14
    //   5107: lstore 16
    //   5109: lconst_0
    //   5110: lstore 14
    //   5112: aload 29
    //   5114: astore 27
    //   5116: iconst_0
    //   5117: istore 4
    //   5119: aload 30
    //   5121: astore 29
    //   5123: aload 32
    //   5125: astore 30
    //   5127: goto -3590 -> 1537
    //   5130: astore 31
    //   5132: aconst_null
    //   5133: astore 28
    //   5135: aconst_null
    //   5136: astore 32
    //   5138: aload 27
    //   5140: astore 30
    //   5142: lload 14
    //   5144: lstore 16
    //   5146: lconst_0
    //   5147: lstore 14
    //   5149: iconst_0
    //   5150: istore 4
    //   5152: aload 29
    //   5154: astore 27
    //   5156: iconst_1
    //   5157: istore 24
    //   5159: aload 30
    //   5161: astore 29
    //   5163: aload 32
    //   5165: astore 30
    //   5167: goto -3630 -> 1537
    //   5170: astore 31
    //   5172: iconst_1
    //   5173: istore 24
    //   5175: aconst_null
    //   5176: astore 32
    //   5178: aconst_null
    //   5179: astore 30
    //   5181: aload 27
    //   5183: astore 29
    //   5185: lload 14
    //   5187: lstore 16
    //   5189: lconst_0
    //   5190: lstore 14
    //   5192: iconst_0
    //   5193: istore 4
    //   5195: aload 28
    //   5197: astore 27
    //   5199: aload 32
    //   5201: astore 28
    //   5203: goto -3666 -> 1537
    //   5206: astore 31
    //   5208: iconst_1
    //   5209: istore 24
    //   5211: aload 28
    //   5213: astore 32
    //   5215: aconst_null
    //   5216: astore 28
    //   5218: lload 14
    //   5220: lstore 18
    //   5222: lload 16
    //   5224: lstore 14
    //   5226: aload 29
    //   5228: astore 27
    //   5230: iconst_0
    //   5231: istore 4
    //   5233: lload 18
    //   5235: lstore 16
    //   5237: aload 32
    //   5239: astore 29
    //   5241: goto -3704 -> 1537
    //   5244: astore 31
    //   5246: aload 28
    //   5248: astore 32
    //   5250: aload 30
    //   5252: astore 28
    //   5254: iconst_1
    //   5255: istore 24
    //   5257: aload 27
    //   5259: astore 30
    //   5261: lload 14
    //   5263: lstore 18
    //   5265: lload 16
    //   5267: lstore 14
    //   5269: aload 29
    //   5271: astore 27
    //   5273: lload 18
    //   5275: lstore 16
    //   5277: aload 32
    //   5279: astore 29
    //   5281: goto -3744 -> 1537
    //   5284: astore 27
    //   5286: goto -4386 -> 900
    //   5289: iconst_0
    //   5290: istore 4
    //   5292: aconst_null
    //   5293: astore 30
    //   5295: aconst_null
    //   5296: astore 27
    //   5298: goto -1621 -> 3677
    //   5301: aload 27
    //   5303: astore 28
    //   5305: goto -4968 -> 337
    //   5308: iload 6
    //   5310: iconst_1
    //   5311: iadd
    //   5312: istore 6
    //   5314: goto -2746 -> 2568
    //   5317: iload 6
    //   5319: iconst_1
    //   5320: iadd
    //   5321: istore 6
    //   5323: goto -2602 -> 2721
    //   5326: iconst_0
    //   5327: istore 7
    //   5329: iload 8
    //   5331: istore 4
    //   5333: goto -2120 -> 3213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5336	0	this	HttpCommunicator
    //   0	5336	1	paramHttpMsg	HttpMsg
    //   0	5336	2	paramHttpCommunicatorHandler	HttpCommunicator.HttpCommunicatorHandler
    //   71	4944	3	i	int
    //   213	5119	4	j	int
    //   338	4632	5	k	int
    //   56	5266	6	m	int
    //   46	5282	7	n	int
    //   34	5296	8	i1	int
    //   22	3671	9	i2	int
    //   43	3381	10	i3	int
    //   40	3376	11	i4	int
    //   37	4445	12	i5	int
    //   2716	14	13	i6	int
    //   25	5243	14	l1	long
    //   28	5248	16	l2	long
    //   303	4971	18	l3	long
    //   342	4583	20	l4	long
    //   3279	193	22	l5	long
    //   31	5225	24	bool1	boolean
    //   440	1108	25	bool2	boolean
    //   65	3878	26	localObject1	Object
    //   3953	520	26	localException1	Exception
    //   4576	3	26	localException2	Exception
    //   4703	314	26	localObject2	Object
    //   68	4486	27	localObject3	Object
    //   4650	1	27	localIOException1	IOException
    //   4655	1	27	localIOException2	IOException
    //   4670	1	27	localIOException3	IOException
    //   4675	1	27	localIOException4	IOException
    //   4680	1	27	localIOException5	IOException
    //   4697	1	27	localObject4	Object
    //   4731	41	27	localObject5	Object
    //   4777	106	27	localObject6	Object
    //   4913	21	27	localObject7	Object
    //   4939	1	27	localObject8	Object
    //   4965	1	27	localObject9	Object
    //   5008	264	27	localObject10	Object
    //   5284	1	27	localThrowable1	Throwable
    //   5296	6	27	localObject11	Object
    //   94	5210	28	localObject12	Object
    //   62	4488	29	localObject13	Object
    //   4645	1	29	localIOException6	IOException
    //   4712	31	29	localObject14	Object
    //   4871	10	29	localObject15	Object
    //   4886	394	29	localObject16	Object
    //   16	4749	30	localObject17	Object
    //   4769	7	30	localObject18	Object
    //   4798	1	30	localThrowable2	Throwable
    //   4803	10	30	localObject19	Object
    //   4832	1	30	localThrowable3	Throwable
    //   4837	10	30	localObject20	Object
    //   4866	428	30	localObject21	Object
    //   13	1473	31	localObject22	Object
    //   1500	444	31	localThrowable4	Throwable
    //   1968	2285	31	localObject23	Object
    //   4512	16	31	localObject24	Object
    //   4541	360	31	localObject25	Object
    //   4931	7	31	localObject26	Object
    //   4956	24	31	localObject27	Object
    //   4988	1	31	localObject28	Object
    //   4993	1	31	localThrowable5	Throwable
    //   5024	1	31	localThrowable6	Throwable
    //   5056	1	31	localThrowable7	Throwable
    //   5093	1	31	localThrowable8	Throwable
    //   5130	1	31	localThrowable9	Throwable
    //   5170	1	31	localThrowable10	Throwable
    //   5206	1	31	localThrowable11	Throwable
    //   5244	1	31	localThrowable12	Throwable
    //   19	4086	32	localObject29	Object
    //   4492	1	32	localException3	Exception
    //   4507	1	32	localIOException7	IOException
    //   4515	8	32	localObject30	Object
    //   4530	22	32	localObject31	Object
    //   4660	1	32	localIOException8	IOException
    //   4665	234	32	localIOException9	IOException
    //   4935	343	32	localObject32	Object
    //   7	1579	33	localObject33	Object
    //   1958	21	33	localObject34	Object
    //   2540	1102	33	localObject35	Object
    //   4071	911	33	localThrowable13	Throwable
    //   10	4476	34	localObject36	Object
    //   4	4594	35	localIHttpCommunicatorListener	IHttpCommunicatorListener
    //   173	2435	36	localObject37	Object
    // Exception table:
    //   from	to	target	type
    //   547	554	639	java/lang/Exception
    //   559	568	639	java/lang/Exception
    //   577	589	639	java/lang/Exception
    //   598	606	639	java/lang/Exception
    //   610	618	639	java/lang/Exception
    //   623	628	639	java/lang/Exception
    //   633	638	639	java/lang/Exception
    //   1052	1059	1144	java/lang/Exception
    //   1064	1073	1144	java/lang/Exception
    //   1082	1094	1144	java/lang/Exception
    //   1103	1111	1144	java/lang/Exception
    //   1115	1123	1144	java/lang/Exception
    //   1128	1133	1144	java/lang/Exception
    //   1138	1143	1144	java/lang/Exception
    //   355	361	1500	java/lang/Throwable
    //   379	385	1500	java/lang/Throwable
    //   403	411	1500	java/lang/Throwable
    //   433	442	1500	java/lang/Throwable
    //   663	670	1500	java/lang/Throwable
    //   693	702	1500	java/lang/Throwable
    //   720	748	1500	java/lang/Throwable
    //   786	830	1500	java/lang/Throwable
    //   848	858	1500	java/lang/Throwable
    //   918	925	1500	java/lang/Throwable
    //   943	952	1500	java/lang/Throwable
    //   1168	1175	1500	java/lang/Throwable
    //   1193	1202	1500	java/lang/Throwable
    //   1220	1227	1500	java/lang/Throwable
    //   1245	1256	1500	java/lang/Throwable
    //   1274	1280	1500	java/lang/Throwable
    //   1298	1305	1500	java/lang/Throwable
    //   1323	1330	1500	java/lang/Throwable
    //   1348	1356	1500	java/lang/Throwable
    //   1374	1383	1500	java/lang/Throwable
    //   1401	1430	1500	java/lang/Throwable
    //   1448	1455	1500	java/lang/Throwable
    //   1489	1500	1500	java/lang/Throwable
    //   1947	1958	1500	java/lang/Throwable
    //   2257	2264	1500	java/lang/Throwable
    //   2296	2303	1500	java/lang/Throwable
    //   2331	2338	1500	java/lang/Throwable
    //   2356	2364	1500	java/lang/Throwable
    //   2382	2390	1500	java/lang/Throwable
    //   2411	2420	1500	java/lang/Throwable
    //   2438	2447	1500	java/lang/Throwable
    //   2465	2483	1500	java/lang/Throwable
    //   2509	2518	1500	java/lang/Throwable
    //   2536	2542	1500	java/lang/Throwable
    //   2560	2565	1500	java/lang/Throwable
    //   2605	2613	1500	java/lang/Throwable
    //   2631	2640	1500	java/lang/Throwable
    //   2661	2668	1500	java/lang/Throwable
    //   2689	2695	1500	java/lang/Throwable
    //   2713	2718	1500	java/lang/Throwable
    //   2762	2772	1500	java/lang/Throwable
    //   2796	2839	1500	java/lang/Throwable
    //   2857	2866	1500	java/lang/Throwable
    //   2884	2897	1500	java/lang/Throwable
    //   2915	2925	1500	java/lang/Throwable
    //   2943	2974	1500	java/lang/Throwable
    //   2992	3001	1500	java/lang/Throwable
    //   3019	3031	1500	java/lang/Throwable
    //   3049	3062	1500	java/lang/Throwable
    //   3087	3094	1500	java/lang/Throwable
    //   4129	4136	1500	java/lang/Throwable
    //   4154	4161	1500	java/lang/Throwable
    //   4179	4186	1500	java/lang/Throwable
    //   4204	4215	1500	java/lang/Throwable
    //   4233	4238	1500	java/lang/Throwable
    //   4256	4262	1500	java/lang/Throwable
    //   4470	4478	1500	java/lang/Throwable
    //   1905	1914	1915	java/lang/Exception
    //   4597	4608	1915	java/lang/Exception
    //   355	361	1958	finally
    //   379	385	1958	finally
    //   403	411	1958	finally
    //   433	442	1958	finally
    //   663	670	1958	finally
    //   693	702	1958	finally
    //   720	748	1958	finally
    //   786	830	1958	finally
    //   848	858	1958	finally
    //   879	884	1958	finally
    //   895	900	1958	finally
    //   918	925	1958	finally
    //   943	952	1958	finally
    //   1168	1175	1958	finally
    //   1193	1202	1958	finally
    //   1220	1227	1958	finally
    //   1245	1256	1958	finally
    //   1274	1280	1958	finally
    //   1298	1305	1958	finally
    //   1323	1330	1958	finally
    //   1348	1356	1958	finally
    //   1374	1383	1958	finally
    //   1401	1430	1958	finally
    //   1448	1455	1958	finally
    //   1489	1500	1958	finally
    //   1947	1958	1958	finally
    //   2257	2264	1958	finally
    //   2296	2303	1958	finally
    //   2331	2338	1958	finally
    //   2356	2364	1958	finally
    //   2382	2390	1958	finally
    //   2411	2420	1958	finally
    //   2438	2447	1958	finally
    //   2465	2483	1958	finally
    //   2509	2518	1958	finally
    //   2536	2542	1958	finally
    //   2560	2565	1958	finally
    //   2605	2613	1958	finally
    //   2631	2640	1958	finally
    //   2661	2668	1958	finally
    //   2689	2695	1958	finally
    //   2713	2718	1958	finally
    //   2762	2772	1958	finally
    //   2796	2839	1958	finally
    //   2857	2866	1958	finally
    //   2884	2897	1958	finally
    //   2915	2925	1958	finally
    //   2943	2974	1958	finally
    //   2992	3001	1958	finally
    //   3019	3031	1958	finally
    //   3049	3062	1958	finally
    //   3087	3094	1958	finally
    //   3105	3110	1958	finally
    //   3121	3125	1958	finally
    //   3136	3141	1958	finally
    //   3152	3161	1958	finally
    //   4129	4136	1958	finally
    //   4154	4161	1958	finally
    //   4179	4186	1958	finally
    //   4204	4215	1958	finally
    //   4233	4238	1958	finally
    //   4256	4262	1958	finally
    //   3856	3863	3953	java/lang/Exception
    //   3868	3877	3953	java/lang/Exception
    //   3887	3899	3953	java/lang/Exception
    //   3909	3914	3953	java/lang/Exception
    //   3919	3924	3953	java/lang/Exception
    //   3929	3934	3953	java/lang/Exception
    //   3942	3947	3953	java/lang/Exception
    //   3177	3184	4071	java/lang/Throwable
    //   3200	3210	4071	java/lang/Throwable
    //   3229	3246	4071	java/lang/Throwable
    //   3267	3273	4071	java/lang/Throwable
    //   3323	3331	4071	java/lang/Throwable
    //   3347	3354	4071	java/lang/Throwable
    //   3370	3376	4071	java/lang/Throwable
    //   3392	3401	4071	java/lang/Throwable
    //   3431	3438	4071	java/lang/Throwable
    //   3457	3464	4071	java/lang/Throwable
    //   3494	3501	4071	java/lang/Throwable
    //   3522	3528	4071	java/lang/Throwable
    //   3544	3555	4071	java/lang/Throwable
    //   3571	3577	4071	java/lang/Throwable
    //   3593	3602	4071	java/lang/Throwable
    //   3618	3625	4071	java/lang/Throwable
    //   3641	3648	4071	java/lang/Throwable
    //   3664	3669	4071	java/lang/Throwable
    //   3987	3997	4071	java/lang/Throwable
    //   4013	4018	4071	java/lang/Throwable
    //   4034	4043	4071	java/lang/Throwable
    //   4059	4068	4071	java/lang/Throwable
    //   4362	4369	4454	java/lang/Exception
    //   4374	4383	4454	java/lang/Exception
    //   4392	4404	4454	java/lang/Exception
    //   4413	4421	4454	java/lang/Exception
    //   4425	4433	4454	java/lang/Exception
    //   4438	4443	4454	java/lang/Exception
    //   4448	4453	4454	java/lang/Exception
    //   1560	1567	4492	java/lang/Exception
    //   1571	1578	4492	java/lang/Exception
    //   1587	1596	4492	java/lang/Exception
    //   4499	4504	4507	java/io/IOException
    //   1560	1567	4512	finally
    //   1540	1547	4530	finally
    //   1606	1611	4530	finally
    //   1611	1623	4530	finally
    //   4499	4504	4530	finally
    //   4522	4527	4530	finally
    //   4527	4530	4530	finally
    //   1783	1790	4576	java/lang/Exception
    //   1795	1804	4576	java/lang/Exception
    //   1814	1826	4576	java/lang/Exception
    //   1836	1841	4576	java/lang/Exception
    //   1846	1851	4576	java/lang/Exception
    //   1856	1861	4576	java/lang/Exception
    //   1869	1874	4576	java/lang/Exception
    //   2148	2155	4589	java/lang/Exception
    //   2160	2169	4589	java/lang/Exception
    //   2179	2191	4589	java/lang/Exception
    //   2201	2206	4589	java/lang/Exception
    //   2211	2216	4589	java/lang/Exception
    //   2221	2226	4589	java/lang/Exception
    //   2231	2236	4589	java/lang/Exception
    //   598	606	4609	java/io/IOException
    //   610	618	4613	java/io/IOException
    //   623	628	4617	java/io/IOException
    //   1103	1111	4621	java/io/IOException
    //   1115	1123	4625	java/io/IOException
    //   1128	1133	4629	java/io/IOException
    //   4413	4421	4633	java/io/IOException
    //   4425	4433	4637	java/io/IOException
    //   4438	4443	4641	java/io/IOException
    //   3909	3914	4645	java/io/IOException
    //   3919	3924	4650	java/io/IOException
    //   3929	3934	4655	java/io/IOException
    //   1606	1611	4660	java/io/IOException
    //   4522	4527	4665	java/io/IOException
    //   1836	1841	4670	java/io/IOException
    //   1846	1851	4675	java/io/IOException
    //   1856	1861	4680	java/io/IOException
    //   2201	2206	4685	java/io/IOException
    //   2211	2216	4689	java/io/IOException
    //   2221	2226	4693	java/io/IOException
    //   48	55	4697	finally
    //   182	212	4731	finally
    //   215	255	4731	finally
    //   270	280	4731	finally
    //   280	291	4731	finally
    //   291	310	4731	finally
    //   72	96	4769	finally
    //   100	124	4803	finally
    //   127	156	4837	finally
    //   156	182	4871	finally
    //   3177	3184	4913	finally
    //   3200	3210	4913	finally
    //   3229	3246	4913	finally
    //   3267	3273	4913	finally
    //   3323	3331	4913	finally
    //   3347	3354	4913	finally
    //   3370	3376	4913	finally
    //   3392	3401	4913	finally
    //   3431	3438	4913	finally
    //   3457	3464	4913	finally
    //   3494	3501	4913	finally
    //   3522	3528	4913	finally
    //   3544	3555	4913	finally
    //   3571	3577	4913	finally
    //   3593	3602	4913	finally
    //   3618	3625	4913	finally
    //   3641	3648	4913	finally
    //   3664	3669	4913	finally
    //   3987	3997	4913	finally
    //   4013	4018	4913	finally
    //   4034	4043	4913	finally
    //   4059	4068	4913	finally
    //   3677	3688	4931	finally
    //   4470	4478	4965	finally
    //   1571	1578	4988	finally
    //   1587	1596	4988	finally
    //   48	55	4993	java/lang/Throwable
    //   182	212	5024	java/lang/Throwable
    //   215	255	5024	java/lang/Throwable
    //   270	280	5024	java/lang/Throwable
    //   280	291	5024	java/lang/Throwable
    //   291	310	5024	java/lang/Throwable
    //   72	96	5056	java/lang/Throwable
    //   100	124	5093	java/lang/Throwable
    //   127	156	5130	java/lang/Throwable
    //   156	182	5170	java/lang/Throwable
    //   3105	3110	5206	java/lang/Throwable
    //   3121	3125	5206	java/lang/Throwable
    //   3136	3141	5206	java/lang/Throwable
    //   3152	3161	5206	java/lang/Throwable
    //   3677	3688	5244	java/lang/Throwable
    //   879	884	5284	java/lang/Throwable
    //   895	900	5284	java/lang/Throwable
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
        paramHttpURLConnection = getServerReason("Q", -9531L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpCommunicator
 * JD-Core Version:    0.7.0.1
 */