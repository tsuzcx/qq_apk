package com.tencent.mobileqq.weiyun.utils;

import android.content.Context;
import com.tencent.mobileqq.weiyun.api.download.IDownloadListener;
import com.tencent.mobileqq.weiyun.api.download.IWeiyunSoListener;
import com.tencent.mobileqq.weiyun.sdk.download.WyDownloader;
import java.io.File;

final class SoHelper$1
  implements IDownloadListener
{
  SoHelper$1(String paramString1, String paramString2, IWeiyunSoListener paramIWeiyunSoListener, Context paramContext, File paramFile1, File paramFile2) {}
  
  public void a(String paramString, long paramLong, float paramFloat)
  {
    paramString = this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIWeiyunSoListener;
    if (paramString != null) {
      paramString.a(paramLong, paramFloat);
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    if (paramBoolean)
    {
      WyDownloader.a().a(SoHelper.a(), this.jdField_a_of_type_JavaLangString, "SoHelper", new SoHelper.1.1(this));
      return;
    }
    paramString1 = this.jdField_a_of_type_ComTencentMobileqqWeiyunApiDownloadIWeiyunSoListener;
    if (paramString1 != null) {
      paramString1.a(paramString3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.utils.SoHelper.1
 * JD-Core Version:    0.7.0.1
 */