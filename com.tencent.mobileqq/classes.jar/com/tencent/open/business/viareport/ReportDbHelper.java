package com.tencent.open.business.viareport;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
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
        paramSQLiteDatabase.printStackTrace();
        LogUtility.e("BusinessReport", paramSQLiteDatabase.getLocalizedMessage());
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
  
  /* Error */
  public int a(String paramString, ArrayList<BatchReportInfo> paramArrayList)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 117	com/tencent/mobileqq/app/SQLiteDatabase:beginTransactionLog	()V
    //   5: aload_0
    //   6: invokevirtual 120	com/tencent/open/business/viareport/ReportDbHelper:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   9: astore 5
    //   11: iconst_0
    //   12: istore 4
    //   14: iconst_0
    //   15: istore_3
    //   16: aload 5
    //   18: ifnonnull +7 -> 25
    //   21: aload_0
    //   22: monitorexit
    //   23: iconst_0
    //   24: ireturn
    //   25: aload 5
    //   27: invokevirtual 123	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   30: aload_2
    //   31: invokevirtual 129	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   34: astore_2
    //   35: iload_3
    //   36: istore 4
    //   38: aload_2
    //   39: invokeinterface 135 1 0
    //   44: ifeq +30 -> 74
    //   47: iload_3
    //   48: istore 4
    //   50: aload_0
    //   51: aload 5
    //   53: aload_1
    //   54: aload_2
    //   55: invokeinterface 139 1 0
    //   60: checkcast 21	com/tencent/open/business/viareport/BatchReportInfo
    //   63: invokespecial 141	com/tencent/open/business/viareport/ReportDbHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lcom/tencent/open/business/viareport/BatchReportInfo;)J
    //   66: pop2
    //   67: iload_3
    //   68: iconst_1
    //   69: iadd
    //   70: istore_3
    //   71: goto -36 -> 35
    //   74: iload_3
    //   75: istore 4
    //   77: aload 5
    //   79: invokevirtual 144	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   82: aload 5
    //   84: invokevirtual 147	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   87: aload 5
    //   89: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   92: invokestatic 153	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   95: goto +32 -> 127
    //   98: astore_1
    //   99: goto +32 -> 131
    //   102: astore_1
    //   103: ldc 98
    //   105: ldc 155
    //   107: aload_1
    //   108: invokestatic 158	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   111: aload 5
    //   113: invokevirtual 147	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   116: aload 5
    //   118: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   121: iload 4
    //   123: istore_3
    //   124: goto -32 -> 92
    //   127: aload_0
    //   128: monitorexit
    //   129: iload_3
    //   130: ireturn
    //   131: aload 5
    //   133: invokevirtual 147	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   136: aload 5
    //   138: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   141: invokestatic 153	com/tencent/mobileqq/app/SQLiteDatabase:endTransactionLog	()V
    //   144: aload_1
    //   145: athrow
    //   146: astore_1
    //   147: aload_0
    //   148: monitorexit
    //   149: goto +5 -> 154
    //   152: aload_1
    //   153: athrow
    //   154: goto -2 -> 152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	ReportDbHelper
    //   0	157	1	paramString	String
    //   0	157	2	paramArrayList	ArrayList<BatchReportInfo>
    //   15	115	3	i	int
    //   12	110	4	j	int
    //   9	128	5	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   30	35	98	finally
    //   38	47	98	finally
    //   50	67	98	finally
    //   77	82	98	finally
    //   103	111	98	finally
    //   30	35	102	java/lang/Exception
    //   38	47	102	java/lang/Exception
    //   50	67	102	java/lang/Exception
    //   77	82	102	java/lang/Exception
    //   2	11	146	finally
    //   25	30	146	finally
    //   82	92	146	finally
    //   92	95	146	finally
    //   111	121	146	finally
    //   131	146	146	finally
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
    //   5: lstore_3
    //   6: aload_0
    //   7: invokevirtual 120	com/tencent/open/business/viareport/ReportDbHelper:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   10: astore 7
    //   12: lload_3
    //   13: lstore 5
    //   15: aload 7
    //   17: ifnull +50 -> 67
    //   20: aload_0
    //   21: aload 7
    //   23: aload_1
    //   24: aload_2
    //   25: invokespecial 141	com/tencent/open/business/viareport/ReportDbHelper:a	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Lcom/tencent/open/business/viareport/BatchReportInfo;)J
    //   28: lstore 5
    //   30: lload 5
    //   32: lstore_3
    //   33: aload 7
    //   35: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   38: lload_3
    //   39: lstore 5
    //   41: goto +26 -> 67
    //   44: astore_1
    //   45: goto +15 -> 60
    //   48: astore_1
    //   49: ldc 98
    //   51: ldc 169
    //   53: aload_1
    //   54: invokestatic 158	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   57: goto -24 -> 33
    //   60: aload 7
    //   62: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   65: aload_1
    //   66: athrow
    //   67: aload_0
    //   68: monitorexit
    //   69: lload 5
    //   71: lreturn
    //   72: astore_1
    //   73: aload_0
    //   74: monitorexit
    //   75: goto +5 -> 80
    //   78: aload_1
    //   79: athrow
    //   80: goto -2 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	this	ReportDbHelper
    //   0	83	1	paramString	String
    //   0	83	2	paramBatchReportInfo	BatchReportInfo
    //   5	34	3	l1	long
    //   13	57	5	l2	long
    //   10	51	7	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   20	30	44	finally
    //   49	57	44	finally
    //   20	30	48	java/lang/Exception
    //   6	12	72	finally
    //   33	38	72	finally
    //   60	67	72	finally
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
    //   0: aload_0
    //   1: monitorenter
    //   2: new 125	java/util/ArrayList
    //   5: dup
    //   6: invokespecial 177	java/util/ArrayList:<init>	()V
    //   9: astore 11
    //   11: aload_2
    //   12: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: istore_3
    //   16: aconst_null
    //   17: astore 9
    //   19: aconst_null
    //   20: astore 6
    //   22: aconst_null
    //   23: astore 5
    //   25: aconst_null
    //   26: astore 10
    //   28: iload_3
    //   29: ifeq +622 -> 651
    //   32: aconst_null
    //   33: astore 7
    //   35: goto +3 -> 38
    //   38: aload_2
    //   39: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   42: ifeq +9 -> 51
    //   45: aconst_null
    //   46: astore 8
    //   48: goto +13 -> 61
    //   51: iconst_1
    //   52: anewarray 185	java/lang/String
    //   55: dup
    //   56: iconst_0
    //   57: aload_2
    //   58: aastore
    //   59: astore 8
    //   61: aload_0
    //   62: invokevirtual 120	com/tencent/open/business/viareport/ReportDbHelper:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   65: astore 4
    //   67: aload 10
    //   69: astore_2
    //   70: aload 4
    //   72: astore 5
    //   74: aload 9
    //   76: astore 6
    //   78: aload 4
    //   80: aload_1
    //   81: aconst_null
    //   82: aload 7
    //   84: aload 8
    //   86: aconst_null
    //   87: aconst_null
    //   88: aconst_null
    //   89: invokevirtual 189	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   92: astore_1
    //   93: aload_1
    //   94: astore_2
    //   95: aload 4
    //   97: astore 5
    //   99: aload_1
    //   100: astore 6
    //   102: aload_1
    //   103: invokeinterface 194 1 0
    //   108: pop
    //   109: aload_1
    //   110: astore_2
    //   111: aload 4
    //   113: astore 5
    //   115: aload_1
    //   116: astore 6
    //   118: aload_1
    //   119: invokeinterface 197 1 0
    //   124: ifne +393 -> 517
    //   127: aload_1
    //   128: astore_2
    //   129: aload 4
    //   131: astore 5
    //   133: aload_1
    //   134: astore 6
    //   136: new 21	com/tencent/open/business/viareport/BatchReportInfo
    //   139: dup
    //   140: invokespecial 198	com/tencent/open/business/viareport/BatchReportInfo:<init>	()V
    //   143: astore 7
    //   145: aload_1
    //   146: astore_2
    //   147: aload 4
    //   149: astore 5
    //   151: aload_1
    //   152: astore 6
    //   154: aload 7
    //   156: aload_1
    //   157: aload_1
    //   158: ldc 19
    //   160: invokeinterface 202 2 0
    //   165: invokeinterface 206 2 0
    //   170: putfield 25	com/tencent/open/business/viareport/BatchReportInfo:c	Ljava/lang/String;
    //   173: aload_1
    //   174: astore_2
    //   175: aload 4
    //   177: astore 5
    //   179: aload_1
    //   180: astore 6
    //   182: aload 7
    //   184: aload_1
    //   185: aload_1
    //   186: ldc 31
    //   188: invokeinterface 202 2 0
    //   193: invokeinterface 206 2 0
    //   198: putfield 33	com/tencent/open/business/viareport/BatchReportInfo:a	Ljava/lang/String;
    //   201: aload_1
    //   202: astore_2
    //   203: aload 4
    //   205: astore 5
    //   207: aload_1
    //   208: astore 6
    //   210: aload 7
    //   212: aload_1
    //   213: aload_1
    //   214: ldc 35
    //   216: invokeinterface 202 2 0
    //   221: invokeinterface 206 2 0
    //   226: putfield 38	com/tencent/open/business/viareport/BatchReportInfo:e	Ljava/lang/String;
    //   229: aload_1
    //   230: astore_2
    //   231: aload 4
    //   233: astore 5
    //   235: aload_1
    //   236: astore 6
    //   238: aload 7
    //   240: aload_1
    //   241: aload_1
    //   242: ldc 40
    //   244: invokeinterface 202 2 0
    //   249: invokeinterface 206 2 0
    //   254: putfield 43	com/tencent/open/business/viareport/BatchReportInfo:d	Ljava/lang/String;
    //   257: aload_1
    //   258: astore_2
    //   259: aload 4
    //   261: astore 5
    //   263: aload_1
    //   264: astore 6
    //   266: aload 7
    //   268: aload_1
    //   269: aload_1
    //   270: ldc 45
    //   272: invokeinterface 202 2 0
    //   277: invokeinterface 206 2 0
    //   282: putfield 48	com/tencent/open/business/viareport/BatchReportInfo:b	Ljava/lang/String;
    //   285: aload_1
    //   286: astore_2
    //   287: aload 4
    //   289: astore 5
    //   291: aload_1
    //   292: astore 6
    //   294: aload 7
    //   296: aload_1
    //   297: aload_1
    //   298: ldc 50
    //   300: invokeinterface 202 2 0
    //   305: invokeinterface 206 2 0
    //   310: putfield 209	com/tencent/open/business/viareport/BatchReportInfo:f	Ljava/lang/String;
    //   313: aload_1
    //   314: astore_2
    //   315: aload 4
    //   317: astore 5
    //   319: aload_1
    //   320: astore 6
    //   322: aload 7
    //   324: aload_1
    //   325: aload_1
    //   326: ldc 55
    //   328: invokeinterface 202 2 0
    //   333: invokeinterface 206 2 0
    //   338: putfield 58	com/tencent/open/business/viareport/BatchReportInfo:g	Ljava/lang/String;
    //   341: aload_1
    //   342: astore_2
    //   343: aload 4
    //   345: astore 5
    //   347: aload_1
    //   348: astore 6
    //   350: aload 7
    //   352: aload_1
    //   353: aload_1
    //   354: ldc 60
    //   356: invokeinterface 202 2 0
    //   361: invokeinterface 206 2 0
    //   366: putfield 63	com/tencent/open/business/viareport/BatchReportInfo:h	Ljava/lang/String;
    //   369: aload_1
    //   370: astore_2
    //   371: aload 4
    //   373: astore 5
    //   375: aload_1
    //   376: astore 6
    //   378: aload 7
    //   380: aload_1
    //   381: aload_1
    //   382: ldc 65
    //   384: invokeinterface 202 2 0
    //   389: invokeinterface 206 2 0
    //   394: putfield 68	com/tencent/open/business/viareport/BatchReportInfo:i	Ljava/lang/String;
    //   397: aload_1
    //   398: astore_2
    //   399: aload 4
    //   401: astore 5
    //   403: aload_1
    //   404: astore 6
    //   406: aload 7
    //   408: aload_1
    //   409: aload_1
    //   410: ldc 70
    //   412: invokeinterface 202 2 0
    //   417: invokeinterface 206 2 0
    //   422: putfield 73	com/tencent/open/business/viareport/BatchReportInfo:j	Ljava/lang/String;
    //   425: aload_1
    //   426: astore_2
    //   427: aload 4
    //   429: astore 5
    //   431: aload_1
    //   432: astore 6
    //   434: aload 7
    //   436: aload_1
    //   437: aload_1
    //   438: ldc 75
    //   440: invokeinterface 202 2 0
    //   445: invokeinterface 206 2 0
    //   450: putfield 78	com/tencent/open/business/viareport/BatchReportInfo:k	Ljava/lang/String;
    //   453: aload_1
    //   454: astore_2
    //   455: aload 4
    //   457: astore 5
    //   459: aload_1
    //   460: astore 6
    //   462: aload 7
    //   464: aload_1
    //   465: aload_1
    //   466: ldc 80
    //   468: invokeinterface 202 2 0
    //   473: invokeinterface 206 2 0
    //   478: putfield 83	com/tencent/open/business/viareport/BatchReportInfo:l	Ljava/lang/String;
    //   481: aload_1
    //   482: astore_2
    //   483: aload 4
    //   485: astore 5
    //   487: aload_1
    //   488: astore 6
    //   490: aload 11
    //   492: aload 7
    //   494: invokevirtual 213	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   497: pop
    //   498: aload_1
    //   499: astore_2
    //   500: aload 4
    //   502: astore 5
    //   504: aload_1
    //   505: astore 6
    //   507: aload_1
    //   508: invokeinterface 216 1 0
    //   513: pop
    //   514: goto -405 -> 109
    //   517: aload_1
    //   518: ifnull +140 -> 658
    //   521: aload_1
    //   522: invokeinterface 217 1 0
    //   527: goto +131 -> 658
    //   530: aload_1
    //   531: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   534: goto +79 -> 613
    //   537: astore_1
    //   538: goto +80 -> 618
    //   541: astore 7
    //   543: aload 4
    //   545: astore_1
    //   546: goto +21 -> 567
    //   549: astore_1
    //   550: aconst_null
    //   551: astore 4
    //   553: aload 5
    //   555: astore_2
    //   556: aload 4
    //   558: astore 5
    //   560: goto +58 -> 618
    //   563: astore 7
    //   565: aconst_null
    //   566: astore_1
    //   567: aload 6
    //   569: astore_2
    //   570: aload_1
    //   571: astore 5
    //   573: aload 7
    //   575: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   578: aload 6
    //   580: astore_2
    //   581: aload_1
    //   582: astore 5
    //   584: ldc 98
    //   586: aload 7
    //   588: invokevirtual 219	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   591: invokestatic 105	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   594: aload 6
    //   596: ifnull +10 -> 606
    //   599: aload 6
    //   601: invokeinterface 217 1 0
    //   606: aload_1
    //   607: ifnull +6 -> 613
    //   610: goto -80 -> 530
    //   613: aload_0
    //   614: monitorexit
    //   615: aload 11
    //   617: areturn
    //   618: aload_2
    //   619: ifnull +9 -> 628
    //   622: aload_2
    //   623: invokeinterface 217 1 0
    //   628: aload 5
    //   630: ifnull +8 -> 638
    //   633: aload 5
    //   635: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   638: aload_1
    //   639: athrow
    //   640: astore_1
    //   641: aload_0
    //   642: monitorexit
    //   643: goto +5 -> 648
    //   646: aload_1
    //   647: athrow
    //   648: goto -2 -> 646
    //   651: ldc 221
    //   653: astore 7
    //   655: goto -617 -> 38
    //   658: aload 4
    //   660: ifnull -47 -> 613
    //   663: aload 4
    //   665: astore_1
    //   666: goto -136 -> 530
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	669	0	this	ReportDbHelper
    //   0	669	1	paramString1	String
    //   0	669	2	paramString2	String
    //   15	14	3	bool	boolean
    //   65	599	4	localSQLiteDatabase	SQLiteDatabase
    //   23	611	5	localObject1	Object
    //   20	580	6	localObject2	Object
    //   33	460	7	localObject3	Object
    //   541	1	7	localException1	Exception
    //   563	24	7	localException2	Exception
    //   653	1	7	str	String
    //   46	39	8	arrayOfString	String[]
    //   17	58	9	localObject4	Object
    //   26	42	10	localObject5	Object
    //   9	607	11	localArrayList	ArrayList
    // Exception table:
    //   from	to	target	type
    //   78	93	537	finally
    //   102	109	537	finally
    //   118	127	537	finally
    //   136	145	537	finally
    //   154	173	537	finally
    //   182	201	537	finally
    //   210	229	537	finally
    //   238	257	537	finally
    //   266	285	537	finally
    //   294	313	537	finally
    //   322	341	537	finally
    //   350	369	537	finally
    //   378	397	537	finally
    //   406	425	537	finally
    //   434	453	537	finally
    //   462	481	537	finally
    //   490	498	537	finally
    //   507	514	537	finally
    //   573	578	537	finally
    //   584	594	537	finally
    //   78	93	541	java/lang/Exception
    //   102	109	541	java/lang/Exception
    //   118	127	541	java/lang/Exception
    //   136	145	541	java/lang/Exception
    //   154	173	541	java/lang/Exception
    //   182	201	541	java/lang/Exception
    //   210	229	541	java/lang/Exception
    //   238	257	541	java/lang/Exception
    //   266	285	541	java/lang/Exception
    //   294	313	541	java/lang/Exception
    //   322	341	541	java/lang/Exception
    //   350	369	541	java/lang/Exception
    //   378	397	541	java/lang/Exception
    //   406	425	541	java/lang/Exception
    //   434	453	541	java/lang/Exception
    //   462	481	541	java/lang/Exception
    //   490	498	541	java/lang/Exception
    //   507	514	541	java/lang/Exception
    //   61	67	549	finally
    //   61	67	563	java/lang/Exception
    //   2	16	640	finally
    //   38	45	640	finally
    //   521	527	640	finally
    //   530	534	640	finally
    //   599	606	640	finally
    //   622	628	640	finally
    //   633	638	640	finally
    //   638	640	640	finally
  }
  
  /* Error */
  public int b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore 6
    //   5: aconst_null
    //   6: astore 4
    //   8: aload_0
    //   9: invokevirtual 120	com/tencent/open/business/viareport/ReportDbHelper:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   12: astore 5
    //   14: aload_2
    //   15: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: ifeq +26 -> 44
    //   21: aload 5
    //   23: aload_1
    //   24: aconst_null
    //   25: aconst_null
    //   26: invokevirtual 227	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   29: istore_3
    //   30: aload 5
    //   32: ifnull +8 -> 40
    //   35: aload 5
    //   37: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   40: aload_0
    //   41: monitorexit
    //   42: iload_3
    //   43: ireturn
    //   44: aload 5
    //   46: aload_1
    //   47: ldc 221
    //   49: iconst_1
    //   50: anewarray 185	java/lang/String
    //   53: dup
    //   54: iconst_0
    //   55: aload_2
    //   56: aastore
    //   57: invokevirtual 227	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   60: istore_3
    //   61: aload 5
    //   63: ifnull +8 -> 71
    //   66: aload 5
    //   68: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   71: aload_0
    //   72: monitorexit
    //   73: iload_3
    //   74: ireturn
    //   75: astore_1
    //   76: goto +53 -> 129
    //   79: astore_2
    //   80: aload 5
    //   82: astore_1
    //   83: goto +15 -> 98
    //   86: astore_1
    //   87: aload 4
    //   89: astore 5
    //   91: goto +38 -> 129
    //   94: astore_2
    //   95: aload 6
    //   97: astore_1
    //   98: aload_1
    //   99: astore 4
    //   101: aload_2
    //   102: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   105: aload_1
    //   106: astore 4
    //   108: ldc 98
    //   110: aload_2
    //   111: invokevirtual 219	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   114: invokestatic 105	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload_1
    //   118: ifnull +7 -> 125
    //   121: aload_1
    //   122: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   125: aload_0
    //   126: monitorexit
    //   127: iconst_m1
    //   128: ireturn
    //   129: aload 5
    //   131: ifnull +8 -> 139
    //   134: aload 5
    //   136: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   139: aload_1
    //   140: athrow
    //   141: astore_1
    //   142: aload_0
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	ReportDbHelper
    //   0	146	1	paramString1	String
    //   0	146	2	paramString2	String
    //   29	45	3	i	int
    //   6	101	4	str	String
    //   12	123	5	localObject1	Object
    //   3	93	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   14	30	75	finally
    //   44	61	75	finally
    //   14	30	79	java/lang/Exception
    //   44	61	79	java/lang/Exception
    //   8	14	86	finally
    //   101	105	86	finally
    //   108	117	86	finally
    //   8	14	94	java/lang/Exception
    //   35	40	141	finally
    //   66	71	141	finally
    //   121	125	141	finally
    //   134	139	141	finally
    //   139	141	141	finally
  }
  
  protected SQLiteDatabase b()
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = ReportSqliteHelper.a(CommonDataAdapter.a().b()).getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
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
  
  public int c(String paramString)
  {
    try
    {
      int i = c("table_new_data", paramString) + 0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new_table>>count=");
      localStringBuilder.append(i);
      LogUtility.b("Jie", localStringBuilder.toString());
      i += c("table_old_data", paramString);
      paramString = new StringBuilder();
      paramString.append("all_table>>>count=");
      paramString.append(i);
      LogUtility.b("Jie", paramString.toString());
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public int c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: istore 4
    //   8: aconst_null
    //   9: astore 10
    //   11: aconst_null
    //   12: astore 9
    //   14: aconst_null
    //   15: astore 5
    //   17: aconst_null
    //   18: astore 11
    //   20: iload 4
    //   22: ifeq +218 -> 240
    //   25: aconst_null
    //   26: astore 6
    //   28: goto +3 -> 31
    //   31: aload_2
    //   32: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +9 -> 44
    //   38: aconst_null
    //   39: astore 8
    //   41: goto +13 -> 54
    //   44: iconst_1
    //   45: anewarray 185	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: aload_2
    //   51: aastore
    //   52: astore 8
    //   54: aload_0
    //   55: invokevirtual 120	com/tencent/open/business/viareport/ReportDbHelper:b	()Landroid/database/sqlite/SQLiteDatabase;
    //   58: astore 7
    //   60: aload 11
    //   62: astore_2
    //   63: aload 10
    //   65: astore 5
    //   67: aload 7
    //   69: aload_1
    //   70: aconst_null
    //   71: aload 6
    //   73: aload 8
    //   75: aconst_null
    //   76: aconst_null
    //   77: aconst_null
    //   78: invokevirtual 189	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   81: astore_1
    //   82: aload_1
    //   83: astore_2
    //   84: aload_1
    //   85: astore 5
    //   87: aload_1
    //   88: invokeinterface 270 1 0
    //   93: istore_3
    //   94: aload_1
    //   95: ifnull +9 -> 104
    //   98: aload_1
    //   99: invokeinterface 217 1 0
    //   104: aload 7
    //   106: ifnull +8 -> 114
    //   109: aload 7
    //   111: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   114: aload_0
    //   115: monitorexit
    //   116: iload_3
    //   117: ireturn
    //   118: astore 6
    //   120: aload 7
    //   122: astore_1
    //   123: aload_2
    //   124: astore 5
    //   126: aload 6
    //   128: astore_2
    //   129: goto +84 -> 213
    //   132: astore 6
    //   134: aload 7
    //   136: astore_1
    //   137: aload 5
    //   139: astore_2
    //   140: aload 6
    //   142: astore 5
    //   144: goto +24 -> 168
    //   147: astore_2
    //   148: aconst_null
    //   149: astore 6
    //   151: aload 5
    //   153: astore_1
    //   154: aload 6
    //   156: astore 5
    //   158: goto +55 -> 213
    //   161: astore 5
    //   163: aconst_null
    //   164: astore_2
    //   165: aload 9
    //   167: astore_1
    //   168: aload 5
    //   170: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   173: ldc 98
    //   175: aload 5
    //   177: invokevirtual 219	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   180: invokestatic 105	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: aload_2
    //   184: ifnull +9 -> 193
    //   187: aload_2
    //   188: invokeinterface 217 1 0
    //   193: aload_1
    //   194: ifnull +7 -> 201
    //   197: aload_1
    //   198: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   201: aload_0
    //   202: monitorexit
    //   203: iconst_0
    //   204: ireturn
    //   205: astore 6
    //   207: aload_2
    //   208: astore 5
    //   210: aload 6
    //   212: astore_2
    //   213: aload 5
    //   215: ifnull +10 -> 225
    //   218: aload 5
    //   220: invokeinterface 217 1 0
    //   225: aload_1
    //   226: ifnull +7 -> 233
    //   229: aload_1
    //   230: invokevirtual 150	android/database/sqlite/SQLiteDatabase:close	()V
    //   233: aload_2
    //   234: athrow
    //   235: astore_1
    //   236: aload_0
    //   237: monitorexit
    //   238: aload_1
    //   239: athrow
    //   240: ldc 221
    //   242: astore 6
    //   244: goto -213 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	247	0	this	ReportDbHelper
    //   0	247	1	paramString1	String
    //   0	247	2	paramString2	String
    //   93	24	3	i	int
    //   6	15	4	bool	boolean
    //   15	142	5	localObject1	Object
    //   161	15	5	localException1	Exception
    //   208	11	5	str1	String
    //   26	46	6	str2	String
    //   118	9	6	localObject2	Object
    //   132	9	6	localException2	Exception
    //   149	6	6	localObject3	Object
    //   205	6	6	localObject4	Object
    //   242	1	6	str3	String
    //   58	77	7	localSQLiteDatabase	SQLiteDatabase
    //   39	35	8	arrayOfString	String[]
    //   12	154	9	localObject5	Object
    //   9	55	10	localObject6	Object
    //   18	43	11	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   67	82	118	finally
    //   87	94	118	finally
    //   67	82	132	java/lang/Exception
    //   87	94	132	java/lang/Exception
    //   54	60	147	finally
    //   54	60	161	java/lang/Exception
    //   168	183	205	finally
    //   2	8	235	finally
    //   31	38	235	finally
    //   98	104	235	finally
    //   109	114	235	finally
    //   187	193	235	finally
    //   197	201	235	finally
    //   218	225	235	finally
    //   229	233	235	finally
    //   233	235	235	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.business.viareport.ReportDbHelper
 * JD-Core Version:    0.7.0.1
 */