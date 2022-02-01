package com.tencent.mobileqq.newnearby.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.nearby.trpc_nearby_control.nearby_control.nearbyControl.GetCityMapRsp;
import java.io.File;

final class PickLocationHelper$7
  extends ProtoUtils.TroopProtocolObserver
{
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("nearbyControl.GetTabConfigReq, errCode=");
      paramArrayOfByte.append(paramInt);
      QLog.e("PickLocationHelper", 2, paramArrayOfByte.toString());
      return;
    }
    try
    {
      paramArrayOfByte = ((nearbyControl.GetCityMapRsp)nearbyControl.GetCityMapRsp.mergeFrom(new nearbyControl.GetCityMapRsp(), paramArrayOfByte)).url.get();
      if (TextUtils.isEmpty(paramArrayOfByte)) {
        return;
      }
      paramBundle = new StringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_PATH);
      localStringBuilder.append(".nearby/cache/location/");
      paramBundle.append(VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString()));
      paramBundle.append("lbs.json");
      paramBundle = paramBundle.toString();
      if (!TextUtils.isEmpty(paramBundle))
      {
        paramBundle = new File(paramBundle);
        if (paramBundle.exists())
        {
          PickLocationHelper.d(paramBundle.getAbsolutePath());
          return;
        }
        ThreadManagerV2.executeOnSubThread(new PickLocationHelper.7.1(this, paramArrayOfByte, paramBundle));
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label170:
      break label170;
    }
    QLog.e("PickLocationHelper", 2, "reqNearbyControl GetMasterControlReq, InvalidProtocolBufferMicroException!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.util.PickLocationHelper.7
 * JD-Core Version:    0.7.0.1
 */