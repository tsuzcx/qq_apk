package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.view.MotionEvent;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;
import com.tencent.ttpic.openapi.filter.VideoFilterList;
import com.tencent.ttpic.util.AlgoUtils;

public class CameraARFilterGesture
  implements GLGestureListener
{
  private static final String TAG = "CameraARFilterGesture";
  private int filterWidth;
  private boolean mNeedRecordTouchPoint = true;
  private PointF mTouchStartPoint = new PointF();
  private VideoFilterList videoFilterList;
  
  public CameraARFilterGesture(VideoFilterList paramVideoFilterList)
  {
    this.videoFilterList = paramVideoFilterList;
    this.filterWidth = paramVideoFilterList.filterWidth;
  }
  
  private void addTouchPoint(PointF paramPointF)
  {
    if ((paramPointF != null) && (this.videoFilterList != null))
    {
      this.filterWidth = this.videoFilterList.filterWidth;
      int i = DeviceUtils.getScreenWidth(AEModule.getContext());
      int j = this.filterWidth;
      if ((j > 0) && (i > 0))
      {
        float f = j / i;
        paramPointF.x *= f;
        paramPointF.y = (f * paramPointF.y);
        this.videoFilterList.addTouchPoint(new PointF(paramPointF.x, paramPointF.y));
      }
    }
  }
  
  public int onGetPriority()
  {
    return 1020;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    int j = paramMotionEvent.getAction();
    if (i > 2) {
      return false;
    }
    float f2;
    float f1;
    if ((i == 2) && (paramBoolean))
    {
      i = 1;
      if (i == 0) {
        break label120;
      }
      f2 = GLGestureProxy.getInstance().getScreenCoordinateX(paramMotionEvent.getX(1));
      f1 = GLGestureProxy.getInstance().getScreenCoordinateY(paramMotionEvent.getY(1));
      label63:
      switch (j & 0xFF)
      {
      }
    }
    for (;;)
    {
      return true;
      i = 0;
      break;
      label120:
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      break label63;
      this.mTouchStartPoint.x = f2;
      this.mTouchStartPoint.y = f1;
      this.mNeedRecordTouchPoint = true;
      continue;
      if (AlgoUtils.getDistance(new PointF(this.mTouchStartPoint.x, this.mTouchStartPoint.y), new PointF(f2, f1)) > DeviceUtils.getScreenWidth(AEModule.getContext()) * 0.05F)
      {
        this.mNeedRecordTouchPoint = false;
        continue;
        if ((this.mNeedRecordTouchPoint) && (!paramBoolean)) {
          addTouchPoint(new PointF(f2, f1));
        }
        this.mNeedRecordTouchPoint = true;
        continue;
        if (i != 0)
        {
          this.mTouchStartPoint.x = f2;
          this.mTouchStartPoint.y = f1;
          this.mNeedRecordTouchPoint = true;
          continue;
          if ((this.mNeedRecordTouchPoint) && (i != 0))
          {
            addTouchPoint(new PointF(f2, f1));
            this.mNeedRecordTouchPoint = false;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.filter.CameraARFilterGesture
 * JD-Core Version:    0.7.0.1
 */