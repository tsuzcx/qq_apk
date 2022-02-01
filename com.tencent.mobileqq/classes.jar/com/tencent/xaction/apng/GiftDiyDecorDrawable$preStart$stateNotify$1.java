package com.tencent.xaction.apng;

import android.view.View;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "tag", "", "status", "delayMillis", "", "invoke"}, k=3, mv={1, 1, 16})
final class GiftDiyDecorDrawable$preStart$stateNotify$1
  extends Lambda
  implements Function3<String, String, Long, Unit>
{
  GiftDiyDecorDrawable$preStart$stateNotify$1(GiftDiyDecorDrawable paramGiftDiyDecorDrawable, View paramView)
  {
    super(3);
  }
  
  public final void invoke(@NotNull String paramString1, @NotNull String paramString2, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "status");
    IXAEngine localIXAEngine = this.this$0.getEngine();
    if (localIXAEngine != null) {
      this.$view.postDelayed((Runnable)new GiftDiyDecorDrawable.preStart.stateNotify.1..special..inlined.let.lambda.1(localIXAEngine, this, paramString1, paramString2, paramLong), paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.apng.GiftDiyDecorDrawable.preStart.stateNotify.1
 * JD-Core Version:    0.7.0.1
 */