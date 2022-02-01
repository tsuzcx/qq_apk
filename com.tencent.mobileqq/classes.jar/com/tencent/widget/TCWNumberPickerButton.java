package com.tencent.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.ImageButton;

public class TCWNumberPickerButton
  extends ImageButton
{
  private TCWNumberPicker a;
  
  public TCWNumberPickerButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public TCWNumberPickerButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TCWNumberPickerButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a()
  {
    if (2131435671 == getId())
    {
      this.a.a();
      return;
    }
    if (2131431670 == getId()) {
      this.a.b();
    }
  }
  
  private void a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 3) || (paramMotionEvent.getAction() == 1)) {
      a();
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 23) || (paramInt == 66)) {
      a();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent);
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public boolean onTrackballEvent(MotionEvent paramMotionEvent)
  {
    a(paramMotionEvent);
    return super.onTrackballEvent(paramMotionEvent);
  }
  
  public void setNumberPicker(TCWNumberPicker paramTCWNumberPicker)
  {
    this.a = paramTCWNumberPicker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.TCWNumberPickerButton
 * JD-Core Version:    0.7.0.1
 */