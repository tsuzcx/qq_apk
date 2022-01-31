import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserLoginLogic;

public class rex
  implements DialogInterface.OnClickListener
{
  public rex(UserLoginLogic paramUserLoginLogic) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    UserLoginLogic.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rex
 * JD-Core Version:    0.7.0.1
 */