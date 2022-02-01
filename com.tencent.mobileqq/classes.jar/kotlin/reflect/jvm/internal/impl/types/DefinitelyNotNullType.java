package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import org.jetbrains.annotations.NotNull;

public final class DefinitelyNotNullType
  extends DelegatingSimpleType
  implements CustomTypeVariable, DefinitelyNotNullTypeMarker
{
  public static final DefinitelyNotNullType.Companion Companion = new DefinitelyNotNullType.Companion(null);
  @NotNull
  private final SimpleType original;
  
  private DefinitelyNotNullType(SimpleType paramSimpleType)
  {
    this.original = paramSimpleType;
  }
  
  @NotNull
  protected SimpleType getDelegate()
  {
    return this.original;
  }
  
  @NotNull
  public final SimpleType getOriginal()
  {
    return this.original;
  }
  
  public boolean isMarkedNullable()
  {
    return false;
  }
  
  public boolean isTypeVariable()
  {
    return ((getDelegate().getConstructor() instanceof NewTypeVariableConstructor)) || ((getDelegate().getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor));
  }
  
  @NotNull
  public SimpleType makeNullableAsSpecified(boolean paramBoolean)
  {
    if (paramBoolean) {
      return getDelegate().makeNullableAsSpecified(paramBoolean);
    }
    return (SimpleType)this;
  }
  
  @NotNull
  public DefinitelyNotNullType replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    return new DefinitelyNotNullType(getDelegate().replaceAnnotations(paramAnnotations));
  }
  
  @NotNull
  public DefinitelyNotNullType replaceDelegate(@NotNull SimpleType paramSimpleType)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleType, "delegate");
    return new DefinitelyNotNullType(paramSimpleType);
  }
  
  @NotNull
  public KotlinType substitutionResult(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "replacement");
    return (KotlinType)SpecialTypesKt.makeDefinitelyNotNullOrNotNull(paramKotlinType.unwrap());
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getDelegate());
    localStringBuilder.append("!!");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType
 * JD-Core Version:    0.7.0.1
 */