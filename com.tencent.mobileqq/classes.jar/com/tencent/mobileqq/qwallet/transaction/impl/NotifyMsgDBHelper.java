package com.tencent.mobileqq.qwallet.transaction.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class NotifyMsgDBHelper
  extends SQLiteOpenHelper
{
  public NotifyMsgDBHelper(Context paramContext)
  {
    super(paramContext, "QWalletNotifyMsg.db", null, 1);
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" CREATE TABLE IF NOT EXISTS ");
    localStringBuilder.append("record");
    localStringBuilder.append(" (");
    localStringBuilder.append("no");
    localStringBuilder.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
    localStringBuilder.append("uin");
    localStringBuilder.append(" INTEGER(64) DEFAULT 0, ");
    localStringBuilder.append("btype");
    localStringBuilder.append(" INTEGER(16) DEFAULT 0, ");
    localStringBuilder.append("bid");
    localStringBuilder.append(" VARCHAR(64) , ");
    localStringBuilder.append("create_time");
    localStringBuilder.append(" INTEGER(64) DEFAULT 0, ");
    localStringBuilder.append("ext");
    localStringBuilder.append(" VARCHAR(128) ");
    localStringBuilder.append(")");
    paramSQLiteDatabase.execSQL(localStringBuilder.toString());
  }
  
  /* Error */
  public void a(long paramLong, int[] paramArrayOfInt)
  {
    // Byte code:
    //   0: lload_1
    //   1: lconst_0
    //   2: lcmp
    //   3: ifgt +4 -> 7
    //   6: return
    //   7: invokestatic 72	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   10: lstore 6
    //   12: aconst_null
    //   13: astore 9
    //   15: aconst_null
    //   16: astore 8
    //   18: aload_0
    //   19: invokevirtual 76	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore 10
    //   24: aload_3
    //   25: ifnull +248 -> 273
    //   28: aload 10
    //   30: astore 8
    //   32: aload 10
    //   34: astore 9
    //   36: aload_3
    //   37: arraylength
    //   38: ifle +235 -> 273
    //   41: aload 10
    //   43: astore 8
    //   45: aload 10
    //   47: astore 9
    //   49: new 16	java/lang/StringBuilder
    //   52: dup
    //   53: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   56: astore 11
    //   58: iconst_0
    //   59: istore 4
    //   61: aload 10
    //   63: astore 8
    //   65: aload 10
    //   67: astore 9
    //   69: iload 4
    //   71: aload_3
    //   72: arraylength
    //   73: if_icmpge +69 -> 142
    //   76: aload 10
    //   78: astore 8
    //   80: aload 10
    //   82: astore 9
    //   84: aload 11
    //   86: aload_3
    //   87: iload 4
    //   89: iaload
    //   90: invokevirtual 79	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: iload 4
    //   96: iconst_1
    //   97: iadd
    //   98: istore 5
    //   100: iload 5
    //   102: istore 4
    //   104: aload 10
    //   106: astore 8
    //   108: aload 10
    //   110: astore 9
    //   112: iload 5
    //   114: aload_3
    //   115: arraylength
    //   116: if_icmpge -55 -> 61
    //   119: aload 10
    //   121: astore 8
    //   123: aload 10
    //   125: astore 9
    //   127: aload 11
    //   129: bipush 44
    //   131: invokevirtual 82	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: iload 5
    //   137: istore 4
    //   139: goto -78 -> 61
    //   142: aload 10
    //   144: astore 8
    //   146: aload 10
    //   148: astore 9
    //   150: new 16	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   157: astore_3
    //   158: aload 10
    //   160: astore 8
    //   162: aload 10
    //   164: astore 9
    //   166: aload_3
    //   167: ldc 84
    //   169: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 10
    //   175: astore 8
    //   177: aload 10
    //   179: astore 9
    //   181: aload_3
    //   182: aload 11
    //   184: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload 10
    //   193: astore 8
    //   195: aload 10
    //   197: astore 9
    //   199: aload_3
    //   200: ldc 86
    //   202: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 10
    //   208: astore 8
    //   210: aload 10
    //   212: astore 9
    //   214: aload_3
    //   215: ldc 47
    //   217: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: aload 10
    //   223: astore 8
    //   225: aload 10
    //   227: astore 9
    //   229: aload_3
    //   230: ldc 88
    //   232: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: aload 10
    //   238: astore 8
    //   240: aload 10
    //   242: astore 9
    //   244: aload 10
    //   246: ldc 27
    //   248: aload_3
    //   249: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: iconst_1
    //   253: anewarray 90	java/lang/String
    //   256: dup
    //   257: iconst_0
    //   258: lload 6
    //   260: lload_1
    //   261: lsub
    //   262: invokestatic 94	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   265: aastore
    //   266: invokevirtual 98	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   269: pop
    //   270: goto +35 -> 305
    //   273: aload 10
    //   275: astore 8
    //   277: aload 10
    //   279: astore 9
    //   281: aload 10
    //   283: ldc 27
    //   285: ldc 100
    //   287: iconst_1
    //   288: anewarray 90	java/lang/String
    //   291: dup
    //   292: iconst_0
    //   293: lload 6
    //   295: lload_1
    //   296: lsub
    //   297: invokestatic 94	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   300: aastore
    //   301: invokevirtual 98	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   304: pop
    //   305: aload 10
    //   307: ifnull +94 -> 401
    //   310: aload 10
    //   312: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   315: return
    //   316: astore_3
    //   317: goto +85 -> 402
    //   320: astore_3
    //   321: aload 9
    //   323: astore 8
    //   325: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq +57 -> 385
    //   331: aload 9
    //   333: astore 8
    //   335: new 16	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   342: astore 10
    //   344: aload 9
    //   346: astore 8
    //   348: aload 10
    //   350: ldc 111
    //   352: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: pop
    //   356: aload 9
    //   358: astore 8
    //   360: aload 10
    //   362: aload_3
    //   363: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   366: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: aload 9
    //   372: astore 8
    //   374: ldc 116
    //   376: iconst_2
    //   377: aload 10
    //   379: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   382: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   385: aload 9
    //   387: ifnull +14 -> 401
    //   390: aload 9
    //   392: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   395: return
    //   396: astore_3
    //   397: aload_3
    //   398: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   401: return
    //   402: aload 8
    //   404: ifnull +18 -> 422
    //   407: aload 8
    //   409: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   412: goto +10 -> 422
    //   415: astore 8
    //   417: aload 8
    //   419: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   422: goto +5 -> 427
    //   425: aload_3
    //   426: athrow
    //   427: goto -2 -> 425
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	430	0	this	NotifyMsgDBHelper
    //   0	430	1	paramLong	long
    //   0	430	3	paramArrayOfInt	int[]
    //   59	79	4	i	int
    //   98	38	5	j	int
    //   10	284	6	l	long
    //   16	392	8	localObject1	java.lang.Object
    //   415	3	8	localException	java.lang.Exception
    //   13	378	9	localObject2	java.lang.Object
    //   22	356	10	localObject3	java.lang.Object
    //   56	127	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   18	24	316	finally
    //   36	41	316	finally
    //   49	58	316	finally
    //   69	76	316	finally
    //   84	94	316	finally
    //   112	119	316	finally
    //   127	135	316	finally
    //   150	158	316	finally
    //   166	173	316	finally
    //   181	191	316	finally
    //   199	206	316	finally
    //   214	221	316	finally
    //   229	236	316	finally
    //   244	270	316	finally
    //   281	305	316	finally
    //   325	331	316	finally
    //   335	344	316	finally
    //   348	356	316	finally
    //   360	370	316	finally
    //   374	385	316	finally
    //   18	24	320	java/lang/Exception
    //   36	41	320	java/lang/Exception
    //   49	58	320	java/lang/Exception
    //   69	76	320	java/lang/Exception
    //   84	94	320	java/lang/Exception
    //   112	119	320	java/lang/Exception
    //   127	135	320	java/lang/Exception
    //   150	158	320	java/lang/Exception
    //   166	173	320	java/lang/Exception
    //   181	191	320	java/lang/Exception
    //   199	206	320	java/lang/Exception
    //   214	221	320	java/lang/Exception
    //   229	236	320	java/lang/Exception
    //   244	270	320	java/lang/Exception
    //   281	305	320	java/lang/Exception
    //   310	315	396	java/lang/Exception
    //   390	395	396	java/lang/Exception
    //   407	412	415	java/lang/Exception
  }
  
  /* Error */
  public void a(java.lang.String paramString, java.util.List<NotifyMsgRecord> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +422 -> 423
    //   4: aload_2
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aload_2
    //   10: invokeinterface 129 1 0
    //   15: aconst_null
    //   16: astore 7
    //   18: aconst_null
    //   19: astore 8
    //   21: aconst_null
    //   22: astore 4
    //   24: aconst_null
    //   25: astore_3
    //   26: aconst_null
    //   27: astore 6
    //   29: aload_0
    //   30: invokevirtual 132	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   33: astore 5
    //   35: aload 8
    //   37: astore_3
    //   38: aload 5
    //   40: ifnull +195 -> 235
    //   43: aload 6
    //   45: astore_3
    //   46: aload 7
    //   48: astore 4
    //   50: new 16	java/lang/StringBuilder
    //   53: dup
    //   54: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   57: astore 8
    //   59: aload 6
    //   61: astore_3
    //   62: aload 7
    //   64: astore 4
    //   66: aload 8
    //   68: ldc 134
    //   70: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 6
    //   76: astore_3
    //   77: aload 7
    //   79: astore 4
    //   81: aload 8
    //   83: aload_1
    //   84: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload 6
    //   90: astore_3
    //   91: aload 7
    //   93: astore 4
    //   95: aload 5
    //   97: aload 8
    //   99: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: aconst_null
    //   103: invokevirtual 138	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   106: astore_1
    //   107: aload_1
    //   108: ifnull +88 -> 196
    //   111: aload_1
    //   112: astore_3
    //   113: aload_1
    //   114: astore 4
    //   116: aload_1
    //   117: invokeinterface 144 1 0
    //   122: ifle +74 -> 196
    //   125: aload_1
    //   126: astore_3
    //   127: aload_1
    //   128: astore 4
    //   130: aload_1
    //   131: invokeinterface 147 1 0
    //   136: pop
    //   137: aload_1
    //   138: astore_3
    //   139: aload_1
    //   140: astore 4
    //   142: aload_1
    //   143: invokeinterface 150 1 0
    //   148: ifne +48 -> 196
    //   151: aload_1
    //   152: astore_3
    //   153: aload_1
    //   154: astore 4
    //   156: aload_1
    //   157: invokestatic 155	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:a	(Landroid/database/Cursor;)Lcom/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord;
    //   160: astore 6
    //   162: aload 6
    //   164: ifnull +17 -> 181
    //   167: aload_1
    //   168: astore_3
    //   169: aload_1
    //   170: astore 4
    //   172: aload_2
    //   173: aload 6
    //   175: invokeinterface 159 2 0
    //   180: pop
    //   181: aload_1
    //   182: astore_3
    //   183: aload_1
    //   184: astore 4
    //   186: aload_1
    //   187: invokeinterface 162 1 0
    //   192: pop
    //   193: goto -56 -> 137
    //   196: aload_1
    //   197: astore_3
    //   198: aload_1
    //   199: ifnull +36 -> 235
    //   202: aload_1
    //   203: astore_3
    //   204: aload_1
    //   205: astore 4
    //   207: aload_1
    //   208: invokeinterface 163 1 0
    //   213: aload_1
    //   214: astore_3
    //   215: goto +20 -> 235
    //   218: astore_2
    //   219: aload 5
    //   221: astore_1
    //   222: goto +156 -> 378
    //   225: astore_3
    //   226: aload 4
    //   228: astore_2
    //   229: aload 5
    //   231: astore_1
    //   232: goto +59 -> 291
    //   235: aload_3
    //   236: ifnull +26 -> 262
    //   239: aload_3
    //   240: invokeinterface 166 1 0
    //   245: ifne +17 -> 262
    //   248: aload_3
    //   249: invokeinterface 163 1 0
    //   254: goto +8 -> 262
    //   257: astore_1
    //   258: aload_1
    //   259: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   262: aload 5
    //   264: ifnull +106 -> 370
    //   267: aload 5
    //   269: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   272: return
    //   273: astore_1
    //   274: aload_1
    //   275: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   278: return
    //   279: astore_2
    //   280: aconst_null
    //   281: astore_1
    //   282: goto +96 -> 378
    //   285: astore_3
    //   286: aconst_null
    //   287: astore_2
    //   288: aload 4
    //   290: astore_1
    //   291: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   294: ifeq +41 -> 335
    //   297: new 16	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   304: astore 4
    //   306: aload 4
    //   308: ldc 168
    //   310: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload 4
    //   316: aload_3
    //   317: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   320: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: ldc 116
    //   326: iconst_2
    //   327: aload 4
    //   329: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_2
    //   336: ifnull +26 -> 362
    //   339: aload_2
    //   340: invokeinterface 166 1 0
    //   345: ifne +17 -> 362
    //   348: aload_2
    //   349: invokeinterface 163 1 0
    //   354: goto +8 -> 362
    //   357: astore_2
    //   358: aload_2
    //   359: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   362: aload_1
    //   363: ifnull +7 -> 370
    //   366: aload_1
    //   367: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   370: return
    //   371: astore 4
    //   373: aload_2
    //   374: astore_3
    //   375: aload 4
    //   377: astore_2
    //   378: aload_3
    //   379: ifnull +26 -> 405
    //   382: aload_3
    //   383: invokeinterface 166 1 0
    //   388: ifne +17 -> 405
    //   391: aload_3
    //   392: invokeinterface 163 1 0
    //   397: goto +8 -> 405
    //   400: astore_3
    //   401: aload_3
    //   402: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   405: aload_1
    //   406: ifnull +15 -> 421
    //   409: aload_1
    //   410: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   413: goto +8 -> 421
    //   416: astore_1
    //   417: aload_1
    //   418: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   421: aload_2
    //   422: athrow
    //   423: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	NotifyMsgDBHelper
    //   0	424	1	paramString	java.lang.String
    //   0	424	2	paramList	java.util.List<NotifyMsgRecord>
    //   25	190	3	localObject1	java.lang.Object
    //   225	24	3	localException1	java.lang.Exception
    //   285	32	3	localException2	java.lang.Exception
    //   374	18	3	localList	java.util.List<NotifyMsgRecord>
    //   400	2	3	localException3	java.lang.Exception
    //   22	306	4	localObject2	java.lang.Object
    //   371	5	4	localObject3	java.lang.Object
    //   33	235	5	localSQLiteDatabase	SQLiteDatabase
    //   27	147	6	localNotifyMsgRecord	NotifyMsgRecord
    //   16	76	7	localObject4	java.lang.Object
    //   19	79	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   50	59	218	finally
    //   66	74	218	finally
    //   81	88	218	finally
    //   95	107	218	finally
    //   116	125	218	finally
    //   130	137	218	finally
    //   142	151	218	finally
    //   156	162	218	finally
    //   172	181	218	finally
    //   186	193	218	finally
    //   207	213	218	finally
    //   50	59	225	java/lang/Exception
    //   66	74	225	java/lang/Exception
    //   81	88	225	java/lang/Exception
    //   95	107	225	java/lang/Exception
    //   116	125	225	java/lang/Exception
    //   130	137	225	java/lang/Exception
    //   142	151	225	java/lang/Exception
    //   156	162	225	java/lang/Exception
    //   172	181	225	java/lang/Exception
    //   186	193	225	java/lang/Exception
    //   207	213	225	java/lang/Exception
    //   239	254	257	java/lang/Exception
    //   267	272	273	java/lang/Exception
    //   366	370	273	java/lang/Exception
    //   29	35	279	finally
    //   29	35	285	java/lang/Exception
    //   339	354	357	java/lang/Exception
    //   291	335	371	finally
    //   382	397	400	java/lang/Exception
    //   409	413	416	java/lang/Exception
  }
  
  /* Error */
  public void b(java.lang.String paramString, java.util.List<NotifyMsgRecord> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +464 -> 465
    //   4: aload_2
    //   5: ifnull +460 -> 465
    //   8: aload_2
    //   9: invokeinterface 174 1 0
    //   14: ifgt +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: invokevirtual 76	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore_3
    //   23: aload_3
    //   24: astore_1
    //   25: aload_2
    //   26: invokeinterface 178 1 0
    //   31: astore 5
    //   33: aload_3
    //   34: astore_1
    //   35: aload 5
    //   37: invokeinterface 183 1 0
    //   42: ifeq +306 -> 348
    //   45: aload_3
    //   46: astore_1
    //   47: aload 5
    //   49: invokeinterface 187 1 0
    //   54: checkcast 152	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord
    //   57: astore 6
    //   59: aload 6
    //   61: ifnull -28 -> 33
    //   64: aload_3
    //   65: astore_1
    //   66: new 189	android/content/ContentValues
    //   69: dup
    //   70: invokespecial 190	android/content/ContentValues:<init>	()V
    //   73: astore 7
    //   75: aload_3
    //   76: astore_1
    //   77: aload 7
    //   79: ldc 35
    //   81: aload 6
    //   83: getfield 193	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:b	J
    //   86: invokestatic 198	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   89: invokevirtual 202	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   92: aload_3
    //   93: astore_1
    //   94: aload 7
    //   96: ldc 39
    //   98: aload 6
    //   100: getfield 206	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:c	I
    //   103: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: invokevirtual 214	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   109: aload_3
    //   110: astore_1
    //   111: aload 6
    //   113: getfield 218	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:d	Ljava/lang/String;
    //   116: astore_2
    //   117: ldc 220
    //   119: astore 4
    //   121: aload_2
    //   122: ifnonnull +9 -> 131
    //   125: ldc 220
    //   127: astore_2
    //   128: goto +11 -> 139
    //   131: aload_3
    //   132: astore_1
    //   133: aload 6
    //   135: getfield 218	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:d	Ljava/lang/String;
    //   138: astore_2
    //   139: aload_3
    //   140: astore_1
    //   141: aload 7
    //   143: ldc 43
    //   145: aload_2
    //   146: invokevirtual 223	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: aload_3
    //   150: astore_1
    //   151: aload 7
    //   153: ldc 47
    //   155: invokestatic 72	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   158: invokestatic 198	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   161: invokevirtual 202	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   164: aload_3
    //   165: astore_1
    //   166: aload 6
    //   168: getfield 227	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:f	Lorg/json/JSONObject;
    //   171: ifnonnull +9 -> 180
    //   174: aload 4
    //   176: astore_2
    //   177: goto +14 -> 191
    //   180: aload_3
    //   181: astore_1
    //   182: aload 6
    //   184: getfield 227	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:f	Lorg/json/JSONObject;
    //   187: invokevirtual 230	org/json/JSONObject:toString	()Ljava/lang/String;
    //   190: astore_2
    //   191: aload_3
    //   192: astore_1
    //   193: aload 7
    //   195: ldc 49
    //   197: aload_2
    //   198: invokevirtual 223	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: aload_3
    //   202: astore_1
    //   203: aload_3
    //   204: ldc 27
    //   206: aconst_null
    //   207: aload 7
    //   209: invokevirtual 234	android/database/sqlite/SQLiteDatabase:insertOrThrow	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   212: pop2
    //   213: aload_3
    //   214: astore_1
    //   215: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq -185 -> 33
    //   221: aload_3
    //   222: astore_1
    //   223: new 16	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   230: astore_2
    //   231: aload_3
    //   232: astore_1
    //   233: aload_2
    //   234: ldc 236
    //   236: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_3
    //   241: astore_1
    //   242: aload_2
    //   243: aload 6
    //   245: getfield 218	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:d	Ljava/lang/String;
    //   248: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload_3
    //   253: astore_1
    //   254: ldc 116
    //   256: iconst_2
    //   257: aload_2
    //   258: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   264: goto -231 -> 33
    //   267: astore_2
    //   268: aload_3
    //   269: astore_1
    //   270: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq -240 -> 33
    //   276: aload_3
    //   277: astore_1
    //   278: new 16	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   285: astore 4
    //   287: aload_3
    //   288: astore_1
    //   289: aload 4
    //   291: ldc 238
    //   293: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_3
    //   298: astore_1
    //   299: aload 4
    //   301: aload 6
    //   303: getfield 218	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:d	Ljava/lang/String;
    //   306: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload_3
    //   311: astore_1
    //   312: aload 4
    //   314: ldc 240
    //   316: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_3
    //   321: astore_1
    //   322: aload 4
    //   324: aload_2
    //   325: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   328: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_3
    //   333: astore_1
    //   334: ldc 116
    //   336: iconst_2
    //   337: aload 4
    //   339: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: goto -312 -> 33
    //   348: aload_3
    //   349: ifnull +97 -> 446
    //   352: aload_3
    //   353: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   356: return
    //   357: astore_2
    //   358: goto +89 -> 447
    //   361: astore_1
    //   362: aload_3
    //   363: astore_2
    //   364: aload_1
    //   365: astore_3
    //   366: goto +12 -> 378
    //   369: astore_2
    //   370: aconst_null
    //   371: astore_1
    //   372: goto +75 -> 447
    //   375: astore_3
    //   376: aconst_null
    //   377: astore_2
    //   378: aload_2
    //   379: astore_1
    //   380: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq +49 -> 432
    //   386: aload_2
    //   387: astore_1
    //   388: new 16	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   395: astore 4
    //   397: aload_2
    //   398: astore_1
    //   399: aload 4
    //   401: ldc 242
    //   403: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload_2
    //   408: astore_1
    //   409: aload 4
    //   411: aload_3
    //   412: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   415: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload_2
    //   420: astore_1
    //   421: ldc 116
    //   423: iconst_2
    //   424: aload 4
    //   426: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   429: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   432: aload_2
    //   433: ifnull +13 -> 446
    //   436: aload_2
    //   437: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   440: return
    //   441: astore_1
    //   442: aload_1
    //   443: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   446: return
    //   447: aload_1
    //   448: ifnull +15 -> 463
    //   451: aload_1
    //   452: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   455: goto +8 -> 463
    //   458: astore_1
    //   459: aload_1
    //   460: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   463: aload_2
    //   464: athrow
    //   465: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	466	0	this	NotifyMsgDBHelper
    //   0	466	1	paramString	java.lang.String
    //   0	466	2	paramList	java.util.List<NotifyMsgRecord>
    //   22	344	3	localObject1	java.lang.Object
    //   375	37	3	localException	java.lang.Exception
    //   119	306	4	localObject2	java.lang.Object
    //   31	17	5	localIterator	java.util.Iterator
    //   57	245	6	localNotifyMsgRecord	NotifyMsgRecord
    //   73	135	7	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   203	213	267	java/lang/Exception
    //   215	221	267	java/lang/Exception
    //   223	231	267	java/lang/Exception
    //   233	240	267	java/lang/Exception
    //   242	252	267	java/lang/Exception
    //   254	264	267	java/lang/Exception
    //   25	33	357	finally
    //   35	45	357	finally
    //   47	59	357	finally
    //   66	75	357	finally
    //   77	92	357	finally
    //   94	109	357	finally
    //   111	117	357	finally
    //   133	139	357	finally
    //   141	149	357	finally
    //   151	164	357	finally
    //   166	174	357	finally
    //   182	191	357	finally
    //   193	201	357	finally
    //   203	213	357	finally
    //   215	221	357	finally
    //   223	231	357	finally
    //   233	240	357	finally
    //   242	252	357	finally
    //   254	264	357	finally
    //   270	276	357	finally
    //   278	287	357	finally
    //   289	297	357	finally
    //   299	310	357	finally
    //   312	320	357	finally
    //   322	332	357	finally
    //   334	345	357	finally
    //   380	386	357	finally
    //   388	397	357	finally
    //   399	407	357	finally
    //   409	419	357	finally
    //   421	432	357	finally
    //   25	33	361	java/lang/Exception
    //   35	45	361	java/lang/Exception
    //   47	59	361	java/lang/Exception
    //   66	75	361	java/lang/Exception
    //   77	92	361	java/lang/Exception
    //   94	109	361	java/lang/Exception
    //   111	117	361	java/lang/Exception
    //   133	139	361	java/lang/Exception
    //   141	149	361	java/lang/Exception
    //   151	164	361	java/lang/Exception
    //   166	174	361	java/lang/Exception
    //   182	191	361	java/lang/Exception
    //   193	201	361	java/lang/Exception
    //   270	276	361	java/lang/Exception
    //   278	287	361	java/lang/Exception
    //   289	297	361	java/lang/Exception
    //   299	310	361	java/lang/Exception
    //   312	320	361	java/lang/Exception
    //   322	332	361	java/lang/Exception
    //   334	345	361	java/lang/Exception
    //   18	23	369	finally
    //   18	23	375	java/lang/Exception
    //   352	356	441	java/lang/Exception
    //   436	440	441	java/lang/Exception
    //   451	455	458	java/lang/Exception
  }
  
  /* Error */
  public void c(java.lang.String paramString, java.util.List<NotifyMsgRecord> paramList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +575 -> 576
    //   4: aload_2
    //   5: ifnull +571 -> 576
    //   8: aload_2
    //   9: invokeinterface 174 1 0
    //   14: ifgt +4 -> 18
    //   17: return
    //   18: aconst_null
    //   19: astore 4
    //   21: aconst_null
    //   22: astore_3
    //   23: aload_0
    //   24: invokevirtual 76	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore 5
    //   29: aload 5
    //   31: astore_3
    //   32: aload 5
    //   34: astore 4
    //   36: aload_2
    //   37: invokeinterface 178 1 0
    //   42: astore 7
    //   44: aload 5
    //   46: astore_3
    //   47: aload 5
    //   49: astore 4
    //   51: aload 7
    //   53: invokeinterface 183 1 0
    //   58: ifeq +411 -> 469
    //   61: aload 5
    //   63: astore_3
    //   64: aload 5
    //   66: astore 4
    //   68: aload 7
    //   70: invokeinterface 187 1 0
    //   75: checkcast 152	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord
    //   78: astore 8
    //   80: aload 8
    //   82: ifnull -38 -> 44
    //   85: aload 5
    //   87: astore_3
    //   88: aload 5
    //   90: astore 4
    //   92: new 189	android/content/ContentValues
    //   95: dup
    //   96: invokespecial 190	android/content/ContentValues:<init>	()V
    //   99: astore 9
    //   101: aload 5
    //   103: astore_3
    //   104: aload 5
    //   106: astore 4
    //   108: aload 9
    //   110: ldc 35
    //   112: aload 8
    //   114: getfield 193	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:b	J
    //   117: invokestatic 198	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   120: invokevirtual 202	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   123: aload 5
    //   125: astore_3
    //   126: aload 5
    //   128: astore 4
    //   130: aload 9
    //   132: ldc 39
    //   134: aload 8
    //   136: getfield 206	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:c	I
    //   139: invokestatic 211	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   142: invokevirtual 214	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   145: aload 5
    //   147: astore_3
    //   148: aload 5
    //   150: astore 4
    //   152: aload 8
    //   154: getfield 218	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:d	Ljava/lang/String;
    //   157: astore_2
    //   158: ldc 220
    //   160: astore 6
    //   162: aload_2
    //   163: ifnonnull +9 -> 172
    //   166: ldc 220
    //   168: astore_2
    //   169: goto +16 -> 185
    //   172: aload 5
    //   174: astore_3
    //   175: aload 5
    //   177: astore 4
    //   179: aload 8
    //   181: getfield 218	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:d	Ljava/lang/String;
    //   184: astore_2
    //   185: aload 5
    //   187: astore_3
    //   188: aload 5
    //   190: astore 4
    //   192: aload 9
    //   194: ldc 43
    //   196: aload_2
    //   197: invokevirtual 223	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 5
    //   202: astore_3
    //   203: aload 5
    //   205: astore 4
    //   207: aload 8
    //   209: getfield 227	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:f	Lorg/json/JSONObject;
    //   212: ifnonnull +9 -> 221
    //   215: aload 6
    //   217: astore_2
    //   218: goto +19 -> 237
    //   221: aload 5
    //   223: astore_3
    //   224: aload 5
    //   226: astore 4
    //   228: aload 8
    //   230: getfield 227	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:f	Lorg/json/JSONObject;
    //   233: invokevirtual 230	org/json/JSONObject:toString	()Ljava/lang/String;
    //   236: astore_2
    //   237: aload 5
    //   239: astore_3
    //   240: aload 5
    //   242: astore 4
    //   244: aload 9
    //   246: ldc 49
    //   248: aload_2
    //   249: invokevirtual 223	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   252: aload 5
    //   254: astore_3
    //   255: aload 5
    //   257: ldc 27
    //   259: aload 9
    //   261: ldc 244
    //   263: iconst_3
    //   264: anewarray 90	java/lang/String
    //   267: dup
    //   268: iconst_0
    //   269: aload_1
    //   270: aastore
    //   271: dup
    //   272: iconst_1
    //   273: aload 8
    //   275: getfield 206	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:c	I
    //   278: invokestatic 247	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   281: aastore
    //   282: dup
    //   283: iconst_2
    //   284: aload 8
    //   286: getfield 218	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:d	Ljava/lang/String;
    //   289: aastore
    //   290: invokevirtual 251	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   293: pop
    //   294: aload 5
    //   296: astore_3
    //   297: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   300: ifeq -256 -> 44
    //   303: aload 5
    //   305: astore_3
    //   306: new 16	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   313: astore_2
    //   314: aload 5
    //   316: astore_3
    //   317: aload_2
    //   318: ldc 253
    //   320: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 5
    //   326: astore_3
    //   327: aload_2
    //   328: aload 8
    //   330: getfield 218	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:d	Ljava/lang/String;
    //   333: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 5
    //   339: astore_3
    //   340: ldc 116
    //   342: iconst_2
    //   343: aload_2
    //   344: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   350: goto -306 -> 44
    //   353: astore_2
    //   354: aload 5
    //   356: astore_3
    //   357: aload 5
    //   359: astore 4
    //   361: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq -320 -> 44
    //   367: aload 5
    //   369: astore_3
    //   370: aload 5
    //   372: astore 4
    //   374: new 16	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   381: astore 6
    //   383: aload 5
    //   385: astore_3
    //   386: aload 5
    //   388: astore 4
    //   390: aload 6
    //   392: ldc 255
    //   394: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 5
    //   400: astore_3
    //   401: aload 5
    //   403: astore 4
    //   405: aload 6
    //   407: aload 8
    //   409: getfield 218	com/tencent/mobileqq/qwallet/transaction/impl/NotifyMsgRecord:d	Ljava/lang/String;
    //   412: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 5
    //   418: astore_3
    //   419: aload 5
    //   421: astore 4
    //   423: aload 6
    //   425: ldc 240
    //   427: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload 5
    //   433: astore_3
    //   434: aload 5
    //   436: astore 4
    //   438: aload 6
    //   440: aload_2
    //   441: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   444: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: aload 5
    //   450: astore_3
    //   451: aload 5
    //   453: astore 4
    //   455: ldc 116
    //   457: iconst_2
    //   458: aload 6
    //   460: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: goto -422 -> 44
    //   469: aload 5
    //   471: ifnull +86 -> 557
    //   474: aload 5
    //   476: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   479: return
    //   480: astore_1
    //   481: goto +77 -> 558
    //   484: astore_1
    //   485: aload 4
    //   487: astore_3
    //   488: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   491: ifeq +50 -> 541
    //   494: aload 4
    //   496: astore_3
    //   497: new 16	java/lang/StringBuilder
    //   500: dup
    //   501: invokespecial 19	java/lang/StringBuilder:<init>	()V
    //   504: astore_2
    //   505: aload 4
    //   507: astore_3
    //   508: aload_2
    //   509: ldc_w 257
    //   512: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 4
    //   518: astore_3
    //   519: aload_2
    //   520: aload_1
    //   521: invokevirtual 114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   524: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload 4
    //   530: astore_3
    //   531: ldc 116
    //   533: iconst_2
    //   534: aload_2
    //   535: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 120	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   541: aload 4
    //   543: ifnull +14 -> 557
    //   546: aload 4
    //   548: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   551: return
    //   552: astore_1
    //   553: aload_1
    //   554: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   557: return
    //   558: aload_3
    //   559: ifnull +15 -> 574
    //   562: aload_3
    //   563: invokevirtual 103	android/database/sqlite/SQLiteDatabase:close	()V
    //   566: goto +8 -> 574
    //   569: astore_2
    //   570: aload_2
    //   571: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   574: aload_1
    //   575: athrow
    //   576: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	577	0	this	NotifyMsgDBHelper
    //   0	577	1	paramString	java.lang.String
    //   0	577	2	paramList	java.util.List<NotifyMsgRecord>
    //   22	541	3	localObject1	java.lang.Object
    //   19	528	4	localObject2	java.lang.Object
    //   27	448	5	localSQLiteDatabase	SQLiteDatabase
    //   160	299	6	localObject3	java.lang.Object
    //   42	27	7	localIterator	java.util.Iterator
    //   78	330	8	localNotifyMsgRecord	NotifyMsgRecord
    //   99	161	9	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   255	294	353	java/lang/Exception
    //   297	303	353	java/lang/Exception
    //   306	314	353	java/lang/Exception
    //   317	324	353	java/lang/Exception
    //   327	337	353	java/lang/Exception
    //   340	350	353	java/lang/Exception
    //   23	29	480	finally
    //   36	44	480	finally
    //   51	61	480	finally
    //   68	80	480	finally
    //   92	101	480	finally
    //   108	123	480	finally
    //   130	145	480	finally
    //   152	158	480	finally
    //   179	185	480	finally
    //   192	200	480	finally
    //   207	215	480	finally
    //   228	237	480	finally
    //   244	252	480	finally
    //   255	294	480	finally
    //   297	303	480	finally
    //   306	314	480	finally
    //   317	324	480	finally
    //   327	337	480	finally
    //   340	350	480	finally
    //   361	367	480	finally
    //   374	383	480	finally
    //   390	398	480	finally
    //   405	416	480	finally
    //   423	431	480	finally
    //   438	448	480	finally
    //   455	466	480	finally
    //   488	494	480	finally
    //   497	505	480	finally
    //   508	516	480	finally
    //   519	528	480	finally
    //   531	541	480	finally
    //   23	29	484	java/lang/Exception
    //   36	44	484	java/lang/Exception
    //   51	61	484	java/lang/Exception
    //   68	80	484	java/lang/Exception
    //   92	101	484	java/lang/Exception
    //   108	123	484	java/lang/Exception
    //   130	145	484	java/lang/Exception
    //   152	158	484	java/lang/Exception
    //   179	185	484	java/lang/Exception
    //   192	200	484	java/lang/Exception
    //   207	215	484	java/lang/Exception
    //   228	237	484	java/lang/Exception
    //   244	252	484	java/lang/Exception
    //   361	367	484	java/lang/Exception
    //   374	383	484	java/lang/Exception
    //   390	398	484	java/lang/Exception
    //   405	416	484	java/lang/Exception
    //   423	431	484	java/lang/Exception
    //   438	448	484	java/lang/Exception
    //   455	466	484	java/lang/Exception
    //   474	479	552	java/lang/Exception
    //   546	551	552	java/lang/Exception
    //   562	566	569	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    a(paramSQLiteDatabase);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.transaction.impl.NotifyMsgDBHelper
 * JD-Core Version:    0.7.0.1
 */