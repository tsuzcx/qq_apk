package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewParent;
import com.tencent.mobileqq.R.styleable;

public class LargeAreaPatchedButton
  extends PatchedButton
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
  private int j;
  
  public LargeAreaPatchedButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public LargeAreaPatchedButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public LargeAreaPatchedButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LargeTouchableAreaView);
    int k = (int)paramContext.getDimension(0, 0.0F);
    this.f = k;
    this.g = k;
    this.h = k;
    this.i = k;
    this.j = 1;
    this.f = ((int)paramContext.getDimension(1, this.f));
    this.g = ((int)paramContext.getDimension(2, this.g));
    this.h = ((int)paramContext.getDimension(3, this.h));
    this.i = ((int)paramContext.getDimension(4, this.i));
    this.j = paramContext.getInt(5, this.j);
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
      TouchDelegate localTouchDelegate = new TouchDelegate(new Rect(paramInt1 - this.g, paramInt2 - this.i, this.h + paramInt3, this.f + paramInt4), this);
      Object localObject1 = getParent();
      paramInt1 = 0;
      while (paramInt1 < this.j)
      {
        Object localObject2 = localObject1;
        if ((localObject1 instanceof View))
        {
          ((View)localObject1).setTouchDelegate(localTouchDelegate);
          localObject2 = ((ViewParent)localObject1).getParent();
        }
        paramInt1 += 1;
        localObject1 = localObject2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.widget.LargeAreaPatchedButton
 * JD-Core Version:    0.7.0.1
 */