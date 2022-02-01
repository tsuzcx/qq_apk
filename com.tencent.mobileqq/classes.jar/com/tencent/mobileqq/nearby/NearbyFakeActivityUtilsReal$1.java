package com.tencent.mobileqq.nearby;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.newnearby.INearbyVersionControl;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.ControlFlag;
import com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.GetMasterControlRsp;

final class NearbyFakeActivityUtilsReal$1
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyFakeActivityUtilsReal$1(Context paramContext, Intent paramIntent) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int i = 2;
    if (paramInt != 0)
    {
      QLog.e("NearbyFakeActivityUtilsReal", 2, "reqNearbyControl GetMasterControlReq, errcode=0");
      return;
    }
    try
    {
      paramArrayOfByte = (nearbyControl.GetMasterControlRsp)nearbyControl.GetMasterControlRsp.mergeFrom(new nearbyControl.GetMasterControlRsp(), paramArrayOfByte);
      paramBundle = paramArrayOfByte.control_flag;
      if ((paramBundle != null) && (!paramBundle.isEmpty()))
      {
        paramArrayOfByte = paramArrayOfByte.control_flag;
        boolean bool = false;
        paramArrayOfByte = (nearbyControl.ControlFlag)paramArrayOfByte.get(0);
        if (paramArrayOfByte == null)
        {
          QLog.e("NearbyFakeActivityUtilsReal", 2, "control_flag is null");
          NearbyFakeActivityUtilsReal.c(this.a, this.b);
          return;
        }
        if (paramArrayOfByte.value.get() == 1) {
          bool = true;
        }
        NearbyFakeActivityUtilsReal.a(bool);
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("reqNearbyControl isNew=");
        paramArrayOfByte.append(NearbyFakeActivityUtilsReal.b());
        QLog.d("NearbyFakeActivityUtilsReal", 2, paramArrayOfByte.toString());
        paramArrayOfByte = (INearbyVersionControl)QRoute.api(INearbyVersionControl.class);
        if (NearbyFakeActivityUtilsReal.b()) {
          paramInt = i;
        } else {
          paramInt = 1;
        }
        paramArrayOfByte.updateVersion(paramInt);
        NearbyFakeActivityUtilsReal.d(this.a, this.b);
        return;
      }
      QLog.e("NearbyFakeActivityUtilsReal", 2, "control_flag is empty");
      NearbyFakeActivityUtilsReal.c(this.a, this.b);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label206:
      break label206;
    }
    QLog.e("NearbyFakeActivityUtilsReal", 2, "reqNearbyControl GetMasterControlReq, InvalidProtocolBufferMicroException!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFakeActivityUtilsReal.1
 * JD-Core Version:    0.7.0.1
 */