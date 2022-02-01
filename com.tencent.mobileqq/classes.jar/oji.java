import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;

class oji
  implements ViewPager.OnPageChangeListener
{
  oji(ojc paramojc) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, "on page scroll state: " + paramInt);
    ojc.b(this.a, paramInt);
    if (paramInt == 0)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page scroll state changed notify");
      ojc.b(this.a);
      ojc.a(this.a).a();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!ojc.a(this.a)) {
      ojc.a(this.a, paramInt1, paramFloat, paramInt2);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    if ((paramInt1 >= ojc.jdField_a_of_type_Int) && (localTabChannelCoverInfo != null)) {
      ojc.b(this.a, localTabChannelCoverInfo);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onPageSelected position = ", Integer.valueOf(paramInt) });
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    ojc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo = localTabChannelCoverInfo;
    if (localTabChannelCoverInfo != null) {
      ojc.a(localTabChannelCoverInfo.mChannelCoverId);
    }
    if (ojc.a(this.a) == 0) {
      ojc.a(this.a, paramInt);
    }
    ojc.b(this.a, paramInt);
    ojc.a(this.a, paramInt);
    QLog.d("ReadInJoyChannelViewPagerController", 2, "page selected notify");
    if (ojc.a(this.a) == 0) {
      ojc.b(this.a);
    }
    if ((localTabChannelCoverInfo != null) && (localTabChannelCoverInfo.mChannelCoverId == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      ojc.a(bool);
      ojc.c(this.a);
      ojc.a(this.a, ojc.c());
      if (this.a.jdField_a_of_type_Sqh != null) {
        this.a.jdField_a_of_type_Sqh.a(6, paramInt);
      }
      QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "selected channel cover info =", ojc.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oji
 * JD-Core Version:    0.7.0.1
 */