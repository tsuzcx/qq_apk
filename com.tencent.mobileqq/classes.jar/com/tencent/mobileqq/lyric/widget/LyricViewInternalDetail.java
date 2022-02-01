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
    this.v = this.jdField_b_of_type_Int;
  }
  
  private int c(int paramInt)
  {
    Lyric localLyric = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
    int m = 0;
    if ((localLyric != null) && (!this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a()))
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a();
      int j;
      if (this.jdField_b_of_type_Boolean)
      {
        i = this.q;
        j = this.r;
      }
      else
      {
        j = i - 1;
        i = 0;
      }
      int k = this.jdField_b_of_type_Int;
      k = this.c;
      k = i;
      while (k <= j)
      {
        i = ((Sentence)this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.get(k)).a();
        m += this.jdField_b_of_type_Int * i + this.jdField_d_of_type_Int * (i - 1) + this.c;
        i = m;
        if (this.jdField_f_of_type_Boolean)
        {
          i = m;
          if (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric != null)
          {
            i = m;
            if (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.a() == this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a())
            {
              i = ((Sentence)this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.get(k)).a();
              i = m + (this.jdField_b_of_type_Int * i + this.jdField_d_of_type_Int * (i - 1) + this.c);
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
    this.s = c(paramInt + this.v);
    postInvalidate();
    return this.s;
  }
  
  public void a()
  {
    int i1 = this.jdField_b_of_type_Int + this.c;
    int i = this.s;
    int j = i;
    if (this.jdField_b_of_type_Boolean) {
      j = i - this.q;
    }
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList;
    int m = localArrayList.size() - 1;
    boolean bool = this.jdField_b_of_type_Boolean;
    int n = 0;
    if (bool)
    {
      i = this.q;
      m = this.r;
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
      m = i + ((Sentence)localArrayList.get(k)).a();
      i = m;
      if (this.jdField_f_of_type_Boolean)
      {
        i = m;
        if (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric != null)
        {
          i = m;
          if (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList != null)
          {
            i = m;
            if (k < this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.size()) {
              if (k < 0) {
                i = m;
              } else {
                i = m + ((Sentence)this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.get(k)).a();
              }
            }
          }
        }
      }
      k += 1;
    }
    if (this.x >= 0)
    {
      this.u = (this.jdField_f_of_type_Int + i1 * (i + 1 - this.x) - this.c);
      return;
    }
    this.u = (this.jdField_f_of_type_Int + i1 * (i - this.w - this.x) - this.c);
  }
  
  protected void a(Canvas paramCanvas, int paramInt)
  {
    int n = this.jdField_b_of_type_Int + this.c;
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList;
    int m = localArrayList.size();
    int k = this.s;
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
      int i1 = paramInt + b();
      paramInt = this.jdField_f_of_type_Int;
      m -= 1;
      i = j;
      j = paramInt;
      if (this.jdField_b_of_type_Boolean)
      {
        i = this.q;
        m = this.r;
        j = paramInt;
      }
      while (i <= m)
      {
        Sentence localSentence = (Sentence)localArrayList.get(i);
        paramInt = Math.abs(i - k);
        if (paramInt == 0)
        {
          if ((this.g) && (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_Int == 2) && (this.jdField_i_of_type_Boolean))
          {
            a(localSentence, paramCanvas, i1, j);
            paramInt = localSentence.a();
          }
          else
          {
            a(localSentence, paramCanvas, i1, j, this.jdField_i_of_type_Boolean);
            paramInt = localSentence.a();
          }
          paramInt = j + paramInt * n;
          a(paramCanvas, i1, paramInt, true, i, null);
        }
        else if ((paramInt > 0) && (paramInt <= this.w))
        {
          a(localSentence, paramCanvas, i1, j, this.jdField_a_of_type_AndroidGraphicsPaint);
          paramInt = j + localSentence.a() * n;
          a(paramCanvas, i1, paramInt, false, i, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
        else
        {
          paramInt = j + localSentence.a() * n;
        }
        j = paramInt;
        if (this.jdField_f_of_type_Boolean)
        {
          j = paramInt;
          if (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric != null)
          {
            j = paramInt;
            if (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList != null)
            {
              j = paramInt;
              if (i < this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.size()) {
                if (i < 0) {
                  j = paramInt;
                } else {
                  j = paramInt + ((Sentence)this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.get(i)).a() * n;
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
    if ((this.jdField_f_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric != null) && (this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList != null))
    {
      paramPaint = this.jdField_b_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList;
      if (paramInt3 < paramPaint.size())
      {
        if (paramInt3 < 0) {
          return;
        }
        if ((paramBoolean) && (!this.jdField_d_of_type_Boolean))
        {
          a((Sentence)paramPaint.get(paramInt3), paramCanvas, paramInt1, paramInt2);
          return;
        }
        a((Sentence)paramPaint.get(paramInt3), paramCanvas, paramInt1, paramInt2, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_i_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showLyricPronounce:");
    localStringBuilder.append(paramBoolean);
    Log.d("LyricViewInternalDetail", localStringBuilder.toString());
    if (this.jdField_f_of_type_Boolean == paramBoolean) {
      return;
    }
    this.jdField_f_of_type_Boolean = paramBoolean;
    this.e = false;
    LyricContext.a().post(new LyricViewInternalDetail.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.lyric.widget.LyricViewInternalDetail
 * JD-Core Version:    0.7.0.1
 */