package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;

public final class NameResolverUtilKt
{
  @NotNull
  public static final ClassId getClassId(@NotNull NameResolver paramNameResolver, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramNameResolver, "$this$getClassId");
    paramNameResolver = ClassId.fromString(paramNameResolver.getQualifiedClassName(paramInt), paramNameResolver.isLocalClassName(paramInt));
    Intrinsics.checkExpressionValueIsNotNull(paramNameResolver, "ClassId.fromString(getQu… isLocalClassName(index))");
    return paramNameResolver;
  }
  
  @NotNull
  public static final Name getName(@NotNull NameResolver paramNameResolver, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramNameResolver, "$this$getName");
    paramNameResolver = Name.guessByFirstCharacter(paramNameResolver.getString(paramInt));
    Intrinsics.checkExpressionValueIsNotNull(paramNameResolver, "Name.guessByFirstCharacter(getString(index))");
    return paramNameResolver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt
 * JD-Core Version:    0.7.0.1
 */