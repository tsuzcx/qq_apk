package com.tencent.mobileqq.richmedia.capture.gesture;

import android.view.MotionEvent;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.TakeVideoUtils;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import java.math.BigDecimal;

public class CameraZoomGesture
  implements GLGestureListener
{
  public float a;
  public CameraCaptureView a;
  private float b;
  private float c;
  
  public CameraZoomGesture(CameraCaptureView paramCameraCaptureView)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView = paramCameraCaptureView;
  }
  
  public int a()
  {
    return 0;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction() & 0xFF;
    if ((j != 3) || ((i == 1) && (paramBoolean))) {
      switch (j)
      {
      }
    }
    while ((i != 2) || (paramBoolean))
    {
      do
      {
        return false;
        this.c = this.jdField_a_of_type_Float;
        return false;
        if (paramMotionEvent.getY() >= this.jdField_a_of_type_Float)
        {
          this.c = this.jdField_a_of_type_Float;
          return false;
        }
        i = new BigDecimal((this.c - paramMotionEvent.getY()) / 20.0F).setScale(0, 4).intValue();
      } while ((i == 0) || (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView == null));
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setZoom(i);
      this.c = paramMotionEvent.getY();
      return false;
    }
    SLog.a("CameraZoomGesture", "onTouchEvent %s", new Object[] { paramMotionEvent });
    float f4;
    float f2;
    float f3;
    if (i == 2)
    {
      f4 = paramMotionEvent.getX(0);
      f2 = paramMotionEvent.getY(0);
      f3 = paramMotionEvent.getX(1);
    }
    for (float f1 = paramMotionEvent.getY(1);; f1 = paramMotionEvent.getY(2)) {
      switch (j)
      {
      case 6: 
      case 3: 
      case 4: 
      default: 
        return false;
      case 2: 
        f1 = TakeVideoUtils.a(f4, f2, f3, f1);
        i = new BigDecimal((f1 - this.b) / 20.0F).setScale(0, 4).intValue();
        if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.setZoom(i);
          this.b = f1;
        }
        return true;
        f4 = paramMotionEvent.getX(1);
        f2 = paramMotionEvent.getY(1);
        f3 = paramMotionEvent.getX(2);
      }
    }
    this.b = TakeVideoUtils.a(f4, f2, f3, f1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.CameraZoomGesture
 * JD-Core Version:    0.7.0.1
 */