package kotlinx.coroutines.selects;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/selects/UnbiasedSelectBuilderImpl;", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "uCont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "clauses", "Ljava/util/ArrayList;", "Lkotlin/Function0;", "", "Lkotlin/collections/ArrayList;", "getClauses", "()Ljava/util/ArrayList;", "instance", "Lkotlinx/coroutines/selects/SelectBuilderImpl;", "getInstance", "()Lkotlinx/coroutines/selects/SelectBuilderImpl;", "handleBuilderException", "e", "", "initSelectResult", "", "onTimeout", "timeMillis", "", "block", "Lkotlin/Function1;", "(JLkotlin/jvm/functions/Function1;)V", "invoke", "Lkotlinx/coroutines/selects/SelectClause0;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
@PublishedApi
public final class UnbiasedSelectBuilderImpl<R>
  implements SelectBuilder<R>
{
  @NotNull
  private final ArrayList<Function0<Unit>> clauses;
  @NotNull
  private final SelectBuilderImpl<R> instance;
  
  public UnbiasedSelectBuilderImpl(@NotNull Continuation<? super R> paramContinuation)
  {
    this.instance = new SelectBuilderImpl(paramContinuation);
    this.clauses = new ArrayList();
  }
  
  @NotNull
  public final ArrayList<Function0<Unit>> getClauses()
  {
    return this.clauses;
  }
  
  @NotNull
  public final SelectBuilderImpl<R> getInstance()
  {
    return this.instance;
  }
  
  @PublishedApi
  public final void handleBuilderException(@NotNull Throwable paramThrowable)
  {
    this.instance.handleBuilderException(paramThrowable);
  }
  
  @PublishedApi
  @Nullable
  public final Object initSelectResult()
  {
    if (!this.instance.isSelected()) {
      try
      {
        Collections.shuffle((List)this.clauses);
        Iterator localIterator = ((Iterable)this.clauses).iterator();
        while (localIterator.hasNext()) {
          ((Function0)localIterator.next()).invoke();
        }
        return this.instance.getResult();
      }
      catch (Throwable localThrowable)
      {
        this.instance.handleBuilderException(localThrowable);
      }
    }
  }
  
  public void invoke(@NotNull SelectClause0 paramSelectClause0, @NotNull Function1<? super Continuation<? super R>, ? extends Object> paramFunction1)
  {
    ((Collection)this.clauses).add(new UnbiasedSelectBuilderImpl.invoke.1(this, paramSelectClause0, paramFunction1));
  }
  
  public <Q> void invoke(@NotNull SelectClause1<? extends Q> paramSelectClause1, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    ((Collection)this.clauses).add(new UnbiasedSelectBuilderImpl.invoke.2(this, paramSelectClause1, paramFunction2));
  }
  
  public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> paramSelectClause2, P paramP, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    ((Collection)this.clauses).add(new UnbiasedSelectBuilderImpl.invoke.3(this, paramSelectClause2, paramP, paramFunction2));
  }
  
  public <P, Q> void invoke(@NotNull SelectClause2<? super P, ? extends Q> paramSelectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    SelectBuilder.DefaultImpls.invoke(this, paramSelectClause2, paramFunction2);
  }
  
  public void onTimeout(long paramLong, @NotNull Function1<? super Continuation<? super R>, ? extends Object> paramFunction1)
  {
    ((Collection)this.clauses).add(new UnbiasedSelectBuilderImpl.onTimeout.1(this, paramLong, paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl
 * JD-Core Version:    0.7.0.1
 */