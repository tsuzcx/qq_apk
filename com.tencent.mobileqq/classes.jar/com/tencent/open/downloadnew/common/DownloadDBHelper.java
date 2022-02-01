package com.tencent.open.downloadnew.common;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;

public class DownloadDBHelper
  extends SQLiteOpenHelper
{
  protected static volatile DownloadDBHelper a;
  protected static final String a = "com.tencent.open.downloadnew.common.DownloadDBHelper";
  protected static final byte[] a;
  public static final String[] a;
  protected long a;
  
  static
  {
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "appid", "download_url", "package", "push_title", "sendtime_col", "uin_col", "triggertime_col", "via_col", "patch_url", "update_type", "myappid_col", "apkid_col", "version_col", "downloadtype_col", "filepath_col", "source_col", "last_download_size", "is_apk", "myapp_download_from", "icon_url", "is_show_notification", "apk_writecode_state", "extra_info", "is_autoInstall_by_sdk", "download_file_md5", "download_file_size", "ext_param_id" };
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  protected DownloadDBHelper(Context paramContext)
  {
    super(paramContext, "app_plugin_download.db", null, 18);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public static DownloadDBHelper a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper == null) {
        jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper = new DownloadDBHelper(CommonDataAdapter.a().a());
      }
      if (jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long == 0L)
      {
        jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long = CommonDataAdapter.a().a();
        if (jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long == 0L) {
          jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper.jdField_a_of_type_Long = CommonDataAdapter.a().b();
        }
      }
      DownloadDBHelper localDownloadDBHelper = jdField_a_of_type_ComTencentOpenDownloadnewCommonDownloadDBHelper;
      return localDownloadDBHelper;
    }
    finally {}
  }
  
  protected DownloadInfo a(Cursor paramCursor)
  {
    Object localObject = paramCursor.getString(0);
    String str1 = paramCursor.getString(1);
    String str2 = paramCursor.getString(2);
    String str3 = paramCursor.getString(3);
    String str4 = paramCursor.getString(4);
    long l1 = paramCursor.getLong(6);
    String str5 = paramCursor.getString(7);
    String str6 = paramCursor.getString(8);
    int j = paramCursor.getInt(9);
    String str7 = paramCursor.getString(10);
    String str8 = paramCursor.getString(11);
    int k = paramCursor.getInt(12);
    int m = paramCursor.getInt(13);
    String str9 = paramCursor.getString(14);
    String str10 = paramCursor.getString(15);
    long l2 = paramCursor.getLong(16);
    boolean bool1;
    if (paramCursor.getInt(17) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int n = paramCursor.getInt(18);
    String str11 = paramCursor.getString(19);
    int i1 = paramCursor.getInt(20);
    int i;
    if (paramCursor.getInt(21) == 1) {
      i = 0;
    } else {
      i = paramCursor.getInt(21);
    }
    String str12 = paramCursor.getString(22);
    boolean bool2;
    if (paramCursor.getInt(23) == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    localObject = new DownloadInfo((String)localObject, str1, str2, str3, str4, l1, str5, str6, j, str7, str8, k, m, str9, str10, l2, bool1, n, str11, i1, i, str12, bool2, paramCursor.getString(24), paramCursor.getLong(25));
    ((DownloadInfo)localObject).y = paramCursor.getString(paramCursor.getColumnIndex("ext_param_id"));
    return localObject;
  }
  
  public DownloadInfo a(String paramString)
  {
    return a("package = ?", new String[] { paramString });
  }
  
  /* Error */
  protected DownloadInfo a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: getstatic 74	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfByte	[B
    //   3: astore 8
    //   5: aload 8
    //   7: monitorenter
    //   8: aconst_null
    //   9: astore 6
    //   11: aconst_null
    //   12: astore 7
    //   14: aconst_null
    //   15: astore 4
    //   17: aload_0
    //   18: invokevirtual 142	com/tencent/open/downloadnew/common/DownloadDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 144
    //   25: getstatic 72	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   28: aload_1
    //   29: aload_2
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 150	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 5
    //   38: aload 4
    //   40: astore_1
    //   41: aload_3
    //   42: astore 4
    //   44: aload 5
    //   46: astore_2
    //   47: aload 5
    //   49: invokeinterface 154 1 0
    //   54: ifle +30 -> 84
    //   57: aload_3
    //   58: astore 4
    //   60: aload 5
    //   62: astore_2
    //   63: aload 5
    //   65: invokeinterface 158 1 0
    //   70: pop
    //   71: aload_3
    //   72: astore 4
    //   74: aload 5
    //   76: astore_2
    //   77: aload_0
    //   78: aload 5
    //   80: invokevirtual 160	com/tencent/open/downloadnew/common/DownloadDBHelper:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   83: astore_1
    //   84: aload 5
    //   86: ifnull +126 -> 212
    //   89: aload 5
    //   91: invokeinterface 163 1 0
    //   96: goto +116 -> 212
    //   99: aload_3
    //   100: invokevirtual 164	android/database/sqlite/SQLiteDatabase:close	()V
    //   103: aload_1
    //   104: astore_2
    //   105: goto +68 -> 173
    //   108: astore_2
    //   109: aload 5
    //   111: astore_1
    //   112: aload_2
    //   113: astore 5
    //   115: goto +30 -> 145
    //   118: astore_1
    //   119: aconst_null
    //   120: astore_2
    //   121: goto +57 -> 178
    //   124: astore 5
    //   126: aconst_null
    //   127: astore_1
    //   128: goto +17 -> 145
    //   131: astore_1
    //   132: aconst_null
    //   133: astore_2
    //   134: aload_2
    //   135: astore_3
    //   136: goto +42 -> 178
    //   139: astore 5
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_1
    //   144: astore_3
    //   145: aload_3
    //   146: astore 4
    //   148: aload_1
    //   149: astore_2
    //   150: getstatic 166	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   153: ldc 168
    //   155: aload 5
    //   157: invokestatic 174	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   160: aload_1
    //   161: ifnull +60 -> 221
    //   164: aload_1
    //   165: invokeinterface 163 1 0
    //   170: goto +51 -> 221
    //   173: aload 8
    //   175: monitorexit
    //   176: aload_2
    //   177: areturn
    //   178: aload_2
    //   179: ifnull +12 -> 191
    //   182: aload_2
    //   183: invokeinterface 163 1 0
    //   188: goto +3 -> 191
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 164	android/database/sqlite/SQLiteDatabase:close	()V
    //   199: aload_1
    //   200: athrow
    //   201: aload 8
    //   203: monitorexit
    //   204: goto +5 -> 209
    //   207: aload_1
    //   208: athrow
    //   209: goto -2 -> 207
    //   212: aload_1
    //   213: astore_2
    //   214: aload_3
    //   215: ifnull -42 -> 173
    //   218: goto -119 -> 99
    //   221: aload 7
    //   223: astore_2
    //   224: aload_3
    //   225: ifnull -52 -> 173
    //   228: aload 6
    //   230: astore_1
    //   231: goto -132 -> 99
    //   234: astore_1
    //   235: aload 4
    //   237: astore_3
    //   238: goto -60 -> 178
    //   241: astore_1
    //   242: goto -41 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	245	0	this	DownloadDBHelper
    //   0	245	1	paramString	String
    //   0	245	2	paramArrayOfString	String[]
    //   21	217	3	localObject1	Object
    //   15	221	4	localObject2	Object
    //   36	78	5	localObject3	Object
    //   124	1	5	localException1	java.lang.Exception
    //   139	17	5	localException2	java.lang.Exception
    //   9	220	6	localObject4	Object
    //   12	210	7	localObject5	Object
    //   3	199	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   47	57	108	java/lang/Exception
    //   63	71	108	java/lang/Exception
    //   77	84	108	java/lang/Exception
    //   22	38	118	finally
    //   22	38	124	java/lang/Exception
    //   17	22	131	finally
    //   17	22	139	java/lang/Exception
    //   47	57	234	finally
    //   63	71	234	finally
    //   77	84	234	finally
    //   150	160	234	finally
    //   89	96	241	finally
    //   99	103	241	finally
    //   164	170	241	finally
    //   173	176	241	finally
    //   182	188	241	finally
    //   195	199	241	finally
    //   199	201	241	finally
    //   201	204	241	finally
  }
  
  protected String a()
  {
    if (this.jdField_a_of_type_Long == 0L)
    {
      this.jdField_a_of_type_Long = CommonDataAdapter.a().a();
      if (this.jdField_a_of_type_Long == 0L) {
        LogUtility.e(jdField_a_of_type_JavaLangString, "getUin() is empty!");
      }
    }
    return String.valueOf(this.jdField_a_of_type_Long);
  }
  
  /* Error */
  public java.util.Map<String, DownloadInfo> a()
  {
    // Byte code:
    //   0: getstatic 166	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3: ldc 188
    //   5: invokestatic 190	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: new 192	java/util/concurrent/ConcurrentHashMap
    //   11: dup
    //   12: invokespecial 194	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   15: astore 8
    //   17: getstatic 74	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfByte	[B
    //   20: astore 7
    //   22: aload 7
    //   24: monitorenter
    //   25: aconst_null
    //   26: astore 6
    //   28: aconst_null
    //   29: astore 5
    //   31: aconst_null
    //   32: astore_2
    //   33: aconst_null
    //   34: astore 4
    //   36: aload_0
    //   37: invokevirtual 142	com/tencent/open/downloadnew/common/DownloadDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   40: astore_3
    //   41: aload 4
    //   43: astore_2
    //   44: aload_3
    //   45: astore 4
    //   47: aload 6
    //   49: astore 5
    //   51: aload_3
    //   52: ldc 144
    //   54: getstatic 72	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: invokevirtual 150	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   65: astore 6
    //   67: aload 6
    //   69: astore_2
    //   70: aload_3
    //   71: astore 4
    //   73: aload 6
    //   75: astore 5
    //   77: aload 6
    //   79: invokeinterface 154 1 0
    //   84: ifle +286 -> 370
    //   87: aload 6
    //   89: astore_2
    //   90: aload_3
    //   91: astore 4
    //   93: aload 6
    //   95: astore 5
    //   97: aload 6
    //   99: invokeinterface 158 1 0
    //   104: pop
    //   105: aload 6
    //   107: astore_2
    //   108: aload_3
    //   109: astore 4
    //   111: aload 6
    //   113: astore 5
    //   115: aload 6
    //   117: iconst_0
    //   118: invokeinterface 110 2 0
    //   123: astore 9
    //   125: aload 6
    //   127: astore_2
    //   128: aload_3
    //   129: astore 4
    //   131: aload 6
    //   133: astore 5
    //   135: getstatic 166	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   138: astore 10
    //   140: aload 6
    //   142: astore_2
    //   143: aload_3
    //   144: astore 4
    //   146: aload 6
    //   148: astore 5
    //   150: new 196	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   157: astore 11
    //   159: aload 6
    //   161: astore_2
    //   162: aload_3
    //   163: astore 4
    //   165: aload 6
    //   167: astore 5
    //   169: aload 11
    //   171: ldc 199
    //   173: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 6
    //   179: astore_2
    //   180: aload_3
    //   181: astore 4
    //   183: aload 6
    //   185: astore 5
    //   187: aload 11
    //   189: aload 9
    //   191: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload 6
    //   197: astore_2
    //   198: aload_3
    //   199: astore 4
    //   201: aload 6
    //   203: astore 5
    //   205: aload 10
    //   207: aload 11
    //   209: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 190	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   215: aload 6
    //   217: astore_2
    //   218: aload_3
    //   219: astore 4
    //   221: aload 6
    //   223: astore 5
    //   225: aload_0
    //   226: aload 6
    //   228: invokevirtual 160	com/tencent/open/downloadnew/common/DownloadDBHelper:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   231: astore 10
    //   233: aload 6
    //   235: astore_2
    //   236: aload_3
    //   237: astore 4
    //   239: aload 6
    //   241: astore 5
    //   243: getstatic 166	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   246: astore 11
    //   248: aload 6
    //   250: astore_2
    //   251: aload_3
    //   252: astore 4
    //   254: aload 6
    //   256: astore 5
    //   258: new 196	java/lang/StringBuilder
    //   261: dup
    //   262: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   265: astore 12
    //   267: aload 6
    //   269: astore_2
    //   270: aload_3
    //   271: astore 4
    //   273: aload 6
    //   275: astore 5
    //   277: aload 12
    //   279: ldc 208
    //   281: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 6
    //   287: astore_2
    //   288: aload_3
    //   289: astore 4
    //   291: aload 6
    //   293: astore 5
    //   295: aload 12
    //   297: aload 10
    //   299: invokevirtual 209	com/tencent/open/downloadnew/DownloadInfo:toString	()Ljava/lang/String;
    //   302: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: pop
    //   306: aload 6
    //   308: astore_2
    //   309: aload_3
    //   310: astore 4
    //   312: aload 6
    //   314: astore 5
    //   316: aload 11
    //   318: aload 12
    //   320: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 190	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: aload 6
    //   328: astore_2
    //   329: aload_3
    //   330: astore 4
    //   332: aload 6
    //   334: astore 5
    //   336: aload 8
    //   338: aload 9
    //   340: aload 10
    //   342: invokeinterface 215 3 0
    //   347: pop
    //   348: aload 6
    //   350: astore_2
    //   351: aload_3
    //   352: astore 4
    //   354: aload 6
    //   356: astore 5
    //   358: aload 6
    //   360: invokeinterface 218 1 0
    //   365: istore_1
    //   366: iload_1
    //   367: ifne -262 -> 105
    //   370: aload 6
    //   372: ifnull +113 -> 485
    //   375: aload 6
    //   377: invokeinterface 163 1 0
    //   382: goto +103 -> 485
    //   385: aload_3
    //   386: invokevirtual 164	android/database/sqlite/SQLiteDatabase:close	()V
    //   389: goto +54 -> 443
    //   392: astore_3
    //   393: goto +56 -> 449
    //   396: astore 6
    //   398: goto +14 -> 412
    //   401: astore_3
    //   402: aconst_null
    //   403: astore 4
    //   405: goto +44 -> 449
    //   408: astore 6
    //   410: aconst_null
    //   411: astore_3
    //   412: aload 5
    //   414: astore_2
    //   415: aload_3
    //   416: astore 4
    //   418: getstatic 166	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   421: ldc 220
    //   423: aload 6
    //   425: invokestatic 174	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   428: aload 5
    //   430: ifnull +62 -> 492
    //   433: aload 5
    //   435: invokeinterface 163 1 0
    //   440: goto +52 -> 492
    //   443: aload 7
    //   445: monitorexit
    //   446: aload 8
    //   448: areturn
    //   449: aload_2
    //   450: ifnull +12 -> 462
    //   453: aload_2
    //   454: invokeinterface 163 1 0
    //   459: goto +3 -> 462
    //   462: aload 4
    //   464: ifnull +8 -> 472
    //   467: aload 4
    //   469: invokevirtual 164	android/database/sqlite/SQLiteDatabase:close	()V
    //   472: aload_3
    //   473: athrow
    //   474: aload 7
    //   476: monitorexit
    //   477: goto +5 -> 482
    //   480: aload_2
    //   481: athrow
    //   482: goto -2 -> 480
    //   485: aload_3
    //   486: ifnull -43 -> 443
    //   489: goto -104 -> 385
    //   492: aload_3
    //   493: ifnull -50 -> 443
    //   496: goto -111 -> 385
    //   499: astore_2
    //   500: goto -26 -> 474
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	this	DownloadDBHelper
    //   365	2	1	bool	boolean
    //   32	449	2	localObject1	Object
    //   499	1	2	localObject2	Object
    //   40	346	3	localSQLiteDatabase	SQLiteDatabase
    //   392	1	3	localObject3	Object
    //   401	1	3	localObject4	Object
    //   411	82	3	localObject5	Object
    //   34	434	4	localObject6	Object
    //   29	405	5	localCursor1	Cursor
    //   26	350	6	localCursor2	Cursor
    //   396	1	6	localException1	java.lang.Exception
    //   408	16	6	localException2	java.lang.Exception
    //   20	455	7	arrayOfByte	byte[]
    //   15	432	8	localConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    //   123	216	9	str	String
    //   138	203	10	localObject7	Object
    //   157	160	11	localObject8	Object
    //   265	54	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   51	67	392	finally
    //   77	87	392	finally
    //   97	105	392	finally
    //   115	125	392	finally
    //   135	140	392	finally
    //   150	159	392	finally
    //   169	177	392	finally
    //   187	195	392	finally
    //   205	215	392	finally
    //   225	233	392	finally
    //   243	248	392	finally
    //   258	267	392	finally
    //   277	285	392	finally
    //   295	306	392	finally
    //   316	326	392	finally
    //   336	348	392	finally
    //   358	366	392	finally
    //   418	428	392	finally
    //   51	67	396	java/lang/Exception
    //   77	87	396	java/lang/Exception
    //   97	105	396	java/lang/Exception
    //   115	125	396	java/lang/Exception
    //   135	140	396	java/lang/Exception
    //   150	159	396	java/lang/Exception
    //   169	177	396	java/lang/Exception
    //   187	195	396	java/lang/Exception
    //   205	215	396	java/lang/Exception
    //   225	233	396	java/lang/Exception
    //   243	248	396	java/lang/Exception
    //   258	267	396	java/lang/Exception
    //   277	285	396	java/lang/Exception
    //   295	306	396	java/lang/Exception
    //   316	326	396	java/lang/Exception
    //   336	348	396	java/lang/Exception
    //   358	366	396	java/lang/Exception
    //   36	41	401	finally
    //   36	41	408	java/lang/Exception
    //   375	382	499	finally
    //   385	389	499	finally
    //   433	440	499	finally
    //   443	446	499	finally
    //   453	459	499	finally
    //   467	472	499	finally
    //   472	474	499	finally
    //   474	477	499	finally
  }
  
  protected void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.beginTransaction();
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS download_info;");
      paramSQLiteDatabase.setTransactionSuccessful();
      paramSQLiteDatabase.endTransaction();
      onCreate(paramSQLiteDatabase);
    }
  }
  
  /* Error */
  public void a(DownloadInfo paramDownloadInfo)
  {
    // Byte code:
    //   0: getstatic 74	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfByte	[B
    //   3: astore 8
    //   5: aload 8
    //   7: monitorenter
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 5
    //   14: aload_0
    //   15: invokevirtual 246	com/tencent/open/downloadnew/common/DownloadDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore 6
    //   20: aload 6
    //   22: invokevirtual 226	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   25: new 248	android/content/ContentValues
    //   28: dup
    //   29: invokespecial 249	android/content/ContentValues:<init>	()V
    //   32: astore 5
    //   34: aload 5
    //   36: ldc 18
    //   38: aload_1
    //   39: getfield 251	com/tencent/open/downloadnew/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   42: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload 5
    //   47: ldc 20
    //   49: aload_1
    //   50: getfield 256	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   53: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload 5
    //   58: ldc 22
    //   60: aload_1
    //   61: getfield 258	com/tencent/open/downloadnew/DownloadInfo:e	Ljava/lang/String;
    //   64: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload 5
    //   69: ldc 24
    //   71: aload_1
    //   72: getfield 261	com/tencent/open/downloadnew/DownloadInfo:f	Ljava/lang/String;
    //   75: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload 5
    //   80: ldc 26
    //   82: aload_1
    //   83: getfield 264	com/tencent/open/downloadnew/DownloadInfo:g	Ljava/lang/String;
    //   86: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 5
    //   91: ldc 28
    //   93: aload_0
    //   94: invokevirtual 266	com/tencent/open/downloadnew/common/DownloadDBHelper:a	()Ljava/lang/String;
    //   97: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload 5
    //   102: ldc 30
    //   104: aload_1
    //   105: getfield 267	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Long	J
    //   108: invokestatic 272	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: invokevirtual 275	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   114: aload 5
    //   116: ldc 32
    //   118: aload_1
    //   119: getfield 278	com/tencent/open/downloadnew/DownloadInfo:jdField_h_of_type_JavaLangString	Ljava/lang/String;
    //   122: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload 5
    //   127: ldc 34
    //   129: aload_1
    //   130: getfield 281	com/tencent/open/downloadnew/DownloadInfo:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   133: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 5
    //   138: ldc 36
    //   140: aload_1
    //   141: getfield 284	com/tencent/open/downloadnew/DownloadInfo:jdField_a_of_type_Int	I
    //   144: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   150: aload 5
    //   152: ldc 38
    //   154: aload_1
    //   155: getfield 295	com/tencent/open/downloadnew/DownloadInfo:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   158: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 5
    //   163: ldc 40
    //   165: aload_1
    //   166: getfield 298	com/tencent/open/downloadnew/DownloadInfo:k	Ljava/lang/String;
    //   169: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload 5
    //   174: ldc 42
    //   176: aload_1
    //   177: getfield 300	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_Int	I
    //   180: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   186: aload 5
    //   188: ldc 44
    //   190: aload_1
    //   191: getfield 302	com/tencent/open/downloadnew/DownloadInfo:jdField_c_of_type_Int	I
    //   194: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   200: aload 5
    //   202: ldc 46
    //   204: aload_1
    //   205: getfield 305	com/tencent/open/downloadnew/DownloadInfo:l	Ljava/lang/String;
    //   208: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 5
    //   213: ldc 48
    //   215: aload_1
    //   216: getfield 308	com/tencent/open/downloadnew/DownloadInfo:m	Ljava/lang/String;
    //   219: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload 5
    //   224: ldc 50
    //   226: aload_1
    //   227: getfield 310	com/tencent/open/downloadnew/DownloadInfo:jdField_b_of_type_Long	J
    //   230: invokestatic 272	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   233: invokevirtual 275	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   236: aload_1
    //   237: getfield 313	com/tencent/open/downloadnew/DownloadInfo:jdField_c_of_type_Boolean	Z
    //   240: ifeq +431 -> 671
    //   243: iconst_1
    //   244: istore_2
    //   245: goto +3 -> 248
    //   248: aload 5
    //   250: ldc 52
    //   252: iload_2
    //   253: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   259: aload 5
    //   261: ldc 54
    //   263: aload_1
    //   264: getfield 315	com/tencent/open/downloadnew/DownloadInfo:jdField_h_of_type_Int	I
    //   267: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   273: aload 5
    //   275: ldc 56
    //   277: aload_1
    //   278: getfield 318	com/tencent/open/downloadnew/DownloadInfo:n	Ljava/lang/String;
    //   281: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload 5
    //   286: ldc 58
    //   288: aload_1
    //   289: getfield 320	com/tencent/open/downloadnew/DownloadInfo:jdField_i_of_type_Int	I
    //   292: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   298: aload_1
    //   299: getfield 322	com/tencent/open/downloadnew/DownloadInfo:jdField_j_of_type_Int	I
    //   302: ifne +8 -> 310
    //   305: iconst_1
    //   306: istore_2
    //   307: goto +8 -> 315
    //   310: aload_1
    //   311: getfield 322	com/tencent/open/downloadnew/DownloadInfo:jdField_j_of_type_Int	I
    //   314: istore_2
    //   315: aload 5
    //   317: ldc 60
    //   319: iload_2
    //   320: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   323: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   326: aload 5
    //   328: ldc 62
    //   330: aload_1
    //   331: getfield 325	com/tencent/open/downloadnew/DownloadInfo:o	Ljava/lang/String;
    //   334: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload_1
    //   338: getfield 327	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Boolean	Z
    //   341: ifeq +335 -> 676
    //   344: iconst_1
    //   345: istore_2
    //   346: goto +3 -> 349
    //   349: aload 5
    //   351: ldc 64
    //   353: iload_2
    //   354: invokestatic 289	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: invokevirtual 292	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   360: aload 5
    //   362: ldc 66
    //   364: aload_1
    //   365: getfield 330	com/tencent/open/downloadnew/DownloadInfo:p	Ljava/lang/String;
    //   368: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload 5
    //   373: ldc 68
    //   375: aload_1
    //   376: getfield 332	com/tencent/open/downloadnew/DownloadInfo:jdField_d_of_type_Long	J
    //   379: invokestatic 272	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   382: invokevirtual 275	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   385: aload 5
    //   387: ldc 70
    //   389: aload_1
    //   390: getfield 130	com/tencent/open/downloadnew/DownloadInfo:y	Ljava/lang/String;
    //   393: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload 6
    //   398: ldc 144
    //   400: aload 5
    //   402: ldc_w 334
    //   405: iconst_1
    //   406: anewarray 16	java/lang/String
    //   409: dup
    //   410: iconst_0
    //   411: aload_1
    //   412: getfield 251	com/tencent/open/downloadnew/DownloadInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   415: aastore
    //   416: invokevirtual 338	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   419: istore_2
    //   420: getstatic 166	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   423: astore_1
    //   424: new 196	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   431: astore 7
    //   433: aload 7
    //   435: ldc_w 340
    //   438: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload 7
    //   444: iload_2
    //   445: invokevirtual 343	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload_1
    //   450: aload 7
    //   452: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 345	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   458: iload_2
    //   459: ifne +52 -> 511
    //   462: aload 6
    //   464: ldc 144
    //   466: aconst_null
    //   467: aload 5
    //   469: invokevirtual 349	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   472: lstore_3
    //   473: getstatic 166	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   476: astore_1
    //   477: new 196	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   484: astore 5
    //   486: aload 5
    //   488: ldc_w 351
    //   491: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 5
    //   497: lload_3
    //   498: invokevirtual 354	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload_1
    //   503: aload 5
    //   505: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 345	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: aload 6
    //   513: invokevirtual 235	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   516: aload 6
    //   518: ifnull +101 -> 619
    //   521: aload 6
    //   523: invokevirtual 238	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   526: aload 6
    //   528: invokevirtual 164	android/database/sqlite/SQLiteDatabase:close	()V
    //   531: goto +88 -> 619
    //   534: astore 5
    //   536: getstatic 166	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   539: astore_1
    //   540: aload_1
    //   541: ldc_w 356
    //   544: aload 5
    //   546: invokestatic 174	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   549: goto +70 -> 619
    //   552: astore_1
    //   553: goto +70 -> 623
    //   556: astore 5
    //   558: aload 6
    //   560: astore_1
    //   561: aload 5
    //   563: astore 6
    //   565: goto +16 -> 581
    //   568: astore_1
    //   569: aload 5
    //   571: astore 6
    //   573: goto +50 -> 623
    //   576: astore 6
    //   578: aload 7
    //   580: astore_1
    //   581: aload_1
    //   582: astore 5
    //   584: getstatic 166	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   587: ldc_w 356
    //   590: aload 6
    //   592: invokestatic 174	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   595: aload_1
    //   596: ifnull +23 -> 619
    //   599: aload_1
    //   600: invokevirtual 238	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   603: aload_1
    //   604: invokevirtual 164	android/database/sqlite/SQLiteDatabase:close	()V
    //   607: goto +12 -> 619
    //   610: astore 5
    //   612: getstatic 166	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   615: astore_1
    //   616: goto -76 -> 540
    //   619: aload 8
    //   621: monitorexit
    //   622: return
    //   623: aload 6
    //   625: ifnull +33 -> 658
    //   628: aload 6
    //   630: invokevirtual 238	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   633: aload 6
    //   635: invokevirtual 164	android/database/sqlite/SQLiteDatabase:close	()V
    //   638: goto +20 -> 658
    //   641: astore_1
    //   642: goto +18 -> 660
    //   645: astore 5
    //   647: getstatic 166	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   650: ldc_w 356
    //   653: aload 5
    //   655: invokestatic 174	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   658: aload_1
    //   659: athrow
    //   660: aload 8
    //   662: monitorexit
    //   663: goto +5 -> 668
    //   666: aload_1
    //   667: athrow
    //   668: goto -2 -> 666
    //   671: iconst_0
    //   672: istore_2
    //   673: goto -425 -> 248
    //   676: iconst_0
    //   677: istore_2
    //   678: goto -329 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	681	0	this	DownloadDBHelper
    //   0	681	1	paramDownloadInfo	DownloadInfo
    //   244	434	2	i	int
    //   472	26	3	l	long
    //   12	492	5	localObject1	Object
    //   534	11	5	localException1	java.lang.Exception
    //   556	14	5	localException2	java.lang.Exception
    //   582	1	5	localDownloadInfo	DownloadInfo
    //   610	1	5	localException3	java.lang.Exception
    //   645	9	5	localException4	java.lang.Exception
    //   18	554	6	localObject2	Object
    //   576	58	6	localException5	java.lang.Exception
    //   9	570	7	localStringBuilder	StringBuilder
    //   3	658	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   521	531	534	java/lang/Exception
    //   20	243	552	finally
    //   248	305	552	finally
    //   310	315	552	finally
    //   315	344	552	finally
    //   349	458	552	finally
    //   462	511	552	finally
    //   511	516	552	finally
    //   20	243	556	java/lang/Exception
    //   248	305	556	java/lang/Exception
    //   310	315	556	java/lang/Exception
    //   315	344	556	java/lang/Exception
    //   349	458	556	java/lang/Exception
    //   462	511	556	java/lang/Exception
    //   511	516	556	java/lang/Exception
    //   14	20	568	finally
    //   584	595	568	finally
    //   14	20	576	java/lang/Exception
    //   599	607	610	java/lang/Exception
    //   521	531	641	finally
    //   536	540	641	finally
    //   540	549	641	finally
    //   599	607	641	finally
    //   612	616	641	finally
    //   619	622	641	finally
    //   628	638	641	finally
    //   647	658	641	finally
    //   658	660	641	finally
    //   660	663	641	finally
    //   628	638	645	java/lang/Exception
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: getstatic 74	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_ArrayOfByte	[B
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore_3
    //   12: aload_0
    //   13: invokevirtual 246	com/tencent/open/downloadnew/common/DownloadDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 4
    //   18: aload 4
    //   20: astore_3
    //   21: aload 4
    //   23: astore_2
    //   24: getstatic 166	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: astore 6
    //   29: aload 4
    //   31: astore_3
    //   32: aload 4
    //   34: astore_2
    //   35: new 196	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   42: astore 7
    //   44: aload 4
    //   46: astore_3
    //   47: aload 4
    //   49: astore_2
    //   50: aload 7
    //   52: ldc_w 358
    //   55: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 4
    //   61: astore_3
    //   62: aload 4
    //   64: astore_2
    //   65: aload 7
    //   67: iconst_1
    //   68: anewarray 16	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: invokestatic 363	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   78: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 4
    //   84: astore_3
    //   85: aload 4
    //   87: astore_2
    //   88: aload 6
    //   90: aload 7
    //   92: invokevirtual 206	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 190	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 4
    //   100: astore_3
    //   101: aload 4
    //   103: astore_2
    //   104: aload 4
    //   106: ldc 144
    //   108: ldc_w 334
    //   111: iconst_1
    //   112: anewarray 16	java/lang/String
    //   115: dup
    //   116: iconst_0
    //   117: aload_1
    //   118: aastore
    //   119: invokevirtual 367	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   122: pop
    //   123: aload 4
    //   125: ifnull +37 -> 162
    //   128: aload 4
    //   130: astore_2
    //   131: aload_2
    //   132: invokevirtual 164	android/database/sqlite/SQLiteDatabase:close	()V
    //   135: goto +27 -> 162
    //   138: astore_1
    //   139: goto +27 -> 166
    //   142: astore_1
    //   143: aload_2
    //   144: astore_3
    //   145: getstatic 166	com/tencent/open/downloadnew/common/DownloadDBHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   148: ldc_w 369
    //   151: aload_1
    //   152: invokestatic 174	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: aload_2
    //   156: ifnull +6 -> 162
    //   159: goto -28 -> 131
    //   162: aload 5
    //   164: monitorexit
    //   165: return
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 164	android/database/sqlite/SQLiteDatabase:close	()V
    //   174: aload_1
    //   175: athrow
    //   176: astore_1
    //   177: aload 5
    //   179: monitorexit
    //   180: goto +5 -> 185
    //   183: aload_1
    //   184: athrow
    //   185: goto -2 -> 183
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	DownloadDBHelper
    //   0	188	1	paramString	String
    //   9	147	2	localObject1	Object
    //   11	160	3	localObject2	Object
    //   16	113	4	localSQLiteDatabase	SQLiteDatabase
    //   3	175	5	arrayOfByte	byte[]
    //   27	62	6	str	String
    //   42	49	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   12	18	138	finally
    //   24	29	138	finally
    //   35	44	138	finally
    //   50	59	138	finally
    //   65	82	138	finally
    //   88	98	138	finally
    //   104	123	138	finally
    //   145	155	138	finally
    //   12	18	142	java/lang/Exception
    //   24	29	142	java/lang/Exception
    //   35	44	142	java/lang/Exception
    //   50	59	142	java/lang/Exception
    //   65	82	142	java/lang/Exception
    //   88	98	142	java/lang/Exception
    //   104	123	142	java/lang/Exception
    //   131	135	176	finally
    //   162	165	176	finally
    //   170	174	176	finally
    //   174	176	176	finally
    //   177	180	176	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE download_info (appid TEXT PRIMARY KEY,download_url TEXT,package TEXT,push_title TEXT,sendtime_col TEXT,uin_col TEXT,triggertime_col INTEGER,via_col TEXT,patch_url TEXT,update_type INTEGER,myappid_col TEXT,apkid_col TEXT,version_col INTEGER,downloadtype_col INTEGER,filepath_col TEXT,source_col TEXT,last_download_size INTEGER,is_apk INTEGER,myapp_download_from INTEGER,icon_url TEXT,is_show_notification INTEGER,apk_writecode_state INTEGER,extra_info TEXT,is_autoInstall_by_sdk INTEGER,download_file_md5 TEXT,download_file_size INTEGER,ext_param_id TEXT); ");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDowngrade oldVersion=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" newVersion=");
    localStringBuilder.append(paramInt2);
    LogUtility.c(str, localStringBuilder.toString());
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpgrade oldVersion=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" newVersion=");
    localStringBuilder.append(paramInt2);
    LogUtility.c(str, localStringBuilder.toString());
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.DownloadDBHelper
 * JD-Core Version:    0.7.0.1
 */