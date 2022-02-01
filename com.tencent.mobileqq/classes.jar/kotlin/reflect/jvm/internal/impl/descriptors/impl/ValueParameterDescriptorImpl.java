package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor.DefaultImpls;
import kotlin.reflect.jvm.internal.impl.descriptors.VariableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ValueParameterDescriptorImpl
  extends VariableDescriptorImpl
  implements ValueParameterDescriptor
{
  public static final ValueParameterDescriptorImpl.Companion Companion = new ValueParameterDescriptorImpl.Companion(null);
  private final boolean declaresDefaultValue;
  private final int index;
  private final boolean isCrossinline;
  private final boolean isNoinline;
  private final ValueParameterDescriptor original;
  @Nullable
  private final KotlinType varargElementType;
  
  public ValueParameterDescriptorImpl(@NotNull CallableDescriptor paramCallableDescriptor, @Nullable ValueParameterDescriptor paramValueParameterDescriptor, int paramInt, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull KotlinType paramKotlinType1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @Nullable KotlinType paramKotlinType2, @NotNull SourceElement paramSourceElement)
  {
    super((DeclarationDescriptor)paramCallableDescriptor, paramAnnotations, paramName, paramKotlinType1, paramSourceElement);
    this.index = paramInt;
    this.declaresDefaultValue = paramBoolean1;
    this.isCrossinline = paramBoolean2;
    this.isNoinline = paramBoolean3;
    this.varargElementType = paramKotlinType2;
    if (paramValueParameterDescriptor == null) {
      paramValueParameterDescriptor = (ValueParameterDescriptor)this;
    }
    this.original = paramValueParameterDescriptor;
  }
  
  @JvmStatic
  @NotNull
  public static final ValueParameterDescriptorImpl createWithDestructuringDeclarations(@NotNull CallableDescriptor paramCallableDescriptor, @Nullable ValueParameterDescriptor paramValueParameterDescriptor, int paramInt, @NotNull Annotations paramAnnotations, @NotNull Name paramName, @NotNull KotlinType paramKotlinType1, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @Nullable KotlinType paramKotlinType2, @NotNull SourceElement paramSourceElement, @Nullable Function0<? extends List<? extends VariableDescriptor>> paramFunction0)
  {
    return Companion.createWithDestructuringDeclarations(paramCallableDescriptor, paramValueParameterDescriptor, paramInt, paramAnnotations, paramName, paramKotlinType1, paramBoolean1, paramBoolean2, paramBoolean3, paramKotlinType2, paramSourceElement, paramFunction0);
  }
  
  public <R, D> R accept(@NotNull DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptorVisitor, "visitor");
    return paramDeclarationDescriptorVisitor.visitValueParameterDescriptor((ValueParameterDescriptor)this, paramD);
  }
  
  @NotNull
  public ValueParameterDescriptor copy(@NotNull CallableDescriptor paramCallableDescriptor, @NotNull Name paramName, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor, "newOwner");
    Intrinsics.checkParameterIsNotNull(paramName, "newName");
    Annotations localAnnotations = getAnnotations();
    Intrinsics.checkExpressionValueIsNotNull(localAnnotations, "annotations");
    KotlinType localKotlinType1 = getType();
    Intrinsics.checkExpressionValueIsNotNull(localKotlinType1, "type");
    boolean bool1 = declaresDefaultValue();
    boolean bool2 = isCrossinline();
    boolean bool3 = isNoinline();
    KotlinType localKotlinType2 = getVarargElementType();
    SourceElement localSourceElement = SourceElement.NO_SOURCE;
    Intrinsics.checkExpressionValueIsNotNull(localSourceElement, "SourceElement.NO_SOURCE");
    return (ValueParameterDescriptor)new ValueParameterDescriptorImpl(paramCallableDescriptor, null, paramInt, localAnnotations, paramName, localKotlinType1, bool1, bool2, bool3, localKotlinType2, localSourceElement);
  }
  
  public boolean declaresDefaultValue()
  {
    if (this.declaresDefaultValue)
    {
      Object localObject = getContainingDeclaration();
      if (localObject != null)
      {
        localObject = ((CallableMemberDescriptor)localObject).getKind();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "(containingDeclaration a…bleMemberDescriptor).kind");
        if (((CallableMemberDescriptor.Kind)localObject).isReal()) {
          return true;
        }
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableMemberDescriptor");
      }
    }
    return false;
  }
  
  @Nullable
  public Void getCompileTimeInitializer()
  {
    return null;
  }
  
  @NotNull
  public CallableDescriptor getContainingDeclaration()
  {
    DeclarationDescriptor localDeclarationDescriptor = super.getContainingDeclaration();
    if (localDeclarationDescriptor != null) {
      return (CallableDescriptor)localDeclarationDescriptor;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  @NotNull
  public ValueParameterDescriptor getOriginal()
  {
    ValueParameterDescriptor localValueParameterDescriptor = this.original;
    if (localValueParameterDescriptor == (ValueParameterDescriptorImpl)this) {
      return (ValueParameterDescriptor)this;
    }
    return localValueParameterDescriptor.getOriginal();
  }
  
  @NotNull
  public Collection<ValueParameterDescriptor> getOverriddenDescriptors()
  {
    Collection localCollection = getContainingDeclaration().getOverriddenDescriptors();
    Intrinsics.checkExpressionValueIsNotNull(localCollection, "containingDeclaration.overriddenDescriptors");
    Object localObject = (Iterable)localCollection;
    localCollection = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      CallableDescriptor localCallableDescriptor = (CallableDescriptor)((Iterator)localObject).next();
      Intrinsics.checkExpressionValueIsNotNull(localCallableDescriptor, "it");
      localCollection.add((ValueParameterDescriptor)localCallableDescriptor.getValueParameters().get(getIndex()));
    }
    return (Collection)localCollection;
  }
  
  @Nullable
  public KotlinType getVarargElementType()
  {
    return this.varargElementType;
  }
  
  @NotNull
  public Visibility getVisibility()
  {
    Visibility localVisibility = Visibilities.LOCAL;
    Intrinsics.checkExpressionValueIsNotNull(localVisibility, "Visibilities.LOCAL");
    return localVisibility;
  }
  
  public boolean isCrossinline()
  {
    return this.isCrossinline;
  }
  
  public boolean isLateInit()
  {
    return ValueParameterDescriptor.DefaultImpls.isLateInit(this);
  }
  
  public boolean isNoinline()
  {
    return this.isNoinline;
  }
  
  public boolean isVar()
  {
    return false;
  }
  
  @NotNull
  public ValueParameterDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeSubstitutor, "substitutor");
    if (paramTypeSubstitutor.isEmpty()) {
      return (ValueParameterDescriptor)this;
    }
    throw ((Throwable)new UnsupportedOperationException());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */