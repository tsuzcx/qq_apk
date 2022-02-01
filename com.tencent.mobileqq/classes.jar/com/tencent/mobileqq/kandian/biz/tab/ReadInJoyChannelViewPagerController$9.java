package com.tencent.mobileqq.kandian.biz.tab;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.framework.CallHotwordChange;
import com.tencent.mobileqq.kandian.biz.framework.util.RIJChannelViewpagerEnterPathHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.qroute.QRoute;
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
    ReadInJoyChannelViewPagerController.b(this.a, paramInt);
    if (paramInt == 0)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "page scroll state changed notify");
      ReadInJoyChannelViewPagerController.b(this.a);
      ReadInJoyChannelViewPagerController.a(this.a).a();
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (!ReadInJoyChannelViewPagerController.a(this.a)) {
      ReadInJoyChannelViewPagerController.a(this.a, paramInt1, paramFloat, paramInt2);
    }
    TabChannelCoverInfo localTabChannelCoverInfo = this.a.a();
    if ((paramInt1 >= ReadInJoyChannelViewPagerController.jdField_a_of_type_Int) && (localTabChannelCoverInfo != null)) {
      ReadInJoyChannelViewPagerController.b(this.a, localTabChannelCoverInfo);
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onPageSelected position = ", Integer.valueOf(paramInt) });
    TabChannelCoverInfo localTabChannelCoverInfo1 = this.a.a();
    if (ReadInJoyChannelViewPagerController.a(this.a) != null)
    {
      ReadInJoyChannelViewPagerController.OnChannelChangeListener localOnChannelChangeListener = ReadInJoyChannelViewPagerController.a(this.a);
      TabChannelCoverInfo localTabChannelCoverInfo2 = ReadInJoyChannelViewPagerController.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo;
      int j = -1;
      int i;
      if (localTabChannelCoverInfo2 != null) {
        i = ReadInJoyChannelViewPagerController.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo.mChannelCoverId;
      } else {
        i = -1;
      }
      if (localTabChannelCoverInfo1 != null) {
        j = localTabChannelCoverInfo1.mChannelCoverId;
      }
      localOnChannelChangeListener.a(i, j);
    }
    ReadInJoyChannelViewPagerController.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo = localTabChannelCoverInfo1;
    ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).onChannelChanged(ReadInJoyChannelViewPagerController.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo, this.a.c());
    if (localTabChannelCoverInfo1 != null) {
      RIJChannelViewpagerEnterPathHelper.a().remove(Integer.valueOf(localTabChannelCoverInfo1.mChannelCoverId));
    }
    if (ReadInJoyChannelViewPagerController.a(this.a) == 0) {
      ReadInJoyChannelViewPagerController.a(this.a, paramInt);
    }
    ReadInJoyChannelViewPagerController.b(this.a, paramInt);
    ReadInJoyChannelViewPagerController.a(this.a, paramInt);
    QLog.d("ReadInJoyChannelViewPagerController", 2, "page selected notify");
    if (ReadInJoyChannelViewPagerController.a(this.a) == 0) {
      ReadInJoyChannelViewPagerController.b(this.a);
    }
    boolean bool;
    if ((localTabChannelCoverInfo1 != null) && (localTabChannelCoverInfo1.mChannelCoverId == 0)) {
      bool = true;
    } else {
      bool = false;
    }
    ReadInJoyChannelViewPagerController.a(bool);
    ReadInJoyChannelViewPagerController.c(this.a);
    if (this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkCallHotwordChange != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkCallHotwordChange.a(6, paramInt);
    }
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "selected channel cover info =", ReadInJoyChannelViewPagerController.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController.9
 * JD-Core Version:    0.7.0.1
 */