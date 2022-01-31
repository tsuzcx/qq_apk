import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class kth
  implements DialogInterface.OnDismissListener
{
  kth(ktg paramktg) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("PublicAccountAdvertisementActivity", 2, "action dismiss");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kth
 * JD-Core Version:    0.7.0.1
 */