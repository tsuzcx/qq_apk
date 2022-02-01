package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.widget.Button;
import com.tencent.mobileqq.utils.ViewUtils;

public class ProgressButton
  extends Button
{
  protected Paint a;
  protected float b;
  protected float c = 0.0F;
  protected int d = 100;
  protected ClipDrawable e;
  private int f = -1;
  
  public ProgressButton(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ProgressButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.a = new Paint();
    int i = getResources().getColorStateList(2131168043).getDefaultColor();
    int j = this.f;
    if (j == -1)
    {
      this.a.setColor(i);
      return;
    }
    this.a.setColor(j);
  }
  
  public ClipDrawable a(@ColorInt int paramInt)
  {
    Object localObject = this.e;
    if (localObject != null) {
      return localObject;
    }
    float f1 = ViewUtils.dip2px(50.0F);
    localObject = new ShapeDrawable(new RoundRectShape(new float[] { f1, f1, f1, f1, f1, f1, f1, f1 }, null, null));
    ((ShapeDrawable)localObject).getPaint().setColor(paramInt);
    return new ClipDrawable((Drawable)localObject, 8388611, 1);
  }
  
  public int getMaxProgress()
  {
    return this.d;
  }
  
  public int getProgressColor()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    ClipDrawable localClipDrawable = this.e;
    if (localClipDrawable != null)
    {
      localClipDrawable.setBounds(0, 0, getWidth(), getHeight());
      this.e.setLevel((int)(10000 / this.d * this.c));
      this.e.draw(paramCanvas);
    }
    else
    {
      if (this.b == 0.0F) {
        this.b = (getWidth() / this.d);
      }
      paramCanvas.drawRoundRect(new RectF(0.0F, 0.0F, this.b * this.c, getHeight()), 5.0F, 5.0F, this.a);
    }
    super.onDraw(paramCanvas);
  }
  
  public void setMacProgress(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    this.f = paramInt;
    this.a.setColor(this.f);
  }
  
  public void setProgressDrawable(ClipDrawable paramClipDrawable)
  {
    this.e = paramClipDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ProgressButton
 * JD-Core Version:    0.7.0.1
 */