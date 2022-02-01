package com.tencent.mobileqq.qqlive.api.impl.room;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.callback.room.AudienceListCallback;
import com.tencent.mobileqq.qqlive.data.room.LiveAudienceInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveAudienceListData;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qqlive.iliveRoomDispatch.nano.GetMemberListRsp;
import com.tencent.qqlive.iliveRoomDispatch.nano.UserInfo;
import com.tencent.qqlive.iliveRoomDispatch.nano.UserList;
import java.util.ArrayList;
import java.util.List;

class AudienceListImpl$2
  extends BaseSsoCallback
{
  AudienceListImpl$2(AudienceListImpl paramAudienceListImpl, AudienceListCallback paramAudienceListCallback) {}
  
  public void onFailed(int paramInt, String paramString)
  {
    super.onFailed(paramInt, paramString);
    AudienceListCallback localAudienceListCallback = this.val$callback;
    if (localAudienceListCallback != null) {
      localAudienceListCallback.onFailed(paramInt, paramString);
    }
  }
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    try
    {
      paramQQLiveRspData = GetMemberListRsp.a(paramQQLiveRspData.a());
      LiveAudienceListData localLiveAudienceListData = new LiveAudienceListData();
      localLiveAudienceListData.list = new ArrayList();
      if ((paramQQLiveRspData.a != null) && (paramQQLiveRspData.a.b != null))
      {
        UserInfo[] arrayOfUserInfo = paramQQLiveRspData.a.b;
        int i = arrayOfUserInfo.length;
        paramInt = 0;
        while (paramInt < i)
        {
          UserInfo localUserInfo = arrayOfUserInfo[paramInt];
          LiveAudienceInfo localLiveAudienceInfo = new LiveAudienceInfo();
          localLiveAudienceInfo.uid = localUserInfo.a;
          localLiveAudienceInfo.nick = localUserInfo.d;
          localLiveAudienceInfo.headUrl = localUserInfo.b;
          localLiveAudienceInfo.explicitId = localUserInfo.a;
          localLiveAudienceInfo.enterTs = localUserInfo.e;
          localLiveAudienceListData.list.add(localLiveAudienceInfo);
          paramInt += 1;
        }
        localLiveAudienceListData.isEnd = paramQQLiveRspData.b;
        if (this.val$callback != null)
        {
          this.val$callback.a(localLiveAudienceListData);
          return;
        }
      }
    }
    catch (InvalidProtocolBufferNanoException paramQQLiveRspData)
    {
      paramQQLiveRspData.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceListImpl.2
 * JD-Core Version:    0.7.0.1
 */