package com.tencent.mobileqq.newnearby.hippy;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.SetProfileRsp;

final class NearbyHippyCallback$1
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyHippyCallback$1(Promise paramPromise, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      this.a.reject("fail");
      return;
    }
    try
    {
      paramArrayOfByte = (nearbyProfile.SetProfileRsp)nearbyProfile.SetProfileRsp.mergeFrom(new nearbyProfile.SetProfileRsp(), paramArrayOfByte);
      if (paramArrayOfByte.ret_code.get() == 0) {
        NearbyHippyCallback.a(this.a, this.b, this.c, this.d);
      } else {
        this.a.reject("fail");
      }
      paramBundle = new StringBuilder();
      paramBundle.append("nearbyProfile.SetProfileReq rsp: code=");
      paramBundle.append(paramArrayOfByte.ret_code.get());
      paramBundle.append("; msg=");
      paramBundle.append(paramArrayOfByte.ret_msg.get());
      QLog.d("NearbyHippyCallback", 2, paramBundle.toString());
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label131:
      break label131;
    }
    QLog.e("NearbyHippyCallback", 2, "nearbyProfile.SetProfileReq, InvalidProtocolBufferMicroException!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.NearbyHippyCallback.1
 * JD-Core Version:    0.7.0.1
 */