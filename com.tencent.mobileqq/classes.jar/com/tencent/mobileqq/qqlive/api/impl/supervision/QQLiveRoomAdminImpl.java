package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.qqlive.api.supervision.IQQLiveRoomAdmin;
import com.tencent.mobileqq.qqlive.callback.room.AdminListCallback;
import com.tencent.mobileqq.qqlive.callback.room.IsAdminCallback;
import com.tencent.mobileqq.qqlive.callback.room.SetAdminCallback;
import com.tencent.mobileqq.qqlive.listener.supervision.OnAdminStatusChangedListener;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveCallbackObserver;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.IsRoomAdminReq;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.ListRoomAdminReq;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.SetRoomAdminReq;
import java.util.ArrayList;
import java.util.List;

public class QQLiveRoomAdminImpl
  extends IQQLiveBaseModule
  implements IQQLiveRoomAdmin
{
  private static final String METHOD_IS_ADMIN = "IsRoomAdmin";
  private static final String METHOD_LIST_ADMIN = "ListRoomAdmin";
  private static final String METHOD_SET_ADMIN = "SetRoomAdmin";
  private static final int PUSH_MSG_ADMIN_PUBLIC_STATUS = 255;
  private static final int PUSH_MSG_ADMIN_STATUS = 253;
  private static final String SERVICE_CMD = "trpc.qlive.room_admin_svr.RoomAdminSvr";
  private PushReceiver adminStatusReceiver;
  private final List<OnAdminStatusChangedListener> listeners = new ArrayList();
  
  public void addAdminStatusListener(OnAdminStatusChangedListener paramOnAdminStatusChangedListener)
  {
    if (!this.listeners.contains(paramOnAdminStatusChangedListener)) {
      this.listeners.add(paramOnAdminStatusChangedListener);
    }
  }
  
  public void destroy()
  {
    this.adminStatusReceiver.a();
    this.listeners.clear();
  }
  
  public void getAdminListByAnchorUid(long paramLong1, long paramLong2, AdminListCallback paramAdminListCallback)
  {
    ListRoomAdminReq localListRoomAdminReq = new ListRoomAdminReq();
    localListRoomAdminReq.b = paramLong1;
    localListRoomAdminReq.a = paramLong2;
    ((IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module")).a("trpc.qlive.room_admin_svr.RoomAdminSvr", "ListRoomAdmin", MessageNano.toByteArray(localListRoomAdminReq), new QQLiveCallbackObserver(new QQLiveRoomAdminImpl.4(this, paramAdminListCallback)));
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    super.init(paramIQQLiveSDK);
    this.adminStatusReceiver = ((IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush")).a().a(253, new QQLiveRoomAdminImpl.1(this));
  }
  
  public void isAdmin(long paramLong1, long paramLong2, long paramLong3, IsAdminCallback paramIsAdminCallback)
  {
    IsRoomAdminReq localIsRoomAdminReq = new IsRoomAdminReq();
    localIsRoomAdminReq.b = paramLong1;
    localIsRoomAdminReq.a = paramLong2;
    localIsRoomAdminReq.c = paramLong3;
    ((IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module")).a("trpc.qlive.room_admin_svr.RoomAdminSvr", "IsRoomAdmin", MessageNano.toByteArray(localIsRoomAdminReq), new QQLiveCallbackObserver(new QQLiveRoomAdminImpl.2(this, paramIsAdminCallback, paramLong3)));
  }
  
  public void removeAdminStatusListener(OnAdminStatusChangedListener paramOnAdminStatusChangedListener)
  {
    if (paramOnAdminStatusChangedListener != null) {
      this.listeners.remove(paramOnAdminStatusChangedListener);
    }
  }
  
  public void reset() {}
  
  public void setAdminState(long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean, SetAdminCallback paramSetAdminCallback)
  {
    SetRoomAdminReq localSetRoomAdminReq = new SetRoomAdminReq();
    localSetRoomAdminReq.b = paramLong1;
    localSetRoomAdminReq.a = paramLong2;
    localSetRoomAdminReq.c = paramLong3;
    localSetRoomAdminReq.d = paramBoolean;
    ((IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module")).a("trpc.qlive.room_admin_svr.RoomAdminSvr", "SetRoomAdmin", MessageNano.toByteArray(localSetRoomAdminReq), new QQLiveCallbackObserver(new QQLiveRoomAdminImpl.3(this, paramSetAdminCallback, paramLong3)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveRoomAdminImpl
 * JD-Core Version:    0.7.0.1
 */