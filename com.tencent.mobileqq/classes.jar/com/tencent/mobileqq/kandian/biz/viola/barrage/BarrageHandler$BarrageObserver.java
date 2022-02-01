package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;

public abstract class BarrageHandler$BarrageObserver
  implements BusinessObserver
{
  public abstract void a(boolean paramBoolean, Bundle paramBundle);
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject != null)
    {
      try
      {
        a(paramBoolean, (Bundle)paramObject);
        return;
      }
      catch (Exception paramObject)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetBarrageList Error: ");
      localStringBuilder.append(paramObject.getMessage());
      QLog.d("BarrageHandler", 2, localStringBuilder.toString());
    }
    else
    {
      a(false, new Bundle());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageHandler.BarrageObserver
 * JD-Core Version:    0.7.0.1
 */