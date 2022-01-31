package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;
import bmix;
import bmkq;

public class HWEditImportVideoPlayer$5
  implements Runnable
{
  public HWEditImportVideoPlayer$5(bmkq parambmkq, long paramLong) {}
  
  public void run()
  {
    long l2 = this.a / 1000000L;
    long l1;
    if (l2 < bmkq.a(this.this$0)) {
      l1 = bmkq.a(this.this$0);
    }
    while (this.this$0.a.b)
    {
      return;
      l1 = l2;
      if (l2 > bmkq.b(this.this$0)) {
        l1 = bmkq.b(this.this$0);
      }
    }
    this.this$0.a.a(Message.obtain(null, 13, new Long[] { Long.valueOf(l1), Long.valueOf(this.a) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */