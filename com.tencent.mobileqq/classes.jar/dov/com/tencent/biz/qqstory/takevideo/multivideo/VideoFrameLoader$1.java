package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bkkl;
import bkkm;
import java.lang.ref.WeakReference;

public class VideoFrameLoader$1
  implements Runnable
{
  public VideoFrameLoader$1(bkkl parambkkl) {}
  
  public void run()
  {
    bkkm localbkkm = null;
    if (bkkl.a(this.this$0) != null) {
      localbkkm = (bkkm)bkkl.a(this.this$0).get();
    }
    if (localbkkm != null) {
      localbkkm.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.1
 * JD-Core Version:    0.7.0.1
 */