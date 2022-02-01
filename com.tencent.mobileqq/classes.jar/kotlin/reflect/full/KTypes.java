package kotlin.reflect.full;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"isSubtypeOf", "", "Lkotlin/reflect/KType;", "other", "isSupertypeOf", "withNullability", "nullable", "kotlin-reflection"}, k=2, mv={1, 1, 16})
@JvmName(name="KTypes")
public final class KTypes
{
  @SinceKotlin(version="1.1")
  public static final boolean isSubtypeOf(@NotNull KType paramKType1, @NotNull KType paramKType2)
  {
    Intrinsics.checkParameterIsNotNull(paramKType1, "$this$isSubtypeOf");
    Intrinsics.checkParameterIsNotNull(paramKType2, "other");
    return TypeUtilsKt.isSubtypeOf(((KTypeImpl)paramKType1).getType(), ((KTypeImpl)paramKType2).getType());
  }
  
  @SinceKotlin(version="1.1")
  public static final boolean isSupertypeOf(@NotNull KType paramKType1, @NotNull KType paramKType2)
  {
    Intrinsics.checkParameterIsNotNull(paramKType1, "$this$isSupertypeOf");
    Intrinsics.checkParameterIsNotNull(paramKType2, "other");
    return isSubtypeOf(paramKType2, paramKType1);
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final KType withNullability(@NotNull KType paramKType, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramKType, "$this$withNullability");
    if (paramKType.isMarkedNullable())
    {
      if (paramBoolean) {
        return paramKType;
      }
      localKotlinType = TypeUtils.makeNotNullable(((KTypeImpl)paramKType).getType());
      Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "TypeUtils.makeNotNullabl…(this as KTypeImpl).type)");
      return (KType)new KTypeImpl(localKotlinType, (Function0)new KTypes.withNullability.1(paramKType));
    }
    KotlinType localKotlinType = ((KTypeImpl)paramKType).getType();
    if (FlexibleTypesKt.isFlexible(localKotlinType))
    {
      localKotlinType = TypeUtils.makeNullableAsSpecified(localKotlinType, paramBoolean);
      Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "TypeUtils.makeNullableAs…ied(kotlinType, nullable)");
      return (KType)new KTypeImpl(localKotlinType, (Function0)new KTypes.withNullability.2(paramKType));
    }
    if (!paramBoolean) {
      return paramKType;
    }
    localKotlinType = TypeUtils.makeNullable(localKotlinType);
    Intrinsics.checkExpressionValueIsNotNull(localKotlinType, "TypeUtils.makeNullable(kotlinType)");
    return (KType)new KTypeImpl(localKotlinType, (Function0)new KTypes.withNullability.3(paramKType));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.full.KTypes
 * JD-Core Version:    0.7.0.1
 */