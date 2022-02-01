package cooperation.weiyun.utils;

import android.content.Context;
import cooperation.weiyun.sdk.download.WyDownloader;
import cooperation.weiyun.sdk.download.WyDownloader.IDownloadListener;
import java.io.File;

final class SoHelper$1
  implements WyDownloader.IDownloadListener
{
  SoHelper$1(String paramString1, String paramString2, SoHelper.SoListener paramSoListener, Context paramContext, File paramFile1, File paramFile2) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    if (this.jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener != null) {
      this.jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener.a(paramLong, paramFloat);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if (paramBoolean) {
      WyDownloader.a().a(SoHelper.a(), this.jdField_a_of_type_JavaLangString, "SoHelper", new SoHelper.1.1(this));
    }
    while (this.jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener == null) {
      return;
    }
    this.jdField_a_of_type_CooperationWeiyunUtilsSoHelper$SoListener.a(paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.weiyun.utils.SoHelper.1
 * JD-Core Version:    0.7.0.1
 */