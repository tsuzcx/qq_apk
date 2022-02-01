package com.tencent.mobileqq.qqlive.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveGetFollowListCallback;
import com.tencent.mobileqq.qqlive.data.follow.FollowListUser;
import com.tencent.mobileqq.qqlive.sso.QQLiveBusinessObserver;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano.GetFollowListRsp;
import com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano.GetFollowListRsp.FollowListItem;
import java.util.ArrayList;

class QQLiveFollowMsgServiceImpl$5
  extends QQLiveBusinessObserver
{
  QQLiveFollowMsgServiceImpl$5(QQLiveFollowMsgServiceImpl paramQQLiveFollowMsgServiceImpl, IQQLiveGetFollowListCallback paramIQQLiveGetFollowListCallback) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, QQLiveRspData paramQQLiveRspData)
  {
    if (paramBoolean)
    {
      if (QQLiveFollowMsgServiceImpl.access$300(this.this$0, this.val$getFollowListCallback, paramQQLiveRspData))
      {
        QLog.e("IQQLiveFollowMsgService", 4, "onGetFollowListFail fail");
        return;
      }
      try
      {
        paramQQLiveRspData = GetFollowListRsp.a(paramQQLiveRspData.a());
        localObject = new ArrayList();
        GetFollowListRsp.FollowListItem[] arrayOfFollowListItem = paramQQLiveRspData.c;
        int i = arrayOfFollowListItem.length;
        paramInt = 0;
        while (paramInt < i)
        {
          GetFollowListRsp.FollowListItem localFollowListItem = arrayOfFollowListItem[paramInt];
          FollowListUser localFollowListUser = new FollowListUser();
          localFollowListUser.uid = localFollowListItem.a;
          localFollowListUser.nick = localFollowListItem.b;
          localFollowListUser.icon = localFollowListItem.c;
          localFollowListUser.fansNum = localFollowListItem.d;
          localFollowListUser.giftNum = localFollowListItem.e;
          localFollowListUser.isLiving6 = localFollowListItem.f;
          ((ArrayList)localObject).add(localFollowListUser);
          paramInt += 1;
        }
        this.val$getFollowListCallback.a(paramQQLiveRspData.a, paramQQLiveRspData.b, (ArrayList)localObject);
        return;
      }
      catch (InvalidProtocolBufferNanoException paramQQLiveRspData)
      {
        this.val$getFollowListCallback.a(-1, "GetFollowListRsp parse fail");
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("GetFollowListRsp error:");
        ((StringBuilder)localObject).append(paramQQLiveRspData.getMessage());
        QLog.e("IQQLiveFollowMsgService", 4, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFollowMsgServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */