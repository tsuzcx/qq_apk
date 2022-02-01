package com.tencent.mobileqq.ocr;

import ayxt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;

public class OCRManager$3
  implements Runnable
{
  public OCRManager$3(ayxt paramayxt, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.manager", 2, "onGetOCRConfig ,excute runnable");
    }
    if ((this.a) && (this.this$0.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null)) {
      synchronized (ayxt.a(this.this$0))
      {
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig != null) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqOcrDataOcrConfig.saveToFile(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRManager.3
 * JD-Core Version:    0.7.0.1
 */