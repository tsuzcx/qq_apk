package com.tencent.mobileqq.kandian.biz.video;

import android.content.Context;
import android.os.Looper;
import java.util.HashMap;

public class VideoExtractFrameTask
{
  private static String a = "VideoExtractFrameTask";
  private String b;
  private Context c;
  private VideoExtractFrameTask.Callback d = null;
  private HashMap<Integer, VideoExtractFrameTask.FrameInfo> e;
  private long f;
  private VideoExtractFrameTask.TaskHandler g;
  
  public VideoExtractFrameTask(Context paramContext, String paramString, HashMap<Integer, VideoExtractFrameTask.FrameInfo> paramHashMap, long paramLong)
  {
    this.c = paramContext;
    this.b = paramString;
    this.e = paramHashMap;
    this.f = paramLong;
  }
  
  private void c() {}
  
  public void a()
  {
    this.g = new VideoExtractFrameTask.TaskHandler(this, Looper.getMainLooper());
    this.g.sendEmptyMessageDelayed(1, this.f);
    c();
  }
  
  public void a(VideoExtractFrameTask.Callback paramCallback)
  {
    this.d = paramCallback;
  }
  
  public void b()
  {
    VideoExtractFrameTask.TaskHandler localTaskHandler = this.g;
    if (localTaskHandler != null)
    {
      localTaskHandler.removeCallbacksAndMessages(null);
      this.g = null;
    }
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoExtractFrameTask
 * JD-Core Version:    0.7.0.1
 */