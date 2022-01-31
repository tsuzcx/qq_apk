package com.tencent.mobileqq.hiboom;

import android.content.Context;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;

public class HiBoomManager$HiBoomAuthObserver
  extends MessageObserver
{
  private Context a;
  
  protected void a(int paramInt, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("HiBoomFont.HiBoomManager", 2, "onHiBoomAuthResult errorCode = " + paramInt);
    }
    if (paramInt != 0) {
      HiBoomManager.a(this.a, paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.HiBoomManager.HiBoomAuthObserver
 * JD-Core Version:    0.7.0.1
 */