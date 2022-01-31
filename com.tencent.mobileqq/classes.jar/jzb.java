import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qphone.base.util.QLog;

public class jzb
  implements DialogInterface.OnClickListener
{
  public jzb(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a.a().a() == -1) {
      this.a.N();
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      if (this.a.a != null) {
        if (this.a.c()) {
          this.a.L();
        } else if (QLog.isColorLevel()) {
          QLog.e(this.a.c, 2, "PressCameraBtnRunnable-->go on stage fail,can not find the session");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jzb
 * JD-Core Version:    0.7.0.1
 */