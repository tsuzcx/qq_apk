import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class sux
  implements DialogInterface.OnDismissListener
{
  sux(suw paramsuw) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    }
    if (suw.a(this.a) != null) {
      suw.a(this.a).a(suw.a(this.a), suw.b(this.a), false, false);
    }
    suw.a(this.a, true);
    suw.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sux
 * JD-Core Version:    0.7.0.1
 */