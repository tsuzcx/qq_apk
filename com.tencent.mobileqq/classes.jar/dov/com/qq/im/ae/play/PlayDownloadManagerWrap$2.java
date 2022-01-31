package dov.com.qq.im.ae.play;

import biqn;
import biwb;
import biyo;
import mqq.util.WeakReference;

public class PlayDownloadManagerWrap$2
  implements Runnable
{
  public PlayDownloadManagerWrap$2(biyo parambiyo, biqn parambiqn) {}
  
  public void run()
  {
    if (this.a.f == 0) {
      if ((biyo.a(this.this$0) != null) && (biyo.a(this.this$0).get() != null))
      {
        biwh.b = this.a;
        ((biwb)biyo.a(this.this$0).get()).a(393218, new Object[] { this.a });
      }
    }
    while (((this.a.f != 4) && (this.a.f != 5) && (this.a.f != 6) && (this.a.f != 7)) || (biyo.a(this.this$0) == null) || (biyo.a(this.this$0).get() == null)) {
      return;
    }
    ((biwb)biyo.a(this.this$0).get()).a(655361, new Object[] { this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayDownloadManagerWrap.2
 * JD-Core Version:    0.7.0.1
 */