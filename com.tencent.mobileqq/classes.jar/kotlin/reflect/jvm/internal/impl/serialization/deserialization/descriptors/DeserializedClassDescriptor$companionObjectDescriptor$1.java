package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.Nullable;

final class DeserializedClassDescriptor$companionObjectDescriptor$1
  extends Lambda
  implements Function0<ClassDescriptor>
{
  DeserializedClassDescriptor$companionObjectDescriptor$1(DeserializedClassDescriptor paramDeserializedClassDescriptor)
  {
    super(0);
  }
  
  @Nullable
  public final ClassDescriptor invoke()
  {
    return DeserializedClassDescriptor.access$computeCompanionObjectDescriptor(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedClassDescriptor.companionObjectDescriptor.1
 * JD-Core Version:    0.7.0.1
 */