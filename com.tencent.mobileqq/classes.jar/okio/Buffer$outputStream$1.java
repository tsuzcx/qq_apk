package okio;

import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"okio/Buffer$outputStream$1", "Ljava/io/OutputStream;", "close", "", "flush", "toString", "", "write", "data", "", "offset", "", "byteCount", "b", "okio"}, k=1, mv={1, 1, 16})
public final class Buffer$outputStream$1
  extends OutputStream
{
  public void close() {}
  
  public void flush() {}
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0);
    localStringBuilder.append(".outputStream()");
    return localStringBuilder.toString();
  }
  
  public void write(int paramInt)
  {
    this.this$0.writeByte(paramInt);
  }
  
  public void write(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "data");
    this.this$0.write(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     okio.Buffer.outputStream.1
 * JD-Core Version:    0.7.0.1
 */