package com.tencent.timi.game.trtc.roomservice.multipevoiceroom;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import com.tencent.timi.game.utils.Logger;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCVolumeInfo;
import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class TRTCMultipeVoiceRoom$3
  extends TRTCCloudListener
{
  TRTCMultipeVoiceRoom$3(TRTCMultipeVoiceRoom paramTRTCMultipeVoiceRoom, TRTCCloud paramTRTCCloud, String paramString) {}
  
  public void onConnectionLost()
  {
    super.onConnectionLost();
    TRTCMultipeVoiceRoom.a(this.c, 1);
  }
  
  public void onConnectionRecovery()
  {
    super.onConnectionRecovery();
    TRTCMultipeVoiceRoom.a(this.c, 0);
  }
  
  public void onEnterRoom(long paramLong)
  {
    super.onEnterRoom(paramLong);
    TRTCMultipeVoiceRoom.a(this.c, 0);
  }
  
  public void onError(int paramInt, String paramString, Bundle paramBundle)
  {
    super.onError(paramInt, paramString, paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append("TRTCListenerOnError roomID:");
    paramBundle.append(this.b);
    paramBundle.append(" errCode:");
    paramBundle.append(paramInt);
    paramBundle.append(" msg:");
    paramBundle.append(paramString);
    Logger.c("TRTCMultipeVoiceRoom", paramBundle.toString());
  }
  
  public void onExitRoom(int paramInt)
  {
    super.onExitRoom(paramInt);
    TRTCMultipeVoiceRoom.a(this.c, 4);
  }
  
  public void onRemoteUserEnterRoom(String paramString)
  {
    super.onRemoteUserEnterRoom(paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onRemoteUserEnterRoom uid: ");
    localStringBuilder.append(paramString);
    Logger.b("TRTCMultipeVoiceRoom", localStringBuilder.toString());
  }
  
  public void onRemoteUserLeaveRoom(String paramString, int paramInt)
  {
    super.onRemoteUserLeaveRoom(paramString, paramInt);
  }
  
  public void onScreenCapturePaused()
  {
    super.onScreenCapturePaused();
  }
  
  public void onScreenCaptureResumed()
  {
    super.onScreenCaptureResumed();
  }
  
  public void onScreenCaptureStarted()
  {
    super.onScreenCaptureStarted();
  }
  
  public void onScreenCaptureStopped(int paramInt)
  {
    super.onScreenCaptureStopped(paramInt);
  }
  
  public void onSendFirstLocalVideoFrame(int paramInt)
  {
    super.onSendFirstLocalVideoFrame(paramInt);
  }
  
  public void onStartPublishing(int paramInt, String paramString)
  {
    super.onStartPublishing(paramInt, paramString);
  }
  
  public void onTryToReconnect()
  {
    super.onTryToReconnect();
    TRTCMultipeVoiceRoom.a(this.c, 2);
  }
  
  public void onUserSubStreamAvailable(String paramString, boolean paramBoolean)
  {
    super.onUserSubStreamAvailable(paramString, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUserSubStreamAvailable uid: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramBoolean);
    Logger.b("TRTCMultipeVoiceRoom", localStringBuilder.toString());
  }
  
  public void onUserVideoAvailable(String paramString, boolean paramBoolean)
  {
    super.onUserVideoAvailable(paramString, paramBoolean);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUserVideoAvailable uid: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramBoolean);
    Logger.b("TRTCMultipeVoiceRoom", localStringBuilder.toString());
    if (paramBoolean) {
      TRTCMultipeVoiceRoomManager.a().a(this.b, paramString);
    }
  }
  
  public void onUserVoiceVolume(ArrayList<TRTCCloudDef.TRTCVolumeInfo> paramArrayList, int paramInt)
  {
    super.onUserVoiceVolume(paramArrayList, paramInt);
    TRTCMultipeVoiceRoom.b(this.c).clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      TRTCCloudDef.TRTCVolumeInfo localTRTCVolumeInfo = (TRTCCloudDef.TRTCVolumeInfo)paramArrayList.next();
      TRTCMultipeVoiceRoom.b(this.c).put(localTRTCVolumeInfo.userId, Integer.valueOf(localTRTCVolumeInfo.volume));
      this.a.setRemoteAudioVolume(localTRTCVolumeInfo.userId, TRTCMultipeVoiceRoom.c(this.c));
    }
    TRTCMultipeVoiceRoom.d(this.c).put(this.b, TRTCMultipeVoiceRoom.b(this.c));
    if (this.c.a.hasObservers()) {
      this.c.a.setValue(TRTCMultipeVoiceRoom.d(this.c));
    }
    if (TRTCMultipeVoiceRoom.e(this.c).hasObservers()) {
      TRTCMultipeVoiceRoom.e(this.c).setValue(TRTCMultipeVoiceRoom.b(this.c));
    }
  }
  
  public void onWarning(int paramInt, String paramString, Bundle paramBundle)
  {
    super.onWarning(paramInt, paramString, paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append("TRTCListenerOnError roomID:");
    paramBundle.append(this.b);
    paramBundle.append(" errCode:");
    paramBundle.append(paramInt);
    paramBundle.append(" msg:");
    paramBundle.append(paramString);
    Logger.d("TRTCMultipeVoiceRoom", paramBundle.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.roomservice.multipevoiceroom.TRTCMultipeVoiceRoom.3
 * JD-Core Version:    0.7.0.1
 */