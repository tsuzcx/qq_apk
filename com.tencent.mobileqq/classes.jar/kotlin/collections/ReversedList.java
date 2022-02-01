package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/ReversedList;", "T", "Lkotlin/collections/AbstractMutableList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "add", "", "index", "element", "(ILjava/lang/Object;)V", "clear", "get", "(I)Ljava/lang/Object;", "removeAt", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ReversedList<T>
  extends AbstractMutableList<T>
{
  private final List<T> delegate;
  
  public ReversedList(@NotNull List<T> paramList)
  {
    this.delegate = paramList;
  }
  
  public void add(int paramInt, T paramT)
  {
    this.delegate.add(CollectionsKt__ReversedViewsKt.access$reversePositionIndex(this, paramInt), paramT);
  }
  
  public void clear()
  {
    this.delegate.clear();
  }
  
  public T get(int paramInt)
  {
    return this.delegate.get(CollectionsKt__ReversedViewsKt.access$reverseElementIndex(this, paramInt));
  }
  
  public int getSize()
  {
    return this.delegate.size();
  }
  
  public T removeAt(int paramInt)
  {
    return this.delegate.remove(CollectionsKt__ReversedViewsKt.access$reverseElementIndex(this, paramInt));
  }
  
  public T set(int paramInt, T paramT)
  {
    return this.delegate.set(CollectionsKt__ReversedViewsKt.access$reverseElementIndex(this, paramInt), paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.collections.ReversedList
 * JD-Core Version:    0.7.0.1
 */