package com.tencent.mobileqq.writetogether.websocket;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.writetogether.client.RoomController;
import com.tencent.mobileqq.writetogether.client.RoomController.OnEnterRoomListener;
import com.tencent.mobileqq.writetogether.websocket.msg.BaseToWriteTogetherMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import okhttp3.WebSocketListener;

public class WriteTogetherWebSocketSender
  implements RoomController.OnEnterRoomListener
{
  boolean a;
  RoomController b;
  boolean c;
  WebSocketListener d;
  private LinkedBlockingDeque<BaseToWriteTogetherMsg> e = new LinkedBlockingDeque();
  private ConcurrentHashMap<Integer, BaseToWriteTogetherMsg> f = new ConcurrentHashMap();
  private AtomicBoolean g = new AtomicBoolean(false);
  private WriteTogetherWebSocketSender.Worker h;
  private WriteTogetherWebSocketEngine i;
  private WriteTogetherWebSocketAlarm j;
  private HeartBeat k;
  private final Object l = new Object();
  private int m = 2000;
  private String n;
  private String o;
  private INetInfoHandler p;
  
  public WriteTogetherWebSocketSender(WriteTogetherWebSocketEngine paramWriteTogetherWebSocketEngine)
  {
    this.i = paramWriteTogetherWebSocketEngine;
    this.j = new WriteTogetherWebSocketAlarm(this);
    f();
  }
  
  private void f()
  {
    this.k = new HeartBeat(this);
  }
  
  private void g()
  {
    this.a = true;
    this.e.clear();
    this.f.clear();
    this.h = new WriteTogetherWebSocketSender.Worker(this, null);
    this.h.setName("WriteTogether.WriteTogetherWebSocketSender");
    this.h.start();
  }
  
  public void a()
  {
    this.k.a(true);
    if (this.e.size() == 0) {
      a(this.k.a());
    }
  }
  
  public void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void a(BaseToWriteTogetherMsg paramBaseToWriteTogetherMsg)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendData, ");
      localStringBuilder.append(paramBaseToWriteTogetherMsg.toShortStr());
      QLog.d("WriteTogether.WriteTogetherWebSocketSender", 2, localStringBuilder.toString());
    }
    if ((!this.a) && (!this.c)) {
      g();
    }
    try
    {
      paramBaseToWriteTogetherMsg.header.groupCode = Integer.parseInt(this.o);
      paramBaseToWriteTogetherMsg.header.sig = this.n;
    }
    catch (Exception localException)
    {
      QLog.e("WriteTogether.WriteTogetherWebSocketSender", 1, localException, new Object[0]);
    }
    if (this.e.offer(paramBaseToWriteTogetherMsg))
    {
      this.f.put(Integer.valueOf(paramBaseToWriteTogetherMsg.getSeq()), paramBaseToWriteTogetherMsg);
      this.j.a(paramBaseToWriteTogetherMsg, paramBaseToWriteTogetherMsg.getTimeout());
      return;
    }
    QLog.d("WriteTogether.WriteTogetherWebSocketSender", 1, "sendData, but mWaitSendQueue is full");
  }
  
  public void a(AppRuntime paramAppRuntime, String paramString1, String paramString2, int paramInt)
  {
    this.c = false;
    this.o = paramString2;
    if (this.d == null) {
      this.d = new WriteTogetherWebSocketSender.1(this);
    }
    this.i.a(this.d);
    TicketManager localTicketManager = (TicketManager)paramAppRuntime.getManager(2);
    String str = paramAppRuntime.getAccount();
    if (localTicketManager != null) {
      this.n = localTicketManager.getA2(str);
    }
    c();
    this.k.a(paramString1, str);
    this.b = new RoomController(paramAppRuntime, this.i, paramString2, paramString1, paramInt, this.n);
    this.b.a(this);
    this.i.b();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (paramInt == 60010) {
      return;
    }
    if ((paramBoolean) && (paramInt == 0)) {
      synchronized (this.l)
      {
        this.l.notify();
        this.k.a(false);
        if (this.k.a() != null)
        {
          ThreadManager.getSubThreadHandler().postDelayed(this.k, 30000L);
          return;
        }
        throw new IllegalStateException("heart beat not initialize");
      }
    }
    this.a = false;
    synchronized (this.l)
    {
      this.l.notify();
      return;
    }
  }
  
  public ConcurrentHashMap<Integer, BaseToWriteTogetherMsg> b()
  {
    return this.f;
  }
  
  void c()
  {
    if (this.p == null) {
      this.p = new WriteTogetherWebSocketSender.MyNetInfoHandler(this, null);
    }
    AppNetConnInfo.registerConnectionChangeReceiver(MobileQQ.sMobileQQ, this.p);
  }
  
  public void d()
  {
    this.c = true;
    this.a = false;
    this.i.c();
    Object localObject = this.b;
    if (localObject != null) {
      ((RoomController)localObject).b();
    }
    localObject = this.p;
    if (localObject != null) {
      AppNetConnInfo.unregisterNetInfoHandler((INetInfoHandler)localObject);
    }
  }
  
  boolean e()
  {
    return NetworkUtil.isNetworkAvailable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketSender
 * JD-Core Version:    0.7.0.1
 */