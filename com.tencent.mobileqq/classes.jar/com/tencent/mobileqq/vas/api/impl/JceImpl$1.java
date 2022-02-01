package com.tencent.mobileqq.vas.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessObserver;
import eipc.EIPCCallback.Stub;
import eipc.EIPCResult;
import java.io.Serializable;

class JceImpl$1
  extends EIPCCallback.Stub
{
  JceImpl$1(JceImpl paramJceImpl, BusinessObserver paramBusinessObserver) {}
  
  public void callback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null))
    {
      Serializable localSerializable = paramEIPCResult.data.getSerializable("rspBytes");
      boolean bool = paramEIPCResult.data.getBoolean("isSuccess");
      int i = paramEIPCResult.data.getInt("type");
      paramEIPCResult = this.a;
      if (paramEIPCResult != null) {
        paramEIPCResult.onUpdate(i, bool, localSerializable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.api.impl.JceImpl.1
 * JD-Core Version:    0.7.0.1
 */