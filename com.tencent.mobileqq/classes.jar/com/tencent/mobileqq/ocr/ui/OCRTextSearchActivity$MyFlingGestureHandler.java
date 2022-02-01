package com.tencent.mobileqq.ocr.ui;

import android.app.Activity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

public class OCRTextSearchActivity$MyFlingGestureHandler
  extends FlingGestureHandler
{
  boolean a = true;
  
  public OCRTextSearchActivity$MyFlingGestureHandler(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (!b()) {
      a();
    }
    this.mTopLayout.setInterceptTouchFlag(paramBoolean);
  }
  
  public void flingLToR()
  {
    if (this.a) {
      super.flingLToR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.ui.OCRTextSearchActivity.MyFlingGestureHandler
 * JD-Core Version:    0.7.0.1
 */