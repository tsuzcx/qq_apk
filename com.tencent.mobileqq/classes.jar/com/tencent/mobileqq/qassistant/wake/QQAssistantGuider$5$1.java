package com.tencent.mobileqq.qassistant.wake;

import mqq.app.QQPermissionCallback;

class QQAssistantGuider$5$1
  implements QQPermissionCallback
{
  QQAssistantGuider$5$1(QQAssistantGuider.5 param5) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt) {}
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    WakeManager.a().a("QQAssistantGuider");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.QQAssistantGuider.5.1
 * JD-Core Version:    0.7.0.1
 */