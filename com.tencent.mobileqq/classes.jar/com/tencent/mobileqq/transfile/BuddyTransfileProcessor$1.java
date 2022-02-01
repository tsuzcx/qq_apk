package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.service.message.MessageFactoryReceiver.UploadStreamStruct;
import com.tencent.qphone.base.util.QLog;

class BuddyTransfileProcessor$1
  extends MessageObserver
{
  BuddyTransfileProcessor$1(BuddyTransfileProcessor paramBuddyTransfileProcessor) {}
  
  public void onUpdateUploadStreamFinished(boolean paramBoolean, MessageFactoryReceiver.UploadStreamStruct paramUploadStreamStruct)
  {
    if ((paramUploadStreamStruct != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "onUpdateUploadStreamFinished Key:" + paramUploadStreamStruct.jdField_a_of_type_JavaLangString + " seq:" + paramUploadStreamStruct.jdField_a_of_type_Short + " Layer:" + paramUploadStreamStruct.jdField_a_of_type_Int + " RespCode:" + paramUploadStreamStruct.b);
    }
    if ((this.this$0.file != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "isSuccess:" + paramBoolean + "　FilePath:" + this.this$0.file.filePath + " isStreamPttSuccess:" + this.this$0.isStreamPttSuccess);
    }
    this.this$0.setStepFinishTime(2);
    if ((paramUploadStreamStruct == null) || (paramUploadStreamStruct.jdField_a_of_type_JavaLangString == null) || (!paramUploadStreamStruct.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.this$0.file.filePath))) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor.1
 * JD-Core Version:    0.7.0.1
 */