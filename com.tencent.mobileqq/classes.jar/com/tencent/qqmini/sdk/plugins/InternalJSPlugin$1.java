package com.tencent.qqmini.sdk.plugins;

import android.content.Context;
import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.manager.LoginManager;

final class InternalJSPlugin$1
  implements Runnable
{
  InternalJSPlugin$1(Context paramContext, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Storage localStorage = Storage.open(this.val$context, String.valueOf(LoginManager.getInstance().getAccount()), this.val$appId);
      localObject1 = localStorage;
      localObject3 = localStorage;
      localStorage.writeSync(this.val$key, "Object", this.val$data);
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      QMLog.e("InternalJSPlugin", "saveToMiniAppStorage ", localException);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InternalJSPlugin.1
 * JD-Core Version:    0.7.0.1
 */