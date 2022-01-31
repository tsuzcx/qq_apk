import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;

class nig
  implements ViewPager.OnPageChangeListener
{
  nig(nia paramnia) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, "on page scroll state: " + paramInt);
    nia.b(this.a, paramInt);
    if (paramInt == 0)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page scroll state changed notify");
      nia.b(this.a);
      nia.a(this.a).a();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!nia.a(this.a)) {
      nia.a(this.a, paramInt1, paramFloat, paramInt2);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    if ((paramInt1 >= nia.a) && (localTabChannelCoverInfo != null)) {
      nia.b(this.a, localTabChannelCoverInfo);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onPageSelected position = ", Integer.valueOf(paramInt) });
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    nia.a(this.a, localTabChannelCoverInfo);
    if (localTabChannelCoverInfo != null) {
      nia.a(localTabChannelCoverInfo.mChannelCoverId);
    }
    if (nia.a(this.a) == 0) {
      nia.a(this.a, paramInt);
    }
    nia.b(this.a, paramInt);
    nia.a(this.a, paramInt);
    QLog.d("ReadInJoyChannelViewPagerController", 2, "page selected notify");
    if (nia.a(this.a) == 0) {
      nia.b(this.a);
    }
    if ((localTabChannelCoverInfo != null) && (localTabChannelCoverInfo.mChannelCoverId == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      nia.a(bool);
      nia.c(this.a);
      nia.a(this.a, nia.c());
      QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "selected channel cover info =", nia.a(this.a) });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nig
 * JD-Core Version:    0.7.0.1
 */