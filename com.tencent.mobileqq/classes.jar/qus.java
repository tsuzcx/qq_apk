import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class qus
  implements DialogInterface.OnDismissListener
{
  qus(qur paramqur) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    }
    if (qur.a(this.a) != null) {
      qur.a(this.a).a(qur.a(this.a), qur.b(this.a), false, false);
    }
    qur.a(this.a, true);
    qur.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qus
 * JD-Core Version:    0.7.0.1
 */