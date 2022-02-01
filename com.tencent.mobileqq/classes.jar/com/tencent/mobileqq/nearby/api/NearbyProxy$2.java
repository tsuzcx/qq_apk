package com.tencent.mobileqq.nearby.api;

import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.qphone.base.util.QLog;

class NearbyProxy$2
  implements ConditionSearchManager.IConfigListener
{
  NearbyProxy$2(NearbyProxy paramNearbyProxy) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetConfig, resultCode:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",isSuccess:");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.dating", 2, localStringBuilder.toString());
    }
    NearbyProxy.a(this.a, 4131, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyProxy.2
 * JD-Core Version:    0.7.0.1
 */