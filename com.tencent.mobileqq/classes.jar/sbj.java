import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.qphone.base.util.QLog;

class sbj
  implements DialogInterface.OnDismissListener
{
  sbj(sbi paramsbi) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoShareHelper", 2, "DialogInterface.OnDismissListener onDismiss() mIsActivityDoOnPaused=");
    }
    if (sbi.a(this.a) != null) {
      sbi.a(this.a).a(sbi.a(this.a), sbi.b(this.a), false, false);
    }
    sbi.a(this.a, true);
    sbi.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbj
 * JD-Core Version:    0.7.0.1
 */