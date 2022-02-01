import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class skf
  implements DialogInterface.OnDismissListener
{
  skf(ske paramske) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    }
    if (ske.a(this.a) != null) {
      ske.a(this.a).a(ske.a(this.a), ske.b(this.a), false, false);
    }
    ske.a(this.a, true);
    ske.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     skf
 * JD-Core Version:    0.7.0.1
 */