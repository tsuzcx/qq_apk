package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlinx/coroutines/channels/AbstractChannel$onReceiveOrNull$1", "Lkotlinx/coroutines/selects/SelectClause1;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public final class AbstractChannel$onReceiveOrNull$1
  implements SelectClause1<E>
{
  public <R> void registerSelectClause1(@NotNull SelectInstance<? super R> paramSelectInstance, @NotNull Function2<? super E, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    AbstractChannel localAbstractChannel = this.this$0;
    if (paramFunction2 != null)
    {
      AbstractChannel.access$registerSelectReceiveMode(localAbstractChannel, paramSelectInstance, 1, paramFunction2);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.channels.AbstractChannel.onReceiveOrNull.1
 * JD-Core Version:    0.7.0.1
 */