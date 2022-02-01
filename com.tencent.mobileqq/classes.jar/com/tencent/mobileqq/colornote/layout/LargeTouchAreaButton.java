package com.tencent.mobileqq.colornote.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.colornote.api.R.styleable;

public class LargeTouchAreaButton
  extends Button
{
  private int a = -1;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  
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
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ar);
    int i = (int)paramContext.getDimension(R.styleable.as, 0.0F);
    this.e = i;
    this.f = i;
    this.g = i;
    this.h = i;
    this.e = ((int)paramContext.getDimension(R.styleable.at, this.e));
    this.f = ((int)paramContext.getDimension(R.styleable.au, this.f));
    this.g = ((int)paramContext.getDimension(R.styleable.av, this.g));
    this.h = ((int)paramContext.getDimension(R.styleable.aw, this.h));
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
      ((View)getParent()).setTouchDelegate(new TouchDelegate(new Rect(paramInt1 - this.f, paramInt2 - this.h, paramInt3 + this.g, paramInt4 + this.e), this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.layout.LargeTouchAreaButton
 * JD-Core Version:    0.7.0.1
 */