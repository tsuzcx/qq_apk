package com.tencent.weishi.module.edit.widget.playtrack.provider;

import com.tencent.tavcut.util.Logger;

class VideoThumbVideoGenerator$ReleaseRunnable
  implements Runnable
{
  private VideoThumbVideoGenerator$ReleaseRunnable(VideoThumbVideoGenerator paramVideoThumbVideoGenerator) {}
  
  public void run()
  {
    Logger.i("VideoThumbVideoGenerator", "release success:" + Thread.currentThread().getName());
    VideoThumbVideoGenerator.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.weishi.module.edit.widget.playtrack.provider.VideoThumbVideoGenerator.ReleaseRunnable
 * JD-Core Version:    0.7.0.1
 */