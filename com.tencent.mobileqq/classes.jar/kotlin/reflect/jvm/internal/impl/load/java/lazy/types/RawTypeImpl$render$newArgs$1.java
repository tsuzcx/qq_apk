package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

final class RawTypeImpl$render$newArgs$1
  extends Lambda
  implements Function1<String, String>
{
  public static final 1 INSTANCE = new 1();
  
  RawTypeImpl$render$newArgs$1()
  {
    super(1);
  }
  
  @NotNull
  public final String invoke(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "it");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(raw) ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl.render.newArgs.1
 * JD-Core Version:    0.7.0.1
 */