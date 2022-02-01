package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

public final class TypeSubstitutionKt
{
  @NotNull
  public static final SimpleType asSimpleType(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$asSimpleType");
    UnwrappedType localUnwrappedType = paramKotlinType.unwrap();
    Object localObject = localUnwrappedType;
    if (!(localUnwrappedType instanceof SimpleType)) {
      localObject = null;
    }
    localObject = (SimpleType)localObject;
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("This is should be simple type: ");
    ((StringBuilder)localObject).append(paramKotlinType);
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
  }
  
  @JvmOverloads
  @NotNull
  public static final KotlinType replace(@NotNull KotlinType paramKotlinType, @NotNull List<? extends TypeProjection> paramList, @NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$replace");
    Intrinsics.checkParameterIsNotNull(paramList, "newArguments");
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    if (((paramList.isEmpty()) || (paramList == paramKotlinType.getArguments())) && (paramAnnotations == paramKotlinType.getAnnotations())) {
      return paramKotlinType;
    }
    paramKotlinType = paramKotlinType.unwrap();
    if ((paramKotlinType instanceof FlexibleType))
    {
      paramKotlinType = (FlexibleType)paramKotlinType;
      return (KotlinType)KotlinTypeFactory.flexibleType(replace(paramKotlinType.getLowerBound(), paramList, paramAnnotations), replace(paramKotlinType.getUpperBound(), paramList, paramAnnotations));
    }
    if ((paramKotlinType instanceof SimpleType)) {
      return (KotlinType)replace((SimpleType)paramKotlinType, paramList, paramAnnotations);
    }
    throw new NoWhenBranchMatchedException();
  }
  
  @JvmOverloads
  @NotNull
  public static final SimpleType replace(@NotNull SimpleType paramSimpleType, @NotNull List<? extends TypeProjection> paramList, @NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleType, "$this$replace");
    Intrinsics.checkParameterIsNotNull(paramList, "newArguments");
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    if ((paramList.isEmpty()) && (paramAnnotations == paramSimpleType.getAnnotations())) {
      return paramSimpleType;
    }
    if (paramList.isEmpty()) {
      return paramSimpleType.replaceAnnotations(paramAnnotations);
    }
    return KotlinTypeFactory.simpleType$default(paramAnnotations, paramSimpleType.getConstructor(), paramList, paramSimpleType.isMarkedNullable(), null, 16, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt
 * JD-Core Version:    0.7.0.1
 */