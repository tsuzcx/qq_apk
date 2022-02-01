package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveBanChat;
import com.tencent.mobileqq.qqlive.callback.supervision.QueryBanedHistoryCallback;
import com.tencent.mobileqq.qqlive.callback.supervision.QueryIsBanedChatCallback;
import com.tencent.mobileqq.qqlive.callback.supervision.SetBanChatCallback;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveCallbackObserver;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.GetBannedChatUserReq;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.GetChatStatusReq;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.SetChatStatusReq;
import java.util.List;

public class QQLiveBanChatImpl
  extends SuperVisionImpl
  implements IQQLiveBanChat
{
  private static final String BAN_CHAT_METHOD = "SetChatStatus";
  private static final String IS_BAN_CHAT_METHOD = "GetChatStatus";
  private static final String QUERY_BANED_HISTORY_METHOD = "GetBannedChatUser";
  
  public void banChat(long paramLong1, long paramLong2, long paramLong3, int paramInt, SetBanChatCallback paramSetBanChatCallback)
  {
    SetChatStatusReq localSetChatStatusReq = new SetChatStatusReq();
    localSetChatStatusReq.b = paramLong1;
    localSetChatStatusReq.e = paramInt;
    localSetChatStatusReq.a = paramLong2;
    localSetChatStatusReq.d = 0;
    localSetChatStatusReq.c = paramLong3;
    ((IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module")).a("trpc.qlive.room_admin_svr.RoomAdminSvr", "SetChatStatus", MessageNano.toByteArray(localSetChatStatusReq), new QQLiveCallbackObserver(new QQLiveBanChatImpl.2(this, paramSetBanChatCallback, paramLong3)));
  }
  
  public void cancelBanChat(long paramLong1, long paramLong2, long paramLong3, SetBanChatCallback paramSetBanChatCallback)
  {
    SetChatStatusReq localSetChatStatusReq = new SetChatStatusReq();
    localSetChatStatusReq.b = paramLong1;
    localSetChatStatusReq.a = paramLong2;
    localSetChatStatusReq.d = 1;
    localSetChatStatusReq.c = paramLong3;
    ((IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module")).a("trpc.qlive.room_admin_svr.RoomAdminSvr", "SetChatStatus", MessageNano.toByteArray(localSetChatStatusReq), new QQLiveCallbackObserver(new QQLiveBanChatImpl.3(this, paramSetBanChatCallback, paramLong3)));
  }
  
  public void destroy() {}
  
  public List<AdminReason> getBanChatReasonList()
  {
    return this.reasonList;
  }
  
  public int getReasonFlag()
  {
    return 1;
  }
  
  public void isBanedChat(long paramLong1, long paramLong2, long paramLong3, QueryIsBanedChatCallback paramQueryIsBanedChatCallback)
  {
    GetChatStatusReq localGetChatStatusReq = new GetChatStatusReq();
    localGetChatStatusReq.b = paramLong1;
    localGetChatStatusReq.a = paramLong2;
    localGetChatStatusReq.c = paramLong3;
    ((IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module")).a("trpc.qlive.room_admin_svr.RoomAdminSvr", "GetChatStatus", MessageNano.toByteArray(localGetChatStatusReq), new QQLiveCallbackObserver(new QQLiveBanChatImpl.1(this, paramLong3, paramQueryIsBanedChatCallback)));
  }
  
  public void queryBanedHistory(long paramLong1, long paramLong2, int paramInt1, int paramInt2, QueryBanedHistoryCallback paramQueryBanedHistoryCallback)
  {
    GetBannedChatUserReq localGetBannedChatUserReq = new GetBannedChatUserReq();
    localGetBannedChatUserReq.b = paramLong1;
    localGetBannedChatUserReq.c = paramInt1;
    localGetBannedChatUserReq.d = paramInt2;
    localGetBannedChatUserReq.a = paramLong2;
    ((IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module")).a("trpc.qlive.room_admin_svr.RoomAdminSvr", "GetBannedChatUser", MessageNano.toByteArray(localGetBannedChatUserReq), new QQLiveCallbackObserver(new QQLiveBanChatImpl.4(this, paramQueryBanedHistoryCallback)));
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveBanChatImpl
 * JD-Core Version:    0.7.0.1
 */