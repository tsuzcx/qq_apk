import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;

class ntq
  implements ViewPager.OnPageChangeListener
{
  ntq(ntk paramntk) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, "on page scroll state: " + paramInt);
    ntk.b(this.a, paramInt);
    if (paramInt == 0)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page scroll state changed notify");
      ntk.b(this.a);
      ntk.a(this.a).a();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!ntk.a(this.a)) {
      ntk.a(this.a, paramInt1, paramFloat, paramInt2);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    if ((paramInt1 >= ntk.jdField_a_of_type_Int) && (localTabChannelCoverInfo != null)) {
      ntk.b(this.a, localTabChannelCoverInfo);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onPageSelected position = ", Integer.valueOf(paramInt) });
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    ntk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo = localTabChannelCoverInfo;
    if (localTabChannelCoverInfo != null) {
      ntk.a(localTabChannelCoverInfo.mChannelCoverId);
    }
    if (ntk.a(this.a) == 0) {
      ntk.a(this.a, paramInt);
    }
    ntk.b(this.a, paramInt);
    ntk.a(this.a, paramInt);
    QLog.d("ReadInJoyChannelViewPagerController", 2, "page selected notify");
    if (ntk.a(this.a) == 0) {
      ntk.b(this.a);
    }
    if ((localTabChannelCoverInfo != null) && (localTabChannelCoverInfo.mChannelCoverId == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ntk.a(bool);
      ntk.c(this.a);
      ntk.a(this.a, ntk.c());
      QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "selected channel cover info =", ntk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntq
 * JD-Core Version:    0.7.0.1
 */