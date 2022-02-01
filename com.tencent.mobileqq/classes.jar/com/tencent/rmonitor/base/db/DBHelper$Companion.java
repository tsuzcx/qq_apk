package com.tencent.rmonitor.base.db;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/db/DBHelper$Companion;", "", "()V", "DATABASE_NAME", "", "helper", "Lcom/tencent/rmonitor/base/db/DBHelper;", "getInstance", "context", "Landroid/content/Context;", "registerTable", "", "tableName", "createSql", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DBHelper$Companion
{
  @JvmStatic
  @NotNull
  public final DBHelper a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    DBHelper localDBHelper = DBHelper.b();
    if (localDBHelper != null) {
      return localDBHelper;
    }
    try
    {
      localDBHelper = DBHelper.b();
      if (localDBHelper != null)
      {
        paramContext = localDBHelper;
      }
      else
      {
        paramContext = new DBHelper(paramContext);
        DBHelper.a(paramContext);
      }
      return paramContext;
    }
    finally {}
  }
  
  @JvmStatic
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tableName");
    Intrinsics.checkParameterIsNotNull(paramString2, "createSql");
    SqliteHelper.b.a(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.db.DBHelper.Companion
 * JD-Core Version:    0.7.0.1
 */