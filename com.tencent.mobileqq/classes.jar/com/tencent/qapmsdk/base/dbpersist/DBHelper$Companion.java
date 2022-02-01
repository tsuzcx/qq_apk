package com.tencent.qapmsdk.base.dbpersist;

import android.content.Context;
import com.tencent.qapmsdk.common.sqlitedb.SqliteHelper;
import com.tencent.qapmsdk.common.sqlitedb.SqliteHelper.Companion;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/DBHelper$Companion;", "", "()V", "DATABASE_NAME", "", "DB_VERSION", "", "helper", "Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;", "getInstance", "context", "Landroid/content/Context;", "registerTable", "", "tableName", "createSql", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class DBHelper$Companion
{
  @JvmStatic
  @NotNull
  public final DBHelper getInstance(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    DBHelper localDBHelper = DBHelper.access$getHelper$cp();
    if (localDBHelper != null) {
      return localDBHelper;
    }
    try
    {
      localDBHelper = DBHelper.access$getHelper$cp();
      if (localDBHelper != null)
      {
        paramContext = localDBHelper;
      }
      else
      {
        paramContext = new DBHelper(paramContext);
        DBHelper.access$setHelper$cp(paramContext);
      }
      return paramContext;
    }
    finally {}
  }
  
  @JvmStatic
  public final void registerTable(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tableName");
    Intrinsics.checkParameterIsNotNull(paramString2, "createSql");
    SqliteHelper.Companion.registerTable(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.DBHelper.Companion
 * JD-Core Version:    0.7.0.1
 */