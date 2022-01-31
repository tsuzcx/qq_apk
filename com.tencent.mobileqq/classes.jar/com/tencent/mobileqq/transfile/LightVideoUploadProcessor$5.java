package com.tencent.mobileqq.transfile;

import axtf;
import axtg;
import baqf;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

public class LightVideoUploadProcessor$5
  implements Runnable
{
  public LightVideoUploadProcessor$5(baqf parambaqf, axtf paramaxtf) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "onSendSliceFinish, info:" + this.a + " mSendingInfos:" + this.this$0.jdField_b_of_type_JavaUtilMap.size() + " mReadyToSendInfos:" + this.this$0.jdField_b_of_type_JavaUtilArrayList.size());
    }
    this.this$0.jdField_b_of_type_JavaUtilMap.remove(Integer.valueOf(this.a.d));
    if (this.this$0.jdField_b_of_type_JavaUtilArrayList.size() > 0) {
      this.this$0.s();
    }
    while ((this.this$0.jdField_b_of_type_JavaUtilArrayList.size() != 0) || (this.this$0.jdField_b_of_type_JavaUtilMap.size() != 0) || (baqf.a(this.this$0) == null) || (!baqf.a(this.this$0).a())) {
      return;
    }
    this.this$0.r();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.LightVideoUploadProcessor.5
 * JD-Core Version:    0.7.0.1
 */