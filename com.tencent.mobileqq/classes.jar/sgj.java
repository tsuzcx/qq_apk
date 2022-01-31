import com.tencent.mobileqq.activity.DevlockPushActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class sgj
  implements Runnable
{
  public sgj(DevlockPushActivity paramDevlockPushActivity) {}
  
  public void run()
  {
    try
    {
      if ((this.a.a != null) && (this.a.a.isShowing()))
      {
        this.a.a.dismiss();
        this.a.a.cancel();
      }
      this.a.a = null;
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
 * Qualified Name:     sgj
 * JD-Core Version:    0.7.0.1
 */