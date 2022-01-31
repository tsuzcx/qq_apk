import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;

public class svg
  implements Runnable
{
  public svg(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public void run()
  {
    HongbaoShowerActivity.a(this.a).setVisibility(0);
    HongbaoShowerActivity.a(this.a).startAnimation(HongbaoShowerActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svg
 * JD-Core Version:    0.7.0.1
 */