package kotlin.reflect.jvm.internal.impl.descriptors.runtime.components;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ReflectJavaClassFinderKt
{
  @Nullable
  public static final Class<?> tryLoadClass(@NotNull ClassLoader paramClassLoader, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramClassLoader, "$this$tryLoadClass");
    Intrinsics.checkParameterIsNotNull(paramString, "fqName");
    try
    {
      paramClassLoader = Class.forName(paramString, false, paramClassLoader);
      return paramClassLoader;
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      label21:
      break label21;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.ReflectJavaClassFinderKt
 * JD-Core Version:    0.7.0.1
 */