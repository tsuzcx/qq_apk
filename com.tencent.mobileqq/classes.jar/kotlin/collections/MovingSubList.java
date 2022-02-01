package kotlin.collections;

import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/MovingSubList;", "E", "Lkotlin/collections/AbstractList;", "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "list", "", "(Ljava/util/List;)V", "_size", "", "fromIndex", "size", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "move", "", "toIndex", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class MovingSubList<E>
  extends AbstractList<E>
  implements RandomAccess
{
  private int _size;
  private int fromIndex;
  private final List<E> list;
  
  public MovingSubList(@NotNull List<? extends E> paramList)
  {
    this.list = paramList;
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
  
  public final void move(int paramInt1, int paramInt2)
  {
    AbstractList.Companion.checkRangeIndexes$kotlin_stdlib(paramInt1, paramInt2, this.list.size());
    this.fromIndex = paramInt1;
    this._size = (paramInt2 - paramInt1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.MovingSubList
 * JD-Core Version:    0.7.0.1
 */