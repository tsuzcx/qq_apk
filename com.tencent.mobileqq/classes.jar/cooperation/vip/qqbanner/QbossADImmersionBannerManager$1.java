package cooperation.vip.qqbanner;

import ahmr;
import ahms;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import bbkx;
import bhus;
import bhzp;
import bhzs;

public class QbossADImmersionBannerManager$1
  implements Runnable
{
  public QbossADImmersionBannerManager$1(bhzs parambhzs, ahmr paramahmr) {}
  
  public void run()
  {
    if (this.a == null) {}
    while (!(this.a instanceof bhzp)) {
      return;
    }
    bhzs.a(this.this$0, (bhzp)this.a);
    bhzs.a(this.this$0).setText(bhzs.a(this.this$0, bhzs.a(this.this$0).c));
    bhzs.b(this.this$0).setText(bhzs.b(this.this$0, bhzs.a(this.this$0).d));
    bhzs.a(this.this$0).setTextColor(bhzs.a(this.this$0, bhzs.a(this.this$0).e));
    bhzs.b(this.this$0).setTextColor(bhzs.b(this.this$0, bhzs.a(this.this$0).e));
    ahms localahms = (ahms)this.a.a.get(2);
    bhzs.a(this.this$0, new bhus());
    bhzs.a(this.this$0).a(localahms.c, bhzs.a(this.this$0, bhzs.a(this.this$0)));
    bhzs.a(this.this$0).a(bbkx.a() / 720.0F);
    bhzs.a(this.this$0).a();
    bhzs.a(this.this$0).a(true);
    bhzs.a(this.this$0).b(true);
    bhzs.a(this.this$0).start();
    bhzs.a(this.this$0).setImageDrawable(bhzs.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADImmersionBannerManager.1
 * JD-Core Version:    0.7.0.1
 */