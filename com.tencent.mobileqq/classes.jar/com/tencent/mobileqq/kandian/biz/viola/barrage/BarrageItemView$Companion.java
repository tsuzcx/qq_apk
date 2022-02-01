package com.tencent.mobileqq.kandian.biz.viola.barrage;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageItemView$Companion;", "", "()V", "BARRAGE_HEIGHT", "", "getBARRAGE_HEIGHT", "()I", "EMOTICON_TEXT_SIZE", "MAX_TEXT_LIMIT", "NEXT_LINE_LIMIT", "PADDING_LEFT_RIGHT", "getPADDING_LEFT_RIGHT", "getBarrageType", "Lcom/tencent/mobileqq/kandian/biz/viola/barrage/BarrageItemView$BarrageType;", "text", "", "getShowText", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BarrageItemView$Companion
{
  public final int a()
  {
    return BarrageItemView.b();
  }
  
  @NotNull
  public final BarrageItemView.BarrageType a(@Nullable String paramString)
  {
    if (paramString != null)
    {
      if (paramString.length() <= 16) {
        return BarrageItemView.BarrageType.SHORT;
      }
      if (paramString.length() <= 25) {
        return BarrageItemView.BarrageType.LONG;
      }
      return BarrageItemView.BarrageType.DOUBLE_LINE;
    }
    return BarrageItemView.BarrageType.SHORT;
  }
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    paramString = new StringBuilder(paramString);
    if (paramString.length() >= 33)
    {
      paramString.delete(33, paramString.length());
      paramString.replace(31, 34, "...");
    }
    if (paramString.length() >= 16) {
      paramString.insert(16, '\n');
    }
    paramString = paramString.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "stringBuilder.toString()");
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageItemView.Companion
 * JD-Core Version:    0.7.0.1
 */