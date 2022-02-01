package com.tencent.qqmini.minigame.helper;

import android.content.Context;
import com.tencent.qqmini.sdk.cache.Storage;
import com.tencent.qqmini.sdk.manager.LoginManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PreloadStorageHelper$preload$1
  implements Runnable
{
  PreloadStorageHelper$preload$1(WeakReference paramWeakReference, String paramString) {}
  
  public final void run()
  {
    Context localContext = (Context)this.a.get();
    if (localContext != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localContext, "ctxRef.get() ?: return@executeOnDiskIOThreadPool");
      Object localObject = LoginManager.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "LoginManager.getInstance()");
      if (((LoginManager)localObject).getAccount() != null)
      {
        localObject = LoginManager.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "LoginManager.getInstance()");
        localObject = ((LoginManager)localObject).getAccount();
      }
      else
      {
        localObject = "";
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject, "uin");
      int i;
      if (((CharSequence)localObject).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        Storage.open(localContext, (String)localObject, this.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.helper.PreloadStorageHelper.preload.1
 * JD-Core Version:    0.7.0.1
 */