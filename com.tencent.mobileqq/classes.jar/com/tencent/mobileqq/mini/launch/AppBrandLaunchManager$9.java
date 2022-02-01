package com.tencent.mobileqq.mini.launch;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.BaseLibManager.UpdateListener;
import com.tencent.qphone.base.util.QLog;

class AppBrandLaunchManager$9
  implements BaseLibManager.UpdateListener
{
  AppBrandLaunchManager$9(AppBrandLaunchManager paramAppBrandLaunchManager) {}
  
  public void onUpdateResult(int paramInt)
  {
    QLog.w("miniapp-process_AppBrandLaunchManager", 1, "updateBaseLib ret=" + paramInt);
    if (paramInt == 0) {
      return;
    }
    if (paramInt == 1)
    {
      QLog.w("miniapp-process_AppBrandLaunchManager", 1, HardCodeUtil.a(2131700675));
      return;
    }
    String str = HardCodeUtil.a(2131700672);
    if (paramInt == 1100) {
      str = HardCodeUtil.a(2131700678);
    }
    for (;;)
    {
      QLog.w("miniapp-process_AppBrandLaunchManager", 1, str);
      return;
      if (paramInt == 1101) {
        str = HardCodeUtil.a(2131700681);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.9
 * JD-Core Version:    0.7.0.1
 */