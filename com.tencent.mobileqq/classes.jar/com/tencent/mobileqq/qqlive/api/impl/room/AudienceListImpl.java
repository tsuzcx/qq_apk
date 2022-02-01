package com.tencent.mobileqq.qqlive.api.impl.room;

import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.room.IAudienceList;
import com.tencent.mobileqq.qqlive.callback.room.AudienceListCallback;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveCallbackObserver;
import com.tencent.qqlive.iliveMidendRoomRankSvr.nano.GetRoomRankReq;
import com.tencent.qqlive.iliveRoomDispatch.nano.GetMemberListReq;

public class AudienceListImpl
  implements IAudienceList
{
  private static final String QQ_LIVE_AUDIENCE_USER_CMD = "GetMemberList";
  private static final String QQ_LIVE_RANK_AUDIENCE_LIST_SERVICE = "trpc.qlive.ilive_midend_room_rank_svr.IliveMidendRoomRankSvr";
  private static final String QQ_LIVE_RANK_USER_CMD = "GetRoomRank";
  private static final String QQ_LIVE_USER_LIST_SERVICE = "trpc.qlive.room_dispatch.RoomDispatch";
  private IQQLiveSDK sdk;
  
  public void destroy() {}
  
  public void getRankUserList(long paramLong, String paramString, AudienceListCallback paramAudienceListCallback)
  {
    GetRoomRankReq localGetRoomRankReq = new GetRoomRankReq();
    localGetRoomRankReq.a = paramLong;
    if (!TextUtils.isEmpty(paramString)) {
      localGetRoomRankReq.b = paramString;
    }
    ((IQQLiveSsoModule)this.sdk.getExtModule("sso_module")).a("trpc.qlive.ilive_midend_room_rank_svr.IliveMidendRoomRankSvr", "GetRoomRank", MessageNano.toByteArray(localGetRoomRankReq), new QQLiveCallbackObserver(new AudienceListImpl.2(this, paramAudienceListCallback)));
  }
  
  public void getUserList(long paramLong, int paramInt1, int paramInt2, AudienceListCallback paramAudienceListCallback)
  {
    GetMemberListReq localGetMemberListReq = new GetMemberListReq();
    localGetMemberListReq.a = paramLong;
    localGetMemberListReq.b = paramInt1;
    localGetMemberListReq.c = paramInt2;
    ((IQQLiveSsoModule)this.sdk.getExtModule("sso_module")).a("trpc.qlive.room_dispatch.RoomDispatch", "GetMemberList", MessageNano.toByteArray(localGetMemberListReq), new QQLiveCallbackObserver(new AudienceListImpl.1(this, paramAudienceListCallback)));
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.sdk = paramIQQLiveSDK;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.room.AudienceListImpl
 * JD-Core Version:    0.7.0.1
 */