package dov.com.qq.im.ae.play;

import bire;
import biws;
import bizf;
import mqq.util.WeakReference;

public class PlayDownloadManagerWrap$2
  implements Runnable
{
  public PlayDownloadManagerWrap$2(bizf parambizf, bire parambire) {}
  
  public void run()
  {
    if (this.a.f == 0) {
      if ((bizf.a(this.this$0) != null) && (bizf.a(this.this$0).get() != null))
      {
        biwy.b = this.a;
        ((biws)bizf.a(this.this$0).get()).a(393218, new Object[] { this.a });
      }
    }
    while (((this.a.f != 4) && (this.a.f != 5) && (this.a.f != 6) && (this.a.f != 7)) || (bizf.a(this.this$0) == null) || (bizf.a(this.this$0).get() == null)) {
      return;
    }
    ((biws)bizf.a(this.this$0).get()).a(655361, new Object[] { this.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.play.PlayDownloadManagerWrap.2
 * JD-Core Version:    0.7.0.1
 */