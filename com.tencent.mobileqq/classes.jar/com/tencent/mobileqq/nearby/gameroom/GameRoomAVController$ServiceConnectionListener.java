package com.tencent.mobileqq.nearby.gameroom;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.av.service.IAVServiceForQQ.Stub;
import java.lang.ref.WeakReference;

public class GameRoomAVController$ServiceConnectionListener
  implements ServiceConnection
{
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public GameRoomAVController$ServiceConnectionListener(GameRoomAVController paramGameRoomAVController, GameRoomAVController.OnBindCallback paramOnBindCallback)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramOnBindCallback);
  }
  
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    GameRoomAVController.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController, IAVServiceForQQ.Stub.a(paramIBinder));
    paramComponentName = (GameRoomAVController.OnBindCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bc();
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    GameRoomAVController.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController, null);
    paramComponentName = (GameRoomAVController.OnBindCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramComponentName != null) {
      paramComponentName.bd();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomAVController.ServiceConnectionListener
 * JD-Core Version:    0.7.0.1
 */