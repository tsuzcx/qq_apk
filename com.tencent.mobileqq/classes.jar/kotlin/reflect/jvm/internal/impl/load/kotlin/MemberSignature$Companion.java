package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Field;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.JvmMemberSignature.Method;
import org.jetbrains.annotations.NotNull;

public final class MemberSignature$Companion
{
  @JvmStatic
  @NotNull
  public final MemberSignature fromFieldNameAndDesc(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "desc");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('#');
    localStringBuilder.append(paramString2);
    return new MemberSignature(localStringBuilder.toString(), null);
  }
  
  @JvmStatic
  @NotNull
  public final MemberSignature fromJvmMemberSignature(@NotNull JvmMemberSignature paramJvmMemberSignature)
  {
    Intrinsics.checkParameterIsNotNull(paramJvmMemberSignature, "signature");
    if ((paramJvmMemberSignature instanceof JvmMemberSignature.Method)) {
      return ((Companion)this).fromMethodNameAndDesc(paramJvmMemberSignature.getName(), paramJvmMemberSignature.getDesc());
    }
    if ((paramJvmMemberSignature instanceof JvmMemberSignature.Field)) {
      return ((Companion)this).fromFieldNameAndDesc(paramJvmMemberSignature.getName(), paramJvmMemberSignature.getDesc());
    }
    throw new NoWhenBranchMatchedException();
  }
  
  @JvmStatic
  @NotNull
  public final MemberSignature fromMethod(@NotNull NameResolver paramNameResolver, @NotNull JvmProtoBuf.JvmMethodSignature paramJvmMethodSignature)
  {
    Intrinsics.checkParameterIsNotNull(paramNameResolver, "nameResolver");
    Intrinsics.checkParameterIsNotNull(paramJvmMethodSignature, "signature");
    return ((Companion)this).fromMethodNameAndDesc(paramNameResolver.getString(paramJvmMethodSignature.getName()), paramNameResolver.getString(paramJvmMethodSignature.getDesc()));
  }
  
  @JvmStatic
  @NotNull
  public final MemberSignature fromMethodNameAndDesc(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "desc");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString2);
    return new MemberSignature(localStringBuilder.toString(), null);
  }
  
  @JvmStatic
  @NotNull
  public final MemberSignature fromMethodSignatureAndParameterIndex(@NotNull MemberSignature paramMemberSignature, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramMemberSignature, "signature");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramMemberSignature.getSignature$descriptors_jvm());
    localStringBuilder.append('@');
    localStringBuilder.append(paramInt);
    return new MemberSignature(localStringBuilder.toString(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.kotlin.MemberSignature.Companion
 * JD-Core Version:    0.7.0.1
 */