package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.tencent.mobileqq.qqlive.callback.supervision.QueryBanedHistoryCallback;
import com.tencent.mobileqq.qqlive.data.supervision.BanChatUserListData;
import com.tencent.mobileqq.qqlive.data.user.LimitUserInfo;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.mobileqq.qqlive.utils.RspParamUtil;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.GetBannedChatUserRsp;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.RoomUserInfo;
import java.util.List;

class QQLiveBanChatImpl$4
  extends BaseSsoCallback
{
  QQLiveBanChatImpl$4(QQLiveBanChatImpl paramQQLiveBanChatImpl, QueryBanedHistoryCallback paramQueryBanedHistoryCallback) {}
  
  public void onBusinessFailed(int paramInt, String paramString)
  {
    super.onBusinessFailed(paramInt, paramString);
    this.val$callback.onFailed(paramInt, paramString);
  }
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    paramQQLiveRspData = GetBannedChatUserRsp.a(paramQQLiveRspData.a());
    BanChatUserListData localBanChatUserListData = new BanChatUserListData();
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
      localBanChatUserListData.list.add(localLimitUserInfo);
      paramInt += 1;
    }
    localBanChatUserListData.isEnd = RspParamUtil.a(paramQQLiveRspData.e);
    this.val$callback.a(localBanChatUserListData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveBanChatImpl.4
 * JD-Core Version:    0.7.0.1
 */