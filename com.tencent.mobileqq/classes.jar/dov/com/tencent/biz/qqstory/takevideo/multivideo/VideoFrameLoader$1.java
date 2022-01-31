package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bkju;
import bkjv;
import java.lang.ref.WeakReference;

public class VideoFrameLoader$1
  implements Runnable
{
  public VideoFrameLoader$1(bkju parambkju) {}
  
  public void run()
  {
    bkjv localbkjv = null;
    if (bkju.a(this.this$0) != null) {
      localbkjv = (bkjv)bkju.a(this.this$0).get();
    }
    if (localbkjv != null) {
      localbkjv.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.1
 * JD-Core Version:    0.7.0.1
 */