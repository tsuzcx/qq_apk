package com.tencent.theme;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.LongSparseArray;

@TargetApi(16)
public class f
  extends LongSparseArray<Drawable.ConstantState>
{
  private int a;
  private e b;
  private int c = 0;
  
  public f(int paramInt, e parame)
  {
    this.a = paramInt;
    this.b = parame;
  }
  
  public Drawable.ConstantState a(int paramInt)
  {
    this.c += 1;
    int i = this.c;
    Drawable.ConstantState localConstantState = null;
    if (i > 100)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parentFunction:");
      localStringBuilder.append(this);
      localStringBuilder.append(", childFunction=");
      localStringBuilder.append(this.b.b[this.a]);
      h.d("SkinEngine", 2, localStringBuilder.toString(), null);
    }
    else
    {
      localConstantState = (Drawable.ConstantState)this.b.b[this.a].valueAt(paramInt);
    }
    this.c -= 1;
    return localConstantState;
  }
  
  public Drawable.ConstantState a(long paramLong)
  {
    return this.b.a(this.a, paramLong);
  }
  
  public void a(long paramLong, Drawable.ConstantState paramConstantState)
  {
    this.b.b[this.a].put(paramLong, paramConstantState);
  }
  
  public int size()
  {
    return this.b.b[this.a].size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.theme.f
 * JD-Core Version:    0.7.0.1
 */