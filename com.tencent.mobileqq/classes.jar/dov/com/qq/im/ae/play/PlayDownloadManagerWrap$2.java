package dov.com.qq.im.ae.play;

import boqu;
import bown;
import bozd;
import mqq.util.WeakReference;

public class PlayDownloadManagerWrap$2
  implements Runnable
{
  public PlayDownloadManagerWrap$2(bozd parambozd, boqu paramboqu) {}
  
  public void run()
  {
    if (this.a.g == 0) {
      if ((bozd.a(this.this$0) != null) && (bozd.a(this.this$0).get() != null))
      {
        bowt.b = this.a;
        ((bown)bozd.a(this.this$0).get()).a(393218, new Object[] { this.a });
      }
    }
    while (((this.a.g != 4) && (this.a.g != 5) && (this.a.g != 6) && (this.a.g != 7)) || (bozd.a(this.this$0) == null) || (bozd.a(this.this$0).get() == null)) {
      return;
    }
    ((bown)bozd.a(this.this$0).get()).a(655361, new Object[] { this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayDownloadManagerWrap.2
 * JD-Core Version:    0.7.0.1
 */