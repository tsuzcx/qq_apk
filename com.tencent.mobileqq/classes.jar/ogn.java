import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;

class ogn
  implements ViewPager.OnPageChangeListener
{
  ogn(ogh paramogh) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, "on page scroll state: " + paramInt);
    ogh.b(this.a, paramInt);
    if (paramInt == 0)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page scroll state changed notify");
      ogh.b(this.a);
      ogh.a(this.a).a();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!ogh.a(this.a)) {
      ogh.a(this.a, paramInt1, paramFloat, paramInt2);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    if ((paramInt1 >= ogh.jdField_a_of_type_Int) && (localTabChannelCoverInfo != null)) {
      ogh.b(this.a, localTabChannelCoverInfo);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onPageSelected position = ", Integer.valueOf(paramInt) });
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    ogh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo = localTabChannelCoverInfo;
    if (localTabChannelCoverInfo != null) {
      ogh.a(localTabChannelCoverInfo.mChannelCoverId);
    }
    if (ogh.a(this.a) == 0) {
      ogh.a(this.a, paramInt);
    }
    ogh.b(this.a, paramInt);
    ogh.a(this.a, paramInt);
    QLog.d("ReadInJoyChannelViewPagerController", 2, "page selected notify");
    if (ogh.a(this.a) == 0) {
      ogh.b(this.a);
    }
    if ((localTabChannelCoverInfo != null) && (localTabChannelCoverInfo.mChannelCoverId == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ogh.a(bool);
      ogh.c(this.a);
      ogh.a(this.a, ogh.c());
      if (this.a.jdField_a_of_type_Svd != null) {
        this.a.jdField_a_of_type_Svd.a(6, paramInt);
      }
      QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "selected channel cover info =", ogh.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ogn
 * JD-Core Version:    0.7.0.1
 */