package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CancelHandlerBase;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "()V", "invoke", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract class CancelHandlerBase
  implements Function1<Throwable, Unit>
{
  public abstract void invoke(@Nullable Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CancelHandlerBase
 * JD-Core Version:    0.7.0.1
 */