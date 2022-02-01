package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bqti;
import bqtj;
import java.lang.ref.WeakReference;

public class VideoFrameLoader$1
  implements Runnable
{
  public VideoFrameLoader$1(bqti parambqti) {}
  
  public void run()
  {
    bqtj localbqtj = null;
    if (bqti.a(this.this$0) != null) {
      localbqtj = (bqtj)bqti.a(this.this$0).get();
    }
    if (localbqtj != null) {
      localbqtj.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.1
 * JD-Core Version:    0.7.0.1
 */