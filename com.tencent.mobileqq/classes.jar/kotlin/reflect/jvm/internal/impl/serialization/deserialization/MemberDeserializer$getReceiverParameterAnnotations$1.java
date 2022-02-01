package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.jetbrains.annotations.NotNull;

final class MemberDeserializer$getReceiverParameterAnnotations$1
  extends Lambda
  implements Function0<List<? extends AnnotationDescriptor>>
{
  MemberDeserializer$getReceiverParameterAnnotations$1(MemberDeserializer paramMemberDeserializer, MessageLite paramMessageLite, AnnotatedCallableKind paramAnnotatedCallableKind)
  {
    super(0);
  }
  
  @NotNull
  public final List<AnnotationDescriptor> invoke()
  {
    Object localObject = this.this$0;
    localObject = MemberDeserializer.access$asProtoContainer((MemberDeserializer)localObject, MemberDeserializer.access$getC$p((MemberDeserializer)localObject).getContainingDeclaration());
    if (localObject != null) {
      localObject = MemberDeserializer.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadExtensionReceiverParameterAnnotations((ProtoContainer)localObject, this.$proto, this.$kind);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      return localObject;
    }
    return CollectionsKt.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.getReceiverParameterAnnotations.1
 * JD-Core Version:    0.7.0.1
 */