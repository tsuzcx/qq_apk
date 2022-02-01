package cooperation.qqfav.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;

class QfavJumpActivity$2
  implements DialogInterface.OnClickListener
{
  QfavJumpActivity$2(QfavJumpActivity paramQfavJumpActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      QfavJumpActivity.a(this.d, this.a, this.b, this.c);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.w("qqfav|QfavJumpActivity", 2, "copy file error", paramDialogInterface);
      }
      paramDialogInterface = this.d;
      QfavJumpActivity.a(paramDialogInterface, paramDialogInterface.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qqfav.widget.QfavJumpActivity.2
 * JD-Core Version:    0.7.0.1
 */