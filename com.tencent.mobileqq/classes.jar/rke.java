import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class rke
  implements DialogInterface.OnDismissListener
{
  rke(rkd paramrkd) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    }
    if (rkd.a(this.a) != null) {
      rkd.a(this.a).a(rkd.a(this.a), rkd.b(this.a), false, false);
    }
    rkd.a(this.a, true);
    rkd.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rke
 * JD-Core Version:    0.7.0.1
 */