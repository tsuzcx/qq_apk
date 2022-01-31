import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;

class nws
  implements ViewPager.OnPageChangeListener
{
  nws(nwm paramnwm) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, "on page scroll state: " + paramInt);
    nwm.b(this.a, paramInt);
    if (paramInt == 0)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page scroll state changed notify");
      nwm.b(this.a);
      nwm.a(this.a).a();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!nwm.a(this.a)) {
      nwm.a(this.a, paramInt1, paramFloat, paramInt2);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    if ((paramInt1 >= nwm.jdField_a_of_type_Int) && (localTabChannelCoverInfo != null)) {
      nwm.b(this.a, localTabChannelCoverInfo);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onPageSelected position = ", Integer.valueOf(paramInt) });
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    nwm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo = localTabChannelCoverInfo;
    if (localTabChannelCoverInfo != null) {
      nwm.a(localTabChannelCoverInfo.mChannelCoverId);
    }
    if (nwm.a(this.a) == 0) {
      nwm.a(this.a, paramInt);
    }
    nwm.b(this.a, paramInt);
    nwm.a(this.a, paramInt);
    QLog.d("ReadInJoyChannelViewPagerController", 2, "page selected notify");
    if (nwm.a(this.a) == 0) {
      nwm.b(this.a);
    }
    if ((localTabChannelCoverInfo != null) && (localTabChannelCoverInfo.mChannelCoverId == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      nwm.a(bool);
      nwm.c(this.a);
      nwm.a(this.a, nwm.c());
      QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "selected channel cover info =", nwm.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nws
 * JD-Core Version:    0.7.0.1
 */