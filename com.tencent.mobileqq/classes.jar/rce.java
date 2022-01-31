import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;

public class rce
  implements DialogInterface.OnClickListener
{
  public rce(UserInfoModule paramUserInfoModule, APICallback paramAPICallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rce
 * JD-Core Version:    0.7.0.1
 */