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
  private WeakReference<OnBindCallback> jdField_a_of_type_JavaLangRefWeakReference;
  
  public GameRoomAVControllerDelegateImpl$ServiceConnectionListener(GameRoomAVControllerDelegateImpl paramGameRoomAVControllerDelegateImpl, OnBindCallback paramOnBindCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnBindCallback);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    GameRoomAVControllerDelegateImpl.access$002(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomImplGameRoomAVControllerDelegateImpl, IAVServiceForQQ.Stub.a(paramIBinder));
    paramComponentName = (OnBindCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.at();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    GameRoomAVControllerDelegateImpl.access$002(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomImplGameRoomAVControllerDelegateImpl, null);
    paramComponentName = (OnBindCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.au();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.impl.GameRoomAVControllerDelegateImpl.ServiceConnectionListener
 * JD-Core Version:    0.7.0.1
 */