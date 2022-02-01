package com.tencent.mobileqq.msgbackup.data;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msgbackup.util.MsgBackupUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.ISQLiteOpenHelper;
import com.tencent.mobileqq.persistence.NoColumnError;
import com.tencent.mobileqq.persistence.NoColumnErrorHandler;
import com.tencent.mobileqq.persistence.SQLiteOpenHelperFacade;
import com.tencent.mobileqq.persistence.TableBuilder;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgBackupEntityManagerFactory
  extends EntityManagerFactory
{
  public MsgBackupEntityManagerFactory(String paramString)
  {
    super(paramString);
  }
  
  /* Error */
  public int a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/mobileqq/msgbackup/data/MsgBackupEntityManagerFactory:mInnerDbHelper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   4: invokeinterface 25 1 0
    //   9: astore 6
    //   11: iconst_0
    //   12: istore 5
    //   14: iconst_0
    //   15: istore_3
    //   16: iconst_0
    //   17: istore 4
    //   19: aload 6
    //   21: ifnonnull +16 -> 37
    //   24: ldc 27
    //   26: ldc 29
    //   28: iconst_0
    //   29: anewarray 31	java/lang/Object
    //   32: invokestatic 36	com/tencent/mobileqq/msgbackup/util/MsgBackupUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   35: iconst_0
    //   36: ireturn
    //   37: iload 5
    //   39: istore_2
    //   40: new 38	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   47: astore 7
    //   49: iload 5
    //   51: istore_2
    //   52: aload 7
    //   54: ldc 43
    //   56: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: iload 5
    //   62: istore_2
    //   63: aload 7
    //   65: aload_1
    //   66: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: iload 5
    //   72: istore_2
    //   73: aload 6
    //   75: aload 7
    //   77: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: aconst_null
    //   81: invokevirtual 57	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   84: astore_1
    //   85: iload_3
    //   86: istore_2
    //   87: aload_1
    //   88: ifnull +133 -> 221
    //   91: iload 4
    //   93: istore_3
    //   94: aload_1
    //   95: invokeinterface 63 1 0
    //   100: ifeq +11 -> 111
    //   103: aload_1
    //   104: iconst_0
    //   105: invokeinterface 67 2 0
    //   110: istore_3
    //   111: iload_3
    //   112: istore_2
    //   113: aload_1
    //   114: invokeinterface 70 1 0
    //   119: iload_3
    //   120: ireturn
    //   121: astore 6
    //   123: goto +47 -> 170
    //   126: astore 6
    //   128: new 38	java/lang/StringBuilder
    //   131: dup
    //   132: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   135: astore 7
    //   137: aload 7
    //   139: ldc 72
    //   141: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 7
    //   147: aload 6
    //   149: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   152: pop
    //   153: ldc 27
    //   155: iconst_1
    //   156: aload 7
    //   158: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: iload 4
    //   166: istore_3
    //   167: goto -56 -> 111
    //   170: iload 5
    //   172: istore_2
    //   173: aload_1
    //   174: invokeinterface 70 1 0
    //   179: iload 5
    //   181: istore_2
    //   182: aload 6
    //   184: athrow
    //   185: astore_1
    //   186: new 38	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   193: astore 6
    //   195: aload 6
    //   197: ldc 83
    //   199: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload 6
    //   205: aload_1
    //   206: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: ldc 27
    //   212: iconst_1
    //   213: aload 6
    //   215: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   221: iload_2
    //   222: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	MsgBackupEntityManagerFactory
    //   0	223	1	paramString	String
    //   39	183	2	i	int
    //   15	152	3	j	int
    //   17	148	4	k	int
    //   12	168	5	m	int
    //   9	65	6	localSQLiteDatabase	SQLiteDatabase
    //   121	1	6	localObject	Object
    //   126	57	6	localThrowable	Throwable
    //   193	21	6	localStringBuilder1	java.lang.StringBuilder
    //   47	110	7	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   94	111	121	finally
    //   128	164	121	finally
    //   94	111	126	java/lang/Throwable
    //   40	49	185	java/lang/Exception
    //   52	60	185	java/lang/Exception
    //   63	70	185	java/lang/Exception
    //   73	85	185	java/lang/Exception
    //   113	119	185	java/lang/Exception
    //   173	179	185	java/lang/Exception
    //   182	185	185	java/lang/Exception
  }
  
  public Entity a(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler)
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
        paramClass = (Entity)paramClass.newInstance();
        a(paramString, paramCursor, paramNoColumnErrorHandler, l1, paramClass);
        return paramClass;
      }
      catch (OutOfMemoryError paramClass)
      {
        if (QLog.isColorLevel())
        {
          QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(paramClass));
          return null;
        }
      }
      catch (Exception paramClass)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(paramClass));
        }
      }
      return null;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
  }
  
  public List<MsgBackupExtraEntity> a()
  {
    Object localObject1 = String.format("select * from %s", new Object[] { "ex_info" });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      MsgBackupUtil.a("MsgBackup_db", "db is null queryExtraInfo ...", new Object[0]);
      return new ArrayList();
    }
    localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
    localObject2 = a(MsgBackupExtraEntity.class, "ex_info", (Cursor)localObject1, null);
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  public List<MsgBackupMsgEntity> a(long paramLong, int paramInt)
  {
    Object localObject1 = String.format("select * from %s where _id>=%d limit %d", new Object[] { "msg", Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      MsgBackupUtil.a("MsgBackup_db", "db is null queryMsg ..125.", new Object[0]);
      return new ArrayList();
    }
    localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
    localObject2 = a(MsgBackupMsgEntity.class, "msg", (Cursor)localObject1, null);
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  public List<MsgBackupResEntity> a(long paramLong1, long paramLong2)
  {
    Object localObject1 = String.format("select * from %s where msgSeq = %d and msgRandom = %d", new Object[] { "res", Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      MsgBackupUtil.a("MsgBackup_db", "db is null queryRes ...", new Object[0]);
      return new ArrayList();
    }
    localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
    localObject2 = a(MsgBackupResEntity.class, "res", (Cursor)localObject1, null);
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  protected List<? extends Entity> a(Class<? extends Entity> paramClass, String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler)
  {
    Entity localEntity = null;
    Object localObject4 = null;
    localObject3 = null;
    localObject2 = localObject4;
    Object localObject1;
    if (paramCursor != null)
    {
      localObject1 = localEntity;
      localObject2 = localObject4;
      for (;;)
      {
        try
        {
          if (paramCursor.moveToFirst())
          {
            localObject1 = localEntity;
            i = paramCursor.getCount();
            localObject2 = localObject3;
            localObject1 = localObject2;
            localEntity = a(paramClass, paramString, paramCursor, paramNoColumnErrorHandler);
            localObject3 = localObject2;
            if (localEntity != null)
            {
              localObject3 = localObject2;
              if (localObject2 == null) {
                localObject1 = localObject2;
              }
            }
          }
        }
        catch (Exception paramClass)
        {
          int i;
          boolean bool;
          localObject2 = localObject1;
          if (QLog.isColorLevel())
          {
            QLog.e("MsgBackup_db", 2, MsfSdkUtils.getStackTraceString(paramClass));
            localObject2 = localObject1;
          }
        }
        try
        {
          localObject3 = new ArrayList(i);
          localObject1 = localObject3;
          ((List)localObject3).add(localEntity);
        }
        catch (Throwable localThrowable)
        {
          localObject3 = localObject2;
          continue;
        }
        localObject1 = localObject3;
        bool = paramCursor.moveToNext();
        localObject2 = localObject3;
        if (!bool) {
          return localObject3;
        }
      }
    }
    return localObject2;
  }
  
  protected void a(String paramString, Cursor paramCursor, NoColumnErrorHandler paramNoColumnErrorHandler, long paramLong, Entity paramEntity)
  {
    if (paramEntity != null)
    {
      paramEntity.setId(paramLong);
      List localList = TableBuilder.getValidField(paramEntity);
      int j = localList.size();
      int i = 0;
      while (i < j)
      {
        Field localField = (Field)localList.get(i);
        Class localClass = localField.getType();
        String str = localField.getName();
        int k = paramCursor.getColumnIndex(str);
        if (k != -1)
        {
          boolean bool2 = localField.isAccessible();
          boolean bool1 = true;
          if (!bool2) {
            localField.setAccessible(true);
          }
          if (localClass == Long.TYPE)
          {
            localField.set(paramEntity, Long.valueOf(paramCursor.getLong(k)));
          }
          else if (localClass == Integer.TYPE)
          {
            localField.set(paramEntity, Integer.valueOf(paramCursor.getInt(k)));
          }
          else if (localClass == String.class)
          {
            localField.set(paramEntity, paramCursor.getString(k));
          }
          else if (localClass == Byte.TYPE)
          {
            localField.set(paramEntity, Byte.valueOf((byte)paramCursor.getShort(k)));
          }
          else if (localClass == [B.class)
          {
            localField.set(paramEntity, paramCursor.getBlob(k));
          }
          else if (localClass == Short.TYPE)
          {
            localField.set(paramEntity, Short.valueOf(paramCursor.getShort(k)));
          }
          else if (localClass == Boolean.TYPE)
          {
            if (paramCursor.getInt(k) == 0) {
              bool1 = false;
            }
            localField.set(paramEntity, Boolean.valueOf(bool1));
          }
          else if (localClass == Float.TYPE)
          {
            localField.set(paramEntity, Float.valueOf(paramCursor.getFloat(k)));
          }
          else if (localClass == Double.TYPE)
          {
            localField.set(paramEntity, Double.valueOf(paramCursor.getDouble(k)));
          }
        }
        else if (paramNoColumnErrorHandler != null)
        {
          paramNoColumnErrorHandler.handleNoColumnError(new NoColumnError(str, localClass));
        }
        i += 1;
      }
      if ((paramLong != -1L) && (paramString != null)) {
        paramEntity.setStatus(1001);
      } else {
        paramEntity.setStatus(1002);
      }
      if ((paramEntity instanceof MsgBackupMsgEntity))
      {
        ((MsgBackupMsgEntity)paramEntity).postRead();
        return;
      }
      if ((paramEntity instanceof MsgBackupResEntity)) {
        ((MsgBackupResEntity)paramEntity).postRead();
      }
    }
  }
  
  public void a(List<MsgBackupExtraEntity> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ContentValues localContentValues = new ContentValues();
      SQLiteDatabase localSQLiteDatabase = this.mInnerDbHelper.getWritableDatabase();
      localSQLiteDatabase.beginTransaction();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MsgBackupExtraEntity localMsgBackupExtraEntity = (MsgBackupExtraEntity)paramList.next();
        localContentValues.put("name", localMsgBackupExtraEntity.name);
        localContentValues.put("value", localMsgBackupExtraEntity.value);
        localSQLiteDatabase.insert("ex_info", null, localContentValues);
      }
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
    }
  }
  
  /* Error */
  public int b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/mobileqq/msgbackup/data/MsgBackupEntityManagerFactory:mInnerDbHelper	Lcom/tencent/mobileqq/persistence/ISQLiteOpenHelper;
    //   4: invokeinterface 25 1 0
    //   9: astore 6
    //   11: iconst_0
    //   12: istore 5
    //   14: iconst_0
    //   15: istore_3
    //   16: iconst_0
    //   17: istore 4
    //   19: aload 6
    //   21: ifnonnull +17 -> 38
    //   24: ldc 27
    //   26: ldc_w 355
    //   29: iconst_0
    //   30: anewarray 31	java/lang/Object
    //   33: invokestatic 36	com/tencent/mobileqq/msgbackup/util/MsgBackupUtil:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   36: iconst_0
    //   37: ireturn
    //   38: iload 5
    //   40: istore_2
    //   41: new 38	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   48: astore 7
    //   50: iload 5
    //   52: istore_2
    //   53: aload 7
    //   55: ldc 43
    //   57: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: iload 5
    //   63: istore_2
    //   64: aload 7
    //   66: aload_1
    //   67: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: iload 5
    //   73: istore_2
    //   74: aload 6
    //   76: aload 7
    //   78: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: aconst_null
    //   82: invokevirtual 57	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   85: astore_1
    //   86: iload_3
    //   87: istore_2
    //   88: aload_1
    //   89: ifnull +134 -> 223
    //   92: iload 4
    //   94: istore_3
    //   95: aload_1
    //   96: invokeinterface 63 1 0
    //   101: ifeq +11 -> 112
    //   104: aload_1
    //   105: iconst_0
    //   106: invokeinterface 67 2 0
    //   111: istore_3
    //   112: iload_3
    //   113: istore_2
    //   114: aload_1
    //   115: invokeinterface 70 1 0
    //   120: iload_3
    //   121: ireturn
    //   122: astore 6
    //   124: goto +47 -> 171
    //   127: astore 6
    //   129: new 38	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   136: astore 7
    //   138: aload 7
    //   140: ldc 72
    //   142: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload 7
    //   148: aload 6
    //   150: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: ldc 27
    //   156: iconst_1
    //   157: aload 7
    //   159: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: iload 4
    //   167: istore_3
    //   168: goto -56 -> 112
    //   171: iload 5
    //   173: istore_2
    //   174: aload_1
    //   175: invokeinterface 70 1 0
    //   180: iload 5
    //   182: istore_2
    //   183: aload 6
    //   185: athrow
    //   186: astore_1
    //   187: new 38	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   194: astore 6
    //   196: aload 6
    //   198: ldc_w 357
    //   201: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload 6
    //   207: aload_1
    //   208: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: ldc 27
    //   214: iconst_1
    //   215: aload 6
    //   217: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 81	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   223: iload_2
    //   224: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	this	MsgBackupEntityManagerFactory
    //   0	225	1	paramString	String
    //   40	184	2	i	int
    //   15	153	3	j	int
    //   17	149	4	k	int
    //   12	169	5	m	int
    //   9	66	6	localSQLiteDatabase	SQLiteDatabase
    //   122	1	6	localObject	Object
    //   127	57	6	localThrowable	Throwable
    //   194	22	6	localStringBuilder1	java.lang.StringBuilder
    //   48	110	7	localStringBuilder2	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   95	112	122	finally
    //   129	165	122	finally
    //   95	112	127	java/lang/Throwable
    //   41	50	186	java/lang/Exception
    //   53	61	186	java/lang/Exception
    //   64	71	186	java/lang/Exception
    //   74	86	186	java/lang/Exception
    //   114	120	186	java/lang/Exception
    //   174	180	186	java/lang/Exception
    //   183	186	186	java/lang/Exception
  }
  
  public List<MsgBackupResEntity> b(long paramLong, int paramInt)
  {
    Object localObject1 = String.format("select * from %s where _id>=%d limit %d", new Object[] { "res", Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    Object localObject2 = this.mInnerDbHelper.getWritableDatabase();
    if (localObject2 == null)
    {
      MsgBackupUtil.a("MsgBackup_db", "db is null queryRes ...135", new Object[0]);
      return new ArrayList();
    }
    localObject1 = ((SQLiteDatabase)localObject2).rawQuery((String)localObject1, null);
    localObject2 = a(MsgBackupResEntity.class, "res", (Cursor)localObject1, null);
    ((Cursor)localObject1).close();
    return localObject2;
  }
  
  public void b(List<MsgBackupMsgEntity> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ContentValues localContentValues = new ContentValues();
      SQLiteDatabase localSQLiteDatabase = this.mInnerDbHelper.getWritableDatabase();
      localSQLiteDatabase.beginTransaction();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MsgBackupMsgEntity localMsgBackupMsgEntity = (MsgBackupMsgEntity)paramList.next();
        localMsgBackupMsgEntity.prewrite();
        localContentValues.put("chatUin", localMsgBackupMsgEntity.chatUin);
        localContentValues.put("chatType", Integer.valueOf(localMsgBackupMsgEntity.chatType));
        localContentValues.put("msgType", Integer.valueOf(localMsgBackupMsgEntity.msgType));
        localContentValues.put("msgTime", Long.valueOf(localMsgBackupMsgEntity.msgTime));
        localContentValues.put("msgSeq", Long.valueOf(localMsgBackupMsgEntity.msgSeq));
        localContentValues.put("msgRandom", Long.valueOf(localMsgBackupMsgEntity.msgRandom));
        localContentValues.put("extensionData", localMsgBackupMsgEntity.extensionData);
        localContentValues.put("extraData", localMsgBackupMsgEntity.extraData);
        localSQLiteDatabase.insert("msg", null, localContentValues);
      }
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
    }
  }
  
  public SQLiteOpenHelper build(String paramString)
  {
    if (this.mInnerDbHelper == null)
    {
      this.mInnerDbHelper = SQLiteOpenHelperFacade.a(this, paramString, 1);
      this.dbHelper = new SQLiteOpenHelper(this.mInnerDbHelper);
      createDatabase(this.mInnerDbHelper.getWritableDatabase());
    }
    return this.dbHelper;
  }
  
  public void c(List<MsgBackupResEntity> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      ContentValues localContentValues = new ContentValues();
      SQLiteDatabase localSQLiteDatabase = this.mInnerDbHelper.getWritableDatabase();
      localSQLiteDatabase.beginTransaction();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MsgBackupResEntity localMsgBackupResEntity = (MsgBackupResEntity)paramList.next();
        localMsgBackupResEntity.prewrite();
        localContentValues.put("msgSeq", Long.valueOf(localMsgBackupResEntity.msgSeq));
        localContentValues.put("msgRandom", Long.valueOf(localMsgBackupResEntity.msgRandom));
        localContentValues.put("msgType", Integer.valueOf(localMsgBackupResEntity.msgType));
        localContentValues.put("msgSubType", Integer.valueOf(localMsgBackupResEntity.msgSubType));
        localContentValues.put("filePath", localMsgBackupResEntity.filePath);
        localContentValues.put("fileSize", Long.valueOf(localMsgBackupResEntity.fileSize));
        localContentValues.put("extraData", localMsgBackupResEntity.extraData);
        localSQLiteDatabase.insert("res", null, localContentValues);
      }
      localSQLiteDatabase.setTransactionSuccessful();
      localSQLiteDatabase.endTransaction();
    }
  }
  
  protected void createDatabase(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase == null)
    {
      MsgBackupUtil.b("MsgBackup_db", "db create is null", new Object[0]);
      return;
    }
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgBackupMsgEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgBackupResEntity()));
    paramSQLiteDatabase.execSQL(TableBuilder.createSQLStatement(new MsgBackupExtraEntity()));
  }
  
  protected String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  protected boolean isNeedEncrypt()
  {
    return false;
  }
  
  protected void upgradeDatabase(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msgbackup.data.MsgBackupEntityManagerFactory
 * JD-Core Version:    0.7.0.1
 */