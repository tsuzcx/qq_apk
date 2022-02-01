package com.tencent.mobileqq.troop.utils.api.impl;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils.TroopPrivilegeCallback;
import tencent.mobileim.structmsg.structmsg.StructMsg;

class TroopUtilsApiImpl$1
  extends ProtoUtils.TroopProtocolObserver
{
  TroopUtilsApiImpl$1(TroopUtilsApiImpl paramTroopUtilsApiImpl, String paramString, Context paramContext, structmsg.StructMsg paramStructMsg, TroopNotificationUtils.TroopPrivilegeCallback paramTroopPrivilegeCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    TroopUtilsApiImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsApiImplTroopUtilsApiImpl, paramInt, paramArrayOfByte, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationUtilsTroopNotificationUtils$TroopPrivilegeCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.api.impl.TroopUtilsApiImpl.1
 * JD-Core Version:    0.7.0.1
 */