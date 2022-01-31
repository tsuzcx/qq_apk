package com.tencent.mobileqq.mini.launch;

import ajjy;
import com.tencent.mobileqq.mini.apkg.BaseLibManager.UpdateListener;
import com.tencent.qphone.base.util.QLog;

class AppBrandLaunchManager$11
  implements BaseLibManager.UpdateListener
{
  AppBrandLaunchManager$11(AppBrandLaunchManager paramAppBrandLaunchManager) {}
  
  public void onUpdateResult(int paramInt)
  {
    QLog.w("miniapp-process_AppBrandLaunchManager", 1, "updateBaseLib ret=" + paramInt);
    if (paramInt == 0) {
      return;
    }
    if (paramInt == 1)
    {
      QLog.w("miniapp-process_AppBrandLaunchManager", 1, ajjy.a(2131634803));
      return;
    }
    String str = ajjy.a(2131634800);
    if (paramInt == 1100) {
      str = ajjy.a(2131634806);
    }
    for (;;)
    {
      QLog.w("miniapp-process_AppBrandLaunchManager", 1, str);
      return;
      if (paramInt == 1101) {
        str = ajjy.a(2131634809);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.11
 * JD-Core Version:    0.7.0.1
 */