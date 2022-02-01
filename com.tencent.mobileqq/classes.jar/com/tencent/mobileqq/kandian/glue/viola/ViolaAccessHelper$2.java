package com.tencent.mobileqq.kandian.glue.viola;

import com.tencent.qphone.base.util.QLog;

final class ViolaAccessHelper$2
  implements ViolaAccessHelper.SDKInitCallback
{
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "preInit viola sdk error");
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "preInit viola sdk succ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.2
 * JD-Core Version:    0.7.0.1
 */