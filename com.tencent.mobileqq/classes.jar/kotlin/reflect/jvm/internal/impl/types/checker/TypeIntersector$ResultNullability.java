package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import org.jetbrains.annotations.NotNull;

 enum TypeIntersector$ResultNullability
{
  static
  {
    TypeIntersector.ResultNullability.START localSTART = new TypeIntersector.ResultNullability.START("START", 0);
    START = localSTART;
    TypeIntersector.ResultNullability.ACCEPT_NULL localACCEPT_NULL = new TypeIntersector.ResultNullability.ACCEPT_NULL("ACCEPT_NULL", 1);
    ACCEPT_NULL = localACCEPT_NULL;
    TypeIntersector.ResultNullability.UNKNOWN localUNKNOWN = new TypeIntersector.ResultNullability.UNKNOWN("UNKNOWN", 2);
    UNKNOWN = localUNKNOWN;
    TypeIntersector.ResultNullability.NOT_NULL localNOT_NULL = new TypeIntersector.ResultNullability.NOT_NULL("NOT_NULL", 3);
    NOT_NULL = localNOT_NULL;
    $VALUES = new ResultNullability[] { localSTART, localACCEPT_NULL, localUNKNOWN, localNOT_NULL };
  }
  
  private TypeIntersector$ResultNullability() {}
  
  @NotNull
  public abstract ResultNullability combine(@NotNull UnwrappedType paramUnwrappedType);
  
  @NotNull
  protected final ResultNullability getResultNullability(@NotNull UnwrappedType paramUnwrappedType)
  {
    Intrinsics.checkParameterIsNotNull(paramUnwrappedType, "$this$resultNullability");
    if (paramUnwrappedType.isMarkedNullable()) {
      return ACCEPT_NULL;
    }
    if (NullabilityChecker.INSTANCE.isSubtypeOfAny(paramUnwrappedType)) {
      return NOT_NULL;
    }
    return UNKNOWN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
 * JD-Core Version:    0.7.0.1
 */