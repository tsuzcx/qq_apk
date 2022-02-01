package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.Layout;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;

public class EllipsisTextView
  extends TextView
{
  public EllipsisTextView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public EllipsisTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public EllipsisTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    setMaxLines(1);
    setEllipsize(TextUtils.TruncateAt.END);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Layout localLayout = getLayout();
    if (localLayout.getEllipsisCount(0) > 0)
    {
      paramInt1 = (int)(localLayout.getLineRight(0) + 0.5F);
      paramInt2 = getMeasuredHeight();
      setMeasuredDimension(getCompoundPaddingLeft() + paramInt1 + getCompoundPaddingRight(), paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.EllipsisTextView
 * JD-Core Version:    0.7.0.1
 */