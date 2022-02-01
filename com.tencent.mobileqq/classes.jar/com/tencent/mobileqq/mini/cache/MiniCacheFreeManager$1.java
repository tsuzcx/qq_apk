package com.tencent.mobileqq.mini.cache;

import android.app.Activity;
import anzj;
import bhlq;
import bhpc;
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
        bhpc localbhpc = bhlq.a(this.val$activity, 230, null, this.val$dialogContext, anzj.a(2131709099), anzj.a(2131709100), new MiniCacheFreeManager.1.1(this), new MiniCacheFreeManager.1.2(this));
        localbhpc.setCanceledOnTouchOutside(false);
        if ((this.val$activity != null) && (!this.val$activity.isFinishing()))
        {
          localbhpc.show();
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