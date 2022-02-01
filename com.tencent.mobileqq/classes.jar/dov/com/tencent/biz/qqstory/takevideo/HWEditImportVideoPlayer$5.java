package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Message;

class HWEditImportVideoPlayer$5
  implements Runnable
{
  HWEditImportVideoPlayer$5(HWEditImportVideoPlayer paramHWEditImportVideoPlayer, long paramLong) {}
  
  public void run()
  {
    long l2 = this.a / 1000000L;
    long l1;
    if (l2 < HWEditImportVideoPlayer.a(this.this$0)) {
      l1 = HWEditImportVideoPlayer.a(this.this$0);
    }
    while (this.this$0.a.b)
    {
      return;
      l1 = l2;
      if (l2 > HWEditImportVideoPlayer.b(this.this$0)) {
        l1 = HWEditImportVideoPlayer.b(this.this$0);
      }
    }
    this.this$0.a.a(Message.obtain(null, 13, new Long[] { Long.valueOf(l1), Long.valueOf(this.a) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.HWEditImportVideoPlayer.5
 * JD-Core Version:    0.7.0.1
 */