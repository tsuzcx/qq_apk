package com.tencent.mobileqq.managers;

public class MessageRecordManagerImpl
  implements MessageRecordManager
{
  /* Error */
  public void a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokestatic 20	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   9: astore 5
    //   11: aload 5
    //   13: aload_1
    //   14: invokevirtual 26	com/tencent/mobileqq/persistence/EntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   17: invokevirtual 32	com/tencent/mobileqq/app/SQLiteOpenHelper:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   20: astore 8
    //   22: aconst_null
    //   23: astore 6
    //   25: aconst_null
    //   26: astore 7
    //   28: aload 8
    //   30: ldc 34
    //   32: aconst_null
    //   33: invokevirtual 40	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore_2
    //   37: aload_2
    //   38: ifnull +34 -> 72
    //   41: aload_2
    //   42: invokeinterface 46 1 0
    //   47: ifeq +25 -> 72
    //   50: aload 8
    //   52: aload_2
    //   53: iconst_0
    //   54: invokeinterface 50 2 0
    //   59: invokestatic 56	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   62: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   65: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   68: pop
    //   69: goto -28 -> 41
    //   72: aload 8
    //   74: ldc 67
    //   76: aconst_null
    //   77: invokevirtual 40	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   80: astore 4
    //   82: aload 4
    //   84: ifnull +36 -> 120
    //   87: aload 4
    //   89: invokeinterface 46 1 0
    //   94: ifeq +26 -> 120
    //   97: aload 8
    //   99: aload 4
    //   101: iconst_0
    //   102: invokeinterface 50 2 0
    //   107: invokestatic 56	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   110: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   113: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   116: pop
    //   117: goto -30 -> 87
    //   120: aload 8
    //   122: ldc 69
    //   124: aconst_null
    //   125: invokevirtual 40	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   128: astore_3
    //   129: aload_3
    //   130: ifnull +34 -> 164
    //   133: aload_3
    //   134: invokeinterface 46 1 0
    //   139: ifeq +25 -> 164
    //   142: aload 8
    //   144: aload_3
    //   145: iconst_0
    //   146: invokeinterface 50 2 0
    //   151: invokestatic 56	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   154: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   157: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   160: pop
    //   161: goto -28 -> 133
    //   164: aload 8
    //   166: new 71	com/tencent/mobileqq/data/RecentUser
    //   169: dup
    //   170: invokespecial 72	com/tencent/mobileqq/data/RecentUser:<init>	()V
    //   173: invokevirtual 76	com/tencent/mobileqq/data/RecentUser:getTableName	()Ljava/lang/String;
    //   176: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   179: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   182: pop
    //   183: aload 8
    //   185: new 78	com/tencent/mobileqq/data/QCallRecent
    //   188: dup
    //   189: invokespecial 79	com/tencent/mobileqq/data/QCallRecent:<init>	()V
    //   192: invokevirtual 80	com/tencent/mobileqq/data/QCallRecent:getTableName	()Ljava/lang/String;
    //   195: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   198: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   201: pop
    //   202: aload 8
    //   204: new 82	com/tencent/mobileqq/data/TroopAssistantData
    //   207: dup
    //   208: invokespecial 83	com/tencent/mobileqq/data/TroopAssistantData:<init>	()V
    //   211: invokevirtual 84	com/tencent/mobileqq/data/TroopAssistantData:getTableName	()Ljava/lang/String;
    //   214: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   217: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   220: pop
    //   221: aload 8
    //   223: new 86	com/tencent/mobileqq/data/PubAccountAssistantData
    //   226: dup
    //   227: invokespecial 87	com/tencent/mobileqq/data/PubAccountAssistantData:<init>	()V
    //   230: invokevirtual 88	com/tencent/mobileqq/data/PubAccountAssistantData:getTableName	()Ljava/lang/String;
    //   233: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   236: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   239: pop
    //   240: aload 8
    //   242: new 90	com/tencent/biz/pubaccount/troopbarassit/TroopBarData
    //   245: dup
    //   246: invokespecial 91	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:<init>	()V
    //   249: invokevirtual 92	com/tencent/biz/pubaccount/troopbarassit/TroopBarData:getTableName	()Ljava/lang/String;
    //   252: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   255: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   258: pop
    //   259: aload 8
    //   261: new 94	com/tencent/mobileqq/data/NeedHandleUserData
    //   264: dup
    //   265: invokespecial 95	com/tencent/mobileqq/data/NeedHandleUserData:<init>	()V
    //   268: invokevirtual 96	com/tencent/mobileqq/data/NeedHandleUserData:getTableName	()Ljava/lang/String;
    //   271: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   274: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   277: pop
    //   278: aload 8
    //   280: new 98	com/tencent/mobileqq/data/ConversationInfo
    //   283: dup
    //   284: invokespecial 99	com/tencent/mobileqq/data/ConversationInfo:<init>	()V
    //   287: invokevirtual 100	com/tencent/mobileqq/data/ConversationInfo:getTableName	()Ljava/lang/String;
    //   290: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   293: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   296: pop
    //   297: aload 8
    //   299: new 102	com/tencent/mobileqq/phonecontact/data/RecommendContact
    //   302: dup
    //   303: invokespecial 103	com/tencent/mobileqq/phonecontact/data/RecommendContact:<init>	()V
    //   306: invokevirtual 104	com/tencent/mobileqq/phonecontact/data/RecommendContact:getTableName	()Ljava/lang/String;
    //   309: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   312: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   315: pop
    //   316: aload 8
    //   318: new 106	com/tencent/mobileqq/data/SubAccountInfo
    //   321: dup
    //   322: invokespecial 107	com/tencent/mobileqq/data/SubAccountInfo:<init>	()V
    //   325: invokevirtual 108	com/tencent/mobileqq/data/SubAccountInfo:getTableName	()Ljava/lang/String;
    //   328: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   331: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   334: pop
    //   335: aload 8
    //   337: new 110	com/tencent/mobileqq/data/SubAccountMessage
    //   340: dup
    //   341: invokespecial 111	com/tencent/mobileqq/data/SubAccountMessage:<init>	()V
    //   344: invokevirtual 112	com/tencent/mobileqq/data/SubAccountMessage:getTableName	()Ljava/lang/String;
    //   347: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   350: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   353: pop
    //   354: aload 5
    //   356: invokevirtual 115	com/tencent/mobileqq/persistence/EntityManagerFactory:close	()V
    //   359: aload_2
    //   360: ifnull +9 -> 369
    //   363: aload_2
    //   364: invokeinterface 116 1 0
    //   369: aload 4
    //   371: ifnull +10 -> 381
    //   374: aload 4
    //   376: invokeinterface 116 1 0
    //   381: aload_3
    //   382: ifnull +102 -> 484
    //   385: aload_3
    //   386: astore_2
    //   387: goto +91 -> 478
    //   390: astore_1
    //   391: aconst_null
    //   392: astore_2
    //   393: aconst_null
    //   394: astore 4
    //   396: aconst_null
    //   397: astore_3
    //   398: goto +18 -> 416
    //   401: aconst_null
    //   402: astore_2
    //   403: aconst_null
    //   404: astore 4
    //   406: aconst_null
    //   407: astore_3
    //   408: aload_2
    //   409: astore 5
    //   411: aload_3
    //   412: astore_2
    //   413: goto +37 -> 450
    //   416: aload_2
    //   417: ifnull +9 -> 426
    //   420: aload_2
    //   421: invokeinterface 116 1 0
    //   426: aload 4
    //   428: ifnull +10 -> 438
    //   431: aload 4
    //   433: invokeinterface 116 1 0
    //   438: aload_3
    //   439: ifnull +9 -> 448
    //   442: aload_3
    //   443: invokeinterface 116 1 0
    //   448: aload_1
    //   449: athrow
    //   450: aload 5
    //   452: ifnull +10 -> 462
    //   455: aload 5
    //   457: invokeinterface 116 1 0
    //   462: aload 4
    //   464: ifnull +10 -> 474
    //   467: aload 4
    //   469: invokeinterface 116 1 0
    //   474: aload_2
    //   475: ifnull +9 -> 484
    //   478: aload_2
    //   479: invokeinterface 116 1 0
    //   484: new 118	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory
    //   487: dup
    //   488: aload_1
    //   489: invokespecial 120	com/tencent/mobileqq/persistence/qslowtable/QSlowTableEntityManagerFactory:<init>	(Ljava/lang/String;)V
    //   492: aload_1
    //   493: invokevirtual 26	com/tencent/mobileqq/persistence/EntityManagerFactory:build	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/SQLiteOpenHelper;
    //   496: invokevirtual 32	com/tencent/mobileqq/app/SQLiteOpenHelper:getWritableDatabase	()Lcom/tencent/mobileqq/app/SQLiteDatabase;
    //   499: astore 4
    //   501: aload 7
    //   503: astore_2
    //   504: aload 6
    //   506: astore_1
    //   507: aload 4
    //   509: ldc 34
    //   511: aconst_null
    //   512: invokevirtual 40	com/tencent/mobileqq/app/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   515: astore_3
    //   516: aload_3
    //   517: ifnull +42 -> 559
    //   520: aload_3
    //   521: astore_2
    //   522: aload_3
    //   523: astore_1
    //   524: aload_3
    //   525: invokeinterface 46 1 0
    //   530: ifeq +29 -> 559
    //   533: aload_3
    //   534: astore_2
    //   535: aload_3
    //   536: astore_1
    //   537: aload 4
    //   539: aload_3
    //   540: iconst_0
    //   541: invokeinterface 50 2 0
    //   546: invokestatic 56	com/tencent/mobileqq/utils/SecurityUtile:encode	(Ljava/lang/String;)Ljava/lang/String;
    //   549: invokestatic 61	com/tencent/mobileqq/persistence/TableBuilder:dropSQLStatement	(Ljava/lang/String;)Ljava/lang/String;
    //   552: invokevirtual 65	com/tencent/mobileqq/app/SQLiteDatabase:execSQL	(Ljava/lang/String;)Z
    //   555: pop
    //   556: goto -36 -> 520
    //   559: aload_3
    //   560: ifnull +29 -> 589
    //   563: aload_3
    //   564: astore_1
    //   565: goto +18 -> 583
    //   568: astore_1
    //   569: goto +21 -> 590
    //   572: astore_3
    //   573: aload_1
    //   574: astore_2
    //   575: aload_3
    //   576: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   579: aload_1
    //   580: ifnull +9 -> 589
    //   583: aload_1
    //   584: invokeinterface 116 1 0
    //   589: return
    //   590: aload_2
    //   591: ifnull +9 -> 600
    //   594: aload_2
    //   595: invokeinterface 116 1 0
    //   600: goto +5 -> 605
    //   603: aload_1
    //   604: athrow
    //   605: goto -2 -> 603
    //   608: astore_2
    //   609: goto -208 -> 401
    //   612: astore_3
    //   613: goto +16 -> 629
    //   616: astore_3
    //   617: goto +21 -> 638
    //   620: astore 5
    //   622: goto +30 -> 652
    //   625: astore_1
    //   626: goto -233 -> 393
    //   629: goto -226 -> 403
    //   632: astore_1
    //   633: aconst_null
    //   634: astore_3
    //   635: goto -219 -> 416
    //   638: aconst_null
    //   639: astore_3
    //   640: aload_2
    //   641: astore 5
    //   643: aload_3
    //   644: astore_2
    //   645: goto -195 -> 450
    //   648: astore_1
    //   649: goto -233 -> 416
    //   652: aload_2
    //   653: astore 5
    //   655: aload_3
    //   656: astore_2
    //   657: goto -207 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	660	0	this	MessageRecordManagerImpl
    //   0	660	1	paramString	java.lang.String
    //   36	559	2	localObject1	Object
    //   608	33	2	localException1	java.lang.Exception
    //   644	13	2	localObject2	Object
    //   128	436	3	localCursor	android.database.Cursor
    //   572	4	3	localException2	java.lang.Exception
    //   612	1	3	localException3	java.lang.Exception
    //   616	1	3	localException4	java.lang.Exception
    //   634	22	3	localObject3	Object
    //   80	458	4	localObject4	Object
    //   9	447	5	localObject5	Object
    //   620	1	5	localException5	java.lang.Exception
    //   641	13	5	localObject6	Object
    //   23	482	6	localObject7	Object
    //   26	476	7	localObject8	Object
    //   20	316	8	localSQLiteDatabase	com.tencent.mobileqq.app.SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   28	37	390	finally
    //   507	516	568	finally
    //   524	533	568	finally
    //   537	556	568	finally
    //   575	579	568	finally
    //   507	516	572	java/lang/Exception
    //   524	533	572	java/lang/Exception
    //   537	556	572	java/lang/Exception
    //   28	37	608	java/lang/Exception
    //   41	69	612	java/lang/Exception
    //   72	82	612	java/lang/Exception
    //   87	117	616	java/lang/Exception
    //   120	129	616	java/lang/Exception
    //   133	161	620	java/lang/Exception
    //   164	359	620	java/lang/Exception
    //   41	69	625	finally
    //   72	82	625	finally
    //   87	117	632	finally
    //   120	129	632	finally
    //   133	161	648	finally
    //   164	359	648	finally
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.managers.MessageRecordManagerImpl
 * JD-Core Version:    0.7.0.1
 */