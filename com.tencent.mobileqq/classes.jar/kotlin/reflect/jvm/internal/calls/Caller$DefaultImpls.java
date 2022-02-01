package kotlin.reflect.jvm.internal.calls;

import java.lang.reflect.Member;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class Caller$DefaultImpls
{
  public static <M extends Member> void checkArguments(Caller<? extends M> paramCaller, @NotNull Object[] paramArrayOfObject)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfObject, "args");
    if (CallerKt.getArity(paramCaller) == paramArrayOfObject.length) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Callable expects ");
    localStringBuilder.append(CallerKt.getArity(paramCaller));
    localStringBuilder.append(" arguments, but ");
    localStringBuilder.append(paramArrayOfObject.length);
    localStringBuilder.append(" were provided.");
    throw ((Throwable)new IllegalArgumentException(localStringBuilder.toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.calls.Caller.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */