package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlinx/coroutines/CompletedWithCancellation;", "", "result", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "toString", "", "kotlinx-coroutines-core"}, k=1, mv={1, 1, 16})
final class CompletedWithCancellation
{
  @JvmField
  @NotNull
  public final Function1<Throwable, Unit> onCancellation;
  @JvmField
  @Nullable
  public final Object result;
  
  public CompletedWithCancellation(@Nullable Object paramObject, @NotNull Function1<? super Throwable, Unit> paramFunction1)
  {
    this.result = paramObject;
    this.onCancellation = paramFunction1;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompletedWithCancellation[");
    localStringBuilder.append(this.result);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlinx.coroutines.CompletedWithCancellation
 * JD-Core Version:    0.7.0.1
 */