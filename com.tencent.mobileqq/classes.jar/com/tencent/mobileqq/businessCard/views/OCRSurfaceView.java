package com.tencent.mobileqq.businessCard.views;

import android.content.Context;
import android.view.MotionEvent;
import android.view.SurfaceView;
import com.tencent.mobileqq.businessCard.helpers.CameraHelper;
import com.tencent.mobileqq.shortvideo.util.MotionEventUtil;

public class OCRSurfaceView
  extends SurfaceView
{
  public OCRSurfaceView(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = MotionEventUtil.a(paramMotionEvent);
    if (i == 1) {}
    switch (j)
    {
    default: 
      return true;
    }
    CameraHelper.a().c();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.businessCard.views.OCRSurfaceView
 * JD-Core Version:    0.7.0.1
 */