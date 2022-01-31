package com.tencent.mobileqq.transfile;

import bard;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ShortVideoUploadProcessor$8
  implements Runnable
{
  public void run()
  {
    synchronized (this.this$0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<PreUploadVideo><BDH_LOG> cancelCurrentSlices isNeedWait:" + this.jdField_a_of_type_Boolean + " cancelReason:" + this.jdField_a_of_type_Int);
      }
      if (ShortVideoUploadProcessor.a(this.this$0) != 3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> cancelCurrentSlices mSwitch != SWITCH_PRE_UPLOAD  mSwitch : " + ShortVideoUploadProcessor.a(this.this$0));
        }
        return;
      }
      ShortVideoUploadProcessor.b(this.this$0, 3);
      ShortVideoUploadProcessor.c(this.this$0, 1);
      this.this$0.y = this.jdField_a_of_type_Int;
      Iterator localIterator = this.this$0.c.iterator();
      if (localIterator.hasNext()) {
        ((Transaction)localIterator.next()).cancelTransaction();
      }
    }
    this.this$0.c.clear();
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck != null)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHwEngine().cancelAckRequest(this.this$0.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck);
      this.this$0.jdField_a_of_type_ComTencentMobileqqHighwaySegmentRequestAck = null;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.this$0.s();
      this.this$0.jdField_a_of_type_Bard.a(this.this$0.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor.8
 * JD-Core Version:    0.7.0.1
 */