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
    double d1 = l - this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager.jdField_a_of_type_Long;
    double d2 = this.jdField_a_of_type_Long;
    Double.isNaN(d2);
    if (d1 > d2 * 0.95D)
    {
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager;
      ((WakeManager)localObject).jdField_a_of_type_Long = l;
      if (WakeManager.b((WakeManager)localObject) != null)
      {
        localObject = WakeManager.b(this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager).obtainMessage(1002);
        ((Message)localObject).obj = paramArrayOfByte;
        WakeManager.b(this.jdField_a_of_type_ComTencentMobileqqQassistantWakeWakeManager).sendMessage((Message)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.WakeManager.4
 * JD-Core Version:    0.7.0.1
 */