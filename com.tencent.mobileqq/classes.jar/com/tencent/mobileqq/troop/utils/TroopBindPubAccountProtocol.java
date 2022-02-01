package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.mobileqq_mp.FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;

public class TroopBindPubAccountProtocol
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    if (paramLong <= 0L) {
      return;
    }
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("8.8.17,3,5770");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.seqno.set(0);
    localGetPublicAccountDetailInfoRequest.luin.set(paramLong);
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramLong);
    ProtoUtils.a(paramQQAppInterface, paramTroopProtocolObserver, localGetPublicAccountDetailInfoRequest.toByteArray(), "PubAccountSvc.get_detail_info", localBundle);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, Bundle paramBundle)
  {
    mobileqq_mp.FollowRequest localFollowRequest = new mobileqq_mp.FollowRequest();
    localFollowRequest.luin.set(paramLong);
    localFollowRequest.ext.set("0");
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    ProtoUtils.a(paramQQAppInterface, paramTroopProtocolObserver, localFollowRequest.toByteArray(), "PubAccountSvc.follow", localBundle);
    paramTroopProtocolObserver = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    paramBundle = new StringBuilder();
    paramBundle.append("");
    paramBundle.append(paramLong);
    paramTroopProtocolObserver.reportFollowEvent(paramQQAppInterface, paramBundle.toString(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopBindPubAccountProtocol
 * JD-Core Version:    0.7.0.1
 */