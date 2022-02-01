package com.tencent.rmonitor.base.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.tencent.rmonitor.base.db.table.DropFrameTable;
import com.tencent.rmonitor.base.db.table.ReportDataTable;
import com.tencent.rmonitor.base.db.table.StatisticsTable;
import com.tencent.rmonitor.common.logger.Logger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/db/DBHandler;", "", "()V", "database", "Landroid/database/sqlite/SQLiteDatabase;", "dbHelper", "Lcom/tencent/rmonitor/base/db/DBHelper;", "getDbHelper", "()Lcom/tencent/rmonitor/base/db/DBHelper;", "setDbHelper", "(Lcom/tencent/rmonitor/base/db/DBHelper;)V", "close", "", "delete", "", "table", "", "whereClause", "whereArgs", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I", "deleteAllSentOrOverTime", "overTime", "", "insert", "Lcom/tencent/rmonitor/base/db/BaseTable;", "block", "Lkotlin/Function0;", "open", "search", "sql", "sqlSearch", "updateStatus", "id", "", "status", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DBHandler
{
  public static final DBHandler.Companion a = new DBHandler.Companion(null);
  private static final ArrayList<Object> d = CollectionsKt.arrayListOf(new Object[] { DropFrameTable.b, ReportDataTable.b, StatisticsTable.b });
  private static volatile DBHandler e;
  private SQLiteDatabase b;
  @Nullable
  private DBHelper c;
  
  public final int a(@NotNull BaseTable paramBaseTable, @NotNull Function0<Integer> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTable, "table");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    SQLiteDatabase localSQLiteDatabase = a(this);
    int j = -2;
    int i = j;
    if (localSQLiteDatabase != null)
    {
      localSQLiteDatabase = a(this);
      if ((localSQLiteDatabase != null) && (!localSQLiteDatabase.isOpen())) {
        return -2;
      }
      try
      {
        localSQLiteDatabase = this.b;
        i = j;
        if (localSQLiteDatabase != null)
        {
          i = paramBaseTable.a(localSQLiteDatabase, paramFunction0);
          return i;
        }
      }
      catch (Exception paramBaseTable)
      {
        Logger.b.a("RMonitor_db_persist_DBHandler", (Throwable)paramBaseTable);
        i = -1;
      }
    }
    return i;
  }
  
  public final int a(@NotNull String paramString, long paramLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "table");
    if (a(this) != null)
    {
      Object localObject = a(this);
      if ((localObject == null) || (((SQLiteDatabase)localObject).isOpen())) {
        try
        {
          if ((paramInt != DBDataStatus.TO_SEND.getValue()) && (paramInt != DBDataStatus.SENT.getValue())) {
            return -1;
          }
          localObject = new ContentValues();
          ((ContentValues)localObject).put("status", Integer.valueOf(paramInt));
          SQLiteDatabase localSQLiteDatabase = this.b;
          if (localSQLiteDatabase != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("_id=");
            localStringBuilder.append(paramLong);
            paramInt = localSQLiteDatabase.update(paramString, (ContentValues)localObject, localStringBuilder.toString(), null);
            return paramInt;
          }
          return 0;
        }
        catch (Exception paramString)
        {
          Logger.b.a("RMonitor_db_persist_DBHandler", (Throwable)paramString);
          return -1;
        }
      }
    }
    return -2;
  }
  
  public final int a(@NotNull String paramString1, @Nullable String paramString2, @Nullable String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "table");
    if (a(this) != null)
    {
      SQLiteDatabase localSQLiteDatabase = a(this);
      if ((localSQLiteDatabase == null) || (localSQLiteDatabase.isOpen())) {
        try
        {
          localSQLiteDatabase = this.b;
          if (localSQLiteDatabase != null)
          {
            int i = localSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
            return i;
          }
          return 0;
        }
        catch (Exception paramString1)
        {
          Logger.b.a("RMonitor_db_persist_DBHandler", (Throwable)paramString1);
          return -1;
        }
      }
    }
    return -2;
  }
  
  public final int a(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "table");
    if (paramBoolean) {
      return a(paramString, "status=? OR occur_time<?", new String[] { String.valueOf(DBDataStatus.SENT.getValue()), String.valueOf(System.currentTimeMillis() - 259200000) });
    }
    return a(paramString, "status=?", new String[] { String.valueOf(DBDataStatus.SENT.getValue()) });
  }
  
  public final void a()
  {
    Object localObject1 = this.b;
    if ((localObject1 == null) || ((localObject1 != null) && (!((SQLiteDatabase)localObject1).isOpen()))) {}
    for (;;)
    {
      try
      {
        localObject1 = this.c;
        if (localObject1 == null) {
          break label57;
        }
        localObject1 = ((DBHelper)localObject1).getWritableDatabase();
        this.b = ((SQLiteDatabase)localObject1);
        return;
      }
      catch (SQLiteException localSQLiteException)
      {
        Logger.b.a("RMonitor_db_persist_DBHandler", (Throwable)localSQLiteException);
      }
      return;
      label57:
      Object localObject2 = null;
    }
  }
  
  public final void a(@Nullable DBHelper paramDBHelper)
  {
    this.c = paramDBHelper;
  }
  
  @Nullable
  public final Object b(@NotNull BaseTable paramBaseTable, @NotNull Function0<? extends Object> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTable, "table");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    if (a(this) != null)
    {
      SQLiteDatabase localSQLiteDatabase = a(this);
      if ((localSQLiteDatabase != null) && (!localSQLiteDatabase.isOpen())) {
        return null;
      }
      try
      {
        localSQLiteDatabase = this.b;
        if (localSQLiteDatabase != null)
        {
          paramBaseTable = paramBaseTable.b(localSQLiteDatabase, paramFunction0);
          return paramBaseTable;
        }
      }
      catch (Exception paramBaseTable)
      {
        Logger.b.a("RMonitor_db_persist_DBHandler", (Throwable)paramBaseTable);
      }
    }
    return null;
  }
  
  public final void b()
  {
    SQLiteDatabase localSQLiteDatabase = this.b;
    if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen()))
    {
      localSQLiteDatabase.close();
      e = (DBHandler)null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.db.DBHandler
 * JD-Core Version:    0.7.0.1
 */