package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bitg;
import bith;
import java.lang.ref.WeakReference;

public class VideoFrameLoader$1
  implements Runnable
{
  public VideoFrameLoader$1(bitg parambitg) {}
  
  public void run()
  {
    bith localbith = null;
    if (bitg.a(this.this$0) != null) {
      localbith = (bith)bitg.a(this.this$0).get();
    }
    if (localbith != null) {
      localbith.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.1
 * JD-Core Version:    0.7.0.1
 */