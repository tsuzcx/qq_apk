import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverVideoActivity;
import com.tencent.qphone.base.util.QLog;

class lyn
  implements Runnable
{
  lyn(lym paramlym) {}
  
  public void run()
  {
    QLog.d("ReadInJoyDeliverVideoActivity", 2, "initCompositionManager: success, update UI");
    ReadInJoyDeliverVideoActivity.a(this.a.a).setVisibility(4);
    ReadInJoyDeliverVideoActivity.a(this.a.a).setVisibility(0);
    ReadInJoyDeliverVideoActivity.a(this.a.a).setClickable(true);
    ReadInJoyDeliverVideoActivity.a(this.a.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lyn
 * JD-Core Version:    0.7.0.1
 */