package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class JavaTypeQualifiers
{
  public static final JavaTypeQualifiers.Companion Companion = new JavaTypeQualifiers.Companion(null);
  @NotNull
  private static final JavaTypeQualifiers NONE = new JavaTypeQualifiers(null, null, false, false, 8, null);
  private final boolean isNotNullTypeParameter;
  private final boolean isNullabilityQualifierForWarning;
  @Nullable
  private final MutabilityQualifier mutability;
  @Nullable
  private final NullabilityQualifier nullability;
  
  public JavaTypeQualifiers(@Nullable NullabilityQualifier paramNullabilityQualifier, @Nullable MutabilityQualifier paramMutabilityQualifier, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.nullability = paramNullabilityQualifier;
    this.mutability = paramMutabilityQualifier;
    this.isNotNullTypeParameter = paramBoolean1;
    this.isNullabilityQualifierForWarning = paramBoolean2;
  }
  
  @Nullable
  public final MutabilityQualifier getMutability()
  {
    return this.mutability;
  }
  
  @Nullable
  public final NullabilityQualifier getNullability()
  {
    return this.nullability;
  }
  
  public final boolean isNotNullTypeParameter()
  {
    return this.isNotNullTypeParameter;
  }
  
  public final boolean isNullabilityQualifierForWarning()
  {
    return this.isNullabilityQualifierForWarning;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers
 * JD-Core Version:    0.7.0.1
 */