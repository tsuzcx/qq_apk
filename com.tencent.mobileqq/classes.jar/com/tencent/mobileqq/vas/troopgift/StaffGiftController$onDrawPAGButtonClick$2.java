package com.tencent.mobileqq.vas.troopgift;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.libpag.PAGView;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lorg/libpag/PAGView;", "invoke"}, k=3, mv={1, 1, 16})
final class StaffGiftController$onDrawPAGButtonClick$2
  extends Lambda
  implements Function1<PAGView, String>
{
  StaffGiftController$onDrawPAGButtonClick$2(String paramString)
  {
    super(1);
  }
  
  @Nullable
  public final String invoke(@NotNull PAGView paramPAGView)
  {
    Intrinsics.checkParameterIsNotNull(paramPAGView, "it");
    return this.$feedbackText;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.StaffGiftController.onDrawPAGButtonClick.2
 * JD-Core Version:    0.7.0.1
 */