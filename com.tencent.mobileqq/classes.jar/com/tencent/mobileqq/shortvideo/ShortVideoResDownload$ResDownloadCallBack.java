package com.tencent.mobileqq.shortvideo;

class ShortVideoResDownload$ResDownloadCallBack
  implements ShortVideoResourceManager.INet_ShortVideoResource
{
  boolean a = true;
  boolean b = true;
  boolean c = true;
  boolean d = true;
  ShortVideoResDownload e;
  private String f;
  
  public ShortVideoResDownload$ResDownloadCallBack(String paramString, ShortVideoResDownload paramShortVideoResDownload)
  {
    this.f = paramString;
    this.e = paramShortVideoResDownload;
  }
  
  public void a()
  {
    if ((this.a) && (this.b) && (this.d)) {
      ShortVideoResDownload.a(this.e);
    }
  }
  
  public void onDownloadFinish(String paramString1, int paramInt, String paramString2)
  {
    String str = this.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDownloadFinish| name=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",result=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",filePath=");
    localStringBuilder.append(paramString2);
    VideoEnvironment.LogDownLoad(str, localStringBuilder.toString(), null);
    if (paramString1.startsWith("new_qq_android_native_short_video_")) {
      this.a = true;
    } else if (paramString1.startsWith("new_qq_android_native_art_filter_")) {
      this.b = true;
    } else if (paramString1.startsWith("new_qq_android_native_portrait_filter_")) {
      this.c = true;
    }
    a();
  }
  
  public void onNetWorkNone()
  {
    VideoEnvironment.LogDownLoad(this.f, "onNetWorkNone...", null);
  }
  
  public void onUpdateProgress(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    String str = this.f;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.ShortVideoResDownload.ResDownloadCallBack
 * JD-Core Version:    0.7.0.1
 */