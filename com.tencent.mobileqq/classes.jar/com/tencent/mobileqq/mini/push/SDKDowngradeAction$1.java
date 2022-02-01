package com.tencent.mobileqq.mini.push;

import android.os.Process;

class SDKDowngradeAction$1
  implements Runnable
{
  SDKDowngradeAction$1(SDKDowngradeAction paramSDKDowngradeAction) {}
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.push.SDKDowngradeAction.1
 * JD-Core Version:    0.7.0.1
 */