package dov.com.qq.im.ae.play;

import blab;
import blft;
import blig;
import mqq.util.WeakReference;

public class PlayDownloadManagerWrap$2
  implements Runnable
{
  public PlayDownloadManagerWrap$2(blig paramblig, blab paramblab) {}
  
  public void run()
  {
    if (this.a.f == 0) {
      if ((blig.a(this.this$0) != null) && (blig.a(this.this$0).get() != null))
      {
        blfz.b = this.a;
        ((blft)blig.a(this.this$0).get()).a(393218, new Object[] { this.a });
      }
    }
    while (((this.a.f != 4) && (this.a.f != 5) && (this.a.f != 6) && (this.a.f != 7)) || (blig.a(this.this$0) == null) || (blig.a(this.this$0).get() == null)) {
      return;
    }
    ((blft)blig.a(this.this$0).get()).a(655361, new Object[] { this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayDownloadManagerWrap.2
 * JD-Core Version:    0.7.0.1
 */