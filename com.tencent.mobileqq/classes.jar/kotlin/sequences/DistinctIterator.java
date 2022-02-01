package kotlin.sequences;

import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.AbstractIterator;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/sequences/DistinctIterator;", "T", "K", "Lkotlin/collections/AbstractIterator;", "source", "", "keySelector", "Lkotlin/Function1;", "(Ljava/util/Iterator;Lkotlin/jvm/functions/Function1;)V", "observed", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "computeNext", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class DistinctIterator<T, K>
  extends AbstractIterator<T>
{
  private final Function1<T, K> keySelector;
  private final HashSet<K> observed;
  private final Iterator<T> source;
  
  public DistinctIterator(@NotNull Iterator<? extends T> paramIterator, @NotNull Function1<? super T, ? extends K> paramFunction1)
  {
    this.source = paramIterator;
    this.keySelector = paramFunction1;
    this.observed = new HashSet();
  }
  
  protected void computeNext()
  {
    while (this.source.hasNext())
    {
      Object localObject1 = this.source.next();
      Object localObject2 = this.keySelector.invoke(localObject1);
      if (this.observed.add(localObject2))
      {
        setNext(localObject1);
        return;
      }
    }
    done();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.sequences.DistinctIterator
 * JD-Core Version:    0.7.0.1
 */