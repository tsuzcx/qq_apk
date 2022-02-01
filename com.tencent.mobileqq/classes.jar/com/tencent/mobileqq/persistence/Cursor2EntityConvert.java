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
  private ConcurrentHashMap<String, Integer> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  /* Error */
  public static MessageRecord a(Entity paramEntity)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +89 -> 90
    //   4: aload_0
    //   5: invokevirtual 27	com/tencent/mobileqq/persistence/Entity:postRead	()V
    //   8: aload_0
    //   9: checkcast 29	com/tencent/mobileqq/data/MessageRecord
    //   12: astore_0
    //   13: aload_0
    //   14: areturn
    //   15: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   18: ifeq +72 -> 90
    //   21: ldc 37
    //   23: iconst_2
    //   24: ldc 39
    //   26: invokestatic 43	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: goto +61 -> 90
    //   32: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +55 -> 90
    //   38: ldc 37
    //   40: iconst_2
    //   41: ldc 45
    //   43: invokestatic 43	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: goto +44 -> 90
    //   49: astore_0
    //   50: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +37 -> 90
    //   56: new 47	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   63: astore_1
    //   64: aload_1
    //   65: ldc 50
    //   67: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_1
    //   72: aload_0
    //   73: invokevirtual 58	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   76: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: ldc 37
    //   82: iconst_2
    //   83: aload_1
    //   84: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 43	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
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
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = ((Field)paramList.next()).getName();
        int i = paramCursor.getColumnIndex(str);
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(str, Integer.valueOf(i));
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
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        a(TableBuilder.getAllField(localMessageRecord), paramCursor);
      }
      localMessageRecord.selfuin = paramCursor.getString(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("selfuin")).intValue());
      localMessageRecord.frienduin = paramCursor.getString(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("frienduin")).intValue());
      localMessageRecord.senderuin = paramCursor.getString(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("senderuin")).intValue());
      localMessageRecord.time = paramCursor.getLong(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("time")).intValue());
      localMessageRecord.msgtype = paramCursor.getInt(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("msgtype")).intValue());
      localMessageRecord.issend = paramCursor.getInt(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("issend")).intValue());
      localMessageRecord.msgseq = paramCursor.getLong(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("msgseq")).intValue());
      localMessageRecord.shmsgseq = paramCursor.getLong(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("shmsgseq")).intValue());
      localMessageRecord.msgId = paramCursor.getLong(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("msgId")).intValue());
      localMessageRecord.msgUid = paramCursor.getLong(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("msgUid")).intValue());
      localMessageRecord.uniseq = paramCursor.getLong(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("uniseq")).intValue());
      localMessageRecord.versionCode = paramCursor.getInt(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("versionCode")).intValue());
      if (localMessageRecord.versionCode <= 0) {
        localMessageRecord.msg = paramCursor.getString(((Integer)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get("msg")).intValue());
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
    this.jdField_a_of_type_Boolean = false;
    ConcurrentHashMap localConcurrentHashMap = this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
    if (localConcurrentHashMap != null)
    {
      localConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.Cursor2EntityConvert
 * JD-Core Version:    0.7.0.1
 */