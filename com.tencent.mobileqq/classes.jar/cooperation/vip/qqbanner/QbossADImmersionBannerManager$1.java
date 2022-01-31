package cooperation.vip.qqbanner;

import ajin;
import ajio;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import bdoo;
import bkbb;
import bkgj;
import bkgm;

public class QbossADImmersionBannerManager$1
  implements Runnable
{
  public QbossADImmersionBannerManager$1(bkgm parambkgm, ajin paramajin) {}
  
  public void run()
  {
    if (this.a == null) {}
    while (!(this.a instanceof bkgj)) {
      return;
    }
    bkgm.a(this.this$0, (bkgj)this.a);
    bkgm.a(this.this$0).setText(bkgm.a(this.this$0, bkgm.a(this.this$0).c));
    bkgm.b(this.this$0).setText(bkgm.b(this.this$0, bkgm.a(this.this$0).d));
    bkgm.a(this.this$0).setTextColor(bkgm.a(this.this$0, bkgm.a(this.this$0).e));
    bkgm.b(this.this$0).setTextColor(bkgm.b(this.this$0, bkgm.a(this.this$0).e));
    ajio localajio = (ajio)this.a.a.get(2);
    bkgm.a(this.this$0, new bkbb());
    bkgm.a(this.this$0).a(localajio.c, bkgm.a(this.this$0, bkgm.a(this.this$0)));
    bkgm.a(this.this$0).a(bdoo.a() / 720.0F);
    bkgm.a(this.this$0).a();
    bkgm.a(this.this$0).a(true);
    bkgm.a(this.this$0).b(true);
    bkgm.a(this.this$0).start();
    bkgm.a(this.this$0).setImageDrawable(bkgm.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADImmersionBannerManager.1
 * JD-Core Version:    0.7.0.1
 */