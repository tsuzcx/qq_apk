package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.FilterInputStream;
import java.io.InputStream;

final class AbstractMessageLite$Builder$LimitedInputStream
  extends FilterInputStream
{
  private int limit;
  
  AbstractMessageLite$Builder$LimitedInputStream(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream);
    this.limit = paramInt;
  }
  
  public int available()
  {
    return Math.min(super.available(), this.limit);
  }
  
  public int read()
  {
    if (this.limit <= 0) {
      return -1;
    }
    int i = super.read();
    if (i >= 0) {
      this.limit -= 1;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = this.limit;
    if (i <= 0) {
      return -1;
    }
    paramInt1 = super.read(paramArrayOfByte, paramInt1, Math.min(paramInt2, i));
    if (paramInt1 >= 0) {
      this.limit -= paramInt1;
    }
    return paramInt1;
  }
  
  public long skip(long paramLong)
  {
    paramLong = super.skip(Math.min(paramLong, this.limit));
    if (paramLong >= 0L) {
      this.limit = ((int)(this.limit - paramLong));
    }
    return paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.AbstractMessageLite.Builder.LimitedInputStream
 * JD-Core Version:    0.7.0.1
 */