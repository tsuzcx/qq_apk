package com.tencent.qapmsdk.base.dbpersist;

import com.tencent.qapmsdk.common.sqlitedb.SqliteHelper;
import com.tencent.qapmsdk.common.sqlitedb.SqliteHelper.Companion;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/DBHelper$Companion;", "", "()V", "DATABASE_NAME", "", "DB_VERSION", "", "helper", "Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;", "getInstance", "context", "Landroid/content/Context;", "registerTable", "", "tableName", "createSql", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class DBHelper$Companion
{
  /* Error */
  @JvmStatic
  @NotNull
  public final DBHelper getInstance(@NotNull android.content.Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 39
    //   3: invokestatic 45	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: invokestatic 51	com/tencent/qapmsdk/base/dbpersist/DBHelper:access$getHelper$cp	()Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +5 -> 16
    //   14: aload_2
    //   15: areturn
    //   16: aload_0
    //   17: monitorenter
    //   18: invokestatic 51	com/tencent/qapmsdk/base/dbpersist/DBHelper:access$getHelper$cp	()Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +7 -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: new 47	com/tencent/qapmsdk/base/dbpersist/DBHelper
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 54	com/tencent/qapmsdk/base/dbpersist/DBHelper:<init>	(Landroid/content/Context;)V
    //   38: astore_2
    //   39: aload_2
    //   40: invokestatic 58	com/tencent/qapmsdk/base/dbpersist/DBHelper:access$setHelper$cp	(Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;)V
    //   43: goto -17 -> 26
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	this	Companion
    //   0	51	1	paramContext	android.content.Context
    //   9	31	2	localDBHelper	DBHelper
    // Exception table:
    //   from	to	target	type
    //   18	22	46	finally
    //   30	43	46	finally
  }
  
  @JvmStatic
  public final void registerTable(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tableName");
    Intrinsics.checkParameterIsNotNull(paramString2, "createSql");
    SqliteHelper.Companion.registerTable(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.DBHelper.Companion
 * JD-Core Version:    0.7.0.1
 */