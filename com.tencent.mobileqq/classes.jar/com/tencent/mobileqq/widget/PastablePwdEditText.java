package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mobileqq.mqsafeedit.libsafeedit;

public class PastablePwdEditText
  extends ConfigClearableEditText
{
  public PastablePwdEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public PastablePwdEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public PastablePwdEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setClearButtonVisible(false);
  }
  
  protected boolean a()
  {
    return true;
  }
  
  public void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    super.onFocusChanged(paramBoolean, paramInt, paramRect);
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    libsafeedit.getLoginLegal(paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PastablePwdEditText
 * JD-Core Version:    0.7.0.1
 */