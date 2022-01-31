import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class qup
  implements DialogInterface.OnDismissListener
{
  qup(quo paramquo) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    }
    if (quo.a(this.a) != null) {
      quo.a(this.a).a(quo.a(this.a), quo.b(this.a), false, false);
    }
    quo.a(this.a, true);
    quo.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qup
 * JD-Core Version:    0.7.0.1
 */