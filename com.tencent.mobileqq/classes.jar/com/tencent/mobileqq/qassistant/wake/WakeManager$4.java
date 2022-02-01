package com.tencent.mobileqq.qassistant.wake;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qassistant.listener.IRecordStreamListener;

class WakeManager$4
  implements IRecordStreamListener
{
  WakeManager$4(WakeManager paramWakeManager, long paramLong) {}
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager.jdField_a_of_type_Long > this.jdField_a_of_type_Long * 0.95D)
    {
      this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager.jdField_a_of_type_Long = l;
      if (WakeManager.b(this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager) != null)
      {
        Message localMessage = WakeManager.b(this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager).obtainMessage(1002);
        localMessage.obj = paramArrayOfByte;
        WakeManager.b(this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager).sendMessage(localMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeManager.4
 * JD-Core Version:    0.7.0.1
 */