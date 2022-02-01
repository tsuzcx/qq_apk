package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FilePreViewControllerBase;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;

public class TroopFilePreviewController
  extends FilePreViewControllerBase
{
  long jdField_a_of_type_Long;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = null;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  TroopFileStatusInfo jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo;
  
  public TroopFilePreviewController(QQAppInterface paramQQAppInterface, long paramLong, TroopFileStatusInfo paramTroopFileStatusInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo = paramTroopFileStatusInfo;
    this.jdField_a_of_type_Long = paramLong;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new TroopFilePreviewController.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
  }
  
  public int a()
  {
    return 3;
  }
  
  public void a()
  {
    BizTroopObserver localBizTroopObserver = this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver;
    if (localBizTroopObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(localBizTroopObserver);
    }
  }
  
  public boolean a()
  {
    TroopFileTransferManager localTroopFileTransferManager = TroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
    if (localTroopFileTransferManager == null) {
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a != null) {
      localTroopFileTransferManager.e(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.a);
    } else {
      localTroopFileTransferManager.a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.e, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.g, this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileStatusInfo.h);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFilePreviewController
 * JD-Core Version:    0.7.0.1
 */