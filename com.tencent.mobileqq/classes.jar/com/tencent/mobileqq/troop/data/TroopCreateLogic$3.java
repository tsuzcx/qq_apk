package com.tencent.mobileqq.troop.data;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.qphone.base.util.QLog;

class TroopCreateLogic$3
  extends TroopBusinessObserver
{
  TroopCreateLogic$3(TroopCreateLogic paramTroopCreateLogic) {}
  
  public void onTroopManagerFailed(int paramInt1, int paramInt2)
  {
    QLog.e("TroopCreateLogic", 1, "onTroopManagerFailed, result = " + paramInt2);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback != null)
    {
      if (paramInt1 == 8) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.b(paramInt2, "");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback = null;
    }
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.a.jdField_a_of_type_ComTencentMobileqqAppTroopBusinessObserver);
    if (paramInt1 == 8)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback != null) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopCreateLogic$TroopCreateCallback.b(0, paramString);
      }
      this.a.a(paramString, true, "");
      ((TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b(Long.parseLong(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopCreateLogic.3
 * JD-Core Version:    0.7.0.1
 */