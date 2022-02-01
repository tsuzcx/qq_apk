package kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins;

import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class BuiltInsResourceLoader
{
  @Nullable
  public final InputStream loadResource(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "path");
    Object localObject = getClass().getClassLoader();
    if (localObject != null)
    {
      localObject = ((ClassLoader)localObject).getResourceAsStream(paramString);
      if (localObject != null) {
        return localObject;
      }
    }
    return ClassLoader.getSystemResourceAsStream(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.builtins.BuiltInsResourceLoader
 * JD-Core Version:    0.7.0.1
 */