package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;

class HWEditLocalVideoPlayer$6
  implements Runnable
{
  HWEditLocalVideoPlayer$6(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    EditMusicExport localEditMusicExport = (EditMusicExport)this.this$0.a(EditMusicExport.class);
    if (localEditMusicExport != null) {
      localEditMusicExport.b();
    }
    this.this$0.a.a(Message.obtain(null, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditLocalVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */