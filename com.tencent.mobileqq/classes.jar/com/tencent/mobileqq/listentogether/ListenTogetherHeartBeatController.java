package com.tencent.mobileqq.listentogether;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/listentogether/ListenTogetherHeartBeatController;", "Lcom/tencent/mobileqq/listentogether/ListenTogetherObserver;", "Landroid/os/Handler$Callback;", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "(Lcom/tencent/mobileqq/app/QQAppInterface;)V", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "errCount", "", "getErrCount", "()I", "setErrCount", "(I)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "interval", "getInterval", "setInterval", "joinedData", "Lcom/tencent/mobileqq/listentogether/ListenTogetherHeartBeatController$Data;", "getJoinedData", "()Lcom/tencent/mobileqq/listentogether/ListenTogetherHeartBeatController$Data;", "stop", "", "getStop", "()Z", "setStop", "(Z)V", "destroy", "", "doHeartBeat", "handleMessage", "msg", "Landroid/os/Message;", "keepHeartBeat", "onHeartBeat", "suc", "type", "uin", "", "reqTs", "", "errCode", "errWording", "onUIModuleNeedRefresh", "session", "Lcom/tencent/mobileqq/listentogether/ListenTogetherSession;", "start", "Companion", "Data", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ListenTogetherHeartBeatController
  extends ListenTogetherObserver
  implements Handler.Callback
{
  public static final ListenTogetherHeartBeatController.Companion a = new ListenTogetherHeartBeatController.Companion(null);
  private volatile int b;
  @NotNull
  private final Handler c;
  private volatile boolean d;
  private volatile int e;
  @NotNull
  private final ListenTogetherHeartBeatController.Data f;
  @NotNull
  private final QQAppInterface g;
  
  public ListenTogetherHeartBeatController(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.g = paramQQAppInterface;
    this.b = 60000;
    this.c = new Handler(ThreadManager.getSubThreadLooper(), (Handler.Callback)this);
    this.d = true;
    this.f = new ListenTogetherHeartBeatController.Data(0, "");
    this.g.addObserver((BusinessObserver)this, true);
  }
  
  private final void e()
  {
    this.c.removeMessages(0);
    this.c.sendEmptyMessageDelayed(0, this.b);
  }
  
  private final void f()
  {
    try
    {
      boolean bool = this.d;
      if (bool) {
        return;
      }
      Object localObject1 = this.g.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
      if (localObject1 != null)
      {
        ((ListenTogetherHandler)localObject1).e(this.f.a(), this.f.b());
        e();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("doHeartBeat uin=");
          ((StringBuilder)localObject1).append(this.f.b());
          QLog.d("ListenTogetherHeartBeatController", 2, ((StringBuilder)localObject1).toString());
        }
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.listentogether.ListenTogetherHandler");
    }
    finally {}
  }
  
  public final void a()
  {
    QLog.d("ListenTogetherHeartBeatController", 1, "stop heartBeat");
    this.d = true;
    this.c.removeMessages(0);
  }
  
  protected void a(@NotNull ListenTogetherSession paramListenTogetherSession)
  {
    for (;;)
    {
      try
      {
        Intrinsics.checkParameterIsNotNull(paramListenTogetherSession, "session");
        Object localObject = ListenTogetherManager.a(this.g);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "mgr");
        boolean bool2 = ((ListenTogetherManager)localObject).e();
        boolean bool3 = ((ListenTogetherManager)localObject).d(paramListenTogetherSession.m, paramListenTogetherSession.n);
        bool1 = true;
        if (bool3)
        {
          localObject = this.f;
          i = paramListenTogetherSession.m;
          String str = paramListenTogetherSession.n;
          Intrinsics.checkExpressionValueIsNotNull(str, "session.uin");
          if ((Intrinsics.areEqual(localObject, new ListenTogetherHeartBeatController.Data(i, str)) ^ true))
          {
            this.f.a(paramListenTogetherSession.m);
            this.f.a(paramListenTogetherSession.n);
            i = 1;
            continue;
          }
        }
        if (!bool2)
        {
          this.f.a(0);
          this.f.a("");
          break label312;
          if (this.f.a() != 2) {
            break label317;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onUIModuleNeedRefresh joinState=");
            ((StringBuilder)localObject).append(paramListenTogetherSession.q);
            ((StringBuilder)localObject).append(" isJoin=");
            ((StringBuilder)localObject).append(bool2);
            ((StringBuilder)localObject).append(" isJoinThisSession=");
            ((StringBuilder)localObject).append(bool3);
            ((StringBuilder)localObject).append(" isJoinedSessionC2c=");
            ((StringBuilder)localObject).append(bool1);
            QLog.d("ListenTogetherHeartBeatController", 2, ((StringBuilder)localObject).toString());
          }
          if (bool2)
          {
            if ((i != 0) && (!this.d)) {
              a();
            }
            if (this.d) {
              b();
            }
          }
          else if ((!this.d) && (!bool2))
          {
            a();
          }
          return;
        }
      }
      finally {}
      label312:
      int i = 0;
      continue;
      label317:
      boolean bool1 = false;
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt1, @NotNull String paramString1, long paramLong, int paramInt2, int paramInt3, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "uin");
    Intrinsics.checkParameterIsNotNull(paramString2, "errWording");
    if (this.d) {
      return;
    }
    boolean bool;
    if (SystemClock.elapsedRealtime() - paramLong > 30000) {
      bool = true;
    } else {
      bool = false;
    }
    if ((paramBoolean) && (!bool)) {
      this.e = 0;
    } else {
      this.e += 1;
    }
    if (this.e > 15)
    {
      paramString1 = new StringBuilder();
      paramString1.append("onHeartBeat isTimeout=");
      paramString1.append(bool);
      paramString1.append(" errCount=");
      paramString1.append(this.e);
      paramString1.append(" stop");
      QLog.d("ListenTogetherHeartBeatController", 1, paramString1.toString());
      a();
    }
    if (paramBoolean == true)
    {
      if ((paramInt2 > 0) && (paramInt2 != this.b)) {
        this.b = paramInt2;
      }
    }
    else if (!paramBoolean)
    {
      paramString1 = new StringBuilder();
      paramString1.append("onHeartBeat failed errCode=");
      paramString1.append(paramInt3);
      paramString1.append(" errWordig=");
      paramString1.append(paramString2);
      QLog.d("ListenTogetherHeartBeatController", 1, paramString1.toString());
    }
  }
  
  public final void b()
  {
    QLog.d("ListenTogetherHeartBeatController", 1, "start heartBeat");
    this.d = false;
    this.e = 0;
    f();
  }
  
  public final void c()
  {
    a();
    this.c.removeCallbacksAndMessages(null);
    this.g.removeObserver((BusinessObserver)this);
  }
  
  public boolean handleMessage(@NotNull Message paramMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramMessage, "msg");
    if (paramMessage.what == 0) {
      f();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherHeartBeatController
 * JD-Core Version:    0.7.0.1
 */