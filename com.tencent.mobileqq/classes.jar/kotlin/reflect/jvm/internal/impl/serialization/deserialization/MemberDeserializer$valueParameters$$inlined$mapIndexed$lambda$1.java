package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;

final class MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1
  extends Lambda
  implements Function0<List<? extends AnnotationDescriptor>>
{
  MemberDeserializer$valueParameters$$inlined$mapIndexed$lambda$1(int paramInt, ProtoBuf.ValueParameter paramValueParameter, MemberDeserializer paramMemberDeserializer, ProtoContainer paramProtoContainer, MessageLite paramMessageLite, AnnotatedCallableKind paramAnnotatedCallableKind, CallableDescriptor paramCallableDescriptor)
  {
    super(0);
  }
  
  @NotNull
  public final List<AnnotationDescriptor> invoke()
  {
    return CollectionsKt.toList((Iterable)MemberDeserializer.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadValueParameterAnnotations(this.$containerOfCallable$inlined, this.$callable$inlined, this.$kind$inlined, this.$i, this.$proto));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.valueParameters..inlined.mapIndexed.lambda.1
 * JD-Core Version:    0.7.0.1
 */