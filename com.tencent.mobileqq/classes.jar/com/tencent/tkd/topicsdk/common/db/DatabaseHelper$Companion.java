package com.tencent.tkd.topicsdk.common.db;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/db/DatabaseHelper$Companion;", "", "()V", "TAG", "", "VERSION", "", "instance", "Lcom/tencent/tkd/topicsdk/common/db/DatabaseHelper;", "getInstance", "()Lcom/tencent/tkd/topicsdk/common/db/DatabaseHelper;", "mInstance", "release", "", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class DatabaseHelper$Companion
{
  /* Error */
  @org.jetbrains.annotations.NotNull
  public final DatabaseHelper a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 39	com/tencent/tkd/topicsdk/common/db/DatabaseHelper:a	()Lcom/tencent/tkd/topicsdk/common/db/DatabaseHelper;
    //   5: astore_1
    //   6: aload_1
    //   7: ifnull +7 -> 14
    //   10: aload_0
    //   11: monitorexit
    //   12: aload_1
    //   13: areturn
    //   14: new 37	com/tencent/tkd/topicsdk/common/db/DatabaseHelper
    //   17: dup
    //   18: invokespecial 40	com/tencent/tkd/topicsdk/common/db/DatabaseHelper:<init>	()V
    //   21: astore_1
    //   22: aload_1
    //   23: invokestatic 43	com/tencent/tkd/topicsdk/common/db/DatabaseHelper:a	(Lcom/tencent/tkd/topicsdk/common/db/DatabaseHelper;)V
    //   26: ldc 45
    //   28: new 47	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   35: ldc 50
    //   37: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: invokestatic 39	com/tencent/tkd/topicsdk/common/db/DatabaseHelper:a	()Lcom/tencent/tkd/topicsdk/common/db/DatabaseHelper;
    //   43: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 67	com/tencent/tkd/topicsdk/framework/TLog:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: goto -42 -> 10
    //   55: astore_1
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_1
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	Companion
    //   5	18	1	localDatabaseHelper	DatabaseHelper
    //   55	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	6	55	finally
    //   14	52	55	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.db.DatabaseHelper.Companion
 * JD-Core Version:    0.7.0.1
 */