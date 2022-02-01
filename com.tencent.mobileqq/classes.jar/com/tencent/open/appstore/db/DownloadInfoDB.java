package com.tencent.open.appstore.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.tencent.open.adapter.CommonDataAdapter;
import com.tencent.open.base.LogUtility;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.List;

public class DownloadInfoDB
  extends SQLiteOpenHelper
{
  private static final String[] a = { "ticket", "open_appid", "download_url", "package_name", "push_title", "send_time", "uin", "trigger_time", "via", "patch_url", "update_type", "appid", "apkid", "version", "download_type", "filepath", "source", "last_download_size", "is_apk", "yyb_download_from", "icon_url", "is_show_notification", "apk_write_code_state", "extra_info", "is_autoInstall_by_sdk", "download_file_md5", "download_file_size", "download_state", "download_progress", "total_length", "recommend_id", "source_from_server", "channel_id", "page_id", "module_id", "position_id", "process_flag_id", "unique_id", "ext_param_id" };
  private static volatile DownloadInfoDB b = null;
  private final Object c = new Object();
  private long d = 0L;
  
  private DownloadInfoDB(Context paramContext)
  {
    super(paramContext, "open_appstore_db_DownloadInfoDB.db", null, 5);
  }
  
  private static int a(Cursor paramCursor, String paramString)
  {
    if ((paramCursor != null) && (!TextUtils.isEmpty(paramString))) {
      return paramCursor.getColumnIndex(paramString);
    }
    return -1;
  }
  
  public static DownloadInfoDB a()
  {
    if (b == null) {
      try
      {
        if (b == null)
        {
          b = new DownloadInfoDB(CommonDataAdapter.a().b());
          b.d();
        }
      }
      finally {}
    }
    return b;
  }
  
  private DownloadInfo a(Cursor paramCursor)
  {
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.b = paramCursor.getString(a(paramCursor, "ticket"));
    localDownloadInfo.c = paramCursor.getString(a(paramCursor, "open_appid"));
    localDownloadInfo.d = paramCursor.getString(a(paramCursor, "download_url"));
    localDownloadInfo.e = paramCursor.getString(a(paramCursor, "package_name"));
    localDownloadInfo.f = paramCursor.getString(a(paramCursor, "push_title"));
    localDownloadInfo.g = paramCursor.getString(a(paramCursor, "send_time"));
    localDownloadInfo.i = paramCursor.getLong(a(paramCursor, "trigger_time"));
    localDownloadInfo.h = paramCursor.getString(a(paramCursor, "via"));
    localDownloadInfo.k = paramCursor.getString(a(paramCursor, "patch_url"));
    localDownloadInfo.j = paramCursor.getInt(a(paramCursor, "update_type"));
    localDownloadInfo.l = paramCursor.getString(a(paramCursor, "appid"));
    localDownloadInfo.m = paramCursor.getString(a(paramCursor, "apkid"));
    localDownloadInfo.n = paramCursor.getInt(a(paramCursor, "version"));
    localDownloadInfo.o = paramCursor.getInt(a(paramCursor, "download_type"));
    localDownloadInfo.q = paramCursor.getString(a(paramCursor, "filepath"));
    localDownloadInfo.r = paramCursor.getString(a(paramCursor, "source"));
    localDownloadInfo.y = paramCursor.getLong(a(paramCursor, "last_download_size"));
    int i = paramCursor.getInt(a(paramCursor, "is_apk"));
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localDownloadInfo.A = bool1;
    localDownloadInfo.z = paramCursor.getInt(a(paramCursor, "yyb_download_from"));
    localDownloadInfo.B = paramCursor.getString(a(paramCursor, "icon_url"));
    localDownloadInfo.C = paramCursor.getInt(a(paramCursor, "is_show_notification"));
    localDownloadInfo.D = paramCursor.getInt(a(paramCursor, "apk_write_code_state"));
    if (localDownloadInfo.D == 1) {
      localDownloadInfo.D = 0;
    }
    localDownloadInfo.F = paramCursor.getString(a(paramCursor, "extra_info"));
    boolean bool1 = bool2;
    if (paramCursor.getInt(a(paramCursor, "is_autoInstall_by_sdk")) == 1) {
      bool1 = true;
    }
    localDownloadInfo.G = bool1;
    localDownloadInfo.H = paramCursor.getString(a(paramCursor, "download_file_md5"));
    localDownloadInfo.I = paramCursor.getLong(a(paramCursor, "download_file_size"));
    localDownloadInfo.a(paramCursor.getInt(a(paramCursor, "download_state")));
    localDownloadInfo.t = paramCursor.getInt(a(paramCursor, "download_progress"));
    localDownloadInfo.E = paramCursor.getLong(a(paramCursor, "total_length"));
    localDownloadInfo.J = paramCursor.getString(a(paramCursor, "recommend_id"));
    localDownloadInfo.K = paramCursor.getString(a(paramCursor, "source_from_server"));
    localDownloadInfo.L = paramCursor.getString(a(paramCursor, "channel_id"));
    localDownloadInfo.M = paramCursor.getString(a(paramCursor, "page_id"));
    localDownloadInfo.N = paramCursor.getString(a(paramCursor, "module_id"));
    localDownloadInfo.O = paramCursor.getString(a(paramCursor, "position_id"));
    localDownloadInfo.R = paramCursor.getString(a(paramCursor, "process_flag_id"));
    localDownloadInfo.S = paramCursor.getString(a(paramCursor, "unique_id"));
    localDownloadInfo.T = paramCursor.getString(a(paramCursor, "ext_param_id"));
    return localDownloadInfo;
  }
  
  /* Error */
  private DownloadInfo a(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 112	com/tencent/open/appstore/db/DownloadInfoDB:c	Ljava/lang/Object;
    //   4: astore 8
    //   6: aload 8
    //   8: monitorenter
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 7
    //   15: aconst_null
    //   16: astore 4
    //   18: aload_0
    //   19: invokevirtual 277	com/tencent/open/appstore/db/DownloadInfoDB:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   22: astore_3
    //   23: aload_3
    //   24: ldc_w 279
    //   27: getstatic 96	com/tencent/open/appstore/db/DownloadInfoDB:a	[Ljava/lang/String;
    //   30: aload_1
    //   31: aload_2
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 285	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore 5
    //   40: aload 4
    //   42: astore_1
    //   43: aload_3
    //   44: astore 4
    //   46: aload 5
    //   48: astore_2
    //   49: aload 5
    //   51: invokeinterface 289 1 0
    //   56: ifle +30 -> 86
    //   59: aload_3
    //   60: astore 4
    //   62: aload 5
    //   64: astore_2
    //   65: aload 5
    //   67: invokeinterface 293 1 0
    //   72: pop
    //   73: aload_3
    //   74: astore 4
    //   76: aload 5
    //   78: astore_2
    //   79: aload_0
    //   80: aload 5
    //   82: invokespecial 295	com/tencent/open/appstore/db/DownloadInfoDB:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   85: astore_1
    //   86: aload 5
    //   88: ifnull +127 -> 215
    //   91: aload 5
    //   93: invokeinterface 298 1 0
    //   98: goto +117 -> 215
    //   101: aload_3
    //   102: invokevirtual 299	android/database/sqlite/SQLiteDatabase:close	()V
    //   105: aload_1
    //   106: astore_2
    //   107: goto +69 -> 176
    //   110: astore_2
    //   111: aload 5
    //   113: astore_1
    //   114: aload_2
    //   115: astore 5
    //   117: goto +30 -> 147
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_2
    //   123: goto +58 -> 181
    //   126: astore 5
    //   128: aconst_null
    //   129: astore_1
    //   130: goto +17 -> 147
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_2
    //   136: aload_2
    //   137: astore_3
    //   138: goto +43 -> 181
    //   141: astore 5
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: astore_3
    //   147: aload_3
    //   148: astore 4
    //   150: aload_1
    //   151: astore_2
    //   152: ldc_w 301
    //   155: ldc_w 303
    //   158: aload 5
    //   160: invokestatic 308	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload_1
    //   164: ifnull +60 -> 224
    //   167: aload_1
    //   168: invokeinterface 298 1 0
    //   173: goto +51 -> 224
    //   176: aload 8
    //   178: monitorexit
    //   179: aload_2
    //   180: areturn
    //   181: aload_2
    //   182: ifnull +12 -> 194
    //   185: aload_2
    //   186: invokeinterface 298 1 0
    //   191: goto +3 -> 194
    //   194: aload_3
    //   195: ifnull +7 -> 202
    //   198: aload_3
    //   199: invokevirtual 299	android/database/sqlite/SQLiteDatabase:close	()V
    //   202: aload_1
    //   203: athrow
    //   204: aload 8
    //   206: monitorexit
    //   207: goto +5 -> 212
    //   210: aload_1
    //   211: athrow
    //   212: goto -2 -> 210
    //   215: aload_1
    //   216: astore_2
    //   217: aload_3
    //   218: ifnull -42 -> 176
    //   221: goto -120 -> 101
    //   224: aload 7
    //   226: astore_2
    //   227: aload_3
    //   228: ifnull -52 -> 176
    //   231: aload 6
    //   233: astore_1
    //   234: goto -133 -> 101
    //   237: astore_1
    //   238: aload 4
    //   240: astore_3
    //   241: goto -60 -> 181
    //   244: astore_1
    //   245: goto -41 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	DownloadInfoDB
    //   0	248	1	paramString	String
    //   0	248	2	paramArrayOfString	String[]
    //   22	219	3	localObject1	Object
    //   16	223	4	localObject2	Object
    //   38	78	5	localObject3	Object
    //   126	1	5	localException1	java.lang.Exception
    //   141	18	5	localException2	java.lang.Exception
    //   10	222	6	localObject4	Object
    //   13	212	7	localObject5	Object
    //   4	201	8	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   49	59	110	java/lang/Exception
    //   65	73	110	java/lang/Exception
    //   79	86	110	java/lang/Exception
    //   23	40	120	finally
    //   23	40	126	java/lang/Exception
    //   18	23	133	finally
    //   18	23	141	java/lang/Exception
    //   49	59	237	finally
    //   65	73	237	finally
    //   79	86	237	finally
    //   152	163	237	finally
    //   91	98	244	finally
    //   101	105	244	finally
    //   167	173	244	finally
    //   176	179	244	finally
    //   185	191	244	finally
    //   198	202	244	finally
    //   202	204	244	finally
    //   204	207	244	finally
  }
  
  private void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
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
  private List<DownloadInfo> b(String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 331	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 332	java/util/ArrayList:<init>	()V
    //   7: astore 10
    //   9: aload_0
    //   10: getfield 112	com/tencent/open/appstore/db/DownloadInfoDB:c	Ljava/lang/Object;
    //   13: astore 9
    //   15: aload 9
    //   17: monitorenter
    //   18: aconst_null
    //   19: astore 8
    //   21: aconst_null
    //   22: astore 7
    //   24: aconst_null
    //   25: astore 4
    //   27: aconst_null
    //   28: astore 6
    //   30: aload_0
    //   31: invokevirtual 277	com/tencent/open/appstore/db/DownloadInfoDB:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   34: astore 5
    //   36: aload 6
    //   38: astore 4
    //   40: aload 5
    //   42: astore 6
    //   44: aload 8
    //   46: astore 7
    //   48: aload 5
    //   50: ldc_w 279
    //   53: getstatic 96	com/tencent/open/appstore/db/DownloadInfoDB:a	[Ljava/lang/String;
    //   56: aload_1
    //   57: aload_2
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: invokevirtual 285	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore_1
    //   65: aload_1
    //   66: astore 4
    //   68: aload 5
    //   70: astore 6
    //   72: aload_1
    //   73: astore 7
    //   75: aload_1
    //   76: invokeinterface 289 1 0
    //   81: ifle +64 -> 145
    //   84: aload_1
    //   85: astore 4
    //   87: aload 5
    //   89: astore 6
    //   91: aload_1
    //   92: astore 7
    //   94: aload_1
    //   95: invokeinterface 293 1 0
    //   100: pop
    //   101: aload_1
    //   102: astore 4
    //   104: aload 5
    //   106: astore 6
    //   108: aload_1
    //   109: astore 7
    //   111: aload 10
    //   113: aload_0
    //   114: aload_1
    //   115: invokespecial 295	com/tencent/open/appstore/db/DownloadInfoDB:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   118: invokeinterface 338 2 0
    //   123: pop
    //   124: aload_1
    //   125: astore 4
    //   127: aload 5
    //   129: astore 6
    //   131: aload_1
    //   132: astore 7
    //   134: aload_1
    //   135: invokeinterface 341 1 0
    //   140: istore_3
    //   141: iload_3
    //   142: ifne -41 -> 101
    //   145: aload_1
    //   146: ifnull +154 -> 300
    //   149: aload_1
    //   150: invokeinterface 298 1 0
    //   155: goto +145 -> 300
    //   158: aload_1
    //   159: invokevirtual 299	android/database/sqlite/SQLiteDatabase:close	()V
    //   162: goto +56 -> 218
    //   165: astore_1
    //   166: goto +96 -> 262
    //   169: astore_2
    //   170: aload 5
    //   172: astore_1
    //   173: goto +13 -> 186
    //   176: astore_1
    //   177: aconst_null
    //   178: astore 6
    //   180: goto +82 -> 262
    //   183: astore_2
    //   184: aconst_null
    //   185: astore_1
    //   186: aload 7
    //   188: astore 4
    //   190: aload_1
    //   191: astore 6
    //   193: ldc_w 301
    //   196: ldc_w 343
    //   199: aload_2
    //   200: invokestatic 308	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   203: aload 7
    //   205: ifnull +106 -> 311
    //   208: aload 7
    //   210: invokeinterface 298 1 0
    //   215: goto +96 -> 311
    //   218: aload 9
    //   220: monitorexit
    //   221: new 345	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   228: astore_1
    //   229: aload_1
    //   230: ldc_w 348
    //   233: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: aload_1
    //   238: aload 10
    //   240: invokeinterface 355 1 0
    //   245: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: ldc_w 301
    //   252: aload_1
    //   253: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 365	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 10
    //   261: areturn
    //   262: aload 4
    //   264: ifnull +13 -> 277
    //   267: aload 4
    //   269: invokeinterface 298 1 0
    //   274: goto +3 -> 277
    //   277: aload 6
    //   279: ifnull +8 -> 287
    //   282: aload 6
    //   284: invokevirtual 299	android/database/sqlite/SQLiteDatabase:close	()V
    //   287: aload_1
    //   288: athrow
    //   289: aload 9
    //   291: monitorexit
    //   292: goto +5 -> 297
    //   295: aload_1
    //   296: athrow
    //   297: goto -2 -> 295
    //   300: aload 5
    //   302: ifnull -84 -> 218
    //   305: aload 5
    //   307: astore_1
    //   308: goto -150 -> 158
    //   311: aload_1
    //   312: ifnull -94 -> 218
    //   315: goto -157 -> 158
    //   318: astore_1
    //   319: goto -30 -> 289
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	DownloadInfoDB
    //   0	322	1	paramString	String
    //   0	322	2	paramArrayOfString	String[]
    //   140	2	3	bool	boolean
    //   25	243	4	localObject1	Object
    //   34	272	5	localSQLiteDatabase	SQLiteDatabase
    //   28	255	6	localObject2	Object
    //   22	187	7	localObject3	Object
    //   19	26	8	localObject4	Object
    //   13	277	9	localObject5	Object
    //   7	253	10	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   48	65	165	finally
    //   75	84	165	finally
    //   94	101	165	finally
    //   111	124	165	finally
    //   134	141	165	finally
    //   193	203	165	finally
    //   48	65	169	java/lang/Exception
    //   75	84	169	java/lang/Exception
    //   94	101	169	java/lang/Exception
    //   111	124	169	java/lang/Exception
    //   134	141	169	java/lang/Exception
    //   30	36	176	finally
    //   30	36	183	java/lang/Exception
    //   149	155	318	finally
    //   158	162	318	finally
    //   208	215	318	finally
    //   218	221	318	finally
    //   267	274	318	finally
    //   282	287	318	finally
    //   287	289	318	finally
    //   289	292	318	finally
  }
  
  private String c()
  {
    if (this.d == 0L)
    {
      this.d = CommonDataAdapter.a().c();
      if (this.d == 0L) {
        LogUtility.e("DownloadInfoDB", "getUin() is empty!");
      }
    }
    return String.valueOf(this.d);
  }
  
  private void d()
  {
    if (this.d == 0L)
    {
      this.d = CommonDataAdapter.a().c();
      if (this.d == 0L) {
        this.d = CommonDataAdapter.a().d();
      }
    }
  }
  
  public List<DownloadInfo> a(String paramString)
  {
    return b("package_name = ?", new String[] { paramString });
  }
  
  /* Error */
  public void a(DownloadInfo paramDownloadInfo, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 112	com/tencent/open/appstore/db/DownloadInfoDB:c	Ljava/lang/Object;
    //   4: astore 9
    //   6: aload 9
    //   8: monitorenter
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 6
    //   15: aload_0
    //   16: invokevirtual 390	com/tencent/open/appstore/db/DownloadInfoDB:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   19: astore 7
    //   21: aload 7
    //   23: invokevirtual 312	android/database/sqlite/SQLiteDatabase:beginTransaction	()V
    //   26: new 392	android/content/ContentValues
    //   29: dup
    //   30: invokespecial 393	android/content/ContentValues:<init>	()V
    //   33: astore 6
    //   35: aload 6
    //   37: ldc 18
    //   39: aload_1
    //   40: getfield 153	com/tencent/open/downloadnew/DownloadInfo:b	Ljava/lang/String;
    //   43: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload 6
    //   48: ldc 20
    //   50: aload_1
    //   51: getfield 155	com/tencent/open/downloadnew/DownloadInfo:c	Ljava/lang/String;
    //   54: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aload 6
    //   59: ldc 22
    //   61: aload_1
    //   62: getfield 157	com/tencent/open/downloadnew/DownloadInfo:d	Ljava/lang/String;
    //   65: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload 6
    //   70: ldc 24
    //   72: aload_1
    //   73: getfield 160	com/tencent/open/downloadnew/DownloadInfo:e	Ljava/lang/String;
    //   76: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload 6
    //   81: ldc 26
    //   83: aload_1
    //   84: getfield 163	com/tencent/open/downloadnew/DownloadInfo:f	Ljava/lang/String;
    //   87: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: aload 6
    //   92: ldc 28
    //   94: aload_1
    //   95: getfield 166	com/tencent/open/downloadnew/DownloadInfo:g	Ljava/lang/String;
    //   98: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: aload 6
    //   103: ldc 30
    //   105: aload_0
    //   106: invokespecial 398	com/tencent/open/appstore/db/DownloadInfoDB:c	()Ljava/lang/String;
    //   109: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload 6
    //   114: ldc 32
    //   116: aload_1
    //   117: getfield 173	com/tencent/open/downloadnew/DownloadInfo:i	J
    //   120: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   123: invokevirtual 406	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   126: aload 6
    //   128: ldc 34
    //   130: aload_1
    //   131: getfield 176	com/tencent/open/downloadnew/DownloadInfo:h	Ljava/lang/String;
    //   134: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload 6
    //   139: ldc 36
    //   141: aload_1
    //   142: getfield 179	com/tencent/open/downloadnew/DownloadInfo:k	Ljava/lang/String;
    //   145: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: aload 6
    //   150: ldc 38
    //   152: aload_1
    //   153: getfield 187	com/tencent/open/downloadnew/DownloadInfo:j	I
    //   156: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   159: invokevirtual 414	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   162: aload 6
    //   164: ldc 40
    //   166: aload_1
    //   167: getfield 190	com/tencent/open/downloadnew/DownloadInfo:l	Ljava/lang/String;
    //   170: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload 6
    //   175: ldc 42
    //   177: aload_1
    //   178: getfield 193	com/tencent/open/downloadnew/DownloadInfo:m	Ljava/lang/String;
    //   181: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   184: aload 6
    //   186: ldc 44
    //   188: aload_1
    //   189: getfield 196	com/tencent/open/downloadnew/DownloadInfo:n	I
    //   192: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   195: invokevirtual 414	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   198: aload 6
    //   200: ldc 46
    //   202: aload_1
    //   203: getfield 199	com/tencent/open/downloadnew/DownloadInfo:o	I
    //   206: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   209: invokevirtual 414	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   212: aload 6
    //   214: ldc 48
    //   216: aload_1
    //   217: getfield 202	com/tencent/open/downloadnew/DownloadInfo:q	Ljava/lang/String;
    //   220: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload 6
    //   225: ldc 50
    //   227: aload_1
    //   228: getfield 205	com/tencent/open/downloadnew/DownloadInfo:r	Ljava/lang/String;
    //   231: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: aload 6
    //   236: ldc 52
    //   238: aload_1
    //   239: getfield 208	com/tencent/open/downloadnew/DownloadInfo:y	J
    //   242: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   245: invokevirtual 406	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   248: aload_1
    //   249: getfield 212	com/tencent/open/downloadnew/DownloadInfo:A	Z
    //   252: ifeq +563 -> 815
    //   255: iconst_1
    //   256: istore_3
    //   257: goto +3 -> 260
    //   260: aload 6
    //   262: ldc 54
    //   264: iload_3
    //   265: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   268: invokevirtual 414	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   271: aload 6
    //   273: ldc 56
    //   275: aload_1
    //   276: getfield 215	com/tencent/open/downloadnew/DownloadInfo:z	I
    //   279: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   282: invokevirtual 414	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   285: aload 6
    //   287: ldc 58
    //   289: aload_1
    //   290: getfield 218	com/tencent/open/downloadnew/DownloadInfo:B	Ljava/lang/String;
    //   293: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload 6
    //   298: ldc 60
    //   300: aload_1
    //   301: getfield 221	com/tencent/open/downloadnew/DownloadInfo:C	I
    //   304: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   307: invokevirtual 414	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   310: aload_1
    //   311: getfield 224	com/tencent/open/downloadnew/DownloadInfo:D	I
    //   314: ifne +8 -> 322
    //   317: iconst_1
    //   318: istore_3
    //   319: goto +8 -> 327
    //   322: aload_1
    //   323: getfield 224	com/tencent/open/downloadnew/DownloadInfo:D	I
    //   326: istore_3
    //   327: aload 6
    //   329: ldc 62
    //   331: iload_3
    //   332: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: invokevirtual 414	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   338: aload 6
    //   340: ldc 64
    //   342: aload_1
    //   343: getfield 227	com/tencent/open/downloadnew/DownloadInfo:F	Ljava/lang/String;
    //   346: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload_1
    //   350: getfield 230	com/tencent/open/downloadnew/DownloadInfo:G	Z
    //   353: ifeq +467 -> 820
    //   356: iconst_1
    //   357: istore_3
    //   358: goto +3 -> 361
    //   361: aload 6
    //   363: ldc 66
    //   365: iload_3
    //   366: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   369: invokevirtual 414	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   372: aload 6
    //   374: ldc 68
    //   376: aload_1
    //   377: getfield 233	com/tencent/open/downloadnew/DownloadInfo:H	Ljava/lang/String;
    //   380: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload 6
    //   385: ldc 70
    //   387: aload_1
    //   388: getfield 235	com/tencent/open/downloadnew/DownloadInfo:I	J
    //   391: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   394: invokevirtual 406	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   397: aload 6
    //   399: ldc 72
    //   401: aload_1
    //   402: invokevirtual 416	com/tencent/open/downloadnew/DownloadInfo:a	()I
    //   405: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   408: invokevirtual 414	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   411: aload 6
    //   413: ldc 74
    //   415: aload_1
    //   416: getfield 241	com/tencent/open/downloadnew/DownloadInfo:t	I
    //   419: invokestatic 411	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   422: invokevirtual 414	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   425: aload 6
    //   427: ldc 76
    //   429: aload_1
    //   430: getfield 244	com/tencent/open/downloadnew/DownloadInfo:E	J
    //   433: invokestatic 403	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   436: invokevirtual 406	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   439: aload 6
    //   441: ldc 78
    //   443: aload_1
    //   444: getfield 246	com/tencent/open/downloadnew/DownloadInfo:J	Ljava/lang/String;
    //   447: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: aload 6
    //   452: ldc 80
    //   454: aload_1
    //   455: getfield 249	com/tencent/open/downloadnew/DownloadInfo:K	Ljava/lang/String;
    //   458: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: aload 6
    //   463: ldc 82
    //   465: aload_1
    //   466: getfield 252	com/tencent/open/downloadnew/DownloadInfo:L	Ljava/lang/String;
    //   469: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   472: aload 6
    //   474: ldc 84
    //   476: aload_1
    //   477: getfield 255	com/tencent/open/downloadnew/DownloadInfo:M	Ljava/lang/String;
    //   480: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   483: aload 6
    //   485: ldc 86
    //   487: aload_1
    //   488: getfield 258	com/tencent/open/downloadnew/DownloadInfo:N	Ljava/lang/String;
    //   491: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload 6
    //   496: ldc 88
    //   498: aload_1
    //   499: getfield 261	com/tencent/open/downloadnew/DownloadInfo:O	Ljava/lang/String;
    //   502: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   505: iload_2
    //   506: ifeq +14 -> 520
    //   509: aload 6
    //   511: ldc 90
    //   513: aload_1
    //   514: getfield 264	com/tencent/open/downloadnew/DownloadInfo:R	Ljava/lang/String;
    //   517: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: aload 6
    //   522: ldc 92
    //   524: aload_1
    //   525: getfield 267	com/tencent/open/downloadnew/DownloadInfo:S	Ljava/lang/String;
    //   528: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   531: aload 6
    //   533: ldc 94
    //   535: aload_1
    //   536: getfield 270	com/tencent/open/downloadnew/DownloadInfo:T	Ljava/lang/String;
    //   539: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   542: aload 7
    //   544: ldc_w 279
    //   547: aload 6
    //   549: ldc_w 418
    //   552: iconst_1
    //   553: anewarray 16	java/lang/String
    //   556: dup
    //   557: iconst_0
    //   558: aload_1
    //   559: getfield 153	com/tencent/open/downloadnew/DownloadInfo:b	Ljava/lang/String;
    //   562: aastore
    //   563: invokevirtual 422	android/database/sqlite/SQLiteDatabase:update	(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   566: istore_3
    //   567: new 345	java/lang/StringBuilder
    //   570: dup
    //   571: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   574: astore 8
    //   576: aload 8
    //   578: ldc_w 424
    //   581: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: pop
    //   585: aload 8
    //   587: iload_3
    //   588: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: ldc_w 301
    //   595: aload 8
    //   597: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 426	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   603: iload_3
    //   604: ifne +60 -> 664
    //   607: aload 6
    //   609: ldc 90
    //   611: aload_1
    //   612: getfield 264	com/tencent/open/downloadnew/DownloadInfo:R	Ljava/lang/String;
    //   615: invokevirtual 396	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   618: aload 7
    //   620: ldc_w 279
    //   623: aconst_null
    //   624: aload 6
    //   626: invokevirtual 430	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   629: lstore 4
    //   631: new 345	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   638: astore_1
    //   639: aload_1
    //   640: ldc_w 432
    //   643: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: pop
    //   647: aload_1
    //   648: lload 4
    //   650: invokevirtual 435	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   653: pop
    //   654: ldc_w 301
    //   657: aload_1
    //   658: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   661: invokestatic 426	com/tencent/open/base/LogUtility:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   664: aload 7
    //   666: invokevirtual 321	android/database/sqlite/SQLiteDatabase:setTransactionSuccessful	()V
    //   669: aload 7
    //   671: ifnull +92 -> 763
    //   674: aload 7
    //   676: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   679: aload 7
    //   681: invokevirtual 299	android/database/sqlite/SQLiteDatabase:close	()V
    //   684: goto +79 -> 763
    //   687: astore_1
    //   688: ldc_w 301
    //   691: ldc_w 437
    //   694: aload_1
    //   695: invokestatic 308	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   698: goto +65 -> 763
    //   701: astore_1
    //   702: goto +65 -> 767
    //   705: astore 6
    //   707: aload 7
    //   709: astore_1
    //   710: aload 6
    //   712: astore 7
    //   714: goto +16 -> 730
    //   717: astore_1
    //   718: aload 6
    //   720: astore 7
    //   722: goto +45 -> 767
    //   725: astore 7
    //   727: aload 8
    //   729: astore_1
    //   730: aload_1
    //   731: astore 6
    //   733: ldc_w 301
    //   736: ldc_w 437
    //   739: aload 7
    //   741: invokestatic 308	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   744: aload_1
    //   745: ifnull +18 -> 763
    //   748: aload_1
    //   749: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   752: aload_1
    //   753: invokevirtual 299	android/database/sqlite/SQLiteDatabase:close	()V
    //   756: goto +7 -> 763
    //   759: astore_1
    //   760: goto -72 -> 688
    //   763: aload 9
    //   765: monitorexit
    //   766: return
    //   767: aload 7
    //   769: ifnull +33 -> 802
    //   772: aload 7
    //   774: invokevirtual 324	android/database/sqlite/SQLiteDatabase:endTransaction	()V
    //   777: aload 7
    //   779: invokevirtual 299	android/database/sqlite/SQLiteDatabase:close	()V
    //   782: goto +20 -> 802
    //   785: astore_1
    //   786: goto +18 -> 804
    //   789: astore 6
    //   791: ldc_w 301
    //   794: ldc_w 437
    //   797: aload 6
    //   799: invokestatic 308	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   802: aload_1
    //   803: athrow
    //   804: aload 9
    //   806: monitorexit
    //   807: goto +5 -> 812
    //   810: aload_1
    //   811: athrow
    //   812: goto -2 -> 810
    //   815: iconst_0
    //   816: istore_3
    //   817: goto -557 -> 260
    //   820: iconst_0
    //   821: istore_3
    //   822: goto -461 -> 361
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	825	0	this	DownloadInfoDB
    //   0	825	1	paramDownloadInfo	DownloadInfo
    //   0	825	2	paramBoolean	boolean
    //   256	566	3	i	int
    //   629	20	4	l	long
    //   13	612	6	localContentValues	android.content.ContentValues
    //   705	14	6	localException1	java.lang.Exception
    //   731	1	6	localDownloadInfo	DownloadInfo
    //   789	9	6	localException2	java.lang.Exception
    //   19	702	7	localObject1	Object
    //   725	53	7	localException3	java.lang.Exception
    //   10	718	8	localStringBuilder	StringBuilder
    //   4	801	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   674	684	687	java/lang/Exception
    //   21	255	701	finally
    //   260	317	701	finally
    //   322	327	701	finally
    //   327	356	701	finally
    //   361	505	701	finally
    //   509	520	701	finally
    //   520	603	701	finally
    //   607	664	701	finally
    //   664	669	701	finally
    //   21	255	705	java/lang/Exception
    //   260	317	705	java/lang/Exception
    //   322	327	705	java/lang/Exception
    //   327	356	705	java/lang/Exception
    //   361	505	705	java/lang/Exception
    //   509	520	705	java/lang/Exception
    //   520	603	705	java/lang/Exception
    //   607	664	705	java/lang/Exception
    //   664	669	705	java/lang/Exception
    //   15	21	717	finally
    //   733	744	717	finally
    //   15	21	725	java/lang/Exception
    //   748	756	759	java/lang/Exception
    //   674	684	785	finally
    //   688	698	785	finally
    //   748	756	785	finally
    //   763	766	785	finally
    //   772	782	785	finally
    //   791	802	785	finally
    //   802	804	785	finally
    //   804	807	785	finally
    //   772	782	789	java/lang/Exception
  }
  
  public DownloadInfo b(String paramString)
  {
    return a("ticket = ?", new String[] { paramString });
  }
  
  /* Error */
  public java.util.concurrent.ConcurrentHashMap<String, DownloadInfo> b()
  {
    // Byte code:
    //   0: ldc_w 301
    //   3: ldc_w 443
    //   6: invokestatic 445	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: new 447	java/util/concurrent/ConcurrentHashMap
    //   12: dup
    //   13: invokespecial 448	java/util/concurrent/ConcurrentHashMap:<init>	()V
    //   16: astore 8
    //   18: aload_0
    //   19: getfield 112	com/tencent/open/appstore/db/DownloadInfoDB:c	Ljava/lang/Object;
    //   22: astore 7
    //   24: aload 7
    //   26: monitorenter
    //   27: aconst_null
    //   28: astore 6
    //   30: aconst_null
    //   31: astore 5
    //   33: aconst_null
    //   34: astore_2
    //   35: aconst_null
    //   36: astore 4
    //   38: aload_0
    //   39: invokevirtual 277	com/tencent/open/appstore/db/DownloadInfoDB:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   42: astore_3
    //   43: aload 4
    //   45: astore_2
    //   46: aload_3
    //   47: astore 4
    //   49: aload 6
    //   51: astore 5
    //   53: aload_3
    //   54: ldc_w 279
    //   57: getstatic 96	com/tencent/open/appstore/db/DownloadInfoDB:a	[Ljava/lang/String;
    //   60: aconst_null
    //   61: aconst_null
    //   62: aconst_null
    //   63: aconst_null
    //   64: aconst_null
    //   65: invokevirtual 285	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   68: astore 6
    //   70: aload 6
    //   72: astore_2
    //   73: aload_3
    //   74: astore 4
    //   76: aload 6
    //   78: astore 5
    //   80: aload 6
    //   82: invokeinterface 289 1 0
    //   87: ifle +264 -> 351
    //   90: aload 6
    //   92: astore_2
    //   93: aload_3
    //   94: astore 4
    //   96: aload 6
    //   98: astore 5
    //   100: aload 6
    //   102: invokeinterface 293 1 0
    //   107: pop
    //   108: aload 6
    //   110: astore_2
    //   111: aload_3
    //   112: astore 4
    //   114: aload 6
    //   116: astore 5
    //   118: aload 6
    //   120: aload 6
    //   122: ldc 18
    //   124: invokestatic 146	com/tencent/open/appstore/db/DownloadInfoDB:a	(Landroid/database/Cursor;Ljava/lang/String;)I
    //   127: invokeinterface 150 2 0
    //   132: astore 9
    //   134: aload 6
    //   136: astore_2
    //   137: aload_3
    //   138: astore 4
    //   140: aload 6
    //   142: astore 5
    //   144: new 345	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   151: astore 10
    //   153: aload 6
    //   155: astore_2
    //   156: aload_3
    //   157: astore 4
    //   159: aload 6
    //   161: astore 5
    //   163: aload 10
    //   165: ldc_w 450
    //   168: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: aload 6
    //   174: astore_2
    //   175: aload_3
    //   176: astore 4
    //   178: aload 6
    //   180: astore 5
    //   182: aload 10
    //   184: aload 9
    //   186: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 6
    //   192: astore_2
    //   193: aload_3
    //   194: astore 4
    //   196: aload 6
    //   198: astore 5
    //   200: ldc_w 301
    //   203: aload 10
    //   205: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 445	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 6
    //   213: astore_2
    //   214: aload_3
    //   215: astore 4
    //   217: aload 6
    //   219: astore 5
    //   221: aload_0
    //   222: aload 6
    //   224: invokespecial 295	com/tencent/open/appstore/db/DownloadInfoDB:a	(Landroid/database/Cursor;)Lcom/tencent/open/downloadnew/DownloadInfo;
    //   227: astore 10
    //   229: aload 6
    //   231: astore_2
    //   232: aload_3
    //   233: astore 4
    //   235: aload 6
    //   237: astore 5
    //   239: new 345	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   246: astore 11
    //   248: aload 6
    //   250: astore_2
    //   251: aload_3
    //   252: astore 4
    //   254: aload 6
    //   256: astore 5
    //   258: aload 11
    //   260: ldc_w 452
    //   263: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 6
    //   269: astore_2
    //   270: aload_3
    //   271: astore 4
    //   273: aload 6
    //   275: astore 5
    //   277: aload 11
    //   279: aload 10
    //   281: invokevirtual 453	com/tencent/open/downloadnew/DownloadInfo:toString	()Ljava/lang/String;
    //   284: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 6
    //   290: astore_2
    //   291: aload_3
    //   292: astore 4
    //   294: aload 6
    //   296: astore 5
    //   298: ldc_w 301
    //   301: aload 11
    //   303: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 445	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   309: aload 6
    //   311: astore_2
    //   312: aload_3
    //   313: astore 4
    //   315: aload 6
    //   317: astore 5
    //   319: aload 8
    //   321: aload 9
    //   323: aload 10
    //   325: invokevirtual 456	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   328: pop
    //   329: aload 6
    //   331: astore_2
    //   332: aload_3
    //   333: astore 4
    //   335: aload 6
    //   337: astore 5
    //   339: aload 6
    //   341: invokeinterface 341 1 0
    //   346: istore_1
    //   347: iload_1
    //   348: ifne -240 -> 108
    //   351: aload 6
    //   353: ifnull +114 -> 467
    //   356: aload 6
    //   358: invokeinterface 298 1 0
    //   363: goto +104 -> 467
    //   366: aload_3
    //   367: invokevirtual 299	android/database/sqlite/SQLiteDatabase:close	()V
    //   370: goto +55 -> 425
    //   373: astore_3
    //   374: goto +57 -> 431
    //   377: astore 6
    //   379: goto +14 -> 393
    //   382: astore_3
    //   383: aconst_null
    //   384: astore 4
    //   386: goto +45 -> 431
    //   389: astore 6
    //   391: aconst_null
    //   392: astore_3
    //   393: aload 5
    //   395: astore_2
    //   396: aload_3
    //   397: astore 4
    //   399: ldc_w 301
    //   402: ldc_w 458
    //   405: aload 6
    //   407: invokestatic 308	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   410: aload 5
    //   412: ifnull +62 -> 474
    //   415: aload 5
    //   417: invokeinterface 298 1 0
    //   422: goto +52 -> 474
    //   425: aload 7
    //   427: monitorexit
    //   428: aload 8
    //   430: areturn
    //   431: aload_2
    //   432: ifnull +12 -> 444
    //   435: aload_2
    //   436: invokeinterface 298 1 0
    //   441: goto +3 -> 444
    //   444: aload 4
    //   446: ifnull +8 -> 454
    //   449: aload 4
    //   451: invokevirtual 299	android/database/sqlite/SQLiteDatabase:close	()V
    //   454: aload_3
    //   455: athrow
    //   456: aload 7
    //   458: monitorexit
    //   459: goto +5 -> 464
    //   462: aload_2
    //   463: athrow
    //   464: goto -2 -> 462
    //   467: aload_3
    //   468: ifnull -43 -> 425
    //   471: goto -105 -> 366
    //   474: aload_3
    //   475: ifnull -50 -> 425
    //   478: goto -112 -> 366
    //   481: astore_2
    //   482: goto -26 -> 456
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	this	DownloadInfoDB
    //   346	2	1	bool	boolean
    //   34	429	2	localObject1	Object
    //   481	1	2	localObject2	Object
    //   42	325	3	localSQLiteDatabase	SQLiteDatabase
    //   373	1	3	localObject3	Object
    //   382	1	3	localObject4	Object
    //   392	83	3	localObject5	Object
    //   36	414	4	localObject6	Object
    //   31	385	5	localCursor1	Cursor
    //   28	329	6	localCursor2	Cursor
    //   377	1	6	localException1	java.lang.Exception
    //   389	17	6	localException2	java.lang.Exception
    //   22	435	7	localObject7	Object
    //   16	413	8	localConcurrentHashMap	java.util.concurrent.ConcurrentHashMap
    //   132	190	9	str	String
    //   151	173	10	localObject8	Object
    //   246	56	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   53	70	373	finally
    //   80	90	373	finally
    //   100	108	373	finally
    //   118	134	373	finally
    //   144	153	373	finally
    //   163	172	373	finally
    //   182	190	373	finally
    //   200	211	373	finally
    //   221	229	373	finally
    //   239	248	373	finally
    //   258	267	373	finally
    //   277	288	373	finally
    //   298	309	373	finally
    //   319	329	373	finally
    //   339	347	373	finally
    //   399	410	373	finally
    //   53	70	377	java/lang/Exception
    //   80	90	377	java/lang/Exception
    //   100	108	377	java/lang/Exception
    //   118	134	377	java/lang/Exception
    //   144	153	377	java/lang/Exception
    //   163	172	377	java/lang/Exception
    //   182	190	377	java/lang/Exception
    //   200	211	377	java/lang/Exception
    //   221	229	377	java/lang/Exception
    //   239	248	377	java/lang/Exception
    //   258	267	377	java/lang/Exception
    //   277	288	377	java/lang/Exception
    //   298	309	377	java/lang/Exception
    //   319	329	377	java/lang/Exception
    //   339	347	377	java/lang/Exception
    //   38	43	382	finally
    //   38	43	389	java/lang/Exception
    //   356	363	481	finally
    //   366	370	481	finally
    //   415	422	481	finally
    //   425	428	481	finally
    //   435	441	481	finally
    //   449	454	481	finally
    //   454	456	481	finally
    //   456	459	481	finally
  }
  
  /* Error */
  public void c(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +13 -> 17
    //   7: ldc_w 301
    //   10: ldc_w 461
    //   13: invokestatic 374	com/tencent/open/base/LogUtility:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: return
    //   17: aload_0
    //   18: getfield 112	com/tencent/open/appstore/db/DownloadInfoDB:c	Ljava/lang/Object;
    //   21: astore 5
    //   23: aload 5
    //   25: monitorenter
    //   26: aconst_null
    //   27: astore_2
    //   28: aconst_null
    //   29: astore_3
    //   30: aload_0
    //   31: invokevirtual 390	com/tencent/open/appstore/db/DownloadInfoDB:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   34: astore 4
    //   36: aload 4
    //   38: astore_3
    //   39: aload 4
    //   41: astore_2
    //   42: new 345	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 346	java/lang/StringBuilder:<init>	()V
    //   49: astore 6
    //   51: aload 4
    //   53: astore_3
    //   54: aload 4
    //   56: astore_2
    //   57: aload 6
    //   59: ldc_w 463
    //   62: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload 4
    //   68: astore_3
    //   69: aload 4
    //   71: astore_2
    //   72: aload 6
    //   74: iconst_1
    //   75: anewarray 16	java/lang/String
    //   78: dup
    //   79: iconst_0
    //   80: aload_1
    //   81: aastore
    //   82: invokestatic 468	java/util/Arrays:toString	([Ljava/lang/Object;)Ljava/lang/String;
    //   85: invokevirtual 352	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload 4
    //   91: astore_3
    //   92: aload 4
    //   94: astore_2
    //   95: ldc_w 301
    //   98: aload 6
    //   100: invokevirtual 362	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 445	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload 4
    //   108: astore_3
    //   109: aload 4
    //   111: astore_2
    //   112: aload 4
    //   114: ldc_w 279
    //   117: ldc_w 418
    //   120: iconst_1
    //   121: anewarray 16	java/lang/String
    //   124: dup
    //   125: iconst_0
    //   126: aload_1
    //   127: aastore
    //   128: invokevirtual 472	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   131: pop
    //   132: aload 4
    //   134: ifnull +37 -> 171
    //   137: aload 4
    //   139: astore_2
    //   140: aload_2
    //   141: invokevirtual 299	android/database/sqlite/SQLiteDatabase:close	()V
    //   144: goto +27 -> 171
    //   147: astore_1
    //   148: goto +27 -> 175
    //   151: astore_1
    //   152: aload_2
    //   153: astore_3
    //   154: ldc_w 301
    //   157: ldc_w 474
    //   160: aload_1
    //   161: invokestatic 308	com/tencent/open/base/LogUtility:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: aload_2
    //   165: ifnull +6 -> 171
    //   168: goto -28 -> 140
    //   171: aload 5
    //   173: monitorexit
    //   174: return
    //   175: aload_3
    //   176: ifnull +7 -> 183
    //   179: aload_3
    //   180: invokevirtual 299	android/database/sqlite/SQLiteDatabase:close	()V
    //   183: aload_1
    //   184: athrow
    //   185: astore_1
    //   186: aload 5
    //   188: monitorexit
    //   189: goto +5 -> 194
    //   192: aload_1
    //   193: athrow
    //   194: goto -2 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	DownloadInfoDB
    //   0	197	1	paramString	String
    //   27	138	2	localObject1	Object
    //   29	151	3	localObject2	Object
    //   34	104	4	localSQLiteDatabase	SQLiteDatabase
    //   21	166	5	localObject3	Object
    //   49	50	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   30	36	147	finally
    //   42	51	147	finally
    //   57	66	147	finally
    //   72	89	147	finally
    //   95	106	147	finally
    //   112	132	147	finally
    //   154	164	147	finally
    //   30	36	151	java/lang/Exception
    //   42	51	151	java/lang/Exception
    //   57	66	151	java/lang/Exception
    //   72	89	151	java/lang/Exception
    //   95	106	151	java/lang/Exception
    //   112	132	151	java/lang/Exception
    //   140	144	185	finally
    //   171	174	185	finally
    //   179	183	185	finally
    //   183	185	185	finally
    //   186	189	185	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE download_info (ticket TEXT PRIMARY KEY,open_appid TEXT,download_url TEXT,package_name TEXT,push_title TEXT,send_time TEXT,uin TEXT,trigger_time INTEGER,via TEXT,patch_url TEXT,update_type INTEGER,appid TEXT,apkid TEXT,version INTEGER,download_type INTEGER,filepath TEXT,source TEXT,last_download_size INTEGER,is_apk INTEGER,yyb_download_from INTEGER,icon_url TEXT,is_show_notification INTEGER,apk_write_code_state INTEGER,extra_info TEXT,is_autoInstall_by_sdk INTEGER,download_file_md5 TEXT,download_file_size INTEGER,download_state INTEGER,download_progress INTEGER,total_length INTEGER,recommend_id TEXT,source_from_server TEXT,channel_id TEXT,page_id TEXT,module_id TEXT,position_id TEXT,process_flag_id TEXT,unique_id TEXT,ext_param_id TEXT); ");
  }
  
  public void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDowngrade oldVersion=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" newVersion=");
    localStringBuilder.append(paramInt2);
    LogUtility.b("DownloadInfoDB", localStringBuilder.toString());
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpgrade oldVersion=");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" newVersion=");
    localStringBuilder.append(paramInt2);
    LogUtility.b("DownloadInfoDB", localStringBuilder.toString());
    a(paramSQLiteDatabase, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.appstore.db.DownloadInfoDB
 * JD-Core Version:    0.7.0.1
 */