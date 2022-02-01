package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import androidx.annotation.NonNull;

public class NotifyData
{
  private int a = 0;
  private int b = 1000;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private float f = 0.0F;
  private float g = 0.0F;
  private float h = 0.0F;
  private float i = 0.0F;
  
  public NotifyData(float paramFloat1, float paramFloat2)
  {
    this.h = paramFloat1;
    this.i = paramFloat2;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(float paramFloat)
  {
    this.g = paramFloat;
    f();
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public void c(int paramInt)
  {
    this.c = paramInt;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public void d(int paramInt)
  {
    this.e = paramInt;
  }
  
  public int e()
  {
    return this.e;
  }
  
  public void f()
  {
    float f1 = this.g;
    float f2 = this.f;
    int j;
    if (f1 == f2)
    {
      if (f1 == this.h) {
        j = 1;
      } else {
        j = 3;
      }
      this.d = j;
      return;
    }
    if (f1 > f2) {
      j = 2;
    } else {
      j = 4;
    }
    this.d = j;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("mCurMoveState = ");
    localStringBuilder2.append(this.a);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mCurMoveProgress = ");
    localStringBuilder2.append(this.b);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mCurMoveDirection = ");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mFromToEndDirType = ");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mTriggerMovementSourceType = ");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mOriginTranslationX = ");
    localStringBuilder2.append(this.f);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mEndTranslationX = ");
    localStringBuilder2.append(this.g);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mMinTranslationX");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append(" mMaxTranlsationX");
    localStringBuilder2.append(this.i);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.NotifyData
 * JD-Core Version:    0.7.0.1
 */