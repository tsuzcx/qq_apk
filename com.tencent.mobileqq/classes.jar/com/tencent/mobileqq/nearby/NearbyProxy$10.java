package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.ShieldListObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class NearbyProxy$10
  extends ShieldListObserver
{
  NearbyProxy$10(NearbyProxy paramNearbyProxy) {}
  
  public void a(boolean paramBoolean, List<Long> paramList, int paramInt)
  {
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProxy", 2, "onAddShieldList from nearby");
      }
      NearbyProxy.a(this.a, 4113, new Object[] { Boolean.valueOf(paramBoolean), paramList });
    }
  }
  
  public void b(boolean paramBoolean, List<Long> paramList, int paramInt)
  {
    if (paramInt == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyProxy", 2, "onDeleteShieldList from nearby");
      }
      NearbyProxy.a(this.a, 4114, new Object[] { Boolean.valueOf(paramBoolean), paramList });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyProxy.10
 * JD-Core Version:    0.7.0.1
 */