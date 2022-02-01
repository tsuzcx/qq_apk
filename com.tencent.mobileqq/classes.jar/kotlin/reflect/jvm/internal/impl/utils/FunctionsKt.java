package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;

public final class FunctionsKt
{
  private static final Function1<Object, Object> ALWAYS_NULL = (Function1)FunctionsKt.ALWAYS_NULL.1.INSTANCE;
  private static final Function1<Object, Boolean> ALWAYS_TRUE;
  @NotNull
  private static final Function1<Object, Unit> DO_NOTHING = (Function1)FunctionsKt.DO_NOTHING.1.INSTANCE;
  @NotNull
  private static final Function2<Object, Object, Unit> DO_NOTHING_2 = (Function2)FunctionsKt.DO_NOTHING_2.1.INSTANCE;
  @NotNull
  private static final Function3<Object, Object, Object, Unit> DO_NOTHING_3 = (Function3)FunctionsKt.DO_NOTHING_3.1.INSTANCE;
  private static final Function1<Object, Object> IDENTITY = (Function1)FunctionsKt.IDENTITY.1.INSTANCE;
  
  static
  {
    ALWAYS_TRUE = (Function1)FunctionsKt.ALWAYS_TRUE.1.INSTANCE;
  }
  
  @NotNull
  public static final <T> Function1<T, Boolean> alwaysTrue()
  {
    return ALWAYS_TRUE;
  }
  
  @NotNull
  public static final Function3<Object, Object, Object, Unit> getDO_NOTHING_3()
  {
    return DO_NOTHING_3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.FunctionsKt
 * JD-Core Version:    0.7.0.1
 */