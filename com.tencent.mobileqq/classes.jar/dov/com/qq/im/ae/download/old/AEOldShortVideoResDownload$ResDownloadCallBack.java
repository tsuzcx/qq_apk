package dov.com.qq.im.ae.download.old;

import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class AEOldShortVideoResDownload$ResDownloadCallBack
  implements AEOldShortVideoResManager.INet_ShortVideoResource
{
  AEOldShortVideoResDownload jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResDownload;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  boolean b = true;
  boolean c = true;
  boolean d = true;
  
  public AEOldShortVideoResDownload$ResDownloadCallBack(String paramString, AEOldShortVideoResDownload paramAEOldShortVideoResDownload)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResDownload = paramAEOldShortVideoResDownload;
  }
  
  public void a()
  {
    VideoEnvironment.LogDownLoad(this.jdField_a_of_type_JavaLangString, "onNetWorkNone...", null);
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    VideoEnvironment.LogDownLoad(this.jdField_a_of_type_JavaLangString, "onDownloadFinish| name=" + paramString1 + ",result=" + paramInt + ",filePath=" + paramString2, null);
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Boolean = true;
    }
    for (;;)
    {
      b();
      return;
      if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
        this.b = true;
      } else if (paramString1.startsWith("new_qq_android_native_portrait_filter_")) {
        this.c = true;
      } else if (paramString1.startsWith("new_qq_android_native_object_tracking_")) {
        this.d = true;
      }
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    VideoEnvironment.LogDownLoad(this.jdField_a_of_type_JavaLangString, "name=" + paramString + ",totalLen=" + paramLong2 + ",curOffset=" + paramLong1 + ",localProgress=" + i, null);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.b) && (this.d)) {
      AEOldShortVideoResDownload.a(this.jdField_a_of_type_DovComQqImAeDownloadOldAEOldShortVideoResDownload);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResDownload.ResDownloadCallBack
 * JD-Core Version:    0.7.0.1
 */