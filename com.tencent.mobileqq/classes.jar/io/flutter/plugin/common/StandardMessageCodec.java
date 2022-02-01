package io.flutter.plugin.common;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StandardMessageCodec
  implements MessageCodec<Object>
{
  private static final byte BIGINT = 5;
  private static final byte BYTE_ARRAY = 8;
  private static final byte DOUBLE = 6;
  private static final byte DOUBLE_ARRAY = 11;
  private static final byte FALSE = 2;
  private static final byte FlutterStandardFieldJSValue = 16;
  public static final StandardMessageCodec INSTANCE = new StandardMessageCodec();
  private static final byte INT = 3;
  private static final byte INT_ARRAY = 9;
  private static final byte LIST = 12;
  private static final boolean LITTLE_ENDIAN;
  private static final byte LONG = 4;
  private static final byte LONG_ARRAY = 10;
  private static final byte MAP = 13;
  private static final byte NULL = 0;
  private static final byte STRING = 7;
  private static final String TAG = "StandardMessageCodec#";
  private static final byte TRUE = 1;
  private static final Charset UTF8;
  
  static
  {
    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {}
    for (boolean bool = true;; bool = false)
    {
      LITTLE_ENDIAN = bool;
      UTF8 = Charset.forName("UTF8");
      return;
    }
  }
  
  protected static final void readAlignment(ByteBuffer paramByteBuffer, int paramInt)
  {
    int i = paramByteBuffer.position() % paramInt;
    if (i != 0) {
      paramByteBuffer.position(paramByteBuffer.position() + paramInt - i);
    }
  }
  
  protected static final byte[] readBytes(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[readSize(paramByteBuffer)];
    paramByteBuffer.get(arrayOfByte);
    return arrayOfByte;
  }
  
  protected static final int readSize(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasRemaining())
    {
      int i = paramByteBuffer.get() & 0xFF;
      if (i < 254) {
        return i;
      }
      if (i == 254) {
        return paramByteBuffer.getChar();
      }
      return paramByteBuffer.getInt();
    }
    throw new IllegalArgumentException("Message corrupted");
  }
  
  protected static final void writeAlignment(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    int j = paramByteArrayOutputStream.size() % paramInt;
    if (j != 0)
    {
      int i = 0;
      while (i < paramInt - j)
      {
        paramByteArrayOutputStream.write(0);
        i += 1;
      }
    }
  }
  
  protected static final void writeBytes(ByteArrayOutputStream paramByteArrayOutputStream, byte[] paramArrayOfByte)
  {
    writeSize(paramByteArrayOutputStream, paramArrayOfByte.length);
    paramByteArrayOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  protected static final void writeChar(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    if (LITTLE_ENDIAN)
    {
      paramByteArrayOutputStream.write(paramInt);
      paramByteArrayOutputStream.write(paramInt >>> 8);
      return;
    }
    paramByteArrayOutputStream.write(paramInt >>> 8);
    paramByteArrayOutputStream.write(paramInt);
  }
  
  protected static final void writeDouble(ByteArrayOutputStream paramByteArrayOutputStream, double paramDouble)
  {
    writeLong(paramByteArrayOutputStream, Double.doubleToLongBits(paramDouble));
  }
  
  protected static final void writeInt(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    if (LITTLE_ENDIAN)
    {
      paramByteArrayOutputStream.write(paramInt);
      paramByteArrayOutputStream.write(paramInt >>> 8);
      paramByteArrayOutputStream.write(paramInt >>> 16);
      paramByteArrayOutputStream.write(paramInt >>> 24);
      return;
    }
    paramByteArrayOutputStream.write(paramInt >>> 24);
    paramByteArrayOutputStream.write(paramInt >>> 16);
    paramByteArrayOutputStream.write(paramInt >>> 8);
    paramByteArrayOutputStream.write(paramInt);
  }
  
  protected static final void writeLong(ByteArrayOutputStream paramByteArrayOutputStream, long paramLong)
  {
    if (LITTLE_ENDIAN)
    {
      paramByteArrayOutputStream.write((byte)(int)paramLong);
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 8));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 16));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 24));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 32));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 40));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 48));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 56));
      return;
    }
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 56));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 48));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 40));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 32));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 24));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 16));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 8));
    paramByteArrayOutputStream.write((byte)(int)paramLong);
  }
  
  protected static final void writeSize(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    if (paramInt < 254)
    {
      paramByteArrayOutputStream.write(paramInt);
      return;
    }
    if (paramInt <= 65535)
    {
      paramByteArrayOutputStream.write(254);
      writeChar(paramByteArrayOutputStream, paramInt);
      return;
    }
    paramByteArrayOutputStream.write(255);
    writeInt(paramByteArrayOutputStream, paramInt);
  }
  
  public Object decodeMessage(ByteBuffer paramByteBuffer)
  {
    Object localObject;
    if (paramByteBuffer == null) {
      localObject = null;
    }
    do
    {
      return localObject;
      paramByteBuffer.order(ByteOrder.nativeOrder());
      localObject = readValue(paramByteBuffer);
    } while (!paramByteBuffer.hasRemaining());
    throw new IllegalArgumentException("Message corrupted");
  }
  
  public ByteBuffer encodeMessage(Object paramObject)
  {
    if (paramObject == null) {
      return null;
    }
    StandardMessageCodec.ExposedByteArrayOutputStream localExposedByteArrayOutputStream = new StandardMessageCodec.ExposedByteArrayOutputStream();
    writeValue(localExposedByteArrayOutputStream, paramObject);
    paramObject = ByteBuffer.allocateDirect(localExposedByteArrayOutputStream.size());
    paramObject.put(localExposedByteArrayOutputStream.buffer(), 0, localExposedByteArrayOutputStream.size());
    return paramObject;
  }
  
  protected final Object readValue(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasRemaining()) {
      return readValueOfType(paramByteBuffer.get(), paramByteBuffer);
    }
    throw new IllegalArgumentException("Message corrupted");
  }
  
  protected Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
  {
    byte b2 = 0;
    byte b1 = 0;
    Object localObject2;
    Object localObject1;
    switch (paramByte)
    {
    default: 
      throw new IllegalArgumentException("Message corrupted");
    case 13: 
      b2 = readSize(paramByteBuffer);
      localObject2 = new HashMap();
      paramByte = b1;
      for (;;)
      {
        localObject1 = localObject2;
        if (paramByte >= b2) {
          break;
        }
        ((Map)localObject2).put(readValue(paramByteBuffer), readValue(paramByteBuffer));
        paramByte += 1;
      }
    case 12: 
      b1 = readSize(paramByteBuffer);
      localObject2 = new ArrayList(b1);
      paramByte = b2;
      for (;;)
      {
        localObject1 = localObject2;
        if (paramByte >= b1) {
          break;
        }
        ((List)localObject2).add(readValue(paramByteBuffer));
        paramByte += 1;
      }
    case 11: 
      paramByte = readSize(paramByteBuffer);
      localObject1 = new double[paramByte];
      readAlignment(paramByteBuffer, 8);
      paramByteBuffer.asDoubleBuffer().get((double[])localObject1);
      paramByteBuffer.position(paramByte * 8 + paramByteBuffer.position());
      return localObject1;
    case 10: 
      paramByte = readSize(paramByteBuffer);
      localObject1 = new long[paramByte];
      readAlignment(paramByteBuffer, 8);
      paramByteBuffer.asLongBuffer().get((long[])localObject1);
      paramByteBuffer.position(paramByte * 8 + paramByteBuffer.position());
      return localObject1;
    case 9: 
      paramByte = readSize(paramByteBuffer);
      localObject1 = new int[paramByte];
      readAlignment(paramByteBuffer, 4);
      paramByteBuffer.asIntBuffer().get((int[])localObject1);
      paramByteBuffer.position(paramByte * 4 + paramByteBuffer.position());
      return localObject1;
    case 8: 
      return readBytes(paramByteBuffer);
    case 7: 
      return new String(readBytes(paramByteBuffer), UTF8);
    case 6: 
      readAlignment(paramByteBuffer, 8);
      return Double.valueOf(paramByteBuffer.getDouble());
    case 5: 
      return new BigInteger(new String(readBytes(paramByteBuffer), UTF8), 16);
    case 4: 
      return Long.valueOf(paramByteBuffer.getLong());
    case 3: 
      return Integer.valueOf(paramByteBuffer.getInt());
    case 2: 
      return Boolean.valueOf(false);
    case 1: 
      return Boolean.valueOf(true);
    }
    return null;
  }
  
  protected void writeValue(ByteArrayOutputStream paramByteArrayOutputStream, Object paramObject)
  {
    int j = 0;
    int k = 0;
    int i = 0;
    if ((paramObject == null) || (paramObject.equals(null))) {
      paramByteArrayOutputStream.write(0);
    }
    for (;;)
    {
      return;
      if (paramObject == Boolean.TRUE)
      {
        paramByteArrayOutputStream.write(1);
        return;
      }
      if (paramObject == Boolean.FALSE)
      {
        paramByteArrayOutputStream.write(2);
        return;
      }
      if ((paramObject instanceof Number))
      {
        if (((paramObject instanceof Integer)) || ((paramObject instanceof Short)) || ((paramObject instanceof Byte)))
        {
          paramByteArrayOutputStream.write(3);
          writeInt(paramByteArrayOutputStream, ((Number)paramObject).intValue());
          return;
        }
        if ((paramObject instanceof Long))
        {
          paramByteArrayOutputStream.write(4);
          writeLong(paramByteArrayOutputStream, ((Long)paramObject).longValue());
          return;
        }
        if (((paramObject instanceof Float)) || ((paramObject instanceof Double)))
        {
          paramByteArrayOutputStream.write(6);
          writeAlignment(paramByteArrayOutputStream, 8);
          writeDouble(paramByteArrayOutputStream, ((Number)paramObject).doubleValue());
          return;
        }
        if ((paramObject instanceof BigInteger))
        {
          paramByteArrayOutputStream.write(5);
          writeBytes(paramByteArrayOutputStream, ((BigInteger)paramObject).toString(16).getBytes(UTF8));
          return;
        }
        paramByteArrayOutputStream = new StringBuilder();
        paramByteArrayOutputStream.append("Unsupported Number type: ");
        paramByteArrayOutputStream.append(paramObject.getClass());
        throw new IllegalArgumentException(paramByteArrayOutputStream.toString());
      }
      if ((paramObject instanceof String))
      {
        paramByteArrayOutputStream.write(7);
        writeBytes(paramByteArrayOutputStream, ((String)paramObject).getBytes(UTF8));
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        paramByteArrayOutputStream.write(8);
        writeBytes(paramByteArrayOutputStream, (byte[])paramObject);
        return;
      }
      if ((paramObject instanceof int[]))
      {
        paramByteArrayOutputStream.write(9);
        paramObject = (int[])paramObject;
        writeSize(paramByteArrayOutputStream, paramObject.length);
        writeAlignment(paramByteArrayOutputStream, 4);
        j = paramObject.length;
        while (i < j)
        {
          writeInt(paramByteArrayOutputStream, paramObject[i]);
          i += 1;
        }
      }
      else if ((paramObject instanceof long[]))
      {
        paramByteArrayOutputStream.write(10);
        paramObject = (long[])paramObject;
        writeSize(paramByteArrayOutputStream, paramObject.length);
        writeAlignment(paramByteArrayOutputStream, 8);
        k = paramObject.length;
        i = j;
        while (i < k)
        {
          writeLong(paramByteArrayOutputStream, paramObject[i]);
          i += 1;
        }
      }
      else if ((paramObject instanceof double[]))
      {
        paramByteArrayOutputStream.write(11);
        paramObject = (double[])paramObject;
        writeSize(paramByteArrayOutputStream, paramObject.length);
        writeAlignment(paramByteArrayOutputStream, 8);
        j = paramObject.length;
        i = k;
        while (i < j)
        {
          writeDouble(paramByteArrayOutputStream, paramObject[i]);
          i += 1;
        }
      }
      else if ((paramObject instanceof List))
      {
        paramByteArrayOutputStream.write(12);
        paramObject = (List)paramObject;
        writeSize(paramByteArrayOutputStream, paramObject.size());
        paramObject = paramObject.iterator();
        while (paramObject.hasNext()) {
          writeValue(paramByteArrayOutputStream, paramObject.next());
        }
      }
      else
      {
        if (!(paramObject instanceof Map)) {
          break;
        }
        paramByteArrayOutputStream.write(13);
        paramObject = (Map)paramObject;
        writeSize(paramByteArrayOutputStream, paramObject.size());
        paramObject = paramObject.entrySet().iterator();
        while (paramObject.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)paramObject.next();
          writeValue(paramByteArrayOutputStream, localEntry.getKey());
          writeValue(paramByteArrayOutputStream, localEntry.getValue());
        }
      }
    }
    if ((paramObject instanceof FlutterStandardFieldJSValueWrapper))
    {
      paramByteArrayOutputStream.write(16);
      writeLong(paramByteArrayOutputStream, ((FlutterStandardFieldJSValueWrapper)paramObject).getAddress());
      return;
    }
    paramByteArrayOutputStream = new StringBuilder();
    paramByteArrayOutputStream.append("Unsupported value: ");
    paramByteArrayOutputStream.append(paramObject);
    throw new IllegalArgumentException(paramByteArrayOutputStream.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.common.StandardMessageCodec
 * JD-Core Version:    0.7.0.1
 */