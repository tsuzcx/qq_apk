package rx.internal.operators;

import java.util.HashMap;
import java.util.Map;
import rx.functions.Func0;

public final class OperatorToMap$DefaultToMapFactory<K, V>
  implements Func0<Map<K, V>>
{
  public Map<K, V> call()
  {
    return new HashMap();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorToMap.DefaultToMapFactory
 * JD-Core Version:    0.7.0.1
 */