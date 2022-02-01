import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;

class ohv
  implements ViewPager.OnPageChangeListener
{
  ohv(ohp paramohp) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, "on page scroll state: " + paramInt);
    ohp.b(this.a, paramInt);
    if (paramInt == 0)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page scroll state changed notify");
      ohp.b(this.a);
      ohp.a(this.a).a();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!ohp.a(this.a)) {
      ohp.a(this.a, paramInt1, paramFloat, paramInt2);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    if ((paramInt1 >= ohp.jdField_a_of_type_Int) && (localTabChannelCoverInfo != null)) {
      ohp.b(this.a, localTabChannelCoverInfo);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onPageSelected position = ", Integer.valueOf(paramInt) });
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    ohp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo = localTabChannelCoverInfo;
    if (localTabChannelCoverInfo != null) {
      ohp.a(localTabChannelCoverInfo.mChannelCoverId);
    }
    if (ohp.a(this.a) == 0) {
      ohp.a(this.a, paramInt);
    }
    ohp.b(this.a, paramInt);
    ohp.a(this.a, paramInt);
    QLog.d("ReadInJoyChannelViewPagerController", 2, "page selected notify");
    if (ohp.a(this.a) == 0) {
      ohp.b(this.a);
    }
    if ((localTabChannelCoverInfo != null) && (localTabChannelCoverInfo.mChannelCoverId == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ohp.a(bool);
      ohp.c(this.a);
      ohp.a(this.a, ohp.c());
      if (this.a.jdField_a_of_type_Smg != null) {
        this.a.jdField_a_of_type_Smg.a(6, paramInt);
      }
      QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "selected channel cover info =", ohp.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ohv
 * JD-Core Version:    0.7.0.1
 */