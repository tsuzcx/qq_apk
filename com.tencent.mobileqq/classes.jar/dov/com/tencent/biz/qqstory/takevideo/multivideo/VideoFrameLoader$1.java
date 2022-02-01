package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bpei;
import bpej;
import java.lang.ref.WeakReference;

public class VideoFrameLoader$1
  implements Runnable
{
  public VideoFrameLoader$1(bpei parambpei) {}
  
  public void run()
  {
    bpej localbpej = null;
    if (bpei.a(this.this$0) != null) {
      localbpej = (bpej)bpei.a(this.this$0).get();
    }
    if (localbpej != null) {
      localbpej.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.1
 * JD-Core Version:    0.7.0.1
 */