package com.tencent.mobileqq.structmsg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TextViewWrapLayout
  extends RelativeLayout
{
  private boolean a = false;
  
  public TextViewWrapLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TextViewWrapLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TextViewWrapLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    requestLayout();
    invalidate();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    try
    {
      super.onMeasure(paramInt1, paramInt2);
      if (this.a)
      {
        TextView localTextView1 = (TextView)findViewById(2131379930);
        TextView localTextView2 = (TextView)findViewById(2131379906);
        if ((localTextView2 != null) && (localTextView1 != null) && (4 - localTextView1.getLineCount() > 0)) {
          localTextView2.setMaxLines(4 - localTextView1.getLineCount());
        }
        this.a = false;
      }
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.widget.TextViewWrapLayout
 * JD-Core Version:    0.7.0.1
 */