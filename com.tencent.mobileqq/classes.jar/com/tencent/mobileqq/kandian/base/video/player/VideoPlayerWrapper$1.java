package com.tencent.mobileqq.kandian.base.video.player;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.video.player.api.IPlayer;
import java.util.Properties;

class VideoPlayerWrapper$1
  implements Runnable
{
  VideoPlayerWrapper$1(VideoPlayerWrapper paramVideoPlayerWrapper, IPlayer paramIPlayer) {}
  
  public void run()
  {
    Object localObject = this.a.a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = RIJStringUtils.a((String)localObject);
      if (localObject != null) {
        localObject = ((Properties)localObject).getProperty("VideoBitRate");
      } else {
        localObject = null;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.this$0.a = Long.parseLong((String)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */