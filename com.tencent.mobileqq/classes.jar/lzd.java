import android.os.Bundle;
import android.view.WindowManager.BadTokenException;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.app.BaseActivity;

public abstract class lzd
{
  protected final BaseActivity a;
  
  public lzd(BaseActivity paramBaseActivity)
  {
    this.a = paramBaseActivity;
  }
  
  public abstract void a();
  
  public abstract void a(Bundle paramBundle);
  
  void a(String paramString, QQCustomDialog paramQQCustomDialog)
  {
    boolean bool = true;
    if ((paramQQCustomDialog == null) || (this.a.isFinishing())) {}
    for (;;)
    {
      return;
      try
      {
        paramQQCustomDialog.show();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("DialogModelBase", 2, "showDialog, from[" + paramString + "], isShowSuc[" + bool + "]");
        return;
      }
      catch (WindowManager.BadTokenException paramQQCustomDialog)
      {
        for (;;)
        {
          QLog.w("DialogModelBase", 1, "showDialog BadTokenException, from[" + paramString + "]", paramQQCustomDialog);
          bool = false;
        }
      }
      catch (Throwable paramQQCustomDialog)
      {
        for (;;)
        {
          QLog.w("DialogModelBase", 1, "showDialog BadTokenException, from[" + paramString + "]", paramQQCustomDialog);
          bool = false;
        }
      }
    }
  }
  
  public abstract void b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lzd
 * JD-Core Version:    0.7.0.1
 */