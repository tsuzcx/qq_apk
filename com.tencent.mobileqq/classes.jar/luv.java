import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.MultiVideoCtrlLayerUI4Discussion;
import com.tencent.qphone.base.util.QLog;

public class luv
  implements DialogInterface.OnClickListener
{
  public luv(MultiVideoCtrlLayerUI4Discussion paramMultiVideoCtrlLayerUI4Discussion) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.w(this.a.c, 1, "showConfirmBoxToHangup, no, mRelationId[" + this.a.b + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     luv
 * JD-Core Version:    0.7.0.1
 */