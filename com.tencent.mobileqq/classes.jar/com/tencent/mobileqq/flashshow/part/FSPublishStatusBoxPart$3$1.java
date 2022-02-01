package com.tencent.mobileqq.flashshow.part;

import com.tencent.qphone.base.util.QLog;

class FSPublishStatusBoxPart$3$1
  implements Runnable
{
  FSPublishStatusBoxPart$3$1(FSPublishStatusBoxPart.3 param3) {}
  
  public void run()
  {
    QLog.e("FSPublishStatusBoxPart", 1, "mPublishQueueListener:onQueueChanged");
    FSPublishStatusBoxPart.b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.part.FSPublishStatusBoxPart.3.1
 * JD-Core Version:    0.7.0.1
 */