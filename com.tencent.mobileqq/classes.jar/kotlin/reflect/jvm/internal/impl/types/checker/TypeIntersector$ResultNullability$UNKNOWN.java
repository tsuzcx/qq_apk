package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

final class TypeIntersector$ResultNullability$UNKNOWN
  extends TypeIntersector.ResultNullability
{
  TypeIntersector$ResultNullability$UNKNOWN()
  {
    super(str, i, null);
  }
  
  @NotNull
  public TypeIntersector.ResultNullability combine(@NotNull UnwrappedType paramUnwrappedType)
  {
    Intrinsics.checkParameterIsNotNull(paramUnwrappedType, "nextType");
    TypeIntersector.ResultNullability localResultNullability = getResultNullability(paramUnwrappedType);
    paramUnwrappedType = localResultNullability;
    if (localResultNullability == TypeIntersector.ResultNullability.ACCEPT_NULL) {
      paramUnwrappedType = (TypeIntersector.ResultNullability)this;
    }
    return paramUnwrappedType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability.UNKNOWN
 * JD-Core Version:    0.7.0.1
 */