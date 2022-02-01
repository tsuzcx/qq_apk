import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;

class ore
  implements ViewPager.OnPageChangeListener
{
  ore(oqy paramoqy) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, "on page scroll state: " + paramInt);
    oqy.b(this.a, paramInt);
    if (paramInt == 0)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page scroll state changed notify");
      oqy.b(this.a);
      oqy.a(this.a).a();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!oqy.a(this.a)) {
      oqy.a(this.a, paramInt1, paramFloat, paramInt2);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    if ((paramInt1 >= oqy.jdField_a_of_type_Int) && (localTabChannelCoverInfo != null)) {
      oqy.b(this.a, localTabChannelCoverInfo);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    int j = -1;
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onPageSelected position = ", Integer.valueOf(paramInt) });
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    int i;
    if (oqy.a(this.a) != null)
    {
      orf localorf = oqy.a(this.a);
      if (oqy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null)
      {
        i = oqy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId;
        if (localTabChannelCoverInfo != null) {
          j = localTabChannelCoverInfo.mChannelCoverId;
        }
        localorf.a(i, j);
      }
    }
    else
    {
      oqy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo = localTabChannelCoverInfo;
      if (localTabChannelCoverInfo != null) {
        oqy.a(localTabChannelCoverInfo.mChannelCoverId);
      }
      if (oqy.a(this.a) == 0) {
        oqy.a(this.a, paramInt);
      }
      oqy.b(this.a, paramInt);
      oqy.a(this.a, paramInt);
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page selected notify");
      if (oqy.a(this.a) == 0) {
        oqy.b(this.a);
      }
      if ((localTabChannelCoverInfo == null) || (localTabChannelCoverInfo.mChannelCoverId != 0)) {
        break label245;
      }
    }
    label245:
    for (boolean bool = true;; bool = false)
    {
      oqy.a(bool);
      oqy.c(this.a);
      if (this.a.jdField_a_of_type_Tds != null) {
        this.a.jdField_a_of_type_Tds.a(6, paramInt);
      }
      QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "selected channel cover info =", oqy.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo });
      return;
      i = -1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ore
 * JD-Core Version:    0.7.0.1
 */