package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;

class UnmodifiableLazyStringList$2
  implements Iterator<String>
{
  Iterator<String> iter = UnmodifiableLazyStringList.access$000(this.this$0).iterator();
  
  UnmodifiableLazyStringList$2(UnmodifiableLazyStringList paramUnmodifiableLazyStringList) {}
  
  public boolean hasNext()
  {
    return this.iter.hasNext();
  }
  
  public String next()
  {
    return (String)this.iter.next();
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.UnmodifiableLazyStringList.2
 * JD-Core Version:    0.7.0.1
 */