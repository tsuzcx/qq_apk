package com.tencent.mobileqq.jubao;

import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class JubaoApiPlugin$1
  implements EIPCResultCallback
{
  JubaoApiPlugin$1(JubaoApiPlugin paramJubaoApiPlugin) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      boolean bool = paramEIPCResult.data.getBoolean("receive_success");
      this.a.a(0, bool, paramEIPCResult.data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jubao.JubaoApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */