package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class ModuleAwareClassDescriptorKt
{
  @NotNull
  public static final MemberScope getRefinedMemberScopeIfPossible(@NotNull ClassDescriptor paramClassDescriptor, @NotNull TypeSubstitution paramTypeSubstitution, @NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "$this$getRefinedMemberScopeIfPossible");
    Intrinsics.checkParameterIsNotNull(paramTypeSubstitution, "typeSubstitution");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return ModuleAwareClassDescriptor.Companion.getRefinedMemberScopeIfPossible$descriptors(paramClassDescriptor, paramTypeSubstitution, paramKotlinTypeRefiner);
  }
  
  @NotNull
  public static final MemberScope getRefinedUnsubstitutedMemberScopeIfPossible(@NotNull ClassDescriptor paramClassDescriptor, @NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "$this$getRefinedUnsubstitutedMemberScopeIfPossible");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return ModuleAwareClassDescriptor.Companion.getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(paramClassDescriptor, paramKotlinTypeRefiner);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt
 * JD-Core Version:    0.7.0.1
 */