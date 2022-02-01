package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorWithSource;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractTypeAliasDescriptor
  extends DeclarationDescriptorNonRootImpl
  implements TypeAliasDescriptor
{
  private List<? extends TypeParameterDescriptor> declaredTypeParametersImpl;
  private final AbstractTypeAliasDescriptor.typeConstructor.1 typeConstructor;
  private final Visibility visibilityImpl;
  
  public AbstractTypeAliasDescriptor(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull SourceElement paramSourceElement, @NotNull Visibility paramVisibility)
  {
    super(paramDeclarationDescriptor, paramAnnotations, paramName, paramSourceElement);
    this.visibilityImpl = paramVisibility;
    this.typeConstructor = new AbstractTypeAliasDescriptor.typeConstructor.1(this);
  }
  
  public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptorVisitor, "visitor");
    return paramDeclarationDescriptorVisitor.visitTypeAliasDescriptor((TypeAliasDescriptor)this, paramD);
  }
  
  @NotNull
  protected final SimpleType computeDefaultType()
  {
    ClassifierDescriptor localClassifierDescriptor = (ClassifierDescriptor)this;
    Object localObject = getClassDescriptor();
    if (localObject != null)
    {
      localObject = ((ClassDescriptor)localObject).getUnsubstitutedMemberScope();
      if (localObject != null) {}
    }
    else
    {
      localObject = (MemberScope)MemberScope.Empty.INSTANCE;
    }
    localObject = TypeUtils.makeUnsubstitutedType(localClassifierDescriptor, (MemberScope)localObject, (Function1)new AbstractTypeAliasDescriptor.computeDefaultType.1(this));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "TypeUtils.makeUnsubstitu…s)?.defaultType\n        }");
    return localObject;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getDeclaredTypeParameters()
  {
    List localList = this.declaredTypeParametersImpl;
    if (localList == null) {
      Intrinsics.throwUninitializedPropertyAccessException("declaredTypeParametersImpl");
    }
    return localList;
  }
  
  @NotNull
  public Modality getModality()
  {
    return Modality.FINAL;
  }
  
  @NotNull
  public TypeAliasDescriptor getOriginal()
  {
    DeclarationDescriptorWithSource localDeclarationDescriptorWithSource = super.getOriginal();
    if (localDeclarationDescriptorWithSource != null) {
      return (TypeAliasDescriptor)localDeclarationDescriptorWithSource;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeAliasDescriptor");
  }
  
  @NotNull
  protected abstract StorageManager getStorageManager();
  
  @NotNull
  public final Collection<TypeAliasConstructorDescriptor> getTypeAliasConstructors()
  {
    Object localObject1 = getClassDescriptor();
    if (localObject1 != null)
    {
      localObject1 = ((ClassDescriptor)localObject1).getConstructors();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "classDescriptor.constructors");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (ClassConstructorDescriptor)((Iterator)localObject2).next();
        TypeAliasConstructorDescriptorImpl.Companion localCompanion = TypeAliasConstructorDescriptorImpl.Companion;
        StorageManager localStorageManager = getStorageManager();
        TypeAliasDescriptor localTypeAliasDescriptor = (TypeAliasDescriptor)this;
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "it");
        localObject3 = localCompanion.createIfAvailable(localStorageManager, localTypeAliasDescriptor, (ClassConstructorDescriptor)localObject3);
        if (localObject3 != null) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      return (Collection)localObject1;
    }
    return (Collection)CollectionsKt.emptyList();
  }
  
  @NotNull
  public TypeConstructor getTypeConstructor()
  {
    return (TypeConstructor)this.typeConstructor;
  }
  
  @NotNull
  protected abstract List<TypeParameterDescriptor> getTypeConstructorTypeParameters();
  
  @NotNull
  public Visibility getVisibility()
  {
    return this.visibilityImpl;
  }
  
  public final void initialize(@NotNull List<? extends TypeParameterDescriptor> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "declaredTypeParameters");
    this.declaredTypeParametersImpl = paramList;
  }
  
  public boolean isActual()
  {
    return false;
  }
  
  public boolean isExpect()
  {
    return false;
  }
  
  public boolean isExternal()
  {
    return false;
  }
  
  public boolean isInner()
  {
    return TypeUtils.contains((KotlinType)getUnderlyingType(), (Function1)new AbstractTypeAliasDescriptor.isInner.1(this));
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("typealias ");
    localStringBuilder.append(getName().asString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractTypeAliasDescriptor
 * JD-Core Version:    0.7.0.1
 */