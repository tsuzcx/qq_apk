package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1
  extends Lambda
  implements Function1
{
  public static final 1 INSTANCE = new 1();
  
  KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1()
  {
    super(1);
  }
  
  @Nullable
  public final Void invoke(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "<anonymous parameter 0>");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.EMPTY_REFINED_TYPE_FACTORY.1
 * JD-Core Version:    0.7.0.1
 */