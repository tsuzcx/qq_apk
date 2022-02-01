package dov.com.qq.im.aeeditor.view.videotrack;

import bofr;

class VideoTrackContainerView$1
  implements Runnable
{
  VideoTrackContainerView$1(VideoTrackContainerView paramVideoTrackContainerView) {}
  
  public void run()
  {
    int i = this.this$0.getScrollX();
    if (VideoTrackContainerView.a(this.this$0) - i == 0)
    {
      if (VideoTrackContainerView.a(this.this$0) != null) {
        VideoTrackContainerView.a(this.this$0).a();
      }
      return;
    }
    VideoTrackContainerView.a(this.this$0, i);
    this.this$0.postDelayed(VideoTrackContainerView.a(this.this$0), 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.view.videotrack.VideoTrackContainerView.1
 * JD-Core Version:    0.7.0.1
 */