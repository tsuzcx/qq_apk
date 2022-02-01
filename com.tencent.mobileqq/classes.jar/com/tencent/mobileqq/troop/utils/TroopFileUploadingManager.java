package com.tencent.mobileqq.troop.utils;

import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;

public class TroopFileUploadingManager
{
  public static TroopFileUploadingManager a;
  public BizTroopObserver a;
  public QQAppInterface a;
  
  public TroopFileUploadingManager()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopFileUploadingManager.1(this);
  }
  
  public static TroopFileUploadingManager a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager == null)
      {
        b(paramQQAppInterface);
      }
      else if (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != paramQQAppInterface)
      {
        if (jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
        {
          jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
          jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
        }
        jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = null;
        b(paramQQAppInterface);
      }
      paramQQAppInterface = jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager;
      return paramQQAppInterface;
    }
    finally {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    TroopFileUploadingManager localTroopFileUploadingManager = jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager;
    if (localTroopFileUploadingManager != null)
    {
      paramQQAppInterface.removeObserver(localTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
      jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = null;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface)
  {
    jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager = new TroopFileUploadingManager();
    TroopFileUploadingManager localTroopFileUploadingManager = jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopFileUploadingManager;
    localTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramQQAppInterface.addObserver(localTroopFileUploadingManager.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileUploadingManager
 * JD-Core Version:    0.7.0.1
 */