package kotlin.jvm.internal;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.ByteIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/ArrayByteIterator;", "Lkotlin/collections/ByteIterator;", "array", "", "([B)V", "index", "", "hasNext", "", "nextByte", "", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class ArrayByteIterator
  extends ByteIterator
{
  private final byte[] array;
  private int index;
  
  public ArrayByteIterator(@NotNull byte[] paramArrayOfByte)
  {
    this.array = paramArrayOfByte;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public byte nextByte()
  {
    try
    {
      byte[] arrayOfByte = this.array;
      int i = this.index;
      this.index = (i + 1);
      byte b = arrayOfByte[i];
      return b;
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      this.index -= 1;
      throw ((Throwable)new NoSuchElementException(localArrayIndexOutOfBoundsException.getMessage()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     kotlin.jvm.internal.ArrayByteIterator
 * JD-Core Version:    0.7.0.1
 */