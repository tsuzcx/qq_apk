package com.tencent.mobileqq.mini.cache;

import alud;
import android.app.Activity;
import bdgm;
import bdjz;
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
        bdjz localbdjz = bdgm.a(this.val$activity, 230, null, this.val$dialogContext, alud.a(2131710614), alud.a(2131710615), new MiniCacheFreeManager.1.1(this), new MiniCacheFreeManager.1.2(this));
        localbdjz.setCanceledOnTouchOutside(false);
        if ((this.val$activity != null) && (!this.val$activity.isFinishing()))
        {
          localbdjz.show();
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