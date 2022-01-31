package com.tencent.qapmsdk.base.dbpersist;

import android.content.Context;
import com.tencent.qapmsdk.common.sqlitedb.SqliteHelper;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;", "Lcom/tencent/qapmsdk/common/sqlitedb/SqliteHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dbHandler", "Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;", "getDbHandler", "()Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;", "Companion", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class DBHelper
  extends SqliteHelper
{
  public static final DBHelper.Companion Companion = new DBHelper.Companion(null);
  private static final String DATABASE_NAME = "sdk_db";
  private static final int DB_VERSION = 6;
  private static volatile DBHelper helper;
  @NotNull
  private final DBHandler dbHandler = DBHandler.Companion.getInstance(this);
  
  public DBHelper(@NotNull Context paramContext)
  {
    super(paramContext, "sdk_db", null, 6);
  }
  
  @JvmStatic
  @NotNull
  public static final DBHelper getInstance(@NotNull Context paramContext)
  {
    return Companion.getInstance(paramContext);
  }
  
  @JvmStatic
  public static final void registerTable(@NotNull String paramString1, @NotNull String paramString2)
  {
    Companion.registerTable(paramString1, paramString2);
  }
  
  @NotNull
  public final DBHandler getDbHandler()
  {
    return this.dbHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.DBHelper
 * JD-Core Version:    0.7.0.1
 */