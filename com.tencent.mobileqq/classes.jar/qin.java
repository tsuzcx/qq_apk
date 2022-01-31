import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class qin
  implements DialogInterface.OnDismissListener
{
  qin(qim paramqim) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    }
    if (qim.a(this.a) != null) {
      qim.a(this.a).a(qim.a(this.a), qim.b(this.a), false, false);
    }
    qim.a(this.a, true);
    qim.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qin
 * JD-Core Version:    0.7.0.1
 */