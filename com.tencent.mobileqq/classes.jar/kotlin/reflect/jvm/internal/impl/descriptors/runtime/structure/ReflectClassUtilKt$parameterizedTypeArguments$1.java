package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class ReflectClassUtilKt$parameterizedTypeArguments$1
  extends Lambda
  implements Function1<ParameterizedType, ParameterizedType>
{
  public static final 1 INSTANCE = new 1();
  
  ReflectClassUtilKt$parameterizedTypeArguments$1()
  {
    super(1);
  }
  
  @Nullable
  public final ParameterizedType invoke(@NotNull ParameterizedType paramParameterizedType)
  {
    Intrinsics.checkParameterIsNotNull(paramParameterizedType, "it");
    Type localType = paramParameterizedType.getOwnerType();
    paramParameterizedType = localType;
    if (!(localType instanceof ParameterizedType)) {
      paramParameterizedType = null;
    }
    return (ParameterizedType)paramParameterizedType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt.parameterizedTypeArguments.1
 * JD-Core Version:    0.7.0.1
 */