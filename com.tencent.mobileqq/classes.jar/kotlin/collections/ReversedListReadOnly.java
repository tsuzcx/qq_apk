package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/collections/ReversedListReadOnly;", "T", "Lkotlin/collections/AbstractList;", "delegate", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "get", "index", "(I)Ljava/lang/Object;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
class ReversedListReadOnly<T>
  extends AbstractList<T>
{
  private final List<T> delegate;
  
  public ReversedListReadOnly(@NotNull List<? extends T> paramList)
  {
    this.delegate = paramList;
  }
  
  public T get(int paramInt)
  {
    return this.delegate.get(CollectionsKt__ReversedViewsKt.access$reverseElementIndex(this, paramInt));
  }
  
  public int getSize()
  {
    return this.delegate.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.collections.ReversedListReadOnly
 * JD-Core Version:    0.7.0.1
 */