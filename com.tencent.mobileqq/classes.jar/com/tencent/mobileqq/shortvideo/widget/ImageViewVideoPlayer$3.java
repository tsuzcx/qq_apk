package com.tencent.mobileqq.shortvideo.widget;

class ImageViewVideoPlayer$3
  implements Runnable
{
  ImageViewVideoPlayer$3(ImageViewVideoPlayer paramImageViewVideoPlayer) {}
  
  public void run()
  {
    if (this.this$0.mPlayerEndListener != null) {
      this.this$0.mPlayerEndListener.onPlayerEnd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.3
 * JD-Core Version:    0.7.0.1
 */