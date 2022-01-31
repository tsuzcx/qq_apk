import android.app.Dialog;
import com.tencent.mobileqq.activity.BaseChatPie;

public class rvk
  implements Runnable
{
  public rvk(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if ((this.a.e != null) && (this.a.e.isShowing())) {
      this.a.e.dismiss();
    }
    while ((this.a.f == null) || (!this.a.f.isShowing())) {
      return;
    }
    this.a.f.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rvk
 * JD-Core Version:    0.7.0.1
 */