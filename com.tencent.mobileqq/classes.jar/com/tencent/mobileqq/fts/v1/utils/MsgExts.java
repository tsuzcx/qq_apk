package com.tencent.mobileqq.fts.v1.utils;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.nio.ByteBuffer;

public class MsgExts
  implements Serializable, Cloneable
{
  public static long bytesToLong(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.flip();
    return localByteBuffer.getLong();
  }
  
  public static byte[] copyOfRange(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 <= paramInt2)
    {
      int i = paramArrayOfByte.length;
      if ((paramInt1 >= 0) && (paramInt1 <= i))
      {
        paramInt2 -= paramInt1;
        i = Math.min(paramInt2, i - paramInt1);
        byte[] arrayOfByte = new byte[paramInt2];
        System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, i);
        return arrayOfByte;
      }
      throw new ArrayIndexOutOfBoundsException();
    }
    throw new IllegalArgumentException();
  }
  
  public static byte[] longToBytes(long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.putLong(paramLong);
    return localByteBuffer.array();
  }
  
  public static byte[] serialize(Object paramObject, int paramInt)
  {
    if (paramObject == null) {
      return null;
    }
    if (paramInt == 1) {}
    try
    {
      if ((paramObject instanceof TextMsgExts))
      {
        byte[] arrayOfByte = new byte[16];
        paramObject = (TextMsgExts)paramObject;
        System.arraycopy(longToBytes(paramObject.time), 0, arrayOfByte, 0, 8);
        System.arraycopy(longToBytes(paramObject.shmsgseq), 0, arrayOfByte, 8, 8);
        return arrayOfByte;
      }
      return null;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.MsgExts", 2, "unserialize: failure", paramObject);
      }
    }
    return null;
  }
  
  public static Object unserialize(byte[] paramArrayOfByte, int paramInt)
  {
    TextMsgExts localTextMsgExts = null;
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length == 0) {
        return null;
      }
      if (paramInt != 1) {
        return null;
      }
      try
      {
        if (paramArrayOfByte.length == 16) {
          localTextMsgExts = new TextMsgExts(bytesToLong(copyOfRange(paramArrayOfByte, 0, 8)), bytesToLong(copyOfRange(paramArrayOfByte, 8, 16)));
        }
        return localTextMsgExts;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("Q.fts.MsgExts", 2, "unserialize: failure", paramArrayOfByte);
        }
      }
    }
    return null;
  }
  
  protected Object clone()
  {
    return super.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.v1.utils.MsgExts
 * JD-Core Version:    0.7.0.1
 */