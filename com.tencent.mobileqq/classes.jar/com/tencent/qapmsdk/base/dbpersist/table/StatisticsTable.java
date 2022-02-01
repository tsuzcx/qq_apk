package com.tencent.qapmsdk.base.dbpersist.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.qapmsdk.base.dbpersist.BaseTable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/table/StatisticsTable;", "Lcom/tencent/qapmsdk/base/dbpersist/BaseTable;", "pId", "", "plugin", "returnCode", "", "errorCode", "category", "zoneDate", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(I)V", "()V", "insert", "dataBase", "Landroid/database/sqlite/SQLiteDatabase;", "block", "Lkotlin/Function0;", "search", "", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class StatisticsTable
  extends BaseTable
{
  private static final String COLUMN_CATEGORY = "category";
  private static final String COLUMN_ERROR_CODE = "error_code";
  private static final String COLUMN_ID = "_id";
  private static final String COLUMN_PLUGIN = "plugin";
  private static final String COLUMN_PRODUCT_ID = "p_id";
  private static final String COLUMN_STATUE_CODE = "statue_code";
  private static final String COLUMN_ZONE_DATE = "zone_date";
  private static final String CREATE_ERROR_STATISTICS = "CREATE TABLE error_statistics (_id INTEGER PRIMARY KEY AUTOINCREMENT,p_id INT,plugin SMALLINT,statue_code INT,error_code INT,category TEXT,zone_date TEXT);";
  public static final StatisticsTable.Companion Companion = new StatisticsTable.Companion(null);
  private static final String TABLE_ERROR_STATISTICS = "error_statistics";
  private static final String TAG = "QAPM_table_DropFrameTable";
  private String category = "";
  private String errorCode = "";
  private int pId;
  private int plugin;
  private String returnCode = "";
  private String zoneDate = "";
  
  static
  {
    new StatisticsTable();
  }
  
  public StatisticsTable()
  {
    super("error_statistics", "CREATE TABLE error_statistics (_id INTEGER PRIMARY KEY AUTOINCREMENT,p_id INT,plugin SMALLINT,statue_code INT,error_code INT,category TEXT,zone_date TEXT);");
  }
  
  public StatisticsTable(int paramInt)
  {
    this();
    this.pId = paramInt;
  }
  
  public StatisticsTable(int paramInt1, int paramInt2, @NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4)
  {
    this();
    this.pId = paramInt1;
    this.plugin = paramInt2;
    this.returnCode = paramString1;
    this.errorCode = paramString2;
    this.category = paramString3;
    this.zoneDate = paramString4;
  }
  
  public int insert(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<Integer> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "dataBase");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramFunction0 = new ContentValues();
    paramFunction0.put("p_id", Integer.valueOf(this.pId));
    paramFunction0.put("plugin", Integer.valueOf(this.plugin));
    paramFunction0.put("statue_code", this.returnCode);
    paramFunction0.put("error_code", this.errorCode);
    paramFunction0.put("category", this.category);
    paramFunction0.put("zone_date", this.zoneDate);
    return (int)paramSQLiteDatabase.insert("error_statistics", "name", paramFunction0);
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public java.lang.Object search(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<? extends java.lang.Object> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 107
    //   3: invokestatic 100	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 108
    //   9: invokestatic 100	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: new 140	org/json/JSONObject
    //   15: dup
    //   16: invokespecial 141	org/json/JSONObject:<init>	()V
    //   19: astore 4
    //   21: new 143	org/json/JSONArray
    //   24: dup
    //   25: invokespecial 144	org/json/JSONArray:<init>	()V
    //   28: astore 6
    //   30: aload_1
    //   31: ldc 62
    //   33: aconst_null
    //   34: ldc 146
    //   36: iconst_1
    //   37: anewarray 148	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: getfield 92	com/tencent/qapmsdk/base/dbpersist/table/StatisticsTable:pId	I
    //   46: invokestatic 151	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: invokevirtual 155	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull +337 -> 395
    //   61: aload_1
    //   62: checkcast 157	java/io/Closeable
    //   65: astore 5
    //   67: aconst_null
    //   68: checkcast 138	java/lang/Throwable
    //   71: astore_2
    //   72: aload_2
    //   73: astore_1
    //   74: aload 5
    //   76: checkcast 159	android/database/Cursor
    //   79: astore 7
    //   81: aload_2
    //   82: astore_1
    //   83: aload 7
    //   85: invokeinterface 163 1 0
    //   90: pop
    //   91: aload_2
    //   92: astore_1
    //   93: aload 7
    //   95: invokeinterface 166 1 0
    //   100: ifne +227 -> 327
    //   103: aload_2
    //   104: astore_1
    //   105: aload 7
    //   107: aload 7
    //   109: ldc 49
    //   111: invokeinterface 170 2 0
    //   116: invokeinterface 174 2 0
    //   121: istore_3
    //   122: aload_2
    //   123: astore_1
    //   124: aload_0
    //   125: getfield 92	com/tencent/qapmsdk/base/dbpersist/table/StatisticsTable:pId	I
    //   128: iload_3
    //   129: if_icmpeq +6 -> 135
    //   132: goto -41 -> 91
    //   135: aload_2
    //   136: astore_1
    //   137: aload 7
    //   139: aload 7
    //   141: ldc 46
    //   143: invokeinterface 170 2 0
    //   148: invokeinterface 174 2 0
    //   153: istore_3
    //   154: aload_2
    //   155: astore_1
    //   156: aload 7
    //   158: aload 7
    //   160: ldc 52
    //   162: invokeinterface 170 2 0
    //   167: invokeinterface 177 2 0
    //   172: astore 8
    //   174: aload_2
    //   175: astore_1
    //   176: aload 7
    //   178: aload 7
    //   180: ldc 41
    //   182: invokeinterface 170 2 0
    //   187: invokeinterface 177 2 0
    //   192: astore 9
    //   194: aload_2
    //   195: astore_1
    //   196: aload 7
    //   198: aload 7
    //   200: ldc 38
    //   202: invokeinterface 170 2 0
    //   207: invokeinterface 177 2 0
    //   212: astore 10
    //   214: aload_2
    //   215: astore_1
    //   216: aload 7
    //   218: aload 7
    //   220: ldc 55
    //   222: invokeinterface 170 2 0
    //   227: invokeinterface 177 2 0
    //   232: astore 11
    //   234: aload_2
    //   235: astore_1
    //   236: new 140	org/json/JSONObject
    //   239: dup
    //   240: invokespecial 141	org/json/JSONObject:<init>	()V
    //   243: astore 12
    //   245: aload_2
    //   246: astore_1
    //   247: aload 12
    //   249: ldc 46
    //   251: iload_3
    //   252: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   255: pop
    //   256: aload_2
    //   257: astore_1
    //   258: aload 12
    //   260: ldc 182
    //   262: aload 8
    //   264: invokevirtual 185	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   267: pop
    //   268: aload_2
    //   269: astore_1
    //   270: aload 12
    //   272: ldc 41
    //   274: aload 9
    //   276: invokevirtual 185	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: pop
    //   280: aload_2
    //   281: astore_1
    //   282: aload 12
    //   284: ldc 38
    //   286: aload 10
    //   288: invokevirtual 185	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   291: pop
    //   292: aload_2
    //   293: astore_1
    //   294: aload 12
    //   296: ldc 187
    //   298: aload 11
    //   300: invokevirtual 185	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   303: pop
    //   304: aload_2
    //   305: astore_1
    //   306: aload 6
    //   308: aload 12
    //   310: invokevirtual 190	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   313: pop
    //   314: aload_2
    //   315: astore_1
    //   316: aload 7
    //   318: invokeinterface 193 1 0
    //   323: pop
    //   324: goto -233 -> 91
    //   327: aload_2
    //   328: astore_1
    //   329: aload 6
    //   331: invokevirtual 197	org/json/JSONArray:length	()I
    //   334: ifle +15 -> 349
    //   337: aload_2
    //   338: astore_1
    //   339: aload 4
    //   341: ldc 199
    //   343: aload 6
    //   345: invokevirtual 185	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   348: pop
    //   349: aload_2
    //   350: astore_1
    //   351: getstatic 205	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   354: astore 6
    //   356: aload 5
    //   358: aload_2
    //   359: invokestatic 211	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   362: aload 4
    //   364: areturn
    //   365: astore_2
    //   366: goto +8 -> 374
    //   369: astore_2
    //   370: aload_2
    //   371: astore_1
    //   372: aload_2
    //   373: athrow
    //   374: aload 5
    //   376: aload_1
    //   377: invokestatic 211	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   380: aload_2
    //   381: athrow
    //   382: astore_1
    //   383: getstatic 216	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   386: ldc 65
    //   388: aload_1
    //   389: checkcast 138	java/lang/Throwable
    //   392: invokevirtual 220	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   395: aload 4
    //   397: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	398	0	this	StatisticsTable
    //   0	398	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	398	2	paramFunction0	Function0<? extends java.lang.Object>
    //   121	131	3	i	int
    //   19	377	4	localJSONObject1	org.json.JSONObject
    //   65	310	5	localCloseable	java.io.Closeable
    //   28	327	6	localObject	java.lang.Object
    //   79	238	7	localCursor	android.database.Cursor
    //   172	91	8	str1	String
    //   192	83	9	str2	String
    //   212	75	10	str3	String
    //   232	67	11	str4	String
    //   243	66	12	localJSONObject2	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   74	81	365	finally
    //   83	91	365	finally
    //   93	103	365	finally
    //   105	122	365	finally
    //   124	132	365	finally
    //   137	154	365	finally
    //   156	174	365	finally
    //   176	194	365	finally
    //   196	214	365	finally
    //   216	234	365	finally
    //   236	245	365	finally
    //   247	256	365	finally
    //   258	268	365	finally
    //   270	280	365	finally
    //   282	292	365	finally
    //   294	304	365	finally
    //   306	314	365	finally
    //   316	324	365	finally
    //   329	337	365	finally
    //   339	349	365	finally
    //   351	356	365	finally
    //   372	374	365	finally
    //   74	81	369	java/lang/Throwable
    //   83	91	369	java/lang/Throwable
    //   93	103	369	java/lang/Throwable
    //   105	122	369	java/lang/Throwable
    //   124	132	369	java/lang/Throwable
    //   137	154	369	java/lang/Throwable
    //   156	174	369	java/lang/Throwable
    //   176	194	369	java/lang/Throwable
    //   196	214	369	java/lang/Throwable
    //   216	234	369	java/lang/Throwable
    //   236	245	369	java/lang/Throwable
    //   247	256	369	java/lang/Throwable
    //   258	268	369	java/lang/Throwable
    //   270	280	369	java/lang/Throwable
    //   282	292	369	java/lang/Throwable
    //   294	304	369	java/lang/Throwable
    //   306	314	369	java/lang/Throwable
    //   316	324	369	java/lang/Throwable
    //   329	337	369	java/lang/Throwable
    //   339	349	369	java/lang/Throwable
    //   351	356	369	java/lang/Throwable
    //   30	57	382	java/lang/Exception
    //   61	72	382	java/lang/Exception
    //   356	362	382	java/lang/Exception
    //   374	382	382	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.table.StatisticsTable
 * JD-Core Version:    0.7.0.1
 */