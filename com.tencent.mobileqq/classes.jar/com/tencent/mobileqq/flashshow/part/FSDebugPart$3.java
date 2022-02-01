package com.tencent.mobileqq.flashshow.part;

import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;

class FSDebugPart$3
  implements Runnable
{
  FSDebugPart$3(FSDebugPart paramFSDebugPart) {}
  
  public void run()
  {
    HostUIHelper.closeHostEnvironment();
    QLog.d("FSDebugPart", 1, "delayedCloseHostEnvironment");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSDebugPart.3
 * JD-Core Version:    0.7.0.1
 */