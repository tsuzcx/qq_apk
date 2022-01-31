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
    //   58: ifnull +293 -> 351
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
    //   100: ifne +254 -> 354
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
    //   129: if_icmpne -38 -> 91
    //   132: aload_2
    //   133: astore_1
    //   134: aload 7
    //   136: aload 7
    //   138: ldc 46
    //   140: invokeinterface 170 2 0
    //   145: invokeinterface 174 2 0
    //   150: istore_3
    //   151: aload_2
    //   152: astore_1
    //   153: aload 7
    //   155: aload 7
    //   157: ldc 52
    //   159: invokeinterface 170 2 0
    //   164: invokeinterface 177 2 0
    //   169: astore 8
    //   171: aload_2
    //   172: astore_1
    //   173: aload 7
    //   175: aload 7
    //   177: ldc 41
    //   179: invokeinterface 170 2 0
    //   184: invokeinterface 177 2 0
    //   189: astore 9
    //   191: aload_2
    //   192: astore_1
    //   193: aload 7
    //   195: aload 7
    //   197: ldc 38
    //   199: invokeinterface 170 2 0
    //   204: invokeinterface 177 2 0
    //   209: astore 10
    //   211: aload_2
    //   212: astore_1
    //   213: aload 7
    //   215: aload 7
    //   217: ldc 55
    //   219: invokeinterface 170 2 0
    //   224: invokeinterface 177 2 0
    //   229: astore 11
    //   231: aload_2
    //   232: astore_1
    //   233: new 140	org/json/JSONObject
    //   236: dup
    //   237: invokespecial 141	org/json/JSONObject:<init>	()V
    //   240: astore 12
    //   242: aload_2
    //   243: astore_1
    //   244: aload 12
    //   246: ldc 46
    //   248: iload_3
    //   249: invokevirtual 180	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   252: pop
    //   253: aload_2
    //   254: astore_1
    //   255: aload 12
    //   257: ldc 182
    //   259: aload 8
    //   261: invokevirtual 185	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   264: pop
    //   265: aload_2
    //   266: astore_1
    //   267: aload 12
    //   269: ldc 41
    //   271: aload 9
    //   273: invokevirtual 185	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   276: pop
    //   277: aload_2
    //   278: astore_1
    //   279: aload 12
    //   281: ldc 38
    //   283: aload 10
    //   285: invokevirtual 185	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   288: pop
    //   289: aload_2
    //   290: astore_1
    //   291: aload 12
    //   293: ldc 187
    //   295: aload 11
    //   297: invokevirtual 185	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   300: pop
    //   301: aload_2
    //   302: astore_1
    //   303: aload 6
    //   305: aload 12
    //   307: invokevirtual 190	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   310: pop
    //   311: aload_2
    //   312: astore_1
    //   313: aload 7
    //   315: invokeinterface 193 1 0
    //   320: pop
    //   321: goto -230 -> 91
    //   324: astore_2
    //   325: aload_2
    //   326: astore_1
    //   327: aload_2
    //   328: athrow
    //   329: astore_2
    //   330: aload 5
    //   332: aload_1
    //   333: invokestatic 199	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   336: aload_2
    //   337: athrow
    //   338: astore_1
    //   339: getstatic 205	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   342: ldc 65
    //   344: aload_1
    //   345: checkcast 138	java/lang/Throwable
    //   348: invokevirtual 209	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   351: aload 4
    //   353: areturn
    //   354: aload_2
    //   355: astore_1
    //   356: aload 6
    //   358: invokevirtual 213	org/json/JSONArray:length	()I
    //   361: ifle +15 -> 376
    //   364: aload_2
    //   365: astore_1
    //   366: aload 4
    //   368: ldc 215
    //   370: aload 6
    //   372: invokevirtual 185	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   375: pop
    //   376: aload_2
    //   377: astore_1
    //   378: getstatic 220	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   381: astore 6
    //   383: aload 5
    //   385: aload_2
    //   386: invokestatic 199	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   389: aload 4
    //   391: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	392	0	this	StatisticsTable
    //   0	392	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	392	2	paramFunction0	Function0<? extends java.lang.Object>
    //   121	128	3	i	int
    //   19	371	4	localJSONObject1	org.json.JSONObject
    //   65	319	5	localCloseable	java.io.Closeable
    //   28	354	6	localObject	java.lang.Object
    //   79	235	7	localCursor	android.database.Cursor
    //   169	91	8	str1	String
    //   189	83	9	str2	String
    //   209	75	10	str3	String
    //   229	67	11	str4	String
    //   240	66	12	localJSONObject2	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   74	81	324	java/lang/Throwable
    //   83	91	324	java/lang/Throwable
    //   93	103	324	java/lang/Throwable
    //   105	122	324	java/lang/Throwable
    //   124	132	324	java/lang/Throwable
    //   134	151	324	java/lang/Throwable
    //   153	171	324	java/lang/Throwable
    //   173	191	324	java/lang/Throwable
    //   193	211	324	java/lang/Throwable
    //   213	231	324	java/lang/Throwable
    //   233	242	324	java/lang/Throwable
    //   244	253	324	java/lang/Throwable
    //   255	265	324	java/lang/Throwable
    //   267	277	324	java/lang/Throwable
    //   279	289	324	java/lang/Throwable
    //   291	301	324	java/lang/Throwable
    //   303	311	324	java/lang/Throwable
    //   313	321	324	java/lang/Throwable
    //   356	364	324	java/lang/Throwable
    //   366	376	324	java/lang/Throwable
    //   378	383	324	java/lang/Throwable
    //   74	81	329	finally
    //   83	91	329	finally
    //   93	103	329	finally
    //   105	122	329	finally
    //   124	132	329	finally
    //   134	151	329	finally
    //   153	171	329	finally
    //   173	191	329	finally
    //   193	211	329	finally
    //   213	231	329	finally
    //   233	242	329	finally
    //   244	253	329	finally
    //   255	265	329	finally
    //   267	277	329	finally
    //   279	289	329	finally
    //   291	301	329	finally
    //   303	311	329	finally
    //   313	321	329	finally
    //   327	329	329	finally
    //   356	364	329	finally
    //   366	376	329	finally
    //   378	383	329	finally
    //   30	57	338	java/lang/Exception
    //   61	72	338	java/lang/Exception
    //   330	338	338	java/lang/Exception
    //   383	389	338	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.table.StatisticsTable
 * JD-Core Version:    0.7.0.1
 */