package com.tencent.mobileqq.persistence;

import android.database.Cursor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class Cursor2EntityConvert
{
  private volatile boolean a = false;
  private ConcurrentHashMap<String, Integer> b;
  
  /* Error */
  public static MessageRecord a(Entity paramEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +89 -> 90
    //   4: aload_0
    //   5: invokevirtual 28	com/tencent/mobileqq/persistence/Entity:postRead	()V
    //   8: aload_0
    //   9: checkcast 30	com/tencent/mobileqq/data/MessageRecord
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +72 -> 90
    //   21: ldc 38
    //   23: iconst_2
    //   24: ldc 40
    //   26: invokestatic 44	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: goto +61 -> 90
    //   32: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +55 -> 90
    //   38: ldc 38
    //   40: iconst_2
    //   41: ldc 46
    //   43: invokestatic 44	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: goto +44 -> 90
    //   49: astore_0
    //   50: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +37 -> 90
    //   56: new 48	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   63: astore_1
    //   64: aload_1
    //   65: ldc 51
    //   67: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_1
    //   72: aload_0
    //   73: invokevirtual 59	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   76: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: ldc 38
    //   82: iconst_2
    //   83: aload_1
    //   84: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 44	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_0
    //   93: goto -61 -> 32
    //   96: astore_0
    //   97: goto -82 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramEntity	Entity
    //   63	21	1	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   4	13	49	java/lang/Exception
    //   4	13	92	java/lang/OutOfMemoryError
    //   4	13	96	java/lang/VerifyError
  }
  
  private void a(List<Field> paramList, Cursor paramCursor)
  {
    if (paramList != null)
    {
      if (paramCursor == null) {
        return;
      }
      if (this.b == null) {
        this.b = new ConcurrentHashMap();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = ((Field)paramList.next()).getName();
        int i = paramCursor.getColumnIndex(str);
        this.b.put(str, Integer.valueOf(i));
      }
    }
  }
  
  public Entity a(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor)
  {
    if (paramCursor.isBeforeFirst()) {
      paramCursor.moveToFirst();
    }
    try
    {
      if (paramCursor.getColumnIndex("_id") >= 0) {
        l = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      }
    }
    catch (Exception localException)
    {
      long l;
      label46:
      break label46;
    }
    l = -1L;
    try
    {
      if (!paramClass.getName().equals(MessageRecord.class.getName())) {
        break label606;
      }
      int i = paramCursor.getInt(paramCursor.getColumnIndex("msgtype"));
      paramClass = paramCursor.getBlob(paramCursor.getColumnIndex("msgData"));
      int j = paramCursor.getInt(paramCursor.getColumnIndex("extLong"));
      String str = paramCursor.getString(paramCursor.getColumnIndex("extStr"));
      int k = paramCursor.getInt(paramCursor.getColumnIndex("istroop"));
      MessageRecord localMessageRecord = MessageRecordFactory.a(i, paramClass, j, str, k);
      localMessageRecord.msgData = paramClass;
      localMessageRecord._id = l;
      localMessageRecord.extLong = j;
      localMessageRecord.extStr = str;
      localMessageRecord.istroop = k;
      if (!this.a)
      {
        this.a = true;
        a(TableBuilder.getAllField(localMessageRecord), paramCursor);
      }
      localMessageRecord.selfuin = paramCursor.getString(((Integer)this.b.get("selfuin")).intValue());
      localMessageRecord.frienduin = paramCursor.getString(((Integer)this.b.get("frienduin")).intValue());
      localMessageRecord.senderuin = paramCursor.getString(((Integer)this.b.get("senderuin")).intValue());
      localMessageRecord.time = paramCursor.getLong(((Integer)this.b.get("time")).intValue());
      localMessageRecord.msgtype = paramCursor.getInt(((Integer)this.b.get("msgtype")).intValue());
      localMessageRecord.issend = paramCursor.getInt(((Integer)this.b.get("issend")).intValue());
      localMessageRecord.msgseq = paramCursor.getLong(((Integer)this.b.get("msgseq")).intValue());
      localMessageRecord.shmsgseq = paramCursor.getLong(((Integer)this.b.get("shmsgseq")).intValue());
      localMessageRecord.msgId = paramCursor.getLong(((Integer)this.b.get("msgId")).intValue());
      localMessageRecord.msgUid = paramCursor.getLong(((Integer)this.b.get("msgUid")).intValue());
      localMessageRecord.uniseq = paramCursor.getLong(((Integer)this.b.get("uniseq")).intValue());
      localMessageRecord.versionCode = paramCursor.getInt(((Integer)this.b.get("versionCode")).intValue());
      if (localMessageRecord.versionCode <= 0) {
        localMessageRecord.msg = paramCursor.getString(((Integer)this.b.get("msg")).intValue());
      }
      if ((l != -1L) && (paramString != null)) {
        localMessageRecord._status = 1001;
      } else {
        localMessageRecord._status = 1002;
      }
      return localMessageRecord;
    }
    catch (Exception paramClass)
    {
      break label602;
    }
    catch (OutOfMemoryError paramClass)
    {
      return null;
    }
    catch (VerifyError paramClass)
    {
      label596:
      label602:
      label606:
      break label596;
    }
    a();
    return null;
    a();
    return null;
  }
  
  public void a()
  {
    this.a = false;
    ConcurrentHashMap localConcurrentHashMap = this.b;
    if (localConcurrentHashMap != null)
    {
      localConcurrentHashMap.clear();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.Cursor2EntityConvert
 * JD-Core Version:    0.7.0.1
 */