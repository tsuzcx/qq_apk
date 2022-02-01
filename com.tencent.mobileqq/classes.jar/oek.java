import android.os.Handler;
import android.view.View;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.VerticalPagerView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;

public class oek
  implements ofq
{
  public oek(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
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
      if (!PublicAccountAdvertisementActivity.a(this.a).a())
      {
        PublicAccountAdvertisementActivity.a(this.a).setVisibility(8);
        PublicAccountAdvertisementActivity.a(this.a).a(false);
      }
      return;
    }
    if (PublicAccountAdvertisementActivity.d(this.a))
    {
      PublicAccountAdvertisementActivity.d(this.a, false);
      if (this.a.a()) {
        this.a.a.sendEmptyMessage(5);
      }
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
    bdla.a(null, "dc00898", "", PublicAccountAdvertisementActivity.a(this.a).a.a, "0X8008F68", "0X8008F68", 0, 0, PublicAccountAdvertisementActivity.a(this.a).a.c, PublicAccountAdvertisementActivity.a(this.a) + "", "" + PublicAccountAdvertisementActivity.a(this.a).a.d, PublicAccountAdvertisementActivity.a(this.a).a.b);
    paramVerticalPagerView = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramVerticalPagerView instanceof ToolAppRuntime)) {
      avqq.a().a(PublicAccountAdvertisementActivity.a(this.a), this.a, (AppInterface)((ToolAppRuntime)paramVerticalPagerView).onGetSubRuntime("imax"));
    }
    PublicAccountAdvertisementActivity.b(this.a, 0);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    PublicAccountAdvertisementActivity.b(this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oek
 * JD-Core Version:    0.7.0.1
 */