package kotlin.collections;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", "T", "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class SlidingWindowKt
{
  public static final void checkWindowSizeStep(int paramInt1, int paramInt2)
  {
    int i;
    if ((paramInt1 > 0) && (paramInt2 > 0)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      Object localObject;
      if (paramInt1 != paramInt2)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Both size ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" and step ");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" must be greater than zero.");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("size ");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" must be greater than zero.");
        localObject = ((StringBuilder)localObject).toString();
      }
      throw ((Throwable)new IllegalArgumentException(localObject.toString()));
    }
  }
  
  @NotNull
  public static final <T> Iterator<List<T>> windowedIterator(@NotNull Iterator<? extends T> paramIterator, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramIterator, "iterator");
    if (!paramIterator.hasNext()) {
      return (Iterator)EmptyIterator.INSTANCE;
    }
    return SequencesKt.iterator((Function2)new SlidingWindowKt.windowedIterator.1(paramInt1, paramInt2, paramIterator, paramBoolean2, paramBoolean1, null));
  }
  
  @NotNull
  public static final <T> Sequence<List<T>> windowedSequence(@NotNull Sequence<? extends T> paramSequence, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramSequence, "$this$windowedSequence");
    checkWindowSizeStep(paramInt1, paramInt2);
    return (Sequence)new SlidingWindowKt.windowedSequence..inlined.Sequence.1(paramSequence, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     kotlin.collections.SlidingWindowKt
 * JD-Core Version:    0.7.0.1
 */