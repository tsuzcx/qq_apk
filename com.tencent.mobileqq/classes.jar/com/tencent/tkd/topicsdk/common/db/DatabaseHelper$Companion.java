package com.tencent.tkd.topicsdk.common.db;

import com.tencent.tkd.topicsdk.framework.TLog;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/db/DatabaseHelper$Companion;", "", "()V", "TAG", "", "VERSION", "", "instance", "Lcom/tencent/tkd/topicsdk/common/db/DatabaseHelper;", "getInstance", "()Lcom/tencent/tkd/topicsdk/common/db/DatabaseHelper;", "mInstance", "release", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DatabaseHelper$Companion
{
  @NotNull
  public final DatabaseHelper a()
  {
    try
    {
      DatabaseHelper localDatabaseHelper = DatabaseHelper.a();
      if (localDatabaseHelper == null)
      {
        localDatabaseHelper = new DatabaseHelper();
        DatabaseHelper.a(localDatabaseHelper);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("new Database Instance ");
        localStringBuilder.append(DatabaseHelper.a());
        TLog.b("DatabaseHelper", localStringBuilder.toString());
      }
      return localDatabaseHelper;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.db.DatabaseHelper.Companion
 * JD-Core Version:    0.7.0.1
 */