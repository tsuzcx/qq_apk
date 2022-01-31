package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import bmeu;
import bmix;

class HWEditLocalVideoPlayer$6
  implements Runnable
{
  HWEditLocalVideoPlayer$6(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    bmeu localbmeu = (bmeu)this.this$0.a(bmeu.class);
    if (localbmeu != null) {
      localbmeu.b();
    }
    this.this$0.a.a(Message.obtain(null, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */