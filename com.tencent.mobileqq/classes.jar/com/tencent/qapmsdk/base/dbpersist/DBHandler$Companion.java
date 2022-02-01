package com.tencent.qapmsdk.base.dbpersist;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/dbpersist/DBHandler$Companion;", "", "()V", "DB_ERROR", "", "DB_NO_OPEN", "TABLES", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "TAG", "", "handler", "Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;", "getInstance", "dbHelper", "Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public final class DBHandler$Companion
{
  /* Error */
  @org.jetbrains.annotations.NotNull
  public final DBHandler getInstance(@org.jetbrains.annotations.NotNull DBHelper paramDBHelper)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 39
    //   3: invokestatic 45	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: invokestatic 51	com/tencent/qapmsdk/base/dbpersist/DBHandler:access$getHandler$cp	()Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;
    //   9: astore_2
    //   10: aload_2
    //   11: ifnull +5 -> 16
    //   14: aload_2
    //   15: areturn
    //   16: aload_0
    //   17: monitorenter
    //   18: invokestatic 51	com/tencent/qapmsdk/base/dbpersist/DBHandler:access$getHandler$cp	()Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;
    //   21: astore_2
    //   22: aload_2
    //   23: ifnull +7 -> 30
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: new 47	com/tencent/qapmsdk/base/dbpersist/DBHandler
    //   33: dup
    //   34: aconst_null
    //   35: invokespecial 53	com/tencent/qapmsdk/base/dbpersist/DBHandler:<init>	(Lkotlin/jvm/internal/DefaultConstructorMarker;)V
    //   38: astore_2
    //   39: aload_2
    //   40: invokestatic 57	com/tencent/qapmsdk/base/dbpersist/DBHandler:access$setHandler$cp	(Lcom/tencent/qapmsdk/base/dbpersist/DBHandler;)V
    //   43: aload_2
    //   44: aload_1
    //   45: invokevirtual 61	com/tencent/qapmsdk/base/dbpersist/DBHandler:setDbHelper	(Lcom/tencent/qapmsdk/base/dbpersist/DBHelper;)V
    //   48: aload_2
    //   49: invokevirtual 64	com/tencent/qapmsdk/base/dbpersist/DBHandler:open	()V
    //   52: goto -26 -> 26
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	Companion
    //   0	60	1	paramDBHelper	DBHelper
    //   9	40	2	localDBHandler	DBHandler
    // Exception table:
    //   from	to	target	type
    //   18	22	55	finally
    //   30	52	55	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.dbpersist.DBHandler.Companion
 * JD-Core Version:    0.7.0.1
 */