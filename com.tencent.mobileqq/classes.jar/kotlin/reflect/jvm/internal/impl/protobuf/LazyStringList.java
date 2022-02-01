package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.List;

public abstract interface LazyStringList
  extends ProtocolStringList
{
  public abstract void add(ByteString paramByteString);
  
  public abstract ByteString getByteString(int paramInt);
  
  public abstract List<?> getUnderlyingElements();
  
  public abstract LazyStringList getUnmodifiableView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.LazyStringList
 * JD-Core Version:    0.7.0.1
 */