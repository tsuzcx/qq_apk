package okio;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/Buffer$inputStream$1", "Ljava/io/InputStream;", "available", "", "close", "", "read", "sink", "", "offset", "byteCount", "toString", "", "okio"}, k=1, mv={1, 1, 16})
public final class Buffer$inputStream$1
  extends InputStream
{
  public int available()
  {
    return (int)Math.min(this.this$0.size(), 2147483647);
  }
  
  public void close() {}
  
  public int read()
  {
    if (this.this$0.size() > 0L) {
      return this.this$0.readByte() & 0xFF;
    }
    return -1;
  }
  
  public int read(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "sink");
    return this.this$0.read(paramArrayOfByte, paramInt1, paramInt2);
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
 * Qualified Name:     okio.Buffer.inputStream.1
 * JD-Core Version:    0.7.0.1
 */