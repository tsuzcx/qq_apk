package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import bmeu;
import bmix;
import bmkq;

public class HWEditImportVideoPlayer$6
  implements Runnable
{
  public HWEditImportVideoPlayer$6(bmkq parambmkq) {}
  
  public void run()
  {
    if (this.this$0.j) {
      return;
    }
    bmeu localbmeu = (bmeu)this.this$0.a(bmeu.class);
    if (localbmeu != null) {
      localbmeu.b();
    }
    this.this$0.a.a(Message.obtain(null, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */