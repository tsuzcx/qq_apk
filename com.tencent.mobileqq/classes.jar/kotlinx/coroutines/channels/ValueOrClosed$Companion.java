package kotlinx.coroutines.channels;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/channels/ValueOrClosed$Companion;", "", "()V", "closed", "Lkotlinx/coroutines/channels/ValueOrClosed;", "E", "cause", "", "closed$kotlinx_coroutines_core", "(Ljava/lang/Throwable;)Ljava/lang/Object;", "value", "value$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class ValueOrClosed$Companion
{
  @NotNull
  public final <E> Object closed$kotlinx_coroutines_core(@Nullable Throwable paramThrowable)
  {
    return ValueOrClosed.constructor-impl(new ValueOrClosed.Closed(paramThrowable));
  }
  
  @NotNull
  public final <E> Object value$kotlinx_coroutines_core(E paramE)
  {
    return ValueOrClosed.constructor-impl(paramE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.ValueOrClosed.Companion
 * JD-Core Version:    0.7.0.1
 */