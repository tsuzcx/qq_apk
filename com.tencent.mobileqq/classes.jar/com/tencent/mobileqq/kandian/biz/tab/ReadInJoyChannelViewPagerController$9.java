package com.tencent.mobileqq.kandian.biz.tab;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.mobileqq.kandian.biz.feeds.api.impl.RIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.framework.CallHotwordChange;
import com.tencent.mobileqq.kandian.biz.framework.util.RIJChannelViewpagerEnterPathHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ReadInJoyChannelViewPagerController$9
  implements ViewPager.OnPageChangeListener
{
  ReadInJoyChannelViewPagerController$9(ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("on page scroll state: ");
    localStringBuilder.append(paramInt);
    QLog.d("ReadInJoyChannelViewPagerController", 2, localStringBuilder.toString());
    ReadInJoyChannelViewPagerController.e(this.a, paramInt);
    if (paramInt == 0)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page scroll state changed notify");
      ReadInJoyChannelViewPagerController.l(this.a);
      ReadInJoyChannelViewPagerController.g(this.a).a();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!ReadInJoyChannelViewPagerController.i(this.a)) {
      ReadInJoyChannelViewPagerController.a(this.a, paramInt1, paramFloat, paramInt2);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.i();
    if ((paramInt1 >= ReadInJoyChannelViewPagerController.c) && (localTabChannelCoverInfo != null)) {
      ReadInJoyChannelViewPagerController.b(this.a, localTabChannelCoverInfo);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onPageSelected position = ", Integer.valueOf(paramInt) });
    TabChannelCoverInfo localTabChannelCoverInfo1 = this.a.i();
    if (ReadInJoyChannelViewPagerController.j(this.a) != null)
    {
      ReadInJoyChannelViewPagerController.OnChannelChangeListener localOnChannelChangeListener = ReadInJoyChannelViewPagerController.j(this.a);
      TabChannelCoverInfo localTabChannelCoverInfo2 = ReadInJoyChannelViewPagerController.a;
      int j = -1;
      int i;
      if (localTabChannelCoverInfo2 != null) {
        i = ReadInJoyChannelViewPagerController.a.mChannelCoverId;
      } else {
        i = -1;
      }
      if (localTabChannelCoverInfo1 != null) {
        j = localTabChannelCoverInfo1.mChannelCoverId;
      }
      localOnChannelChangeListener.a(i, j);
    }
    ReadInJoyChannelViewPagerController.a = localTabChannelCoverInfo1;
    RIJChannelStayTimeMonitor.INSTANCE.onChannelChanged(ReadInJoyChannelViewPagerController.a, this.a.j());
    if (localTabChannelCoverInfo1 != null) {
      RIJChannelViewpagerEnterPathHelper.a().remove(Integer.valueOf(localTabChannelCoverInfo1.mChannelCoverId));
    }
    if (ReadInJoyChannelViewPagerController.k(this.a) == 0) {
      ReadInJoyChannelViewPagerController.c(this.a, paramInt);
    }
    ReadInJoyChannelViewPagerController.d(this.a, paramInt);
    ReadInJoyChannelViewPagerController.b(this.a, paramInt);
    QLog.d("ReadInJoyChannelViewPagerController", 2, "page selected notify");
    if (ReadInJoyChannelViewPagerController.k(this.a) == 0) {
      ReadInJoyChannelViewPagerController.l(this.a);
    }
    boolean bool;
    if ((localTabChannelCoverInfo1 != null) && (localTabChannelCoverInfo1.mChannelCoverId == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    ReadInJoyChannelViewPagerController.b(bool);
    ReadInJoyChannelViewPagerController.m(this.a);
    if (this.a.b != null) {
      this.a.b.a(6, paramInt);
    }
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "selected channel cover info =", ReadInJoyChannelViewPagerController.a });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController.9
 * JD-Core Version:    0.7.0.1
 */