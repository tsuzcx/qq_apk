import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;

class sdt
  implements DialogInterface.OnCancelListener
{
  sdt(sds paramsds) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryShareHelper", 2, "mShareActionSheet cancle button OnClick");
    }
    sds.a(this.a, -1, -1, true);
    sds.b(this.a, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sdt
 * JD-Core Version:    0.7.0.1
 */