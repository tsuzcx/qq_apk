package com.tencent.mobileqq.mini.cache;

import android.app.Activity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

final class MiniCacheFreeManager$1
  implements Runnable
{
  MiniCacheFreeManager$1(Activity paramActivity, String paramString1, String paramString2, MiniAppInfo paramMiniAppInfo) {}
  
  public void run()
  {
    Object localObject = this.val$activity;
    if ((localObject != null) && (!((Activity)localObject).isFinishing()))
    {
      try
      {
        localObject = DialogUtil.a(this.val$activity, 230, null, this.val$dialogContext, HardCodeUtil.a(2131710175), HardCodeUtil.a(2131710176), new MiniCacheFreeManager.1.1(this), new MiniCacheFreeManager.1.2(this));
        ((QQCustomDialog)localObject).setCanceledOnTouchOutside(false);
        if ((this.val$activity != null) && (!this.val$activity.isFinishing()))
        {
          ((QQCustomDialog)localObject).show();
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("MiniCacheFreeManager", 1, "freeCacheDialog exception ", localException);
      }
      return;
    }
    QLog.e("MiniCacheFreeManager", 1, "freeCacheDialog activity is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.1
 * JD-Core Version:    0.7.0.1
 */