import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

class jkx
  implements DialogInterface.OnClickListener
{
  jkx(jkw paramjkw) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RandomController", 2, " [random room owner] kick member fail because of network bad");
    }
    this.a.a.c = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jkx
 * JD-Core Version:    0.7.0.1
 */