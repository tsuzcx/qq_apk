package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import com.tencent.mobileqq.mini.utils.TroopApplicationListUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;

class MiniAppProxyImpl$4
  implements IActivityResultListener
{
  MiniAppProxyImpl$4(MiniAppProxyImpl paramMiniAppProxyImpl, IActivityResultManager paramIActivityResultManager, IMiniAppContext paramIMiniAppContext) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1002) && (paramInt2 == -1))
    {
      this.jdField_a_of_type_ComTencentQqminiSdkLauncherShellIActivityResultManager.removeActivityResultListener(this);
      String str = paramIntent.getStringExtra("uin");
      paramIntent = paramIntent.getStringExtra("uinname");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("group uin: ");
      localStringBuilder.append(str);
      localStringBuilder.append(", group name: ");
      localStringBuilder.append(paramIntent);
      QLog.d("MiniAppProxyImpl", 1, localStringBuilder.toString());
      TroopApplicationListUtil.addMiniAppToTroopApplicationList(str, this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreIMiniAppContext.getMiniAppInfo().appId, null);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.4
 * JD-Core Version:    0.7.0.1
 */