package com.tencent.mobileqq.nearby.gameroom.impl;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.service.AVServiceForQQ;
import com.tencent.av.service.IAVServiceForQQ;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.gameroom.GameRoomFloatView;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.nearby.gameroom.OnBindCallback;
import com.tencent.qphone.base.util.QLog;

public class GameRoomAVControllerDelegateImpl
  implements IGameRoomAVControllerDelegate
{
  private static final int DISABLE_STATE = 1;
  private static final int ENABLE_STATE = 0;
  private static final int INIT_STATE = -1;
  public static final String TAG = "GameRoomAVController";
  private boolean isInAIO = false;
  private boolean isInAudio = false;
  private boolean isInGameGift = false;
  private boolean isInvite = false;
  private IAVServiceForQQ mAVServiceForQQ;
  private int mCurrentPhoneState;
  private int mCurrentSoundEnableState = -1;
  private GameRoomFloatView mGameRoomFloatView = new GameRoomFloatView();
  private long mGroupId;
  private GameRoomAVControllerDelegateImpl.ServiceConnectionListener mServiceConnectionListener;
  
  private boolean isCalling(int paramInt)
  {
    return paramInt == 2;
  }
  
  private void restoreSoundState()
  {
    int i = this.mCurrentSoundEnableState;
    if (i != -1)
    {
      boolean bool;
      if (i == 0) {
        bool = true;
      } else {
        bool = false;
      }
      setSoundEnableInner(bool);
    }
  }
  
  private void setSoundEnableInner(boolean paramBoolean)
  {
    IAVServiceForQQ localIAVServiceForQQ = this.mAVServiceForQQ;
    if (localIAVServiceForQQ == null) {
      return;
    }
    try
    {
      localIAVServiceForQQ.a(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setSoundEnable: ");
        localStringBuilder.append(QLog.getStackTraceString(localRemoteException));
        QLog.d("GameRoomAVController", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void bindService(OnBindCallback paramOnBindCallback)
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.getApplication();
    if (this.mAVServiceForQQ == null)
    {
      Intent localIntent = new Intent(localBaseApplicationImpl, AVServiceForQQ.class);
      this.mServiceConnectionListener = new GameRoomAVControllerDelegateImpl.ServiceConnectionListener(this, paramOnBindCallback);
      localBaseApplicationImpl.bindService(localIntent, this.mServiceConnectionListener, 1);
      return;
    }
    if (paramOnBindCallback != null) {
      paramOnBindCallback.at();
    }
  }
  
  public void enterRoom(long paramLong, String paramString)
  {
    this.mGroupId = paramLong;
    if (this.mAVServiceForQQ == null) {
      return;
    }
    try
    {
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)) && (((QQAppInterface)localObject).getAVNotifyCenter().b())) {
        this.mAVServiceForQQ.c();
      }
      this.mAVServiceForQQ.a(paramLong, paramString);
      this.isInAudio = true;
      return;
    }
    catch (RemoteException paramString)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("enterRoom: ");
        ((StringBuilder)localObject).append(QLog.getStackTraceString(paramString));
        QLog.d("GameRoomAVController", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void exitRoom()
  {
    IAVServiceForQQ localIAVServiceForQQ = this.mAVServiceForQQ;
    if (localIAVServiceForQQ == null) {
      return;
    }
    try
    {
      localIAVServiceForQQ.a(this.mGroupId);
      this.isInAudio = false;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exitRoom: ");
        localStringBuilder.append(QLog.getStackTraceString(localRemoteException));
        QLog.d("GameRoomAVController", 2, localStringBuilder.toString());
      }
    }
    this.mGameRoomFloatView.a();
    this.mAVServiceForQQ = null;
  }
  
  public void exitRoom(long paramLong)
  {
    IAVServiceForQQ localIAVServiceForQQ = this.mAVServiceForQQ;
    if (localIAVServiceForQQ == null) {
      return;
    }
    try
    {
      localIAVServiceForQQ.a(paramLong);
      this.isInAudio = false;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("exitRoom: ");
        localStringBuilder.append(QLog.getStackTraceString(localException));
        QLog.d("GameRoomAVController", 2, localStringBuilder.toString());
      }
    }
    this.mGameRoomFloatView.a();
    this.mAVServiceForQQ = null;
  }
  
  public int getFloatViewState()
  {
    return this.mGameRoomFloatView.a();
  }
  
  public boolean getInAIO()
  {
    return this.isInAIO;
  }
  
  public boolean getInAudio()
  {
    return this.isInAudio;
  }
  
  public boolean getInGameGift()
  {
    return this.isInGameGift;
  }
  
  public boolean getInvite()
  {
    return this.isInvite;
  }
  
  public void hideFloatView()
  {
    this.mGameRoomFloatView.a();
  }
  
  public boolean isBinded()
  {
    return this.mAVServiceForQQ != null;
  }
  
  public void onActivityResume()
  {
    restoreSoundState();
  }
  
  public void onPhoneStateChange(int paramInt)
  {
    this.mCurrentPhoneState = paramInt;
    if (isCalling(paramInt))
    {
      setSoundEnableInner(false);
      return;
    }
    restoreSoundState();
  }
  
  public void reset(Context paramContext)
  {
    this.mAVServiceForQQ = null;
    paramContext.stopService(new Intent(paramContext, AVServiceForQQ.class));
  }
  
  public void setInAIO(boolean paramBoolean)
  {
    this.isInAIO = paramBoolean;
  }
  
  public void setInAudio(boolean paramBoolean)
  {
    this.isInAudio = paramBoolean;
  }
  
  public void setInGameGift(boolean paramBoolean)
  {
    this.isInGameGift = paramBoolean;
  }
  
  public void setInvite(boolean paramBoolean)
  {
    this.isInvite = paramBoolean;
  }
  
  public void setSoundEnable(boolean paramBoolean)
  {
    this.mCurrentSoundEnableState = (paramBoolean ^ true);
    if ((paramBoolean) && (isCalling(this.mCurrentPhoneState))) {
      return;
    }
    setSoundEnableInner(paramBoolean);
  }
  
  public void showFloatView(int paramInt1, String paramString1, int paramInt2, long paramLong, String paramString2)
  {
    if ((!this.isInvite) && (!this.isInGameGift)) {
      this.mGameRoomFloatView.a(paramInt1, paramString1, paramInt2, paramLong, paramString2);
    }
  }
  
  public void showFloatView(int paramInt, String paramString1, long paramLong, String paramString2)
  {
    if ((!this.isInvite) && (!this.isInGameGift)) {
      this.mGameRoomFloatView.a(paramInt, paramString1, 10, paramLong, paramString2);
    }
  }
  
  public void startSpeak()
  {
    IAVServiceForQQ localIAVServiceForQQ = this.mAVServiceForQQ;
    if (localIAVServiceForQQ == null) {
      return;
    }
    try
    {
      localIAVServiceForQQ.a();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("startSpeak: ");
        localStringBuilder.append(QLog.getStackTraceString(localRemoteException));
        QLog.d("GameRoomAVController", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void stopSpeak()
  {
    IAVServiceForQQ localIAVServiceForQQ = this.mAVServiceForQQ;
    if (localIAVServiceForQQ == null) {
      return;
    }
    try
    {
      localIAVServiceForQQ.b();
      return;
    }
    catch (RemoteException localRemoteException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopSpeak: ");
        localStringBuilder.append(QLog.getStackTraceString(localRemoteException));
        QLog.d("GameRoomAVController", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void unbindService()
  {
    if (this.mServiceConnectionListener != null)
    {
      BaseApplicationImpl.getApplication().unbindService(this.mServiceConnectionListener);
      this.mServiceConnectionListener = null;
    }
    this.mAVServiceForQQ = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.impl.GameRoomAVControllerDelegateImpl
 * JD-Core Version:    0.7.0.1
 */