package com.tencent.mobileqq.fts.operator;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.fts.utils.FTSUtils;
import com.tencent.mobileqq.msg.api.IMessageRecordEntityManager;
import com.tencent.mobileqq.persistence.fts.FTSDatatbase;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;

public class FTSMsgUpgrader
  implements FTSUpgrader
{
  private int jdField_a_of_type_Int;
  private FTSMsgOperator jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSMsgOperator;
  private FTSSyncHandler jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler;
  private FTSDatatbase jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  
  FTSMsgUpgrader(AppRuntime paramAppRuntime, FTSMsgOperator paramFTSMsgOperator)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSMsgOperator = paramFTSMsgOperator;
    this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase = this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSMsgOperator.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase;
    this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler = this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSMsgOperator.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler;
  }
  
  /* Error */
  private int a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 4
    //   3: iload 4
    //   5: istore_3
    //   6: aload_1
    //   7: ldc 41
    //   9: aconst_null
    //   10: invokevirtual 47	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   13: astore_1
    //   14: iload 4
    //   16: istore_2
    //   17: aload_1
    //   18: ifnull +47 -> 65
    //   21: iload 4
    //   23: istore_2
    //   24: iload 4
    //   26: istore_3
    //   27: aload_1
    //   28: invokeinterface 53 1 0
    //   33: iconst_1
    //   34: if_icmpne +31 -> 65
    //   37: iload 4
    //   39: istore_3
    //   40: aload_1
    //   41: invokeinterface 57 1 0
    //   46: pop
    //   47: iload 4
    //   49: istore_3
    //   50: aload_1
    //   51: aload_1
    //   52: ldc 59
    //   54: invokeinterface 63 2 0
    //   59: invokeinterface 67 2 0
    //   64: istore_2
    //   65: iload_2
    //   66: istore 4
    //   68: aload_1
    //   69: ifnull +43 -> 112
    //   72: iload_2
    //   73: istore_3
    //   74: aload_1
    //   75: invokeinterface 70 1 0
    //   80: iload_2
    //   81: ireturn
    //   82: astore_1
    //   83: goto +32 -> 115
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   91: iload_3
    //   92: istore 4
    //   94: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +15 -> 112
    //   100: ldc 80
    //   102: iconst_2
    //   103: ldc 82
    //   105: aload_1
    //   106: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   109: iload_3
    //   110: istore 4
    //   112: iload 4
    //   114: ireturn
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	FTSMsgUpgrader
    //   0	117	1	paramSQLiteDatabase	SQLiteDatabase
    //   16	65	2	i	int
    //   5	105	3	j	int
    //   1	112	4	k	int
    // Exception table:
    //   from	to	target	type
    //   6	14	82	finally
    //   27	37	82	finally
    //   40	47	82	finally
    //   50	65	82	finally
    //   74	80	82	finally
    //   87	91	82	finally
    //   94	109	82	finally
    //   6	14	86	java/lang/Exception
    //   27	37	86	java/lang/Exception
    //   40	47	86	java/lang/Exception
    //   50	65	86	java/lang/Exception
    //   74	80	86	java/lang/Exception
  }
  
  private long a(long paramLong1, String paramString, long paramLong2, SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramLong1 != -1L)
    {
      paramString = new ContentValues();
      paramString.put("MAX_ID", Long.valueOf(paramLong2));
      return paramSQLiteDatabase.update("msg_upgrade_log", paramString, "id=?", new String[] { String.valueOf(paramLong1) });
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("tablename", paramString);
    localContentValues.put("MAX_ID", Long.valueOf(paramLong2));
    return paramSQLiteDatabase.insert("msg_upgrade_log", null, localContentValues);
  }
  
  private List<MessageRecord> a(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject1 = paramSQLiteDatabase.rawQuery("SELECT tablename, MAX_ID FROM msg_upgrade_log WHERE id=?;", new String[] { String.valueOf(this.jdField_b_of_type_Int + 1) });
    Object localObject2 = null;
    long l;
    if ((localObject1 != null) && (((Cursor)localObject1).getCount() == 1))
    {
      ((Cursor)localObject1).moveToNext();
      paramSQLiteDatabase = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("tablename"));
      l = ((Cursor)localObject1).getLong(((Cursor)localObject1).getColumnIndex("MAX_ID"));
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramSQLiteDatabase = new StringBuilder();
        paramSQLiteDatabase.append("UpgradeThread: rowid=");
        paramSQLiteDatabase.append(this.jdField_b_of_type_Int + 1);
        paramSQLiteDatabase.append(" failure");
        QLog.d("Q.fts.FTSMsgUpgrader", 2, paramSQLiteDatabase.toString());
      }
      l = -1L;
      paramSQLiteDatabase = null;
    }
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("writeNativeIndex tableName=");
      ((StringBuilder)localObject1).append(paramSQLiteDatabase);
      ((StringBuilder)localObject1).append(" maxId=");
      ((StringBuilder)localObject1).append(l);
      QLog.d("Q.fts.FTSMsgUpgrader", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = localObject2;
    if (paramSQLiteDatabase != null)
    {
      localObject1 = localObject2;
      if (l > 0L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("SELECT * FROM ");
        ((StringBuilder)localObject1).append(paramSQLiteDatabase);
        ((StringBuilder)localObject1).append(" WHERE _id<=?;");
        localObject1 = ((StringBuilder)localObject1).toString();
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("UpgradeThread: SELECT * FROM ");
          ((StringBuilder)localObject2).append(paramSQLiteDatabase);
          ((StringBuilder)localObject2).append(" WHERE _id<=");
          ((StringBuilder)localObject2).append(l);
          ((StringBuilder)localObject2).append(";");
          QLog.d("Q.fts.FTSMsgUpgrader", 2, ((StringBuilder)localObject2).toString());
        }
        localObject2 = ((IMessageRecordEntityManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageRecordEntityManager.class, "")).rawQuery((String)localObject1, new String[] { String.valueOf(l) });
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("UpgradeThread: list size = ");
          if (localObject2 == null) {
            paramSQLiteDatabase = "null";
          } else {
            paramSQLiteDatabase = Integer.valueOf(((List)localObject2).size());
          }
          ((StringBuilder)localObject1).append(paramSQLiteDatabase);
          QLog.d("Q.fts.FTSMsgUpgrader", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
    }
    return localObject1;
  }
  
  /* Error */
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: iload 5
    //   8: istore_3
    //   9: aload_1
    //   10: ldc 222
    //   12: aconst_null
    //   13: invokevirtual 47	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore_1
    //   17: iload 4
    //   19: istore_2
    //   20: aload_1
    //   21: ifnull +21 -> 42
    //   24: iload 4
    //   26: istore_2
    //   27: iload 5
    //   29: istore_3
    //   30: aload_1
    //   31: invokeinterface 53 1 0
    //   36: iconst_1
    //   37: if_icmpne +5 -> 42
    //   40: iconst_1
    //   41: istore_2
    //   42: iload_2
    //   43: istore 4
    //   45: aload_1
    //   46: ifnull +43 -> 89
    //   49: iload_2
    //   50: istore_3
    //   51: aload_1
    //   52: invokeinterface 70 1 0
    //   57: iload_2
    //   58: ireturn
    //   59: astore_1
    //   60: goto +32 -> 92
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   68: iload_3
    //   69: istore 4
    //   71: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +15 -> 89
    //   77: ldc 80
    //   79: iconst_2
    //   80: ldc 82
    //   82: aload_1
    //   83: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   86: iload_3
    //   87: istore 4
    //   89: iload 4
    //   91: ireturn
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	FTSMsgUpgrader
    //   0	94	1	paramSQLiteDatabase	SQLiteDatabase
    //   19	39	2	bool1	boolean
    //   8	79	3	bool2	boolean
    //   4	86	4	bool3	boolean
    //   1	27	5	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   9	17	59	finally
    //   30	40	59	finally
    //   51	57	59	finally
    //   64	68	59	finally
    //   71	86	59	finally
    //   9	17	63	java/lang/Exception
    //   30	40	63	java/lang/Exception
    //   51	57	63	java/lang/Exception
  }
  
  private void b()
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_table", String.valueOf(FTSUtils.d(this.jdField_a_of_type_MqqAppAppRuntime)));
    ((HashMap)localObject).put("param_msg", String.valueOf(FTSUtils.e(this.jdField_a_of_type_MqqAppAppRuntime)));
    StatisticCollector.getInstance(this.jdField_a_of_type_MqqAppAppRuntime.getApp()).collectPerformance(null, "actFTSUpgradeCost", true, FTSUtils.a(this.jdField_a_of_type_MqqAppAppRuntime), 0L, (HashMap)localObject, null, false);
    FTSUtils.d(this.jdField_a_of_type_MqqAppAppRuntime, true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("========== upgrade table complete, cost =");
      ((StringBuilder)localObject).append(FTSUtils.a(this.jdField_a_of_type_MqqAppAppRuntime));
      ((StringBuilder)localObject).append("us, tables = ");
      ((StringBuilder)localObject).append(FTSUtils.d(this.jdField_a_of_type_MqqAppAppRuntime));
      ((StringBuilder)localObject).append(", msgs = ");
      ((StringBuilder)localObject).append(FTSUtils.e(this.jdField_a_of_type_MqqAppAppRuntime));
      QLog.d("Q.fts.FTSMsgUpgrader", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void c()
  {
    long l1 = FTSUtils.a(this.jdField_a_of_type_MqqAppAppRuntime);
    long l2 = System.nanoTime();
    int i;
    if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.b("UpgradeCursor"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: upgradeCursorTable has not exist");
      }
      if (!this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("UpgradeCursor"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: create upgradeCursorTable failure");
        }
        return;
      }
      i = 0;
    }
    else
    {
      i = -1;
    }
    int j = i;
    if (i != 1) {
      j = this.jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase.a("UpgradeCursor");
    }
    if (j == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: curCursor == -1");
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startUpgradeTableStep: curCursor = ");
      localStringBuilder.append(j);
      QLog.d("Q.fts.FTSMsgUpgrader", 2, localStringBuilder.toString());
    }
    this.jdField_b_of_type_Int = j;
    l2 = (System.nanoTime() - l2) / 1000L;
    FTSUtils.a(this.jdField_a_of_type_MqqAppAppRuntime, l1, l2);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private boolean c()
  {
    if (FTSUtils.b(this.jdField_a_of_type_MqqAppAppRuntime) != 1) {
      return false;
    }
    if (FTSUtils.d(this.jdField_a_of_type_MqqAppAppRuntime))
    {
      QLog.d("Q.fts.FTSMsgUpgrader", 1, "========== upgrade table has complete");
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.FTSMsgUpgrader", 2, "========== upgrade table start");
    }
    long l1 = FTSUtils.a(this.jdField_a_of_type_MqqAppAppRuntime);
    long l2 = System.nanoTime();
    if (!a(this.jdField_a_of_type_MqqAppAppRuntime.getReadableDatabase()))
    {
      QLog.d("Q.fts.FTSMsgUpgrader", 1, "startUpgradeTableStep: msg_upgrade_log has not exist");
      b();
      return true;
    }
    int i = a(this.jdField_a_of_type_MqqAppAppRuntime.getReadableDatabase());
    if (i == -1)
    {
      QLog.d("Q.fts.FTSMsgUpgrader", 1, "startUpgradeTableStep: query msg_upgrade_log MAX(id) failure");
      b();
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startUpgradeTableStep: maxIndex = ");
      localStringBuilder.append(i);
      QLog.d("Q.fts.FTSMsgUpgrader", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_Int = i;
    l2 = (System.nanoTime() - l2) / 1000L;
    FTSUtils.a(this.jdField_a_of_type_MqqAppAppRuntime, l1, l2);
    this.jdField_a_of_type_ComTencentMobileqqFtsOperatorFTSSyncHandler.post(new FTSMsgUpgrader.1(this));
    return false;
  }
  
  /* Error */
  private boolean d()
  {
    // Byte code:
    //   0: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 80
    //   8: iconst_2
    //   9: ldc_w 343
    //   12: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: new 345	java/util/ArrayList
    //   18: dup
    //   19: sipush 512
    //   22: invokespecial 348	java/util/ArrayList:<init>	(I)V
    //   25: astore 8
    //   27: aload_0
    //   28: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   31: invokestatic 235	com/tencent/mobileqq/fts/utils/FTSUtils:d	(Lmqq/app/AppRuntime;)I
    //   34: istore_1
    //   35: aload_0
    //   36: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   39: invokestatic 242	com/tencent/mobileqq/fts/utils/FTSUtils:e	(Lmqq/app/AppRuntime;)I
    //   42: istore_2
    //   43: aload_0
    //   44: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   47: invokestatic 257	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;)J
    //   50: lstore 4
    //   52: invokestatic 280	java/lang/System:nanoTime	()J
    //   55: lstore 6
    //   57: aload_0
    //   58: aload_0
    //   59: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   62: invokevirtual 317	mqq/app/AppRuntime:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   65: invokespecial 350	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:a	(Lcom/tencent/mobileqq/app/SQLiteDatabase;)Ljava/util/List;
    //   68: astore 9
    //   70: aload 9
    //   72: ifnull +224 -> 296
    //   75: aload 9
    //   77: invokeinterface 353 1 0
    //   82: ifne +214 -> 296
    //   85: aload 9
    //   87: invokeinterface 357 1 0
    //   92: astore 9
    //   94: aload 9
    //   96: invokeinterface 362 1 0
    //   101: ifeq +195 -> 296
    //   104: aload 9
    //   106: invokeinterface 366 1 0
    //   111: checkcast 368	com/tencent/mobileqq/data/MessageRecord
    //   114: astore 10
    //   116: aload 10
    //   118: invokevirtual 371	com/tencent/mobileqq/data/MessageRecord:isSupportFTS	()Z
    //   121: ifeq +172 -> 293
    //   124: aload 10
    //   126: getfield 374	com/tencent/mobileqq/data/MessageRecord:isValid	Z
    //   129: ifeq +164 -> 293
    //   132: aload 10
    //   134: getfield 377	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   137: sipush -2006
    //   140: if_icmpeq +153 -> 293
    //   143: aload 10
    //   145: invokestatic 382	com/tencent/mobileqq/fts/v1/utils/FTSMessageCodec:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/fts/data/msg/FTSMessage;
    //   148: astore 10
    //   150: aload 10
    //   152: ifnull +141 -> 293
    //   155: aload 10
    //   157: invokevirtual 387	com/tencent/mobileqq/fts/data/msg/FTSMessage:insertOpt	()V
    //   160: aload 10
    //   162: invokevirtual 390	com/tencent/mobileqq/fts/data/msg/FTSMessage:preWrite	()V
    //   165: aload 8
    //   167: aload 10
    //   169: invokevirtual 394	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   172: pop
    //   173: goto +120 -> 293
    //   176: astore 9
    //   178: aload 9
    //   180: invokevirtual 395	java/lang/Throwable:printStackTrace	()V
    //   183: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +40 -> 226
    //   189: new 145	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   196: astore 10
    //   198: aload 10
    //   200: ldc_w 397
    //   203: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 10
    //   209: aload 9
    //   211: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: ldc 80
    //   217: iconst_2
    //   218: aload 10
    //   220: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 399	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +62 -> 291
    //   232: new 145	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   239: astore 9
    //   241: aload 9
    //   243: ldc_w 401
    //   246: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 9
    //   252: aload 8
    //   254: invokevirtual 402	java/util/ArrayList:size	()I
    //   257: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 9
    //   263: ldc_w 404
    //   266: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 9
    //   272: aload_0
    //   273: getfield 89	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   276: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: ldc 80
    //   282: iconst_2
    //   283: aload 9
    //   285: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: iconst_0
    //   292: ireturn
    //   293: goto -199 -> 94
    //   296: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +62 -> 361
    //   302: new 145	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   309: astore 9
    //   311: aload 9
    //   313: ldc_w 401
    //   316: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 9
    //   322: aload 8
    //   324: invokevirtual 402	java/util/ArrayList:size	()I
    //   327: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 9
    //   333: ldc_w 404
    //   336: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 9
    //   342: aload_0
    //   343: getfield 89	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   346: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: ldc 80
    //   352: iconst_2
    //   353: aload 9
    //   355: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload_0
    //   362: getfield 32	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   365: aload 8
    //   367: iconst_1
    //   368: invokevirtual 407	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   371: iconst_m1
    //   372: if_icmpne +114 -> 486
    //   375: ldc2_w 408
    //   378: invokestatic 415	java/lang/Thread:sleep	(J)V
    //   381: goto +10 -> 391
    //   384: astore 9
    //   386: aload 9
    //   388: invokevirtual 416	java/lang/InterruptedException:printStackTrace	()V
    //   391: aload_0
    //   392: getfield 32	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   395: aload 8
    //   397: iconst_1
    //   398: invokevirtual 407	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   401: istore_3
    //   402: invokestatic 280	java/lang/System:nanoTime	()J
    //   405: lload 6
    //   407: lsub
    //   408: ldc2_w 300
    //   411: ldiv
    //   412: lstore 6
    //   414: aload_0
    //   415: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   418: lload 4
    //   420: lload 6
    //   422: invokestatic 304	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   425: pop2
    //   426: iload_3
    //   427: iconst_m1
    //   428: if_icmpne +45 -> 473
    //   431: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +12 -> 446
    //   437: ldc 80
    //   439: iconst_2
    //   440: ldc_w 418
    //   443: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: aload_0
    //   447: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   450: invokevirtual 246	mqq/app/AppRuntime:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   453: invokestatic 252	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   456: aconst_null
    //   457: ldc_w 420
    //   460: iconst_0
    //   461: ldc2_w 91
    //   464: lconst_0
    //   465: aconst_null
    //   466: aconst_null
    //   467: iconst_0
    //   468: invokevirtual 261	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   471: iconst_0
    //   472: ireturn
    //   473: aload_0
    //   474: aload_0
    //   475: getfield 89	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   478: iconst_1
    //   479: iadd
    //   480: putfield 89	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   483: goto +37 -> 520
    //   486: invokestatic 280	java/lang/System:nanoTime	()J
    //   489: lload 6
    //   491: lsub
    //   492: ldc2_w 300
    //   495: ldiv
    //   496: lstore 6
    //   498: aload_0
    //   499: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   502: lload 4
    //   504: lload 6
    //   506: invokestatic 304	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   509: pop2
    //   510: aload_0
    //   511: aload_0
    //   512: getfield 89	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   515: iconst_1
    //   516: iadd
    //   517: putfield 89	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   520: aload_0
    //   521: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   524: iload_1
    //   525: iconst_1
    //   526: invokestatic 423	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;II)I
    //   529: pop
    //   530: aload_0
    //   531: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   534: iload_2
    //   535: aload 8
    //   537: invokevirtual 402	java/util/ArrayList:size	()I
    //   540: invokestatic 425	com/tencent/mobileqq/fts/utils/FTSUtils:b	(Lmqq/app/AppRuntime;II)I
    //   543: pop
    //   544: iconst_1
    //   545: ireturn
    //   546: astore 9
    //   548: goto +94 -> 642
    //   551: astore 9
    //   553: aload 9
    //   555: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   558: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   561: ifeq +14 -> 575
    //   564: ldc 80
    //   566: iconst_2
    //   567: ldc_w 427
    //   570: aload 9
    //   572: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   575: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   578: ifeq +62 -> 640
    //   581: new 145	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   588: astore 9
    //   590: aload 9
    //   592: ldc_w 401
    //   595: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload 9
    //   601: aload 8
    //   603: invokevirtual 402	java/util/ArrayList:size	()I
    //   606: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload 9
    //   612: ldc_w 404
    //   615: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload 9
    //   621: aload_0
    //   622: getfield 89	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   625: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: ldc 80
    //   631: iconst_2
    //   632: aload 9
    //   634: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   640: iconst_0
    //   641: ireturn
    //   642: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq +62 -> 707
    //   648: new 145	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   655: astore 10
    //   657: aload 10
    //   659: ldc_w 401
    //   662: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload 10
    //   668: aload 8
    //   670: invokevirtual 402	java/util/ArrayList:size	()I
    //   673: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 10
    //   679: ldc_w 404
    //   682: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload 10
    //   688: aload_0
    //   689: getfield 89	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   692: invokevirtual 155	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: ldc 80
    //   698: iconst_2
    //   699: aload 10
    //   701: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: aload_0
    //   708: getfield 32	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   711: aload 8
    //   713: iconst_1
    //   714: invokevirtual 407	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   717: iconst_m1
    //   718: if_icmpne +81 -> 799
    //   721: ldc2_w 408
    //   724: invokestatic 415	java/lang/Thread:sleep	(J)V
    //   727: goto +10 -> 737
    //   730: astore 10
    //   732: aload 10
    //   734: invokevirtual 416	java/lang/InterruptedException:printStackTrace	()V
    //   737: aload_0
    //   738: getfield 32	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_ComTencentMobileqqPersistenceFtsFTSDatatbase	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   741: aload 8
    //   743: iconst_1
    //   744: invokevirtual 407	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   747: istore_3
    //   748: invokestatic 280	java/lang/System:nanoTime	()J
    //   751: lload 6
    //   753: lsub
    //   754: ldc2_w 300
    //   757: ldiv
    //   758: lstore 6
    //   760: aload_0
    //   761: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   764: lload 4
    //   766: lload 6
    //   768: invokestatic 304	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   771: pop2
    //   772: iload_3
    //   773: iconst_m1
    //   774: if_icmpne +12 -> 786
    //   777: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   780: ifeq -334 -> 446
    //   783: goto -346 -> 437
    //   786: aload_0
    //   787: aload_0
    //   788: getfield 89	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   791: iconst_1
    //   792: iadd
    //   793: putfield 89	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   796: goto +37 -> 833
    //   799: invokestatic 280	java/lang/System:nanoTime	()J
    //   802: lload 6
    //   804: lsub
    //   805: ldc2_w 300
    //   808: ldiv
    //   809: lstore 6
    //   811: aload_0
    //   812: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   815: lload 4
    //   817: lload 6
    //   819: invokestatic 304	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   822: pop2
    //   823: aload_0
    //   824: aload_0
    //   825: getfield 89	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   828: iconst_1
    //   829: iadd
    //   830: putfield 89	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_b_of_type_Int	I
    //   833: aload_0
    //   834: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   837: iload_1
    //   838: iconst_1
    //   839: invokestatic 423	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;II)I
    //   842: pop
    //   843: aload_0
    //   844: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   847: iload_2
    //   848: aload 8
    //   850: invokevirtual 402	java/util/ArrayList:size	()I
    //   853: invokestatic 425	com/tencent/mobileqq/fts/utils/FTSUtils:b	(Lmqq/app/AppRuntime;II)I
    //   856: pop
    //   857: goto +6 -> 863
    //   860: aload 9
    //   862: athrow
    //   863: goto -3 -> 860
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	866	0	this	FTSMsgUpgrader
    //   34	804	1	i	int
    //   42	806	2	j	int
    //   401	374	3	k	int
    //   50	766	4	l1	long
    //   55	763	6	l2	long
    //   25	824	8	localArrayList	java.util.ArrayList
    //   68	37	9	localObject1	Object
    //   176	34	9	localThrowable	java.lang.Throwable
    //   239	115	9	localStringBuilder1	StringBuilder
    //   384	3	9	localInterruptedException1	java.lang.InterruptedException
    //   546	1	9	localObject2	Object
    //   551	20	9	localException	java.lang.Exception
    //   588	273	9	localStringBuilder2	StringBuilder
    //   114	586	10	localObject3	Object
    //   730	3	10	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   165	173	176	java/lang/Throwable
    //   375	381	384	java/lang/InterruptedException
    //   57	70	546	finally
    //   75	94	546	finally
    //   94	150	546	finally
    //   155	165	546	finally
    //   165	173	546	finally
    //   178	226	546	finally
    //   553	575	546	finally
    //   57	70	551	java/lang/Exception
    //   75	94	551	java/lang/Exception
    //   94	150	551	java/lang/Exception
    //   155	165	551	java/lang/Exception
    //   165	173	551	java/lang/Exception
    //   178	226	551	java/lang/Exception
    //   721	727	730	java/lang/InterruptedException
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return !FTSUtils.e(this.jdField_a_of_type_MqqAppAppRuntime);
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: ldc_w 431
    //   3: astore 18
    //   5: ldc_w 433
    //   8: astore 13
    //   10: aload_0
    //   11: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   14: invokestatic 435	com/tencent/mobileqq/fts/utils/FTSUtils:c	(Lmqq/app/AppRuntime;)Z
    //   17: ifeq +17 -> 34
    //   20: ldc 80
    //   22: iconst_2
    //   23: ldc_w 437
    //   26: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_0
    //   30: invokespecial 439	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:c	()Z
    //   33: ireturn
    //   34: ldc 80
    //   36: iconst_2
    //   37: ldc_w 441
    //   40: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   47: invokestatic 257	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;)J
    //   50: lstore 5
    //   52: invokestatic 280	java/lang/System:nanoTime	()J
    //   55: lstore 7
    //   57: iconst_0
    //   58: istore 11
    //   60: aload_0
    //   61: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   64: invokevirtual 317	mqq/app/AppRuntime:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   67: astore 17
    //   69: aload 17
    //   71: invokevirtual 445	com/tencent/mobileqq/app/SQLiteDatabase:getAllTableNameFromDB	()[Ljava/lang/String;
    //   74: astore 14
    //   76: aload 14
    //   78: ifnull +787 -> 865
    //   81: aload 14
    //   83: arraylength
    //   84: ifne +6 -> 90
    //   87: goto +778 -> 865
    //   90: new 227	java/util/HashMap
    //   93: dup
    //   94: invokespecial 228	java/util/HashMap:<init>	()V
    //   97: astore 19
    //   99: aload 14
    //   101: arraylength
    //   102: istore_2
    //   103: iconst_0
    //   104: istore_1
    //   105: iload_1
    //   106: iload_2
    //   107: if_icmpge +191 -> 298
    //   110: aload 14
    //   112: iload_1
    //   113: aaload
    //   114: astore 15
    //   116: aload 15
    //   118: ldc_w 447
    //   121: invokevirtual 450	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   124: ifeq +884 -> 1008
    //   127: aload 15
    //   129: ldc_w 452
    //   132: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   135: ifne +47 -> 182
    //   138: aload 15
    //   140: ldc_w 457
    //   143: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   146: ifne +36 -> 182
    //   149: aload 15
    //   151: ldc_w 459
    //   154: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   157: ifne +25 -> 182
    //   160: aload 15
    //   162: ldc_w 461
    //   165: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   168: ifne +14 -> 182
    //   171: aload 15
    //   173: ldc_w 463
    //   176: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   179: ifeq +829 -> 1008
    //   182: new 145	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   189: astore 16
    //   191: aload 16
    //   193: ldc_w 465
    //   196: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 16
    //   202: aload 15
    //   204: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 16
    //   210: ldc 182
    //   212: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 17
    //   218: aload 16
    //   220: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: aconst_null
    //   224: invokevirtual 47	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   227: astore 16
    //   229: aload 16
    //   231: ifnull +774 -> 1005
    //   234: aload 16
    //   236: invokeinterface 53 1 0
    //   241: iconst_1
    //   242: if_icmpne +41 -> 283
    //   245: aload 16
    //   247: invokeinterface 57 1 0
    //   252: pop
    //   253: aload 19
    //   255: aload 15
    //   257: aload 16
    //   259: aload 16
    //   261: ldc 59
    //   263: invokeinterface 63 2 0
    //   268: invokeinterface 143 2 0
    //   273: invokestatic 101	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   276: invokevirtual 238	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   279: pop
    //   280: goto +3 -> 283
    //   283: aload 16
    //   285: ifnull +723 -> 1008
    //   288: aload 16
    //   290: invokeinterface 70 1 0
    //   295: goto +713 -> 1008
    //   298: invokestatic 78	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   301: ifeq +108 -> 409
    //   304: aload 19
    //   306: invokevirtual 469	java/util/HashMap:keySet	()Ljava/util/Set;
    //   309: invokeinterface 472 1 0
    //   314: astore 14
    //   316: aload 14
    //   318: invokeinterface 362 1 0
    //   323: ifeq +86 -> 409
    //   326: aload 14
    //   328: invokeinterface 366 1 0
    //   333: checkcast 111	java/lang/String
    //   336: astore 15
    //   338: new 145	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   345: astore 16
    //   347: aload 16
    //   349: ldc_w 474
    //   352: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 16
    //   358: aload 15
    //   360: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: pop
    //   364: aload 16
    //   366: ldc_w 476
    //   369: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 16
    //   375: aload 19
    //   377: aload 15
    //   379: invokevirtual 480	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   382: invokevirtual 212	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 16
    //   388: ldc_w 482
    //   391: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: ldc 80
    //   397: iconst_2
    //   398: aload 16
    //   400: invokevirtual 161	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 165	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: goto -90 -> 316
    //   409: aload 13
    //   411: astore 14
    //   413: aload 13
    //   415: astore 15
    //   417: aload 17
    //   419: ldc_w 484
    //   422: invokevirtual 487	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   425: pop
    //   426: aload 13
    //   428: astore 14
    //   430: aload 13
    //   432: astore 15
    //   434: aload 19
    //   436: invokevirtual 469	java/util/HashMap:keySet	()Ljava/util/Set;
    //   439: invokeinterface 472 1 0
    //   444: astore 16
    //   446: aload 13
    //   448: astore 14
    //   450: aload 13
    //   452: astore 15
    //   454: aload 16
    //   456: invokeinterface 362 1 0
    //   461: ifeq +303 -> 764
    //   464: aload 13
    //   466: astore 14
    //   468: aload 13
    //   470: astore 15
    //   472: aload 16
    //   474: invokeinterface 366 1 0
    //   479: checkcast 111	java/lang/String
    //   482: astore 20
    //   484: aload 13
    //   486: astore 14
    //   488: aload 13
    //   490: astore 15
    //   492: aload 17
    //   494: ldc 107
    //   496: iconst_1
    //   497: anewarray 111	java/lang/String
    //   500: dup
    //   501: iconst_0
    //   502: aload 18
    //   504: aastore
    //   505: ldc_w 489
    //   508: iconst_1
    //   509: anewarray 111	java/lang/String
    //   512: dup
    //   513: iconst_0
    //   514: aload 20
    //   516: aastore
    //   517: aconst_null
    //   518: aconst_null
    //   519: invokevirtual 493	com/tencent/mobileqq/app/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   522: astore 21
    //   524: aload 21
    //   526: ifnull +489 -> 1015
    //   529: aload 13
    //   531: astore 14
    //   533: aload 13
    //   535: astore 15
    //   537: aload 21
    //   539: invokeinterface 53 1 0
    //   544: iconst_1
    //   545: if_icmpne +470 -> 1015
    //   548: aload 13
    //   550: astore 14
    //   552: aload 13
    //   554: astore 15
    //   556: aload 21
    //   558: invokeinterface 57 1 0
    //   563: pop
    //   564: aload 13
    //   566: astore 14
    //   568: aload 13
    //   570: astore 15
    //   572: aload 21
    //   574: aload 21
    //   576: aload 18
    //   578: invokeinterface 63 2 0
    //   583: invokeinterface 143 2 0
    //   588: lstore_3
    //   589: goto +3 -> 592
    //   592: aload 21
    //   594: ifnull +18 -> 612
    //   597: aload 13
    //   599: astore 14
    //   601: aload 13
    //   603: astore 15
    //   605: aload 21
    //   607: invokeinterface 70 1 0
    //   612: aload 13
    //   614: astore 14
    //   616: aload 13
    //   618: astore 15
    //   620: aload 19
    //   622: aload 20
    //   624: invokevirtual 480	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   627: checkcast 97	java/lang/Long
    //   630: invokevirtual 496	java/lang/Long:longValue	()J
    //   633: lstore 9
    //   635: aload 13
    //   637: astore 15
    //   639: aload 15
    //   641: astore 14
    //   643: aload_0
    //   644: lload_3
    //   645: aload 20
    //   647: lload 9
    //   649: aload 17
    //   651: invokespecial 498	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:a	(JLjava/lang/String;JLcom/tencent/mobileqq/app/SQLiteDatabase;)J
    //   654: ldc2_w 91
    //   657: lcmp
    //   658: ifne +99 -> 757
    //   661: aload 15
    //   663: astore 14
    //   665: ldc2_w 499
    //   668: invokestatic 415	java/lang/Thread:sleep	(J)V
    //   671: aload 15
    //   673: astore 14
    //   675: aload_0
    //   676: lload_3
    //   677: aload 20
    //   679: aload 19
    //   681: aload 20
    //   683: invokevirtual 480	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   686: checkcast 97	java/lang/Long
    //   689: invokevirtual 496	java/lang/Long:longValue	()J
    //   692: aload 17
    //   694: invokespecial 498	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:a	(JLjava/lang/String;JLcom/tencent/mobileqq/app/SQLiteDatabase;)J
    //   697: ldc2_w 91
    //   700: lcmp
    //   701: ifne +56 -> 757
    //   704: aload 15
    //   706: astore 14
    //   708: aload_0
    //   709: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   712: invokevirtual 246	mqq/app/AppRuntime:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   715: invokestatic 252	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   718: aconst_null
    //   719: ldc_w 502
    //   722: iconst_0
    //   723: ldc2_w 91
    //   726: lconst_0
    //   727: aconst_null
    //   728: aconst_null
    //   729: iconst_0
    //   730: invokevirtual 261	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   733: invokestatic 280	java/lang/System:nanoTime	()J
    //   736: lload 7
    //   738: lsub
    //   739: ldc2_w 300
    //   742: ldiv
    //   743: lstore_3
    //   744: aload_0
    //   745: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   748: lload 5
    //   750: lload_3
    //   751: invokestatic 304	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   754: pop2
    //   755: iconst_0
    //   756: ireturn
    //   757: aload 15
    //   759: astore 13
    //   761: goto -315 -> 446
    //   764: aload 13
    //   766: astore 15
    //   768: aload 15
    //   770: astore 14
    //   772: aload_0
    //   773: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   776: iconst_1
    //   777: invokestatic 504	com/tencent/mobileqq/fts/utils/FTSUtils:c	(Lmqq/app/AppRuntime;Z)V
    //   780: aload 15
    //   782: astore 14
    //   784: aload_0
    //   785: invokespecial 439	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:c	()Z
    //   788: istore 12
    //   790: iload 12
    //   792: istore 11
    //   794: goto +155 -> 949
    //   797: astore 15
    //   799: goto +26 -> 825
    //   802: astore 15
    //   804: aload 14
    //   806: astore 13
    //   808: aload 15
    //   810: astore 14
    //   812: goto +50 -> 862
    //   815: astore 14
    //   817: aload 15
    //   819: astore 13
    //   821: aload 14
    //   823: astore 15
    //   825: aload 13
    //   827: astore 14
    //   829: aload 15
    //   831: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   834: ldc 80
    //   836: iconst_2
    //   837: aload 13
    //   839: aload 15
    //   841: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   844: goto +105 -> 949
    //   847: astore 14
    //   849: goto +13 -> 862
    //   852: astore 15
    //   854: aload 14
    //   856: astore 13
    //   858: aload 15
    //   860: astore 14
    //   862: aload 14
    //   864: athrow
    //   865: ldc_w 433
    //   868: astore 14
    //   870: aload 14
    //   872: astore 13
    //   874: aload_0
    //   875: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   878: iconst_1
    //   879: invokestatic 504	com/tencent/mobileqq/fts/utils/FTSUtils:c	(Lmqq/app/AppRuntime;Z)V
    //   882: aload 14
    //   884: astore 13
    //   886: aload_0
    //   887: invokespecial 439	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:c	()Z
    //   890: istore 12
    //   892: invokestatic 280	java/lang/System:nanoTime	()J
    //   895: lload 7
    //   897: lsub
    //   898: ldc2_w 300
    //   901: ldiv
    //   902: lstore_3
    //   903: aload_0
    //   904: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   907: lload 5
    //   909: lload_3
    //   910: invokestatic 304	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   913: pop2
    //   914: iload 12
    //   916: ireturn
    //   917: astore 14
    //   919: goto +15 -> 934
    //   922: astore 13
    //   924: goto +50 -> 974
    //   927: astore 14
    //   929: ldc_w 433
    //   932: astore 13
    //   934: aload 14
    //   936: invokevirtual 73	java/lang/Exception:printStackTrace	()V
    //   939: ldc 80
    //   941: iconst_2
    //   942: aload 13
    //   944: aload 14
    //   946: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   949: invokestatic 280	java/lang/System:nanoTime	()J
    //   952: lload 7
    //   954: lsub
    //   955: ldc2_w 300
    //   958: ldiv
    //   959: lstore_3
    //   960: aload_0
    //   961: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   964: lload 5
    //   966: lload_3
    //   967: invokestatic 304	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   970: pop2
    //   971: iload 11
    //   973: ireturn
    //   974: invokestatic 280	java/lang/System:nanoTime	()J
    //   977: lload 7
    //   979: lsub
    //   980: ldc2_w 300
    //   983: ldiv
    //   984: lstore_3
    //   985: aload_0
    //   986: getfield 25	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:jdField_a_of_type_MqqAppAppRuntime	Lmqq/app/AppRuntime;
    //   989: lload 5
    //   991: lload_3
    //   992: invokestatic 304	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   995: pop2
    //   996: goto +6 -> 1002
    //   999: aload 13
    //   1001: athrow
    //   1002: goto -3 -> 999
    //   1005: goto -722 -> 283
    //   1008: iload_1
    //   1009: iconst_1
    //   1010: iadd
    //   1011: istore_1
    //   1012: goto -907 -> 105
    //   1015: ldc2_w 91
    //   1018: lstore_3
    //   1019: goto -427 -> 592
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1022	0	this	FTSMsgUpgrader
    //   104	908	1	i	int
    //   102	6	2	j	int
    //   588	431	3	l1	long
    //   50	940	5	l2	long
    //   55	923	7	l3	long
    //   633	15	9	l4	long
    //   58	914	11	bool1	boolean
    //   788	127	12	bool2	boolean
    //   8	877	13	localObject1	Object
    //   922	1	13	localObject2	Object
    //   932	68	13	str1	String
    //   74	737	14	localObject3	Object
    //   815	7	14	localException1	java.lang.Exception
    //   827	1	14	localObject4	Object
    //   847	8	14	localObject5	Object
    //   860	23	14	localObject6	Object
    //   917	1	14	localException2	java.lang.Exception
    //   927	18	14	localException3	java.lang.Exception
    //   114	667	15	localObject7	Object
    //   797	1	15	localException4	java.lang.Exception
    //   802	16	15	localObject8	Object
    //   823	17	15	localException5	java.lang.Exception
    //   852	7	15	localObject9	Object
    //   189	284	16	localObject10	Object
    //   67	626	17	localSQLiteDatabase	SQLiteDatabase
    //   3	574	18	str2	String
    //   97	583	19	localHashMap	HashMap
    //   482	200	20	str3	String
    //   522	84	21	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   643	661	797	java/lang/Exception
    //   665	671	797	java/lang/Exception
    //   675	704	797	java/lang/Exception
    //   708	733	797	java/lang/Exception
    //   772	780	797	java/lang/Exception
    //   784	790	797	java/lang/Exception
    //   417	426	802	finally
    //   434	446	802	finally
    //   454	464	802	finally
    //   472	484	802	finally
    //   492	524	802	finally
    //   537	548	802	finally
    //   556	564	802	finally
    //   572	589	802	finally
    //   605	612	802	finally
    //   620	635	802	finally
    //   417	426	815	java/lang/Exception
    //   434	446	815	java/lang/Exception
    //   454	464	815	java/lang/Exception
    //   472	484	815	java/lang/Exception
    //   492	524	815	java/lang/Exception
    //   537	548	815	java/lang/Exception
    //   556	564	815	java/lang/Exception
    //   572	589	815	java/lang/Exception
    //   605	612	815	java/lang/Exception
    //   620	635	815	java/lang/Exception
    //   834	844	847	finally
    //   643	661	852	finally
    //   665	671	852	finally
    //   675	704	852	finally
    //   708	733	852	finally
    //   772	780	852	finally
    //   784	790	852	finally
    //   829	834	852	finally
    //   862	865	917	java/lang/Exception
    //   874	882	917	java/lang/Exception
    //   886	892	917	java/lang/Exception
    //   60	76	922	finally
    //   81	87	922	finally
    //   90	103	922	finally
    //   116	182	922	finally
    //   182	229	922	finally
    //   234	280	922	finally
    //   288	295	922	finally
    //   298	316	922	finally
    //   316	406	922	finally
    //   862	865	922	finally
    //   874	882	922	finally
    //   886	892	922	finally
    //   934	949	922	finally
    //   60	76	927	java/lang/Exception
    //   81	87	927	java/lang/Exception
    //   90	103	927	java/lang/Exception
    //   116	182	927	java/lang/Exception
    //   182	229	927	java/lang/Exception
    //   234	280	927	java/lang/Exception
    //   288	295	927	java/lang/Exception
    //   298	316	927	java/lang/Exception
    //   316	406	927	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.operator.FTSMsgUpgrader
 * JD-Core Version:    0.7.0.1
 */