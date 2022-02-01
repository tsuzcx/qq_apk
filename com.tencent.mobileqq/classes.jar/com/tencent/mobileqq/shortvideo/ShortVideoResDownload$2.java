package com.tencent.mobileqq.shortvideo;

import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;

class ShortVideoResDownload$2
  implements ShortVideoResourceStatus.ISVConfig
{
  ShortVideoResDownload$2(ShortVideoResDownload paramShortVideoResDownload, ShortVideoResourceStatus.ISVConfig_V2 paramISVConfig_V2) {}
  
  public void onConfigResult(int paramInt1, int paramInt2)
  {
    AEQLog.b(ShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    if ((paramInt1 == 1) || (paramInt1 == 0)) {
      if (paramInt2 != 0)
      {
        AEQLog.b(ShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], serverError");
        AEQLog.b(ShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        ShortVideoResDownload.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload);
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceStatus$ISVConfig_V2 != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceStatus$ISVConfig_V2.a(paramInt1, paramInt2);
        }
      }
    }
    for (;;)
    {
      AEQLog.b(ShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
      return;
      ArrayList localArrayList = new ArrayList(1);
      if (ShortVideoResourceManager.a(ShortVideoResDownload.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload), localArrayList) == 0)
      {
        AEQLog.b(ShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList valid");
        ShortVideoResDownload.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload).a();
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceStatus$ISVConfig_V2 != null) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceStatus$ISVConfig_V2.a(paramInt1, paramInt2);
        }
      }
      else
      {
        AEQLog.b(ShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList invalid");
        AEQLog.b(ShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        ShortVideoResDownload.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload);
        if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceStatus$ISVConfig_V2 != null)
        {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceStatus$ISVConfig_V2.a(paramInt1, paramInt2);
          continue;
          AEQLog.b(ShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], result invalid");
          AEQLog.b(ShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
          ShortVideoResDownload.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload);
          if (this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceStatus$ISVConfig_V2 != null) {
            this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResourceStatus$ISVConfig_V2.a(paramInt1, paramInt2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResDownload.2
 * JD-Core Version:    0.7.0.1
 */