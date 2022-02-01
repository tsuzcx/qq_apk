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
  private static final int[] B = { 16842901, 16842904 };
  private int C = 16;
  private int D = 16;
  private int E = -16776961;
  private int F = 25;
  private int G = 9;
  private int H = 15;
  private Paint I;
  private RectF J;
  private Rect K = new Rect();
  
  public TabBarView2(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabBarView2(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.c = ViewUtils.dip2px(56.0F);
    this.n = 16;
    boolean bool1 = QQTheme.isDefaultTheme();
    int k = this.F;
    boolean bool2 = QQTheme.isNowThemeIsNight();
    boolean bool3 = QQTheme.isNowSimpleUI();
    int j = 2131168001;
    int m = 2131168122;
    int i;
    if (bool3)
    {
      m = 2131168059;
      k = 255;
      i = 2131168072;
      j = 2131168072;
    }
    else if (bool2)
    {
      j = 2131165915;
      m = 2131165914;
      i = 2131165913;
      k = 30;
    }
    else if (!bool1)
    {
      i = 2131168001;
    }
    else
    {
      i = 2131165916;
      j = 2131165916;
    }
    this.g = getResources().getColor(m);
    this.f = getResources().getColor(j);
    this.E = getResources().getColor(i);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    this.G = ((int)TypedValue.applyDimension(1, this.G, localDisplayMetrics));
    this.H = ((int)TypedValue.applyDimension(1, this.H, localDisplayMetrics));
    this.C = ((int)TypedValue.applyDimension(1, this.C, localDisplayMetrics));
    this.D = ((int)TypedValue.applyDimension(1, this.D, localDisplayMetrics));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, B);
    this.E = paramContext.getColor(R.styleable.dK, this.E);
    this.F = paramContext.getInt(R.styleable.dJ, this.F);
    this.C = paramContext.getDimensionPixelSize(R.styleable.dN, this.C);
    this.D = paramContext.getDimensionPixelSize(R.styleable.dO, this.D);
    this.G = paramContext.getDimensionPixelSize(R.styleable.dM, this.G);
    this.H = paramContext.getDimensionPixelSize(R.styleable.dL, this.H);
    paramContext.recycle();
    if (("1103".equals(QQTheme.getCurrentThemeId())) || (QQTheme.isNowSimpleUI()))
    {
      this.E = getResources().getColor(i);
      this.F = k;
    }
    d();
  }
  
  private void b(Canvas paramCanvas)
  {
    Object localObject = getChildAt(this.t);
    if (localObject != null)
    {
      this.I.setColor(this.E);
      this.I.setAlpha(this.F);
      View localView = (View)this.v.get(this.t);
      this.A.setTextSize(this.n * getContext().getResources().getDisplayMetrics().density + 0.5F);
      String str = (String)this.x.get(this.t);
      this.A.getTextBounds(str, 0, str.length(), this.K);
      float f1 = this.K.width();
      float f2 = this.K.height();
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
        if (this.r > 0.0F)
        {
          localObject = getChildAt(this.s);
          j = k;
          i = m;
          if (localObject != null)
          {
            f1 = this.A.measureText(((String)this.x.get(this.s)).toString());
            j = (int)((((View)localObject).getRight() - ((View)localObject).getLeft() - f1) / 2.0F);
            i = (int)(j + f1);
            j = (int)(k + this.r * (((View)localObject).getLeft() + j - this.e - k));
            i = (int)(m + this.r * (((View)localObject).getLeft() + i + this.e - m));
          }
        }
        localObject = this.J;
        k = this.H;
        f1 = j - k;
        j = this.G;
        ((RectF)localObject).set(f1, i2 + n - j, i + k, i3 + i1 + j);
        paramCanvas.drawRoundRect(this.J, this.C, this.D, this.I);
      }
    }
  }
  
  private void d()
  {
    this.I = new Paint();
    this.I.setAntiAlias(true);
    this.I.setStyle(Paint.Style.FILL);
    this.J = new RectF();
  }
  
  protected void a(Canvas paramCanvas)
  {
    if (QQTheme.isNowSimpleUI())
    {
      a(paramCanvas, this.I, this.f);
      return;
    }
    b(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.TabBarView2
 * JD-Core Version:    0.7.0.1
 */