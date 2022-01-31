package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import bjst;
import bjww;
import bjyp;

public class HWEditImportVideoPlayer$6
  implements Runnable
{
  public HWEditImportVideoPlayer$6(bjyp parambjyp) {}
  
  public void run()
  {
    if (this.this$0.j) {
      return;
    }
    bjst localbjst = (bjst)this.this$0.a(bjst.class);
    if (localbjst != null) {
      localbjst.b();
    }
    this.this$0.a.a(Message.obtain(null, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */