package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.PaintDrawable;
import android.util.AttributeSet;
import android.widget.TextView;

public class KanDianRoundCornerTextView
  extends TextView
{
  private float jdField_a_of_type_Float = 0.4F;
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString = "#000000";
  
  public KanDianRoundCornerTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public KanDianRoundCornerTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public KanDianRoundCornerTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    PaintDrawable localPaintDrawable = new PaintDrawable();
    localPaintDrawable.setCornerRadius(this.jdField_a_of_type_Int);
    localPaintDrawable.setColorFilter(Color.parseColor(this.jdField_a_of_type_JavaLangString), PorterDuff.Mode.SRC_ATOP);
    localPaintDrawable.setAlpha((int)(this.jdField_a_of_type_Float * 255.0F));
    setBackgroundDrawable(localPaintDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.KanDianRoundCornerTextView
 * JD-Core Version:    0.7.0.1
 */