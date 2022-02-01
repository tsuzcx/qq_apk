package com.tencent.mobileqq.weiyun.sdk.download.processor;

import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.weiyun.api.download.DownloadServerInfoCallback;
import com.tencent.mobileqq.weiyun.model.DownloadFile;
import com.tencent.mobileqq.weiyun.model.DownloadJobContext;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;

class UrlFetcher$1
  implements DownloadServerInfoCallback
{
  UrlFetcher$1(UrlFetcher paramUrlFetcher, String paramString, long paramLong, DownloadJobContext paramDownloadJobContext, int paramInt) {}
  
  public void a(DownloadFile paramDownloadFile, boolean paramBoolean, int paramInt, String paramString)
  {
    if (paramDownloadFile != null)
    {
      if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramDownloadFile.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if (paramBoolean)
      {
        if (paramDownloadFile.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile$DownloadServerInfo == null)
        {
          UrlFetcher.a(this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorUrlFetcher).a(this.jdField_a_of_type_Long, 1810024, "");
          return;
        }
        UrlFetcher.a(this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorUrlFetcher).a(this.jdField_a_of_type_Long, paramDownloadFile.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadFile$DownloadServerInfo);
        return;
      }
      if ((paramInt == 1002) && (!this.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadJobContext.a()))
      {
        this.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadJobContext.d(true);
        paramDownloadFile = Message.obtain();
        paramDownloadFile.what = 21;
        paramDownloadFile.obj = this.jdField_a_of_type_ComTencentMobileqqWeiyunModelDownloadJobContext;
        paramDownloadFile.arg1 = this.jdField_a_of_type_Int;
        UrlFetcher.a(this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorUrlFetcher).sendMessageDelayed(paramDownloadFile, 1000L);
        return;
      }
      UrlFetcher.a(this.jdField_a_of_type_ComTencentMobileqqWeiyunSdkDownloadProcessorUrlFetcher).a(this.jdField_a_of_type_Long, paramInt, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.sdk.download.processor.UrlFetcher.1
 * JD-Core Version:    0.7.0.1
 */