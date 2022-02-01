package com.tencent.open.business.cgireport;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import java.util.ArrayList;
import java.util.Iterator;

public class ReportDataModal
{
  protected static final String a = "com.tencent.open.business.cgireport.ReportDataModal";
  protected SQLiteDatabase a;
  protected ReportDataModal.DataBaseHelper a;
  
  public ReportDataModal()
  {
    this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper = new ReportDataModal.DataBaseHelper(this, CommonDataAdapter.a().a(), "agent_cgi_report.db", null, 4);
  }
  
  /* Error */
  private ArrayList<reportItem> a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 38
    //   4: ldc 40
    //   6: invokestatic 46	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: new 48	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 49	java/util/ArrayList:<init>	()V
    //   16: astore 7
    //   18: aload_0
    //   19: aload_0
    //   20: getfield 33	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper	Lcom/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper;
    //   23: invokevirtual 53	com/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: putfield 55	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   29: aconst_null
    //   30: astore 6
    //   32: aconst_null
    //   33: astore 5
    //   35: aload 5
    //   37: astore 4
    //   39: aload 6
    //   41: astore_3
    //   42: aload_0
    //   43: getfield 55	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   46: astore 8
    //   48: aload 5
    //   50: astore 4
    //   52: aload 6
    //   54: astore_3
    //   55: new 57	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   62: astore 9
    //   64: aload 5
    //   66: astore 4
    //   68: aload 6
    //   70: astore_3
    //   71: aload 9
    //   73: ldc 60
    //   75: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: aload 5
    //   81: astore 4
    //   83: aload 6
    //   85: astore_3
    //   86: aload 9
    //   88: aload_1
    //   89: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 5
    //   95: astore 4
    //   97: aload 6
    //   99: astore_3
    //   100: aload 9
    //   102: ldc 66
    //   104: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 5
    //   110: astore 4
    //   112: aload 6
    //   114: astore_3
    //   115: aload 9
    //   117: ldc 68
    //   119: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 5
    //   125: astore 4
    //   127: aload 6
    //   129: astore_3
    //   130: aload 9
    //   132: ldc 70
    //   134: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: pop
    //   138: aload 5
    //   140: astore 4
    //   142: aload 6
    //   144: astore_3
    //   145: aload 8
    //   147: aload 9
    //   149: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: iconst_1
    //   153: anewarray 76	java/lang/String
    //   156: dup
    //   157: iconst_0
    //   158: aload_2
    //   159: aastore
    //   160: invokevirtual 82	android/database/sqlite/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;
    //   163: astore 5
    //   165: aload 5
    //   167: ifnull +322 -> 489
    //   170: aload 5
    //   172: astore 4
    //   174: aload 5
    //   176: astore_3
    //   177: aload 5
    //   179: invokeinterface 88 1 0
    //   184: pop
    //   185: aload 5
    //   187: astore 4
    //   189: aload 5
    //   191: astore_3
    //   192: aload 5
    //   194: invokeinterface 91 1 0
    //   199: ifne +290 -> 489
    //   202: aload 5
    //   204: astore 4
    //   206: aload 5
    //   208: astore_3
    //   209: aload 5
    //   211: aload 5
    //   213: ldc 93
    //   215: invokeinterface 97 2 0
    //   220: invokeinterface 101 2 0
    //   225: astore 6
    //   227: aload 5
    //   229: astore 4
    //   231: aload 5
    //   233: astore_3
    //   234: aload 5
    //   236: aload 5
    //   238: ldc 103
    //   240: invokeinterface 97 2 0
    //   245: invokeinterface 101 2 0
    //   250: astore 8
    //   252: aload 5
    //   254: astore 4
    //   256: aload 5
    //   258: astore_3
    //   259: aload 5
    //   261: aload 5
    //   263: ldc 105
    //   265: invokeinterface 97 2 0
    //   270: invokeinterface 101 2 0
    //   275: astore 9
    //   277: aload 5
    //   279: astore 4
    //   281: aload 5
    //   283: astore_3
    //   284: aload 5
    //   286: aload 5
    //   288: ldc 107
    //   290: invokeinterface 97 2 0
    //   295: invokeinterface 101 2 0
    //   300: astore 10
    //   302: aload 5
    //   304: astore 4
    //   306: aload 5
    //   308: astore_3
    //   309: aload 5
    //   311: aload 5
    //   313: ldc 109
    //   315: invokeinterface 97 2 0
    //   320: invokeinterface 101 2 0
    //   325: astore 11
    //   327: aload 5
    //   329: astore 4
    //   331: aload 5
    //   333: astore_3
    //   334: aload 5
    //   336: aload 5
    //   338: ldc 111
    //   340: invokeinterface 97 2 0
    //   345: invokeinterface 101 2 0
    //   350: astore 12
    //   352: aload 5
    //   354: astore 4
    //   356: aload 5
    //   358: astore_3
    //   359: aload 5
    //   361: aload 5
    //   363: ldc 113
    //   365: invokeinterface 97 2 0
    //   370: invokeinterface 101 2 0
    //   375: astore 13
    //   377: aload 5
    //   379: astore 4
    //   381: aload 5
    //   383: astore_3
    //   384: aload 5
    //   386: aload 5
    //   388: ldc 115
    //   390: invokeinterface 97 2 0
    //   395: invokeinterface 101 2 0
    //   400: astore 14
    //   402: aload 5
    //   404: astore 4
    //   406: aload 5
    //   408: astore_3
    //   409: aload 7
    //   411: new 117	com/tencent/open/business/cgireport/reportItem
    //   414: dup
    //   415: aload 6
    //   417: aload 8
    //   419: aload 9
    //   421: aload 10
    //   423: aload 11
    //   425: aload 12
    //   427: aload 13
    //   429: aload 5
    //   431: aload 5
    //   433: ldc 119
    //   435: invokeinterface 97 2 0
    //   440: invokeinterface 101 2 0
    //   445: aload 5
    //   447: aload 5
    //   449: ldc 121
    //   451: invokeinterface 97 2 0
    //   456: invokeinterface 101 2 0
    //   461: aload 14
    //   463: aload_2
    //   464: invokespecial 124	com/tencent/open/business/cgireport/reportItem:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   467: invokevirtual 128	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   470: pop
    //   471: aload 5
    //   473: astore 4
    //   475: aload 5
    //   477: astore_3
    //   478: aload 5
    //   480: invokeinterface 131 1 0
    //   485: pop
    //   486: goto -301 -> 185
    //   489: aload 5
    //   491: ifnull +93 -> 584
    //   494: aload 5
    //   496: astore_3
    //   497: aload_3
    //   498: invokeinterface 134 1 0
    //   503: goto +81 -> 584
    //   506: astore_1
    //   507: goto +136 -> 643
    //   510: astore_2
    //   511: aload_3
    //   512: astore 4
    //   514: getstatic 136	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   517: astore 5
    //   519: aload_3
    //   520: astore 4
    //   522: new 57	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   529: astore 6
    //   531: aload_3
    //   532: astore 4
    //   534: aload 6
    //   536: ldc 138
    //   538: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_3
    //   543: astore 4
    //   545: aload 6
    //   547: aload_1
    //   548: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: aload_3
    //   553: astore 4
    //   555: aload 6
    //   557: ldc 140
    //   559: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: pop
    //   563: aload_3
    //   564: astore 4
    //   566: aload 5
    //   568: aload 6
    //   570: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   573: aload_2
    //   574: invokestatic 143	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   577: aload_3
    //   578: ifnull +6 -> 584
    //   581: goto -84 -> 497
    //   584: aload_0
    //   585: getfield 55	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   588: invokevirtual 144	android/database/sqlite/SQLiteDatabase:close	()V
    //   591: new 57	java/lang/StringBuilder
    //   594: dup
    //   595: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   598: astore_2
    //   599: aload_2
    //   600: ldc 138
    //   602: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload_2
    //   607: aload_1
    //   608: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload_2
    //   613: ldc 146
    //   615: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload_2
    //   620: aload 7
    //   622: invokevirtual 150	java/util/ArrayList:size	()I
    //   625: invokevirtual 153	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: ldc 38
    //   631: aload_2
    //   632: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   635: invokestatic 46	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   638: aload_0
    //   639: monitorexit
    //   640: aload 7
    //   642: areturn
    //   643: aload 4
    //   645: ifnull +10 -> 655
    //   648: aload 4
    //   650: invokeinterface 134 1 0
    //   655: aload_1
    //   656: athrow
    //   657: astore_1
    //   658: getstatic 136	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   661: ldc 155
    //   663: aload_1
    //   664: invokestatic 143	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   667: aload_0
    //   668: monitorexit
    //   669: aload 7
    //   671: areturn
    //   672: astore_1
    //   673: aload_0
    //   674: monitorexit
    //   675: goto +5 -> 680
    //   678: aload_1
    //   679: athrow
    //   680: goto -2 -> 678
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	683	0	this	ReportDataModal
    //   0	683	1	paramString1	String
    //   0	683	2	paramString2	String
    //   41	537	3	localObject1	Object
    //   37	612	4	localObject2	Object
    //   33	534	5	localObject3	Object
    //   30	539	6	localObject4	Object
    //   16	654	7	localArrayList	ArrayList
    //   46	372	8	localObject5	Object
    //   62	358	9	localObject6	Object
    //   300	122	10	str1	String
    //   325	99	11	str2	String
    //   350	76	12	str3	String
    //   375	53	13	str4	String
    //   400	62	14	str5	String
    // Exception table:
    //   from	to	target	type
    //   42	48	506	finally
    //   55	64	506	finally
    //   71	79	506	finally
    //   86	93	506	finally
    //   100	108	506	finally
    //   115	123	506	finally
    //   130	138	506	finally
    //   145	165	506	finally
    //   177	185	506	finally
    //   192	202	506	finally
    //   209	227	506	finally
    //   234	252	506	finally
    //   259	277	506	finally
    //   284	302	506	finally
    //   309	327	506	finally
    //   334	352	506	finally
    //   359	377	506	finally
    //   384	402	506	finally
    //   409	471	506	finally
    //   478	486	506	finally
    //   514	519	506	finally
    //   522	531	506	finally
    //   534	542	506	finally
    //   545	552	506	finally
    //   555	563	506	finally
    //   566	577	506	finally
    //   42	48	510	java/lang/Exception
    //   55	64	510	java/lang/Exception
    //   71	79	510	java/lang/Exception
    //   86	93	510	java/lang/Exception
    //   100	108	510	java/lang/Exception
    //   115	123	510	java/lang/Exception
    //   130	138	510	java/lang/Exception
    //   145	165	510	java/lang/Exception
    //   177	185	510	java/lang/Exception
    //   192	202	510	java/lang/Exception
    //   209	227	510	java/lang/Exception
    //   234	252	510	java/lang/Exception
    //   259	277	510	java/lang/Exception
    //   284	302	510	java/lang/Exception
    //   309	327	510	java/lang/Exception
    //   334	352	510	java/lang/Exception
    //   359	377	510	java/lang/Exception
    //   384	402	510	java/lang/Exception
    //   409	471	510	java/lang/Exception
    //   478	486	510	java/lang/Exception
    //   18	29	657	java/lang/Exception
    //   2	18	672	finally
    //   18	29	672	finally
    //   497	503	672	finally
    //   584	638	672	finally
    //   648	655	672	finally
    //   655	657	672	finally
    //   658	667	672	finally
  }
  
  public int a(String paramString)
  {
    try
    {
      int i = a("newdata_report", paramString) + 0;
      Object localObject = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new_table>>count=");
      localStringBuilder.append(i);
      LogUtility.b((String)localObject, localStringBuilder.toString());
      i += a("olddata_report", paramString);
      paramString = jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("all_table>>>count=");
      ((StringBuilder)localObject).append(i);
      LogUtility.b(paramString, ((StringBuilder)localObject).toString());
      return i;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString2);
      arrayOfString = null;
      if (!bool) {
        break label137;
      }
      str = null;
    }
    finally
    {
      label137:
      label144:
      for (;;)
      {
        String[] arrayOfString;
        for (;;)
        {
          throw paramString1;
        }
        String str = "appid=?";
      }
    }
    if (TextUtils.isEmpty(paramString2))
    {
      paramString2 = arrayOfString;
    }
    else
    {
      arrayOfString = new String[1];
      arrayOfString[0] = paramString2;
      paramString2 = arrayOfString;
      break label144;
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper.getReadableDatabase();
        try
        {
          paramString1 = this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.query(paramString1, null, str, paramString2, null, null, null);
          int i = paramString1.getCount();
          paramString1.close();
          return i;
        }
        catch (Exception paramString1)
        {
          LogUtility.c(jdField_a_of_type_JavaLangString, paramString1.getLocalizedMessage(), paramString1);
          return 0;
        }
        paramString1 = finally;
      }
      catch (Exception paramString1)
      {
        LogUtility.a(jdField_a_of_type_JavaLangString, "getOldItems>>>", paramString1);
        return 0;
      }
    }
  }
  
  public int a(ArrayList<reportItem> paramArrayList)
  {
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ReportDataModal backupOldItems count = ");
      ((StringBuilder)localObject).append(paramArrayList.size());
      LogUtility.b("cgi_report_debug", ((StringBuilder)localObject).toString());
      i = 0;
      paramArrayList = new ArrayList(paramArrayList).iterator();
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        int i;
        ContentValues localContentValues;
        for (;;)
        {
          throw paramArrayList;
        }
        i += 1;
      }
    }
    if (paramArrayList.hasNext())
    {
      localObject = (reportItem)paramArrayList.next();
      localContentValues = new ContentValues();
      localContentValues.put("apn", ((reportItem)localObject).jdField_a_of_type_JavaLangString);
      localContentValues.put("frequency", ((reportItem)localObject).b);
      localContentValues.put("commandid", ((reportItem)localObject).c);
      localContentValues.put("resultcode", ((reportItem)localObject).d);
      localContentValues.put("tmcost", ((reportItem)localObject).e);
      localContentValues.put("reqsize", ((reportItem)localObject).f);
      localContentValues.put("rspsize", ((reportItem)localObject).g);
      localContentValues.put("touin", ((reportItem)localObject).h);
      localContentValues.put("deviceinfo", ((reportItem)localObject).i);
      localContentValues.put("detail", ((reportItem)localObject).j);
      localContentValues.put("appid", ((reportItem)localObject).k);
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper.getWritableDatabase();
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insertOrThrow("olddata_report", null, localContentValues);
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
      }
      catch (Exception localException)
      {
        LogUtility.c(jdField_a_of_type_JavaLangString, "update>>>", localException);
      }
    }
    else
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("ReportDataModal backupOldItems succ_count = ");
      paramArrayList.append(i);
      LogUtility.b("cgi_report_debug", paramArrayList.toString());
      return i;
    }
  }
  
  public ArrayList<reportItem> a(String paramString)
  {
    try
    {
      paramString = a("newdata_report", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 38
    //   4: ldc_w 262
    //   7: invokestatic 46	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: aload_0
    //   12: getfield 33	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper	Lcom/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper;
    //   15: invokevirtual 246	com/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: putfield 55	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   21: new 57	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   28: astore_2
    //   29: aload_2
    //   30: ldc_w 264
    //   33: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_2
    //   38: aload_1
    //   39: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: ldc_w 266
    //   47: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 55	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   60: aload_1
    //   61: invokevirtual 270	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 55	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   68: invokevirtual 144	android/database/sqlite/SQLiteDatabase:close	()V
    //   71: ldc 38
    //   73: ldc_w 272
    //   76: invokestatic 46	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: monitorexit
    //   81: iconst_1
    //   82: ireturn
    //   83: astore_1
    //   84: getstatic 136	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   87: ldc_w 274
    //   90: aload_1
    //   91: invokestatic 143	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: aload_0
    //   95: getfield 55	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   98: invokevirtual 144	android/database/sqlite/SQLiteDatabase:close	()V
    //   101: aload_0
    //   102: monitorexit
    //   103: iconst_0
    //   104: ireturn
    //   105: astore_1
    //   106: getstatic 136	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   109: ldc_w 274
    //   112: aload_1
    //   113: invokestatic 143	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   116: aload_0
    //   117: monitorexit
    //   118: iconst_0
    //   119: ireturn
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	ReportDataModal
    //   0	125	1	paramString	String
    //   28	24	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   56	64	83	java/lang/Exception
    //   10	21	105	java/lang/Exception
    //   2	10	120	finally
    //   10	21	120	finally
    //   21	56	120	finally
    //   56	64	120	finally
    //   64	79	120	finally
    //   84	101	120	finally
    //   106	116	120	finally
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    String str = paramString3;
    for (;;)
    {
      try
      {
        if (paramString3.contains("?")) {
          str = paramString3.split("\\?")[0];
        }
        paramString3 = new StringBuilder();
        paramString3.append("ReportDataModal addNewItem apn=");
        paramString3.append(paramString1);
        paramString3.append(",frequency=");
        paramString3.append(paramString2);
        paramString3.append(",commandid=");
        paramString3.append(str);
        paramString3.append(",resultCode=");
        paramString3.append(paramString4);
        paramString3.append(",costTime=");
        paramString3.append(paramString5);
        paramString3.append(",reqSzie=");
        paramString3.append(paramString6);
        paramString3.append(",rspSize=");
        paramString3.append(paramString7);
        LogUtility.b("cgi_report_debug", paramString3.toString());
        paramString3 = new ContentValues();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append("");
        paramString3.put("apn", localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString2);
        localStringBuilder.append("");
        paramString3.put("frequency", localStringBuilder.toString());
        paramString2 = new StringBuilder();
        paramString2.append(str);
        paramString2.append("");
        paramString3.put("commandid", paramString2.toString());
        paramString2 = new StringBuilder();
        paramString2.append(paramString4);
        paramString2.append("");
        paramString3.put("resultcode", paramString2.toString());
        paramString2 = new StringBuilder();
        paramString2.append(paramString5);
        paramString2.append("");
        paramString3.put("tmcost", paramString2.toString());
        paramString2 = new StringBuilder();
        paramString2.append(paramString6);
        paramString2.append("");
        paramString3.put("reqsize", paramString2.toString());
        paramString2 = new StringBuilder();
        paramString2.append(paramString7);
        paramString2.append("");
        paramString3.put("rspsize", paramString2.toString());
        paramString2 = new StringBuilder();
        paramString2.append(paramString8);
        paramString2.append("");
        paramString3.put("touin", paramString2.toString());
        paramString2 = new StringBuilder();
        paramString2.append(paramString10);
        paramString2.append("");
        paramString3.put("appid", paramString2.toString());
        paramString2 = new StringBuilder();
        paramString2.append("network=");
        paramString2.append(paramString1);
        paramString2.append('&');
        paramString2.append("sdcard=");
        if (!Environment.getExternalStorageState().equals("mounted")) {
          break label717;
        }
        i = 1;
        paramString2.append(i);
        paramString2.append('&');
        paramString2.append("wifi=");
        paramString2.append(APNUtil.e(CommonDataAdapter.a().a()));
        paramString3.put("deviceinfo", paramString2.toString());
        paramString1 = new StringBuilder();
        paramString1.append("current login uin=");
        paramString1.append(CommonDataAdapter.a().a());
        paramString1.append("");
        paramString2 = paramString1.toString();
        paramString1 = paramString2;
        if (paramString9 != null)
        {
          paramString1 = new StringBuilder();
          paramString1.append(paramString2);
          paramString1.append("&");
          paramString1.append(paramString9);
          paramString1.append("");
          paramString1 = paramString1.toString();
        }
        paramString3.put("detail", paramString1);
      }
      finally {}
      try
      {
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase = this.jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper.getWritableDatabase();
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.insertOrThrow("newdata_report", null, paramString3);
        this.jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase.close();
        LogUtility.b("cgi_report_debug", "ReportDataModal addNewItem success");
        return true;
      }
      catch (Exception paramString1)
      {
        continue;
      }
      LogUtility.e("cgi_report_debug", "ReportDataModal addNewItem failed");
      return false;
      label717:
      int i = 0;
    }
  }
  
  public ArrayList<reportItem> b(String paramString)
  {
    try
    {
      paramString = a("olddata_report", paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 38
    //   4: ldc_w 344
    //   7: invokestatic 46	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   10: aload_0
    //   11: aload_0
    //   12: getfield 33	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_ComTencentOpenBusinessCgireportReportDataModal$DataBaseHelper	Lcom/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper;
    //   15: invokevirtual 246	com/tencent/open/business/cgireport/ReportDataModal$DataBaseHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: putfield 55	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   21: new 57	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 58	java/lang/StringBuilder:<init>	()V
    //   28: astore_2
    //   29: aload_2
    //   30: ldc_w 346
    //   33: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_2
    //   38: aload_1
    //   39: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: ldc_w 266
    //   47: invokevirtual 64	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 55	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   60: aload_1
    //   61: invokevirtual 270	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 55	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   68: invokevirtual 144	android/database/sqlite/SQLiteDatabase:close	()V
    //   71: ldc 38
    //   73: ldc_w 348
    //   76: invokestatic 46	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload_0
    //   80: monitorexit
    //   81: iconst_1
    //   82: ireturn
    //   83: astore_1
    //   84: getstatic 136	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   87: ldc_w 350
    //   90: aload_1
    //   91: invokestatic 143	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: aload_0
    //   95: getfield 55	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_AndroidDatabaseSqliteSQLiteDatabase	Landroid/database/sqlite/SQLiteDatabase;
    //   98: invokevirtual 144	android/database/sqlite/SQLiteDatabase:close	()V
    //   101: aload_0
    //   102: monitorexit
    //   103: iconst_0
    //   104: ireturn
    //   105: astore_1
    //   106: getstatic 136	com/tencent/open/business/cgireport/ReportDataModal:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   109: ldc_w 350
    //   112: aload_1
    //   113: invokestatic 143	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   116: aload_0
    //   117: monitorexit
    //   118: iconst_0
    //   119: ireturn
    //   120: astore_1
    //   121: aload_0
    //   122: monitorexit
    //   123: aload_1
    //   124: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	this	ReportDataModal
    //   0	125	1	paramString	String
    //   28	24	2	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   56	64	83	java/lang/Exception
    //   10	21	105	java/lang/Exception
    //   2	10	120	finally
    //   10	21	120	finally
    //   21	56	120	finally
    //   56	64	120	finally
    //   64	79	120	finally
    //   84	101	120	finally
    //   106	116	120	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.business.cgireport.ReportDataModal
 * JD-Core Version:    0.7.0.1
 */