package com.tencent.mobileqq.troop.data;

import ajjx;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class TroopFilePreviewController
  extends FilePreViewControllerBase
{
  long jdField_a_of_type_Long;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
  public QQAppInterface a;
  TroopFileStatusInfo jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo;
  
  public TroopFilePreviewController(QQAppInterface paramQQAppInterface, long paramLong, TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo = paramTroopFileStatusInfo;
    this.jdField_a_of_type_Long = paramLong;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new ajjx(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
  
  public int a()
  {
    return 3;
  }
  
  public boolean a()
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (localTroopFileTransferManager == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a != null) {
      localTroopFileTransferManager.e(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a);
    }
    for (;;)
    {
      return true;
      localTroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.jdField_e_of_type_Int);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFilePreviewController
 * JD-Core Version:    0.7.0.1
 */