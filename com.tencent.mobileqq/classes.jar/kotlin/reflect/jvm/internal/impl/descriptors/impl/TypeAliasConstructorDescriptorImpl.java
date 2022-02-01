package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.TypeCastException;
import kotlin._Assertions;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassConstructorDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor.CopyBuilder;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Visibility;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.NullableLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeAliasConstructorDescriptorImpl
  extends FunctionDescriptorImpl
  implements TypeAliasConstructorDescriptor
{
  public static final TypeAliasConstructorDescriptorImpl.Companion Companion = new TypeAliasConstructorDescriptorImpl.Companion(null);
  @NotNull
  private final StorageManager storageManager;
  @NotNull
  private final TypeAliasDescriptor typeAliasDescriptor;
  @NotNull
  private ClassConstructorDescriptor underlyingConstructorDescriptor;
  @Nullable
  private final NullableLazyValue withDispatchReceiver$delegate;
  
  private TypeAliasConstructorDescriptorImpl(StorageManager paramStorageManager, TypeAliasDescriptor paramTypeAliasDescriptor, ClassConstructorDescriptor paramClassConstructorDescriptor, TypeAliasConstructorDescriptor paramTypeAliasConstructorDescriptor, Annotations paramAnnotations, CallableMemberDescriptor.Kind paramKind, SourceElement paramSourceElement)
  {
    super((DeclarationDescriptor)paramTypeAliasDescriptor, (FunctionDescriptor)paramTypeAliasConstructorDescriptor, paramAnnotations, Name.special("<init>"), paramKind, paramSourceElement);
    this.storageManager = paramStorageManager;
    this.typeAliasDescriptor = paramTypeAliasDescriptor;
    setActual(getTypeAliasDescriptor().isActual());
    this.withDispatchReceiver$delegate = this.storageManager.createNullableLazyValue((Function0)new TypeAliasConstructorDescriptorImpl.withDispatchReceiver.2(this, paramClassConstructorDescriptor));
    this.underlyingConstructorDescriptor = paramClassConstructorDescriptor;
  }
  
  @NotNull
  public TypeAliasConstructorDescriptor copy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @NotNull Modality paramModality, @NotNull Visibility paramVisibility, @NotNull CallableMemberDescriptor.Kind paramKind, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "newOwner");
    Intrinsics.checkParameterIsNotNull(paramModality, "modality");
    Intrinsics.checkParameterIsNotNull(paramVisibility, "visibility");
    Intrinsics.checkParameterIsNotNull(paramKind, "kind");
    paramDeclarationDescriptor = newCopyBuilder().setOwner(paramDeclarationDescriptor).setModality(paramModality).setVisibility(paramVisibility).setKind(paramKind).setCopyOverrides(paramBoolean).build();
    if (paramDeclarationDescriptor != null) {
      return (TypeAliasConstructorDescriptor)paramDeclarationDescriptor;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
  }
  
  @NotNull
  protected TypeAliasConstructorDescriptorImpl createSubstitutedCopy(@NotNull DeclarationDescriptor paramDeclarationDescriptor, @Nullable FunctionDescriptor paramFunctionDescriptor, @NotNull CallableMemberDescriptor.Kind paramKind, @Nullable Name paramName, @NotNull Annotations paramAnnotations, @NotNull SourceElement paramSourceElement)
  {
    Intrinsics.checkParameterIsNotNull(paramDeclarationDescriptor, "newOwner");
    Intrinsics.checkParameterIsNotNull(paramKind, "kind");
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "annotations");
    Intrinsics.checkParameterIsNotNull(paramSourceElement, "source");
    paramFunctionDescriptor = CallableMemberDescriptor.Kind.DECLARATION;
    int j = 0;
    if ((paramKind != paramFunctionDescriptor) && (paramKind != CallableMemberDescriptor.Kind.SYNTHESIZED)) {
      i = 0;
    } else {
      i = 1;
    }
    if ((_Assertions.ENABLED) && (i == 0))
    {
      paramFunctionDescriptor = new StringBuilder();
      paramFunctionDescriptor.append("Creating a type alias constructor that is not a declaration: \ncopy from: ");
      paramFunctionDescriptor.append(this);
      paramFunctionDescriptor.append("\nnewOwner: ");
      paramFunctionDescriptor.append(paramDeclarationDescriptor);
      paramFunctionDescriptor.append("\nkind: ");
      paramFunctionDescriptor.append(paramKind);
      throw ((Throwable)new AssertionError(paramFunctionDescriptor.toString()));
    }
    int i = j;
    if (paramName == null) {
      i = 1;
    }
    if ((_Assertions.ENABLED) && (i == 0))
    {
      paramDeclarationDescriptor = new StringBuilder();
      paramDeclarationDescriptor.append("Renaming type alias constructor: ");
      paramDeclarationDescriptor.append(this);
      throw ((Throwable)new AssertionError(paramDeclarationDescriptor.toString()));
    }
    return new TypeAliasConstructorDescriptorImpl(this.storageManager, getTypeAliasDescriptor(), getUnderlyingConstructorDescriptor(), (TypeAliasConstructorDescriptor)this, paramAnnotations, CallableMemberDescriptor.Kind.DECLARATION, paramSourceElement);
  }
  
  @NotNull
  public ClassDescriptor getConstructedClass()
  {
    ClassDescriptor localClassDescriptor = getUnderlyingConstructorDescriptor().getConstructedClass();
    Intrinsics.checkExpressionValueIsNotNull(localClassDescriptor, "underlyingConstructorDescriptor.constructedClass");
    return localClassDescriptor;
  }
  
  @NotNull
  public TypeAliasDescriptor getContainingDeclaration()
  {
    return getTypeAliasDescriptor();
  }
  
  @NotNull
  public TypeAliasConstructorDescriptor getOriginal()
  {
    FunctionDescriptor localFunctionDescriptor = super.getOriginal();
    if (localFunctionDescriptor != null) {
      return (TypeAliasConstructorDescriptor)localFunctionDescriptor;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
  }
  
  @NotNull
  public KotlinType getReturnType()
  {
    KotlinType localKotlinType = super.getReturnType();
    if (localKotlinType == null) {
      Intrinsics.throwNpe();
    }
    return localKotlinType;
  }
  
  @NotNull
  public final StorageManager getStorageManager()
  {
    return this.storageManager;
  }
  
  @NotNull
  public TypeAliasDescriptor getTypeAliasDescriptor()
  {
    return this.typeAliasDescriptor;
  }
  
  @NotNull
  public ClassConstructorDescriptor getUnderlyingConstructorDescriptor()
  {
    return this.underlyingConstructorDescriptor;
  }
  
  public boolean isPrimary()
  {
    return getUnderlyingConstructorDescriptor().isPrimary();
  }
  
  @Nullable
  public TypeAliasConstructorDescriptor substitute(@NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeSubstitutor, "substitutor");
    paramTypeSubstitutor = super.substitute(paramTypeSubstitutor);
    if (paramTypeSubstitutor != null)
    {
      paramTypeSubstitutor = (TypeAliasConstructorDescriptorImpl)paramTypeSubstitutor;
      Object localObject = TypeSubstitutor.create(paramTypeSubstitutor.getReturnType());
      Intrinsics.checkExpressionValueIsNotNull(localObject, "TypeSubstitutor.create(s…asConstructor.returnType)");
      localObject = getUnderlyingConstructorDescriptor().getOriginal().substitute((TypeSubstitutor)localObject);
      if (localObject != null)
      {
        paramTypeSubstitutor.underlyingConstructorDescriptor = ((ClassConstructorDescriptor)localObject);
        return (TypeAliasConstructorDescriptor)paramTypeSubstitutor;
      }
      return null;
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeAliasConstructorDescriptorImpl
 * JD-Core Version:    0.7.0.1
 */