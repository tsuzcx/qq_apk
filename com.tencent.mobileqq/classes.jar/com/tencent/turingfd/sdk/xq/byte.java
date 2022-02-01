package com.tencent.turingfd.sdk.xq;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class byte
{
  public ByteBuffer i;
  public String j = "GBK";
  
  public byte()
  {
    this(128);
  }
  
  public byte(int paramInt)
  {
    this.i = ByteBuffer.allocate(paramInt);
  }
  
  public void a(byte paramByte, int paramInt)
  {
    b(3);
    if (paramByte == 0)
    {
      b((byte)12, paramInt);
      return;
    }
    b((byte)0, paramInt);
    this.i.put(paramByte);
  }
  
  public void a(double paramDouble, int paramInt)
  {
    b(10);
    b((byte)5, paramInt);
    this.i.putDouble(paramDouble);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    b(6);
    if ((paramInt1 >= -32768) && (paramInt1 <= 32767))
    {
      a((short)paramInt1, paramInt2);
      return;
    }
    b((byte)2, paramInt2);
    this.i.putInt(paramInt1);
  }
  
  public void a(long paramLong, int paramInt)
  {
    b(10);
    if ((paramLong >= -2147483648L) && (paramLong <= 2147483647L))
    {
      a((int)paramLong, paramInt);
      return;
    }
    b((byte)3, paramInt);
    this.i.putLong(paramLong);
  }
  
  public void a(case paramcase, int paramInt)
  {
    b(2);
    b((byte)10, paramInt);
    paramcase.a(this);
    b(2);
    b((byte)11, 0);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Byte)) {
      a(((Byte)paramObject).byteValue(), paramInt);
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof Boolean))
      {
        a(((Boolean)paramObject).booleanValue(), paramInt);
        return;
      }
      if ((paramObject instanceof Short))
      {
        a(((Short)paramObject).shortValue(), paramInt);
        return;
      }
      if ((paramObject instanceof Integer))
      {
        a(((Integer)paramObject).intValue(), paramInt);
        return;
      }
      if ((paramObject instanceof Long))
      {
        a(((Long)paramObject).longValue(), paramInt);
        return;
      }
      float f;
      if ((paramObject instanceof Float))
      {
        f = ((Float)paramObject).floatValue();
        b(6);
        b((byte)4, paramInt);
        this.i.putFloat(f);
        return;
      }
      if ((paramObject instanceof Double))
      {
        a(((Double)paramObject).doubleValue(), paramInt);
        return;
      }
      if ((paramObject instanceof String))
      {
        b((String)paramObject, paramInt);
        return;
      }
      if ((paramObject instanceof Map))
      {
        a((Map)paramObject, paramInt);
        return;
      }
      if ((paramObject instanceof List))
      {
        a((List)paramObject, paramInt);
        return;
      }
      if ((paramObject instanceof case))
      {
        a((case)paramObject, paramInt);
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        a((byte[])paramObject, paramInt);
        return;
      }
      int k;
      if ((paramObject instanceof boolean[]))
      {
        paramObject = (boolean[])paramObject;
        b(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        k = paramObject.length;
        paramInt = 0;
        while (paramInt < k)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof short[]))
      {
        paramObject = (short[])paramObject;
        b(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        k = paramObject.length;
        paramInt = 0;
        while (paramInt < k)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof int[]))
      {
        paramObject = (int[])paramObject;
        b(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        k = paramObject.length;
        paramInt = 0;
        while (paramInt < k)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof long[]))
      {
        paramObject = (long[])paramObject;
        b(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        k = paramObject.length;
        paramInt = 0;
        while (paramInt < k)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof float[]))
      {
        paramObject = (float[])paramObject;
        b(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        k = paramObject.length;
        paramInt = 0;
        while (paramInt < k)
        {
          f = paramObject[paramInt];
          b(6);
          b((byte)4, 0);
          this.i.putFloat(f);
          paramInt += 1;
        }
      }
      else if ((paramObject instanceof double[]))
      {
        paramObject = (double[])paramObject;
        b(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        k = paramObject.length;
        paramInt = 0;
        while (paramInt < k)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
      else
      {
        if (!paramObject.getClass().isArray()) {
          break;
        }
        paramObject = (Object[])paramObject;
        b(8);
        b((byte)9, paramInt);
        a(paramObject.length, 0);
        k = paramObject.length;
        paramInt = 0;
        while (paramInt < k)
        {
          a(paramObject[paramInt], 0);
          paramInt += 1;
        }
      }
    }
    if ((paramObject instanceof Collection))
    {
      a((Collection)paramObject, paramInt);
      return;
    }
    throw new new(paramObject.getClass());
  }
  
  public <T> void a(Collection<T> paramCollection, int paramInt)
  {
    b(8);
    b((byte)9, paramInt);
    if (paramCollection == null) {}
    for (paramInt = 0;; paramInt = paramCollection.size())
    {
      a(paramInt, 0);
      if (paramCollection == null) {
        break;
      }
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        a(paramCollection.next(), 0);
      }
    }
  }
  
  public <K, V> void a(Map<K, V> paramMap, int paramInt)
  {
    b(8);
    b((byte)8, paramInt);
    if (paramMap == null) {}
    for (paramInt = 0;; paramInt = paramMap.size())
    {
      a(paramInt, 0);
      if (paramMap == null) {
        break;
      }
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        a(localEntry.getKey(), 0);
        a(localEntry.getValue(), 1);
      }
    }
  }
  
  public void a(short paramShort, int paramInt)
  {
    b(4);
    if ((paramShort >= -128) && (paramShort <= 127))
    {
      a((byte)paramShort, paramInt);
      return;
    }
    b((byte)1, paramInt);
    this.i.putShort(paramShort);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    a((byte)paramBoolean, paramInt);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    b(paramArrayOfByte.length + 8);
    b((byte)13, paramInt);
    b((byte)0, 0);
    a(paramArrayOfByte.length, 0);
    this.i.put(paramArrayOfByte);
  }
  
  public int b(String paramString)
  {
    this.j = paramString;
    return 0;
  }
  
  public void b(byte paramByte, int paramInt)
  {
    byte b;
    if (paramInt < 15)
    {
      b = (byte)(paramInt << 4 | paramByte);
      this.i.put(b);
      return;
    }
    if (paramInt < 256)
    {
      b = (byte)(paramByte | 0xF0);
      this.i.put(b);
      this.i.put((byte)paramInt);
      return;
    }
    throw new new(do.a("tag is too large: ", paramInt));
  }
  
  public void b(int paramInt)
  {
    if (this.i.remaining() < paramInt)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate((this.i.capacity() + paramInt) * 2);
      localByteBuffer.put(this.i.array(), 0, this.i.position());
      this.i = localByteBuffer;
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes(this.j);
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
      b((byte)6, paramInt);
      this.i.put((byte)paramString.length);
      this.i.put(paramString);
    }
    b(paramString.length + 10);
    if (paramString.length > 255)
    {
      b((byte)7, paramInt);
      this.i.putInt(paramString.length);
      this.i.put(paramString);
      return;
    }
  }
  
  public byte[] toByteArray()
  {
    byte[] arrayOfByte = new byte[this.i.position()];
    System.arraycopy(this.i.array(), 0, arrayOfByte, 0, this.i.position());
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.byte
 * JD-Core Version:    0.7.0.1
 */