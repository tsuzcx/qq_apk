package com.tencent.mobileqq.persistence.qslowtable;

import android.database.Cursor;
import android.database.SQLException;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.UncommonMessageProcessor;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.utils.MessageDBUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.manager.Manager;

public class QSlowTableManager
  implements Manager
{
  protected MessageRecordEntityManager a = null;
  QQAppInterface b;
  private QSlowTableEntityManagerFactory c;
  private Object d = new Object();
  
  public QSlowTableManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
  }
  
  private SQLiteOpenHelper e()
  {
    if (!this.b.getCurrentAccountUin().equals("0")) {
      return a().build(this.b.getCurrentAccountUin());
    }
    return null;
  }
  
  public int a(MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    String str2 = MessageRecord.getTableName(paramMessageRecord.frienduin, paramMessageRecord.istroop);
    long l = paramMessageRecord.getId();
    String[] arrayOfString = null;
    int j = 0;
    String str1;
    if (l > 0L)
    {
      arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramMessageRecord.getId());
      str1 = "_id=?";
    }
    else if (paramMessageRecord.uniseq != 0L)
    {
      arrayOfString = new String[1];
      arrayOfString[0] = String.valueOf(paramMessageRecord.uniseq);
      str1 = "uniseq=?";
    }
    else
    {
      str1 = null;
    }
    int i = j;
    if (str1 != null)
    {
      i = j;
      if (arrayOfString != null)
      {
        j = a(str2, str1, arrayOfString);
        i = j;
        if (paramBoolean)
        {
          this.b.getMsgHandler().E().a(paramMessageRecord);
          i = j;
        }
      }
    }
    return i;
  }
  
  public int a(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = c();
    if (localSQLiteDatabase == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QSlowTableManager", 2, "getSlowTableCount db = null!");
      }
      return 0;
    }
    if (MessageDBUtils.a(paramString, localSQLiteDatabase)) {
      return localSQLiteDatabase.getCount(paramString);
    }
    return 0;
  }
  
  /* Error */
  public int a(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 134	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   7: astore 7
    //   9: aload 7
    //   11: ldc 137
    //   13: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 7
    //   19: aload_1
    //   20: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 7
    //   26: ldc 143
    //   28: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload 7
    //   34: aload_2
    //   35: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload 7
    //   41: ldc 145
    //   43: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 7
    //   49: aload_3
    //   50: invokestatic 151	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   53: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload 7
    //   59: ldc 153
    //   61: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: ldc 115
    //   67: iconst_1
    //   68: aload 7
    //   70: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: invokevirtual 159	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager:b	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   80: astore 8
    //   82: iconst_0
    //   83: istore 5
    //   85: aload 8
    //   87: ifnonnull +13 -> 100
    //   90: ldc 115
    //   92: iconst_2
    //   93: ldc 161
    //   95: invokestatic 120	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   98: iconst_0
    //   99: ireturn
    //   100: aload_0
    //   101: invokevirtual 164	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager:d	()Lcom/tencent/mobileqq/persistence/MessageRecordEntityManager;
    //   104: invokevirtual 170	com/tencent/mobileqq/persistence/MessageRecordEntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   107: astore 7
    //   109: aload 7
    //   111: ifnull +12 -> 123
    //   114: iload 5
    //   116: istore 4
    //   118: aload 7
    //   120: invokevirtual 175	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   123: iload 5
    //   125: istore 4
    //   127: aload 8
    //   129: aload_1
    //   130: aload_2
    //   131: aload_3
    //   132: invokevirtual 178	com/tencent/mobileqq/app/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   135: istore 5
    //   137: aload 7
    //   139: ifnull +12 -> 151
    //   142: iload 5
    //   144: istore 4
    //   146: aload 7
    //   148: invokevirtual 181	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   151: iload 5
    //   153: istore 6
    //   155: aload 7
    //   157: ifnull +45 -> 202
    //   160: iload 5
    //   162: istore 4
    //   164: aload 7
    //   166: invokevirtual 184	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   169: iload 4
    //   171: istore 6
    //   173: goto +29 -> 202
    //   176: astore_1
    //   177: goto +132 -> 309
    //   180: astore_3
    //   181: ldc 115
    //   183: iconst_1
    //   184: ldc 186
    //   186: aload_3
    //   187: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: iload 4
    //   192: istore 6
    //   194: aload 7
    //   196: ifnull +6 -> 202
    //   199: goto -35 -> 164
    //   202: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +64 -> 269
    //   208: new 134	java/lang/StringBuilder
    //   211: dup
    //   212: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   215: astore_3
    //   216: aload_3
    //   217: ldc 191
    //   219: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: pop
    //   223: aload_3
    //   224: aload_1
    //   225: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload_3
    //   230: ldc 193
    //   232: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload_3
    //   237: iload 6
    //   239: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload_3
    //   244: ldc 198
    //   246: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_3
    //   251: aload_2
    //   252: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: pop
    //   256: ldc 115
    //   258: iconst_2
    //   259: aload_3
    //   260: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   266: iload 6
    //   268: ireturn
    //   269: iload 6
    //   271: ifle +35 -> 306
    //   274: new 134	java/lang/StringBuilder
    //   277: dup
    //   278: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   281: astore_1
    //   282: aload_1
    //   283: ldc 200
    //   285: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: pop
    //   289: aload_1
    //   290: iload 6
    //   292: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: ldc 115
    //   298: iconst_1
    //   299: aload_1
    //   300: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   306: iload 6
    //   308: ireturn
    //   309: aload 7
    //   311: ifnull +8 -> 319
    //   314: aload 7
    //   316: invokevirtual 184	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   319: goto +5 -> 324
    //   322: aload_1
    //   323: athrow
    //   324: goto -2 -> 322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	this	QSlowTableManager
    //   0	327	1	paramString1	String
    //   0	327	2	paramString2	String
    //   0	327	3	paramArrayOfString	String[]
    //   116	75	4	i	int
    //   83	78	5	j	int
    //   153	154	6	k	int
    //   7	308	7	localObject	Object
    //   80	48	8	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   118	123	176	finally
    //   127	137	176	finally
    //   146	151	176	finally
    //   181	190	176	finally
    //   118	123	180	java/lang/Exception
    //   127	137	180	java/lang/Exception
    //   146	151	180	java/lang/Exception
  }
  
  public Cursor a(String paramString1, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = c();
    Object localObject = null;
    if (localSQLiteDatabase == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QSlowTableManager", 2, "querySlowTable db null!");
      }
      return null;
    }
    if (paramString1.indexOf("mr_troop_") != -1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" where ");
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
      paramString2 = MessageDBUtils.b(null, paramString1, localSQLiteDatabase, (String)localObject);
      if (paramString2 == null) {
        return null;
      }
    }
    label176:
    try
    {
      paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
      paramString1 = paramString2;
    }
    catch (SQLException paramString2)
    {
      label96:
      break label96;
    }
    for (paramString1 = localSQLiteDatabase.query(paramString1, null, (String)localObject, null, null, null);; paramString1 = localSQLiteDatabase.query(paramString1, null, (String)localObject, null, null, null)) {
      for (;;)
      {
        return paramString1;
        if (paramString1.indexOf("mr_grp_") != -1)
        {
          localObject = new StringBuilder("select * from ");
          ((StringBuilder)localObject).append(paramString1);
          if ((paramString2 != null) && (paramString2.length() > 0))
          {
            ((StringBuilder)localObject).append(" where ");
            ((StringBuilder)localObject).append(paramString2);
          }
        }
        try
        {
          localObject = localSQLiteDatabase.rawQuery(((StringBuilder)localObject).toString(), null);
          paramString1 = (String)localObject;
        }
        catch (SQLException localSQLException1)
        {
          break label176;
        }
        paramString1 = localSQLiteDatabase.query(paramString1, null, paramString2, null, null, null);
        localObject = paramString1;
        if (!QLog.isColorLevel()) {
          break label353;
        }
        paramString2 = new StringBuilder();
        paramString2.append("cursor: ");
        paramString2.append(paramString1);
        QLog.d("gene", 2, paramString2.toString());
        return paramString1;
        if (paramString1.indexOf("mr_discusssion_") == -1) {
          break label311;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" where ");
        ((StringBuilder)localObject).append(paramString2);
        localObject = ((StringBuilder)localObject).toString();
        paramString2 = MessageDBUtils.b(null, paramString1, localSQLiteDatabase, (String)localObject);
        if (paramString2 == null) {
          return null;
        }
        try
        {
          paramString2 = localSQLiteDatabase.rawQuery(paramString2.toString(), null);
          paramString1 = paramString2;
        }
        catch (SQLException paramString2)
        {
          label296:
          StringBuilder localStringBuilder;
          break label296;
        }
      }
    }
    label311:
    localStringBuilder = MessageDBUtils.a(null, paramString1, localSQLiteDatabase, paramString2, null);
    if (localStringBuilder != null) {}
    try
    {
      localObject = localSQLiteDatabase.rawQuery(localStringBuilder.toString(), null);
      return localObject;
    }
    catch (SQLException localSQLException2)
    {
      label341:
      label353:
      break label341;
    }
    localObject = localSQLiteDatabase.query(paramString1, null, paramString2, null, null, null);
    return localObject;
  }
  
  public QSlowTableEntityManagerFactory a()
  {
    String str = this.b.getCurrentUin();
    if (str != null)
    {
      QSlowTableEntityManagerFactory localQSlowTableEntityManagerFactory = this.c;
      if (localQSlowTableEntityManagerFactory != null) {
        return localQSlowTableEntityManagerFactory;
      }
      try
      {
        if (this.c == null)
        {
          this.c = new QSlowTableEntityManagerFactory(str);
          ThreadManager.post(new QSlowTableManager.1(this), 8, null, false);
        }
        return this.c;
      }
      finally {}
    }
    throw new IllegalStateException("uin is null");
  }
  
  /* Error */
  public void a(String paramString, List<MessageRecord> paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +331 -> 332
    //   4: aload_2
    //   5: invokeinterface 272 1 0
    //   10: ifeq +6 -> 16
    //   13: goto +319 -> 332
    //   16: iconst_0
    //   17: istore 6
    //   19: iconst_0
    //   20: istore 7
    //   22: iconst_0
    //   23: istore_3
    //   24: aload_0
    //   25: invokevirtual 164	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager:d	()Lcom/tencent/mobileqq/persistence/MessageRecordEntityManager;
    //   28: invokevirtual 170	com/tencent/mobileqq/persistence/MessageRecordEntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   31: astore_1
    //   32: aload_1
    //   33: ifnull +15 -> 48
    //   36: iload 6
    //   38: istore 5
    //   40: iload 7
    //   42: istore 4
    //   44: aload_1
    //   45: invokevirtual 175	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   48: iload 6
    //   50: istore 5
    //   52: iload 7
    //   54: istore 4
    //   56: aload_2
    //   57: invokeinterface 276 1 0
    //   62: astore 8
    //   64: iload_3
    //   65: istore 5
    //   67: iload_3
    //   68: istore 4
    //   70: aload 8
    //   72: invokeinterface 281 1 0
    //   77: ifeq +74 -> 151
    //   80: iload_3
    //   81: istore 5
    //   83: iload_3
    //   84: istore 4
    //   86: aload 8
    //   88: invokeinterface 285 1 0
    //   93: checkcast 57	com/tencent/mobileqq/data/MessageRecord
    //   96: astore 9
    //   98: iload_3
    //   99: istore 5
    //   101: iload_3
    //   102: istore 4
    //   104: aload 9
    //   106: sipush 1000
    //   109: invokevirtual 289	com/tencent/mobileqq/data/MessageRecord:setStatus	(I)V
    //   112: iload_3
    //   113: istore 5
    //   115: iload_3
    //   116: istore 4
    //   118: aload_0
    //   119: invokevirtual 164	com/tencent/mobileqq/persistence/qslowtable/QSlowTableManager:d	()Lcom/tencent/mobileqq/persistence/MessageRecordEntityManager;
    //   122: aload 9
    //   124: invokevirtual 293	com/tencent/mobileqq/persistence/MessageRecordEntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   127: iload_3
    //   128: istore 5
    //   130: iload_3
    //   131: istore 4
    //   133: aload 9
    //   135: invokevirtual 296	com/tencent/mobileqq/data/MessageRecord:getStatus	()I
    //   138: sipush 1001
    //   141: if_icmpne -77 -> 64
    //   144: iload_3
    //   145: iconst_1
    //   146: iadd
    //   147: istore_3
    //   148: goto -84 -> 64
    //   151: aload_1
    //   152: ifnull +13 -> 165
    //   155: iload_3
    //   156: istore 5
    //   158: iload_3
    //   159: istore 4
    //   161: aload_1
    //   162: invokevirtual 181	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   165: aload_1
    //   166: ifnull +7 -> 173
    //   169: aload_1
    //   170: invokevirtual 184	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   173: new 134	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   180: astore_1
    //   181: goto +44 -> 225
    //   184: astore 8
    //   186: goto +83 -> 269
    //   189: astore 8
    //   191: iload 4
    //   193: istore 5
    //   195: ldc 115
    //   197: iconst_1
    //   198: ldc_w 298
    //   201: aload 8
    //   203: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   206: aload_1
    //   207: ifnull +7 -> 214
    //   210: aload_1
    //   211: invokevirtual 184	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   214: new 134	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   221: astore_1
    //   222: iload 4
    //   224: istore_3
    //   225: aload_1
    //   226: ldc_w 300
    //   229: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_1
    //   234: aload_2
    //   235: invokeinterface 303 1 0
    //   240: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload_1
    //   245: ldc_w 305
    //   248: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_1
    //   253: iload_3
    //   254: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: pop
    //   258: ldc 115
    //   260: iconst_1
    //   261: aload_1
    //   262: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: return
    //   269: aload_1
    //   270: ifnull +7 -> 277
    //   273: aload_1
    //   274: invokevirtual 184	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   277: new 134	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   284: astore_1
    //   285: aload_1
    //   286: ldc_w 300
    //   289: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload_1
    //   294: aload_2
    //   295: invokeinterface 303 1 0
    //   300: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_1
    //   305: ldc_w 305
    //   308: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   311: pop
    //   312: aload_1
    //   313: iload 5
    //   315: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: ldc 115
    //   321: iconst_1
    //   322: aload_1
    //   323: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   329: aload 8
    //   331: athrow
    //   332: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   335: ifeq +12 -> 347
    //   338: ldc 115
    //   340: iconst_2
    //   341: ldc_w 307
    //   344: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   347: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	348	0	this	QSlowTableManager
    //   0	348	1	paramString	String
    //   0	348	2	paramList	List<MessageRecord>
    //   23	231	3	i	int
    //   42	181	4	j	int
    //   38	276	5	k	int
    //   17	32	6	m	int
    //   20	33	7	n	int
    //   62	25	8	localIterator	java.util.Iterator
    //   184	1	8	localObject	Object
    //   189	141	8	localException	Exception
    //   96	38	9	localMessageRecord	MessageRecord
    // Exception table:
    //   from	to	target	type
    //   44	48	184	finally
    //   56	64	184	finally
    //   70	80	184	finally
    //   86	98	184	finally
    //   104	112	184	finally
    //   118	127	184	finally
    //   133	144	184	finally
    //   161	165	184	finally
    //   195	206	184	finally
    //   44	48	189	java/lang/Exception
    //   56	64	189	java/lang/Exception
    //   70	80	189	java/lang/Exception
    //   86	98	189	java/lang/Exception
    //   104	112	189	java/lang/Exception
    //   118	127	189	java/lang/Exception
    //   133	144	189	java/lang/Exception
    //   161	165	189	java/lang/Exception
  }
  
  public SQLiteDatabase b()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = e();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.getWritableDatabase();
    }
    return null;
  }
  
  public List<MessageRecord> b(String paramString)
  {
    if (c() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QSlowTableManager", 2, "querySlowTable db = null!");
      }
      return null;
    }
    if (paramString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QSlowTableManager", 2, "sql = null!");
      }
      return null;
    }
    return d().rawQuery(MessageRecord.class, paramString, null);
  }
  
  public List<MessageRecord> b(String paramString1, String paramString2)
  {
    SQLiteDatabase localSQLiteDatabase = c();
    if (localSQLiteDatabase == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QSlowTableManager", 2, "querySlowTableForList db = null!");
      }
      return null;
    }
    paramString1 = MessageDBUtils.a(null, paramString1, localSQLiteDatabase, paramString2, null);
    if (paramString1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QSlowTableManager", 2, "sqlStr db = null!");
      }
      return null;
    }
    return d().rawQuery(MessageRecord.class, paramString1.toString(), null);
  }
  
  public long c(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = c();
    long l2 = 0L;
    if (localSQLiteDatabase == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QSlowTableManager", 2, "queryLastMsgTime db = null!");
      }
      return 0L;
    }
    l1 = l2;
    if (MessageDBUtils.a(paramString, localSQLiteDatabase)) {
      l3 = l2;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      l3 = l2;
      localStringBuilder.append("select time from ");
      l3 = l2;
      localStringBuilder.append(paramString);
      l3 = l2;
      localStringBuilder.append(" order by time desc limit 1");
      l3 = l2;
      paramString = localSQLiteDatabase.rawQuery(localStringBuilder.toString(), null);
      l1 = l2;
      l3 = l2;
      if (paramString.moveToNext())
      {
        l3 = l2;
        l1 = paramString.getLong(0);
      }
      l3 = l1;
      paramString.close();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        l1 = l3;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("queryLastMsgTime maxtime=");
      paramString.append(l1);
      QLog.d("QSlowTableManager", 2, paramString.toString());
    }
    return l1;
  }
  
  public SQLiteDatabase c()
  {
    SQLiteOpenHelper localSQLiteOpenHelper = e();
    if (localSQLiteOpenHelper != null) {
      return localSQLiteOpenHelper.getReadableDatabase();
    }
    return null;
  }
  
  public long d(String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = c();
    long l2 = 0L;
    if (localSQLiteDatabase == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QSlowTableManager", 2, "queryLastMsgTime db = null!");
      }
      return 0L;
    }
    l1 = l2;
    if (MessageDBUtils.a(paramString, localSQLiteDatabase)) {
      l3 = l2;
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      l3 = l2;
      localStringBuilder.append("select time from ");
      l3 = l2;
      localStringBuilder.append(paramString);
      l3 = l2;
      localStringBuilder.append(" order by time asc limit 1");
      l3 = l2;
      paramString = localSQLiteDatabase.rawQuery(localStringBuilder.toString(), null);
      l1 = l2;
      l3 = l2;
      if (paramString.moveToNext())
      {
        l3 = l2;
        l1 = paramString.getLong(0);
      }
      l3 = l1;
      paramString.close();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        l1 = l3;
      }
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("queryFirstMsgTime maxtime=");
      paramString.append(l1);
      QLog.d("QSlowTableManager", 2, paramString.toString());
    }
    return l1;
  }
  
  public MessageRecordEntityManager d()
  {
    ??? = this.a;
    if ((??? == null) || (!((MessageRecordEntityManager)???).isOpen())) {}
    synchronized (this.d)
    {
      if ((this.a == null) || (!this.a.isOpen())) {
        this.a = ((MessageRecordEntityManager)a().a());
      }
      return this.a;
    }
  }
  
  public void onDestroy()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((MessageRecordEntityManager)localObject).isOpen())) {
      this.a.close();
    }
    localObject = this.c;
    if (localObject != null) {
      ((QSlowTableEntityManagerFactory)localObject).close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.persistence.qslowtable.QSlowTableManager
 * JD-Core Version:    0.7.0.1
 */