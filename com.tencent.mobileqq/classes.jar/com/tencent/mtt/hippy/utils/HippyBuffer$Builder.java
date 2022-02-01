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
    }
    for (;;)
    {
      this.mReferenceStack = ((ArrayList)sLocalRefStack.get());
      if (this.mReferenceStack == null) {
        break;
      }
      sLocalRefStack.set(null);
      return;
      this.mBuffer = new byte[2048];
    }
    this.mReferenceStack = new ArrayList(16);
  }
  
  private final byte[] build(Object paramObject)
  {
    writeObject(paramObject);
    paramObject = new byte[this.mPosition];
    System.arraycopy(this.mBuffer, 0, paramObject, 0, this.mPosition);
    return paramObject;
  }
  
  private final void ensureBufferSize(int paramInt)
  {
    int j = 16384;
    int i = this.mPosition + paramInt;
    if (i - this.mBuffer.length > 0)
    {
      paramInt = this.mBuffer.length << 1;
      if (paramInt >= 16384) {
        break label62;
      }
      paramInt = j;
    }
    label62:
    for (;;)
    {
      if (paramInt - i < 0) {
        paramInt = i;
      }
      for (;;)
      {
        this.mBuffer = Arrays.copyOf(this.mBuffer, paramInt);
        return;
      }
    }
  }
  
  private final void release()
  {
    if (this.mBuffer.length <= 16384) {
      sLocalBuilderBuffer.set(this.mBuffer);
    }
    if (this.mReferenceStack.isEmpty()) {
      sLocalRefStack.set(this.mReferenceStack);
    }
    for (;;)
    {
      this.mReferenceStack = null;
      this.mBuffer = null;
      this.mPosition = 0;
      return;
      this.mReferenceStack.clear();
    }
  }
  
  private final void writeDataType(byte paramByte)
  {
    this.mBuffer[this.mPosition] = paramByte;
    this.mPosition += 1;
  }
  
  private final void writeDouble(double paramDouble)
  {
    writeLong(Double.doubleToLongBits(paramDouble));
  }
  
  private final void writeFloat(float paramFloat)
  {
    int i = Float.floatToIntBits(paramFloat);
    this.mBuffer[(this.mPosition + 3)] = ((byte)i);
    this.mBuffer[(this.mPosition + 2)] = ((byte)(i >>> 8));
    this.mBuffer[(this.mPosition + 1)] = ((byte)(i >>> 16));
    this.mBuffer[this.mPosition] = ((byte)(i >>> 24));
    this.mPosition += 4;
  }
  
  private final void writeInteger(int paramInt)
  {
    writeUnsignedInt(paramInt << 1 ^ paramInt >> 31);
  }
  
  private final void writeLong(long paramLong)
  {
    this.mBuffer[(this.mPosition + 7)] = ((byte)(int)paramLong);
    this.mBuffer[(this.mPosition + 6)] = ((byte)(int)(paramLong >>> 8));
    this.mBuffer[(this.mPosition + 5)] = ((byte)(int)(paramLong >>> 16));
    this.mBuffer[(this.mPosition + 4)] = ((byte)(int)(paramLong >>> 24));
    this.mBuffer[(this.mPosition + 3)] = ((byte)(int)(paramLong >>> 32));
    this.mBuffer[(this.mPosition + 2)] = ((byte)(int)(paramLong >>> 40));
    this.mBuffer[(this.mPosition + 1)] = ((byte)(int)(paramLong >>> 48));
    this.mBuffer[this.mPosition] = ((byte)(int)(paramLong >>> 56));
    this.mPosition += 8;
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
    if (((paramNumber instanceof Integer)) || ((paramNumber instanceof Short)) || ((paramNumber instanceof Byte)))
    {
      writeDataType((byte)4);
      writeInteger(paramNumber.intValue());
    }
    while ((!(paramNumber instanceof Float)) && (!(paramNumber instanceof Double)) && (!(paramNumber instanceof Long))) {
      return;
    }
    writeDataType((byte)5);
    writeDouble(paramNumber.doubleValue());
  }
  
  private final void writeObject(Object paramObject)
  {
    int i = 0;
    if ((paramObject instanceof String))
    {
      ensureBufferSize(2);
      writeDataType((byte)1);
      writeString((String)paramObject);
    }
    do
    {
      return;
      if ((paramObject instanceof HippyMap))
      {
        if (this.mReferenceStack.contains(paramObject)) {
          throw new RuntimeException("Circluar Reference Detected");
        }
        this.mReferenceStack.add(paramObject);
        writeMap((HippyMap)paramObject);
        this.mReferenceStack.remove(this.mReferenceStack.size() - 1);
        return;
      }
      if ((paramObject instanceof HippyArray))
      {
        if (this.mReferenceStack.contains(paramObject)) {
          throw new RuntimeException("Circluar Reference Detected");
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
        this.mReferenceStack.remove(this.mReferenceStack.size() - 1);
        return;
      }
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
    } while (paramObject != null);
    ensureBufferSize(2);
    writeDataType((byte)0);
  }
  
  private final void writeProperty(String paramString)
  {
    ensureBufferSize(2);
    this.mBuffer[this.mPosition] = -16;
    this.mBuffer[(this.mPosition + 1)] = 0;
    this.mPosition += 2;
    writeString(paramString);
  }
  
  private final void writeString(String paramString)
  {
    paramString = paramString.getBytes();
    if (paramString == null) {}
    for (int i = 0;; i = paramString.length)
    {
      ensureBufferSize(i + 8);
      writeUnsignedInt(i);
      if (i > 0)
      {
        System.arraycopy(paramString, 0, this.mBuffer, this.mPosition, i);
        this.mPosition = (i + this.mPosition);
      }
      return;
    }
  }
  
  private final void writeUnsignedInt(int paramInt)
  {
    while ((paramInt & 0xFFFFFF80) != 0)
    {
      this.mBuffer[this.mPosition] = ((byte)(paramInt & 0x7F | 0x80));
      this.mPosition += 1;
      paramInt >>>= 7;
    }
    this.mBuffer[this.mPosition] = ((byte)(paramInt & 0x7F));
    this.mPosition += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.HippyBuffer.Builder
 * JD-Core Version:    0.7.0.1
 */