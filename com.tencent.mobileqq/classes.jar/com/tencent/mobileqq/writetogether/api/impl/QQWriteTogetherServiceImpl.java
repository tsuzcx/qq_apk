package com.tencent.mobileqq.writetogether.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.writetogether.IWriteTogetherObserver;
import com.tencent.mobileqq.writetogether.api.IQQWriteTogetherService;
import com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketEngine;
import com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketSender;
import com.tencent.mobileqq.writetogether.websocket.msg.BaseToWriteTogetherMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.BaseWriteTogetherMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.IWriteTogetherMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.Type;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class QQWriteTogetherServiceImpl
  implements IQQWriteTogetherService
{
  private AppRuntime appRuntime;
  private CopyOnWriteArrayList<IWriteTogetherObserver> mBgObservers = new CopyOnWriteArrayList();
  private MqqHandler mSubHandler;
  private MqqHandler mUiHandler;
  private CopyOnWriteArrayList<IWriteTogetherObserver> mUiObservers = new CopyOnWriteArrayList();
  private WriteTogetherWebSocketSender mWriteTogetherWebSocketSender;
  
  private void dispatchObservers(IWriteTogetherObserver paramIWriteTogetherObserver, Type paramType, boolean paramBoolean, Object paramObject, MqqHandler paramMqqHandler)
  {
    paramMqqHandler.post(new QQWriteTogetherServiceImpl.1(this, paramIWriteTogetherObserver, paramType, paramBoolean, paramObject));
  }
  
  public void addObservers(IWriteTogetherObserver paramIWriteTogetherObserver)
  {
    addObservers(paramIWriteTogetherObserver, false);
  }
  
  public void addObservers(IWriteTogetherObserver paramIWriteTogetherObserver, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mBgObservers.add(paramIWriteTogetherObserver);
      return;
    }
    this.mUiObservers.add(paramIWriteTogetherObserver);
  }
  
  public void init(String paramString1, String paramString2, int paramInt)
  {
    this.mWriteTogetherWebSocketSender.a(this.appRuntime, paramString1, paramString2, paramInt);
  }
  
  public void notify(IWriteTogetherMsg paramIWriteTogetherMsg)
  {
    if (!(paramIWriteTogetherMsg instanceof BaseWriteTogetherMsg)) {
      return;
    }
    paramIWriteTogetherMsg = (BaseWriteTogetherMsg)paramIWriteTogetherMsg;
    Type localType = paramIWriteTogetherMsg.getType();
    Iterator localIterator = this.mUiObservers.iterator();
    while (localIterator.hasNext()) {
      dispatchObservers((IWriteTogetherObserver)localIterator.next(), localType, true, paramIWriteTogetherMsg, this.mUiHandler);
    }
    localIterator = this.mBgObservers.iterator();
    while (localIterator.hasNext()) {
      dispatchObservers((IWriteTogetherObserver)localIterator.next(), localType, true, paramIWriteTogetherMsg, this.mSubHandler);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.appRuntime = paramAppRuntime;
    this.mWriteTogetherWebSocketSender = new WriteTogetherWebSocketSender(new WriteTogetherWebSocketEngine());
    this.mUiHandler = ThreadManager.getUIHandler();
    this.mSubHandler = ThreadManager.getSubThreadHandler();
  }
  
  public void onDestroy()
  {
    stop();
  }
  
  public void removeObserver(IWriteTogetherObserver paramIWriteTogetherObserver)
  {
    removeObserver(paramIWriteTogetherObserver, false);
  }
  
  public void removeObserver(IWriteTogetherObserver paramIWriteTogetherObserver, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mBgObservers.remove(paramIWriteTogetherObserver);
      return;
    }
    this.mUiObservers.remove(paramIWriteTogetherObserver);
  }
  
  public void sendData(IWriteTogetherMsg paramIWriteTogetherMsg)
  {
    if (!(paramIWriteTogetherMsg instanceof BaseWriteTogetherMsg)) {
      return;
    }
    paramIWriteTogetherMsg = (BaseToWriteTogetherMsg)paramIWriteTogetherMsg;
    this.mWriteTogetherWebSocketSender.a(paramIWriteTogetherMsg);
  }
  
  public void stop()
  {
    this.mWriteTogetherWebSocketSender.d();
  }
  
  public void updateRev(int paramInt)
  {
    this.mWriteTogetherWebSocketSender.a(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.api.impl.QQWriteTogetherServiceImpl
 * JD-Core Version:    0.7.0.1
 */