package com.tencent.tmdownloader.internal.storage.table;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.tmassistant.common.a.c;
import com.tencent.tmassistant.common.a.d;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmdownloader.internal.storage.a.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class e
  implements c
{
  private final Map<String, String> a = new ConcurrentHashMap();
  private final Map<String, byte[]> b = new ConcurrentHashMap();
  
  /* Error */
  private void a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   6: ifeq +13 -> 19
    //   9: ldc 40
    //   11: ldc 42
    //   13: invokestatic 48	com/tencent/tmassistantbase/util/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: return
    //   19: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   22: lstore 5
    //   24: aload_0
    //   25: getfield 20	com/tencent/tmdownloader/internal/storage/table/e:a	Ljava/util/Map;
    //   28: aload_1
    //   29: aload_2
    //   30: invokeinterface 60 3 0
    //   35: pop
    //   36: aload_3
    //   37: ifnull +20 -> 57
    //   40: aload_3
    //   41: arraylength
    //   42: ifle +15 -> 57
    //   45: aload_0
    //   46: getfield 22	com/tencent/tmdownloader/internal/storage/table/e:b	Ljava/util/Map;
    //   49: aload_1
    //   50: aload_3
    //   51: invokeinterface 60 3 0
    //   56: pop
    //   57: invokestatic 66	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   60: astore 10
    //   62: aload 10
    //   64: ifnonnull +13 -> 77
    //   67: ldc 40
    //   69: ldc 68
    //   71: invokestatic 48	com/tencent/tmassistantbase/util/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: aload 10
    //   79: invokevirtual 74	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   82: astore 10
    //   84: aload 10
    //   86: ifnonnull +13 -> 99
    //   89: ldc 40
    //   91: ldc 76
    //   93: invokestatic 48	com/tencent/tmassistantbase/util/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   96: aload_0
    //   97: monitorexit
    //   98: return
    //   99: aload 10
    //   101: invokevirtual 81	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   104: new 83	android/content/ContentValues
    //   107: dup
    //   108: invokespecial 84	android/content/ContentValues:<init>	()V
    //   111: astore 11
    //   113: aload 11
    //   115: ldc 86
    //   117: aload_1
    //   118: invokevirtual 88	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload 11
    //   123: ldc 90
    //   125: aload_2
    //   126: invokevirtual 88	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload 11
    //   131: ldc 92
    //   133: aload_3
    //   134: invokevirtual 95	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   137: aload 10
    //   139: ldc 97
    //   141: ldc 99
    //   143: iconst_1
    //   144: anewarray 101	java/lang/String
    //   147: dup
    //   148: iconst_0
    //   149: aload_1
    //   150: aastore
    //   151: invokevirtual 105	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   154: istore 4
    //   156: aload 10
    //   158: ldc 97
    //   160: aconst_null
    //   161: aload 11
    //   163: invokevirtual 109	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   166: lstore 7
    //   168: new 111	java/lang/StringBuilder
    //   171: dup
    //   172: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   175: astore_1
    //   176: aload_1
    //   177: ldc 114
    //   179: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload_1
    //   184: iload 4
    //   186: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload_1
    //   191: ldc 123
    //   193: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload_1
    //   198: lload 7
    //   200: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   203: pop
    //   204: ldc 40
    //   206: aload_1
    //   207: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 132	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload 11
    //   215: invokevirtual 135	android/content/ContentValues:clear	()V
    //   218: aload 10
    //   220: invokevirtual 138	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   223: aload 10
    //   225: invokevirtual 142	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   228: ifeq +102 -> 330
    //   231: aload 10
    //   233: invokevirtual 145	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   236: istore 9
    //   238: iload 9
    //   240: ifeq +90 -> 330
    //   243: aload 10
    //   245: invokevirtual 148	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   248: goto +82 -> 330
    //   251: ldc 40
    //   253: ldc 150
    //   255: invokestatic 48	com/tencent/tmassistantbase/util/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: goto +72 -> 330
    //   261: astore_1
    //   262: goto +113 -> 375
    //   265: astore_1
    //   266: new 111	java/lang/StringBuilder
    //   269: dup
    //   270: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   273: astore_2
    //   274: aload_2
    //   275: ldc 152
    //   277: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload_2
    //   282: aload_1
    //   283: invokevirtual 155	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   286: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: ldc 40
    //   292: aload_2
    //   293: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   296: invokestatic 132	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   299: aload 10
    //   301: invokevirtual 142	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   304: ifeq +26 -> 330
    //   307: aload 10
    //   309: invokevirtual 145	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   312: istore 9
    //   314: iload 9
    //   316: ifeq +14 -> 330
    //   319: aload 10
    //   321: invokevirtual 148	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   324: goto +6 -> 330
    //   327: goto -76 -> 251
    //   330: new 111	java/lang/StringBuilder
    //   333: dup
    //   334: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   337: astore_1
    //   338: aload_1
    //   339: ldc 157
    //   341: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_1
    //   346: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   349: lload 5
    //   351: lsub
    //   352: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload_1
    //   357: ldc 159
    //   359: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: ldc 40
    //   365: aload_1
    //   366: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 132	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload_0
    //   373: monitorexit
    //   374: return
    //   375: aload 10
    //   377: invokevirtual 142	android/database/sqlite/SQLiteDatabase:isOpen	()Z
    //   380: ifeq +30 -> 410
    //   383: aload 10
    //   385: invokevirtual 145	android/database/sqlite/SQLiteDatabase:inTransaction	()Z
    //   388: istore 9
    //   390: iload 9
    //   392: ifeq +18 -> 410
    //   395: aload 10
    //   397: invokevirtual 148	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   400: goto +10 -> 410
    //   403: ldc 40
    //   405: ldc 150
    //   407: invokestatic 48	com/tencent/tmassistantbase/util/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: aload_1
    //   411: athrow
    //   412: astore_1
    //   413: aload_0
    //   414: monitorexit
    //   415: goto +5 -> 420
    //   418: aload_1
    //   419: athrow
    //   420: goto -2 -> 418
    //   423: astore_1
    //   424: goto -173 -> 251
    //   427: astore_1
    //   428: goto -101 -> 327
    //   431: astore_2
    //   432: goto -29 -> 403
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	435	0	this	e
    //   0	435	1	paramString1	String
    //   0	435	2	paramString2	String
    //   0	435	3	paramArrayOfByte	byte[]
    //   154	31	4	i	int
    //   22	328	5	l1	long
    //   166	33	7	l2	long
    //   236	155	9	bool	boolean
    //   60	336	10	localObject	Object
    //   111	103	11	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   99	223	261	finally
    //   266	299	261	finally
    //   99	223	265	java/lang/Exception
    //   2	16	412	finally
    //   19	36	412	finally
    //   40	57	412	finally
    //   57	62	412	finally
    //   67	74	412	finally
    //   77	84	412	finally
    //   89	96	412	finally
    //   223	238	412	finally
    //   243	248	412	finally
    //   251	258	412	finally
    //   299	314	412	finally
    //   319	324	412	finally
    //   330	372	412	finally
    //   375	390	412	finally
    //   395	400	412	finally
    //   403	410	412	finally
    //   410	412	412	finally
    //   243	248	423	java/lang/Exception
    //   319	324	427	java/lang/Exception
    //   395	400	431	java/lang/Exception
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 40
    //   4: ldc 161
    //   6: invokestatic 132	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: invokestatic 66	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   12: astore_2
    //   13: aload_2
    //   14: ifnonnull +13 -> 27
    //   17: ldc 40
    //   19: ldc 163
    //   21: invokestatic 48	com/tencent/tmassistantbase/util/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: aload_2
    //   28: invokevirtual 74	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   31: astore 4
    //   33: aload 4
    //   35: ifnonnull +13 -> 48
    //   38: ldc 40
    //   40: ldc 165
    //   42: invokestatic 48	com/tencent/tmassistantbase/util/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: aconst_null
    //   49: astore_2
    //   50: aconst_null
    //   51: astore_3
    //   52: aload 4
    //   54: ldc 167
    //   56: aconst_null
    //   57: invokevirtual 171	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   60: astore 4
    //   62: aload 4
    //   64: ifnull +280 -> 344
    //   67: aload 4
    //   69: astore_3
    //   70: aload 4
    //   72: astore_2
    //   73: aload 4
    //   75: invokeinterface 176 1 0
    //   80: ifeq +264 -> 344
    //   83: aload 4
    //   85: astore_3
    //   86: aload 4
    //   88: astore_2
    //   89: aload 4
    //   91: aload 4
    //   93: ldc 86
    //   95: invokeinterface 180 2 0
    //   100: invokeinterface 184 2 0
    //   105: astore 5
    //   107: aload 4
    //   109: astore_3
    //   110: aload 4
    //   112: astore_2
    //   113: aload 4
    //   115: aload 4
    //   117: ldc 90
    //   119: invokeinterface 180 2 0
    //   124: invokeinterface 184 2 0
    //   129: astore 6
    //   131: aload 4
    //   133: astore_3
    //   134: aload 4
    //   136: astore_2
    //   137: aload 4
    //   139: aload 4
    //   141: ldc 92
    //   143: invokeinterface 180 2 0
    //   148: invokeinterface 188 2 0
    //   153: astore 7
    //   155: aload 4
    //   157: astore_3
    //   158: new 111	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   165: astore_2
    //   166: aload 4
    //   168: astore_3
    //   169: aload_2
    //   170: ldc 190
    //   172: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: pop
    //   176: aload 4
    //   178: astore_3
    //   179: aload_2
    //   180: aload 5
    //   182: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: aload 4
    //   188: astore_3
    //   189: aload_2
    //   190: ldc 192
    //   192: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: aload 4
    //   198: astore_3
    //   199: aload_2
    //   200: aload 6
    //   202: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 4
    //   208: astore_3
    //   209: aload_2
    //   210: ldc 194
    //   212: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: pop
    //   216: aload 4
    //   218: astore_3
    //   219: aload_2
    //   220: aload 7
    //   222: arraylength
    //   223: invokevirtual 121	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 4
    //   229: astore_3
    //   230: ldc 40
    //   232: aload_2
    //   233: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 132	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   239: goto +16 -> 255
    //   242: astore 8
    //   244: aload 4
    //   246: astore_3
    //   247: aload 4
    //   249: astore_2
    //   250: aload 8
    //   252: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   255: aload 4
    //   257: astore_3
    //   258: aload 4
    //   260: astore_2
    //   261: aload 6
    //   263: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   266: ifne +23 -> 289
    //   269: aload 4
    //   271: astore_3
    //   272: aload 4
    //   274: astore_2
    //   275: aload_0
    //   276: getfield 20	com/tencent/tmdownloader/internal/storage/table/e:a	Ljava/util/Map;
    //   279: aload 5
    //   281: aload 6
    //   283: invokeinterface 60 3 0
    //   288: pop
    //   289: aload 7
    //   291: ifnull +35 -> 326
    //   294: aload 4
    //   296: astore_3
    //   297: aload 4
    //   299: astore_2
    //   300: aload 7
    //   302: arraylength
    //   303: ifle +23 -> 326
    //   306: aload 4
    //   308: astore_3
    //   309: aload 4
    //   311: astore_2
    //   312: aload_0
    //   313: getfield 22	com/tencent/tmdownloader/internal/storage/table/e:b	Ljava/util/Map;
    //   316: aload 5
    //   318: aload 7
    //   320: invokeinterface 60 3 0
    //   325: pop
    //   326: aload 4
    //   328: astore_3
    //   329: aload 4
    //   331: astore_2
    //   332: aload 4
    //   334: invokeinterface 200 1 0
    //   339: istore_1
    //   340: iload_1
    //   341: ifne -258 -> 83
    //   344: aload 4
    //   346: ifnull +46 -> 392
    //   349: aload 4
    //   351: astore_2
    //   352: aload_2
    //   353: invokeinterface 203 1 0
    //   358: goto +34 -> 392
    //   361: astore_2
    //   362: goto +33 -> 395
    //   365: astore 4
    //   367: aload_2
    //   368: astore_3
    //   369: ldc 40
    //   371: ldc 205
    //   373: aload 4
    //   375: invokestatic 208	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   378: aload_2
    //   379: astore_3
    //   380: aload 4
    //   382: invokevirtual 197	java/lang/Exception:printStackTrace	()V
    //   385: aload_2
    //   386: ifnull +6 -> 392
    //   389: goto -37 -> 352
    //   392: aload_0
    //   393: monitorexit
    //   394: return
    //   395: aload_3
    //   396: ifnull +9 -> 405
    //   399: aload_3
    //   400: invokeinterface 203 1 0
    //   405: aload_2
    //   406: athrow
    //   407: astore_2
    //   408: aload_0
    //   409: monitorexit
    //   410: goto +5 -> 415
    //   413: aload_2
    //   414: athrow
    //   415: goto -2 -> 413
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	418	0	this	e
    //   339	2	1	bool	boolean
    //   12	341	2	localObject1	Object
    //   361	45	2	localObject2	Object
    //   407	7	2	localObject3	Object
    //   51	349	3	localObject4	Object
    //   31	319	4	localObject5	Object
    //   365	16	4	localException1	Exception
    //   105	212	5	str1	String
    //   129	153	6	str2	String
    //   153	166	7	arrayOfByte	byte[]
    //   242	9	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   158	166	242	java/lang/Exception
    //   169	176	242	java/lang/Exception
    //   179	186	242	java/lang/Exception
    //   189	196	242	java/lang/Exception
    //   199	206	242	java/lang/Exception
    //   209	216	242	java/lang/Exception
    //   219	227	242	java/lang/Exception
    //   230	239	242	java/lang/Exception
    //   52	62	361	finally
    //   73	83	361	finally
    //   89	107	361	finally
    //   113	131	361	finally
    //   137	155	361	finally
    //   158	166	361	finally
    //   169	176	361	finally
    //   179	186	361	finally
    //   189	196	361	finally
    //   199	206	361	finally
    //   209	216	361	finally
    //   219	227	361	finally
    //   230	239	361	finally
    //   250	255	361	finally
    //   261	269	361	finally
    //   275	289	361	finally
    //   300	306	361	finally
    //   312	326	361	finally
    //   332	340	361	finally
    //   369	378	361	finally
    //   380	385	361	finally
    //   52	62	365	java/lang/Exception
    //   73	83	365	java/lang/Exception
    //   89	107	365	java/lang/Exception
    //   113	131	365	java/lang/Exception
    //   137	155	365	java/lang/Exception
    //   250	255	365	java/lang/Exception
    //   261	269	365	java/lang/Exception
    //   275	289	365	java/lang/Exception
    //   300	306	365	java/lang/Exception
    //   312	326	365	java/lang/Exception
    //   332	340	365	java/lang/Exception
    //   2	13	407	finally
    //   17	24	407	finally
    //   27	33	407	finally
    //   38	45	407	finally
    //   352	358	407	finally
    //   399	405	407	finally
    //   405	407	407	finally
  }
  
  /* Error */
  private String f(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/tmdownloader/internal/storage/table/e:a	Ljava/util/Map;
    //   4: aload_1
    //   5: invokeinterface 214 2 0
    //   10: ifeq +79 -> 89
    //   13: aload_0
    //   14: getfield 20	com/tencent/tmdownloader/internal/storage/table/e:a	Ljava/util/Map;
    //   17: aload_1
    //   18: invokeinterface 218 2 0
    //   23: checkcast 101	java/lang/String
    //   26: astore 5
    //   28: new 111	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   35: astore 6
    //   37: aload 6
    //   39: ldc 220
    //   41: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 6
    //   47: aload_1
    //   48: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload 6
    //   54: ldc 222
    //   56: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 6
    //   62: aload 5
    //   64: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 6
    //   70: ldc 224
    //   72: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: pop
    //   76: ldc 40
    //   78: aload 6
    //   80: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: invokestatic 132	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload 5
    //   88: areturn
    //   89: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   92: lstore_2
    //   93: aload_0
    //   94: monitorenter
    //   95: aload_1
    //   96: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   99: istore 4
    //   101: ldc 226
    //   103: astore 8
    //   105: aload 8
    //   107: astore 7
    //   109: iload 4
    //   111: ifne +200 -> 311
    //   114: invokestatic 66	com/tencent/tmdownloader/internal/storage/a/a:c	()Lcom/tencent/tmassistant/common/a/d;
    //   117: astore 5
    //   119: aload 5
    //   121: ifnonnull +15 -> 136
    //   124: ldc 40
    //   126: ldc 228
    //   128: invokestatic 48	com/tencent/tmassistantbase/util/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: monitorexit
    //   133: ldc 226
    //   135: areturn
    //   136: aload 5
    //   138: invokevirtual 74	com/tencent/tmassistant/common/a/d:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   141: astore 5
    //   143: aload 5
    //   145: ifnonnull +15 -> 160
    //   148: ldc 40
    //   150: ldc 230
    //   152: invokestatic 48	com/tencent/tmassistantbase/util/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_0
    //   156: monitorexit
    //   157: ldc 226
    //   159: areturn
    //   160: aconst_null
    //   161: astore 7
    //   163: aconst_null
    //   164: astore 9
    //   166: aload 5
    //   168: ldc 232
    //   170: iconst_1
    //   171: anewarray 101	java/lang/String
    //   174: dup
    //   175: iconst_0
    //   176: aload_1
    //   177: aastore
    //   178: invokevirtual 171	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   181: astore 5
    //   183: aload 8
    //   185: astore 6
    //   187: aload 5
    //   189: ifnull +82 -> 271
    //   192: aload 8
    //   194: astore 6
    //   196: aload 5
    //   198: astore 9
    //   200: aload 5
    //   202: astore 7
    //   204: aload 5
    //   206: invokeinterface 176 1 0
    //   211: ifeq +60 -> 271
    //   214: aload 5
    //   216: astore 9
    //   218: aload 5
    //   220: astore 7
    //   222: aload 5
    //   224: aload 5
    //   226: ldc 90
    //   228: invokeinterface 180 2 0
    //   233: invokeinterface 184 2 0
    //   238: astore 6
    //   240: aload 6
    //   242: ifnull +29 -> 271
    //   245: aload 5
    //   247: astore 9
    //   249: aload_0
    //   250: getfield 20	com/tencent/tmdownloader/internal/storage/table/e:a	Ljava/util/Map;
    //   253: aload_1
    //   254: aload 6
    //   256: invokeinterface 60 3 0
    //   261: pop
    //   262: goto +9 -> 271
    //   265: aload 6
    //   267: astore_1
    //   268: goto +115 -> 383
    //   271: aload 6
    //   273: astore 7
    //   275: aload 5
    //   277: ifnull +34 -> 311
    //   280: aload 6
    //   282: astore_1
    //   283: aload 5
    //   285: invokeinterface 203 1 0
    //   290: aload_1
    //   291: astore 7
    //   293: goto +18 -> 311
    //   296: astore_1
    //   297: aload 9
    //   299: ifnull +10 -> 309
    //   302: aload 9
    //   304: invokeinterface 203 1 0
    //   309: aload_1
    //   310: athrow
    //   311: aload_0
    //   312: monitorexit
    //   313: new 111	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 112	java/lang/StringBuilder:<init>	()V
    //   320: astore_1
    //   321: aload_1
    //   322: ldc 234
    //   324: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: pop
    //   328: aload_1
    //   329: invokestatic 54	java/lang/System:currentTimeMillis	()J
    //   332: lload_2
    //   333: lsub
    //   334: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_1
    //   339: ldc 159
    //   341: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: ldc 40
    //   347: aload_1
    //   348: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 132	com/tencent/tmassistantbase/util/ab:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   354: aload 7
    //   356: areturn
    //   357: astore_1
    //   358: aload_0
    //   359: monitorexit
    //   360: goto +5 -> 365
    //   363: aload_1
    //   364: athrow
    //   365: goto -2 -> 363
    //   368: astore_1
    //   369: aload 8
    //   371: astore_1
    //   372: aload 7
    //   374: astore 5
    //   376: goto +7 -> 383
    //   379: astore_1
    //   380: goto -115 -> 265
    //   383: aload_1
    //   384: astore 7
    //   386: aload 5
    //   388: ifnull -77 -> 311
    //   391: goto -108 -> 283
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	394	0	this	e
    //   0	394	1	paramString	String
    //   92	241	2	l	long
    //   99	11	4	bool	boolean
    //   26	361	5	localObject1	Object
    //   35	246	6	localObject2	Object
    //   107	278	7	localObject3	Object
    //   103	267	8	str	String
    //   164	139	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   166	183	296	finally
    //   204	214	296	finally
    //   222	240	296	finally
    //   249	262	296	finally
    //   95	101	357	finally
    //   114	119	357	finally
    //   124	133	357	finally
    //   136	143	357	finally
    //   148	157	357	finally
    //   283	290	357	finally
    //   302	309	357	finally
    //   309	311	357	finally
    //   311	313	357	finally
    //   358	360	357	finally
    //   166	183	368	java/lang/Exception
    //   204	214	368	java/lang/Exception
    //   222	240	368	java/lang/Exception
    //   249	262	379	java/lang/Exception
  }
  
  public void a()
  {
    if (s.a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<SettingTable> init begin, process ");
      localStringBuilder.append(s.e());
      ab.c("SettingTable", localStringBuilder.toString());
      com.tencent.tmassistantbase.util.k.a().postDelayed(new f(this), 1000L);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<setInt>key=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", value=");
    localStringBuilder.append(String.valueOf(paramInt));
    localStringBuilder.append(", process:");
    localStringBuilder.append(s.e());
    ab.c("SettingTable", localStringBuilder.toString());
    com.tencent.tmassistantbase.util.k.a().post(new g(this, paramString, paramInt));
    ab.c("SettingTable", "<setInt> exit");
  }
  
  public void a(String paramString, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<setLong>key=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", value=");
    localStringBuilder.append(String.valueOf(paramLong));
    localStringBuilder.append(", process:");
    localStringBuilder.append(s.e());
    ab.c("SettingTable", localStringBuilder.toString());
    com.tencent.tmassistantbase.util.k.a().post(new h(this, paramString, paramLong));
    ab.c("SettingTable", "<setLong> exit");
  }
  
  public void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<setString>key=");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", value=");
    localStringBuilder.append(String.valueOf(paramString2));
    localStringBuilder.append(", process:");
    localStringBuilder.append(s.e());
    ab.c("SettingTable", localStringBuilder.toString());
    com.tencent.tmassistantbase.util.k.a().post(new i(this, paramString1, paramString2));
    ab.c("SettingTable", "<setString> exit");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<setBoolean>key=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", value=");
    localStringBuilder.append(String.valueOf(paramBoolean));
    localStringBuilder.append(",process:");
    localStringBuilder.append(s.e());
    ab.c("SettingTable", localStringBuilder.toString());
    com.tencent.tmassistantbase.util.k.a().post(new k(this, paramString, paramBoolean));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<setBlob>key=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", value.length=");
    localStringBuilder.append(paramArrayOfByte.length);
    localStringBuilder.append(",process:");
    localStringBuilder.append(s.e());
    ab.c("SettingTable", localStringBuilder.toString());
    com.tencent.tmassistantbase.util.k.a().post(new j(this, paramString, paramArrayOfByte));
  }
  
  public boolean a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<getBoolean> key=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",process:");
    localStringBuilder.append(s.e());
    ab.c("SettingTable", localStringBuilder.toString());
    try
    {
      boolean bool = Boolean.valueOf(f(paramString)).booleanValue();
      return bool;
    }
    catch (Exception paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<getBoolean> error, e = ");
      localStringBuilder.append(paramString.getMessage());
      localStringBuilder.append(",process:");
      localStringBuilder.append(s.e());
      ab.e("SettingTable", localStringBuilder.toString());
    }
    return false;
  }
  
  public int b(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<getInt> key=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",process:");
    localStringBuilder.append(s.e());
    ab.c("SettingTable", localStringBuilder.toString());
    try
    {
      int i = Integer.valueOf(f(paramString)).intValue();
      return i;
    }
    catch (Exception paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<getInt> error, e = ");
      localStringBuilder.append(paramString.getMessage());
      localStringBuilder.append(",process:");
      localStringBuilder.append(s.e());
      ab.e("SettingTable", localStringBuilder.toString());
    }
    return 0;
  }
  
  public long c(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<getLong> key=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",process:");
    localStringBuilder.append(s.e());
    ab.c("SettingTable", localStringBuilder.toString());
    try
    {
      long l = Long.valueOf(f(paramString)).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<getLong> error, e = ");
      localStringBuilder.append(paramString.getMessage());
      localStringBuilder.append(",process:");
      localStringBuilder.append(s.e());
      ab.e("SettingTable", localStringBuilder.toString());
    }
    return 0L;
  }
  
  public String createTableSQL()
  {
    return "CREATE TABLE if not exists setting_table (_id INTEGER PRIMARY KEY AUTOINCREMENT,key TEXT,value TEXT,data BLOB);";
  }
  
  public String d(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<getString> key=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",process:");
    localStringBuilder.append(s.e());
    ab.c("SettingTable", localStringBuilder.toString());
    try
    {
      paramString = f(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("<getString> error, e = ");
      localStringBuilder.append(paramString.getMessage());
      localStringBuilder.append(",process:");
      localStringBuilder.append(s.e());
      ab.e("SettingTable", localStringBuilder.toString());
    }
    return "";
  }
  
  public byte[] e(String paramString)
  {
    try
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<getBlob> key=");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(",process:");
      ((StringBuilder)localObject1).append(s.e());
      ab.c("SettingTable", ((StringBuilder)localObject1).toString());
      arrayOfByte = new byte[0];
      if (this.b.containsKey(paramString))
      {
        localObject1 = (byte[])this.b.get(paramString);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getting key=");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(",data=");
        ((StringBuilder)localObject2).append(localObject1);
        ((StringBuilder)localObject2).append(",using cache");
        ab.c("SettingTable", ((StringBuilder)localObject2).toString());
        return localObject1;
      }
      localObject3 = arrayOfByte;
      if (!TextUtils.isEmpty(paramString))
      {
        localObject1 = a.c();
        localObject3 = null;
        localObject4 = null;
        if (localObject1 == null)
        {
          ab.e("SettingTable", "<getBlob> sqliteHelper is null");
          return null;
        }
        localObject1 = ((d)localObject1).getWritableDatabase();
        if (localObject1 == null)
        {
          ab.e("SettingTable", "<getBlob> db is null");
          return null;
        }
      }
    }
    finally
    {
      Object localObject2;
      Object localObject4;
      for (;;)
      {
        label285:
        label290:
        label326:
        throw paramString;
      }
    }
    try
    {
      try
      {
        localObject1 = ((SQLiteDatabase)localObject1).rawQuery("select * from setting_table where key = ?", new String[] { paramString });
        localObject2 = arrayOfByte;
        if (localObject1 != null)
        {
          localObject2 = arrayOfByte;
          localObject4 = localObject1;
          localObject3 = localObject1;
          if (((Cursor)localObject1).moveToFirst())
          {
            localObject4 = localObject1;
            localObject3 = localObject1;
            localObject2 = ((Cursor)localObject1).getBlob(((Cursor)localObject1).getColumnIndexOrThrow("data"));
            if (localObject2 != null) {
              localObject4 = localObject1;
            }
          }
        }
      }
      finally
      {
        if (localObject4 != null) {
          localObject4.close();
        }
      }
    }
    catch (Exception paramString)
    {
      paramString = arrayOfByte;
      localObject1 = localObject3;
      break label326;
    }
    try
    {
      if (localObject2.length <= 0) {
        break label290;
      }
      localObject4 = localObject1;
      this.b.put(paramString, localObject2);
    }
    catch (Exception paramString)
    {
      break label285;
    }
    paramString = (String)localObject2;
    break label326;
    localObject3 = localObject2;
    if (localObject1 != null)
    {
      paramString = (String)localObject2;
      do
      {
        ((Cursor)localObject1).close();
        localObject3 = paramString;
        break;
        localObject3 = paramString;
      } while (localObject1 != null);
    }
    return localObject3;
  }
  
  public String[] getAlterSQL(int paramInt1, int paramInt2)
  {
    return new String[0];
  }
  
  public String tableName()
  {
    return "setting_table";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.internal.storage.table.e
 * JD-Core Version:    0.7.0.1
 */