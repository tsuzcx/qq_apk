package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope.Empty;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class EnumEntrySyntheticClassDescriptor
  extends ClassDescriptorBase
{
  private final Annotations annotations;
  private final NotNullLazyValue<Set<Name>> enumMemberNames;
  private final MemberScope scope;
  private final TypeConstructor typeConstructor;
  
  private EnumEntrySyntheticClassDescriptor(@NotNull StorageManager paramStorageManager, @NotNull ClassDescriptor paramClassDescriptor, @NotNull KotlinType paramKotlinType, @NotNull Name paramName, @NotNull NotNullLazyValue<Set<Name>> paramNotNullLazyValue, @NotNull Annotations paramAnnotations, @NotNull SourceElement paramSourceElement)
  {
    super(paramStorageManager, paramClassDescriptor, paramName, paramSourceElement, false);
    this.annotations = paramAnnotations;
    this.typeConstructor = new ClassTypeConstructorImpl(this, Collections.emptyList(), Collections.singleton(paramKotlinType), paramStorageManager);
    this.scope = new EnumEntrySyntheticClassDescriptor.EnumEntryScope(this, paramStorageManager);
    this.enumMemberNames = paramNotNullLazyValue;
  }
  
  @NotNull
  public static EnumEntrySyntheticClassDescriptor create(@NotNull StorageManager paramStorageManager, @NotNull ClassDescriptor paramClassDescriptor, @NotNull Name paramName, @NotNull NotNullLazyValue<Set<Name>> paramNotNullLazyValue, @NotNull Annotations paramAnnotations, @NotNull SourceElement paramSourceElement)
  {
    if (paramStorageManager == null) {
      $$$reportNull$$$0(0);
    }
    if (paramClassDescriptor == null) {
      $$$reportNull$$$0(1);
    }
    if (paramName == null) {
      $$$reportNull$$$0(2);
    }
    if (paramNotNullLazyValue == null) {
      $$$reportNull$$$0(3);
    }
    if (paramAnnotations == null) {
      $$$reportNull$$$0(4);
    }
    if (paramSourceElement == null) {
      $$$reportNull$$$0(5);
    }
    return new EnumEntrySyntheticClassDescriptor(paramStorageManager, paramClassDescriptor, paramClassDescriptor.getDefaultType(), paramName, paramNotNullLazyValue, paramAnnotations, paramSourceElement);
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    Annotations localAnnotations = this.annotations;
    if (localAnnotations == null) {
      $$$reportNull$$$0(21);
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
    List localList = Collections.emptyList();
    if (localList == null) {
      $$$reportNull$$$0(16);
    }
    return localList;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getDeclaredTypeParameters()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      $$$reportNull$$$0(22);
    }
    return localList;
  }
  
  @NotNull
  public ClassKind getKind()
  {
    ClassKind localClassKind = ClassKind.ENUM_ENTRY;
    if (localClassKind == null) {
      $$$reportNull$$$0(18);
    }
    return localClassKind;
  }
  
  @NotNull
  public Modality getModality()
  {
    Modality localModality = Modality.FINAL;
    if (localModality == null) {
      $$$reportNull$$$0(19);
    }
    return localModality;
  }
  
  @NotNull
  public Collection<ClassDescriptor> getSealedSubclasses()
  {
    List localList = Collections.emptyList();
    if (localList == null) {
      $$$reportNull$$$0(23);
    }
    return localList;
  }
  
  @NotNull
  public MemberScope getStaticScope()
  {
    MemberScope.Empty localEmpty = MemberScope.Empty.INSTANCE;
    if (localEmpty == null) {
      $$$reportNull$$$0(15);
    }
    return localEmpty;
  }
  
  @NotNull
  public TypeConstructor getTypeConstructor()
  {
    TypeConstructor localTypeConstructor = this.typeConstructor;
    if (localTypeConstructor == null) {
      $$$reportNull$$$0(17);
    }
    return localTypeConstructor;
  }
  
  @NotNull
  public MemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    if (paramKotlinTypeRefiner == null) {
      $$$reportNull$$$0(13);
    }
    paramKotlinTypeRefiner = this.scope;
    if (paramKotlinTypeRefiner == null) {
      $$$reportNull$$$0(14);
    }
    return paramKotlinTypeRefiner;
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
    if (localVisibility == null) {
      $$$reportNull$$$0(20);
    }
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
    localStringBuilder.append("enum entry ");
    localStringBuilder.append(getName());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.EnumEntrySyntheticClassDescriptor
 * JD-Core Version:    0.7.0.1
 */