package com.tencent.mobileqq.nearby.gameroom;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.service.IAVServiceForQQ;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class GameRoomAVController
{
  private static GameRoomAVController jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController;
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long;
  private IAVServiceForQQ jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ;
  private GameRoomAVController.ServiceConnectionListener jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController$ServiceConnectionListener;
  private GameRoomFloatView jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomFloatView = new GameRoomFloatView();
  public boolean a;
  private int b;
  public boolean b;
  public boolean c;
  public boolean d;
  
  public static GameRoomAVController a()
  {
    if (jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController == null) {
        jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController = new GameRoomAVController();
      }
      return jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController;
    }
    finally {}
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == 2;
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null) {}
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.a(paramBoolean);
        return;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "setSoundEnable: " + QLog.getStackTraceString(localRemoteException));
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Int != -1) {
      if (this.jdField_a_of_type_Int != 0) {
        break label23;
      }
    }
    label23:
    for (boolean bool = true;; bool = false)
    {
      b(bool);
      return;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomFloatView.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController$ServiceConnectionListener != null)
    {
      BaseApplicationImpl.getApplication().unbindService(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController$ServiceConnectionListener);
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController$ServiceConnectionListener = null;
    }
    this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (a(paramInt))
    {
      b(false);
      return;
    }
    f();
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    if ((!this.c) && (!this.d)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomFloatView.a(paramInt1, paramString1, paramInt2, paramLong, paramString2);
    }
  }
  
  public void a(int paramInt, String paramString1, long paramLong, String paramString2)
  {
    if ((!this.c) && (!this.d)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomFloatView.a(paramInt, paramString1, 10, paramLong, paramString2);
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.a(paramLong);
      this.jdField_b_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomFloatView.a();
      this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GameRoomAVController", 2, "exitRoom: " + QLog.getStackTraceString(localException));
        }
      }
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    this.jdField_a_of_type_Long = paramLong;
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null) {}
    do
    {
      return;
      try
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)) && (((QQAppInterface)localAppRuntime).a().d())) {
          this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.c();
        }
        this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.a(paramLong, paramString);
        this.jdField_b_of_type_Boolean = true;
        return;
      }
      catch (RemoteException paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "enterRoom: " + QLog.getStackTraceString(paramString));
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ = null;
    paramContext.stopService(new Intent(paramContext, AVServiceForQQ.class));
  }
  
  public void a(GameRoomAVController.OnBindCallback paramOnBindCallback)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null)
    {
      localIntent = new Intent(localBaseApplicationImpl, AVServiceForQQ.class);
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController$ServiceConnectionListener = new GameRoomAVController.ServiceConnectionListener(this, paramOnBindCallback);
      localBaseApplicationImpl.bindService(localIntent, this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController$ServiceConnectionListener, 1);
    }
    while (paramOnBindCallback == null)
    {
      Intent localIntent;
      return;
    }
    paramOnBindCallback.bc();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1)
    {
      this.jdField_a_of_type_Int = i;
      if ((!paramBoolean) || (!a(this.jdField_b_of_type_Int))) {
        break;
      }
      return;
    }
    b(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ != null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null) {}
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.a();
        return;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "startSpeak: " + QLog.getStackTraceString(localRemoteException));
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ == null) {}
    do
    {
      return;
      try
      {
        this.jdField_a_of_type_ComTencentAvServiceIAVServiceForQQ.b();
        return;
      }
      catch (RemoteException localRemoteException) {}
    } while (!QLog.isColorLevel());
    QLog.d("GameRoomAVController", 2, "stopSpeak: " + QLog.getStackTraceString(localRemoteException));
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomFloatView.a();
  }
  
  public void e()
  {
    f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomAVController
 * JD-Core Version:    0.7.0.1
 */