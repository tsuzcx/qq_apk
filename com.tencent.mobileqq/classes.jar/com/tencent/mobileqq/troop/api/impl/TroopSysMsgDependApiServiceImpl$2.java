package com.tencent.mobileqq.troop.api.impl;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService.ITransitTroopProtocolOnGetInfoObserver;
import com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol.RequestPublicAccountObserver;

class TroopSysMsgDependApiServiceImpl$2
  extends TroopBindPubAccountProtocol.RequestPublicAccountObserver
{
  TroopSysMsgDependApiServiceImpl$2(TroopSysMsgDependApiServiceImpl paramTroopSysMsgDependApiServiceImpl, ITroopSysMsgDependApiService.ITransitTroopProtocolOnGetInfoObserver paramITransitTroopProtocolOnGetInfoObserver) {}
  
  protected void a(boolean paramBoolean, long paramLong, IPublicAccountDetail paramIPublicAccountDetail)
  {
    ITroopSysMsgDependApiService.ITransitTroopProtocolOnGetInfoObserver localITransitTroopProtocolOnGetInfoObserver = this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopSysMsgDependApiService$ITransitTroopProtocolOnGetInfoObserver;
    if ((localITransitTroopProtocolOnGetInfoObserver != null) && (paramIPublicAccountDetail != null)) {
      localITransitTroopProtocolOnGetInfoObserver.a(paramBoolean, paramLong, paramIPublicAccountDetail.getName());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopSysMsgDependApiServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */