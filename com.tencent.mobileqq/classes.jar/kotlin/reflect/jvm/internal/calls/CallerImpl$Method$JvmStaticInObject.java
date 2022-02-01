package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$JvmStaticInObject;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "(Ljava/lang/reflect/Method;)V", "call", "", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class CallerImpl$Method$JvmStaticInObject
  extends CallerImpl.Method
{
  public CallerImpl$Method$JvmStaticInObject(@NotNull Method paramMethod)
  {
    super(paramMethod, true, null, 4, null);
  }
  
  @Nullable
  public Object call(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    checkArguments(paramArrayOfObject);
    checkObjectInstance(ArraysKt.firstOrNull(paramArrayOfObject));
    CallerImpl.Companion localCompanion = CallerImpl.Companion;
    if (paramArrayOfObject.length <= 1)
    {
      paramArrayOfObject = new Object[0];
    }
    else
    {
      paramArrayOfObject = ArraysKt.copyOfRange(paramArrayOfObject, 1, paramArrayOfObject.length);
      if (paramArrayOfObject == null) {
        break label56;
      }
    }
    return callMethod(null, paramArrayOfObject);
    label56:
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.CallerImpl.Method.JvmStaticInObject
 * JD-Core Version:    0.7.0.1
 */