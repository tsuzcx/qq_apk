package com.tencent.mtt.hippy.utils;

import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class HippyBuffer$Builder
{
  private static final int DEFAULT_BUFFER_SZIE = 2048;
  private static final ThreadLocal<byte[]> sLocalBuilderBuffer = new ThreadLocal();
  private static final ThreadLocal<ArrayList<Object>> sLocalRefStack = new ThreadLocal();
  private byte[] mBuffer = (byte[])sLocalBuilderBuffer.get();
  private int mPosition;
  private ArrayList<Object> mReferenceStack;
  
  private HippyBuffer$Builder()
  {
    if (this.mBuffer != null) {
      sLocalBuilderBuffer.set(null);
    } else {
      this.mBuffer = new byte[2048];
    }
    this.mReferenceStack = ((ArrayList)sLocalRefStack.get());
    if (this.mReferenceStack != null)
    {
      sLocalRefStack.set(null);
      return;
    }
    this.mReferenceStack = new ArrayList(16);
  }
  
  private final byte[] build(Object paramObject)
  {
    writeObject(paramObject);
    int i = this.mPosition;
    paramObject = new byte[i];
    System.arraycopy(this.mBuffer, 0, paramObject, 0, i);
    return paramObject;
  }
  
  private final void ensureBufferSize(int paramInt)
  {
    int i = paramInt + this.mPosition;
    byte[] arrayOfByte = this.mBuffer;
    if (i - arrayOfByte.length > 0)
    {
      int j = arrayOfByte.length << 1;
      paramInt = j;
      if (j < 16384) {
        paramInt = 16384;
      }
      if (paramInt - i < 0) {
        paramInt = i;
      }
      this.mBuffer = Arrays.copyOf(this.mBuffer, paramInt);
    }
  }
  
  private final void release()
  {
    byte[] arrayOfByte = this.mBuffer;
    if (arrayOfByte.length <= 16384) {
      sLocalBuilderBuffer.set(arrayOfByte);
    }
    if (this.mReferenceStack.isEmpty()) {
      sLocalRefStack.set(this.mReferenceStack);
    } else {
      this.mReferenceStack.clear();
    }
    this.mReferenceStack = null;
    this.mBuffer = null;
    this.mPosition = 0;
  }
  
  private final void writeDataType(byte paramByte)
  {
    byte[] arrayOfByte = this.mBuffer;
    int i = this.mPosition;
    arrayOfByte[i] = paramByte;
    this.mPosition = (i + 1);
  }
  
  private final void writeDouble(double paramDouble)
  {
    writeLong(Double.doubleToLongBits(paramDouble));
  }
  
  private final void writeFloat(float paramFloat)
  {
    int i = Float.floatToIntBits(paramFloat);
    byte[] arrayOfByte = this.mBuffer;
    int j = this.mPosition;
    arrayOfByte[(j + 3)] = ((byte)i);
    arrayOfByte[(j + 2)] = ((byte)(i >>> 8));
    arrayOfByte[(j + 1)] = ((byte)(i >>> 16));
    arrayOfByte[j] = ((byte)(i >>> 24));
    this.mPosition = (j + 4);
  }
  
  private final void writeInteger(int paramInt)
  {
    writeUnsignedInt(paramInt >> 31 ^ paramInt << 1);
  }
  
  private final void writeLong(long paramLong)
  {
    byte[] arrayOfByte = this.mBuffer;
    int i = this.mPosition;
    arrayOfByte[(i + 7)] = ((byte)(int)paramLong);
    arrayOfByte[(i + 6)] = ((byte)(int)(paramLong >>> 8));
    arrayOfByte[(i + 5)] = ((byte)(int)(paramLong >>> 16));
    arrayOfByte[(i + 4)] = ((byte)(int)(paramLong >>> 24));
    arrayOfByte[(i + 3)] = ((byte)(int)(paramLong >>> 32));
    arrayOfByte[(i + 2)] = ((byte)(int)(paramLong >>> 40));
    arrayOfByte[(i + 1)] = ((byte)(int)(paramLong >>> 48));
    arrayOfByte[i] = ((byte)(int)(paramLong >>> 56));
    this.mPosition = (i + 8);
  }
  
  private final void writeMap(HippyMap paramHippyMap)
  {
    ensureBufferSize(8);
    writeDataType((byte)7);
    writeUnsignedInt(paramHippyMap.size());
    paramHippyMap = paramHippyMap.entrySet().iterator();
    while (paramHippyMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramHippyMap.next();
      writeProperty((String)localEntry.getKey());
      writeObject(localEntry.getValue());
    }
  }
  
  private final void writeNumber(Number paramNumber)
  {
    ensureBufferSize(12);
    if ((!(paramNumber instanceof Integer)) && (!(paramNumber instanceof Short)) && (!(paramNumber instanceof Byte)))
    {
      if (((paramNumber instanceof Float)) || ((paramNumber instanceof Double)) || ((paramNumber instanceof Long)))
      {
        writeDataType((byte)5);
        writeDouble(paramNumber.doubleValue());
      }
    }
    else
    {
      writeDataType((byte)4);
      writeInteger(paramNumber.intValue());
    }
  }
  
  private final void writeObject(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      ensureBufferSize(2);
      writeDataType((byte)1);
      writeString((String)paramObject);
      return;
    }
    if ((paramObject instanceof HippyMap)) {
      if (!this.mReferenceStack.contains(paramObject))
      {
        this.mReferenceStack.add(paramObject);
        writeMap((HippyMap)paramObject);
      }
    }
    for (;;)
    {
      paramObject = this.mReferenceStack;
      paramObject.remove(paramObject.size() - 1);
      return;
      throw new RuntimeException("Circluar Reference Detected");
      boolean bool = paramObject instanceof HippyArray;
      int i = 0;
      if (!bool) {
        break label179;
      }
      if (this.mReferenceStack.contains(paramObject)) {
        break;
      }
      this.mReferenceStack.add(paramObject);
      ensureBufferSize(8);
      paramObject = (HippyArray)paramObject;
      writeDataType((byte)6);
      int j = paramObject.size();
      writeUnsignedInt(j);
      while (i < j)
      {
        writeObject(paramObject.get(i));
        i += 1;
      }
    }
    throw new RuntimeException("Circluar Reference Detected");
    label179:
    if ((paramObject instanceof Number))
    {
      writeNumber((Number)paramObject);
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      ensureBufferSize(2);
      if (((Boolean)paramObject).booleanValue())
      {
        writeDataType((byte)2);
        return;
      }
      writeDataType((byte)3);
      return;
    }
    if (paramObject == null)
    {
      ensureBufferSize(2);
      writeDataType((byte)0);
    }
  }
  
  private final void writeProperty(String paramString)
  {
    ensureBufferSize(2);
    byte[] arrayOfByte = this.mBuffer;
    int i = this.mPosition;
    arrayOfByte[i] = -16;
    arrayOfByte[(i + 1)] = 0;
    this.mPosition = (i + 2);
    writeString(paramString);
  }
  
  private final void writeString(String paramString)
  {
    paramString = paramString.getBytes();
    int i;
    if (paramString == null) {
      i = 0;
    } else {
      i = paramString.length;
    }
    ensureBufferSize(i + 8);
    writeUnsignedInt(i);
    if (i > 0)
    {
      System.arraycopy(paramString, 0, this.mBuffer, this.mPosition, i);
      this.mPosition += i;
    }
  }
  
  private final void writeUnsignedInt(int paramInt)
  {
    while ((paramInt & 0xFFFFFF80) != 0)
    {
      arrayOfByte = this.mBuffer;
      i = this.mPosition;
      arrayOfByte[i] = ((byte)(paramInt & 0x7F | 0x80));
      this.mPosition = (i + 1);
      paramInt >>>= 7;
    }
    byte[] arrayOfByte = this.mBuffer;
    int i = this.mPosition;
    arrayOfByte[i] = ((byte)(paramInt & 0x7F));
    this.mPosition = (i + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.HippyBuffer.Builder
 * JD-Core Version:    0.7.0.1
 */