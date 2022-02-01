package cooperation.ilive.lite.floatwindow;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.falco.base.floatwindow.permission.FWPermission;

final class IliveFloatWindowHelper$1
  implements DialogInterface.OnClickListener
{
  IliveFloatWindowHelper$1(Activity paramActivity, IliveFloatWindowHelper.IPermissionCallback paramIPermissionCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FWPermission.requestPermission(this.a, new IliveFloatWindowHelper.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper.1
 * JD-Core Version:    0.7.0.1
 */