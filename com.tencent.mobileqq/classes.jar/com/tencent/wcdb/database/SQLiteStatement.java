package com.tencent.wcdb.database;

public final class SQLiteStatement
  extends SQLiteProgram
{
  SQLiteStatement(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, null);
  }
  
  public int a()
  {
    return a(null);
  }
  
  /* Error */
  public int a(com.tencent.wcdb.support.CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 21	com/tencent/wcdb/database/SQLiteStatement:h	()V
    //   4: aload_0
    //   5: invokevirtual 25	com/tencent/wcdb/database/SQLiteStatement:l	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   8: aload_0
    //   9: invokevirtual 29	com/tencent/wcdb/database/SQLiteStatement:f	()Ljava/lang/String;
    //   12: aload_0
    //   13: invokevirtual 33	com/tencent/wcdb/database/SQLiteStatement:j	()[Ljava/lang/Object;
    //   16: aload_0
    //   17: invokevirtual 36	com/tencent/wcdb/database/SQLiteStatement:m	()I
    //   20: aload_1
    //   21: invokevirtual 41	com/tencent/wcdb/database/SQLiteSession:a	(Ljava/lang/String;[Ljava/lang/Object;ILcom/tencent/wcdb/support/CancellationSignal;)I
    //   24: istore_2
    //   25: aload_0
    //   26: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:i	()V
    //   29: iload_2
    //   30: ireturn
    //   31: astore_1
    //   32: goto +11 -> 43
    //   35: astore_1
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 47	com/tencent/wcdb/database/SQLiteStatement:a	(Lcom/tencent/wcdb/database/SQLiteException;)V
    //   41: aload_1
    //   42: athrow
    //   43: aload_0
    //   44: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:i	()V
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	SQLiteStatement
    //   0	49	1	paramCancellationSignal	com.tencent.wcdb.support.CancellationSignal
    //   24	6	2	i	int
    // Exception table:
    //   from	to	target	type
    //   4	25	31	finally
    //   36	43	31	finally
    //   4	25	35	com/tencent/wcdb/database/SQLiteDatabaseCorruptException
  }
  
  public long b()
  {
    return b(null);
  }
  
  /* Error */
  public long b(com.tencent.wcdb.support.CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 21	com/tencent/wcdb/database/SQLiteStatement:h	()V
    //   4: aload_0
    //   5: invokevirtual 25	com/tencent/wcdb/database/SQLiteStatement:l	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   8: aload_0
    //   9: invokevirtual 29	com/tencent/wcdb/database/SQLiteStatement:f	()Ljava/lang/String;
    //   12: aload_0
    //   13: invokevirtual 33	com/tencent/wcdb/database/SQLiteStatement:j	()[Ljava/lang/Object;
    //   16: aload_0
    //   17: invokevirtual 36	com/tencent/wcdb/database/SQLiteStatement:m	()I
    //   20: aload_1
    //   21: invokevirtual 55	com/tencent/wcdb/database/SQLiteSession:b	(Ljava/lang/String;[Ljava/lang/Object;ILcom/tencent/wcdb/support/CancellationSignal;)J
    //   24: lstore_2
    //   25: aload_0
    //   26: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:i	()V
    //   29: lload_2
    //   30: lreturn
    //   31: astore_1
    //   32: goto +11 -> 43
    //   35: astore_1
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 47	com/tencent/wcdb/database/SQLiteStatement:a	(Lcom/tencent/wcdb/database/SQLiteException;)V
    //   41: aload_1
    //   42: athrow
    //   43: aload_0
    //   44: invokevirtual 44	com/tencent/wcdb/database/SQLiteStatement:i	()V
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	SQLiteStatement
    //   0	49	1	paramCancellationSignal	com.tencent.wcdb.support.CancellationSignal
    //   24	6	2	l	long
    // Exception table:
    //   from	to	target	type
    //   4	25	31	finally
    //   36	43	31	finally
    //   4	25	35	com/tencent/wcdb/database/SQLiteDatabaseCorruptException
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SQLiteProgram: ");
    localStringBuilder.append(f());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteStatement
 * JD-Core Version:    0.7.0.1
 */