package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.tencent.mobileqq.qqlive.callback.supervision.QueryKickOutHistoryCallback;
import com.tencent.mobileqq.qqlive.data.supervision.KickOutHistoryListData;
import com.tencent.mobileqq.qqlive.data.user.LimitUserInfo;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.mobileqq.qqlive.utils.RspParamUtil;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.GetKickOutUserRsp;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.RoomUserInfo;
import java.util.List;

class QQLiveKickOutImpl$4
  extends BaseSsoCallback
{
  QQLiveKickOutImpl$4(QQLiveKickOutImpl paramQQLiveKickOutImpl, QueryKickOutHistoryCallback paramQueryKickOutHistoryCallback) {}
  
  public void onBusinessFailed(int paramInt, String paramString)
  {
    super.onBusinessFailed(paramInt, paramString);
    this.val$callback.onFailed(paramInt, paramString);
  }
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    paramQQLiveRspData = GetKickOutUserRsp.a(paramQQLiveRspData.a());
    KickOutHistoryListData localKickOutHistoryListData = new KickOutHistoryListData();
    RoomUserInfo[] arrayOfRoomUserInfo = paramQQLiveRspData.c;
    int i = arrayOfRoomUserInfo.length;
    paramInt = 0;
    while (paramInt < i)
    {
      RoomUserInfo localRoomUserInfo = arrayOfRoomUserInfo[paramInt];
      LimitUserInfo localLimitUserInfo = new LimitUserInfo();
      localLimitUserInfo.headUrl = localRoomUserInfo.a;
      localLimitUserInfo.nick = localRoomUserInfo.b;
      localLimitUserInfo.opTime = localRoomUserInfo.d;
      localLimitUserInfo.sex = RspParamUtil.a(localRoomUserInfo.c);
      localLimitUserInfo.uid = localRoomUserInfo.e;
      localKickOutHistoryListData.list.add(localLimitUserInfo);
      paramInt += 1;
    }
    localKickOutHistoryListData.isEnd = RspParamUtil.a(paramQQLiveRspData.e);
    localKickOutHistoryListData.sum = paramQQLiveRspData.d;
    this.val$callback.a(localKickOutHistoryListData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveKickOutImpl.4
 * JD-Core Version:    0.7.0.1
 */