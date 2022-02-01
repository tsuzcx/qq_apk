package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class VideoPlayManager$UiHandler
  extends Handler
{
  private WeakReference<VideoPlayManager> a;
  
  public VideoPlayManager$UiHandler(VideoPlayManager paramVideoPlayManager)
  {
    this.a = new WeakReference(paramVideoPlayManager);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject1 = this.a;
    if (localObject1 != null) {
      localObject1 = (VideoPlayManager)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      if (paramMessage.what != 0) {
        return;
      }
      if (VideoPlayManager.c((VideoPlayManager)localObject1) != null)
      {
        if (VideoPlayManager.VideoPlayParam.a(VideoPlayManager.c((VideoPlayManager)localObject1)) == null) {
          return;
        }
        Object localObject2 = VideoPlayManager.VideoPlayParam.a(VideoPlayManager.c((VideoPlayManager)localObject1));
        paramMessage = VideoPlayManager.c((VideoPlayManager)localObject1);
        if ((localObject2 != null) && (((VideoPlayerWrapper)localObject2).n()))
        {
          long l = ((VideoPlayerWrapper)localObject2).C();
          localObject2 = VideoPlayManager.d((VideoPlayManager)localObject1).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((VideoPlayManager.VideoStatusListener)((Iterator)localObject2).next()).a(paramMessage, ViolaVideoDelegate.a(l) * 1000);
          }
        }
        VideoPlayManager.a((VideoPlayManager)localObject1).sendEmptyMessageDelayed(0, VideoPlayManager.e((VideoPlayManager)localObject1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VideoPlayManager.UiHandler
 * JD-Core Version:    0.7.0.1
 */