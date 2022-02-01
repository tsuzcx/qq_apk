package kotlin.io;

import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/io/ExposingBufferByteArrayOutputStream;", "Ljava/io/ByteArrayOutputStream;", "size", "", "(I)V", "buffer", "", "getBuffer", "()[B", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ExposingBufferByteArrayOutputStream
  extends ByteArrayOutputStream
{
  public ExposingBufferByteArrayOutputStream(int paramInt)
  {
    super(paramInt);
  }
  
  @NotNull
  public final byte[] getBuffer()
  {
    byte[] arrayOfByte = this.buf;
    Intrinsics.checkExpressionValueIsNotNull(arrayOfByte, "buf");
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     kotlin.io.ExposingBufferByteArrayOutputStream
 * JD-Core Version:    0.7.0.1
 */