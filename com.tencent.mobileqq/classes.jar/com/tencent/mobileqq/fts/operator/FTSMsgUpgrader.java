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
  boolean a = false;
  private AppRuntime b;
  private FTSDatatbase c;
  private int d;
  private int e;
  private FTSSyncHandler f;
  private FTSMsgOperator g;
  private boolean h = false;
  
  FTSMsgUpgrader(AppRuntime paramAppRuntime, FTSMsgOperator paramFTSMsgOperator)
  {
    this.b = paramAppRuntime;
    this.g = paramFTSMsgOperator;
    this.c = this.g.b;
    this.f = this.g.d;
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
    //   10: ldc 92
    //   12: aconst_null
    //   13: invokevirtual 96	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
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
    //   31: invokeinterface 102 1 0
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
    //   52: invokeinterface 105 1 0
    //   57: iload_2
    //   58: ireturn
    //   59: astore_1
    //   60: goto +32 -> 92
    //   63: astore_1
    //   64: aload_1
    //   65: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   68: iload_3
    //   69: istore 4
    //   71: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +15 -> 89
    //   77: ldc 116
    //   79: iconst_2
    //   80: ldc 118
    //   82: aload_1
    //   83: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
  
  /* Error */
  private int b(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 4
    //   3: iload 4
    //   5: istore_3
    //   6: aload_1
    //   7: ldc 124
    //   9: aconst_null
    //   10: invokevirtual 96	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
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
    //   28: invokeinterface 102 1 0
    //   33: iconst_1
    //   34: if_icmpne +31 -> 65
    //   37: iload 4
    //   39: istore_3
    //   40: aload_1
    //   41: invokeinterface 127 1 0
    //   46: pop
    //   47: iload 4
    //   49: istore_3
    //   50: aload_1
    //   51: aload_1
    //   52: ldc 52
    //   54: invokeinterface 131 2 0
    //   59: invokeinterface 135 2 0
    //   64: istore_2
    //   65: iload_2
    //   66: istore 4
    //   68: aload_1
    //   69: ifnull +43 -> 112
    //   72: iload_2
    //   73: istore_3
    //   74: aload_1
    //   75: invokeinterface 105 1 0
    //   80: iload_2
    //   81: ireturn
    //   82: astore_1
    //   83: goto +32 -> 115
    //   86: astore_1
    //   87: aload_1
    //   88: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   91: iload_3
    //   92: istore 4
    //   94: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +15 -> 112
    //   100: ldc 116
    //   102: iconst_2
    //   103: ldc 118
    //   105: aload_1
    //   106: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
  
  private List<MessageRecord> c(SQLiteDatabase paramSQLiteDatabase)
  {
    Object localObject1 = paramSQLiteDatabase.rawQuery("SELECT tablename, MAX_ID FROM msg_upgrade_log WHERE id=?;", new String[] { String.valueOf(this.e + 1) });
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
        paramSQLiteDatabase.append(this.e + 1);
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
        localObject2 = ((IMessageRecordEntityManager)this.b.getRuntimeService(IMessageRecordEntityManager.class, "")).rawQuery((String)localObject1, new String[] { String.valueOf(l) });
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
  
  private boolean d()
  {
    if (FTSUtils.b(this.b) != 1) {
      return false;
    }
    if (FTSUtils.h(this.b))
    {
      QLog.d("Q.fts.FTSMsgUpgrader", 1, "========== upgrade table has complete");
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.FTSMsgUpgrader", 2, "========== upgrade table start");
    }
    long l1 = FTSUtils.g(this.b);
    long l2 = System.nanoTime();
    if (!a(this.b.getReadableDatabase()))
    {
      QLog.d("Q.fts.FTSMsgUpgrader", 1, "startUpgradeTableStep: msg_upgrade_log has not exist");
      e();
      return true;
    }
    int i = b(this.b.getReadableDatabase());
    if (i == -1)
    {
      QLog.d("Q.fts.FTSMsgUpgrader", 1, "startUpgradeTableStep: query msg_upgrade_log MAX(id) failure");
      e();
      return true;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startUpgradeTableStep: maxIndex = ");
      localStringBuilder.append(i);
      QLog.d("Q.fts.FTSMsgUpgrader", 2, localStringBuilder.toString());
    }
    this.d = i;
    l2 = (System.nanoTime() - l2) / 1000L;
    FTSUtils.a(this.b, l1, l2);
    this.f.post(new FTSMsgUpgrader.1(this));
    return false;
  }
  
  private void e()
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_table", String.valueOf(FTSUtils.i(this.b)));
    ((HashMap)localObject).put("param_msg", String.valueOf(FTSUtils.j(this.b)));
    StatisticCollector.getInstance(this.b.getApp()).collectPerformance(null, "actFTSUpgradeCost", true, FTSUtils.g(this.b), 0L, (HashMap)localObject, null, false);
    FTSUtils.d(this.b, true);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("========== upgrade table complete, cost =");
      ((StringBuilder)localObject).append(FTSUtils.g(this.b));
      ((StringBuilder)localObject).append("us, tables = ");
      ((StringBuilder)localObject).append(FTSUtils.i(this.b));
      ((StringBuilder)localObject).append(", msgs = ");
      ((StringBuilder)localObject).append(FTSUtils.j(this.b));
      QLog.d("Q.fts.FTSMsgUpgrader", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  private void f()
  {
    long l1 = FTSUtils.g(this.b);
    long l2 = System.nanoTime();
    int i;
    if (!this.c.b("UpgradeCursor"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.fts.FTSMsgUpgrader", 2, "startUpgradeTableStep: upgradeCursorTable has not exist");
      }
      if (!this.c.a("UpgradeCursor"))
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
      j = this.c.c("UpgradeCursor");
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
    this.e = j;
    l2 = (System.nanoTime() - l2) / 1000L;
    FTSUtils.a(this.b, l1, l2);
    this.a = true;
  }
  
  /* Error */
  private boolean g()
  {
    // Byte code:
    //   0: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 116
    //   8: iconst_2
    //   9: ldc_w 346
    //   12: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: new 348	java/util/ArrayList
    //   18: dup
    //   19: sipush 512
    //   22: invokespecial 351	java/util/ArrayList:<init>	(I)V
    //   25: astore 8
    //   27: aload_0
    //   28: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   31: invokestatic 288	com/tencent/mobileqq/fts/utils/FTSUtils:i	(Lmqq/app/AppRuntime;)I
    //   34: istore_1
    //   35: aload_0
    //   36: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   39: invokestatic 296	com/tencent/mobileqq/fts/utils/FTSUtils:j	(Lmqq/app/AppRuntime;)I
    //   42: istore_2
    //   43: aload_0
    //   44: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   47: invokestatic 240	com/tencent/mobileqq/fts/utils/FTSUtils:g	(Lmqq/app/AppRuntime;)J
    //   50: lstore 4
    //   52: invokestatic 246	java/lang/System:nanoTime	()J
    //   55: lstore 6
    //   57: aload_0
    //   58: aload_0
    //   59: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   62: invokevirtual 250	mqq/app/AppRuntime:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   65: invokespecial 353	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:c	(Lcom/tencent/mobileqq/app/SQLiteDatabase;)Ljava/util/List;
    //   68: astore 9
    //   70: aload 9
    //   72: ifnull +224 -> 296
    //   75: aload 9
    //   77: invokeinterface 356 1 0
    //   82: ifne +214 -> 296
    //   85: aload 9
    //   87: invokeinterface 360 1 0
    //   92: astore 9
    //   94: aload 9
    //   96: invokeinterface 365 1 0
    //   101: ifeq +195 -> 296
    //   104: aload 9
    //   106: invokeinterface 369 1 0
    //   111: checkcast 371	com/tencent/mobileqq/data/MessageRecord
    //   114: astore 10
    //   116: aload 10
    //   118: invokevirtual 374	com/tencent/mobileqq/data/MessageRecord:isSupportFTS	()Z
    //   121: ifeq +172 -> 293
    //   124: aload 10
    //   126: getfield 377	com/tencent/mobileqq/data/MessageRecord:isValid	Z
    //   129: ifeq +164 -> 293
    //   132: aload 10
    //   134: getfield 380	com/tencent/mobileqq/data/MessageRecord:msgtype	I
    //   137: sipush -2006
    //   140: if_icmpeq +153 -> 293
    //   143: aload 10
    //   145: invokestatic 385	com/tencent/mobileqq/fts/v1/utils/FTSMessageCodec:a	(Lcom/tencent/mobileqq/data/MessageRecord;)Lcom/tencent/mobileqq/fts/data/msg/FTSMessage;
    //   148: astore 10
    //   150: aload 10
    //   152: ifnull +141 -> 293
    //   155: aload 10
    //   157: invokevirtual 390	com/tencent/mobileqq/fts/data/msg/FTSMessage:insertOpt	()V
    //   160: aload 10
    //   162: invokevirtual 393	com/tencent/mobileqq/fts/data/msg/FTSMessage:preWrite	()V
    //   165: aload 8
    //   167: aload 10
    //   169: invokevirtual 397	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   172: pop
    //   173: goto +120 -> 293
    //   176: astore 9
    //   178: aload 9
    //   180: invokevirtual 398	java/lang/Throwable:printStackTrace	()V
    //   183: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +40 -> 226
    //   189: new 154	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   196: astore 10
    //   198: aload 10
    //   200: ldc_w 400
    //   203: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload 10
    //   209: aload 9
    //   211: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: ldc 116
    //   217: iconst_2
    //   218: aload 10
    //   220: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 402	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   229: ifeq +62 -> 291
    //   232: new 154	java/lang/StringBuilder
    //   235: dup
    //   236: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   239: astore 9
    //   241: aload 9
    //   243: ldc_w 404
    //   246: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 9
    //   252: aload 8
    //   254: invokevirtual 405	java/util/ArrayList:size	()I
    //   257: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 9
    //   263: ldc_w 407
    //   266: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 9
    //   272: aload_0
    //   273: getfield 142	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:e	I
    //   276: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: ldc 116
    //   282: iconst_2
    //   283: aload 9
    //   285: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: iconst_0
    //   292: ireturn
    //   293: goto -199 -> 94
    //   296: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq +62 -> 361
    //   302: new 154	java/lang/StringBuilder
    //   305: dup
    //   306: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   309: astore 9
    //   311: aload 9
    //   313: ldc_w 404
    //   316: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload 9
    //   322: aload 8
    //   324: invokevirtual 405	java/util/ArrayList:size	()I
    //   327: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload 9
    //   333: ldc_w 407
    //   336: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: aload 9
    //   342: aload_0
    //   343: getfield 142	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:e	I
    //   346: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: ldc 116
    //   352: iconst_2
    //   353: aload 9
    //   355: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload_0
    //   362: getfield 39	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:c	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   365: aload 8
    //   367: iconst_1
    //   368: invokevirtual 410	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   371: iconst_m1
    //   372: if_icmpne +114 -> 486
    //   375: ldc2_w 411
    //   378: invokestatic 418	java/lang/Thread:sleep	(J)V
    //   381: goto +10 -> 391
    //   384: astore 9
    //   386: aload 9
    //   388: invokevirtual 419	java/lang/InterruptedException:printStackTrace	()V
    //   391: aload_0
    //   392: getfield 39	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:c	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   395: aload 8
    //   397: iconst_1
    //   398: invokevirtual 410	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   401: istore_3
    //   402: invokestatic 246	java/lang/System:nanoTime	()J
    //   405: lload 6
    //   407: lsub
    //   408: ldc2_w 265
    //   411: ldiv
    //   412: lstore 6
    //   414: aload_0
    //   415: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   418: lload 4
    //   420: lload 6
    //   422: invokestatic 269	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   425: pop2
    //   426: iload_3
    //   427: iconst_m1
    //   428: if_icmpne +45 -> 473
    //   431: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   434: ifeq +12 -> 446
    //   437: ldc 116
    //   439: iconst_2
    //   440: ldc_w 421
    //   443: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: aload_0
    //   447: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   450: invokevirtual 300	mqq/app/AppRuntime:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   453: invokestatic 306	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   456: aconst_null
    //   457: ldc_w 423
    //   460: iconst_0
    //   461: ldc2_w 46
    //   464: lconst_0
    //   465: aconst_null
    //   466: aconst_null
    //   467: iconst_0
    //   468: invokevirtual 312	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   471: iconst_0
    //   472: ireturn
    //   473: aload_0
    //   474: aload_0
    //   475: getfield 142	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:e	I
    //   478: iconst_1
    //   479: iadd
    //   480: putfield 142	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:e	I
    //   483: goto +37 -> 520
    //   486: invokestatic 246	java/lang/System:nanoTime	()J
    //   489: lload 6
    //   491: lsub
    //   492: ldc2_w 265
    //   495: ldiv
    //   496: lstore 6
    //   498: aload_0
    //   499: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   502: lload 4
    //   504: lload 6
    //   506: invokestatic 269	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   509: pop2
    //   510: aload_0
    //   511: aload_0
    //   512: getfield 142	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:e	I
    //   515: iconst_1
    //   516: iadd
    //   517: putfield 142	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:e	I
    //   520: aload_0
    //   521: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   524: iload_1
    //   525: iconst_1
    //   526: invokestatic 426	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;II)I
    //   529: pop
    //   530: aload_0
    //   531: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   534: iload_2
    //   535: aload 8
    //   537: invokevirtual 405	java/util/ArrayList:size	()I
    //   540: invokestatic 428	com/tencent/mobileqq/fts/utils/FTSUtils:b	(Lmqq/app/AppRuntime;II)I
    //   543: pop
    //   544: iconst_1
    //   545: ireturn
    //   546: astore 9
    //   548: goto +94 -> 642
    //   551: astore 9
    //   553: aload 9
    //   555: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   558: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   561: ifeq +14 -> 575
    //   564: ldc 116
    //   566: iconst_2
    //   567: ldc_w 430
    //   570: aload 9
    //   572: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   575: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   578: ifeq +62 -> 640
    //   581: new 154	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   588: astore 9
    //   590: aload 9
    //   592: ldc_w 404
    //   595: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload 9
    //   601: aload 8
    //   603: invokevirtual 405	java/util/ArrayList:size	()I
    //   606: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload 9
    //   612: ldc_w 407
    //   615: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload 9
    //   621: aload_0
    //   622: getfield 142	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:e	I
    //   625: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: ldc 116
    //   631: iconst_2
    //   632: aload 9
    //   634: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   637: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   640: iconst_0
    //   641: ireturn
    //   642: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq +62 -> 707
    //   648: new 154	java/lang/StringBuilder
    //   651: dup
    //   652: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   655: astore 10
    //   657: aload 10
    //   659: ldc_w 404
    //   662: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: pop
    //   666: aload 10
    //   668: aload 8
    //   670: invokevirtual 405	java/util/ArrayList:size	()I
    //   673: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   676: pop
    //   677: aload 10
    //   679: ldc_w 407
    //   682: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload 10
    //   688: aload_0
    //   689: getfield 142	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:e	I
    //   692: invokevirtual 164	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   695: pop
    //   696: ldc 116
    //   698: iconst_2
    //   699: aload 10
    //   701: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   704: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   707: aload_0
    //   708: getfield 39	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:c	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   711: aload 8
    //   713: iconst_1
    //   714: invokevirtual 410	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   717: iconst_m1
    //   718: if_icmpne +81 -> 799
    //   721: ldc2_w 411
    //   724: invokestatic 418	java/lang/Thread:sleep	(J)V
    //   727: goto +10 -> 737
    //   730: astore 10
    //   732: aload 10
    //   734: invokevirtual 419	java/lang/InterruptedException:printStackTrace	()V
    //   737: aload_0
    //   738: getfield 39	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:c	Lcom/tencent/mobileqq/persistence/fts/FTSDatatbase;
    //   741: aload 8
    //   743: iconst_1
    //   744: invokevirtual 410	com/tencent/mobileqq/persistence/fts/FTSDatatbase:a	(Ljava/util/ArrayList;I)I
    //   747: istore_3
    //   748: invokestatic 246	java/lang/System:nanoTime	()J
    //   751: lload 6
    //   753: lsub
    //   754: ldc2_w 265
    //   757: ldiv
    //   758: lstore 6
    //   760: aload_0
    //   761: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   764: lload 4
    //   766: lload 6
    //   768: invokestatic 269	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   771: pop2
    //   772: iload_3
    //   773: iconst_m1
    //   774: if_icmpne +12 -> 786
    //   777: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   780: ifeq -334 -> 446
    //   783: goto -346 -> 437
    //   786: aload_0
    //   787: aload_0
    //   788: getfield 142	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:e	I
    //   791: iconst_1
    //   792: iadd
    //   793: putfield 142	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:e	I
    //   796: goto +37 -> 833
    //   799: invokestatic 246	java/lang/System:nanoTime	()J
    //   802: lload 6
    //   804: lsub
    //   805: ldc2_w 265
    //   808: ldiv
    //   809: lstore 6
    //   811: aload_0
    //   812: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   815: lload 4
    //   817: lload 6
    //   819: invokestatic 269	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   822: pop2
    //   823: aload_0
    //   824: aload_0
    //   825: getfield 142	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:e	I
    //   828: iconst_1
    //   829: iadd
    //   830: putfield 142	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:e	I
    //   833: aload_0
    //   834: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   837: iload_1
    //   838: iconst_1
    //   839: invokestatic 426	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;II)I
    //   842: pop
    //   843: aload_0
    //   844: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   847: iload_2
    //   848: aload 8
    //   850: invokevirtual 405	java/util/ArrayList:size	()I
    //   853: invokestatic 428	com/tencent/mobileqq/fts/utils/FTSUtils:b	(Lmqq/app/AppRuntime;II)I
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
  
  public boolean a()
  {
    return !FTSUtils.k(this.b);
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: ldc_w 439
    //   3: astore 18
    //   5: ldc_w 441
    //   8: astore 13
    //   10: aload_0
    //   11: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   14: invokestatic 443	com/tencent/mobileqq/fts/utils/FTSUtils:f	(Lmqq/app/AppRuntime;)Z
    //   17: ifeq +17 -> 34
    //   20: ldc 116
    //   22: iconst_2
    //   23: ldc_w 445
    //   26: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_0
    //   30: invokespecial 447	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:d	()Z
    //   33: ireturn
    //   34: ldc 116
    //   36: iconst_2
    //   37: ldc_w 449
    //   40: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   43: aload_0
    //   44: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   47: invokestatic 240	com/tencent/mobileqq/fts/utils/FTSUtils:g	(Lmqq/app/AppRuntime;)J
    //   50: lstore 5
    //   52: invokestatic 246	java/lang/System:nanoTime	()J
    //   55: lstore 7
    //   57: iconst_0
    //   58: istore 11
    //   60: aload_0
    //   61: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   64: invokevirtual 250	mqq/app/AppRuntime:getReadableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   67: astore 17
    //   69: aload 17
    //   71: invokevirtual 453	com/tencent/mobileqq/app/SQLiteDatabase:getAllTableNameFromDB	()[Ljava/lang/String;
    //   74: astore 14
    //   76: aload 14
    //   78: ifnull +798 -> 876
    //   81: aload 14
    //   83: arraylength
    //   84: ifne +6 -> 90
    //   87: goto +789 -> 876
    //   90: new 282	java/util/HashMap
    //   93: dup
    //   94: invokespecial 283	java/util/HashMap:<init>	()V
    //   97: astore 19
    //   99: aload 14
    //   101: arraylength
    //   102: istore_2
    //   103: iconst_0
    //   104: istore_1
    //   105: iload_1
    //   106: iload_2
    //   107: if_icmpge +202 -> 309
    //   110: aload 14
    //   112: iload_1
    //   113: aaload
    //   114: astore 15
    //   116: aload 15
    //   118: ldc_w 455
    //   121: invokevirtual 458	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   124: ifeq +895 -> 1019
    //   127: aload 15
    //   129: ldc_w 460
    //   132: invokevirtual 463	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   135: ifne +58 -> 193
    //   138: aload 15
    //   140: ldc_w 465
    //   143: invokevirtual 463	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   146: ifne +47 -> 193
    //   149: aload 15
    //   151: ldc_w 467
    //   154: invokevirtual 463	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   157: ifne +36 -> 193
    //   160: aload 15
    //   162: ldc_w 469
    //   165: invokevirtual 463	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   168: ifne +25 -> 193
    //   171: aload 15
    //   173: ldc_w 471
    //   176: invokevirtual 463	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   179: ifne +14 -> 193
    //   182: aload 15
    //   184: ldc_w 473
    //   187: invokevirtual 463	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   190: ifeq +829 -> 1019
    //   193: new 154	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   200: astore 16
    //   202: aload 16
    //   204: ldc_w 475
    //   207: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: pop
    //   211: aload 16
    //   213: aload 15
    //   215: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload 16
    //   221: ldc 190
    //   223: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 17
    //   229: aload 16
    //   231: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: aconst_null
    //   235: invokevirtual 96	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   238: astore 16
    //   240: aload 16
    //   242: ifnull +774 -> 1016
    //   245: aload 16
    //   247: invokeinterface 102 1 0
    //   252: iconst_1
    //   253: if_icmpne +41 -> 294
    //   256: aload 16
    //   258: invokeinterface 127 1 0
    //   263: pop
    //   264: aload 19
    //   266: aload 15
    //   268: aload 16
    //   270: aload 16
    //   272: ldc 52
    //   274: invokeinterface 131 2 0
    //   279: invokeinterface 152 2 0
    //   284: invokestatic 58	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   287: invokevirtual 291	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   290: pop
    //   291: goto +3 -> 294
    //   294: aload 16
    //   296: ifnull +723 -> 1019
    //   299: aload 16
    //   301: invokeinterface 105 1 0
    //   306: goto +713 -> 1019
    //   309: invokestatic 114	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq +108 -> 420
    //   315: aload 19
    //   317: invokevirtual 479	java/util/HashMap:keySet	()Ljava/util/Set;
    //   320: invokeinterface 482 1 0
    //   325: astore 14
    //   327: aload 14
    //   329: invokeinterface 365 1 0
    //   334: ifeq +86 -> 420
    //   337: aload 14
    //   339: invokeinterface 369 1 0
    //   344: checkcast 68	java/lang/String
    //   347: astore 15
    //   349: new 154	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   356: astore 16
    //   358: aload 16
    //   360: ldc_w 484
    //   363: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: pop
    //   367: aload 16
    //   369: aload 15
    //   371: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload 16
    //   377: ldc_w 486
    //   380: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 16
    //   386: aload 19
    //   388: aload 15
    //   390: invokevirtual 490	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   393: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload 16
    //   399: ldc_w 492
    //   402: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: ldc 116
    //   408: iconst_2
    //   409: aload 16
    //   411: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: goto -90 -> 327
    //   420: aload 13
    //   422: astore 14
    //   424: aload 13
    //   426: astore 15
    //   428: aload 17
    //   430: ldc_w 494
    //   433: invokevirtual 497	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   436: pop
    //   437: aload 13
    //   439: astore 14
    //   441: aload 13
    //   443: astore 15
    //   445: aload 19
    //   447: invokevirtual 479	java/util/HashMap:keySet	()Ljava/util/Set;
    //   450: invokeinterface 482 1 0
    //   455: astore 16
    //   457: aload 13
    //   459: astore 14
    //   461: aload 13
    //   463: astore 15
    //   465: aload 16
    //   467: invokeinterface 365 1 0
    //   472: ifeq +303 -> 775
    //   475: aload 13
    //   477: astore 14
    //   479: aload 13
    //   481: astore 15
    //   483: aload 16
    //   485: invokeinterface 369 1 0
    //   490: checkcast 68	java/lang/String
    //   493: astore 20
    //   495: aload 13
    //   497: astore 14
    //   499: aload 13
    //   501: astore 15
    //   503: aload 17
    //   505: ldc 64
    //   507: iconst_1
    //   508: anewarray 68	java/lang/String
    //   511: dup
    //   512: iconst_0
    //   513: aload 18
    //   515: aastore
    //   516: ldc_w 499
    //   519: iconst_1
    //   520: anewarray 68	java/lang/String
    //   523: dup
    //   524: iconst_0
    //   525: aload 20
    //   527: aastore
    //   528: aconst_null
    //   529: aconst_null
    //   530: invokevirtual 503	com/tencent/mobileqq/app/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   533: astore 21
    //   535: aload 21
    //   537: ifnull +489 -> 1026
    //   540: aload 13
    //   542: astore 14
    //   544: aload 13
    //   546: astore 15
    //   548: aload 21
    //   550: invokeinterface 102 1 0
    //   555: iconst_1
    //   556: if_icmpne +470 -> 1026
    //   559: aload 13
    //   561: astore 14
    //   563: aload 13
    //   565: astore 15
    //   567: aload 21
    //   569: invokeinterface 127 1 0
    //   574: pop
    //   575: aload 13
    //   577: astore 14
    //   579: aload 13
    //   581: astore 15
    //   583: aload 21
    //   585: aload 21
    //   587: aload 18
    //   589: invokeinterface 131 2 0
    //   594: invokeinterface 152 2 0
    //   599: lstore_3
    //   600: goto +3 -> 603
    //   603: aload 21
    //   605: ifnull +18 -> 623
    //   608: aload 13
    //   610: astore 14
    //   612: aload 13
    //   614: astore 15
    //   616: aload 21
    //   618: invokeinterface 105 1 0
    //   623: aload 13
    //   625: astore 14
    //   627: aload 13
    //   629: astore 15
    //   631: aload 19
    //   633: aload 20
    //   635: invokevirtual 490	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   638: checkcast 54	java/lang/Long
    //   641: invokevirtual 506	java/lang/Long:longValue	()J
    //   644: lstore 9
    //   646: aload 13
    //   648: astore 15
    //   650: aload 15
    //   652: astore 14
    //   654: aload_0
    //   655: lload_3
    //   656: aload 20
    //   658: lload 9
    //   660: aload 17
    //   662: invokespecial 508	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:a	(JLjava/lang/String;JLcom/tencent/mobileqq/app/SQLiteDatabase;)J
    //   665: ldc2_w 46
    //   668: lcmp
    //   669: ifne +99 -> 768
    //   672: aload 15
    //   674: astore 14
    //   676: ldc2_w 509
    //   679: invokestatic 418	java/lang/Thread:sleep	(J)V
    //   682: aload 15
    //   684: astore 14
    //   686: aload_0
    //   687: lload_3
    //   688: aload 20
    //   690: aload 19
    //   692: aload 20
    //   694: invokevirtual 490	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   697: checkcast 54	java/lang/Long
    //   700: invokevirtual 506	java/lang/Long:longValue	()J
    //   703: aload 17
    //   705: invokespecial 508	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:a	(JLjava/lang/String;JLcom/tencent/mobileqq/app/SQLiteDatabase;)J
    //   708: ldc2_w 46
    //   711: lcmp
    //   712: ifne +56 -> 768
    //   715: aload 15
    //   717: astore 14
    //   719: aload_0
    //   720: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   723: invokevirtual 300	mqq/app/AppRuntime:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   726: invokestatic 306	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   729: aconst_null
    //   730: ldc_w 512
    //   733: iconst_0
    //   734: ldc2_w 46
    //   737: lconst_0
    //   738: aconst_null
    //   739: aconst_null
    //   740: iconst_0
    //   741: invokevirtual 312	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   744: invokestatic 246	java/lang/System:nanoTime	()J
    //   747: lload 7
    //   749: lsub
    //   750: ldc2_w 265
    //   753: ldiv
    //   754: lstore_3
    //   755: aload_0
    //   756: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   759: lload 5
    //   761: lload_3
    //   762: invokestatic 269	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   765: pop2
    //   766: iconst_0
    //   767: ireturn
    //   768: aload 15
    //   770: astore 13
    //   772: goto -315 -> 457
    //   775: aload 13
    //   777: astore 15
    //   779: aload 15
    //   781: astore 14
    //   783: aload_0
    //   784: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   787: iconst_1
    //   788: invokestatic 514	com/tencent/mobileqq/fts/utils/FTSUtils:c	(Lmqq/app/AppRuntime;Z)V
    //   791: aload 15
    //   793: astore 14
    //   795: aload_0
    //   796: invokespecial 447	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:d	()Z
    //   799: istore 12
    //   801: iload 12
    //   803: istore 11
    //   805: goto +155 -> 960
    //   808: astore 15
    //   810: goto +26 -> 836
    //   813: astore 15
    //   815: aload 14
    //   817: astore 13
    //   819: aload 15
    //   821: astore 14
    //   823: goto +50 -> 873
    //   826: astore 14
    //   828: aload 15
    //   830: astore 13
    //   832: aload 14
    //   834: astore 15
    //   836: aload 13
    //   838: astore 14
    //   840: aload 15
    //   842: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   845: ldc 116
    //   847: iconst_2
    //   848: aload 13
    //   850: aload 15
    //   852: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   855: goto +105 -> 960
    //   858: astore 14
    //   860: goto +13 -> 873
    //   863: astore 15
    //   865: aload 14
    //   867: astore 13
    //   869: aload 15
    //   871: astore 14
    //   873: aload 14
    //   875: athrow
    //   876: ldc_w 441
    //   879: astore 14
    //   881: aload 14
    //   883: astore 13
    //   885: aload_0
    //   886: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   889: iconst_1
    //   890: invokestatic 514	com/tencent/mobileqq/fts/utils/FTSUtils:c	(Lmqq/app/AppRuntime;Z)V
    //   893: aload 14
    //   895: astore 13
    //   897: aload_0
    //   898: invokespecial 447	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:d	()Z
    //   901: istore 12
    //   903: invokestatic 246	java/lang/System:nanoTime	()J
    //   906: lload 7
    //   908: lsub
    //   909: ldc2_w 265
    //   912: ldiv
    //   913: lstore_3
    //   914: aload_0
    //   915: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   918: lload 5
    //   920: lload_3
    //   921: invokestatic 269	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   924: pop2
    //   925: iload 12
    //   927: ireturn
    //   928: astore 14
    //   930: goto +15 -> 945
    //   933: astore 13
    //   935: goto +50 -> 985
    //   938: astore 14
    //   940: ldc_w 441
    //   943: astore 13
    //   945: aload 14
    //   947: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   950: ldc 116
    //   952: iconst_2
    //   953: aload 13
    //   955: aload 14
    //   957: invokestatic 121	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   960: invokestatic 246	java/lang/System:nanoTime	()J
    //   963: lload 7
    //   965: lsub
    //   966: ldc2_w 265
    //   969: ldiv
    //   970: lstore_3
    //   971: aload_0
    //   972: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   975: lload 5
    //   977: lload_3
    //   978: invokestatic 269	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   981: pop2
    //   982: iload 11
    //   984: ireturn
    //   985: invokestatic 246	java/lang/System:nanoTime	()J
    //   988: lload 7
    //   990: lsub
    //   991: ldc2_w 265
    //   994: ldiv
    //   995: lstore_3
    //   996: aload_0
    //   997: getfield 31	com/tencent/mobileqq/fts/operator/FTSMsgUpgrader:b	Lmqq/app/AppRuntime;
    //   1000: lload 5
    //   1002: lload_3
    //   1003: invokestatic 269	com/tencent/mobileqq/fts/utils/FTSUtils:a	(Lmqq/app/AppRuntime;JJ)J
    //   1006: pop2
    //   1007: goto +6 -> 1013
    //   1010: aload 13
    //   1012: athrow
    //   1013: goto -3 -> 1010
    //   1016: goto -722 -> 294
    //   1019: iload_1
    //   1020: iconst_1
    //   1021: iadd
    //   1022: istore_1
    //   1023: goto -918 -> 105
    //   1026: ldc2_w 46
    //   1029: lstore_3
    //   1030: goto -427 -> 603
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1033	0	this	FTSMsgUpgrader
    //   104	919	1	i	int
    //   102	6	2	j	int
    //   599	431	3	l1	long
    //   50	951	5	l2	long
    //   55	934	7	l3	long
    //   644	15	9	l4	long
    //   58	925	11	bool1	boolean
    //   799	127	12	bool2	boolean
    //   8	888	13	localObject1	Object
    //   933	1	13	localObject2	Object
    //   943	68	13	str1	String
    //   74	748	14	localObject3	Object
    //   826	7	14	localException1	java.lang.Exception
    //   838	1	14	localObject4	Object
    //   858	8	14	localObject5	Object
    //   871	23	14	localObject6	Object
    //   928	1	14	localException2	java.lang.Exception
    //   938	18	14	localException3	java.lang.Exception
    //   114	678	15	localObject7	Object
    //   808	1	15	localException4	java.lang.Exception
    //   813	16	15	localObject8	Object
    //   834	17	15	localException5	java.lang.Exception
    //   863	7	15	localObject9	Object
    //   200	284	16	localObject10	Object
    //   67	637	17	localSQLiteDatabase	SQLiteDatabase
    //   3	585	18	str2	String
    //   97	594	19	localHashMap	HashMap
    //   493	200	20	str3	String
    //   533	84	21	localCursor	Cursor
    // Exception table:
    //   from	to	target	type
    //   654	672	808	java/lang/Exception
    //   676	682	808	java/lang/Exception
    //   686	715	808	java/lang/Exception
    //   719	744	808	java/lang/Exception
    //   783	791	808	java/lang/Exception
    //   795	801	808	java/lang/Exception
    //   428	437	813	finally
    //   445	457	813	finally
    //   465	475	813	finally
    //   483	495	813	finally
    //   503	535	813	finally
    //   548	559	813	finally
    //   567	575	813	finally
    //   583	600	813	finally
    //   616	623	813	finally
    //   631	646	813	finally
    //   428	437	826	java/lang/Exception
    //   445	457	826	java/lang/Exception
    //   465	475	826	java/lang/Exception
    //   483	495	826	java/lang/Exception
    //   503	535	826	java/lang/Exception
    //   548	559	826	java/lang/Exception
    //   567	575	826	java/lang/Exception
    //   583	600	826	java/lang/Exception
    //   616	623	826	java/lang/Exception
    //   631	646	826	java/lang/Exception
    //   845	855	858	finally
    //   654	672	863	finally
    //   676	682	863	finally
    //   686	715	863	finally
    //   719	744	863	finally
    //   783	791	863	finally
    //   795	801	863	finally
    //   840	845	863	finally
    //   873	876	928	java/lang/Exception
    //   885	893	928	java/lang/Exception
    //   897	903	928	java/lang/Exception
    //   60	76	933	finally
    //   81	87	933	finally
    //   90	103	933	finally
    //   116	193	933	finally
    //   193	240	933	finally
    //   245	291	933	finally
    //   299	306	933	finally
    //   309	327	933	finally
    //   327	417	933	finally
    //   873	876	933	finally
    //   885	893	933	finally
    //   897	903	933	finally
    //   945	960	933	finally
    //   60	76	938	java/lang/Exception
    //   81	87	938	java/lang/Exception
    //   90	103	938	java/lang/Exception
    //   116	193	938	java/lang/Exception
    //   193	240	938	java/lang/Exception
    //   245	291	938	java/lang/Exception
    //   299	306	938	java/lang/Exception
    //   309	327	938	java/lang/Exception
    //   327	417	938	java/lang/Exception
  }
  
  public void c()
  {
    this.h = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.operator.FTSMsgUpgrader
 * JD-Core Version:    0.7.0.1
 */