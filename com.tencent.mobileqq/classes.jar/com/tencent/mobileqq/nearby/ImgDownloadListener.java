package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.app.ThreadManager;

public class ImgDownloadListener
  implements URLDrawable.DownloadListener
{
  private long a;
  private Context b;
  private String c = "freshnews.small_pic_download";
  
  public ImgDownloadListener(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public ImgDownloadListener(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.c = paramString;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    ThreadManager.postImmediately(new ImgDownloadListener.2(this, paramInt), null, true);
  }
  
  public void onFileDownloadStarted()
  {
    this.a = SystemClock.elapsedRealtime();
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    ThreadManager.postImmediately(new ImgDownloadListener.1(this, paramLong), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.ImgDownloadListener
 * JD-Core Version:    0.7.0.1
 */