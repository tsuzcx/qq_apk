package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.Nullable;

final class TypeDeserializer$classDescriptors$1
  extends Lambda
  implements Function1<Integer, ClassDescriptor>
{
  TypeDeserializer$classDescriptors$1(TypeDeserializer paramTypeDeserializer)
  {
    super(1);
  }
  
  @Nullable
  public final ClassDescriptor invoke(int paramInt)
  {
    return TypeDeserializer.access$computeClassDescriptor(this.this$0, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer.classDescriptors.1
 * JD-Core Version:    0.7.0.1
 */