package kotlin.reflect.jvm.internal.calls;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"arity", "", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getArity", "(Lkotlin/reflect/jvm/internal/calls/Caller;)I", "kotlin-reflection"}, k=2, mv={1, 1, 16})
public final class CallerKt
{
  public static final int getArity(@NotNull Caller<?> paramCaller)
  {
    Intrinsics.checkParameterIsNotNull(paramCaller, "$this$arity");
    return paramCaller.getParameterTypes().size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.CallerKt
 * JD-Core Version:    0.7.0.1
 */