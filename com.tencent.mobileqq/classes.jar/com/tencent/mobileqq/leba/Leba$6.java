package com.tencent.mobileqq.leba;

import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;

class Leba$6
  extends ResourcePluginListener
{
  Leba$6(Leba paramLeba) {}
  
  public void a(byte paramByte)
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ResourcePluginListener listener notify = ");
      localStringBuilder.append(paramByte);
      QLog.d("ResourcePluginListener", 4, localStringBuilder.toString());
    }
    if (paramByte != -1) {
      this.a.k.sendEmptyMessage(11340002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.6
 * JD-Core Version:    0.7.0.1
 */