package kotlin.script.dependencies;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"compareIterables", "", "T", "", "a", "", "b", "compareValues", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)I", "chainCompare", "compFn", "Lkotlin/Function0;", "kotlin-script-runtime"}, k=2, mv={1, 1, 16})
public final class Dependencies_deprecatedKt
{
  private static final int chainCompare(int paramInt, Function0<Integer> paramFunction0)
  {
    if (paramInt != 0) {
      return paramInt;
    }
    return ((Number)paramFunction0.invoke()).intValue();
  }
  
  private static final <T extends Comparable<? super T>> int compareIterables(Iterable<? extends T> paramIterable1, Iterable<? extends T> paramIterable2)
  {
    paramIterable1 = paramIterable1.iterator();
    paramIterable2 = paramIterable2.iterator();
    int i;
    do
    {
      if ((paramIterable1.hasNext()) && (!paramIterable2.hasNext())) {
        return 1;
      }
      if ((!paramIterable1.hasNext()) && (!paramIterable2.hasNext())) {
        return 0;
      }
      if (!paramIterable1.hasNext()) {
        return -1;
      }
      i = compareValues((Comparable)paramIterable1.next(), (Comparable)paramIterable2.next());
    } while (i == 0);
    return i;
  }
  
  private static final <T extends Comparable<?>> int compareValues(T paramT1, T paramT2)
  {
    if (paramT1 == paramT2) {
      return 0;
    }
    if (paramT1 == null) {
      return -1;
    }
    if (paramT2 == null) {
      return 1;
    }
    return paramT1.compareTo(paramT2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.dependencies.Dependencies_deprecatedKt
 * JD-Core Version:    0.7.0.1
 */