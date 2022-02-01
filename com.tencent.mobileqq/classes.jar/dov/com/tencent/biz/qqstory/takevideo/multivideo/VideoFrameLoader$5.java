package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import java.lang.ref.WeakReference;
import java.util.List;

class VideoFrameLoader$5
  implements Runnable
{
  VideoFrameLoader$5(VideoFrameLoader paramVideoFrameLoader, List paramList) {}
  
  public void run()
  {
    VideoFrameLoader.VideoFrameLoaderListener localVideoFrameLoaderListener = null;
    if (VideoFrameLoader.a(this.this$0) != null) {
      localVideoFrameLoaderListener = (VideoFrameLoader.VideoFrameLoaderListener)VideoFrameLoader.a(this.this$0).get();
    }
    if (localVideoFrameLoaderListener != null) {
      localVideoFrameLoaderListener.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.5
 * JD-Core Version:    0.7.0.1
 */