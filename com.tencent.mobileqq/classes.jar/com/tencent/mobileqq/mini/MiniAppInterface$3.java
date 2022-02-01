package com.tencent.mobileqq.mini;

import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class MiniAppInterface$3
  implements SDKInitListener
{
  MiniAppInterface$3(MiniAppInterface paramMiniAppInterface) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QLog.e("MiniAppInterface", 1, "initSDKAsync failed!");
      return;
    }
    QLog.d("MiniAppInterface", 1, "initSDKAsync succeed!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.MiniAppInterface.3
 * JD-Core Version:    0.7.0.1
 */