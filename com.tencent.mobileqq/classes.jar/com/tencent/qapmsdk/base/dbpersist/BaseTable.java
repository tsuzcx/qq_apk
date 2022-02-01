package com.tencent.qapmsdk.base.dbpersist;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/BaseTable;", "", "tableName", "", "createTableSql", "(Ljava/lang/String;Ljava/lang/String;)V", "insert", "", "dataBase", "Landroid/database/sqlite/SQLiteDatabase;", "block", "Lkotlin/Function0;", "search", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract class BaseTable
{
  public static final BaseTable.Companion Companion = new BaseTable.Companion(null);
  public static final int DATA_OVER_TIME = 259200000;
  
  public BaseTable(@NotNull String paramString1, @NotNull String paramString2)
  {
    DBHelper.Companion.registerTable(paramString1, paramString2);
  }
  
  public abstract int insert(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<Integer> paramFunction0);
  
  @Nullable
  public abstract Object search(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<? extends Object> paramFunction0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.BaseTable
 * JD-Core Version:    0.7.0.1
 */