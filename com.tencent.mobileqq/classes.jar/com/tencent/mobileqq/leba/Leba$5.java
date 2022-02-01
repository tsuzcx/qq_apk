package com.tencent.mobileqq.leba;

import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;

class Leba$5
  extends ResourcePluginListener
{
  Leba$5(Leba paramLeba) {}
  
  public void a(byte paramByte)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("ResourcePluginListener", 4, "ResourcePluginListener listener notify = " + paramByte);
    }
    if (paramByte != -1) {
      this.a.a.sendEmptyMessage(11340002);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.Leba.5
 * JD-Core Version:    0.7.0.1
 */