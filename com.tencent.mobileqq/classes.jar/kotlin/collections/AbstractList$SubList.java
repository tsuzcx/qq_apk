package kotlin.collections;

import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/AbstractList$SubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "fromIndex", "", "toIndex", "(Lkotlin/collections/AbstractList;II)V", "_size", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class AbstractList$SubList<E>
  extends AbstractList<E>
  implements RandomAccess
{
  private int _size;
  private final int fromIndex;
  private final AbstractList<E> list;
  
  public AbstractList$SubList(@NotNull AbstractList<? extends E> paramAbstractList, int paramInt1, int paramInt2)
  {
    this.list = paramAbstractList;
    this.fromIndex = paramInt1;
    AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(this.fromIndex, paramInt2, this.list.size());
    this._size = (paramInt2 - this.fromIndex);
  }
  
  public E get(int paramInt)
  {
    AbstractList.Companion.checkElementIndex$kotlin_stdlib(paramInt, this._size);
    return this.list.get(this.fromIndex + paramInt);
  }
  
  public int getSize()
  {
    return this._size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.AbstractList.SubList
 * JD-Core Version:    0.7.0.1
 */