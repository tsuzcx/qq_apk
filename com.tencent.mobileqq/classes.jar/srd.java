import android.widget.TextView;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;

public class srd
  implements Runnable
{
  public srd(GesturePWDUnlockActivity paramGesturePWDUnlockActivity) {}
  
  public void run()
  {
    GesturePWDUnlockActivity.a(this.a).setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     srd
 * JD-Core Version:    0.7.0.1
 */