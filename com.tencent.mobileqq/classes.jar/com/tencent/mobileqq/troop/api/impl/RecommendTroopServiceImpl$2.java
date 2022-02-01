package com.tencent.mobileqq.troop.api.impl;

import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class RecommendTroopServiceImpl$2
  implements BusinessObserver
{
  RecommendTroopServiceImpl$2(RecommendTroopServiceImpl paramRecommendTroopServiceImpl, long paramLong) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.b.mGetRecommmendTroopLock.append(2, Boolean.valueOf(false));
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRecommendTroopFromServer onReceive :");
      localStringBuilder.append(paramBoolean);
      QLog.d("RecommendTroopServiceImpl", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle != null)
      {
        RecommendTroopServiceImpl.access$000(this.b, 2, this.a, paramBundle);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("RecommendTroopServiceImpl", 2, "getRecommendTroopFromServer success data is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.RecommendTroopServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */