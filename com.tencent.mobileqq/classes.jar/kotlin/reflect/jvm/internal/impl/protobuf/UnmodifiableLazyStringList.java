package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class UnmodifiableLazyStringList
  extends AbstractList<String>
  implements RandomAccess, LazyStringList
{
  private final LazyStringList list;
  
  public UnmodifiableLazyStringList(LazyStringList paramLazyStringList)
  {
    this.list = paramLazyStringList;
  }
  
  public void add(ByteString paramByteString)
  {
    throw new UnsupportedOperationException();
  }
  
  public String get(int paramInt)
  {
    return (String)this.list.get(paramInt);
  }
  
  public ByteString getByteString(int paramInt)
  {
    return this.list.getByteString(paramInt);
  }
  
  public List<?> getUnderlyingElements()
  {
    return this.list.getUnderlyingElements();
  }
  
  public LazyStringList getUnmodifiableView()
  {
    return this;
  }
  
  public Iterator<String> iterator()
  {
    return new UnmodifiableLazyStringList.2(this);
  }
  
  public ListIterator<String> listIterator(int paramInt)
  {
    return new UnmodifiableLazyStringList.1(this, paramInt);
  }
  
  public int size()
  {
    return this.list.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.UnmodifiableLazyStringList
 * JD-Core Version:    0.7.0.1
 */