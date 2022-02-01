package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

final class DeserializedClassDescriptor$sealedSubclasses$1
  extends Lambda
  implements Function0<Collection<? extends ClassDescriptor>>
{
  DeserializedClassDescriptor$sealedSubclasses$1(DeserializedClassDescriptor paramDeserializedClassDescriptor)
  {
    super(0);
  }
  
  @NotNull
  public final Collection<ClassDescriptor> invoke()
  {
    return DeserializedClassDescriptor.access$computeSubclassesForSealedClass(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.sealedSubclasses.1
 * JD-Core Version:    0.7.0.1
 */