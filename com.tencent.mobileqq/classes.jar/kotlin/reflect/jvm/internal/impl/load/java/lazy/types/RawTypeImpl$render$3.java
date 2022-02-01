package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

final class RawTypeImpl$render$3
  extends Lambda
  implements Function2<String, String, String>
{
  public static final 3 INSTANCE = new 3();
  
  RawTypeImpl$render$3()
  {
    super(2);
  }
  
  @NotNull
  public final String invoke(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "$this$replaceArgs");
    Intrinsics.checkParameterIsNotNull(paramString2, "newArgs");
    if (!StringsKt.contains$default((CharSequence)paramString1, '<', false, 2, null)) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringsKt.substringBefore$default(paramString1, '<', null, 2, null));
    localStringBuilder.append('<');
    localStringBuilder.append(paramString2);
    localStringBuilder.append('>');
    localStringBuilder.append(StringsKt.substringAfterLast$default(paramString1, '>', null, 2, null));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl.render.3
 * JD-Core Version:    0.7.0.1
 */