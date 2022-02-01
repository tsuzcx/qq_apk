package com.tencent.tmdownloader.internal.storage.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistant.common.a.d;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmdownloader.internal.storage.a.a;

public class c
  implements com.tencent.tmassistant.common.a.c
{
  private static final Object a = new Object();
  
  private static int a(com.tencent.tmdownloader.internal.downloadservice.c paramc, SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramc == null) {
      return -1;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      com.tencent.tmdownloader.internal.downloadservice.c.a(localContentValues, paramc);
      int i = paramSQLiteDatabase.update("downloadInfo", localContentValues, "taskUrl = ?", new String[] { paramc.b });
      if (i > 0) {
        return i;
      }
      return 0;
    }
    catch (Exception paramc)
    {
      ab.c("DownloadInfoTable", "exception: ", paramc);
      paramc.printStackTrace();
    }
    return -2;
  }
  
  /* Error */
  public static java.util.ArrayList<com.tencent.tmdownloader.internal.downloadservice.c> a()
  {
    // Byte code:
    //   0: getstatic 15	com/tencent/tmdownloader/internal/storage/table/c:a	Ljava/lang/Object;
    //   3: astore 4
    //   5: aload 4
    //   7: monitorenter
    //   8: new 59	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 60	java/util/ArrayList:<init>	()V
    //   15: astore 5
    //   17: invokestatic 65	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   20: invokevirtual 71	com/tencent/tmassistant/common/a/d:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_3
    //   24: aload_3
    //   25: ifnull +123 -> 148
    //   28: aconst_null
    //   29: astore_2
    //   30: aconst_null
    //   31: astore_1
    //   32: aload_3
    //   33: ldc 73
    //   35: aconst_null
    //   36: invokevirtual 77	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   39: astore_3
    //   40: aload_3
    //   41: ifnull +45 -> 86
    //   44: aload_3
    //   45: astore_1
    //   46: aload_3
    //   47: astore_2
    //   48: aload_3
    //   49: invokeinterface 83 1 0
    //   54: ifeq +32 -> 86
    //   57: aload_3
    //   58: astore_1
    //   59: aload_3
    //   60: astore_2
    //   61: aload 5
    //   63: aload_3
    //   64: invokestatic 86	com/tencent/tmdownloader/internal/downloadservice/c:a	(Landroid/database/Cursor;)Lcom/tencent/tmdownloader/internal/downloadservice/c;
    //   67: invokevirtual 90	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   70: pop
    //   71: aload_3
    //   72: astore_1
    //   73: aload_3
    //   74: astore_2
    //   75: aload_3
    //   76: invokeinterface 93 1 0
    //   81: istore_0
    //   82: iload_0
    //   83: ifne -26 -> 57
    //   86: aload_3
    //   87: ifnull +61 -> 148
    //   90: aload_3
    //   91: invokeinterface 96 1 0
    //   96: goto +52 -> 148
    //   99: astore_2
    //   100: goto +36 -> 136
    //   103: astore_3
    //   104: aload_2
    //   105: astore_1
    //   106: ldc 45
    //   108: ldc 47
    //   110: aload_3
    //   111: invokestatic 53	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   114: aload_2
    //   115: astore_1
    //   116: aload_3
    //   117: invokevirtual 56	java/lang/Exception:printStackTrace	()V
    //   120: aload_2
    //   121: ifnull +9 -> 130
    //   124: aload_2
    //   125: invokeinterface 96 1 0
    //   130: aload 4
    //   132: monitorexit
    //   133: aload 5
    //   135: areturn
    //   136: aload_1
    //   137: ifnull +9 -> 146
    //   140: aload_1
    //   141: invokeinterface 96 1 0
    //   146: aload_2
    //   147: athrow
    //   148: aload 4
    //   150: monitorexit
    //   151: aload 5
    //   153: areturn
    //   154: astore_1
    //   155: aload 4
    //   157: monitorexit
    //   158: goto +5 -> 163
    //   161: aload_1
    //   162: athrow
    //   163: goto -2 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   81	2	0	bool	boolean
    //   31	110	1	localObject1	Object
    //   154	8	1	localObject2	Object
    //   29	46	2	localObject3	Object
    //   99	48	2	localObject4	Object
    //   23	68	3	localObject5	Object
    //   103	14	3	localException	Exception
    //   3	153	4	localObject6	Object
    //   15	137	5	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   32	40	99	finally
    //   48	57	99	finally
    //   61	71	99	finally
    //   75	82	99	finally
    //   106	114	99	finally
    //   116	120	99	finally
    //   32	40	103	java/lang/Exception
    //   48	57	103	java/lang/Exception
    //   61	71	103	java/lang/Exception
    //   75	82	103	java/lang/Exception
    //   8	24	154	finally
    //   90	96	154	finally
    //   124	130	154	finally
    //   130	133	154	finally
    //   140	146	154	finally
    //   146	148	154	finally
    //   148	151	154	finally
    //   155	158	154	finally
  }
  
  public static void a(com.tencent.tmdownloader.internal.downloadservice.c paramc)
  {
    Object localObject = a;
    if (paramc != null) {}
    try
    {
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
        ab.c("DownloadInfoTable", "exception: ", paramc);
        paramc.printStackTrace();
      }
      return;
    }
    finally {}
  }
  
  public static void a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        SQLiteDatabase localSQLiteDatabase = a.c().getWritableDatabase();
        if (localSQLiteDatabase != null)
        {
          localSQLiteDatabase.delete("downloadInfo", "taskUrl = ?", new String[] { paramString });
          return;
        }
      }
      catch (Exception paramString)
      {
        ab.c("DownloadInfoTable", "exception: ", paramString);
        paramString.printStackTrace();
      }
    }
  }
  
  /* Error */
  public static void a(java.util.ArrayList<com.tencent.tmdownloader.internal.downloadservice.c> paramArrayList)
  {
    // Byte code:
    //   0: getstatic 15	com/tencent/tmdownloader/internal/storage/table/c:a	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: aload_0
    //   7: ifnull +120 -> 127
    //   10: invokestatic 65	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   13: invokevirtual 102	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +109 -> 127
    //   21: aload_2
    //   22: invokevirtual 121	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   25: aload_0
    //   26: invokevirtual 125	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   29: astore_0
    //   30: aload_0
    //   31: invokeinterface 130 1 0
    //   36: ifeq +49 -> 85
    //   39: aload_0
    //   40: invokeinterface 134 1 0
    //   45: checkcast 24	com/tencent/tmdownloader/internal/downloadservice/c
    //   48: astore_3
    //   49: aload_3
    //   50: aload_2
    //   51: invokestatic 104	com/tencent/tmdownloader/internal/storage/table/c:a	(Lcom/tencent/tmdownloader/internal/downloadservice/c;Landroid/database/sqlite/SQLiteDatabase;)I
    //   54: ifgt -24 -> 30
    //   57: new 21	android/content/ContentValues
    //   60: dup
    //   61: invokespecial 22	android/content/ContentValues:<init>	()V
    //   64: astore 4
    //   66: aload 4
    //   68: aload_3
    //   69: invokestatic 27	com/tencent/tmdownloader/internal/downloadservice/c:a	(Landroid/content/ContentValues;Lcom/tencent/tmdownloader/internal/downloadservice/c;)V
    //   72: aload_2
    //   73: ldc 29
    //   75: aconst_null
    //   76: aload 4
    //   78: invokevirtual 108	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   81: pop2
    //   82: goto -52 -> 30
    //   85: aload_2
    //   86: invokevirtual 137	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   89: aload_2
    //   90: invokevirtual 140	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   93: goto +34 -> 127
    //   96: astore_0
    //   97: goto +19 -> 116
    //   100: astore_0
    //   101: ldc 45
    //   103: ldc 47
    //   105: aload_0
    //   106: invokestatic 53	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   109: aload_0
    //   110: invokevirtual 56	java/lang/Exception:printStackTrace	()V
    //   113: goto -24 -> 89
    //   116: aload_2
    //   117: invokevirtual 140	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 56	java/lang/Exception:printStackTrace	()V
    //   127: aload_1
    //   128: monitorexit
    //   129: return
    //   130: astore_0
    //   131: aload_1
    //   132: monitorexit
    //   133: goto +5 -> 138
    //   136: aload_0
    //   137: athrow
    //   138: goto -2 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	paramArrayList	java.util.ArrayList<com.tencent.tmdownloader.internal.downloadservice.c>
    //   3	129	1	localObject	Object
    //   16	101	2	localSQLiteDatabase	SQLiteDatabase
    //   48	21	3	localc	com.tencent.tmdownloader.internal.downloadservice.c
    //   64	13	4	localContentValues	ContentValues
    // Exception table:
    //   from	to	target	type
    //   21	30	96	finally
    //   30	82	96	finally
    //   85	89	96	finally
    //   101	113	96	finally
    //   21	30	100	java/lang/Exception
    //   30	82	100	java/lang/Exception
    //   85	89	100	java/lang/Exception
    //   10	17	122	java/lang/Exception
    //   89	93	122	java/lang/Exception
    //   116	122	122	java/lang/Exception
    //   10	17	130	finally
    //   89	93	130	finally
    //   116	122	130	finally
    //   123	127	130	finally
    //   127	129	130	finally
    //   131	133	130	finally
  }
  
  /* Error */
  public static com.tencent.tmdownloader.internal.downloadservice.c b(String paramString)
  {
    // Byte code:
    //   0: getstatic 15	com/tencent/tmdownloader/internal/storage/table/c:a	Ljava/lang/Object;
    //   3: astore_3
    //   4: aload_3
    //   5: monitorenter
    //   6: aload_0
    //   7: ifnull +126 -> 133
    //   10: aload_0
    //   11: invokevirtual 113	java/lang/String:length	()I
    //   14: ifle +119 -> 133
    //   17: invokestatic 65	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   20: invokevirtual 71	com/tencent/tmassistant/common/a/d:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +108 -> 133
    //   28: aload_1
    //   29: ldc 144
    //   31: iconst_1
    //   32: anewarray 33	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: aload_0
    //   38: aastore
    //   39: invokevirtual 77	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore_0
    //   43: aload_0
    //   44: ifnull +108 -> 152
    //   47: aload_0
    //   48: astore_1
    //   49: aload_0
    //   50: invokeinterface 83 1 0
    //   55: ifeq +97 -> 152
    //   58: aload_0
    //   59: astore_1
    //   60: aload_0
    //   61: invokestatic 86	com/tencent/tmdownloader/internal/downloadservice/c:a	(Landroid/database/Cursor;)Lcom/tencent/tmdownloader/internal/downloadservice/c;
    //   64: astore_2
    //   65: aload_0
    //   66: ifnull +9 -> 75
    //   69: aload_0
    //   70: invokeinterface 96 1 0
    //   75: aload_3
    //   76: monitorexit
    //   77: aload_2
    //   78: areturn
    //   79: aload_0
    //   80: invokeinterface 96 1 0
    //   85: goto +48 -> 133
    //   88: astore_0
    //   89: aconst_null
    //   90: astore_1
    //   91: goto +30 -> 121
    //   94: astore_2
    //   95: aconst_null
    //   96: astore_0
    //   97: aload_0
    //   98: astore_1
    //   99: ldc 45
    //   101: ldc 47
    //   103: aload_2
    //   104: invokestatic 53	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   107: aload_0
    //   108: astore_1
    //   109: aload_2
    //   110: invokevirtual 56	java/lang/Exception:printStackTrace	()V
    //   113: aload_0
    //   114: ifnull +19 -> 133
    //   117: goto -38 -> 79
    //   120: astore_0
    //   121: aload_1
    //   122: ifnull +9 -> 131
    //   125: aload_1
    //   126: invokeinterface 96 1 0
    //   131: aload_0
    //   132: athrow
    //   133: aload_3
    //   134: monitorexit
    //   135: aconst_null
    //   136: areturn
    //   137: astore_0
    //   138: aload_3
    //   139: monitorexit
    //   140: goto +5 -> 145
    //   143: aload_0
    //   144: athrow
    //   145: goto -2 -> 143
    //   148: astore_2
    //   149: goto -52 -> 97
    //   152: aload_0
    //   153: ifnull -20 -> 133
    //   156: goto -77 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	paramString	String
    //   23	103	1	localObject1	Object
    //   64	14	2	localc	com.tencent.tmdownloader.internal.downloadservice.c
    //   94	16	2	localException1	Exception
    //   148	1	2	localException2	Exception
    //   3	136	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   28	43	88	finally
    //   28	43	94	java/lang/Exception
    //   49	58	120	finally
    //   60	65	120	finally
    //   99	107	120	finally
    //   109	113	120	finally
    //   10	24	137	finally
    //   69	75	137	finally
    //   75	77	137	finally
    //   79	85	137	finally
    //   125	131	137	finally
    //   131	133	137	finally
    //   133	135	137	finally
    //   138	140	137	finally
    //   49	58	148	java/lang/Exception
    //   60	65	148	java/lang/Exception
  }
  
  /* Error */
  public static java.util.ArrayList<com.tencent.tmdownloader.internal.downloadservice.a.b> b()
  {
    // Byte code:
    //   0: getstatic 15	com/tencent/tmdownloader/internal/storage/table/c:a	Ljava/lang/Object;
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: new 59	java/util/ArrayList
    //   11: dup
    //   12: invokespecial 60	java/util/ArrayList:<init>	()V
    //   15: astore 6
    //   17: invokestatic 65	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   20: invokevirtual 71	com/tencent/tmassistant/common/a/d:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   23: astore 4
    //   25: aload 4
    //   27: ifnull +239 -> 266
    //   30: aconst_null
    //   31: astore_3
    //   32: aconst_null
    //   33: astore_2
    //   34: aload 4
    //   36: ldc 146
    //   38: aconst_null
    //   39: invokevirtual 77	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore 4
    //   44: aload 4
    //   46: ifnull +153 -> 199
    //   49: aload 4
    //   51: astore_2
    //   52: aload 4
    //   54: astore_3
    //   55: aload 4
    //   57: invokeinterface 83 1 0
    //   62: ifeq +137 -> 199
    //   65: aload 4
    //   67: astore_2
    //   68: aload 4
    //   70: astore_3
    //   71: aload 4
    //   73: aload 4
    //   75: ldc 148
    //   77: invokeinterface 152 2 0
    //   82: invokeinterface 156 2 0
    //   87: astore 7
    //   89: aload 4
    //   91: astore_2
    //   92: aload 4
    //   94: astore_3
    //   95: aload 4
    //   97: aload 4
    //   99: ldc 158
    //   101: invokeinterface 152 2 0
    //   106: invokeinterface 156 2 0
    //   111: astore 8
    //   113: aload 4
    //   115: astore_2
    //   116: aload 4
    //   118: astore_3
    //   119: aload 4
    //   121: aload 4
    //   123: ldc 160
    //   125: invokeinterface 152 2 0
    //   130: invokeinterface 164 2 0
    //   135: istore_0
    //   136: aload 4
    //   138: astore_2
    //   139: aload 4
    //   141: astore_3
    //   142: new 166	com/tencent/tmdownloader/internal/downloadservice/a/b
    //   145: dup
    //   146: aload 7
    //   148: aload 8
    //   150: invokespecial 169	com/tencent/tmdownloader/internal/downloadservice/a/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: astore 7
    //   155: aload 4
    //   157: astore_2
    //   158: aload 4
    //   160: astore_3
    //   161: aload 7
    //   163: iload_0
    //   164: putfield 172	com/tencent/tmdownloader/internal/downloadservice/a/b:c	I
    //   167: aload 4
    //   169: astore_2
    //   170: aload 4
    //   172: astore_3
    //   173: aload 6
    //   175: aload 7
    //   177: invokevirtual 90	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   180: pop
    //   181: aload 4
    //   183: astore_2
    //   184: aload 4
    //   186: astore_3
    //   187: aload 4
    //   189: invokeinterface 93 1 0
    //   194: istore_1
    //   195: iload_1
    //   196: ifne -131 -> 65
    //   199: aload 4
    //   201: ifnull +65 -> 266
    //   204: aload 4
    //   206: invokeinterface 96 1 0
    //   211: goto +55 -> 266
    //   214: astore_3
    //   215: goto +39 -> 254
    //   218: astore 4
    //   220: aload_3
    //   221: astore_2
    //   222: ldc 45
    //   224: ldc 47
    //   226: aload 4
    //   228: invokestatic 53	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload_3
    //   232: astore_2
    //   233: aload 4
    //   235: invokevirtual 56	java/lang/Exception:printStackTrace	()V
    //   238: aload_3
    //   239: ifnull +9 -> 248
    //   242: aload_3
    //   243: invokeinterface 96 1 0
    //   248: aload 5
    //   250: monitorexit
    //   251: aload 6
    //   253: areturn
    //   254: aload_2
    //   255: ifnull +9 -> 264
    //   258: aload_2
    //   259: invokeinterface 96 1 0
    //   264: aload_3
    //   265: athrow
    //   266: aload 5
    //   268: monitorexit
    //   269: aload 6
    //   271: areturn
    //   272: astore_2
    //   273: aload 5
    //   275: monitorexit
    //   276: goto +5 -> 281
    //   279: aload_2
    //   280: athrow
    //   281: goto -2 -> 279
    // Local variable table:
    //   start	length	slot	name	signature
    //   135	29	0	i	int
    //   194	2	1	bool	boolean
    //   33	226	2	localObject1	Object
    //   272	8	2	localObject2	Object
    //   31	156	3	localObject3	Object
    //   214	51	3	localObject4	Object
    //   23	182	4	localObject5	Object
    //   218	16	4	localException	Exception
    //   3	271	5	localObject6	Object
    //   15	255	6	localArrayList	java.util.ArrayList
    //   87	89	7	localObject7	Object
    //   111	38	8	str	String
    // Exception table:
    //   from	to	target	type
    //   34	44	214	finally
    //   55	65	214	finally
    //   71	89	214	finally
    //   95	113	214	finally
    //   119	136	214	finally
    //   142	155	214	finally
    //   161	167	214	finally
    //   173	181	214	finally
    //   187	195	214	finally
    //   222	231	214	finally
    //   233	238	214	finally
    //   34	44	218	java/lang/Exception
    //   55	65	218	java/lang/Exception
    //   71	89	218	java/lang/Exception
    //   95	113	218	java/lang/Exception
    //   119	136	218	java/lang/Exception
    //   142	155	218	java/lang/Exception
    //   161	167	218	java/lang/Exception
    //   173	181	218	java/lang/Exception
    //   187	195	218	java/lang/Exception
    //   8	25	272	finally
    //   204	211	272	finally
    //   242	248	272	finally
    //   248	251	272	finally
    //   258	264	272	finally
    //   264	266	272	finally
    //   266	269	272	finally
    //   273	276	272	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.table.c
 * JD-Core Version:    0.7.0.1
 */