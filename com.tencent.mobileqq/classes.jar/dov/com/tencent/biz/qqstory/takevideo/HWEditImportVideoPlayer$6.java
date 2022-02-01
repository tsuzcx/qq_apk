package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import bpam;
import bpep;
import bpgi;

public class HWEditImportVideoPlayer$6
  implements Runnable
{
  public HWEditImportVideoPlayer$6(bpgi parambpgi) {}
  
  public void run()
  {
    if (this.this$0.j) {
      return;
    }
    bpam localbpam = (bpam)this.this$0.a(bpam.class);
    if (localbpam != null) {
      localbpam.b();
    }
    this.this$0.a.a(Message.obtain(null, 14));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.6
 * JD-Core Version:    0.7.0.1
 */