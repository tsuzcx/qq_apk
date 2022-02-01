package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedPropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.Nullable;

final class MemberDeserializer$loadProperty$3
  extends Lambda
  implements Function0<ConstantValue<?>>
{
  MemberDeserializer$loadProperty$3(MemberDeserializer paramMemberDeserializer, ProtoBuf.Property paramProperty, DeserializedPropertyDescriptor paramDeserializedPropertyDescriptor)
  {
    super(0);
  }
  
  @Nullable
  public final ConstantValue<?> invoke()
  {
    Object localObject = this.this$0;
    localObject = MemberDeserializer.access$asProtoContainer((MemberDeserializer)localObject, MemberDeserializer.access$getC$p((MemberDeserializer)localObject).getContainingDeclaration());
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    AnnotationAndConstantLoader localAnnotationAndConstantLoader = MemberDeserializer.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader();
    ProtoBuf.Property localProperty = this.$proto;
    KotlinType localKotlinType = this.$property.getReturnType();
    Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "property.returnType");
    return (ConstantValue)localAnnotationAndConstantLoader.loadPropertyConstant((ProtoContainer)localObject, localProperty, localKotlinType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.loadProperty.3
 * JD-Core Version:    0.7.0.1
 */