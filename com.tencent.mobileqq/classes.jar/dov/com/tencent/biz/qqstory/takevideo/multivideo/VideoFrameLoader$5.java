package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bkkl;
import bkkm;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoFrameLoader$5
  implements Runnable
{
  public VideoFrameLoader$5(bkkl parambkkl, List paramList) {}
  
  public void run()
  {
    bkkm localbkkm = null;
    if (bkkl.a(this.this$0) != null) {
      localbkkm = (bkkm)bkkl.a(this.this$0).get();
    }
    if (localbkkm != null) {
      localbkkm.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.5
 * JD-Core Version:    0.7.0.1
 */