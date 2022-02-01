package com.tencent.mobileqq.ocr.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageButton;

public class EyeButton
  extends ImageButton
{
  private EyeButton.EyeButtonLonTouchListener a;
  
  public EyeButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public EyeButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public EyeButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      if (this.a != null)
      {
        this.a.a();
        continue;
        if (this.a != null) {
          this.a.b();
        }
      }
    }
  }
  
  public void setLonTouchListener(EyeButton.EyeButtonLonTouchListener paramEyeButtonLonTouchListener)
  {
    this.a = paramEyeButtonLonTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.EyeButton
 * JD-Core Version:    0.7.0.1
 */