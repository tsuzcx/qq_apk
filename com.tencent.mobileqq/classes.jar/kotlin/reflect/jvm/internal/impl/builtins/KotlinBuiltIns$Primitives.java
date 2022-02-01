package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import org.jetbrains.annotations.NotNull;

class KotlinBuiltIns$Primitives
{
  public final Map<SimpleType, SimpleType> kotlinArrayTypeToPrimitiveKotlinType;
  public final Map<KotlinType, SimpleType> primitiveKotlinTypeToKotlinArrayType;
  public final Map<PrimitiveType, SimpleType> primitiveTypeToArrayKotlinType;
  
  private KotlinBuiltIns$Primitives(@NotNull Map<PrimitiveType, SimpleType> paramMap, @NotNull Map<KotlinType, SimpleType> paramMap1, @NotNull Map<SimpleType, SimpleType> paramMap2)
  {
    this.primitiveTypeToArrayKotlinType = paramMap;
    this.primitiveKotlinTypeToKotlinArrayType = paramMap1;
    this.kotlinArrayTypeToPrimitiveKotlinType = paramMap2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.Primitives
 * JD-Core Version:    0.7.0.1
 */