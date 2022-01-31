package com.tencent.mobileqq.mini.cache;

import alpo;
import android.app.Activity;
import bdcd;
import bdfq;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
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
        bdfq localbdfq = bdcd.a(this.val$activity, 230, null, this.val$dialogContext, alpo.a(2131710602), alpo.a(2131710603), new MiniCacheFreeManager.1.1(this), new MiniCacheFreeManager.1.2(this));
        localbdfq.setCanceledOnTouchOutside(false);
        if ((this.val$activity != null) && (!this.val$activity.isFinishing()))
        {
          localbdfq.show();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.cache.MiniCacheFreeManager.1
 * JD-Core Version:    0.7.0.1
 */