package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class TypeDeserializer$typeConstructor$1$typeParametersCount$1
  extends Lambda
  implements Function1<ProtoBuf.Type, ProtoBuf.Type>
{
  TypeDeserializer$typeConstructor$1$typeParametersCount$1(TypeDeserializer.typeConstructor.1 param1)
  {
    super(1);
  }
  
  @Nullable
  public final ProtoBuf.Type invoke(@NotNull ProtoBuf.Type paramType)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "it");
    return ProtoTypeTableUtilKt.outerType(paramType, TypeDeserializer.access$getC$p(this.this$0.this$0).getTypeTable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.typeConstructor.1.typeParametersCount.1
 * JD-Core Version:    0.7.0.1
 */