package com.tencent.mobileqq.troop.utils;

import ajpm;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopFileUploadingManager
{
  public static TroopFileUploadingManager a;
  public BizTroopObserver a;
  public QQAppInterface a;
  
  public TroopFileUploadingManager()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new ajpm(this);
  }
  
  public static TroopFileUploadingManager a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager == null) {
      b(paramQQAppInterface);
    }
    for (;;)
    {
      return jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager;
      if (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
        jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = null;
        b(paramQQAppInterface);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if ((jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager != null) && (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == paramQQAppInterface))
    {
      paramQQAppInterface.removeObserver(jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = new TroopFileUploadingManager();
    jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileUploadingManager
 * JD-Core Version:    0.7.0.1
 */