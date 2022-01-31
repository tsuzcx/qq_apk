import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserLoginLogic;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;

public class rez
  implements DialogInterface.OnCancelListener
{
  public rez(UserLoginLogic paramUserLoginLogic) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    DoraemonUtil.a(this.a.a, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rez
 * JD-Core Version:    0.7.0.1
 */