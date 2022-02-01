package com.tencent.wcdb.database;

import java.io.Closeable;

public abstract class SQLiteClosable
  implements Closeable
{
  private int a = 1;
  
  public void close()
  {
    i();
  }
  
  protected abstract void g();
  
  public void h()
  {
    try
    {
      if (this.a > 0)
      {
        this.a += 1;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("attempt to re-open an already-closed object: ");
      localStringBuilder.append(this);
      throw new IllegalStateException(localStringBuilder.toString());
    }
    finally {}
  }
  
  public void i()
  {
    for (;;)
    {
      try
      {
        int j = this.a;
        i = 1;
        j -= 1;
        this.a = j;
        if (j == 0)
        {
          if (i != 0) {
            g();
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteClosable
 * JD-Core Version:    0.7.0.1
 */