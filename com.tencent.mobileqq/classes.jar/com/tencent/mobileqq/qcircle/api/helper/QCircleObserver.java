package com.tencent.mobileqq.qcircle.api.helper;

import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.app.BusinessObserver;

public class QCircleObserver
  implements BusinessObserver
{
  private static final String TAG = "QCircleObserver";
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    paramInt = ((Integer)paramObject).intValue();
    RFLog.d("QCircleObserver", RFLog.USR, "TYPE_UPDATE_RED_POINT_DISPLAY repointNum");
    onUpdateRedPoint(paramInt);
  }
  
  protected void onUpdateRedPoint(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.helper.QCircleObserver
 * JD-Core Version:    0.7.0.1
 */