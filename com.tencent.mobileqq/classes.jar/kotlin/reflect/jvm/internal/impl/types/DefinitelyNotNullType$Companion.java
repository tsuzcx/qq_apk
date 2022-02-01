package kotlin.reflect.jvm.internal.impl.types;

import kotlin._Assertions;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class DefinitelyNotNullType$Companion
{
  private final boolean makesSenseToBeDefinitelyNotNull(UnwrappedType paramUnwrappedType)
  {
    return (TypeUtilsKt.canHaveUndefinedNullability(paramUnwrappedType)) && (!NullabilityChecker.INSTANCE.isSubtypeOfAny(paramUnwrappedType));
  }
  
  @Nullable
  public final DefinitelyNotNullType makeDefinitelyNotNull$descriptors(@NotNull UnwrappedType paramUnwrappedType)
  {
    Intrinsics.checkParameterIsNotNull(paramUnwrappedType, "type");
    boolean bool = paramUnwrappedType instanceof DefinitelyNotNullType;
    Object localObject = null;
    if (bool) {
      return (DefinitelyNotNullType)paramUnwrappedType;
    }
    if (((Companion)this).makesSenseToBeDefinitelyNotNull(paramUnwrappedType))
    {
      if ((paramUnwrappedType instanceof FlexibleType))
      {
        localObject = (FlexibleType)paramUnwrappedType;
        bool = Intrinsics.areEqual(((FlexibleType)localObject).getLowerBound().getConstructor(), ((FlexibleType)localObject).getUpperBound().getConstructor());
        if ((_Assertions.ENABLED) && (!bool))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("DefinitelyNotNullType for flexible type (");
          ((StringBuilder)localObject).append(paramUnwrappedType);
          ((StringBuilder)localObject).append(") can be created only from type variable with the same constructor for bounds");
          throw ((Throwable)new AssertionError(((StringBuilder)localObject).toString()));
        }
      }
      localObject = new DefinitelyNotNullType(FlexibleTypesKt.lowerIfFlexible((KotlinType)paramUnwrappedType), null);
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType.Companion
 * JD-Core Version:    0.7.0.1
 */