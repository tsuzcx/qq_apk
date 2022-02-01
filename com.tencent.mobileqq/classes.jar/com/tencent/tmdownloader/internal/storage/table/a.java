package com.tencent.tmdownloader.internal.storage.table;

import android.database.sqlite.SQLiteDatabase;
import com.tencent.tmassistant.common.a.d;
import java.util.List;
import java.util.Map;

public class a
{
  public static void a()
  {
    try
    {
      Object localObject1 = com.tencent.tmdownloader.internal.storage.a.a.c();
      if (localObject1 == null) {
        return;
      }
      localObject1 = com.tencent.tmdownloader.internal.storage.a.a.c().getWritableDatabase();
      if (localObject1 == null) {
        return;
      }
      try
      {
        ((SQLiteDatabase)localObject1).delete("reportInfo", "key = ?", new String[] { "report" });
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public static void a(String paramString, List<String> paramList)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 41	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 44	java/lang/StringBuilder:<init>	()V
    //   10: astore 5
    //   12: aload 5
    //   14: ldc 46
    //   16: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload 5
    //   22: invokestatic 56	com/tencent/tmassistantbase/util/s:e	()Ljava/lang/String;
    //   25: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload 5
    //   31: ldc 58
    //   33: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 5
    //   39: aload_0
    //   40: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 5
    //   46: ldc 60
    //   48: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 5
    //   54: aload_1
    //   55: invokevirtual 63	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc 65
    //   61: aload 5
    //   63: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 73	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_1
    //   70: invokeinterface 79 1 0
    //   75: istore_2
    //   76: aload_0
    //   77: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   80: ifne +240 -> 320
    //   83: iload_2
    //   84: ifeq +236 -> 320
    //   87: invokestatic 14	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   90: ifnonnull +258 -> 348
    //   93: goto +227 -> 320
    //   96: invokestatic 14	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   99: invokevirtual 20	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   102: astore 5
    //   104: aload 5
    //   106: ifnonnull +7 -> 113
    //   109: ldc 2
    //   111: monitorexit
    //   112: return
    //   113: aload 5
    //   115: invokevirtual 89	android/database/sqlite/SQLiteDatabase:isDbLockedByOtherThreads	()Z
    //   118: ifne +15 -> 133
    //   121: aload 5
    //   123: invokevirtual 92	android/database/sqlite/SQLiteDatabase:isDbLockedByCurrentThread	()Z
    //   126: istore 4
    //   128: iload 4
    //   130: ifeq +19 -> 149
    //   133: ldc2_w 93
    //   136: invokestatic 100	java/lang/Thread:sleep	(J)V
    //   139: goto +10 -> 149
    //   142: astore 6
    //   144: aload 6
    //   146: invokevirtual 37	java/lang/Exception:printStackTrace	()V
    //   149: aload 5
    //   151: invokevirtual 103	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   154: new 105	android/content/ContentValues
    //   157: dup
    //   158: invokespecial 106	android/content/ContentValues:<init>	()V
    //   161: astore 6
    //   163: iconst_0
    //   164: istore_3
    //   165: iload_3
    //   166: iload_2
    //   167: if_icmpge +74 -> 241
    //   170: aload_1
    //   171: iload_3
    //   172: invokeinterface 110 2 0
    //   177: checkcast 26	java/lang/String
    //   180: astore 7
    //   182: aload 7
    //   184: ifnull +45 -> 229
    //   187: aload 6
    //   189: ldc 112
    //   191: ldc 28
    //   193: invokevirtual 115	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload 6
    //   198: ldc 117
    //   200: aload_0
    //   201: invokevirtual 115	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   204: aload 6
    //   206: ldc 119
    //   208: aload 7
    //   210: ldc 121
    //   212: invokevirtual 125	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   215: invokevirtual 128	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   218: aload 5
    //   220: ldc 22
    //   222: aconst_null
    //   223: aload 6
    //   225: invokevirtual 132	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   228: pop2
    //   229: aload 6
    //   231: invokevirtual 135	android/content/ContentValues:clear	()V
    //   234: iload_3
    //   235: iconst_1
    //   236: iadd
    //   237: istore_3
    //   238: goto -73 -> 165
    //   241: aload 5
    //   243: invokevirtual 138	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   246: aload 5
    //   248: ifnull +68 -> 316
    //   251: aload 5
    //   253: invokevirtual 141	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   256: istore 4
    //   258: iload 4
    //   260: ifeq +56 -> 316
    //   263: aload 5
    //   265: invokevirtual 144	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   268: goto +48 -> 316
    //   271: astore_0
    //   272: aload 5
    //   274: ifnull +20 -> 294
    //   277: aload 5
    //   279: invokevirtual 141	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   282: istore 4
    //   284: iload 4
    //   286: ifeq +8 -> 294
    //   289: aload 5
    //   291: invokevirtual 144	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   294: aload_0
    //   295: athrow
    //   296: aload 5
    //   298: ifnull +18 -> 316
    //   301: aload 5
    //   303: invokevirtual 141	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   306: istore 4
    //   308: iload 4
    //   310: ifeq +6 -> 316
    //   313: goto -50 -> 263
    //   316: ldc 2
    //   318: monitorexit
    //   319: return
    //   320: ldc 2
    //   322: monitorexit
    //   323: return
    //   324: astore_0
    //   325: ldc 2
    //   327: monitorexit
    //   328: goto +5 -> 333
    //   331: aload_0
    //   332: athrow
    //   333: goto -2 -> 331
    //   336: astore_0
    //   337: goto -41 -> 296
    //   340: astore_0
    //   341: goto -25 -> 316
    //   344: astore_1
    //   345: goto -51 -> 294
    //   348: iload_2
    //   349: bipush 20
    //   351: if_icmpgt +6 -> 357
    //   354: goto -258 -> 96
    //   357: bipush 20
    //   359: istore_2
    //   360: goto -264 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	paramString	String
    //   0	363	1	paramList	List<String>
    //   75	285	2	i	int
    //   164	74	3	j	int
    //   126	183	4	bool	boolean
    //   10	292	5	localObject	Object
    //   142	3	6	localException	Exception
    //   161	69	6	localContentValues	android.content.ContentValues
    //   180	29	7	str	String
    // Exception table:
    //   from	to	target	type
    //   133	139	142	java/lang/Exception
    //   149	163	271	finally
    //   170	182	271	finally
    //   187	229	271	finally
    //   229	234	271	finally
    //   241	246	271	finally
    //   3	83	324	finally
    //   87	93	324	finally
    //   96	104	324	finally
    //   113	128	324	finally
    //   133	139	324	finally
    //   144	149	324	finally
    //   251	258	324	finally
    //   263	268	324	finally
    //   277	284	324	finally
    //   289	294	324	finally
    //   294	296	324	finally
    //   301	308	324	finally
    //   149	163	336	java/lang/Exception
    //   170	182	336	java/lang/Exception
    //   187	229	336	java/lang/Exception
    //   229	234	336	java/lang/Exception
    //   241	246	336	java/lang/Exception
    //   263	268	340	java/lang/Exception
    //   289	294	344	java/lang/Exception
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
    //   10: astore 7
    //   12: invokestatic 14	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   15: astore_2
    //   16: aload_2
    //   17: ifnonnull +9 -> 26
    //   20: ldc 2
    //   22: monitorexit
    //   23: aload 7
    //   25: areturn
    //   26: invokestatic 14	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   29: invokevirtual 20	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   32: astore 4
    //   34: aconst_null
    //   35: astore_2
    //   36: aconst_null
    //   37: astore_3
    //   38: aload 4
    //   40: ldc 22
    //   42: iconst_2
    //   43: anewarray 26	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: ldc 117
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: ldc 119
    //   55: aastore
    //   56: ldc 24
    //   58: iconst_1
    //   59: anewarray 26	java/lang/String
    //   62: dup
    //   63: iconst_0
    //   64: ldc 28
    //   66: aastore
    //   67: aconst_null
    //   68: aconst_null
    //   69: aconst_null
    //   70: invokevirtual 155	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   73: astore 4
    //   75: aload 4
    //   77: ifnull +181 -> 258
    //   80: aload 4
    //   82: astore_3
    //   83: aload 4
    //   85: astore_2
    //   86: aload 4
    //   88: invokeinterface 160 1 0
    //   93: ifeq +165 -> 258
    //   96: aload 4
    //   98: astore_3
    //   99: aload 4
    //   101: astore_2
    //   102: aload 4
    //   104: aload 4
    //   106: ldc 117
    //   108: invokeinterface 164 2 0
    //   113: invokeinterface 168 2 0
    //   118: invokestatic 174	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   121: invokevirtual 177	java/lang/Integer:intValue	()I
    //   124: istore_0
    //   125: aload 4
    //   127: astore_3
    //   128: aload 4
    //   130: astore_2
    //   131: new 26	java/lang/String
    //   134: dup
    //   135: aload 4
    //   137: aload 4
    //   139: ldc 119
    //   141: invokeinterface 164 2 0
    //   146: invokeinterface 181 2 0
    //   151: ldc 121
    //   153: invokespecial 184	java/lang/String:<init>	([BLjava/lang/String;)V
    //   156: astore 8
    //   158: aload 4
    //   160: astore_3
    //   161: aload 4
    //   163: astore_2
    //   164: aload 7
    //   166: iload_0
    //   167: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: invokeinterface 192 2 0
    //   175: checkcast 75	java/util/List
    //   178: astore 6
    //   180: aload 6
    //   182: astore 5
    //   184: aload 6
    //   186: ifnonnull +38 -> 224
    //   189: aload 4
    //   191: astore_3
    //   192: aload 4
    //   194: astore_2
    //   195: new 194	java/util/ArrayList
    //   198: dup
    //   199: invokespecial 195	java/util/ArrayList:<init>	()V
    //   202: astore 5
    //   204: aload 4
    //   206: astore_3
    //   207: aload 4
    //   209: astore_2
    //   210: aload 7
    //   212: iload_0
    //   213: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: aload 5
    //   218: invokeinterface 198 3 0
    //   223: pop
    //   224: aload 4
    //   226: astore_3
    //   227: aload 4
    //   229: astore_2
    //   230: aload 5
    //   232: aload 8
    //   234: invokeinterface 202 2 0
    //   239: pop
    //   240: aload 4
    //   242: astore_3
    //   243: aload 4
    //   245: astore_2
    //   246: aload 4
    //   248: invokeinterface 205 1 0
    //   253: istore_1
    //   254: iload_1
    //   255: ifne -159 -> 96
    //   258: aload 4
    //   260: ifnull +35 -> 295
    //   263: aload 4
    //   265: astore_2
    //   266: aload_2
    //   267: invokeinterface 208 1 0
    //   272: goto +23 -> 295
    //   275: astore_2
    //   276: goto +25 -> 301
    //   279: astore 4
    //   281: aload_2
    //   282: astore_3
    //   283: aload 4
    //   285: invokevirtual 37	java/lang/Exception:printStackTrace	()V
    //   288: aload_2
    //   289: ifnull +6 -> 295
    //   292: goto -26 -> 266
    //   295: ldc 2
    //   297: monitorexit
    //   298: aload 7
    //   300: areturn
    //   301: aload_3
    //   302: ifnull +9 -> 311
    //   305: aload_3
    //   306: invokeinterface 208 1 0
    //   311: aload_2
    //   312: athrow
    //   313: astore_2
    //   314: ldc 2
    //   316: monitorexit
    //   317: goto +5 -> 322
    //   320: aload_2
    //   321: athrow
    //   322: goto -2 -> 320
    // Local variable table:
    //   start	length	slot	name	signature
    //   124	89	0	i	int
    //   253	2	1	bool	boolean
    //   15	252	2	localObject1	Object
    //   275	37	2	localObject2	Object
    //   313	8	2	localObject3	Object
    //   37	269	3	localObject4	Object
    //   32	232	4	localObject5	Object
    //   279	5	4	localException	Exception
    //   182	49	5	localObject6	Object
    //   178	7	6	localList	List
    //   10	289	7	localConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    //   156	77	8	str	String
    // Exception table:
    //   from	to	target	type
    //   38	75	275	finally
    //   86	96	275	finally
    //   102	125	275	finally
    //   131	158	275	finally
    //   164	180	275	finally
    //   195	204	275	finally
    //   210	224	275	finally
    //   230	240	275	finally
    //   246	254	275	finally
    //   283	288	275	finally
    //   38	75	279	java/lang/Exception
    //   86	96	279	java/lang/Exception
    //   102	125	279	java/lang/Exception
    //   131	158	279	java/lang/Exception
    //   164	180	279	java/lang/Exception
    //   195	204	279	java/lang/Exception
    //   210	224	279	java/lang/Exception
    //   230	240	279	java/lang/Exception
    //   246	254	279	java/lang/Exception
    //   3	16	313	finally
    //   26	34	313	finally
    //   266	272	313	finally
    //   305	311	313	finally
    //   311	313	313	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.table.a
 * JD-Core Version:    0.7.0.1
 */