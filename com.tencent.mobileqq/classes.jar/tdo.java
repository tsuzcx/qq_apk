import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.NotifyPCActiveActivity;
import com.tencent.mobileqq.app.CardHandler;

public class tdo
  implements DialogInterface.OnClickListener
{
  public tdo(NotifyPCActiveActivity paramNotifyPCActiveActivity, CardHandler paramCardHandler) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppCardHandler.b(true);
    BaseApplicationImpl.getApplication().setPCActiveNotice(null, null, null, null);
    this.jdField_a_of_type_ComTencentMobileqqActivityNotifyPCActiveActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tdo
 * JD-Core Version:    0.7.0.1
 */