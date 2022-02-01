package com.tencent.mobileqq.editor.composite;

import android.annotation.TargetApi;
import android.os.SystemClock;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.videocodec.ffmpeg.ExecuteBinResponseCallback;

@TargetApi(14)
public class VideoCompositeHelper$MusicCallBack
  extends ExecuteBinResponseCallback
{
  private VideoCompositeHelper.VideoCompositeCallBack a;
  private String b;
  private String c;
  private long d = SystemClock.elapsedRealtime();
  private int e = 941000;
  
  public VideoCompositeHelper$MusicCallBack(String paramString1, String paramString2, VideoCompositeHelper.VideoCompositeCallBack paramVideoCompositeCallBack)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.a = paramVideoCompositeCallBack;
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void onFailure(String paramString)
  {
    if (paramString.equals(String.valueOf(941001))) {
      this.a.a(941001, paramString, "");
    } else if (paramString.equals(String.valueOf(941002))) {
      this.a.a(941002, paramString, "");
    } else {
      this.a.a(this.e, paramString, "");
    }
    SLog.d(VideoCompositeHelper.a, "combine audio fail %s, %d", new Object[] { paramString, Integer.valueOf(this.e) });
    FileUtils.k(this.b);
  }
  
  public void onSuccess(String paramString)
  {
    SLog.a(VideoCompositeHelper.a, "combine music success take time:%d", Long.valueOf(SystemClock.elapsedRealtime() - this.d));
    this.a.a(0, "", this.c);
    FileUtils.k(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.editor.composite.VideoCompositeHelper.MusicCallBack
 * JD-Core Version:    0.7.0.1
 */