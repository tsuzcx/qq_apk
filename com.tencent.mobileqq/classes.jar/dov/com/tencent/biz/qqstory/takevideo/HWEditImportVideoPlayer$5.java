package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import bmnj;
import bmpc;

public class HWEditImportVideoPlayer$5
  implements Runnable
{
  public HWEditImportVideoPlayer$5(bmpc parambmpc, long paramLong) {}
  
  public void run()
  {
    long l2 = this.a / 1000000L;
    long l1;
    if (l2 < bmpc.a(this.this$0)) {
      l1 = bmpc.a(this.this$0);
    }
    while (this.this$0.a.b)
    {
      return;
      l1 = l2;
      if (l2 > bmpc.b(this.this$0)) {
        l1 = bmpc.b(this.this$0);
      }
    }
    this.this$0.a.a(Message.obtain(null, 13, new Long[] { Long.valueOf(l1), Long.valueOf(this.a) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */