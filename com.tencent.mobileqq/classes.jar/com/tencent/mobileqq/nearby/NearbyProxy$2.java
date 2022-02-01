package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.qphone.base.util.QLog;

class NearbyProxy$2
  implements ConditionSearchManager.IConfigListener
{
  NearbyProxy$2(NearbyProxy paramNearbyProxy) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.dating", 2, "onGetConfig, resultCode:" + paramInt + ",isSuccess:" + paramBoolean);
    }
    NearbyProxy.a(this.a, 4131, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy.2
 * JD-Core Version:    0.7.0.1
 */