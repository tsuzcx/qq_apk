package cooperation.vip.qqbanner;

import alfw;
import android.widget.TextView;
import bmob;
import bmoc;

public class QbossADBannerCountDownManager$1
  implements Runnable
{
  public QbossADBannerCountDownManager$1(bmoc parambmoc, alfw paramalfw) {}
  
  public void run()
  {
    if (this.a == null) {}
    do
    {
      do
      {
        return;
      } while (!(this.a instanceof bmob));
      bmoc.a(this.this$0, (bmob)this.a);
      bmoc.a(this.this$0).setText(bmoc.a(this.this$0, bmoc.a(this.this$0).e));
      bmoc.b(this.this$0).setText(bmoc.b(this.this$0, bmoc.a(this.this$0).f));
      bmoc.a(this.this$0).setTextColor(bmoc.a(this.this$0, bmoc.a(this.this$0).g));
      bmoc.b(this.this$0).setTextColor(bmoc.b(this.this$0, bmoc.a(this.this$0).g));
      bmoc.a(this.this$0, bmoc.a(this.this$0));
      bmoc.c(this.this$0).setBackgroundDrawable(bmoc.a(this.this$0, bmoc.a(this.this$0).h));
      bmoc.c(this.this$0).setTextColor(bmoc.c(this.this$0, bmoc.a(this.this$0).i));
    } while (bmoc.a(this.this$0).d != 1);
    bmoc.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADBannerCountDownManager.1
 * JD-Core Version:    0.7.0.1
 */