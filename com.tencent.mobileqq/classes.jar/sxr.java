import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;

public class sxr
  implements Runnable
{
  public sxr(LoginVerifyCodeActivity paramLoginVerifyCodeActivity) {}
  
  public void run()
  {
    if ((LoginVerifyCodeActivity.a(this.a) == 1) || (this.a.isFinishing()))
    {
      LoginVerifyCodeActivity.a(this.a).setText(2131434260);
      LoginVerifyCodeActivity.a(this.a).setEnabled(true);
      LoginVerifyCodeActivity.a(this.a).setClickable(true);
      return;
    }
    LoginVerifyCodeActivity.b(this.a);
    LoginVerifyCodeActivity.a(this.a).setText(this.a.getString(2131434260) + "(" + LoginVerifyCodeActivity.a(this.a) + ")");
    this.a.a.postDelayed(this, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sxr
 * JD-Core Version:    0.7.0.1
 */