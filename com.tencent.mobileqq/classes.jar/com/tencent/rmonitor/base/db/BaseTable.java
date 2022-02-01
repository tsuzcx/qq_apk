package com.tencent.rmonitor.base.db;

import android.database.sqlite.SQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/db/BaseTable;", "", "tableName", "", "createTableSql", "(Ljava/lang/String;Ljava/lang/String;)V", "insert", "", "dataBase", "Landroid/database/sqlite/SQLiteDatabase;", "block", "Lkotlin/Function0;", "search", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public abstract class BaseTable
{
  public static final BaseTable.Companion a = new BaseTable.Companion(null);
  
  public BaseTable(@NotNull String paramString1, @NotNull String paramString2)
  {
    DBHelper.a.a(paramString1, paramString2);
  }
  
  public abstract int a(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<Integer> paramFunction0);
  
  @Nullable
  public abstract Object b(@NotNull SQLiteDatabase paramSQLiteDatabase, @NotNull Function0<? extends Object> paramFunction0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.db.BaseTable
 * JD-Core Version:    0.7.0.1
 */