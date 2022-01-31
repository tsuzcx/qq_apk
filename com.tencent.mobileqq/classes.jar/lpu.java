import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyAtlasViewPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasFragment.ReportEventListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAllInOneBar;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAtlasViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyAtlasViewPager.PageItemScrollListener;
import com.tencent.biz.pubaccount.readinjoy.view.VariableSizeTextView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class lpu
  implements ReadInJoyAtlasViewPager.PageItemScrollListener
{
  public lpu(ReadInJoyAtlasFragment paramReadInJoyAtlasFragment) {}
  
  public void a()
  {
    ReadInJoyAtlasFragment.a(this.a).a(1, null);
    if ((this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager != null) && (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.getCurrentItem() == 0))
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("exitType", 1);
      localBundle.putSerializable("lastShowImageModel", this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyAtlasViewPagerAdapter.b());
      ReadInJoyAtlasFragment.a(this.a).a(-2, localBundle);
    }
    ReadInJoyAtlasFragment.b(this.a, true);
    ReadInJoyAtlasFragment.a(this.a).finish();
  }
  
  public void a(float paramFloat1, float paramFloat2, View paramView)
  {
    paramFloat1 = 1.0F;
    float f = 1.0F - Math.abs(paramFloat2) * 10.0F / ScreenUtil.b;
    if (f < 0.0F) {
      paramFloat1 = 0.0F;
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidViewView.setAlpha(paramFloat1);
      this.a.b.setAlpha(paramFloat1);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewVariableSizeTextView.setAlpha(paramFloat1);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAllInOneBar.setAlpha(paramFloat1);
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.getBackground() != null)
      {
        int i = (int)((int)(Math.max(0.0F, ScreenUtil.b - 2.0F * Math.abs(paramFloat2)) * 255.0F / ScreenUtil.b) * 0.8F + 51.0F);
        paramView = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.getBackground().mutate();
        paramView.setAlpha(i);
        this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.setBackgroundDrawable(paramView);
      }
      return;
      if (f <= 1.0F) {
        paramFloat1 = f;
      }
    }
  }
  
  public void b()
  {
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.getBackground() != null)
    {
      Drawable localDrawable = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.getBackground().mutate();
      localDrawable.setAlpha(255);
      this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyAtlasViewPager.setBackgroundDrawable(localDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpu
 * JD-Core Version:    0.7.0.1
 */