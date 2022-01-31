package com.tencent.mobileqq.richmedia.capture.gesture;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.mobileqq.shortvideo.ptvfilter.NonFit2DFilter;
import com.tencent.mobileqq.shortvideo.ptvfilter.VideoFilterList;
import com.tencent.sveffects.SLog;
import com.tencent.ttpic.util.VideoGlobalContext;

public class CameraARFilterGesture
  implements GLGestureListener
{
  private int jdField_a_of_type_Int;
  private PointF jdField_a_of_type_AndroidGraphicsPointF = new PointF();
  private VideoFilterList jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList;
  private boolean jdField_a_of_type_Boolean = true;
  
  public CameraARFilterGesture(VideoFilterList paramVideoFilterList)
  {
    this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList = paramVideoFilterList;
    this.jdField_a_of_type_Int = paramVideoFilterList.jdField_a_of_type_Int;
  }
  
  private void a(PointF paramPointF)
  {
    if ((paramPointF != null) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList != null))
    {
      int i = NonFit2DFilter.a(VideoGlobalContext.getContext());
      int j = this.jdField_a_of_type_Int;
      if (SLog.a()) {
        SLog.c("CameraARFilterGesture", "width:" + j + ", windowWidth:" + i);
      }
      if ((j > 0) && (i > 0))
      {
        float f = j / i;
        paramPointF.x *= f;
        paramPointF.y = (f * paramPointF.y);
        this.jdField_a_of_type_ComTencentMobileqqShortvideoPtvfilterVideoFilterList.a(new PointF(paramPointF.x, paramPointF.y));
      }
    }
  }
  
  public int a()
  {
    return 1020;
  }
  
  public boolean a(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction();
    if (i > 2)
    {
      if (SLog.a()) {
        SLog.c("CameraARFilterGesture", "two more point!");
      }
      return false;
    }
    float f2;
    float f1;
    if ((i == 2) && (paramBoolean))
    {
      i = 1;
      if (i == 0) {
        break label132;
      }
      f2 = GLGestureProxy.a().a(paramMotionEvent.getX(1));
      f1 = GLGestureProxy.a().b(paramMotionEvent.getY(1));
      label76:
      switch (j & 0xFF)
      {
      }
    }
    for (;;)
    {
      return true;
      i = 0;
      break;
      label132:
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      break label76;
      this.jdField_a_of_type_AndroidGraphicsPointF.x = f2;
      this.jdField_a_of_type_AndroidGraphicsPointF.y = f1;
      this.jdField_a_of_type_Boolean = true;
      continue;
      if (NonFit2DFilter.a(this.jdField_a_of_type_AndroidGraphicsPointF.x, this.jdField_a_of_type_AndroidGraphicsPointF.y, f2, f1) > NonFit2DFilter.a(VideoGlobalContext.getContext()) * 0.05F)
      {
        if (SLog.a()) {
          SLog.c("CameraARFilterGesture", "point move!");
        }
        this.jdField_a_of_type_Boolean = false;
        continue;
        if ((this.jdField_a_of_type_Boolean) && (!paramBoolean)) {
          a(new PointF(f2, f1));
        }
        this.jdField_a_of_type_Boolean = true;
        continue;
        if (SLog.a()) {
          SLog.c("CameraARFilterGesture", "point_dow, isRecording:" + paramBoolean);
        }
        if (i != 0)
        {
          this.jdField_a_of_type_AndroidGraphicsPointF.x = f2;
          this.jdField_a_of_type_AndroidGraphicsPointF.y = f1;
          this.jdField_a_of_type_Boolean = true;
          continue;
          if (SLog.a()) {
            SLog.c("CameraARFilterGesture", "point_up, isRecording:" + paramBoolean + ", needTouchPoint:" + this.jdField_a_of_type_Boolean);
          }
          if ((this.jdField_a_of_type_Boolean) && (i != 0))
          {
            a(new PointF(f2, f1));
            this.jdField_a_of_type_Boolean = false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.gesture.CameraARFilterGesture
 * JD-Core Version:    0.7.0.1
 */