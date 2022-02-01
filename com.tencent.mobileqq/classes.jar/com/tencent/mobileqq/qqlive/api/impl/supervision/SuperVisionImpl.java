package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveCallbackObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.AdminMenuListReq;
import java.util.ArrayList;
import java.util.List;

abstract class SuperVisionImpl
  extends IQQLiveBaseModule
{
  private static final String GET_ADMIN_REASON_LIST_METHOD = "AdminMenuList";
  public static final String SERVICE_NAME = "trpc.qlive.room_admin_svr.RoomAdminSvr";
  private static final String TAG = "SuperVisionImpl";
  protected List<AdminReason> reasonList = new ArrayList();
  
  private void queryBanChatReasonList(int paramInt)
  {
    AdminMenuListReq localAdminMenuListReq = new AdminMenuListReq();
    localAdminMenuListReq.a = paramInt;
    ((IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module")).a("trpc.qlive.room_admin_svr.RoomAdminSvr", "AdminMenuList", MessageNano.toByteArray(localAdminMenuListReq), new QQLiveCallbackObserver(new SuperVisionImpl.2(this)));
  }
  
  public abstract int getReasonFlag();
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    super.init(paramIQQLiveSDK);
    if (paramIQQLiveSDK.getLoginModule() != null)
    {
      if (paramIQQLiveSDK.getLoginModule().isLogined())
      {
        queryBanChatReasonList(getReasonFlag());
        return;
      }
      paramIQQLiveSDK.getLoginModule().registerLoginStateCallback(new SuperVisionImpl.1(this));
      return;
    }
    QLog.d("SuperVisionImpl", 1, "the login module is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.SuperVisionImpl
 * JD-Core Version:    0.7.0.1
 */