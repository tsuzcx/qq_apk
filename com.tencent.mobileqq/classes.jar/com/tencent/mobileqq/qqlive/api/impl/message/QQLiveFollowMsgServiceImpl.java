package com.tencent.mobileqq.qqlive.api.impl.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveFollowMsgService;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveFollowCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveGetFollowListCallback;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveReceiveFollowListener;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano.ChkFollowReq;
import com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano.FollowReq;
import com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano.GetFollowListReq;
import com.tencent.trpcprotocol.qlive.relationchain_svr.relationchain_svr.nano.UnFollowReq;
import java.util.concurrent.CopyOnWriteArraySet;

public class QQLiveFollowMsgServiceImpl
  implements IQQLiveFollowMsgService
{
  private static final int FOLLOW_MESSAGE_CMD = 19;
  private static final String QQ_LIVE_CHK_FOLLOW_METHOD = "ChkFollow";
  private static final String QQ_LIVE_FOLLOW_CMD = "trpc.qlive.relationchain_svr.RelationchainSvr";
  private static final String QQ_LIVE_FOLLOW_METHOD = "Follow";
  private static final String QQ_LIVE_GET_FOLLOW_LIST_METHOD = "GetFollowList";
  private static final String QQ_LIVE_UNFOLLOW_METHOD = "UnFollow";
  private static final String TAG = "IQQLiveFollowMsgService";
  private PushReceiver followPushReceiver;
  private CopyOnWriteArraySet<IQQLiveReceiveFollowListener> receiveFollowListenerSet = new CopyOnWriteArraySet();
  private IQQLiveSDK sdkImpl;
  
  private void initFollowMsgListener(IQQLiveSDK paramIQQLiveSDK)
  {
    IQQLiveRoomPushService localIQQLiveRoomPushService = (IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush");
    if (localIQQLiveRoomPushService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IQQLiveFollowMsgService", 4, "get IQQLiveRoomPushService null");
      }
      return;
    }
    this.followPushReceiver = localIQQLiveRoomPushService.a().a(((IQQLivePushCmdHelper)QRoute.api(IQQLivePushCmdHelper.class)).getLowPriorityPushCmd(paramIQQLiveSDK.getAppId()), new QQLiveFollowMsgServiceImpl.1(this));
  }
  
  private boolean onCheckFollowAnchorFail(IQQLiveCheckFollowCallback paramIQQLiveCheckFollowCallback, QQLiveRspData paramQQLiveRspData)
  {
    if (paramIQQLiveCheckFollowCallback == null)
    {
      QLog.e("IQQLiveFollowMsgService", 4, "checkFollowCallback is null");
      return true;
    }
    if ((paramQQLiveRspData != null) && (paramQQLiveRspData.a() != null))
    {
      if (paramQQLiveRspData.c() != 0)
      {
        paramIQQLiveCheckFollowCallback.a(paramQQLiveRspData.c(), paramQQLiveRspData.e());
        return true;
      }
      return false;
    }
    paramIQQLiveCheckFollowCallback.a(-1, "the data is null");
    return true;
  }
  
  private boolean onFollowAnchorFail(IQQLiveFollowCallback paramIQQLiveFollowCallback, QQLiveRspData paramQQLiveRspData)
  {
    if (paramIQQLiveFollowCallback == null)
    {
      QLog.e("IQQLiveFollowMsgService", 4, "follow callback is null");
      return true;
    }
    if ((paramQQLiveRspData != null) && (paramQQLiveRspData.a() != null))
    {
      if (paramQQLiveRspData.c() != 0)
      {
        paramIQQLiveFollowCallback.a(paramQQLiveRspData.c(), paramQQLiveRspData.e());
        return true;
      }
      return false;
    }
    paramIQQLiveFollowCallback.a(-1, "the data is null");
    return true;
  }
  
  private boolean onGetFollowListFail(IQQLiveGetFollowListCallback paramIQQLiveGetFollowListCallback, QQLiveRspData paramQQLiveRspData)
  {
    if (paramIQQLiveGetFollowListCallback == null)
    {
      QLog.e("IQQLiveFollowMsgService", 4, "checkFollowCallback is null");
      return true;
    }
    if ((paramQQLiveRspData != null) && (paramQQLiveRspData.a() != null))
    {
      if (paramQQLiveRspData.c() != 0)
      {
        paramIQQLiveGetFollowListCallback.a(paramQQLiveRspData.c(), paramQQLiveRspData.e());
        return true;
      }
      return false;
    }
    paramIQQLiveGetFollowListCallback.a(-1, "the data is null");
    return true;
  }
  
  public void addFollowMessageListener(IQQLiveReceiveFollowListener paramIQQLiveReceiveFollowListener)
  {
    if (paramIQQLiveReceiveFollowListener != null) {
      this.receiveFollowListenerSet.add(paramIQQLiveReceiveFollowListener);
    }
  }
  
  public void checkFollowAnchor(long paramLong, IQQLiveCheckFollowCallback paramIQQLiveCheckFollowCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLiveFollowMsgService", 4, "checkFollowAnchor send");
    }
    if (this.sdkImpl != null)
    {
      ChkFollowReq localChkFollowReq = new ChkFollowReq();
      localChkFollowReq.a = paramLong;
      IQQLiveSsoModule localIQQLiveSsoModule = (IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module");
      if (localIQQLiveSsoModule == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("IQQLiveFollowMsgService", 4, "get IQQLiveRoomPushService null");
        }
        return;
      }
      localIQQLiveSsoModule.a("trpc.qlive.relationchain_svr.RelationchainSvr", "ChkFollow", ChkFollowReq.toByteArray(localChkFollowReq), new QQLiveFollowMsgServiceImpl.4(this, paramIQQLiveCheckFollowCallback));
    }
  }
  
  public void delFollowMessageListener(IQQLiveReceiveFollowListener paramIQQLiveReceiveFollowListener)
  {
    if (paramIQQLiveReceiveFollowListener != null) {
      this.receiveFollowListenerSet.remove(paramIQQLiveReceiveFollowListener);
    }
  }
  
  public void destroy()
  {
    QLog.d("IQQLiveFollowMsgService", 4, "IQQLiveFollowMsgService destroy");
    PushReceiver localPushReceiver = this.followPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.receiveFollowListenerSet.clear();
  }
  
  public void followAnchor(long paramLong1, long paramLong2, IQQLiveFollowCallback paramIQQLiveFollowCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLiveFollowMsgService", 4, "followAnchor send");
    }
    if (this.sdkImpl != null)
    {
      FollowReq localFollowReq = new FollowReq();
      localFollowReq.a = paramLong1;
      localFollowReq.b = paramLong2;
      IQQLiveSsoModule localIQQLiveSsoModule = (IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module");
      if (localIQQLiveSsoModule == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("IQQLiveFollowMsgService", 4, "get IQQLiveRoomPushService null");
        }
        return;
      }
      localIQQLiveSsoModule.a("trpc.qlive.relationchain_svr.RelationchainSvr", "Follow", FollowReq.toByteArray(localFollowReq), new QQLiveFollowMsgServiceImpl.2(this, paramIQQLiveFollowCallback));
    }
  }
  
  public void getFollowList(String paramString, long paramLong, IQQLiveGetFollowListCallback paramIQQLiveGetFollowListCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLiveFollowMsgService", 4, "getFollowList send");
    }
    if (this.sdkImpl != null)
    {
      GetFollowListReq localGetFollowListReq = new GetFollowListReq();
      localGetFollowListReq.a = paramString;
      localGetFollowListReq.b = paramLong;
      paramString = (IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module");
      if (paramString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("IQQLiveFollowMsgService", 4, "get IQQLiveRoomPushService null");
        }
        return;
      }
      paramString.a("trpc.qlive.relationchain_svr.RelationchainSvr", "GetFollowList", GetFollowListReq.toByteArray(localGetFollowListReq), new QQLiveFollowMsgServiceImpl.5(this, paramIQQLiveGetFollowListCallback));
    }
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.sdkImpl = paramIQQLiveSDK;
    initFollowMsgListener(paramIQQLiveSDK);
  }
  
  public void reset()
  {
    QLog.d("IQQLiveFollowMsgService", 4, "IQQLiveFollowMsgService reset");
    PushReceiver localPushReceiver = this.followPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.receiveFollowListenerSet.clear();
  }
  
  public void unFollowAnchor(long paramLong1, long paramLong2, IQQLiveFollowCallback paramIQQLiveFollowCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLiveFollowMsgService", 4, "unFollowAnchor send");
    }
    if (this.sdkImpl != null)
    {
      UnFollowReq localUnFollowReq = new UnFollowReq();
      localUnFollowReq.a = paramLong1;
      localUnFollowReq.b = paramLong2;
      IQQLiveSsoModule localIQQLiveSsoModule = (IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module");
      if (localIQQLiveSsoModule == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("IQQLiveFollowMsgService", 4, "get IQQLiveRoomPushService null");
        }
        return;
      }
      localIQQLiveSsoModule.a("trpc.qlive.relationchain_svr.RelationchainSvr", "UnFollow", UnFollowReq.toByteArray(localUnFollowReq), new QQLiveFollowMsgServiceImpl.3(this, paramIQQLiveFollowCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveFollowMsgServiceImpl
 * JD-Core Version:    0.7.0.1
 */