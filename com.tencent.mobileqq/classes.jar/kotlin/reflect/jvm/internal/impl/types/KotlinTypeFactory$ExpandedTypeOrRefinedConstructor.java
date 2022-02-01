package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.Nullable;

final class KotlinTypeFactory$ExpandedTypeOrRefinedConstructor
{
  @Nullable
  private final SimpleType expandedType;
  @Nullable
  private final TypeConstructor refinedConstructor;
  
  public KotlinTypeFactory$ExpandedTypeOrRefinedConstructor(@Nullable SimpleType paramSimpleType, @Nullable TypeConstructor paramTypeConstructor)
  {
    this.expandedType = paramSimpleType;
    this.refinedConstructor = paramTypeConstructor;
  }
  
  @Nullable
  public final SimpleType getExpandedType()
  {
    return this.expandedType;
  }
  
  @Nullable
  public final TypeConstructor getRefinedConstructor()
  {
    return this.refinedConstructor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.ExpandedTypeOrRefinedConstructor
 * JD-Core Version:    0.7.0.1
 */