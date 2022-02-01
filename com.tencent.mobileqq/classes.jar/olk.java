import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class olk
  implements View.OnClickListener
{
  public olk(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onClick(View paramView)
  {
    ozs.a(paramView.getContext(), "https://kandian.qq.com/mqq/vue/configPush?_wv=3&x5PreFetch=1&_bid=2378", null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     olk
 * JD-Core Version:    0.7.0.1
 */