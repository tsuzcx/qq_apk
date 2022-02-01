package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;

public final class EnumEntry
  extends JavaDefaultValue
{
  @NotNull
  private final ClassDescriptor descriptor;
  
  public EnumEntry(@NotNull ClassDescriptor paramClassDescriptor)
  {
    super(null);
    this.descriptor = paramClassDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.EnumEntry
 * JD-Core Version:    0.7.0.1
 */