package com.tencent.mobileqq.kandian.glue.businesshandler.engine;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.RIJLogUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class KandianMergeManager$8
  implements Runnable
{
  KandianMergeManager$8(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    try
    {
      if (KandianMergeManager.c(this.this$0) != null)
      {
        KandianMergeManager.c(this.this$0).getApplication().getApplicationContext().unregisterReceiver(KandianMergeManager.d(this.this$0));
        return;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      QLog.e("KandianMergeManager", 1, new Object[] { "unRegisterBroadcastReceivers: e = ", RIJLogUtil.a(localIllegalArgumentException) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager.8
 * JD-Core Version:    0.7.0.1
 */