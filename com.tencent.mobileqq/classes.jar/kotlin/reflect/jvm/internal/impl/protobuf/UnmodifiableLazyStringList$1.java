package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.ListIterator;

class UnmodifiableLazyStringList$1
  implements ListIterator<String>
{
  ListIterator<String> iter = UnmodifiableLazyStringList.access$000(this.this$0).listIterator(this.val$index);
  
  UnmodifiableLazyStringList$1(UnmodifiableLazyStringList paramUnmodifiableLazyStringList, int paramInt) {}
  
  public void add(String paramString)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean hasNext()
  {
    return this.iter.hasNext();
  }
  
  public boolean hasPrevious()
  {
    return this.iter.hasPrevious();
  }
  
  public String next()
  {
    return (String)this.iter.next();
  }
  
  public int nextIndex()
  {
    return this.iter.nextIndex();
  }
  
  public String previous()
  {
    return (String)this.iter.previous();
  }
  
  public int previousIndex()
  {
    return this.iter.previousIndex();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
  
  public void set(String paramString)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.UnmodifiableLazyStringList.1
 * JD-Core Version:    0.7.0.1
 */