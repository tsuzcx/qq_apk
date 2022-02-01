package org.apache.commons.io;

import java.nio.ByteOrder;

public final class ByteOrderParser
{
  public static ByteOrder parseByteOrder(String paramString)
  {
    if (ByteOrder.BIG_ENDIAN.toString().equals(paramString)) {
      return ByteOrder.BIG_ENDIAN;
    }
    if (ByteOrder.LITTLE_ENDIAN.toString().equals(paramString)) {
      return ByteOrder.LITTLE_ENDIAN;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Unsupported byte order setting: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", expeced one of ");
    localStringBuilder.append(ByteOrder.LITTLE_ENDIAN);
    localStringBuilder.append(", ");
    localStringBuilder.append(ByteOrder.BIG_ENDIAN);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.ByteOrderParser
 * JD-Core Version:    0.7.0.1
 */