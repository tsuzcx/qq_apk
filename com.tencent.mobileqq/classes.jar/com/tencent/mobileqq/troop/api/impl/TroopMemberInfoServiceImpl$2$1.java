package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.troop.api.ITroopMemberInfoService.ITroopMemberInfoCallBack;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TroopMemberInfoServiceImpl$2$1
  implements Runnable
{
  TroopMemberInfoServiceImpl$2$1(TroopMemberInfoServiceImpl.2 param2, TroopMemberInfo paramTroopMemberInfo) {}
  
  public void run()
  {
    Object localObject = (List)this.jdField_a_of_type_ComTencentMobileqqTroopApiImplTroopMemberInfoServiceImpl$2.this$0.mTmiCallBackRefMap.remove(this.jdField_a_of_type_ComTencentMobileqqTroopApiImplTroopMemberInfoServiceImpl$2.a + "_" + this.jdField_a_of_type_ComTencentMobileqqTroopApiImplTroopMemberInfoServiceImpl$2.b);
    if (QLog.isColorLevel()) {
      QLog.i("TroopManager", 2, "getTroopMemberInfo, size=" + ((List)localObject).size());
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ITroopMemberInfoService.ITroopMemberInfoCallBack localITroopMemberInfoCallBack = (ITroopMemberInfoService.ITroopMemberInfoCallBack)((WeakReference)((Iterator)localObject).next()).get();
      if (localITroopMemberInfoCallBack != null) {
        localITroopMemberInfoCallBack.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopMemberInfoServiceImpl.2.1
 * JD-Core Version:    0.7.0.1
 */