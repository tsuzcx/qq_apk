package dov.com.qq.im.ae.download.old;

import com.tencent.mobileqq.shortvideo.VideoEnvironment;

class AEOldShortVideoResDownload$ResDownloadCallBack
  implements AEOldShortVideoResManager.INet_ShortVideoResource
{
  boolean a = true;
  boolean b = true;
  boolean c = true;
  AEOldShortVideoResDownload d;
  private String e;
  
  public AEOldShortVideoResDownload$ResDownloadCallBack(String paramString, AEOldShortVideoResDownload paramAEOldShortVideoResDownload)
  {
    this.e = paramString;
    this.d = paramAEOldShortVideoResDownload;
  }
  
  public void a()
  {
    if ((this.a) && (this.b)) {
      AEOldShortVideoResDownload.a(this.d);
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    String str = this.e;
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
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    String str = this.e;
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
  
  public void b()
  {
    VideoEnvironment.LogDownLoad(this.e, "onNetWorkNone...", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     dov.com.qq.im.ae.download.old.AEOldShortVideoResDownload.ResDownloadCallBack
 * JD-Core Version:    0.7.0.1
 */