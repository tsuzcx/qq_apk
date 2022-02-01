package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public abstract class UnwrappedType
  extends KotlinType
{
  private UnwrappedType()
  {
    super(null);
  }
  
  @NotNull
  public abstract UnwrappedType makeNullableAsSpecified(boolean paramBoolean);
  
  @NotNull
  public abstract UnwrappedType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner);
  
  @NotNull
  public abstract UnwrappedType replaceAnnotations(@NotNull Annotations paramAnnotations);
  
  @NotNull
  public final UnwrappedType unwrap()
  {
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.UnwrappedType
 * JD-Core Version:    0.7.0.1
 */