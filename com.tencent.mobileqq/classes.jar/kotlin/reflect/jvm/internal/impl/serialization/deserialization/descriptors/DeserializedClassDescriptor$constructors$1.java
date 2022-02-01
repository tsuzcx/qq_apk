package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import org.jetbrains.annotations.NotNull;

final class DeserializedClassDescriptor$constructors$1
  extends Lambda
  implements Function0<Collection<? extends ClassConstructorDescriptor>>
{
  DeserializedClassDescriptor$constructors$1(DeserializedClassDescriptor paramDeserializedClassDescriptor)
  {
    super(0);
  }
  
  @NotNull
  public final Collection<ClassConstructorDescriptor> invoke()
  {
    return DeserializedClassDescriptor.access$computeConstructors(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.constructors.1
 * JD-Core Version:    0.7.0.1
 */