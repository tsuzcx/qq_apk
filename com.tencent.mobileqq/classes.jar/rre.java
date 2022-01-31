import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;

class rre
  implements DialogInterface.OnCancelListener
{
  rre(rrd paramrrd) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryShareHelper", 2, "mShareActionSheet cancle button OnClick");
    }
    rrd.a(this.a, -1, -1, true);
    rrd.b(this.a, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rre
 * JD-Core Version:    0.7.0.1
 */