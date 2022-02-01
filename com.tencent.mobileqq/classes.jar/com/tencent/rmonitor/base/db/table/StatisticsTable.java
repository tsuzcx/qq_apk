package com.tencent.rmonitor.base.db.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.rmonitor.base.db.BaseTable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/db/table/StatisticsTable;", "Lcom/tencent/rmonitor/base/db/BaseTable;", "pId", "", "plugin", "", "returnCode", "errorCode", "category", "zoneDate", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "(Ljava/lang/String;)V", "()V", "insert", "dataBase", "Landroid/database/sqlite/SQLiteDatabase;", "block", "Lkotlin/Function0;", "search", "", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class StatisticsTable
  extends BaseTable
{
  public static final StatisticsTable.Companion b = new StatisticsTable.Companion(null);
  private String c = "";
  private int d;
  private String e = "";
  private String f = "";
  private String g = "";
  private String h = "";
  
  static
  {
    new StatisticsTable();
  }
  
  public StatisticsTable()
  {
    super("error_statistics", "CREATE TABLE error_statistics (_id INTEGER PRIMARY KEY AUTOINCREMENT,p_id TEXT,plugin SMALLINT,statue_code INT,error_code INT,category TEXT,zone_date TEXT);");
  }
  
  public StatisticsTable(@NotNull String paramString)
  {
    this();
    this.c = paramString;
  }
  
  public StatisticsTable(@NotNull String paramString1, int paramInt, @NotNull String paramString2, @NotNull String paramString3, @NotNull String paramString4, @NotNull String paramString5)
  {
    this();
    this.c = paramString1;
    this.d = paramInt;
    this.e = paramString2;
    this.f = paramString3;
    this.g = paramString4;
    this.h = paramString5;
  }
  
  public int a(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<Integer> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "dataBase");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramFunction0 = new ContentValues();
    paramFunction0.put("p_id", this.c);
    paramFunction0.put("plugin", Integer.valueOf(this.d));
    paramFunction0.put("statue_code", this.e);
    paramFunction0.put("error_code", this.f);
    paramFunction0.put("category", this.g);
    paramFunction0.put("zone_date", this.h);
    return (int)paramSQLiteDatabase.insert("error_statistics", "name", paramFunction0);
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public java.lang.Object b(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<? extends java.lang.Object> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 93
    //   3: invokestatic 83	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 94
    //   9: invokestatic 83	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: new 135	org/json/JSONObject
    //   15: dup
    //   16: invokespecial 136	org/json/JSONObject:<init>	()V
    //   19: astore 4
    //   21: new 138	org/json/JSONArray
    //   24: dup
    //   25: invokespecial 139	org/json/JSONArray:<init>	()V
    //   28: astore 6
    //   30: aload_1
    //   31: ldc 59
    //   33: aconst_null
    //   34: ldc 141
    //   36: iconst_1
    //   37: anewarray 143	java/lang/String
    //   40: dup
    //   41: iconst_0
    //   42: aload_0
    //   43: getfield 67	com/tencent/rmonitor/base/db/table/StatisticsTable:c	Ljava/lang/String;
    //   46: invokevirtual 147	java/lang/String:toString	()Ljava/lang/String;
    //   49: aastore
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: invokevirtual 151	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   56: astore_1
    //   57: aload_1
    //   58: ifnull +344 -> 402
    //   61: aload_1
    //   62: checkcast 153	java/io/Closeable
    //   65: astore 5
    //   67: aconst_null
    //   68: checkcast 133	java/lang/Throwable
    //   71: astore_2
    //   72: aload_2
    //   73: astore_1
    //   74: aload 5
    //   76: checkcast 155	android/database/Cursor
    //   79: astore 7
    //   81: aload_2
    //   82: astore_1
    //   83: aload 7
    //   85: invokeinterface 159 1 0
    //   90: pop
    //   91: aload_2
    //   92: astore_1
    //   93: aload 7
    //   95: invokeinterface 162 1 0
    //   100: ifne +234 -> 334
    //   103: aload_2
    //   104: astore_1
    //   105: aload 7
    //   107: aload 7
    //   109: ldc 99
    //   111: invokeinterface 166 2 0
    //   116: invokeinterface 170 2 0
    //   121: astore 8
    //   123: aload_2
    //   124: astore_1
    //   125: aload_0
    //   126: getfield 67	com/tencent/rmonitor/base/db/table/StatisticsTable:c	Ljava/lang/String;
    //   129: aload 8
    //   131: invokestatic 174	kotlin/jvm/internal/Intrinsics:areEqual	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   134: iconst_1
    //   135: ixor
    //   136: ifeq +6 -> 142
    //   139: goto -48 -> 91
    //   142: aload_2
    //   143: astore_1
    //   144: aload 7
    //   146: aload 7
    //   148: ldc 103
    //   150: invokeinterface 166 2 0
    //   155: invokeinterface 178 2 0
    //   160: istore_3
    //   161: aload_2
    //   162: astore_1
    //   163: aload 7
    //   165: aload 7
    //   167: ldc 114
    //   169: invokeinterface 166 2 0
    //   174: invokeinterface 170 2 0
    //   179: astore 8
    //   181: aload_2
    //   182: astore_1
    //   183: aload 7
    //   185: aload 7
    //   187: ldc 116
    //   189: invokeinterface 166 2 0
    //   194: invokeinterface 170 2 0
    //   199: astore 9
    //   201: aload_2
    //   202: astore_1
    //   203: aload 7
    //   205: aload 7
    //   207: ldc 87
    //   209: invokeinterface 166 2 0
    //   214: invokeinterface 170 2 0
    //   219: astore 10
    //   221: aload_2
    //   222: astore_1
    //   223: aload 7
    //   225: aload 7
    //   227: ldc 118
    //   229: invokeinterface 166 2 0
    //   234: invokeinterface 170 2 0
    //   239: astore 11
    //   241: aload_2
    //   242: astore_1
    //   243: new 135	org/json/JSONObject
    //   246: dup
    //   247: invokespecial 136	org/json/JSONObject:<init>	()V
    //   250: astore 12
    //   252: aload_2
    //   253: astore_1
    //   254: aload 12
    //   256: ldc 103
    //   258: iload_3
    //   259: invokevirtual 181	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   262: pop
    //   263: aload_2
    //   264: astore_1
    //   265: aload 12
    //   267: ldc 183
    //   269: aload 8
    //   271: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   274: pop
    //   275: aload_2
    //   276: astore_1
    //   277: aload 12
    //   279: ldc 116
    //   281: aload 9
    //   283: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   286: pop
    //   287: aload_2
    //   288: astore_1
    //   289: aload 12
    //   291: ldc 87
    //   293: aload 10
    //   295: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   298: pop
    //   299: aload_2
    //   300: astore_1
    //   301: aload 12
    //   303: ldc 188
    //   305: aload 11
    //   307: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   310: pop
    //   311: aload_2
    //   312: astore_1
    //   313: aload 6
    //   315: aload 12
    //   317: invokevirtual 191	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   320: pop
    //   321: aload_2
    //   322: astore_1
    //   323: aload 7
    //   325: invokeinterface 194 1 0
    //   330: pop
    //   331: goto -240 -> 91
    //   334: aload_2
    //   335: astore_1
    //   336: aload 6
    //   338: invokevirtual 198	org/json/JSONArray:length	()I
    //   341: ifle +15 -> 356
    //   344: aload_2
    //   345: astore_1
    //   346: aload 4
    //   348: ldc 200
    //   350: aload 6
    //   352: invokevirtual 186	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   355: pop
    //   356: aload_2
    //   357: astore_1
    //   358: getstatic 206	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   361: astore 6
    //   363: aload 5
    //   365: aload_2
    //   366: invokestatic 212	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   369: aload 4
    //   371: areturn
    //   372: astore_2
    //   373: goto +8 -> 381
    //   376: astore_2
    //   377: aload_2
    //   378: astore_1
    //   379: aload_2
    //   380: athrow
    //   381: aload 5
    //   383: aload_1
    //   384: invokestatic 212	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   387: aload_2
    //   388: athrow
    //   389: astore_1
    //   390: getstatic 217	com/tencent/rmonitor/common/logger/Logger:b	Lcom/tencent/rmonitor/common/logger/Logger;
    //   393: ldc 219
    //   395: aload_1
    //   396: checkcast 133	java/lang/Throwable
    //   399: invokevirtual 222	com/tencent/rmonitor/common/logger/Logger:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   402: aload 4
    //   404: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	this	StatisticsTable
    //   0	405	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	405	2	paramFunction0	Function0<? extends java.lang.Object>
    //   160	99	3	i	int
    //   19	384	4	localJSONObject1	org.json.JSONObject
    //   65	317	5	localCloseable	java.io.Closeable
    //   28	334	6	localObject	java.lang.Object
    //   79	245	7	localCursor	android.database.Cursor
    //   121	149	8	str1	String
    //   199	83	9	str2	String
    //   219	75	10	str3	String
    //   239	67	11	str4	String
    //   250	66	12	localJSONObject2	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   74	81	372	finally
    //   83	91	372	finally
    //   93	103	372	finally
    //   105	123	372	finally
    //   125	139	372	finally
    //   144	161	372	finally
    //   163	181	372	finally
    //   183	201	372	finally
    //   203	221	372	finally
    //   223	241	372	finally
    //   243	252	372	finally
    //   254	263	372	finally
    //   265	275	372	finally
    //   277	287	372	finally
    //   289	299	372	finally
    //   301	311	372	finally
    //   313	321	372	finally
    //   323	331	372	finally
    //   336	344	372	finally
    //   346	356	372	finally
    //   358	363	372	finally
    //   379	381	372	finally
    //   74	81	376	java/lang/Throwable
    //   83	91	376	java/lang/Throwable
    //   93	103	376	java/lang/Throwable
    //   105	123	376	java/lang/Throwable
    //   125	139	376	java/lang/Throwable
    //   144	161	376	java/lang/Throwable
    //   163	181	376	java/lang/Throwable
    //   183	201	376	java/lang/Throwable
    //   203	221	376	java/lang/Throwable
    //   223	241	376	java/lang/Throwable
    //   243	252	376	java/lang/Throwable
    //   254	263	376	java/lang/Throwable
    //   265	275	376	java/lang/Throwable
    //   277	287	376	java/lang/Throwable
    //   289	299	376	java/lang/Throwable
    //   301	311	376	java/lang/Throwable
    //   313	321	376	java/lang/Throwable
    //   323	331	376	java/lang/Throwable
    //   336	344	376	java/lang/Throwable
    //   346	356	376	java/lang/Throwable
    //   358	363	376	java/lang/Throwable
    //   30	57	389	java/lang/Exception
    //   61	72	389	java/lang/Exception
    //   363	369	389	java/lang/Exception
    //   381	389	389	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.db.table.StatisticsTable
 * JD-Core Version:    0.7.0.1
 */