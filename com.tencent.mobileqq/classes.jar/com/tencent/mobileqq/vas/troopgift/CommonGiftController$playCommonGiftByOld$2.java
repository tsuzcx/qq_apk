package com.tencent.mobileqq.vas.troopgift;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lorg/libpag/PAGView;", "invoke"}, k=3, mv={1, 1, 16})
final class CommonGiftController$playCommonGiftByOld$2
  extends Lambda
  implements Function1<PAGView, Unit>
{
  CommonGiftController$playCommonGiftByOld$2(CommonGiftController paramCommonGiftController)
  {
    super(1);
  }
  
  public final void invoke(@NotNull PAGView paramPAGView)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGView, "it");
    paramPAGView.setRepeatCount(2);
    paramPAGView.addListener((PAGView.PAGViewListener)new CommonGiftController.playCommonGiftByOld.2.1(this));
    paramPAGView.setProgress(0.0D);
    paramPAGView.play();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.CommonGiftController.playCommonGiftByOld.2
 * JD-Core Version:    0.7.0.1
 */