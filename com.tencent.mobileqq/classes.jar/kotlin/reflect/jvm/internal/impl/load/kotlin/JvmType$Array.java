package kotlin.reflect.jvm.internal.impl.load.kotlin;

import org.jetbrains.annotations.NotNull;

public final class JvmType$Array
  extends JvmType
{
  @NotNull
  private final JvmType elementType;
  
  public JvmType$Array(@NotNull JvmType paramJvmType)
  {
    super(null);
    this.elementType = paramJvmType;
  }
  
  @NotNull
  public final JvmType getElementType()
  {
    return this.elementType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType.Array
 * JD-Core Version:    0.7.0.1
 */