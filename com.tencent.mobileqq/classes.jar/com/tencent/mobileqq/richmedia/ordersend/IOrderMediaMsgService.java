package com.tencent.mobileqq.richmedia.ordersend;

import android.view.View;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;

@Service(process={""})
public abstract interface IOrderMediaMsgService
  extends IRuntimeService
{
  public abstract boolean addCallback(String paramString, long paramLong, View paramView, Callback paramCallback);
  
  public abstract void addOrderMsg(MessageRecord paramMessageRecord, String paramString);
  
  public abstract void addOrderMsgStatus(String paramString1, MessageRecord paramMessageRecord, String paramString2);
  
  public abstract void enqueueMediaMsgByMsgList(String paramString, ArrayList<ChatMessage> paramArrayList);
  
  public abstract void enqueueMediaMsgByPath(String paramString1, String paramString2);
  
  public abstract void enqueueMediaMsgByUniseq(String paramString, long paramLong);
  
  public abstract IMediaMsgApi getMsgController();
  
  public abstract boolean isMediaMsgInQueue(String paramString, long paramLong);
  
  public abstract boolean isMediaMsgInQueueNotHead(String paramString, long paramLong);
  
  public abstract boolean isSessionOrderSending(String paramString);
  
  public abstract void removeMediaMsgByUniseq(String paramString, long paramLong);
  
  public abstract void sendOrderMsg(MessageRecord paramMessageRecord, MediaMessageObserver paramMediaMessageObserver);
  
  public abstract void sendOrderMsg(MessageRecord paramMessageRecord, MediaMessageObserver paramMediaMessageObserver, IOrderMediaMsgService.IMsgSendingListener paramIMsgSendingListener);
  
  public abstract void updateMediaMsgByUniseq(String paramString, long paramLong1, long paramLong2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService
 * JD-Core Version:    0.7.0.1
 */