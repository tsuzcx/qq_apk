package com.tencent.mobileqq.nearby.gameroom.impl;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.av.service.IAVServiceForQQ.Stub;
import com.tencent.mobileqq.nearby.gameroom.OnBindCallback;
import java.lang.ref.WeakReference;

public class GameRoomAVControllerDelegateImpl$ServiceConnectionListener
  implements ServiceConnection
{
  private WeakReference<OnBindCallback> b;
  
  public GameRoomAVControllerDelegateImpl$ServiceConnectionListener(GameRoomAVControllerDelegateImpl paramGameRoomAVControllerDelegateImpl, OnBindCallback paramOnBindCallback)
  {
    this.b = new WeakReference(paramOnBindCallback);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    GameRoomAVControllerDelegateImpl.access$002(this.a, IAVServiceForQQ.Stub.a(paramIBinder));
    paramComponentName = (OnBindCallback)this.b.get();
    if (paramComponentName != null) {
      paramComponentName.bJ();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    GameRoomAVControllerDelegateImpl.access$002(this.a, null);
    paramComponentName = (OnBindCallback)this.b.get();
    if (paramComponentName != null) {
      paramComponentName.bK();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.impl.GameRoomAVControllerDelegateImpl.ServiceConnectionListener
 * JD-Core Version:    0.7.0.1
 */