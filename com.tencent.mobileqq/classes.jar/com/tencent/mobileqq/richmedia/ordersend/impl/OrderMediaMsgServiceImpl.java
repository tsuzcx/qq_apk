package com.tencent.mobileqq.richmedia.ordersend.impl;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import com.tencent.mobileqq.richmedia.ordersend.IMediaMsgApi;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService.IMsgSendingListener;
import com.tencent.mobileqq.richmedia.ordersend.MediaMsgController;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgReporter;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgSessionQueue;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgSessionQueue.IMsgPhaseListener;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgStatusCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class OrderMediaMsgServiceImpl
  implements IOrderMediaMsgService, OrderMediaMsgSessionQueue.IMsgPhaseListener
{
  public static final String TAG = "OrderMediaMsgService";
  @ConfigInject(configPath="Business/qqrichmedia-impl/src/main/resources/Inject_MediaMsgController.yml", version=1)
  public static ArrayList<Class<? extends IMediaMsgApi>> sInjectMediaMsgCtrlList = new ArrayList();
  private AppRuntime mApp;
  private IMediaMsgApi mMediaMsgController;
  protected HashMap<String, OrderMediaMsgSessionQueue> mOrderMediaMsgSessionMap = new HashMap();
  
  static
  {
    sInjectMediaMsgCtrlList.add(MediaMsgController.class);
  }
  
  private OrderMediaMsgSessionQueue getOrderMediaMsgSession(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    synchronized (this.mOrderMediaMsgSessionMap)
    {
      if (this.mOrderMediaMsgSessionMap.containsKey(paramString))
      {
        paramString = (OrderMediaMsgSessionQueue)this.mOrderMediaMsgSessionMap.get(paramString);
      }
      else
      {
        OrderMediaMsgSessionQueue localOrderMediaMsgSessionQueue = new OrderMediaMsgSessionQueue(paramString, getMsgController());
        localOrderMediaMsgSessionQueue.a(this);
        this.mOrderMediaMsgSessionMap.put(paramString, localOrderMediaMsgSessionQueue);
        paramString = localOrderMediaMsgSessionQueue;
      }
      return paramString;
    }
  }
  
  public boolean addCallback(String paramString, long paramLong, View paramView, Callback paramCallback)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.mOrderMediaMsgSessionMap.containsKey(paramString))) {
      return getOrderMediaMsgSession(paramString).a().a(this.mApp, paramLong, paramView, paramCallback);
    }
    return false;
  }
  
  public void addOrderMsg(MessageRecord paramMessageRecord, String paramString)
  {
    Object localObject = getOrderMediaMsgSession(paramMessageRecord.frienduin);
    if (((OrderMediaMsgSessionQueue)localObject).a(paramMessageRecord.uniseq, paramString))
    {
      ((OrderMediaMsgSessionQueue)localObject).a(paramMessageRecord, paramMessageRecord.uniseq, paramString, true);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addOrderMsg but not in queue, uniseq:");
      ((StringBuilder)localObject).append(paramMessageRecord.uniseq);
      ((StringBuilder)localObject).append(", path:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("OrderMediaMsgService", 2, ((StringBuilder)localObject).toString());
    }
    getMsgController().a(paramMessageRecord);
  }
  
  public void addOrderMsgStatus(String paramString1, MessageRecord paramMessageRecord, String paramString2)
  {
    OrderMediaMsgSessionQueue localOrderMediaMsgSessionQueue = getOrderMediaMsgSession(paramMessageRecord.frienduin);
    if (!localOrderMediaMsgSessionQueue.a(paramMessageRecord.uniseq, paramString2)) {
      enqueueMediaMsgByUniseq(paramString1, paramMessageRecord.uniseq);
    }
    localOrderMediaMsgSessionQueue.a(paramMessageRecord, paramMessageRecord.uniseq, paramString2, false);
  }
  
  public void enqueueMediaMsgByMsgList(String paramString, ArrayList<ChatMessage> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      int i = 0;
      int j = 0;
      while (paramArrayList.hasNext())
      {
        ChatMessage localChatMessage = (ChatMessage)paramArrayList.next();
        int k = i + 1;
        i = k;
        if (getMsgController().b(localChatMessage.msgtype))
        {
          j += 1;
          getOrderMediaMsgSession(paramString).a(localChatMessage.uniseq, "", getMsgController().a(localChatMessage));
          i = k;
        }
      }
      OrderMediaMsgReporter.b(i, j);
    }
  }
  
  public void enqueueMediaMsgByPath(String paramString1, String paramString2)
  {
    if (getMsgController().a(paramString2)) {
      return;
    }
    getOrderMediaMsgSession(paramString1).a(0L, paramString2);
  }
  
  public void enqueueMediaMsgByUniseq(String paramString, long paramLong)
  {
    getOrderMediaMsgSession(paramString).a(paramLong, "");
  }
  
  public IMediaMsgApi getMsgController()
  {
    if (this.mMediaMsgController == null) {
      try
      {
        this.mMediaMsgController = ((IMediaMsgApi)((Class)sInjectMediaMsgCtrlList.get(0)).newInstance());
      }
      catch (Exception localException)
      {
        QLog.d("OrderMediaMsgService", 1, "getMsgCtr error!", localException);
      }
    }
    return this.mMediaMsgController;
  }
  
  public boolean isMediaMsgInQueue(String paramString, long paramLong)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (!this.mOrderMediaMsgSessionMap.containsKey(paramString)) {
        return false;
      }
      bool1 = bool2;
      if (getOrderMediaMsgSession(paramString).a().a(paramLong) != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isMediaMsgInQueueNotHead(String paramString, long paramLong)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      if (!this.mOrderMediaMsgSessionMap.containsKey(paramString)) {
        return false;
      }
      bool1 = bool2;
      if (getOrderMediaMsgSession(paramString).a().a(paramLong) == 2) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean isSessionOrderSending(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.mOrderMediaMsgSessionMap.containsKey(paramString))) {
      return getOrderMediaMsgSession(paramString).a() ^ true;
    }
    return false;
  }
  
  public void onAllCompleted(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.mOrderMediaMsgSessionMap)
      {
        localOrderMediaMsgSessionQueue = (OrderMediaMsgSessionQueue)this.mOrderMediaMsgSessionMap.remove(paramString);
      }
    }
    OrderMediaMsgSessionQueue localOrderMediaMsgSessionQueue = null;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("remove orderSession, suin = ");
      ((StringBuilder)???).append(paramString);
      ((StringBuilder)???).append(", addr = ");
      if (localOrderMediaMsgSessionQueue != null) {
        paramString = localOrderMediaMsgSessionQueue.toString();
      } else {
        paramString = Integer.valueOf(0);
      }
      ((StringBuilder)???).append(paramString);
      QLog.d("OrderMediaMsgService", 2, ((StringBuilder)???).toString());
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    Object localObject = this.mOrderMediaMsgSessionMap;
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((OrderMediaMsgSessionQueue)((Iterator)localObject).next()).a();
      }
      this.mOrderMediaMsgSessionMap.clear();
    }
    this.mApp = null;
  }
  
  public void removeMediaMsgByUniseq(String paramString, long paramLong)
  {
    getOrderMediaMsgSession(paramString).a(paramLong);
  }
  
  public void sendOrderMsg(MessageRecord paramMessageRecord, MediaMessageObserver paramMediaMessageObserver)
  {
    sendOrderMsg(paramMessageRecord, paramMediaMessageObserver, null);
  }
  
  public void sendOrderMsg(MessageRecord paramMessageRecord, MediaMessageObserver paramMediaMessageObserver, IOrderMediaMsgService.IMsgSendingListener paramIMsgSendingListener)
  {
    Object localObject = getOrderMediaMsgSession(paramMessageRecord.frienduin);
    String str = getMsgController().a(paramMessageRecord);
    if (((OrderMediaMsgSessionQueue)localObject).a(paramMessageRecord.uniseq, str))
    {
      ((OrderMediaMsgSessionQueue)localObject).a(paramMessageRecord, paramMediaMessageObserver, paramIMsgSendingListener);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendOrderMsg but not in queue, uniseq:");
      ((StringBuilder)localObject).append(paramMessageRecord.uniseq);
      QLog.d("OrderMediaMsgService", 2, ((StringBuilder)localObject).toString());
    }
    getMsgController().a(paramMessageRecord, paramMediaMessageObserver, paramIMsgSendingListener);
  }
  
  public void updateMediaMsgByUniseq(String paramString, long paramLong1, long paramLong2)
  {
    getOrderMediaMsgSession(paramString).a(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.ordersend.impl.OrderMediaMsgServiceImpl
 * JD-Core Version:    0.7.0.1
 */