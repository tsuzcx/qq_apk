package com.tencent.mobileqq.transfile;

import aywa;
import bben;
import com.tencent.qphone.base.util.QLog;

class ShortVideoUploadProcessor$7
  implements Runnable
{
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitEntireVideo");
    }
    bben.a(String.valueOf(this.this$0.a.a), "submitEntireVideo", "videoPath = " + this.jdField_a_of_type_JavaLangString);
    synchronized (this.this$0)
    {
      if (ShortVideoUploadProcessor.a(this.this$0) != 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitEntireVideo mSwitch != SWITCH_PRE_UPLOAD  mSwitch : " + ShortVideoUploadProcessor.a(this.this$0));
        }
        return;
      }
      this.this$0.a.i = (this.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + this.this$0.a.j + "QQ_&_MoblieQQ_&_QQ" + this.jdField_a_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + this.this$0.a.k);
      ShortVideoUploadProcessor.b(this.this$0, 2);
      bben.a(String.valueOf(this.this$0.a.a), "submitEntireVideo", "mUiRequest.mLocalPath = " + this.this$0.a.i + ",mVideoPreUpStatus = " + ShortVideoUploadProcessor.b(this.this$0) + ", mVideoRecordStatus = " + ShortVideoUploadProcessor.c(this.this$0));
      if ((ShortVideoUploadProcessor.b(this.this$0) == 1) || (ShortVideoUploadProcessor.b(this.this$0) == 2) || (ShortVideoUploadProcessor.c(this.this$0) == 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> submitEntireVideo mVideoPreUpStatus = " + ShortVideoUploadProcessor.b(this.this$0) + " mVideoRecordStatus = " + ShortVideoUploadProcessor.c(this.this$0));
        }
        ShortVideoUploadProcessor.a(this.this$0);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.7
 * JD-Core Version:    0.7.0.1
 */