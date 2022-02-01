package com.tencent.mobileqq.troop.troopapps.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.troopapps.data.TroopAppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class TroopCardAppInfoHelperApiImpl$1
  implements BusinessObserver
{
  TroopCardAppInfoHelperApiImpl$1(TroopCardAppInfoHelperApiImpl paramTroopCardAppInfoHelperApiImpl, boolean paramBoolean) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiImplTroopCardAppInfoHelperApiImpl.bIsDestroy) {
      return;
    }
    if ((paramBoolean) && (paramBundle != null))
    {
      paramBundle = paramBundle.getByteArray("data");
      Object localObject = new oidb_sso.OIDBSSOPkg();
      try
      {
        ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramBundle);
        if ((((oidb_sso.OIDBSSOPkg)localObject).uint32_result.has()) && (((oidb_sso.OIDBSSOPkg)localObject).uint32_result.get() == 0) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.has()) && (((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.get() != null))
        {
          localObject = TroopCardAppInfoHelperApiImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiImplTroopCardAppInfoHelperApiImpl, (oidb_sso.OIDBSSOPkg)localObject);
          if ((localObject != null) && (((ArrayList)localObject).size() > 0))
          {
            if (!this.jdField_a_of_type_Boolean)
            {
              TroopCardAppInfoHelperApiImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiImplTroopCardAppInfoHelperApiImpl, (List)localObject);
              return;
            }
            paramBundle = new ArrayList();
            localObject = ((ArrayList)localObject).iterator();
            while (((Iterator)localObject).hasNext())
            {
              Long localLong = (Long)((Iterator)localObject).next();
              new TroopAppInfo().appId = localLong.longValue();
            }
            TroopCardAppInfoHelperApiImpl.access$300(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiImplTroopCardAppInfoHelperApiImpl, paramBundle);
            return;
          }
          TroopCardAppInfoHelperApiImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiImplTroopCardAppInfoHelperApiImpl);
          return;
        }
        TroopCardAppInfoHelperApiImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiImplTroopCardAppInfoHelperApiImpl);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("handleGetTroopAppBriefList error ");
          ((StringBuilder)localObject).append(QLog.getStackTraceString(paramBundle));
          QLog.d("TroopCardAppInfoHandler", 2, ((StringBuilder)localObject).toString());
        }
        TroopCardAppInfoHelperApiImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiImplTroopCardAppInfoHelperApiImpl);
        return;
      }
    }
    TroopCardAppInfoHelperApiImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqTroopTroopappsApiImplTroopCardAppInfoHelperApiImpl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopCardAppInfoHelperApiImpl.1
 * JD-Core Version:    0.7.0.1
 */