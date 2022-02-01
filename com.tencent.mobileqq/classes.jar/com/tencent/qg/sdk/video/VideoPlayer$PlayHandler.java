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
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          VideoPlayer.access$300(this.this$0, ((Integer)paramMessage.obj).intValue());
          return;
        }
        VideoPlayer.access$200(this.this$0);
        return;
      }
      VideoPlayer.access$100(this.this$0);
      return;
    }
    VideoPlayer.access$000(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.sdk.video.VideoPlayer.PlayHandler
 * JD-Core Version:    0.7.0.1
 */