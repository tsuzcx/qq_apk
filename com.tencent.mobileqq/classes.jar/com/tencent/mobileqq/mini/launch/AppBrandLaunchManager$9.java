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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateBaseLib ret=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.w("miniapp-process_AppBrandLaunchManager", 1, ((StringBuilder)localObject).toString());
    if (paramInt == 0) {
      return;
    }
    if (paramInt == 1)
    {
      QLog.w("miniapp-process_AppBrandLaunchManager", 1, HardCodeUtil.a(2131700816));
      return;
    }
    localObject = HardCodeUtil.a(2131700813);
    if (paramInt == 1100) {
      localObject = HardCodeUtil.a(2131700819);
    } else if (paramInt == 1101) {
      localObject = HardCodeUtil.a(2131700822);
    }
    QLog.w("miniapp-process_AppBrandLaunchManager", 1, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.9
 * JD-Core Version:    0.7.0.1
 */