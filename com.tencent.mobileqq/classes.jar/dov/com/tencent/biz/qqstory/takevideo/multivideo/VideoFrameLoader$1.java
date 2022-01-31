package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import bmvv;
import bmvw;
import java.lang.ref.WeakReference;

public class VideoFrameLoader$1
  implements Runnable
{
  public VideoFrameLoader$1(bmvv parambmvv) {}
  
  public void run()
  {
    bmvw localbmvw = null;
    if (bmvv.a(this.this$0) != null) {
      localbmvw = (bmvw)bmvv.a(this.this$0).get();
    }
    if (localbmvw != null) {
      localbmvw.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.1
 * JD-Core Version:    0.7.0.1
 */