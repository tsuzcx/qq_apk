package com.tencent.mobileqq.identification;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.sdkkitframework.common.YtLogger;

class IdentificationPoseReflect$2
  implements Runnable
{
  IdentificationPoseReflect$2(IdentificationPoseReflect paramIdentificationPoseReflect, int paramInt, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[YTUtilityInterface.setAppBrightness] brightness: ");
    ((StringBuilder)localObject).append(this.a);
    YtLogger.i("qq_Identification.Model", ((StringBuilder)localObject).toString());
    localObject = this.b;
    int i = 1;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      localObject = this.b.getWindow();
      if (localObject == null)
      {
        QLog.e("qq_Identification.Model", 1, "setAppBrightness window==null");
        return;
      }
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      int j = this.a;
      if (j == -1)
      {
        localLayoutParams.screenBrightness = -1.0F;
      }
      else
      {
        if (j > 0) {
          i = j;
        }
        localLayoutParams.screenBrightness = (i / 255.0F);
      }
      ((Window)localObject).setAttributes(localLayoutParams);
      return;
    }
    QLog.e("qq_Identification.Model", 1, "setAppBrightness activity invalid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.identification.IdentificationPoseReflect.2
 * JD-Core Version:    0.7.0.1
 */