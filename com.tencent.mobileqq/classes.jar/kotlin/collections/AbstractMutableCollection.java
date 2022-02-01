package kotlin.collections;

import java.util.AbstractCollection;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.markers.KMutableCollection;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractMutableCollection;", "E", "", "Ljava/util/AbstractCollection;", "()V", "add", "", "element", "(Ljava/lang/Object;)Z", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
@SinceKotlin(version="1.1")
public abstract class AbstractMutableCollection<E>
  extends AbstractCollection<E>
  implements Collection<E>, KMutableCollection
{
  public abstract boolean add(E paramE);
  
  public abstract int getSize();
  
  public final int size()
  {
    return getSize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.AbstractMutableCollection
 * JD-Core Version:    0.7.0.1
 */