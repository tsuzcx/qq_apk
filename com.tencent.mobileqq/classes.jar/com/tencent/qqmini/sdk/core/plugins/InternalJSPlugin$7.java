package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import beix;
import betc;
import beut;

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
      beix localbeix = beix.a(this.val$context, String.valueOf(beut.a().a()), this.val$appId);
      localObject1 = localbeix;
      localObject3 = localbeix;
      localbeix.a(this.val$key, "Object", this.val$data);
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      betc.d("InternalJSPlugin", "saveToMiniAppStorage ", localException);
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