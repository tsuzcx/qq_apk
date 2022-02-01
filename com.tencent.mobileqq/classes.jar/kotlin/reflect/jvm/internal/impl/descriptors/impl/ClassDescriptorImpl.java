package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations.Companion;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ClassDescriptorImpl
  extends ClassDescriptorBase
{
  private Set<ClassConstructorDescriptor> constructors;
  private final ClassKind kind;
  private final Modality modality;
  private ClassConstructorDescriptor primaryConstructor;
  private final TypeConstructor typeConstructor;
  private MemberScope unsubstitutedMemberScope;
  
  public ClassDescriptorImpl(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Name paramName, @NotNull Modality paramModality, @NotNull ClassKind paramClassKind, @NotNull Collection<KotlinType> paramCollection, @NotNull SourceElement paramSourceElement, boolean paramBoolean, @NotNull StorageManager paramStorageManager)
  {
    super(paramStorageManager, paramDeclarationDescriptor, paramName, paramSourceElement, paramBoolean);
    this.modality = paramModality;
    this.kind = paramClassKind;
    this.typeConstructor = new ClassTypeConstructorImpl(this, Collections.emptyList(), paramCollection, paramStorageManager);
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    Annotations localAnnotations = Annotations.Companion.getEMPTY();
    if (localAnnotations == null) {
      $$$reportNull$$$0(9);
    }
    return localAnnotations;
  }
  
  @Nullable
  public ClassDescriptor getCompanionObjectDescriptor()
  {
    return null;
  }
  
  @NotNull
  public Collection<ClassConstructorDescriptor> getConstructors()
  {
    Set localSet = this.constructors;
    if (localSet == null) {
      $$$reportNull$$$0(11);
    }
    return localSet;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getDeclaredTypeParameters()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      $$$reportNull$$$0(18);
    }
    return localList;
  }
  
  @NotNull
  public ClassKind getKind()
  {
    ClassKind localClassKind = this.kind;
    if (localClassKind == null) {
      $$$reportNull$$$0(15);
    }
    return localClassKind;
  }
  
  @NotNull
  public Modality getModality()
  {
    Modality localModality = this.modality;
    if (localModality == null) {
      $$$reportNull$$$0(16);
    }
    return localModality;
  }
  
  @NotNull
  public Collection<ClassDescriptor> getSealedSubclasses()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      $$$reportNull$$$0(19);
    }
    return localList;
  }
  
  @NotNull
  public MemberScope getStaticScope()
  {
    MemberScope.Empty localEmpty = MemberScope.Empty.INSTANCE;
    if (localEmpty == null) {
      $$$reportNull$$$0(14);
    }
    return localEmpty;
  }
  
  @NotNull
  public TypeConstructor getTypeConstructor()
  {
    TypeConstructor localTypeConstructor = this.typeConstructor;
    if (localTypeConstructor == null) {
      $$$reportNull$$$0(10);
    }
    return localTypeConstructor;
  }
  
  @NotNull
  public MemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    if (paramKotlinTypeRefiner == null) {
      $$$reportNull$$$0(12);
    }
    paramKotlinTypeRefiner = this.unsubstitutedMemberScope;
    if (paramKotlinTypeRefiner == null) {
      $$$reportNull$$$0(13);
    }
    return paramKotlinTypeRefiner;
  }
  
  public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor()
  {
    return this.primaryConstructor;
  }
  
  @NotNull
  public Visibility getVisibility()
  {
    Visibility localVisibility = Visibilities.PUBLIC;
    if (localVisibility == null) {
      $$$reportNull$$$0(17);
    }
    return localVisibility;
  }
  
  public final void initialize(@NotNull MemberScope paramMemberScope, @NotNull Set<ClassConstructorDescriptor> paramSet, @Nullable ClassConstructorDescriptor paramClassConstructorDescriptor)
  {
    if (paramMemberScope == null) {
      $$$reportNull$$$0(7);
    }
    if (paramSet == null) {
      $$$reportNull$$$0(8);
    }
    this.unsubstitutedMemberScope = paramMemberScope;
    this.constructors = paramSet;
    this.primaryConstructor = paramClassConstructorDescriptor;
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
  
  public boolean isInline()
  {
    return false;
  }
  
  public boolean isInner()
  {
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("class ");
    localStringBuilder.append(getName());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ClassDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */