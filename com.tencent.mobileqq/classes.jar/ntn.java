import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;

class ntn
  implements ViewPager.OnPageChangeListener
{
  ntn(nth paramnth) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, "on page scroll state: " + paramInt);
    nth.b(this.a, paramInt);
    if (paramInt == 0)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page scroll state changed notify");
      nth.b(this.a);
      nth.a(this.a).a();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!nth.a(this.a)) {
      nth.a(this.a, paramInt1, paramFloat, paramInt2);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    if ((paramInt1 >= nth.jdField_a_of_type_Int) && (localTabChannelCoverInfo != null)) {
      nth.b(this.a, localTabChannelCoverInfo);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onPageSelected position = ", Integer.valueOf(paramInt) });
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    nth.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo = localTabChannelCoverInfo;
    if (localTabChannelCoverInfo != null) {
      nth.a(localTabChannelCoverInfo.mChannelCoverId);
    }
    if (nth.a(this.a) == 0) {
      nth.a(this.a, paramInt);
    }
    nth.b(this.a, paramInt);
    nth.a(this.a, paramInt);
    QLog.d("ReadInJoyChannelViewPagerController", 2, "page selected notify");
    if (nth.a(this.a) == 0) {
      nth.b(this.a);
    }
    if ((localTabChannelCoverInfo != null) && (localTabChannelCoverInfo.mChannelCoverId == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      nth.a(bool);
      nth.c(this.a);
      nth.a(this.a, nth.c());
      QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "selected channel cover info =", nth.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntn
 * JD-Core Version:    0.7.0.1
 */