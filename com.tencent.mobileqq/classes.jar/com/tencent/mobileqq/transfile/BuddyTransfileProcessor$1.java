package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.qphone.base.util.QLog;

class BuddyTransfileProcessor$1
  extends MessageObserver
{
  BuddyTransfileProcessor$1(BuddyTransfileProcessor paramBuddyTransfileProcessor) {}
  
  protected void onUpdateUploadStreamFinished(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct)
  {
    StringBuilder localStringBuilder;
    if ((paramUploadStreamStruct != null) && (QLog.isColorLevel()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateUploadStreamFinished Key:");
      localStringBuilder.append(paramUploadStreamStruct.a);
      localStringBuilder.append(" seq:");
      localStringBuilder.append(paramUploadStreamStruct.b);
      localStringBuilder.append(" Layer:");
      localStringBuilder.append(paramUploadStreamStruct.c);
      localStringBuilder.append(" RespCode:");
      localStringBuilder.append(paramUploadStreamStruct.e);
      QLog.e("streamptt.send", 2, localStringBuilder.toString());
    }
    if ((this.this$0.file != null) && (QLog.isColorLevel()))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("　FilePath:");
      localStringBuilder.append(this.this$0.file.filePath);
      localStringBuilder.append(" isStreamPttSuccess:");
      localStringBuilder.append(this.this$0.isStreamPttSuccess);
      QLog.e("streamptt.send", 2, localStringBuilder.toString());
    }
    if ((paramUploadStreamStruct != null) && (paramUploadStreamStruct.a != null))
    {
      if (!paramUploadStreamStruct.a.equalsIgnoreCase(this.this$0.file.filePath)) {
        return;
      }
      if (!paramBoolean)
      {
        BuddyTransfileProcessor.access$000(this.this$0, false, paramUploadStreamStruct);
        return;
      }
      BuddyTransfileProcessor.access$000(this.this$0, true, paramUploadStreamStruct);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor.1
 * JD-Core Version:    0.7.0.1
 */