package com.tencent.mobileqq.transfile;

import anyz;
import bcrr;
import com.tencent.qphone.base.util.QLog;

class BuddyTransfileProcessor$1
  extends anyz
{
  BuddyTransfileProcessor$1(BuddyTransfileProcessor paramBuddyTransfileProcessor) {}
  
  public void onUpdateUploadStreamFinished(boolean paramBoolean, bcrr parambcrr)
  {
    if ((parambcrr != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "onUpdateUploadStreamFinished Key:" + parambcrr.jdField_a_of_type_JavaLangString + " seq:" + parambcrr.jdField_a_of_type_Short + " Layer:" + parambcrr.jdField_a_of_type_Int + " RespCode:" + parambcrr.b);
    }
    if ((this.this$0.file != null) && (QLog.isColorLevel())) {
      QLog.e("streamptt.send", 2, "isSuccess:" + paramBoolean + "　FilePath:" + this.this$0.file.filePath + " isStreamPttSuccess:" + this.this$0.isStreamPttSuccess);
    }
    this.this$0.setStepFinishTime(2);
    if ((parambcrr == null) || (parambcrr.jdField_a_of_type_JavaLangString == null) || (!parambcrr.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.this$0.file.filePath))) {
      return;
    }
    if (!paramBoolean)
    {
      BuddyTransfileProcessor.access$000(this.this$0, false, parambcrr);
      return;
    }
    BuddyTransfileProcessor.access$000(this.this$0, true, parambcrr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BuddyTransfileProcessor.1
 * JD-Core Version:    0.7.0.1
 */