import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.biz.pubaccount.readinjoy.ugc.video.transfer.VideoDeliverController;
import mqq.os.MqqHandler;

public class mch
  implements View.OnClickListener
{
  public mch(ReadInJoyDeliverVideoActivity paramReadInJoyDeliverVideoActivity) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyDeliverVideoActivity.a(this.a).sendEmptyMessage(103);
    ReadInJoyDeliverVideoActivity.e(this.a);
    ReadInJoyDeliverVideoActivity.a(this.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mch
 * JD-Core Version:    0.7.0.1
 */