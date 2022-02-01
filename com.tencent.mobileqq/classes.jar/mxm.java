import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class mxm
  implements DialogInterface.OnClickListener
{
  mxm(mxk parammxk) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (mxk.a(this.a) != null) {
      mxk.a(this.a).a();
    }
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameVideoProcessHelper", 2, "showRealNameDialog click cancel.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mxm
 * JD-Core Version:    0.7.0.1
 */