package com.tencent.mobileqq.winkpublish.task;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.winkpublish.event.BoxProgressStatusEvent;
import com.tencent.qphone.base.util.QLog;

class FSUploadShuoShuoTask$4
  implements Runnable
{
  FSUploadShuoShuoTask$4(FSUploadShuoShuoTask paramFSUploadShuoShuoTask) {}
  
  public void run()
  {
    QLog.d("[upload2_FSUploadShuoShuoTask]", 1, "run... showCloseBt");
    FSUploadShuoShuoTask.a(this.this$0, true);
    BoxProgressStatusEvent localBoxProgressStatusEvent = new BoxProgressStatusEvent(0);
    SimpleEventBus.getInstance().dispatchEvent(localBoxProgressStatusEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.FSUploadShuoShuoTask.4
 * JD-Core Version:    0.7.0.1
 */