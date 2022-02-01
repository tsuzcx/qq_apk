package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method$BoundStatic;", "Lkotlin/reflect/jvm/internal/calls/BoundCaller;", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "method", "Ljava/lang/reflect/Method;", "boundReceiver", "", "(Ljava/lang/reflect/Method;Ljava/lang/Object;)V", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-reflection"}, k=1, mv={1, 1, 16})
public final class CallerImpl$Method$BoundStatic
  extends CallerImpl.Method
  implements BoundCaller
{
  private final Object boundReceiver;
  
  public CallerImpl$Method$BoundStatic(@NotNull Method paramMethod, @Nullable Object paramObject)
  {
    super(paramMethod, false, (Type[])localObject, null);
    this.boundReceiver = paramObject;
    return;
    label64:
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  @Nullable
  public Object call(@NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    checkArguments(paramArrayOfObject);
    SpreadBuilder localSpreadBuilder = new SpreadBuilder(2);
    localSpreadBuilder.add(this.boundReceiver);
    localSpreadBuilder.addSpread(paramArrayOfObject);
    return callMethod(null, localSpreadBuilder.toArray(new Object[localSpreadBuilder.size()]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.CallerImpl.Method.BoundStatic
 * JD-Core Version:    0.7.0.1
 */