package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractTypeParameterDescriptor
  extends DeclarationDescriptorNonRootImpl
  implements TypeParameterDescriptor
{
  private final NotNullLazyValue<SimpleType> defaultType;
  private final int index;
  private final boolean reified;
  private final StorageManager storageManager;
  private final NotNullLazyValue<TypeConstructor> typeConstructor;
  private final Variance variance;
  
  protected AbstractTypeParameterDescriptor(@NotNull StorageManager paramStorageManager, @NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull Variance paramVariance, boolean paramBoolean, int paramInt, @NotNull SourceElement paramSourceElement, @NotNull SupertypeLoopChecker paramSupertypeLoopChecker)
  {
    super(paramDeclarationDescriptor, paramAnnotations, paramName, paramSourceElement);
    this.variance = paramVariance;
    this.reified = paramBoolean;
    this.index = paramInt;
    this.typeConstructor = paramStorageManager.createLazyValue(new AbstractTypeParameterDescriptor.1(this, paramStorageManager, paramSupertypeLoopChecker));
    this.defaultType = paramStorageManager.createLazyValue(new AbstractTypeParameterDescriptor.2(this, paramStorageManager, paramName));
    this.storageManager = paramStorageManager;
  }
  
  public <R, D> R accept(DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    return paramDeclarationDescriptorVisitor.visitTypeParameterDescriptor(this, paramD);
  }
  
  @NotNull
  public SimpleType getDefaultType()
  {
    SimpleType localSimpleType = (SimpleType)this.defaultType.invoke();
    if (localSimpleType == null) {
      $$$reportNull$$$0(10);
    }
    return localSimpleType;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  @NotNull
  public TypeParameterDescriptor getOriginal()
  {
    TypeParameterDescriptor localTypeParameterDescriptor = (TypeParameterDescriptor)super.getOriginal();
    if (localTypeParameterDescriptor == null) {
      $$$reportNull$$$0(11);
    }
    return localTypeParameterDescriptor;
  }
  
  @NotNull
  public StorageManager getStorageManager()
  {
    StorageManager localStorageManager = this.storageManager;
    if (localStorageManager == null) {
      $$$reportNull$$$0(12);
    }
    return localStorageManager;
  }
  
  @NotNull
  public final TypeConstructor getTypeConstructor()
  {
    TypeConstructor localTypeConstructor = (TypeConstructor)this.typeConstructor.invoke();
    if (localTypeConstructor == null) {
      $$$reportNull$$$0(9);
    }
    return localTypeConstructor;
  }
  
  @NotNull
  public List<KotlinType> getUpperBounds()
  {
    List localList = ((AbstractTypeParameterDescriptor.TypeParameterTypeConstructor)getTypeConstructor()).getSupertypes();
    if (localList == null) {
      $$$reportNull$$$0(8);
    }
    return localList;
  }
  
  @NotNull
  public Variance getVariance()
  {
    Variance localVariance = this.variance;
    if (localVariance == null) {
      $$$reportNull$$$0(7);
    }
    return localVariance;
  }
  
  public boolean isCapturedFromOuterDeclaration()
  {
    return false;
  }
  
  public boolean isReified()
  {
    return this.reified;
  }
  
  protected abstract void reportSupertypeLoopError(@NotNull KotlinType paramKotlinType);
  
  @NotNull
  protected abstract List<KotlinType> resolveUpperBounds();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor
 * JD-Core Version:    0.7.0.1
 */