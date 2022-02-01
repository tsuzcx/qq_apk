package com.tencent.mobileqq.qqlive.api.impl.supervision;

import com.tencent.mobileqq.qqlive.data.room.AdminReason;
import com.tencent.mobileqq.qqlive.sso.BaseSsoCallback;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.AdminMenu;
import com.tencent.qqlive.iliveRoomAdminSvr.nano.AdminMenuListRsp;
import java.util.ArrayList;
import java.util.List;

class SuperVisionImpl$2
  extends BaseSsoCallback
{
  SuperVisionImpl$2(SuperVisionImpl paramSuperVisionImpl) {}
  
  public void onProxyRequestSuccess(int paramInt, QQLiveRspData paramQQLiveRspData)
  {
    Object localObject1 = AdminMenuListRsp.a(paramQQLiveRspData.a());
    paramQQLiveRspData = new ArrayList();
    localObject1 = ((AdminMenuListRsp)localObject1).c;
    int i = localObject1.length;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject2 = localObject1[paramInt];
      paramQQLiveRspData.add(new AdminReason(localObject2.a, localObject2.b));
      paramInt += 1;
    }
    this.this$0.reasonList = paramQQLiveRspData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.supervision.SuperVisionImpl.2
 * JD-Core Version:    0.7.0.1
 */