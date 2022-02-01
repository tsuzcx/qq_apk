import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;

public class mfl
  implements DialogInterface.OnCancelListener
{
  public mfl(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, long paramLong) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.a(this.jdField_a_of_type_Long, "onClickCancel", true, null, -1);
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.b("onClickCancel");
    bhgd.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mfl
 * JD-Core Version:    0.7.0.1
 */