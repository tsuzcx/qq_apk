package com.tencent.rmonitor.base.db.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.rmonitor.base.db.BaseTable;
import com.tencent.rmonitor.base.db.DBDataStatus;
import com.tencent.rmonitor.base.reporter.data.ReportData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/db/table/ReportDataTable;", "Lcom/tencent/rmonitor/base/db/BaseTable;", "pId", "", "processName", "version", "uin", "params", "isRealTime", "", "occurTime", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "cursorToResultObject", "Lcom/tencent/rmonitor/base/reporter/data/ReportData;", "cursor", "Landroid/database/Cursor;", "insert", "", "dataBase", "Landroid/database/sqlite/SQLiteDatabase;", "block", "Lkotlin/Function0;", "search", "", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class ReportDataTable
  extends BaseTable
{
  public static final ReportDataTable.Companion b = new ReportDataTable.Companion(null);
  private String c = "";
  private String d = "";
  private String e = "";
  private String f = "";
  private boolean g;
  private String h = "";
  private long i;
  
  static
  {
    new ReportDataTable();
  }
  
  public ReportDataTable()
  {
    super("report_data", "CREATE TABLE report_data (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,p_id TEXT,version TEXT,params TEXT,is_real_time TINYINT,uin TEXT,status TINYINT,occur_time BIGINT);");
  }
  
  public ReportDataTable(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    this();
    this.c = paramString2;
    this.d = paramString1;
    this.e = paramString3;
  }
  
  public ReportDataTable(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5, boolean paramBoolean, long paramLong)
  {
    this();
    this.c = paramString2;
    this.d = paramString1;
    this.e = paramString3;
    this.f = paramString5;
    this.g = paramBoolean;
    this.h = paramString4;
    this.i = paramLong;
  }
  
  private final ReportData a(Cursor paramCursor)
  {
    if (paramCursor != null)
    {
      ReportData localReportData = new ReportData(0, null, false, 0L, 0L, null, false, false, null, 511, null);
      localReportData.setDbId(paramCursor.getInt(paramCursor.getColumnIndex("_id")));
      localReportData.setParams(new JSONObject(paramCursor.getString(paramCursor.getColumnIndex("params"))));
      boolean bool;
      if (paramCursor.getInt(paramCursor.getColumnIndex("is_real_time")) > 0) {
        bool = true;
      } else {
        bool = false;
      }
      localReportData.setRealTime(bool);
      paramCursor = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      Intrinsics.checkExpressionValueIsNotNull(paramCursor, "it.getString(it.getColumnIndex(COLUMN_UIN))");
      localReportData.setUin(paramCursor);
      return localReportData;
    }
    return (ReportData)null;
  }
  
  public int a(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<Integer> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "dataBase");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramFunction0 = new ContentValues();
    paramFunction0.put("process_name", this.c);
    paramFunction0.put("p_id", this.d);
    paramFunction0.put("version", this.e);
    paramFunction0.put("params", this.f);
    paramFunction0.put("is_real_time", Boolean.valueOf(this.g));
    paramFunction0.put("uin", this.h);
    paramFunction0.put("status", Integer.valueOf(DBDataStatus.TO_SEND.getValue()));
    if (this.i == 0L) {
      this.i = System.currentTimeMillis();
    }
    paramFunction0.put("occur_time", Long.valueOf(this.i));
    return (int)paramSQLiteDatabase.insert("report_data", "name", paramFunction0);
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public java.lang.Object b(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<? extends java.lang.Object> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 151
    //   3: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 152
    //   9: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: new 224	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 225	java/util/ArrayList:<init>	()V
    //   19: astore 4
    //   21: aload_2
    //   22: invokeinterface 231 1 0
    //   27: iconst_1
    //   28: invokestatic 168	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: invokestatic 235	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   34: ifeq +248 -> 282
    //   37: ldc 237
    //   39: astore_3
    //   40: goto +3 -> 43
    //   43: aload_2
    //   44: invokeinterface 231 1 0
    //   49: iconst_1
    //   50: invokestatic 168	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   53: invokestatic 235	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   56: ifeq +57 -> 113
    //   59: iconst_5
    //   60: anewarray 239	java/lang/String
    //   63: astore_2
    //   64: aload_2
    //   65: iconst_0
    //   66: aload_0
    //   67: getfield 74	com/tencent/rmonitor/base/db/table/ReportDataTable:c	Ljava/lang/String;
    //   70: aastore
    //   71: aload_2
    //   72: iconst_1
    //   73: aload_0
    //   74: getfield 76	com/tencent/rmonitor/base/db/table/ReportDataTable:d	Ljava/lang/String;
    //   77: aastore
    //   78: aload_2
    //   79: iconst_2
    //   80: aload_0
    //   81: getfield 78	com/tencent/rmonitor/base/db/table/ReportDataTable:e	Ljava/lang/String;
    //   84: aastore
    //   85: aload_2
    //   86: iconst_3
    //   87: getstatic 179	com/tencent/rmonitor/base/db/DBDataStatus:TO_SEND	Lcom/tencent/rmonitor/base/db/DBDataStatus;
    //   90: invokevirtual 183	com/tencent/rmonitor/base/db/DBDataStatus:getValue	()I
    //   93: invokestatic 241	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   96: aastore
    //   97: aload_2
    //   98: iconst_4
    //   99: invokestatic 197	java/lang/System:currentTimeMillis	()J
    //   102: ldc 242
    //   104: i2l
    //   105: lsub
    //   106: invokestatic 245	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   109: aastore
    //   110: goto +29 -> 139
    //   113: iconst_3
    //   114: anewarray 239	java/lang/String
    //   117: astore_2
    //   118: aload_2
    //   119: iconst_0
    //   120: aload_0
    //   121: getfield 74	com/tencent/rmonitor/base/db/table/ReportDataTable:c	Ljava/lang/String;
    //   124: aastore
    //   125: aload_2
    //   126: iconst_1
    //   127: aload_0
    //   128: getfield 76	com/tencent/rmonitor/base/db/table/ReportDataTable:d	Ljava/lang/String;
    //   131: aastore
    //   132: aload_2
    //   133: iconst_2
    //   134: aload_0
    //   135: getfield 78	com/tencent/rmonitor/base/db/table/ReportDataTable:e	Ljava/lang/String;
    //   138: aastore
    //   139: aload_1
    //   140: ldc 66
    //   142: aconst_null
    //   143: aload_3
    //   144: aload_2
    //   145: aconst_null
    //   146: aconst_null
    //   147: aconst_null
    //   148: invokevirtual 249	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   151: astore_1
    //   152: aload_1
    //   153: ifnull +126 -> 279
    //   156: aload_1
    //   157: checkcast 251	java/io/Closeable
    //   160: astore_3
    //   161: aconst_null
    //   162: checkcast 222	java/lang/Throwable
    //   165: astore_2
    //   166: aload_2
    //   167: astore_1
    //   168: aload_3
    //   169: checkcast 110	android/database/Cursor
    //   172: astore 5
    //   174: aload_2
    //   175: astore_1
    //   176: aload 5
    //   178: invokeinterface 255 1 0
    //   183: pop
    //   184: aload_2
    //   185: astore_1
    //   186: aload 5
    //   188: invokeinterface 258 1 0
    //   193: ifne +41 -> 234
    //   196: aload_2
    //   197: astore_1
    //   198: aload_0
    //   199: aload 5
    //   201: invokespecial 260	com/tencent/rmonitor/base/db/table/ReportDataTable:a	(Landroid/database/Cursor;)Lcom/tencent/rmonitor/base/reporter/data/ReportData;
    //   204: astore 6
    //   206: aload 6
    //   208: ifnull +13 -> 221
    //   211: aload_2
    //   212: astore_1
    //   213: aload 4
    //   215: aload 6
    //   217: invokevirtual 264	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   220: pop
    //   221: aload_2
    //   222: astore_1
    //   223: aload 5
    //   225: invokeinterface 267 1 0
    //   230: pop
    //   231: goto -47 -> 184
    //   234: aload_2
    //   235: astore_1
    //   236: getstatic 273	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   239: astore 5
    //   241: aload_3
    //   242: aload_2
    //   243: invokestatic 279	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   246: aload 4
    //   248: areturn
    //   249: astore_2
    //   250: goto +8 -> 258
    //   253: astore_2
    //   254: aload_2
    //   255: astore_1
    //   256: aload_2
    //   257: athrow
    //   258: aload_3
    //   259: aload_1
    //   260: invokestatic 279	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   263: aload_2
    //   264: athrow
    //   265: astore_1
    //   266: getstatic 284	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   269: ldc_w 286
    //   272: aload_1
    //   273: checkcast 222	java/lang/Throwable
    //   276: invokevirtual 289	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   279: aload 4
    //   281: areturn
    //   282: ldc_w 291
    //   285: astore_3
    //   286: goto -243 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	289	0	this	ReportDataTable
    //   0	289	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	289	2	paramFunction0	Function0<? extends java.lang.Object>
    //   39	247	3	localObject1	java.lang.Object
    //   19	261	4	localArrayList	java.util.ArrayList
    //   172	68	5	localObject2	java.lang.Object
    //   204	12	6	localReportData	ReportData
    // Exception table:
    //   from	to	target	type
    //   168	174	249	finally
    //   176	184	249	finally
    //   186	196	249	finally
    //   198	206	249	finally
    //   213	221	249	finally
    //   223	231	249	finally
    //   236	241	249	finally
    //   256	258	249	finally
    //   168	174	253	java/lang/Throwable
    //   176	184	253	java/lang/Throwable
    //   186	196	253	java/lang/Throwable
    //   198	206	253	java/lang/Throwable
    //   213	221	253	java/lang/Throwable
    //   223	231	253	java/lang/Throwable
    //   236	241	253	java/lang/Throwable
    //   21	37	265	java/lang/Exception
    //   43	110	265	java/lang/Exception
    //   113	139	265	java/lang/Exception
    //   139	152	265	java/lang/Exception
    //   156	166	265	java/lang/Exception
    //   241	246	265	java/lang/Exception
    //   258	265	265	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.db.table.ReportDataTable
 * JD-Core Version:    0.7.0.1
 */