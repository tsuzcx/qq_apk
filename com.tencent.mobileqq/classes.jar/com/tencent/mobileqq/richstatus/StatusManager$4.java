package com.tencent.mobileqq.richstatus;

import com.etrump.mixlayout.VasFontIPCModule;
import com.tencent.mobileqq.app.SignatureObserver;

class StatusManager$4
  extends SignatureObserver
{
  StatusManager$4(StatusManager paramStatusManager) {}
  
  protected void g(boolean paramBoolean, Object paramObject)
  {
    int j = ((Integer)paramObject).intValue();
    paramObject = VasFontIPCModule.a();
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = -1;
    }
    paramObject.b(i, j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusManager.4
 * JD-Core Version:    0.7.0.1
 */