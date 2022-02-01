package com.tencent.tavcut.utils;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoUtils$getWidthHeightAndDuration$safeToInt$1
  extends Lambda
  implements Function1<String, Integer>
{
  public static final 1 INSTANCE = new 1();
  
  VideoUtils$getWidthHeightAndDuration$safeToInt$1()
  {
    super(1);
  }
  
  public final int invoke(@Nullable String paramString)
  {
    if (paramString != null) {
      return Integer.parseInt(paramString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.utils.VideoUtils.getWidthHeightAndDuration.safeToInt.1
 * JD-Core Version:    0.7.0.1
 */