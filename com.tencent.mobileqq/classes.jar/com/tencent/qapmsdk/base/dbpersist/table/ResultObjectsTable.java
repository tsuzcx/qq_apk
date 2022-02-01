package com.tencent.qapmsdk.base.dbpersist.table;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.qapmsdk.base.dbpersist.BaseTable;
import com.tencent.qapmsdk.base.dbpersist.DBDataStatus;
import com.tencent.qapmsdk.base.reporter.uploaddata.data.ResultObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable;", "Lcom/tencent/qapmsdk/base/dbpersist/BaseTable;", "pId", "", "processName", "", "version", "uin", "params", "isRealTime", "", "occurTime", "", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)V", "(ILjava/lang/String;Ljava/lang/String;)V", "()V", "cursorToResultObject", "Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;", "cursor", "Landroid/database/Cursor;", "insert", "dataBase", "Landroid/database/sqlite/SQLiteDatabase;", "block", "Lkotlin/Function0;", "search", "", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ResultObjectsTable
  extends BaseTable
{
  private static final String COLUMN_ID = "_id";
  private static final String COLUMN_IS_REAL_TIME = "is_real_time";
  private static final String COLUMN_OCCUR_TIME = "occur_time";
  private static final String COLUMN_PARAMS = "params";
  private static final String COLUMN_PROCESS_NAME = "process_name";
  private static final String COLUMN_PRODUCT_ID = "p_id";
  private static final String COLUMN_STATUS = "status";
  private static final String COLUMN_UIN = "uin";
  private static final String COLUMN_VERSION = "version";
  private static final String CREATE_RESULT_OBJECTS = "CREATE TABLE result_objects (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,p_id INT,version TEXT,params TEXT,is_real_time TINYINT,uin TEXT,status TINYINT,occur_time BIGINT);";
  public static final ResultObjectsTable.Companion Companion = new ResultObjectsTable.Companion(null);
  private static final String TABLE_RESULT_OBJECTS = "result_objects";
  private static final String TAG = "QAPM_base_ResultObjectsTable";
  private boolean isRealTime;
  private long occurTime;
  private int pId;
  private String params = "";
  private String processName = "";
  private String uin = "";
  private String version = "";
  
  static
  {
    new ResultObjectsTable();
  }
  
  public ResultObjectsTable()
  {
    super("result_objects", "CREATE TABLE result_objects (_id INTEGER PRIMARY KEY AUTOINCREMENT,process_name TEXT,p_id INT,version TEXT,params TEXT,is_real_time TINYINT,uin TEXT,status TINYINT,occur_time BIGINT);");
  }
  
  public ResultObjectsTable(int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    this();
    this.processName = paramString1;
    this.pId = paramInt;
    this.version = paramString2;
  }
  
  public ResultObjectsTable(int paramInt, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, boolean paramBoolean, long paramLong)
  {
    this();
    this.processName = paramString1;
    this.pId = paramInt;
    this.version = paramString2;
    this.params = paramString4;
    this.isRealTime = paramBoolean;
    this.uin = paramString3;
    this.occurTime = paramLong;
  }
  
  private final ResultObject cursorToResultObject(Cursor paramCursor)
  {
    boolean bool = false;
    if (paramCursor != null)
    {
      ResultObject localResultObject = new ResultObject(0, null, false, 0L, 0L, null, false, false, null, 511, null);
      localResultObject.setDbId(paramCursor.getInt(paramCursor.getColumnIndex("_id")));
      localResultObject.setParams(new JSONObject(paramCursor.getString(paramCursor.getColumnIndex("params"))));
      if (paramCursor.getInt(paramCursor.getColumnIndex("is_real_time")) > 0) {
        bool = true;
      }
      localResultObject.setRealTime(bool);
      paramCursor = paramCursor.getString(paramCursor.getColumnIndex("uin"));
      Intrinsics.checkExpressionValueIsNotNull(paramCursor, "it.getString(it.getColumnIndex(COLUMN_UIN))");
      localResultObject.setUin(paramCursor);
      return localResultObject;
    }
    return (ResultObject)null;
  }
  
  public int insert(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<Integer> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "dataBase");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramFunction0 = new ContentValues();
    paramFunction0.put("process_name", this.processName);
    paramFunction0.put("p_id", Integer.valueOf(this.pId));
    paramFunction0.put("version", this.version);
    paramFunction0.put("params", this.params);
    paramFunction0.put("is_real_time", Boolean.valueOf(this.isRealTime));
    paramFunction0.put("uin", this.uin);
    paramFunction0.put("status", Integer.valueOf(DBDataStatus.TO_SEND.getValue()));
    if (this.occurTime == 0L) {
      this.occurTime = System.currentTimeMillis();
    }
    paramFunction0.put("occur_time", Long.valueOf(this.occurTime));
    return (int)paramSQLiteDatabase.insert("result_objects", "name", paramFunction0);
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public java.lang.Object search(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<? extends java.lang.Object> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 164
    //   3: invokestatic 110	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 165
    //   9: invokestatic 110	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: new 229	java/util/ArrayList
    //   15: dup
    //   16: invokespecial 230	java/util/ArrayList:<init>	()V
    //   19: astore 4
    //   21: aload_2
    //   22: invokeinterface 236 1 0
    //   27: iconst_1
    //   28: invokestatic 185	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   31: invokestatic 240	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   34: ifeq +200 -> 234
    //   37: ldc 242
    //   39: astore_3
    //   40: aload_2
    //   41: invokeinterface 236 1 0
    //   46: iconst_1
    //   47: invokestatic 185	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   50: invokestatic 240	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   53: ifeq +188 -> 241
    //   56: iconst_5
    //   57: anewarray 244	java/lang/String
    //   60: astore_2
    //   61: aload_2
    //   62: iconst_0
    //   63: aload_0
    //   64: getfield 96	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:processName	Ljava/lang/String;
    //   67: aastore
    //   68: aload_2
    //   69: iconst_1
    //   70: aload_0
    //   71: getfield 112	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:pId	I
    //   74: invokestatic 246	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   77: aastore
    //   78: aload_2
    //   79: iconst_2
    //   80: aload_0
    //   81: getfield 98	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:version	Ljava/lang/String;
    //   84: aastore
    //   85: aload_2
    //   86: iconst_3
    //   87: getstatic 194	com/tencent/qapmsdk/base/dbpersist/DBDataStatus:TO_SEND	Lcom/tencent/qapmsdk/base/dbpersist/DBDataStatus;
    //   90: invokevirtual 198	com/tencent/qapmsdk/base/dbpersist/DBDataStatus:getValue	()I
    //   93: invokestatic 246	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   96: aastore
    //   97: aload_2
    //   98: iconst_4
    //   99: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   102: ldc 247
    //   104: i2l
    //   105: lsub
    //   106: invokestatic 250	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   109: aastore
    //   110: aload_1
    //   111: ldc 72
    //   113: aconst_null
    //   114: aload_3
    //   115: aload_2
    //   116: aconst_null
    //   117: aconst_null
    //   118: aconst_null
    //   119: invokevirtual 254	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   122: astore_1
    //   123: aload_1
    //   124: ifnull +107 -> 231
    //   127: aload_1
    //   128: checkcast 256	java/io/Closeable
    //   131: astore_3
    //   132: aconst_null
    //   133: checkcast 227	java/lang/Throwable
    //   136: astore_2
    //   137: aload_2
    //   138: astore_1
    //   139: aload_3
    //   140: checkcast 125	android/database/Cursor
    //   143: astore 5
    //   145: aload_2
    //   146: astore_1
    //   147: aload 5
    //   149: invokeinterface 260 1 0
    //   154: pop
    //   155: aload_2
    //   156: astore_1
    //   157: aload 5
    //   159: invokeinterface 263 1 0
    //   164: ifne +109 -> 273
    //   167: aload_2
    //   168: astore_1
    //   169: aload_0
    //   170: aload 5
    //   172: invokespecial 265	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:cursorToResultObject	(Landroid/database/Cursor;)Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   175: astore 6
    //   177: aload 6
    //   179: ifnull +13 -> 192
    //   182: aload_2
    //   183: astore_1
    //   184: aload 4
    //   186: aload 6
    //   188: invokevirtual 269	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   191: pop
    //   192: aload_2
    //   193: astore_1
    //   194: aload 5
    //   196: invokeinterface 272 1 0
    //   201: pop
    //   202: goto -47 -> 155
    //   205: astore_2
    //   206: aload_2
    //   207: astore_1
    //   208: aload_2
    //   209: athrow
    //   210: astore_2
    //   211: aload_3
    //   212: aload_1
    //   213: invokestatic 278	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   216: aload_2
    //   217: athrow
    //   218: astore_1
    //   219: getstatic 284	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   222: ldc 75
    //   224: aload_1
    //   225: checkcast 227	java/lang/Throwable
    //   228: invokevirtual 288	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   231: aload 4
    //   233: areturn
    //   234: ldc_w 290
    //   237: astore_3
    //   238: goto -198 -> 40
    //   241: iconst_3
    //   242: anewarray 244	java/lang/String
    //   245: astore_2
    //   246: aload_2
    //   247: iconst_0
    //   248: aload_0
    //   249: getfield 96	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:processName	Ljava/lang/String;
    //   252: aastore
    //   253: aload_2
    //   254: iconst_1
    //   255: aload_0
    //   256: getfield 112	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:pId	I
    //   259: invokestatic 246	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   262: aastore
    //   263: aload_2
    //   264: iconst_2
    //   265: aload_0
    //   266: getfield 98	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:version	Ljava/lang/String;
    //   269: aastore
    //   270: goto -160 -> 110
    //   273: aload_2
    //   274: astore_1
    //   275: getstatic 295	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   278: astore 5
    //   280: aload_3
    //   281: aload_2
    //   282: invokestatic 278	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   285: aload 4
    //   287: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	288	0	this	ResultObjectsTable
    //   0	288	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	288	2	paramFunction0	Function0<? extends java.lang.Object>
    //   39	242	3	localObject1	java.lang.Object
    //   19	267	4	localArrayList	java.util.ArrayList
    //   143	136	5	localObject2	java.lang.Object
    //   175	12	6	localResultObject	ResultObject
    // Exception table:
    //   from	to	target	type
    //   139	145	205	java/lang/Throwable
    //   147	155	205	java/lang/Throwable
    //   157	167	205	java/lang/Throwable
    //   169	177	205	java/lang/Throwable
    //   184	192	205	java/lang/Throwable
    //   194	202	205	java/lang/Throwable
    //   275	280	205	java/lang/Throwable
    //   139	145	210	finally
    //   147	155	210	finally
    //   157	167	210	finally
    //   169	177	210	finally
    //   184	192	210	finally
    //   194	202	210	finally
    //   208	210	210	finally
    //   275	280	210	finally
    //   21	37	218	java/lang/Exception
    //   40	110	218	java/lang/Exception
    //   110	123	218	java/lang/Exception
    //   127	137	218	java/lang/Exception
    //   211	218	218	java/lang/Exception
    //   241	270	218	java/lang/Exception
    //   280	285	218	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.table.ResultObjectsTable
 * JD-Core Version:    0.7.0.1
 */