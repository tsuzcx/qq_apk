import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.ResultReceiver;
import com.tencent.av.utils.PopupDialogQQSide;

public class mvd
  implements DialogInterface.OnClickListener
{
  public mvd(PopupDialogQQSide paramPopupDialogQQSide, ResultReceiver paramResultReceiver) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null) {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(0, this.jdField_a_of_type_ComTencentAvUtilsPopupDialogQQSide.getArguments());
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mvd
 * JD-Core Version:    0.7.0.1
 */