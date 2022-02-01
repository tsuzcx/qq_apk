package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.data.troop.ITroopInfoCallback;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TroopInfoServiceImpl$1$1
  implements Runnable
{
  TroopInfoServiceImpl$1$1(TroopInfoServiceImpl.1 param1, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    Object localObject = (List)TroopInfoServiceImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqTroopApiImplTroopInfoServiceImpl$1.this$0).remove(this.jdField_a_of_type_ComTencentMobileqqTroopApiImplTroopInfoServiceImpl$1.a);
    if (QLog.isColorLevel()) {
      QLog.i("TroopManager", 2, "asyncGetTroopInfo, size=" + ((List)localObject).size());
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ITroopInfoCallback localITroopInfoCallback = (ITroopInfoCallback)((WeakReference)((Iterator)localObject).next()).get();
      if (localITroopInfoCallback != null) {
        localITroopInfoCallback.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.TroopInfoServiceImpl.1.1
 * JD-Core Version:    0.7.0.1
 */