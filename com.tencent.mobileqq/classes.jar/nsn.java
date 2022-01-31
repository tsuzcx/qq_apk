import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;

public class nsn
  implements View.OnClickListener
{
  public nsn(ReadInJoyDeliverBiuActivity paramReadInJoyDeliverBiuActivity) {}
  
  public void onClick(View paramView)
  {
    if ((ReadInJoyDeliverBiuActivity.c(this.a)) && ((!ReadInJoyDeliverBiuActivity.d(this.a)) || (ReadInJoyDeliverBiuActivity.k(this.a) != -1)))
    {
      this.a.d(ReadInJoyDeliverBiuActivity.l(this.a));
      return;
    }
    ndn.a(null, "", "0X8008661", "0X8008661", 0, 0, ReadInJoyDeliverBiuActivity.l(this.a) + "", "", "", ReadInJoyBaseDeliverActivity.a(), false);
    this.a.finish();
    ReadInJoyDeliverBiuActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsn
 * JD-Core Version:    0.7.0.1
 */