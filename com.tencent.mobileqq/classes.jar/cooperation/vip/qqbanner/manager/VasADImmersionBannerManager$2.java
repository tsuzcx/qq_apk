package cooperation.vip.qqbanner.manager;

import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import cooperation.vip.qqbanner.data.ImmersionData;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo.ResourceInfo;
import cooperation.vip.qqbanner.info.VasADBannerImmersionInfo;

class VasADImmersionBannerManager$2
  implements Runnable
{
  VasADImmersionBannerManager$2(VasADImmersionBannerManager paramVasADImmersionBannerManager, VasADBannerConfigInfo paramVasADBannerConfigInfo) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    if (localObject1 == null) {
      return;
    }
    if (!(localObject1 instanceof VasADBannerImmersionInfo)) {
      return;
    }
    VasADImmersionBannerManager.a(this.this$0, (VasADBannerImmersionInfo)localObject1);
    localObject1 = VasADImmersionBannerManager.a(this.this$0).a;
    if (localObject1 == null) {
      return;
    }
    VasADImmersionBannerManager.a(this.this$0).setText(this.this$0.a(((ImmersionData)localObject1).a));
    VasADImmersionBannerManager.b(this.this$0).setText(this.this$0.a(((ImmersionData)localObject1).b));
    VasADImmersionBannerManager.a(this.this$0).setTextColor(this.this$0.a(((ImmersionData)localObject1).c));
    VasADImmersionBannerManager.b(this.this$0).setTextColor(this.this$0.a(((ImmersionData)localObject1).c));
    Object localObject2 = (VasADBannerConfigInfo.ResourceInfo)this.a.a.get(2);
    VasADImmersionBannerManager.a(this.this$0, ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable());
    localObject1 = (IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class);
    Drawable localDrawable = VasADImmersionBannerManager.a(this.this$0);
    localObject2 = ((VasADBannerConfigInfo.ResourceInfo)localObject2).c;
    VasADImmersionBannerManager localVasADImmersionBannerManager = this.this$0;
    ((IZipAnimationDrawable)localObject1).setAnimationRes(localDrawable, (String)localObject2, VasADImmersionBannerManager.a(localVasADImmersionBannerManager, VasADImmersionBannerManager.a(localVasADImmersionBannerManager)));
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setScale(VasADImmersionBannerManager.a(this.this$0), ViewUtils.a() / 720.0F);
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(VasADImmersionBannerManager.a(this.this$0));
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(VasADImmersionBannerManager.a(this.this$0), true);
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(VasADImmersionBannerManager.a(this.this$0), true);
    ((IZipAnimationDrawable)QRoute.api(IZipAnimationDrawable.class)).start(VasADImmersionBannerManager.a(this.this$0));
    VasADImmersionBannerManager.a(this.this$0).setImageDrawable(VasADImmersionBannerManager.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADImmersionBannerManager.2
 * JD-Core Version:    0.7.0.1
 */