package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class InputMethodLinearLayout
  extends LinearLayout
{
  protected InputMethodLinearLayout.onSizeChangeListenner a;
  private int b;
  private int c;
  private int d;
  private int e;
  private boolean f = false;
  
  public InputMethodLinearLayout(Context paramContext)
  {
    super(paramContext);
    paramContext = ((Activity)paramContext).getWindowManager().getDefaultDisplay();
    this.d = paramContext.getWidth();
    this.e = paramContext.getHeight();
  }
  
  public InputMethodLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = ((Activity)paramContext).getWindowManager().getDefaultDisplay();
    this.d = paramContext.getWidth();
    this.e = paramContext.getHeight();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.a != null) && (paramInt1 == paramInt3) && (paramInt3 != 0) && (paramInt4 != 0))
    {
      if ((paramInt2 < paramInt4) && (Math.abs(paramInt2 - paramInt4) > this.e * 1 / 4))
      {
        this.f = true;
      }
      else
      {
        if ((paramInt2 <= paramInt4) || (Math.abs(paramInt2 - paramInt4) <= this.e * 1 / 4)) {
          return;
        }
        this.f = false;
      }
      this.a.onSizeChange(this.f);
      measure(this.b - paramInt1 + getWidth(), this.c - paramInt2 + getHeight());
    }
  }
  
  public void setOnSizeChangedListenner(InputMethodLinearLayout.onSizeChangeListenner paramonSizeChangeListenner)
  {
    this.a = paramonSizeChangeListenner;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.InputMethodLinearLayout
 * JD-Core Version:    0.7.0.1
 */