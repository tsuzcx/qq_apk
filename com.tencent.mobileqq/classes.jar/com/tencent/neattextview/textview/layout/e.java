package com.tencent.neattextview.textview.layout;

import android.text.Spanned;
import java.lang.reflect.Array;

public class e<E>
{
  public int a;
  public E[] b;
  public int[] c;
  public int[] d;
  public int[] e;
  private final Class<? extends E> f;
  
  e(Class<? extends E> paramClass)
  {
    this.f = paramClass;
    this.a = 0;
  }
  
  public E a(int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < this.a)
    {
      if ((this.c[i] < paramInt2) && (this.d[i] > paramInt1)) {
        return this.b[i];
      }
      i += 1;
    }
    return null;
  }
  
  public void a(Spanned paramSpanned, int paramInt1, int paramInt2)
  {
    Object[] arrayOfObject1 = paramSpanned.getSpans(paramInt1, paramInt2, this.f);
    paramInt2 = arrayOfObject1.length;
    Object localObject;
    if (paramInt2 > 0)
    {
      localObject = this.b;
      if ((localObject == null) || (localObject.length < paramInt2))
      {
        this.b = ((Object[])Array.newInstance(this.f, paramInt2));
        this.c = new int[paramInt2];
        this.d = new int[paramInt2];
        this.e = new int[paramInt2];
      }
    }
    paramInt1 = 0;
    this.a = 0;
    while (paramInt1 < paramInt2)
    {
      localObject = arrayOfObject1[paramInt1];
      int i = paramSpanned.getSpanStart(localObject);
      int j = paramSpanned.getSpanEnd(localObject);
      if (i != j)
      {
        int k = paramSpanned.getSpanFlags(localObject);
        Object[] arrayOfObject2 = this.b;
        int m = this.a;
        arrayOfObject2[m] = localObject;
        this.c[m] = i;
        this.d[m] = j;
        this.e[m] = k;
        this.a = (m + 1);
      }
      paramInt1 += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.neattextview.textview.layout.e
 * JD-Core Version:    0.7.0.1
 */