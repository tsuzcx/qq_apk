package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;

public final class DescriptorRenderer$ValueParametersHandler$DEFAULT
  implements DescriptorRenderer.ValueParametersHandler
{
  public static final DEFAULT INSTANCE = new DEFAULT();
  
  public void appendAfterValueParameter(@NotNull ValueParameterDescriptor paramValueParameterDescriptor, int paramInt1, int paramInt2, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramValueParameterDescriptor, "parameter");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    if (paramInt1 != paramInt2 - 1) {
      paramStringBuilder.append(", ");
    }
  }
  
  public void appendAfterValueParameters(int paramInt, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    paramStringBuilder.append(")");
  }
  
  public void appendBeforeValueParameter(@NotNull ValueParameterDescriptor paramValueParameterDescriptor, int paramInt1, int paramInt2, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramValueParameterDescriptor, "parameter");
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
  }
  
  public void appendBeforeValueParameters(int paramInt, @NotNull StringBuilder paramStringBuilder)
  {
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "builder");
    paramStringBuilder.append("(");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler.DEFAULT
 * JD-Core Version:    0.7.0.1
 */