package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.tencent.mobileqq.qqlive.callback.room.AdminListCallback;
import com.tencent.mobileqq.qqlive.data.room.AdminListData;
import com.tencent.mobileqq.qqlive.data.room.RoomAdminInfo;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.AdminDetail;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.ListRoomAdminRsp;
import java.util.ArrayList;
import java.util.List;

class QQLiveRoomAdminImpl$4
  extends BaseSsoCallback
{
  QQLiveRoomAdminImpl$4(QQLiveRoomAdminImpl paramQQLiveRoomAdminImpl, AdminListCallback paramAdminListCallback) {}
  
  public void onBusinessFailed(int paramInt, String paramString)
  {
    super.onBusinessFailed(paramInt, paramString);
    this.val$callback.onFailed(paramInt, paramString);
  }
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    Object localObject1 = ListRoomAdminRsp.a(paramQQLiveRspData.a());
    paramQQLiveRspData = new AdminListData();
    paramQQLiveRspData.adminList = new ArrayList();
    localObject1 = ((ListRoomAdminRsp)localObject1).d;
    int i = localObject1.length;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject2 = localObject1[paramInt];
      RoomAdminInfo localRoomAdminInfo = new RoomAdminInfo();
      localRoomAdminInfo.isAdminInRoom = localObject2.g;
      localRoomAdminInfo.headUrl = localObject2.f;
      localRoomAdminInfo.isPlatformAdmin = localObject2.i;
      localRoomAdminInfo.nickname = localObject2.b;
      localRoomAdminInfo.sex = (localObject2.e ^ true);
      localRoomAdminInfo.isRoomAdmin = localObject2.h;
      localRoomAdminInfo.uid = localObject2.a;
      localRoomAdminInfo.sign = localObject2.d;
      paramQQLiveRspData.adminList.add(localRoomAdminInfo);
      paramInt += 1;
    }
    this.val$callback.a(paramQQLiveRspData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.QQLiveRoomAdminImpl.4
 * JD-Core Version:    0.7.0.1
 */