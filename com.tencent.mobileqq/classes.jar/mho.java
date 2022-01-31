import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.ResultReceiver;
import com.tencent.av.utils.PopupDialogQQSide;

public class mho
  implements DialogInterface.OnClickListener
{
  public mho(PopupDialogQQSide paramPopupDialogQQSide, ResultReceiver paramResultReceiver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null) {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(1, this.jdField_a_of_type_ComTencentAvUtilsPopupDialogQQSide.getArguments());
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     mho
 * JD-Core Version:    0.7.0.1
 */