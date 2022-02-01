package com.tencent.mobileqq.vas.troopgift;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGComposition;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lorg/libpag/PAGView;", "invoke"}, k=3, mv={1, 1, 16})
final class CommonGiftController$playCommonGiftByOld$1
  extends Lambda
  implements Function1<PAGView, Unit>
{
  CommonGiftController$playCommonGiftByOld$1(File[] paramArrayOfFile)
  {
    super(1);
  }
  
  public final void invoke(@NotNull PAGView paramPAGView)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGView, "it");
    String str = this.$files[1].getPath();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("/gift/gift.pag");
    paramPAGView.setComposition((PAGComposition)PAGFile.Load(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.CommonGiftController.playCommonGiftByOld.1
 * JD-Core Version:    0.7.0.1
 */