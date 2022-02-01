package com.tencent.mobileqq.filemanager.app;

import asej;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QFileAppStorePromoteManager$2$2
  implements Runnable
{
  QFileAppStorePromoteManager$2$2(QFileAppStorePromoteManager.2 param2, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, "request appInfo. add reqId[" + this.jdField_a_of_type_Int + "]");
    }
    asej.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileAppStorePromoteManager$2.this$0).put(Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileAppStorePromoteManager$2.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.2.2
 * JD-Core Version:    0.7.0.1
 */