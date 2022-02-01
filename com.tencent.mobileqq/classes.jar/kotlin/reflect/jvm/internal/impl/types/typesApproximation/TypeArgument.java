package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import org.jetbrains.annotations.NotNull;

final class TypeArgument
{
  @NotNull
  private final KotlinType inProjection;
  @NotNull
  private final KotlinType outProjection;
  @NotNull
  private final TypeParameterDescriptor typeParameter;
  
  public TypeArgument(@NotNull TypeParameterDescriptor paramTypeParameterDescriptor, @NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2)
  {
    this.typeParameter = paramTypeParameterDescriptor;
    this.inProjection = paramKotlinType1;
    this.outProjection = paramKotlinType2;
  }
  
  @NotNull
  public final KotlinType getInProjection()
  {
    return this.inProjection;
  }
  
  @NotNull
  public final KotlinType getOutProjection()
  {
    return this.outProjection;
  }
  
  @NotNull
  public final TypeParameterDescriptor getTypeParameter()
  {
    return this.typeParameter;
  }
  
  public final boolean isConsistent()
  {
    return KotlinTypeChecker.DEFAULT.isSubtypeOf(this.inProjection, this.outProjection);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.typesApproximation.TypeArgument
 * JD-Core Version:    0.7.0.1
 */