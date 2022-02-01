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
  protected static final String a = "com.tencent.open.downloadnew.common.DownloadDBHelper";
  public static final String[] b = { "appid", "download_url", "package", "push_title", "sendtime_col", "uin_col", "triggertime_col", "via_col", "patch_url", "update_type", "myappid_col", "apkid_col", "version_col", "downloadtype_col", "filepath_col", "source_col", "last_download_size", "is_apk", "myapp_download_from", "icon_url", "is_show_notification", "apk_writecode_state", "extra_info", "is_autoInstall_by_sdk", "download_file_md5", "download_file_size", "ext_param_id" };
  protected static final byte[] c = new byte[1];
  protected static volatile DownloadDBHelper e;
  protected long d = 0L;
  
  protected DownloadDBHelper(Context paramContext)
  {
    super(paramContext, "app_plugin_download.db", null, 18);
  }
  
  public static DownloadDBHelper a()
  {
    try
    {
      if (e == null) {
        e = new DownloadDBHelper(CommonDataAdapter.a().b());
      }
      if (e.d == 0L)
      {
        e.d = CommonDataAdapter.a().c();
        if (e.d == 0L) {
          e.d = CommonDataAdapter.a().d();
        }
      }
      DownloadDBHelper localDownloadDBHelper = e;
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
    ((DownloadInfo)localObject).T = paramCursor.getString(paramCursor.getColumnIndex("ext_param_id"));
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
    //   0: getstatic 78	com/tencent/open/downloadnew/common/DownloadDBHelper:c	[B
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
    //   18: invokevirtual 145	com/tencent/open/downloadnew/common/DownloadDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore_3
    //   22: aload_3
    //   23: ldc 147
    //   25: getstatic 76	com/tencent/open/downloadnew/common/DownloadDBHelper:b	[Ljava/lang/String;
    //   28: aload_1
    //   29: aload_2
    //   30: aconst_null
    //   31: aconst_null
    //   32: aconst_null
    //   33: invokevirtual 153	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   36: astore 5
    //   38: aload 4
    //   40: astore_1
    //   41: aload_3
    //   42: astore 4
    //   44: aload 5
    //   46: astore_2
    //   47: aload 5
    //   49: invokeinterface 157 1 0
    //   54: ifle +30 -> 84
    //   57: aload_3
    //   58: astore 4
    //   60: aload 5
    //   62: astore_2
    //   63: aload 5
    //   65: invokeinterface 161 1 0
    //   70: pop
    //   71: aload_3
    //   72: astore 4
    //   74: aload 5
    //   76: astore_2
    //   77: aload_0
    //   78: aload 5
    //   80: invokevirtual 163	com/tencent/open/downloadnew/common/DownloadDBHelper:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   83: astore_1
    //   84: aload 5
    //   86: ifnull +126 -> 212
    //   89: aload 5
    //   91: invokeinterface 166 1 0
    //   96: goto +116 -> 212
    //   99: aload_3
    //   100: invokevirtual 167	android/database/sqlite/SQLiteDatabase:close	()V
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
    //   150: getstatic 169	com/tencent/open/downloadnew/common/DownloadDBHelper:a	Ljava/lang/String;
    //   153: ldc 171
    //   155: aload 5
    //   157: invokestatic 176	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   160: aload_1
    //   161: ifnull +60 -> 221
    //   164: aload_1
    //   165: invokeinterface 166 1 0
    //   170: goto +51 -> 221
    //   173: aload 8
    //   175: monitorexit
    //   176: aload_2
    //   177: areturn
    //   178: aload_2
    //   179: ifnull +12 -> 191
    //   182: aload_2
    //   183: invokeinterface 166 1 0
    //   188: goto +3 -> 191
    //   191: aload_3
    //   192: ifnull +7 -> 199
    //   195: aload_3
    //   196: invokevirtual 167	android/database/sqlite/SQLiteDatabase:close	()V
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
    //   0: getstatic 78	com/tencent/open/downloadnew/common/DownloadDBHelper:c	[B
    //   3: astore 8
    //   5: aload 8
    //   7: monitorenter
    //   8: aconst_null
    //   9: astore 7
    //   11: aconst_null
    //   12: astore 5
    //   14: aload_0
    //   15: invokevirtual 200	com/tencent/open/downloadnew/common/DownloadDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   18: astore 6
    //   20: aload 6
    //   22: invokevirtual 180	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   25: new 202	android/content/ContentValues
    //   28: dup
    //   29: invokespecial 204	android/content/ContentValues:<init>	()V
    //   32: astore 5
    //   34: aload 5
    //   36: ldc 22
    //   38: aload_1
    //   39: getfield 206	com/tencent/open/downloadnew/DownloadInfo:c	Ljava/lang/String;
    //   42: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: aload 5
    //   47: ldc 24
    //   49: aload_1
    //   50: getfield 212	com/tencent/open/downloadnew/DownloadInfo:d	Ljava/lang/String;
    //   53: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload 5
    //   58: ldc 26
    //   60: aload_1
    //   61: getfield 214	com/tencent/open/downloadnew/DownloadInfo:e	Ljava/lang/String;
    //   64: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload 5
    //   69: ldc 28
    //   71: aload_1
    //   72: getfield 217	com/tencent/open/downloadnew/DownloadInfo:f	Ljava/lang/String;
    //   75: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: aload 5
    //   80: ldc 30
    //   82: aload_1
    //   83: getfield 220	com/tencent/open/downloadnew/DownloadInfo:g	Ljava/lang/String;
    //   86: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload 5
    //   91: ldc 32
    //   93: aload_0
    //   94: invokevirtual 223	com/tencent/open/downloadnew/common/DownloadDBHelper:c	()Ljava/lang/String;
    //   97: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload 5
    //   102: ldc 34
    //   104: aload_1
    //   105: getfield 226	com/tencent/open/downloadnew/DownloadInfo:i	J
    //   108: invokestatic 232	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   111: invokevirtual 235	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   114: aload 5
    //   116: ldc 36
    //   118: aload_1
    //   119: getfield 238	com/tencent/open/downloadnew/DownloadInfo:h	Ljava/lang/String;
    //   122: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload 5
    //   127: ldc 38
    //   129: aload_1
    //   130: getfield 241	com/tencent/open/downloadnew/DownloadInfo:k	Ljava/lang/String;
    //   133: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload 5
    //   138: ldc 40
    //   140: aload_1
    //   141: getfield 245	com/tencent/open/downloadnew/DownloadInfo:j	I
    //   144: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   147: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   150: aload 5
    //   152: ldc 42
    //   154: aload_1
    //   155: getfield 256	com/tencent/open/downloadnew/DownloadInfo:l	Ljava/lang/String;
    //   158: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload 5
    //   163: ldc 44
    //   165: aload_1
    //   166: getfield 259	com/tencent/open/downloadnew/DownloadInfo:m	Ljava/lang/String;
    //   169: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload 5
    //   174: ldc 46
    //   176: aload_1
    //   177: getfield 262	com/tencent/open/downloadnew/DownloadInfo:n	I
    //   180: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   186: aload 5
    //   188: ldc 48
    //   190: aload_1
    //   191: getfield 265	com/tencent/open/downloadnew/DownloadInfo:o	I
    //   194: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   197: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   200: aload 5
    //   202: ldc 50
    //   204: aload_1
    //   205: getfield 268	com/tencent/open/downloadnew/DownloadInfo:q	Ljava/lang/String;
    //   208: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 5
    //   213: ldc 52
    //   215: aload_1
    //   216: getfield 271	com/tencent/open/downloadnew/DownloadInfo:r	Ljava/lang/String;
    //   219: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: aload 5
    //   224: ldc 54
    //   226: aload_1
    //   227: getfield 274	com/tencent/open/downloadnew/DownloadInfo:y	J
    //   230: invokestatic 232	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   233: invokevirtual 235	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   236: aload_1
    //   237: getfield 278	com/tencent/open/downloadnew/DownloadInfo:A	Z
    //   240: ifeq +431 -> 671
    //   243: iconst_1
    //   244: istore_2
    //   245: goto +3 -> 248
    //   248: aload 5
    //   250: ldc 56
    //   252: iload_2
    //   253: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   256: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   259: aload 5
    //   261: ldc 58
    //   263: aload_1
    //   264: getfield 281	com/tencent/open/downloadnew/DownloadInfo:z	I
    //   267: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   270: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   273: aload 5
    //   275: ldc 60
    //   277: aload_1
    //   278: getfield 284	com/tencent/open/downloadnew/DownloadInfo:B	Ljava/lang/String;
    //   281: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: aload 5
    //   286: ldc 62
    //   288: aload_1
    //   289: getfield 287	com/tencent/open/downloadnew/DownloadInfo:C	I
    //   292: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   295: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   298: aload_1
    //   299: getfield 290	com/tencent/open/downloadnew/DownloadInfo:D	I
    //   302: ifne +8 -> 310
    //   305: iconst_1
    //   306: istore_2
    //   307: goto +8 -> 315
    //   310: aload_1
    //   311: getfield 290	com/tencent/open/downloadnew/DownloadInfo:D	I
    //   314: istore_2
    //   315: aload 5
    //   317: ldc 64
    //   319: iload_2
    //   320: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   323: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   326: aload 5
    //   328: ldc 66
    //   330: aload_1
    //   331: getfield 293	com/tencent/open/downloadnew/DownloadInfo:F	Ljava/lang/String;
    //   334: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   337: aload_1
    //   338: getfield 296	com/tencent/open/downloadnew/DownloadInfo:G	Z
    //   341: ifeq +335 -> 676
    //   344: iconst_1
    //   345: istore_2
    //   346: goto +3 -> 349
    //   349: aload 5
    //   351: ldc 68
    //   353: iload_2
    //   354: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   357: invokevirtual 253	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   360: aload 5
    //   362: ldc 70
    //   364: aload_1
    //   365: getfield 299	com/tencent/open/downloadnew/DownloadInfo:H	Ljava/lang/String;
    //   368: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: aload 5
    //   373: ldc 72
    //   375: aload_1
    //   376: getfield 301	com/tencent/open/downloadnew/DownloadInfo:I	J
    //   379: invokestatic 232	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   382: invokevirtual 235	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   385: aload 5
    //   387: ldc 74
    //   389: aload_1
    //   390: getfield 133	com/tencent/open/downloadnew/DownloadInfo:T	Ljava/lang/String;
    //   393: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   396: aload 6
    //   398: ldc 147
    //   400: aload 5
    //   402: ldc_w 303
    //   405: iconst_1
    //   406: anewarray 20	java/lang/String
    //   409: dup
    //   410: iconst_0
    //   411: aload_1
    //   412: getfield 206	com/tencent/open/downloadnew/DownloadInfo:c	Ljava/lang/String;
    //   415: aastore
    //   416: invokevirtual 307	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   419: istore_2
    //   420: getstatic 169	com/tencent/open/downloadnew/common/DownloadDBHelper:a	Ljava/lang/String;
    //   423: astore_1
    //   424: new 309	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   431: astore 7
    //   433: aload 7
    //   435: ldc_w 312
    //   438: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: aload 7
    //   444: iload_2
    //   445: invokevirtual 319	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload_1
    //   450: aload 7
    //   452: invokevirtual 322	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   455: invokestatic 324	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   458: iload_2
    //   459: ifne +52 -> 511
    //   462: aload 6
    //   464: ldc 147
    //   466: aconst_null
    //   467: aload 5
    //   469: invokevirtual 328	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   472: lstore_3
    //   473: getstatic 169	com/tencent/open/downloadnew/common/DownloadDBHelper:a	Ljava/lang/String;
    //   476: astore_1
    //   477: new 309	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   484: astore 5
    //   486: aload 5
    //   488: ldc_w 330
    //   491: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: pop
    //   495: aload 5
    //   497: lload_3
    //   498: invokevirtual 333	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   501: pop
    //   502: aload_1
    //   503: aload 5
    //   505: invokevirtual 322	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: invokestatic 324	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   511: aload 6
    //   513: invokevirtual 189	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   516: aload 6
    //   518: ifnull +101 -> 619
    //   521: aload 6
    //   523: invokevirtual 192	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   526: aload 6
    //   528: invokevirtual 167	android/database/sqlite/SQLiteDatabase:close	()V
    //   531: goto +88 -> 619
    //   534: astore 5
    //   536: getstatic 169	com/tencent/open/downloadnew/common/DownloadDBHelper:a	Ljava/lang/String;
    //   539: astore_1
    //   540: aload_1
    //   541: ldc_w 335
    //   544: aload 5
    //   546: invokestatic 176	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
    //   584: getstatic 169	com/tencent/open/downloadnew/common/DownloadDBHelper:a	Ljava/lang/String;
    //   587: ldc_w 335
    //   590: aload 6
    //   592: invokestatic 176	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   595: aload_1
    //   596: ifnull +23 -> 619
    //   599: aload_1
    //   600: invokevirtual 192	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   603: aload_1
    //   604: invokevirtual 167	android/database/sqlite/SQLiteDatabase:close	()V
    //   607: goto +12 -> 619
    //   610: astore 5
    //   612: getstatic 169	com/tencent/open/downloadnew/common/DownloadDBHelper:a	Ljava/lang/String;
    //   615: astore_1
    //   616: goto -76 -> 540
    //   619: aload 8
    //   621: monitorexit
    //   622: return
    //   623: aload 6
    //   625: ifnull +33 -> 658
    //   628: aload 6
    //   630: invokevirtual 192	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   633: aload 6
    //   635: invokevirtual 167	android/database/sqlite/SQLiteDatabase:close	()V
    //   638: goto +20 -> 658
    //   641: astore_1
    //   642: goto +18 -> 660
    //   645: astore 5
    //   647: getstatic 169	com/tencent/open/downloadnew/common/DownloadDBHelper:a	Ljava/lang/String;
    //   650: ldc_w 335
    //   653: aload 5
    //   655: invokestatic 176	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
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
  public java.util.Map<String, DownloadInfo> b()
  {
    // Byte code:
    //   0: getstatic 169	com/tencent/open/downloadnew/common/DownloadDBHelper:a	Ljava/lang/String;
    //   3: ldc_w 338
    //   6: invokestatic 340	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: new 342	java/util/concurrent/ConcurrentHashMap
    //   12: dup
    //   13: invokespecial 343	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   16: astore 8
    //   18: getstatic 78	com/tencent/open/downloadnew/common/DownloadDBHelper:c	[B
    //   21: astore 7
    //   23: aload 7
    //   25: monitorenter
    //   26: aconst_null
    //   27: astore 6
    //   29: aconst_null
    //   30: astore 5
    //   32: aconst_null
    //   33: astore_2
    //   34: aconst_null
    //   35: astore 4
    //   37: aload_0
    //   38: invokevirtual 145	com/tencent/open/downloadnew/common/DownloadDBHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   41: astore_3
    //   42: aload 4
    //   44: astore_2
    //   45: aload_3
    //   46: astore 4
    //   48: aload 6
    //   50: astore 5
    //   52: aload_3
    //   53: ldc 147
    //   55: getstatic 76	com/tencent/open/downloadnew/common/DownloadDBHelper:b	[Ljava/lang/String;
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: invokevirtual 153	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   66: astore 6
    //   68: aload 6
    //   70: astore_2
    //   71: aload_3
    //   72: astore 4
    //   74: aload 6
    //   76: astore 5
    //   78: aload 6
    //   80: invokeinterface 157 1 0
    //   85: ifle +288 -> 373
    //   88: aload 6
    //   90: astore_2
    //   91: aload_3
    //   92: astore 4
    //   94: aload 6
    //   96: astore 5
    //   98: aload 6
    //   100: invokeinterface 161 1 0
    //   105: pop
    //   106: aload 6
    //   108: astore_2
    //   109: aload_3
    //   110: astore 4
    //   112: aload 6
    //   114: astore 5
    //   116: aload 6
    //   118: iconst_0
    //   119: invokeinterface 113 2 0
    //   124: astore 9
    //   126: aload 6
    //   128: astore_2
    //   129: aload_3
    //   130: astore 4
    //   132: aload 6
    //   134: astore 5
    //   136: getstatic 169	com/tencent/open/downloadnew/common/DownloadDBHelper:a	Ljava/lang/String;
    //   139: astore 10
    //   141: aload 6
    //   143: astore_2
    //   144: aload_3
    //   145: astore 4
    //   147: aload 6
    //   149: astore 5
    //   151: new 309	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   158: astore 11
    //   160: aload 6
    //   162: astore_2
    //   163: aload_3
    //   164: astore 4
    //   166: aload 6
    //   168: astore 5
    //   170: aload 11
    //   172: ldc_w 345
    //   175: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 6
    //   181: astore_2
    //   182: aload_3
    //   183: astore 4
    //   185: aload 6
    //   187: astore 5
    //   189: aload 11
    //   191: aload 9
    //   193: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 6
    //   199: astore_2
    //   200: aload_3
    //   201: astore 4
    //   203: aload 6
    //   205: astore 5
    //   207: aload 10
    //   209: aload 11
    //   211: invokevirtual 322	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 340	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: aload 6
    //   219: astore_2
    //   220: aload_3
    //   221: astore 4
    //   223: aload 6
    //   225: astore 5
    //   227: aload_0
    //   228: aload 6
    //   230: invokevirtual 163	com/tencent/open/downloadnew/common/DownloadDBHelper:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   233: astore 10
    //   235: aload 6
    //   237: astore_2
    //   238: aload_3
    //   239: astore 4
    //   241: aload 6
    //   243: astore 5
    //   245: getstatic 169	com/tencent/open/downloadnew/common/DownloadDBHelper:a	Ljava/lang/String;
    //   248: astore 11
    //   250: aload 6
    //   252: astore_2
    //   253: aload_3
    //   254: astore 4
    //   256: aload 6
    //   258: astore 5
    //   260: new 309	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   267: astore 12
    //   269: aload 6
    //   271: astore_2
    //   272: aload_3
    //   273: astore 4
    //   275: aload 6
    //   277: astore 5
    //   279: aload 12
    //   281: ldc_w 347
    //   284: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 6
    //   290: astore_2
    //   291: aload_3
    //   292: astore 4
    //   294: aload 6
    //   296: astore 5
    //   298: aload 12
    //   300: aload 10
    //   302: invokevirtual 348	com/tencent/open/downloadnew/DownloadInfo:toString	()Ljava/lang/String;
    //   305: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: pop
    //   309: aload 6
    //   311: astore_2
    //   312: aload_3
    //   313: astore 4
    //   315: aload 6
    //   317: astore 5
    //   319: aload 11
    //   321: aload 12
    //   323: invokevirtual 322	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   326: invokestatic 340	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   329: aload 6
    //   331: astore_2
    //   332: aload_3
    //   333: astore 4
    //   335: aload 6
    //   337: astore 5
    //   339: aload 8
    //   341: aload 9
    //   343: aload 10
    //   345: invokeinterface 353 3 0
    //   350: pop
    //   351: aload 6
    //   353: astore_2
    //   354: aload_3
    //   355: astore 4
    //   357: aload 6
    //   359: astore 5
    //   361: aload 6
    //   363: invokeinterface 356 1 0
    //   368: istore_1
    //   369: iload_1
    //   370: ifne -264 -> 106
    //   373: aload 6
    //   375: ifnull +114 -> 489
    //   378: aload 6
    //   380: invokeinterface 166 1 0
    //   385: goto +104 -> 489
    //   388: aload_3
    //   389: invokevirtual 167	android/database/sqlite/SQLiteDatabase:close	()V
    //   392: goto +55 -> 447
    //   395: astore_3
    //   396: goto +57 -> 453
    //   399: astore 6
    //   401: goto +14 -> 415
    //   404: astore_3
    //   405: aconst_null
    //   406: astore 4
    //   408: goto +45 -> 453
    //   411: astore 6
    //   413: aconst_null
    //   414: astore_3
    //   415: aload 5
    //   417: astore_2
    //   418: aload_3
    //   419: astore 4
    //   421: getstatic 169	com/tencent/open/downloadnew/common/DownloadDBHelper:a	Ljava/lang/String;
    //   424: ldc_w 358
    //   427: aload 6
    //   429: invokestatic 176	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   432: aload 5
    //   434: ifnull +62 -> 496
    //   437: aload 5
    //   439: invokeinterface 166 1 0
    //   444: goto +52 -> 496
    //   447: aload 7
    //   449: monitorexit
    //   450: aload 8
    //   452: areturn
    //   453: aload_2
    //   454: ifnull +12 -> 466
    //   457: aload_2
    //   458: invokeinterface 166 1 0
    //   463: goto +3 -> 466
    //   466: aload 4
    //   468: ifnull +8 -> 476
    //   471: aload 4
    //   473: invokevirtual 167	android/database/sqlite/SQLiteDatabase:close	()V
    //   476: aload_3
    //   477: athrow
    //   478: aload 7
    //   480: monitorexit
    //   481: goto +5 -> 486
    //   484: aload_2
    //   485: athrow
    //   486: goto -2 -> 484
    //   489: aload_3
    //   490: ifnull -43 -> 447
    //   493: goto -105 -> 388
    //   496: aload_3
    //   497: ifnull -50 -> 447
    //   500: goto -112 -> 388
    //   503: astore_2
    //   504: goto -26 -> 478
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	507	0	this	DownloadDBHelper
    //   368	2	1	bool	boolean
    //   33	452	2	localObject1	Object
    //   503	1	2	localObject2	Object
    //   41	348	3	localSQLiteDatabase	SQLiteDatabase
    //   395	1	3	localObject3	Object
    //   404	1	3	localObject4	Object
    //   414	83	3	localObject5	Object
    //   35	437	4	localObject6	Object
    //   30	408	5	localCursor1	Cursor
    //   27	352	6	localCursor2	Cursor
    //   399	1	6	localException1	java.lang.Exception
    //   411	17	6	localException2	java.lang.Exception
    //   21	458	7	arrayOfByte	byte[]
    //   16	435	8	localConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    //   124	218	9	str	String
    //   139	205	10	localObject7	Object
    //   158	162	11	localObject8	Object
    //   267	55	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   52	68	395	finally
    //   78	88	395	finally
    //   98	106	395	finally
    //   116	126	395	finally
    //   136	141	395	finally
    //   151	160	395	finally
    //   170	179	395	finally
    //   189	197	395	finally
    //   207	217	395	finally
    //   227	235	395	finally
    //   245	250	395	finally
    //   260	269	395	finally
    //   279	288	395	finally
    //   298	309	395	finally
    //   319	329	395	finally
    //   339	351	395	finally
    //   361	369	395	finally
    //   421	432	395	finally
    //   52	68	399	java/lang/Exception
    //   78	88	399	java/lang/Exception
    //   98	106	399	java/lang/Exception
    //   116	126	399	java/lang/Exception
    //   136	141	399	java/lang/Exception
    //   151	160	399	java/lang/Exception
    //   170	179	399	java/lang/Exception
    //   189	197	399	java/lang/Exception
    //   207	217	399	java/lang/Exception
    //   227	235	399	java/lang/Exception
    //   245	250	399	java/lang/Exception
    //   260	269	399	java/lang/Exception
    //   279	288	399	java/lang/Exception
    //   298	309	399	java/lang/Exception
    //   319	329	399	java/lang/Exception
    //   339	351	399	java/lang/Exception
    //   361	369	399	java/lang/Exception
    //   37	42	404	finally
    //   37	42	411	java/lang/Exception
    //   378	385	503	finally
    //   388	392	503	finally
    //   437	444	503	finally
    //   447	450	503	finally
    //   457	463	503	finally
    //   471	476	503	finally
    //   476	478	503	finally
    //   478	481	503	finally
  }
  
  /* Error */
  public void b(String paramString)
  {
    // Byte code:
    //   0: getstatic 78	com/tencent/open/downloadnew/common/DownloadDBHelper:c	[B
    //   3: astore 5
    //   5: aload 5
    //   7: monitorenter
    //   8: aconst_null
    //   9: astore_2
    //   10: aconst_null
    //   11: astore_3
    //   12: aload_0
    //   13: invokevirtual 200	com/tencent/open/downloadnew/common/DownloadDBHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   16: astore 4
    //   18: aload 4
    //   20: astore_3
    //   21: aload 4
    //   23: astore_2
    //   24: getstatic 169	com/tencent/open/downloadnew/common/DownloadDBHelper:a	Ljava/lang/String;
    //   27: astore 6
    //   29: aload 4
    //   31: astore_3
    //   32: aload 4
    //   34: astore_2
    //   35: new 309	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 310	java/lang/StringBuilder:<init>	()V
    //   42: astore 7
    //   44: aload 4
    //   46: astore_3
    //   47: aload 4
    //   49: astore_2
    //   50: aload 7
    //   52: ldc_w 362
    //   55: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 4
    //   61: astore_3
    //   62: aload 4
    //   64: astore_2
    //   65: aload 7
    //   67: iconst_1
    //   68: anewarray 20	java/lang/String
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: invokestatic 367	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   78: invokevirtual 316	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 4
    //   84: astore_3
    //   85: aload 4
    //   87: astore_2
    //   88: aload 6
    //   90: aload 7
    //   92: invokevirtual 322	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   95: invokestatic 340	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: aload 4
    //   100: astore_3
    //   101: aload 4
    //   103: astore_2
    //   104: aload 4
    //   106: ldc 147
    //   108: ldc_w 303
    //   111: iconst_1
    //   112: anewarray 20	java/lang/String
    //   115: dup
    //   116: iconst_0
    //   117: aload_1
    //   118: aastore
    //   119: invokevirtual 371	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   122: pop
    //   123: aload 4
    //   125: ifnull +37 -> 162
    //   128: aload 4
    //   130: astore_2
    //   131: aload_2
    //   132: invokevirtual 167	android/database/sqlite/SQLiteDatabase:close	()V
    //   135: goto +27 -> 162
    //   138: astore_1
    //   139: goto +27 -> 166
    //   142: astore_1
    //   143: aload_2
    //   144: astore_3
    //   145: getstatic 169	com/tencent/open/downloadnew/common/DownloadDBHelper:a	Ljava/lang/String;
    //   148: ldc_w 373
    //   151: aload_1
    //   152: invokestatic 176	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   155: aload_2
    //   156: ifnull +6 -> 162
    //   159: goto -28 -> 131
    //   162: aload 5
    //   164: monitorexit
    //   165: return
    //   166: aload_3
    //   167: ifnull +7 -> 174
    //   170: aload_3
    //   171: invokevirtual 167	android/database/sqlite/SQLiteDatabase:close	()V
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
  
  protected String c()
  {
    if (this.d == 0L)
    {
      this.d = CommonDataAdapter.a().c();
      if (this.d == 0L) {
        LogUtility.e(a, "getUin() is empty!");
      }
    }
    return String.valueOf(this.d);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE download_info (appid TEXT PRIMARY KEY,download_url TEXT,package TEXT,push_title TEXT,sendtime_col TEXT,uin_col TEXT,triggertime_col INTEGER,via_col TEXT,patch_url TEXT,update_type INTEGER,myappid_col TEXT,apkid_col TEXT,version_col INTEGER,downloadtype_col INTEGER,filepath_col TEXT,source_col TEXT,last_download_size INTEGER,is_apk INTEGER,myapp_download_from INTEGER,icon_url TEXT,is_show_notification INTEGER,apk_writecode_state INTEGER,extra_info TEXT,is_autoInstall_by_sdk INTEGER,download_file_md5 TEXT,download_file_size INTEGER,ext_param_id TEXT); ");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    String str = a;
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
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpgrade oldVersion=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" newVersion=");
    localStringBuilder.append(paramInt2);
    LogUtility.c(str, localStringBuilder.toString());
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.common.DownloadDBHelper
 * JD-Core Version:    0.7.0.1
 */