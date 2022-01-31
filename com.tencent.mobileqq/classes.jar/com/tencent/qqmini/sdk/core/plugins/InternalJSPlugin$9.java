package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import bgiy;
import bgte;
import com.tencent.qqmini.sdk.log.QMLog;

final class InternalJSPlugin$9
  implements Runnable
{
  InternalJSPlugin$9(Context paramContext, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      bgiy localbgiy = bgiy.a(this.val$context, String.valueOf(bgte.a().a()), this.val$appId);
      localObject1 = localbgiy;
      localObject3 = localbgiy;
      localbgiy.a(this.val$key, "Object", this.val$data);
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
        localObject3.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.9
 * JD-Core Version:    0.7.0.1
 */