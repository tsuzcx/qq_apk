package shark.internal;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"shark/internal/LruCache$2", "Ljava/util/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "shark-graph"}, k=1, mv={1, 4, 1})
public final class LruCache$2
  extends LinkedHashMap<K, V>
{
  LruCache$2(int paramInt, float paramFloat, boolean paramBoolean)
  {
    super(paramFloat, paramBoolean, bool);
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    return getEntries();
  }
  
  public Set getEntries()
  {
    return super.entrySet();
  }
  
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
  
  protected boolean removeEldestEntry(@Nullable Map.Entry<K, V> paramEntry)
  {
    if (size() > this.this$0.b())
    {
      paramEntry = this.this$0;
      LruCache.a(paramEntry, paramEntry.a() + 1);
      return true;
    }
    return false;
  }
  
  public final int size()
  {
    return getSize();
  }
  
  public final Collection<V> values()
  {
    return getValues();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.internal.LruCache.2
 * JD-Core Version:    0.7.0.1
 */