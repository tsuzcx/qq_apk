import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;

public class nls
  implements View.OnClickListener
{
  public nls(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onClick(View paramView)
  {
    obz.a(paramView.getContext(), "https://kandian.qq.com/mqq/vue/configPush?_wv=3&x5PreFetch=1&_bid=2378", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nls
 * JD-Core Version:    0.7.0.1
 */