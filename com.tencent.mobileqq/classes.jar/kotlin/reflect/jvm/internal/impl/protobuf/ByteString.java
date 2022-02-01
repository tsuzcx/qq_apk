package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class ByteString
  implements Iterable<Byte>
{
  public static final ByteString EMPTY = new LiteralByteString(new byte[0]);
  
  private static ByteString balancedConcat(Iterator<ByteString> paramIterator, int paramInt)
  {
    if (paramInt == 1) {
      return (ByteString)paramIterator.next();
    }
    int i = paramInt >>> 1;
    return balancedConcat(paramIterator, i).concat(balancedConcat(paramIterator, paramInt - i));
  }
  
  public static ByteString copyFrom(Iterable<ByteString> paramIterable)
  {
    if (!(paramIterable instanceof Collection))
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramIterable.iterator();
      for (;;)
      {
        paramIterable = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localArrayList.add((ByteString)localIterator.next());
      }
    }
    paramIterable = (Collection)paramIterable;
    if (paramIterable.isEmpty()) {
      return EMPTY;
    }
    return balancedConcat(paramIterable.iterator(), paramIterable.size());
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfByte)
  {
    return copyFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static ByteString copyFrom(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return new LiteralByteString(arrayOfByte);
  }
  
  public static ByteString copyFromUtf8(String paramString)
  {
    try
    {
      paramString = new LiteralByteString(paramString.getBytes("UTF-8"));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported?", paramString);
    }
  }
  
  public static ByteString.Output newOutput()
  {
    return new ByteString.Output(128);
  }
  
  public ByteString concat(ByteString paramByteString)
  {
    int i = size();
    int j = paramByteString.size();
    if (i + j < 2147483647L) {
      return RopeByteString.concatenate(this, paramByteString);
    }
    paramByteString = new StringBuilder(53);
    paramByteString.append("ByteString would be too long: ");
    paramByteString.append(i);
    paramByteString.append("+");
    paramByteString.append(j);
    throw new IllegalArgumentException(paramByteString.toString());
  }
  
  public void copyTo(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 >= 0)
      {
        if (paramInt3 >= 0)
        {
          int i = paramInt1 + paramInt3;
          if (i <= size())
          {
            i = paramInt2 + paramInt3;
            if (i <= paramArrayOfByte.length)
            {
              if (paramInt3 > 0) {
                copyToInternal(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
              }
              return;
            }
            paramArrayOfByte = new StringBuilder(34);
            paramArrayOfByte.append("Target end offset < 0: ");
            paramArrayOfByte.append(i);
            throw new IndexOutOfBoundsException(paramArrayOfByte.toString());
          }
          paramArrayOfByte = new StringBuilder(34);
          paramArrayOfByte.append("Source end offset < 0: ");
          paramArrayOfByte.append(i);
          throw new IndexOutOfBoundsException(paramArrayOfByte.toString());
        }
        paramArrayOfByte = new StringBuilder(23);
        paramArrayOfByte.append("Length < 0: ");
        paramArrayOfByte.append(paramInt3);
        throw new IndexOutOfBoundsException(paramArrayOfByte.toString());
      }
      paramArrayOfByte = new StringBuilder(30);
      paramArrayOfByte.append("Target offset < 0: ");
      paramArrayOfByte.append(paramInt2);
      throw new IndexOutOfBoundsException(paramArrayOfByte.toString());
    }
    paramArrayOfByte = new StringBuilder(30);
    paramArrayOfByte.append("Source offset < 0: ");
    paramArrayOfByte.append(paramInt1);
    throw new IndexOutOfBoundsException(paramArrayOfByte.toString());
  }
  
  protected abstract void copyToInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract int getTreeDepth();
  
  protected abstract boolean isBalanced();
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public abstract boolean isValidUtf8();
  
  public abstract ByteString.ByteIterator iterator();
  
  public abstract CodedInputStream newCodedInput();
  
  protected abstract int partialHash(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract int partialIsValidUtf8(int paramInt1, int paramInt2, int paramInt3);
  
  protected abstract int peekCachedHashCode();
  
  public abstract int size();
  
  public byte[] toByteArray()
  {
    int i = size();
    if (i == 0) {
      return Internal.EMPTY_BYTE_ARRAY;
    }
    byte[] arrayOfByte = new byte[i];
    copyToInternal(arrayOfByte, 0, 0, i);
    return arrayOfByte;
  }
  
  public String toString()
  {
    return String.format("<ByteString@%s size=%d>", new Object[] { Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()) });
  }
  
  public abstract String toString(String paramString);
  
  public String toStringUtf8()
  {
    try
    {
      String str = toString("UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      throw new RuntimeException("UTF-8 not supported?", localUnsupportedEncodingException);
    }
  }
  
  void writeTo(OutputStream paramOutputStream, int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      if (paramInt2 >= 0)
      {
        int i = paramInt1 + paramInt2;
        if (i <= size())
        {
          if (paramInt2 > 0) {
            writeToInternal(paramOutputStream, paramInt1, paramInt2);
          }
          return;
        }
        paramOutputStream = new StringBuilder(39);
        paramOutputStream.append("Source end offset exceeded: ");
        paramOutputStream.append(i);
        throw new IndexOutOfBoundsException(paramOutputStream.toString());
      }
      paramOutputStream = new StringBuilder(23);
      paramOutputStream.append("Length < 0: ");
      paramOutputStream.append(paramInt2);
      throw new IndexOutOfBoundsException(paramOutputStream.toString());
    }
    paramOutputStream = new StringBuilder(30);
    paramOutputStream.append("Source offset < 0: ");
    paramOutputStream.append(paramInt1);
    throw new IndexOutOfBoundsException(paramOutputStream.toString());
  }
  
  abstract void writeToInternal(OutputStream paramOutputStream, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.protobuf.ByteString
 * JD-Core Version:    0.7.0.1
 */