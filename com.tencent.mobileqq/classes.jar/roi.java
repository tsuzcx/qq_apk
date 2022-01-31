import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class roi
  implements Runnable
{
  public roi(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevVerifyCodeActivity.a(this.a) == null) && (!this.a.isFinishing()))
      {
        AuthDevVerifyCodeActivity.a(this.a, new QQProgressDialog(this.a.getActivity(), this.a.getTitleBarHeight()));
        AuthDevVerifyCodeActivity.a(this.a).c(2131435070);
        AuthDevVerifyCodeActivity.a(this.a).c(true);
      }
      if ((AuthDevVerifyCodeActivity.a(this.a) != null) && (!AuthDevVerifyCodeActivity.a(this.a).isShowing())) {
        AuthDevVerifyCodeActivity.a(this.a).show();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     roi
 * JD-Core Version:    0.7.0.1
 */