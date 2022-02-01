package com.tencent.mobileqq.qqlive.api.impl.gift;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.gift.IQQLiveGiftService;
import com.tencent.mobileqq.qqlive.api.gift.IQQLivePushCmdHelper;
import com.tencent.mobileqq.qqlive.callback.gift.ReceiveGiftMessageListener;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

public class QQLiveGiftServiceImpl
  implements IQQLiveGiftService
{
  private static final String TAG = "IQQLiveGiftService";
  private PushReceiver mGiftPushReceiver;
  private int mLastLeftBalance;
  private Set<ReceiveGiftMessageListener> mReceiveGiftMessageListeners = new HashSet();
  private IQQLiveSDK sdkImpl;
  
  private void initGiftMessageListener(IQQLiveSDK paramIQQLiveSDK)
  {
    this.mGiftPushReceiver = ((IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush")).a().a(((IQQLivePushCmdHelper)QRoute.api(IQQLivePushCmdHelper.class)).getHighPriorityPushCmd(paramIQQLiveSDK.getAppId()), new QQLiveGiftServiceImpl.1(this, paramIQQLiveSDK));
  }
  
  public void addReceiveGiftMessageListener(ReceiveGiftMessageListener paramReceiveGiftMessageListener)
  {
    this.mReceiveGiftMessageListeners.add(paramReceiveGiftMessageListener);
  }
  
  public void delReceiveGiftMessageListener(ReceiveGiftMessageListener paramReceiveGiftMessageListener)
  {
    this.mReceiveGiftMessageListeners.remove(paramReceiveGiftMessageListener);
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLiveGiftService", 4, "IQQLiveGiftService destroy");
    }
    PushReceiver localPushReceiver = this.mGiftPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.mReceiveGiftMessageListeners.clear();
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.sdkImpl = paramIQQLiveSDK;
    initGiftMessageListener(paramIQQLiveSDK);
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("IQQLiveGiftService", 4, "IQQLiveGiftService reset");
    }
    PushReceiver localPushReceiver = this.mGiftPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.mReceiveGiftMessageListeners.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.gift.QQLiveGiftServiceImpl
 * JD-Core Version:    0.7.0.1
 */