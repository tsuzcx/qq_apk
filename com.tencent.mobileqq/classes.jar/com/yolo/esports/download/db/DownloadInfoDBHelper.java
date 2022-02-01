package com.yolo.esports.download.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.timi.game.utils.Logger;

class DownloadInfoDBHelper
  extends BaseSQLHelper
{
  private final Object a = new Object();
  
  public DownloadInfoDBHelper(Context paramContext)
  {
    super(paramContext, "timi_game_download_db", null, 1);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE download_table (download_ticket TEXT PRIMARY KEY,download_url TEXT,file_size INTEGER,file_md5 TEXT,file_name TEXT,file_abs_path TEXT,file_root_dir TEXT,create_time INTEGER,cost_time INTEGER,received_length INTEGER,total_length INTEGER,error_code INTEGER,error_msg TEXT,priority INTEGER,scene TEXT,pause_on_mobile INTEGER,download_state INTEGER,extra_info TEXT,unique_id TEXT,file_type TEXT);");
      Logger.a("DownloadInfoDBHelper_", "createTable succ");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      Logger.a("DownloadInfoDBHelper_", "createTable failed", paramSQLiteDatabase);
    }
  }
  
  /* Error */
  public java.util.List<com.yolo.esports.download.common.DownloadInfo> a()
  {
    // Byte code:
    //   0: ldc 34
    //   2: ldc 49
    //   4: invokestatic 52	com/tencent/timi/game/utils/Logger:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: new 54	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 55	java/util/ArrayList:<init>	()V
    //   14: astore 8
    //   16: aload_0
    //   17: getfield 20	com/yolo/esports/download/db/DownloadInfoDBHelper:a	Ljava/lang/Object;
    //   20: astore 7
    //   22: aload 7
    //   24: monitorenter
    //   25: aconst_null
    //   26: astore 6
    //   28: aconst_null
    //   29: astore 5
    //   31: aconst_null
    //   32: astore_2
    //   33: aconst_null
    //   34: astore 4
    //   36: aload_0
    //   37: invokevirtual 59	com/yolo/esports/download/db/DownloadInfoDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   40: astore_3
    //   41: aload 4
    //   43: astore_2
    //   44: aload_3
    //   45: astore 4
    //   47: aload 6
    //   49: astore 5
    //   51: aload_3
    //   52: ldc 61
    //   54: getstatic 66	com/yolo/esports/download/db/DownloadInfoDBCommon:a	[Ljava/lang/String;
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 70	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 6
    //   67: aload 6
    //   69: astore_2
    //   70: aload_3
    //   71: astore 4
    //   73: aload 6
    //   75: astore 5
    //   77: aload 6
    //   79: invokeinterface 76 1 0
    //   84: ifle +259 -> 343
    //   87: aload 6
    //   89: astore_2
    //   90: aload_3
    //   91: astore 4
    //   93: aload 6
    //   95: astore 5
    //   97: aload 6
    //   99: invokeinterface 80 1 0
    //   104: pop
    //   105: aload 6
    //   107: astore_2
    //   108: aload_3
    //   109: astore 4
    //   111: aload 6
    //   113: astore 5
    //   115: aload 6
    //   117: aload 6
    //   119: ldc 82
    //   121: invokestatic 85	com/yolo/esports/download/db/DownloadInfoDBCommon:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   124: invokeinterface 89 2 0
    //   129: astore 9
    //   131: aload 6
    //   133: astore_2
    //   134: aload_3
    //   135: astore 4
    //   137: aload 6
    //   139: astore 5
    //   141: new 91	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   148: astore 10
    //   150: aload 6
    //   152: astore_2
    //   153: aload_3
    //   154: astore 4
    //   156: aload 6
    //   158: astore 5
    //   160: aload 10
    //   162: ldc 94
    //   164: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload 6
    //   170: astore_2
    //   171: aload_3
    //   172: astore 4
    //   174: aload 6
    //   176: astore 5
    //   178: aload 10
    //   180: aload 9
    //   182: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 6
    //   188: astore_2
    //   189: aload_3
    //   190: astore 4
    //   192: aload 6
    //   194: astore 5
    //   196: ldc 34
    //   198: aload 10
    //   200: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 52	com/tencent/timi/game/utils/Logger:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload 6
    //   208: astore_2
    //   209: aload_3
    //   210: astore 4
    //   212: aload 6
    //   214: astore 5
    //   216: aload 6
    //   218: invokestatic 105	com/yolo/esports/download/db/DownloadInfoDBCommon:a	(Landroid/database/Cursor;)Lcom/yolo/esports/download/common/DownloadInfo;
    //   221: astore 9
    //   223: aload 6
    //   225: astore_2
    //   226: aload_3
    //   227: astore 4
    //   229: aload 6
    //   231: astore 5
    //   233: new 91	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   240: astore 10
    //   242: aload 6
    //   244: astore_2
    //   245: aload_3
    //   246: astore 4
    //   248: aload 6
    //   250: astore 5
    //   252: aload 10
    //   254: ldc 107
    //   256: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 6
    //   262: astore_2
    //   263: aload_3
    //   264: astore 4
    //   266: aload 6
    //   268: astore 5
    //   270: aload 10
    //   272: aload 9
    //   274: invokevirtual 110	com/yolo/esports/download/common/DownloadInfo:toString	()Ljava/lang/String;
    //   277: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 6
    //   283: astore_2
    //   284: aload_3
    //   285: astore 4
    //   287: aload 6
    //   289: astore 5
    //   291: ldc 34
    //   293: aload 10
    //   295: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   298: invokestatic 52	com/tencent/timi/game/utils/Logger:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   301: aload 6
    //   303: astore_2
    //   304: aload_3
    //   305: astore 4
    //   307: aload 6
    //   309: astore 5
    //   311: aload 8
    //   313: aload 9
    //   315: invokeinterface 116 2 0
    //   320: pop
    //   321: aload 6
    //   323: astore_2
    //   324: aload_3
    //   325: astore 4
    //   327: aload 6
    //   329: astore 5
    //   331: aload 6
    //   333: invokeinterface 119 1 0
    //   338: istore_1
    //   339: iload_1
    //   340: ifne -235 -> 105
    //   343: aload 6
    //   345: ifnull +112 -> 457
    //   348: aload 6
    //   350: invokeinterface 122 1 0
    //   355: goto +102 -> 457
    //   358: aload_3
    //   359: invokevirtual 123	android/database/sqlite/SQLiteDatabase:close	()V
    //   362: goto +53 -> 415
    //   365: astore_3
    //   366: goto +55 -> 421
    //   369: astore 6
    //   371: goto +14 -> 385
    //   374: astore_3
    //   375: aconst_null
    //   376: astore 4
    //   378: goto +43 -> 421
    //   381: astore 6
    //   383: aconst_null
    //   384: astore_3
    //   385: aload 5
    //   387: astore_2
    //   388: aload_3
    //   389: astore 4
    //   391: ldc 34
    //   393: ldc 125
    //   395: aload 6
    //   397: invokestatic 46	com/tencent/timi/game/utils/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   400: aload 5
    //   402: ifnull +62 -> 464
    //   405: aload 5
    //   407: invokeinterface 122 1 0
    //   412: goto +52 -> 464
    //   415: aload 7
    //   417: monitorexit
    //   418: aload 8
    //   420: areturn
    //   421: aload_2
    //   422: ifnull +12 -> 434
    //   425: aload_2
    //   426: invokeinterface 122 1 0
    //   431: goto +3 -> 434
    //   434: aload 4
    //   436: ifnull +8 -> 444
    //   439: aload 4
    //   441: invokevirtual 123	android/database/sqlite/SQLiteDatabase:close	()V
    //   444: aload_3
    //   445: athrow
    //   446: aload 7
    //   448: monitorexit
    //   449: goto +5 -> 454
    //   452: aload_2
    //   453: athrow
    //   454: goto -2 -> 452
    //   457: aload_3
    //   458: ifnull -43 -> 415
    //   461: goto -103 -> 358
    //   464: aload_3
    //   465: ifnull -50 -> 415
    //   468: goto -110 -> 358
    //   471: astore_2
    //   472: goto -26 -> 446
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	this	DownloadInfoDBHelper
    //   338	2	1	bool	boolean
    //   32	421	2	localObject1	Object
    //   471	1	2	localObject2	Object
    //   40	319	3	localSQLiteDatabase	SQLiteDatabase
    //   365	1	3	localObject3	Object
    //   374	1	3	localObject4	Object
    //   384	81	3	localObject5	Object
    //   34	406	4	localObject6	Object
    //   29	377	5	localCursor1	android.database.Cursor
    //   26	323	6	localCursor2	android.database.Cursor
    //   369	1	6	localException1	Exception
    //   381	15	6	localException2	Exception
    //   20	427	7	localObject7	Object
    //   14	405	8	localArrayList	java.util.ArrayList
    //   129	185	9	localObject8	Object
    //   148	146	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   51	67	365	finally
    //   77	87	365	finally
    //   97	105	365	finally
    //   115	131	365	finally
    //   141	150	365	finally
    //   160	168	365	finally
    //   178	186	365	finally
    //   196	206	365	finally
    //   216	223	365	finally
    //   233	242	365	finally
    //   252	260	365	finally
    //   270	281	365	finally
    //   291	301	365	finally
    //   311	321	365	finally
    //   331	339	365	finally
    //   391	400	365	finally
    //   51	67	369	java/lang/Exception
    //   77	87	369	java/lang/Exception
    //   97	105	369	java/lang/Exception
    //   115	131	369	java/lang/Exception
    //   141	150	369	java/lang/Exception
    //   160	168	369	java/lang/Exception
    //   178	186	369	java/lang/Exception
    //   196	206	369	java/lang/Exception
    //   216	223	369	java/lang/Exception
    //   233	242	369	java/lang/Exception
    //   252	260	369	java/lang/Exception
    //   270	281	369	java/lang/Exception
    //   291	301	369	java/lang/Exception
    //   311	321	369	java/lang/Exception
    //   331	339	369	java/lang/Exception
    //   36	41	374	finally
    //   36	41	381	java/lang/Exception
    //   348	355	471	finally
    //   358	362	471	finally
    //   405	412	471	finally
    //   415	418	471	finally
    //   425	431	471	finally
    //   439	444	471	finally
    //   444	446	471	finally
    //   446	449	471	finally
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append(">upgradeStepByStep ");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append("|");
    paramSQLiteDatabase.append(paramInt2);
    Logger.b("DownloadInfoDBHelper_", paramSQLiteDatabase.toString());
  }
  
  /* Error */
  public void a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +11 -> 15
    //   7: ldc 34
    //   9: ldc 143
    //   11: invokestatic 146	com/tencent/timi/game/utils/Logger:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: return
    //   15: aload_0
    //   16: getfield 20	com/yolo/esports/download/db/DownloadInfoDBHelper:a	Ljava/lang/Object;
    //   19: astore 5
    //   21: aload 5
    //   23: monitorenter
    //   24: aconst_null
    //   25: astore_2
    //   26: aconst_null
    //   27: astore_3
    //   28: aload_0
    //   29: invokevirtual 149	com/yolo/esports/download/db/DownloadInfoDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: astore 4
    //   34: aload 4
    //   36: astore_3
    //   37: aload 4
    //   39: astore_2
    //   40: new 91	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   47: astore 6
    //   49: aload 4
    //   51: astore_3
    //   52: aload 4
    //   54: astore_2
    //   55: aload 6
    //   57: ldc 151
    //   59: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 4
    //   65: astore_3
    //   66: aload 4
    //   68: astore_2
    //   69: aload 6
    //   71: iconst_1
    //   72: anewarray 153	java/lang/String
    //   75: dup
    //   76: iconst_0
    //   77: aload_1
    //   78: aastore
    //   79: invokestatic 158	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 4
    //   88: astore_3
    //   89: aload 4
    //   91: astore_2
    //   92: ldc 34
    //   94: aload 6
    //   96: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 52	com/tencent/timi/game/utils/Logger:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload 4
    //   104: astore_3
    //   105: aload 4
    //   107: astore_2
    //   108: aload 4
    //   110: ldc 61
    //   112: ldc 160
    //   114: iconst_1
    //   115: anewarray 153	java/lang/String
    //   118: dup
    //   119: iconst_0
    //   120: aload_1
    //   121: aastore
    //   122: invokevirtual 164	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   125: pop
    //   126: aload 4
    //   128: ifnull +35 -> 163
    //   131: aload 4
    //   133: astore_2
    //   134: aload_2
    //   135: invokevirtual 123	android/database/sqlite/SQLiteDatabase:close	()V
    //   138: goto +25 -> 163
    //   141: astore_1
    //   142: goto +25 -> 167
    //   145: astore_1
    //   146: aload_2
    //   147: astore_3
    //   148: ldc 34
    //   150: ldc 166
    //   152: aload_1
    //   153: invokestatic 46	com/tencent/timi/game/utils/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   156: aload_2
    //   157: ifnull +6 -> 163
    //   160: goto -26 -> 134
    //   163: aload 5
    //   165: monitorexit
    //   166: return
    //   167: aload_3
    //   168: ifnull +7 -> 175
    //   171: aload_3
    //   172: invokevirtual 123	android/database/sqlite/SQLiteDatabase:close	()V
    //   175: aload_1
    //   176: athrow
    //   177: astore_1
    //   178: aload 5
    //   180: monitorexit
    //   181: goto +5 -> 186
    //   184: aload_1
    //   185: athrow
    //   186: goto -2 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	DownloadInfoDBHelper
    //   0	189	1	paramString	java.lang.String
    //   25	132	2	localObject1	Object
    //   27	145	3	localObject2	Object
    //   32	100	4	localSQLiteDatabase	SQLiteDatabase
    //   19	160	5	localObject3	Object
    //   47	48	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   28	34	141	finally
    //   40	49	141	finally
    //   55	63	141	finally
    //   69	86	141	finally
    //   92	102	141	finally
    //   108	126	141	finally
    //   148	156	141	finally
    //   28	34	145	java/lang/Exception
    //   40	49	145	java/lang/Exception
    //   55	63	145	java/lang/Exception
    //   69	86	145	java/lang/Exception
    //   92	102	145	java/lang/Exception
    //   108	126	145	java/lang/Exception
    //   134	138	177	finally
    //   163	166	177	finally
    //   171	175	177	finally
    //   175	177	177	finally
    //   178	181	177	finally
  }
  
  /* Error */
  public boolean a(com.yolo.esports.download.common.DownloadInfo paramDownloadInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 169	com/yolo/esports/download/common/DownloadInfo:a	()Ljava/lang/String;
    //   4: astore 10
    //   6: aload 10
    //   8: invokestatic 141	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: istore_2
    //   12: iconst_0
    //   13: istore_3
    //   14: iload_2
    //   15: ifeq +5 -> 20
    //   18: iconst_0
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 20	com/yolo/esports/download/db/DownloadInfoDBHelper:a	Ljava/lang/Object;
    //   24: astore 9
    //   26: aload 9
    //   28: monitorenter
    //   29: aconst_null
    //   30: astore 8
    //   32: aconst_null
    //   33: astore 7
    //   35: aload 7
    //   37: astore 6
    //   39: aload_1
    //   40: invokestatic 172	com/yolo/esports/download/db/DownloadInfoDBCommon:a	(Lcom/yolo/esports/download/common/DownloadInfo;)Landroid/content/ContentValues;
    //   43: astore 11
    //   45: aload 7
    //   47: astore 6
    //   49: aload_0
    //   50: invokevirtual 149	com/yolo/esports/download/db/DownloadInfoDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   53: astore_1
    //   54: aload_1
    //   55: invokevirtual 175	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   58: aload_1
    //   59: ldc 61
    //   61: ldc 160
    //   63: iconst_1
    //   64: anewarray 153	java/lang/String
    //   67: dup
    //   68: iconst_0
    //   69: aload 10
    //   71: aastore
    //   72: invokevirtual 164	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   75: pop
    //   76: aload_1
    //   77: ldc 61
    //   79: aconst_null
    //   80: aload 11
    //   82: invokevirtual 179	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   85: lstore 4
    //   87: new 91	java/lang/StringBuilder
    //   90: dup
    //   91: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   94: astore 6
    //   96: aload 6
    //   98: ldc 181
    //   100: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload 6
    //   106: lload 4
    //   108: invokevirtual 184	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: ldc 34
    //   114: aload 6
    //   116: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 52	com/tencent/timi/game/utils/Logger:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: aload_1
    //   123: invokevirtual 187	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   126: aload_1
    //   127: ifnull +23 -> 150
    //   130: aload_1
    //   131: invokevirtual 190	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   134: aload_1
    //   135: invokevirtual 123	android/database/sqlite/SQLiteDatabase:close	()V
    //   138: goto +12 -> 150
    //   141: astore_1
    //   142: ldc 34
    //   144: ldc 192
    //   146: aload_1
    //   147: invokestatic 46	com/tencent/timi/game/utils/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   150: iconst_1
    //   151: istore_2
    //   152: goto +72 -> 224
    //   155: astore 6
    //   157: goto +72 -> 229
    //   160: astore 7
    //   162: goto +20 -> 182
    //   165: astore 7
    //   167: aload 6
    //   169: astore_1
    //   170: aload 7
    //   172: astore 6
    //   174: goto +55 -> 229
    //   177: astore 7
    //   179: aload 8
    //   181: astore_1
    //   182: aload_1
    //   183: astore 6
    //   185: ldc 34
    //   187: ldc 194
    //   189: aload 7
    //   191: invokestatic 46	com/tencent/timi/game/utils/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   194: iload_3
    //   195: istore_2
    //   196: aload_1
    //   197: ifnull +27 -> 224
    //   200: aload_1
    //   201: invokevirtual 190	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   204: aload_1
    //   205: invokevirtual 123	android/database/sqlite/SQLiteDatabase:close	()V
    //   208: iload_3
    //   209: istore_2
    //   210: goto +14 -> 224
    //   213: astore_1
    //   214: ldc 34
    //   216: ldc 192
    //   218: aload_1
    //   219: invokestatic 46	com/tencent/timi/game/utils/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   222: iload_3
    //   223: istore_2
    //   224: aload 9
    //   226: monitorexit
    //   227: iload_2
    //   228: ireturn
    //   229: aload_1
    //   230: ifnull +27 -> 257
    //   233: aload_1
    //   234: invokevirtual 190	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   237: aload_1
    //   238: invokevirtual 123	android/database/sqlite/SQLiteDatabase:close	()V
    //   241: goto +16 -> 257
    //   244: astore_1
    //   245: goto +15 -> 260
    //   248: astore_1
    //   249: ldc 34
    //   251: ldc 192
    //   253: aload_1
    //   254: invokestatic 46	com/tencent/timi/game/utils/Logger:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   257: aload 6
    //   259: athrow
    //   260: aload 9
    //   262: monitorexit
    //   263: aload_1
    //   264: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	this	DownloadInfoDBHelper
    //   0	265	1	paramDownloadInfo	com.yolo.esports.download.common.DownloadInfo
    //   11	217	2	bool1	boolean
    //   13	210	3	bool2	boolean
    //   85	22	4	l	long
    //   37	78	6	localObject1	Object
    //   155	13	6	localObject2	Object
    //   172	86	6	localObject3	Object
    //   33	13	7	localObject4	Object
    //   160	1	7	localException1	Exception
    //   165	6	7	localObject5	Object
    //   177	13	7	localException2	Exception
    //   30	150	8	localObject6	Object
    //   24	237	9	localObject7	Object
    //   4	66	10	str	java.lang.String
    //   43	38	11	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   130	138	141	java/lang/Exception
    //   54	126	155	finally
    //   54	126	160	java/lang/Exception
    //   39	45	165	finally
    //   49	54	165	finally
    //   185	194	165	finally
    //   39	45	177	java/lang/Exception
    //   49	54	177	java/lang/Exception
    //   200	208	213	java/lang/Exception
    //   130	138	244	finally
    //   142	150	244	finally
    //   200	208	244	finally
    //   214	222	244	finally
    //   224	227	244	finally
    //   233	241	244	finally
    //   249	257	244	finally
    //   257	260	244	finally
    //   260	263	244	finally
    //   233	241	248	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    paramSQLiteDatabase = new StringBuilder();
    paramSQLiteDatabase.append(">onDowngrade ");
    paramSQLiteDatabase.append(paramInt1);
    paramSQLiteDatabase.append("|");
    paramSQLiteDatabase.append(paramInt2);
    Logger.b("DownloadInfoDBHelper_", paramSQLiteDatabase.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.yolo.esports.download.db.DownloadInfoDBHelper
 * JD-Core Version:    0.7.0.1
 */