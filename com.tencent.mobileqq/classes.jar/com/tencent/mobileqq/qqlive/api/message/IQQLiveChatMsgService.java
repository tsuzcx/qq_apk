package com.tencent.mobileqq.qqlive.api.message;

import com.tencent.mobileqq.qqlive.api.IQQLiveModule;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveMessageCallback;
import com.tencent.mobileqq.qqlive.callback.message.IQQLiveReceiveMessageListener;
import com.tencent.mobileqq.qqlive.callback.message.IllegalMessageListener;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData.ExtData;
import java.util.ArrayList;

public abstract interface IQQLiveChatMsgService
  extends IQQLiveModule
{
  public static final int DEFAULT_SEND = 0;
  public static final int SEND_LOCAL_ONLY = 2;
  public static final int SEND_REMOTE_ONLY = 1;
  
  public abstract void addChatMessageListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener);
  
  public abstract void addIllegalMessageListener(IllegalMessageListener paramIllegalMessageListener);
  
  public abstract void delChatMessageListener(IQQLiveReceiveMessageListener paramIQQLiveReceiveMessageListener);
  
  public abstract void delIllegalMessageListener(IllegalMessageListener paramIllegalMessageListener);
  
  public abstract void sendMessage(LiveMessageData paramLiveMessageData, IQQLiveMessageCallback paramIQQLiveMessageCallback, int paramInt);
  
  public abstract void sendMessage(String paramString, ArrayList<LiveMessageData.ExtData> paramArrayList, IQQLiveMessageCallback paramIQQLiveMessageCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.message.IQQLiveChatMsgService
 * JD-Core Version:    0.7.0.1
 */