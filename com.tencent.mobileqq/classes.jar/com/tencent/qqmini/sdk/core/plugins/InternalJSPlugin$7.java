package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import beig;
import besl;
import beuc;

final class InternalJSPlugin$7
  implements Runnable
{
  InternalJSPlugin$7(Context paramContext, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      beig localbeig = beig.a(this.val$context, String.valueOf(beuc.a().a()), this.val$appId);
      localObject1 = localbeig;
      localObject3 = localbeig;
      localbeig.a(this.val$key, "Object", this.val$data);
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      besl.d("InternalJSPlugin", "saveToMiniAppStorage ", localException);
      return;
    }
    finally
    {
      if (localObject3 != null) {
        localObject3.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.7
 * JD-Core Version:    0.7.0.1
 */