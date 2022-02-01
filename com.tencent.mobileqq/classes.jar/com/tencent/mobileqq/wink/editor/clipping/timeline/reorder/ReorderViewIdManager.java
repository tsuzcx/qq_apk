package com.tencent.mobileqq.wink.editor.clipping.timeline.reorder;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/ReorderViewIdManager;", "", "()V", "INVALID_ID", "", "ids", "", "", "clear", "", "get", "key", "put", "id", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public final class ReorderViewIdManager
{
  public static final ReorderViewIdManager a = new ReorderViewIdManager();
  private static final Map<String, Integer> b = (Map)new LinkedHashMap();
  
  public final int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    paramString = (Integer)b.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.ReorderViewIdManager
 * JD-Core Version:    0.7.0.1
 */