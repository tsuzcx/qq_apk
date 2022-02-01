package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

final class ClassDeserializer$classes$1
  extends Lambda
  implements Function1<ClassDeserializer.ClassKey, ClassDescriptor>
{
  ClassDeserializer$classes$1(ClassDeserializer paramClassDeserializer)
  {
    super(1);
  }
  
  @Nullable
  public final ClassDescriptor invoke(@NotNull ClassDeserializer.ClassKey paramClassKey)
  {
    Intrinsics.checkParameterIsNotNull(paramClassKey, "key");
    return ClassDeserializer.access$createClass(this.this$0, paramClassKey);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDeserializer.classes.1
 * JD-Core Version:    0.7.0.1
 */