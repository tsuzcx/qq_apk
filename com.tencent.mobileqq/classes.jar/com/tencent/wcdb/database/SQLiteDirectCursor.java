package com.tencent.wcdb.database;

import com.tencent.wcdb.AbstractCursor;
import com.tencent.wcdb.support.Log;

public class SQLiteDirectCursor
  extends AbstractCursor
{
  public static final SQLiteDatabase.CursorFactory g = new SQLiteDirectCursor.1();
  private final SQLiteDirectQuery h;
  private final SQLiteCursorDriver i;
  private final String[] j;
  private int k;
  private boolean l;
  
  public SQLiteDirectCursor(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteDirectQuery paramSQLiteDirectQuery)
  {
    if (paramSQLiteDirectQuery != null)
    {
      this.h = paramSQLiteDirectQuery;
      this.i = paramSQLiteCursorDriver;
      this.j = paramSQLiteDirectQuery.k();
      this.k = -1;
      this.l = false;
      return;
    }
    throw new IllegalArgumentException("query object cannot be null");
  }
  
  public void close()
  {
    super.close();
    this.h.close();
    this.i.b();
  }
  
  public void deactivate()
  {
    super.deactivate();
    this.i.a();
  }
  
  public byte[] getBlob(int paramInt)
  {
    return this.h.d(paramInt);
  }
  
  public String[] getColumnNames()
  {
    return this.j;
  }
  
  public int getCount()
  {
    if (!this.l)
    {
      Log.b("WCDB.SQLiteDirectCursor", "Count query on SQLiteDirectCursor is slow. Iterate through the end to get count or use other implementations.");
      this.k = (this.b + this.h.f(2147483647) + 1);
      this.l = true;
      this.h.a(false);
      this.b = (this.h.f(this.b + 1) - 1);
    }
    return this.k;
  }
  
  public double getDouble(int paramInt)
  {
    return this.h.b(paramInt);
  }
  
  public float getFloat(int paramInt)
  {
    return (float)this.h.b(paramInt);
  }
  
  public int getInt(int paramInt)
  {
    return (int)this.h.a(paramInt);
  }
  
  public long getLong(int paramInt)
  {
    return this.h.a(paramInt);
  }
  
  public short getShort(int paramInt)
  {
    return (short)(int)this.h.a(paramInt);
  }
  
  public String getString(int paramInt)
  {
    return this.h.c(paramInt);
  }
  
  public int getType(int paramInt)
  {
    return this.h.e(paramInt);
  }
  
  public boolean isNull(int paramInt)
  {
    return getType(paramInt) == 0;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    boolean bool = false;
    if (paramInt < 0)
    {
      this.h.a(false);
      this.b = -1;
      return false;
    }
    int m;
    if (this.l)
    {
      m = this.k;
      if (paramInt >= m)
      {
        this.b = m;
        return false;
      }
    }
    if (paramInt < this.b)
    {
      Log.b("WCDB.SQLiteDirectCursor", "Moving backward on SQLiteDirectCursor is slow. Get rid of backward movement or use other implementations.");
      this.h.a(false);
      m = this.h.f(paramInt + 1) - 1;
    }
    else
    {
      if (paramInt == this.b) {
        return true;
      }
      m = this.b + this.h.f(paramInt - this.b);
    }
    if (m < paramInt)
    {
      this.k = (m + 1);
      this.l = true;
      this.b = this.k;
    }
    else
    {
      this.b = m;
      if (m >= this.k)
      {
        this.k = (m + 1);
        this.l = false;
      }
    }
    if (this.b < this.k) {
      bool = true;
    }
    return bool;
  }
  
  /* Error */
  public boolean requery()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 128	com/tencent/wcdb/database/SQLiteDirectCursor:isClosed	()Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 30	com/tencent/wcdb/database/SQLiteDirectCursor:h	Lcom/tencent/wcdb/database/SQLiteDirectQuery;
    //   15: invokevirtual 131	com/tencent/wcdb/database/SQLiteDirectQuery:e	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   18: invokevirtual 135	com/tencent/wcdb/database/SQLiteDatabase:k	()Z
    //   21: ifne +7 -> 28
    //   24: aload_0
    //   25: monitorexit
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_0
    //   29: iconst_m1
    //   30: putfield 84	com/tencent/wcdb/database/SQLiteDirectCursor:b	I
    //   33: aload_0
    //   34: iconst_0
    //   35: putfield 43	com/tencent/wcdb/database/SQLiteDirectCursor:l	Z
    //   38: aload_0
    //   39: iconst_m1
    //   40: putfield 41	com/tencent/wcdb/database/SQLiteDirectCursor:k	I
    //   43: aload_0
    //   44: getfield 32	com/tencent/wcdb/database/SQLiteDirectCursor:i	Lcom/tencent/wcdb/database/SQLiteCursorDriver;
    //   47: aload_0
    //   48: invokeinterface 138 2 0
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_0
    //   56: getfield 30	com/tencent/wcdb/database/SQLiteDirectCursor:h	Lcom/tencent/wcdb/database/SQLiteDirectQuery;
    //   59: iconst_0
    //   60: invokevirtual 92	com/tencent/wcdb/database/SQLiteDirectQuery:a	(Z)V
    //   63: aload_0
    //   64: invokespecial 140	com/tencent/wcdb/AbstractCursor:requery	()Z
    //   67: istore_1
    //   68: iload_1
    //   69: ireturn
    //   70: astore_2
    //   71: new 142	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   78: astore_3
    //   79: aload_3
    //   80: ldc 145
    //   82: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_3
    //   87: aload_2
    //   88: invokevirtual 153	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   91: invokevirtual 149	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: ldc 75
    //   97: aload_3
    //   98: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: iconst_1
    //   102: anewarray 158	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload_2
    //   108: aastore
    //   109: invokestatic 161	com/tencent/wcdb/support/Log:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: iconst_0
    //   113: ireturn
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	SQLiteDirectCursor
    //   67	2	1	bool	boolean
    //   70	38	2	localIllegalStateException	java.lang.IllegalStateException
    //   114	4	2	localObject	java.lang.Object
    //   78	20	3	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   63	68	70	java/lang/IllegalStateException
    //   11	26	114	finally
    //   28	55	114	finally
    //   115	117	114	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDirectCursor
 * JD-Core Version:    0.7.0.1
 */