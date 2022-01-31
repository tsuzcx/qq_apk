package com.tencent.tvkbeacon.core.a.a;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.tvkbeacon.core.c.c;
import java.util.ArrayList;
import java.util.List;

public final class b
{
  public static int a(Context paramContext, String paramString, int[] paramArrayOfInt)
  {
    int i = -1;
    int j = 0;
    if (paramContext == null) {}
    for (;;)
    {
      try
      {
        c.d("[db] delete context is null arg", new Object[0]);
        return i;
      }
      finally {}
      if (-1L > 9223372036854775807L)
      {
        i = 0;
      }
      else if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
      {
        String str = "";
        i = j;
        while (i < paramArrayOfInt.length)
        {
          str = str + " or _type = " + paramArrayOfInt[i];
          i += 1;
        }
        paramArrayOfInt = str.substring(4);
      }
    }
    for (paramArrayOfInt = "_time >= -1 and _time <= 9223372036854775807" + " and ( " + paramArrayOfInt + " )";; paramArrayOfInt = "_time >= -1 and _time <= 9223372036854775807") {
      for (;;)
      {
        c.b("[db] delete where: ".concat(String.valueOf(paramArrayOfInt)), new Object[0]);
        try
        {
          i = e.a(paramContext, paramString).getWritableDatabase().delete("t_event", paramArrayOfInt, null);
          c.b("[db] deleted num: ".concat(String.valueOf(i)), new Object[0]);
          c.b("[db] delete end", new Object[0]);
          break;
        }
        catch (Throwable paramContext)
        {
          for (;;)
          {
            c.b(paramContext.getMessage(), new Object[0]);
            c.b("[db] delete end", new Object[0]);
            i = -1;
          }
        }
        finally
        {
          c.b("[db] delete end", new Object[0]);
        }
      }
    }
  }
  
  /* Error */
  public static int a(Context paramContext, String paramString, java.lang.Long[] paramArrayOfLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 6
    //   9: ldc 2
    //   11: monitorenter
    //   12: aload_0
    //   13: ifnonnull +19 -> 32
    //   16: ldc 96
    //   18: iconst_0
    //   19: anewarray 4	java/lang/Object
    //   22: invokestatic 16	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   25: iconst_m1
    //   26: istore_3
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: iload 6
    //   34: istore_3
    //   35: aload_2
    //   36: ifnull -9 -> 27
    //   39: aload_2
    //   40: arraylength
    //   41: istore 7
    //   43: iload 6
    //   45: istore_3
    //   46: iload 7
    //   48: ifle -21 -> 27
    //   51: iload 5
    //   53: istore_3
    //   54: aload_0
    //   55: aload_1
    //   56: invokestatic 71	com/tencent/tvkbeacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/tvkbeacon/core/a/a/e;
    //   59: invokevirtual 75	com/tencent/tvkbeacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   62: astore_0
    //   63: iload 5
    //   65: istore_3
    //   66: new 98	java/lang/StringBuffer
    //   69: dup
    //   70: invokespecial 99	java/lang/StringBuffer:<init>	()V
    //   73: astore_1
    //   74: iconst_0
    //   75: istore 5
    //   77: iload 4
    //   79: istore_3
    //   80: iload 5
    //   82: aload_2
    //   83: arraylength
    //   84: if_icmpge +119 -> 203
    //   87: iload 4
    //   89: istore_3
    //   90: aload_1
    //   91: ldc 101
    //   93: aload_2
    //   94: iload 5
    //   96: aaload
    //   97: invokevirtual 107	java/lang/Long:longValue	()J
    //   100: invokestatic 110	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   103: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   106: invokevirtual 113	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   109: pop
    //   110: iload 4
    //   112: istore_3
    //   113: iload 5
    //   115: ifle +229 -> 344
    //   118: iload 4
    //   120: istore_3
    //   121: iload 5
    //   123: bipush 25
    //   125: irem
    //   126: ifne +218 -> 344
    //   129: iload 4
    //   131: istore_3
    //   132: ldc 115
    //   134: iload 5
    //   136: invokestatic 87	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   139: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: iload 4
    //   151: istore_3
    //   152: iload 4
    //   154: aload_0
    //   155: ldc 77
    //   157: aload_1
    //   158: iconst_4
    //   159: invokevirtual 116	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   162: aconst_null
    //   163: invokevirtual 83	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   166: iadd
    //   167: istore 4
    //   169: iload 4
    //   171: istore_3
    //   172: aload_1
    //   173: iconst_0
    //   174: invokevirtual 120	java/lang/StringBuffer:setLength	(I)V
    //   177: iload 4
    //   179: istore_3
    //   180: ldc 122
    //   182: iload 4
    //   184: invokestatic 87	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   187: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   190: iconst_0
    //   191: anewarray 4	java/lang/Object
    //   194: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: iload 4
    //   199: istore_3
    //   200: goto +144 -> 344
    //   203: iload 4
    //   205: istore 5
    //   207: iload 4
    //   209: istore_3
    //   210: aload_1
    //   211: invokevirtual 126	java/lang/StringBuffer:length	()I
    //   214: ifle +34 -> 248
    //   217: iload 4
    //   219: istore_3
    //   220: aload_0
    //   221: ldc 77
    //   223: aload_1
    //   224: iconst_4
    //   225: invokevirtual 116	java/lang/StringBuffer:substring	(I)Ljava/lang/String;
    //   228: aconst_null
    //   229: invokevirtual 83	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   232: istore 5
    //   234: iload 5
    //   236: iload 4
    //   238: iadd
    //   239: istore_3
    //   240: aload_1
    //   241: iconst_0
    //   242: invokevirtual 120	java/lang/StringBuffer:setLength	(I)V
    //   245: iload_3
    //   246: istore 5
    //   248: iload 5
    //   250: istore_3
    //   251: ldc 128
    //   253: iload 5
    //   255: invokestatic 87	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   258: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   261: iconst_0
    //   262: anewarray 4	java/lang/Object
    //   265: invokestatic 130	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: ldc 132
    //   270: iconst_0
    //   271: anewarray 4	java/lang/Object
    //   274: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: iload 5
    //   279: istore_3
    //   280: goto -253 -> 27
    //   283: astore_0
    //   284: ldc 2
    //   286: monitorexit
    //   287: aload_0
    //   288: athrow
    //   289: astore_0
    //   290: new 24	java/lang/StringBuilder
    //   293: dup
    //   294: ldc 134
    //   296: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   299: aload_0
    //   300: invokevirtual 92	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   303: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: iconst_0
    //   310: anewarray 4	java/lang/Object
    //   313: invokestatic 16	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   316: ldc 132
    //   318: iconst_0
    //   319: anewarray 4	java/lang/Object
    //   322: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   325: goto -298 -> 27
    //   328: astore_0
    //   329: ldc 132
    //   331: iconst_0
    //   332: anewarray 4	java/lang/Object
    //   335: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: aload_0
    //   339: athrow
    //   340: astore_0
    //   341: goto -51 -> 290
    //   344: iload 5
    //   346: iconst_1
    //   347: iadd
    //   348: istore 5
    //   350: iload_3
    //   351: istore 4
    //   353: goto -276 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramContext	Context
    //   0	356	1	paramString	String
    //   0	356	2	paramArrayOfLong	java.lang.Long[]
    //   26	325	3	i	int
    //   1	351	4	j	int
    //   4	345	5	k	int
    //   7	37	6	m	int
    //   41	6	7	n	int
    // Exception table:
    //   from	to	target	type
    //   16	25	283	finally
    //   39	43	283	finally
    //   268	277	283	finally
    //   316	325	283	finally
    //   329	340	283	finally
    //   54	63	289	java/lang/Throwable
    //   66	74	289	java/lang/Throwable
    //   80	87	289	java/lang/Throwable
    //   90	110	289	java/lang/Throwable
    //   132	149	289	java/lang/Throwable
    //   152	169	289	java/lang/Throwable
    //   172	177	289	java/lang/Throwable
    //   180	197	289	java/lang/Throwable
    //   210	217	289	java/lang/Throwable
    //   220	234	289	java/lang/Throwable
    //   251	268	289	java/lang/Throwable
    //   54	63	328	finally
    //   66	74	328	finally
    //   80	87	328	finally
    //   90	110	328	finally
    //   132	149	328	finally
    //   152	169	328	finally
    //   172	177	328	finally
    //   180	197	328	finally
    //   210	217	328	finally
    //   220	234	328	finally
    //   240	245	328	finally
    //   251	268	328	finally
    //   290	316	328	finally
    //   240	245	340	java/lang/Throwable
  }
  
  /* Error */
  public static List a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: aload_0
    //   6: ifnonnull +19 -> 25
    //   9: ldc 142
    //   11: iconst_0
    //   12: anewarray 4	java/lang/Object
    //   15: invokestatic 16	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aconst_null
    //   19: astore_0
    //   20: ldc 2
    //   22: monitorexit
    //   23: aload_0
    //   24: areturn
    //   25: aload_0
    //   26: aload_1
    //   27: invokestatic 71	com/tencent/tvkbeacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/tvkbeacon/core/a/a/e;
    //   30: invokevirtual 75	com/tencent/tvkbeacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   33: ldc 144
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: aconst_null
    //   40: ldc 146
    //   42: ldc 148
    //   44: invokevirtual 152	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   47: astore_0
    //   48: aload_0
    //   49: invokeinterface 158 1 0
    //   54: ifeq +263 -> 317
    //   57: new 160	java/util/ArrayList
    //   60: dup
    //   61: invokespecial 161	java/util/ArrayList:<init>	()V
    //   64: astore_1
    //   65: aload_1
    //   66: aload_0
    //   67: aload_0
    //   68: ldc 163
    //   70: invokeinterface 167 2 0
    //   75: invokeinterface 171 2 0
    //   80: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   83: invokeinterface 182 2 0
    //   88: pop
    //   89: aload_1
    //   90: aload_0
    //   91: aload_0
    //   92: ldc 184
    //   94: invokeinterface 167 2 0
    //   99: invokeinterface 187 2 0
    //   104: invokeinterface 182 2 0
    //   109: pop
    //   110: aload_1
    //   111: aload_0
    //   112: aload_0
    //   113: ldc 189
    //   115: invokeinterface 167 2 0
    //   120: invokeinterface 193 2 0
    //   125: invokestatic 196	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   128: invokeinterface 182 2 0
    //   133: pop
    //   134: aload_1
    //   135: aload_0
    //   136: aload_0
    //   137: ldc 198
    //   139: invokeinterface 167 2 0
    //   144: invokeinterface 202 2 0
    //   149: invokeinterface 182 2 0
    //   154: pop
    //   155: aload_1
    //   156: aload_0
    //   157: aload_0
    //   158: ldc 204
    //   160: invokeinterface 167 2 0
    //   165: invokeinterface 171 2 0
    //   170: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   173: invokeinterface 182 2 0
    //   178: pop
    //   179: ldc 206
    //   181: iconst_0
    //   182: anewarray 4	java/lang/Object
    //   185: invokestatic 130	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload_0
    //   189: ifnull +18 -> 207
    //   192: aload_0
    //   193: invokeinterface 209 1 0
    //   198: ifne +9 -> 207
    //   201: aload_0
    //   202: invokeinterface 212 1 0
    //   207: ldc 214
    //   209: iconst_0
    //   210: anewarray 4	java/lang/Object
    //   213: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: aload_1
    //   217: astore_0
    //   218: goto -198 -> 20
    //   221: astore_0
    //   222: ldc 2
    //   224: monitorexit
    //   225: aload_0
    //   226: athrow
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_0
    //   230: aload_2
    //   231: astore_1
    //   232: aload_1
    //   233: ifnull +18 -> 251
    //   236: aload_1
    //   237: invokeinterface 209 1 0
    //   242: ifne +9 -> 251
    //   245: aload_1
    //   246: invokeinterface 212 1 0
    //   251: ldc 214
    //   253: iconst_0
    //   254: anewarray 4	java/lang/Object
    //   257: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   260: goto -240 -> 20
    //   263: aload_0
    //   264: ifnull +18 -> 282
    //   267: aload_0
    //   268: invokeinterface 209 1 0
    //   273: ifne +9 -> 282
    //   276: aload_0
    //   277: invokeinterface 212 1 0
    //   282: ldc 214
    //   284: iconst_0
    //   285: anewarray 4	java/lang/Object
    //   288: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: aload_1
    //   292: athrow
    //   293: astore_1
    //   294: goto -31 -> 263
    //   297: astore_1
    //   298: aconst_null
    //   299: astore_2
    //   300: aload_0
    //   301: astore_1
    //   302: aload_2
    //   303: astore_0
    //   304: goto -72 -> 232
    //   307: astore_2
    //   308: aload_0
    //   309: astore_2
    //   310: aload_1
    //   311: astore_0
    //   312: aload_2
    //   313: astore_1
    //   314: goto -82 -> 232
    //   317: aconst_null
    //   318: astore_1
    //   319: goto -131 -> 188
    //   322: astore_1
    //   323: aconst_null
    //   324: astore_0
    //   325: goto -62 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramContext	Context
    //   0	328	1	paramString	String
    //   1	302	2	localObject	Object
    //   307	1	2	localException	java.lang.Exception
    //   309	4	2	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   9	18	221	finally
    //   192	207	221	finally
    //   207	216	221	finally
    //   236	251	221	finally
    //   251	260	221	finally
    //   267	282	221	finally
    //   282	293	221	finally
    //   25	48	227	java/lang/Exception
    //   48	65	293	finally
    //   65	188	293	finally
    //   48	65	297	java/lang/Exception
    //   65	188	307	java/lang/Exception
    //   25	48	322	finally
  }
  
  public static List<a> a(Context paramContext, String paramString, int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      paramContext = b(paramContext, paramString, paramArrayOfInt, paramInt);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private static List<a> a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = paramCursor.getColumnIndex("_id");
    int j = paramCursor.getColumnIndex("_prority");
    int k = paramCursor.getColumnIndex("_time");
    int m = paramCursor.getColumnIndex("_type");
    int n = paramCursor.getColumnIndex("_datas");
    int i1 = paramCursor.getColumnIndex("_length");
    while (paramCursor.moveToNext())
    {
      a locala = new a();
      locala.a = paramCursor.getLong(i);
      locala.e = paramCursor.getBlob(n);
      locala.c = paramCursor.getInt(j);
      locala.d = paramCursor.getLong(k);
      locala.b = paramCursor.getInt(m);
      locala.f = paramCursor.getLong(i1);
      localArrayList.add(locala);
    }
    c.b("[db] in parseCursor end", new Object[0]);
    return localArrayList;
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload_0
    //   10: ifnonnull +22 -> 32
    //   13: ldc 253
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 16	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: iload 5
    //   24: istore 4
    //   26: ldc 2
    //   28: monitorexit
    //   29: iload 4
    //   31: ireturn
    //   32: iload 5
    //   34: istore 4
    //   36: aload_2
    //   37: ifnull -11 -> 26
    //   40: iload 5
    //   42: istore 4
    //   44: aload_2
    //   45: invokevirtual 256	java/lang/String:trim	()Ljava/lang/String;
    //   48: ldc 22
    //   50: invokevirtual 259	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifne -27 -> 26
    //   56: new 24	java/lang/StringBuilder
    //   59: dup
    //   60: ldc_w 261
    //   63: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   66: aload_2
    //   67: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc_w 263
    //   73: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore_2
    //   80: ldc_w 265
    //   83: aload_2
    //   84: invokestatic 59	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   87: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   90: iconst_0
    //   91: anewarray 4	java/lang/Object
    //   94: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   97: aload_0
    //   98: aload_1
    //   99: invokestatic 71	com/tencent/tvkbeacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/tvkbeacon/core/a/a/e;
    //   102: invokevirtual 75	com/tencent/tvkbeacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   105: ldc 144
    //   107: aload_2
    //   108: aconst_null
    //   109: invokevirtual 83	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   112: istore_3
    //   113: ldc_w 267
    //   116: iload_3
    //   117: invokestatic 87	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   120: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: iload 6
    //   132: istore 4
    //   134: iload_3
    //   135: iconst_1
    //   136: if_icmpne +6 -> 142
    //   139: iconst_1
    //   140: istore 4
    //   142: ldc_w 269
    //   145: iconst_0
    //   146: anewarray 4	java/lang/Object
    //   149: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: goto -126 -> 26
    //   155: astore_0
    //   156: ldc 2
    //   158: monitorexit
    //   159: aload_0
    //   160: athrow
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 92	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   166: iconst_0
    //   167: anewarray 4	java/lang/Object
    //   170: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: ldc_w 269
    //   176: iconst_0
    //   177: anewarray 4	java/lang/Object
    //   180: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: iload 5
    //   185: istore 4
    //   187: goto -161 -> 26
    //   190: astore_0
    //   191: ldc_w 269
    //   194: iconst_0
    //   195: anewarray 4	java/lang/Object
    //   198: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: aload_0
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramContext	Context
    //   0	203	1	paramString1	String
    //   0	203	2	paramString2	String
    //   112	25	3	i	int
    //   24	162	4	bool1	boolean
    //   4	180	5	bool2	boolean
    //   1	130	6	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   13	22	155	finally
    //   44	97	155	finally
    //   142	152	155	finally
    //   173	183	155	finally
    //   191	203	155	finally
    //   97	130	161	java/lang/Throwable
    //   97	130	190	finally
    //   162	173	190	finally
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString, List<a> paramList)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 2
    //   5: monitorenter
    //   6: aload_0
    //   7: ifnonnull +19 -> 26
    //   10: ldc_w 272
    //   13: iconst_0
    //   14: anewarray 4	java/lang/Object
    //   17: invokestatic 16	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   20: ldc 2
    //   22: monitorexit
    //   23: iload 4
    //   25: ireturn
    //   26: aload_2
    //   27: invokeinterface 275 1 0
    //   32: ifgt +19 -> 51
    //   35: ldc_w 277
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   45: iconst_1
    //   46: istore 4
    //   48: goto -28 -> 20
    //   51: aconst_null
    //   52: astore 7
    //   54: aload_0
    //   55: aload_1
    //   56: invokestatic 71	com/tencent/tvkbeacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/tvkbeacon/core/a/a/e;
    //   59: invokevirtual 75	com/tencent/tvkbeacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   62: astore_0
    //   63: aload_0
    //   64: invokevirtual 280	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   67: iconst_0
    //   68: istore_3
    //   69: iload_3
    //   70: aload_2
    //   71: invokeinterface 275 1 0
    //   76: if_icmpge +155 -> 231
    //   79: aload_2
    //   80: iload_3
    //   81: invokeinterface 284 2 0
    //   86: checkcast 228	com/tencent/tvkbeacon/core/a/a/a
    //   89: astore_1
    //   90: new 286	android/content/ContentValues
    //   93: dup
    //   94: invokespecial 287	android/content/ContentValues:<init>	()V
    //   97: astore 7
    //   99: aload_1
    //   100: getfield 232	com/tencent/tvkbeacon/core/a/a/a:a	J
    //   103: lconst_0
    //   104: lcmp
    //   105: ifle +17 -> 122
    //   108: aload 7
    //   110: ldc 163
    //   112: aload_1
    //   113: getfield 232	com/tencent/tvkbeacon/core/a/a/a:a	J
    //   116: invokestatic 196	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   119: invokevirtual 291	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   122: aload 7
    //   124: ldc 222
    //   126: aload_1
    //   127: getfield 240	com/tencent/tvkbeacon/core/a/a/a:c	I
    //   130: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   133: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   136: aload 7
    //   138: ldc 189
    //   140: aload_1
    //   141: getfield 242	com/tencent/tvkbeacon/core/a/a/a:d	J
    //   144: invokestatic 196	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   147: invokevirtual 291	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   150: aload 7
    //   152: ldc 224
    //   154: aload_1
    //   155: getfield 244	com/tencent/tvkbeacon/core/a/a/a:b	I
    //   158: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   161: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   164: aload 7
    //   166: ldc 198
    //   168: aload_1
    //   169: getfield 236	com/tencent/tvkbeacon/core/a/a/a:e	[B
    //   172: invokevirtual 297	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   175: aload 7
    //   177: ldc 226
    //   179: aload_1
    //   180: getfield 247	com/tencent/tvkbeacon/core/a/a/a:f	J
    //   183: invokestatic 196	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   186: invokevirtual 291	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   189: aload_0
    //   190: ldc 77
    //   192: ldc 163
    //   194: aload 7
    //   196: invokevirtual 301	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   199: lstore 5
    //   201: lload 5
    //   203: lconst_0
    //   204: lcmp
    //   205: ifge +13 -> 218
    //   208: ldc_w 303
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 16	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload_1
    //   219: lload 5
    //   221: putfield 232	com/tencent/tvkbeacon/core/a/a/a:a	J
    //   224: iload_3
    //   225: iconst_1
    //   226: iadd
    //   227: istore_3
    //   228: goto -159 -> 69
    //   231: aload_0
    //   232: invokevirtual 306	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   235: aload_0
    //   236: invokevirtual 309	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   239: ldc_w 311
    //   242: iconst_1
    //   243: anewarray 4	java/lang/Object
    //   246: dup
    //   247: iconst_0
    //   248: ldc 77
    //   250: aastore
    //   251: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: iconst_1
    //   255: istore 4
    //   257: goto +126 -> 383
    //   260: astore_0
    //   261: ldc_w 313
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: goto -32 -> 239
    //   274: astore_0
    //   275: ldc 2
    //   277: monitorexit
    //   278: aload_0
    //   279: athrow
    //   280: astore_0
    //   281: aload 7
    //   283: astore_0
    //   284: ldc_w 315
    //   287: iconst_0
    //   288: anewarray 4	java/lang/Object
    //   291: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   294: aload_0
    //   295: invokevirtual 309	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   298: ldc_w 311
    //   301: iconst_1
    //   302: anewarray 4	java/lang/Object
    //   305: dup
    //   306: iconst_0
    //   307: ldc 77
    //   309: aastore
    //   310: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   313: iconst_0
    //   314: istore 4
    //   316: goto +67 -> 383
    //   319: astore_0
    //   320: ldc_w 313
    //   323: iconst_0
    //   324: anewarray 4	java/lang/Object
    //   327: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   330: goto -32 -> 298
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_0
    //   336: aload_0
    //   337: invokevirtual 309	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   340: ldc_w 311
    //   343: iconst_1
    //   344: anewarray 4	java/lang/Object
    //   347: dup
    //   348: iconst_0
    //   349: ldc 77
    //   351: aastore
    //   352: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   355: aload_1
    //   356: athrow
    //   357: astore_0
    //   358: ldc_w 313
    //   361: iconst_0
    //   362: anewarray 4	java/lang/Object
    //   365: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   368: goto -28 -> 340
    //   371: astore_1
    //   372: goto -36 -> 336
    //   375: astore_1
    //   376: goto -40 -> 336
    //   379: astore_1
    //   380: goto -96 -> 284
    //   383: goto -363 -> 20
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	paramContext	Context
    //   0	386	1	paramString	String
    //   0	386	2	paramList	List<a>
    //   68	160	3	i	int
    //   1	314	4	bool	boolean
    //   199	21	5	l	long
    //   52	230	7	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   235	239	260	java/lang/Exception
    //   10	20	274	finally
    //   26	45	274	finally
    //   235	239	274	finally
    //   239	254	274	finally
    //   261	271	274	finally
    //   294	298	274	finally
    //   298	313	274	finally
    //   320	330	274	finally
    //   336	340	274	finally
    //   340	357	274	finally
    //   358	368	274	finally
    //   54	63	280	java/lang/Throwable
    //   294	298	319	java/lang/Exception
    //   54	63	333	finally
    //   336	340	357	java/lang/Exception
    //   63	67	371	finally
    //   69	122	371	finally
    //   122	201	371	finally
    //   208	218	371	finally
    //   218	224	371	finally
    //   231	235	371	finally
    //   284	294	375	finally
    //   63	67	379	java/lang/Throwable
    //   69	122	379	java/lang/Throwable
    //   122	201	379	java/lang/Throwable
    //   208	218	379	java/lang/Throwable
    //   218	224	379	java/lang/Throwable
    //   231	235	379	java/lang/Throwable
  }
  
  /* Error */
  public static boolean a(Context paramContext, String paramString1, byte[] paramArrayOfByte, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload_0
    //   10: ifnull +11 -> 21
    //   13: aload_2
    //   14: ifnull +7 -> 21
    //   17: aload_3
    //   18: ifnonnull +19 -> 37
    //   21: ldc_w 319
    //   24: iconst_0
    //   25: anewarray 4	java/lang/Object
    //   28: invokestatic 16	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   31: ldc 2
    //   33: monitorexit
    //   34: iload 5
    //   36: ireturn
    //   37: aload_0
    //   38: aload_1
    //   39: invokestatic 71	com/tencent/tvkbeacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/tvkbeacon/core/a/a/e;
    //   42: invokevirtual 75	com/tencent/tvkbeacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   45: astore_0
    //   46: new 286	android/content/ContentValues
    //   49: dup
    //   50: invokespecial 287	android/content/ContentValues:<init>	()V
    //   53: astore_1
    //   54: aload_1
    //   55: ldc 184
    //   57: aload_3
    //   58: invokevirtual 322	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   61: aload_1
    //   62: ldc 189
    //   64: new 324	java/util/Date
    //   67: dup
    //   68: invokespecial 325	java/util/Date:<init>	()V
    //   71: invokevirtual 328	java/util/Date:getTime	()J
    //   74: invokestatic 196	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   77: invokevirtual 291	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   80: aload_1
    //   81: ldc 204
    //   83: iload 4
    //   85: invokestatic 176	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: invokevirtual 294	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   91: aload_1
    //   92: ldc 198
    //   94: aload_2
    //   95: invokevirtual 297	android/content/ContentValues:put	(Ljava/lang/String;[B)V
    //   98: aload_0
    //   99: ldc 144
    //   101: aconst_null
    //   102: aload_1
    //   103: invokevirtual 301	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   106: lconst_0
    //   107: lcmp
    //   108: ifge +36 -> 144
    //   111: ldc_w 330
    //   114: iconst_0
    //   115: anewarray 4	java/lang/Object
    //   118: invokestatic 16	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: iload 6
    //   123: istore 5
    //   125: ldc_w 332
    //   128: iconst_0
    //   129: anewarray 4	java/lang/Object
    //   132: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: goto -104 -> 31
    //   138: astore_0
    //   139: ldc 2
    //   141: monitorexit
    //   142: aload_0
    //   143: athrow
    //   144: iconst_1
    //   145: istore 5
    //   147: goto -22 -> 125
    //   150: astore_0
    //   151: ldc_w 334
    //   154: iconst_0
    //   155: anewarray 4	java/lang/Object
    //   158: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: ldc_w 332
    //   164: iconst_0
    //   165: anewarray 4	java/lang/Object
    //   168: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   171: goto -140 -> 31
    //   174: astore_0
    //   175: ldc_w 332
    //   178: iconst_0
    //   179: anewarray 4	java/lang/Object
    //   182: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   185: aload_0
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	187	0	paramContext	Context
    //   0	187	1	paramString1	String
    //   0	187	2	paramArrayOfByte	byte[]
    //   0	187	3	paramString2	String
    //   0	187	4	paramInt	int
    //   4	142	5	bool1	boolean
    //   1	121	6	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   21	31	138	finally
    //   125	135	138	finally
    //   161	171	138	finally
    //   175	187	138	finally
    //   37	121	150	java/lang/Throwable
    //   37	121	174	finally
    //   151	161	174	finally
  }
  
  /* Error */
  public static int b(Context paramContext, String paramString, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: ldc 2
    //   7: monitorenter
    //   8: aload_0
    //   9: ifnonnull +18 -> 27
    //   12: ldc_w 336
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 130	com/tencent/tvkbeacon/core/c/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   22: ldc 2
    //   24: monitorexit
    //   25: iload_3
    //   26: ireturn
    //   27: ldc2_w 17
    //   30: ldc2_w 19
    //   33: lcmp
    //   34: ifle +8 -> 42
    //   37: iconst_0
    //   38: istore_3
    //   39: goto -17 -> 22
    //   42: ldc 22
    //   44: astore 5
    //   46: iload 4
    //   48: istore_3
    //   49: iload_3
    //   50: iconst_4
    //   51: if_icmpge +38 -> 89
    //   54: new 24	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   61: aload 5
    //   63: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 34
    //   68: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_2
    //   72: iload_3
    //   73: iaload
    //   74: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 5
    //   82: iload_3
    //   83: iconst_1
    //   84: iadd
    //   85: istore_3
    //   86: goto -37 -> 49
    //   89: aload 5
    //   91: iconst_4
    //   92: invokevirtual 47	java/lang/String:substring	(I)Ljava/lang/String;
    //   95: astore_2
    //   96: new 24	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   103: ldc 49
    //   105: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: ldc 51
    //   110: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_2
    //   114: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: ldc 53
    //   119: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_2
    //   126: ldc_w 338
    //   129: aload_2
    //   130: invokestatic 59	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   133: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   136: iconst_0
    //   137: anewarray 4	java/lang/Object
    //   140: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: aload_0
    //   144: aload_1
    //   145: invokestatic 71	com/tencent/tvkbeacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/tvkbeacon/core/a/a/e;
    //   148: invokevirtual 75	com/tencent/tvkbeacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   151: ldc 77
    //   153: iconst_1
    //   154: anewarray 43	java/lang/String
    //   157: dup
    //   158: iconst_0
    //   159: ldc_w 340
    //   162: aastore
    //   163: aload_2
    //   164: aconst_null
    //   165: aconst_null
    //   166: aconst_null
    //   167: aconst_null
    //   168: invokevirtual 343	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   171: astore_1
    //   172: aload_1
    //   173: astore_0
    //   174: aload_1
    //   175: invokeinterface 158 1 0
    //   180: pop
    //   181: aload_1
    //   182: astore_0
    //   183: aload_1
    //   184: aload_1
    //   185: ldc_w 345
    //   188: invokeinterface 167 2 0
    //   193: invokeinterface 171 2 0
    //   198: istore_3
    //   199: aload_1
    //   200: astore_0
    //   201: ldc_w 347
    //   204: iload_3
    //   205: invokestatic 87	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   208: invokevirtual 63	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   211: iconst_0
    //   212: anewarray 4	java/lang/Object
    //   215: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload_1
    //   219: ifnull +18 -> 237
    //   222: aload_1
    //   223: invokeinterface 209 1 0
    //   228: ifne +9 -> 237
    //   231: aload_1
    //   232: invokeinterface 212 1 0
    //   237: ldc_w 349
    //   240: iconst_0
    //   241: anewarray 4	java/lang/Object
    //   244: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: goto -225 -> 22
    //   250: astore_2
    //   251: aconst_null
    //   252: astore_1
    //   253: aload_1
    //   254: astore_0
    //   255: aload_2
    //   256: invokevirtual 92	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   259: iconst_0
    //   260: anewarray 4	java/lang/Object
    //   263: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: aload_1
    //   267: ifnull +18 -> 285
    //   270: aload_1
    //   271: invokeinterface 209 1 0
    //   276: ifne +9 -> 285
    //   279: aload_1
    //   280: invokeinterface 212 1 0
    //   285: ldc_w 349
    //   288: iconst_0
    //   289: anewarray 4	java/lang/Object
    //   292: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   295: iconst_m1
    //   296: istore_3
    //   297: goto -50 -> 247
    //   300: aload_0
    //   301: ifnull +18 -> 319
    //   304: aload_0
    //   305: invokeinterface 209 1 0
    //   310: ifne +9 -> 319
    //   313: aload_0
    //   314: invokeinterface 212 1 0
    //   319: ldc_w 349
    //   322: iconst_0
    //   323: anewarray 4	java/lang/Object
    //   326: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   329: aload_1
    //   330: athrow
    //   331: astore_0
    //   332: ldc 2
    //   334: monitorexit
    //   335: aload_0
    //   336: athrow
    //   337: astore_1
    //   338: goto -38 -> 300
    //   341: astore_2
    //   342: goto -89 -> 253
    //   345: astore_1
    //   346: aconst_null
    //   347: astore_0
    //   348: goto -48 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	paramContext	Context
    //   0	351	1	paramString	String
    //   0	351	2	paramArrayOfInt	int[]
    //   1	296	3	i	int
    //   3	44	4	j	int
    //   44	46	5	str	String
    // Exception table:
    //   from	to	target	type
    //   143	172	250	java/lang/Throwable
    //   12	22	331	finally
    //   54	82	331	finally
    //   89	143	331	finally
    //   222	237	331	finally
    //   237	247	331	finally
    //   270	285	331	finally
    //   285	295	331	finally
    //   304	319	331	finally
    //   319	331	331	finally
    //   174	181	337	finally
    //   183	199	337	finally
    //   201	218	337	finally
    //   255	266	337	finally
    //   174	181	341	java/lang/Throwable
    //   183	199	341	java/lang/Throwable
    //   201	218	341	java/lang/Throwable
    //   143	172	345	finally
  }
  
  private static List<a> b(Context paramContext, String paramString, int[] paramArrayOfInt, int paramInt)
  {
    try
    {
      paramContext = c(paramContext, paramString, paramArrayOfInt, paramInt);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  /* Error */
  private static List<a> c(Context paramContext, String paramString, int[] paramArrayOfInt, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: iconst_0
    //   4: istore 4
    //   6: ldc 2
    //   8: monitorenter
    //   9: aload_0
    //   10: ifnull +91 -> 101
    //   13: ldc2_w 17
    //   16: lconst_0
    //   17: lcmp
    //   18: ifle +13 -> 31
    //   21: ldc2_w 17
    //   24: ldc2_w 17
    //   27: lcmp
    //   28: ifgt +73 -> 101
    //   31: ldc 22
    //   33: astore 7
    //   35: aload 7
    //   37: astore 5
    //   39: aload_2
    //   40: ifnull +104 -> 144
    //   43: aload 7
    //   45: astore 5
    //   47: aload_2
    //   48: arraylength
    //   49: ifle +95 -> 144
    //   52: ldc 22
    //   54: astore 5
    //   56: iload 4
    //   58: aload_2
    //   59: arraylength
    //   60: if_icmpge +58 -> 118
    //   63: new 24	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   70: aload 5
    //   72: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 34
    //   77: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_2
    //   81: iload 4
    //   83: iaload
    //   84: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   87: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: astore 5
    //   92: iload 4
    //   94: iconst_1
    //   95: iadd
    //   96: istore 4
    //   98: goto -42 -> 56
    //   101: ldc_w 353
    //   104: iconst_0
    //   105: anewarray 4	java/lang/Object
    //   108: invokestatic 16	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   111: aconst_null
    //   112: astore_0
    //   113: ldc 2
    //   115: monitorexit
    //   116: aload_0
    //   117: areturn
    //   118: new 24	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   125: ldc 22
    //   127: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 5
    //   132: iconst_4
    //   133: invokevirtual 47	java/lang/String:substring	(I)Ljava/lang/String;
    //   136: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: astore 5
    //   144: aload 5
    //   146: invokevirtual 354	java/lang/String:length	()I
    //   149: ifle +369 -> 518
    //   152: new 24	java/lang/StringBuilder
    //   155: dup
    //   156: ldc_w 356
    //   159: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   162: aload 5
    //   164: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: ldc_w 358
    //   170: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: astore 5
    //   178: aload 5
    //   180: astore_2
    //   181: ldc2_w 17
    //   184: lconst_0
    //   185: lcmp
    //   186: iflt +45 -> 231
    //   189: new 24	java/lang/StringBuilder
    //   192: dup
    //   193: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   196: aload 5
    //   198: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: astore 7
    //   203: aload 5
    //   205: invokevirtual 354	java/lang/String:length	()I
    //   208: ifle +449 -> 657
    //   211: ldc_w 360
    //   214: astore_2
    //   215: aload 7
    //   217: aload_2
    //   218: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 362
    //   224: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: astore_2
    //   231: aload_2
    //   232: astore 5
    //   234: ldc2_w 17
    //   237: lconst_0
    //   238: lcmp
    //   239: iflt +44 -> 283
    //   242: new 24	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   249: aload_2
    //   250: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: astore 5
    //   255: aload_2
    //   256: invokevirtual 354	java/lang/String:length	()I
    //   259: ifle +266 -> 525
    //   262: ldc_w 360
    //   265: astore_2
    //   266: aload 5
    //   268: aload_2
    //   269: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 364
    //   275: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: astore 5
    //   283: new 24	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   290: ldc 22
    //   292: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: ldc_w 366
    //   298: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: astore_2
    //   305: new 24	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 28	java/lang/StringBuilder:<init>	()V
    //   312: aload_2
    //   313: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc 146
    //   318: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: astore 7
    //   326: aload 7
    //   328: astore_2
    //   329: aload 7
    //   331: ldc_w 368
    //   334: invokevirtual 372	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   337: ifeq +17 -> 354
    //   340: aload 7
    //   342: iconst_0
    //   343: aload 7
    //   345: invokevirtual 354	java/lang/String:length	()I
    //   348: iconst_3
    //   349: isub
    //   350: invokevirtual 375	java/lang/String:substring	(II)Ljava/lang/String;
    //   353: astore_2
    //   354: ldc_w 377
    //   357: iconst_1
    //   358: anewarray 4	java/lang/Object
    //   361: dup
    //   362: iconst_0
    //   363: aload 5
    //   365: aastore
    //   366: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: aload_0
    //   370: aload_1
    //   371: invokestatic 71	com/tencent/tvkbeacon/core/a/a/e:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/tencent/tvkbeacon/core/a/a/e;
    //   374: invokevirtual 75	com/tencent/tvkbeacon/core/a/a/e:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   377: astore_1
    //   378: iload_3
    //   379: iflt +152 -> 531
    //   382: iload_3
    //   383: invokestatic 87	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   386: astore_0
    //   387: aload_1
    //   388: ldc 77
    //   390: aconst_null
    //   391: aload 5
    //   393: aconst_null
    //   394: aconst_null
    //   395: aconst_null
    //   396: aload_2
    //   397: aload_0
    //   398: invokevirtual 152	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   401: astore_0
    //   402: new 24	java/lang/StringBuilder
    //   405: dup
    //   406: ldc_w 379
    //   409: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   412: aload_0
    //   413: invokeinterface 382 1 0
    //   418: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   421: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: iconst_0
    //   425: anewarray 4	java/lang/Object
    //   428: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   431: aload_0
    //   432: invokeinterface 382 1 0
    //   437: ifle +215 -> 652
    //   440: aload_0
    //   441: invokestatic 384	com/tencent/tvkbeacon/core/a/a/b:a	(Landroid/database/Cursor;)Ljava/util/List;
    //   444: astore_1
    //   445: aload_1
    //   446: ifnull +32 -> 478
    //   449: new 24	java/lang/StringBuilder
    //   452: dup
    //   453: ldc_w 386
    //   456: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   459: aload_1
    //   460: invokeinterface 275 1 0
    //   465: invokevirtual 37	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   468: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: iconst_0
    //   472: anewarray 4	java/lang/Object
    //   475: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   478: aload_0
    //   479: ifnull +18 -> 497
    //   482: aload_0
    //   483: invokeinterface 209 1 0
    //   488: ifne +9 -> 497
    //   491: aload_0
    //   492: invokeinterface 212 1 0
    //   497: ldc_w 388
    //   500: iconst_0
    //   501: anewarray 4	java/lang/Object
    //   504: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   507: aload_1
    //   508: astore_0
    //   509: goto -396 -> 113
    //   512: astore_0
    //   513: ldc 2
    //   515: monitorexit
    //   516: aload_0
    //   517: athrow
    //   518: ldc 22
    //   520: astore 5
    //   522: goto -344 -> 178
    //   525: ldc 22
    //   527: astore_2
    //   528: goto -262 -> 266
    //   531: aconst_null
    //   532: astore_0
    //   533: goto -146 -> 387
    //   536: astore_2
    //   537: aconst_null
    //   538: astore_0
    //   539: aload 6
    //   541: astore_1
    //   542: aload_2
    //   543: invokevirtual 92	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   546: iconst_0
    //   547: anewarray 4	java/lang/Object
    //   550: invokestatic 16	com/tencent/tvkbeacon/core/c/c:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   553: aload_1
    //   554: ifnull +18 -> 572
    //   557: aload_1
    //   558: invokeinterface 209 1 0
    //   563: ifne +9 -> 572
    //   566: aload_1
    //   567: invokeinterface 212 1 0
    //   572: ldc_w 388
    //   575: iconst_0
    //   576: anewarray 4	java/lang/Object
    //   579: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   582: goto -469 -> 113
    //   585: aload_0
    //   586: ifnull +18 -> 604
    //   589: aload_0
    //   590: invokeinterface 209 1 0
    //   595: ifne +9 -> 604
    //   598: aload_0
    //   599: invokeinterface 212 1 0
    //   604: ldc_w 388
    //   607: iconst_0
    //   608: anewarray 4	java/lang/Object
    //   611: invokestatic 66	com/tencent/tvkbeacon/core/c/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   614: aload_1
    //   615: athrow
    //   616: astore_1
    //   617: goto -32 -> 585
    //   620: astore_2
    //   621: aload_1
    //   622: astore_0
    //   623: aload_2
    //   624: astore_1
    //   625: goto -40 -> 585
    //   628: astore_2
    //   629: aconst_null
    //   630: astore 5
    //   632: aload_0
    //   633: astore_1
    //   634: aload 5
    //   636: astore_0
    //   637: goto -95 -> 542
    //   640: astore_2
    //   641: aload_0
    //   642: astore 5
    //   644: aload_1
    //   645: astore_0
    //   646: aload 5
    //   648: astore_1
    //   649: goto -107 -> 542
    //   652: aconst_null
    //   653: astore_1
    //   654: goto -209 -> 445
    //   657: ldc 22
    //   659: astore_2
    //   660: goto -445 -> 215
    //   663: astore_1
    //   664: aconst_null
    //   665: astore_0
    //   666: goto -81 -> 585
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	669	0	paramContext	Context
    //   0	669	1	paramString	String
    //   0	669	2	paramArrayOfInt	int[]
    //   0	669	3	paramInt	int
    //   4	93	4	i	int
    //   37	610	5	localObject1	Object
    //   1	539	6	localObject2	Object
    //   33	311	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   47	52	512	finally
    //   56	92	512	finally
    //   101	111	512	finally
    //   118	144	512	finally
    //   144	178	512	finally
    //   189	211	512	finally
    //   215	231	512	finally
    //   242	262	512	finally
    //   266	283	512	finally
    //   283	326	512	finally
    //   329	354	512	finally
    //   354	369	512	finally
    //   482	497	512	finally
    //   497	507	512	finally
    //   557	572	512	finally
    //   572	582	512	finally
    //   589	604	512	finally
    //   604	616	512	finally
    //   369	378	536	java/lang/Throwable
    //   382	387	536	java/lang/Throwable
    //   387	402	536	java/lang/Throwable
    //   402	445	616	finally
    //   449	478	616	finally
    //   542	553	620	finally
    //   402	445	628	java/lang/Throwable
    //   449	478	640	java/lang/Throwable
    //   369	378	663	finally
    //   382	387	663	finally
    //   387	402	663	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.a.a.b
 * JD-Core Version:    0.7.0.1
 */