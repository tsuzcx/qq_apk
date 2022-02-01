package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AnnotationDescriptorImpl
  implements AnnotationDescriptor
{
  private final KotlinType annotationType;
  private final SourceElement source;
  private final Map<Name, ConstantValue<?>> valueArguments;
  
  public AnnotationDescriptorImpl(@NotNull KotlinType paramKotlinType, @NotNull Map<Name, ConstantValue<?>> paramMap, @NotNull SourceElement paramSourceElement)
  {
    this.annotationType = paramKotlinType;
    this.valueArguments = paramMap;
    this.source = paramSourceElement;
  }
  
  @NotNull
  public Map<Name, ConstantValue<?>> getAllValueArguments()
  {
    Map localMap = this.valueArguments;
    if (localMap == null) {
      $$$reportNull$$$0(4);
    }
    return localMap;
  }
  
  @Nullable
  public FqName getFqName()
  {
    return AnnotationDescriptor.DefaultImpls.getFqName(this);
  }
  
  @NotNull
  public SourceElement getSource()
  {
    SourceElement localSourceElement = this.source;
    if (localSourceElement == null) {
      $$$reportNull$$$0(5);
    }
    return localSourceElement;
  }
  
  @NotNull
  public KotlinType getType()
  {
    KotlinType localKotlinType = this.annotationType;
    if (localKotlinType == null) {
      $$$reportNull$$$0(3);
    }
    return localKotlinType;
  }
  
  public String toString()
  {
    return DescriptorRenderer.FQ_NAMES_IN_TYPES.renderAnnotation(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */