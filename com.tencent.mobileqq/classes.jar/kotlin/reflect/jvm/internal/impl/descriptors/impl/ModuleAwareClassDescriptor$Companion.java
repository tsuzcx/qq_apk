package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class ModuleAwareClassDescriptor$Companion
{
  @NotNull
  public final MemberScope getRefinedMemberScopeIfPossible$descriptors(@NotNull ClassDescriptor paramClassDescriptor, @NotNull TypeSubstitution paramTypeSubstitution, @NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "$this$getRefinedMemberScopeIfPossible");
    Intrinsics.checkParameterIsNotNull(paramTypeSubstitution, "typeSubstitution");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    if (!(paramClassDescriptor instanceof ModuleAwareClassDescriptor)) {
      localObject = null;
    } else {
      localObject = paramClassDescriptor;
    }
    Object localObject = (ModuleAwareClassDescriptor)localObject;
    if (localObject != null)
    {
      paramKotlinTypeRefiner = ((ModuleAwareClassDescriptor)localObject).getMemberScope(paramTypeSubstitution, paramKotlinTypeRefiner);
      if (paramKotlinTypeRefiner != null) {
        return paramKotlinTypeRefiner;
      }
    }
    paramClassDescriptor = paramClassDescriptor.getMemberScope(paramTypeSubstitution);
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "this.getMemberScope(\n   …ubstitution\n            )");
    return paramClassDescriptor;
  }
  
  @NotNull
  public final MemberScope getRefinedUnsubstitutedMemberScopeIfPossible$descriptors(@NotNull ClassDescriptor paramClassDescriptor, @NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramClassDescriptor, "$this$getRefinedUnsubstitutedMemberScopeIfPossible");
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    if (!(paramClassDescriptor instanceof ModuleAwareClassDescriptor)) {
      localObject = null;
    } else {
      localObject = paramClassDescriptor;
    }
    Object localObject = (ModuleAwareClassDescriptor)localObject;
    if (localObject != null)
    {
      paramKotlinTypeRefiner = ((ModuleAwareClassDescriptor)localObject).getUnsubstitutedMemberScope(paramKotlinTypeRefiner);
      if (paramKotlinTypeRefiner != null) {
        return paramKotlinTypeRefiner;
      }
    }
    paramClassDescriptor = paramClassDescriptor.getUnsubstitutedMemberScope();
    Intrinsics.checkExpressionValueIsNotNull(paramClassDescriptor, "this.unsubstitutedMemberScope");
    return paramClassDescriptor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptor.Companion
 * JD-Core Version:    0.7.0.1
 */