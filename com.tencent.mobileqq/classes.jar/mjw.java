import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.AppInPushNotification;
import com.tencent.biz.pubaccount.readinjoy.view.appinpush.BubbleAppInPushNotification;

public class mjw
  implements View.OnClickListener
{
  public mjw(BubbleAppInPushNotification paramBubbleAppInPushNotification) {}
  
  public void onClick(View paramView)
  {
    AppInPushNotification.a(8);
    this.a.a.postDelayed(new mjx(this), 200L);
    this.a.a(true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mjw
 * JD-Core Version:    0.7.0.1
 */