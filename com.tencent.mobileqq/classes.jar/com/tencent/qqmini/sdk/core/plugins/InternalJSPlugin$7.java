package com.tencent.qqmini.sdk.core.plugins;

import android.content.Context;
import bdeg;
import bdnw;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;

final class InternalJSPlugin$7
  implements Runnable
{
  InternalJSPlugin$7(Context paramContext, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Object localObject3 = null;
    bdeg localbdeg2 = null;
    bdeg localbdeg1 = localbdeg2;
    Object localObject1 = localObject3;
    try
    {
      MiniAppProxy localMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
      localbdeg1 = localbdeg2;
      localObject1 = localObject3;
      localbdeg2 = bdeg.a(this.val$context, String.valueOf(localMiniAppProxy.getAccount()), this.val$appId);
      localbdeg1 = localbdeg2;
      localObject1 = localbdeg2;
      localbdeg2.a(this.val$key, "Object", this.val$data);
      if (localbdeg2 != null) {
        localbdeg2.a();
      }
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localObject1 = localbdeg1;
        bdnw.d("InternalJSPlugin", "saveToMiniAppStorage ", localException);
      } while (localbdeg1 == null);
      localbdeg1.a();
      return;
    }
    finally
    {
      if (localObject1 != null) {
        ((bdeg)localObject1).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.InternalJSPlugin.7
 * JD-Core Version:    0.7.0.1
 */