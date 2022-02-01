package com.tencent.mobileqq.winkpublish.task;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.winkpublish.event.BoxProgressStatusEvent;
import com.tencent.qphone.base.util.QLog;

class FSUploadShuoShuoTask$5
  implements Runnable
{
  FSUploadShuoShuoTask$5(FSUploadShuoShuoTask paramFSUploadShuoShuoTask) {}
  
  public void run()
  {
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, "run... CancelUploadRunnable");
    BoxProgressStatusEvent localBoxProgressStatusEvent = new BoxProgressStatusEvent(1);
    SimpleEventBus.getInstance().dispatchEvent(localBoxProgressStatusEvent);
    this.this$0.cancel();
    FSUploadShuoShuoTask.e(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.FSUploadShuoShuoTask.5
 * JD-Core Version:    0.7.0.1
 */