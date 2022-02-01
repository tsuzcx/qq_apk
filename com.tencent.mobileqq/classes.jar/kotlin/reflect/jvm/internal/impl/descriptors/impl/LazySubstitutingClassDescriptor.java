package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.types.ClassTypeConstructorImpl;
import kotlin.reflect.jvm.internal.impl.types.DescriptorSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LazySubstitutingClassDescriptor
  extends ModuleAwareClassDescriptor
{
  private List<TypeParameterDescriptor> declaredTypeParameters;
  private TypeSubstitutor newSubstitutor;
  private final ModuleAwareClassDescriptor original;
  private final TypeSubstitutor originalSubstitutor;
  private TypeConstructor typeConstructor;
  private List<TypeParameterDescriptor> typeConstructorParameters;
  
  public LazySubstitutingClassDescriptor(ModuleAwareClassDescriptor paramModuleAwareClassDescriptor, TypeSubstitutor paramTypeSubstitutor)
  {
    this.original = paramModuleAwareClassDescriptor;
    this.originalSubstitutor = paramTypeSubstitutor;
  }
  
  private TypeSubstitutor getSubstitutor()
  {
    if (this.newSubstitutor == null) {
      if (this.originalSubstitutor.isEmpty())
      {
        this.newSubstitutor = this.originalSubstitutor;
      }
      else
      {
        List localList = this.original.getTypeConstructor().getParameters();
        this.typeConstructorParameters = new ArrayList(localList.size());
        this.newSubstitutor = DescriptorSubstitutor.substituteTypeParameters(localList, this.originalSubstitutor.getSubstitution(), this, this.typeConstructorParameters);
        this.declaredTypeParameters = CollectionsKt.filter(this.typeConstructorParameters, new LazySubstitutingClassDescriptor.1(this));
      }
    }
    return this.newSubstitutor;
  }
  
  public <R, D> R accept(DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    return paramDeclarationDescriptorVisitor.visitClassDescriptor(this, paramD);
  }
  
  @NotNull
  public Annotations getAnnotations()
  {
    Annotations localAnnotations = this.original.getAnnotations();
    if (localAnnotations == null) {
      $$$reportNull$$$0(18);
    }
    return localAnnotations;
  }
  
  public ClassDescriptor getCompanionObjectDescriptor()
  {
    return this.original.getCompanionObjectDescriptor();
  }
  
  @NotNull
  public Collection<ClassConstructorDescriptor> getConstructors()
  {
    Object localObject = this.original.getConstructors();
    ArrayList localArrayList = new ArrayList(((Collection)localObject).size());
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ClassConstructorDescriptor localClassConstructorDescriptor = (ClassConstructorDescriptor)((Iterator)localObject).next();
      localArrayList.add(((ClassConstructorDescriptor)localClassConstructorDescriptor.newCopyBuilder().setOriginal(localClassConstructorDescriptor.getOriginal()).setModality(localClassConstructorDescriptor.getModality()).setVisibility(localClassConstructorDescriptor.getVisibility()).setKind(localClassConstructorDescriptor.getKind()).setCopyOverrides(false).build()).substitute(getSubstitutor()));
    }
    return localArrayList;
  }
  
  @NotNull
  public DeclarationDescriptor getContainingDeclaration()
  {
    DeclarationDescriptor localDeclarationDescriptor = this.original.getContainingDeclaration();
    if (localDeclarationDescriptor == null) {
      $$$reportNull$$$0(21);
    }
    return localDeclarationDescriptor;
  }
  
  @NotNull
  public List<TypeParameterDescriptor> getDeclaredTypeParameters()
  {
    getSubstitutor();
    List localList = this.declaredTypeParameters;
    if (localList == null) {
      $$$reportNull$$$0(29);
    }
    return localList;
  }
  
  @NotNull
  public SimpleType getDefaultType()
  {
    Object localObject = TypeUtils.getDefaultTypeProjections(getTypeConstructor().getParameters());
    localObject = KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(getAnnotations(), getTypeConstructor(), (List)localObject, false, getUnsubstitutedMemberScope());
    if (localObject == null) {
      $$$reportNull$$$0(16);
    }
    return localObject;
  }
  
  @NotNull
  public ClassKind getKind()
  {
    ClassKind localClassKind = this.original.getKind();
    if (localClassKind == null) {
      $$$reportNull$$$0(24);
    }
    return localClassKind;
  }
  
  @NotNull
  public MemberScope getMemberScope(@NotNull TypeSubstitution paramTypeSubstitution)
  {
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(10);
    }
    paramTypeSubstitution = getMemberScope(paramTypeSubstitution, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(11);
    }
    return paramTypeSubstitution;
  }
  
  @NotNull
  public MemberScope getMemberScope(@NotNull TypeSubstitution paramTypeSubstitution, @NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(5);
    }
    if (paramKotlinTypeRefiner == null) {
      $$$reportNull$$$0(6);
    }
    paramTypeSubstitution = this.original.getMemberScope(paramTypeSubstitution, paramKotlinTypeRefiner);
    if (this.originalSubstitutor.isEmpty())
    {
      if (paramTypeSubstitution == null) {
        $$$reportNull$$$0(7);
      }
      return paramTypeSubstitution;
    }
    return new SubstitutingScope(paramTypeSubstitution, getSubstitutor());
  }
  
  @NotNull
  public Modality getModality()
  {
    Modality localModality = this.original.getModality();
    if (localModality == null) {
      $$$reportNull$$$0(25);
    }
    return localModality;
  }
  
  @NotNull
  public Name getName()
  {
    Name localName = this.original.getName();
    if (localName == null) {
      $$$reportNull$$$0(19);
    }
    return localName;
  }
  
  @NotNull
  public ClassDescriptor getOriginal()
  {
    ClassDescriptor localClassDescriptor = this.original.getOriginal();
    if (localClassDescriptor == null) {
      $$$reportNull$$$0(20);
    }
    return localClassDescriptor;
  }
  
  @NotNull
  public Collection<ClassDescriptor> getSealedSubclasses()
  {
    Collection localCollection = this.original.getSealedSubclasses();
    if (localCollection == null) {
      $$$reportNull$$$0(30);
    }
    return localCollection;
  }
  
  @NotNull
  public SourceElement getSource()
  {
    SourceElement localSourceElement = SourceElement.NO_SOURCE;
    if (localSourceElement == null) {
      $$$reportNull$$$0(28);
    }
    return localSourceElement;
  }
  
  @NotNull
  public MemberScope getStaticScope()
  {
    MemberScope localMemberScope = this.original.getStaticScope();
    if (localMemberScope == null) {
      $$$reportNull$$$0(15);
    }
    return localMemberScope;
  }
  
  @NotNull
  public ReceiverParameterDescriptor getThisAsReceiverParameter()
  {
    throw new UnsupportedOperationException();
  }
  
  @NotNull
  public TypeConstructor getTypeConstructor()
  {
    Object localObject2 = this.original.getTypeConstructor();
    if (this.originalSubstitutor.isEmpty())
    {
      if (localObject2 == null) {
        $$$reportNull$$$0(0);
      }
      return localObject2;
    }
    if (this.typeConstructor == null)
    {
      localObject1 = getSubstitutor();
      Object localObject3 = ((TypeConstructor)localObject2).getSupertypes();
      localObject2 = new ArrayList(((Collection)localObject3).size());
      localObject3 = ((Collection)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(((TypeSubstitutor)localObject1).substitute((KotlinType)((Iterator)localObject3).next(), Variance.INVARIANT));
      }
      this.typeConstructor = new ClassTypeConstructorImpl(this, this.typeConstructorParameters, (Collection)localObject2, LockBasedStorageManager.NO_LOCKS);
    }
    Object localObject1 = this.typeConstructor;
    if (localObject1 == null) {
      $$$reportNull$$$0(1);
    }
    return localObject1;
  }
  
  @NotNull
  public MemberScope getUnsubstitutedInnerClassesScope()
  {
    MemberScope localMemberScope = this.original.getUnsubstitutedInnerClassesScope();
    if (localMemberScope == null) {
      $$$reportNull$$$0(27);
    }
    return localMemberScope;
  }
  
  @NotNull
  public MemberScope getUnsubstitutedMemberScope()
  {
    MemberScope localMemberScope = getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this.original)));
    if (localMemberScope == null) {
      $$$reportNull$$$0(12);
    }
    return localMemberScope;
  }
  
  @NotNull
  public MemberScope getUnsubstitutedMemberScope(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    if (paramKotlinTypeRefiner == null) {
      $$$reportNull$$$0(13);
    }
    paramKotlinTypeRefiner = this.original.getUnsubstitutedMemberScope(paramKotlinTypeRefiner);
    if (this.originalSubstitutor.isEmpty())
    {
      if (paramKotlinTypeRefiner == null) {
        $$$reportNull$$$0(14);
      }
      return paramKotlinTypeRefiner;
    }
    return new SubstitutingScope(paramKotlinTypeRefiner, getSubstitutor());
  }
  
  @Nullable
  public ClassConstructorDescriptor getUnsubstitutedPrimaryConstructor()
  {
    return this.original.getUnsubstitutedPrimaryConstructor();
  }
  
  @NotNull
  public Visibility getVisibility()
  {
    Visibility localVisibility = this.original.getVisibility();
    if (localVisibility == null) {
      $$$reportNull$$$0(26);
    }
    return localVisibility;
  }
  
  public boolean isActual()
  {
    return this.original.isActual();
  }
  
  public boolean isCompanionObject()
  {
    return this.original.isCompanionObject();
  }
  
  public boolean isData()
  {
    return this.original.isData();
  }
  
  public boolean isExpect()
  {
    return this.original.isExpect();
  }
  
  public boolean isExternal()
  {
    return this.original.isExternal();
  }
  
  public boolean isInline()
  {
    return this.original.isInline();
  }
  
  public boolean isInner()
  {
    return this.original.isInner();
  }
  
  @NotNull
  public ClassDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    if (paramTypeSubstitutor == null) {
      $$$reportNull$$$0(22);
    }
    if (paramTypeSubstitutor.isEmpty()) {
      return this;
    }
    return new LazySubstitutingClassDescriptor(this, TypeSubstitutor.createChainedSubstitutor(paramTypeSubstitutor.getSubstitution(), getSubstitutor().getSubstitution()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.LazySubstitutingClassDescriptor
 * JD-Core Version:    0.7.0.1
 */