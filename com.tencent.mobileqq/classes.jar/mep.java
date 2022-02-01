import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;

public class mep
  implements DialogInterface.OnCancelListener
{
  public mep(MultiIncomingCallsActivity paramMultiIncomingCallsActivity, long paramLong) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.a(this.jdField_a_of_type_Long, "onClickCancel", true, null, -1);
    this.jdField_a_of_type_ComTencentAvUiMultiIncomingCallsActivity.b("onClickCancel");
    bfxl.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mep
 * JD-Core Version:    0.7.0.1
 */