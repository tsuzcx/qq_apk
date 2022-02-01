package com.tencent.mobileqq.filemanager.app;

import asej;
import aseq;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class QFileAppStorePromoteManager$2$3
  implements Runnable
{
  QFileAppStorePromoteManager$2$3(QFileAppStorePromoteManager.2 param2, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileAppStorePromoteManager$2.a.a();
    aseq localaseq = (aseq)asej.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileAppStorePromoteManager$2.this$0).remove(Integer.valueOf(this.jdField_a_of_type_Int));
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("request appInfo time limit. remove reqId[").append(this.jdField_a_of_type_Int).append("] result[");
      if (localaseq == null) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("QFileAppStorePromoteManager<QFile>", 1, bool + "]");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.2.3
 * JD-Core Version:    0.7.0.1
 */