package com.tencent.mobileqq.qcircle.api.helper;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

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
    QLog.d("QCircleObserver", 1, "TYPE_UPDATE_RED_POINT_DISPLAY repointNum");
    onUpdateRedPoint(paramInt);
  }
  
  protected void onUpdateRedPoint(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.helper.QCircleObserver
 * JD-Core Version:    0.7.0.1
 */