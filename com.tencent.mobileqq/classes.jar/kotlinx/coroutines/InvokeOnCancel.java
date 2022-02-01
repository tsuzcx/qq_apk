package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/InvokeOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class InvokeOnCancel
  extends CancelHandler
{
  private final Function1<Throwable, Unit> handler;
  
  public InvokeOnCancel(@NotNull Function1<? super Throwable, Unit> paramFunction1)
  {
    this.handler = paramFunction1;
  }
  
  public void invoke(@Nullable Throwable paramThrowable)
  {
    this.handler.invoke(paramThrowable);
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("InvokeOnCancel[");
    localStringBuilder.append(DebugStringsKt.getClassSimpleName(this.handler));
    localStringBuilder.append('@');
    localStringBuilder.append(DebugStringsKt.getHexAddress(this));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.InvokeOnCancel
 * JD-Core Version:    0.7.0.1
 */