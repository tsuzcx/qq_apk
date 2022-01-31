import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.AppInPushNotification;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.BubbleAppInPushNotification;

public class mlh
  implements View.OnClickListener
{
  public mlh(BubbleAppInPushNotification paramBubbleAppInPushNotification) {}
  
  public void onClick(View paramView)
  {
    AppInPushNotification.a(8);
    this.a.a.postDelayed(new mli(this), 200L);
    this.a.a(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mlh
 * JD-Core Version:    0.7.0.1
 */