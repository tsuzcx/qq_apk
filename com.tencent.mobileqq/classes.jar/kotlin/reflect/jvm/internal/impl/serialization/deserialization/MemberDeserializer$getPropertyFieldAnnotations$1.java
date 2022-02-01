package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property;
import org.jetbrains.annotations.NotNull;

final class MemberDeserializer$getPropertyFieldAnnotations$1
  extends Lambda
  implements Function0<List<? extends AnnotationDescriptor>>
{
  MemberDeserializer$getPropertyFieldAnnotations$1(MemberDeserializer paramMemberDeserializer, boolean paramBoolean, ProtoBuf.Property paramProperty)
  {
    super(0);
  }
  
  @NotNull
  public final List<AnnotationDescriptor> invoke()
  {
    Object localObject = this.this$0;
    localObject = MemberDeserializer.access$asProtoContainer((MemberDeserializer)localObject, MemberDeserializer.access$getC$p((MemberDeserializer)localObject).getContainingDeclaration());
    if (localObject != null)
    {
      if (this.$isDelegate) {
        localObject = CollectionsKt.toList((Iterable)MemberDeserializer.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadPropertyDelegateFieldAnnotations((ProtoContainer)localObject, this.$proto));
      } else {
        localObject = CollectionsKt.toList((Iterable)MemberDeserializer.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadPropertyBackingFieldAnnotations((ProtoContainer)localObject, this.$proto));
      }
    }
    else {
      localObject = null;
    }
    if (localObject != null) {
      return localObject;
    }
    return CollectionsKt.emptyList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer.getPropertyFieldAnnotations.1
 * JD-Core Version:    0.7.0.1
 */