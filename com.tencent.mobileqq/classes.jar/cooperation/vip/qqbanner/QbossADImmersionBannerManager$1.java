package cooperation.vip.qqbanner;

import ahmp;
import ahmq;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import bbll;
import bhvj;
import biag;
import biaj;

public class QbossADImmersionBannerManager$1
  implements Runnable
{
  public QbossADImmersionBannerManager$1(biaj parambiaj, ahmp paramahmp) {}
  
  public void run()
  {
    if (this.a == null) {}
    while (!(this.a instanceof biag)) {
      return;
    }
    biaj.a(this.this$0, (biag)this.a);
    biaj.a(this.this$0).setText(biaj.a(this.this$0, biaj.a(this.this$0).c));
    biaj.b(this.this$0).setText(biaj.b(this.this$0, biaj.a(this.this$0).d));
    biaj.a(this.this$0).setTextColor(biaj.a(this.this$0, biaj.a(this.this$0).e));
    biaj.b(this.this$0).setTextColor(biaj.b(this.this$0, biaj.a(this.this$0).e));
    ahmq localahmq = (ahmq)this.a.a.get(2);
    biaj.a(this.this$0, new bhvj());
    biaj.a(this.this$0).a(localahmq.c, biaj.a(this.this$0, biaj.a(this.this$0)));
    biaj.a(this.this$0).a(bbll.a() / 720.0F);
    biaj.a(this.this$0).a();
    biaj.a(this.this$0).a(true);
    biaj.a(this.this$0).b(true);
    biaj.a(this.this$0).start();
    biaj.a(this.this$0).setImageDrawable(biaj.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADImmersionBannerManager.1
 * JD-Core Version:    0.7.0.1
 */