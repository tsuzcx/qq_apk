package com.tencent.mobileqq.richmedia.capture.gesture;

import android.view.MotionEvent;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.sveffects.SLog;

public class MovieFilterGesture
  implements GLGestureListener
{
  private long jdField_a_of_type_Long = 0L;
  private GLGestureProxy jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureGLGestureProxy;
  private QQFilterRenderManager jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager;
  
  public MovieFilterGesture(QQFilterRenderManager paramQQFilterRenderManager, GLGestureProxy paramGLGestureProxy)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = paramQQFilterRenderManager;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureGLGestureProxy = paramGLGestureProxy;
  }
  
  public int a()
  {
    return 1050;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction() & 0xFF;
    if (i > 2) {
      if (SLog.a()) {
        SLog.c("MovieFilterGesture", "two more point!");
      }
    }
    label50:
    float f2;
    float f1;
    label125:
    do
    {
      do
      {
        do
        {
          return false;
          if ((i == 2) && (paramBoolean))
          {
            i = 1;
            if (i == 0) {
              break label125;
            }
            f2 = GLGestureProxy.a().a(paramMotionEvent.getX(1));
          }
          for (f1 = GLGestureProxy.a().b(paramMotionEvent.getY(1));; f1 = paramMotionEvent.getY())
          {
            if (i == 0) {
              break label187;
            }
            switch (j)
            {
            default: 
              return false;
            case 5: 
              this.jdField_a_of_type_Long = System.currentTimeMillis();
              return false;
              i = 0;
              break label50;
              f2 = paramMotionEvent.getX();
            }
          }
        } while (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 200L);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(f2, f1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureGLGestureProxy.b(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureGLGestureProxy.a());
        this.jdField_a_of_type_Long = 0L;
        return true;
      } while (paramBoolean);
      switch (j)
      {
      default: 
        return false;
      case 0: 
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        return false;
      }
    } while (System.currentTimeMillis() - this.jdField_a_of_type_Long >= 200L);
    label187:
    this.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.a(f2, f1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureGLGestureProxy.b(), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureGestureGLGestureProxy.a());
    this.jdField_a_of_type_Long = 0L;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.MovieFilterGesture
 * JD-Core Version:    0.7.0.1
 */