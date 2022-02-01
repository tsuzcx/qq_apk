package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.InternalCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/selects/SelectClause2;", "P", "Q", "", "registerSelectClause2", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "param", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
public abstract interface SelectClause2<P, Q>
{
  @InternalCoroutinesApi
  public abstract <R> void registerSelectClause2(@NotNull SelectInstance<? super R> paramSelectInstance, P paramP, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> paramFunction2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.SelectClause2
 * JD-Core Version:    0.7.0.1
 */