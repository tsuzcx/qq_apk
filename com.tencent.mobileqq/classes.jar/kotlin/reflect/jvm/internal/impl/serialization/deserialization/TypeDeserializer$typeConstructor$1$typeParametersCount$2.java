package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import org.jetbrains.annotations.NotNull;

final class TypeDeserializer$typeConstructor$1$typeParametersCount$2
  extends Lambda
  implements Function1<ProtoBuf.Type, Integer>
{
  public static final 2 INSTANCE = new 2();
  
  TypeDeserializer$typeConstructor$1$typeParametersCount$2()
  {
    super(1);
  }
  
  public final int invoke(@NotNull ProtoBuf.Type paramType)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "it");
    return paramType.getArgumentCount();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.typeConstructor.1.typeParametersCount.2
 * JD-Core Version:    0.7.0.1
 */