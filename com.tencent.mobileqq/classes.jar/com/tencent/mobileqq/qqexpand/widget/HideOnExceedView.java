package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HideOnExceedView
  extends ImageView
{
  private boolean a;
  
  public HideOnExceedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HideOnExceedView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (!this.a) {
      super.onDraw(paramCanvas);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    ViewGroup localViewGroup = (ViewGroup)getParent();
    if ((localViewGroup != null) && ((paramInt3 > localViewGroup.getWidth()) || (paramInt4 > localViewGroup.getHeight()))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.HideOnExceedView
 * JD-Core Version:    0.7.0.1
 */