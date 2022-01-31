package com.tencent.mobileqq.utils.fts;

import com.tencent.mobileqq.data.FTSMessageSync;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.fts.FTSMessage;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;

public class FTSMessageCodec
{
  public static long a(byte[] paramArrayOfByte)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.put(paramArrayOfByte);
    localByteBuffer.flip();
    return localByteBuffer.getLong();
  }
  
  public static FTSMessageSync a(FTSMessage paramFTSMessage)
  {
    if (paramFTSMessage == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "codecFTSMessage ftsMessage is null");
      }
      return null;
    }
    FTSMessageSync localFTSMessageSync = new FTSMessageSync();
    localFTSMessageSync.mOpt = paramFTSMessage.mOpt;
    localFTSMessageSync.mType = paramFTSMessage.mType;
    localFTSMessageSync.mContent = paramFTSMessage.mContent;
    localFTSMessageSync.mOId = paramFTSMessage.mOId;
    localFTSMessageSync.uin = paramFTSMessage.uin;
    localFTSMessageSync.istroop = paramFTSMessage.istroop;
    localFTSMessageSync.senderuin = paramFTSMessage.senderuin;
    localFTSMessageSync.msgtype = paramFTSMessage.msgtype;
    try
    {
      if (paramFTSMessage.msgExts != null) {
        localFTSMessageSync.msgExts = ((FTSMessageCodec.MsgExts)paramFTSMessage.msgExts.clone());
      } else {
        localFTSMessageSync.msgExts = null;
      }
    }
    catch (Exception paramFTSMessage)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.utils", 2, "codecFTSMessage, ", paramFTSMessage);
      }
      localFTSMessageSync.msgExts = null;
    }
    return localFTSMessageSync;
  }
  
  public static FTSMessage a(FTSMessageSync paramFTSMessageSync)
  {
    if (paramFTSMessageSync == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "decodecFTSMessage ftsMessageSync is null");
      }
      return null;
    }
    FTSMessage localFTSMessage = new FTSMessage();
    localFTSMessage.mOpt = paramFTSMessageSync.mOpt;
    localFTSMessage.mType = paramFTSMessageSync.mType;
    localFTSMessage.mContent = paramFTSMessageSync.mContent;
    localFTSMessage.mOId = paramFTSMessageSync.mOId;
    localFTSMessage.uin = paramFTSMessageSync.uin;
    localFTSMessage.istroop = paramFTSMessageSync.istroop;
    localFTSMessage.senderuin = paramFTSMessageSync.senderuin;
    localFTSMessage.msgtype = paramFTSMessageSync.msgtype;
    try
    {
      if (paramFTSMessageSync.msgExts != null) {
        localFTSMessage.msgExts = ((FTSMessageCodec.MsgExts)paramFTSMessageSync.msgExts.clone());
      } else {
        localFTSMessage.msgExts = null;
      }
    }
    catch (Exception paramFTSMessageSync)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.fts.utils", 2, "decodecFTSMessage, ", paramFTSMessageSync);
      }
      localFTSMessage.msgExts = null;
    }
    return localFTSMessage;
  }
  
  public static FTSMessage a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      if (QLog.isColorLevel()) {
        QLog.e("Q.fts.utils", 2, "encodeMessageRecord message is null");
      }
    }
    FTSMessage localFTSMessage;
    do
    {
      return null;
      localFTSMessage = b(paramMessageRecord);
      if (localFTSMessage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.fts.utils", 2, "encodeMessageRecord message is null");
    return null;
    switch (paramMessageRecord.msgtype)
    {
    }
    for (;;)
    {
      return localFTSMessage;
      FTSMessageCodec.TextMsgExts localTextMsgExts = new FTSMessageCodec.TextMsgExts();
      localTextMsgExts.time = paramMessageRecord.time;
      localTextMsgExts.shmsgseq = paramMessageRecord.shmsgseq;
      localFTSMessage.msgExts = localTextMsgExts;
    }
  }
  
  public static Object a(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {}
    do
    {
      return null;
      switch (paramInt)
      {
      }
      for (;;)
      {
        paramArrayOfByte = null;
        return paramArrayOfByte;
        try
        {
          if (paramArrayOfByte.length == 16) {
            paramArrayOfByte = new FTSMessageCodec.TextMsgExts(a(a(paramArrayOfByte, 0, 8)), a(a(paramArrayOfByte, 8, 16)));
          }
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.fts.utils", 2, "unserialize: failure", paramArrayOfByte);
    return null;
  }
  
  public static byte[] a(long paramLong)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8);
    localByteBuffer.putLong(paramLong);
    return localByteBuffer.array();
  }
  
  public static byte[] a(Object paramObject, int paramInt)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      switch (paramInt)
      {
      }
      for (;;)
      {
        paramObject = null;
        return paramObject;
        try
        {
          if ((paramObject instanceof FTSMessageCodec.TextMsgExts))
          {
            byte[] arrayOfByte = new byte[16];
            paramObject = (FTSMessageCodec.TextMsgExts)paramObject;
            System.arraycopy(a(paramObject.time), 0, arrayOfByte, 0, 8);
            System.arraycopy(a(paramObject.shmsgseq), 0, arrayOfByte, 8, 8);
            paramObject = arrayOfByte;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.e("Q.fts.utils", 2, "unserialize: failure", paramObject);
    return null;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      throw new IllegalArgumentException();
    }
    int i = paramArrayOfByte.length;
    if ((paramInt1 < 0) || (paramInt1 > i)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    paramInt2 -= paramInt1;
    i = Math.min(paramInt2, i - paramInt1);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  private static FTSMessage b(MessageRecord paramMessageRecord)
  {
    FTSMessage localFTSMessage = new FTSMessage();
    localFTSMessage.mType = 1;
    localFTSMessage.mContent = paramMessageRecord.getContentForSearch();
    localFTSMessage.mOId = paramMessageRecord.getId();
    localFTSMessage.uin = Long.parseLong(paramMessageRecord.frienduin);
    localFTSMessage.istroop = paramMessageRecord.istroop;
    localFTSMessage.senderuin = paramMessageRecord.senderuin;
    localFTSMessage.msgtype = paramMessageRecord.msgtype;
    return localFTSMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.utils.fts.FTSMessageCodec
 * JD-Core Version:    0.7.0.1
 */