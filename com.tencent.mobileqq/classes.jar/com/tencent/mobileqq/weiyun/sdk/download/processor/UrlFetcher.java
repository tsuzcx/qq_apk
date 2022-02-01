package com.tencent.mobileqq.weiyun.sdk.download.processor;

import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.weiyun.api.download.IFetchListener;
import com.tencent.mobileqq.weiyun.model.DownloadFile;
import com.tencent.mobileqq.weiyun.model.DownloadJobContext;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

public class UrlFetcher
  implements Handler.Callback
{
  private IFetchListener jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIFetchListener;
  private final UrlFetcher.UrlFetcherCallback jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorUrlFetcher$UrlFetcherCallback;
  private final ReleaseLooperHandler jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler;
  
  public UrlFetcher(UrlFetcher.UrlFetcherCallback paramUrlFetcherCallback, IFetchListener paramIFetchListener, ReleaseLooperHandler paramReleaseLooperHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorUrlFetcher$UrlFetcherCallback = paramUrlFetcherCallback;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler = paramReleaseLooperHandler;
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.addCallback(this);
    this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIFetchListener = paramIFetchListener;
  }
  
  private void b(DownloadJobContext paramDownloadJobContext, int paramInt)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    long l = paramDownloadJobContext.a();
    String str = paramDownloadJobContext.a().a;
    if (paramDownloadJobContext.d()) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIFetchListener.a(paramDownloadJobContext.a().a(), paramInt, new UrlFetcher.1(this, str, l, paramDownloadJobContext, paramInt));
  }
  
  public void a(DownloadJobContext paramDownloadJobContext, int paramInt)
  {
    if (paramDownloadJobContext == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentWeiyunTransmissionUtilsHandlerReleaseLooperHandler.sendMessage(Message.obtain(null, 21, paramInt, 0, paramDownloadJobContext));
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 21)
    {
      b((DownloadJobContext)paramMessage.obj, paramMessage.arg1);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.processor.UrlFetcher
 * JD-Core Version:    0.7.0.1
 */