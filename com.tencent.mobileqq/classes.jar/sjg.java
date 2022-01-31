import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class sjg
  implements Runnable
{
  public sjg(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void run()
  {
    try
    {
      if ((this.a.a == null) && (!this.a.isFinishing()))
      {
        this.a.a = new QQProgressDialog(this.a, this.a.getTitleBarHeight());
        this.a.a.c(2131435070);
      }
      if ((this.a.a != null) && (!this.a.a.isShowing())) {
        this.a.a.show();
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
 * Qualified Name:     sjg
 * JD-Core Version:    0.7.0.1
 */