package com.tencent.open.business.viareport;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import java.util.ArrayList;

public class ReportDbHelper
{
  protected static ReportDbHelper a;
  
  private long a(SQLiteDatabase paramSQLiteDatabase, String paramString, BatchReportInfo paramBatchReportInfo)
  {
    try
    {
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("actiontype", paramBatchReportInfo.c);
      localContentValues.put("appid", paramBatchReportInfo.a);
      localContentValues.put("qua", paramBatchReportInfo.e);
      localContentValues.put("uin", paramBatchReportInfo.d);
      localContentValues.put("via", paramBatchReportInfo.b);
      localContentValues.put("network", paramBatchReportInfo.a());
      localContentValues.put("timestamp", paramBatchReportInfo.g);
      localContentValues.put("expand1", paramBatchReportInfo.h);
      localContentValues.put("expand2", paramBatchReportInfo.i);
      localContentValues.put("expand3", paramBatchReportInfo.j);
      localContentValues.put("expand4", paramBatchReportInfo.k);
      localContentValues.put("expand5", paramBatchReportInfo.l);
      long l1 = -1L;
      try
      {
        long l2 = paramSQLiteDatabase.insertOrThrow(paramString, "_id", localContentValues);
        l1 = l2;
      }
      catch (SQLException paramSQLiteDatabase)
      {
        for (;;)
        {
          paramSQLiteDatabase.printStackTrace();
          LogUtility.e("BusinessReport", paramSQLiteDatabase.getLocalizedMessage());
        }
      }
      return l1;
    }
    finally {}
  }
  
  public static ReportDbHelper a()
  {
    try
    {
      if (a == null) {
        a = new ReportDbHelper();
      }
      ReportDbHelper localReportDbHelper = a;
      return localReportDbHelper;
    }
    finally {}
  }
  
  public int a(String paramString)
  {
    try
    {
      int i = 0 + b("table_new_data", paramString);
      LogUtility.b("Jie", "new_table>>count=" + i);
      i += b("table_old_data", paramString);
      LogUtility.b("Jie", "all_table>>>count=" + i);
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        SQLiteDatabase localSQLiteDatabase = a();
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        if (TextUtils.isEmpty(paramString2))
        {
          localObject1 = localSQLiteDatabase;
          localObject2 = localSQLiteDatabase;
          j = localSQLiteDatabase.delete(paramString1, null, null);
          i = j;
          if (localSQLiteDatabase == null) {}
        }
        try
        {
          localSQLiteDatabase.close();
          i = j;
          return i;
        }
        finally {}
        localObject1 = localSQLiteDatabase;
        localObject2 = localSQLiteDatabase;
        int j = localSQLiteDatabase.delete(paramString1, "uin=?", new String[] { paramString2 });
        int i = j;
        if (localSQLiteDatabase != null)
        {
          localSQLiteDatabase.close();
          i = j;
          continue;
          i = -1;
        }
      }
      catch (Exception paramString1)
      {
        localObject2 = localObject1;
        paramString1.printStackTrace();
        localObject2 = localObject1;
        LogUtility.e("BusinessReport", paramString1.getLocalizedMessage());
      }
      finally
      {
        if (localObject2 != null) {
          localObject2.close();
        }
      }
    }
  }
  
  /* Error */
  public int a(String paramString, ArrayList<BatchReportInfo> paramArrayList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: invokestatic 168	com/tencent/mobileqq/app/SQLiteDatabase:beginTransactionLog	()V
    //   10: aload_0
    //   11: invokevirtual 143	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   14: astore 5
    //   16: aload 5
    //   18: ifnonnull +7 -> 25
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_3
    //   24: ireturn
    //   25: aload 5
    //   27: invokevirtual 171	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   30: aload_2
    //   31: invokevirtual 177	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   34: astore_2
    //   35: iconst_0
    //   36: istore_3
    //   37: aload_2
    //   38: invokeinterface 183 1 0
    //   43: ifeq +27 -> 70
    //   46: aload_0
    //   47: aload 5
    //   49: aload_1
    //   50: aload_2
    //   51: invokeinterface 187 1 0
    //   56: checkcast 21	com/tencent/open/business/viareport/BatchReportInfo
    //   59: invokespecial 189	com/tencent/open/business/viareport/ReportDbHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lcom/tencent/open/business/viareport/BatchReportInfo;)J
    //   62: pop2
    //   63: iload_3
    //   64: iconst_1
    //   65: iadd
    //   66: istore_3
    //   67: goto -30 -> 37
    //   70: aload 5
    //   72: invokevirtual 192	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   75: aload 5
    //   77: invokevirtual 195	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   80: aload 5
    //   82: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   85: invokestatic 198	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   88: goto -67 -> 21
    //   91: astore_1
    //   92: iload 4
    //   94: istore_3
    //   95: ldc 98
    //   97: ldc 200
    //   99: aload_1
    //   100: invokestatic 203	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload 5
    //   105: invokevirtual 195	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   108: aload 5
    //   110: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   113: invokestatic 198	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   116: goto -95 -> 21
    //   119: astore_1
    //   120: aload_0
    //   121: monitorexit
    //   122: aload_1
    //   123: athrow
    //   124: astore_1
    //   125: aload 5
    //   127: invokevirtual 195	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   130: aload 5
    //   132: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   135: invokestatic 198	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   138: aload_1
    //   139: athrow
    //   140: astore_1
    //   141: goto -46 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	ReportDbHelper
    //   0	144	1	paramString	String
    //   0	144	2	paramArrayList	ArrayList<BatchReportInfo>
    //   4	91	3	i	int
    //   1	92	4	j	int
    //   14	117	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   30	35	91	java/lang/Exception
    //   7	16	119	finally
    //   25	30	119	finally
    //   75	88	119	finally
    //   103	116	119	finally
    //   125	140	119	finally
    //   30	35	124	finally
    //   37	63	124	finally
    //   70	75	124	finally
    //   95	103	124	finally
    //   37	63	140	java/lang/Exception
    //   70	75	140	java/lang/Exception
  }
  
  public int a(ArrayList<BatchReportInfo> paramArrayList)
  {
    try
    {
      int i = a("table_old_data", paramArrayList);
      return i;
    }
    finally
    {
      paramArrayList = finally;
      throw paramArrayList;
    }
  }
  
  /* Error */
  public long a(String paramString, BatchReportInfo paramBatchReportInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc2_w 84
    //   5: lstore 5
    //   7: aload_0
    //   8: invokevirtual 143	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore 7
    //   13: lload 5
    //   15: lstore_3
    //   16: aload 7
    //   18: ifnull +17 -> 35
    //   21: aload_0
    //   22: aload 7
    //   24: aload_1
    //   25: aload_2
    //   26: invokespecial 189	com/tencent/open/business/viareport/ReportDbHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lcom/tencent/open/business/viareport/BatchReportInfo;)J
    //   29: lstore_3
    //   30: aload 7
    //   32: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   35: aload_0
    //   36: monitorexit
    //   37: lload_3
    //   38: lreturn
    //   39: astore_1
    //   40: ldc 98
    //   42: ldc 212
    //   44: aload_1
    //   45: invokestatic 203	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   48: aload 7
    //   50: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   53: lload 5
    //   55: lstore_3
    //   56: goto -21 -> 35
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: astore_1
    //   65: aload 7
    //   67: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	ReportDbHelper
    //   0	72	1	paramString	String
    //   0	72	2	paramBatchReportInfo	BatchReportInfo
    //   15	41	3	l1	long
    //   5	49	5	l2	long
    //   11	55	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   21	30	39	java/lang/Exception
    //   7	13	59	finally
    //   30	35	59	finally
    //   48	53	59	finally
    //   65	72	59	finally
    //   21	30	64	finally
    //   40	48	64	finally
  }
  
  protected SQLiteDatabase a()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = ReportSqliteHelper.a(CommonDataAdapter.a().a()).getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public ArrayList<BatchReportInfo> a(String paramString)
  {
    try
    {
      paramString = a("table_new_data", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public ArrayList<BatchReportInfo> a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 10
    //   12: aload_0
    //   13: monitorenter
    //   14: new 173	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 234	java/util/ArrayList:<init>	()V
    //   21: astore 11
    //   23: aload_2
    //   24: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   27: ifeq +444 -> 471
    //   30: aconst_null
    //   31: astore 6
    //   33: aload_2
    //   34: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   37: istore_3
    //   38: iload_3
    //   39: ifeq +439 -> 478
    //   42: aconst_null
    //   43: astore 7
    //   45: aload_0
    //   46: invokevirtual 143	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   49: astore 5
    //   51: aload 10
    //   53: astore 4
    //   55: aload 9
    //   57: astore_2
    //   58: aload 5
    //   60: aload_1
    //   61: aconst_null
    //   62: aload 6
    //   64: aload 7
    //   66: aconst_null
    //   67: aconst_null
    //   68: aconst_null
    //   69: invokevirtual 238	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore_1
    //   73: aload_1
    //   74: astore 4
    //   76: aload_1
    //   77: astore_2
    //   78: aload_1
    //   79: invokeinterface 243 1 0
    //   84: pop
    //   85: aload_1
    //   86: astore 4
    //   88: aload_1
    //   89: astore_2
    //   90: aload_1
    //   91: invokeinterface 246 1 0
    //   96: ifne +401 -> 497
    //   99: aload_1
    //   100: astore 4
    //   102: aload_1
    //   103: astore_2
    //   104: new 21	com/tencent/open/business/viareport/BatchReportInfo
    //   107: dup
    //   108: invokespecial 247	com/tencent/open/business/viareport/BatchReportInfo:<init>	()V
    //   111: astore 6
    //   113: aload_1
    //   114: astore 4
    //   116: aload_1
    //   117: astore_2
    //   118: aload 6
    //   120: aload_1
    //   121: aload_1
    //   122: ldc 19
    //   124: invokeinterface 250 2 0
    //   129: invokeinterface 254 2 0
    //   134: putfield 25	com/tencent/open/business/viareport/BatchReportInfo:c	Ljava/lang/String;
    //   137: aload_1
    //   138: astore 4
    //   140: aload_1
    //   141: astore_2
    //   142: aload 6
    //   144: aload_1
    //   145: aload_1
    //   146: ldc 31
    //   148: invokeinterface 250 2 0
    //   153: invokeinterface 254 2 0
    //   158: putfield 33	com/tencent/open/business/viareport/BatchReportInfo:a	Ljava/lang/String;
    //   161: aload_1
    //   162: astore 4
    //   164: aload_1
    //   165: astore_2
    //   166: aload 6
    //   168: aload_1
    //   169: aload_1
    //   170: ldc 35
    //   172: invokeinterface 250 2 0
    //   177: invokeinterface 254 2 0
    //   182: putfield 38	com/tencent/open/business/viareport/BatchReportInfo:e	Ljava/lang/String;
    //   185: aload_1
    //   186: astore 4
    //   188: aload_1
    //   189: astore_2
    //   190: aload 6
    //   192: aload_1
    //   193: aload_1
    //   194: ldc 40
    //   196: invokeinterface 250 2 0
    //   201: invokeinterface 254 2 0
    //   206: putfield 43	com/tencent/open/business/viareport/BatchReportInfo:d	Ljava/lang/String;
    //   209: aload_1
    //   210: astore 4
    //   212: aload_1
    //   213: astore_2
    //   214: aload 6
    //   216: aload_1
    //   217: aload_1
    //   218: ldc 45
    //   220: invokeinterface 250 2 0
    //   225: invokeinterface 254 2 0
    //   230: putfield 48	com/tencent/open/business/viareport/BatchReportInfo:b	Ljava/lang/String;
    //   233: aload_1
    //   234: astore 4
    //   236: aload_1
    //   237: astore_2
    //   238: aload 6
    //   240: aload_1
    //   241: aload_1
    //   242: ldc 50
    //   244: invokeinterface 250 2 0
    //   249: invokeinterface 254 2 0
    //   254: putfield 257	com/tencent/open/business/viareport/BatchReportInfo:f	Ljava/lang/String;
    //   257: aload_1
    //   258: astore 4
    //   260: aload_1
    //   261: astore_2
    //   262: aload 6
    //   264: aload_1
    //   265: aload_1
    //   266: ldc 55
    //   268: invokeinterface 250 2 0
    //   273: invokeinterface 254 2 0
    //   278: putfield 58	com/tencent/open/business/viareport/BatchReportInfo:g	Ljava/lang/String;
    //   281: aload_1
    //   282: astore 4
    //   284: aload_1
    //   285: astore_2
    //   286: aload 6
    //   288: aload_1
    //   289: aload_1
    //   290: ldc 60
    //   292: invokeinterface 250 2 0
    //   297: invokeinterface 254 2 0
    //   302: putfield 63	com/tencent/open/business/viareport/BatchReportInfo:h	Ljava/lang/String;
    //   305: aload_1
    //   306: astore 4
    //   308: aload_1
    //   309: astore_2
    //   310: aload 6
    //   312: aload_1
    //   313: aload_1
    //   314: ldc 65
    //   316: invokeinterface 250 2 0
    //   321: invokeinterface 254 2 0
    //   326: putfield 68	com/tencent/open/business/viareport/BatchReportInfo:i	Ljava/lang/String;
    //   329: aload_1
    //   330: astore 4
    //   332: aload_1
    //   333: astore_2
    //   334: aload 6
    //   336: aload_1
    //   337: aload_1
    //   338: ldc 70
    //   340: invokeinterface 250 2 0
    //   345: invokeinterface 254 2 0
    //   350: putfield 73	com/tencent/open/business/viareport/BatchReportInfo:j	Ljava/lang/String;
    //   353: aload_1
    //   354: astore 4
    //   356: aload_1
    //   357: astore_2
    //   358: aload 6
    //   360: aload_1
    //   361: aload_1
    //   362: ldc 75
    //   364: invokeinterface 250 2 0
    //   369: invokeinterface 254 2 0
    //   374: putfield 78	com/tencent/open/business/viareport/BatchReportInfo:k	Ljava/lang/String;
    //   377: aload_1
    //   378: astore 4
    //   380: aload_1
    //   381: astore_2
    //   382: aload 6
    //   384: aload_1
    //   385: aload_1
    //   386: ldc 80
    //   388: invokeinterface 250 2 0
    //   393: invokeinterface 254 2 0
    //   398: putfield 83	com/tencent/open/business/viareport/BatchReportInfo:l	Ljava/lang/String;
    //   401: aload_1
    //   402: astore 4
    //   404: aload_1
    //   405: astore_2
    //   406: aload 11
    //   408: aload 6
    //   410: invokevirtual 261	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   413: pop
    //   414: aload_1
    //   415: astore 4
    //   417: aload_1
    //   418: astore_2
    //   419: aload_1
    //   420: invokeinterface 264 1 0
    //   425: pop
    //   426: goto -341 -> 85
    //   429: astore_1
    //   430: aload 5
    //   432: astore_2
    //   433: aload_1
    //   434: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   437: ldc 98
    //   439: aload_1
    //   440: invokevirtual 162	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   443: invokestatic 105	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   446: aload 4
    //   448: ifnull +10 -> 458
    //   451: aload 4
    //   453: invokeinterface 265 1 0
    //   458: aload_2
    //   459: ifnull +7 -> 466
    //   462: aload_2
    //   463: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   466: aload_0
    //   467: monitorexit
    //   468: aload 11
    //   470: areturn
    //   471: ldc 158
    //   473: astore 6
    //   475: goto -442 -> 33
    //   478: iconst_1
    //   479: anewarray 160	java/lang/String
    //   482: astore 7
    //   484: aload 7
    //   486: iconst_0
    //   487: aload_2
    //   488: aastore
    //   489: goto -444 -> 45
    //   492: astore_1
    //   493: aload_0
    //   494: monitorexit
    //   495: aload_1
    //   496: athrow
    //   497: aload_1
    //   498: ifnull +9 -> 507
    //   501: aload_1
    //   502: invokeinterface 265 1 0
    //   507: aload 5
    //   509: ifnull -43 -> 466
    //   512: aload 5
    //   514: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   517: goto -51 -> 466
    //   520: aload_2
    //   521: ifnull +9 -> 530
    //   524: aload_2
    //   525: invokeinterface 265 1 0
    //   530: aload 5
    //   532: ifnull +8 -> 540
    //   535: aload 5
    //   537: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   540: aload_1
    //   541: athrow
    //   542: astore_1
    //   543: goto -23 -> 520
    //   546: astore_1
    //   547: aload_2
    //   548: astore 5
    //   550: aload 4
    //   552: astore_2
    //   553: goto -33 -> 520
    //   556: astore_1
    //   557: aconst_null
    //   558: astore_2
    //   559: goto -126 -> 433
    //   562: astore_1
    //   563: aconst_null
    //   564: astore 5
    //   566: aload 8
    //   568: astore_2
    //   569: goto -49 -> 520
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	this	ReportDbHelper
    //   0	572	1	paramString1	String
    //   0	572	2	paramString2	String
    //   37	2	3	bool	boolean
    //   1	550	4	localObject1	Object
    //   49	516	5	localObject2	Object
    //   31	443	6	localObject3	Object
    //   43	442	7	arrayOfString	String[]
    //   4	563	8	localObject4	Object
    //   7	49	9	localObject5	Object
    //   10	42	10	localObject6	Object
    //   21	448	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   58	73	429	java/lang/Exception
    //   78	85	429	java/lang/Exception
    //   90	99	429	java/lang/Exception
    //   104	113	429	java/lang/Exception
    //   118	137	429	java/lang/Exception
    //   142	161	429	java/lang/Exception
    //   166	185	429	java/lang/Exception
    //   190	209	429	java/lang/Exception
    //   214	233	429	java/lang/Exception
    //   238	257	429	java/lang/Exception
    //   262	281	429	java/lang/Exception
    //   286	305	429	java/lang/Exception
    //   310	329	429	java/lang/Exception
    //   334	353	429	java/lang/Exception
    //   358	377	429	java/lang/Exception
    //   382	401	429	java/lang/Exception
    //   406	414	429	java/lang/Exception
    //   419	426	429	java/lang/Exception
    //   14	30	492	finally
    //   33	38	492	finally
    //   451	458	492	finally
    //   462	466	492	finally
    //   478	484	492	finally
    //   501	507	492	finally
    //   512	517	492	finally
    //   524	530	492	finally
    //   535	540	492	finally
    //   540	542	492	finally
    //   58	73	542	finally
    //   78	85	542	finally
    //   90	99	542	finally
    //   104	113	542	finally
    //   118	137	542	finally
    //   142	161	542	finally
    //   166	185	542	finally
    //   190	209	542	finally
    //   214	233	542	finally
    //   238	257	542	finally
    //   262	281	542	finally
    //   286	305	542	finally
    //   310	329	542	finally
    //   334	353	542	finally
    //   358	377	542	finally
    //   382	401	542	finally
    //   406	414	542	finally
    //   419	426	542	finally
    //   433	446	546	finally
    //   45	51	556	java/lang/Exception
    //   45	51	562	finally
  }
  
  /* Error */
  public int b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 9
    //   12: aload_0
    //   13: monitorenter
    //   14: aload_2
    //   15: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +84 -> 102
    //   21: aconst_null
    //   22: astore 6
    //   24: aload_2
    //   25: invokestatic 149	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   28: istore 4
    //   30: iload 4
    //   32: ifeq +77 -> 109
    //   35: aconst_null
    //   36: astore 8
    //   38: aload_0
    //   39: invokevirtual 143	com/tencent/open/business/viareport/ReportDbHelper:a	()Landroid/database/sqlite/SQLiteDatabase;
    //   42: astore 7
    //   44: aload 11
    //   46: astore_2
    //   47: aload 10
    //   49: astore 5
    //   51: aload 7
    //   53: aload_1
    //   54: aconst_null
    //   55: aload 6
    //   57: aload 8
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 238	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore_1
    //   66: aload_1
    //   67: astore_2
    //   68: aload_1
    //   69: astore 5
    //   71: aload_1
    //   72: invokeinterface 270 1 0
    //   77: istore_3
    //   78: aload_1
    //   79: ifnull +9 -> 88
    //   82: aload_1
    //   83: invokeinterface 265 1 0
    //   88: aload 7
    //   90: ifnull +8 -> 98
    //   93: aload 7
    //   95: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   98: aload_0
    //   99: monitorexit
    //   100: iload_3
    //   101: ireturn
    //   102: ldc 158
    //   104: astore 6
    //   106: goto -82 -> 24
    //   109: iconst_1
    //   110: anewarray 160	java/lang/String
    //   113: astore 8
    //   115: aload 8
    //   117: iconst_0
    //   118: aload_2
    //   119: aastore
    //   120: goto -82 -> 38
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aconst_null
    //   130: astore_2
    //   131: aload 9
    //   133: astore 5
    //   135: aload_1
    //   136: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   139: ldc 98
    //   141: aload_1
    //   142: invokevirtual 162	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   145: invokestatic 105	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 5
    //   150: ifnull +10 -> 160
    //   153: aload 5
    //   155: invokeinterface 265 1 0
    //   160: aload_2
    //   161: ifnull +57 -> 218
    //   164: aload_2
    //   165: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   168: goto +50 -> 218
    //   171: aload_2
    //   172: ifnull +9 -> 181
    //   175: aload_2
    //   176: invokeinterface 265 1 0
    //   181: aload 6
    //   183: ifnull +8 -> 191
    //   186: aload 6
    //   188: invokevirtual 156	android/database/sqlite/SQLiteDatabase:close	()V
    //   191: aload_1
    //   192: athrow
    //   193: astore_1
    //   194: aload 7
    //   196: astore 6
    //   198: goto -27 -> 171
    //   201: astore_1
    //   202: aload_2
    //   203: astore 6
    //   205: aload 5
    //   207: astore_2
    //   208: goto -37 -> 171
    //   211: astore_1
    //   212: aload 7
    //   214: astore_2
    //   215: goto -80 -> 135
    //   218: iconst_0
    //   219: istore_3
    //   220: goto -122 -> 98
    //   223: astore_1
    //   224: aconst_null
    //   225: astore 6
    //   227: aload 5
    //   229: astore_2
    //   230: goto -59 -> 171
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	ReportDbHelper
    //   0	233	1	paramString1	String
    //   0	233	2	paramString2	String
    //   77	143	3	i	int
    //   28	3	4	bool	boolean
    //   1	227	5	localObject1	Object
    //   22	204	6	localObject2	Object
    //   42	171	7	localSQLiteDatabase	SQLiteDatabase
    //   36	80	8	arrayOfString	String[]
    //   10	122	9	localObject3	Object
    //   7	41	10	localObject4	Object
    //   4	41	11	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   14	21	123	finally
    //   24	30	123	finally
    //   82	88	123	finally
    //   93	98	123	finally
    //   109	115	123	finally
    //   153	160	123	finally
    //   164	168	123	finally
    //   175	181	123	finally
    //   186	191	123	finally
    //   191	193	123	finally
    //   38	44	128	java/lang/Exception
    //   51	66	193	finally
    //   71	78	193	finally
    //   135	148	201	finally
    //   51	66	211	java/lang/Exception
    //   71	78	211	java/lang/Exception
    //   38	44	223	finally
  }
  
  public ArrayList<BatchReportInfo> b(String paramString)
  {
    try
    {
      paramString = a("table_old_data", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportDbHelper
 * JD-Core Version:    0.7.0.1
 */