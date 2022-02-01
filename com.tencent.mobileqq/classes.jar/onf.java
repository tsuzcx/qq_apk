import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class onf
  implements View.OnClickListener
{
  public onf(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ReadInJoyDeliverBiuActivity.e(this.a)) && ((!ReadInJoyDeliverBiuActivity.f(this.a)) || (ReadInJoyDeliverBiuActivity.m(this.a) != -1))) {
      this.a.e(ReadInJoyDeliverBiuActivity.n(this.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.finish();
      ocd.a(null, "", "0X8008661", "0X8008661", 0, 0, ReadInJoyDeliverBiuActivity.n(this.a) + "", "", "", ReadInJoyBaseDeliverActivity.a(), false);
      ReadInJoyDeliverBiuActivity.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     onf
 * JD-Core Version:    0.7.0.1
 */