package com.tencent.qg.sdk.video;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class VideoPlayer$PlayHandler
  extends Handler
{
  public VideoPlayer$PlayHandler(VideoPlayer paramVideoPlayer, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      VideoPlayer.access$000(this.this$0);
      return;
    case 2: 
      VideoPlayer.access$100(this.this$0);
      return;
    case 3: 
      VideoPlayer.access$200(this.this$0);
      return;
    }
    VideoPlayer.access$300(this.this$0, ((Integer)paramMessage.obj).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.video.VideoPlayer.PlayHandler
 * JD-Core Version:    0.7.0.1
 */