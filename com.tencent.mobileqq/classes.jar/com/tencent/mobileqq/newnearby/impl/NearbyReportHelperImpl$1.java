package com.tencent.mobileqq.newnearby.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.newnearby.INearbyCGIReporter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.nowsummarycard.NowSummaryCard.MiniCard;
import com.tencent.nowsummarycard.NowSummaryCard.NearbyMiniCardRsp;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class NearbyReportHelperImpl$1
  extends ProtoUtils.TroopProtocolObserver
{
  NearbyReportHelperImpl$1(NearbyReportHelperImpl paramNearbyReportHelperImpl, AppInterface paramAppInterface, String paramString) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (paramInt != 0) {
      return;
    }
    paramBundle = new NowSummaryCard.NearbyMiniCardRsp();
    try
    {
      paramBundle.mergeFrom(paramArrayOfByte);
      try
      {
        paramArrayOfByte = new JSONObject();
        paramArrayOfByte.put("opername", "now#nearby#news");
        paramArrayOfByte.put("module", "c2c_list");
        paramArrayOfByte.put("action", "click");
        if ((paramBundle.mini_card != null) && (!paramBundle.mini_card.isEmpty()))
        {
          paramBundle = (NowSummaryCard.MiniCard)paramBundle.mini_card.get(0);
          if (paramBundle != null)
          {
            boolean bool = paramBundle.is_match.get();
            if (bool) {
              paramArrayOfByte.put("d6", "2");
            } else if (paramBundle.is_greet.get()) {
              paramArrayOfByte.put("d6", "1");
            } else {
              paramArrayOfByte.put("d6", "0");
            }
          }
        }
        paramArrayOfByte.put("fromuin", this.a.getCurrentAccountUin());
        paramArrayOfByte.put("touin", this.b);
        paramArrayOfByte.put("appid", String.valueOf(this.a.getAppid()));
        paramArrayOfByte.put("ts", String.valueOf(System.currentTimeMillis() / 1000L));
        ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(paramArrayOfByte);
        return;
      }
      catch (JSONException paramArrayOfByte)
      {
        paramBundle = new StringBuilder();
        paramBundle.append("reportMsgListItemClick JSONException:");
        paramBundle.append(paramArrayOfByte.getMessage());
        QLog.e("NearbyReportHelperImpl", 2, paramBundle.toString());
        return;
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.impl.NearbyReportHelperImpl.1
 * JD-Core Version:    0.7.0.1
 */