import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mobileqq.Doraemon.APICallback;
import com.tencent.mobileqq.Doraemon.impl.commonModule.UserInfoModule;
import com.tencent.mobileqq.Doraemon.util.DoraemonUtil;

public class rcf
  implements DialogInterface.OnCancelListener
{
  public rcf(UserInfoModule paramUserInfoModule, APICallback paramAPICallback) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    DoraemonUtil.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonAPICallback, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rcf
 * JD-Core Version:    0.7.0.1
 */