package com.tencent.mobileqq.winkpublish.task;

import com.tencent.qphone.base.util.QLog;

class AUploadBaseUploadShuoShuoTask$1
  implements Runnable
{
  AUploadBaseUploadShuoShuoTask$1(AUploadBaseUploadShuoShuoTask paramAUploadBaseUploadShuoShuoTask) {}
  
  public void run()
  {
    if (this.this$0.t != 3) {
      return;
    }
    String str = AUploadBaseUploadShuoShuoTask.m();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.this$0.k());
    localStringBuilder.append(", libavcodec download timeout, go to next step");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.this$0.getState() != 1)
    {
      str = AUploadBaseUploadShuoShuoTask.m();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.this$0.k());
      localStringBuilder.append(", change state to running");
      QLog.i(str, 1, localStringBuilder.toString());
      this.this$0.a(1);
    }
    AUploadBaseUploadShuoShuoTask.a(this.this$0, true);
    this.this$0.b();
    AUploadBaseUploadShuoShuoTask.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.task.AUploadBaseUploadShuoShuoTask.1
 * JD-Core Version:    0.7.0.1
 */