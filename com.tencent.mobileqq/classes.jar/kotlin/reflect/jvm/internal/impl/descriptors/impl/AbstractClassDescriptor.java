package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.SubstitutingScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractClassDescriptor
  extends ModuleAwareClassDescriptor
{
  protected final NotNullLazyValue<SimpleType> defaultType;
  private final Name name;
  private final NotNullLazyValue<ReceiverParameterDescriptor> thisAsReceiverParameter;
  private final NotNullLazyValue<MemberScope> unsubstitutedInnerClassesScope;
  
  public AbstractClassDescriptor(@NotNull StorageManager paramStorageManager, @NotNull Name paramName)
  {
    this.name = paramName;
    this.defaultType = paramStorageManager.createLazyValue(new AbstractClassDescriptor.1(this));
    this.unsubstitutedInnerClassesScope = paramStorageManager.createLazyValue(new AbstractClassDescriptor.2(this));
    this.thisAsReceiverParameter = paramStorageManager.createLazyValue(new AbstractClassDescriptor.3(this));
  }
  
  public <R, D> R accept(DeclarationDescriptorVisitor<R, D> paramDeclarationDescriptorVisitor, D paramD)
  {
    return paramDeclarationDescriptorVisitor.visitClassDescriptor(this, paramD);
  }
  
  @NotNull
  public SimpleType getDefaultType()
  {
    SimpleType localSimpleType = (SimpleType)this.defaultType.invoke();
    if (localSimpleType == null) {
      $$$reportNull$$$0(19);
    }
    return localSimpleType;
  }
  
  @NotNull
  public MemberScope getMemberScope(@NotNull TypeSubstitution paramTypeSubstitution)
  {
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(14);
    }
    paramTypeSubstitution = getMemberScope(paramTypeSubstitution, DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(15);
    }
    return paramTypeSubstitution;
  }
  
  @NotNull
  public MemberScope getMemberScope(@NotNull TypeSubstitution paramTypeSubstitution, @NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    if (paramTypeSubstitution == null) {
      $$$reportNull$$$0(9);
    }
    if (paramKotlinTypeRefiner == null) {
      $$$reportNull$$$0(10);
    }
    if (paramTypeSubstitution.isEmpty())
    {
      paramTypeSubstitution = getUnsubstitutedMemberScope(paramKotlinTypeRefiner);
      if (paramTypeSubstitution == null) {
        $$$reportNull$$$0(11);
      }
      return paramTypeSubstitution;
    }
    paramTypeSubstitution = TypeSubstitutor.create(paramTypeSubstitution);
    return new SubstitutingScope(getUnsubstitutedMemberScope(paramKotlinTypeRefiner), paramTypeSubstitution);
  }
  
  @NotNull
  public Name getName()
  {
    Name localName = this.name;
    if (localName == null) {
      $$$reportNull$$$0(2);
    }
    return localName;
  }
  
  @NotNull
  public ClassDescriptor getOriginal()
  {
    return this;
  }
  
  @NotNull
  public ReceiverParameterDescriptor getThisAsReceiverParameter()
  {
    ReceiverParameterDescriptor localReceiverParameterDescriptor = (ReceiverParameterDescriptor)this.thisAsReceiverParameter.invoke();
    if (localReceiverParameterDescriptor == null) {
      $$$reportNull$$$0(5);
    }
    return localReceiverParameterDescriptor;
  }
  
  @NotNull
  public MemberScope getUnsubstitutedInnerClassesScope()
  {
    MemberScope localMemberScope = (MemberScope)this.unsubstitutedInnerClassesScope.invoke();
    if (localMemberScope == null) {
      $$$reportNull$$$0(4);
    }
    return localMemberScope;
  }
  
  @NotNull
  public MemberScope getUnsubstitutedMemberScope()
  {
    MemberScope localMemberScope = getUnsubstitutedMemberScope(DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtils.getContainingModule(this)));
    if (localMemberScope == null) {
      $$$reportNull$$$0(16);
    }
    return localMemberScope;
  }
  
  @NotNull
  public ClassDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    if (paramTypeSubstitutor == null) {
      $$$reportNull$$$0(17);
    }
    if (paramTypeSubstitutor.isEmpty()) {
      return this;
    }
    return new LazySubstitutingClassDescriptor(this, paramTypeSubstitutor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.AbstractClassDescriptor
 * JD-Core Version:    0.7.0.1
 */