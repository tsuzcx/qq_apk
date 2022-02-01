package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/selects/SelectBuilder;", "R", "", "onTimeout", "", "timeMillis", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(JLkotlin/jvm/functions/Function1;)V", "invoke", "Lkotlinx/coroutines/selects/SelectClause0;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Lkotlinx/coroutines/selects/SelectClause2;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface SelectBuilder<R>
{
  public abstract void invoke(@NotNull SelectClause0 paramSelectClause0, @NotNull Function1<? super Continuation<? super R>, ? extends Object> paramFunction1);
  
  public abstract <Q> void invoke(@NotNull SelectClause1<? extends Q> paramSelectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> paramFunction2);
  
  public abstract <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> paramSelectClause2, P paramP, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> paramFunction2);
  
  public abstract <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> paramSelectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> paramFunction2);
  
  @ExperimentalCoroutinesApi
  public abstract void onTimeout(long paramLong, @NotNull Function1<? super Continuation<? super R>, ? extends Object> paramFunction1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.SelectBuilder
 * JD-Core Version:    0.7.0.1
 */