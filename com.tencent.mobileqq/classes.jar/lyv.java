import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoDeliverController;

public class lyv
  implements View.OnClickListener
{
  public lyv(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyDeliverVideoActivity.d(this.a, true);
    ReadInJoyDeliverVideoActivity.e(this.a);
    ReadInJoyDeliverVideoActivity.a(this.a).a(ReadInJoyDeliverVideoActivity.c(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lyv
 * JD-Core Version:    0.7.0.1
 */