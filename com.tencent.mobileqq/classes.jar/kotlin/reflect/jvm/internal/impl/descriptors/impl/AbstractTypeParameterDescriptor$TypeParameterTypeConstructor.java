package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class AbstractTypeParameterDescriptor$TypeParameterTypeConstructor
  extends AbstractTypeConstructor
{
  private final SupertypeLoopChecker supertypeLoopChecker;
  
  public AbstractTypeParameterDescriptor$TypeParameterTypeConstructor(AbstractTypeParameterDescriptor paramAbstractTypeParameterDescriptor, @NotNull StorageManager paramStorageManager, SupertypeLoopChecker paramSupertypeLoopChecker)
  {
    super(paramStorageManager);
    this.supertypeLoopChecker = paramSupertypeLoopChecker;
  }
  
  @NotNull
  protected Collection<KotlinType> computeSupertypes()
  {
    List localList = this.this$0.resolveUpperBounds();
    if (localList == null) {
      $$$reportNull$$$0(1);
    }
    return localList;
  }
  
  @Nullable
  protected KotlinType defaultSupertypeIfEmpty()
  {
    return ErrorUtils.createErrorType("Cyclic upper bounds");
  }
  
  @NotNull
  public KotlinBuiltIns getBuiltIns()
  {
    KotlinBuiltIns localKotlinBuiltIns = DescriptorUtilsKt.getBuiltIns(this.this$0);
    if (localKotlinBuiltIns == null) {
      $$$reportNull$$$0(4);
    }
    return localKotlinBuiltIns;
  }
  
  @NotNull
  public ClassifierDescriptor getDeclarationDescriptor()
  {
    AbstractTypeParameterDescriptor localAbstractTypeParameterDescriptor = this.this$0;
    if (localAbstractTypeParameterDescriptor == null) {
      $$$reportNull$$$0(3);
    }
    return localAbstractTypeParameterDescriptor;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getParameters()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      $$$reportNull$$$0(2);
    }
    return localList;
  }
  
  @NotNull
  protected SupertypeLoopChecker getSupertypeLoopChecker()
  {
    SupertypeLoopChecker localSupertypeLoopChecker = this.supertypeLoopChecker;
    if (localSupertypeLoopChecker == null) {
      $$$reportNull$$$0(5);
    }
    return localSupertypeLoopChecker;
  }
  
  public boolean isDenotable()
  {
    return true;
  }
  
  protected void reportSupertypeLoopError(@NotNull KotlinType paramKotlinType)
  {
    if (paramKotlinType == null) {
      $$$reportNull$$$0(6);
    }
    this.this$0.reportSupertypeLoopError(paramKotlinType);
  }
  
  public String toString()
  {
    return this.this$0.getName().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeParameterDescriptor.TypeParameterTypeConstructor
 * JD-Core Version:    0.7.0.1
 */