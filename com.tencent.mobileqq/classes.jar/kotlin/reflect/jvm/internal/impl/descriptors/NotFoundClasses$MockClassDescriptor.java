package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorBase;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class NotFoundClasses$MockClassDescriptor
  extends ClassDescriptorBase
{
  private final boolean isInner;
  private final ClassTypeConstructorImpl typeConstructor;
  private final List<TypeParameterDescriptor> typeParameters;
  
  public NotFoundClasses$MockClassDescriptor(@NotNull StorageManager paramStorageManager, @NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Name paramName, boolean paramBoolean, int paramInt)
  {
    super(paramStorageManager, paramDeclarationDescriptor, paramName, SourceElement.NO_SOURCE, false);
    this.isInner = paramBoolean;
    paramName = (Iterable)RangesKt.until(0, paramInt);
    paramDeclarationDescriptor = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault(paramName, 10));
    paramName = paramName.iterator();
    while (paramName.hasNext())
    {
      paramInt = ((IntIterator)paramName).nextInt();
      DeclarationDescriptor localDeclarationDescriptor = (DeclarationDescriptor)this;
      Annotations localAnnotations = Annotations.Companion.getEMPTY();
      Variance localVariance = Variance.INVARIANT;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append('T');
      localStringBuilder.append(paramInt);
      paramDeclarationDescriptor.add(TypeParameterDescriptorImpl.createWithDefaultBound(localDeclarationDescriptor, localAnnotations, false, localVariance, Name.identifier(localStringBuilder.toString()), paramInt, paramStorageManager));
    }
    this.typeParameters = ((List)paramDeclarationDescriptor);
    this.typeConstructor = new ClassTypeConstructorImpl((ClassDescriptor)this, this.typeParameters, (Collection)SetsKt.setOf(DescriptorUtilsKt.getModule(this).getBuiltIns().getAnyType()), paramStorageManager);
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    return Annotations.Companion.getEMPTY();
  }
  
  @Nullable
  public ClassDescriptor getCompanionObjectDescriptor()
  {
    return null;
  }
  
  @NotNull
  public Collection<ClassConstructorDescriptor> getConstructors()
  {
    return (Collection)SetsKt.emptySet();
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getDeclaredTypeParameters()
  {
    return this.typeParameters;
  }
  
  @NotNull
  public ClassKind getKind()
  {
    return ClassKind.CLASS;
  }
  
  @NotNull
  public Modality getModality()
  {
    return Modality.FINAL;
  }
  
  @NotNull
  public Collection<ClassDescriptor> getSealedSubclasses()
  {
    return (Collection)CollectionsKt.emptyList();
  }
  
  @NotNull
  public MemberScope.Empty getStaticScope()
  {
    return MemberScope.Empty.INSTANCE;
  }
  
  @NotNull
  public ClassTypeConstructorImpl getTypeConstructor()
  {
    return this.typeConstructor;
  }
  
  @NotNull
  protected MemberScope.Empty getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return MemberScope.Empty.INSTANCE;
  }
  
  @Nullable
  public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor()
  {
    return null;
  }
  
  @NotNull
  public Visibility getVisibility()
  {
    Visibility localVisibility = Visibilities.PUBLIC;
    Intrinsics.checkExpressionValueIsNotNull(localVisibility, "Visibilities.PUBLIC");
    return localVisibility;
  }
  
  public boolean isActual()
  {
    return false;
  }
  
  public boolean isCompanionObject()
  {
    return false;
  }
  
  public boolean isData()
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
  
  public boolean isInline()
  {
    return false;
  }
  
  public boolean isInner()
  {
    return this.isInner;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ");
    localStringBuilder.append(getName());
    localStringBuilder.append(" (not found)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses.MockClassDescriptor
 * JD-Core Version:    0.7.0.1
 */