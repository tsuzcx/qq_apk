package kotlin.reflect.jvm.internal.impl.types;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeConstructorSubstitution$Companion$createByConstructorsMap$1
  extends TypeConstructorSubstitution
{
  TypeConstructorSubstitution$Companion$createByConstructorsMap$1(Map paramMap, boolean paramBoolean) {}
  
  public boolean approximateCapturedTypes()
  {
    return this.$approximateCapturedTypes;
  }
  
  @Nullable
  public TypeProjection get(@NotNull TypeConstructor paramTypeConstructor)
  {
    Intrinsics.checkParameterIsNotNull(paramTypeConstructor, "key");
    return (TypeProjection)this.$map.get(paramTypeConstructor);
  }
  
  public boolean isEmpty()
  {
    return this.$map.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution.Companion.createByConstructorsMap.1
 * JD-Core Version:    0.7.0.1
 */