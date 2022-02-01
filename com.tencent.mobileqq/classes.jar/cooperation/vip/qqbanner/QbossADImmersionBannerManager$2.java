package cooperation.vip.qqbanner;

import alfw;
import alfx;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import bmod;
import bmog;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.zipanimate.ZipAnimationDrawable;

public class QbossADImmersionBannerManager$2
  implements Runnable
{
  public QbossADImmersionBannerManager$2(bmog parambmog, alfw paramalfw) {}
  
  public void run()
  {
    if (this.a == null) {}
    while (!(this.a instanceof bmod)) {
      return;
    }
    bmog.a(this.this$0, (bmod)this.a);
    bmog.a(this.this$0).setText(bmog.a(this.this$0, bmog.a(this.this$0).e));
    bmog.b(this.this$0).setText(bmog.b(this.this$0, bmog.a(this.this$0).f));
    bmog.a(this.this$0).setTextColor(bmog.a(this.this$0, bmog.a(this.this$0).g));
    bmog.b(this.this$0).setTextColor(bmog.b(this.this$0, bmog.a(this.this$0).g));
    alfx localalfx = (alfx)this.a.a.get(2);
    bmog.a(this.this$0, new ZipAnimationDrawable());
    bmog.a(this.this$0).setAnimationRes(localalfx.c, bmog.a(this.this$0, bmog.a(this.this$0)));
    bmog.a(this.this$0).setScale(ViewUtils.getScreenWidth() / 720.0F);
    bmog.a(this.this$0).clearFirstFrame();
    bmog.a(this.this$0).setRepeatAnimation(true);
    bmog.a(this.this$0).setShowLastFrameWhenStop(true);
    bmog.a(this.this$0).start();
    bmog.a(this.this$0).setImageDrawable(bmog.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADImmersionBannerManager.2
 * JD-Core Version:    0.7.0.1
 */