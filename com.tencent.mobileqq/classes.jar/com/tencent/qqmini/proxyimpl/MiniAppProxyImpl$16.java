package com.tencent.qqmini.proxyimpl;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.IAppUpdateListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;

class MiniAppProxyImpl$16
  implements IActivityResultListener
{
  MiniAppProxyImpl$16(MiniAppProxyImpl paramMiniAppProxyImpl, IActivityResultManager paramIActivityResultManager, MiniAppProxy.IAppUpdateListener paramIAppUpdateListener) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.a.removeActivityResultListener(this);
    if (paramInt1 == 1003)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        boolean bool = paramIntent.getBooleanExtra("getUpgradeInfo", true);
        if (bool)
        {
          paramIntent = "最新版本无需更新";
        }
        else
        {
          paramIntent = new StringBuilder();
          paramIntent.append("getUpgradeInfo: ");
          paramIntent.append(bool);
          QLog.d("MiniAppProxyImpl", 1, paramIntent.toString());
          paramIntent = "获取版本信息失败";
        }
        this.b.onGetAppUpdateResult(bool, paramIntent);
        return true;
      }
      this.b.onGetAppUpdateResult(true, "版本过低需要更新");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.MiniAppProxyImpl.16
 * JD-Core Version:    0.7.0.1
 */