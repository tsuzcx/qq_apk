package com.tencent.qqmini.minigame.helper;

import android.app.Activity;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class PreloadSystemInfoHelper$preload$1
  implements Runnable
{
  PreloadSystemInfoHelper$preload$1(WeakReference paramWeakReference) {}
  
  public final void run()
  {
    Activity localActivity = (Activity)this.a.get();
    if (localActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localActivity, "actRef.get() ?: return@e…teOnComputationThreadPool");
      PreloadSystemInfoHelper.b(localActivity);
      PreloadSystemInfoHelper.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.helper.PreloadSystemInfoHelper.preload.1
 * JD-Core Version:    0.7.0.1
 */