package com.tencent.qqmini.sdk.cache;

import android.app.Activity;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.core.utils.DialogUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.widget.MiniCustomDialog;

final class MiniCacheFreeManager$1
  implements Runnable
{
  MiniCacheFreeManager$1(Activity paramActivity, String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    if ((this.val$activity == null) || (this.val$activity.isFinishing())) {
      QMLog.e("MiniCacheFreeManager", "freeCacheDialog activity is null");
    }
    for (;;)
    {
      return;
      try
      {
        MiniCustomDialog localMiniCustomDialog = DialogUtil.createCustomDialog(this.val$activity, 230, null, this.val$dialogContext, R.string.mini_sdk_cancel, R.string.mini_sdk_ok, new MiniCacheFreeManager.1.1(this), new MiniCacheFreeManager.1.2(this));
        localMiniCustomDialog.setCanceledOnTouchOutside(false);
        if ((this.val$activity != null) && (!this.val$activity.isFinishing()))
        {
          localMiniCustomDialog.show();
          return;
        }
      }
      catch (Exception localException)
      {
        QMLog.e("MiniCacheFreeManager", "freeCacheDialog exception ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.cache.MiniCacheFreeManager.1
 * JD-Core Version:    0.7.0.1
 */