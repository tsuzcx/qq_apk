package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import java.util.Map;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class TypeConstructorSubstitution
  extends TypeSubstitution
{
  public static final TypeConstructorSubstitution.Companion Companion = new TypeConstructorSubstitution.Companion(null);
  
  @JvmStatic
  @NotNull
  public static final TypeSubstitution create(@NotNull TypeConstructor paramTypeConstructor, @NotNull List<? extends TypeProjection> paramList)
  {
    return Companion.create(paramTypeConstructor, paramList);
  }
  
  @JvmStatic
  @JvmOverloads
  @NotNull
  public static final TypeConstructorSubstitution createByConstructorsMap(@NotNull Map<TypeConstructor, ? extends TypeProjection> paramMap)
  {
    return TypeConstructorSubstitution.Companion.createByConstructorsMap$default(Companion, paramMap, false, 2, null);
  }
  
  @Nullable
  public TypeProjection get(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "key");
    return get(paramKotlinType.getConstructor());
  }
  
  @Nullable
  public abstract TypeProjection get(@NotNull TypeConstructor paramTypeConstructor);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
 * JD-Core Version:    0.7.0.1
 */