import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;

public class ody
  implements View.OnClickListener
{
  public ody(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ReadInJoyDeliverBiuActivity.e(this.a)) && ((!ReadInJoyDeliverBiuActivity.f(this.a)) || (ReadInJoyDeliverBiuActivity.m(this.a) != -1)))
    {
      this.a.d(ReadInJoyDeliverBiuActivity.n(this.a));
      return;
    }
    this.a.finish();
    noo.a(null, "", "0X8008661", "0X8008661", 0, 0, ReadInJoyDeliverBiuActivity.n(this.a) + "", "", "", ReadInJoyBaseDeliverActivity.a(), false);
    ReadInJoyDeliverBiuActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ody
 * JD-Core Version:    0.7.0.1
 */