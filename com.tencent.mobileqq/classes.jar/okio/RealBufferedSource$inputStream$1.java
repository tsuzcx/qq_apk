package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/RealBufferedSource$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "data", "", "offset", "byteCount", "toString", "", "okio"}, k=1, mv={1, 1, 16})
public final class RealBufferedSource$inputStream$1
  extends InputStream
{
  public int available()
  {
    if (!this.this$0.closed) {
      return (int)Math.min(this.this$0.bufferField.size(), 2147483647);
    }
    throw ((Throwable)new IOException("closed"));
  }
  
  public void close()
  {
    this.this$0.close();
  }
  
  public int read()
  {
    if (!this.this$0.closed)
    {
      if ((this.this$0.bufferField.size() == 0L) && (this.this$0.source.read(this.this$0.bufferField, 8192) == -1L)) {
        return -1;
      }
      return this.this$0.bufferField.readByte() & 0xFF;
    }
    throw ((Throwable)new IOException("closed"));
  }
  
  public int read(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    if (!this.this$0.closed)
    {
      -Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
      if ((this.this$0.bufferField.size() == 0L) && (this.this$0.source.read(this.this$0.bufferField, 8192) == -1L)) {
        return -1;
      }
      return this.this$0.bufferField.read(paramArrayOfByte, paramInt1, paramInt2);
    }
    throw ((Throwable)new IOException("closed"));
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0);
    localStringBuilder.append(".inputStream()");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.RealBufferedSource.inputStream.1
 * JD-Core Version:    0.7.0.1
 */