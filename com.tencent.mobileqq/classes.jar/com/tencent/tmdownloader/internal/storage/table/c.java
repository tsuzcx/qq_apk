package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistant.common.a.d;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.storage.a.a;

public class c
  implements com.tencent.tmassistant.common.a.c
{
  private static int a(com.tencent.tmdownloader.internal.downloadservice.c paramc, SQLiteDatabase paramSQLiteDatabase)
  {
    int i;
    if (paramc == null) {
      i = -1;
    }
    for (;;)
    {
      return i;
      try
      {
        ContentValues localContentValues = new ContentValues();
        com.tencent.tmdownloader.internal.downloadservice.c.a(localContentValues, paramc);
        int j = paramSQLiteDatabase.update("downloadInfo", localContentValues, "taskUrl = ?", new String[] { paramc.b });
        i = j;
        if (j <= 0) {
          return 0;
        }
      }
      catch (Exception paramc)
      {
        r.c("DownloadInfoTable", "exception: ", paramc);
        paramc.printStackTrace();
      }
    }
    return -2;
  }
  
  /* Error */
  public static java.util.ArrayList<com.tencent.tmdownloader.internal.downloadservice.c> a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_1
    //   4: ldc 2
    //   6: monitorenter
    //   7: new 55	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 56	java/util/ArrayList:<init>	()V
    //   14: astore 4
    //   16: invokestatic 61	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   19: invokevirtual 67	com/tencent/tmassistant/common/a/d:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore_3
    //   23: aload_3
    //   24: ifnull +67 -> 91
    //   27: aload_3
    //   28: ldc 69
    //   30: aconst_null
    //   31: invokevirtual 73	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +45 -> 81
    //   39: aload_3
    //   40: astore_1
    //   41: aload_3
    //   42: astore_2
    //   43: aload_3
    //   44: invokeinterface 79 1 0
    //   49: ifeq +32 -> 81
    //   52: aload_3
    //   53: astore_1
    //   54: aload_3
    //   55: astore_2
    //   56: aload 4
    //   58: aload_3
    //   59: invokestatic 82	com/tencent/tmdownloader/internal/downloadservice/c:a	(Landroid/database/Cursor;)Lcom/tencent/tmdownloader/internal/downloadservice/c;
    //   62: invokevirtual 86	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: aload_3
    //   67: astore_1
    //   68: aload_3
    //   69: astore_2
    //   70: aload_3
    //   71: invokeinterface 89 1 0
    //   76: istore_0
    //   77: iload_0
    //   78: ifne -26 -> 52
    //   81: aload_3
    //   82: ifnull +9 -> 91
    //   85: aload_3
    //   86: invokeinterface 92 1 0
    //   91: ldc 2
    //   93: monitorexit
    //   94: aload 4
    //   96: areturn
    //   97: astore_3
    //   98: aload_1
    //   99: astore_2
    //   100: ldc 41
    //   102: ldc 43
    //   104: aload_3
    //   105: invokestatic 49	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   108: aload_1
    //   109: astore_2
    //   110: aload_3
    //   111: invokevirtual 52	java/lang/Exception:printStackTrace	()V
    //   114: aload_1
    //   115: ifnull -24 -> 91
    //   118: aload_1
    //   119: invokeinterface 92 1 0
    //   124: goto -33 -> 91
    //   127: astore_1
    //   128: ldc 2
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    //   133: astore_1
    //   134: aload_2
    //   135: ifnull +9 -> 144
    //   138: aload_2
    //   139: invokeinterface 92 1 0
    //   144: aload_1
    //   145: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   76	2	0	bool	boolean
    //   3	116	1	localObject1	Object
    //   127	5	1	localObject2	Object
    //   133	12	1	localObject3	Object
    //   1	138	2	localObject4	Object
    //   22	64	3	localObject5	Object
    //   97	14	3	localException	Exception
    //   14	81	4	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   27	35	97	java/lang/Exception
    //   43	52	97	java/lang/Exception
    //   56	66	97	java/lang/Exception
    //   70	77	97	java/lang/Exception
    //   7	23	127	finally
    //   85	91	127	finally
    //   118	124	127	finally
    //   138	144	127	finally
    //   144	146	127	finally
    //   27	35	133	finally
    //   43	52	133	finally
    //   56	66	133	finally
    //   70	77	133	finally
    //   100	108	133	finally
    //   110	114	133	finally
  }
  
  public static void a(com.tencent.tmdownloader.internal.downloadservice.c paramc)
  {
    if (paramc != null) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = a.c().getWritableDatabase();
      if ((localSQLiteDatabase != null) && (a(paramc, localSQLiteDatabase) <= 0))
      {
        ContentValues localContentValues = new ContentValues();
        com.tencent.tmdownloader.internal.downloadservice.c.a(localContentValues, paramc);
        localSQLiteDatabase.insert("downloadInfo", null, localContentValues);
      }
    }
    catch (Exception paramc)
    {
      for (;;)
      {
        r.c("DownloadInfoTable", "exception: ", paramc);
        paramc.printStackTrace();
      }
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {}
    try
    {
      SQLiteDatabase localSQLiteDatabase = a.c().getWritableDatabase();
      if (localSQLiteDatabase != null) {
        localSQLiteDatabase.delete("downloadInfo", "taskUrl = ?", new String[] { paramString });
      }
      return;
    }
    catch (Exception paramString)
    {
      r.c("DownloadInfoTable", "exception: ", paramString);
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public static void a(java.util.ArrayList<com.tencent.tmdownloader.internal.downloadservice.c> paramArrayList)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +92 -> 96
    //   7: invokestatic 61	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   10: invokevirtual 98	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   13: astore_1
    //   14: aload_1
    //   15: ifnull +81 -> 96
    //   18: aload_1
    //   19: invokevirtual 117	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   22: aload_0
    //   23: invokevirtual 121	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   26: astore_0
    //   27: aload_0
    //   28: invokeinterface 126 1 0
    //   33: ifeq +67 -> 100
    //   36: aload_0
    //   37: invokeinterface 130 1 0
    //   42: checkcast 20	com/tencent/tmdownloader/internal/downloadservice/c
    //   45: astore_2
    //   46: aload_2
    //   47: aload_1
    //   48: invokestatic 100	com/tencent/tmdownloader/internal/storage/table/c:a	(Lcom/tencent/tmdownloader/internal/downloadservice/c;Landroid/database/sqlite/SQLiteDatabase;)I
    //   51: ifgt -24 -> 27
    //   54: new 17	android/content/ContentValues
    //   57: dup
    //   58: invokespecial 18	android/content/ContentValues:<init>	()V
    //   61: astore_3
    //   62: aload_3
    //   63: aload_2
    //   64: invokestatic 23	com/tencent/tmdownloader/internal/downloadservice/c:a	(Landroid/content/ContentValues;Lcom/tencent/tmdownloader/internal/downloadservice/c;)V
    //   67: aload_1
    //   68: ldc 25
    //   70: aconst_null
    //   71: aload_3
    //   72: invokevirtual 104	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   75: pop2
    //   76: goto -49 -> 27
    //   79: astore_0
    //   80: ldc 41
    //   82: ldc 43
    //   84: aload_0
    //   85: invokestatic 49	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   88: aload_0
    //   89: invokevirtual 52	java/lang/Exception:printStackTrace	()V
    //   92: aload_1
    //   93: invokevirtual 133	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   96: ldc 2
    //   98: monitorexit
    //   99: return
    //   100: aload_1
    //   101: invokevirtual 136	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   104: aload_1
    //   105: invokevirtual 133	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   108: goto -12 -> 96
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 52	java/lang/Exception:printStackTrace	()V
    //   116: goto -20 -> 96
    //   119: astore_0
    //   120: ldc 2
    //   122: monitorexit
    //   123: aload_0
    //   124: athrow
    //   125: astore_0
    //   126: aload_1
    //   127: invokevirtual 133	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   130: aload_0
    //   131: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	paramArrayList	java.util.ArrayList<com.tencent.tmdownloader.internal.downloadservice.c>
    //   13	114	1	localSQLiteDatabase	SQLiteDatabase
    //   45	19	2	localc	com.tencent.tmdownloader.internal.downloadservice.c
    //   61	11	3	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   18	27	79	java/lang/Exception
    //   27	76	79	java/lang/Exception
    //   100	104	79	java/lang/Exception
    //   7	14	111	java/lang/Exception
    //   92	96	111	java/lang/Exception
    //   104	108	111	java/lang/Exception
    //   126	132	111	java/lang/Exception
    //   7	14	119	finally
    //   92	96	119	finally
    //   104	108	119	finally
    //   112	116	119	finally
    //   126	132	119	finally
    //   18	27	125	finally
    //   27	76	125	finally
    //   80	92	125	finally
    //   100	104	125	finally
  }
  
  /* Error */
  public static com.tencent.tmdownloader.internal.downloadservice.c b(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_3
    //   6: astore_1
    //   7: aload_0
    //   8: ifnull +76 -> 84
    //   11: aload_3
    //   12: astore_1
    //   13: aload_0
    //   14: invokevirtual 109	java/lang/String:length	()I
    //   17: ifle +67 -> 84
    //   20: invokestatic 61	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   23: invokevirtual 67	com/tencent/tmassistant/common/a/d:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore_2
    //   27: aload_3
    //   28: astore_1
    //   29: aload_2
    //   30: ifnull +54 -> 84
    //   33: aload_2
    //   34: ldc 140
    //   36: iconst_1
    //   37: anewarray 29	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: aastore
    //   44: invokevirtual 73	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_0
    //   48: aload_0
    //   49: ifnull +40 -> 89
    //   52: aload_0
    //   53: astore_1
    //   54: aload_0
    //   55: invokeinterface 79 1 0
    //   60: ifeq +29 -> 89
    //   63: aload_0
    //   64: astore_1
    //   65: aload_0
    //   66: invokestatic 82	com/tencent/tmdownloader/internal/downloadservice/c:a	(Landroid/database/Cursor;)Lcom/tencent/tmdownloader/internal/downloadservice/c;
    //   69: astore_2
    //   70: aload_2
    //   71: astore_1
    //   72: aload_0
    //   73: ifnull +11 -> 84
    //   76: aload_0
    //   77: invokeinterface 92 1 0
    //   82: aload_2
    //   83: astore_1
    //   84: ldc 2
    //   86: monitorexit
    //   87: aload_1
    //   88: areturn
    //   89: aload_3
    //   90: astore_1
    //   91: aload_0
    //   92: ifnull -8 -> 84
    //   95: aload_0
    //   96: invokeinterface 92 1 0
    //   101: aload_3
    //   102: astore_1
    //   103: goto -19 -> 84
    //   106: astore_0
    //   107: ldc 2
    //   109: monitorexit
    //   110: aload_0
    //   111: athrow
    //   112: astore_2
    //   113: aconst_null
    //   114: astore_0
    //   115: aload_0
    //   116: astore_1
    //   117: ldc 41
    //   119: ldc 43
    //   121: aload_2
    //   122: invokestatic 49	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   125: aload_0
    //   126: astore_1
    //   127: aload_2
    //   128: invokevirtual 52	java/lang/Exception:printStackTrace	()V
    //   131: aload_3
    //   132: astore_1
    //   133: aload_0
    //   134: ifnull -50 -> 84
    //   137: aload_0
    //   138: invokeinterface 92 1 0
    //   143: aload_3
    //   144: astore_1
    //   145: goto -61 -> 84
    //   148: aload_1
    //   149: ifnull +9 -> 158
    //   152: aload_1
    //   153: invokeinterface 92 1 0
    //   158: aload_0
    //   159: athrow
    //   160: astore_0
    //   161: goto -13 -> 148
    //   164: astore_2
    //   165: goto -50 -> 115
    //   168: astore_0
    //   169: aconst_null
    //   170: astore_1
    //   171: goto -23 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	174	0	paramString	String
    //   6	165	1	localObject1	Object
    //   26	57	2	localObject2	Object
    //   112	16	2	localException1	Exception
    //   164	1	2	localException2	Exception
    //   1	143	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   13	27	106	finally
    //   76	82	106	finally
    //   95	101	106	finally
    //   137	143	106	finally
    //   152	158	106	finally
    //   158	160	106	finally
    //   33	48	112	java/lang/Exception
    //   54	63	160	finally
    //   65	70	160	finally
    //   117	125	160	finally
    //   127	131	160	finally
    //   54	63	164	java/lang/Exception
    //   65	70	164	java/lang/Exception
    //   33	48	168	finally
  }
  
  /* Error */
  public static java.util.ArrayList<com.tencent.tmdownloader.internal.downloadservice.a.b> b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: ldc 2
    //   6: monitorenter
    //   7: new 55	java/util/ArrayList
    //   10: dup
    //   11: invokespecial 56	java/util/ArrayList:<init>	()V
    //   14: astore 5
    //   16: invokestatic 61	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   19: invokevirtual 67	com/tencent/tmassistant/common/a/d:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore 4
    //   24: aload 4
    //   26: ifnull +180 -> 206
    //   29: aload 4
    //   31: ldc 142
    //   33: aconst_null
    //   34: invokevirtual 73	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   37: astore 4
    //   39: aload 4
    //   41: ifnull +153 -> 194
    //   44: aload 4
    //   46: astore_2
    //   47: aload 4
    //   49: astore_3
    //   50: aload 4
    //   52: invokeinterface 79 1 0
    //   57: ifeq +137 -> 194
    //   60: aload 4
    //   62: astore_2
    //   63: aload 4
    //   65: astore_3
    //   66: aload 4
    //   68: aload 4
    //   70: ldc 144
    //   72: invokeinterface 148 2 0
    //   77: invokeinterface 152 2 0
    //   82: astore 6
    //   84: aload 4
    //   86: astore_2
    //   87: aload 4
    //   89: astore_3
    //   90: aload 4
    //   92: aload 4
    //   94: ldc 154
    //   96: invokeinterface 148 2 0
    //   101: invokeinterface 152 2 0
    //   106: astore 7
    //   108: aload 4
    //   110: astore_2
    //   111: aload 4
    //   113: astore_3
    //   114: aload 4
    //   116: aload 4
    //   118: ldc 156
    //   120: invokeinterface 148 2 0
    //   125: invokeinterface 160 2 0
    //   130: istore_0
    //   131: aload 4
    //   133: astore_2
    //   134: aload 4
    //   136: astore_3
    //   137: new 162	com/tencent/tmdownloader/internal/downloadservice/a/b
    //   140: dup
    //   141: aload 6
    //   143: aload 7
    //   145: invokespecial 165	com/tencent/tmdownloader/internal/downloadservice/a/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: astore 6
    //   150: aload 4
    //   152: astore_2
    //   153: aload 4
    //   155: astore_3
    //   156: aload 6
    //   158: iload_0
    //   159: putfield 168	com/tencent/tmdownloader/internal/downloadservice/a/b:c	I
    //   162: aload 4
    //   164: astore_2
    //   165: aload 4
    //   167: astore_3
    //   168: aload 5
    //   170: aload 6
    //   172: invokevirtual 86	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   175: pop
    //   176: aload 4
    //   178: astore_2
    //   179: aload 4
    //   181: astore_3
    //   182: aload 4
    //   184: invokeinterface 89 1 0
    //   189: istore_1
    //   190: iload_1
    //   191: ifne -131 -> 60
    //   194: aload 4
    //   196: ifnull +10 -> 206
    //   199: aload 4
    //   201: invokeinterface 92 1 0
    //   206: ldc 2
    //   208: monitorexit
    //   209: aload 5
    //   211: areturn
    //   212: astore 4
    //   214: aload_2
    //   215: astore_3
    //   216: ldc 41
    //   218: ldc 43
    //   220: aload 4
    //   222: invokestatic 49	com/tencent/tmassistantbase/util/r:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   225: aload_2
    //   226: astore_3
    //   227: aload 4
    //   229: invokevirtual 52	java/lang/Exception:printStackTrace	()V
    //   232: aload_2
    //   233: ifnull -27 -> 206
    //   236: aload_2
    //   237: invokeinterface 92 1 0
    //   242: goto -36 -> 206
    //   245: astore_2
    //   246: ldc 2
    //   248: monitorexit
    //   249: aload_2
    //   250: athrow
    //   251: astore_2
    //   252: aload_3
    //   253: ifnull +9 -> 262
    //   256: aload_3
    //   257: invokeinterface 92 1 0
    //   262: aload_2
    //   263: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   130	29	0	i	int
    //   189	2	1	bool	boolean
    //   3	234	2	localObject1	Object
    //   245	5	2	localObject2	Object
    //   251	12	2	localObject3	Object
    //   1	256	3	localObject4	Object
    //   22	178	4	localObject5	Object
    //   212	16	4	localException	Exception
    //   14	196	5	localArrayList	java.util.ArrayList
    //   82	89	6	localObject6	Object
    //   106	38	7	str	String
    // Exception table:
    //   from	to	target	type
    //   29	39	212	java/lang/Exception
    //   50	60	212	java/lang/Exception
    //   66	84	212	java/lang/Exception
    //   90	108	212	java/lang/Exception
    //   114	131	212	java/lang/Exception
    //   137	150	212	java/lang/Exception
    //   156	162	212	java/lang/Exception
    //   168	176	212	java/lang/Exception
    //   182	190	212	java/lang/Exception
    //   7	24	245	finally
    //   199	206	245	finally
    //   236	242	245	finally
    //   256	262	245	finally
    //   262	264	245	finally
    //   29	39	251	finally
    //   50	60	251	finally
    //   66	84	251	finally
    //   90	108	251	finally
    //   114	131	251	finally
    //   137	150	251	finally
    //   156	162	251	finally
    //   168	176	251	finally
    //   182	190	251	finally
    //   216	225	251	finally
    //   227	232	251	finally
  }
  
  public String createTableSQL()
  {
    return "CREATE TABLE if not exists downloadInfo( _id INTEGER PRIMARY KEY AUTOINCREMENT, taskId INTEGER , uId TEXT, taskUrl TEXT, bakUrl TEXT,finalUrl TEXT, fileName TEXT, contentType TEXT, totalBytes INTEGER,status INTEGER,receivedBytes INTEGER,priority INTEGER, netType TEXT,downloadFailedErrCode INTEGER,downloadFailedTime INTEGER,headerParams TEXT,appId INTEGER,taskPakcageName TEXT,taskVersioncode TEXT,startTime INTEGER,endTime INTEGER,downloadType INTEGER,uin INTEGER,uintype TEXT,via TEXT,channelId TEXT,traceId TEXT,extraData TEXT,iconUrl TEXT,appName TEXT,isAutoInstallBySDK INTEGER,fileSize INTEGER);";
  }
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (paramInt2 == 2)) {
      return new String[] { "alter table downloadInfo add column headerParams TEXT;" };
    }
    if ((paramInt1 == 2) && (paramInt2 == 3)) {
      return new String[] { "alter table downloadInfo add column appId INTEGER;", "alter table downloadInfo add column taskPakcageName TEXT;", "alter table downloadInfo add column taskVersioncode TEXT;", "alter table downloadInfo add column startTime INTEGER;", "alter table downloadInfo add column endTime INTEGER;", "alter table downloadInfo add column downloadType INTEGER;", "alter table downloadInfo add column uin INTEGER;", "alter table downloadInfo add column uintype TEXT;", "alter table downloadInfo add column via TEXT;", "alter table downloadInfo add column channelId TEXT;", "alter table downloadInfo add column traceId TEXT;", "alter table downloadInfo add column extraData TEXT;" };
    }
    if ((paramInt1 == 3) && (paramInt2 == 4)) {
      return new String[] { "alter table downloadInfo add column iconUrl TEXT;", "alter table downloadInfo add column appName TEXT;" };
    }
    if ((paramInt1 == 4) && (paramInt2 == 5)) {
      return new String[] { "alter table downloadInfo add column isAutoInstallBySDK INTEGER;" };
    }
    if ((paramInt1 == 5) && (paramInt2 == 6)) {
      return new String[] { "alter table downloadInfo add column fileSize INTEGER;" };
    }
    return new String[] { "alter table downloadInfo add column netType TEXT;", "alter table downloadInfo add column downloadFailedErrCode INTEGER;", "alter table downloadInfo add column downloadFailedTime INTEGER;" };
  }
  
  public String tableName()
  {
    return "downloadInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.table.c
 * JD-Core Version:    0.7.0.1
 */