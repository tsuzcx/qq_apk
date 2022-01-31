import android.os.Message;
import android.widget.Toast;
import com.tencent.mobileqq.activity.AssociatedAccountManageActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class rmu
  extends MqqHandler
{
  public rmu(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      super.handleMessage(paramMessage);
      return;
      if (AssociatedAccountManageActivity.a(this.a) == null) {
        AssociatedAccountManageActivity.a(this.a, new QQProgressDialog(this.a, this.a.getTitleBarHeight()));
      }
      if ((!this.a.isFinishing()) && (!AssociatedAccountManageActivity.a(this.a).isShowing()))
      {
        try
        {
          AssociatedAccountManageActivity.a(this.a).show();
        }
        catch (Exception localException) {}
        if (QLog.isColorLevel())
        {
          QLog.e("AssociatedAccountManage", 2, "QQProgressDialog show exception.", localException);
          continue;
          if ((AssociatedAccountManageActivity.a(this.a) != null) && (AssociatedAccountManageActivity.a(this.a).isShowing()))
          {
            AssociatedAccountManageActivity.a(this.a).dismiss();
            AssociatedAccountManageActivity.a(this.a, null);
            continue;
            if (AssociatedAccountManageActivity.a(this.a) != null) {
              AssociatedAccountManageActivity.a(this.a).cancel();
            }
            AssociatedAccountManageActivity.a(this.a, QQToast.a(this.a, paramMessage.arg1, paramMessage.arg2, 0).b(this.a.getTitleBarHeight()));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmu
 * JD-Core Version:    0.7.0.1
 */