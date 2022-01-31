import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;

public class lja
  implements View.OnClickListener
{
  public lja(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ReadInJoyDeliverBiuActivity.d(this.a)) && ((!ReadInJoyDeliverBiuActivity.e(this.a)) || (ReadInJoyDeliverBiuActivity.m(this.a) != -1)))
    {
      this.a.c(ReadInJoyDeliverBiuActivity.n(this.a));
      return;
    }
    this.a.finish();
    PublicAccountReportUtils.a(null, "", "0X8008661", "0X8008661", 0, 0, ReadInJoyDeliverBiuActivity.n(this.a) + "", "", "", ReadInJoyBaseDeliverActivity.a(), false);
    ReadInJoyDeliverBiuActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lja
 * JD-Core Version:    0.7.0.1
 */