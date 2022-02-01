package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import org.jetbrains.annotations.Nullable;

final class DeserializedClassDescriptor$primaryConstructor$1
  extends Lambda
  implements Function0<ClassConstructorDescriptor>
{
  DeserializedClassDescriptor$primaryConstructor$1(DeserializedClassDescriptor paramDeserializedClassDescriptor)
  {
    super(0);
  }
  
  @Nullable
  public final ClassConstructorDescriptor invoke()
  {
    return DeserializedClassDescriptor.access$computePrimaryConstructor(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.primaryConstructor.1
 * JD-Core Version:    0.7.0.1
 */