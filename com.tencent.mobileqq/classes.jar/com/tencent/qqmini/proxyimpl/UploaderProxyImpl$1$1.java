package com.tencent.qqmini.proxyimpl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.UploaderProxy.UploadListener;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.ResponseBody;

class UploaderProxyImpl$1$1
  implements Callback
{
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  UploaderProxyImpl$1$1(UploaderProxyImpl.1 param1) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    QLog.e("UploaderProxyImpl", 1, "httpConnect err url:" + this.jdField_a_of_type_ComTencentQqminiProxyimplUploaderProxyImpl$1.jdField_a_of_type_JavaLangString, paramIOException);
    if ("Canceled".equals(paramIOException.getLocalizedMessage())) {
      this.jdField_a_of_type_ComTencentQqminiProxyimplUploaderProxyImpl$1.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyUploaderProxy$UploadListener.onUploadFailed(-5, "download error:cancel");
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentQqminiProxyimplUploaderProxyImpl$1.this$0.a.remove(this.jdField_a_of_type_ComTencentQqminiProxyimplUploaderProxyImpl$1.jdField_a_of_type_JavaLangString);
      return;
      this.jdField_a_of_type_ComTencentQqminiProxyimplUploaderProxyImpl$1.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyUploaderProxy$UploadListener.onUploadFailed(HttpUtil.a(paramIOException, -1), "request error:network");
    }
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = paramResponse.code();
    paramCall = paramResponse.headers().toMultimap();
    this.jdField_a_of_type_ComTencentQqminiProxyimplUploaderProxyImpl$1.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyUploaderProxy$UploadListener.onUploadHeadersReceived(i, paramCall);
    this.jdField_a_of_type_ComTencentQqminiProxyimplUploaderProxyImpl$1.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyUploaderProxy$UploadListener.onUploadSucceed(i, paramResponse.body().bytes(), paramCall);
    this.jdField_a_of_type_ComTencentQqminiProxyimplUploaderProxyImpl$1.this$0.a.remove(this.jdField_a_of_type_ComTencentQqminiProxyimplUploaderProxyImpl$1.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.UploaderProxyImpl.1.1
 * JD-Core Version:    0.7.0.1
 */