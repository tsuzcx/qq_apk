package com.tencent.mobileqq.qqlive.api.impl.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.qqlive.api.message.IQQLivePushCmdService;
import com.tencent.mobileqq.qqlive.callback.message.IQQCmdPushCallback;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class QQLivePushCmdServiceImpl
  implements IQQLivePushCmdService
{
  private static final String TAG = "IQQLivePushCmdService";
  private ConcurrentHashMap<Integer, CopyOnWriteArraySet<IQQCmdPushCallback>> highPriorityMap = new ConcurrentHashMap();
  private PushReceiver highPriorityPushReceiver;
  private ConcurrentHashMap<Integer, CopyOnWriteArraySet<IQQCmdPushCallback>> lowPriorityMap = new ConcurrentHashMap();
  private PushReceiver lowPriorityPushReceiver;
  private IQQLiveSDK sdkImpl;
  
  private void initHighPriorityListener(IQQLiveSDK paramIQQLiveSDK)
  {
    IQQLiveRoomPushService localIQQLiveRoomPushService = (IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush");
    if (localIQQLiveRoomPushService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IQQLivePushCmdService", 4, "get IQQLiveRoomPushService null");
      }
      return;
    }
    this.highPriorityPushReceiver = localIQQLiveRoomPushService.a().a(((IQQLivePushCmdHelper)QRoute.api(IQQLivePushCmdHelper.class)).getHighPriorityPushCmd(paramIQQLiveSDK.getAppId()), new QQLivePushCmdServiceImpl.1(this));
  }
  
  private void initLowPriorityListener(IQQLiveSDK paramIQQLiveSDK)
  {
    IQQLiveRoomPushService localIQQLiveRoomPushService = (IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush");
    if (localIQQLiveRoomPushService == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("IQQLivePushCmdService", 4, "get IQQLiveRoomPushService null");
      }
      return;
    }
    this.lowPriorityPushReceiver = localIQQLiveRoomPushService.a().a(((IQQLivePushCmdHelper)QRoute.api(IQQLivePushCmdHelper.class)).getLowPriorityPushCmd(paramIQQLiveSDK.getAppId()), new QQLivePushCmdServiceImpl.2(this));
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLivePushCmdService", 4, "IQQLiveAnnounceMsgService destroy");
    }
    PushReceiver localPushReceiver = this.highPriorityPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    localPushReceiver = this.lowPriorityPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.highPriorityMap.clear();
    this.lowPriorityMap.clear();
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.sdkImpl = paramIQQLiveSDK;
    initHighPriorityListener(paramIQQLiveSDK);
    initLowPriorityListener(paramIQQLiveSDK);
  }
  
  public void registerHighPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback)
  {
    if (!this.highPriorityMap.containsKey(Integer.valueOf(paramInt))) {
      this.highPriorityMap.put(Integer.valueOf(paramInt), new CopyOnWriteArraySet());
    }
    CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.highPriorityMap.get(Integer.valueOf(paramInt));
    if (localCopyOnWriteArraySet != null) {
      localCopyOnWriteArraySet.add(paramIQQCmdPushCallback);
    }
  }
  
  public void registerLowPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback)
  {
    if (!this.lowPriorityMap.containsKey(Integer.valueOf(paramInt))) {
      this.lowPriorityMap.put(Integer.valueOf(paramInt), new CopyOnWriteArraySet());
    }
    CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.lowPriorityMap.get(Integer.valueOf(paramInt));
    if (localCopyOnWriteArraySet != null) {
      localCopyOnWriteArraySet.add(paramIQQCmdPushCallback);
    }
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLivePushCmdService", 4, "IQQLiveAnnounceMsgService reset");
    }
    PushReceiver localPushReceiver = this.highPriorityPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    localPushReceiver = this.lowPriorityPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.highPriorityMap.clear();
    this.lowPriorityMap.clear();
  }
  
  public void unRegisterHighPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback)
  {
    if ((!this.highPriorityMap.containsKey(Integer.valueOf(paramInt))) && (paramIQQCmdPushCallback != null)) {
      paramIQQCmdPushCallback.a(-1, "this cmd did not register before");
    }
    CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.highPriorityMap.get(Integer.valueOf(paramInt));
    if (localCopyOnWriteArraySet != null) {
      localCopyOnWriteArraySet.remove(paramIQQCmdPushCallback);
    }
  }
  
  public void unRegisterLowPriorityListener(int paramInt, IQQCmdPushCallback paramIQQCmdPushCallback)
  {
    if ((!this.lowPriorityMap.containsKey(Integer.valueOf(paramInt))) && (paramIQQCmdPushCallback != null)) {
      paramIQQCmdPushCallback.a(-1, "this cmd did not register before");
    }
    CopyOnWriteArraySet localCopyOnWriteArraySet = (CopyOnWriteArraySet)this.lowPriorityMap.get(Integer.valueOf(paramInt));
    if (localCopyOnWriteArraySet != null) {
      localCopyOnWriteArraySet.remove(paramIQQCmdPushCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLivePushCmdServiceImpl
 * JD-Core Version:    0.7.0.1
 */