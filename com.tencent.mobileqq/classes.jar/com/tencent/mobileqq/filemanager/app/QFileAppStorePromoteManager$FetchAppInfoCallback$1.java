package com.tencent.mobileqq.filemanager.app;

import com.tencent.tmassistant.appinfo.data.AppDetail;
import java.util.HashMap;
import java.util.List;

class QFileAppStorePromoteManager$FetchAppInfoCallback$1
  implements Runnable
{
  QFileAppStorePromoteManager$FetchAppInfoCallback$1(QFileAppStorePromoteManager.FetchAppInfoCallback paramFetchAppInfoCallback, int paramInt1, int paramInt2, List paramList) {}
  
  public void run()
  {
    QFileAppStorePromoteManager.IGetAppDetailCallback localIGetAppDetailCallback = (QFileAppStorePromoteManager.IGetAppDetailCallback)QFileAppStorePromoteManager.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppQFileAppStorePromoteManager$FetchAppInfoCallback.a).get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localIGetAppDetailCallback != null)
    {
      boolean bool;
      if (this.b == 0) {
        bool = true;
      } else {
        bool = false;
      }
      localIGetAppDetailCallback.a(bool, (AppDetail)this.jdField_a_of_type_JavaUtilList.get(0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.QFileAppStorePromoteManager.FetchAppInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */