package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class LazyStringArrayList
  extends AbstractList<String>
  implements RandomAccess, LazyStringList
{
  public static final LazyStringList EMPTY = new LazyStringArrayList().getUnmodifiableView();
  private final List<Object> list;
  
  public LazyStringArrayList()
  {
    this.list = new ArrayList();
  }
  
  public LazyStringArrayList(LazyStringList paramLazyStringList)
  {
    this.list = new ArrayList(paramLazyStringList.size());
    addAll(paramLazyStringList);
  }
  
  private static ByteString asByteString(Object paramObject)
  {
    if ((paramObject instanceof ByteString)) {
      return (ByteString)paramObject;
    }
    if ((paramObject instanceof String)) {
      return ByteString.copyFromUtf8((String)paramObject);
    }
    return ByteString.copyFrom((byte[])paramObject);
  }
  
  private static String asString(Object paramObject)
  {
    if ((paramObject instanceof String)) {
      return (String)paramObject;
    }
    if ((paramObject instanceof ByteString)) {
      return ((ByteString)paramObject).toStringUtf8();
    }
    return Internal.toStringUtf8((byte[])paramObject);
  }
  
  public void add(int paramInt, String paramString)
  {
    this.list.add(paramInt, paramString);
    this.modCount += 1;
  }
  
  public void add(ByteString paramByteString)
  {
    this.list.add(paramByteString);
    this.modCount += 1;
  }
  
  public boolean addAll(int paramInt, Collection<? extends String> paramCollection)
  {
    Object localObject = paramCollection;
    if ((paramCollection instanceof LazyStringList)) {
      localObject = ((LazyStringList)paramCollection).getUnderlyingElements();
    }
    boolean bool = this.list.addAll(paramInt, (Collection)localObject);
    this.modCount += 1;
    return bool;
  }
  
  public boolean addAll(Collection<? extends String> paramCollection)
  {
    return addAll(size(), paramCollection);
  }
  
  public void clear()
  {
    this.list.clear();
    this.modCount += 1;
  }
  
  public String get(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    if ((localObject instanceof ByteString))
    {
      localObject = (ByteString)localObject;
      str = ((ByteString)localObject).toStringUtf8();
      if (((ByteString)localObject).isValidUtf8()) {
        this.list.set(paramInt, str);
      }
      return str;
    }
    localObject = (byte[])localObject;
    String str = Internal.toStringUtf8((byte[])localObject);
    if (Internal.isValidUtf8((byte[])localObject)) {
      this.list.set(paramInt, str);
    }
    return str;
  }
  
  public ByteString getByteString(int paramInt)
  {
    Object localObject = this.list.get(paramInt);
    ByteString localByteString = asByteString(localObject);
    if (localByteString != localObject) {
      this.list.set(paramInt, localByteString);
    }
    return localByteString;
  }
  
  public List<?> getUnderlyingElements()
  {
    return Collections.unmodifiableList(this.list);
  }
  
  public LazyStringList getUnmodifiableView()
  {
    return new UnmodifiableLazyStringList(this);
  }
  
  public String remove(int paramInt)
  {
    Object localObject = this.list.remove(paramInt);
    this.modCount += 1;
    return asString(localObject);
  }
  
  public String set(int paramInt, String paramString)
  {
    return asString(this.list.set(paramInt, paramString));
  }
  
  public int size()
  {
    return this.list.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.LazyStringArrayList
 * JD-Core Version:    0.7.0.1
 */