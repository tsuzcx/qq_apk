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
    int i;
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
      if ((this.mHttpHandlers != null) && (this.mHttpHandlers.length != 0))
      {
        if (this.mConcurrentRunningMsgs > 0) {
          return false;
        }
        HttpCommunicator.HttpCommunicatorHandler[] arrayOfHttpCommunicatorHandler = this.mHttpHandlers;
        int j = arrayOfHttpCommunicatorHandler.length;
        i = 0;
        if (i < j)
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
            j = arrayOfHttpCommunicatorHandler.length;
            i = 0;
            while (i < j)
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
      }
      else
      {
        return false;
      }
    }
  }
  
  private HttpURLConnection getConnection(HttpMsg paramHttpMsg)
  {
    Object localObject1 = paramHttpMsg.getUrl();
    Object localObject2 = (String)paramHttpMsg.requestPropertys.remove("mType");
    if (localObject2 != null) {
      localObject1 = MsfSdkUtils.insertMtype((String)localObject2, (String)localObject1);
    } else {
      localObject1 = MsfSdkUtils.insertMtype("Other", (String)localObject1);
    }
    String str1 = android.net.Proxy.getDefaultHost();
    int i1 = android.net.Proxy.getDefaultPort();
    int i = 0;
    int j = 0;
    Object localObject3 = null;
    localObject2 = localObject1;
    while ((i == 0) && (j < 2))
    {
      Object localObject4 = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
      i = -1;
      if (localObject4 != null)
      {
        i = ((NetworkInfo)localObject4).getType();
        localObject1 = ((NetworkInfo)localObject4).getExtraInfo();
      }
      else
      {
        localObject1 = null;
      }
      localObject3 = PkgTools.getApnType((String)localObject1);
      paramHttpMsg.isRequestInCmwap = PkgTools.APN_TYPE_CMWAP.equals(localObject3);
      if (!((String)localObject3).equals(this.lastApn)) {
        if ((i != 1) && (!((String)localObject3).equals(PkgTools.APN_TYPE_CMWAP))) {
          this.forceDirect = true;
        } else {
          this.forceDirect = false;
        }
      }
      if ((i == 1) && (("10.0.0.172".equals(str1)) || ("10.0.0.200".equals(str1)))) {
        this.forceDirect = true;
      }
      int k;
      if ((str1 != null) && (i1 > 0)) {
        k = 1;
      } else {
        k = 0;
      }
      if ((!this.forceDirect) && (k != 0))
      {
        if ((!((String)localObject3).equals(PkgTools.APN_TYPE_CMWAP)) && (!((String)localObject3).equals(PkgTools.APN_TYPE_UNIWAP)) && (!((String)localObject3).equals(PkgTools.APN_TYPE_3GWAP))) {
          if (((String)localObject3).equals(PkgTools.APN_TYPE_CTWAP)) {
            localObject1 = PkgTools.getConnectionWithDefaultProxy((String)localObject2, str1, i1);
          } else {
            localObject1 = PkgTools.getConnectionWithDefaultProxy((String)localObject2, str1, i1);
          }
        }
        for (;;)
        {
          m = 1;
          break label432;
          if (!paramHttpMsg.isCmwapRetried)
          {
            m = paramHttpMsg.mCmwapConnectionType;
            if (m != 1)
            {
              if (m != 2) {
                localObject1 = PkgTools.getConnectionWithXOnlineHost((String)localObject2, str1, i1);
              } else {
                localObject1 = PkgTools.getConnectionWithDefaultProxy((String)localObject2, str1, i1);
              }
            }
            else
            {
              localObject1 = (HttpURLConnection)new URL((String)localObject2).openConnection(java.net.Proxy.NO_PROXY);
              break;
            }
          }
          else
          {
            localObject1 = PkgTools.getConnectionWithXOnlineHost((String)localObject2, str1, i1);
          }
        }
      }
      localObject1 = (HttpURLConnection)new URL((String)localObject2).openConnection();
      int m = 0;
      label432:
      httpsSSLProcess((HttpURLConnection)localObject1, paramHttpMsg);
      paramHttpMsg.netType = i;
      int i2 = NetworkCenter.getInstance().getNetType();
      int n;
      if (paramHttpMsg.timeoutParam == null)
      {
        localObject5 = RichMediaStrategy.getPolicy(i2);
        n = ((RichMediaStrategy.NetPolicy)localObject5).getConnectTimeout();
        if ("POST".equals(paramHttpMsg.getRequestMethod())) {
          i = 89500;
        } else {
          i = ((RichMediaStrategy.NetPolicy)localObject5).getReadTimeout();
        }
      }
      else
      {
        n = paramHttpMsg.timeoutParam.getConnectTimeout(i2);
        i = paramHttpMsg.timeoutParam.getReadTimeout(i2);
      }
      ((HttpURLConnection)localObject1).setConnectTimeout(n);
      ((HttpURLConnection)localObject1).setReadTimeout(i);
      Object localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("getConnection type:");
      ((StringBuilder)localObject5).append(i2);
      ((StringBuilder)localObject5).append(" activeNetworkInfo: ");
      ((StringBuilder)localObject5).append(localObject4);
      ((StringBuilder)localObject5).append(" defaultHost:");
      ((StringBuilder)localObject5).append(str1);
      ((StringBuilder)localObject5).append(" defaultPort: ");
      ((StringBuilder)localObject5).append(i1);
      ((StringBuilder)localObject5).append(" last apnType:");
      ((StringBuilder)localObject5).append(this.lastApn);
      ((StringBuilder)localObject5).append(" forceDirect:");
      ((StringBuilder)localObject5).append(this.forceDirect);
      ((StringBuilder)localObject5).append(",connectTimeOut:");
      ((StringBuilder)localObject5).append(n);
      ((StringBuilder)localObject5).append(",readTimeout:");
      ((StringBuilder)localObject5).append(i);
      logHttpCommunicator(paramHttpMsg, "gettingConn", ((StringBuilder)localObject5).toString());
      ((HttpURLConnection)localObject1).setInstanceFollowRedirects(false);
      localObject4 = paramHttpMsg.requestPropertys.entrySet().iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (Map.Entry)((Iterator)localObject4).next();
        ((HttpURLConnection)localObject1).setRequestProperty((String)((Map.Entry)localObject5).getKey(), (String)((Map.Entry)localObject5).getValue());
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
      catch (AssertionError localAssertionError)
      {
        String str2 = localAssertionError.getMessage();
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("assertion:");
          ((StringBuilder)localObject5).append(str2);
          QLog.d("Q.richmedia.HttpCommunicator", 2, ((StringBuilder)localObject5).toString());
        }
        if (k != 0)
        {
          if ((m != 0) && (k != 0)) {}
          for (this.forceDirect = true;; this.forceDirect = false)
          {
            i = 0;
            break label822;
            if ((k == 0) || (m != 0)) {
              break;
            }
          }
        }
        paramHttpMsg = new StringBuilder();
        paramHttpMsg.append("AssertionError : ");
        paramHttpMsg.append(str2);
        throw new SocketException(paramHttpMsg.toString());
      }
      catch (Exception localException)
      {
        label822:
        if (k == 0) {
          break label1017;
        }
      }
      if ((m != 0) && (k != 0))
      {
        this.forceDirect = true;
      }
      else
      {
        if ((k == 0) || (m != 0)) {
          break label1014;
        }
        this.forceDirect = false;
      }
      i = 0;
      j += 1;
      this.lastApn = ((String)localObject3);
      localObject3 = localObject1;
      continue;
      label1014:
      throw localException;
      label1017:
      throw localException;
    }
    return localObject3;
  }
  
  public static String getHttpDataReason(int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("H_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  public static String getServerReason(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
  
  private void httpsSSLProcess(HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    if ((paramHttpMsg.mIsHttps) && ((paramHttpURLConnection instanceof HttpsURLConnection)))
    {
      paramHttpURLConnection = (HttpsURLConnection)paramHttpURLConnection;
      String str = paramHttpMsg.mReqHost;
      HttpCommunicator.2 local2 = new HttpCommunicator.2(this, str, paramHttpMsg);
      if (paramHttpMsg.mIsHostIP)
      {
        paramHttpURLConnection.setRequestProperty("host", str);
        paramHttpURLConnection.setSSLSocketFactory(new SniSSLSocketFactory(str, local2));
        paramHttpURLConnection.setHostnameVerifier(local2);
        return;
      }
      paramHttpURLConnection.setRequestProperty("host", str);
      paramHttpURLConnection.setHostnameVerifier(local2);
    }
  }
  
  private void statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msg statuschanged: ");
      localStringBuilder.append(paramInt);
      QLog.d("SSCM", 2, localStringBuilder.toString());
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
    if (!paramHttpMsg.mIsCancel.get())
    {
      if ((paramHttpCommunicatorHandler != null) && (paramHttpCommunicatorHandler.forceFinish.get())) {
        throw new RuntimeException("thread should close");
      }
      if (!paramHttpMsg.mIsPreempted.get()) {
        return;
      }
      logHttpCommunicator(paramHttpMsg, "interrupt", "preempted");
      throw new IOException("preempted by higher msg");
    }
    throw new IOException("request cancelled");
  }
  
  public void close()
  {
    this.mTimeoutCheckHandler.post(new HttpCommunicator.3(this));
  }
  
  public void close_inter()
  {
    synchronized (this.locker)
    {
      long l = System.currentTimeMillis();
      Object localObject2;
      for (;;)
      {
        localObject2 = this.mSendQueue.getMaxPriortyMsg(true);
        if (localObject2 == null) {
          break;
        }
        if ((localObject2 != null) && (((HttpMsg)localObject2).getProcessor() != null))
        {
          ((HttpMsg)localObject2).setHttpErrorCode(9366, -1, "httpcommunicator_close");
          ((HttpMsg)localObject2).getProcessor().handleError((HttpMsg)localObject2, (HttpMsg)localObject2);
        }
      }
      this.mSendQueue.clearMsgs();
      if (this.mHttpHandlers != null)
      {
        localObject2 = this.mHttpHandlers;
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          localObject2[i].sendEmptyMessage(1);
          i += 1;
        }
      }
      this.mHttpHandlers = null;
      this.mConcurrentRunningMsgs = 0;
      this.mConcurrentLimit = 0;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("HttpCommunicator close_inter.elapse:");
        ((StringBuilder)localObject2).append(System.currentTimeMillis() - l);
        QLog.d("Q.richmedia.HttpCommunicator", 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  void copyRespHeader(int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    if (paramHttpURLConnection != null)
    {
      if (paramHttpMsg == null) {
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
      if (str != null)
      {
        int i = str.lastIndexOf("/");
        try
        {
          paramHttpMsg.totalLen = Long.valueOf(str.substring(i + 1)).longValue();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        paramHttpMsg.totalBlockLen = paramHttpURLConnection.getContentLength();
      }
      else
      {
        paramHttpMsg.totalLen = paramHttpURLConnection.getContentLength();
        paramHttpMsg.totalBlockLen = paramHttpMsg.totalLen;
      }
      paramHttpURLConnection = new StringBuilder();
      paramHttpURLConnection.append("resultCode:");
      paramHttpURLConnection.append(paramInt);
      paramHttpURLConnection.append(" totalLen:");
      paramHttpURLConnection.append(paramHttpMsg.totalLen);
      paramHttpURLConnection.append(",totalBlockLen:");
      paramHttpURLConnection.append(paramHttpMsg.totalBlockLen);
      logHttpCommunicator(paramHttpMsg, "copyRespHeader", paramHttpURLConnection.toString());
    }
  }
  
  public void disPatchMsg(String paramString)
  {
    if (this.bDispose) {
      return;
    }
    int i;
    label359:
    synchronized (this.locker)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("queueSize:");
        ((StringBuilder)localObject2).append(this.mSendQueue.getQueueMsgNums());
        ((StringBuilder)localObject2).append(" mConcurrentRunningMsgs:");
        ((StringBuilder)localObject2).append(this.mConcurrentRunningMsgs);
        ((StringBuilder)localObject2).append(" mConcurrentLimit:");
        ((StringBuilder)localObject2).append(this.mConcurrentLimit);
        ((StringBuilder)localObject2).append(" reason:");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(" tid:");
        ((StringBuilder)localObject2).append(Thread.currentThread().getId());
        QLog.d("Q.richmedia.HttpCommunicator", 2, ((StringBuilder)localObject2).toString());
      }
      if (this.mSendQueue.getQueueMsgNums() == 0) {
        return;
      }
      if (this.mConcurrentRunningMsgs < this.mConcurrentLimit)
      {
        paramString = this.mSendQueue;
        i = 0;
        paramString = paramString.getMaxPriortyMsg(false);
        if (paramString != null)
        {
          localObject2 = this.mHttpHandlers;
          int j = localObject2.length;
          if (i < j)
          {
            Object localObject3 = localObject2[i];
            HttpMsg localHttpMsg = localObject3.curReq;
            if (!localObject3.isProcReq.get())
            {
              this.mSendQueue.removeHttpMsg(paramString);
              paramString.refresh();
              localObject3.isProcReq.set(true);
              localObject3.curReq = paramString;
              localObject3.sendRequestToProc(paramString);
              this.mConcurrentRunningMsgs += 1;
              paramString.inQueueCost = (SystemClock.uptimeMillis() - paramString.inQueueStartTime);
              if (QLog.isColorLevel()) {
                logHttpCommunicator(paramString, "attach", "");
              }
            }
            else
            {
              if ((!this.mPreemptEnabled.get()) || (!localObject3.isProcReq.get()) || (localHttpMsg == null) || (localHttpMsg.getPriority() <= paramString.getPriority())) {
                break label359;
              }
              localObject3.interruptCurrentMsg();
            }
          }
        }
      }
      return;
    }
  }
  
  public String getFullQueue()
  {
    PriorityQueue localPriorityQueue = this.mSendQueue;
    if (localPriorityQueue != null) {
      return localPriorityQueue.getFullSendQueue();
    }
    return "";
  }
  
  Exception getInjectException(int paramInt)
  {
    switch (paramInt % 10)
    {
    default: 
      return new Exception("inject Exception");
    case 9: 
      return new IOException("content-length zero");
    case 8: 
      return new IOException("HttpCommunicator closed or msg caceled!");
    case 7: 
      return new IOException("preempted by higher msg");
    case 6: 
      return new IOException("inject IOException");
    case 5: 
      return new IllegalStateException("inject IllegalStateException");
    case 4: 
      return new IllegalArgumentException("inject IllegalArgumentException");
    case 3: 
      return new NoRouteToHostException("inject NoRouteToHostException");
    case 2: 
      return new ConnectException("inject ConnectException");
    case 1: 
      return new PortUnreachableException("inject PortUnreachableException");
    }
    return new SocketTimeoutException("inject sockettimeout");
  }
  
  int getInjectionRespCode(int paramInt)
  {
    int i = paramInt % 5;
    paramInt = 404;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return 404;
            }
            return 400;
          }
          return 501;
        }
        return 302;
      }
      paramInt = 416;
    }
    return paramInt;
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
    if ((paramHttpMsg != null) && (paramHttpCommunicatorHandler != null)) {
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
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "onResponseTimeout", paramHttpMsg);
        }
      }
    }
  }
  
  void procBadResponse(int paramInt, HttpURLConnection paramHttpURLConnection, HttpMsg paramHttpMsg)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Response code: ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).toString();
    localObject = paramHttpURLConnection.getHeaderField("X-ErrNo");
    if ((localObject != null) && (!((String)localObject).equals("")))
    {
      try
      {
        l = Long.parseLong((String)localObject);
      }
      catch (Exception paramHttpURLConnection)
      {
        paramHttpURLConnection.printStackTrace();
        break label110;
      }
    }
    else
    {
      paramHttpURLConnection = paramHttpURLConnection.getHeaderField("User-ReturnCode");
      if ((paramHttpURLConnection != null) && (!paramHttpURLConnection.equals(""))) {
        try
        {
          l = Long.parseLong(paramHttpURLConnection);
        }
        catch (Exception paramHttpURLConnection)
        {
          paramHttpURLConnection.printStackTrace();
        }
      }
    }
    label110:
    long l = 0L;
    paramHttpURLConnection = getHttpDataReason(paramInt, l);
    paramHttpMsg.setResponseProperty(HttpMsg.Param_Reason, paramHttpURLConnection);
    paramHttpMsg.setHttpErrorCode(-9527, paramInt, paramHttpURLConnection);
  }
  
  public void replaceNewThread(HttpCommunicator.HttpCommunicatorHandler paramHttpCommunicatorHandler)
  {
    if (this.bDispose) {
      return;
    }
    if (paramHttpCommunicatorHandler == null) {
      return;
    }
    paramHttpCommunicatorHandler.forceFinish.set(true);
    int i = paramHttpCommunicatorHandler.index;
    if ((i >= 0) && (i < 4))
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("httpcommunicator_norm_new_");
      ((StringBuilder)???).append(i);
      ??? = new HandlerThread(((StringBuilder)???).toString(), 5);
      ((HandlerThread)???).start();
      HttpCommunicator.HttpCommunicatorHandler localHttpCommunicatorHandler = new HttpCommunicator.HttpCommunicatorHandler(this, ((HandlerThread)???).getLooper());
      localHttpCommunicatorHandler.index = i;
      synchronized (this.locker)
      {
        this.mHttpHandlers[i] = localHttpCommunicatorHandler;
        if (paramHttpCommunicatorHandler.isProcReq.get()) {
          this.mConcurrentRunningMsgs -= 1;
        }
        paramHttpCommunicatorHandler = new StringBuilder();
        paramHttpCommunicatorHandler.append("replaceNewThread index:");
        paramHttpCommunicatorHandler.append(i);
        disPatchMsg(paramHttpCommunicatorHandler.toString());
        return;
      }
    }
    if (QLog.isColorLevel())
    {
      paramHttpCommunicatorHandler = new StringBuilder();
      paramHttpCommunicatorHandler.append("replaceNewThread,index error occurs. ");
      paramHttpCommunicatorHandler.append(i);
      QLog.e("Q.richmedia.HttpCommunicator", 2, paramHttpCommunicatorHandler.toString());
    }
  }
  
  /* Error */
  public void run(HttpMsg paramHttpMsg, HttpCommunicator.HttpCommunicatorHandler paramHttpCommunicatorHandler)
  {
    // Byte code:
    //   0: ldc_w 866
    //   3: astore 24
    //   5: ldc_w 868
    //   8: astore 25
    //   10: ldc_w 731
    //   13: astore 28
    //   15: ldc_w 870
    //   18: astore 30
    //   20: ldc_w 872
    //   23: astore 19
    //   25: ldc_w 344
    //   28: astore 20
    //   30: aload_1
    //   31: invokevirtual 523	com/tencent/mobileqq/utils/httputils/HttpMsg:getProcessor	()Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   34: astore 26
    //   36: aload_0
    //   37: aload_1
    //   38: aconst_null
    //   39: iconst_1
    //   40: invokespecial 874	com/tencent/mobileqq/transfile/HttpCommunicator:statusChanged	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;I)V
    //   43: aconst_null
    //   44: astore 22
    //   46: aload 22
    //   48: astore 23
    //   50: aload 23
    //   52: astore 27
    //   54: lconst_0
    //   55: lstore 9
    //   57: iconst_0
    //   58: istore 5
    //   60: iconst_m1
    //   61: istore_3
    //   62: iconst_0
    //   63: istore 17
    //   65: aload_0
    //   66: aload_1
    //   67: ldc_w 876
    //   70: aload 28
    //   72: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   75: aload_0
    //   76: aload_2
    //   77: aload_1
    //   78: invokevirtual 878	com/tencent/mobileqq/transfile/HttpCommunicator:checkInterruptedBeforeBlock	(Lcom/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   81: aload_0
    //   82: aload_1
    //   83: invokespecial 880	com/tencent/mobileqq/transfile/HttpCommunicator:getConnection	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)Ljava/net/HttpURLConnection;
    //   86: astore 21
    //   88: aload_1
    //   89: aload 21
    //   91: putfield 884	com/tencent/mobileqq/utils/httputils/HttpMsg:mConn	Ljava/net/HttpURLConnection;
    //   94: aload_1
    //   95: invokestatic 721	android/os/SystemClock:uptimeMillis	()J
    //   98: putfield 887	com/tencent/mobileqq/utils/httputils/HttpMsg:startTime	J
    //   101: aload_0
    //   102: aload_1
    //   103: ldc_w 889
    //   106: aload 28
    //   108: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   111: invokestatic 586	java/lang/System:currentTimeMillis	()J
    //   114: pop2
    //   115: aload_1
    //   116: invokevirtual 347	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   119: aload 20
    //   121: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   124: istore 17
    //   126: iload 17
    //   128: ifeq +491 -> 619
    //   131: new 891	com/tencent/mobileqq/transfile/HttpCommunicator$1
    //   134: dup
    //   135: aload_0
    //   136: aload_1
    //   137: aload_2
    //   138: invokespecial 894	com/tencent/mobileqq/transfile/HttpCommunicator$1:<init>	(Lcom/tencent/mobileqq/transfile/HttpCommunicator;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler;)V
    //   141: astore 27
    //   143: aload_0
    //   144: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   147: astore 23
    //   149: aload 24
    //   151: astore 29
    //   153: aload 25
    //   155: astore 31
    //   157: aload 23
    //   159: aload 27
    //   161: ldc2_w 895
    //   164: invokevirtual 900	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   167: pop
    //   168: aload_1
    //   169: invokevirtual 446	com/tencent/mobileqq/utils/httputils/HttpMsg:getSendData	()[B
    //   172: astore 32
    //   174: aload 21
    //   176: invokevirtual 904	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   179: astore 23
    //   181: aload 27
    //   183: astore 22
    //   185: new 366	java/lang/StringBuilder
    //   188: dup
    //   189: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   192: astore 33
    //   194: aload 33
    //   196: ldc_w 906
    //   199: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 33
    //   205: aload 32
    //   207: arraylength
    //   208: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_0
    //   213: aload_1
    //   214: ldc_w 908
    //   217: aload 33
    //   219: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   225: iconst_0
    //   226: istore 4
    //   228: aload 32
    //   230: arraylength
    //   231: istore 6
    //   233: iload 4
    //   235: iload 6
    //   237: if_icmpge +46 -> 283
    //   240: aload_0
    //   241: aload_2
    //   242: aload_1
    //   243: invokevirtual 878	com/tencent/mobileqq/transfile/HttpCommunicator:checkInterruptedBeforeBlock	(Lcom/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   246: aload 23
    //   248: aload 32
    //   250: iload 4
    //   252: sipush 10240
    //   255: aload 32
    //   257: arraylength
    //   258: iload 4
    //   260: isub
    //   261: invokestatic 914	java/lang/Math:min	(II)I
    //   264: invokevirtual 920	java/io/OutputStream:write	([BII)V
    //   267: aload 23
    //   269: invokevirtual 923	java/io/OutputStream:flush	()V
    //   272: iload 4
    //   274: sipush 10240
    //   277: iadd
    //   278: istore 4
    //   280: goto -52 -> 228
    //   283: aload_2
    //   284: ifnull +17 -> 301
    //   287: aload_2
    //   288: getfield 553	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   291: invokevirtual 176	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   294: istore 17
    //   296: iload 17
    //   298: ifne +13 -> 311
    //   301: aload_0
    //   302: aload_1
    //   303: ldc_w 925
    //   306: aload 28
    //   308: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   311: aload 21
    //   313: invokevirtual 929	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   316: invokevirtual 930	java/net/URL:toString	()Ljava/lang/String;
    //   319: invokevirtual 933	java/lang/String:length	()I
    //   322: i2l
    //   323: lstore 11
    //   325: aload 32
    //   327: arraylength
    //   328: istore 4
    //   330: aload 23
    //   332: astore 27
    //   334: lload 9
    //   336: lload 11
    //   338: ldc2_w 934
    //   341: ladd
    //   342: iload 4
    //   344: i2l
    //   345: ladd
    //   346: ladd
    //   347: lstore 9
    //   349: aload 22
    //   351: astore 23
    //   353: goto +270 -> 623
    //   356: astore 24
    //   358: aload 23
    //   360: astore 25
    //   362: aload 19
    //   364: astore 27
    //   366: aload 22
    //   368: astore 23
    //   370: aload 29
    //   372: astore 19
    //   374: aload 26
    //   376: astore 28
    //   378: iconst_0
    //   379: istore 5
    //   381: aconst_null
    //   382: astore 29
    //   384: aconst_null
    //   385: astore 32
    //   387: iconst_1
    //   388: istore 17
    //   390: aload 21
    //   392: astore 22
    //   394: lconst_0
    //   395: lstore 13
    //   397: iload_3
    //   398: istore 4
    //   400: aload 24
    //   402: astore 26
    //   404: iload 5
    //   406: istore_3
    //   407: aload 27
    //   409: astore 21
    //   411: aload 29
    //   413: astore 24
    //   415: lload 9
    //   417: lstore 11
    //   419: aload 25
    //   421: astore 29
    //   423: aload 32
    //   425: astore 25
    //   427: lload 13
    //   429: lstore 9
    //   431: aload 31
    //   433: astore 27
    //   435: goto +4277 -> 4712
    //   438: astore 26
    //   440: goto +8 -> 448
    //   443: astore 24
    //   445: goto +14 -> 459
    //   448: aload 23
    //   450: astore 22
    //   452: aload 26
    //   454: astore 23
    //   456: goto +16 -> 472
    //   459: aload 23
    //   461: astore 22
    //   463: aload 24
    //   465: astore 23
    //   467: goto +14 -> 481
    //   470: astore 23
    //   472: aload 27
    //   474: astore 26
    //   476: goto +41 -> 517
    //   479: astore 23
    //   481: aload 26
    //   483: astore 28
    //   485: aload 29
    //   487: astore 24
    //   489: aload 23
    //   491: astore 26
    //   493: iload_3
    //   494: istore 4
    //   496: aload 27
    //   498: astore 23
    //   500: aload 22
    //   502: astore 27
    //   504: aload 31
    //   506: astore 25
    //   508: goto +3600 -> 4108
    //   511: astore 23
    //   513: aload 27
    //   515: astore 26
    //   517: aload 21
    //   519: astore 27
    //   521: iconst_1
    //   522: istore 17
    //   524: aload 26
    //   526: astore 21
    //   528: goto +3921 -> 4449
    //   531: astore 28
    //   533: aload 27
    //   535: astore 23
    //   537: aload 28
    //   539: astore 27
    //   541: goto +10 -> 551
    //   544: astore 26
    //   546: goto +3682 -> 4228
    //   549: astore 27
    //   551: aload 21
    //   553: astore 31
    //   555: aload 25
    //   557: astore 32
    //   559: iconst_1
    //   560: istore 17
    //   562: lconst_0
    //   563: lstore 13
    //   565: aconst_null
    //   566: astore 25
    //   568: aconst_null
    //   569: astore 29
    //   571: aload 19
    //   573: astore 21
    //   575: iload_3
    //   576: istore 4
    //   578: iconst_0
    //   579: istore_3
    //   580: aload 26
    //   582: astore 28
    //   584: aload 24
    //   586: astore 19
    //   588: aload 27
    //   590: astore 26
    //   592: aload 29
    //   594: astore 24
    //   596: lload 9
    //   598: lstore 11
    //   600: aload 22
    //   602: astore 29
    //   604: lload 13
    //   606: lstore 9
    //   608: aload 32
    //   610: astore 27
    //   612: aload 31
    //   614: astore 22
    //   616: goto +4096 -> 4712
    //   619: aload 22
    //   621: astore 27
    //   623: aload 25
    //   625: astore 22
    //   627: aload 28
    //   629: astore 31
    //   631: aload_0
    //   632: aload_2
    //   633: aload_1
    //   634: invokevirtual 878	com/tencent/mobileqq/transfile/HttpCommunicator:checkInterruptedBeforeBlock	(Lcom/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   637: aload 21
    //   639: invokevirtual 938	java/net/HttpURLConnection:getResponseCode	()I
    //   642: istore 4
    //   644: iload 4
    //   646: istore_3
    //   647: aload_0
    //   648: iload_3
    //   649: aload 21
    //   651: aload_1
    //   652: invokevirtual 940	com/tencent/mobileqq/transfile/HttpCommunicator:copyRespHeader	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   655: aload_2
    //   656: ifnull +348 -> 1004
    //   659: aload_2
    //   660: getfield 553	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   663: invokevirtual 176	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   666: istore 17
    //   668: iload 17
    //   670: ifeq +334 -> 1004
    //   673: iload_3
    //   674: sipush 200
    //   677: if_icmpeq +10 -> 687
    //   680: iload_3
    //   681: sipush 206
    //   684: if_icmpne +41 -> 725
    //   687: new 366	java/lang/StringBuilder
    //   690: dup
    //   691: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   694: astore 22
    //   696: aload 22
    //   698: ldc_w 942
    //   701: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: pop
    //   705: aload 22
    //   707: iconst_0
    //   708: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   711: pop
    //   712: aload_0
    //   713: aload_1
    //   714: ldc_w 944
    //   717: aload 22
    //   719: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   722: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   725: aload_2
    //   726: ifnull +13 -> 739
    //   729: aload_2
    //   730: getfield 553	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   733: invokevirtual 176	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   736: ifne +56 -> 792
    //   739: new 366	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   746: astore_2
    //   747: aload_2
    //   748: aload 19
    //   750: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload_2
    //   755: aload_1
    //   756: invokevirtual 947	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   759: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: aload_2
    //   764: ldc_w 870
    //   767: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   770: pop
    //   771: aload_2
    //   772: aload_1
    //   773: invokevirtual 950	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   776: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: pop
    //   780: aload_0
    //   781: aload_1
    //   782: ldc_w 952
    //   785: aload_2
    //   786: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   789: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   792: aload_0
    //   793: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   796: ifnull +17 -> 813
    //   799: aload 23
    //   801: ifnull +12 -> 813
    //   804: aload_0
    //   805: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   808: aload 23
    //   810: invokevirtual 956	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   813: lload 9
    //   815: lconst_0
    //   816: ladd
    //   817: lconst_0
    //   818: lcmp
    //   819: ifeq +13 -> 832
    //   822: aload_1
    //   823: invokevirtual 347	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   826: aload 20
    //   828: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   831: pop
    //   832: aload 27
    //   834: ifnull +11 -> 845
    //   837: aload 27
    //   839: invokevirtual 958	java/io/OutputStream:close	()V
    //   842: goto +3 -> 845
    //   845: aload 21
    //   847: ifnull +14 -> 861
    //   850: aload 21
    //   852: invokevirtual 961	java/net/HttpURLConnection:disconnect	()V
    //   855: return
    //   856: astore_1
    //   857: aload_1
    //   858: invokevirtual 673	java/lang/Exception:printStackTrace	()V
    //   861: return
    //   862: astore 25
    //   864: iconst_0
    //   865: istore 5
    //   867: aload 20
    //   869: astore 28
    //   871: aload 21
    //   873: astore 31
    //   875: aconst_null
    //   876: astore 26
    //   878: iconst_1
    //   879: istore 17
    //   881: lconst_0
    //   882: lstore 13
    //   884: aconst_null
    //   885: astore 32
    //   887: aload 19
    //   889: astore 21
    //   891: iconst_0
    //   892: istore 4
    //   894: aload 24
    //   896: astore 19
    //   898: aload 23
    //   900: astore 24
    //   902: aload 25
    //   904: astore 20
    //   906: aload 22
    //   908: astore 23
    //   910: lload 9
    //   912: lstore 11
    //   914: aload 27
    //   916: astore 29
    //   918: aload 32
    //   920: astore 25
    //   922: lload 13
    //   924: lstore 9
    //   926: aload 31
    //   928: astore 22
    //   930: aload 28
    //   932: astore 27
    //   934: goto +4379 -> 5313
    //   937: astore 28
    //   939: lconst_0
    //   940: lstore 13
    //   942: aconst_null
    //   943: astore 29
    //   945: aconst_null
    //   946: astore 25
    //   948: aload 21
    //   950: astore 31
    //   952: aload 19
    //   954: astore 21
    //   956: aload 26
    //   958: astore 32
    //   960: aload 24
    //   962: astore 19
    //   964: iconst_1
    //   965: istore 17
    //   967: iconst_0
    //   968: istore_3
    //   969: aload 28
    //   971: astore 26
    //   973: aload 32
    //   975: astore 28
    //   977: aload 29
    //   979: astore 24
    //   981: lload 9
    //   983: lstore 11
    //   985: aload 27
    //   987: astore 29
    //   989: lload 13
    //   991: lstore 9
    //   993: aload 22
    //   995: astore 27
    //   997: aload 31
    //   999: astore 22
    //   1001: goto +3711 -> 4712
    //   1004: aload_0
    //   1005: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   1008: astore 28
    //   1010: aload 28
    //   1012: ifnull +17 -> 1029
    //   1015: aload 23
    //   1017: ifnull +12 -> 1029
    //   1020: aload_0
    //   1021: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   1024: aload 23
    //   1026: invokevirtual 956	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1029: new 366	java/lang/StringBuilder
    //   1032: dup
    //   1033: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   1036: astore 28
    //   1038: aload 28
    //   1040: ldc_w 963
    //   1043: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1046: pop
    //   1047: aload 28
    //   1049: iload_3
    //   1050: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1053: pop
    //   1054: aload_0
    //   1055: aload_1
    //   1056: ldc_w 965
    //   1059: aload 28
    //   1061: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1064: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1067: iload_3
    //   1068: sipush 302
    //   1071: if_icmpeq +2382 -> 3453
    //   1074: iload_3
    //   1075: sipush 301
    //   1078: if_icmpne +6 -> 1084
    //   1081: goto +2372 -> 3453
    //   1084: aload_0
    //   1085: aload_1
    //   1086: aconst_null
    //   1087: iconst_2
    //   1088: invokespecial 874	com/tencent/mobileqq/transfile/HttpCommunicator:statusChanged	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;I)V
    //   1091: iload_3
    //   1092: sipush 200
    //   1095: if_icmpeq +303 -> 1398
    //   1098: iload_3
    //   1099: sipush 206
    //   1102: if_icmpne +6 -> 1108
    //   1105: goto +293 -> 1398
    //   1108: aload_1
    //   1109: getfield 265	com/tencent/mobileqq/utils/httputils/HttpMsg:isRequestInCmwap	Z
    //   1112: ifeq +228 -> 1340
    //   1115: aload_1
    //   1116: getfield 288	com/tencent/mobileqq/utils/httputils/HttpMsg:mCmwapConnectionType	I
    //   1119: ifeq +221 -> 1340
    //   1122: aload_1
    //   1123: getfield 285	com/tencent/mobileqq/utils/httputils/HttpMsg:isCmwapRetried	Z
    //   1126: ifne +214 -> 1340
    //   1129: aload_0
    //   1130: aload_1
    //   1131: ldc_w 966
    //   1134: ldc_w 968
    //   1137: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1140: aload_1
    //   1141: iconst_1
    //   1142: putfield 285	com/tencent/mobileqq/utils/httputils/HttpMsg:isCmwapRetried	Z
    //   1145: aload_0
    //   1146: aload_1
    //   1147: aload_2
    //   1148: invokevirtual 970	com/tencent/mobileqq/transfile/HttpCommunicator:run	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler;)V
    //   1151: iload_3
    //   1152: sipush 200
    //   1155: if_icmpeq +10 -> 1165
    //   1158: iload_3
    //   1159: sipush 206
    //   1162: if_icmpne +41 -> 1203
    //   1165: new 366	java/lang/StringBuilder
    //   1168: dup
    //   1169: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   1172: astore 22
    //   1174: aload 22
    //   1176: ldc_w 942
    //   1179: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: pop
    //   1183: aload 22
    //   1185: iconst_0
    //   1186: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1189: pop
    //   1190: aload_0
    //   1191: aload_1
    //   1192: ldc_w 944
    //   1195: aload 22
    //   1197: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1200: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1203: aload_2
    //   1204: ifnull +13 -> 1217
    //   1207: aload_2
    //   1208: getfield 553	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   1211: invokevirtual 176	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   1214: ifne +56 -> 1270
    //   1217: new 366	java/lang/StringBuilder
    //   1220: dup
    //   1221: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   1224: astore_2
    //   1225: aload_2
    //   1226: aload 19
    //   1228: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: pop
    //   1232: aload_2
    //   1233: aload_1
    //   1234: invokevirtual 947	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   1237: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1240: pop
    //   1241: aload_2
    //   1242: ldc_w 870
    //   1245: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: pop
    //   1249: aload_2
    //   1250: aload_1
    //   1251: invokevirtual 950	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   1254: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: pop
    //   1258: aload_0
    //   1259: aload_1
    //   1260: ldc_w 952
    //   1263: aload_2
    //   1264: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1267: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1270: aload_0
    //   1271: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   1274: ifnull +17 -> 1291
    //   1277: aload 23
    //   1279: ifnull +12 -> 1291
    //   1282: aload_0
    //   1283: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   1286: aload 23
    //   1288: invokevirtual 956	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1291: lload 9
    //   1293: lconst_0
    //   1294: ladd
    //   1295: lconst_0
    //   1296: lcmp
    //   1297: ifeq +13 -> 1310
    //   1300: aload_1
    //   1301: invokevirtual 347	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   1304: aload 20
    //   1306: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1309: pop
    //   1310: aload 27
    //   1312: ifnull +11 -> 1323
    //   1315: aload 27
    //   1317: invokevirtual 958	java/io/OutputStream:close	()V
    //   1320: goto +3 -> 1323
    //   1323: aload 21
    //   1325: ifnull +14 -> 1339
    //   1328: aload 21
    //   1330: invokevirtual 961	java/net/HttpURLConnection:disconnect	()V
    //   1333: return
    //   1334: astore_1
    //   1335: aload_1
    //   1336: invokevirtual 673	java/lang/Exception:printStackTrace	()V
    //   1339: return
    //   1340: aload_0
    //   1341: iload_3
    //   1342: aload 21
    //   1344: aload_1
    //   1345: invokevirtual 972	com/tencent/mobileqq/transfile/HttpCommunicator:procBadResponse	(ILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   1348: aconst_null
    //   1349: astore 28
    //   1351: aload 28
    //   1353: astore 29
    //   1355: ldc_w 870
    //   1358: astore 30
    //   1360: lconst_0
    //   1361: lstore 13
    //   1363: iconst_0
    //   1364: istore 5
    //   1366: iconst_1
    //   1367: istore 4
    //   1369: aload 19
    //   1371: astore 25
    //   1373: aload 30
    //   1375: astore 19
    //   1377: goto +1542 -> 2919
    //   1380: astore 25
    //   1382: iconst_1
    //   1383: istore 5
    //   1385: goto -518 -> 867
    //   1388: astore 25
    //   1390: goto -526 -> 864
    //   1393: astore 28
    //   1395: goto -456 -> 939
    //   1398: aload 21
    //   1400: invokevirtual 615	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   1403: astore 28
    //   1405: aload 28
    //   1407: ifnonnull +10 -> 1417
    //   1410: aload 31
    //   1412: astore 28
    //   1414: goto +10 -> 1424
    //   1417: aload 28
    //   1419: invokevirtual 975	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1422: astore 28
    //   1424: aload_1
    //   1425: getfield 979	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   1428: astore 29
    //   1430: aload 29
    //   1432: ifnull +348 -> 1780
    //   1435: aload_1
    //   1436: getfield 979	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   1439: arraylength
    //   1440: ifle +340 -> 1780
    //   1443: aload 28
    //   1445: invokevirtual 933	java/lang/String:length	()I
    //   1448: ifle +332 -> 1780
    //   1451: aload_1
    //   1452: getfield 979	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   1455: arraylength
    //   1456: istore 6
    //   1458: iconst_1
    //   1459: istore 5
    //   1461: iload 6
    //   1463: iconst_1
    //   1464: if_icmpne +37 -> 1501
    //   1467: aload_1
    //   1468: getfield 979	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   1471: iconst_0
    //   1472: aaload
    //   1473: ifnull +28 -> 1501
    //   1476: aload_1
    //   1477: getfield 979	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   1480: iconst_0
    //   1481: aaload
    //   1482: invokevirtual 975	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1485: ldc_w 981
    //   1488: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1491: istore 17
    //   1493: iload 17
    //   1495: ifeq +6 -> 1501
    //   1498: goto +68 -> 1566
    //   1501: aload_1
    //   1502: getfield 979	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   1505: astore 29
    //   1507: aload 29
    //   1509: arraylength
    //   1510: istore 5
    //   1512: iconst_0
    //   1513: istore 6
    //   1515: iload 6
    //   1517: iload 5
    //   1519: if_icmpge +44 -> 1563
    //   1522: aload 29
    //   1524: iload 6
    //   1526: aaload
    //   1527: astore 31
    //   1529: aload 31
    //   1531: ifnull +23 -> 1554
    //   1534: aload 28
    //   1536: aload 31
    //   1538: invokevirtual 985	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1541: istore 17
    //   1543: iload 17
    //   1545: ifeq +9 -> 1554
    //   1548: iconst_1
    //   1549: istore 5
    //   1551: goto +15 -> 1566
    //   1554: iload 6
    //   1556: iconst_1
    //   1557: iadd
    //   1558: istore 6
    //   1560: goto -45 -> 1515
    //   1563: iconst_0
    //   1564: istore 5
    //   1566: iload 5
    //   1568: ifne +212 -> 1780
    //   1571: new 366	java/lang/StringBuilder
    //   1574: dup
    //   1575: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   1578: astore 25
    //   1580: aload_1
    //   1581: getfield 979	com/tencent/mobileqq/utils/httputils/HttpMsg:whiteList_type	[Ljava/lang/String;
    //   1584: astore 29
    //   1586: aload 29
    //   1588: arraylength
    //   1589: istore 5
    //   1591: iconst_0
    //   1592: istore 6
    //   1594: iload 6
    //   1596: iload 5
    //   1598: if_icmpge +35 -> 1633
    //   1601: aload 29
    //   1603: iload 6
    //   1605: aaload
    //   1606: astore 31
    //   1608: aload 31
    //   1610: ifnull +4102 -> 5712
    //   1613: aload 25
    //   1615: aload 31
    //   1617: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1620: pop
    //   1621: aload 25
    //   1623: ldc_w 987
    //   1626: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1629: pop
    //   1630: goto +4082 -> 5712
    //   1633: new 366	java/lang/StringBuilder
    //   1636: dup
    //   1637: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   1640: astore 29
    //   1642: aload 29
    //   1644: ldc_w 989
    //   1647: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1650: pop
    //   1651: aload 29
    //   1653: aload 28
    //   1655: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1658: pop
    //   1659: aload 29
    //   1661: ldc_w 991
    //   1664: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1667: pop
    //   1668: aload 29
    //   1670: aload 25
    //   1672: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1675: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1678: pop
    //   1679: new 547	java/io/IOException
    //   1682: dup
    //   1683: aload 29
    //   1685: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1688: invokespecial 550	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1691: athrow
    //   1692: astore 28
    //   1694: lconst_0
    //   1695: lstore 13
    //   1697: aconst_null
    //   1698: astore 26
    //   1700: aload 23
    //   1702: astore 25
    //   1704: aload 28
    //   1706: astore 23
    //   1708: aload 20
    //   1710: astore 28
    //   1712: aload 21
    //   1714: astore 31
    //   1716: iconst_1
    //   1717: istore 17
    //   1719: aconst_null
    //   1720: astore 32
    //   1722: aload 19
    //   1724: astore 21
    //   1726: iconst_0
    //   1727: istore 4
    //   1729: aload 24
    //   1731: astore 19
    //   1733: iconst_0
    //   1734: istore 5
    //   1736: aload 23
    //   1738: astore 20
    //   1740: aload 22
    //   1742: astore 23
    //   1744: aload 25
    //   1746: astore 24
    //   1748: lload 9
    //   1750: lstore 11
    //   1752: aload 27
    //   1754: astore 29
    //   1756: aload 32
    //   1758: astore 25
    //   1760: lload 13
    //   1762: lstore 9
    //   1764: aload 31
    //   1766: astore 22
    //   1768: aload 28
    //   1770: astore 27
    //   1772: goto +3541 -> 5313
    //   1775: astore 28
    //   1777: goto -838 -> 939
    //   1780: aload 23
    //   1782: astore 31
    //   1784: aload_1
    //   1785: getfield 652	com/tencent/mobileqq/utils/httputils/HttpMsg:totalLen	J
    //   1788: lstore 11
    //   1790: lload 11
    //   1792: lconst_0
    //   1793: lcmp
    //   1794: ifne +38 -> 1832
    //   1797: aload_1
    //   1798: invokevirtual 347	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   1801: aload 20
    //   1803: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1806: ifeq +6 -> 1812
    //   1809: goto +23 -> 1832
    //   1812: new 547	java/io/IOException
    //   1815: dup
    //   1816: ldc 28
    //   1818: invokespecial 550	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1821: athrow
    //   1822: astore 28
    //   1824: goto -130 -> 1694
    //   1827: astore 28
    //   1829: goto -52 -> 1777
    //   1832: new 366	java/lang/StringBuilder
    //   1835: dup
    //   1836: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   1839: astore 28
    //   1841: aload 28
    //   1843: ldc_w 993
    //   1846: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1849: pop
    //   1850: aload 28
    //   1852: aload_1
    //   1853: getfield 652	com/tencent/mobileqq/utils/httputils/HttpMsg:totalLen	J
    //   1856: invokevirtual 479	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1859: pop
    //   1860: aload_0
    //   1861: aload_1
    //   1862: ldc_w 995
    //   1865: aload 28
    //   1867: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1870: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   1873: aload_1
    //   1874: getfield 887	com/tencent/mobileqq/utils/httputils/HttpMsg:startTime	J
    //   1877: lstore 11
    //   1879: lload 11
    //   1881: lconst_0
    //   1882: lcmp
    //   1883: ifeq +15 -> 1898
    //   1886: aload_1
    //   1887: invokestatic 721	android/os/SystemClock:uptimeMillis	()J
    //   1890: aload_1
    //   1891: getfield 887	com/tencent/mobileqq/utils/httputils/HttpMsg:startTime	J
    //   1894: lsub
    //   1895: putfield 998	com/tencent/mobileqq/utils/httputils/HttpMsg:cost	J
    //   1898: aload 26
    //   1900: astore 32
    //   1902: aload 32
    //   1904: aload_1
    //   1905: aload_1
    //   1906: iconst_3
    //   1907: invokeinterface 528 4 0
    //   1912: istore 17
    //   1914: iload 17
    //   1916: ifeq +956 -> 2872
    //   1919: ldc2_w 934
    //   1922: lstore 13
    //   1924: aload 21
    //   1926: invokevirtual 1002	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1929: astore 33
    //   1931: aload 33
    //   1933: astore 28
    //   1935: invokestatic 1008	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1938: astore 38
    //   1940: invokestatic 1011	com/tencent/commonsdk/pool/ByteArrayPool:getMaxBufInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   1943: pop
    //   1944: aload_1
    //   1945: iconst_0
    //   1946: putfield 1014	com/tencent/mobileqq/utils/httputils/HttpMsg:mUseByteArrayPool	Z
    //   1949: new 1016	java/io/ByteArrayOutputStream
    //   1952: dup
    //   1953: invokespecial 1017	java/io/ByteArrayOutputStream:<init>	()V
    //   1956: astore 29
    //   1958: aload_1
    //   1959: getfield 1014	com/tencent/mobileqq/utils/httputils/HttpMsg:mUseByteArrayPool	Z
    //   1962: istore 17
    //   1964: iload 17
    //   1966: ifeq +50 -> 2016
    //   1969: aload 38
    //   1971: sipush 10240
    //   1974: invokevirtual 1021	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   1977: astore 37
    //   1979: goto +44 -> 2023
    //   1982: astore 26
    //   1984: goto +680 -> 2664
    //   1987: astore 32
    //   1989: aload 28
    //   1991: astore 25
    //   1993: aload 31
    //   1995: astore 23
    //   1997: aload 29
    //   1999: astore 31
    //   2001: aload 32
    //   2003: astore 28
    //   2005: aload 25
    //   2007: astore 29
    //   2009: aload 31
    //   2011: astore 25
    //   2013: goto -1065 -> 948
    //   2016: sipush 10240
    //   2019: newarray byte
    //   2021: astore 37
    //   2023: aload 21
    //   2025: astore 35
    //   2027: aload 20
    //   2029: astore 36
    //   2031: iconst_0
    //   2032: istore 6
    //   2034: iconst_0
    //   2035: istore 5
    //   2037: aload 19
    //   2039: astore 25
    //   2041: aload 30
    //   2043: astore 19
    //   2045: aload 28
    //   2047: aload 37
    //   2049: iload 6
    //   2051: aload 37
    //   2053: arraylength
    //   2054: iload 6
    //   2056: isub
    //   2057: invokevirtual 1027	java/io/InputStream:read	([BII)I
    //   2060: istore 7
    //   2062: iload 7
    //   2064: ifle +162 -> 2226
    //   2067: aload_0
    //   2068: aload_2
    //   2069: aload_1
    //   2070: invokevirtual 878	com/tencent/mobileqq/transfile/HttpCommunicator:checkInterruptedBeforeBlock	(Lcom/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   2073: aload 19
    //   2075: astore 30
    //   2077: aload 25
    //   2079: astore 34
    //   2081: lload 13
    //   2083: iload 7
    //   2085: i2l
    //   2086: ladd
    //   2087: lstore 13
    //   2089: iload 6
    //   2091: iload 7
    //   2093: iadd
    //   2094: istore 6
    //   2096: iload 5
    //   2098: iload 7
    //   2100: iadd
    //   2101: istore 5
    //   2103: lload 13
    //   2105: lstore 11
    //   2107: iload 5
    //   2109: istore 7
    //   2111: lload 13
    //   2113: lstore 15
    //   2115: iload 5
    //   2117: istore 8
    //   2119: iload 6
    //   2121: aload 37
    //   2123: arraylength
    //   2124: if_icmplt +3611 -> 5735
    //   2127: lload 13
    //   2129: lstore 11
    //   2131: iload 5
    //   2133: istore 7
    //   2135: lload 13
    //   2137: lstore 15
    //   2139: iload 5
    //   2141: istore 8
    //   2143: aload_1
    //   2144: invokevirtual 1030	com/tencent/mobileqq/utils/httputils/HttpMsg:isDataSlice	()Z
    //   2147: ifeq +53 -> 2200
    //   2150: lload 13
    //   2152: lstore 11
    //   2154: iload 5
    //   2156: istore 7
    //   2158: lload 13
    //   2160: lstore 15
    //   2162: iload 5
    //   2164: istore 8
    //   2166: aload_1
    //   2167: aload 37
    //   2169: invokevirtual 1034	com/tencent/mobileqq/utils/httputils/HttpMsg:setRecvData	([B)V
    //   2172: lload 13
    //   2174: lstore 11
    //   2176: iload 5
    //   2178: istore 7
    //   2180: lload 13
    //   2182: lstore 15
    //   2184: iload 5
    //   2186: istore 8
    //   2188: aload 32
    //   2190: aload_1
    //   2191: aload_1
    //   2192: invokeinterface 1037 3 0
    //   2197: goto +3524 -> 5721
    //   2200: lload 13
    //   2202: lstore 11
    //   2204: iload 5
    //   2206: istore 7
    //   2208: lload 13
    //   2210: lstore 15
    //   2212: iload 5
    //   2214: istore 8
    //   2216: aload 29
    //   2218: aload 37
    //   2220: invokevirtual 1039	java/io/ByteArrayOutputStream:write	([B)V
    //   2223: goto +3498 -> 5721
    //   2226: aload 19
    //   2228: astore 30
    //   2230: aload 25
    //   2232: astore 34
    //   2234: lload 13
    //   2236: lstore 11
    //   2238: iload 5
    //   2240: istore 7
    //   2242: lload 13
    //   2244: lstore 15
    //   2246: iload 5
    //   2248: istore 8
    //   2250: aload_1
    //   2251: invokevirtual 1030	com/tencent/mobileqq/utils/httputils/HttpMsg:isDataSlice	()Z
    //   2254: ifeq +107 -> 2361
    //   2257: iload 6
    //   2259: ifle +204 -> 2463
    //   2262: lload 13
    //   2264: lstore 11
    //   2266: iload 5
    //   2268: istore 7
    //   2270: lload 13
    //   2272: lstore 15
    //   2274: iload 5
    //   2276: istore 8
    //   2278: iload 6
    //   2280: newarray byte
    //   2282: astore 39
    //   2284: lload 13
    //   2286: lstore 11
    //   2288: iload 5
    //   2290: istore 7
    //   2292: lload 13
    //   2294: lstore 15
    //   2296: iload 5
    //   2298: istore 8
    //   2300: aload 37
    //   2302: iconst_0
    //   2303: aload 39
    //   2305: iconst_0
    //   2306: iload 6
    //   2308: invokestatic 1043	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   2311: lload 13
    //   2313: lstore 11
    //   2315: iload 5
    //   2317: istore 7
    //   2319: lload 13
    //   2321: lstore 15
    //   2323: iload 5
    //   2325: istore 8
    //   2327: aload_1
    //   2328: aload 39
    //   2330: invokevirtual 1034	com/tencent/mobileqq/utils/httputils/HttpMsg:setRecvData	([B)V
    //   2333: lload 13
    //   2335: lstore 11
    //   2337: iload 5
    //   2339: istore 7
    //   2341: lload 13
    //   2343: lstore 15
    //   2345: iload 5
    //   2347: istore 8
    //   2349: aload 32
    //   2351: aload_1
    //   2352: aload_1
    //   2353: invokeinterface 1037 3 0
    //   2358: goto +105 -> 2463
    //   2361: iload 6
    //   2363: ifle +29 -> 2392
    //   2366: lload 13
    //   2368: lstore 11
    //   2370: iload 5
    //   2372: istore 7
    //   2374: lload 13
    //   2376: lstore 15
    //   2378: iload 5
    //   2380: istore 8
    //   2382: aload 29
    //   2384: aload 37
    //   2386: iconst_0
    //   2387: iload 6
    //   2389: invokevirtual 1044	java/io/ByteArrayOutputStream:write	([BII)V
    //   2392: lload 13
    //   2394: lstore 11
    //   2396: iload 5
    //   2398: istore 7
    //   2400: lload 13
    //   2402: lstore 15
    //   2404: iload 5
    //   2406: istore 8
    //   2408: aload 29
    //   2410: invokevirtual 1045	java/io/ByteArrayOutputStream:flush	()V
    //   2413: lload 13
    //   2415: lstore 11
    //   2417: iload 5
    //   2419: istore 7
    //   2421: lload 13
    //   2423: lstore 15
    //   2425: iload 5
    //   2427: istore 8
    //   2429: aload_1
    //   2430: aload 29
    //   2432: invokevirtual 1048	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   2435: invokevirtual 1034	com/tencent/mobileqq/utils/httputils/HttpMsg:setRecvData	([B)V
    //   2438: lload 13
    //   2440: lstore 11
    //   2442: iload 5
    //   2444: istore 7
    //   2446: lload 13
    //   2448: lstore 15
    //   2450: iload 5
    //   2452: istore 8
    //   2454: aload 32
    //   2456: aload_1
    //   2457: aload_1
    //   2458: invokeinterface 1037 3 0
    //   2463: lload 13
    //   2465: lstore 11
    //   2467: iload 5
    //   2469: istore 7
    //   2471: lload 13
    //   2473: lstore 15
    //   2475: iload 5
    //   2477: istore 8
    //   2479: aload_1
    //   2480: getfield 1014	com/tencent/mobileqq/utils/httputils/HttpMsg:mUseByteArrayPool	Z
    //   2483: ifeq +26 -> 2509
    //   2486: lload 13
    //   2488: lstore 11
    //   2490: iload 5
    //   2492: istore 7
    //   2494: lload 13
    //   2496: lstore 15
    //   2498: iload 5
    //   2500: istore 8
    //   2502: aload 38
    //   2504: aload 37
    //   2506: invokevirtual 1051	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   2509: lload 13
    //   2511: lstore 11
    //   2513: iload 5
    //   2515: istore 7
    //   2517: lload 13
    //   2519: lstore 15
    //   2521: iload 5
    //   2523: istore 8
    //   2525: aload 29
    //   2527: invokevirtual 1052	java/io/ByteArrayOutputStream:close	()V
    //   2530: aload 34
    //   2532: astore 25
    //   2534: aload 30
    //   2536: astore 19
    //   2538: goto +359 -> 2897
    //   2541: astore 26
    //   2543: iload 7
    //   2545: istore 4
    //   2547: aload 19
    //   2549: astore 30
    //   2551: aload 26
    //   2553: astore 19
    //   2555: goto +41 -> 2596
    //   2558: astore 26
    //   2560: iload 8
    //   2562: istore_3
    //   2563: aload 25
    //   2565: astore 21
    //   2567: aload 19
    //   2569: astore 30
    //   2571: lload 15
    //   2573: lstore 13
    //   2575: goto +41 -> 2616
    //   2578: astore 26
    //   2580: iload 5
    //   2582: istore 4
    //   2584: lload 13
    //   2586: lstore 11
    //   2588: aload 19
    //   2590: astore 30
    //   2592: aload 26
    //   2594: astore 19
    //   2596: lload 11
    //   2598: lstore 13
    //   2600: goto +75 -> 2675
    //   2603: astore 26
    //   2605: aload 25
    //   2607: astore 21
    //   2609: iload 5
    //   2611: istore_3
    //   2612: aload 19
    //   2614: astore 30
    //   2616: aload 24
    //   2618: astore 19
    //   2620: iconst_1
    //   2621: istore 17
    //   2623: aload 29
    //   2625: astore 25
    //   2627: aload 36
    //   2629: astore 20
    //   2631: aload 32
    //   2633: astore 28
    //   2635: aload 33
    //   2637: astore 24
    //   2639: lload 9
    //   2641: lstore 11
    //   2643: aload 27
    //   2645: astore 29
    //   2647: lload 13
    //   2649: lstore 9
    //   2651: aload 22
    //   2653: astore 27
    //   2655: aload 35
    //   2657: astore 22
    //   2659: goto +2053 -> 4712
    //   2662: astore 26
    //   2664: iconst_0
    //   2665: istore 4
    //   2667: aload 19
    //   2669: astore 25
    //   2671: aload 26
    //   2673: astore 19
    //   2675: aload 20
    //   2677: astore 28
    //   2679: aload 21
    //   2681: astore 31
    //   2683: aload 33
    //   2685: astore 26
    //   2687: aload 23
    //   2689: astore 21
    //   2691: iconst_1
    //   2692: istore 17
    //   2694: iconst_0
    //   2695: istore 5
    //   2697: aload 29
    //   2699: astore 32
    //   2701: aload 19
    //   2703: astore 20
    //   2705: aload 22
    //   2707: astore 23
    //   2709: aload 24
    //   2711: astore 19
    //   2713: aload 21
    //   2715: astore 24
    //   2717: aload 25
    //   2719: astore 21
    //   2721: lload 9
    //   2723: lstore 11
    //   2725: aload 27
    //   2727: astore 29
    //   2729: aload 32
    //   2731: astore 25
    //   2733: lload 13
    //   2735: lstore 9
    //   2737: aload 31
    //   2739: astore 22
    //   2741: aload 28
    //   2743: astore 27
    //   2745: goto +2568 -> 5313
    //   2748: astore 26
    //   2750: aload 21
    //   2752: astore 33
    //   2754: aload 28
    //   2756: astore 25
    //   2758: iload_3
    //   2759: istore 4
    //   2761: aload 19
    //   2763: astore 21
    //   2765: aload 31
    //   2767: astore 23
    //   2769: iconst_0
    //   2770: istore_3
    //   2771: iconst_1
    //   2772: istore 17
    //   2774: aload 29
    //   2776: astore 31
    //   2778: aload 24
    //   2780: astore 19
    //   2782: aload 32
    //   2784: astore 28
    //   2786: aload 25
    //   2788: astore 24
    //   2790: lload 9
    //   2792: lstore 11
    //   2794: aload 27
    //   2796: astore 29
    //   2798: aload 31
    //   2800: astore 25
    //   2802: lload 13
    //   2804: lstore 9
    //   2806: aload 22
    //   2808: astore 27
    //   2810: aload 33
    //   2812: astore 22
    //   2814: goto +1898 -> 4712
    //   2817: astore 23
    //   2819: aload 28
    //   2821: astore 26
    //   2823: aload 31
    //   2825: astore 25
    //   2827: goto -1119 -> 1708
    //   2830: astore 26
    //   2832: aload 28
    //   2834: astore 29
    //   2836: goto +13 -> 2849
    //   2839: astore 28
    //   2841: goto -1144 -> 1697
    //   2844: astore 26
    //   2846: aconst_null
    //   2847: astore 29
    //   2849: aload 24
    //   2851: astore 22
    //   2853: aload 32
    //   2855: astore 28
    //   2857: aload 29
    //   2859: astore 24
    //   2861: lload 9
    //   2863: lstore 11
    //   2865: lload 13
    //   2867: lstore 9
    //   2869: goto +1396 -> 4265
    //   2872: ldc_w 870
    //   2875: astore 30
    //   2877: aload 19
    //   2879: astore 25
    //   2881: lconst_0
    //   2882: lstore 13
    //   2884: aconst_null
    //   2885: astore 28
    //   2887: aconst_null
    //   2888: astore 29
    //   2890: iconst_0
    //   2891: istore 5
    //   2893: aload 30
    //   2895: astore 19
    //   2897: aload 20
    //   2899: astore 30
    //   2901: aload 21
    //   2903: astore 33
    //   2905: aload 32
    //   2907: aload_1
    //   2908: aload_1
    //   2909: iconst_4
    //   2910: invokeinterface 528 4 0
    //   2915: pop
    //   2916: iconst_0
    //   2917: istore 4
    //   2919: iload_3
    //   2920: sipush 200
    //   2923: if_icmpeq +10 -> 2933
    //   2926: iload_3
    //   2927: sipush 206
    //   2930: if_icmpne +42 -> 2972
    //   2933: new 366	java/lang/StringBuilder
    //   2936: dup
    //   2937: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   2940: astore 30
    //   2942: aload 30
    //   2944: ldc_w 942
    //   2947: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2950: pop
    //   2951: aload 30
    //   2953: iload 5
    //   2955: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2958: pop
    //   2959: aload_0
    //   2960: aload_1
    //   2961: ldc_w 944
    //   2964: aload 30
    //   2966: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2969: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   2972: aload_2
    //   2973: ifnull +13 -> 2986
    //   2976: aload_2
    //   2977: getfield 553	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   2980: invokevirtual 176	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   2983: ifne +134 -> 3117
    //   2986: new 366	java/lang/StringBuilder
    //   2989: dup
    //   2990: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   2993: astore 30
    //   2995: aload 30
    //   2997: aload 25
    //   2999: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3002: pop
    //   3003: aload 30
    //   3005: aload_1
    //   3006: invokevirtual 947	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   3009: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3012: pop
    //   3013: aload 30
    //   3015: aload 19
    //   3017: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3020: pop
    //   3021: aload 30
    //   3023: aload_1
    //   3024: invokevirtual 950	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   3027: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3030: pop
    //   3031: aload_0
    //   3032: aload_1
    //   3033: ldc_w 952
    //   3036: aload 30
    //   3038: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3041: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3044: iload 4
    //   3046: ifeq +71 -> 3117
    //   3049: aload_1
    //   3050: getfield 1055	com/tencent/mobileqq/utils/httputils/HttpMsg:errCode	I
    //   3053: sipush -9527
    //   3056: if_icmpne +61 -> 3117
    //   3059: new 366	java/lang/StringBuilder
    //   3062: dup
    //   3063: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   3066: astore 19
    //   3068: aload 19
    //   3070: aload 22
    //   3072: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3075: pop
    //   3076: aload 19
    //   3078: aload_1
    //   3079: getfield 457	com/tencent/mobileqq/utils/httputils/HttpMsg:rawReqHeader	Ljava/lang/String;
    //   3082: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3085: pop
    //   3086: aload 19
    //   3088: aload 24
    //   3090: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3093: pop
    //   3094: aload 19
    //   3096: aload_1
    //   3097: getfield 624	com/tencent/mobileqq/utils/httputils/HttpMsg:rawRespHeader	Ljava/lang/String;
    //   3100: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3103: pop
    //   3104: aload_0
    //   3105: aload_1
    //   3106: ldc_w 1057
    //   3109: aload 19
    //   3111: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3114: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3117: aload_0
    //   3118: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   3121: ifnull +17 -> 3138
    //   3124: aload 23
    //   3126: ifnull +12 -> 3138
    //   3129: aload_0
    //   3130: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   3133: aload 23
    //   3135: invokevirtual 956	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3138: lload 9
    //   3140: lload 13
    //   3142: ladd
    //   3143: lconst_0
    //   3144: lcmp
    //   3145: ifeq +13 -> 3158
    //   3148: aload_1
    //   3149: invokevirtual 347	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   3152: aload 20
    //   3154: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3157: pop
    //   3158: aload 29
    //   3160: ifnull +11 -> 3171
    //   3163: aload 29
    //   3165: invokevirtual 1052	java/io/ByteArrayOutputStream:close	()V
    //   3168: goto +3 -> 3171
    //   3171: aload 28
    //   3173: ifnull +11 -> 3184
    //   3176: aload 28
    //   3178: invokevirtual 1058	java/io/InputStream:close	()V
    //   3181: goto +3 -> 3184
    //   3184: aload 27
    //   3186: ifnull +11 -> 3197
    //   3189: aload 27
    //   3191: invokevirtual 958	java/io/OutputStream:close	()V
    //   3194: goto +3 -> 3197
    //   3197: aload 21
    //   3199: ifnull +18 -> 3217
    //   3202: aload 21
    //   3204: invokevirtual 961	java/net/HttpURLConnection:disconnect	()V
    //   3207: goto +10 -> 3217
    //   3210: astore 19
    //   3212: aload 19
    //   3214: invokevirtual 673	java/lang/Exception:printStackTrace	()V
    //   3217: iload 4
    //   3219: istore_3
    //   3220: aload 26
    //   3222: astore 19
    //   3224: goto +1977 -> 5201
    //   3227: astore 20
    //   3229: aload 19
    //   3231: astore 26
    //   3233: iload 5
    //   3235: istore 4
    //   3237: aload 22
    //   3239: astore 19
    //   3241: aload 30
    //   3243: astore 31
    //   3245: aload 25
    //   3247: astore 22
    //   3249: aload 26
    //   3251: astore 30
    //   3253: aload 29
    //   3255: astore 25
    //   3257: aload 28
    //   3259: astore 26
    //   3261: aload 31
    //   3263: astore 28
    //   3265: goto +126 -> 3391
    //   3268: astore 26
    //   3270: aload 25
    //   3272: astore 21
    //   3274: aload 19
    //   3276: astore 23
    //   3278: aload 29
    //   3280: astore 25
    //   3282: aload 30
    //   3284: astore 20
    //   3286: aload 28
    //   3288: astore 29
    //   3290: iconst_1
    //   3291: istore 17
    //   3293: iload_3
    //   3294: istore 4
    //   3296: iload 5
    //   3298: istore_3
    //   3299: aload 24
    //   3301: astore 19
    //   3303: aload 32
    //   3305: astore 28
    //   3307: aload 23
    //   3309: astore 30
    //   3311: aload 31
    //   3313: astore 23
    //   3315: aload 29
    //   3317: astore 24
    //   3319: lload 9
    //   3321: lstore 11
    //   3323: aload 27
    //   3325: astore 29
    //   3327: lload 13
    //   3329: lstore 9
    //   3331: aload 22
    //   3333: astore 27
    //   3335: aload 33
    //   3337: astore 22
    //   3339: goto +1373 -> 4712
    //   3342: astore 25
    //   3344: goto +102 -> 3446
    //   3347: astore 25
    //   3349: goto +10 -> 3359
    //   3352: astore 25
    //   3354: goto +92 -> 3446
    //   3357: astore 25
    //   3359: aload 20
    //   3361: astore 28
    //   3363: aload 25
    //   3365: astore 20
    //   3367: lconst_0
    //   3368: lstore 13
    //   3370: aload 22
    //   3372: astore 29
    //   3374: iconst_0
    //   3375: istore 4
    //   3377: aconst_null
    //   3378: astore 25
    //   3380: aconst_null
    //   3381: astore 26
    //   3383: aload 19
    //   3385: astore 22
    //   3387: aload 29
    //   3389: astore 19
    //   3391: aload 21
    //   3393: astore 31
    //   3395: iconst_1
    //   3396: istore 17
    //   3398: iconst_0
    //   3399: istore 5
    //   3401: aload 23
    //   3403: astore 21
    //   3405: aload 19
    //   3407: astore 23
    //   3409: aload 24
    //   3411: astore 19
    //   3413: aload 21
    //   3415: astore 24
    //   3417: aload 22
    //   3419: astore 21
    //   3421: lload 9
    //   3423: lstore 11
    //   3425: aload 27
    //   3427: astore 29
    //   3429: lload 13
    //   3431: lstore 9
    //   3433: aload 31
    //   3435: astore 22
    //   3437: aload 28
    //   3439: astore 27
    //   3441: goto +1872 -> 5313
    //   3444: astore 25
    //   3446: aload 25
    //   3448: astore 28
    //   3450: goto -2511 -> 939
    //   3453: aload 20
    //   3455: astore 28
    //   3457: aload 19
    //   3459: astore 34
    //   3461: aload 24
    //   3463: astore 32
    //   3465: aload 26
    //   3467: astore 33
    //   3469: aload 21
    //   3471: astore 35
    //   3473: aload 23
    //   3475: astore 29
    //   3477: iload 5
    //   3479: iconst_5
    //   3480: if_icmpge +545 -> 4025
    //   3483: new 366	java/lang/StringBuilder
    //   3486: dup
    //   3487: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   3490: astore 36
    //   3492: aload 36
    //   3494: aload 22
    //   3496: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3499: pop
    //   3500: aload 22
    //   3502: astore 25
    //   3504: aload 36
    //   3506: aload_1
    //   3507: getfield 457	com/tencent/mobileqq/utils/httputils/HttpMsg:rawReqHeader	Ljava/lang/String;
    //   3510: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3513: pop
    //   3514: aload 36
    //   3516: aload 32
    //   3518: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3521: pop
    //   3522: aload 36
    //   3524: aload_1
    //   3525: getfield 624	com/tencent/mobileqq/utils/httputils/HttpMsg:rawRespHeader	Ljava/lang/String;
    //   3528: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3531: pop
    //   3532: aload_0
    //   3533: aload_1
    //   3534: ldc_w 1060
    //   3537: aload 36
    //   3539: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3542: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3545: aload 35
    //   3547: ldc_w 1062
    //   3550: invokevirtual 629	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   3553: astore 36
    //   3555: aload 36
    //   3557: ifnull +457 -> 4014
    //   3560: aload 27
    //   3562: ifnull +8 -> 3570
    //   3565: aload 27
    //   3567: invokevirtual 958	java/io/OutputStream:close	()V
    //   3570: aload 35
    //   3572: invokevirtual 961	java/net/HttpURLConnection:disconnect	()V
    //   3575: goto +12 -> 3587
    //   3578: astore 20
    //   3580: aload 25
    //   3582: astore 22
    //   3584: goto -217 -> 3367
    //   3587: aload_1
    //   3588: invokevirtual 1065	com/tencent/mobileqq/utils/httputils/HttpMsg:isInstanceFollowRedirects	()Z
    //   3591: istore 17
    //   3593: iload 17
    //   3595: ifne +219 -> 3814
    //   3598: aload 33
    //   3600: aload 36
    //   3602: invokeinterface 1068 2 0
    //   3607: iload_3
    //   3608: sipush 200
    //   3611: if_icmpeq +10 -> 3621
    //   3614: iload_3
    //   3615: sipush 206
    //   3618: if_icmpne +41 -> 3659
    //   3621: new 366	java/lang/StringBuilder
    //   3624: dup
    //   3625: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   3628: astore 19
    //   3630: aload 19
    //   3632: ldc_w 942
    //   3635: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3638: pop
    //   3639: aload 19
    //   3641: iconst_0
    //   3642: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3645: pop
    //   3646: aload_0
    //   3647: aload_1
    //   3648: ldc_w 944
    //   3651: aload 19
    //   3653: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3656: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3659: aload_2
    //   3660: ifnull +13 -> 3673
    //   3663: aload_2
    //   3664: getfield 553	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   3667: invokevirtual 176	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   3670: ifne +56 -> 3726
    //   3673: new 366	java/lang/StringBuilder
    //   3676: dup
    //   3677: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   3680: astore_2
    //   3681: aload_2
    //   3682: aload 34
    //   3684: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3687: pop
    //   3688: aload_2
    //   3689: aload_1
    //   3690: invokevirtual 947	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   3693: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3696: pop
    //   3697: aload_2
    //   3698: ldc_w 870
    //   3701: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3704: pop
    //   3705: aload_2
    //   3706: aload_1
    //   3707: invokevirtual 950	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   3710: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3713: pop
    //   3714: aload_0
    //   3715: aload_1
    //   3716: ldc_w 952
    //   3719: aload_2
    //   3720: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3723: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3726: aload_0
    //   3727: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   3730: ifnull +17 -> 3747
    //   3733: aload 29
    //   3735: ifnull +12 -> 3747
    //   3738: aload_0
    //   3739: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   3742: aload 29
    //   3744: invokevirtual 956	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   3747: lload 9
    //   3749: lconst_0
    //   3750: ladd
    //   3751: lconst_0
    //   3752: lcmp
    //   3753: ifeq +13 -> 3766
    //   3756: aload_1
    //   3757: invokevirtual 347	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   3760: aload 28
    //   3762: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3765: pop
    //   3766: aload 27
    //   3768: ifnull +11 -> 3779
    //   3771: aload 27
    //   3773: invokevirtual 958	java/io/OutputStream:close	()V
    //   3776: goto +3 -> 3779
    //   3779: aload 35
    //   3781: ifnull +14 -> 3795
    //   3784: aload 35
    //   3786: invokevirtual 961	java/net/HttpURLConnection:disconnect	()V
    //   3789: return
    //   3790: astore_1
    //   3791: aload_1
    //   3792: invokevirtual 673	java/lang/Exception:printStackTrace	()V
    //   3795: return
    //   3796: astore 20
    //   3798: goto -218 -> 3580
    //   3801: astore 28
    //   3803: aload 29
    //   3805: astore 23
    //   3807: aload 25
    //   3809: astore 22
    //   3811: goto -361 -> 3450
    //   3814: aload_1
    //   3815: getfield 1071	com/tencent/mobileqq/utils/httputils/HttpMsg:bReportRedirects	Z
    //   3818: istore 17
    //   3820: iload 17
    //   3822: ifeq +20 -> 3842
    //   3825: aload 33
    //   3827: aload 36
    //   3829: invokeinterface 1068 2 0
    //   3834: goto +8 -> 3842
    //   3837: astore 28
    //   3839: goto -36 -> 3803
    //   3842: aload_1
    //   3843: getfield 1074	com/tencent/mobileqq/utils/httputils/HttpMsg:mNeedNotReferer	Z
    //   3846: istore 17
    //   3848: iload 17
    //   3850: ifne +27 -> 3877
    //   3853: aload_1
    //   3854: ldc_w 1076
    //   3857: aload_1
    //   3858: invokevirtual 194	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrl	()Ljava/lang/String;
    //   3861: invokevirtual 1077	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   3864: goto +13 -> 3877
    //   3867: astore 20
    //   3869: goto -289 -> 3580
    //   3872: astore 28
    //   3874: goto -71 -> 3803
    //   3877: aload_1
    //   3878: aload 36
    //   3880: invokevirtual 1080	com/tencent/mobileqq/utils/httputils/HttpMsg:setUrl	(Ljava/lang/String;)V
    //   3883: aload_1
    //   3884: getfield 1083	com/tencent/mobileqq/utils/httputils/HttpMsg:mHaveIpConnect	Z
    //   3887: ifeq +1859 -> 5746
    //   3890: aload 36
    //   3892: invokestatic 1088	com/tencent/mobileqq/transfile/dns/BaseInnerDns:getHostFromUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   3895: astore 35
    //   3897: aload 35
    //   3899: invokestatic 1093	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3902: istore 17
    //   3904: iload 17
    //   3906: ifne +12 -> 3918
    //   3909: aload_1
    //   3910: ldc_w 499
    //   3913: aload 35
    //   3915: invokevirtual 1077	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   3918: new 366	java/lang/StringBuilder
    //   3921: dup
    //   3922: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   3925: astore 36
    //   3927: aload 36
    //   3929: ldc_w 1095
    //   3932: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3935: pop
    //   3936: aload 36
    //   3938: aload 35
    //   3940: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3943: pop
    //   3944: aload_0
    //   3945: aload_1
    //   3946: ldc_w 1060
    //   3949: aload 36
    //   3951: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3954: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   3957: goto +3 -> 3960
    //   3960: aload_1
    //   3961: ldc_w 1097
    //   3964: invokevirtual 1100	com/tencent/mobileqq/utils/httputils/HttpMsg:setRequestMethod	(Ljava/lang/String;)V
    //   3967: iload 5
    //   3969: iconst_1
    //   3970: iadd
    //   3971: istore 5
    //   3973: aload 34
    //   3975: astore 19
    //   3977: iload 4
    //   3979: istore_3
    //   3980: iconst_1
    //   3981: istore 17
    //   3983: aload 29
    //   3985: astore 23
    //   3987: aload 28
    //   3989: astore 20
    //   3991: aload 33
    //   3993: astore 26
    //   3995: aload 32
    //   3997: astore 24
    //   3999: aload 31
    //   4001: astore 28
    //   4003: aload 27
    //   4005: astore 22
    //   4007: aload 21
    //   4009: astore 27
    //   4011: goto -3946 -> 65
    //   4014: new 547	java/io/IOException
    //   4017: dup
    //   4018: ldc_w 1102
    //   4021: invokespecial 550	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   4024: athrow
    //   4025: new 186	java/lang/Exception
    //   4028: dup
    //   4029: ldc_w 1104
    //   4032: invokespecial 746	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   4035: athrow
    //   4036: astore 25
    //   4038: aload 22
    //   4040: astore 26
    //   4042: aload 25
    //   4044: astore 22
    //   4046: iload 4
    //   4048: istore_3
    //   4049: aload 26
    //   4051: astore 25
    //   4053: goto +22 -> 4075
    //   4056: aload 22
    //   4058: astore 25
    //   4060: astore 22
    //   4062: goto +38 -> 4100
    //   4065: astore 26
    //   4067: aload 22
    //   4069: astore 25
    //   4071: aload 26
    //   4073: astore 22
    //   4075: aload 25
    //   4077: astore 26
    //   4079: aload 22
    //   4081: astore 25
    //   4083: aload 26
    //   4085: astore 22
    //   4087: goto +45 -> 4132
    //   4090: astore 28
    //   4092: aload 22
    //   4094: astore 25
    //   4096: aload 28
    //   4098: astore 22
    //   4100: aload 26
    //   4102: astore 28
    //   4104: aload 22
    //   4106: astore 26
    //   4108: aload 21
    //   4110: astore 31
    //   4112: iconst_1
    //   4113: istore 17
    //   4115: aload 24
    //   4117: astore 21
    //   4119: aload 27
    //   4121: astore 22
    //   4123: aload 25
    //   4125: astore 27
    //   4127: goto +421 -> 4548
    //   4130: astore 25
    //   4132: aload 21
    //   4134: astore 28
    //   4136: aload 20
    //   4138: astore 31
    //   4140: iconst_0
    //   4141: istore 5
    //   4143: aconst_null
    //   4144: astore 26
    //   4146: iconst_1
    //   4147: istore 17
    //   4149: lconst_0
    //   4150: lstore 13
    //   4152: aconst_null
    //   4153: astore 32
    //   4155: aload 19
    //   4157: astore 21
    //   4159: iconst_0
    //   4160: istore 4
    //   4162: aload 24
    //   4164: astore 19
    //   4166: aload 23
    //   4168: astore 24
    //   4170: aload 25
    //   4172: astore 20
    //   4174: aload 22
    //   4176: astore 23
    //   4178: lload 9
    //   4180: lstore 11
    //   4182: aload 27
    //   4184: astore 29
    //   4186: aload 32
    //   4188: astore 25
    //   4190: lload 13
    //   4192: lstore 9
    //   4194: aload 28
    //   4196: astore 22
    //   4198: aload 31
    //   4200: astore 27
    //   4202: goto +1111 -> 5313
    //   4205: astore 29
    //   4207: aload 24
    //   4209: astore 22
    //   4211: aload 26
    //   4213: astore 28
    //   4215: aload 29
    //   4217: astore 26
    //   4219: lload 9
    //   4221: lstore 11
    //   4223: goto +33 -> 4256
    //   4226: astore 26
    //   4228: iconst_1
    //   4229: istore 17
    //   4231: goto +75 -> 4306
    //   4234: astore 29
    //   4236: aload 22
    //   4238: astore 27
    //   4240: lload 9
    //   4242: lstore 11
    //   4244: aload 26
    //   4246: astore 28
    //   4248: aload 24
    //   4250: astore 22
    //   4252: aload 29
    //   4254: astore 26
    //   4256: lconst_0
    //   4257: lstore 9
    //   4259: aconst_null
    //   4260: astore 24
    //   4262: iload_3
    //   4263: istore 4
    //   4265: aload 21
    //   4267: astore 31
    //   4269: aload 25
    //   4271: astore 32
    //   4273: aload 19
    //   4275: astore 21
    //   4277: iconst_0
    //   4278: istore_3
    //   4279: aconst_null
    //   4280: astore 25
    //   4282: iconst_1
    //   4283: istore 17
    //   4285: aload 22
    //   4287: astore 19
    //   4289: aload 27
    //   4291: astore 29
    //   4293: aload 32
    //   4295: astore 27
    //   4297: aload 31
    //   4299: astore 22
    //   4301: goto +411 -> 4712
    //   4304: astore 26
    //   4306: aload 20
    //   4308: astore 27
    //   4310: aload 21
    //   4312: astore 28
    //   4314: lconst_0
    //   4315: lstore 13
    //   4317: aconst_null
    //   4318: astore 31
    //   4320: aload 19
    //   4322: astore 21
    //   4324: iconst_0
    //   4325: istore 4
    //   4327: aload 23
    //   4329: astore 29
    //   4331: aload 24
    //   4333: astore 19
    //   4335: aload 25
    //   4337: astore 23
    //   4339: aconst_null
    //   4340: astore 32
    //   4342: iconst_0
    //   4343: istore 5
    //   4345: aload 26
    //   4347: astore 20
    //   4349: aload 29
    //   4351: astore 24
    //   4353: lload 9
    //   4355: lstore 11
    //   4357: aload 22
    //   4359: astore 29
    //   4361: aload 31
    //   4363: astore 25
    //   4365: lload 13
    //   4367: lstore 9
    //   4369: aload 32
    //   4371: astore 26
    //   4373: aload 28
    //   4375: astore 22
    //   4377: goto +936 -> 5313
    //   4380: astore 29
    //   4382: aload 21
    //   4384: astore 31
    //   4386: aload 25
    //   4388: astore 27
    //   4390: aload 19
    //   4392: astore 21
    //   4394: aload 26
    //   4396: astore 28
    //   4398: aload 24
    //   4400: astore 19
    //   4402: lconst_0
    //   4403: lstore 13
    //   4405: iload_3
    //   4406: istore 4
    //   4408: iconst_0
    //   4409: istore_3
    //   4410: aconst_null
    //   4411: astore 24
    //   4413: aconst_null
    //   4414: astore 25
    //   4416: aload 29
    //   4418: astore 26
    //   4420: lload 9
    //   4422: lstore 11
    //   4424: aload 22
    //   4426: astore 29
    //   4428: lload 13
    //   4430: lstore 9
    //   4432: aload 31
    //   4434: astore 22
    //   4436: goto +276 -> 4712
    //   4439: astore 26
    //   4441: aload 23
    //   4443: astore 21
    //   4445: aload 26
    //   4447: astore 23
    //   4449: aload 20
    //   4451: astore 28
    //   4453: aconst_null
    //   4454: astore 31
    //   4456: aload 19
    //   4458: astore 26
    //   4460: iconst_0
    //   4461: istore 4
    //   4463: aload 24
    //   4465: astore 19
    //   4467: aconst_null
    //   4468: astore 32
    //   4470: iconst_0
    //   4471: istore 5
    //   4473: lconst_0
    //   4474: lstore 13
    //   4476: aload 23
    //   4478: astore 20
    //   4480: aload 25
    //   4482: astore 23
    //   4484: aload 21
    //   4486: astore 24
    //   4488: aload 26
    //   4490: astore 21
    //   4492: lload 9
    //   4494: lstore 11
    //   4496: aload 22
    //   4498: astore 29
    //   4500: aload 31
    //   4502: astore 25
    //   4504: lload 13
    //   4506: lstore 9
    //   4508: aload 32
    //   4510: astore 26
    //   4512: aload 27
    //   4514: astore 22
    //   4516: aload 28
    //   4518: astore 27
    //   4520: goto +793 -> 5313
    //   4523: astore 29
    //   4525: aload 24
    //   4527: astore 21
    //   4529: aload 27
    //   4531: astore 31
    //   4533: aload 25
    //   4535: astore 27
    //   4537: aload 26
    //   4539: astore 28
    //   4541: iload_3
    //   4542: istore 4
    //   4544: aload 29
    //   4546: astore 26
    //   4548: aconst_null
    //   4549: astore 25
    //   4551: aconst_null
    //   4552: astore 29
    //   4554: aload 19
    //   4556: astore 24
    //   4558: iconst_0
    //   4559: istore_3
    //   4560: lconst_0
    //   4561: lstore 13
    //   4563: aload 21
    //   4565: astore 19
    //   4567: aload 24
    //   4569: astore 21
    //   4571: aload 29
    //   4573: astore 24
    //   4575: lload 9
    //   4577: lstore 11
    //   4579: aload 22
    //   4581: astore 29
    //   4583: lload 13
    //   4585: lstore 9
    //   4587: aload 31
    //   4589: astore 22
    //   4591: goto +121 -> 4712
    //   4594: astore 20
    //   4596: ldc_w 872
    //   4599: astore 21
    //   4601: ldc_w 344
    //   4604: astore 27
    //   4606: ldc_w 866
    //   4609: astore 19
    //   4611: lconst_0
    //   4612: lstore 11
    //   4614: lload 11
    //   4616: lstore 9
    //   4618: ldc_w 868
    //   4621: astore 23
    //   4623: iconst_m1
    //   4624: istore_3
    //   4625: aconst_null
    //   4626: astore 24
    //   4628: iconst_0
    //   4629: istore 4
    //   4631: aconst_null
    //   4632: astore 29
    //   4634: aconst_null
    //   4635: astore 25
    //   4637: iconst_0
    //   4638: istore 17
    //   4640: aconst_null
    //   4641: astore 26
    //   4643: iconst_0
    //   4644: istore 5
    //   4646: aconst_null
    //   4647: astore 22
    //   4649: goto +664 -> 5313
    //   4652: astore 31
    //   4654: ldc_w 868
    //   4657: astore 27
    //   4659: ldc_w 872
    //   4662: astore 21
    //   4664: ldc_w 344
    //   4667: astore 20
    //   4669: ldc_w 866
    //   4672: astore 19
    //   4674: lconst_0
    //   4675: lstore 11
    //   4677: lload 11
    //   4679: lstore 9
    //   4681: iconst_0
    //   4682: istore_3
    //   4683: iconst_m1
    //   4684: istore 4
    //   4686: aconst_null
    //   4687: astore 23
    //   4689: aconst_null
    //   4690: astore 24
    //   4692: aconst_null
    //   4693: astore 29
    //   4695: aconst_null
    //   4696: astore 25
    //   4698: iconst_0
    //   4699: istore 17
    //   4701: aconst_null
    //   4702: astore 22
    //   4704: aload 26
    //   4706: astore 28
    //   4708: aload 31
    //   4710: astore 26
    //   4712: aload 26
    //   4714: instanceof 547
    //   4717: istore 18
    //   4719: iload 18
    //   4721: ifeq +144 -> 4865
    //   4724: aload 22
    //   4726: ifnull +139 -> 4865
    //   4729: aload 22
    //   4731: invokevirtual 1107	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   4734: astore 31
    //   4736: sipush 10240
    //   4739: newarray byte
    //   4741: astore 32
    //   4743: aload 31
    //   4745: ifnull +20 -> 4765
    //   4748: aload 31
    //   4750: aload 32
    //   4752: invokevirtual 1110	java/io/InputStream:read	([B)I
    //   4755: istore 5
    //   4757: iload 5
    //   4759: ifle +6 -> 4765
    //   4762: goto -14 -> 4748
    //   4765: aload 31
    //   4767: ifnull +98 -> 4865
    //   4770: goto +37 -> 4807
    //   4773: astore 26
    //   4775: goto +11 -> 4786
    //   4778: goto +24 -> 4802
    //   4781: astore 26
    //   4783: aconst_null
    //   4784: astore 31
    //   4786: aload 31
    //   4788: ifnull +8 -> 4796
    //   4791: aload 31
    //   4793: invokevirtual 1058	java/io/InputStream:close	()V
    //   4796: aload 26
    //   4798: athrow
    //   4799: aconst_null
    //   4800: astore 31
    //   4802: aload 31
    //   4804: ifnull +61 -> 4865
    //   4807: aload 31
    //   4809: invokevirtual 1058	java/io/InputStream:close	()V
    //   4812: goto +53 -> 4865
    //   4815: astore 32
    //   4817: aload 20
    //   4819: astore 28
    //   4821: aload 23
    //   4823: astore 31
    //   4825: aload 24
    //   4827: astore 26
    //   4829: iload_3
    //   4830: istore 5
    //   4832: aload 27
    //   4834: astore 23
    //   4836: iconst_1
    //   4837: istore 6
    //   4839: iload 4
    //   4841: istore_3
    //   4842: aload 32
    //   4844: astore 20
    //   4846: aload 31
    //   4848: astore 24
    //   4850: iload 5
    //   4852: istore 4
    //   4854: iload 6
    //   4856: istore 5
    //   4858: aload 28
    //   4860: astore 27
    //   4862: goto +451 -> 5313
    //   4865: iconst_1
    //   4866: istore 5
    //   4868: aload_0
    //   4869: iload 17
    //   4871: iload 4
    //   4873: aload 22
    //   4875: aload_1
    //   4876: aload 26
    //   4878: invokevirtual 1114	com/tencent/mobileqq/transfile/HttpCommunicator:setExceptionInfo	(ZILjava/net/HttpURLConnection;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/Throwable;)V
    //   4881: iload 17
    //   4883: ifeq +57 -> 4940
    //   4886: iload 4
    //   4888: sipush 200
    //   4891: if_icmpeq +11 -> 4902
    //   4894: iload 4
    //   4896: sipush 206
    //   4899: if_icmpne +41 -> 4940
    //   4902: new 366	java/lang/StringBuilder
    //   4905: dup
    //   4906: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   4909: astore 26
    //   4911: aload 26
    //   4913: ldc_w 942
    //   4916: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4919: pop
    //   4920: aload 26
    //   4922: iload_3
    //   4923: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4926: pop
    //   4927: aload_0
    //   4928: aload_1
    //   4929: ldc_w 944
    //   4932: aload 26
    //   4934: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4937: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   4940: aload_2
    //   4941: ifnull +13 -> 4954
    //   4944: aload_2
    //   4945: getfield 553	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   4948: invokevirtual 176	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   4951: ifne +129 -> 5080
    //   4954: new 366	java/lang/StringBuilder
    //   4957: dup
    //   4958: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   4961: astore 26
    //   4963: aload 26
    //   4965: aload 21
    //   4967: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4970: pop
    //   4971: aload 26
    //   4973: aload_1
    //   4974: invokevirtual 947	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   4977: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4980: pop
    //   4981: aload 26
    //   4983: aload 30
    //   4985: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4988: pop
    //   4989: aload 26
    //   4991: aload_1
    //   4992: invokevirtual 950	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   4995: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4998: pop
    //   4999: aload_0
    //   5000: aload_1
    //   5001: ldc_w 952
    //   5004: aload 26
    //   5006: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5009: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   5012: aload_1
    //   5013: getfield 1055	com/tencent/mobileqq/utils/httputils/HttpMsg:errCode	I
    //   5016: sipush -9527
    //   5019: if_icmpne +61 -> 5080
    //   5022: new 366	java/lang/StringBuilder
    //   5025: dup
    //   5026: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   5029: astore 21
    //   5031: aload 21
    //   5033: aload 27
    //   5035: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5038: pop
    //   5039: aload 21
    //   5041: aload_1
    //   5042: getfield 457	com/tencent/mobileqq/utils/httputils/HttpMsg:rawReqHeader	Ljava/lang/String;
    //   5045: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5048: pop
    //   5049: aload 21
    //   5051: aload 19
    //   5053: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5056: pop
    //   5057: aload 21
    //   5059: aload_1
    //   5060: getfield 624	com/tencent/mobileqq/utils/httputils/HttpMsg:rawRespHeader	Ljava/lang/String;
    //   5063: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5066: pop
    //   5067: aload_0
    //   5068: aload_1
    //   5069: ldc_w 1057
    //   5072: aload 21
    //   5074: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5077: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   5080: aload_0
    //   5081: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   5084: ifnull +17 -> 5101
    //   5087: aload 23
    //   5089: ifnull +12 -> 5101
    //   5092: aload_0
    //   5093: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   5096: aload 23
    //   5098: invokevirtual 956	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   5101: lload 11
    //   5103: lload 9
    //   5105: ladd
    //   5106: lconst_0
    //   5107: lcmp
    //   5108: ifeq +13 -> 5121
    //   5111: aload_1
    //   5112: invokevirtual 347	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   5115: aload 20
    //   5117: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5120: pop
    //   5121: aload 25
    //   5123: ifnull +11 -> 5134
    //   5126: aload 25
    //   5128: invokevirtual 1052	java/io/ByteArrayOutputStream:close	()V
    //   5131: goto +3 -> 5134
    //   5134: aload 24
    //   5136: ifnull +11 -> 5147
    //   5139: aload 24
    //   5141: invokevirtual 1058	java/io/InputStream:close	()V
    //   5144: goto +3 -> 5147
    //   5147: aload 29
    //   5149: ifnull +11 -> 5160
    //   5152: aload 29
    //   5154: invokevirtual 958	java/io/OutputStream:close	()V
    //   5157: goto +3 -> 5160
    //   5160: iload 5
    //   5162: istore_3
    //   5163: aload 28
    //   5165: astore 19
    //   5167: aload 22
    //   5169: ifnull +32 -> 5201
    //   5172: aload 22
    //   5174: invokevirtual 961	java/net/HttpURLConnection:disconnect	()V
    //   5177: iload 5
    //   5179: istore_3
    //   5180: aload 28
    //   5182: astore 19
    //   5184: goto +17 -> 5201
    //   5187: astore 19
    //   5189: aload 19
    //   5191: invokevirtual 673	java/lang/Exception:printStackTrace	()V
    //   5194: aload 28
    //   5196: astore 19
    //   5198: iload 5
    //   5200: istore_3
    //   5201: aload_2
    //   5202: ifnull +13 -> 5215
    //   5205: aload_2
    //   5206: getfield 553	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   5209: invokevirtual 176	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   5212: ifne +52 -> 5264
    //   5215: aload_1
    //   5216: getfield 537	com/tencent/mobileqq/utils/httputils/HttpMsg:mIsCancel	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   5219: invokevirtual 176	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   5222: ifne +42 -> 5264
    //   5225: iload_3
    //   5226: ifeq +13 -> 5239
    //   5229: aload 19
    //   5231: aload_1
    //   5232: aload_1
    //   5233: invokeinterface 600 3 0
    //   5238: return
    //   5239: aload 19
    //   5241: aload_1
    //   5242: aload_1
    //   5243: iconst_5
    //   5244: invokeinterface 528 4 0
    //   5249: pop
    //   5250: return
    //   5251: astore_2
    //   5252: aload_0
    //   5253: aload_1
    //   5254: ldc_w 1116
    //   5257: aload_2
    //   5258: invokestatic 1122	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   5261: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   5264: return
    //   5265: astore 28
    //   5267: goto +5 -> 5272
    //   5270: astore 28
    //   5272: aload 20
    //   5274: astore 26
    //   5276: aload 23
    //   5278: astore 20
    //   5280: aload 27
    //   5282: astore 23
    //   5284: iload 4
    //   5286: istore 6
    //   5288: iconst_1
    //   5289: istore 5
    //   5291: aload 26
    //   5293: astore 27
    //   5295: aload 24
    //   5297: astore 26
    //   5299: iload_3
    //   5300: istore 4
    //   5302: aload 20
    //   5304: astore 24
    //   5306: iload 6
    //   5308: istore_3
    //   5309: aload 28
    //   5311: astore 20
    //   5313: iload 17
    //   5315: ifeq +56 -> 5371
    //   5318: iload_3
    //   5319: sipush 200
    //   5322: if_icmpeq +10 -> 5332
    //   5325: iload_3
    //   5326: sipush 206
    //   5329: if_icmpne +42 -> 5371
    //   5332: new 366	java/lang/StringBuilder
    //   5335: dup
    //   5336: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   5339: astore 28
    //   5341: aload 28
    //   5343: ldc_w 942
    //   5346: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5349: pop
    //   5350: aload 28
    //   5352: iload 4
    //   5354: invokevirtual 376	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5357: pop
    //   5358: aload_0
    //   5359: aload_1
    //   5360: ldc_w 944
    //   5363: aload 28
    //   5365: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5368: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   5371: aload_2
    //   5372: ifnull +13 -> 5385
    //   5375: aload_2
    //   5376: getfield 553	com/tencent/mobileqq/transfile/HttpCommunicator$HttpCommunicatorHandler:forceFinish	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   5379: invokevirtual 176	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   5382: ifne +122 -> 5504
    //   5385: new 366	java/lang/StringBuilder
    //   5388: dup
    //   5389: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   5392: astore_2
    //   5393: aload_2
    //   5394: aload 21
    //   5396: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5399: pop
    //   5400: aload_2
    //   5401: aload_1
    //   5402: invokevirtual 947	com/tencent/mobileqq/utils/httputils/HttpMsg:getErrorString	()Ljava/lang/String;
    //   5405: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5408: pop
    //   5409: aload_2
    //   5410: aload 30
    //   5412: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5415: pop
    //   5416: aload_2
    //   5417: aload_1
    //   5418: invokevirtual 950	com/tencent/mobileqq/utils/httputils/HttpMsg:getUrlForLog	()Ljava/lang/String;
    //   5421: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5424: pop
    //   5425: aload_0
    //   5426: aload_1
    //   5427: ldc_w 952
    //   5430: aload_2
    //   5431: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5434: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   5437: iload 5
    //   5439: ifeq +65 -> 5504
    //   5442: aload_1
    //   5443: getfield 1055	com/tencent/mobileqq/utils/httputils/HttpMsg:errCode	I
    //   5446: sipush -9527
    //   5449: if_icmpne +55 -> 5504
    //   5452: new 366	java/lang/StringBuilder
    //   5455: dup
    //   5456: invokespecial 367	java/lang/StringBuilder:<init>	()V
    //   5459: astore_2
    //   5460: aload_2
    //   5461: aload 23
    //   5463: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5466: pop
    //   5467: aload_2
    //   5468: aload_1
    //   5469: getfield 457	com/tencent/mobileqq/utils/httputils/HttpMsg:rawReqHeader	Ljava/lang/String;
    //   5472: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5475: pop
    //   5476: aload_2
    //   5477: aload 19
    //   5479: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5482: pop
    //   5483: aload_2
    //   5484: aload_1
    //   5485: getfield 624	com/tencent/mobileqq/utils/httputils/HttpMsg:rawRespHeader	Ljava/lang/String;
    //   5488: invokevirtual 373	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5491: pop
    //   5492: aload_0
    //   5493: aload_1
    //   5494: ldc_w 1057
    //   5497: aload_2
    //   5498: invokevirtual 401	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5501: invokevirtual 405	com/tencent/mobileqq/transfile/HttpCommunicator:logHttpCommunicator	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Ljava/lang/String;Ljava/lang/String;)V
    //   5504: aload_0
    //   5505: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   5508: ifnull +17 -> 5525
    //   5511: aload 24
    //   5513: ifnull +12 -> 5525
    //   5516: aload_0
    //   5517: getfield 74	com/tencent/mobileqq/transfile/HttpCommunicator:mTimeoutCheckHandler	Lmqq/os/MqqHandler;
    //   5520: aload 24
    //   5522: invokevirtual 956	mqq/os/MqqHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   5525: lload 11
    //   5527: lload 9
    //   5529: ladd
    //   5530: lconst_0
    //   5531: lcmp
    //   5532: ifeq +13 -> 5545
    //   5535: aload_1
    //   5536: invokevirtual 347	com/tencent/mobileqq/utils/httputils/HttpMsg:getRequestMethod	()Ljava/lang/String;
    //   5539: aload 27
    //   5541: invokevirtual 262	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   5544: pop
    //   5545: aload 25
    //   5547: ifnull +11 -> 5558
    //   5550: aload 25
    //   5552: invokevirtual 1052	java/io/ByteArrayOutputStream:close	()V
    //   5555: goto +3 -> 5558
    //   5558: aload 26
    //   5560: ifnull +11 -> 5571
    //   5563: aload 26
    //   5565: invokevirtual 1058	java/io/InputStream:close	()V
    //   5568: goto +3 -> 5571
    //   5571: aload 29
    //   5573: ifnull +11 -> 5584
    //   5576: aload 29
    //   5578: invokevirtual 958	java/io/OutputStream:close	()V
    //   5581: goto +3 -> 5584
    //   5584: aload 22
    //   5586: ifnull +16 -> 5602
    //   5589: aload 22
    //   5591: invokevirtual 961	java/net/HttpURLConnection:disconnect	()V
    //   5594: goto +8 -> 5602
    //   5597: astore_1
    //   5598: aload_1
    //   5599: invokevirtual 673	java/lang/Exception:printStackTrace	()V
    //   5602: goto +6 -> 5608
    //   5605: aload 20
    //   5607: athrow
    //   5608: goto -3 -> 5605
    //   5611: astore_1
    //   5612: goto -4767 -> 845
    //   5615: astore_1
    //   5616: goto -4293 -> 1323
    //   5619: astore 19
    //   5621: goto -2450 -> 3171
    //   5624: astore 19
    //   5626: goto -2442 -> 3184
    //   5629: astore 19
    //   5631: goto -2434 -> 3197
    //   5634: astore 37
    //   5636: goto -2049 -> 3587
    //   5639: astore_1
    //   5640: goto -1861 -> 3779
    //   5643: astore 31
    //   5645: goto -846 -> 4799
    //   5648: astore 32
    //   5650: goto -872 -> 4778
    //   5653: astore 28
    //   5655: goto -859 -> 4796
    //   5658: astore 31
    //   5660: goto -795 -> 4865
    //   5663: astore 19
    //   5665: goto -531 -> 5134
    //   5668: astore 19
    //   5670: goto -523 -> 5147
    //   5673: astore 19
    //   5675: goto -515 -> 5160
    //   5678: astore_1
    //   5679: goto -121 -> 5558
    //   5682: astore_1
    //   5683: goto -112 -> 5571
    //   5686: astore_1
    //   5687: goto -103 -> 5584
    //   5690: astore 22
    //   5692: aload 23
    //   5694: astore 26
    //   5696: aload 22
    //   5698: astore 23
    //   5700: aload 26
    //   5702: astore 22
    //   5704: goto -5232 -> 472
    //   5707: astore 24
    //   5709: goto -5351 -> 358
    //   5712: iload 6
    //   5714: iconst_1
    //   5715: iadd
    //   5716: istore 6
    //   5718: goto -4124 -> 1594
    //   5721: aload 34
    //   5723: astore 25
    //   5725: aload 30
    //   5727: astore 19
    //   5729: iconst_0
    //   5730: istore 6
    //   5732: goto -3687 -> 2045
    //   5735: aload 34
    //   5737: astore 25
    //   5739: aload 30
    //   5741: astore 19
    //   5743: goto -3698 -> 2045
    //   5746: goto -1786 -> 3960
    //   5749: astore 25
    //   5751: goto +10 -> 5761
    //   5754: astore 22
    //   5756: goto +10 -> 5766
    //   5759: astore 25
    //   5761: goto -1723 -> 4038
    //   5764: astore 22
    //   5766: goto -1666 -> 4100
    //   5769: astore 25
    //   5771: goto +10 -> 5781
    //   5774: astore 25
    //   5776: goto +10 -> 5786
    //   5779: astore 25
    //   5781: goto -1743 -> 4038
    //   5784: astore 25
    //   5786: goto +18 -> 5804
    //   5789: astore 25
    //   5791: aload 22
    //   5793: astore 26
    //   5795: aload 25
    //   5797: astore 22
    //   5799: goto -1720 -> 4079
    //   5802: astore 25
    //   5804: aload 22
    //   5806: astore 28
    //   5808: aload 25
    //   5810: astore 22
    //   5812: aload 28
    //   5814: astore 25
    //   5816: goto -1716 -> 4100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5819	0	this	HttpCommunicator
    //   0	5819	1	paramHttpMsg	HttpMsg
    //   0	5819	2	paramHttpCommunicatorHandler	HttpCommunicator.HttpCommunicatorHandler
    //   61	5269	3	i	int
    //   226	5127	4	j	int
    //   58	5380	5	k	int
    //   231	5500	6	m	int
    //   2060	484	7	n	int
    //   2117	444	8	i1	int
    //   55	5473	9	l1	long
    //   323	5203	11	l2	long
    //   395	4189	13	l3	long
    //   2113	459	15	l4	long
    //   63	5251	17	bool1	boolean
    //   4717	3	18	bool2	boolean
    //   23	3087	19	localObject1	Object
    //   3210	3	19	localException1	Exception
    //   3222	1961	19	localObject2	Object
    //   5187	3	19	localException2	Exception
    //   5196	282	19	localObject3	Object
    //   5619	1	19	localIOException1	IOException
    //   5624	1	19	localIOException2	IOException
    //   5629	1	19	localIOException3	IOException
    //   5663	1	19	localIOException4	IOException
    //   5668	1	19	localIOException5	IOException
    //   5673	1	19	localIOException6	IOException
    //   5727	15	19	localObject4	Object
    //   28	3125	20	localObject5	Object
    //   3227	1	20	localObject6	Object
    //   3284	170	20	localObject7	Object
    //   3578	1	20	localObject8	Object
    //   3796	1	20	localObject9	Object
    //   3867	1	20	localObject10	Object
    //   3989	490	20	localObject11	Object
    //   4594	1	20	localObject12	Object
    //   4667	939	20	localObject13	Object
    //   86	5309	21	localObject14	Object
    //   44	4013	22	localObject15	Object
    //   4060	8	22	localThrowable1	Throwable
    //   4073	1517	22	localObject16	Object
    //   5690	7	22	localObject17	Object
    //   5702	1	22	localObject18	Object
    //   5754	1	22	localThrowable2	Throwable
    //   5764	28	22	localThrowable3	Throwable
    //   5797	14	22	localObject19	Object
    //   48	418	23	localObject20	Object
    //   470	1	23	localObject21	Object
    //   479	11	23	localThrowable4	Throwable
    //   498	1	23	localObject22	Object
    //   511	1	23	localObject23	Object
    //   535	2233	23	localObject24	Object
    //   2817	317	23	localRunnable	Runnable
    //   3276	2423	23	localObject25	Object
    //   3	147	24	str	String
    //   356	45	24	localThrowable5	Throwable
    //   413	1	24	localObject26	Object
    //   443	21	24	localThrowable6	Throwable
    //   487	5034	24	localObject27	Object
    //   5707	1	24	localThrowable7	Throwable
    //   8	616	25	localObject28	Object
    //   862	41	25	localObject29	Object
    //   920	452	25	localObject30	Object
    //   1380	1	25	localObject31	Object
    //   1388	1	25	localObject32	Object
    //   1578	1703	25	localObject33	Object
    //   3342	1	25	localThrowable8	Throwable
    //   3347	1	25	localObject34	Object
    //   3352	1	25	localThrowable9	Throwable
    //   3357	7	25	localObject35	Object
    //   3378	1	25	localObject36	Object
    //   3444	3	25	localThrowable10	Throwable
    //   3502	306	25	localObject37	Object
    //   4036	7	25	localObject38	Object
    //   4051	73	25	localObject39	Object
    //   4130	41	25	localObject40	Object
    //   4188	1550	25	localObject41	Object
    //   5749	1	25	localObject42	Object
    //   5759	1	25	localObject43	Object
    //   5769	1	25	localObject44	Object
    //   5774	1	25	localThrowable11	Throwable
    //   5779	1	25	localObject45	Object
    //   5784	1	25	localThrowable12	Throwable
    //   5789	7	25	localObject46	Object
    //   5802	7	25	localThrowable13	Throwable
    //   5814	1	25	localObject47	Object
    //   34	369	26	localObject48	Object
    //   438	15	26	localObject49	Object
    //   474	51	26	localObject50	Object
    //   544	37	26	localObject51	Object
    //   590	1309	26	localObject52	Object
    //   1982	1	26	localObject53	Object
    //   2541	11	26	localObject54	Object
    //   2558	1	26	localThrowable14	Throwable
    //   2578	15	26	localObject55	Object
    //   2603	1	26	localThrowable15	Throwable
    //   2662	10	26	localObject56	Object
    //   2685	1	26	localObject57	Object
    //   2748	1	26	localThrowable16	Throwable
    //   2821	1	26	localObject58	Object
    //   2830	1	26	localThrowable17	Throwable
    //   2844	377	26	localThrowable18	Throwable
    //   3231	29	26	localObject59	Object
    //   3268	1	26	localThrowable19	Throwable
    //   3381	669	26	localObject60	Object
    //   4065	7	26	localObject61	Object
    //   4077	141	26	localObject62	Object
    //   4226	19	26	localObject63	Object
    //   4254	1	26	localObject64	Object
    //   4304	42	26	localObject65	Object
    //   4371	48	26	localObject66	Object
    //   4439	7	26	localObject67	Object
    //   4458	255	26	localObject68	Object
    //   4773	1	26	localObject69	Object
    //   4781	16	26	localObject70	Object
    //   4827	967	26	localObject71	Object
    //   52	488	27	localObject72	Object
    //   549	40	27	localThrowable20	Throwable
    //   610	4930	27	localObject73	Object
    //   13	471	28	localObject74	Object
    //   531	7	28	localThrowable21	Throwable
    //   582	349	28	localObject75	Object
    //   937	33	28	localThrowable22	Throwable
    //   975	377	28	localObject76	Object
    //   1393	1	28	localThrowable23	Throwable
    //   1403	251	28	localObject77	Object
    //   1692	13	28	localObject78	Object
    //   1710	59	28	localObject79	Object
    //   1775	1	28	localThrowable24	Throwable
    //   1822	1	28	localObject80	Object
    //   1827	1	28	localThrowable25	Throwable
    //   1839	994	28	localObject81	Object
    //   2839	1	28	localObject82	Object
    //   2855	906	28	localObject83	Object
    //   3801	1	28	localThrowable26	Throwable
    //   3837	1	28	localThrowable27	Throwable
    //   3872	116	28	localThrowable28	Throwable
    //   4001	1	28	localObject84	Object
    //   4090	7	28	localThrowable29	Throwable
    //   4102	1093	28	localObject85	Object
    //   5265	1	28	localObject86	Object
    //   5270	40	28	localObject87	Object
    //   5339	25	28	localStringBuilder	StringBuilder
    //   5653	1	28	localIOException7	IOException
    //   5806	7	28	localObject88	Object
    //   151	4034	29	localObject89	Object
    //   4205	11	29	localThrowable30	Throwable
    //   4234	19	29	localThrowable31	Throwable
    //   4291	69	29	localObject90	Object
    //   4380	37	29	localThrowable32	Throwable
    //   4426	73	29	localObject91	Object
    //   4523	22	29	localThrowable33	Throwable
    //   4552	1025	29	localObject92	Object
    //   18	5722	30	localObject93	Object
    //   155	4433	31	localObject94	Object
    //   4652	57	31	localThrowable34	Throwable
    //   4734	113	31	localObject95	Object
    //   5643	1	31	localException3	Exception
    //   5658	1	31	localIOException8	IOException
    //   172	1731	32	localObject96	Object
    //   1987	645	32	localThrowable35	Throwable
    //   2699	2052	32	localObject97	Object
    //   4815	28	32	localObject98	Object
    //   5648	1	32	localException4	Exception
    //   192	3800	33	localObject99	Object
    //   2079	3657	34	localObject100	Object
    //   2025	1914	35	localObject101	Object
    //   2029	1921	36	localObject102	Object
    //   1977	528	37	arrayOfByte1	byte[]
    //   5634	1	37	localThrowable36	Throwable
    //   1938	565	38	localByteArrayPool	com.tencent.commonsdk.pool.ByteArrayPool
    //   2282	47	39	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   194	225	356	java/lang/Throwable
    //   228	233	356	java/lang/Throwable
    //   301	311	356	java/lang/Throwable
    //   311	330	356	java/lang/Throwable
    //   185	194	438	finally
    //   194	225	438	finally
    //   228	233	438	finally
    //   301	311	438	finally
    //   311	330	438	finally
    //   185	194	443	java/lang/Throwable
    //   157	181	470	finally
    //   157	181	479	java/lang/Throwable
    //   143	149	511	finally
    //   143	149	531	java/lang/Throwable
    //   131	143	544	finally
    //   131	143	549	java/lang/Throwable
    //   792	799	856	java/lang/Exception
    //   804	813	856	java/lang/Exception
    //   822	832	856	java/lang/Exception
    //   837	842	856	java/lang/Exception
    //   850	855	856	java/lang/Exception
    //   659	668	862	finally
    //   1020	1029	862	finally
    //   1467	1493	862	finally
    //   1534	1543	862	finally
    //   659	668	937	java/lang/Throwable
    //   1020	1029	937	java/lang/Throwable
    //   1467	1493	937	java/lang/Throwable
    //   1534	1543	937	java/lang/Throwable
    //   1270	1277	1334	java/lang/Exception
    //   1282	1291	1334	java/lang/Exception
    //   1300	1310	1334	java/lang/Exception
    //   1315	1320	1334	java/lang/Exception
    //   1328	1333	1334	java/lang/Exception
    //   1340	1348	1380	finally
    //   1108	1151	1388	finally
    //   1108	1151	1393	java/lang/Throwable
    //   1340	1348	1393	java/lang/Throwable
    //   1435	1458	1692	finally
    //   1501	1512	1692	finally
    //   1571	1591	1692	finally
    //   1435	1458	1775	java/lang/Throwable
    //   1501	1512	1775	java/lang/Throwable
    //   1571	1591	1775	java/lang/Throwable
    //   1613	1630	1822	finally
    //   1633	1692	1822	finally
    //   1797	1809	1822	finally
    //   1812	1822	1822	finally
    //   1886	1898	1822	finally
    //   1613	1630	1827	java/lang/Throwable
    //   1633	1692	1827	java/lang/Throwable
    //   1797	1809	1827	java/lang/Throwable
    //   1812	1822	1827	java/lang/Throwable
    //   1886	1898	1827	java/lang/Throwable
    //   1969	1979	1982	finally
    //   1969	1979	1987	java/lang/Throwable
    //   2119	2127	2541	finally
    //   2143	2150	2541	finally
    //   2166	2172	2541	finally
    //   2188	2197	2541	finally
    //   2216	2223	2541	finally
    //   2250	2257	2541	finally
    //   2278	2284	2541	finally
    //   2300	2311	2541	finally
    //   2327	2333	2541	finally
    //   2349	2358	2541	finally
    //   2382	2392	2541	finally
    //   2408	2413	2541	finally
    //   2429	2438	2541	finally
    //   2454	2463	2541	finally
    //   2479	2486	2541	finally
    //   2502	2509	2541	finally
    //   2525	2530	2541	finally
    //   2119	2127	2558	java/lang/Throwable
    //   2143	2150	2558	java/lang/Throwable
    //   2166	2172	2558	java/lang/Throwable
    //   2188	2197	2558	java/lang/Throwable
    //   2216	2223	2558	java/lang/Throwable
    //   2250	2257	2558	java/lang/Throwable
    //   2278	2284	2558	java/lang/Throwable
    //   2300	2311	2558	java/lang/Throwable
    //   2327	2333	2558	java/lang/Throwable
    //   2349	2358	2558	java/lang/Throwable
    //   2382	2392	2558	java/lang/Throwable
    //   2408	2413	2558	java/lang/Throwable
    //   2429	2438	2558	java/lang/Throwable
    //   2454	2463	2558	java/lang/Throwable
    //   2479	2486	2558	java/lang/Throwable
    //   2502	2509	2558	java/lang/Throwable
    //   2525	2530	2558	java/lang/Throwable
    //   2045	2062	2578	finally
    //   2067	2073	2578	finally
    //   2045	2062	2603	java/lang/Throwable
    //   2067	2073	2603	java/lang/Throwable
    //   1958	1964	2662	finally
    //   2016	2023	2662	finally
    //   1958	1964	2748	java/lang/Throwable
    //   2016	2023	2748	java/lang/Throwable
    //   1935	1958	2817	finally
    //   1935	1958	2830	java/lang/Throwable
    //   1924	1931	2839	finally
    //   1924	1931	2844	java/lang/Throwable
    //   3117	3124	3210	java/lang/Exception
    //   3129	3138	3210	java/lang/Exception
    //   3148	3158	3210	java/lang/Exception
    //   3163	3168	3210	java/lang/Exception
    //   3176	3181	3210	java/lang/Exception
    //   3189	3194	3210	java/lang/Exception
    //   3202	3207	3210	java/lang/Exception
    //   2905	2916	3227	finally
    //   2905	2916	3268	java/lang/Throwable
    //   1902	1914	3342	java/lang/Throwable
    //   1784	1790	3347	finally
    //   1832	1879	3347	finally
    //   1902	1914	3347	finally
    //   1784	1790	3352	java/lang/Throwable
    //   1832	1879	3352	java/lang/Throwable
    //   1084	1091	3357	finally
    //   1398	1405	3357	finally
    //   1417	1424	3357	finally
    //   1424	1430	3357	finally
    //   1084	1091	3444	java/lang/Throwable
    //   1398	1405	3444	java/lang/Throwable
    //   1417	1424	3444	java/lang/Throwable
    //   1424	1430	3444	java/lang/Throwable
    //   3565	3570	3578	finally
    //   3570	3575	3578	finally
    //   3825	3834	3578	finally
    //   3726	3733	3790	java/lang/Exception
    //   3738	3747	3790	java/lang/Exception
    //   3756	3766	3790	java/lang/Exception
    //   3771	3776	3790	java/lang/Exception
    //   3784	3789	3790	java/lang/Exception
    //   3598	3607	3796	finally
    //   3598	3607	3801	java/lang/Throwable
    //   3825	3834	3837	java/lang/Throwable
    //   3853	3864	3867	finally
    //   3909	3918	3867	finally
    //   3853	3864	3872	java/lang/Throwable
    //   3909	3918	3872	java/lang/Throwable
    //   3927	3957	4036	finally
    //   3960	3967	4036	finally
    //   4014	4025	4036	finally
    //   4025	4036	4036	finally
    //   3927	3957	4056	java/lang/Throwable
    //   3960	3967	4056	java/lang/Throwable
    //   4014	4025	4056	java/lang/Throwable
    //   4025	4036	4056	java/lang/Throwable
    //   647	655	4065	finally
    //   1004	1010	4065	finally
    //   1029	1067	4065	finally
    //   647	655	4090	java/lang/Throwable
    //   1004	1010	4090	java/lang/Throwable
    //   1029	1067	4090	java/lang/Throwable
    //   631	644	4130	finally
    //   631	644	4205	java/lang/Throwable
    //   111	126	4226	finally
    //   111	126	4234	java/lang/Throwable
    //   88	111	4304	finally
    //   88	111	4380	java/lang/Throwable
    //   65	88	4439	finally
    //   65	88	4523	java/lang/Throwable
    //   36	43	4594	finally
    //   36	43	4652	java/lang/Throwable
    //   4736	4743	4773	finally
    //   4748	4757	4773	finally
    //   4729	4736	4781	finally
    //   4791	4796	4815	finally
    //   4796	4799	4815	finally
    //   4807	4812	4815	finally
    //   5080	5087	5187	java/lang/Exception
    //   5092	5101	5187	java/lang/Exception
    //   5111	5121	5187	java/lang/Exception
    //   5126	5131	5187	java/lang/Exception
    //   5139	5144	5187	java/lang/Exception
    //   5152	5157	5187	java/lang/Exception
    //   5172	5177	5187	java/lang/Exception
    //   5229	5238	5251	java/lang/Exception
    //   5239	5250	5251	java/lang/Exception
    //   4868	4881	5265	finally
    //   4712	4719	5270	finally
    //   5504	5511	5597	java/lang/Exception
    //   5516	5525	5597	java/lang/Exception
    //   5535	5545	5597	java/lang/Exception
    //   5550	5555	5597	java/lang/Exception
    //   5563	5568	5597	java/lang/Exception
    //   5576	5581	5597	java/lang/Exception
    //   5589	5594	5597	java/lang/Exception
    //   837	842	5611	java/io/IOException
    //   1315	1320	5615	java/io/IOException
    //   3163	3168	5619	java/io/IOException
    //   3176	3181	5624	java/io/IOException
    //   3189	3194	5629	java/io/IOException
    //   3565	3570	5634	java/lang/Throwable
    //   3570	3575	5634	java/lang/Throwable
    //   3771	3776	5639	java/io/IOException
    //   4729	4736	5643	java/lang/Exception
    //   4736	4743	5648	java/lang/Exception
    //   4748	4757	5648	java/lang/Exception
    //   4791	4796	5653	java/io/IOException
    //   4807	4812	5658	java/io/IOException
    //   5126	5131	5663	java/io/IOException
    //   5139	5144	5668	java/io/IOException
    //   5152	5157	5673	java/io/IOException
    //   5550	5555	5678	java/io/IOException
    //   5563	5568	5682	java/io/IOException
    //   5576	5581	5686	java/io/IOException
    //   240	272	5690	finally
    //   287	296	5690	finally
    //   240	272	5707	java/lang/Throwable
    //   287	296	5707	java/lang/Throwable
    //   3877	3904	5749	finally
    //   3918	3927	5749	finally
    //   3877	3904	5754	java/lang/Throwable
    //   3918	3927	5754	java/lang/Throwable
    //   3814	3820	5759	finally
    //   3842	3848	5759	finally
    //   3814	3820	5764	java/lang/Throwable
    //   3842	3848	5764	java/lang/Throwable
    //   3545	3555	5769	finally
    //   3587	3593	5769	finally
    //   3545	3555	5774	java/lang/Throwable
    //   3587	3593	5774	java/lang/Throwable
    //   3504	3545	5779	finally
    //   3504	3545	5784	java/lang/Throwable
    //   3483	3500	5789	finally
    //   3483	3500	5802	java/lang/Throwable
  }
  
  public int sendMsg(HttpMsg paramHttpMsg)
  {
    int i = this.maxQueueLength;
    boolean bool = this.bDispose;
    int k = -1;
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.richmedia.HttpCommunicator", 2, "sendMsg closed");
      }
      if ((paramHttpMsg != null) && (paramHttpMsg.getProcessor() != null))
      {
        paramHttpMsg.setHttpErrorCode(9366, -1, "close");
        paramHttpMsg.getProcessor().handleError(paramHttpMsg, paramHttpMsg);
        return -1;
      }
    }
    if (!this.bRun) {
      start();
    }
    Object localObject = this.locker;
    int m = 0;
    if (paramHttpMsg != null) {}
    try
    {
      int j;
      if (this.mSendQueue.getQueueMsgNums() < i)
      {
        i = this.seed + 1;
        this.seed = i;
        paramHttpMsg.setSerial(i);
        paramHttpMsg.inQueueStartTime = SystemClock.uptimeMillis();
        this.mSendQueue.addMsg(paramHttpMsg);
        paramHttpMsg.getProcessor().statusChanged(paramHttpMsg, null, 0);
        i = this.seed;
        j = 1;
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.richmedia.HttpCommunicator", 2, "exceed queue limit");
        }
        i = k;
        j = m;
        if (paramHttpMsg != null)
        {
          i = k;
          j = m;
          if (paramHttpMsg.getProcessor() != null)
          {
            paramHttpMsg.setHttpErrorCode(9367, -1, "queen full");
            paramHttpMsg.getProcessor().handleError(paramHttpMsg, paramHttpMsg);
            j = m;
            i = k;
          }
        }
      }
      if (j != 0) {
        disPatchMsg("sendMsg");
      }
      return i;
    }
    finally {}
  }
  
  public void sendMsgRealSync(HttpMsg paramHttpMsg)
  {
    run(paramHttpMsg, null);
  }
  
  /* Error */
  @java.lang.Deprecated
  public int sendMsgSync(HttpMsg paramHttpMsg)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 111	com/tencent/mobileqq/transfile/HttpCommunicator:maxQueueLength	I
    //   4: istore_2
    //   5: aload_0
    //   6: getfield 92	com/tencent/mobileqq/transfile/HttpCommunicator:locker	Ljava/lang/Object;
    //   9: astore 4
    //   11: aload 4
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 80	com/tencent/mobileqq/transfile/HttpCommunicator:bDispose	Z
    //   18: ifne +75 -> 93
    //   21: aload_0
    //   22: getfield 72	com/tencent/mobileqq/transfile/HttpCommunicator:mSendQueue	Lcom/tencent/mobileqq/transfile/PriorityQueue;
    //   25: invokevirtual 166	com/tencent/mobileqq/transfile/PriorityQueue:getQueueMsgNums	()I
    //   28: iload_2
    //   29: if_icmpge +64 -> 93
    //   32: aload_0
    //   33: getfield 67	com/tencent/mobileqq/transfile/HttpCommunicator:seed	I
    //   36: iconst_1
    //   37: iadd
    //   38: istore_2
    //   39: aload_0
    //   40: iload_2
    //   41: putfield 67	com/tencent/mobileqq/transfile/HttpCommunicator:seed	I
    //   44: aload_1
    //   45: iload_2
    //   46: invokevirtual 1131	com/tencent/mobileqq/utils/httputils/HttpMsg:setSerial	(I)V
    //   49: aload_0
    //   50: getfield 72	com/tencent/mobileqq/transfile/HttpCommunicator:mSendQueue	Lcom/tencent/mobileqq/transfile/PriorityQueue;
    //   53: aload_1
    //   54: invokevirtual 1134	com/tencent/mobileqq/transfile/PriorityQueue:addMsg	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   57: aload_1
    //   58: invokevirtual 523	com/tencent/mobileqq/utils/httputils/HttpMsg:getProcessor	()Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   61: aload_1
    //   62: aconst_null
    //   63: iconst_0
    //   64: invokeinterface 528 4 0
    //   69: pop
    //   70: aload_0
    //   71: getfield 67	com/tencent/mobileqq/transfile/HttpCommunicator:seed	I
    //   74: istore_3
    //   75: iload_3
    //   76: istore_2
    //   77: aload_0
    //   78: getfield 78	com/tencent/mobileqq/transfile/HttpCommunicator:bRun	Z
    //   81: ifne +30 -> 111
    //   84: aload_0
    //   85: invokevirtual 1128	com/tencent/mobileqq/transfile/HttpCommunicator:start	()V
    //   88: iload_3
    //   89: istore_2
    //   90: goto +21 -> 111
    //   93: invokestatic 103	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   96: ifeq +100 -> 196
    //   99: ldc 38
    //   101: iconst_2
    //   102: ldc_w 1136
    //   105: invokestatic 861	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: goto +88 -> 196
    //   111: aload 4
    //   113: monitorexit
    //   114: new 4	java/lang/Object
    //   117: dup
    //   118: invokespecial 65	java/lang/Object:<init>	()V
    //   121: astore 4
    //   123: aload_1
    //   124: aload 4
    //   126: putfield 1147	com/tencent/mobileqq/utils/httputils/HttpMsg:lockForSyncSend	Ljava/lang/Object;
    //   129: aload_1
    //   130: new 82	java/util/concurrent/atomic/AtomicBoolean
    //   133: dup
    //   134: iconst_0
    //   135: invokespecial 85	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   138: putfield 1150	com/tencent/mobileqq/utils/httputils/HttpMsg:hasFinished	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   141: aload_0
    //   142: ldc_w 1151
    //   145: invokevirtual 857	com/tencent/mobileqq/transfile/HttpCommunicator:disPatchMsg	(Ljava/lang/String;)V
    //   148: aload_1
    //   149: getfield 1150	com/tencent/mobileqq/utils/httputils/HttpMsg:hasFinished	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   152: invokevirtual 176	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   155: ifne +33 -> 188
    //   158: aload 4
    //   160: monitorenter
    //   161: aload 4
    //   163: invokevirtual 1154	java/lang/Object:wait	()V
    //   166: goto +12 -> 178
    //   169: astore_1
    //   170: goto +13 -> 183
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 1155	java/lang/InterruptedException:printStackTrace	()V
    //   178: aload 4
    //   180: monitorexit
    //   181: iload_2
    //   182: ireturn
    //   183: aload 4
    //   185: monitorexit
    //   186: aload_1
    //   187: athrow
    //   188: iload_2
    //   189: ireturn
    //   190: astore_1
    //   191: aload 4
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    //   196: iconst_m1
    //   197: istore_2
    //   198: goto -87 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	201	0	this	HttpCommunicator
    //   0	201	1	paramHttpMsg	HttpMsg
    //   4	194	2	i	int
    //   74	15	3	j	int
    //   9	183	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   161	166	169	finally
    //   174	178	169	finally
    //   178	181	169	finally
    //   183	186	169	finally
    //   161	166	173	java/lang/InterruptedException
    //   14	75	190	finally
    //   77	88	190	finally
    //   93	108	190	finally
    //   111	114	190	finally
    //   191	194	190	finally
  }
  
  public void setCouncurrentNumber(int paramInt)
  {
    Object localObject1 = this.locker;
    if (paramInt == 1) {}
    try
    {
      this.mConcurrentLimit = 4;
      this.mPreemptEnabled.set(false);
      break label41;
      this.mConcurrentLimit = 3;
      this.mPreemptEnabled.set(true);
      label41:
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("netType:");
        ((StringBuilder)localObject1).append(paramInt);
        ((StringBuilder)localObject1).append(" concurrent:");
        ((StringBuilder)localObject1).append(this.mConcurrentLimit);
        QLog.d("Q.richmedia.HttpCommunicator", 2, ((StringBuilder)localObject1).toString());
      }
      disPatchMsg("netChange");
      return;
    }
    finally {}
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
            paramHttpURLConnection.append("\n");
            paramHttpURLConnection.append(localStackTraceElement.toString());
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
      if (paramThrowable.contains("unreachable)"))
      {
        paramHttpURLConnection = new StringBuilder();
        paramHttpURLConnection.append("N_");
        paramHttpURLConnection.append(-20005);
        paramHttpURLConnection = paramHttpURLConnection.toString();
      }
      else if (paramThrowable.contains("Connection refused"))
      {
        paramHttpURLConnection = new StringBuilder();
        paramHttpURLConnection.append("N_");
        paramHttpURLConnection.append(-20002);
        paramHttpURLConnection = paramHttpURLConnection.toString();
      }
      else if (paramThrowable.contains("No route to host"))
      {
        if (paramThrowable.contains("SocketException"))
        {
          paramHttpURLConnection = new StringBuilder();
          paramHttpURLConnection.append("N_");
          paramHttpURLConnection.append(-20003);
          paramHttpURLConnection = paramHttpURLConnection.toString();
        }
        else
        {
          paramHttpURLConnection = new StringBuilder();
          paramHttpURLConnection.append("N_");
          paramHttpURLConnection.append(-20004);
          paramHttpURLConnection = paramHttpURLConnection.toString();
        }
      }
      else if (paramThrowable.contains("unexpected end of stream"))
      {
        paramHttpURLConnection = new StringBuilder();
        paramHttpURLConnection.append("N_");
        paramHttpURLConnection.append(-20005);
        paramHttpURLConnection = paramHttpURLConnection.toString();
      }
      else if (paramThrowable.contains("Connection timed out"))
      {
        paramHttpURLConnection = new StringBuilder();
        paramHttpURLConnection.append("N_");
        paramHttpURLConnection.append(-20006);
        paramHttpURLConnection = paramHttpURLConnection.toString();
      }
      else
      {
        if (paramThrowable.contains("unaccpet content type"))
        {
          paramHttpMsg.setHttpErrorCode(9064, paramInt, paramThrowable);
          return;
        }
        paramHttpURLConnection = new StringBuilder();
        paramHttpURLConnection.append("N_");
        paramHttpURLConnection.append(-20007);
        paramHttpURLConnection = paramHttpURLConnection.toString();
      }
      paramHttpMsg.setHttpErrorCode(9047, paramInt, paramThrowable);
      paramHttpMsg.setResponseProperty(HttpMsg.Param_Reason, paramHttpURLConnection);
      return;
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
    synchronized (this.locker)
    {
      if ((!this.bDispose) && (!this.bRun))
      {
        if ((this.mTimeoutCheckHandler != null) && (this.mCheckThreadPoolIdleRunnable != null)) {
          this.mTimeoutCheckHandler.removeCallbacks(this.mCheckThreadPoolIdleRunnable);
        }
        this.bRun = true;
        int i = 0;
        this.mConcurrentRunningMsgs = 0;
        if (this.mTimeoutCheckHandler == null) {
          this.mTimeoutCheckHandler = ThreadManager.getSubThreadHandler();
        }
        if (this.mHttpHandlers == null)
        {
          this.mHttpHandlers = new HttpCommunicator.HttpCommunicatorHandler[4];
          while (i < 4)
          {
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("httpcommunicator_norm_");
            ((StringBuilder)localObject2).append(i);
            localObject2 = ThreadManager.newFreeHandlerThread(((StringBuilder)localObject2).toString(), 5);
            ((HandlerThread)localObject2).start();
            this.mHttpHandlers[i] = new HttpCommunicator.HttpCommunicatorHandler(this, ((HandlerThread)localObject2).getLooper());
            this.mHttpHandlers[i].index = i;
            i += 1;
          }
        }
        i = NetworkCenter.getInstance().getNetType();
        if ((i != 2) && (i != 3)) {
          this.mConcurrentLimit = 4;
        } else {
          this.mConcurrentLimit = 3;
        }
        return;
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.HttpCommunicator
 * JD-Core Version:    0.7.0.1
 */