import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;

public class liz
  implements View.OnClickListener
{
  public liz(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ReadInJoyDeliverBiuActivity.b(this.a)) && ((!ReadInJoyDeliverBiuActivity.c(this.a)) || (ReadInJoyDeliverBiuActivity.k(this.a) != -1)))
    {
      this.a.c(ReadInJoyDeliverBiuActivity.l(this.a));
      return;
    }
    PublicAccountReportUtils.a(null, "", "0X8008661", "0X8008661", 0, 0, ReadInJoyDeliverBiuActivity.l(this.a) + "", "", "", ReadInJoyBaseDeliverActivity.a(), false);
    this.a.finish();
    ReadInJoyDeliverBiuActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     liz
 * JD-Core Version:    0.7.0.1
 */