package com.tencent.mtt.hippy.utils;

import android.util.LruCache;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import java.nio.charset.Charset;

final class HippyBuffer$Parser
{
  private static final int MAX_CHAR_BUFFER_SIZE = 32;
  private static final int PROPERTY_HASH_VALUE = 5381;
  private byte[] mBuffer;
  private int mPosition;
  private char[] mPropsCharBuffer;
  
  private HippyBuffer$Parser(HippyBuffer paramHippyBuffer, byte[] paramArrayOfByte)
  {
    this.mBuffer = paramArrayOfByte;
    this.mPosition = 0;
    this.mPropsCharBuffer = ((char[])HippyBuffer.access$600().get());
    if (this.mPropsCharBuffer != null)
    {
      HippyBuffer.access$600().set(null);
      return;
    }
    this.mPropsCharBuffer = new char[33];
  }
  
  private final int hashCodeOfBuffer(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt2)
    {
      j = j * 31 + paramArrayOfByte[(paramInt1 + i)];
      i += 1;
    }
    return j;
  }
  
  private final Object parse()
  {
    Object localObject2 = readObject();
    Object localObject1 = localObject2;
    if (localObject2 == HippyBuffer.access$700()) {
      localObject1 = null;
    }
    return localObject1;
  }
  
  private final HippyArray readArray()
  {
    int j = readUnsignedInt();
    HippyArray localHippyArray = new HippyArray();
    int i = 0;
    while (i < j)
    {
      localHippyArray.pushObject(readObject());
      i += 1;
    }
    return localHippyArray;
  }
  
  private final byte readDataType()
  {
    byte[] arrayOfByte = this.mBuffer;
    int i = this.mPosition;
    byte b = arrayOfByte[i];
    this.mPosition = (i + 1);
    return b;
  }
  
  private final Object readDouble()
  {
    double d1 = Double.longBitsToDouble(readLong());
    if (d1 > 2147483647.0D)
    {
      long l = d1;
      double d2 = l;
      Double.isNaN(d2);
      if (d1 - d2 < 2.225073858507201E-308D) {
        return Long.valueOf(l);
      }
    }
    return Double.valueOf(d1);
  }
  
  private final int readInteger()
  {
    int i = readUnsignedInt();
    return i & 0x80000000 ^ (i << 31 >> 31 ^ i) >> 1;
  }
  
  private final long readLong()
  {
    byte[] arrayOfByte = this.mBuffer;
    int i = this.mPosition;
    long l1 = arrayOfByte[(i + 7)];
    long l2 = arrayOfByte[(i + 6)];
    long l3 = arrayOfByte[(i + 5)];
    long l4 = arrayOfByte[(i + 4)];
    long l5 = arrayOfByte[(i + 3)];
    long l6 = arrayOfByte[(i + 2)];
    long l7 = arrayOfByte[(i + 1)];
    long l8 = arrayOfByte[i];
    this.mPosition = (i + 8);
    return (l1 & 0xFF) + ((l2 & 0xFF) << 8) + ((l3 & 0xFF) << 16) + ((l4 & 0xFF) << 24) + ((l5 & 0xFF) << 32) + ((l6 & 0xFF) << 40) + ((0xFF & l7) << 48) + (l8 << 56);
  }
  
  private final HippyMap readMap()
  {
    int j = readUnsignedInt();
    HippyMap localHippyMap = new HippyMap();
    int i = 0;
    while (i < j)
    {
      String str = readProperty();
      Object localObject = readObject(str);
      if (localObject != HippyBuffer.access$700()) {
        localHippyMap.pushObject(str, localObject);
      }
      i += 1;
    }
    return localHippyMap;
  }
  
  private final Object readObject()
  {
    return readObject(null);
  }
  
  private final Object readObject(String paramString)
  {
    int i = readDataType();
    switch (i)
    {
    default: 
      paramString = new StringBuilder();
      paramString.append("unknown hippy-buffer type ");
      paramString.append(i);
      paramString.append(" at ");
      paramString.append(this.mPosition);
      paramString.append(", total buffer length =");
      paramString.append(this.mBuffer.length);
      throw new RuntimeException(paramString.toString());
    case 8: 
      return readString(paramString, true);
    case 7: 
      return readMap();
    case 6: 
      return readArray();
    case 5: 
      return readDouble();
    case 4: 
      return Integer.valueOf(readInteger());
    case 3: 
      return Boolean.FALSE;
    case 2: 
      return Boolean.TRUE;
    case 1: 
      return readString(paramString, false);
    case 0: 
      return null;
    }
    return HippyBuffer.access$700();
  }
  
  private final String readProperty()
  {
    int n = readUnsignedInt();
    Object localObject1;
    if (n > 32)
    {
      localObject1 = new String(this.mBuffer, this.mPosition, n);
    }
    else
    {
      int i = this.mPosition;
      int m = 0;
      int j = 0;
      int k = 5381;
      while (j < n)
      {
        k = (k << 5) + k + (char)this.mBuffer[i];
        i += 1;
        j += 1;
      }
      j = HippyBuffer.access$800().length - 1 & k;
      localObject1 = HippyBuffer.access$800()[j];
      Object localObject2 = null;
      if (localObject1 != null) {
        if (((String)localObject1).length() != n)
        {
          localObject1 = localObject2;
        }
        else
        {
          ((String)localObject1).getChars(0, n, this.mPropsCharBuffer, 0);
          i = m;
          while (i < n)
          {
            if (this.mBuffer[(this.mPosition + i)] != this.mPropsCharBuffer[i])
            {
              localObject1 = localObject2;
              break;
            }
            i += 1;
          }
        }
      }
      if (localObject1 == null)
      {
        localObject1 = new String(this.mBuffer, this.mPosition, n);
        HippyBuffer.access$800()[j] = localObject1;
      }
    }
    this.mPosition += n;
    return localObject1;
  }
  
  private String readString(String paramString, boolean paramBoolean)
  {
    int k = readUnsignedInt();
    Object localObject;
    if (!paramBoolean) {
      localObject = Charset.defaultCharset();
    } else {
      localObject = HippyBuffer.access$900();
    }
    if ((!"uri".equals(paramString)) && (!"src".equals(paramString)))
    {
      paramString = new String(this.mBuffer, this.mPosition, k, (Charset)localObject);
    }
    else if (k < HippyBuffer.access$1000().length)
    {
      paramString = new String(this.mBuffer, this.mPosition, k, (Charset)localObject);
    }
    else
    {
      int m = this.mBuffer[this.mPosition];
      paramString = HippyBuffer.access$1000();
      int j = 0;
      int i = j;
      if (m == paramString[0])
      {
        i = 1;
        while (i < HippyBuffer.access$1000().length)
        {
          if (this.mBuffer[(this.mPosition + i)] != HippyBuffer.access$1000()[i])
          {
            i = j;
            break label172;
          }
          i += 1;
        }
        i = 1;
      }
      label172:
      if (i != 0)
      {
        i = hashCodeOfBuffer(this.mBuffer, this.mPosition, k);
        HippyBuffer.access$1108(this.this$0);
        paramString = (HippyBuffer.CacheItem)HippyBuffer.access$1200(this.this$0).get(Integer.valueOf(i));
        if ((paramString != null) && (paramString.length == k))
        {
          paramString = paramString.content;
          HippyBuffer.access$1408(this.this$0);
        }
        else
        {
          paramString = new String(this.mBuffer, this.mPosition, k, (Charset)localObject);
          localObject = new HippyBuffer.CacheItem(null);
          ((HippyBuffer.CacheItem)localObject).content = paramString;
          ((HippyBuffer.CacheItem)localObject).length = k;
          HippyBuffer.access$1200(this.this$0).put(Integer.valueOf(i), localObject);
        }
      }
      else
      {
        paramString = new String(this.mBuffer, this.mPosition, k, (Charset)localObject);
      }
    }
    this.mPosition += k;
    return paramString;
  }
  
  private final int readUnsignedInt()
  {
    int j = 0;
    int i = 0;
    int k;
    int m;
    do
    {
      byte[] arrayOfByte = this.mBuffer;
      k = this.mPosition;
      m = arrayOfByte[k];
      if ((m & 0x80) == 0) {
        break;
      }
      j |= (m & 0x7F) << i;
      i += 7;
      this.mPosition = (k + 1);
    } while (i <= 35);
    throw new IllegalArgumentException("Data length quantity is too long");
    this.mPosition = (k + 1);
    return j | m << i;
  }
  
  private final void release()
  {
    this.mPosition = 0;
    this.mBuffer = null;
    if (this.mPropsCharBuffer != null) {
      HippyBuffer.access$600().set(this.mPropsCharBuffer);
    }
    this.mPropsCharBuffer = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.HippyBuffer.Parser
 * JD-Core Version:    0.7.0.1
 */