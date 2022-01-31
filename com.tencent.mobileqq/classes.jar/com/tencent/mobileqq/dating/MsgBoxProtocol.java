package com.tencent.mobileqq.dating;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import tencent.im.oidb.cmd0x876.oidb_0x876.ReqBody;
import tencent.im.oidb.cmd0x877.oidb_0x877.ReqBody;
import tencent.nearby.now.nearby_now_anchor.ReqBatchGetAnchorStatus;

public class MsgBoxProtocol
{
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, MsgBoxProtocol.LastFeedObserver paramLastFeedObserver)
  {
    oidb_0x877.ReqBody localReqBody = new oidb_0x877.ReqBody();
    localReqBody.uint32_refer.set(paramInt);
    ProtoUtils.a(paramQQAppInterface, paramLastFeedObserver, localReqBody.toByteArray(), "OidbSvc.0x877_0", 2167, 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, MsgBoxProtocol.MsgBoxReadObserver paramMsgBoxReadObserver)
  {
    ProtoUtils.a(paramQQAppInterface, paramMsgBoxReadObserver, new oidb_0x876.ReqBody().toByteArray(), "OidbSvc.0x876_" + paramInt, 2166, paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, List paramList, Bundle paramBundle, MsgBoxProtocol.ReqNowStateObserver paramReqNowStateObserver)
  {
    nearby_now_anchor.ReqBatchGetAnchorStatus localReqBatchGetAnchorStatus = new nearby_now_anchor.ReqBatchGetAnchorStatus();
    localReqBatchGetAnchorStatus.uint64_uin.set(paramList);
    paramList = paramBundle;
    if (paramBundle == null) {
      paramList = new Bundle();
    }
    ProtoUtils.a(paramQQAppInterface, paramReqNowStateObserver, localReqBatchGetAnchorStatus.toByteArray(), "NearbyNowTips.batch_get_anchor_stats", paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxProtocol
 * JD-Core Version:    0.7.0.1
 */