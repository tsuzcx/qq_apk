package kotlin.collections;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.markers.KMutableMap;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractMutableMap;", "K", "V", "", "Ljava/util/AbstractMap;", "()V", "put", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract class AbstractMutableMap<K, V>
  extends AbstractMap<K, V>
  implements Map<K, V>, KMutableMap
{
  public final Set<Map.Entry<K, V>> entrySet()
  {
    return getEntries();
  }
  
  public abstract Set getEntries();
  
  public Set getKeys()
  {
    return super.keySet();
  }
  
  public int getSize()
  {
    return super.size();
  }
  
  public Collection getValues()
  {
    return super.values();
  }
  
  public final Set<K> keySet()
  {
    return getKeys();
  }
  
  @Nullable
  public abstract V put(K paramK, V paramV);
  
  public final int size()
  {
    return getSize();
  }
  
  public final Collection<V> values()
  {
    return getValues();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.AbstractMutableMap
 * JD-Core Version:    0.7.0.1
 */