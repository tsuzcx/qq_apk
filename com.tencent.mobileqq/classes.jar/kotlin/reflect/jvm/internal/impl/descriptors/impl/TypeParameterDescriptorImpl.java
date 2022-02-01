package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker.EMPTY;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TypeParameterDescriptorImpl
  extends AbstractTypeParameterDescriptor
{
  private boolean initialized = false;
  @Nullable
  private final Function1<KotlinType, Void> reportCycleError;
  private final List<KotlinType> upperBounds = new ArrayList(1);
  
  private TypeParameterDescriptorImpl(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, boolean paramBoolean, @NotNull Variance paramVariance, @NotNull Name paramName, int paramInt, @NotNull SourceElement paramSourceElement, @Nullable Function1<KotlinType, Void> paramFunction1, @NotNull SupertypeLoopChecker paramSupertypeLoopChecker, @NotNull StorageManager paramStorageManager)
  {
    super(paramStorageManager, paramDeclarationDescriptor, paramAnnotations, paramName, paramVariance, paramBoolean, paramInt, paramSourceElement, paramSupertypeLoopChecker);
    this.reportCycleError = paramFunction1;
  }
  
  private void checkInitialized()
  {
    if (this.initialized) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Type parameter descriptor is not initialized: ");
    localStringBuilder.append(nameForAssertions());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void checkUninitialized()
  {
    if (!this.initialized) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Type parameter descriptor is already initialized: ");
    localStringBuilder.append(nameForAssertions());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public static TypeParameterDescriptorImpl createForFurtherModification(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, boolean paramBoolean, @NotNull Variance paramVariance, @NotNull Name paramName, int paramInt, @NotNull SourceElement paramSourceElement, @Nullable Function1<KotlinType, Void> paramFunction1, @NotNull SupertypeLoopChecker paramSupertypeLoopChecker, @NotNull StorageManager paramStorageManager)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(12);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(13);
    }
    if (paramVariance == null) {
      $$$reportNull$$$0(14);
    }
    if (paramName == null) {
      $$$reportNull$$$0(15);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(16);
    }
    if (paramSupertypeLoopChecker == null) {
      $$$reportNull$$$0(17);
    }
    if (paramStorageManager == null) {
      $$$reportNull$$$0(18);
    }
    return new TypeParameterDescriptorImpl(paramDeclarationDescriptor, paramAnnotations, paramBoolean, paramVariance, paramName, paramInt, paramSourceElement, paramFunction1, paramSupertypeLoopChecker, paramStorageManager);
  }
  
  public static TypeParameterDescriptorImpl createForFurtherModification(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, boolean paramBoolean, @NotNull Variance paramVariance, @NotNull Name paramName, int paramInt, @NotNull SourceElement paramSourceElement, @NotNull StorageManager paramStorageManager)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(6);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(7);
    }
    if (paramVariance == null) {
      $$$reportNull$$$0(8);
    }
    if (paramName == null) {
      $$$reportNull$$$0(9);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(10);
    }
    if (paramStorageManager == null) {
      $$$reportNull$$$0(11);
    }
    return createForFurtherModification(paramDeclarationDescriptor, paramAnnotations, paramBoolean, paramVariance, paramName, paramInt, paramSourceElement, null, SupertypeLoopChecker.EMPTY.INSTANCE, paramStorageManager);
  }
  
  @NotNull
  public static TypeParameterDescriptor createWithDefaultBound(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, boolean paramBoolean, @NotNull Variance paramVariance, @NotNull Name paramName, int paramInt, @NotNull StorageManager paramStorageManager)
  {
    if (paramDeclarationDescriptor == null) {
      $$$reportNull$$$0(0);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(1);
    }
    if (paramVariance == null) {
      $$$reportNull$$$0(2);
    }
    if (paramName == null) {
      $$$reportNull$$$0(3);
    }
    if (paramStorageManager == null) {
      $$$reportNull$$$0(4);
    }
    paramAnnotations = createForFurtherModification(paramDeclarationDescriptor, paramAnnotations, paramBoolean, paramVariance, paramName, paramInt, SourceElement.NO_SOURCE, paramStorageManager);
    paramAnnotations.addUpperBound(DescriptorUtilsKt.getBuiltIns(paramDeclarationDescriptor).getDefaultBound());
    paramAnnotations.setInitialized();
    if (paramAnnotations == null) {
      $$$reportNull$$$0(5);
    }
    return paramAnnotations;
  }
  
  private void doAddUpperBound(KotlinType paramKotlinType)
  {
    if (KotlinTypeKt.isError(paramKotlinType)) {
      return;
    }
    this.upperBounds.add(paramKotlinType);
  }
  
  private String nameForAssertions()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getName());
    localStringBuilder.append(" declared in ");
    localStringBuilder.append(DescriptorUtils.getFqName(getContainingDeclaration()));
    return localStringBuilder.toString();
  }
  
  public void addUpperBound(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(26);
    }
    checkUninitialized();
    doAddUpperBound(paramKotlinType);
  }
  
  protected void reportSupertypeLoopError(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(27);
    }
    Function1 localFunction1 = this.reportCycleError;
    if (localFunction1 == null) {
      return;
    }
    localFunction1.invoke(paramKotlinType);
  }
  
  @NotNull
  protected List<KotlinType> resolveUpperBounds()
  {
    checkInitialized();
    List localList = this.upperBounds;
    if (localList == null) {
      $$$reportNull$$$0(28);
    }
    return localList;
  }
  
  public void setInitialized()
  {
    checkUninitialized();
    this.initialized = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */