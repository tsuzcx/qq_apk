package com.tencent.mobileqq.mini.reuse;

import com.tencent.mobileqq.mini.report.MiniProgramReporter;

class MiniAppTransferModule$2
  implements Runnable
{
  MiniAppTransferModule$2(MiniAppTransferModule paramMiniAppTransferModule) {}
  
  public void run()
  {
    MiniProgramReporter.getInstance().reportImmediatelyLaunchDcData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.reuse.MiniAppTransferModule.2
 * JD-Core Version:    0.7.0.1
 */