package com.tencent.mobileqq.troop.troopcard;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.pb.troop.bindgame.GCBindGroup.GCBindGroupSsoServerRsp;
import com.tencent.qphone.base.util.QLog;

class TroopInfoActivity$32
  extends ProtoUtils.TroopProtocolObserver
{
  TroopInfoActivity$32(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    try
    {
      paramBundle = new GCBindGroup.GCBindGroupSsoServerRsp();
      paramBundle.mergeFrom(paramArrayOfByte);
      this.a.a(paramBundle);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label31:
      break label31;
    }
    QLog.e("Q.troopinfo", 1, "parse game bind status failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.TroopInfoActivity.32
 * JD-Core Version:    0.7.0.1
 */