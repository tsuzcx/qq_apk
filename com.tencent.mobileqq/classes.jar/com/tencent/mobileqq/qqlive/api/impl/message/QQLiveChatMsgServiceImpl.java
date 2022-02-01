package com.tencent.mobileqq.qqlive.api.impl.message;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.api.message.IQQLiveChatMsgService;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.callback.message.IllegalMessageListener;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.ExtData;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.ImageElement;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.MsgContent;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.MsgElement;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.SpeakerInfo;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.TextElement;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo;
import com.tencent.mobileqq.qqlive.data.message.LiveMsgExtInfo.MsgSpeed;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.push.api.IQQLiveRoomPushService;
import com.tencent.mobileqq.qqlive.push.api.PushReceiver;
import com.tencent.mobileqq.qqlive.sso.IQQLiveSsoModule;
import com.tencent.protobuf.iliveWordSvr.nano.BroadCastMsg;
import com.tencent.protobuf.iliveWordSvr.nano.ExtData;
import com.tencent.protobuf.iliveWordSvr.nano.ImageElement;
import com.tencent.protobuf.iliveWordSvr.nano.MsgContent;
import com.tencent.protobuf.iliveWordSvr.nano.MsgElement;
import com.tencent.protobuf.iliveWordSvr.nano.NewPublicChatReq;
import com.tencent.protobuf.iliveWordSvr.nano.TextElement;
import com.tencent.protobuf.iliveWordSvr.nano.UserInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

public class QQLiveChatMsgServiceImpl
  implements IQQLiveChatMsgService
{
  private static final int EXT_DATA_SERVER_ID = 232;
  private static final int NORMAL_CHAT_MESSAGE_CMD = 33;
  private static final int PUSH_ERR0R = 1003;
  private static final String QQ_SEND_MSG_CMD = "trpc.qlive.word_svr.WordSvr";
  private static final String QQ_SEND_MSG_SUBCMD = "NewPublicChat";
  private static final String TAG = "QQLiveChatMsgService";
  private static final int TIME_OUT = 1002;
  private CopyOnWriteArraySet<IQQLiveReceiveMessageListener> chatMsgReceiveListenerSet = new CopyOnWriteArraySet();
  private CopyOnWriteArraySet<IllegalMessageListener> illegalMsgReceiveListenerSet = new CopyOnWriteArraySet();
  private PushReceiver normalMsgPushReceiver;
  private IQQLiveSDK sdkImpl;
  
  private LiveMessageData convertBroadCastMsgToMessageData(BroadCastMsg paramBroadCastMsg)
  {
    LiveMessageData localLiveMessageData = new LiveMessageData();
    localLiveMessageData.mMessageType = 1;
    Object localObject1 = new LiveMessageData.SpeakerInfo();
    ((LiveMessageData.SpeakerInfo)localObject1).mSpeakId = paramBroadCastMsg.a.a;
    ((LiveMessageData.SpeakerInfo)localObject1).mSpeakerName = paramBroadCastMsg.a.b;
    ((LiveMessageData.SpeakerInfo)localObject1).mLogo = paramBroadCastMsg.a.c;
    ((LiveMessageData.SpeakerInfo)localObject1).mQunNick = paramBroadCastMsg.a.d;
    ((LiveMessageData.SpeakerInfo)localObject1).mBusinessUid = paramBroadCastMsg.a.e;
    ((LiveMessageData.SpeakerInfo)localObject1).mClientType = paramBroadCastMsg.c;
    localLiveMessageData.mSpeakerInfo = ((LiveMessageData.SpeakerInfo)localObject1);
    localObject1 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    MsgElement[] arrayOfMsgElement = paramBroadCastMsg.b.a;
    int k = arrayOfMsgElement.length;
    int j = 0;
    int i = 0;
    Object localObject2;
    while (i < k)
    {
      localObject2 = arrayOfMsgElement[i];
      localLiveMessageData.getClass();
      LiveMessageData.MsgElement localMsgElement = new LiveMessageData.MsgElement(localLiveMessageData);
      localLiveMessageData.getClass();
      LiveMessageData.TextElement localTextElement = new LiveMessageData.TextElement(localLiveMessageData);
      localLiveMessageData.getClass();
      LiveMessageData.ImageElement localImageElement = new LiveMessageData.ImageElement(localLiveMessageData);
      if (((MsgElement)localObject2).b != null)
      {
        localTextElement.mText = ((MsgElement)localObject2).b.a;
        try
        {
          localTextElement.strText = new String(((MsgElement)localObject2).b.a, "utf-16LE");
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("get 0x21 chat message push message");
            localStringBuilder.append(localTextElement.strText);
            QLog.i("QQLiveChatMsgService", 4, localStringBuilder.toString());
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
          localTextElement.strText = "";
        }
      }
      if (((MsgElement)localObject2).c != null) {
        localImageElement.mImageUrl = ((MsgElement)localObject2).c.a;
      }
      localMsgElement.mElementType = ((MsgElement)localObject2).a;
      localMsgElement.mHideLogo = ((MsgElement)localObject2).d;
      localMsgElement.mTextMsg = localTextElement;
      localMsgElement.mImageMsg = localImageElement;
      ((ArrayList)localObject1).add(localMsgElement);
      i += 1;
    }
    paramBroadCastMsg = paramBroadCastMsg.b.b;
    k = paramBroadCastMsg.length;
    i = j;
    while (i < k)
    {
      arrayOfMsgElement = paramBroadCastMsg[i];
      localLiveMessageData.getClass();
      localObject2 = new LiveMessageData.ExtData(localLiveMessageData);
      ((LiveMessageData.ExtData)localObject2).mId = arrayOfMsgElement.a;
      ((LiveMessageData.ExtData)localObject2).mValue = arrayOfMsgElement.b;
      localArrayList.add(localObject2);
      if (((LiveMessageData.ExtData)localObject2).mId == 232) {
        localLiveMessageData.mMessageId = new String(((LiveMessageData.ExtData)localObject2).mValue);
      }
      i += 1;
    }
    localLiveMessageData.getClass();
    paramBroadCastMsg = new LiveMessageData.MsgContent(localLiveMessageData);
    paramBroadCastMsg.mMsgElements = ((ArrayList)localObject1);
    paramBroadCastMsg.mExtDatas = localArrayList;
    localLiveMessageData.msgContent = paramBroadCastMsg;
    return localLiveMessageData;
  }
  
  private LiveMessageData convertChatPbDataToChatMessage(byte[] paramArrayOfByte)
  {
    LiveMessageData localLiveMessageData = new LiveMessageData();
    try
    {
      paramArrayOfByte = convertBroadCastMsgToMessageData(BroadCastMsg.a(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("convertChatPbDataToChatMessage error:");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      QLog.e("QQLiveChatMsgService", 1, localStringBuilder.toString());
    }
    return localLiveMessageData;
  }
  
  private void handleIllegalNotify(String paramString)
  {
    Iterator localIterator = this.illegalMsgReceiveListenerSet.iterator();
    while (localIterator.hasNext()) {
      ((IllegalMessageListener)localIterator.next()).a(paramString);
    }
  }
  
  private void initNormalChatMsgListener(IQQLiveSDK paramIQQLiveSDK)
  {
    IQQLiveRoomPushService localIQQLiveRoomPushService = (IQQLiveRoomPushService)paramIQQLiveSDK.getExtModule("roomPush");
    if (localIQQLiveRoomPushService == null) {
      return;
    }
    this.normalMsgPushReceiver = localIQQLiveRoomPushService.a().a(33, new QQLiveChatMsgServiceImpl.1(this, paramIQQLiveSDK));
  }
  
  private void sendMessageReq(LiveMessageData paramLiveMessageData, byte[] paramArrayOfByte, IQQLiveMessageCallback paramIQQLiveMessageCallback)
  {
    ((IQQLiveSsoModule)this.sdkImpl.getExtModule("sso_module")).a("trpc.qlive.word_svr.WordSvr", "NewPublicChat", paramArrayOfByte, new QQLiveChatMsgServiceImpl.2(this, paramIQQLiveMessageCallback));
  }
  
  private void sendToLocalScreen(LiveMessageData paramLiveMessageData, IQQLiveMessageCallback paramIQQLiveMessageCallback)
  {
    Object localObject = new LiveMsgExtInfo();
    ((LiveMsgExtInfo)localObject).msgSpeed = LiveMsgExtInfo.MsgSpeed.NON_CONST;
    paramLiveMessageData.mMsgExtInfo = ((LiveMsgExtInfo)localObject);
    localObject = paramLiveMessageData.msgContent.mMsgElements.iterator();
    while (((Iterator)localObject).hasNext())
    {
      LiveMessageData.MsgElement localMsgElement = (LiveMessageData.MsgElement)((Iterator)localObject).next();
      try
      {
        localMsgElement.mTextMsg.strText = new String(localMsgElement.mTextMsg.mText, "utf-16LE");
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
    }
    localObject = this.chatMsgReceiveListenerSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((IQQLiveReceiveMessageListener)((Iterator)localObject).next()).a(paramLiveMessageData);
    }
    paramIQQLiveMessageCallback.a(true);
  }
  
  private void sendToServer(LiveMessageData paramLiveMessageData, IQQLiveMessageCallback paramIQQLiveMessageCallback)
  {
    if (paramLiveMessageData != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQLiveChatMsgService", 4, "sendToServer");
      }
      NewPublicChatReq localNewPublicChatReq = new NewPublicChatReq();
      localNewPublicChatReq.a = paramLiveMessageData.mMainRoomId;
      localNewPublicChatReq.b = paramLiveMessageData.mSubRoomId;
      MsgContent localMsgContent = new MsgContent();
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = paramLiveMessageData.msgContent.mMsgElements.iterator();
      Object localObject3;
      Object localObject4;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LiveMessageData.MsgElement)((Iterator)localObject1).next();
        localObject3 = new MsgElement();
        ((MsgElement)localObject3).a = 1;
        localObject4 = new TextElement();
        ((TextElement)localObject4).a = ((LiveMessageData.MsgElement)localObject2).mTextMsg.mText;
        ((MsgElement)localObject3).b = ((TextElement)localObject4);
        localArrayList.add(localObject3);
      }
      localObject1 = new ArrayList();
      Object localObject2 = paramLiveMessageData.msgContent.mExtDatas.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (LiveMessageData.ExtData)((Iterator)localObject2).next();
        localObject4 = new ExtData();
        ((ExtData)localObject4).a = ((LiveMessageData.ExtData)localObject3).mId;
        ((ExtData)localObject4).b = ((LiveMessageData.ExtData)localObject3).mValue;
        ((List)localObject1).add(localObject4);
      }
      localMsgContent.a = ((MsgElement[])localArrayList.toArray(new MsgElement[localArrayList.size()]));
      localMsgContent.b = ((ExtData[])((List)localObject1).toArray(new ExtData[((List)localObject1).size()]));
      localNewPublicChatReq.c = localMsgContent;
      sendMessageReq(paramLiveMessageData, MessageNano.toByteArray(localNewPublicChatReq), paramIQQLiveMessageCallback);
    }
  }
  
  public void addChatMessageListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener)
  {
    if (paramIQQLiveReceiveMessageListener != null) {
      this.chatMsgReceiveListenerSet.add(paramIQQLiveReceiveMessageListener);
    }
  }
  
  public void addIllegalMessageListener(IllegalMessageListener paramIllegalMessageListener)
  {
    this.illegalMsgReceiveListenerSet.add(paramIllegalMessageListener);
  }
  
  public void delChatMessageListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener)
  {
    if (paramIQQLiveReceiveMessageListener != null) {
      this.chatMsgReceiveListenerSet.remove(paramIQQLiveReceiveMessageListener);
    }
  }
  
  public void delIllegalMessageListener(IllegalMessageListener paramIllegalMessageListener)
  {
    this.illegalMsgReceiveListenerSet.remove(paramIllegalMessageListener);
  }
  
  public void destroy()
  {
    QLog.e("QQLiveChatMsgService", 4, "QQLiveChatMsgServiceImpl destroy");
    PushReceiver localPushReceiver = this.normalMsgPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.chatMsgReceiveListenerSet.clear();
    this.illegalMsgReceiveListenerSet.clear();
  }
  
  public void init(IQQLiveSDK paramIQQLiveSDK)
  {
    this.sdkImpl = paramIQQLiveSDK;
    if (paramIQQLiveSDK != null) {
      initNormalChatMsgListener(paramIQQLiveSDK);
    }
  }
  
  public void reset()
  {
    QLog.d("QQLiveChatMsgService", 4, "IQQLiveChatMsgService reset");
    PushReceiver localPushReceiver = this.normalMsgPushReceiver;
    if (localPushReceiver != null) {
      localPushReceiver.a();
    }
    this.chatMsgReceiveListenerSet.clear();
    this.illegalMsgReceiveListenerSet.clear();
  }
  
  public void sendMessage(LiveMessageData paramLiveMessageData, IQQLiveMessageCallback paramIQQLiveMessageCallback, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        sendToLocalScreen(paramLiveMessageData, paramIQQLiveMessageCallback);
        return;
      }
      sendToServer(paramLiveMessageData, paramIQQLiveMessageCallback);
      return;
    }
    sendToLocalScreen(paramLiveMessageData, paramIQQLiveMessageCallback);
    sendToServer(paramLiveMessageData, paramIQQLiveMessageCallback);
  }
  
  public void sendMessage(String paramString, ArrayList<LiveMessageData.ExtData> paramArrayList, IQQLiveMessageCallback paramIQQLiveMessageCallback)
  {
    Object localObject = this.sdkImpl;
    if (localObject != null)
    {
      localObject = (IQQLiveRoomPushService)((IQQLiveSDK)localObject).getExtModule("roomPush");
      LiveMessageData localLiveMessageData = new LiveMessageData();
      if (localObject != null)
      {
        localLiveMessageData.mMainRoomId = ((int)((IQQLiveRoomPushService)localObject).b());
        localLiveMessageData.mSubRoomId = ((int)((IQQLiveRoomPushService)localObject).b());
      }
      localLiveMessageData.mMessageType = 1;
      localLiveMessageData.mSpeakerInfo.mSpeakId = this.sdkImpl.getLoginModule().getLoginInfo().uid;
      localLiveMessageData.mSpeakerInfo.mBusinessUid = this.sdkImpl.getLoginModule().getLoginInfo().businessUid;
      localObject = this.sdkImpl.getLoginModule().getUserInfo();
      if (localObject != null)
      {
        localLiveMessageData.mSpeakerInfo.mSpeakerName = ((LiveUserInfo)localObject).nick;
        localLiveMessageData.mSpeakerInfo.mLogo = ((LiveUserInfo)localObject).headUrl;
      }
      localObject = paramArrayList;
      if (paramArrayList == null) {
        localObject = new ArrayList();
      }
      localLiveMessageData.msgContent.mExtDatas.addAll((Collection)localObject);
      localLiveMessageData.getClass();
      paramArrayList = new LiveMessageData.MsgElement(localLiveMessageData);
      paramArrayList.mElementType = 1;
      localLiveMessageData.getClass();
      paramArrayList.mTextMsg = new LiveMessageData.TextElement(localLiveMessageData);
      try
      {
        paramArrayList.mTextMsg.mText = paramString.getBytes("utf-16LE");
        localLiveMessageData.msgContent.mMsgElements.add(paramArrayList);
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramString.printStackTrace();
      }
      sendMessage(localLiveMessageData, paramIQQLiveMessageCallback, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.impl.message.QQLiveChatMsgServiceImpl
 * JD-Core Version:    0.7.0.1
 */