package kotlin.collections;

import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/collections/AbstractMap$values$1", "Lkotlin/collections/AbstractCollection;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class AbstractMap$values$1
  extends AbstractCollection<V>
{
  public boolean contains(Object paramObject)
  {
    return this.this$0.containsValue(paramObject);
  }
  
  public int getSize()
  {
    return this.this$0.size();
  }
  
  @NotNull
  public Iterator<V> iterator()
  {
    return (Iterator)new AbstractMap.values.1.iterator.1(this.this$0.entrySet().iterator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.collections.AbstractMap.values.1
 * JD-Core Version:    0.7.0.1
 */