package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class TypeCapabilitiesKt
{
  @Nullable
  public static final CustomTypeVariable getCustomTypeVariable(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$getCustomTypeVariable");
    paramKotlinType = paramKotlinType.unwrap();
    boolean bool = paramKotlinType instanceof CustomTypeVariable;
    Object localObject = null;
    if (!bool) {
      paramKotlinType = null;
    }
    CustomTypeVariable localCustomTypeVariable = (CustomTypeVariable)paramKotlinType;
    paramKotlinType = localObject;
    if (localCustomTypeVariable != null)
    {
      paramKotlinType = localObject;
      if (localCustomTypeVariable.isTypeVariable()) {
        paramKotlinType = localCustomTypeVariable;
      }
    }
    return paramKotlinType;
  }
  
  @NotNull
  public static final KotlinType getSubtypeRepresentative(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$getSubtypeRepresentative");
    Object localObject2 = paramKotlinType.unwrap();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof SubtypingRepresentatives)) {
      localObject1 = null;
    }
    localObject2 = (SubtypingRepresentatives)localObject1;
    localObject1 = paramKotlinType;
    if (localObject2 != null)
    {
      localObject2 = ((SubtypingRepresentatives)localObject2).getSubTypeRepresentative();
      localObject1 = paramKotlinType;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  @NotNull
  public static final KotlinType getSupertypeRepresentative(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$getSupertypeRepresentative");
    Object localObject2 = paramKotlinType.unwrap();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof SubtypingRepresentatives)) {
      localObject1 = null;
    }
    localObject2 = (SubtypingRepresentatives)localObject1;
    localObject1 = paramKotlinType;
    if (localObject2 != null)
    {
      localObject2 = ((SubtypingRepresentatives)localObject2).getSuperTypeRepresentative();
      localObject1 = paramKotlinType;
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  public static final boolean isCustomTypeVariable(@NotNull KotlinType paramKotlinType)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType, "$this$isCustomTypeVariable");
    UnwrappedType localUnwrappedType = paramKotlinType.unwrap();
    paramKotlinType = localUnwrappedType;
    if (!(localUnwrappedType instanceof CustomTypeVariable)) {
      paramKotlinType = null;
    }
    paramKotlinType = (CustomTypeVariable)paramKotlinType;
    if (paramKotlinType != null) {
      return paramKotlinType.isTypeVariable();
    }
    return false;
  }
  
  public static final boolean sameTypeConstructors(@NotNull KotlinType paramKotlinType1, @NotNull KotlinType paramKotlinType2)
  {
    Intrinsics.checkParameterIsNotNull(paramKotlinType1, "first");
    Intrinsics.checkParameterIsNotNull(paramKotlinType2, "second");
    UnwrappedType localUnwrappedType = paramKotlinType1.unwrap();
    Object localObject = localUnwrappedType;
    if (!(localUnwrappedType instanceof SubtypingRepresentatives)) {
      localObject = null;
    }
    localObject = (SubtypingRepresentatives)localObject;
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((SubtypingRepresentatives)localObject).sameTypeConstructor(paramKotlinType2);
    } else {
      bool1 = false;
    }
    if (!bool1)
    {
      localObject = paramKotlinType2.unwrap();
      paramKotlinType2 = (KotlinType)localObject;
      if (!(localObject instanceof SubtypingRepresentatives)) {
        paramKotlinType2 = null;
      }
      paramKotlinType2 = (SubtypingRepresentatives)paramKotlinType2;
      if (paramKotlinType2 != null) {
        bool1 = paramKotlinType2.sameTypeConstructor(paramKotlinType1);
      } else {
        bool1 = false;
      }
      if (!bool1) {}
    }
    else
    {
      bool2 = true;
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.TypeCapabilitiesKt
 * JD-Core Version:    0.7.0.1
 */