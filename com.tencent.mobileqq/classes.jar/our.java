import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class our
  implements View.OnClickListener
{
  public our(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ReadInJoyDeliverBiuActivity.c(this.a)) && ((!ReadInJoyDeliverBiuActivity.d(this.a)) || (ReadInJoyDeliverBiuActivity.k(this.a) != -1))) {
      this.a.d(ReadInJoyDeliverBiuActivity.l(this.a));
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      oat.a(null, "", "0X8008661", "0X8008661", 0, 0, ReadInJoyDeliverBiuActivity.l(this.a) + "", "", "", ReadInJoyBaseDeliverActivity.a(), false);
      this.a.finish();
      ReadInJoyDeliverBiuActivity.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     our
 * JD-Core Version:    0.7.0.1
 */