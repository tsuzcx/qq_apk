import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.qphone.base.util.QLog;

class svm
  implements DialogInterface.OnCancelListener
{
  svm(svl paramsvl) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GalleryShareHelper", 2, "mShareActionSheet cancle button OnClick");
    }
    svl.a(this.a, -1, -1, true);
    svl.b(this.a, -1, -1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     svm
 * JD-Core Version:    0.7.0.1
 */