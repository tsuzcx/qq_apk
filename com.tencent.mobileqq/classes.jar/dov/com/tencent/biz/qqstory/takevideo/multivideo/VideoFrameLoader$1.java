package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bprn;
import bpro;
import java.lang.ref.WeakReference;

public class VideoFrameLoader$1
  implements Runnable
{
  public VideoFrameLoader$1(bprn parambprn) {}
  
  public void run()
  {
    bpro localbpro = null;
    if (bprn.a(this.this$0) != null) {
      localbpro = (bpro)bprn.a(this.this$0).get();
    }
    if (localbpro != null) {
      localbpro.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.1
 * JD-Core Version:    0.7.0.1
 */