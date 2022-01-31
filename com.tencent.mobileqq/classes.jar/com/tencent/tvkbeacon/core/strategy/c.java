package com.tencent.tvkbeacon.core.strategy;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tvkbeacon.core.a.a.e;
import com.tencent.tvkbeacon.core.info.b;

public final class c
{
  /* Error */
  public static g a(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: ldc 2
    //   6: monitorenter
    //   7: aload_0
    //   8: ifnonnull +19 -> 27
    //   11: ldc 10
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 16	com/tencent/tvkbeacon/core/c/c:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: aconst_null
    //   21: astore_3
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_3
    //   26: areturn
    //   27: aload_0
    //   28: invokestatic 21	com/tencent/tvkbeacon/core/info/b:a	(Landroid/content/Context;)Lcom/tencent/tvkbeacon/core/info/b;
    //   31: invokevirtual 25	com/tencent/tvkbeacon/core/info/b:b	()Ljava/lang/String;
    //   34: astore 4
    //   36: aload_0
    //   37: aload 4
    //   39: invokestatic 30	com/tencent/tvkbeacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/tvkbeacon/core/a/a/e;
    //   42: invokevirtual 34	com/tencent/tvkbeacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: astore_0
    //   46: aload_0
    //   47: ifnonnull +17 -> 64
    //   50: ldc 36
    //   52: iconst_0
    //   53: anewarray 4	java/lang/Object
    //   56: invokestatic 16	com/tencent/tvkbeacon/core/c/c:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   59: aconst_null
    //   60: astore_3
    //   61: goto -39 -> 22
    //   64: aload_0
    //   65: ldc 38
    //   67: aconst_null
    //   68: getstatic 44	java/util/Locale:US	Ljava/util/Locale;
    //   71: ldc 46
    //   73: iconst_2
    //   74: anewarray 4	java/lang/Object
    //   77: dup
    //   78: iconst_0
    //   79: ldc 48
    //   81: aastore
    //   82: dup
    //   83: iconst_1
    //   84: bipush 101
    //   86: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   89: aastore
    //   90: invokestatic 60	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   93: aconst_null
    //   94: aconst_null
    //   95: aconst_null
    //   96: aconst_null
    //   97: invokevirtual 66	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   100: astore_0
    //   101: aload_0
    //   102: ifnull +267 -> 369
    //   105: aload_0
    //   106: invokeinterface 72 1 0
    //   111: ifeq +258 -> 369
    //   114: aload_3
    //   115: astore_2
    //   116: aload_0
    //   117: ifnull +27 -> 144
    //   120: aload_3
    //   121: astore_2
    //   122: aload_0
    //   123: invokeinterface 75 1 0
    //   128: ifne +16 -> 144
    //   131: aload_0
    //   132: invokeinterface 78 1 0
    //   137: istore_1
    //   138: iload_1
    //   139: ifeq +62 -> 201
    //   142: aload_3
    //   143: astore_2
    //   144: aload_2
    //   145: ifnull +22 -> 167
    //   148: ldc 80
    //   150: iconst_1
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_2
    //   157: getfield 85	com/tencent/tvkbeacon/core/strategy/g:b	I
    //   160: invokestatic 54	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   163: aastore
    //   164: invokestatic 88	com/tencent/tvkbeacon/core/c/c:g	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: aload_2
    //   168: astore_3
    //   169: aload_0
    //   170: ifnull -148 -> 22
    //   173: aload_2
    //   174: astore_3
    //   175: aload_0
    //   176: invokeinterface 91 1 0
    //   181: ifne -159 -> 22
    //   184: aload_0
    //   185: invokeinterface 95 1 0
    //   190: aload_2
    //   191: astore_3
    //   192: goto -170 -> 22
    //   195: astore_0
    //   196: ldc 2
    //   198: monitorexit
    //   199: aload_0
    //   200: athrow
    //   201: ldc 97
    //   203: iconst_0
    //   204: anewarray 4	java/lang/Object
    //   207: invokestatic 99	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: new 82	com/tencent/tvkbeacon/core/strategy/g
    //   213: dup
    //   214: invokespecial 102	com/tencent/tvkbeacon/core/strategy/g:<init>	()V
    //   217: astore_2
    //   218: aload_2
    //   219: aload_0
    //   220: aload_0
    //   221: ldc 104
    //   223: invokeinterface 108 2 0
    //   228: invokeinterface 112 2 0
    //   233: putfield 115	com/tencent/tvkbeacon/core/strategy/g:a	J
    //   236: aload_2
    //   237: aload_0
    //   238: aload_0
    //   239: ldc 48
    //   241: invokeinterface 108 2 0
    //   246: invokeinterface 119 2 0
    //   251: putfield 85	com/tencent/tvkbeacon/core/strategy/g:b	I
    //   254: aload_2
    //   255: aload_0
    //   256: aload_0
    //   257: ldc 121
    //   259: invokeinterface 108 2 0
    //   264: invokeinterface 125 2 0
    //   269: putfield 128	com/tencent/tvkbeacon/core/strategy/g:c	[B
    //   272: goto -128 -> 144
    //   275: astore_3
    //   276: aconst_null
    //   277: astore_0
    //   278: aload_3
    //   279: invokestatic 131	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/Throwable;)V
    //   282: aload_0
    //   283: astore_3
    //   284: aload_2
    //   285: ifnull -263 -> 22
    //   288: aload_0
    //   289: astore_3
    //   290: aload_2
    //   291: invokeinterface 91 1 0
    //   296: ifne -274 -> 22
    //   299: aload_2
    //   300: invokeinterface 95 1 0
    //   305: aload_0
    //   306: astore_3
    //   307: goto -285 -> 22
    //   310: aload_0
    //   311: ifnull +18 -> 329
    //   314: aload_0
    //   315: invokeinterface 91 1 0
    //   320: ifne +9 -> 329
    //   323: aload_0
    //   324: invokeinterface 95 1 0
    //   329: aload_2
    //   330: athrow
    //   331: astore_2
    //   332: goto -22 -> 310
    //   335: astore_3
    //   336: aload_2
    //   337: astore_0
    //   338: aload_3
    //   339: astore_2
    //   340: goto -30 -> 310
    //   343: astore_3
    //   344: aconst_null
    //   345: astore 4
    //   347: aload_0
    //   348: astore_2
    //   349: aload 4
    //   351: astore_0
    //   352: goto -74 -> 278
    //   355: astore 4
    //   357: aload_2
    //   358: astore_3
    //   359: aload_0
    //   360: astore_2
    //   361: aload_3
    //   362: astore_0
    //   363: aload 4
    //   365: astore_3
    //   366: goto -88 -> 278
    //   369: aconst_null
    //   370: astore_2
    //   371: goto -204 -> 167
    //   374: astore_2
    //   375: aconst_null
    //   376: astore_0
    //   377: goto -67 -> 310
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	380	0	paramContext	Context
    //   137	2	1	bool	boolean
    //   1	329	2	localObject1	Object
    //   331	6	2	localObject2	Object
    //   339	32	2	localObject3	Object
    //   374	1	2	localObject4	Object
    //   3	189	3	localObject5	Object
    //   275	4	3	localThrowable1	Throwable
    //   283	24	3	localContext	Context
    //   335	4	3	localObject6	Object
    //   343	1	3	localThrowable2	Throwable
    //   358	8	3	localObject7	Object
    //   34	316	4	str	String
    //   355	9	4	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   11	20	195	finally
    //   27	36	195	finally
    //   175	190	195	finally
    //   290	305	195	finally
    //   314	329	195	finally
    //   329	331	195	finally
    //   36	46	275	java/lang/Throwable
    //   50	59	275	java/lang/Throwable
    //   64	101	275	java/lang/Throwable
    //   105	114	331	finally
    //   122	138	331	finally
    //   148	167	331	finally
    //   201	272	331	finally
    //   278	282	335	finally
    //   105	114	343	java/lang/Throwable
    //   122	138	343	java/lang/Throwable
    //   201	272	343	java/lang/Throwable
    //   148	167	355	java/lang/Throwable
    //   36	46	374	finally
    //   50	59	374	finally
    //   64	101	374	finally
  }
  
  public static void a(Context paramContext, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    g localg = new g();
    localg.b = paramInt;
    localg.c = paramArrayOfByte;
    a(paramContext, localg);
  }
  
  private static boolean a(Context paramContext, g paramg)
  {
    boolean bool = false;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        com.tencent.tvkbeacon.core.c.c.c("[db] context or bean is null}", new Object[0]);
        return bool;
      }
      finally {}
      Object localObject = b.a(paramContext).b();
      try
      {
        paramContext = e.a(paramContext, (String)localObject).getWritableDatabase();
        if (paramContext != null) {
          break label84;
        }
        com.tencent.tvkbeacon.core.c.c.d("[db] get db fail!,return false ", new Object[0]);
      }
      catch (Throwable paramContext)
      {
        com.tencent.tvkbeacon.core.c.c.d("[db] error: %s", new Object[] { paramContext.toString() });
      }
      continue;
      label84:
      localObject = new ContentValues();
      if (paramg.a >= 0L) {
        ((ContentValues)localObject).put("_id", Long.valueOf(paramg.a));
      }
      ((ContentValues)localObject).put("_key", Integer.valueOf(paramg.b));
      ((ContentValues)localObject).put("_datas", paramg.c);
      long l = paramContext.replace("t_strategy", "_id", (ContentValues)localObject);
      if (l < 0L)
      {
        com.tencent.tvkbeacon.core.c.c.c("[db] insert failure! return false ", new Object[0]);
      }
      else
      {
        paramg.a = l;
        com.tencent.tvkbeacon.core.c.c.e("[db] update strategy %d true ", new Object[] { Integer.valueOf(paramg.b) });
        bool = true;
      }
    }
  }
  
  public static int b(Context paramContext)
  {
    int k = 0;
    int j = 0;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        com.tencent.tvkbeacon.core.c.c.c("[db] params error.", new Object[0]);
        i = j;
        return i;
      }
      finally {}
      String str = b.a(paramContext).b();
      int i = k;
      try
      {
        paramContext = e.a(paramContext, str).getWritableDatabase();
        if (paramContext != null) {
          break label82;
        }
        i = k;
        com.tencent.tvkbeacon.core.c.c.d("get db fail!,return ", new Object[0]);
        i = j;
      }
      catch (Throwable paramContext)
      {
        com.tencent.tvkbeacon.core.c.c.a(paramContext);
      }
      continue;
      label82:
      i = k;
      j = paramContext.delete("t_strategy", String.format("%s = %d", new Object[] { "_key", Integer.valueOf(101) }), null);
      i = j;
      com.tencent.tvkbeacon.core.c.c.g("[db] key:%d , num: %d", new Object[] { Integer.valueOf(101), Integer.valueOf(j) });
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.strategy.c
 * JD-Core Version:    0.7.0.1
 */