package com.tencent.tmdownloader.internal.storage.table;

import java.util.List;
import java.util.Map;

public class a
{
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 14	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   6: astore_0
    //   7: aload_0
    //   8: ifnonnull +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 14	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   18: invokevirtual 20	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore_0
    //   22: aload_0
    //   23: ifnull -12 -> 11
    //   26: aload_0
    //   27: ldc 22
    //   29: ldc 24
    //   31: iconst_1
    //   32: anewarray 26	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc 28
    //   39: aastore
    //   40: invokevirtual 34	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   43: pop
    //   44: goto -33 -> 11
    //   47: astore_0
    //   48: aload_0
    //   49: invokevirtual 37	java/lang/Exception:printStackTrace	()V
    //   52: goto -41 -> 11
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   6	21	0	localObject1	Object
    //   47	2	0	localException	java.lang.Exception
    //   55	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	44	47	java/lang/Exception
    //   3	7	55	finally
    //   15	22	55	finally
    //   26	44	55	finally
    //   48	52	55	finally
  }
  
  /* Error */
  public static void a(String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 41
    //   5: new 43	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   12: ldc 48
    //   14: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokestatic 58	com/tencent/tmassistantbase/util/t:e	()Ljava/lang/String;
    //   20: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: ldc 60
    //   25: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_0
    //   29: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: ldc 62
    //   34: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   41: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 73	com/tencent/tmassistantbase/util/ac:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload_1
    //   48: invokeinterface 79 1 0
    //   53: istore_2
    //   54: aload_0
    //   55: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   58: ifne +17 -> 75
    //   61: iload_2
    //   62: ifeq +13 -> 75
    //   65: invokestatic 14	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   68: astore 5
    //   70: aload 5
    //   72: ifnonnull +7 -> 79
    //   75: ldc 2
    //   77: monitorexit
    //   78: return
    //   79: iload_2
    //   80: bipush 20
    //   82: if_icmpgt +134 -> 216
    //   85: invokestatic 14	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   88: invokevirtual 20	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   91: astore 5
    //   93: aload 5
    //   95: ifnull -20 -> 75
    //   98: aload 5
    //   100: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   103: ifne +15 -> 118
    //   106: aload 5
    //   108: invokevirtual 92	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   111: istore 4
    //   113: iload 4
    //   115: ifeq +9 -> 124
    //   118: ldc2_w 93
    //   121: invokestatic 100	java/lang/Thread:sleep	(J)V
    //   124: aload 5
    //   126: invokevirtual 103	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   129: new 105	android/content/ContentValues
    //   132: dup
    //   133: invokespecial 106	android/content/ContentValues:<init>	()V
    //   136: astore 6
    //   138: iconst_0
    //   139: istore_3
    //   140: iload_3
    //   141: iload_2
    //   142: if_icmpge +96 -> 238
    //   145: aload_1
    //   146: iload_3
    //   147: invokeinterface 110 2 0
    //   152: checkcast 26	java/lang/String
    //   155: astore 7
    //   157: aload 7
    //   159: ifnull +45 -> 204
    //   162: aload 6
    //   164: ldc 112
    //   166: ldc 28
    //   168: invokevirtual 115	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   171: aload 6
    //   173: ldc 117
    //   175: aload_0
    //   176: invokevirtual 115	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   179: aload 6
    //   181: ldc 119
    //   183: aload 7
    //   185: ldc 121
    //   187: invokevirtual 125	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   190: invokevirtual 128	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   193: aload 5
    //   195: ldc 22
    //   197: aconst_null
    //   198: aload 6
    //   200: invokevirtual 132	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   203: pop2
    //   204: aload 6
    //   206: invokevirtual 135	android/content/ContentValues:clear	()V
    //   209: iload_3
    //   210: iconst_1
    //   211: iadd
    //   212: istore_3
    //   213: goto -73 -> 140
    //   216: bipush 20
    //   218: istore_2
    //   219: goto -134 -> 85
    //   222: astore 6
    //   224: aload 6
    //   226: invokevirtual 37	java/lang/Exception:printStackTrace	()V
    //   229: goto -105 -> 124
    //   232: astore_0
    //   233: ldc 2
    //   235: monitorexit
    //   236: aload_0
    //   237: athrow
    //   238: aload 5
    //   240: invokevirtual 138	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   243: aload 5
    //   245: ifnull -170 -> 75
    //   248: aload 5
    //   250: invokevirtual 141	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   253: istore 4
    //   255: iload 4
    //   257: ifeq -182 -> 75
    //   260: aload 5
    //   262: invokevirtual 144	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   265: goto -190 -> 75
    //   268: astore_0
    //   269: goto -194 -> 75
    //   272: astore_0
    //   273: aload 5
    //   275: ifnull -200 -> 75
    //   278: aload 5
    //   280: invokevirtual 141	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   283: istore 4
    //   285: iload 4
    //   287: ifeq -212 -> 75
    //   290: aload 5
    //   292: invokevirtual 144	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   295: goto -220 -> 75
    //   298: astore_0
    //   299: goto -224 -> 75
    //   302: astore_0
    //   303: aload 5
    //   305: ifnull +20 -> 325
    //   308: aload 5
    //   310: invokevirtual 141	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   313: istore 4
    //   315: iload 4
    //   317: ifeq +8 -> 325
    //   320: aload 5
    //   322: invokevirtual 144	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   325: aload_0
    //   326: athrow
    //   327: astore_1
    //   328: goto -3 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	331	0	paramString	String
    //   0	331	1	paramList	List<String>
    //   53	166	2	i	int
    //   139	74	3	j	int
    //   111	205	4	bool	boolean
    //   68	253	5	localObject	Object
    //   136	69	6	localContentValues	android.content.ContentValues
    //   222	3	6	localException	java.lang.Exception
    //   155	29	7	str	String
    // Exception table:
    //   from	to	target	type
    //   118	124	222	java/lang/Exception
    //   3	61	232	finally
    //   65	70	232	finally
    //   85	93	232	finally
    //   98	113	232	finally
    //   118	124	232	finally
    //   224	229	232	finally
    //   248	255	232	finally
    //   260	265	232	finally
    //   278	285	232	finally
    //   290	295	232	finally
    //   308	315	232	finally
    //   320	325	232	finally
    //   325	327	232	finally
    //   260	265	268	java/lang/Exception
    //   124	138	272	java/lang/Exception
    //   145	157	272	java/lang/Exception
    //   162	204	272	java/lang/Exception
    //   204	209	272	java/lang/Exception
    //   238	243	272	java/lang/Exception
    //   290	295	298	java/lang/Exception
    //   124	138	302	finally
    //   145	157	302	finally
    //   162	204	302	finally
    //   204	209	302	finally
    //   238	243	302	finally
    //   320	325	327	java/lang/Exception
  }
  
  /* Error */
  public static Map<Integer, List<String>> b()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 150	java/util/concurrent/ConcurrentHashMap
    //   6: dup
    //   7: invokespecial 151	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   10: astore 6
    //   12: invokestatic 14	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnonnull +9 -> 26
    //   20: ldc 2
    //   22: monitorexit
    //   23: aload 6
    //   25: areturn
    //   26: invokestatic 14	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   29: invokevirtual 20	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: astore_2
    //   33: aload_2
    //   34: ldc 22
    //   36: iconst_2
    //   37: anewarray 26	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: ldc 117
    //   44: aastore
    //   45: dup
    //   46: iconst_1
    //   47: ldc 119
    //   49: aastore
    //   50: ldc 24
    //   52: iconst_1
    //   53: anewarray 26	java/lang/String
    //   56: dup
    //   57: iconst_0
    //   58: ldc 28
    //   60: aastore
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: invokevirtual 155	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   67: astore_3
    //   68: aload_3
    //   69: ifnull +143 -> 212
    //   72: aload_3
    //   73: astore_2
    //   74: aload_3
    //   75: invokeinterface 160 1 0
    //   80: ifeq +132 -> 212
    //   83: aload_3
    //   84: astore_2
    //   85: aload_3
    //   86: aload_3
    //   87: ldc 117
    //   89: invokeinterface 164 2 0
    //   94: invokeinterface 168 2 0
    //   99: invokestatic 174	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   102: invokevirtual 177	java/lang/Integer:intValue	()I
    //   105: istore_0
    //   106: aload_3
    //   107: astore_2
    //   108: new 26	java/lang/String
    //   111: dup
    //   112: aload_3
    //   113: aload_3
    //   114: ldc 119
    //   116: invokeinterface 164 2 0
    //   121: invokeinterface 181 2 0
    //   126: ldc 121
    //   128: invokespecial 184	java/lang/String:<init>	([BLjava/lang/String;)V
    //   131: astore 7
    //   133: aload_3
    //   134: astore_2
    //   135: aload 6
    //   137: iload_0
    //   138: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: invokeinterface 192 2 0
    //   146: checkcast 75	java/util/List
    //   149: astore 5
    //   151: aload 5
    //   153: astore 4
    //   155: aload 5
    //   157: ifnonnull +30 -> 187
    //   160: aload_3
    //   161: astore_2
    //   162: new 194	java/util/ArrayList
    //   165: dup
    //   166: invokespecial 195	java/util/ArrayList:<init>	()V
    //   169: astore 4
    //   171: aload_3
    //   172: astore_2
    //   173: aload 6
    //   175: iload_0
    //   176: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: aload 4
    //   181: invokeinterface 198 3 0
    //   186: pop
    //   187: aload_3
    //   188: astore_2
    //   189: aload 4
    //   191: aload 7
    //   193: invokeinterface 202 2 0
    //   198: pop
    //   199: aload_3
    //   200: astore_2
    //   201: aload_3
    //   202: invokeinterface 205 1 0
    //   207: istore_1
    //   208: iload_1
    //   209: ifne -126 -> 83
    //   212: aload_3
    //   213: ifnull +9 -> 222
    //   216: aload_3
    //   217: invokeinterface 208 1 0
    //   222: goto -202 -> 20
    //   225: astore 4
    //   227: aconst_null
    //   228: astore_3
    //   229: aload_3
    //   230: astore_2
    //   231: aload 4
    //   233: invokevirtual 37	java/lang/Exception:printStackTrace	()V
    //   236: aload_3
    //   237: ifnull -15 -> 222
    //   240: aload_3
    //   241: invokeinterface 208 1 0
    //   246: goto -24 -> 222
    //   249: astore_2
    //   250: ldc 2
    //   252: monitorexit
    //   253: aload_2
    //   254: athrow
    //   255: astore_3
    //   256: aconst_null
    //   257: astore_2
    //   258: aload_2
    //   259: ifnull +9 -> 268
    //   262: aload_2
    //   263: invokeinterface 208 1 0
    //   268: aload_3
    //   269: athrow
    //   270: astore_3
    //   271: goto -13 -> 258
    //   274: astore 4
    //   276: goto -47 -> 229
    // Local variable table:
    //   start	length	slot	name	signature
    //   105	71	0	i	int
    //   207	2	1	bool	boolean
    //   15	216	2	localObject1	Object
    //   249	5	2	localObject2	Object
    //   257	6	2	localObject3	Object
    //   67	174	3	localCursor	android.database.Cursor
    //   255	14	3	localObject4	Object
    //   270	1	3	localObject5	Object
    //   153	37	4	localObject6	Object
    //   225	7	4	localException1	java.lang.Exception
    //   274	1	4	localException2	java.lang.Exception
    //   149	7	5	localList	List
    //   10	164	6	localConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    //   131	61	7	str	String
    // Exception table:
    //   from	to	target	type
    //   33	68	225	java/lang/Exception
    //   3	16	249	finally
    //   26	33	249	finally
    //   216	222	249	finally
    //   240	246	249	finally
    //   262	268	249	finally
    //   268	270	249	finally
    //   33	68	255	finally
    //   74	83	270	finally
    //   85	106	270	finally
    //   108	133	270	finally
    //   135	151	270	finally
    //   162	171	270	finally
    //   173	187	270	finally
    //   189	199	270	finally
    //   201	208	270	finally
    //   231	236	270	finally
    //   74	83	274	java/lang/Exception
    //   85	106	274	java/lang/Exception
    //   108	133	274	java/lang/Exception
    //   135	151	274	java/lang/Exception
    //   162	171	274	java/lang/Exception
    //   173	187	274	java/lang/Exception
    //   189	199	274	java/lang/Exception
    //   201	208	274	java/lang/Exception
  }
  
  public static Map<Integer, List<String>> c()
  {
    try
    {
      Map localMap = b();
      a();
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.table.a
 * JD-Core Version:    0.7.0.1
 */