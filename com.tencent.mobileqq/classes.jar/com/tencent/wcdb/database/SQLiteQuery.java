package com.tencent.wcdb.database;

import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteQuery
  extends SQLiteProgram
{
  private final CancellationSignal b;
  
  SQLiteQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, CancellationSignal paramCancellationSignal)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, paramCancellationSignal);
    this.b = paramCancellationSignal;
  }
  
  /* Error */
  int a(com.tencent.wcdb.CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 21	com/tencent/wcdb/database/SQLiteQuery:h	()V
    //   4: aload_1
    //   5: invokevirtual 24	com/tencent/wcdb/CursorWindow:h	()V
    //   8: aload_0
    //   9: invokevirtual 28	com/tencent/wcdb/database/SQLiteQuery:l	()Lcom/tencent/wcdb/database/SQLiteSession;
    //   12: aload_0
    //   13: invokevirtual 32	com/tencent/wcdb/database/SQLiteQuery:f	()Ljava/lang/String;
    //   16: aload_0
    //   17: invokevirtual 36	com/tencent/wcdb/database/SQLiteQuery:j	()[Ljava/lang/Object;
    //   20: aload_1
    //   21: iload_2
    //   22: iload_3
    //   23: iload 4
    //   25: aload_0
    //   26: invokevirtual 40	com/tencent/wcdb/database/SQLiteQuery:m	()I
    //   29: aload_0
    //   30: getfield 12	com/tencent/wcdb/database/SQLiteQuery:b	Lcom/tencent/wcdb/support/CancellationSignal;
    //   33: invokevirtual 45	com/tencent/wcdb/database/SQLiteSession:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/CursorWindow;IIZILcom/tencent/wcdb/support/CancellationSignal;)I
    //   36: istore_2
    //   37: aload_1
    //   38: invokevirtual 48	com/tencent/wcdb/CursorWindow:i	()V
    //   41: aload_0
    //   42: invokevirtual 49	com/tencent/wcdb/database/SQLiteQuery:i	()V
    //   45: iload_2
    //   46: ireturn
    //   47: astore 5
    //   49: goto +70 -> 119
    //   52: astore 5
    //   54: new 51	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   61: astore 6
    //   63: aload 6
    //   65: ldc 55
    //   67: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload 6
    //   73: aload 5
    //   75: invokevirtual 62	com/tencent/wcdb/database/SQLiteException:getMessage	()Ljava/lang/String;
    //   78: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 6
    //   84: ldc 64
    //   86: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 6
    //   92: aload_0
    //   93: invokevirtual 32	com/tencent/wcdb/database/SQLiteQuery:f	()Ljava/lang/String;
    //   96: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: ldc 66
    //   102: aload 6
    //   104: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 74	com/tencent/wcdb/support/Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload_0
    //   111: aload 5
    //   113: invokevirtual 77	com/tencent/wcdb/database/SQLiteQuery:a	(Lcom/tencent/wcdb/database/SQLiteException;)V
    //   116: aload 5
    //   118: athrow
    //   119: aload_1
    //   120: invokevirtual 48	com/tencent/wcdb/CursorWindow:i	()V
    //   123: aload 5
    //   125: athrow
    //   126: astore_1
    //   127: aload_0
    //   128: invokevirtual 49	com/tencent/wcdb/database/SQLiteQuery:i	()V
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	SQLiteQuery
    //   0	133	1	paramCursorWindow	com.tencent.wcdb.CursorWindow
    //   0	133	2	paramInt1	int
    //   0	133	3	paramInt2	int
    //   0	133	4	paramBoolean	boolean
    //   47	1	5	localObject	Object
    //   52	72	5	localSQLiteException	SQLiteException
    //   61	42	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   8	37	47	finally
    //   54	119	47	finally
    //   8	37	52	com/tencent/wcdb/database/SQLiteException
    //   4	8	126	finally
    //   37	41	126	finally
    //   119	126	126	finally
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SQLiteQuery: ");
    localStringBuilder.append(f());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteQuery
 * JD-Core Version:    0.7.0.1
 */