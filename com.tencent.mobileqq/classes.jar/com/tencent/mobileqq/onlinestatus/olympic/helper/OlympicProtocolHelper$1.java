package com.tencent.mobileqq.onlinestatus.olympic.helper;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import trpc.qq_status_rank.status_rank_mgr.StatusRankMgr.StatusRankResponse;

final class OlympicProtocolHelper$1
  extends ProtoUtils.TroopProtocolObserver
{
  OlympicProtocolHelper$1(OlympicProtocolHelper.IGetStatusRankCallback paramIGetStatusRankCallback) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onResult error and error code: ");
      paramArrayOfByte.append(paramInt);
      QLog.e("OlympicProtocolHelper", 1, paramArrayOfByte.toString());
      return;
    }
    try
    {
      paramArrayOfByte = (StatusRankMgr.StatusRankResponse)StatusRankMgr.StatusRankResponse.mergeFrom(new StatusRankMgr.StatusRankResponse(), paramArrayOfByte);
      if (this.a == null) {
        break label77;
      }
      this.a.a(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label69:
      label77:
      break label69;
    }
    QLog.e("OlympicProtocolHelper", 1, "response merge failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.olympic.helper.OlympicProtocolHelper.1
 * JD-Core Version:    0.7.0.1
 */