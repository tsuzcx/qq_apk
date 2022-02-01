package com.tencent.mobileqq.ptt;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import baht;

public class TouchProxyRelativeLayout
  extends RelativeLayout
{
  public baht a;
  
  public TouchProxyRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public TouchProxyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TouchProxyRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    baht localbaht = this.a;
    boolean bool1 = false;
    if (localbaht != null) {
      bool1 = localbaht.a(paramMotionEvent);
    }
    boolean bool2 = bool1;
    if (!bool1) {
      bool2 = super.dispatchTouchEvent(paramMotionEvent);
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.TouchProxyRelativeLayout
 * JD-Core Version:    0.7.0.1
 */