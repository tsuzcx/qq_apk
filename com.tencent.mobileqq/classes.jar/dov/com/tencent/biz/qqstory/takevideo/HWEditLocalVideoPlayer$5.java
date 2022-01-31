package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import bmix;

class HWEditLocalVideoPlayer$5
  implements Runnable
{
  HWEditLocalVideoPlayer$5(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer, long paramLong) {}
  
  public void run()
  {
    if (this.this$0.a.b) {
      return;
    }
    this.this$0.a.a(Message.obtain(null, 13, new Long[] { Long.valueOf(this.a / 1000000L), Long.valueOf(this.a) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */