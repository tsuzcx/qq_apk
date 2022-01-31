package cooperation.vip.qqbanner;

import ahac;
import ahad;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import bajq;
import bgmb;
import bgqq;
import bgqt;

public class QbossADImmersionBannerManager$1
  implements Runnable
{
  public QbossADImmersionBannerManager$1(bgqt parambgqt, ahac paramahac) {}
  
  public void run()
  {
    if (this.a == null) {}
    while (!(this.a instanceof bgqq)) {
      return;
    }
    bgqt.a(this.this$0, (bgqq)this.a);
    bgqt.a(this.this$0).setText(bgqt.a(this.this$0, bgqt.a(this.this$0).c));
    bgqt.b(this.this$0).setText(bgqt.b(this.this$0, bgqt.a(this.this$0).d));
    bgqt.a(this.this$0).setTextColor(bgqt.a(this.this$0, bgqt.a(this.this$0).e));
    bgqt.b(this.this$0).setTextColor(bgqt.b(this.this$0, bgqt.a(this.this$0).e));
    ahad localahad = (ahad)this.a.a.get(2);
    bgqt.a(this.this$0, new bgmb());
    bgqt.a(this.this$0).a(localahad.c, bgqt.a(this.this$0, bgqt.a(this.this$0)));
    bgqt.a(this.this$0).a(bajq.a() / 720.0F);
    bgqt.a(this.this$0).a();
    bgqt.a(this.this$0).a(true);
    bgqt.a(this.this$0).b(true);
    bgqt.a(this.this$0).start();
    bgqt.a(this.this$0).setImageDrawable(bgqt.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADImmersionBannerManager.1
 * JD-Core Version:    0.7.0.1
 */