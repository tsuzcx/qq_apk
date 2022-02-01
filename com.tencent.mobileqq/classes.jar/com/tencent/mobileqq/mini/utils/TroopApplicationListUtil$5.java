package com.tencent.mobileqq.mini.utils;

import android.content.Intent;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultListener;
import com.tencent.qqmini.sdk.launcher.shell.IActivityResultManager;

final class TroopApplicationListUtil$5
  implements IActivityResultListener
{
  TroopApplicationListUtil$5(IActivityResultManager paramIActivityResultManager, String paramString, AsyncResult paramAsyncResult) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1048576) && (paramInt2 == -1))
    {
      this.val$arm.removeActivityResultListener(this);
      String str = paramIntent.getStringExtra("uin");
      paramIntent = paramIntent.getStringExtra("uinname");
      TroopApplicationListUtil.addMiniAppToTroopApplicationList(str, this.val$appId, null, this.val$result);
      QLog.d("TroopApplicationListUtil", 1, "group uin: " + str + ", group name: " + paramIntent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.utils.TroopApplicationListUtil.5
 * JD-Core Version:    0.7.0.1
 */