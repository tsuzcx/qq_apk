package com.tencent.theme;

final class AndroidXmlResourceParser$a
{
  private int[] a = new int[32];
  private int b;
  private int c;
  private int d;
  
  private final int a(int paramInt, boolean paramBoolean)
  {
    if (this.b == 0) {}
    for (;;)
    {
      return -1;
      int i = this.b - 1;
      int j = this.d;
      while (j != 0)
      {
        int k = this.a[i];
        i -= 2;
        while (k != 0)
        {
          if (paramBoolean)
          {
            if (this.a[i] == paramInt) {
              return this.a[(i + 1)];
            }
          }
          else if (this.a[(i + 1)] == paramInt) {
            return this.a[i];
          }
          i -= 2;
          k -= 1;
        }
        j -= 1;
      }
    }
  }
  
  private final int b(int paramInt, boolean paramBoolean)
  {
    if ((this.b == 0) || (paramInt < 0)) {}
    int j;
    for (;;)
    {
      return -1;
      i = 0;
      int k = this.d;
      j = paramInt;
      paramInt = k;
      while (paramInt != 0)
      {
        k = this.a[i];
        if (j < k) {
          break label69;
        }
        j -= k;
        i += k * 2 + 2;
        paramInt -= 1;
      }
    }
    label69:
    int i = j * 2 + 1 + i;
    paramInt = i;
    if (!paramBoolean) {
      paramInt = i + 1;
    }
    return this.a[paramInt];
  }
  
  private void f(int paramInt)
  {
    int i = this.a.length - this.b;
    if (i > paramInt) {
      return;
    }
    int[] arrayOfInt = new int[(i + this.a.length) * 2];
    System.arraycopy(this.a, 0, arrayOfInt, 0, this.b);
    this.a = arrayOfInt;
  }
  
  public final int a(int paramInt)
  {
    int m = 0;
    int j = 0;
    int i = j;
    if (this.b != 0)
    {
      if (paramInt < 0) {
        i = j;
      }
    }
    else {
      return i;
    }
    i = paramInt;
    if (paramInt > this.d) {
      i = this.d;
    }
    j = 0;
    int k = i;
    paramInt = m;
    for (;;)
    {
      i = paramInt;
      if (k == 0) {
        break;
      }
      i = this.a[j];
      k -= 1;
      j = i * 2 + 2 + j;
      paramInt += i;
    }
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
    int i = this.b - 1;
    int j = this.a[i];
    this.a[(i - 1 - j * 2)] = (j + 1);
    this.a[i] = paramInt1;
    this.a[(i + 1)] = paramInt2;
    this.a[(i + 2)] = (j + 1);
    this.b += 2;
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
    if (this.b == 0) {}
    int k;
    int m;
    int i;
    int j;
    for (;;)
    {
      return false;
      k = this.b - 1;
      m = this.a[k];
      i = k - 2;
      j = 0;
      while (j != m)
      {
        if ((this.a[i] == paramInt1) && (this.a[(i + 1)] == paramInt2)) {
          break label76;
        }
        j += 1;
        i -= 2;
      }
    }
    label76:
    paramInt1 = m - 1;
    if (j == 0)
    {
      this.a[i] = paramInt1;
      this.a[(i - (paramInt1 * 2 + 1))] = paramInt1;
    }
    for (;;)
    {
      this.b -= 2;
      this.c -= 1;
      return true;
      this.a[k] = paramInt1;
      this.a[(k - (paramInt1 * 2 + 3))] = paramInt1;
      System.arraycopy(this.a, i + 2, this.a, i, this.b - i);
    }
  }
  
  public final int c()
  {
    if (this.b == 0) {
      return 0;
    }
    int i = this.b;
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
    if (this.b == 0) {}
    int i;
    int j;
    do
    {
      return false;
      i = this.b - 1;
      j = this.a[i];
    } while (j == 0);
    j -= 1;
    i -= 2;
    this.a[i] = j;
    this.a[(i - (j * 2 + 1))] = j;
    this.b -= 2;
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
    this.a[i] = 0;
    this.a[(i + 1)] = 0;
    this.b += 2;
    this.d += 1;
  }
  
  public final void g()
  {
    if (this.b == 0) {}
    int i;
    int j;
    do
    {
      return;
      i = this.b - 1;
      j = this.a[i];
    } while (i - 1 - j * 2 == 0);
    this.b -= j * 2 + 2;
    this.c -= j;
    this.d -= 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.AndroidXmlResourceParser.a
 * JD-Core Version:    0.7.0.1
 */