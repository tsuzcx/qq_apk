import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;

public class ssh
  implements Runnable
{
  public ssh(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public void run()
  {
    HongbaoShowerActivity.a(this.a).setVisibility(0);
    HongbaoShowerActivity.a(this.a).startAnimation(HongbaoShowerActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ssh
 * JD-Core Version:    0.7.0.1
 */