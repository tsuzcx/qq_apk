import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import mqq.os.MqqHandler;

public class qfa
  implements View.OnClickListener
{
  public qfa(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyDeliverVideoActivity.a(this.a).sendEmptyMessage(103);
    ReadInJoyDeliverVideoActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qfa
 * JD-Core Version:    0.7.0.1
 */