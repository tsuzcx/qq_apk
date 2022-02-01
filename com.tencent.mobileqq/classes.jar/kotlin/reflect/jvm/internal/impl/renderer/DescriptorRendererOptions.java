package kotlin.reflect.jvm.internal.impl.renderer;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import org.jetbrains.annotations.NotNull;

public abstract interface DescriptorRendererOptions
{
  @NotNull
  public abstract AnnotationArgumentsRenderingPolicy getAnnotationArgumentsRenderingPolicy();
  
  public abstract boolean getDebugMode();
  
  public abstract boolean getEnhancedTypes();
  
  @NotNull
  public abstract Set<FqName> getExcludedTypeAnnotationClasses();
  
  public abstract void setAnnotationArgumentsRenderingPolicy(@NotNull AnnotationArgumentsRenderingPolicy paramAnnotationArgumentsRenderingPolicy);
  
  public abstract void setClassifierNamePolicy(@NotNull ClassifierNamePolicy paramClassifierNamePolicy);
  
  public abstract void setDebugMode(boolean paramBoolean);
  
  public abstract void setExcludedTypeAnnotationClasses(@NotNull Set<FqName> paramSet);
  
  public abstract void setModifiers(@NotNull Set<? extends DescriptorRendererModifier> paramSet);
  
  public abstract void setParameterNameRenderingPolicy(@NotNull ParameterNameRenderingPolicy paramParameterNameRenderingPolicy);
  
  public abstract void setReceiverAfterName(boolean paramBoolean);
  
  public abstract void setRenderCompanionObjectName(boolean paramBoolean);
  
  public abstract void setStartFromName(boolean paramBoolean);
  
  public abstract void setTextFormat(@NotNull RenderingFormat paramRenderingFormat);
  
  public abstract void setVerbose(boolean paramBoolean);
  
  public abstract void setWithDefinedIn(boolean paramBoolean);
  
  public abstract void setWithoutSuperTypes(boolean paramBoolean);
  
  public abstract void setWithoutTypeParameters(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions
 * JD-Core Version:    0.7.0.1
 */