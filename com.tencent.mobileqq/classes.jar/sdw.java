import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;

class sdw
  implements DialogInterface.OnCancelListener
{
  sdw(sdv paramsdv) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryShareHelper", 2, "mShareActionSheet cancle button OnClick");
    }
    sdv.a(this.a, -1, -1, true);
    sdv.b(this.a, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sdw
 * JD-Core Version:    0.7.0.1
 */