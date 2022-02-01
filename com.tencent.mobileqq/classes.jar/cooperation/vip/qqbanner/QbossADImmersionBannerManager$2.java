package cooperation.vip.qqbanner;

import akke;
import akkf;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import blbp;
import blbs;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.zipanimate.ZipAnimationDrawable;

public class QbossADImmersionBannerManager$2
  implements Runnable
{
  public QbossADImmersionBannerManager$2(blbs paramblbs, akke paramakke) {}
  
  public void run()
  {
    if (this.a == null) {}
    while (!(this.a instanceof blbp)) {
      return;
    }
    blbs.a(this.this$0, (blbp)this.a);
    blbs.a(this.this$0).setText(blbs.a(this.this$0, blbs.a(this.this$0).e));
    blbs.b(this.this$0).setText(blbs.b(this.this$0, blbs.a(this.this$0).f));
    blbs.a(this.this$0).setTextColor(blbs.a(this.this$0, blbs.a(this.this$0).g));
    blbs.b(this.this$0).setTextColor(blbs.b(this.this$0, blbs.a(this.this$0).g));
    akkf localakkf = (akkf)this.a.a.get(2);
    blbs.a(this.this$0, new ZipAnimationDrawable());
    blbs.a(this.this$0).setAnimationRes(localakkf.c, blbs.a(this.this$0, blbs.a(this.this$0)));
    blbs.a(this.this$0).setScale(ViewUtils.getScreenWidth() / 720.0F);
    blbs.a(this.this$0).clearFirstFrame();
    blbs.a(this.this$0).setRepeatAnimation(true);
    blbs.a(this.this$0).setShowLastFrameWhenStop(true);
    blbs.a(this.this$0).start();
    blbs.a(this.this$0).setImageDrawable(blbs.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADImmersionBannerManager.2
 * JD-Core Version:    0.7.0.1
 */