package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;

public class MaskView
  extends View
{
  private Rect a;
  private RectF b;
  private Rect c;
  private Paint d = new Paint();
  private boolean e = false;
  private Drawable f;
  private int g;
  private boolean h = false;
  private Drawable i;
  
  public MaskView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public MaskView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public MaskView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.f = getResources().getDrawable(2130847256);
    this.g = DisplayUtil.a(getContext(), 3.0F);
    DisplayMetrics localDisplayMetrics = getResources().getDisplayMetrics();
    int j;
    int k;
    if (localDisplayMetrics.widthPixels < localDisplayMetrics.heightPixels)
    {
      j = localDisplayMetrics.widthPixels;
      k = localDisplayMetrics.heightPixels;
    }
    else
    {
      k = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
    }
    int i1 = j - DisplayUtil.a(getContext(), 18.0F);
    int i2 = i1 * 424 / 680;
    int m = (j - i1) / 2 + 0;
    int n = (k - i2) / 2 + 0;
    i1 += m;
    i2 += n;
    this.a = new Rect(m, n, i1, i2);
    int i3 = this.g;
    this.c = new Rect(m + i3, n + i3, i1 - i3, i2 - i3);
    float f2 = this.c.left;
    float f1 = j;
    f2 = f2 * 1.0F / f1;
    float f3 = this.c.top;
    float f4 = k;
    this.b = new RectF(f2, f3 * 1.0F / f4, this.c.right * 1.0F / f1, this.c.bottom * 1.0F / f4);
    if (QLog.isColorLevel()) {
      QLog.d("MaskView", 2, new Object[] { "MaskView init mBoxRect:", this.a, " screenHeight: ", Integer.valueOf(k), " screenWidth: ", Integer.valueOf(j), "mPreviewRect:", this.c, "mPreviewRectF:", this.b });
    }
  }
  
  public Rect getPreviewRect()
  {
    return this.c;
  }
  
  public RectF getPreviewRectF()
  {
    return this.b;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (!this.e) {
      return;
    }
    if (this.h) {
      this.d.setColor(-16777216);
    } else {
      this.d.setColor(-2147483648);
    }
    this.d.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(new Rect(0, 0, getWidth(), this.c.top), this.d);
    paramCanvas.drawRect(new Rect(0, this.c.bottom, getWidth(), getHeight()), this.d);
    paramCanvas.drawRect(new Rect(0, this.c.top, this.c.left, this.c.bottom), this.d);
    paramCanvas.drawRect(new Rect(this.c.right, this.c.top, getHeight(), this.c.bottom), this.d);
    Drawable localDrawable = this.i;
    if ((localDrawable != null) && (this.h))
    {
      localDrawable.setBounds(this.c);
      this.i.draw(paramCanvas);
      return;
    }
    this.f.setBounds(this.a);
    this.f.draw(paramCanvas);
  }
  
  public void setIsDisplayRect(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void setModel(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (!this.h) {
      this.i = null;
    }
    invalidate();
  }
  
  public void setPreviewDrawable(Drawable paramDrawable)
  {
    this.i = paramDrawable;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.MaskView
 * JD-Core Version:    0.7.0.1
 */