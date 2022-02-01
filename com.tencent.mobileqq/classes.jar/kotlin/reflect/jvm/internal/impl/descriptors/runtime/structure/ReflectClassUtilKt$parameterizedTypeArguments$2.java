package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import org.jetbrains.annotations.NotNull;

final class ReflectClassUtilKt$parameterizedTypeArguments$2
  extends Lambda
  implements Function1<ParameterizedType, Sequence<? extends Type>>
{
  public static final 2 INSTANCE = new 2();
  
  ReflectClassUtilKt$parameterizedTypeArguments$2()
  {
    super(1);
  }
  
  @NotNull
  public final Sequence<Type> invoke(@NotNull ParameterizedType paramParameterizedType)
  {
    Intrinsics.checkParameterIsNotNull(paramParameterizedType, "it");
    paramParameterizedType = paramParameterizedType.getActualTypeArguments();
    Intrinsics.checkExpressionValueIsNotNull(paramParameterizedType, "it.actualTypeArguments");
    return ArraysKt.asSequence(paramParameterizedType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.parameterizedTypeArguments.2
 * JD-Core Version:    0.7.0.1
 */