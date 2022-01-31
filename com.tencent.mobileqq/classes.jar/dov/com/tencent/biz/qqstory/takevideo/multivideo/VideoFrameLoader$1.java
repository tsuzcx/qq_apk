package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bnah;
import bnai;
import java.lang.ref.WeakReference;

public class VideoFrameLoader$1
  implements Runnable
{
  public VideoFrameLoader$1(bnah parambnah) {}
  
  public void run()
  {
    bnai localbnai = null;
    if (bnah.a(this.this$0) != null) {
      localbnai = (bnai)bnah.a(this.this$0).get();
    }
    if (localbnai != null) {
      localbnai.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.1
 * JD-Core Version:    0.7.0.1
 */