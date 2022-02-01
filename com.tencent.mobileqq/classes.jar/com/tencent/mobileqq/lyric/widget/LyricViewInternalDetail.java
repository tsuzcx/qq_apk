package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import com.tencent.mobileqq.lyric.util.LyricContext;
import java.util.ArrayList;

public class LyricViewInternalDetail
  extends LyricViewInternal
{
  public LyricViewInternalDetail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.U = this.b;
  }
  
  private int d(int paramInt)
  {
    Lyric localLyric = this.t;
    int m = 0;
    if ((localLyric != null) && (!this.t.f()))
    {
      int i = this.t.b();
      int j;
      if (this.H)
      {
        i = this.K;
        j = this.L;
      }
      else
      {
        j = i - 1;
        i = 0;
      }
      int k = this.b;
      k = this.c;
      k = i;
      while (k <= j)
      {
        i = ((Sentence)this.t.b.get(k)).b();
        m += this.b * i + this.d * (i - 1) + this.c;
        i = m;
        if (this.V)
        {
          i = m;
          if (this.u != null)
          {
            i = m;
            if (this.u.b() == this.t.b())
            {
              i = ((Sentence)this.u.b.get(k)).b();
              i = m + (this.b * i + this.d * (i - 1) + this.c);
            }
          }
        }
        if (paramInt < i) {
          return k;
        }
        k += 1;
        m = i;
      }
      return j;
    }
    Log.e("LyricViewInternalDetail", "computeHilightWhileScrolling -> mLineLyric == null");
    return 0;
  }
  
  public int a(int paramInt)
  {
    super.a(paramInt);
    this.M = d(paramInt + this.U);
    postInvalidate();
    return this.M;
  }
  
  public void a()
  {
    int i1 = this.b + this.c;
    int i = this.M;
    int j = i;
    if (this.H) {
      j = i - this.K;
    }
    ArrayList localArrayList = this.t.b;
    int m = localArrayList.size() - 1;
    boolean bool = this.H;
    int n = 0;
    if (bool)
    {
      i = this.K;
      m = this.L;
    }
    else
    {
      i = 0;
    }
    int k = i;
    i = n;
    if (j > m) {
      return;
    }
    while (k < j)
    {
      m = i + ((Sentence)localArrayList.get(k)).b();
      i = m;
      if (this.V)
      {
        i = m;
        if (this.u != null)
        {
          i = m;
          if (this.u.b != null)
          {
            i = m;
            if (k < this.u.b.size()) {
              if (k < 0) {
                i = m;
              } else {
                i = m + ((Sentence)this.u.b.get(k)).b();
              }
            }
          }
        }
      }
      k += 1;
    }
    if (this.ac >= 0)
    {
      this.O = (this.f + i1 * (i + 1 - this.ac) - this.c);
      return;
    }
    this.O = (this.f + i1 * (i - this.ab - this.ac) - this.c);
  }
  
  protected void a(Canvas paramCanvas, int paramInt)
  {
    int n = this.b + this.c;
    ArrayList localArrayList = this.t.b;
    int m = localArrayList.size();
    int k = this.M;
    int j = 0;
    int i = k;
    if (k < 0) {
      i = 0;
    }
    k = i;
    if (i >= m) {
      k = m - 1;
    }
    if (!localArrayList.isEmpty())
    {
      int i1 = paramInt + getAdJust();
      paramInt = this.f;
      m -= 1;
      i = j;
      j = paramInt;
      if (this.H)
      {
        i = this.K;
        m = this.L;
        j = paramInt;
      }
      while (i <= m)
      {
        Sentence localSentence = (Sentence)localArrayList.get(i);
        paramInt = Math.abs(i - k);
        if (paramInt == 0)
        {
          if ((this.W) && (this.t.a == 2) && (this.aa))
          {
            a(localSentence, paramCanvas, i1, j);
            paramInt = localSentence.b();
          }
          else
          {
            a(localSentence, paramCanvas, i1, j, this.aa);
            paramInt = localSentence.b();
          }
          paramInt = j + paramInt * n;
          a(paramCanvas, i1, paramInt, true, i, null);
        }
        else if ((paramInt > 0) && (paramInt <= this.ab))
        {
          a(localSentence, paramCanvas, i1, j, this.i);
          paramInt = j + localSentence.b() * n;
          a(paramCanvas, i1, paramInt, false, i, this.i);
        }
        else
        {
          paramInt = j + localSentence.b() * n;
        }
        j = paramInt;
        if (this.V)
        {
          j = paramInt;
          if (this.u != null)
          {
            j = paramInt;
            if (this.u.b != null)
            {
              j = paramInt;
              if (i < this.u.b.size()) {
                if (i < 0) {
                  j = paramInt;
                } else {
                  j = paramInt + ((Sentence)this.u.b.get(i)).b() * n;
                }
              }
            }
          }
        }
        i += 1;
      }
    }
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, Paint paramPaint)
  {
    if ((this.V) && (this.u != null) && (this.u.b != null))
    {
      paramPaint = this.u.b;
      if (paramInt3 < paramPaint.size())
      {
        if (paramInt3 < 0) {
          return;
        }
        if ((paramBoolean) && (!this.S))
        {
          a((Sentence)paramPaint.get(paramInt3), paramCanvas, paramInt1, paramInt2);
          return;
        }
        a((Sentence)paramPaint.get(paramInt3), paramCanvas, paramInt1, paramInt2, this.i, this.q);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showLyricPronounce:");
    localStringBuilder.append(paramBoolean);
    Log.d("LyricViewInternalDetail", localStringBuilder.toString());
    if (this.V == paramBoolean) {
      return;
    }
    this.V = paramBoolean;
    this.T = false;
    LyricContext.b().post(new LyricViewInternalDetail.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewInternalDetail
 * JD-Core Version:    0.7.0.1
 */