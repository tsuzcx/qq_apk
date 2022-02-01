package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeVariable;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;

public final class NotNullTypeParameter
  extends DelegatingSimpleType
  implements NotNullTypeVariable
{
  @NotNull
  private final SimpleType delegate;
  
  public NotNullTypeParameter(@NotNull SimpleType paramSimpleType)
  {
    this.delegate = paramSimpleType;
  }
  
  private final SimpleType prepareReplacement(@NotNull SimpleType paramSimpleType)
  {
    SimpleType localSimpleType = paramSimpleType.makeNullableAsSpecified(false);
    if (!TypeUtilsKt.isTypeParameter((KotlinType)paramSimpleType)) {
      return localSimpleType;
    }
    return (SimpleType)new NotNullTypeParameter(localSimpleType);
  }
  
  @NotNull
  protected SimpleType getDelegate()
  {
    return this.delegate;
  }
  
  public boolean isMarkedNullable()
  {
    return false;
  }
  
  public boolean isTypeVariable()
  {
    return true;
  }
  
  @NotNull
  public SimpleType makeNullableAsSpecified(boolean paramBoolean)
  {
    if (paramBoolean) {
      return getDelegate().makeNullableAsSpecified(true);
    }
    return (SimpleType)this;
  }
  
  @NotNull
  public NotNullTypeParameter replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    return new NotNullTypeParameter(getDelegate().replaceAnnotations(paramAnnotations));
  }
  
  @NotNull
  public NotNullTypeParameter replaceDelegate(@NotNull SimpleType paramSimpleType)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleType, "delegate");
    return new NotNullTypeParameter(paramSimpleType);
  }
  
  @NotNull
  public KotlinType substitutionResult(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "replacement");
    paramKotlinType = paramKotlinType.unwrap();
    Object localObject = (KotlinType)paramKotlinType;
    if ((!TypeUtils.isNullableType((KotlinType)localObject)) && (!TypeUtilsKt.isTypeParameter((KotlinType)localObject))) {
      return localObject;
    }
    if ((paramKotlinType instanceof SimpleType)) {
      return (KotlinType)prepareReplacement((SimpleType)paramKotlinType);
    }
    if ((paramKotlinType instanceof FlexibleType))
    {
      paramKotlinType = (FlexibleType)paramKotlinType;
      return (KotlinType)TypeWithEnhancementKt.wrapEnhancement(KotlinTypeFactory.flexibleType(prepareReplacement(paramKotlinType.getLowerBound()), prepareReplacement(paramKotlinType.getUpperBound())), TypeWithEnhancementKt.getEnhancement((KotlinType)localObject));
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Incorrect type: ");
    ((StringBuilder)localObject).append(paramKotlinType);
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NotNullTypeParameter
 * JD-Core Version:    0.7.0.1
 */