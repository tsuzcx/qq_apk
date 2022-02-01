package com.tencent.mobileqq.mini.reuse;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.business.MiniAppConfProcessor;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

class MiniAppTransferModule$1
  implements Runnable
{
  MiniAppTransferModule$1(MiniAppTransferModule paramMiniAppTransferModule, AppRuntime paramAppRuntime, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    DesktopDataManager localDesktopDataManager = (DesktopDataManager)this.val$runtime.getManager(QQManagerFactory.MINI_APP_DESKTOP_MANAGER);
    if ((localDesktopDataManager != null) && (!TextUtils.isEmpty(this.val$appid)))
    {
      if ((this.val$topType == 1) && (localDesktopDataManager.getTopMiniAppNumber() >= MiniAppConfProcessor.f()))
      {
        this.this$0.callbackResult(this.val$callbackId, EIPCResult.createResult(-100, null));
        return;
      }
      MiniAppInfo localMiniAppInfo = localDesktopDataManager.findMiniApp(this.val$appid, this.val$verType);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("miniappInfo : ");
      localStringBuilder.append(localMiniAppInfo);
      QLog.d("MiniAppTransferModule", 2, localStringBuilder.toString());
      if (localMiniAppInfo != null)
      {
        localMiniAppInfo.topType = this.val$topType;
        if (localMiniAppInfo.topType == 1) {
          localMiniAppInfo.updateTimeStamp();
        }
        localDesktopDataManager.updateModuleMyApp(localMiniAppInfo);
        this.this$0.callbackResult(this.val$callbackId, EIPCResult.createResult(0, null));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppTransferModule.1
 * JD-Core Version:    0.7.0.1
 */