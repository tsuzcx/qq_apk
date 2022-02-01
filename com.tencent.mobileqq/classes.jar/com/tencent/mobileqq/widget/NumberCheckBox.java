package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class NumberCheckBox
  extends CheckBox
{
  private int a = -1;
  private boolean b = false;
  private Paint c = new Paint();
  
  public NumberCheckBox(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public NumberCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NumberCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.c.setColor(paramContext.getResources().getColor(2131168479));
    this.c.setStyle(Paint.Style.FILL);
  }
  
  public int getNumber()
  {
    return this.a;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.b) {
      paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, Math.min(getWidth() / 2.0F, getHeight() / 2.0F), this.c);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    if (paramBoolean)
    {
      int i = this.a;
      if (i >= 0)
      {
        str = String.valueOf(i);
        break label29;
      }
    }
    String str = "";
    label29:
    if (!str.equals(getText())) {
      setText(str);
    }
  }
  
  public void setCheckedNumber(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      setText(String.valueOf(paramInt));
    }
    setChecked(true);
  }
  
  public void setForegroundColor(int paramInt)
  {
    this.c.setColor(paramInt);
  }
  
  public void setNeedForeground(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NumberCheckBox
 * JD-Core Version:    0.7.0.1
 */