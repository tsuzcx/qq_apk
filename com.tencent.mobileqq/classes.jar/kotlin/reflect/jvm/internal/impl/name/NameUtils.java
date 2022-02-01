package kotlin.reflect.jvm.internal.impl.name;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

public final class NameUtils
{
  public static final NameUtils INSTANCE = new NameUtils();
  private static final Regex SANITIZE_AS_JAVA_INVALID_CHARACTERS = new Regex("[^\\p{L}\\p{Digit}]");
  
  @JvmStatic
  @NotNull
  public static final String sanitizeAsJavaIdentifier(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return SANITIZE_AS_JAVA_INVALID_CHARACTERS.replace((CharSequence)paramString, "_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.name.NameUtils
 * JD-Core Version:    0.7.0.1
 */