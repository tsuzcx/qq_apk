package com.tencent.qapmsdk.common.util;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/ClassUtil;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class ClassUtil
{
  public static final ClassUtil.Companion Companion = new ClassUtil.Companion(null);
  
  @JvmStatic
  public static final boolean classAvailable(@NotNull String paramString)
  {
    return Companion.classAvailable(paramString);
  }
  
  @JvmStatic
  @NotNull
  public static final String getClassName(@NotNull Object paramObject, @Nullable Integer paramInteger)
  {
    return Companion.getClassName(paramObject, paramInteger);
  }
  
  @JvmStatic
  public static final boolean objectIsInstanceClass(@Nullable Object paramObject, @NotNull String paramString)
  {
    return Companion.objectIsInstanceClass(paramObject, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.ClassUtil
 * JD-Core Version:    0.7.0.1
 */