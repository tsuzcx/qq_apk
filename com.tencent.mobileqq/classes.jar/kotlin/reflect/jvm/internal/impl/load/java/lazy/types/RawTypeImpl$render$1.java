package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

final class RawTypeImpl$render$1
  extends Lambda
  implements Function2<String, String, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  RawTypeImpl$render$1()
  {
    super(2);
  }
  
  public final boolean invoke(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "first");
    Intrinsics.checkParameterIsNotNull(paramString2, "second");
    return (Intrinsics.areEqual(paramString1, StringsKt.removePrefix(paramString2, (CharSequence)"out "))) || (Intrinsics.areEqual(paramString2, "*"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl.render.1
 * JD-Core Version:    0.7.0.1
 */