package kotlin.reflect.jvm.internal.impl.types;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

public final class TypeAliasExpander$Companion
{
  private final void assertRecursionDepth(int paramInt, TypeAliasDescriptor paramTypeAliasDescriptor)
  {
    if (paramInt <= 100) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Too deep recursion while expanding type alias ");
    localStringBuilder.append(paramTypeAliasDescriptor.getName());
    throw ((Throwable)new AssertionError(localStringBuilder.toString()));
  }
  
  public final void checkBoundsInTypeAlias(@NotNull TypeAliasExpansionReportStrategy paramTypeAliasExpansionReportStrategy, @NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2, @NotNull TypeParameterDescriptor paramTypeParameterDescriptor, @NotNull TypeSubstitutor paramTypeSubstitutor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeAliasExpansionReportStrategy, "reportStrategy");
    Intrinsics.checkParameterIsNotNull(paramKotlinType1, "unsubstitutedArgument");
    Intrinsics.checkParameterIsNotNull(paramKotlinType2, "typeArgument");
    Intrinsics.checkParameterIsNotNull(paramTypeParameterDescriptor, "typeParameterDescriptor");
    Intrinsics.checkParameterIsNotNull(paramTypeSubstitutor, "substitutor");
    Iterator localIterator = paramTypeParameterDescriptor.getUpperBounds().iterator();
    while (localIterator.hasNext())
    {
      KotlinType localKotlinType = paramTypeSubstitutor.safeSubstitute((KotlinType)localIterator.next(), Variance.INVARIANT);
      Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "substitutor.safeSubstitu…ound, Variance.INVARIANT)");
      if (!KotlinTypeChecker.DEFAULT.isSubtypeOf(paramKotlinType2, localKotlinType)) {
        paramTypeAliasExpansionReportStrategy.boundsViolationInSubstitution(localKotlinType, paramKotlinType1, paramKotlinType2, paramTypeParameterDescriptor);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeAliasExpander.Companion
 * JD-Core Version:    0.7.0.1
 */