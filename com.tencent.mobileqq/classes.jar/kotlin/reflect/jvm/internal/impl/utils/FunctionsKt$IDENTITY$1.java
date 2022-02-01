package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

final class FunctionsKt$IDENTITY$1
  extends Lambda
  implements Function1<Object, Object>
{
  public static final 1 INSTANCE = new 1();
  
  FunctionsKt$IDENTITY$1()
  {
    super(1);
  }
  
  @Nullable
  public final Object invoke(@Nullable Object paramObject)
  {
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.FunctionsKt.IDENTITY.1
 * JD-Core Version:    0.7.0.1
 */