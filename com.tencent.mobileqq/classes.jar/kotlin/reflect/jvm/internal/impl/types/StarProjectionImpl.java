package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class StarProjectionImpl
  extends TypeProjectionBase
{
  private final Lazy _type$delegate;
  private final TypeParameterDescriptor typeParameter;
  
  public StarProjectionImpl(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor)
  {
    this.typeParameter = paramTypeParameterDescriptor;
    this._type$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0)new StarProjectionImpl._type.2(this));
  }
  
  private final KotlinType get_type()
  {
    return (KotlinType)this._type$delegate.getValue();
  }
  
  @NotNull
  public Variance getProjectionKind()
  {
    return Variance.OUT_VARIANCE;
  }
  
  @NotNull
  public KotlinType getType()
  {
    return get_type();
  }
  
  public boolean isStarProjection()
  {
    return true;
  }
  
  @NotNull
  public TypeProjection refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    return (TypeProjection)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl
 * JD-Core Version:    0.7.0.1
 */