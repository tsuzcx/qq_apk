package com.tencent.qapmsdk.base.dbpersist;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/DBHandler$Companion;", "", "()V", "DB_ERROR", "", "DB_NO_OPEN", "TABLES", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "TAG", "", "handler", "Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;", "getInstance", "dbHelper", "Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class DBHandler$Companion
{
  @NotNull
  public final DBHandler getInstance(@NotNull DBHelper paramDBHelper)
  {
    Intrinsics.checkParameterIsNotNull(paramDBHelper, "dbHelper");
    DBHandler localDBHandler = DBHandler.access$getHandler$cp();
    if (localDBHandler != null) {
      return localDBHandler;
    }
    try
    {
      localDBHandler = DBHandler.access$getHandler$cp();
      if (localDBHandler != null)
      {
        paramDBHelper = localDBHandler;
      }
      else
      {
        localDBHandler = new DBHandler(null);
        DBHandler.access$setHandler$cp(localDBHandler);
        localDBHandler.setDbHelper(paramDBHelper);
        localDBHandler.open();
        paramDBHelper = localDBHandler;
      }
      return paramDBHelper;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.DBHandler.Companion
 * JD-Core Version:    0.7.0.1
 */