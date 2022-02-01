package com.tencent.mobileqq.writetogether.client;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.writetogether.IWriteTogetherObserver;
import com.tencent.mobileqq.writetogether.api.IQQWriteTogetherService;
import com.tencent.mobileqq.writetogether.websocket.WriteTogetherWebSocketEngine;
import com.tencent.mobileqq.writetogether.websocket.msg.ClientReadyReqMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.ClientReadyRespMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.OnPostResult;
import com.tencent.mobileqq.writetogether.websocket.msg.OnPostWrapper;
import com.tencent.mobileqq.writetogether.websocket.msg.Type;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class RoomController
  implements IWriteTogetherObserver, Runnable
{
  int a;
  private WriteTogetherWebSocketEngine b;
  private String c;
  private long d;
  private String e;
  private String f;
  private IQQWriteTogetherService g;
  private RoomController.OnEnterRoomListener h;
  private boolean i;
  
  public RoomController(AppRuntime paramAppRuntime, WriteTogetherWebSocketEngine paramWriteTogetherWebSocketEngine, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this.b = paramWriteTogetherWebSocketEngine;
    this.c = paramAppRuntime.getAccount();
    try
    {
      this.d = Long.parseLong(paramString1);
    }
    catch (NumberFormatException paramWriteTogetherWebSocketEngine)
    {
      QLog.e("RoomController", 1, paramWriteTogetherWebSocketEngine, new Object[0]);
    }
    this.e = paramString2;
    this.a = paramInt;
    this.f = paramString3;
    this.g = ((IQQWriteTogetherService)paramAppRuntime.getRuntimeService(IQQWriteTogetherService.class, ""));
    this.g.addObservers(this);
  }
  
  public void a()
  {
    this.b.a(new ClientReadyReqMsg(this.c, this.e, this.d, this.a, this.f));
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(RoomController.OnEnterRoomListener paramOnEnterRoomListener)
  {
    this.h = paramOnEnterRoomListener;
  }
  
  public void a(Type paramType, boolean paramBoolean, Object paramObject)
  {
    int j = RoomController.1.a[paramType.ordinal()];
    if (j != 1)
    {
      if (j != 2) {
        return;
      }
      this.h.a();
      return;
    }
    paramType = ((OnPostWrapper)((ClientReadyRespMsg)paramObject).body).onpost;
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("isSuccesss: ");
      paramObject.append(paramBoolean);
      paramObject.append(", ret: ");
      paramObject.append(paramType.result);
      QLog.d("RoomController", 2, paramObject.toString());
    }
    paramObject = this.h;
    if (paramObject != null) {
      paramObject.a(paramBoolean, paramType.result);
    }
    if (paramType.result == 60010) {
      ThreadManager.getSubThreadHandler().postDelayed(this, 10000L);
    }
  }
  
  public void b()
  {
    this.g.removeObserver(this);
    this.i = true;
  }
  
  public void run()
  {
    if (this.i) {
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.RoomController
 * JD-Core Version:    0.7.0.1
 */