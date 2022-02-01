package kotlin.reflect.jvm.internal.impl.renderer;

import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import org.jetbrains.annotations.NotNull;

public abstract interface DescriptorRenderer$ValueParametersHandler
{
  public abstract void appendAfterValueParameter(@NotNull ValueParameterDescriptor paramValueParameterDescriptor, int paramInt1, int paramInt2, @NotNull StringBuilder paramStringBuilder);
  
  public abstract void appendAfterValueParameters(int paramInt, @NotNull StringBuilder paramStringBuilder);
  
  public abstract void appendBeforeValueParameter(@NotNull ValueParameterDescriptor paramValueParameterDescriptor, int paramInt1, int paramInt2, @NotNull StringBuilder paramStringBuilder);
  
  public abstract void appendBeforeValueParameters(int paramInt, @NotNull StringBuilder paramStringBuilder);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.ValueParametersHandler
 * JD-Core Version:    0.7.0.1
 */