import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.biz.pubaccount.Advertisement.view.AdControlView;
import com.tencent.biz.pubaccount.Advertisement.view.AdvertisementSplitedProgressBar;

public class nlr
  implements ViewPager.OnPageChangeListener
{
  public nlr(VideoCoverFragment paramVideoCoverFragment, ViewPager.OnPageChangeListener paramOnPageChangeListener) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrolled(paramInt1, paramFloat, paramInt2);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment, paramInt);
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageSelected(paramInt);
    }
    if (VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment) != null) {
      VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment).a(paramInt);
    }
    if (VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment) != null) {
      VideoCoverFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementFragmentVideoCoverFragment).a().setProgress(paramInt, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nlr
 * JD-Core Version:    0.7.0.1
 */