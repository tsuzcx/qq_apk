package cooperation.vip.qqbanner;

import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo.ResourceInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import cooperation.qzone.zipanimate.ZipAnimationDrawable;

class QbossADImmersionBannerManager$2
  implements Runnable
{
  QbossADImmersionBannerManager$2(QbossADImmersionBannerManager paramQbossADImmersionBannerManager, QbossADBannerConfigInfo paramQbossADBannerConfigInfo) {}
  
  public void run()
  {
    if (this.a == null) {}
    while (!(this.a instanceof QbossADBannerImmersionInfo)) {
      return;
    }
    QbossADImmersionBannerManager.a(this.this$0, (QbossADBannerImmersionInfo)this.a);
    QbossADImmersionBannerManager.a(this.this$0).setText(QbossADImmersionBannerManager.a(this.this$0, QbossADImmersionBannerManager.a(this.this$0).f));
    QbossADImmersionBannerManager.b(this.this$0).setText(QbossADImmersionBannerManager.b(this.this$0, QbossADImmersionBannerManager.a(this.this$0).g));
    QbossADImmersionBannerManager.a(this.this$0).setTextColor(QbossADImmersionBannerManager.a(this.this$0, QbossADImmersionBannerManager.a(this.this$0).h));
    QbossADImmersionBannerManager.b(this.this$0).setTextColor(QbossADImmersionBannerManager.b(this.this$0, QbossADImmersionBannerManager.a(this.this$0).h));
    QbossADBannerConfigInfo.ResourceInfo localResourceInfo = (QbossADBannerConfigInfo.ResourceInfo)this.a.a.get(2);
    QbossADImmersionBannerManager.a(this.this$0, new ZipAnimationDrawable());
    QbossADImmersionBannerManager.a(this.this$0).setAnimationRes(localResourceInfo.c, QbossADImmersionBannerManager.a(this.this$0, QbossADImmersionBannerManager.a(this.this$0)));
    QbossADImmersionBannerManager.a(this.this$0).setScale(ViewUtils.a() / 720.0F);
    QbossADImmersionBannerManager.a(this.this$0).clearFirstFrame();
    QbossADImmersionBannerManager.a(this.this$0).setRepeatAnimation(true);
    QbossADImmersionBannerManager.a(this.this$0).setShowLastFrameWhenStop(true);
    QbossADImmersionBannerManager.a(this.this$0).start();
    QbossADImmersionBannerManager.a(this.this$0).setImageDrawable(QbossADImmersionBannerManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADImmersionBannerManager.2
 * JD-Core Version:    0.7.0.1
 */