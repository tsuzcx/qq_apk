package com.tencent.rmonitor.base.db;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/db/DBHandler$Companion;", "", "()V", "DB_ERROR", "", "DB_NO_OPEN", "TABLES", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "TAG", "", "handler", "Lcom/tencent/rmonitor/base/db/DBHandler;", "getInstance", "dbHelper", "Lcom/tencent/rmonitor/base/db/DBHelper;", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DBHandler$Companion
{
  @NotNull
  public final DBHandler a(@NotNull DBHelper paramDBHelper)
  {
    Intrinsics.checkParameterIsNotNull(paramDBHelper, "dbHelper");
    DBHandler localDBHandler = DBHandler.c();
    if (localDBHandler != null) {
      return localDBHandler;
    }
    try
    {
      localDBHandler = DBHandler.c();
      if (localDBHandler != null)
      {
        paramDBHelper = localDBHandler;
      }
      else
      {
        localDBHandler = new DBHandler(null);
        DBHandler.b(localDBHandler);
        localDBHandler.a(paramDBHelper);
        localDBHandler.a();
        paramDBHelper = localDBHandler;
      }
      return paramDBHelper;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.db.DBHandler.Companion
 * JD-Core Version:    0.7.0.1
 */