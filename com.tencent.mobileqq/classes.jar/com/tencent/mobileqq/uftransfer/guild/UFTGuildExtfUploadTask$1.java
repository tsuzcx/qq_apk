package com.tencent.mobileqq.uftransfer.guild;

import com.tencent.mobileqq.uftransfer.task.upload.UFTUploadCbWrapper;

class UFTGuildExtfUploadTask$1
  implements Runnable
{
  UFTGuildExtfUploadTask$1(UFTGuildExtfUploadTask paramUFTGuildExtfUploadTask) {}
  
  public void run()
  {
    if (UFTGuildExtfUploadTask.a(this.this$0)) {
      return;
    }
    UFTGuildExtfUploadTask.c(this.this$0).a(UFTGuildExtfUploadTask.b(this.this$0), 1, null);
    String str = this.this$0.i();
    if (UFTGuildExtfUploadTask.a(this.this$0, str))
    {
      if (!UFTGuildExtfUploadTask.b(this.this$0, str)) {
        return;
      }
      this.this$0.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.guild.UFTGuildExtfUploadTask.1
 * JD-Core Version:    0.7.0.1
 */