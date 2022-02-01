package com.tencent.qqmini.sdk.runtime;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqmini.sdk.cache.MiniCacheFreeManager;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;

class AppStateManager$3$1
  implements DialogInterface.OnClickListener
{
  AppStateManager$3$1(AppStateManager.3 param3) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      QMLog.i("minisdk-start_RuntimeState", "restart " + AppStateManager.access$000(this.this$1.this$0).getRuntime().getMiniAppInfo());
      MiniCacheFreeManager.freeCache(LoginManager.getInstance().getAccount(), this.this$1.val$miniAppInfo, false, new AppStateManager.3.1.1(this));
      return;
    }
    catch (Exception paramDialogInterface)
    {
      QMLog.e("minisdk-start_RuntimeState", "clear cache and restart failed ", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.AppStateManager.3.1
 * JD-Core Version:    0.7.0.1
 */