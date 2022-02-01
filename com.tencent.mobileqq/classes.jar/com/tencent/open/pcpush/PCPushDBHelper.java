package com.tencent.open.pcpush;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;

public class PCPushDBHelper
  extends SQLiteOpenHelper
{
  public static final Uri a = Uri.parse("content://open.pcpush/pcpush_package_info");
  public static final Uri b = Uri.parse("content://open.pcpush/pcpush_package_info/");
  public static final Uri c = Uri.parse("content://open.pcpush/pcpush_package_info//#");
  
  public PCPushDBHelper()
  {
    super(CommonDataAdapter.a().a(), "pcdb", null, 2);
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS pcpush_package_info;");
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      onCreate(paramSQLiteDatabase);
    }
  }
  
  /* Error */
  public void a(PCPushProxy.PkgEntry paramPkgEntry)
  {
    // Byte code:
    //   0: new 70	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   7: astore 5
    //   9: aload 5
    //   11: ldc 74
    //   13: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: pop
    //   17: aload 5
    //   19: aload_1
    //   20: invokevirtual 84	java/lang/Object:toString	()Ljava/lang/String;
    //   23: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: ldc 86
    //   29: aload 5
    //   31: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   34: invokestatic 92	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: aconst_null
    //   38: astore 5
    //   40: aconst_null
    //   41: astore 6
    //   43: aload_0
    //   44: invokevirtual 96	com/tencent/open/pcpush/PCPushDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   47: astore 7
    //   49: aload 7
    //   51: astore 6
    //   53: aload 7
    //   55: astore 5
    //   57: aload 7
    //   59: invokevirtual 49	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   62: aload 7
    //   64: astore 6
    //   66: aload 7
    //   68: astore 5
    //   70: new 98	android/content/ContentValues
    //   73: dup
    //   74: invokespecial 99	android/content/ContentValues:<init>	()V
    //   77: astore 8
    //   79: aload 7
    //   81: astore 6
    //   83: aload 7
    //   85: astore 5
    //   87: aload 8
    //   89: ldc 101
    //   91: aload_1
    //   92: getfield 106	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   95: invokevirtual 109	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 7
    //   100: astore 6
    //   102: aload 7
    //   104: astore 5
    //   106: aload 8
    //   108: ldc 111
    //   110: aload_1
    //   111: getfield 113	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   114: invokevirtual 109	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   117: aload 7
    //   119: astore 6
    //   121: aload 7
    //   123: astore 5
    //   125: aload 8
    //   127: ldc 115
    //   129: aload_1
    //   130: getfield 118	com/tencent/open/pcpush/PCPushProxy$PkgEntry:e	Ljava/lang/String;
    //   133: invokevirtual 109	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 7
    //   138: astore 6
    //   140: aload 7
    //   142: astore 5
    //   144: aload 8
    //   146: ldc 120
    //   148: aload_1
    //   149: getfield 123	com/tencent/open/pcpush/PCPushProxy$PkgEntry:h	Ljava/lang/String;
    //   152: invokevirtual 109	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload 7
    //   157: astore 6
    //   159: aload 7
    //   161: astore 5
    //   163: aload 8
    //   165: ldc 125
    //   167: aload_1
    //   168: getfield 128	com/tencent/open/pcpush/PCPushProxy$PkgEntry:f	Ljava/lang/String;
    //   171: invokevirtual 109	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload 7
    //   176: astore 6
    //   178: aload 7
    //   180: astore 5
    //   182: aload 8
    //   184: ldc 130
    //   186: aload_1
    //   187: getfield 134	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_d_of_type_Int	I
    //   190: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   193: invokevirtual 143	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   196: aload 7
    //   198: astore 6
    //   200: aload 7
    //   202: astore 5
    //   204: aload 8
    //   206: ldc 145
    //   208: aload_1
    //   209: getfield 147	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_b_of_type_Int	I
    //   212: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   215: invokevirtual 143	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   218: aload 7
    //   220: astore 6
    //   222: aload 7
    //   224: astore 5
    //   226: aload 8
    //   228: ldc 149
    //   230: aload_1
    //   231: getfield 152	com/tencent/open/pcpush/PCPushProxy$PkgEntry:g	Ljava/lang/String;
    //   234: invokevirtual 109	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload 7
    //   239: astore 6
    //   241: aload 7
    //   243: astore 5
    //   245: aload 8
    //   247: ldc 154
    //   249: aload_1
    //   250: getfield 156	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   253: invokevirtual 109	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   256: aload 7
    //   258: astore 6
    //   260: aload 7
    //   262: astore 5
    //   264: aload 8
    //   266: ldc 158
    //   268: aload_1
    //   269: getfield 161	com/tencent/open/pcpush/PCPushProxy$PkgEntry:i	Ljava/lang/String;
    //   272: invokevirtual 109	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload 7
    //   277: astore 6
    //   279: aload 7
    //   281: astore 5
    //   283: aload 8
    //   285: ldc 163
    //   287: aload_1
    //   288: getfield 166	com/tencent/open/pcpush/PCPushProxy$PkgEntry:j	Ljava/lang/String;
    //   291: invokevirtual 109	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload 7
    //   296: astore 6
    //   298: aload 7
    //   300: astore 5
    //   302: aload 8
    //   304: ldc 168
    //   306: aload_1
    //   307: getfield 170	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_a_of_type_Int	I
    //   310: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   313: invokevirtual 143	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   316: aload 7
    //   318: astore 6
    //   320: aload 7
    //   322: astore 5
    //   324: aload 8
    //   326: ldc 172
    //   328: aload_1
    //   329: getfield 174	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   332: invokevirtual 109	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   335: aload 7
    //   337: astore 6
    //   339: aload 7
    //   341: astore 5
    //   343: aload 8
    //   345: ldc 101
    //   347: aload_1
    //   348: getfield 106	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   351: invokevirtual 109	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   354: aload 7
    //   356: astore 6
    //   358: aload 7
    //   360: astore 5
    //   362: aload 8
    //   364: ldc 176
    //   366: aload_1
    //   367: getfield 178	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_c_of_type_Int	I
    //   370: invokestatic 140	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   373: invokevirtual 143	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   376: aload 7
    //   378: astore 6
    //   380: aload 7
    //   382: astore 5
    //   384: aload 8
    //   386: ldc 180
    //   388: invokestatic 186	java/lang/System:currentTimeMillis	()J
    //   391: invokestatic 191	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   394: invokevirtual 194	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   397: aload 7
    //   399: astore 6
    //   401: aload 7
    //   403: astore 5
    //   405: aload 7
    //   407: ldc 196
    //   409: aload 8
    //   411: ldc 198
    //   413: iconst_1
    //   414: anewarray 200	java/lang/String
    //   417: dup
    //   418: iconst_0
    //   419: aload_1
    //   420: getfield 106	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   423: aastore
    //   424: invokevirtual 204	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   427: istore_2
    //   428: aload 7
    //   430: astore 6
    //   432: aload 7
    //   434: astore 5
    //   436: new 70	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   443: astore_1
    //   444: aload 7
    //   446: astore 6
    //   448: aload 7
    //   450: astore 5
    //   452: aload_1
    //   453: ldc 206
    //   455: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload 7
    //   461: astore 6
    //   463: aload 7
    //   465: astore 5
    //   467: aload_1
    //   468: iload_2
    //   469: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload 7
    //   475: astore 6
    //   477: aload 7
    //   479: astore 5
    //   481: ldc 86
    //   483: aload_1
    //   484: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   487: invokestatic 211	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   490: iload_2
    //   491: ifne +85 -> 576
    //   494: aload 7
    //   496: astore 6
    //   498: aload 7
    //   500: astore 5
    //   502: aload 7
    //   504: ldc 196
    //   506: ldc 154
    //   508: aload 8
    //   510: invokevirtual 215	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   513: lstore_3
    //   514: aload 7
    //   516: astore 6
    //   518: aload 7
    //   520: astore 5
    //   522: new 70	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   529: astore_1
    //   530: aload 7
    //   532: astore 6
    //   534: aload 7
    //   536: astore 5
    //   538: aload_1
    //   539: ldc 217
    //   541: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 7
    //   547: astore 6
    //   549: aload 7
    //   551: astore 5
    //   553: aload_1
    //   554: lload_3
    //   555: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   558: pop
    //   559: aload 7
    //   561: astore 6
    //   563: aload 7
    //   565: astore 5
    //   567: ldc 86
    //   569: aload_1
    //   570: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: invokestatic 211	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   576: aload 7
    //   578: astore 6
    //   580: aload 7
    //   582: astore 5
    //   584: aload 7
    //   586: invokevirtual 58	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   589: aload 7
    //   591: ifnull +42 -> 633
    //   594: aload 7
    //   596: astore 5
    //   598: goto +25 -> 623
    //   601: astore_1
    //   602: goto +32 -> 634
    //   605: astore_1
    //   606: aload 5
    //   608: astore 6
    //   610: ldc 86
    //   612: ldc 222
    //   614: aload_1
    //   615: invokestatic 225	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   618: aload 5
    //   620: ifnull +13 -> 633
    //   623: aload 5
    //   625: invokevirtual 61	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   628: aload 5
    //   630: invokevirtual 228	android/database/sqlite/SQLiteDatabase:close	()V
    //   633: return
    //   634: aload 6
    //   636: ifnull +13 -> 649
    //   639: aload 6
    //   641: invokevirtual 61	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   644: aload 6
    //   646: invokevirtual 228	android/database/sqlite/SQLiteDatabase:close	()V
    //   649: aload_1
    //   650: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	this	PCPushDBHelper
    //   0	651	1	paramPkgEntry	PCPushProxy.PkgEntry
    //   427	64	2	i	int
    //   513	42	3	l	long
    //   7	622	5	localObject1	Object
    //   41	604	6	localObject2	Object
    //   47	548	7	localSQLiteDatabase	SQLiteDatabase
    //   77	432	8	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   43	49	601	finally
    //   57	62	601	finally
    //   70	79	601	finally
    //   87	98	601	finally
    //   106	117	601	finally
    //   125	136	601	finally
    //   144	155	601	finally
    //   163	174	601	finally
    //   182	196	601	finally
    //   204	218	601	finally
    //   226	237	601	finally
    //   245	256	601	finally
    //   264	275	601	finally
    //   283	294	601	finally
    //   302	316	601	finally
    //   324	335	601	finally
    //   343	354	601	finally
    //   362	376	601	finally
    //   384	397	601	finally
    //   405	428	601	finally
    //   436	444	601	finally
    //   452	459	601	finally
    //   467	473	601	finally
    //   481	490	601	finally
    //   502	514	601	finally
    //   522	530	601	finally
    //   538	545	601	finally
    //   553	559	601	finally
    //   567	576	601	finally
    //   584	589	601	finally
    //   610	618	601	finally
    //   43	49	605	java/lang/Exception
    //   57	62	605	java/lang/Exception
    //   70	79	605	java/lang/Exception
    //   87	98	605	java/lang/Exception
    //   106	117	605	java/lang/Exception
    //   125	136	605	java/lang/Exception
    //   144	155	605	java/lang/Exception
    //   163	174	605	java/lang/Exception
    //   182	196	605	java/lang/Exception
    //   204	218	605	java/lang/Exception
    //   226	237	605	java/lang/Exception
    //   245	256	605	java/lang/Exception
    //   264	275	605	java/lang/Exception
    //   283	294	605	java/lang/Exception
    //   302	316	605	java/lang/Exception
    //   324	335	605	java/lang/Exception
    //   343	354	605	java/lang/Exception
    //   362	376	605	java/lang/Exception
    //   384	397	605	java/lang/Exception
    //   405	428	605	java/lang/Exception
    //   436	444	605	java/lang/Exception
    //   452	459	605	java/lang/Exception
    //   467	473	605	java/lang/Exception
    //   481	490	605	java/lang/Exception
    //   502	514	605	java/lang/Exception
    //   522	530	605	java/lang/Exception
    //   538	545	605	java/lang/Exception
    //   553	559	605	java/lang/Exception
    //   567	576	605	java/lang/Exception
    //   584	589	605	java/lang/Exception
  }
  
  public void a(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("--> delete key = ");
    ((StringBuilder)localObject).append(paramString);
    LogUtility.a("PCPushDBHelper", ((StringBuilder)localObject).toString());
    try
    {
      localObject = getWritableDatabase();
      ((SQLiteDatabase)localObject).delete("pcpush_package_info", "key = ?", new String[] { paramString });
      ((SQLiteDatabase)localObject).close();
      return;
    }
    catch (Exception paramString)
    {
      LogUtility.c("PCPushDBHelper", "deletePkgEntry error", paramString);
    }
  }
  
  /* Error */
  public void a(java.util.concurrent.ConcurrentHashMap<String, PCPushProxy.PkgEntry> paramConcurrentHashMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore_3
    //   8: aconst_null
    //   9: astore 5
    //   11: aload_0
    //   12: invokevirtual 240	com/tencent/open/pcpush/PCPushDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore 4
    //   17: aload 5
    //   19: astore_3
    //   20: aload 4
    //   22: astore 5
    //   24: aload 7
    //   26: astore 6
    //   28: aload 4
    //   30: ldc 196
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: invokevirtual 244	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   41: astore 7
    //   43: aload 7
    //   45: ifnull +557 -> 602
    //   48: aload 7
    //   50: astore_3
    //   51: aload 4
    //   53: astore 5
    //   55: aload 7
    //   57: astore 6
    //   59: aload 7
    //   61: invokeinterface 250 1 0
    //   66: ifle +536 -> 602
    //   69: aload 7
    //   71: astore_3
    //   72: aload 4
    //   74: astore 5
    //   76: aload 7
    //   78: astore 6
    //   80: aload 7
    //   82: invokeinterface 254 1 0
    //   87: pop
    //   88: aload 7
    //   90: astore_3
    //   91: aload 4
    //   93: astore 5
    //   95: aload 7
    //   97: astore 6
    //   99: new 103	com/tencent/open/pcpush/PCPushProxy$PkgEntry
    //   102: dup
    //   103: invokespecial 255	com/tencent/open/pcpush/PCPushProxy$PkgEntry:<init>	()V
    //   106: astore 8
    //   108: aload 7
    //   110: astore_3
    //   111: aload 4
    //   113: astore 5
    //   115: aload 7
    //   117: astore 6
    //   119: aload 8
    //   121: aload 7
    //   123: aload 7
    //   125: ldc 111
    //   127: invokeinterface 259 2 0
    //   132: invokeinterface 263 2 0
    //   137: putfield 113	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   140: aload 7
    //   142: astore_3
    //   143: aload 4
    //   145: astore 5
    //   147: aload 7
    //   149: astore 6
    //   151: aload 8
    //   153: aload 7
    //   155: aload 7
    //   157: ldc 115
    //   159: invokeinterface 259 2 0
    //   164: invokeinterface 263 2 0
    //   169: putfield 118	com/tencent/open/pcpush/PCPushProxy$PkgEntry:e	Ljava/lang/String;
    //   172: aload 7
    //   174: astore_3
    //   175: aload 4
    //   177: astore 5
    //   179: aload 7
    //   181: astore 6
    //   183: aload 8
    //   185: aload 7
    //   187: aload 7
    //   189: ldc 120
    //   191: invokeinterface 259 2 0
    //   196: invokeinterface 263 2 0
    //   201: putfield 123	com/tencent/open/pcpush/PCPushProxy$PkgEntry:h	Ljava/lang/String;
    //   204: aload 7
    //   206: astore_3
    //   207: aload 4
    //   209: astore 5
    //   211: aload 7
    //   213: astore 6
    //   215: aload 8
    //   217: aload 7
    //   219: aload 7
    //   221: ldc 125
    //   223: invokeinterface 259 2 0
    //   228: invokeinterface 263 2 0
    //   233: putfield 128	com/tencent/open/pcpush/PCPushProxy$PkgEntry:f	Ljava/lang/String;
    //   236: aload 7
    //   238: astore_3
    //   239: aload 4
    //   241: astore 5
    //   243: aload 7
    //   245: astore 6
    //   247: aload 8
    //   249: aload 7
    //   251: aload 7
    //   253: ldc 145
    //   255: invokeinterface 259 2 0
    //   260: invokeinterface 267 2 0
    //   265: putfield 147	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_b_of_type_Int	I
    //   268: aload 7
    //   270: astore_3
    //   271: aload 4
    //   273: astore 5
    //   275: aload 7
    //   277: astore 6
    //   279: aload 8
    //   281: aload 7
    //   283: aload 7
    //   285: ldc 149
    //   287: invokeinterface 259 2 0
    //   292: invokeinterface 263 2 0
    //   297: putfield 152	com/tencent/open/pcpush/PCPushProxy$PkgEntry:g	Ljava/lang/String;
    //   300: aload 7
    //   302: astore_3
    //   303: aload 4
    //   305: astore 5
    //   307: aload 7
    //   309: astore 6
    //   311: aload 8
    //   313: aload 7
    //   315: aload 7
    //   317: ldc 154
    //   319: invokeinterface 259 2 0
    //   324: invokeinterface 263 2 0
    //   329: putfield 156	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   332: aload 7
    //   334: astore_3
    //   335: aload 4
    //   337: astore 5
    //   339: aload 7
    //   341: astore 6
    //   343: aload 8
    //   345: aload 7
    //   347: aload 7
    //   349: ldc 158
    //   351: invokeinterface 259 2 0
    //   356: invokeinterface 263 2 0
    //   361: putfield 161	com/tencent/open/pcpush/PCPushProxy$PkgEntry:i	Ljava/lang/String;
    //   364: aload 7
    //   366: astore_3
    //   367: aload 4
    //   369: astore 5
    //   371: aload 7
    //   373: astore 6
    //   375: aload 8
    //   377: aload 7
    //   379: aload 7
    //   381: ldc 163
    //   383: invokeinterface 259 2 0
    //   388: invokeinterface 263 2 0
    //   393: putfield 166	com/tencent/open/pcpush/PCPushProxy$PkgEntry:j	Ljava/lang/String;
    //   396: aload 7
    //   398: astore_3
    //   399: aload 4
    //   401: astore 5
    //   403: aload 7
    //   405: astore 6
    //   407: aload 8
    //   409: aload 7
    //   411: aload 7
    //   413: ldc 168
    //   415: invokeinterface 259 2 0
    //   420: invokeinterface 267 2 0
    //   425: putfield 170	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_a_of_type_Int	I
    //   428: aload 7
    //   430: astore_3
    //   431: aload 4
    //   433: astore 5
    //   435: aload 7
    //   437: astore 6
    //   439: aload 8
    //   441: aload 7
    //   443: aload 7
    //   445: ldc 172
    //   447: invokeinterface 259 2 0
    //   452: invokeinterface 263 2 0
    //   457: putfield 174	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   460: aload 7
    //   462: astore_3
    //   463: aload 4
    //   465: astore 5
    //   467: aload 7
    //   469: astore 6
    //   471: aload 8
    //   473: aload 7
    //   475: aload 7
    //   477: ldc 130
    //   479: invokeinterface 259 2 0
    //   484: invokeinterface 267 2 0
    //   489: putfield 134	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_d_of_type_Int	I
    //   492: aload 7
    //   494: astore_3
    //   495: aload 4
    //   497: astore 5
    //   499: aload 7
    //   501: astore 6
    //   503: aload 8
    //   505: aload 7
    //   507: aload 7
    //   509: ldc 101
    //   511: invokeinterface 259 2 0
    //   516: invokeinterface 263 2 0
    //   521: putfield 106	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   524: aload 7
    //   526: astore_3
    //   527: aload 4
    //   529: astore 5
    //   531: aload 7
    //   533: astore 6
    //   535: aload 8
    //   537: aload 7
    //   539: aload 7
    //   541: ldc 176
    //   543: invokeinterface 259 2 0
    //   548: invokeinterface 267 2 0
    //   553: putfield 178	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_c_of_type_Int	I
    //   556: aload 7
    //   558: astore_3
    //   559: aload 4
    //   561: astore 5
    //   563: aload 7
    //   565: astore 6
    //   567: aload_1
    //   568: aload 8
    //   570: getfield 106	com/tencent/open/pcpush/PCPushProxy$PkgEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   573: aload 8
    //   575: invokevirtual 272	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   578: pop
    //   579: aload 7
    //   581: astore_3
    //   582: aload 4
    //   584: astore 5
    //   586: aload 7
    //   588: astore 6
    //   590: aload 7
    //   592: invokeinterface 275 1 0
    //   597: istore_2
    //   598: iload_2
    //   599: ifne -511 -> 88
    //   602: aload 7
    //   604: ifnull +10 -> 614
    //   607: aload 7
    //   609: invokeinterface 276 1 0
    //   614: aload 4
    //   616: ifnull +71 -> 687
    //   619: aload 4
    //   621: astore_1
    //   622: aload_1
    //   623: invokevirtual 228	android/database/sqlite/SQLiteDatabase:close	()V
    //   626: return
    //   627: astore_1
    //   628: goto +60 -> 688
    //   631: astore_3
    //   632: aload 4
    //   634: astore_1
    //   635: aload_3
    //   636: astore 4
    //   638: goto +14 -> 652
    //   641: astore_1
    //   642: aconst_null
    //   643: astore 5
    //   645: goto +43 -> 688
    //   648: astore 4
    //   650: aconst_null
    //   651: astore_1
    //   652: aload 6
    //   654: astore_3
    //   655: aload_1
    //   656: astore 5
    //   658: ldc 86
    //   660: ldc_w 278
    //   663: aload 4
    //   665: invokestatic 225	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   668: aload 6
    //   670: ifnull +10 -> 680
    //   673: aload 6
    //   675: invokeinterface 276 1 0
    //   680: aload_1
    //   681: ifnull +6 -> 687
    //   684: goto -62 -> 622
    //   687: return
    //   688: aload_3
    //   689: ifnull +9 -> 698
    //   692: aload_3
    //   693: invokeinterface 276 1 0
    //   698: aload 5
    //   700: ifnull +8 -> 708
    //   703: aload 5
    //   705: invokevirtual 228	android/database/sqlite/SQLiteDatabase:close	()V
    //   708: goto +5 -> 713
    //   711: aload_1
    //   712: athrow
    //   713: goto -2 -> 711
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	716	0	this	PCPushDBHelper
    //   0	716	1	paramConcurrentHashMap	java.util.concurrent.ConcurrentHashMap<String, PCPushProxy.PkgEntry>
    //   597	2	2	bool	boolean
    //   7	575	3	localObject1	Object
    //   631	5	3	localException1	Exception
    //   654	39	3	localCursor1	android.database.Cursor
    //   15	622	4	localObject2	Object
    //   648	16	4	localException2	Exception
    //   9	695	5	localObject3	Object
    //   4	670	6	localCursor2	android.database.Cursor
    //   1	607	7	localCursor3	android.database.Cursor
    //   106	468	8	localPkgEntry	PCPushProxy.PkgEntry
    // Exception table:
    //   from	to	target	type
    //   28	43	627	finally
    //   59	69	627	finally
    //   80	88	627	finally
    //   99	108	627	finally
    //   119	140	627	finally
    //   151	172	627	finally
    //   183	204	627	finally
    //   215	236	627	finally
    //   247	268	627	finally
    //   279	300	627	finally
    //   311	332	627	finally
    //   343	364	627	finally
    //   375	396	627	finally
    //   407	428	627	finally
    //   439	460	627	finally
    //   471	492	627	finally
    //   503	524	627	finally
    //   535	556	627	finally
    //   567	579	627	finally
    //   590	598	627	finally
    //   658	668	627	finally
    //   28	43	631	java/lang/Exception
    //   59	69	631	java/lang/Exception
    //   80	88	631	java/lang/Exception
    //   99	108	631	java/lang/Exception
    //   119	140	631	java/lang/Exception
    //   151	172	631	java/lang/Exception
    //   183	204	631	java/lang/Exception
    //   215	236	631	java/lang/Exception
    //   247	268	631	java/lang/Exception
    //   279	300	631	java/lang/Exception
    //   311	332	631	java/lang/Exception
    //   343	364	631	java/lang/Exception
    //   375	396	631	java/lang/Exception
    //   407	428	631	java/lang/Exception
    //   439	460	631	java/lang/Exception
    //   471	492	631	java/lang/Exception
    //   503	524	631	java/lang/Exception
    //   535	556	631	java/lang/Exception
    //   567	579	631	java/lang/Exception
    //   590	598	631	java/lang/Exception
    //   11	17	641	finally
    //   11	17	648	java/lang/Exception
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    LogUtility.a("PCPushDBHelper", "--> start--DatabaseHelper onCreate<<<<");
    paramSQLiteDatabase.execSQL("CREATE TABLE pcpush_package_info (key TEXT PRIMARY KEY,appid TEXT,via TEXT,pkgname TEXT,versioncode INTEGER,appname TEXT,appurl TEXT,iconurl TEXT,appsize TEXT,filetype TEXT,source TEXT,srciconurl TEXT,timestamp INTEGER,installstate INTEGER,downloadtype INTEGER);");
    LogUtility.a("PCPushDBHelper", "--> end--DatabaseHelper onCreate<<<<");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDowngrade oldVersion=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" newVersion=");
    localStringBuilder.append(paramInt2);
    LogUtility.c("PCPushDBHelper", localStringBuilder.toString());
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpgrade oldVersion=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" newVersion=");
    localStringBuilder.append(paramInt2);
    LogUtility.c("PCPushDBHelper", localStringBuilder.toString());
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.pcpush.PCPushDBHelper
 * JD-Core Version:    0.7.0.1
 */