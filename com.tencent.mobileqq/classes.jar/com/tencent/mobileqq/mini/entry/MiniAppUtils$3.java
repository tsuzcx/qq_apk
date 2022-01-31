package com.tencent.mobileqq.mini.entry;

import android.content.Context;
import bcyb;
import com.tencent.mobileqq.mini.cache.Storage;
import com.tencent.qphone.base.util.QLog;

final class MiniAppUtils$3
  implements Runnable
{
  MiniAppUtils$3(Context paramContext, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Storage localStorage = Storage.open(this.val$context, String.valueOf(bcyb.a().a()), this.val$appId);
      localObject1 = localStorage;
      localObject3 = localStorage;
      localStorage.writeSync(this.val$key, "Object", this.val$data);
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      QLog.e("MiniAppUtils", 1, "saveToMiniAppStorage ", localException);
      return;
    }
    finally
    {
      if (localObject3 != null) {
        localObject3.close();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppUtils.3
 * JD-Core Version:    0.7.0.1
 */