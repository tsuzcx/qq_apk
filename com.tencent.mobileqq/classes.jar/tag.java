import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.JDHongbaoActivity;

public class tag
  implements Runnable
{
  public tag(JDHongbaoActivity paramJDHongbaoActivity) {}
  
  public void run()
  {
    JDHongbaoActivity.a(this.a).setVisibility(0);
    JDHongbaoActivity.a(this.a).startAnimation(JDHongbaoActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tag
 * JD-Core Version:    0.7.0.1
 */