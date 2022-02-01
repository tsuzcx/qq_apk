package com.tencent.mobileqq.subaccount;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class UpArrowView
  extends View
{
  Paint a = new Paint();
  int b;
  int c;
  
  public UpArrowView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public UpArrowView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public UpArrowView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  public void a()
  {
    this.b = Color.argb(255, 255, 255, 255);
    this.c = Color.argb(255, 241, 242, 249);
    setDuplicateParentStateEnabled(true);
    int i = getResources().getColor(2131168094);
    if (this.b != i) {
      this.b = i;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((!isSelected()) && (!isPressed())) {
      this.a.setColor(this.b);
    } else {
      this.a.setColor(this.c);
    }
    this.a.setAntiAlias(true);
    int i = getWidth();
    int j = getHeight();
    Path localPath = new Path();
    float f = j;
    localPath.moveTo(0.0F, f);
    localPath.lineTo(i / 2, 0.0F);
    localPath.lineTo(i, f);
    localPath.close();
    paramCanvas.drawPath(localPath, this.a);
  }
  
  public void setPressed(boolean paramBoolean)
  {
    super.setPressed(paramBoolean);
    invalidate();
  }
  
  public void setSelected(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
    invalidate();
  }
  
  public void setTheme(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.b = Color.argb(255, 0, 0, 0);
      this.c = Color.argb(255, 31, 31, 31);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.subaccount.UpArrowView
 * JD-Core Version:    0.7.0.1
 */