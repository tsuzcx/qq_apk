package com.tencent.mobileqq.nearby.gameroom;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGameRoomAVControllerDelegate
  extends QRouteApi
{
  public abstract void bindService(OnBindCallback paramOnBindCallback);
  
  public abstract void enterRoom(long paramLong, String paramString);
  
  public abstract void exitRoom();
  
  public abstract void exitRoom(long paramLong);
  
  public abstract int getFloatViewState();
  
  public abstract boolean getInAIO();
  
  public abstract boolean getInAudio();
  
  public abstract boolean getInGameGift();
  
  public abstract boolean getInvite();
  
  public abstract void hideFloatView();
  
  public abstract boolean isBinded();
  
  public abstract void onActivityResume();
  
  public abstract void onPhoneStateChange(int paramInt);
  
  public abstract void reset(Context paramContext);
  
  public abstract void setInAIO(boolean paramBoolean);
  
  public abstract void setInAudio(boolean paramBoolean);
  
  public abstract void setInGameGift(boolean paramBoolean);
  
  public abstract void setInvite(boolean paramBoolean);
  
  public abstract void setSoundEnable(boolean paramBoolean);
  
  public abstract void showFloatView(int paramInt1, String paramString1, int paramInt2, long paramLong, String paramString2);
  
  public abstract void showFloatView(int paramInt, String paramString1, long paramLong, String paramString2);
  
  public abstract void startSpeak();
  
  public abstract void stopSpeak();
  
  public abstract void unbindService();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate
 * JD-Core Version:    0.7.0.1
 */