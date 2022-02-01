package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;
import org.jetbrains.annotations.Nullable;

public final class JvmType$Primitive
  extends JvmType
{
  @Nullable
  private final JvmPrimitiveType jvmPrimitiveType;
  
  public JvmType$Primitive(@Nullable JvmPrimitiveType paramJvmPrimitiveType)
  {
    super(null);
    this.jvmPrimitiveType = paramJvmPrimitiveType;
  }
  
  @Nullable
  public final JvmPrimitiveType getJvmPrimitiveType()
  {
    return this.jvmPrimitiveType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Primitive
 * JD-Core Version:    0.7.0.1
 */