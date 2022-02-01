package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;

public class RedDotImageView
  extends ImageView
{
  protected Drawable a = null;
  protected int b = 0;
  protected Paint c = null;
  protected int d = 0;
  protected float e = 0.0F;
  private int f = 0;
  private int g = 13;
  private int h = 13;
  private Drawable i = null;
  private boolean j = false;
  private boolean k = false;
  private int l = 0;
  private float m = getResources().getDisplayMetrics().density;
  
  public RedDotImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RedDotImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RedDotImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      if ((this.j) && (this.i == null)) {
        this.i = getResources().getDrawable(2130852588);
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" showRedDot() : ");
        localStringBuilder.append(this.d);
        localStringBuilder.append(",isShownBorder");
        localStringBuilder.append(this.k);
        localStringBuilder.append("，this = ");
        localStringBuilder.append(this);
        QLog.d("Q.recent", 2, localStringBuilder.toString());
      }
      postInvalidate();
    }
  }
  
  public boolean a()
  {
    return this.j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject;
    if ((QLog.isColorLevel()) && (toString().contains("qq_aio_panel_image")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" onDraw() : ");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(",isShownBorder");
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append("，this = ");
      ((StringBuilder)localObject).append(this);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
    int n;
    double d1;
    double d2;
    int i1;
    if (this.j)
    {
      localObject = this.i;
      if (localObject != null)
      {
        ((Drawable)localObject).setState(getDrawableState());
        n = this.f;
        double d3;
        if (n == 0)
        {
          d1 = getWidth();
          Double.isNaN(d1);
          d2 = this.m * this.g;
          Double.isNaN(d2);
          d3 = this.i.getIntrinsicWidth();
          Double.isNaN(d3);
          n = (int)Math.ceil(d1 * 0.5D + d2 - d3 * 0.5D);
          d1 = getHeight();
          Double.isNaN(d1);
          d2 = this.m * this.h;
          Double.isNaN(d2);
          d3 = this.i.getIntrinsicHeight();
          Double.isNaN(d3);
        }
        for (d1 = Math.ceil(d1 * 0.5D - d2 - d3 * 0.5D);; d1 = Math.ceil(d1 - d2 * 0.5D))
        {
          i1 = (int)d1;
          break label386;
          if (n != 1) {
            break;
          }
          d1 = getWidth() + this.m * this.g;
          d2 = this.i.getIntrinsicWidth();
          Double.isNaN(d2);
          Double.isNaN(d1);
          n = (int)Math.ceil(d1 - d2 * 0.5D);
          d1 = -this.m * this.h;
          d2 = this.i.getIntrinsicHeight();
          Double.isNaN(d2);
          Double.isNaN(d1);
        }
        n = 0;
        i1 = 0;
        label386:
        localObject = this.i;
        ((Drawable)localObject).setBounds(n, i1, ((Drawable)localObject).getIntrinsicWidth() + n, this.i.getIntrinsicHeight() + i1);
        this.i.draw(paramCanvas);
      }
    }
    if (this.d > 0)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((Drawable)localObject).setState(getDrawableState());
        n = getWidth();
        i1 = this.b;
        if (n > i1 * 2) {
          d1 = Math.ceil(n / 2);
        } else {
          d1 = Math.ceil(n - i1 - this.l);
        }
        n = (int)d1;
        localObject = this.a;
        i1 = this.b;
        ((Drawable)localObject).setBounds(n, 0, n + i1, i1);
        this.a.draw(paramCanvas);
        i1 = (int)Math.ceil(this.c.measureText(String.valueOf(this.d)));
        int i2 = this.d;
        d1 = n;
        n = this.b;
        d2 = n - i1;
        Double.isNaN(d2);
        Double.isNaN(d1);
        float f1 = (int)(d1 + d2 * 0.5D);
        d1 = n;
        d2 = this.e;
        Double.isNaN(d2);
        Double.isNaN(d1);
        paramCanvas.drawText(String.valueOf(i2), f1, (int)(d1 - d2 * 0.5D), this.c);
      }
    }
  }
  
  public void setRedDotBase(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      postInvalidate();
    }
  }
  
  public void setRedDotDrawable(Drawable paramDrawable)
  {
    if (paramDrawable != null) {
      this.i = paramDrawable;
    }
  }
  
  public void setReddotXOffsetDp(int paramInt)
  {
    if (paramInt != this.g)
    {
      this.g = paramInt;
      postInvalidate();
    }
  }
  
  public void setReddotYOffsetDp(int paramInt)
  {
    if (paramInt != this.h)
    {
      this.h = paramInt;
      postInvalidate();
    }
  }
  
  public void setShowBorder(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setUnreadNumber(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" setUnreadNumber() : ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",isShownBorder");
      ((StringBuilder)localObject).append(this.k);
      ((StringBuilder)localObject).append("，this = ");
      ((StringBuilder)localObject).append(this);
      QLog.d("Q.recent", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt > 0) && (this.a == null))
    {
      float f1 = this.m;
      this.b = ((int)(20.0F * f1));
      this.l = ((int)(f1 * 6.0F));
      this.c = new Paint();
      this.c.setAntiAlias(true);
      this.c.setColor(-1);
      if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null)) {
        this.c.setColor(-1509949441);
      }
      this.c.setStyle(Paint.Style.FILL);
      this.c.setTextSize(this.m * 12.0F);
      localObject = new Paint.FontMetrics();
      this.c.getFontMetrics((Paint.FontMetrics)localObject);
      this.e = Math.abs(((Paint.FontMetrics)localObject).ascent);
      if (this.k) {
        this.a = getResources().getDrawable(2130847335);
      } else {
        this.a = getResources().getDrawable(2130851921);
      }
    }
    this.d = paramInt;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.RedDotImageView
 * JD-Core Version:    0.7.0.1
 */