package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;

class HWEditImportVideoPlayer$6
  implements Runnable
{
  HWEditImportVideoPlayer$6(HWEditImportVideoPlayer paramHWEditImportVideoPlayer) {}
  
  public void run()
  {
    if (this.this$0.g) {
      return;
    }
    EditMusicExport localEditMusicExport = (EditMusicExport)this.this$0.a(EditMusicExport.class);
    if (localEditMusicExport != null) {
      localEditMusicExport.b();
    }
    this.this$0.a.a(Message.obtain(null, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */