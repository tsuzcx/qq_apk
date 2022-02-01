package cooperation.ilive.lite.floatwindow;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

final class IliveFloatWindowHelper$2
  implements DialogInterface.OnClickListener
{
  IliveFloatWindowHelper$2(IliveFloatWindowHelper.IPermissionCallback paramIPermissionCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    QLog.e("IliveFloatWindowHelper", 1, "permissionFinish onCancelClick");
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.onFinish(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper.2
 * JD-Core Version:    0.7.0.1
 */