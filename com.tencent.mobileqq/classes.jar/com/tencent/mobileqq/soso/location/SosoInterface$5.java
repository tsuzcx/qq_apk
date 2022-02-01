package com.tencent.mobileqq.soso.location;

import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;

final class SosoInterface$5
  extends SosoInterfaceOnLocationListener
{
  SosoInterface$5(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SOSO.LBS", 2, "onLocationFinish() lock.notifyAll()");
    }
    synchronized (SosoInterface.access$400())
    {
      SosoInterface.access$400().notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterface.5
 * JD-Core Version:    0.7.0.1
 */