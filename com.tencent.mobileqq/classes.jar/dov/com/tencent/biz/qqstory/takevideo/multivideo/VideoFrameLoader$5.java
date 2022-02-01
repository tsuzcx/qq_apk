package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bprn;
import bpro;
import java.lang.ref.WeakReference;
import java.util.List;

public class VideoFrameLoader$5
  implements Runnable
{
  public VideoFrameLoader$5(bprn parambprn, List paramList) {}
  
  public void run()
  {
    bpro localbpro = null;
    if (bprn.a(this.this$0) != null) {
      localbpro = (bpro)bprn.a(this.this$0).get();
    }
    if (localbpro != null) {
      localbpro.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.5
 * JD-Core Version:    0.7.0.1
 */