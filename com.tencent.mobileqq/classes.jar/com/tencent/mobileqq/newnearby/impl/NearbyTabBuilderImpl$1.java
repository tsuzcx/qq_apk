package com.tencent.mobileqq.newnearby.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.widget.TabLayoutCompat;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.GetTabConfigRsp;

class NearbyTabBuilderImpl$1
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyTabBuilderImpl$1(NearbyTabBuilderImpl paramNearbyTabBuilderImpl, QBaseActivity paramQBaseActivity, TabLayoutCompat paramTabLayoutCompat) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("nearbyControl.GetTabConfigReq, errCode=");
      paramArrayOfByte.append(paramInt);
      QLog.e("NearbyTabBuilderImpl", 2, paramArrayOfByte.toString());
      return;
    }
    try
    {
      ThreadManager.excute(new NearbyTabBuilderImpl.1.1(this, (nearbyControl.GetTabConfigRsp)nearbyControl.GetTabConfigRsp.mergeFrom(new nearbyControl.GetTabConfigRsp(), paramArrayOfByte)), 128, null, false);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label67:
      break label67;
    }
    QLog.e("NearbyTabBuilderImpl", 2, "reqNearbyControl GetMasterControlReq, InvalidProtocolBufferMicroException!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyTabBuilderImpl.1
 * JD-Core Version:    0.7.0.1
 */