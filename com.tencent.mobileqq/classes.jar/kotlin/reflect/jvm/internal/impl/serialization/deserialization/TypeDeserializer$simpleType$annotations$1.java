package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type;
import org.jetbrains.annotations.NotNull;

final class TypeDeserializer$simpleType$annotations$1
  extends Lambda
  implements Function0<List<? extends AnnotationDescriptor>>
{
  TypeDeserializer$simpleType$annotations$1(TypeDeserializer paramTypeDeserializer, ProtoBuf.Type paramType)
  {
    super(0);
  }
  
  @NotNull
  public final List<AnnotationDescriptor> invoke()
  {
    return TypeDeserializer.access$getC$p(this.this$0).getComponents().getAnnotationAndConstantLoader().loadTypeAnnotations(this.$proto, TypeDeserializer.access$getC$p(this.this$0).getNameResolver());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.simpleType.annotations.1
 * JD-Core Version:    0.7.0.1
 */