package com.tencent.mobileqq.shortvideo.widget;

import com.tencent.image.VideoDrawable;
import com.tencent.qphone.base.util.QLog;

class ImageViewVideoPlayer$2
  implements Runnable
{
  ImageViewVideoPlayer$2(ImageViewVideoPlayer paramImageViewVideoPlayer, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.mVideoDrawable != null)
    {
      long l = System.currentTimeMillis();
      this.this$0.mVideoDrawable.resetAndPlayAudioOnce();
      if (QLog.isColorLevel()) {
        QLog.i("ImageViewVideoPlayer", 2, "onPlayRepeat: repeatTimes = " + this.val$repeatTimes + ", costTime = " + (System.currentTimeMillis() - l));
      }
      if (this.this$0.mPlayerEndListener != null) {
        this.this$0.mPlayerEndListener.onPlayerRecyle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.2
 * JD-Core Version:    0.7.0.1
 */