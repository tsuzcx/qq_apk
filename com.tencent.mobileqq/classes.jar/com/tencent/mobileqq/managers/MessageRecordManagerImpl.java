package com.tencent.mobileqq.managers;

public class MessageRecordManagerImpl
  implements MessageRecordManager
{
  /* Error */
  public void a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 5
    //   5: aconst_null
    //   6: astore 6
    //   8: aload_1
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: aload_1
    //   14: invokestatic 20	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   17: astore 8
    //   19: aload 8
    //   21: aload_1
    //   22: invokevirtual 26	com/tencent/mobileqq/persistence/EntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   25: invokevirtual 32	com/tencent/mobileqq/app/SQLiteOpenHelper:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   28: astore 9
    //   30: aload 9
    //   32: ldc 34
    //   34: aconst_null
    //   35: invokevirtual 40	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_3
    //   39: aload_3
    //   40: ifnull +165 -> 205
    //   43: aload_3
    //   44: invokeinterface 46 1 0
    //   49: ifeq +156 -> 205
    //   52: aload 9
    //   54: aload_3
    //   55: iconst_0
    //   56: invokeinterface 50 2 0
    //   61: invokestatic 56	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   64: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   67: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   70: pop
    //   71: goto -28 -> 43
    //   74: astore_2
    //   75: aconst_null
    //   76: astore_2
    //   77: aconst_null
    //   78: astore 4
    //   80: aload_3
    //   81: ifnull +9 -> 90
    //   84: aload_3
    //   85: invokeinterface 68 1 0
    //   90: aload 4
    //   92: ifnull +10 -> 102
    //   95: aload 4
    //   97: invokeinterface 68 1 0
    //   102: aload_2
    //   103: ifnull +9 -> 112
    //   106: aload_2
    //   107: invokeinterface 68 1 0
    //   112: new 70	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory
    //   115: dup
    //   116: aload_1
    //   117: invokespecial 72	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory:<init>	(Ljava/lang/String;)V
    //   120: aload_1
    //   121: invokevirtual 26	com/tencent/mobileqq/persistence/EntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   124: invokevirtual 32	com/tencent/mobileqq/app/SQLiteOpenHelper:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   127: astore 4
    //   129: aload 6
    //   131: astore_1
    //   132: aload 5
    //   134: astore_2
    //   135: aload 4
    //   137: ldc 34
    //   139: aconst_null
    //   140: invokevirtual 40	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   143: astore_3
    //   144: aload_3
    //   145: ifnull +426 -> 571
    //   148: aload_3
    //   149: astore_1
    //   150: aload_3
    //   151: astore_2
    //   152: aload_3
    //   153: invokeinterface 46 1 0
    //   158: ifeq +413 -> 571
    //   161: aload_3
    //   162: astore_1
    //   163: aload_3
    //   164: astore_2
    //   165: aload 4
    //   167: aload_3
    //   168: iconst_0
    //   169: invokeinterface 50 2 0
    //   174: invokestatic 56	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   177: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   180: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   183: pop
    //   184: goto -36 -> 148
    //   187: astore_3
    //   188: aload_1
    //   189: astore_2
    //   190: aload_3
    //   191: invokevirtual 75	java/lang/Exception:printStackTrace	()V
    //   194: aload_1
    //   195: ifnull -183 -> 12
    //   198: aload_1
    //   199: invokeinterface 68 1 0
    //   204: return
    //   205: aload 9
    //   207: ldc 77
    //   209: aconst_null
    //   210: invokevirtual 40	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   213: astore 4
    //   215: aload 4
    //   217: ifnull +36 -> 253
    //   220: aload 4
    //   222: invokeinterface 46 1 0
    //   227: ifeq +26 -> 253
    //   230: aload 9
    //   232: aload 4
    //   234: iconst_0
    //   235: invokeinterface 50 2 0
    //   240: invokestatic 56	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   243: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   246: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   249: pop
    //   250: goto -30 -> 220
    //   253: aload 9
    //   255: ldc 79
    //   257: aconst_null
    //   258: invokevirtual 40	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   261: astore 7
    //   263: aload 7
    //   265: astore_2
    //   266: aload_2
    //   267: ifnull +34 -> 301
    //   270: aload_2
    //   271: invokeinterface 46 1 0
    //   276: ifeq +25 -> 301
    //   279: aload 9
    //   281: aload_2
    //   282: iconst_0
    //   283: invokeinterface 50 2 0
    //   288: invokestatic 56	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   291: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   294: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   297: pop
    //   298: goto -28 -> 270
    //   301: aload 9
    //   303: new 81	com/tencent/mobileqq/data/RecentUser
    //   306: dup
    //   307: invokespecial 82	com/tencent/mobileqq/data/RecentUser:<init>	()V
    //   310: invokevirtual 86	com/tencent/mobileqq/data/RecentUser:getTableName	()Ljava/lang/String;
    //   313: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   316: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   319: pop
    //   320: aload 9
    //   322: new 88	com/tencent/mobileqq/data/QCallRecent
    //   325: dup
    //   326: invokespecial 89	com/tencent/mobileqq/data/QCallRecent:<init>	()V
    //   329: invokevirtual 90	com/tencent/mobileqq/data/QCallRecent:getTableName	()Ljava/lang/String;
    //   332: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   335: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   338: pop
    //   339: aload 9
    //   341: new 92	com/tencent/mobileqq/data/TroopAssistantData
    //   344: dup
    //   345: invokespecial 93	com/tencent/mobileqq/data/TroopAssistantData:<init>	()V
    //   348: invokevirtual 94	com/tencent/mobileqq/data/TroopAssistantData:getTableName	()Ljava/lang/String;
    //   351: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   354: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   357: pop
    //   358: aload 9
    //   360: new 96	com/tencent/mobileqq/data/PubAccountAssistantData
    //   363: dup
    //   364: invokespecial 97	com/tencent/mobileqq/data/PubAccountAssistantData:<init>	()V
    //   367: invokevirtual 98	com/tencent/mobileqq/data/PubAccountAssistantData:getTableName	()Ljava/lang/String;
    //   370: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   373: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   376: pop
    //   377: aload 9
    //   379: new 100	com/tencent/biz/pubaccount/troopbarassit/TroopBarData
    //   382: dup
    //   383: invokespecial 101	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:<init>	()V
    //   386: invokevirtual 102	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:getTableName	()Ljava/lang/String;
    //   389: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   392: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   395: pop
    //   396: aload 9
    //   398: new 104	com/tencent/mobileqq/data/NeedHandleUserData
    //   401: dup
    //   402: invokespecial 105	com/tencent/mobileqq/data/NeedHandleUserData:<init>	()V
    //   405: invokevirtual 106	com/tencent/mobileqq/data/NeedHandleUserData:getTableName	()Ljava/lang/String;
    //   408: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   411: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   414: pop
    //   415: aload 9
    //   417: new 108	com/tencent/mobileqq/data/ConversationInfo
    //   420: dup
    //   421: invokespecial 109	com/tencent/mobileqq/data/ConversationInfo:<init>	()V
    //   424: invokevirtual 110	com/tencent/mobileqq/data/ConversationInfo:getTableName	()Ljava/lang/String;
    //   427: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   430: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   433: pop
    //   434: aload 9
    //   436: new 112	com/tencent/mobileqq/data/RecommendContact
    //   439: dup
    //   440: invokespecial 113	com/tencent/mobileqq/data/RecommendContact:<init>	()V
    //   443: invokevirtual 114	com/tencent/mobileqq/data/RecommendContact:getTableName	()Ljava/lang/String;
    //   446: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   449: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   452: pop
    //   453: aload 9
    //   455: new 116	com/tencent/mobileqq/data/SubAccountInfo
    //   458: dup
    //   459: invokespecial 117	com/tencent/mobileqq/data/SubAccountInfo:<init>	()V
    //   462: invokevirtual 118	com/tencent/mobileqq/data/SubAccountInfo:getTableName	()Ljava/lang/String;
    //   465: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   468: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   471: pop
    //   472: aload 9
    //   474: new 120	com/tencent/mobileqq/data/SubAccountMessage
    //   477: dup
    //   478: invokespecial 121	com/tencent/mobileqq/data/SubAccountMessage:<init>	()V
    //   481: invokevirtual 122	com/tencent/mobileqq/data/SubAccountMessage:getTableName	()Ljava/lang/String;
    //   484: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   487: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   490: pop
    //   491: aload 8
    //   493: invokevirtual 123	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   496: aload_3
    //   497: ifnull +9 -> 506
    //   500: aload_3
    //   501: invokeinterface 68 1 0
    //   506: aload 4
    //   508: ifnull +10 -> 518
    //   511: aload 4
    //   513: invokeinterface 68 1 0
    //   518: aload_2
    //   519: ifnull -407 -> 112
    //   522: aload_2
    //   523: invokeinterface 68 1 0
    //   528: goto -416 -> 112
    //   531: astore_1
    //   532: aconst_null
    //   533: astore 4
    //   535: aconst_null
    //   536: astore_3
    //   537: aload_3
    //   538: ifnull +9 -> 547
    //   541: aload_3
    //   542: invokeinterface 68 1 0
    //   547: aload 4
    //   549: ifnull +10 -> 559
    //   552: aload 4
    //   554: invokeinterface 68 1 0
    //   559: aload_2
    //   560: ifnull +9 -> 569
    //   563: aload_2
    //   564: invokeinterface 68 1 0
    //   569: aload_1
    //   570: athrow
    //   571: aload_3
    //   572: ifnull -560 -> 12
    //   575: aload_3
    //   576: invokeinterface 68 1 0
    //   581: return
    //   582: astore_1
    //   583: aload_2
    //   584: ifnull +9 -> 593
    //   587: aload_2
    //   588: invokeinterface 68 1 0
    //   593: aload_1
    //   594: athrow
    //   595: astore_1
    //   596: aconst_null
    //   597: astore 4
    //   599: goto -62 -> 537
    //   602: astore_1
    //   603: goto -66 -> 537
    //   606: astore_1
    //   607: goto -70 -> 537
    //   610: astore_2
    //   611: aconst_null
    //   612: astore_2
    //   613: aconst_null
    //   614: astore 4
    //   616: aconst_null
    //   617: astore_3
    //   618: goto -538 -> 80
    //   621: astore_2
    //   622: aconst_null
    //   623: astore_2
    //   624: goto -544 -> 80
    //   627: astore 7
    //   629: goto -549 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	632	0	this	MessageRecordManagerImpl
    //   0	632	1	paramString	java.lang.String
    //   1	1	2	localObject1	Object
    //   74	1	2	localException1	java.lang.Exception
    //   76	512	2	localObject2	Object
    //   610	1	2	localException2	java.lang.Exception
    //   612	1	2	localObject3	Object
    //   621	1	2	localException3	java.lang.Exception
    //   623	1	2	localObject4	Object
    //   38	130	3	localCursor1	android.database.Cursor
    //   187	314	3	localException4	java.lang.Exception
    //   536	82	3	localObject5	Object
    //   78	537	4	localObject6	Object
    //   3	130	5	localObject7	Object
    //   6	124	6	localObject8	Object
    //   261	3	7	localCursor2	android.database.Cursor
    //   627	1	7	localException5	java.lang.Exception
    //   17	475	8	localQQEntityManagerFactoryProxy	com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy
    //   28	445	9	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   43	71	74	java/lang/Exception
    //   205	215	74	java/lang/Exception
    //   135	144	187	java/lang/Exception
    //   152	161	187	java/lang/Exception
    //   165	184	187	java/lang/Exception
    //   30	39	531	finally
    //   135	144	582	finally
    //   152	161	582	finally
    //   165	184	582	finally
    //   190	194	582	finally
    //   43	71	595	finally
    //   205	215	595	finally
    //   220	250	602	finally
    //   253	263	602	finally
    //   270	298	606	finally
    //   301	496	606	finally
    //   30	39	610	java/lang/Exception
    //   220	250	621	java/lang/Exception
    //   253	263	621	java/lang/Exception
    //   270	298	627	java/lang/Exception
    //   301	496	627	java/lang/Exception
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.managers.MessageRecordManagerImpl
 * JD-Core Version:    0.7.0.1
 */