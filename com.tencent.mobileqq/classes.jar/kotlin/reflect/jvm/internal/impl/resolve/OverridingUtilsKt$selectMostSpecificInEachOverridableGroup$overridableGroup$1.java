package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

final class OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1
  extends Lambda
  implements Function1<H, Unit>
{
  OverridingUtilsKt$selectMostSpecificInEachOverridableGroup$overridableGroup$1(SmartSet paramSmartSet)
  {
    super(1);
  }
  
  public final void invoke(H paramH)
  {
    SmartSet localSmartSet = this.$conflictedHandles;
    Intrinsics.checkExpressionValueIsNotNull(paramH, "it");
    localSmartSet.add(paramH);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt.selectMostSpecificInEachOverridableGroup.overridableGroup.1
 * JD-Core Version:    0.7.0.1
 */