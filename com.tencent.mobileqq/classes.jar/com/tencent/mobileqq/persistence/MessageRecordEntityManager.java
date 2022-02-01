package com.tencent.mobileqq.persistence;

import android.database.Cursor;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import java.util.List;

public class MessageRecordEntityManager
  extends OGEntityManager
{
  public static MessageRecordEntityManager.Callback a = new MessageRecordEntityManagerCallback();
  
  public MessageRecordEntityManager(SQLiteOpenHelper paramSQLiteOpenHelper, String paramString)
  {
    super(paramSQLiteOpenHelper, paramString);
  }
  
  @NonNull
  private Entity a(String paramString, Cursor paramCursor, long paramLong)
  {
    boolean bool2 = true;
    int i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
    byte[] arrayOfByte = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
    int j = paramCursor.getInt(paramCursor.getColumnIndex("extLong"));
    String str = paramCursor.getString(paramCursor.getColumnIndex("extStr"));
    int k = paramCursor.getInt(paramCursor.getColumnIndex("istroop"));
    MessageRecord localMessageRecord = MessageRecordFactory.a(i, arrayOfByte, j, str, k);
    localMessageRecord.msgData = arrayOfByte;
    localMessageRecord._id = paramLong;
    localMessageRecord.extLong = j;
    localMessageRecord.extStr = str;
    localMessageRecord.istroop = k;
    localMessageRecord.selfuin = paramCursor.getString(paramCursor.getColumnIndex("selfuin"));
    localMessageRecord.frienduin = paramCursor.getString(paramCursor.getColumnIndex("frienduin"));
    localMessageRecord.senderuin = paramCursor.getString(paramCursor.getColumnIndex("senderuin"));
    localMessageRecord.time = paramCursor.getLong(paramCursor.getColumnIndex("time"));
    localMessageRecord.msgtype = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
    boolean bool1;
    if (paramCursor.getInt(paramCursor.getColumnIndex("isread")) != 0)
    {
      bool1 = true;
      localMessageRecord.isread = bool1;
      localMessageRecord.issend = paramCursor.getInt(paramCursor.getColumnIndex("issend"));
      localMessageRecord.msgseq = paramCursor.getLong(paramCursor.getColumnIndex("msgseq"));
      localMessageRecord.shmsgseq = paramCursor.getLong(paramCursor.getColumnIndex("shmsgseq"));
      localMessageRecord.extraflag = paramCursor.getInt(paramCursor.getColumnIndex("extraflag"));
      localMessageRecord.sendFailCode = paramCursor.getInt(paramCursor.getColumnIndex("sendFailCode"));
      localMessageRecord.msgId = paramCursor.getLong(paramCursor.getColumnIndex("msgId"));
      localMessageRecord.longMsgIndex = paramCursor.getInt(paramCursor.getColumnIndex("longMsgIndex"));
      localMessageRecord.longMsgId = paramCursor.getInt(paramCursor.getColumnIndex("longMsgId"));
      localMessageRecord.longMsgCount = paramCursor.getInt(paramCursor.getColumnIndex("longMsgCount"));
      localMessageRecord.msgUid = paramCursor.getLong(paramCursor.getColumnIndex("msgUid"));
      localMessageRecord.uniseq = paramCursor.getLong(paramCursor.getColumnIndex("uniseq"));
      localMessageRecord.extInt = paramCursor.getInt(paramCursor.getColumnIndex("extInt"));
      if (paramCursor.getInt(paramCursor.getColumnIndex("isValid")) == 0) {
        break label609;
      }
      bool1 = bool2;
      label503:
      localMessageRecord.isValid = bool1;
      localMessageRecord.versionCode = paramCursor.getInt(paramCursor.getColumnIndex("versionCode"));
      localMessageRecord.vipBubbleID = paramCursor.getLong(paramCursor.getColumnIndex("vipBubbleID"));
      if (localMessageRecord.versionCode <= 0) {
        localMessageRecord.msg = paramCursor.getString(paramCursor.getColumnIndex("msg"));
      }
      if ((paramLong == -1L) || (paramString == null)) {
        break label615;
      }
    }
    label609:
    label615:
    for (localMessageRecord._status = 1001;; localMessageRecord._status = 1002)
    {
      localMessageRecord.postRead();
      return localMessageRecord;
      bool1 = false;
      break;
      bool1 = false;
      break label503;
    }
  }
  
  private void a(List<MessageRecord> paramList)
  {
    a.a(paramList);
  }
  
  public List<MessageRecord> a(String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    paramString1 = rawQuery(MessageRecord.class, paramString1, paramString2, paramString3, paramArrayOfString);
    a(paramString1);
    return paramString1;
  }
  
  public List<MessageRecord> a(String paramString, String[] paramArrayOfString)
  {
    paramString = rawQuery(MessageRecord.class, paramString, paramArrayOfString);
    a(paramString);
    return paramString;
  }
  
  public Entity cursor2Entity(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    long l2 = -1L;
    long l1 = l2;
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {
        l1 = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      }
      try
      {
        if (paramClass.getName().equals(MessageRecord.class.getName())) {
          return a(paramString, paramCursor, l1);
        }
        paramClass = super.cursor2Entity(paramClass, paramString, paramCursor, null);
        return paramClass;
      }
      catch (Exception paramClass)
      {
        return null;
      }
      catch (OutOfMemoryError paramClass)
      {
        return null;
      }
      catch (VerifyError paramClass)
      {
        return null;
      }
    }
    catch (Exception paramNoColumnErrorHandler)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.MessageRecordEntityManager
 * JD-Core Version:    0.7.0.1
 */