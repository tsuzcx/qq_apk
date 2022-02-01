package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import bosc;
import botw;

class HWEditLocalVideoPlayer$6
  implements Runnable
{
  HWEditLocalVideoPlayer$6(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    bosc localbosc = (bosc)this.this$0.a(bosc.class);
    if (localbosc != null) {
      localbosc.b();
    }
    this.this$0.a.a(Message.obtain(null, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */