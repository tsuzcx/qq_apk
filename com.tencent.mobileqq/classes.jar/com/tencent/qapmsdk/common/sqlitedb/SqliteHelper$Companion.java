package com.tencent.qapmsdk.common.sqlitedb;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/sqlitedb/SqliteHelper$Companion;", "", "()V", "tables", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTables", "()Ljava/util/HashMap;", "registerTable", "", "tableName", "createSql", "common_release"}, k=1, mv={1, 1, 15})
public final class SqliteHelper$Companion
{
  @NotNull
  public final HashMap<String, String> getTables()
  {
    return SqliteHelper.access$getTables$cp();
  }
  
  public final void registerTable(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tableName");
    Intrinsics.checkParameterIsNotNull(paramString2, "createSql");
    if (((CharSequence)paramString1).length() > 0)
    {
      i = 1;
      if (i != 0) {
        if (((CharSequence)paramString2).length() <= 0) {
          break label72;
        }
      }
    }
    label72:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((Map)((Companion)this).getTables()).put(paramString1, paramString2);
      }
      return;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.common.sqlitedb.SqliteHelper.Companion
 * JD-Core Version:    0.7.0.1
 */