package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import biwd;
import bizh;
import bizi;

public class CommonTextView
  extends TextView
  implements bizi
{
  private biwd jdField_a_of_type_Biwd;
  private bizh jdField_a_of_type_Bizh;
  
  public CommonTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CommonTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CommonTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void b(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bizh != null)
    {
      this.jdField_a_of_type_Bizh.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bizh != null)
    {
      this.jdField_a_of_type_Bizh.b(paramCanvas);
      return;
    }
    super.onDraw(paramCanvas);
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (this.jdField_a_of_type_Biwd != null) {
      this.jdField_a_of_type_Biwd.a(paramView, paramInt);
    }
  }
  
  public void setMosaicEffect(bizh parambizh)
  {
    bizh localbizh = this.jdField_a_of_type_Bizh;
    if (localbizh != null) {
      localbizh.a(null);
    }
    this.jdField_a_of_type_Bizh = parambizh;
    if (parambizh != null) {
      parambizh.a(this);
    }
    invalidate();
  }
  
  public void setOnVisibilityChangedListener(biwd parambiwd)
  {
    this.jdField_a_of_type_Biwd = parambiwd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CommonTextView
 * JD-Core Version:    0.7.0.1
 */