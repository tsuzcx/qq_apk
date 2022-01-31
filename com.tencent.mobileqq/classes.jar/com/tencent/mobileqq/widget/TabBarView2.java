package com.tencent.mobileqq.widget;

import aekt;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import azib;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;

public class TabBarView2
  extends TabBarView
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842901, 16842904 };
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private Paint c;
  private int p = 16;
  private int q = 16;
  private int r = -16776961;
  private int s = 25;
  private int t = 9;
  private int u = 15;
  
  public TabBarView2(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabBarView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_Int = aekt.a(56.0F, getResources());
    this.m = 16;
    boolean bool1 = ThemeUtil.isNowThemeIsDefaultCache(BaseApplicationImpl.getApplication().getRuntime(), true);
    int k = this.s;
    boolean bool2 = ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null);
    int i;
    int j;
    if (azib.a()) {
      if (bool2)
      {
        i = 2131166373;
        k = 2131166979;
        int n = 255;
        j = i;
        i = k;
        k = n;
      }
    }
    for (;;)
    {
      this.f = getResources().getColor(i);
      this.e = getResources().getColor(m);
      this.r = getResources().getColor(j);
      DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
      this.t = ((int)TypedValue.applyDimension(1, this.t, localDisplayMetrics));
      this.u = ((int)TypedValue.applyDimension(1, this.u, localDisplayMetrics));
      this.p = ((int)TypedValue.applyDimension(1, this.p, localDisplayMetrics));
      this.q = ((int)TypedValue.applyDimension(1, this.q, localDisplayMetrics));
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt);
      this.r = paramContext.getColor(2, this.r);
      this.s = paramContext.getInt(1, this.s);
      this.p = paramContext.getDimensionPixelSize(5, this.p);
      this.q = paramContext.getDimensionPixelSize(6, this.q);
      this.t = paramContext.getDimensionPixelSize(4, this.t);
      this.u = paramContext.getDimensionPixelSize(3, this.u);
      paramContext.recycle();
      if (("1103".equals(ThemeUtil.curThemeId)) || (azib.a()))
      {
        this.r = getResources().getColor(j);
        this.s = k;
      }
      b();
      return;
      i = 2131166372;
      break;
      if (bool2)
      {
        m = 2131165543;
        i = 2131165542;
        j = 2131165541;
        k = 30;
      }
      else if (!bool1)
      {
        i = 2131166979;
        j = 2131166908;
      }
      else
      {
        m = 2131165544;
        i = 2131166979;
        j = 2131165544;
      }
    }
  }
  
  private void b()
  {
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  }
  
  protected void a(Canvas paramCanvas)
  {
    View localView1 = getChildAt(this.o);
    int i;
    int m;
    int j;
    int k;
    int n;
    int i1;
    if (localView1 != null)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.r);
      this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha(this.s);
      View localView2 = (View)this.jdField_a_of_type_JavaUtilList.get(this.o);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.m * getContext().getResources().getDisplayMetrics().density + 0.5F);
      String str = (String)this.jdField_c_of_type_JavaUtilList.get(this.o);
      this.jdField_b_of_type_AndroidGraphicsPaint.getTextBounds(str, 0, str.length(), this.jdField_a_of_type_AndroidGraphicsRect);
      float f1 = this.jdField_a_of_type_AndroidGraphicsRect.width();
      float f2 = this.jdField_a_of_type_AndroidGraphicsRect.height();
      i = localView1.getRight();
      m = localView1.getLeft();
      j = localView1.getBottom();
      k = localView1.getTop();
      n = (int)((i - m - f1) / 2.0F);
      i = (int)(f1 + n);
      k = (int)((j - k - f2) / 2.0F);
      m = (int)(f2 + k);
      if (localView2 != null)
      {
        j = localView1.getLeft() + n;
        i += localView1.getLeft();
        n = localView1.getTop();
        i1 = localView1.getTop();
        if (this.jdField_a_of_type_Float <= 0.0F) {
          break label460;
        }
        localView1 = getChildAt(this.n);
        if (localView1 == null) {
          break label460;
        }
        f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(((String)this.jdField_c_of_type_JavaUtilList.get(this.n)).toString());
        int i3 = (int)((localView1.getRight() - localView1.getLeft() - f1) / 2.0F);
        int i2 = (int)(f1 + i3);
        f1 = j;
        f2 = this.jdField_a_of_type_Float;
        j = (int)((i3 + localView1.getLeft() - this.d - j) * f2 + f1);
        f1 = i;
        f2 = this.jdField_a_of_type_Float;
        i = (int)((i2 + localView1.getLeft() + this.d - i) * f2 + f1);
      }
    }
    label460:
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(j - this.u, n + k - this.t, i + this.u, i1 + m + this.t);
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.p, this.q, this.jdField_c_of_type_AndroidGraphicsPaint);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView2
 * JD-Core Version:    0.7.0.1
 */