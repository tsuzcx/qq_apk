package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.ProtoTypeTableUtilKt;
import org.jetbrains.annotations.NotNull;

final class TypeDeserializer$simpleType$1
  extends Lambda
  implements Function1<ProtoBuf.Type, List<? extends ProtoBuf.Type.Argument>>
{
  TypeDeserializer$simpleType$1(TypeDeserializer paramTypeDeserializer)
  {
    super(1);
  }
  
  @NotNull
  public final List<ProtoBuf.Type.Argument> invoke(@NotNull ProtoBuf.Type paramType)
  {
    Intrinsics.checkParameterIsNotNull(paramType, "$this$collectAllArguments");
    Object localObject = paramType.getArgumentList();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "argumentList");
    localObject = (Collection)localObject;
    paramType = ProtoTypeTableUtilKt.outerType(paramType, TypeDeserializer.access$getC$p(this.this$0).getTypeTable());
    if (paramType != null) {
      paramType = invoke(paramType);
    } else {
      paramType = null;
    }
    if (paramType == null) {
      paramType = CollectionsKt.emptyList();
    }
    return CollectionsKt.plus((Collection)localObject, (Iterable)paramType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.simpleType.1
 * JD-Core Version:    0.7.0.1
 */