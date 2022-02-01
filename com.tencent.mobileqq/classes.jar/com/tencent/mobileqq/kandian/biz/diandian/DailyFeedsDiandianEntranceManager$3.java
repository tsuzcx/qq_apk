package com.tencent.mobileqq.kandian.biz.diandian;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.daily.ReadInJoyDailyOverScrollListener;
import com.tencent.mobileqq.kandian.biz.reddot.ReadInJoyColorBandEntranceButton;
import com.tencent.mobileqq.kandian.repo.diandian.EntranceIconInfo;
import com.tencent.qphone.base.util.QLog;

class DailyFeedsDiandianEntranceManager$3
  implements View.OnClickListener
{
  DailyFeedsDiandianEntranceManager$3(DailyFeedsDiandianEntranceManager paramDailyFeedsDiandianEntranceManager, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 2, "jump to config feeds");
      int i = ReadInJoyHelper.e();
      Bundle localBundle = new Bundle();
      if ((paramView instanceof ReadInJoyColorBandEntranceButton))
      {
        paramView = ((ReadInJoyColorBandEntranceButton)paramView).a();
        if ((paramView instanceof Parcelable))
        {
          localBundle.putParcelable("daily_bottom_entry_data", (Parcelable)paramView);
        }
        else if ((i == 3) || (i == 4))
        {
          EntranceIconInfo localEntranceIconInfo = new EntranceIconInfo();
          if (i == 4) {
            paramView = "https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&_wwv=1&_wvSb=0&_nav_txtclr=00000&from=kdybrk&target=hot&_nav_titleclr=000000&_wvNlb=0xffffff";
          } else {
            paramView = "mqqapi://readinjoy/open?src_type=internal&ispush=1&target=2&readinjoyNotDecodeUrl=1&version=1&channelid=70&channelname=看点关注&channelType=0&changeChannelOrder=true&moveChannelFromSource=0";
          }
          localEntranceIconInfo.c = paramView;
          localBundle.putParcelable("daily_bottom_entry_data", localEntranceIconInfo);
        }
      }
      localBundle.putInt("daily_bottom_triger_src", 1);
      ReadInJoyDailyOverScrollListener.a(this.jdField_a_of_type_AndroidAppActivity, localBundle);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizDiandianDailyFeedsDiandianEntranceManager.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.diandian.DailyFeedsDiandianEntranceManager.3
 * JD-Core Version:    0.7.0.1
 */