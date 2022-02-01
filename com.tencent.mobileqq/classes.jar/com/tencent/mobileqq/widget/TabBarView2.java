package com.tencent.mobileqq.widget;

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
import com.tencent.mobileqq.qqui.R.styleable;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
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
    this.jdField_b_of_type_Int = ViewUtils.a(56.0F);
    this.m = 16;
    boolean bool1 = QQTheme.e();
    int j = this.s;
    boolean bool2 = QQTheme.a();
    boolean bool3 = QQTheme.f();
    int k = 2131165574;
    int m = 2131167142;
    if (bool3)
    {
      if (bool2) {
        i = 2131166499;
      } else {
        i = 2131166498;
      }
      j = 255;
    }
    else
    {
      if (bool2)
      {
        k = 2131165573;
        m = 2131165572;
        i = 2131165571;
        j = 30;
        break label165;
      }
      if (bool1) {
        break label162;
      }
      i = 2131167063;
    }
    k = 2131167063;
    break label165;
    label162:
    int i = 2131165574;
    label165:
    this.f = getResources().getColor(m);
    this.e = getResources().getColor(k);
    this.r = getResources().getColor(i);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.t = ((int)TypedValue.applyDimension(1, this.t, localDisplayMetrics));
    this.u = ((int)TypedValue.applyDimension(1, this.u, localDisplayMetrics));
    this.p = ((int)TypedValue.applyDimension(1, this.p, localDisplayMetrics));
    this.q = ((int)TypedValue.applyDimension(1, this.q, localDisplayMetrics));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, jdField_a_of_type_ArrayOfInt);
    this.r = paramContext.getColor(R.styleable.bo, this.r);
    this.s = paramContext.getInt(R.styleable.bn, this.s);
    this.p = paramContext.getDimensionPixelSize(R.styleable.br, this.p);
    this.q = paramContext.getDimensionPixelSize(R.styleable.bs, this.q);
    this.t = paramContext.getDimensionPixelSize(R.styleable.bq, this.t);
    this.u = paramContext.getDimensionPixelSize(R.styleable.bp, this.u);
    paramContext.recycle();
    if (("1103".equals(QQTheme.a())) || (QQTheme.f()))
    {
      this.r = getResources().getColor(i);
      this.s = j;
    }
    b();
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
    Object localObject = getChildAt(this.o);
    if (localObject != null)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.r);
      this.jdField_c_of_type_AndroidGraphicsPaint.setAlpha(this.s);
      View localView = (View)this.jdField_a_of_type_JavaUtilList.get(this.o);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.m * getContext().getResources().getDisplayMetrics().density + 0.5F);
      String str = (String)this.jdField_c_of_type_JavaUtilList.get(this.o);
      this.jdField_b_of_type_AndroidGraphicsPaint.getTextBounds(str, 0, str.length(), this.jdField_a_of_type_AndroidGraphicsRect);
      float f1 = this.jdField_a_of_type_AndroidGraphicsRect.width();
      float f2 = this.jdField_a_of_type_AndroidGraphicsRect.height();
      int i = ((View)localObject).getRight();
      int m = ((View)localObject).getLeft();
      int j = ((View)localObject).getBottom();
      int k = ((View)localObject).getTop();
      m = (int)((i - m - f1) / 2.0F);
      i = (int)(m + f1);
      int n = (int)((j - k - f2) / 2.0F);
      int i1 = (int)(n + f2);
      if (localView != null)
      {
        k = ((View)localObject).getLeft() + m;
        m = ((View)localObject).getLeft() + i;
        int i2 = ((View)localObject).getTop();
        int i3 = ((View)localObject).getTop();
        j = k;
        i = m;
        if (this.jdField_a_of_type_Float > 0.0F)
        {
          localObject = getChildAt(this.n);
          j = k;
          i = m;
          if (localObject != null)
          {
            f1 = this.jdField_b_of_type_AndroidGraphicsPaint.measureText(((String)this.jdField_c_of_type_JavaUtilList.get(this.n)).toString());
            j = (int)((((View)localObject).getRight() - ((View)localObject).getLeft() - f1) / 2.0F);
            i = (int)(j + f1);
            j = (int)(k + this.jdField_a_of_type_Float * (((View)localObject).getLeft() + j - this.d - k));
            i = (int)(m + this.jdField_a_of_type_Float * (((View)localObject).getLeft() + i + this.d - m));
          }
        }
        localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
        k = this.u;
        f1 = j - k;
        j = this.t;
        ((RectF)localObject).set(f1, i2 + n - j, i + k, i3 + i1 + j);
        paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.p, this.q, this.jdField_c_of_type_AndroidGraphicsPaint);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView2
 * JD-Core Version:    0.7.0.1
 */