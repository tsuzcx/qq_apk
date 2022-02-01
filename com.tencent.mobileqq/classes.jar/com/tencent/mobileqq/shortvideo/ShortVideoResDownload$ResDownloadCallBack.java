package com.tencent.mobileqq.shortvideo;

class ShortVideoResDownload$ResDownloadCallBack
  implements ShortVideoResourceManager.INet_ShortVideoResource
{
  ShortVideoResDownload jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload;
  private String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean = true;
  boolean b = true;
  boolean c = true;
  boolean d = true;
  
  public ShortVideoResDownload$ResDownloadCallBack(String paramString, ShortVideoResDownload paramShortVideoResDownload)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload = paramShortVideoResDownload;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.b) && (this.d)) {
      ShortVideoResDownload.a(this.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoResDownload);
    }
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadFinish| name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",filePath=");
    localStringBuilder.append(paramString2);
    VideoEnvironment.LogDownLoad(str, localStringBuilder.toString(), null);
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      this.jdField_a_of_type_Boolean = true;
    } else if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
      this.b = true;
    } else if (paramString1.startsWith("new_qq_android_native_portrait_filter_")) {
      this.c = true;
    }
    a();
  }
  
  public void onNetWorkNone()
  {
    VideoEnvironment.LogDownLoad(this.jdField_a_of_type_JavaLangString, "onNetWorkNone...", null);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",totalLen=");
    localStringBuilder.append(paramLong2);
    localStringBuilder.append(",curOffset=");
    localStringBuilder.append(paramLong1);
    localStringBuilder.append(",localProgress=");
    localStringBuilder.append(i);
    VideoEnvironment.LogDownLoad(str, localStringBuilder.toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResDownload.ResDownloadCallBack
 * JD-Core Version:    0.7.0.1
 */