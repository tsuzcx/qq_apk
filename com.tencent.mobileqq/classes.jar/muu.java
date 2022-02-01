import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.qphone.base.util.QLog;

class muu
  implements DialogInterface.OnShowListener
{
  muu(mur parammur) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TraeSessionHelper", 2, "Trae_DRP 0X8008D1E at: " + System.currentTimeMillis());
    }
    bdll.b(null, "CliOper", "", "", "0X8008D1E", "0X8008D1E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     muu
 * JD-Core Version:    0.7.0.1
 */