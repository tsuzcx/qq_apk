package cooperation.vip.qqbanner;

import almm;
import almn;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import bhtq;
import bnqp;
import bnwk;
import bnwn;

public class QbossADImmersionBannerManager$1
  implements Runnable
{
  public QbossADImmersionBannerManager$1(bnwn parambnwn, almm paramalmm) {}
  
  public void run()
  {
    if (this.a == null) {}
    while (!(this.a instanceof bnwk)) {
      return;
    }
    bnwn.a(this.this$0, (bnwk)this.a);
    bnwn.a(this.this$0).setText(bnwn.a(this.this$0, bnwn.a(this.this$0).e));
    bnwn.b(this.this$0).setText(bnwn.b(this.this$0, bnwn.a(this.this$0).f));
    bnwn.a(this.this$0).setTextColor(bnwn.a(this.this$0, bnwn.a(this.this$0).g));
    bnwn.b(this.this$0).setTextColor(bnwn.b(this.this$0, bnwn.a(this.this$0).g));
    almn localalmn = (almn)this.a.a.get(2);
    bnwn.a(this.this$0, new bnqp());
    bnwn.a(this.this$0).a(localalmn.c, bnwn.a(this.this$0, bnwn.a(this.this$0)));
    bnwn.a(this.this$0).a(bhtq.a() / 720.0F);
    bnwn.a(this.this$0).a();
    bnwn.a(this.this$0).a(true);
    bnwn.a(this.this$0).b(true);
    bnwn.a(this.this$0).start();
    bnwn.a(this.this$0).setImageDrawable(bnwn.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADImmersionBannerManager.1
 * JD-Core Version:    0.7.0.1
 */