package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class FunctionsKt$ALWAYS_TRUE$1
  extends Lambda
  implements Function1<Object, Boolean>
{
  public static final 1 INSTANCE = new 1();
  
  FunctionsKt$ALWAYS_TRUE$1()
  {
    super(1);
  }
  
  public final boolean invoke(@Nullable Object paramObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.ALWAYS_TRUE.1
 * JD-Core Version:    0.7.0.1
 */