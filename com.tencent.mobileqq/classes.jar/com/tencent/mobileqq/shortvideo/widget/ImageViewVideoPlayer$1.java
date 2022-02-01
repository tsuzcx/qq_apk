package com.tencent.mobileqq.shortvideo.widget;

class ImageViewVideoPlayer$1
  implements Runnable
{
  ImageViewVideoPlayer$1(ImageViewVideoPlayer paramImageViewVideoPlayer) {}
  
  public void run()
  {
    if (this.this$0.mPlayerEndListener != null) {
      this.this$0.mPlayerEndListener.onDrawLastFrameEnd();
    }
    this.this$0.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */