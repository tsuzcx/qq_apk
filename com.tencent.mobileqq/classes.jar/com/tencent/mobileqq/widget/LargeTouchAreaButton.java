package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.R.styleable;

public class LargeTouchAreaButton
  extends Button
{
  private int a = -1;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private final int e = 0;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public LargeTouchAreaButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public LargeTouchAreaButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public LargeTouchAreaButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LargeTouchableAreaView);
    int j = (int)paramContext.getDimension(0, 0.0F);
    this.f = j;
    this.g = j;
    this.h = j;
    this.i = j;
    this.f = ((int)paramContext.getDimension(1, this.f));
    this.g = ((int)paramContext.getDimension(2, this.g));
    this.h = ((int)paramContext.getDimension(3, this.h));
    this.i = ((int)paramContext.getDimension(4, this.i));
    paramContext.recycle();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != this.a) || (paramInt2 != this.d) || (paramInt3 != this.b) || (paramInt4 != this.c))
    {
      this.a = paramInt1;
      this.d = paramInt2;
      this.b = paramInt3;
      this.c = paramInt4;
      ((View)getParent()).setTouchDelegate(new TouchDelegate(new Rect(paramInt1 - this.g, paramInt2 - this.i, this.h + paramInt3, this.f + paramInt4), this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.LargeTouchAreaButton
 * JD-Core Version:    0.7.0.1
 */