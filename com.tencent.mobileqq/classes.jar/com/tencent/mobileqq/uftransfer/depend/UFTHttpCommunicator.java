package com.tencent.mobileqq.uftransfer.depend;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.TimeoutParam;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import java.net.HttpURLConnection;
import mqq.app.AppRuntime;

public abstract class UFTHttpCommunicator
  implements IHttpCommunicatorListener
{
  private HttpMsg a;
  private boolean b = false;
  protected final AppRuntime c;
  protected final long d;
  protected boolean e = true;
  
  public UFTHttpCommunicator(AppRuntime paramAppRuntime, long paramLong)
  {
    this.c = paramAppRuntime;
    this.d = paramLong;
  }
  
  private TimeoutParam a()
  {
    Object localObject = ((ConnectivityManager)BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool = true;
    int i;
    int k;
    if (localObject != null)
    {
      j = ((NetworkInfo)localObject).getType();
      i = j;
      if (j == 1)
      {
        k = 1;
        i = j;
        j = k;
        break label50;
      }
    }
    else
    {
      i = -1;
    }
    int j = 0;
    label50:
    int m = UFTDependFeatureApi.d();
    if (m == 2) {
      k = 1;
    } else {
      k = 0;
    }
    if (UFTLog.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTimeOutParamer,systemType:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" msfType:");
      ((StringBuilder)localObject).append(m);
      ((StringBuilder)localObject).append(" isSameNet:");
      if (j != k) {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      UFTLog.a("[UFTTransfer] UFTHttpCommunicator", 4, ((StringBuilder)localObject).toString());
    }
    if (j != k)
    {
      localObject = new TimeoutParam();
      ((TimeoutParam)localObject).readTimeoutFor2G = 20000;
      ((TimeoutParam)localObject).readTimeoutFor3G = 15000;
      ((TimeoutParam)localObject).readTimeoutForWifi = 10000;
      ((TimeoutParam)localObject).connectTimeoutFor2G = 10000;
      ((TimeoutParam)localObject).connectTimeoutFor3G = 5000;
      ((TimeoutParam)localObject).connectTimeoutForWifi = 5000;
      return localObject;
    }
    return null;
  }
  
  private boolean a(HttpMsg paramHttpMsg)
  {
    Object localObject = this.a;
    if (paramHttpMsg == localObject) {
      return true;
    }
    if ((paramHttpMsg != null) && (localObject != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("],Req Serial[");
      ((StringBuilder)localObject).append(String.valueOf(paramHttpMsg.getSerial()));
      ((StringBuilder)localObject).append("], curRequest Serial[");
      ((StringBuilder)localObject).append(String.valueOf(this.a.getSerial()));
      ((StringBuilder)localObject).append("]");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, ((StringBuilder)localObject).toString());
    }
    else if (paramHttpMsg != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("],Req Serial[");
      ((StringBuilder)localObject).append(String.valueOf(paramHttpMsg.getSerial()));
      ((StringBuilder)localObject).append("]");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, ((StringBuilder)localObject).toString());
    }
    else if (this.a != null)
    {
      paramHttpMsg = new StringBuilder();
      paramHttpMsg.append("id[");
      paramHttpMsg.append(this.d);
      paramHttpMsg.append("],curRequest Serial[");
      paramHttpMsg.append(String.valueOf(this.a.getSerial()));
      paramHttpMsg.append("]");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, paramHttpMsg.toString());
    }
    return false;
  }
  
  private void b(HttpMsg paramHttpMsg)
  {
    if (paramHttpMsg.getResponseCode() == 200)
    {
      localObject = paramHttpMsg.getResponseProperty("User-ReturnCode");
      if (TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    try
    {
      l2 = Long.parseLong((String)localObject);
    }
    catch (NumberFormatException localNumberFormatException1)
    {
      long l2;
      label36:
      long l1;
      break label36;
    }
    l2 = 0L;
    if (0L != l2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("],decodePost userRetCode[");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("]");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, ((StringBuilder)localObject).toString());
      d(paramHttpMsg);
      return;
    }
    l1 = -1L;
    Object localObject = paramHttpMsg.getResponseProperty("Range");
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    try
    {
      l1 = Long.parseLong((String)localObject);
    }
    catch (NumberFormatException localNumberFormatException2)
    {
      label143:
      break label143;
    }
    l1 = -2L;
    a(new UFTHttpCommunicator.UFTHttpRsp(paramHttpMsg.getRecvData(), paramHttpMsg.rawRespHeader, l1, l2, 0L));
    return;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("id[");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("],decodePost but response Code [");
    ((StringBuilder)localObject).append(paramHttpMsg.getResponseCode());
    ((StringBuilder)localObject).append("] is not 200");
    UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, ((StringBuilder)localObject).toString());
  }
  
  private void c(HttpMsg paramHttpMsg)
  {
    if ((paramHttpMsg.getResponseCode() != 206) && (paramHttpMsg.getResponseCode() != 200))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("] decodeGet resp Code [");
      localStringBuilder.append(paramHttpMsg.getResponseCode());
      localStringBuilder.append("] no 200|206");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, localStringBuilder.toString());
      return;
    }
    a(new UFTHttpCommunicator.UFTHttpRsp(paramHttpMsg.getRecvData(), paramHttpMsg.rawRespHeader, 0L, 0L, paramHttpMsg.getTotalLen()));
  }
  
  private void d(HttpMsg paramHttpMsg)
  {
    String str = null;
    if (paramHttpMsg != null)
    {
      if (paramHttpMsg.mConn != null) {
        str = paramHttpMsg.mConn.getHeaderField("User-ReturnCode");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id[");
      localStringBuilder.append(this.d);
      localStringBuilder.append("], httpReq Error:");
      localStringBuilder.append(paramHttpMsg.errCode);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramHttpMsg.getErrorString());
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, localStringBuilder.toString());
      a(new UFTHttpCommunicator.UFTHttpErr(paramHttpMsg.errCode, paramHttpMsg.getErrorString(), paramHttpMsg.rawRespHeader, str));
      return;
    }
    paramHttpMsg = new StringBuilder();
    paramHttpMsg.append("id[");
    paramHttpMsg.append(this.d);
    paramHttpMsg.append("], httpReq Error:");
    paramHttpMsg.append(9001);
    paramHttpMsg.append(" null rsp");
    UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, paramHttpMsg.toString());
    a(new UFTHttpCommunicator.UFTHttpErr(9001, "null", "null", null));
  }
  
  protected abstract void a(UFTHttpCommunicator.UFTHttpErr paramUFTHttpErr);
  
  protected abstract void a(UFTHttpCommunicator.UFTHttpRsp paramUFTHttpRsp);
  
  protected abstract void a(String paramString);
  
  public boolean a(UFTHttpCommunicator.UFTHttpReq paramUFTHttpReq)
  {
    if (paramUFTHttpReq == null)
    {
      paramUFTHttpReq = new StringBuilder();
      paramUFTHttpReq.append("id[");
      paramUFTHttpReq.append(this.d);
      paramUFTHttpReq.append("]sendReq. req = null");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, paramUFTHttpReq.toString());
      return false;
    }
    this.e = false;
    this.a = new HttpMsg(UFTHttpCommunicator.UFTHttpReq.a(paramUFTHttpReq), UFTHttpCommunicator.UFTHttpReq.b(paramUFTHttpReq), this, UFTHttpCommunicator.UFTHttpReq.c(paramUFTHttpReq));
    this.a.setInstanceFollowRedirects(false);
    this.a.setRequestProperty("cache-control", "no-cache");
    if (!TextUtils.isEmpty(UFTHttpCommunicator.UFTHttpReq.d(paramUFTHttpReq))) {
      this.a.setRequestMethod(UFTHttpCommunicator.UFTHttpReq.d(paramUFTHttpReq));
    }
    this.a.setPriority(UFTHttpCommunicator.UFTHttpReq.e(paramUFTHttpReq));
    this.a.fileType = UFTHttpCommunicator.UFTHttpReq.f(paramUFTHttpReq);
    this.a.busiType = UFTHttpCommunicator.UFTHttpReq.g(paramUFTHttpReq);
    this.a.msgId = String.valueOf(this.d);
    Object localObject = this.a.getRequestMethod();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    if (((String)localObject).toUpperCase().equals("POST")) {
      this.b = true;
    } else {
      this.b = false;
    }
    if (UFTHttpCommunicator.UFTHttpReq.h(paramUFTHttpReq))
    {
      localObject = this.a;
      ((HttpMsg)localObject).mIsHttps = true;
      ((HttpMsg)localObject).mIsHostIP = UFTHttpCommunicator.UFTHttpReq.i(paramUFTHttpReq);
      this.a.mReqHost = UFTHttpCommunicator.UFTHttpReq.j(paramUFTHttpReq);
    }
    this.a.setDataSlice(UFTHttpCommunicator.UFTHttpReq.k(paramUFTHttpReq));
    if (UFTDependFeatureApi.a() == 1) {
      localObject = "wifi";
    } else {
      localObject = "gprs";
    }
    this.a.setRequestProperty("Net-type", (String)localObject);
    if (!TextUtils.isEmpty(UFTHttpCommunicator.UFTHttpReq.l(paramUFTHttpReq))) {
      this.a.setRequestProperty("User-Agent", UFTHttpCommunicator.UFTHttpReq.l(paramUFTHttpReq));
    }
    if (!TextUtils.isEmpty(UFTHttpCommunicator.UFTHttpReq.m(paramUFTHttpReq))) {
      this.a.setRequestProperty("Cookie", UFTHttpCommunicator.UFTHttpReq.m(paramUFTHttpReq));
    }
    if (!TextUtils.isEmpty(UFTHttpCommunicator.UFTHttpReq.n(paramUFTHttpReq))) {
      this.a.setRequestProperty("Range", UFTHttpCommunicator.UFTHttpReq.n(paramUFTHttpReq));
    }
    if (!TextUtils.isEmpty(UFTHttpCommunicator.UFTHttpReq.o(paramUFTHttpReq))) {
      this.a.setRequestProperty("Accept-Encoding", UFTHttpCommunicator.UFTHttpReq.o(paramUFTHttpReq));
    }
    this.a.timeoutParam = a();
    localObject = c();
    if (localObject == null)
    {
      paramUFTHttpReq = new StringBuilder();
      paramUFTHttpReq.append("id[");
      paramUFTHttpReq.append(this.d);
      paramUFTHttpReq.append("]sendReq. but communicator stop service!!");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, paramUFTHttpReq.toString());
      return false;
    }
    int i = ((HttpCommunicator)localObject).sendMsg(this.a);
    if (UFTLog.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("]sendReq. url:");
      ((StringBuilder)localObject).append(UFTHttpCommunicator.UFTHttpReq.a(paramUFTHttpReq));
      ((StringBuilder)localObject).append(" msgId:");
      ((StringBuilder)localObject).append(this.a.msgId);
      ((StringBuilder)localObject).append(" ret:");
      ((StringBuilder)localObject).append(i);
      UFTLog.a("[UFTTransfer] UFTHttpCommunicator", 4, ((StringBuilder)localObject).toString());
    }
    if (i == -1)
    {
      this.e = true;
      return false;
    }
    return true;
  }
  
  public void b()
  {
    this.e = true;
    if (this.a != null)
    {
      c().cancelMsg(this.a);
      this.a = null;
    }
  }
  
  protected HttpCommunicator c()
  {
    return (HttpCommunicator)((IHttpEngineService)this.c.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator();
  }
  
  public final void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.e)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("id[");
      paramHttpMsg1.append(this.d);
      paramHttpMsg1.append("]已经结束,返回");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, paramHttpMsg1.toString());
      return;
    }
    if (!a(paramHttpMsg1)) {
      return;
    }
    if (this.b)
    {
      b(paramHttpMsg2);
      return;
    }
    c(paramHttpMsg2);
  }
  
  public final void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.e) {
      return;
    }
    if (!a(paramHttpMsg1)) {
      return;
    }
    d(paramHttpMsg2);
  }
  
  public final void handleRedirect(String paramString)
  {
    if (this.e) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], onNetRedirect:");
    localStringBuilder.append(paramString);
    UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, localStringBuilder.toString());
    a(paramString);
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator
 * JD-Core Version:    0.7.0.1
 */