package com.tencent.mobileqq.confess;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PorterDuff.Mode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.util.VersionUtils;

public class ConfessNewsBgView
  extends View
{
  ConfessShareHelper.BgElement[] a = null;
  Paint b = new Paint(1);
  int c = -6807359;
  int d = 0;
  RectF e = new RectF();
  private float[] f = { 16.0F, 16.0F, 16.0F, 16.0F, 16.0F, 16.0F, 16.0F, 16.0F };
  private Path g;
  private int h = 0;
  private boolean i;
  
  public ConfessNewsBgView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ConfessNewsBgView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public ConfessNewsBgView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    int j = this.h;
    int k = 0;
    Object localObject1;
    if (j == 2)
    {
      this.a = ConfessShareHelper.a(j, this.d);
      localObject1 = getResources();
      int m = ((Resources)localObject1).getDisplayMetrics().widthPixels;
      int n = ((Resources)localObject1).getDisplayMetrics().heightPixels;
      Object localObject2;
      if ((m != 0) && (Math.abs(m - 1080) > 200))
      {
        localObject1 = this.a;
        int i1 = localObject1.length;
        j = 0;
        while (j < i1)
        {
          localObject2 = localObject1[j];
          float f1 = localObject2.b;
          float f2 = m / 1080;
          if (m - (int)(f1 * f2) > 100) {
            localObject2.b = ((int)(localObject2.b * f2));
          }
          j += 1;
        }
      }
      if (n != 0)
      {
        double d1 = n;
        Double.isNaN(d1);
        d1 *= 0.8D;
        double d2 = 1800;
        Double.isNaN(d2);
        if (Math.abs(d1 - d2) > 200.0D)
        {
          localObject1 = this.a;
          m = localObject1.length;
          j = k;
          while (j < m)
          {
            localObject2 = localObject1[j];
            d2 = localObject2.c;
            double d3 = 1800;
            Double.isNaN(d3);
            d3 = d1 / d3;
            Double.isNaN(d2);
            localObject2.c = ((int)(d2 * d3));
            j += 1;
          }
        }
      }
    }
    else
    {
      localObject1 = ConfessShareHelper.a[0];
      j = this.d;
      if ((j >= 0) && (j < ConfessShareHelper.a.length))
      {
        localObject1 = ConfessShareHelper.a;
        j = this.d;
        localObject1 = localObject1[j];
        this.a = ConfessShareHelper.a(0, j);
      }
      else
      {
        this.a = ConfessShareHelper.a(0, 0);
      }
    }
    try
    {
      this.c = Color.parseColor((String)localObject1);
    }
    catch (Exception localException)
    {
      label359:
      break label359;
    }
    this.c = -6807359;
    this.b.setStyle(Paint.Style.FILL);
    this.b.setColor(this.c);
    if (!VersionUtils.h()) {
      setLayerType(1, null);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.i)
    {
      if (isPressed()) {
        this.c = Color.argb(100, Color.red(this.c), Color.green(this.c), Color.blue(this.c));
      } else {
        this.c = Color.argb(255, Color.red(this.c), Color.green(this.c), Color.blue(this.c));
      }
      postInvalidate();
    }
  }
  
  public int getBgType()
  {
    return this.d;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getMeasuredWidth();
    k = getMeasuredHeight();
    this.e.set(0.0F, 0.0F, j, k);
    if (this.g == null) {
      this.g = new Path();
    }
    int m = paramCanvas.save();
    try
    {
      Object localObject1 = this.g;
      ((Path)localObject1).reset();
      ((Path)localObject1).addRoundRect(this.e, this.f, Path.Direction.CW);
      paramCanvas.clipPath((Path)localObject1);
      label90:
      paramCanvas.drawRect(this.e, this.b);
      localObject1 = this.a;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        int n = localObject1.length;
        j = 0;
        while (j < n)
        {
          Object localObject2 = localObject1[j];
          try
          {
            localDrawable = getResources().getDrawable(localObject2.a);
            if (localObject2.a == 2130846432) {
              break label343;
            }
            int i1 = localDrawable.getIntrinsicWidth();
            k = localDrawable.getIntrinsicHeight();
            float f2 = localObject2.b;
            float f1 = i1;
            i1 = (int)(f2 * 1.8F - localObject2.e * f1 * 1.0F / 2.0F);
            f2 = localObject2.c;
            float f3 = k;
            localDrawable.setBounds(i1, (int)(f2 * 1.6F - localObject2.e * f3 * 1.0F / 2.0F), (int)(localObject2.b * 1.8F + f1 * localObject2.e * 1.0F / 2.0F), (int)(localObject2.c * 1.6F + f3 * localObject2.e * 1.0F / 2.0F));
            if (!localObject2.d) {
              break label337;
            }
            if (this.h != 2) {
              break label369;
            }
            k = 128;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              Drawable localDrawable;
              continue;
              k = 77;
            }
          }
          localDrawable.setAlpha(k);
          localDrawable.setColorFilter(this.c, PorterDuff.Mode.MULTIPLY);
          label337:
          localDrawable.draw(paramCanvas);
          label343:
          j += 1;
        }
      }
      else
      {
        paramCanvas.restoreToCount(m);
        return;
      }
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      break label90;
    }
  }
  
  public void setBgColor(int paramInt)
  {
    if (this.c != paramInt) {
      this.c = paramInt;
    }
  }
  
  public void setBgType(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      a();
      postInvalidate();
    }
  }
  
  public void setPressMask(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public void setSize(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      a();
      postInvalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.confess.ConfessNewsBgView
 * JD-Core Version:    0.7.0.1
 */