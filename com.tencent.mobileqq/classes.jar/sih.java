import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class sih
  implements DialogInterface.OnDismissListener
{
  sih(sig paramsig) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    }
    if (sig.a(this.a) != null) {
      sig.a(this.a).a(sig.a(this.a), sig.b(this.a), false, false);
    }
    sig.a(this.a, true);
    sig.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sih
 * JD-Core Version:    0.7.0.1
 */