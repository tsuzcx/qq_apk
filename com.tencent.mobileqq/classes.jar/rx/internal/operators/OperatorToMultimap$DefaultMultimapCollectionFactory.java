package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collection;
import rx.functions.Func1;

public final class OperatorToMultimap$DefaultMultimapCollectionFactory<K, V>
  implements Func1<K, Collection<V>>
{
  public Collection<V> call(K paramK)
  {
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorToMultimap.DefaultMultimapCollectionFactory
 * JD-Core Version:    0.7.0.1
 */