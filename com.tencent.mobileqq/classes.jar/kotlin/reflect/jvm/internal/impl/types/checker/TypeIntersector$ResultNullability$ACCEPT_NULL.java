package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

final class TypeIntersector$ResultNullability$ACCEPT_NULL
  extends TypeIntersector.ResultNullability
{
  TypeIntersector$ResultNullability$ACCEPT_NULL()
  {
    super(str, i, null);
  }
  
  @NotNull
  public TypeIntersector.ResultNullability combine(@NotNull UnwrappedType paramUnwrappedType)
  {
    Intrinsics.checkParameterIsNotNull(paramUnwrappedType, "nextType");
    return getResultNullability(paramUnwrappedType);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability.ACCEPT_NULL
 * JD-Core Version:    0.7.0.1
 */