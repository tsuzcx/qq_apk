package kotlin;

import java.util.NoSuchElementException;
import kotlin.collections.UByteIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/UByteArray$Iterator;", "Lkotlin/collections/UByteIterator;", "array", "", "([B)V", "index", "", "hasNext", "", "nextUByte", "Lkotlin/UByte;", "()B", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
final class UByteArray$Iterator
  extends UByteIterator
{
  private final byte[] array;
  private int index;
  
  public UByteArray$Iterator(@NotNull byte[] paramArrayOfByte)
  {
    this.array = paramArrayOfByte;
  }
  
  public boolean hasNext()
  {
    return this.index < this.array.length;
  }
  
  public byte nextUByte()
  {
    int i = this.index;
    byte[] arrayOfByte = this.array;
    if (i < arrayOfByte.length)
    {
      this.index = (i + 1);
      return UByte.constructor-impl(arrayOfByte[i]);
    }
    throw ((Throwable)new NoSuchElementException(String.valueOf(i)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     kotlin.UByteArray.Iterator
 * JD-Core Version:    0.7.0.1
 */