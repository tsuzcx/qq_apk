package cooperation.vip.qqbanner;

import ajdy;
import ajdz;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import bdkf;
import bjwu;
import bkcc;
import bkcf;

public class QbossADImmersionBannerManager$1
  implements Runnable
{
  public QbossADImmersionBannerManager$1(bkcf parambkcf, ajdy paramajdy) {}
  
  public void run()
  {
    if (this.a == null) {}
    while (!(this.a instanceof bkcc)) {
      return;
    }
    bkcf.a(this.this$0, (bkcc)this.a);
    bkcf.a(this.this$0).setText(bkcf.a(this.this$0, bkcf.a(this.this$0).c));
    bkcf.b(this.this$0).setText(bkcf.b(this.this$0, bkcf.a(this.this$0).d));
    bkcf.a(this.this$0).setTextColor(bkcf.a(this.this$0, bkcf.a(this.this$0).e));
    bkcf.b(this.this$0).setTextColor(bkcf.b(this.this$0, bkcf.a(this.this$0).e));
    ajdz localajdz = (ajdz)this.a.a.get(2);
    bkcf.a(this.this$0, new bjwu());
    bkcf.a(this.this$0).a(localajdz.c, bkcf.a(this.this$0, bkcf.a(this.this$0)));
    bkcf.a(this.this$0).a(bdkf.a() / 720.0F);
    bkcf.a(this.this$0).a();
    bkcf.a(this.this$0).a(true);
    bkcf.a(this.this$0).b(true);
    bkcf.a(this.this$0).start();
    bkcf.a(this.this$0).setImageDrawable(bkcf.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADImmersionBannerManager.1
 * JD-Core Version:    0.7.0.1
 */