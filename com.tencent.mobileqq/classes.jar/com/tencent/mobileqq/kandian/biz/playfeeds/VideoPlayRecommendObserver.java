package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public class VideoPlayRecommendObserver
  implements BusinessObserver
{
  protected void a(boolean paramBoolean, Bundle paramBundle) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject != null)
    {
      paramObject = (Bundle)paramObject;
      if (paramObject.getInt("VALUE_OBSERVER_TAG") != hashCode()) {
        return;
      }
      try
      {
        a(paramBoolean, paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        paramObject.printStackTrace();
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.e("VideoPlayRecommendObserver", 2, "onUpdate: error, data null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoPlayRecommendObserver
 * JD-Core Version:    0.7.0.1
 */