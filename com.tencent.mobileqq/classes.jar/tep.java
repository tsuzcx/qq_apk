import android.support.v4.view.ViewPager.PageTransformer;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.BannerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.ChannelTopBanner;

public class tep
  implements ViewPager.PageTransformer
{
  private tep(ChannelTopBanner paramChannelTopBanner) {}
  
  public void transformPage(View paramView, float paramFloat)
  {
    if (paramView == null) {}
    while ((this.a.a != null) && (this.a.a.getCount() == 1)) {
      return;
    }
    if ((paramFloat <= -1.1F) || (paramFloat >= 1.1F))
    {
      paramView.setScaleX(0.9F);
      paramView.setScaleY(0.9F);
      return;
    }
    paramFloat = Math.max(0.9F, 1.0F - Math.abs(0.2000001F * paramFloat));
    paramView.setScaleX(paramFloat);
    paramView.setScaleY(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tep
 * JD-Core Version:    0.7.0.1
 */