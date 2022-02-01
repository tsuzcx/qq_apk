package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;

public abstract class DelegatingSimpleTypeImpl
  extends DelegatingSimpleType
{
  @NotNull
  private final SimpleType delegate;
  
  public DelegatingSimpleTypeImpl(@NotNull SimpleType paramSimpleType)
  {
    this.delegate = paramSimpleType;
  }
  
  @NotNull
  protected SimpleType getDelegate()
  {
    return this.delegate;
  }
  
  @NotNull
  public SimpleType makeNullableAsSpecified(boolean paramBoolean)
  {
    if (paramBoolean == isMarkedNullable()) {
      return (SimpleType)this;
    }
    return getDelegate().makeNullableAsSpecified(paramBoolean).replaceAnnotations(getAnnotations());
  }
  
  @NotNull
  public DelegatingSimpleTypeImpl replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    if (paramAnnotations != getAnnotations()) {
      return (DelegatingSimpleTypeImpl)new AnnotatedSimpleType((SimpleType)this, paramAnnotations);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleTypeImpl
 * JD-Core Version:    0.7.0.1
 */