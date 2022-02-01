package com.tencent.wcdb;

import java.util.Iterator;

public final class CursorJoiner
  implements Iterable<CursorJoiner.Result>, Iterator<CursorJoiner.Result>
{
  private Cursor a;
  private Cursor b;
  private boolean c;
  private CursorJoiner.Result d;
  private int[] e;
  private int[] f;
  private String[] g;
  
  private static int a(String... paramVarArgs)
  {
    if (paramVarArgs.length % 2 == 0)
    {
      int i = 0;
      while (i < paramVarArgs.length)
      {
        if (paramVarArgs[i] == null)
        {
          if (paramVarArgs[(i + 1)] != null) {
            return -1;
          }
        }
        else
        {
          int j = i + 1;
          if (paramVarArgs[j] == null) {
            return 1;
          }
          j = paramVarArgs[i].compareTo(paramVarArgs[j]);
          if (j != 0)
          {
            if (j < 0) {
              return -1;
            }
            return 1;
          }
        }
        i += 2;
      }
      return 0;
    }
    paramVarArgs = new IllegalArgumentException("you must specify an even number of values");
    for (;;)
    {
      throw paramVarArgs;
    }
  }
  
  private static void a(String[] paramArrayOfString, Cursor paramCursor, int[] paramArrayOfInt, int paramInt)
  {
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      paramArrayOfString[(i * 2 + paramInt)] = paramCursor.getString(paramArrayOfInt[i]);
      i += 1;
    }
  }
  
  private void b()
  {
    if (this.c)
    {
      int i = CursorJoiner.1.a[this.d.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            this.b.moveToNext();
          }
        }
        else {
          this.a.moveToNext();
        }
      }
      else
      {
        this.a.moveToNext();
        this.b.moveToNext();
      }
      this.c = false;
    }
  }
  
  public CursorJoiner.Result a()
  {
    if (hasNext())
    {
      b();
      boolean bool1 = this.a.isAfterLast() ^ true;
      boolean bool2 = this.b.isAfterLast();
      int i;
      if ((bool1) && ((bool2 ^ true)))
      {
        a(this.g, this.a, this.e, 0);
        a(this.g, this.b, this.f, 1);
        i = a(this.g);
        if (i != -1)
        {
          if (i != 0)
          {
            if (i == 1) {
              this.d = CursorJoiner.Result.RIGHT;
            }
          }
          else {
            this.d = CursorJoiner.Result.BOTH;
          }
        }
        else {
          this.d = CursorJoiner.Result.LEFT;
        }
      }
      else if (i != 0)
      {
        this.d = CursorJoiner.Result.LEFT;
      }
      else
      {
        this.d = CursorJoiner.Result.RIGHT;
      }
      this.c = true;
      return this.d;
    }
    throw new IllegalStateException("you must only call next() when hasNext() is true");
  }
  
  public boolean hasNext()
  {
    boolean bool5 = this.c;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool1 = false;
    if (bool5)
    {
      int i = CursorJoiner.1.a[this.d.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            if ((!this.a.isAfterLast()) || (!this.b.isLast())) {
              bool1 = true;
            }
            return bool1;
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("bad value for mCompareResult, ");
          localStringBuilder.append(this.d);
          throw new IllegalStateException(localStringBuilder.toString());
        }
        if (this.a.isLast())
        {
          bool1 = bool2;
          if (this.b.isAfterLast()) {}
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      if (this.a.isLast())
      {
        bool1 = bool3;
        if (this.b.isLast()) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    if (this.a.isAfterLast())
    {
      bool1 = bool4;
      if (this.b.isAfterLast()) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public Iterator<CursorJoiner.Result> iterator()
  {
    return this;
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("not implemented");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.wcdb.CursorJoiner
 * JD-Core Version:    0.7.0.1
 */