package com.tencent.qapmsdk.base.dbpersist;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.tencent.qapmsdk.base.dbpersist.table.ConfigsTable;
import com.tencent.qapmsdk.base.dbpersist.table.DropFrameTable;
import com.tencent.qapmsdk.base.dbpersist.table.ResultObjectsTable;
import com.tencent.qapmsdk.base.dbpersist.table.StatisticsTable;
import com.tencent.qapmsdk.base.dbpersist.table.UploadErrorsTable;
import com.tencent.qapmsdk.common.logger.Logger;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;", "", "()V", "database", "Landroid/database/sqlite/SQLiteDatabase;", "dbHelper", "Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;", "getDbHelper", "()Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;", "setDbHelper", "(Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;)V", "close", "", "delete", "", "table", "", "whereClause", "whereArgs", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I", "deleteAllSentOrOverTime", "overTime", "", "insert", "Lcom/tencent/qapmsdk/base/dbpersist/BaseTable;", "block", "Lkotlin/Function0;", "open", "search", "sql", "sqlSearch", "updateStatus", "id", "", "status", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class DBHandler
{
  public static final DBHandler.Companion Companion = new DBHandler.Companion(null);
  private static final int DB_ERROR = -1;
  private static final int DB_NO_OPEN = -2;
  private static final ArrayList<Object> TABLES = CollectionsKt.arrayListOf(new Object[] { ConfigsTable.Companion, DropFrameTable.Companion, ResultObjectsTable.Companion, UploadErrorsTable.Companion, StatisticsTable.Companion });
  private static final String TAG = "QAPM_db_persist_DBHandler";
  private static volatile DBHandler handler;
  private SQLiteDatabase database;
  @Nullable
  private DBHelper dbHelper;
  
  private final int sql(Function0<Integer> paramFunction0)
  {
    if (access$getDatabase$p(this) != null)
    {
      SQLiteDatabase localSQLiteDatabase = access$getDatabase$p(this);
      if ((localSQLiteDatabase == null) || (localSQLiteDatabase.isOpen())) {
        try
        {
          int i = ((Number)paramFunction0.invoke()).intValue();
          return i;
        }
        catch (Exception paramFunction0)
        {
          Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)paramFunction0);
          return -1;
        }
      }
    }
    return -2;
  }
  
  private final Object sqlSearch(Function0<? extends Object> paramFunction0)
  {
    if (access$getDatabase$p(this) != null)
    {
      SQLiteDatabase localSQLiteDatabase = access$getDatabase$p(this);
      if ((localSQLiteDatabase != null) && (!localSQLiteDatabase.isOpen())) {
        return null;
      }
      try
      {
        paramFunction0 = paramFunction0.invoke();
        return paramFunction0;
      }
      catch (Exception paramFunction0)
      {
        Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)paramFunction0);
      }
    }
    return null;
  }
  
  public final void close()
  {
    SQLiteDatabase localSQLiteDatabase = this.database;
    if ((localSQLiteDatabase != null) && (localSQLiteDatabase.isOpen()))
    {
      localSQLiteDatabase.close();
      handler = (DBHandler)null;
    }
  }
  
  public final int delete(@NotNull String paramString1, @Nullable String paramString2, @Nullable String[] paramArrayOfString)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "table");
    if (access$getDatabase$p(this) != null)
    {
      SQLiteDatabase localSQLiteDatabase = access$getDatabase$p(this);
      if ((localSQLiteDatabase == null) || (localSQLiteDatabase.isOpen())) {
        try
        {
          localSQLiteDatabase = this.database;
          if (localSQLiteDatabase != null)
          {
            int i = localSQLiteDatabase.delete(paramString1, paramString2, paramArrayOfString);
            return i;
          }
          return 0;
        }
        catch (Exception paramString1)
        {
          Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)paramString1);
          return -1;
        }
      }
    }
    return -2;
  }
  
  public final int deleteAllSentOrOverTime(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "table");
    if (paramBoolean) {
      return delete(paramString, "status=? OR occur_time<?", new String[] { String.valueOf(DBDataStatus.SENT.getValue()), String.valueOf(System.currentTimeMillis() - 259200000) });
    }
    return delete(paramString, "status=?", new String[] { String.valueOf(DBDataStatus.SENT.getValue()) });
  }
  
  @Nullable
  public final DBHelper getDbHelper()
  {
    return this.dbHelper;
  }
  
  public final int insert(@NotNull BaseTable paramBaseTable, @NotNull Function0<Integer> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTable, "table");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    SQLiteDatabase localSQLiteDatabase = access$getDatabase$p(this);
    int j = -2;
    int i = j;
    if (localSQLiteDatabase != null)
    {
      localSQLiteDatabase = access$getDatabase$p(this);
      if ((localSQLiteDatabase != null) && (!localSQLiteDatabase.isOpen())) {
        return -2;
      }
      try
      {
        localSQLiteDatabase = this.database;
        i = j;
        if (localSQLiteDatabase != null)
        {
          i = paramBaseTable.insert(localSQLiteDatabase, paramFunction0);
          return i;
        }
      }
      catch (Exception paramBaseTable)
      {
        Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)paramBaseTable);
        i = -1;
      }
    }
    return i;
  }
  
  public final void open()
  {
    Object localObject1 = this.database;
    if ((localObject1 == null) || ((localObject1 != null) && (!((SQLiteDatabase)localObject1).isOpen()))) {}
    for (;;)
    {
      try
      {
        localObject1 = this.dbHelper;
        if (localObject1 == null) {
          break label57;
        }
        localObject1 = ((DBHelper)localObject1).getWritableDatabase();
        this.database = ((SQLiteDatabase)localObject1);
        return;
      }
      catch (SQLiteException localSQLiteException)
      {
        Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)localSQLiteException);
      }
      return;
      label57:
      Object localObject2 = null;
    }
  }
  
  @Nullable
  public final Object search(@NotNull BaseTable paramBaseTable, @NotNull Function0<? extends Object> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseTable, "table");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    if (access$getDatabase$p(this) != null)
    {
      SQLiteDatabase localSQLiteDatabase = access$getDatabase$p(this);
      if ((localSQLiteDatabase != null) && (!localSQLiteDatabase.isOpen())) {
        return null;
      }
      try
      {
        localSQLiteDatabase = this.database;
        if (localSQLiteDatabase != null)
        {
          paramBaseTable = paramBaseTable.search(localSQLiteDatabase, paramFunction0);
          return paramBaseTable;
        }
      }
      catch (Exception paramBaseTable)
      {
        Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)paramBaseTable);
      }
    }
    return null;
  }
  
  public final void setDbHelper(@Nullable DBHelper paramDBHelper)
  {
    this.dbHelper = paramDBHelper;
  }
  
  public final int updateStatus(@NotNull String paramString, long paramLong, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "table");
    if (access$getDatabase$p(this) != null)
    {
      Object localObject = access$getDatabase$p(this);
      if ((localObject == null) || (((SQLiteDatabase)localObject).isOpen())) {
        try
        {
          if ((paramInt != DBDataStatus.TO_SEND.getValue()) && (paramInt != DBDataStatus.SENT.getValue())) {
            return -1;
          }
          localObject = new ContentValues();
          ((ContentValues)localObject).put("status", Integer.valueOf(paramInt));
          SQLiteDatabase localSQLiteDatabase = this.database;
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
          Logger.INSTANCE.exception("QAPM_db_persist_DBHandler", (Throwable)paramString);
          return -1;
        }
      }
    }
    return -2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.DBHandler
 * JD-Core Version:    0.7.0.1
 */