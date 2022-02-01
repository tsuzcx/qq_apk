import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager.EntranceIconInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ReadInJoyColorBandEntranceButton;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class syi
  implements View.OnClickListener
{
  syi(syf paramsyf, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    int i;
    Bundle localBundle;
    if (this.jdField_a_of_type_AndroidAppActivity != null)
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 2, "jump to config feeds");
      i = bmhv.f();
      localBundle = new Bundle();
      if ((paramView instanceof ReadInJoyColorBandEntranceButton))
      {
        localObject = ((ReadInJoyColorBandEntranceButton)paramView).a();
        if (!(localObject instanceof Parcelable)) {
          break label93;
        }
        localBundle.putParcelable("daily_bottom_entry_data", (Parcelable)localObject);
      }
    }
    label93:
    while ((i != 3) && (i != 4))
    {
      localBundle.putInt("daily_bottom_triger_src", 1);
      szn.a(this.jdField_a_of_type_AndroidAppActivity, localBundle);
      this.jdField_a_of_type_Syf.b();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    RecommendFeedsDiandianEntranceManager.EntranceIconInfo localEntranceIconInfo = new RecommendFeedsDiandianEntranceManager.EntranceIconInfo();
    if (i == 4) {}
    for (Object localObject = "https://buluo.qq.com/mobile/v2/buluoindex.html?_wv=16778243&_bid=128&_wwv=1&_wvSb=0&_nav_txtclr=00000&from=kdybrk&target=hot&_nav_titleclr=000000&_wvNlb=0xffffff";; localObject = "mqqapi://readinjoy/open?src_type=internal&ispush=1&target=2&readinjoyNotDecodeUrl=1&version=1&channelid=70&channelname=看点关注&channelType=0&changeChannelOrder=true&moveChannelFromSource=0")
    {
      localEntranceIconInfo.c = ((String)localObject);
      localBundle.putParcelable("daily_bottom_entry_data", localEntranceIconInfo);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     syi
 * JD-Core Version:    0.7.0.1
 */