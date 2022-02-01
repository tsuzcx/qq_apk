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
  public static final ListenTogetherHeartBeatController.Companion a;
  private volatile int jdField_a_of_type_Int;
  @NotNull
  private final Handler jdField_a_of_type_AndroidOsHandler;
  @NotNull
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  @NotNull
  private final ListenTogetherHeartBeatController.Data jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController$Data;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile int b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController$Companion = new ListenTogetherHeartBeatController.Companion(null);
  }
  
  public ListenTogetherHeartBeatController(@NotNull QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = 60000;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), (Handler.Callback)this);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController$Data = new ListenTogetherHeartBeatController.Data(0, "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((BusinessObserver)this, true);
  }
  
  private final void e()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, this.jdField_a_of_type_Int);
  }
  
  private final void f()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        return;
      }
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.LISTEN_TOGETHER_HANDLER);
      if (localObject1 != null)
      {
        ((ListenTogetherHandler)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController$Data.a(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController$Data.a());
        e();
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("doHeartBeat uin=");
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController$Data.a());
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
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
  }
  
  protected void a(@NotNull ListenTogetherSession paramListenTogetherSession)
  {
    for (;;)
    {
      try
      {
        Intrinsics.checkParameterIsNotNull(paramListenTogetherSession, "session");
        Object localObject = ListenTogetherManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "mgr");
        boolean bool2 = ((ListenTogetherManager)localObject).a();
        boolean bool3 = ((ListenTogetherManager)localObject).b(paramListenTogetherSession.f, paramListenTogetherSession.e);
        bool1 = true;
        if (bool3)
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController$Data;
          i = paramListenTogetherSession.f;
          String str = paramListenTogetherSession.e;
          Intrinsics.checkExpressionValueIsNotNull(str, "session.uin");
          if ((Intrinsics.areEqual(localObject, new ListenTogetherHeartBeatController.Data(i, str)) ^ true))
          {
            this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController$Data.a(paramListenTogetherSession.f);
            this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController$Data.a(paramListenTogetherSession.e);
            i = 1;
            continue;
          }
        }
        if (!bool2)
        {
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController$Data.a(0);
          this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController$Data.a("");
          break label312;
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherHeartBeatController$Data.a() != 2) {
            break label317;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onUIModuleNeedRefresh joinState=");
            ((StringBuilder)localObject).append(paramListenTogetherSession.i);
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
            if ((i != 0) && (!this.jdField_a_of_type_Boolean)) {
              a();
            }
            if (this.jdField_a_of_type_Boolean) {
              b();
            }
          }
          else if ((!this.jdField_a_of_type_Boolean) && (!bool2))
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
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    boolean bool;
    if (SystemClock.elapsedRealtime() - paramLong > 30000) {
      bool = true;
    } else {
      bool = false;
    }
    if ((paramBoolean) && (!bool)) {
      this.b = 0;
    } else {
      this.b += 1;
    }
    if (this.b > 15)
    {
      paramString1 = new StringBuilder();
      paramString1.append("onHeartBeat isTimeout=");
      paramString1.append(bool);
      paramString1.append(" errCount=");
      paramString1.append(this.b);
      paramString1.append(" stop");
      QLog.d("ListenTogetherHeartBeatController", 1, paramString1.toString());
      a();
    }
    if (paramBoolean == true)
    {
      if ((paramInt2 > 0) && (paramInt2 != this.jdField_a_of_type_Int)) {
        this.jdField_a_of_type_Int = paramInt2;
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
    this.jdField_a_of_type_Boolean = false;
    this.b = 0;
    f();
  }
  
  public final void c()
  {
    a();
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)this);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.ListenTogetherHeartBeatController
 * JD-Core Version:    0.7.0.1
 */