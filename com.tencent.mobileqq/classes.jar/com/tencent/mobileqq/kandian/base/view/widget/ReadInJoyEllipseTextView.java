package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.TextView;

public class ReadInJoyEllipseTextView
  extends TextView
{
  public ReadInJoyEllipseTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ReadInJoyEllipseTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ReadInJoyEllipseTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (super.getLineCount() <= 1)
    {
      paramInt1 = super.getLayout().getLineVisibleEnd(0);
      if (super.getText() == null)
      {
        setVisibility(4);
        return;
      }
      if (paramInt1 < super.getText().toString().length())
      {
        setVisibility(4);
        return;
      }
      setVisibility(0);
      return;
    }
    setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyEllipseTextView
 * JD-Core Version:    0.7.0.1
 */