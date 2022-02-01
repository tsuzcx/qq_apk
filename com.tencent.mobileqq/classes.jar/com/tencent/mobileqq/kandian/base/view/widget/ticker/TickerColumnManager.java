package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class TickerColumnManager
{
  final ArrayList<TickerColumn> a = new ArrayList();
  ArrayList<String> b = new ArrayList();
  boolean c = false;
  boolean d = false;
  private final TickerDrawMetrics e;
  private TickerCharacterList[] f;
  private Set<Character> g;
  
  TickerColumnManager(TickerDrawMetrics paramTickerDrawMetrics)
  {
    this.e = paramTickerDrawMetrics;
  }
  
  void a(float paramFloat)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((TickerColumn)this.a.get(i)).a(paramFloat, this.d);
      i += 1;
    }
  }
  
  void a(Canvas paramCanvas, Paint paramPaint)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      TickerColumn localTickerColumn = (TickerColumn)this.a.get(i);
      localTickerColumn.a(paramCanvas, paramPaint);
      paramCanvas.translate(localTickerColumn.c(), 0.0F);
      i += 1;
    }
  }
  
  void a(ArrayList<String> paramArrayList)
  {
    this.b = paramArrayList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  void a(char[] paramArrayOfChar)
  {
    if (this.f != null)
    {
      int i = 0;
      while (i < this.a.size()) {
        if (((TickerColumn)this.a.get(i)).c() > 0.0F) {
          i += 1;
        } else {
          this.a.remove(i);
        }
      }
      int[] arrayOfInt = LevenshteinUtils.a(e(), paramArrayOfChar, this.g);
      int n = 0;
      i = 0;
      int i1 = 1;
      int m = 1;
      int k;
      for (int j = 0; n < arrayOfInt.length; j = k)
      {
        k = arrayOfInt[n];
        int i4;
        int i2;
        int i3;
        if (k != 0) {
          if (k != 1) {
            if (k == 2)
            {
              ((TickerColumn)this.a.get(i)).a(i1, '\000', this.d);
              i4 = i + 1;
              i = i4;
              i2 = i1;
              i3 = m;
              k = j;
              if (!this.c) {
                break label458;
              }
              i = i4;
            }
          }
        }
        for (;;)
        {
          i2 = i1 + m;
          i3 = m + 1;
          k = j;
          break;
          paramArrayOfChar = new StringBuilder();
          paramArrayOfChar.append("Unknown action: ");
          paramArrayOfChar.append(arrayOfInt[n]);
          throw new IllegalArgumentException(paramArrayOfChar.toString());
          this.a.add(i, new TickerColumn(this.f, this.e));
          TickerColumn localTickerColumn = (TickerColumn)this.a.get(i);
          char[] arrayOfChar2 = null;
          ArrayList localArrayList = this.b;
          char[] arrayOfChar1 = arrayOfChar2;
          if (localArrayList != null)
          {
            arrayOfChar1 = arrayOfChar2;
            if (localArrayList.size() > n)
            {
              arrayOfChar2 = ((String)this.b.get(n)).toCharArray();
              arrayOfChar1 = arrayOfChar2;
              if (arrayOfChar2 != null)
              {
                k = arrayOfChar2.length;
                if (arrayOfChar2.length > 0) {
                  bool = true;
                } else {
                  bool = false;
                }
                k -= 1;
                arrayOfChar1 = arrayOfChar2;
                break label356;
              }
            }
          }
          boolean bool = false;
          k = 0;
          label356:
          localTickerColumn.a(i1, paramArrayOfChar[j], this.d, bool, arrayOfChar1, 0, k);
          i4 = i + 1;
          int i5 = j + 1;
          i = i4;
          i2 = i1;
          i3 = m;
          k = i5;
          if (!this.c) {
            break;
          }
          i = i4;
          j = i5;
          if (localTickerColumn.a() == localTickerColumn.b())
          {
            i = i4;
            i2 = i1;
            i3 = m;
            k = i5;
            if (i1 <= 1) {
              break;
            }
            i = i4;
            j = i5;
          }
        }
        label458:
        n += 1;
        i1 = i2;
        m = i3;
      }
      return;
    }
    paramArrayOfChar = new IllegalStateException("Need to call #setCharacterLists first.");
    for (;;)
    {
      throw paramArrayOfChar;
    }
  }
  
  void a(String... paramVarArgs)
  {
    this.f = new TickerCharacterList[paramVarArgs.length];
    int j = 0;
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.f[i] = new TickerCharacterList(paramVarArgs[i]);
      i += 1;
    }
    this.g = new HashSet();
    i = j;
    while (i < paramVarArgs.length)
    {
      this.g.addAll(this.f[i].a());
      i += 1;
    }
  }
  
  TickerCharacterList[] a()
  {
    return this.f;
  }
  
  void b()
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      ((TickerColumn)this.a.get(i)).e();
      i += 1;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  float c()
  {
    int j = this.a.size();
    float f1 = 0.0F;
    int i = 0;
    while (i < j)
    {
      f1 += ((TickerColumn)this.a.get(i)).d();
      i += 1;
    }
    return f1;
  }
  
  float d()
  {
    int j = this.a.size();
    float f1 = 0.0F;
    int i = 0;
    while (i < j)
    {
      f1 += ((TickerColumn)this.a.get(i)).c();
      i += 1;
    }
    return f1;
  }
  
  char[] e()
  {
    int j = this.a.size();
    char[] arrayOfChar = new char[j];
    int i = 0;
    while (i < j)
    {
      arrayOfChar[i] = ((TickerColumn)this.a.get(i)).a();
      i += 1;
    }
    return arrayOfChar;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerColumnManager
 * JD-Core Version:    0.7.0.1
 */