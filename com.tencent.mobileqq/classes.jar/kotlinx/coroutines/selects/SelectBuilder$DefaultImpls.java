package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class SelectBuilder$DefaultImpls
{
  public static <R, P, Q> void invoke(SelectBuilder<? super R> paramSelectBuilder, @NotNull SelectClause2<? super P, ? extends Q> paramSelectClause2, @NotNull Function2<? super Q, ? super Continuation<? super R>, ? extends Object> paramFunction2)
  {
    paramSelectBuilder.invoke(paramSelectClause2, null, paramFunction2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.selects.SelectBuilder.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */