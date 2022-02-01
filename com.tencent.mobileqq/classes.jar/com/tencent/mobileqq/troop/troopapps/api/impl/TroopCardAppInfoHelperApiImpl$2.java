package com.tencent.mobileqq.troop.troopapps.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class TroopCardAppInfoHelperApiImpl$2
  implements BusinessObserver
{
  TroopCardAppInfoHelperApiImpl$2(TroopCardAppInfoHelperApiImpl paramTroopCardAppInfoHelperApiImpl) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.bIsDestroy) {
      return;
    }
    if ((paramBoolean) && (paramBundle != null)) {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.mergeFrom(paramBundle);
        if ((localOIDBSSOPkg.uint32_result.has()) && (localOIDBSSOPkg.uint32_result.get() == 0) && (localOIDBSSOPkg.bytes_bodybuffer.has()) && (localOIDBSSOPkg.bytes_bodybuffer.get() != null))
        {
          paramBundle = TroopCardAppInfoHelperApiImpl.access$400(this.a, localOIDBSSOPkg);
          if ((paramBundle != null) && (paramBundle.size() > 0)) {
            TroopCardAppInfoHelperApiImpl.access$300(this.a, paramBundle);
          }
        }
        else
        {
          TroopCardAppInfoHelperApiImpl.access$000(this.a);
          return;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        TroopCardAppInfoHelperApiImpl.access$000(this.a);
        return;
      }
    }
    TroopCardAppInfoHelperApiImpl.access$000(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.api.impl.TroopCardAppInfoHelperApiImpl.2
 * JD-Core Version:    0.7.0.1
 */