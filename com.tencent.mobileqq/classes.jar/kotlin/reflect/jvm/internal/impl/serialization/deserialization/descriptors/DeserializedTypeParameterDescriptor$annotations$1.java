package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationAndConstantLoader;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationComponents;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializationContext;
import org.jetbrains.annotations.NotNull;

final class DeserializedTypeParameterDescriptor$annotations$1
  extends Lambda
  implements Function0<List<? extends AnnotationDescriptor>>
{
  DeserializedTypeParameterDescriptor$annotations$1(DeserializedTypeParameterDescriptor paramDeserializedTypeParameterDescriptor)
  {
    super(0);
  }
  
  @NotNull
  public final List<AnnotationDescriptor> invoke()
  {
    return CollectionsKt.toList((Iterable)DeserializedTypeParameterDescriptor.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadTypeParameterAnnotations(this.this$0.getProto(), DeserializedTypeParameterDescriptor.access$getC$p(this.this$0).getNameResolver()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedTypeParameterDescriptor.annotations.1
 * JD-Core Version:    0.7.0.1
 */