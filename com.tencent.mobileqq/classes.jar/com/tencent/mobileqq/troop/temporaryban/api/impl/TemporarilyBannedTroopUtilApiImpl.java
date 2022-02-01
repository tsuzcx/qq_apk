package com.tencent.mobileqq.troop.temporaryban.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopInfoExt;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.temporaryban.TemporarilyBannedTroopTipHelper;
import com.tencent.mobileqq.troop.temporaryban.api.ITemporarilyBannedTroopUtilApi;
import com.tencent.qphone.base.util.QLog;

public class TemporarilyBannedTroopUtilApiImpl
  implements ITemporarilyBannedTroopUtilApi
{
  private static final String TAG = "TemporarilyBannedTroopUtilApiImpl";
  
  public boolean checkTemporarilyBannedTroop(Context paramContext, AppInterface paramAppInterface, Intent paramIntent)
  {
    if (((paramContext instanceof Activity)) && (paramAppInterface != null))
    {
      if (paramIntent == null) {
        return false;
      }
      String str = paramIntent.getStringExtra("uin");
      if (paramIntent.getIntExtra("uintype", -1) == 1)
      {
        if (TextUtils.isEmpty(str)) {
          return false;
        }
        paramIntent = ((ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        long l = NetConnInfoCenter.getServerTime();
        if ((paramIntent != null) && (paramIntent.mTroopInfoExtObj.temporaryExpireTime > l))
        {
          TemporarilyBannedTroopTipHelper.a().a(paramAppInterface, paramContext, str);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("uin = ");
            paramContext.append(str);
            paramContext.append(" is TemporarilyBannedTroop, show Tips. time = ");
            paramContext.append(paramIntent.mTroopInfoExtObj.temporaryExpireTime);
            QLog.d("TemporarilyBannedTroopUtilApiImpl", 1, paramContext.toString());
          }
          return true;
        }
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("uin = ");
          paramContext.append(str);
          paramContext.append(" is TemporarilyBannedTroop, show Tips.");
          QLog.d("TemporarilyBannedTroopUtilApiImpl", 1, paramContext.toString());
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.temporaryban.api.impl.TemporarilyBannedTroopUtilApiImpl
 * JD-Core Version:    0.7.0.1
 */