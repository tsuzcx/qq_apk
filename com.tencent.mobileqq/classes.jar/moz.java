import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.AppInPushNotification;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.BubbleAppInPushNotification;

public class moz
  implements View.OnClickListener
{
  public moz(BubbleAppInPushNotification paramBubbleAppInPushNotification) {}
  
  public void onClick(View paramView)
  {
    AppInPushNotification.a(8);
    this.a.a.postDelayed(new mpa(this), 200L);
    this.a.a(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     moz
 * JD-Core Version:    0.7.0.1
 */