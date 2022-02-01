package com.tencent.qapmsdk.common.sqlitedb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/sqlitedb/SqliteHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "dbName", "", "factory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "version", "", "(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public class SqliteHelper
  extends SQLiteOpenHelper
{
  public static final SqliteHelper.Companion Companion = new SqliteHelper.Companion(null);
  @NotNull
  private static final HashMap<String, String> tables = new HashMap();
  
  public SqliteHelper(@NotNull Context paramContext, @NotNull String paramString, @Nullable SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, paramCursorFactory, paramInt);
  }
  
  public void onCreate(@NotNull SQLiteDatabase paramSQLiteDatabase)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "db");
    Iterator localIterator = ((Map)tables).entrySet().iterator();
    while (localIterator.hasNext()) {
      paramSQLiteDatabase.execSQL((String)((Map.Entry)localIterator.next()).getValue());
    }
  }
  
  public void onUpgrade(@NotNull SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramSQLiteDatabase, "db");
    Iterator localIterator = ((Map)tables).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramSQLiteDatabase.execSQL("Drop table if exists " + (String)localEntry.getKey());
    }
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.common.sqlitedb.SqliteHelper
 * JD-Core Version:    0.7.0.1
 */