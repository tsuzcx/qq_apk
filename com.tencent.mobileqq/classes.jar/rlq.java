import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AutoRemarkActivity;

public class rlq
  implements View.OnClickListener
{
  public rlq(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a != null) && (this.a.a.isShowing()) && (this.a.a.getWindow() != null)) {}
    try
    {
      this.a.a.dismiss();
      label46:
      this.a.a = null;
      return;
    }
    catch (Throwable paramView)
    {
      break label46;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rlq
 * JD-Core Version:    0.7.0.1
 */