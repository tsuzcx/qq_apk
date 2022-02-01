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
    if (paramCursor != null)
    {
      ResultObject localResultObject = new ResultObject(0, null, false, 0L, 0L, null, false, false, null, 511, null);
      localResultObject.setDbId(paramCursor.getInt(paramCursor.getColumnIndex("_id")));
      localResultObject.setParams(new JSONObject(paramCursor.getString(paramCursor.getColumnIndex("params"))));
      boolean bool;
      if (paramCursor.getInt(paramCursor.getColumnIndex("is_real_time")) > 0) {
        bool = true;
      } else {
        bool = false;
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
    //   34: ifeq +253 -> 287
    //   37: ldc 242
    //   39: astore_3
    //   40: goto +3 -> 43
    //   43: aload_2
    //   44: invokeinterface 236 1 0
    //   49: iconst_1
    //   50: invokestatic 185	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   53: invokestatic 240	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   56: ifeq +60 -> 116
    //   59: iconst_5
    //   60: anewarray 244	java/lang/String
    //   63: astore_2
    //   64: aload_2
    //   65: iconst_0
    //   66: aload_0
    //   67: getfield 96	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:processName	Ljava/lang/String;
    //   70: aastore
    //   71: aload_2
    //   72: iconst_1
    //   73: aload_0
    //   74: getfield 112	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:pId	I
    //   77: invokestatic 246	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   80: aastore
    //   81: aload_2
    //   82: iconst_2
    //   83: aload_0
    //   84: getfield 98	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:version	Ljava/lang/String;
    //   87: aastore
    //   88: aload_2
    //   89: iconst_3
    //   90: getstatic 194	com/tencent/qapmsdk/base/dbpersist/DBDataStatus:TO_SEND	Lcom/tencent/qapmsdk/base/dbpersist/DBDataStatus;
    //   93: invokevirtual 198	com/tencent/qapmsdk/base/dbpersist/DBDataStatus:getValue	()I
    //   96: invokestatic 246	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   99: aastore
    //   100: aload_2
    //   101: iconst_4
    //   102: invokestatic 204	java/lang/System:currentTimeMillis	()J
    //   105: ldc 247
    //   107: i2l
    //   108: lsub
    //   109: invokestatic 250	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   112: aastore
    //   113: goto +32 -> 145
    //   116: iconst_3
    //   117: anewarray 244	java/lang/String
    //   120: astore_2
    //   121: aload_2
    //   122: iconst_0
    //   123: aload_0
    //   124: getfield 96	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:processName	Ljava/lang/String;
    //   127: aastore
    //   128: aload_2
    //   129: iconst_1
    //   130: aload_0
    //   131: getfield 112	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:pId	I
    //   134: invokestatic 246	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   137: aastore
    //   138: aload_2
    //   139: iconst_2
    //   140: aload_0
    //   141: getfield 98	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:version	Ljava/lang/String;
    //   144: aastore
    //   145: aload_1
    //   146: ldc 72
    //   148: aconst_null
    //   149: aload_3
    //   150: aload_2
    //   151: aconst_null
    //   152: aconst_null
    //   153: aconst_null
    //   154: invokevirtual 254	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   157: astore_1
    //   158: aload_1
    //   159: ifnull +125 -> 284
    //   162: aload_1
    //   163: checkcast 256	java/io/Closeable
    //   166: astore_3
    //   167: aconst_null
    //   168: checkcast 227	java/lang/Throwable
    //   171: astore_2
    //   172: aload_2
    //   173: astore_1
    //   174: aload_3
    //   175: checkcast 125	android/database/Cursor
    //   178: astore 5
    //   180: aload_2
    //   181: astore_1
    //   182: aload 5
    //   184: invokeinterface 260 1 0
    //   189: pop
    //   190: aload_2
    //   191: astore_1
    //   192: aload 5
    //   194: invokeinterface 263 1 0
    //   199: ifne +41 -> 240
    //   202: aload_2
    //   203: astore_1
    //   204: aload_0
    //   205: aload 5
    //   207: invokespecial 265	com/tencent/qapmsdk/base/dbpersist/table/ResultObjectsTable:cursorToResultObject	(Landroid/database/Cursor;)Lcom/tencent/qapmsdk/base/reporter/uploaddata/data/ResultObject;
    //   210: astore 6
    //   212: aload 6
    //   214: ifnull +13 -> 227
    //   217: aload_2
    //   218: astore_1
    //   219: aload 4
    //   221: aload 6
    //   223: invokevirtual 269	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   226: pop
    //   227: aload_2
    //   228: astore_1
    //   229: aload 5
    //   231: invokeinterface 272 1 0
    //   236: pop
    //   237: goto -47 -> 190
    //   240: aload_2
    //   241: astore_1
    //   242: getstatic 278	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   245: astore 5
    //   247: aload_3
    //   248: aload_2
    //   249: invokestatic 284	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   252: aload 4
    //   254: areturn
    //   255: astore_2
    //   256: goto +8 -> 264
    //   259: astore_2
    //   260: aload_2
    //   261: astore_1
    //   262: aload_2
    //   263: athrow
    //   264: aload_3
    //   265: aload_1
    //   266: invokestatic 284	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   269: aload_2
    //   270: athrow
    //   271: astore_1
    //   272: getstatic 289	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   275: ldc 75
    //   277: aload_1
    //   278: checkcast 227	java/lang/Throwable
    //   281: invokevirtual 293	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   284: aload 4
    //   286: areturn
    //   287: ldc_w 295
    //   290: astore_3
    //   291: goto -248 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	ResultObjectsTable
    //   0	294	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	294	2	paramFunction0	Function0<? extends java.lang.Object>
    //   39	252	3	localObject1	java.lang.Object
    //   19	266	4	localArrayList	java.util.ArrayList
    //   178	68	5	localObject2	java.lang.Object
    //   210	12	6	localResultObject	ResultObject
    // Exception table:
    //   from	to	target	type
    //   174	180	255	finally
    //   182	190	255	finally
    //   192	202	255	finally
    //   204	212	255	finally
    //   219	227	255	finally
    //   229	237	255	finally
    //   242	247	255	finally
    //   262	264	255	finally
    //   174	180	259	java/lang/Throwable
    //   182	190	259	java/lang/Throwable
    //   192	202	259	java/lang/Throwable
    //   204	212	259	java/lang/Throwable
    //   219	227	259	java/lang/Throwable
    //   229	237	259	java/lang/Throwable
    //   242	247	259	java/lang/Throwable
    //   21	37	271	java/lang/Exception
    //   43	113	271	java/lang/Exception
    //   116	145	271	java/lang/Exception
    //   145	158	271	java/lang/Exception
    //   162	172	271	java/lang/Exception
    //   247	252	271	java/lang/Exception
    //   264	271	271	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.table.ResultObjectsTable
 * JD-Core Version:    0.7.0.1
 */