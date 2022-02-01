package com.tencent.rmonitor.base.db;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/base/db/DBHelper;", "Lcom/tencent/rmonitor/base/db/SqliteHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dbHandler", "Lcom/tencent/rmonitor/base/db/DBHandler;", "getDbHandler", "()Lcom/tencent/rmonitor/base/db/DBHandler;", "Companion", "rmonitor-base_release"}, k=1, mv={1, 1, 15})
public final class DBHelper
  extends SqliteHelper
{
  public static final DBHelper.Companion a = new DBHelper.Companion(null);
  private static volatile DBHelper d;
  @NotNull
  private final DBHandler c = DBHandler.a.a(this);
  
  public DBHelper(@NotNull Context paramContext)
  {
    super(paramContext, "rmonitor_db", null);
  }
  
  @NotNull
  public final DBHandler a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.db.DBHelper
 * JD-Core Version:    0.7.0.1
 */