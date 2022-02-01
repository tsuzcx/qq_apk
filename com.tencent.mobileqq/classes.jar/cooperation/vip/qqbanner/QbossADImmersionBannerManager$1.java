package cooperation.vip.qqbanner;

import alaw;
import alax;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import bgtn;
import bmpl;
import bmvc;
import bmvf;

public class QbossADImmersionBannerManager$1
  implements Runnable
{
  public QbossADImmersionBannerManager$1(bmvf parambmvf, alaw paramalaw) {}
  
  public void run()
  {
    if (this.a == null) {}
    while (!(this.a instanceof bmvc)) {
      return;
    }
    bmvf.a(this.this$0, (bmvc)this.a);
    bmvf.a(this.this$0).setText(bmvf.a(this.this$0, bmvf.a(this.this$0).c));
    bmvf.b(this.this$0).setText(bmvf.b(this.this$0, bmvf.a(this.this$0).d));
    bmvf.a(this.this$0).setTextColor(bmvf.a(this.this$0, bmvf.a(this.this$0).e));
    bmvf.b(this.this$0).setTextColor(bmvf.b(this.this$0, bmvf.a(this.this$0).e));
    alax localalax = (alax)this.a.a.get(2);
    bmvf.a(this.this$0, new bmpl());
    bmvf.a(this.this$0).a(localalax.c, bmvf.a(this.this$0, bmvf.a(this.this$0)));
    bmvf.a(this.this$0).a(bgtn.a() / 720.0F);
    bmvf.a(this.this$0).a();
    bmvf.a(this.this$0).a(true);
    bmvf.a(this.this$0).b(true);
    bmvf.a(this.this$0).start();
    bmvf.a(this.this$0).setImageDrawable(bmvf.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADImmersionBannerManager.1
 * JD-Core Version:    0.7.0.1
 */