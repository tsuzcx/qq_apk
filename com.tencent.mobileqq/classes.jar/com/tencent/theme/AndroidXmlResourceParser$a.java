package com.tencent.theme;

final class AndroidXmlResourceParser$a
{
  private int[] a = new int[32];
  private int b;
  private int c;
  private int d;
  
  private final int a(int paramInt, boolean paramBoolean)
  {
    int i = this.b;
    if (i == 0) {
      return -1;
    }
    i -= 1;
    int j = this.d;
    while (j != 0)
    {
      int k = this.a[i];
      i -= 2;
      while (k != 0)
      {
        int[] arrayOfInt;
        if (paramBoolean)
        {
          arrayOfInt = this.a;
          if (arrayOfInt[i] == paramInt) {
            return arrayOfInt[(i + 1)];
          }
        }
        else
        {
          arrayOfInt = this.a;
          if (arrayOfInt[(i + 1)] == paramInt) {
            return arrayOfInt[i];
          }
        }
        i -= 2;
        k -= 1;
      }
      j -= 1;
    }
    return -1;
  }
  
  private final int b(int paramInt, boolean paramBoolean)
  {
    if (this.b != 0)
    {
      if (paramInt < 0) {
        return -1;
      }
      int i = 0;
      int k = this.d;
      int j = paramInt;
      paramInt = k;
      while (paramInt != 0)
      {
        k = this.a[i];
        if (j >= k)
        {
          j -= k;
          i += k * 2 + 2;
          paramInt -= 1;
        }
        else
        {
          i += j * 2 + 1;
          paramInt = i;
          if (!paramBoolean) {
            paramInt = i + 1;
          }
          return this.a[paramInt];
        }
      }
    }
    return -1;
  }
  
  private void f(int paramInt)
  {
    int[] arrayOfInt1 = this.a;
    int j = arrayOfInt1.length;
    int i = this.b;
    j -= i;
    if (j > paramInt) {
      return;
    }
    int[] arrayOfInt2 = new int[(arrayOfInt1.length + j) * 2];
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, i);
    this.a = arrayOfInt2;
  }
  
  public final int a(int paramInt)
  {
    int i = this.b;
    int k = 0;
    int j = 0;
    if (i != 0)
    {
      if (paramInt < 0) {
        return 0;
      }
      k = this.d;
      i = paramInt;
      if (paramInt > k) {
        i = k;
      }
      k = 0;
      paramInt = j;
      j = k;
      for (;;)
      {
        k = paramInt;
        if (i == 0) {
          break;
        }
        k = this.a[j];
        paramInt += k;
        j += k * 2 + 2;
        i -= 1;
      }
    }
    return k;
  }
  
  public final void a()
  {
    this.b = 0;
    this.c = 0;
    this.d = 0;
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (this.d == 0) {
      f();
    }
    f(2);
    int i = this.b;
    int j = i - 1;
    int[] arrayOfInt = this.a;
    int k = arrayOfInt[j];
    int m = k + 1;
    arrayOfInt[(j - 1 - k * 2)] = m;
    arrayOfInt[j] = paramInt1;
    arrayOfInt[(j + 1)] = paramInt2;
    arrayOfInt[(j + 2)] = m;
    this.b = (i + 2);
    this.c += 1;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final int b(int paramInt)
  {
    return b(paramInt, true);
  }
  
  public final boolean b(int paramInt1, int paramInt2)
  {
    int i = this.b;
    if (i == 0) {
      return false;
    }
    int k = i - 1;
    int m = this.a[k];
    i = k - 2;
    int j = 0;
    while (j != m)
    {
      int[] arrayOfInt = this.a;
      if ((arrayOfInt[i] == paramInt1) && (arrayOfInt[(i + 1)] == paramInt2))
      {
        paramInt1 = m - 1;
        if (j == 0)
        {
          arrayOfInt[i] = paramInt1;
          arrayOfInt[(i - (paramInt1 * 2 + 1))] = paramInt1;
        }
        else
        {
          arrayOfInt[k] = paramInt1;
          arrayOfInt[(k - (paramInt1 * 2 + 3))] = paramInt1;
          System.arraycopy(arrayOfInt, i + 2, arrayOfInt, i, this.b - i);
        }
        this.b -= 2;
        this.c -= 1;
        return true;
      }
      j += 1;
      i -= 2;
    }
    return false;
  }
  
  public final int c()
  {
    int i = this.b;
    if (i == 0) {
      return 0;
    }
    return this.a[(i - 1)];
  }
  
  public final int c(int paramInt)
  {
    return b(paramInt, false);
  }
  
  public final int d(int paramInt)
  {
    return a(paramInt, false);
  }
  
  public final boolean d()
  {
    int i = this.b;
    if (i == 0) {
      return false;
    }
    int j = i - 1;
    int[] arrayOfInt = this.a;
    int k = arrayOfInt[j];
    if (k == 0) {
      return false;
    }
    k -= 1;
    j -= 2;
    arrayOfInt[j] = k;
    arrayOfInt[(j - (k * 2 + 1))] = k;
    this.b = (i - 2);
    this.c -= 1;
    return true;
  }
  
  public final int e()
  {
    return this.d;
  }
  
  public final int e(int paramInt)
  {
    return a(paramInt, true);
  }
  
  public final void f()
  {
    f(2);
    int i = this.b;
    int[] arrayOfInt = this.a;
    arrayOfInt[i] = 0;
    arrayOfInt[(i + 1)] = 0;
    this.b = (i + 2);
    this.d += 1;
  }
  
  public final void g()
  {
    int i = this.b;
    if (i == 0) {
      return;
    }
    int j = i - 1;
    int k = this.a[j];
    int m = k * 2;
    if (j - 1 - m == 0) {
      return;
    }
    this.b = (i - (m + 2));
    this.c -= k;
    this.d -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.AndroidXmlResourceParser.a
 * JD-Core Version:    0.7.0.1
 */