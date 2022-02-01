package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.RequestProxy.RequestListener;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

class RequestProxyImpl$1
  implements Callback
{
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  RequestProxyImpl$1(RequestProxyImpl paramRequestProxyImpl, String paramString, RequestProxy.RequestListener paramRequestListener) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = new StringBuilder();
    paramCall.append("httpConnect err url:");
    paramCall.append(this.jdField_a_of_type_JavaLangString);
    QLog.e("RequestProxyImpl", 1, paramCall.toString(), paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage()))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyRequestProxy$RequestListener.onRequestFailed(-5, "request error:cancel");
    }
    else
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyRequestProxy$RequestListener.onRequestFailed(HttpUtil.a(paramIOException, -1), "request error:network");
    }
    this.jdField_a_of_type_ComTencentQqminiProxyimplRequestProxyImpl.a.remove(this.jdField_a_of_type_JavaLangString);
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = paramResponse.code();
    Map localMap = paramResponse.headers().toMultimap();
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyRequestProxy$RequestListener.onRequestHeadersReceived(i, localMap);
    paramCall = null;
    try
    {
      paramResponse = paramResponse.body().bytes();
      paramCall = paramResponse;
    }
    catch (IOException paramResponse)
    {
      paramResponse.printStackTrace();
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyRequestProxy$RequestListener.onRequestSucceed(i, paramCall, localMap);
    this.jdField_a_of_type_ComTencentQqminiProxyimplRequestProxyImpl.a.remove(this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.RequestProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */