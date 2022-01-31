import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView.OnPagerChangedListener;

public class ktz
  implements VerticalPagerView.OnPagerChangedListener
{
  public ktz(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void a(VerticalPagerView paramVerticalPagerView, View paramView, int paramInt)
  {
    paramVerticalPagerView = this.a;
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      PublicAccountAdvertisementActivity.c(paramVerticalPagerView, bool);
      if (!PublicAccountAdvertisementActivity.c(this.a)) {
        break;
      }
      PublicAccountAdvertisementActivity.a(this.a).b(true);
      PublicAccountAdvertisementActivity.a(this.a).onResume();
      PublicAccountAdvertisementActivity.e(this.a);
      PublicAccountAdvertisementActivity.a(this.a, System.currentTimeMillis());
      if (PublicAccountAdvertisementActivity.a(this.a) > PublicAccountAdvertisementActivity.b(this.a)) {
        PublicAccountAdvertisementActivity.b(this.a, PublicAccountAdvertisementActivity.c(this.a) + (PublicAccountAdvertisementActivity.a(this.a) - PublicAccountAdvertisementActivity.b(this.a)));
      }
      paramVerticalPagerView = PublicAccountAdvertisementActivity.a(this.a);
      PublicAccountAdvertisementActivity.a(this.a);
      paramVerticalPagerView.setMode(1);
      PublicAccountAdvertisementActivity.a(this.a).setVisibility(8);
      PublicAccountAdvertisementActivity.a(this.a).a(false);
      return;
    }
    PublicAccountAdvertisementActivity.c(this.a);
    PublicAccountAdvertisementActivity.a(this.a).b(false);
    PublicAccountAdvertisementActivity.a(this.a).onPause();
    PublicAccountAdvertisementActivity.a(this.a).b();
    paramVerticalPagerView = PublicAccountAdvertisementActivity.a(this.a);
    PublicAccountAdvertisementActivity.a(this.a);
    paramVerticalPagerView.setMode(2);
    PublicAccountAdvertisementActivity.a(this.a).setVisibility(0);
    PublicAccountAdvertisementActivity.c(this.a, System.currentTimeMillis());
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    PublicAccountAdvertisementActivity.b(this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ktz
 * JD-Core Version:    0.7.0.1
 */