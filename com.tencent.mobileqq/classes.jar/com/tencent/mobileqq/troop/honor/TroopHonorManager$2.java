package com.tencent.mobileqq.troop.honor;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService.IGetTroopHonorListCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class TroopHonorManager$2
  implements ITroopMemberInfoService.ITroopMemberInfoCallBack
{
  TroopHonorManager$2(TroopHonorManager paramTroopHonorManager, String paramString1, String paramString2, ITroopHonorService.IGetTroopHonorListCallback paramIGetTroopHonorListCallback) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    List localList = null;
    if (paramTroopMemberInfo != null) {
      localList = this.jdField_a_of_type_ComTencentMobileqqTroopHonorTroopHonorManager.a(paramTroopMemberInfo.honorList, Byte.valueOf(paramTroopMemberInfo.mHonorRichFlag));
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("getTroopHonorList, troopUin: %s, memberUin: %s, honorList: %s", new Object[] { this.jdField_a_of_type_JavaLangString, this.b, localList }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopHonorApiITroopHonorService$IGetTroopHonorListCallback != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopHonorApiITroopHonorService$IGetTroopHonorListCallback.a(localList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.TroopHonorManager.2
 * JD-Core Version:    0.7.0.1
 */