package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

final class CapturedTypeParameterDescriptor
  implements TypeParameterDescriptor
{
  private final DeclarationDescriptor declarationDescriptor;
  private final int declaredTypeParametersCount;
  private final TypeParameterDescriptor originalDescriptor;
  
  public CapturedTypeParameterDescriptor(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor, @NotNull DeclarationDescriptor paramDeclarationDescriptor, int paramInt)
  {
    this.originalDescriptor = paramTypeParameterDescriptor;
    this.declarationDescriptor = paramDeclarationDescriptor;
    this.declaredTypeParametersCount = paramInt;
  }
  
  public <R, D> R accept(DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    return this.originalDescriptor.accept(paramDeclarationDescriptorVisitor, paramD);
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return this.originalDescriptor.getAnnotations();
  }
  
  @NotNull
  public DeclarationDescriptor getContainingDeclaration()
  {
    return this.declarationDescriptor;
  }
  
  @NotNull
  public SimpleType getDefaultType()
  {
    return this.originalDescriptor.getDefaultType();
  }
  
  public int getIndex()
  {
    return this.declaredTypeParametersCount + this.originalDescriptor.getIndex();
  }
  
  @NotNull
  public Name getName()
  {
    return this.originalDescriptor.getName();
  }
  
  @NotNull
  public TypeParameterDescriptor getOriginal()
  {
    TypeParameterDescriptor localTypeParameterDescriptor = this.originalDescriptor.getOriginal();
    Intrinsics.checkExpressionValueIsNotNull(localTypeParameterDescriptor, "originalDescriptor.original");
    return localTypeParameterDescriptor;
  }
  
  @NotNull
  public SourceElement getSource()
  {
    return this.originalDescriptor.getSource();
  }
  
  @NotNull
  public StorageManager getStorageManager()
  {
    return this.originalDescriptor.getStorageManager();
  }
  
  @NotNull
  public TypeConstructor getTypeConstructor()
  {
    return this.originalDescriptor.getTypeConstructor();
  }
  
  @NotNull
  public List<KotlinType> getUpperBounds()
  {
    return this.originalDescriptor.getUpperBounds();
  }
  
  @NotNull
  public Variance getVariance()
  {
    return this.originalDescriptor.getVariance();
  }
  
  public boolean isCapturedFromOuterDeclaration()
  {
    return true;
  }
  
  public boolean isReified()
  {
    return this.originalDescriptor.isReified();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.originalDescriptor);
    localStringBuilder.append("[inner-copy]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.CapturedTypeParameterDescriptor
 * JD-Core Version:    0.7.0.1
 */