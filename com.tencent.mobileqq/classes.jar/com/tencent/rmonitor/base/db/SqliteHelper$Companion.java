package com.tencent.rmonitor.base.db;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/db/SqliteHelper$Companion;", "", "()V", "DB_VERSION_1_0_0_13", "", "DB_VERSION_1_0_0_14", "DB_VERSION_1_0_1_21", "tables", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getTables", "()Ljava/util/HashMap;", "registerTable", "", "tableName", "createSql", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class SqliteHelper$Companion
{
  @NotNull
  public final HashMap<String, String> a()
  {
    return SqliteHelper.c();
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tableName");
    Intrinsics.checkParameterIsNotNull(paramString2, "createSql");
    int i = ((CharSequence)paramString1).length();
    int j = 1;
    if (i > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (((CharSequence)paramString2).length() > 0) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0) {
        ((Map)((Companion)this).a()).put(paramString1, paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.db.SqliteHelper.Companion
 * JD-Core Version:    0.7.0.1
 */