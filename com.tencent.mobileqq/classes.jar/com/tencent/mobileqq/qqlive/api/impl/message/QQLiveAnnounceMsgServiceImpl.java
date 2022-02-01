package com.tencent.mobileqq.qqlive.api.impl.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveAnnounceMsgService;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveAnnouncePushListener;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveGetAnnounceCallback;
import com.tencent.mobileqq.qqlive.callback.announce.IQQLiveSetAnnounceCallback;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.mobileqq.qqlive.sso.QQLiveRspData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qlive.live_lottery_server.announce.nano.GetAnnounceReq;
import com.tencent.trpcprotocol.qlive.live_lottery_server.announce.nano.SetAnnounceReq;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class QQLiveAnnounceMsgServiceImpl
  implements IQQLiveAnnounceMsgService
{
  private static final int ANNOUNCE_MESSAGE_CMD = 18;
  private static final String QQ_LIVE_ANNOUNCE_CMD = "trpc.qlive.announce_svr.AnnounceSvr";
  private static final String QQ_LIVE_GET_ANNOUNCE_METHOD = "GetAnnouncement";
  private static final String QQ_LIVE_SET_ANNOUNCE_METHOD = "SetAnnouncement";
  private static final String TAG = "IQQLiveAnnounceMsgService";
  private PushReceiver announcePushReceiver;
  private CopyOnWriteArraySet<IQQLiveAnnouncePushListener> receiveAnnounceListenerSet = new CopyOnWriteArraySet();
  private IQQLiveSDK sdkImpl;
  
  private void initAnnounceMsgListener(IQQLiveSDK paramIQQLiveSDK)
  {
    IQQLiveRoomPushService localIQQLiveRoomPushService = (IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush");
    if (localIQQLiveRoomPushService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IQQLiveAnnounceMsgService", 4, "get IQQLiveRoomPushService null");
      }
      return;
    }
    this.announcePushReceiver = localIQQLiveRoomPushService.a().a(((IQQLivePushCmdHelper)QRoute.api(IQQLivePushCmdHelper.class)).getLowPriorityPushCmd(paramIQQLiveSDK.getAppId()), new QQLiveAnnounceMsgServiceImpl.1(this));
  }
  
  private boolean onGetAnnounceFail(IQQLiveGetAnnounceCallback paramIQQLiveGetAnnounceCallback, QQLiveRspData paramQQLiveRspData)
  {
    if (paramIQQLiveGetAnnounceCallback == null)
    {
      QLog.e("IQQLiveAnnounceMsgService", 4, "setAnnounceCallback is null");
      return true;
    }
    if ((paramQQLiveRspData != null) && (paramQQLiveRspData.a() != null))
    {
      if (paramQQLiveRspData.c() != 0)
      {
        paramIQQLiveGetAnnounceCallback.a(paramQQLiveRspData.c(), paramQQLiveRspData.e());
        return true;
      }
      return false;
    }
    paramIQQLiveGetAnnounceCallback.a(-1, "the data is null");
    return true;
  }
  
  private boolean onSetAnnounceFail(IQQLiveSetAnnounceCallback paramIQQLiveSetAnnounceCallback, QQLiveRspData paramQQLiveRspData)
  {
    if (paramIQQLiveSetAnnounceCallback == null)
    {
      QLog.e("IQQLiveAnnounceMsgService", 4, "setAnnounceCallback is null");
      return true;
    }
    if ((paramQQLiveRspData != null) && (paramQQLiveRspData.a() != null))
    {
      if (paramQQLiveRspData.c() != 0)
      {
        paramIQQLiveSetAnnounceCallback.a(paramQQLiveRspData.c(), paramQQLiveRspData.e());
        return true;
      }
      return false;
    }
    paramIQQLiveSetAnnounceCallback.a(-1, "the data is null");
    return true;
  }
  
  public void addAnnounceMessageListener(IQQLiveAnnouncePushListener paramIQQLiveAnnouncePushListener)
  {
    if (paramIQQLiveAnnouncePushListener != null) {
      this.receiveAnnounceListenerSet.add(paramIQQLiveAnnouncePushListener);
    }
  }
  
  public void delAnnounceMessageListener(IQQLiveAnnouncePushListener paramIQQLiveAnnouncePushListener)
  {
    if (paramIQQLiveAnnouncePushListener != null) {
      this.receiveAnnounceListenerSet.remove(paramIQQLiveAnnouncePushListener);
    }
  }
  
  public void destroy()
  {
    QLog.d("IQQLiveAnnounceMsgService", 4, "IQQLiveAnnounceMsgService destroy");
    PushReceiver localPushReceiver = this.announcePushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.receiveAnnounceListenerSet.clear();
  }
  
  public void getRoomAnnounce(long paramLong, IQQLiveGetAnnounceCallback paramIQQLiveGetAnnounceCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLiveAnnounceMsgService", 4, "getRoomAnnounce send");
    }
    if (this.sdkImpl != null)
    {
      GetAnnounceReq localGetAnnounceReq = new GetAnnounceReq();
      localGetAnnounceReq.a = paramLong;
      IQQLiveSsoModule localIQQLiveSsoModule = (IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module");
      if (localIQQLiveSsoModule == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("IQQLiveAnnounceMsgService", 4, "get IQQLiveRoomPushService null");
        }
        return;
      }
      QLog.d("IQQLiveAnnounceMsgService", 4, new Object[] { Long.valueOf(localGetAnnounceReq.a) });
      localIQQLiveSsoModule.a("trpc.qlive.announce_svr.AnnounceSvr", "GetAnnouncement", GetAnnounceReq.toByteArray(localGetAnnounceReq), new QQLiveAnnounceMsgServiceImpl.4(this, paramIQQLiveGetAnnounceCallback));
    }
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    QLog.d("IQQLiveAnnounceMsgService", 4, "IQQLiveAnnounceMsgService init");
    this.sdkImpl = paramIQQLiveSDK;
    initAnnounceMsgListener(paramIQQLiveSDK);
  }
  
  public void reset()
  {
    QLog.d("IQQLiveAnnounceMsgService", 4, "IQQLiveAnnounceMsgService reset");
    PushReceiver localPushReceiver = this.announcePushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.receiveAnnounceListenerSet.clear();
  }
  
  public void setRoomAnnounce(long paramLong1, long paramLong2, String paramString, IQQLiveSetAnnounceCallback paramIQQLiveSetAnnounceCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLiveAnnounceMsgService", 4, "setRoomAnnounce send");
    }
    if (this.sdkImpl != null)
    {
      SetAnnounceReq localSetAnnounceReq = new SetAnnounceReq();
      localSetAnnounceReq.a = paramLong1;
      localSetAnnounceReq.b = paramLong2;
      localSetAnnounceReq.c = paramString;
      localSetAnnounceReq.d = new HashMap();
      paramString = (IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module");
      if (paramString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("IQQLiveAnnounceMsgService", 4, "get IQQLiveRoomPushService null");
        }
        return;
      }
      paramString.a("trpc.qlive.announce_svr.AnnounceSvr", "SetAnnouncement", SetAnnounceReq.toByteArray(localSetAnnounceReq), new QQLiveAnnounceMsgServiceImpl.2(this, paramIQQLiveSetAnnounceCallback));
    }
  }
  
  public void setRoomAnnounce(long paramLong1, long paramLong2, String paramString, Map<Integer, String> paramMap, IQQLiveSetAnnounceCallback paramIQQLiveSetAnnounceCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLiveAnnounceMsgService", 4, "setRoomAnnounce send");
    }
    if (this.sdkImpl != null)
    {
      SetAnnounceReq localSetAnnounceReq = new SetAnnounceReq();
      localSetAnnounceReq.a = paramLong1;
      localSetAnnounceReq.b = paramLong2;
      localSetAnnounceReq.c = paramString;
      paramString = paramMap.entrySet().iterator();
      while (paramString.hasNext())
      {
        paramMap = (Map.Entry)paramString.next();
        localSetAnnounceReq.d.put(paramMap.getKey(), paramMap.getValue());
      }
      paramString = (IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module");
      if (paramString == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("IQQLiveAnnounceMsgService", 4, "get IQQLiveRoomPushService null");
        }
        return;
      }
      paramString.a("trpc.qlive.announce_svr.AnnounceSvr", "SetAnnouncement", SetAnnounceReq.toByteArray(localSetAnnounceReq), new QQLiveAnnounceMsgServiceImpl.3(this, paramIQQLiveSetAnnounceCallback));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveAnnounceMsgServiceImpl
 * JD-Core Version:    0.7.0.1
 */