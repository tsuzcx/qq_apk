package com.tencent.qapmsdk.base.dbpersist.table;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.PluginCombination.Companion;
import com.tencent.qapmsdk.base.dbpersist.BaseTable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/table/ConfigsTable;", "Lcom/tencent/qapmsdk/base/dbpersist/BaseTable;", "pId", "", "version", "", "(ILjava/lang/String;)V", "()V", "insert", "dataBase", "Landroid/database/sqlite/SQLiteDatabase;", "block", "Lkotlin/Function0;", "search", "", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class ConfigsTable
  extends BaseTable
{
  private static final String COLUMN_EVENT_SAMPLE_RATIO = "event_sample_ratio";
  private static final String COLUMN_ID = "_id";
  private static final String COLUMN_MAX_REPORT_NUM = "max_report_num";
  private static final String COLUMN_PLUGIN = "plugin";
  private static final String COLUMN_PRODUCT_ID = "p_id";
  private static final String COLUMN_STACK_DEPTH = "stack_depth";
  private static final String COLUMN_THRESHOLD = "threshold";
  private static final String COLUMN_VERSION = "version";
  private static final String CREATE_CONFIGS = "CREATE TABLE configs (_id INTEGER PRIMARY KEY AUTOINCREMENT,p_id INT,version TEXT,plugin SMALLINT,threshold FLOAT,max_report_num INT,event_sample_ratio FLOAT,stack_depth INT);";
  public static final ConfigsTable.Companion Companion = new ConfigsTable.Companion(null);
  private static final String TABLE_CONFIGS = "configs";
  private static final String TAG = "QAPM_table_ConfigsTable";
  private int pId;
  private String version = "";
  
  static
  {
    new ConfigsTable();
  }
  
  public ConfigsTable()
  {
    super("configs", "CREATE TABLE configs (_id INTEGER PRIMARY KEY AUTOINCREMENT,p_id INT,version TEXT,plugin SMALLINT,threshold FLOAT,max_report_num INT,event_sample_ratio FLOAT,stack_depth INT);");
  }
  
  public ConfigsTable(int paramInt, @NotNull String paramString)
  {
    this();
    this.pId = paramInt;
    this.version = paramString;
  }
  
  public int insert(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<Integer> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "dataBase");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    paramSQLiteDatabase.delete("configs", null, null);
    paramSQLiteDatabase.beginTransaction();
    paramFunction0 = new ContentValues();
    PluginCombination.Companion.each((Function1)new ConfigsTable.insert.1(this, paramFunction0, paramSQLiteDatabase));
    paramSQLiteDatabase.setTransactionSuccessful();
    paramSQLiteDatabase.endTransaction();
    return 0;
  }
  
  /* Error */
  @org.jetbrains.annotations.Nullable
  public java.lang.Object search(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<? extends java.lang.Object> paramFunction0)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 103
    //   3: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_2
    //   7: ldc 104
    //   9: invokestatic 90	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: ldc 61
    //   15: aconst_null
    //   16: ldc 150
    //   18: iconst_2
    //   19: anewarray 152	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: aload_0
    //   25: getfield 92	com/tencent/qapmsdk/base/dbpersist/table/ConfigsTable:pId	I
    //   28: invokestatic 156	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   31: aastore
    //   32: dup
    //   33: iconst_1
    //   34: aload_0
    //   35: getfield 83	com/tencent/qapmsdk/base/dbpersist/table/ConfigsTable:version	Ljava/lang/String;
    //   38: aastore
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: invokevirtual 160	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_1
    //   46: aload_1
    //   47: ifnull +231 -> 278
    //   50: aload_1
    //   51: checkcast 162	java/io/Closeable
    //   54: astore 8
    //   56: aconst_null
    //   57: checkcast 148	java/lang/Throwable
    //   60: astore_2
    //   61: aload_2
    //   62: astore_1
    //   63: aload 8
    //   65: checkcast 164	android/database/Cursor
    //   68: astore 9
    //   70: aload_2
    //   71: astore_1
    //   72: aload 9
    //   74: invokeinterface 168 1 0
    //   79: ifle +154 -> 233
    //   82: aload_2
    //   83: astore_1
    //   84: aload 9
    //   86: invokeinterface 172 1 0
    //   91: pop
    //   92: aload_2
    //   93: astore_1
    //   94: aload 9
    //   96: invokeinterface 175 1 0
    //   101: ifne +132 -> 233
    //   104: aload_2
    //   105: astore_1
    //   106: aload 9
    //   108: aload 9
    //   110: ldc 43
    //   112: invokeinterface 179 2 0
    //   117: invokeinterface 183 2 0
    //   122: istore 4
    //   124: aload_2
    //   125: astore_1
    //   126: aload 9
    //   128: aload 9
    //   130: ldc 52
    //   132: invokeinterface 179 2 0
    //   137: invokeinterface 183 2 0
    //   142: istore 5
    //   144: aload_2
    //   145: astore_1
    //   146: aload 9
    //   148: aload 9
    //   150: ldc 40
    //   152: invokeinterface 179 2 0
    //   157: invokeinterface 183 2 0
    //   162: istore 6
    //   164: aload_2
    //   165: astore_1
    //   166: aload 9
    //   168: aload 9
    //   170: ldc 34
    //   172: invokeinterface 179 2 0
    //   177: invokeinterface 187 2 0
    //   182: fstore_3
    //   183: aload_2
    //   184: astore_1
    //   185: aload 9
    //   187: aload 9
    //   189: ldc 49
    //   191: invokeinterface 179 2 0
    //   196: invokeinterface 183 2 0
    //   201: istore 7
    //   203: aload_2
    //   204: astore_1
    //   205: getstatic 193	com/tencent/qapmsdk/base/monitorplugin/PluginController:INSTANCE	Lcom/tencent/qapmsdk/base/monitorplugin/PluginController;
    //   208: iload 4
    //   210: iload 5
    //   212: iload 6
    //   214: fload_3
    //   215: iload 7
    //   217: invokevirtual 197	com/tencent/qapmsdk/base/monitorplugin/PluginController:resetPlugin	(IIIFI)V
    //   220: aload_2
    //   221: astore_1
    //   222: aload 9
    //   224: invokeinterface 200 1 0
    //   229: pop
    //   230: goto -138 -> 92
    //   233: aload_2
    //   234: astore_1
    //   235: getstatic 205	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   238: astore 9
    //   240: aload 8
    //   242: aload_2
    //   243: invokestatic 211	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   246: aconst_null
    //   247: areturn
    //   248: astore_2
    //   249: goto +8 -> 257
    //   252: astore_2
    //   253: aload_2
    //   254: astore_1
    //   255: aload_2
    //   256: athrow
    //   257: aload 8
    //   259: aload_1
    //   260: invokestatic 211	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   263: aload_2
    //   264: athrow
    //   265: astore_1
    //   266: getstatic 216	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
    //   269: ldc 64
    //   271: aload_1
    //   272: checkcast 148	java/lang/Throwable
    //   275: invokevirtual 220	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   278: aconst_null
    //   279: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	this	ConfigsTable
    //   0	280	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	280	2	paramFunction0	Function0<? extends java.lang.Object>
    //   182	33	3	f	float
    //   122	87	4	i	int
    //   142	69	5	j	int
    //   162	51	6	k	int
    //   201	15	7	m	int
    //   54	204	8	localCloseable	java.io.Closeable
    //   68	171	9	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   63	70	248	finally
    //   72	82	248	finally
    //   84	92	248	finally
    //   94	104	248	finally
    //   106	124	248	finally
    //   126	144	248	finally
    //   146	164	248	finally
    //   166	183	248	finally
    //   185	203	248	finally
    //   205	220	248	finally
    //   222	230	248	finally
    //   235	240	248	finally
    //   255	257	248	finally
    //   63	70	252	java/lang/Throwable
    //   72	82	252	java/lang/Throwable
    //   84	92	252	java/lang/Throwable
    //   94	104	252	java/lang/Throwable
    //   106	124	252	java/lang/Throwable
    //   126	144	252	java/lang/Throwable
    //   146	164	252	java/lang/Throwable
    //   166	183	252	java/lang/Throwable
    //   185	203	252	java/lang/Throwable
    //   205	220	252	java/lang/Throwable
    //   222	230	252	java/lang/Throwable
    //   235	240	252	java/lang/Throwable
    //   12	46	265	java/lang/Exception
    //   50	61	265	java/lang/Exception
    //   240	246	265	java/lang/Exception
    //   257	265	265	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.table.ConfigsTable
 * JD-Core Version:    0.7.0.1
 */