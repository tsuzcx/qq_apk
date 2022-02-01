package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bnoq;
import bnor;
import java.lang.ref.WeakReference;

public class VideoFrameLoader$1
  implements Runnable
{
  public VideoFrameLoader$1(bnoq parambnoq) {}
  
  public void run()
  {
    bnor localbnor = null;
    if (bnoq.a(this.this$0) != null) {
      localbnor = (bnor)bnoq.a(this.this$0).get();
    }
    if (localbnor != null) {
      localbnor.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.1
 * JD-Core Version:    0.7.0.1
 */