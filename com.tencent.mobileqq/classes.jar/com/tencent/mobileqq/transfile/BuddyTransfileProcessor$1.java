package com.tencent.mobileqq.transfile;

import amwl;
import bbkz;
import com.tencent.qphone.base.util.QLog;

class BuddyTransfileProcessor$1
  extends amwl
{
  BuddyTransfileProcessor$1(BuddyTransfileProcessor paramBuddyTransfileProcessor) {}
  
  public void onUpdateUploadStreamFinished(boolean paramBoolean, bbkz parambbkz)
  {
    if ((parambbkz != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "onUpdateUploadStreamFinished Key:" + parambbkz.jdField_a_of_type_JavaLangString + " seq:" + parambbkz.jdField_a_of_type_Short + " Layer:" + parambbkz.jdField_a_of_type_Int + " RespCode:" + parambbkz.b);
    }
    if ((this.this$0.file != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "isSuccess:" + paramBoolean + "　FilePath:" + this.this$0.file.filePath + " isStreamPttSuccess:" + this.this$0.isStreamPttSuccess);
    }
    this.this$0.setStepFinishTime(2);
    if ((parambbkz == null) || (parambbkz.jdField_a_of_type_JavaLangString == null) || (!parambbkz.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.this$0.file.filePath))) {
      return;
    }
    if (!paramBoolean)
    {
      BuddyTransfileProcessor.access$000(this.this$0, false, parambbkz);
      return;
    }
    BuddyTransfileProcessor.access$000(this.this$0, true, parambbkz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor.1
 * JD-Core Version:    0.7.0.1
 */