package com.tencent.mobileqq.ptt;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;

public class LSRecordTextView
  extends TextView
{
  private boolean a;
  private boolean b;
  
  public LSRecordTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public LSRecordTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LSRecordTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void requestLayout()
  {
    if ((this.b) && (this.a)) {
      return;
    }
    super.requestLayout();
  }
  
  public void setNotLayoutInSettingText(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (this.b) {
      this.a = true;
    }
    super.setText(paramCharSequence, paramBufferType);
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.LSRecordTextView
 * JD-Core Version:    0.7.0.1
 */