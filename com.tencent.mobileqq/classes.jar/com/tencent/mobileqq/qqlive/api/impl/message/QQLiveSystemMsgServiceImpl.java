package com.tencent.mobileqq.qqlive.api.impl.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveSystemMsgService;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo.MsgSpeed;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public class QQLiveSystemMsgServiceImpl
  implements IQQLiveSystemMsgService
{
  private static final int SYSTEM_NOTICE_MESSAGE_CMD = 255;
  private static final String TAG = "QQLiveSystemMsgService";
  private PushReceiver systemMsgPushReceiver;
  private CopyOnWriteArraySet<IQQLiveReceiveMessageListener> systemMsgReceiveListenerSet = new CopyOnWriteArraySet();
  
  private void initSystemNoticeMsgListener(IQQLiveSDK paramIQQLiveSDK)
  {
    this.systemMsgPushReceiver = ((IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush")).a().a(255, new QQLiveSystemMsgServiceImpl.1(this));
  }
  
  public void addSystemMessageListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener)
  {
    if (paramIQQLiveReceiveMessageListener != null) {
      this.systemMsgReceiveListenerSet.add(paramIQQLiveReceiveMessageListener);
    }
  }
  
  public void delSystemMessageListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener)
  {
    if (paramIQQLiveReceiveMessageListener != null) {
      this.systemMsgReceiveListenerSet.remove(paramIQQLiveReceiveMessageListener);
    }
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.e("QQLiveSystemMsgService", 4, "IQQLiveSystemMsgService destroy");
    }
    PushReceiver localPushReceiver = this.systemMsgPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.systemMsgReceiveListenerSet.clear();
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    initSystemNoticeMsgListener(paramIQQLiveSDK);
  }
  
  public void reset()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQLiveSystemMsgService", 4, "IQQLiveSystemMsgService reset");
    }
    PushReceiver localPushReceiver = this.systemMsgPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.systemMsgReceiveListenerSet.clear();
  }
  
  public void sendSystemNotice(String paramString)
  {
    LiveMessageData localLiveMessageData = new LiveMessageData();
    localLiveMessageData.mMessageType = 4;
    localLiveMessageData.mRawTipStr = paramString;
    new LiveMsgExtInfo().msgSpeed = LiveMsgExtInfo.MsgSpeed.NON_CONST;
    paramString = this.systemMsgReceiveListenerSet.iterator();
    while (paramString.hasNext()) {
      ((IQQLiveReceiveMessageListener)paramString.next()).a(localLiveMessageData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveSystemMsgServiceImpl
 * JD-Core Version:    0.7.0.1
 */