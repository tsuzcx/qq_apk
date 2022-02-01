package com.tencent.mobileqq.flashshow.part;

import com.tencent.mobileqq.qcircle.api.helper.HostUIHelper;
import com.tencent.qphone.base.util.QLog;

class FSSharePart$3
  implements Runnable
{
  FSSharePart$3(FSSharePart paramFSSharePart) {}
  
  public void run()
  {
    HostUIHelper.closeHostEnvironment();
    FSSharePart.a(this.this$0, null);
    QLog.d("FSSharePart", 1, "delayedCloseHostEnvironment");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSSharePart.3
 * JD-Core Version:    0.7.0.1
 */