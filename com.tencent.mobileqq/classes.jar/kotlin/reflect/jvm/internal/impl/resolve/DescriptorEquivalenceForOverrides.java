package kotlin.reflect.jvm.internal.impl.resolve;

import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor.Kind;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker.TypeConstructorEquality;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DescriptorEquivalenceForOverrides
{
  public static final DescriptorEquivalenceForOverrides INSTANCE = new DescriptorEquivalenceForOverrides();
  
  private final boolean areClassesEquivalent(ClassDescriptor paramClassDescriptor1, ClassDescriptor paramClassDescriptor2)
  {
    return Intrinsics.areEqual(paramClassDescriptor1.getTypeConstructor(), paramClassDescriptor2.getTypeConstructor());
  }
  
  private final boolean areTypeParametersEquivalent(TypeParameterDescriptor paramTypeParameterDescriptor1, TypeParameterDescriptor paramTypeParameterDescriptor2, boolean paramBoolean, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> paramFunction2)
  {
    if (Intrinsics.areEqual(paramTypeParameterDescriptor1, paramTypeParameterDescriptor2)) {
      return true;
    }
    if (Intrinsics.areEqual(paramTypeParameterDescriptor1.getContainingDeclaration(), paramTypeParameterDescriptor2.getContainingDeclaration())) {
      return false;
    }
    if (!ownersEquivalent((DeclarationDescriptor)paramTypeParameterDescriptor1, (DeclarationDescriptor)paramTypeParameterDescriptor2, paramFunction2, paramBoolean)) {
      return false;
    }
    return paramTypeParameterDescriptor1.getIndex() == paramTypeParameterDescriptor2.getIndex();
  }
  
  private final boolean ownersEquivalent(DeclarationDescriptor paramDeclarationDescriptor1, DeclarationDescriptor paramDeclarationDescriptor2, Function2<? super DeclarationDescriptor, ? super DeclarationDescriptor, Boolean> paramFunction2, boolean paramBoolean)
  {
    paramDeclarationDescriptor1 = paramDeclarationDescriptor1.getContainingDeclaration();
    paramDeclarationDescriptor2 = paramDeclarationDescriptor2.getContainingDeclaration();
    if ((!(paramDeclarationDescriptor1 instanceof CallableMemberDescriptor)) && (!(paramDeclarationDescriptor2 instanceof CallableMemberDescriptor))) {
      return areEquivalent(paramDeclarationDescriptor1, paramDeclarationDescriptor2, paramBoolean);
    }
    return ((Boolean)paramFunction2.invoke(paramDeclarationDescriptor1, paramDeclarationDescriptor2)).booleanValue();
  }
  
  private final SourceElement singleSource(@NotNull CallableDescriptor paramCallableDescriptor)
  {
    while ((paramCallableDescriptor instanceof CallableMemberDescriptor))
    {
      CallableMemberDescriptor localCallableMemberDescriptor = (CallableMemberDescriptor)paramCallableDescriptor;
      if (localCallableMemberDescriptor.getKind() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE)
      {
        paramCallableDescriptor = localCallableMemberDescriptor.getOverriddenDescriptors();
        Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor, "overriddenDescriptors");
        paramCallableDescriptor = (CallableMemberDescriptor)CollectionsKt.singleOrNull((Iterable)paramCallableDescriptor);
        if (paramCallableDescriptor != null) {
          paramCallableDescriptor = (CallableDescriptor)paramCallableDescriptor;
        } else {
          return null;
        }
      }
    }
    return paramCallableDescriptor.getSource();
  }
  
  public final boolean areCallableDescriptorsEquivalent(@NotNull CallableDescriptor paramCallableDescriptor1, @NotNull CallableDescriptor paramCallableDescriptor2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor1, "a");
    Intrinsics.checkParameterIsNotNull(paramCallableDescriptor2, "b");
    if (Intrinsics.areEqual(paramCallableDescriptor1, paramCallableDescriptor2)) {
      return true;
    }
    if ((Intrinsics.areEqual(paramCallableDescriptor1.getName(), paramCallableDescriptor2.getName()) ^ true)) {
      return false;
    }
    if (Intrinsics.areEqual(paramCallableDescriptor1.getContainingDeclaration(), paramCallableDescriptor2.getContainingDeclaration()))
    {
      if (!paramBoolean1) {
        return false;
      }
      if ((Intrinsics.areEqual(singleSource(paramCallableDescriptor1), singleSource(paramCallableDescriptor2)) ^ true)) {
        return false;
      }
      if (((paramCallableDescriptor1 instanceof MemberDescriptor)) && ((paramCallableDescriptor2 instanceof MemberDescriptor)) && (((MemberDescriptor)paramCallableDescriptor1).isExpect() != ((MemberDescriptor)paramCallableDescriptor2).isExpect())) {
        return false;
      }
    }
    Object localObject1 = (DeclarationDescriptor)paramCallableDescriptor1;
    if (!DescriptorUtils.isLocal((DeclarationDescriptor)localObject1))
    {
      Object localObject2 = (DeclarationDescriptor)paramCallableDescriptor2;
      if (DescriptorUtils.isLocal((DeclarationDescriptor)localObject2)) {
        return false;
      }
      if (!ownersEquivalent((DeclarationDescriptor)localObject1, (DeclarationDescriptor)localObject2, (Function2)DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent.1.INSTANCE, paramBoolean1)) {
        return false;
      }
      localObject1 = OverridingUtil.createWithEqualityAxioms((KotlinTypeChecker.TypeConstructorEquality)new DescriptorEquivalenceForOverrides.areCallableDescriptorsEquivalent.overridingUtil.1(paramBoolean1, paramCallableDescriptor1, paramCallableDescriptor2));
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "OverridingUtil.createWit…= a && y == b }\n        }");
      localObject2 = ((OverridingUtil)localObject1).isOverridableBy(paramCallableDescriptor1, paramCallableDescriptor2, null, paramBoolean2 ^ true);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "overridingUtil.isOverrid… null, !ignoreReturnType)");
      if (((OverridingUtil.OverrideCompatibilityInfo)localObject2).getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE)
      {
        paramCallableDescriptor1 = ((OverridingUtil)localObject1).isOverridableBy(paramCallableDescriptor2, paramCallableDescriptor1, null, paramBoolean2 ^ true);
        Intrinsics.checkExpressionValueIsNotNull(paramCallableDescriptor1, "overridingUtil.isOverrid… null, !ignoreReturnType)");
        if (paramCallableDescriptor1.getResult() == OverridingUtil.OverrideCompatibilityInfo.Result.OVERRIDABLE) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  public final boolean areEquivalent(@Nullable DeclarationDescriptor paramDeclarationDescriptor1, @Nullable DeclarationDescriptor paramDeclarationDescriptor2, boolean paramBoolean)
  {
    if (((paramDeclarationDescriptor1 instanceof ClassDescriptor)) && ((paramDeclarationDescriptor2 instanceof ClassDescriptor))) {
      return areClassesEquivalent((ClassDescriptor)paramDeclarationDescriptor1, (ClassDescriptor)paramDeclarationDescriptor2);
    }
    if (((paramDeclarationDescriptor1 instanceof TypeParameterDescriptor)) && ((paramDeclarationDescriptor2 instanceof TypeParameterDescriptor))) {
      return areTypeParametersEquivalent$default(this, (TypeParameterDescriptor)paramDeclarationDescriptor1, (TypeParameterDescriptor)paramDeclarationDescriptor2, paramBoolean, null, 8, null);
    }
    if (((paramDeclarationDescriptor1 instanceof CallableDescriptor)) && ((paramDeclarationDescriptor2 instanceof CallableDescriptor))) {
      return areCallableDescriptorsEquivalent$default(this, (CallableDescriptor)paramDeclarationDescriptor1, (CallableDescriptor)paramDeclarationDescriptor2, paramBoolean, false, 8, null);
    }
    if (((paramDeclarationDescriptor1 instanceof PackageFragmentDescriptor)) && ((paramDeclarationDescriptor2 instanceof PackageFragmentDescriptor))) {
      return Intrinsics.areEqual(((PackageFragmentDescriptor)paramDeclarationDescriptor1).getFqName(), ((PackageFragmentDescriptor)paramDeclarationDescriptor2).getFqName());
    }
    return Intrinsics.areEqual(paramDeclarationDescriptor1, paramDeclarationDescriptor2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.resolve.DescriptorEquivalenceForOverrides
 * JD-Core Version:    0.7.0.1
 */