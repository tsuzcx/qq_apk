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
  protected final long a;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  protected final AppRuntime a;
  private boolean jdField_a_of_type_Boolean = false;
  protected boolean b = true;
  
  public UFTHttpCommunicator(AppRuntime paramAppRuntime, long paramLong)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_Long = paramLong;
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
    int m = UFTDependFeatureApi.b();
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
  
  private void a(HttpMsg paramHttpMsg)
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("],decodePost userRetCode[");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append("]");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, ((StringBuilder)localObject).toString());
      c(paramHttpMsg);
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
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("],decodePost but response Code [");
    ((StringBuilder)localObject).append(paramHttpMsg.getResponseCode());
    ((StringBuilder)localObject).append("] is not 200");
    UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, ((StringBuilder)localObject).toString());
  }
  
  private boolean a(HttpMsg paramHttpMsg)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
    if (paramHttpMsg == localObject) {
      return true;
    }
    if ((paramHttpMsg != null) && (localObject != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("],Req Serial[");
      ((StringBuilder)localObject).append(String.valueOf(paramHttpMsg.getSerial()));
      ((StringBuilder)localObject).append("], curRequest Serial[");
      ((StringBuilder)localObject).append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()));
      ((StringBuilder)localObject).append("]");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, ((StringBuilder)localObject).toString());
    }
    else if (paramHttpMsg != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("],Req Serial[");
      ((StringBuilder)localObject).append(String.valueOf(paramHttpMsg.getSerial()));
      ((StringBuilder)localObject).append("]");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, ((StringBuilder)localObject).toString());
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      paramHttpMsg = new StringBuilder();
      paramHttpMsg.append("id[");
      paramHttpMsg.append(this.jdField_a_of_type_Long);
      paramHttpMsg.append("],curRequest Serial[");
      paramHttpMsg.append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()));
      paramHttpMsg.append("]");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, paramHttpMsg.toString());
    }
    return false;
  }
  
  private void b(HttpMsg paramHttpMsg)
  {
    if ((paramHttpMsg.getResponseCode() != 206) && (paramHttpMsg.getResponseCode() != 200))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append("] decodeGet resp Code [");
      localStringBuilder.append(paramHttpMsg.getResponseCode());
      localStringBuilder.append("] no 200|206");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, localStringBuilder.toString());
      return;
    }
    a(new UFTHttpCommunicator.UFTHttpRsp(paramHttpMsg.getRecvData(), paramHttpMsg.rawRespHeader, 0L, 0L, paramHttpMsg.getTotalLen()));
  }
  
  private void c(HttpMsg paramHttpMsg)
  {
    String str = null;
    if (paramHttpMsg != null)
    {
      if (paramHttpMsg.mConn != null) {
        str = paramHttpMsg.mConn.getHeaderField("User-ReturnCode");
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id[");
      localStringBuilder.append(this.jdField_a_of_type_Long);
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
    paramHttpMsg.append(this.jdField_a_of_type_Long);
    paramHttpMsg.append("], httpReq Error:");
    paramHttpMsg.append(9001);
    paramHttpMsg.append(" null rsp");
    UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, paramHttpMsg.toString());
    a(new UFTHttpCommunicator.UFTHttpErr(9001, "null", "null", null));
  }
  
  protected HttpCommunicator a()
  {
    return (HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator();
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
      paramUFTHttpReq.append(this.jdField_a_of_type_Long);
      paramUFTHttpReq.append("]sendReq. req = null");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, paramUFTHttpReq.toString());
      return false;
    }
    this.b = false;
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = new HttpMsg(UFTHttpCommunicator.UFTHttpReq.a(paramUFTHttpReq), UFTHttpCommunicator.UFTHttpReq.a(paramUFTHttpReq), this, UFTHttpCommunicator.UFTHttpReq.a(paramUFTHttpReq));
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setInstanceFollowRedirects(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("cache-control", "no-cache");
    if (!TextUtils.isEmpty(UFTHttpCommunicator.UFTHttpReq.b(paramUFTHttpReq))) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestMethod(UFTHttpCommunicator.UFTHttpReq.b(paramUFTHttpReq));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setPriority(UFTHttpCommunicator.UFTHttpReq.a(paramUFTHttpReq));
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.fileType = UFTHttpCommunicator.UFTHttpReq.b(paramUFTHttpReq);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.busiType = UFTHttpCommunicator.UFTHttpReq.c(paramUFTHttpReq);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.msgId = String.valueOf(this.jdField_a_of_type_Long);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getRequestMethod();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return false;
    }
    if (((String)localObject).toUpperCase().equals("POST")) {
      this.jdField_a_of_type_Boolean = true;
    } else {
      this.jdField_a_of_type_Boolean = false;
    }
    if (UFTHttpCommunicator.UFTHttpReq.b(paramUFTHttpReq))
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
      ((HttpMsg)localObject).mIsHttps = true;
      ((HttpMsg)localObject).mIsHostIP = UFTHttpCommunicator.UFTHttpReq.c(paramUFTHttpReq);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.mReqHost = UFTHttpCommunicator.UFTHttpReq.c(paramUFTHttpReq);
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setDataSlice(UFTHttpCommunicator.UFTHttpReq.d(paramUFTHttpReq));
    if (UFTDependFeatureApi.a() == 1) {
      localObject = "wifi";
    } else {
      localObject = "gprs";
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("Net-type", (String)localObject);
    if (!TextUtils.isEmpty(UFTHttpCommunicator.UFTHttpReq.d(paramUFTHttpReq))) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("User-Agent", UFTHttpCommunicator.UFTHttpReq.d(paramUFTHttpReq));
    }
    if (!TextUtils.isEmpty(UFTHttpCommunicator.UFTHttpReq.e(paramUFTHttpReq))) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("Cookie", UFTHttpCommunicator.UFTHttpReq.e(paramUFTHttpReq));
    }
    if (!TextUtils.isEmpty(UFTHttpCommunicator.UFTHttpReq.f(paramUFTHttpReq))) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("Range", UFTHttpCommunicator.UFTHttpReq.f(paramUFTHttpReq));
    }
    if (!TextUtils.isEmpty(UFTHttpCommunicator.UFTHttpReq.g(paramUFTHttpReq))) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("Accept-Encoding", UFTHttpCommunicator.UFTHttpReq.g(paramUFTHttpReq));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.timeoutParam = a();
    localObject = a();
    if (localObject == null)
    {
      paramUFTHttpReq = new StringBuilder();
      paramUFTHttpReq.append("id[");
      paramUFTHttpReq.append(this.jdField_a_of_type_Long);
      paramUFTHttpReq.append("]sendReq. but communicator stop service!!");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, paramUFTHttpReq.toString());
      return false;
    }
    int i = ((HttpCommunicator)localObject).sendMsg(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    if (UFTLog.a())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("id[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("]sendReq. url:");
      ((StringBuilder)localObject).append(UFTHttpCommunicator.UFTHttpReq.a(paramUFTHttpReq));
      ((StringBuilder)localObject).append(" msgId:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.msgId);
      ((StringBuilder)localObject).append(" ret:");
      ((StringBuilder)localObject).append(i);
      UFTLog.a("[UFTTransfer] UFTHttpCommunicator", 4, ((StringBuilder)localObject).toString());
    }
    if (i == -1)
    {
      this.b = true;
      return false;
    }
    return true;
  }
  
  public void b()
  {
    this.b = true;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      a().cancelMsg(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
    }
  }
  
  public final void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.b)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("id[");
      paramHttpMsg1.append(this.jdField_a_of_type_Long);
      paramHttpMsg1.append("]已经结束,返回");
      UFTLog.d("[UFTTransfer] UFTHttpCommunicator", 1, paramHttpMsg1.toString());
      return;
    }
    if (!a(paramHttpMsg1)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      a(paramHttpMsg2);
      return;
    }
    b(paramHttpMsg2);
  }
  
  public final void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.b) {
      return;
    }
    if (!a(paramHttpMsg1)) {
      return;
    }
    c(paramHttpMsg2);
  }
  
  public final void handleRedirect(String paramString)
  {
    if (this.b) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.depend.UFTHttpCommunicator
 * JD-Core Version:    0.7.0.1
 */