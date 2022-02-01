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
    byte b = this.mBuffer[this.mPosition];
    this.mPosition += 1;
    return b;
  }
  
  private final Object readDouble()
  {
    double d = Double.longBitsToDouble(readLong());
    if (d > 2147483647.0D)
    {
      long l = d;
      if (d - l < 2.225073858507201E-308D) {
        return Long.valueOf(l);
      }
    }
    return Double.valueOf(d);
  }
  
  private final int readInteger()
  {
    int i = readUnsignedInt();
    return i & 0x80000000 ^ (i << 31 >> 31 ^ i) >> 1;
  }
  
  private final long readLong()
  {
    long l1 = this.mBuffer[(this.mPosition + 7)];
    long l2 = this.mBuffer[(this.mPosition + 6)];
    long l3 = this.mBuffer[(this.mPosition + 5)];
    long l4 = this.mBuffer[(this.mPosition + 4)];
    long l5 = this.mBuffer[(this.mPosition + 3)];
    long l6 = this.mBuffer[(this.mPosition + 2)];
    long l7 = this.mBuffer[(this.mPosition + 1)];
    long l8 = this.mBuffer[this.mPosition];
    this.mPosition += 8;
    return (l1 & 0xFF) + ((l2 & 0xFF) << 8) + ((l3 & 0xFF) << 16) + ((l4 & 0xFF) << 24) + ((l5 & 0xFF) << 32) + ((l6 & 0xFF) << 40) + ((l7 & 0xFF) << 48) + (l8 << 56);
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
      throw new RuntimeException("unknown hippy-buffer type " + i + " at " + this.mPosition + ", total buffer length =" + this.mBuffer.length);
    case 1: 
      return readString(paramString, false);
    case 8: 
      return readString(paramString, true);
    case 4: 
      return Integer.valueOf(readInteger());
    case 7: 
      return readMap();
    case 6: 
      return readArray();
    case 5: 
      return readDouble();
    case 3: 
      return Boolean.FALSE;
    case 2: 
      return Boolean.TRUE;
    case 0: 
      return null;
    }
    return HippyBuffer.access$700();
  }
  
  private final String readProperty()
  {
    Object localObject2 = null;
    int m = 0;
    int n = readUnsignedInt();
    if (n > 32)
    {
      localObject2 = new String(this.mBuffer, this.mPosition, n);
      this.mPosition += n;
      return localObject2;
    }
    int j = this.mPosition;
    int k = 5381;
    int i = 0;
    while (i < n)
    {
      k = k + (k << 5) + (char)this.mBuffer[j];
      j += 1;
      i += 1;
    }
    j = HippyBuffer.access$800().length - 1 & k;
    String str = HippyBuffer.access$800()[j];
    Object localObject1;
    if (str != null) {
      if (str.length() != n) {
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      localObject2 = new String(this.mBuffer, this.mPosition, n);
      HippyBuffer.access$800()[j] = localObject2;
      break;
      str.getChars(0, n, this.mPropsCharBuffer, 0);
      i = m;
      for (;;)
      {
        if (i >= n) {
          break label220;
        }
        localObject1 = localObject2;
        if (this.mBuffer[(this.mPosition + i)] != this.mPropsCharBuffer[i]) {
          break;
        }
        i += 1;
      }
      label220:
      localObject1 = str;
    }
  }
  
  private String readString(String paramString, boolean paramBoolean)
  {
    int k = 1;
    int m = readUnsignedInt();
    Object localObject;
    if (!paramBoolean)
    {
      localObject = Charset.defaultCharset();
      if ((!"uri".equals(paramString)) && (!"src".equals(paramString))) {
        break label315;
      }
      if (m >= HippyBuffer.access$1000().length) {
        break label86;
      }
      paramString = new String(this.mBuffer, this.mPosition, m, (Charset)localObject);
    }
    for (;;)
    {
      this.mPosition += m;
      return paramString;
      localObject = HippyBuffer.access$900();
      break;
      label86:
      int j;
      label106:
      int i;
      if (this.mBuffer[this.mPosition] == HippyBuffer.access$1000()[0])
      {
        j = 1;
        i = k;
        if (j < HippyBuffer.access$1000().length)
        {
          if (this.mBuffer[(this.mPosition + j)] == HippyBuffer.access$1000()[j]) {
            break label262;
          }
          i = 0;
        }
      }
      for (;;)
      {
        if (i != 0)
        {
          i = hashCodeOfBuffer(this.mBuffer, this.mPosition, m);
          HippyBuffer.access$1108(this.this$0);
          paramString = (HippyBuffer.CacheItem)HippyBuffer.access$1200(this.this$0).get(Integer.valueOf(i));
          if ((paramString == null) || (paramString.length != m))
          {
            paramString = new String(this.mBuffer, this.mPosition, m, (Charset)localObject);
            localObject = new HippyBuffer.CacheItem(null);
            ((HippyBuffer.CacheItem)localObject).content = paramString;
            ((HippyBuffer.CacheItem)localObject).length = m;
            HippyBuffer.access$1200(this.this$0).put(Integer.valueOf(i), localObject);
            break;
            label262:
            j += 1;
            break label106;
            i = 0;
            continue;
          }
          paramString = paramString.content;
          HippyBuffer.access$1408(this.this$0);
          break;
        }
      }
      paramString = new String(this.mBuffer, this.mPosition, m, (Charset)localObject);
      continue;
      label315:
      paramString = new String(this.mBuffer, this.mPosition, m, (Charset)localObject);
    }
  }
  
  private final int readUnsignedInt()
  {
    int i = 0;
    int j = 0;
    int k;
    do
    {
      k = this.mBuffer[this.mPosition];
      if ((k & 0x80) == 0) {
        break;
      }
      j |= (k & 0x7F) << i;
      k = i + 7;
      this.mPosition += 1;
      i = k;
    } while (k <= 35);
    throw new IllegalArgumentException("Data length quantity is too long");
    this.mPosition += 1;
    return k << i | j;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.HippyBuffer.Parser
 * JD-Core Version:    0.7.0.1
 */