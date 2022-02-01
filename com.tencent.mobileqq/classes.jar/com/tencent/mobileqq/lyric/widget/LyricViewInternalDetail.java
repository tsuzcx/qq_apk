package com.tencent.mobileqq.lyric.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import awpy;
import awqa;
import awqd;
import java.util.ArrayList;

public class LyricViewInternalDetail
  extends LyricViewInternal
{
  public LyricViewInternalDetail(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.u = this.jdField_b_of_type_Int;
  }
  
  private int c(int paramInt)
  {
    int m;
    if ((this.jdField_a_of_type_Awpy == null) || (this.jdField_a_of_type_Awpy.a()))
    {
      Log.e("LyricViewInternalDetail", "computeHilightWhileScrolling -> mLineLyric == null");
      m = 0;
      return m;
    }
    int i = this.jdField_a_of_type_Awpy.a();
    int j;
    if (this.jdField_b_of_type_Boolean)
    {
      j = this.p;
      i = this.q;
    }
    for (;;)
    {
      int k = this.jdField_b_of_type_Int;
      k = this.c;
      m = 0;
      k = j;
      j = m;
      m = i;
      if (k > i) {
        break;
      }
      m = ((awqa)this.jdField_a_of_type_Awpy.jdField_a_of_type_JavaUtilArrayList.get(k)).a();
      int n = this.jdField_b_of_type_Int;
      j += (m - 1) * this.jdField_d_of_type_Int + n * m + this.c;
      if ((this.jdField_f_of_type_Boolean) && (this.jdField_b_of_type_Awpy != null) && (this.jdField_b_of_type_Awpy.a() == this.jdField_a_of_type_Awpy.a()))
      {
        m = ((awqa)this.jdField_b_of_type_Awpy.jdField_a_of_type_JavaUtilArrayList.get(k)).a();
        n = this.jdField_b_of_type_Int;
        j = (m - 1) * this.jdField_d_of_type_Int + n * m + this.c + j;
      }
      for (;;)
      {
        if (paramInt < j) {
          return k;
        }
        k += 1;
        break;
      }
      i -= 1;
      j = 0;
    }
  }
  
  public int a(int paramInt)
  {
    super.a(paramInt);
    this.r = c(this.u + paramInt);
    postInvalidate();
    return this.r;
  }
  
  public void a()
  {
    int m = 0;
    int n = this.jdField_b_of_type_Int + this.c;
    int j = this.r;
    if (this.jdField_b_of_type_Boolean) {
      j -= this.p;
    }
    for (;;)
    {
      ArrayList localArrayList = this.jdField_a_of_type_Awpy.jdField_a_of_type_JavaUtilArrayList;
      int i = localArrayList.size();
      int k;
      if (this.jdField_b_of_type_Boolean)
      {
        i = this.p;
        k = this.q;
      }
      for (;;)
      {
        if (j > k) {
          return;
        }
        k = i;
        i = m;
        if (k < j)
        {
          i += ((awqa)localArrayList.get(k)).a();
          if ((!this.jdField_f_of_type_Boolean) || (this.jdField_b_of_type_Awpy == null) || (this.jdField_b_of_type_Awpy.jdField_a_of_type_JavaUtilArrayList == null) || (k >= this.jdField_b_of_type_Awpy.jdField_a_of_type_JavaUtilArrayList.size())) {
            break label230;
          }
          if (k >= 0) {}
        }
        label230:
        for (;;)
        {
          k += 1;
          break;
          i = ((awqa)this.jdField_b_of_type_Awpy.jdField_a_of_type_JavaUtilArrayList.get(k)).a() + i;
          continue;
          if (this.w >= 0)
          {
            this.t = (this.jdField_f_of_type_Int + (i + 1 - this.w) * n - this.c);
            return;
          }
          this.t = (this.jdField_f_of_type_Int + (i - this.v - this.w) * n - this.c);
          return;
        }
        k = i - 1;
        i = 0;
      }
    }
  }
  
  protected void a(Canvas paramCanvas, int paramInt)
  {
    int n = this.jdField_b_of_type_Int + this.c;
    ArrayList localArrayList = this.jdField_a_of_type_Awpy.jdField_a_of_type_JavaUtilArrayList;
    int k = localArrayList.size();
    int j = this.r;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    int i1;
    if (i >= k)
    {
      j = k - 1;
      if (localArrayList.isEmpty()) {
        break label380;
      }
      i1 = paramInt + b();
      i = this.jdField_f_of_type_Int;
      if (!this.jdField_b_of_type_Boolean) {
        break label381;
      }
      paramInt = this.p;
      k = this.q;
    }
    for (;;)
    {
      int m = paramInt;
      label97:
      if (m <= k)
      {
        awqa localawqa = (awqa)localArrayList.get(m);
        paramInt = Math.abs(m - j);
        if (paramInt == 0) {
          if ((this.g) && (this.jdField_a_of_type_Awpy.jdField_a_of_type_Int == 2) && (this.jdField_i_of_type_Boolean))
          {
            a(localawqa, paramCanvas, i1, i);
            paramInt = i + localawqa.a() * n;
            a(paramCanvas, i1, paramInt, true, m, null);
            i = paramInt;
            if (this.jdField_f_of_type_Boolean)
            {
              i = paramInt;
              if (this.jdField_b_of_type_Awpy != null)
              {
                i = paramInt;
                if (this.jdField_b_of_type_Awpy.jdField_a_of_type_JavaUtilArrayList != null)
                {
                  i = paramInt;
                  if (m < this.jdField_b_of_type_Awpy.jdField_a_of_type_JavaUtilArrayList.size()) {
                    if (m >= 0) {
                      break label353;
                    }
                  }
                }
              }
            }
          }
        }
        for (i = paramInt;; i = paramInt + ((awqa)this.jdField_b_of_type_Awpy.jdField_a_of_type_JavaUtilArrayList.get(m)).a() * n)
        {
          m += 1;
          break label97;
          j = i;
          break;
          a(localawqa, paramCanvas, i1, i, this.jdField_i_of_type_Boolean);
          paramInt = i + localawqa.a() * n;
          break label175;
          if ((paramInt > 0) && (paramInt <= this.v))
          {
            a(localawqa, paramCanvas, i1, i, this.jdField_a_of_type_AndroidGraphicsPaint);
            paramInt = i + localawqa.a() * n;
            a(paramCanvas, i1, paramInt, false, m, this.jdField_a_of_type_AndroidGraphicsPaint);
            break label187;
          }
          paramInt = i + localawqa.a() * n;
          break label187;
        }
      }
      label175:
      label187:
      label353:
      label380:
      return;
      label381:
      k -= 1;
      paramInt = 0;
    }
  }
  
  protected void a(Canvas paramCanvas, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, Paint paramPaint)
  {
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_b_of_type_Awpy != null) && (this.jdField_b_of_type_Awpy.jdField_a_of_type_JavaUtilArrayList != null))
    {
      paramPaint = this.jdField_b_of_type_Awpy.jdField_a_of_type_JavaUtilArrayList;
      if ((paramInt3 < paramPaint.size()) && (paramInt3 >= 0)) {}
    }
    else
    {
      return;
    }
    if ((paramBoolean) && (!this.jdField_d_of_type_Boolean))
    {
      a((awqa)paramPaint.get(paramInt3), paramCanvas, paramInt1, paramInt2);
      return;
    }
    a((awqa)paramPaint.get(paramInt3), paramCanvas, paramInt1, paramInt2, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_i_of_type_AndroidGraphicsPaint);
  }
  
  public void a(boolean paramBoolean)
  {
    Log.d("LyricViewInternalDetail", "showLyricPronounce:" + paramBoolean);
    if (this.jdField_f_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_f_of_type_Boolean = paramBoolean;
    this.e = false;
    awqd.a().post(new LyricViewInternalDetail.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewInternalDetail
 * JD-Core Version:    0.7.0.1
 */