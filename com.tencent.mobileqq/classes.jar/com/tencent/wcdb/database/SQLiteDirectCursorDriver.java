package com.tencent.wcdb.database;

import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.support.CancellationSignal;

public final class SQLiteDirectCursorDriver
  implements SQLiteCursorDriver
{
  private static SQLiteDatabase.CursorFactory f = SQLiteCursor.h;
  private final SQLiteDatabase a;
  private final String b;
  private final String c;
  private final CancellationSignal d;
  private SQLiteProgram e;
  
  public SQLiteDirectCursorDriver(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, CancellationSignal paramCancellationSignal)
  {
    this.a = paramSQLiteDatabase;
    this.b = paramString2;
    this.c = paramString1;
    this.d = paramCancellationSignal;
  }
  
  public Cursor a(SQLiteDatabase.CursorFactory paramCursorFactory, Object[] paramArrayOfObject)
  {
    Object localObject = paramCursorFactory;
    if (paramCursorFactory == null) {
      localObject = f;
    }
    paramCursorFactory = null;
    try
    {
      paramArrayOfObject = ((SQLiteDatabase.CursorFactory)localObject).a(this.a, this.c, paramArrayOfObject, this.d);
      paramCursorFactory = paramArrayOfObject;
      localObject = ((SQLiteDatabase.CursorFactory)localObject).a(this.a, this, this.b, paramArrayOfObject);
      this.e = paramArrayOfObject;
      return localObject;
    }
    catch (RuntimeException paramArrayOfObject)
    {
      if (paramCursorFactory != null) {
        paramCursorFactory.close();
      }
      throw paramArrayOfObject;
    }
  }
  
  public void a() {}
  
  public void a(Cursor paramCursor) {}
  
  public void b() {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SQLiteDirectCursorDriver: ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDirectCursorDriver
 * JD-Core Version:    0.7.0.1
 */