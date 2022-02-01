package com.tencent.mobileqq.mini.cache;

import android.app.Activity;
import anvx;
import bhdj;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

final class MiniCacheFreeManager$1
  implements Runnable
{
  MiniCacheFreeManager$1(Activity paramActivity, String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    if ((this.val$activity == null) || (this.val$activity.isFinishing())) {
      QLog.e("MiniCacheFreeManager", 1, "freeCacheDialog activity is null");
    }
    for (;;)
    {
      return;
      try
      {
        QQCustomDialog localQQCustomDialog = bhdj.a(this.val$activity, 230, null, this.val$dialogContext, anvx.a(2131709678), anvx.a(2131709679), new MiniCacheFreeManager.1.1(this), new MiniCacheFreeManager.1.2(this));
        localQQCustomDialog.setCanceledOnTouchOutside(false);
        if ((this.val$activity != null) && (!this.val$activity.isFinishing()))
        {
          localQQCustomDialog.show();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MiniCacheFreeManager", 1, "freeCacheDialog exception ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.1
 * JD-Core Version:    0.7.0.1
 */