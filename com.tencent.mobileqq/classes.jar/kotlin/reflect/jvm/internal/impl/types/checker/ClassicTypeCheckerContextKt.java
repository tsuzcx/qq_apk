package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

public final class ClassicTypeCheckerContextKt
{
  private static final String errorMessage(@NotNull Object paramObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClassicTypeCheckerContext couldn't handle ");
    localStringBuilder.append(Reflection.getOrCreateKotlinClass(paramObject.getClass()));
    localStringBuilder.append(' ');
    localStringBuilder.append(paramObject);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.ClassicTypeCheckerContextKt
 * JD-Core Version:    0.7.0.1
 */