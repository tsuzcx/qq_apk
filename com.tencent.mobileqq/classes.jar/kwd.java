import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.NativeAd.data.BannerInfo;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase;
import java.util.ArrayList;

public class kwd
  implements ViewPager.OnPageChangeListener
{
  public kwd(ReadInJoyNativeAdFragment paramReadInJoyNativeAdFragment) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    ReadInJoyNativeAdFragment.a(this.a, Math.max(ReadInJoyNativeAdFragment.a(this.a), paramInt + 1));
    ((AdModuleBase)ReadInJoyNativeAdFragment.a(this.a).get(paramInt)).a();
    if (paramInt + 1 < ReadInJoyNativeAdFragment.a(this.a).size()) {
      ((AdModuleBase)ReadInJoyNativeAdFragment.a(this.a).get(paramInt + 1)).b();
    }
    if ((ReadInJoyNativeAdFragment.a(this.a) != null) && (ReadInJoyNativeAdFragment.a(this.a).a == 1) && ((ReadInJoyNativeAdFragment.b(this.a) == 1) || (ReadInJoyNativeAdFragment.b(this.a) == 2)))
    {
      if (paramInt != ReadInJoyNativeAdFragment.a(this.a).size() - 1) {
        break label155;
      }
      ReadInJoyNativeAdFragment.a(this.a).setVisibility(8);
    }
    for (;;)
    {
      ReadInJoyNativeAdFragment.a(this.a);
      return;
      label155:
      ReadInJoyNativeAdFragment.a(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kwd
 * JD-Core Version:    0.7.0.1
 */