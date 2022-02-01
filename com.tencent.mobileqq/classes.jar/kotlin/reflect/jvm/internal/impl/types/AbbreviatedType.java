package kotlin.reflect.jvm.internal.impl.types;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;

public final class AbbreviatedType
  extends DelegatingSimpleType
{
  @NotNull
  private final SimpleType abbreviation;
  @NotNull
  private final SimpleType delegate;
  
  public AbbreviatedType(@NotNull SimpleType paramSimpleType1, @NotNull SimpleType paramSimpleType2)
  {
    this.delegate = paramSimpleType1;
    this.abbreviation = paramSimpleType2;
  }
  
  @NotNull
  public final SimpleType getAbbreviation()
  {
    return this.abbreviation;
  }
  
  @NotNull
  protected SimpleType getDelegate()
  {
    return this.delegate;
  }
  
  @NotNull
  public final SimpleType getExpandedType()
  {
    return getDelegate();
  }
  
  @NotNull
  public AbbreviatedType makeNullableAsSpecified(boolean paramBoolean)
  {
    return new AbbreviatedType(getDelegate().makeNullableAsSpecified(paramBoolean), this.abbreviation.makeNullableAsSpecified(paramBoolean));
  }
  
  @NotNull
  public AbbreviatedType refine(@NotNull KotlinTypeRefiner paramKotlinTypeRefiner)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinTypeRefiner, "kotlinTypeRefiner");
    Object localObject = paramKotlinTypeRefiner.refineType((KotlinType)getDelegate());
    if (localObject != null)
    {
      localObject = (SimpleType)localObject;
      paramKotlinTypeRefiner = paramKotlinTypeRefiner.refineType((KotlinType)this.abbreviation);
      if (paramKotlinTypeRefiner != null) {
        return new AbbreviatedType((SimpleType)localObject, (SimpleType)paramKotlinTypeRefiner);
      }
      throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
    }
    throw new TypeCastException("null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
  }
  
  @NotNull
  public AbbreviatedType replaceAnnotations(@NotNull Annotations paramAnnotations)
  {
    Intrinsics.checkParameterIsNotNull(paramAnnotations, "newAnnotations");
    return new AbbreviatedType(getDelegate().replaceAnnotations(paramAnnotations), this.abbreviation);
  }
  
  @NotNull
  public AbbreviatedType replaceDelegate(@NotNull SimpleType paramSimpleType)
  {
    Intrinsics.checkParameterIsNotNull(paramSimpleType, "delegate");
    return new AbbreviatedType(paramSimpleType, this.abbreviation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.AbbreviatedType
 * JD-Core Version:    0.7.0.1
 */