package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveModuleKickOut;
import com.tencent.mobileqq.qqlive.callback.supervision.KickOutUserCallback;
import com.tencent.mobileqq.qqlive.callback.supervision.QueryKickOutHistoryCallback;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.listener.supervision.OnKickedOutOfRoomListener;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveCallbackObserver;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.CancelKickOutSomebodyReq;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.GetKickOutUserReq;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.KickOutSomebodyReq;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QQLiveKickOutImpl
  extends SuperVisionImpl
  implements IQQLiveModuleKickOut
{
  private static final String CANCEL_KICK_OUT_USER_METHOD = "CancelKickOutSomebody";
  private static final int KICK_OUT_MESSAGE_CMD = 254;
  private static final String KICK_OUT_USER_METHOD = "KickOutSomebody";
  private static final String QUERY_KICK_OUT_USER_HISTORY_METHOD = "GetKickOutUser";
  private static final String TAG = "QQLiveKickOutImpl";
  private PushReceiver kickOutReceiver;
  private final List<OnKickedOutOfRoomListener> listeners = new CopyOnWriteArrayList();
  
  public void addKickedOutOfRoomListener(OnKickedOutOfRoomListener paramOnKickedOutOfRoomListener)
  {
    if (!this.listeners.contains(paramOnKickedOutOfRoomListener)) {
      this.listeners.add(paramOnKickedOutOfRoomListener);
    }
  }
  
  public void cancelKickOutUser(long paramLong1, long paramLong2, long paramLong3, KickOutUserCallback paramKickOutUserCallback)
  {
    CancelKickOutSomebodyReq localCancelKickOutSomebodyReq = new CancelKickOutSomebodyReq();
    localCancelKickOutSomebodyReq.b = paramLong1;
    localCancelKickOutSomebodyReq.a = paramLong2;
    localCancelKickOutSomebodyReq.c = this.sdkImpl.getLoginModule().getUserInfo().uid;
    localCancelKickOutSomebodyReq.d = paramLong3;
    ((IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module")).a("trpc.qlive.room_admin_svr.RoomAdminSvr", "CancelKickOutSomebody", MessageNano.toByteArray(localCancelKickOutSomebodyReq), new QQLiveCallbackObserver(new QQLiveKickOutImpl.3(this, paramKickOutUserCallback, paramLong3)));
  }
  
  public void destroy()
  {
    this.kickOutReceiver.a();
    this.listeners.clear();
  }
  
  public List<AdminReason> getKickOutReasonList()
  {
    return this.reasonList;
  }
  
  public int getReasonFlag()
  {
    return 2;
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    super.init(paramIQQLiveSDK);
    this.kickOutReceiver = ((IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush")).a().a(254, new QQLiveKickOutImpl.1(this));
  }
  
  public void kickOutUser(long paramLong1, long paramLong2, long paramLong3, int paramInt, KickOutUserCallback paramKickOutUserCallback)
  {
    KickOutSomebodyReq localKickOutSomebodyReq = new KickOutSomebodyReq();
    localKickOutSomebodyReq.b = paramLong1;
    localKickOutSomebodyReq.a = paramLong2;
    localKickOutSomebodyReq.c = this.sdkImpl.getLoginModule().getUserInfo().uid;
    localKickOutSomebodyReq.e = paramInt;
    localKickOutSomebodyReq.d = paramLong3;
    ((IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module")).a("trpc.qlive.room_admin_svr.RoomAdminSvr", "KickOutSomebody", MessageNano.toByteArray(localKickOutSomebodyReq), new QQLiveCallbackObserver(new QQLiveKickOutImpl.2(this, paramKickOutUserCallback, paramLong3)));
  }
  
  public void queryKickOutHistory(long paramLong, int paramInt1, int paramInt2, QueryKickOutHistoryCallback paramQueryKickOutHistoryCallback)
  {
    GetKickOutUserReq localGetKickOutUserReq = new GetKickOutUserReq();
    localGetKickOutUserReq.a = paramLong;
    localGetKickOutUserReq.b = paramInt1;
    localGetKickOutUserReq.c = paramInt2;
    ((IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module")).a("trpc.qlive.room_admin_svr.RoomAdminSvr", "GetKickOutUser", MessageNano.toByteArray(localGetKickOutUserReq), new QQLiveCallbackObserver(new QQLiveKickOutImpl.4(this, paramQueryKickOutHistoryCallback)));
  }
  
  public void removeKickedOutOfRoomListener(OnKickedOutOfRoomListener paramOnKickedOutOfRoomListener)
  {
    if (paramOnKickedOutOfRoomListener != null) {
      this.listeners.remove(paramOnKickedOutOfRoomListener);
    }
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveKickOutImpl
 * JD-Core Version:    0.7.0.1
 */