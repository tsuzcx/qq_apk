package dov.com.qq.im.ae.download.old;

import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;

class AEOldShortVideoResDownload$2
  implements AEOldShortVideoResStatus.ISVConfig
{
  AEOldShortVideoResDownload$2(AEOldShortVideoResDownload paramAEOldShortVideoResDownload, AEOldShortVideoResStatus.ISVConfig_V2 paramISVConfig_V2) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    AEQLog.b(AEOldShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - BEGIN -, result=" + paramInt1 + ", serverError=" + paramInt2);
    if ((paramInt1 == 1) || (paramInt1 == 0)) {
      if (paramInt2 != 0)
      {
        AEQLog.b(AEOldShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], serverError");
        AEQLog.b(AEOldShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        AEOldShortVideoResDownload.a(this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResDownload);
        if (this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResStatus$ISVConfig_V2 != null) {
          this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResStatus$ISVConfig_V2.b(paramInt1, paramInt2);
        }
      }
    }
    for (;;)
    {
      AEQLog.b(AEOldShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult] - END -, result=" + paramInt1 + ", serverError=" + paramInt2);
      return;
      ArrayList localArrayList = new ArrayList(1);
      if (AEOldShortVideoResManager.a(AEOldShortVideoResDownload.a(this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResDownload), localArrayList) == 0)
      {
        AEQLog.b(AEOldShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList valid");
        AEOldShortVideoResDownload.a(this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResDownload).b();
        if (this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResStatus$ISVConfig_V2 != null) {
          this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResStatus$ISVConfig_V2.b(paramInt1, paramInt2);
        }
      }
      else
      {
        AEQLog.b(AEOldShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], configList invalid");
        AEQLog.b(AEOldShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
        AEOldShortVideoResDownload.a(this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResDownload);
        if (this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResStatus$ISVConfig_V2 != null)
        {
          this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResStatus$ISVConfig_V2.b(paramInt1, paramInt2);
          continue;
          AEQLog.b(AEOldShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], result invalid");
          AEQLog.b(AEOldShortVideoResDownload.a(), "[startDownload215ConfigWithoutLoginInternal.onConfigResult], removeDownloadSession");
          AEOldShortVideoResDownload.a(this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResDownload);
          if (this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResStatus$ISVConfig_V2 != null) {
            this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResStatus$ISVConfig_V2.b(paramInt1, paramInt2);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResDownload.2
 * JD-Core Version:    0.7.0.1
 */