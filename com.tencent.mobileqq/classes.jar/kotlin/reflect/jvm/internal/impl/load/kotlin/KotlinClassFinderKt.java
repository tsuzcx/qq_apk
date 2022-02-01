package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class KotlinClassFinderKt
{
  @Nullable
  public static final KotlinJvmBinaryClass findKotlinClass(@NotNull KotlinClassFinder paramKotlinClassFinder, @NotNull JavaClass paramJavaClass)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinClassFinder, "$this$findKotlinClass");
    Intrinsics.checkParameterIsNotNull(paramJavaClass, "javaClass");
    paramKotlinClassFinder = paramKotlinClassFinder.findKotlinClassOrContent(paramJavaClass);
    if (paramKotlinClassFinder != null) {
      return paramKotlinClassFinder.toKotlinJvmBinaryClass();
    }
    return null;
  }
  
  @Nullable
  public static final KotlinJvmBinaryClass findKotlinClass(@NotNull KotlinClassFinder paramKotlinClassFinder, @NotNull ClassId paramClassId)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinClassFinder, "$this$findKotlinClass");
    Intrinsics.checkParameterIsNotNull(paramClassId, "classId");
    paramKotlinClassFinder = paramKotlinClassFinder.findKotlinClassOrContent(paramClassId);
    if (paramKotlinClassFinder != null) {
      return paramKotlinClassFinder.toKotlinJvmBinaryClass();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.KotlinClassFinderKt
 * JD-Core Version:    0.7.0.1
 */