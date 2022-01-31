package com.tencent.mobileqq.mini.launch;

import alud;
import com.tencent.mobileqq.mini.apkg.BaseLibManager.UpdateListener;
import com.tencent.qphone.base.util.QLog;

class AppBrandLaunchManager$13
  implements BaseLibManager.UpdateListener
{
  AppBrandLaunchManager$13(AppBrandLaunchManager paramAppBrandLaunchManager) {}
  
  public void onUpdateResult(int paramInt)
  {
    QLog.w("miniapp-process_AppBrandLaunchManager", 1, "updateBaseLib ret=" + paramInt);
    if (paramInt == 0) {
      return;
    }
    if (paramInt == 1)
    {
      QLog.w("miniapp-process_AppBrandLaunchManager", 1, alud.a(2131700979));
      return;
    }
    String str = alud.a(2131700976);
    if (paramInt == 1100) {
      str = alud.a(2131700982);
    }
    for (;;)
    {
      QLog.w("miniapp-process_AppBrandLaunchManager", 1, str);
      return;
      if (paramInt == 1101) {
        str = alud.a(2131700985);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.13
 * JD-Core Version:    0.7.0.1
 */