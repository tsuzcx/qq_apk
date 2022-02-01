package com.tencent.tfd.sdk.wxa;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class new
{
  public ByteBuffer j = ByteBuffer.allocate(128);
  public String k = "GBK";
  
  public void a(byte paramByte, int paramInt)
  {
    c(3);
    if (paramByte == 0)
    {
      b((byte)12, paramInt);
      return;
    }
    b((byte)0, paramInt);
    this.j.put(paramByte);
  }
  
  public void a(long paramLong, int paramInt)
  {
    c(10);
    if ((paramLong >= -2147483648L) && (paramLong <= 2147483647L))
    {
      b((int)paramLong, paramInt);
      return;
    }
    b((byte)3, paramInt);
    this.j.putLong(paramLong);
  }
  
  public void a(try paramtry, int paramInt)
  {
    c(2);
    b((byte)10, paramInt);
    paramtry.a(this);
    c(2);
    b((byte)11, 0);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof Byte))
    {
      a(((Byte)paramObject).byteValue(), paramInt);
      return;
    }
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
      b(((Integer)paramObject).intValue(), paramInt);
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
      c(6);
      b((byte)4, paramInt);
      this.j.putFloat(f);
      return;
    }
    double d;
    if ((paramObject instanceof Double))
    {
      d = ((Double)paramObject).doubleValue();
      c(10);
      b((byte)5, paramInt);
      this.j.putDouble(d);
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
    if ((paramObject instanceof try))
    {
      a((try)paramObject, paramInt);
      return;
    }
    if ((paramObject instanceof byte[]))
    {
      paramObject = (byte[])paramObject;
      c(paramObject.length + 8);
      b((byte)13, paramInt);
      b((byte)0, 0);
      b(paramObject.length, 0);
      this.j.put(paramObject);
      return;
    }
    int i;
    if ((paramObject instanceof boolean[]))
    {
      paramObject = (boolean[])paramObject;
      c(8);
      b((byte)9, paramInt);
      b(paramObject.length, 0);
      i = paramObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        a(paramObject[paramInt], 0);
        paramInt += 1;
      }
    }
    if ((paramObject instanceof short[]))
    {
      paramObject = (short[])paramObject;
      c(8);
      b((byte)9, paramInt);
      b(paramObject.length, 0);
      i = paramObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        a(paramObject[paramInt], 0);
        paramInt += 1;
      }
    }
    if ((paramObject instanceof int[]))
    {
      paramObject = (int[])paramObject;
      c(8);
      b((byte)9, paramInt);
      b(paramObject.length, 0);
      i = paramObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        b(paramObject[paramInt], 0);
        paramInt += 1;
      }
    }
    if ((paramObject instanceof long[]))
    {
      paramObject = (long[])paramObject;
      c(8);
      b((byte)9, paramInt);
      b(paramObject.length, 0);
      i = paramObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        a(paramObject[paramInt], 0);
        paramInt += 1;
      }
    }
    if ((paramObject instanceof float[]))
    {
      paramObject = (float[])paramObject;
      c(8);
      b((byte)9, paramInt);
      b(paramObject.length, 0);
      i = paramObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        f = paramObject[paramInt];
        c(6);
        b((byte)4, 0);
        this.j.putFloat(f);
        paramInt += 1;
      }
    }
    if ((paramObject instanceof double[]))
    {
      paramObject = (double[])paramObject;
      c(8);
      b((byte)9, paramInt);
      b(paramObject.length, 0);
      i = paramObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        d = paramObject[paramInt];
        c(10);
        b((byte)5, 0);
        this.j.putDouble(d);
        paramInt += 1;
      }
    }
    if (paramObject.getClass().isArray())
    {
      paramObject = (Object[])paramObject;
      c(8);
      b((byte)9, paramInt);
      b(paramObject.length, 0);
      i = paramObject.length;
      paramInt = 0;
      while (paramInt < i)
      {
        a(paramObject[paramInt], 0);
        paramInt += 1;
      }
    }
    if ((paramObject instanceof Collection))
    {
      a((Collection)paramObject, paramInt);
      return;
    }
    StringBuilder localStringBuilder = do.b("write object error: unsupport type. ");
    localStringBuilder.append(paramObject.getClass());
    paramObject = new for(localStringBuilder.toString());
    for (;;)
    {
      throw paramObject;
    }
  }
  
  public <T> void a(Collection<T> paramCollection, int paramInt)
  {
    c(8);
    b((byte)9, paramInt);
    if (paramCollection == null) {
      paramInt = 0;
    } else {
      paramInt = paramCollection.size();
    }
    b(paramInt, 0);
    if (paramCollection != null)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext()) {
        a(paramCollection.next(), 0);
      }
    }
  }
  
  public <K, V> void a(Map<K, V> paramMap, int paramInt)
  {
    c(8);
    b((byte)8, paramInt);
    if (paramMap == null) {
      paramInt = 0;
    } else {
      paramInt = paramMap.size();
    }
    b(paramInt, 0);
    if (paramMap != null)
    {
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
    c(4);
    if ((paramShort >= -128) && (paramShort <= 127))
    {
      a((byte)paramShort, paramInt);
      return;
    }
    b((byte)1, paramInt);
    this.j.putShort(paramShort);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    a((byte)paramBoolean, paramInt);
  }
  
  public void b(byte paramByte, int paramInt)
  {
    byte b;
    if (paramInt < 15)
    {
      b = (byte)(paramByte | paramInt << 4);
      this.j.put(b);
      return;
    }
    if (paramInt < 256)
    {
      b = (byte)(paramByte | 0xF0);
      this.j.put(b);
      this.j.put((byte)paramInt);
      return;
    }
    throw new for(do.a("tag is too large: ", paramInt));
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    c(6);
    if ((paramInt1 >= -32768) && (paramInt1 <= 32767))
    {
      a((short)paramInt1, paramInt2);
      return;
    }
    b((byte)2, paramInt2);
    this.j.putInt(paramInt1);
  }
  
  public void b(String paramString, int paramInt)
  {
    try
    {
      byte[] arrayOfByte = paramString.getBytes(this.k);
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label14:
      break label14;
    }
    paramString = paramString.getBytes();
    c(paramString.length + 10);
    if (paramString.length > 255)
    {
      b((byte)7, paramInt);
      this.j.putInt(paramString.length);
      this.j.put(paramString);
      return;
    }
    b((byte)6, paramInt);
    this.j.put((byte)paramString.length);
    this.j.put(paramString);
  }
  
  public void c(int paramInt)
  {
    if (this.j.remaining() < paramInt)
    {
      ByteBuffer localByteBuffer = ByteBuffer.allocate((this.j.capacity() + paramInt) * 2);
      localByteBuffer.put(this.j.array(), 0, this.j.position());
      this.j = localByteBuffer;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.new
 * JD-Core Version:    0.7.0.1
 */