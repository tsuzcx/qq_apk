package com.tencent.mobileqq.newnearby.impl;

import android.os.Bundle;
import android.view.View;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.recent.RecentDefaultItemBuilder.RecentItemDefaultHolder;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyMiniCardRsp;
import com.tencent.qphone.base.util.QLog;

class NearbyMsgboxImpl$3
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyMsgboxImpl$3(NearbyMsgboxImpl paramNearbyMsgboxImpl, View paramView, RecentDefaultItemBuilder.RecentItemDefaultHolder paramRecentItemDefaultHolder) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("getMiniCardList errCode: ");
      paramArrayOfByte.append(paramInt);
      QLog.e("NearbyMsgbox", 1, paramArrayOfByte.toString());
      return;
    }
    paramBundle = new NowSummaryCard.NearbyMiniCardRsp();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      NearbyMsgboxImpl.access$000(this.c, this.a, this.b, paramBundle);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("getMiniCardList error: ");
      paramBundle.append(paramArrayOfByte);
      QLog.e("NearbyMsgbox", 1, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyMsgboxImpl.3
 * JD-Core Version:    0.7.0.1
 */