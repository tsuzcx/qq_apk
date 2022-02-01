package com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider;

import com.tencent.qcircle.tavcut.util.Logger;

class VideoThumbVideoGenerator$ReleaseRunnable
  implements Runnable
{
  private VideoThumbVideoGenerator$ReleaseRunnable(VideoThumbVideoGenerator paramVideoThumbVideoGenerator) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release success:");
    localStringBuilder.append(Thread.currentThread().getName());
    Logger.i("VideoThumbVideoGenerator", localStringBuilder.toString());
    VideoThumbVideoGenerator.access$100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.weishi.module.edit.widget.playtrack.provider.VideoThumbVideoGenerator.ReleaseRunnable
 * JD-Core Version:    0.7.0.1
 */