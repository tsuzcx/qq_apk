package com.tencent.mobileqq.troop.honor;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService.IGetTroopHonorListCallback;
import com.tencent.qphone.base.util.QLog;

class TroopHonorManager$3
  implements ITroopMemberInfoService.ITroopMemberInfoCallBack
{
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    if (paramTroopMemberInfo != null) {
      paramTroopMemberInfo = this.d.c(paramTroopMemberInfo.honorList);
    } else {
      paramTroopMemberInfo = null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopHonor.manager", 2, String.format("getTroopHonorList, troopUin: %s, memberUin: %s, honorList: %s", new Object[] { this.a, this.b, paramTroopMemberInfo }));
    }
    ITroopHonorService.IGetTroopHonorListCallback localIGetTroopHonorListCallback = this.c;
    if (localIGetTroopHonorListCallback != null) {
      localIGetTroopHonorListCallback.a(paramTroopMemberInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.TroopHonorManager.3
 * JD-Core Version:    0.7.0.1
 */