package com.tencent.wcdb.database;

import com.tencent.wcdb.AbstractWindowedCursor;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.DatabaseUtils;
import com.tencent.wcdb.support.Log;
import java.util.HashMap;
import java.util.Map;

public class SQLiteCursor
  extends AbstractWindowedCursor
{
  public static final SQLiteDatabase.CursorFactory h = new SQLiteCursor.1();
  private final String[] i;
  private final SQLiteQuery j;
  private final SQLiteCursorDriver k;
  private int l = -1;
  private int m;
  private Map<String, Integer> n;
  
  public SQLiteCursor(SQLiteCursorDriver paramSQLiteCursorDriver, String paramString, SQLiteQuery paramSQLiteQuery)
  {
    if (paramSQLiteQuery != null)
    {
      this.k = paramSQLiteCursorDriver;
      this.n = null;
      this.j = paramSQLiteQuery;
      this.i = paramSQLiteQuery.k();
      this.c = DatabaseUtils.a(this.i);
      return;
    }
    throw new IllegalArgumentException("query object cannot be null");
  }
  
  private void a(int paramInt)
  {
    a(e().l());
    try
    {
      if (this.l == -1)
      {
        i1 = DatabaseUtils.a(paramInt, 0);
        this.l = this.j.a(this.g, i1, paramInt, true);
        this.m = this.g.d();
        return;
      }
      int i1 = DatabaseUtils.a(paramInt, this.m);
      this.j.a(this.g, i1, paramInt, false);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      d();
      throw localRuntimeException;
    }
  }
  
  public void a(CursorWindow paramCursorWindow)
  {
    super.a(paramCursorWindow);
    this.l = -1;
  }
  
  public boolean a(int paramInt1, int paramInt2)
  {
    if ((this.g == null) || (paramInt2 < this.g.c()) || (paramInt2 >= this.g.c() + this.g.d()))
    {
      a(paramInt2);
      paramInt1 = this.g.c() + this.g.d();
      if (paramInt2 >= paramInt1) {
        this.l = paramInt1;
      }
    }
    return true;
  }
  
  public void close()
  {
    super.close();
    try
    {
      this.j.close();
      this.k.b();
      return;
    }
    finally {}
  }
  
  public void deactivate()
  {
    super.deactivate();
    this.k.a();
  }
  
  public SQLiteDatabase e()
  {
    return this.j.e();
  }
  
  protected void finalize()
  {
    try
    {
      if (this.g != null) {
        close();
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
  
  public int getColumnIndex(String paramString)
  {
    Object localObject2;
    if (this.n == null)
    {
      localObject1 = this.i;
      int i2 = localObject1.length;
      localObject2 = new HashMap(i2, 1.0F);
      i1 = 0;
      while (i1 < i2)
      {
        ((HashMap)localObject2).put(localObject1[i1], Integer.valueOf(i1));
        i1 += 1;
      }
      this.n = ((Map)localObject2);
    }
    int i1 = paramString.lastIndexOf('.');
    Object localObject1 = paramString;
    if (i1 != -1)
    {
      localObject1 = new Exception();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requesting column name with table name -- ");
      ((StringBuilder)localObject2).append(paramString);
      Log.a("WCDB.SQLiteCursor", ((StringBuilder)localObject2).toString(), new Object[] { localObject1 });
      localObject1 = paramString.substring(i1 + 1);
    }
    paramString = (Integer)this.n.get(localObject1);
    if (paramString != null) {
      return paramString.intValue();
    }
    return -1;
  }
  
  public String[] getColumnNames()
  {
    return this.i;
  }
  
  public int getCount()
  {
    if (this.l == -1) {
      a(0);
    }
    return this.l;
  }
  
  public boolean moveToPosition(int paramInt)
  {
    if (!super.moveToPosition(paramInt)) {
      return false;
    }
    int i1 = getCount();
    if (paramInt >= i1)
    {
      this.b = i1;
      return false;
    }
    return true;
  }
  
  /* Error */
  public boolean requery()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 199	com/tencent/wcdb/database/SQLiteCursor:isClosed	()Z
    //   4: ifeq +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 38	com/tencent/wcdb/database/SQLiteCursor:j	Lcom/tencent/wcdb/database/SQLiteQuery;
    //   15: invokevirtual 118	com/tencent/wcdb/database/SQLiteQuery:e	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   18: invokevirtual 201	com/tencent/wcdb/database/SQLiteDatabase:k	()Z
    //   21: ifne +7 -> 28
    //   24: aload_0
    //   25: monitorexit
    //   26: iconst_0
    //   27: ireturn
    //   28: aload_0
    //   29: getfield 82	com/tencent/wcdb/database/SQLiteCursor:g	Lcom/tencent/wcdb/CursorWindow;
    //   32: ifnull +10 -> 42
    //   35: aload_0
    //   36: getfield 82	com/tencent/wcdb/database/SQLiteCursor:g	Lcom/tencent/wcdb/CursorWindow;
    //   39: invokevirtual 202	com/tencent/wcdb/CursorWindow:b	()V
    //   42: aload_0
    //   43: iconst_m1
    //   44: putfield 192	com/tencent/wcdb/database/SQLiteCursor:b	I
    //   47: aload_0
    //   48: iconst_m1
    //   49: putfield 32	com/tencent/wcdb/database/SQLiteCursor:l	I
    //   52: aload_0
    //   53: getfield 34	com/tencent/wcdb/database/SQLiteCursor:k	Lcom/tencent/wcdb/database/SQLiteCursorDriver;
    //   56: aload_0
    //   57: invokeinterface 205 2 0
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_0
    //   65: invokespecial 207	com/tencent/wcdb/AbstractWindowedCursor:requery	()Z
    //   68: istore_1
    //   69: iload_1
    //   70: ireturn
    //   71: astore_2
    //   72: new 150	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   79: astore_3
    //   80: aload_3
    //   81: ldc 209
    //   83: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: pop
    //   87: aload_3
    //   88: aload_2
    //   89: invokevirtual 212	java/lang/IllegalStateException:getMessage	()Ljava/lang/String;
    //   92: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: ldc 159
    //   98: aload_3
    //   99: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: iconst_1
    //   103: anewarray 164	java/lang/Object
    //   106: dup
    //   107: iconst_0
    //   108: aload_2
    //   109: aastore
    //   110: invokestatic 214	com/tencent/wcdb/support/Log:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: iconst_0
    //   114: ireturn
    //   115: astore_2
    //   116: aload_0
    //   117: monitorexit
    //   118: aload_2
    //   119: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	SQLiteCursor
    //   68	2	1	bool	boolean
    //   71	38	2	localIllegalStateException	java.lang.IllegalStateException
    //   115	4	2	localObject	Object
    //   79	20	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   64	69	71	java/lang/IllegalStateException
    //   11	26	115	finally
    //   28	42	115	finally
    //   42	64	115	finally
    //   116	118	115	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteCursor
 * JD-Core Version:    0.7.0.1
 */