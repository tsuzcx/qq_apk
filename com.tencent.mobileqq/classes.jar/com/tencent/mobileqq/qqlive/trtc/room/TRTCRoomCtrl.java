package com.tencent.mobileqq.qqlive.trtc.room;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveRoomParams;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCEngineContext;
import com.tencent.mobileqq.qqlive.trtc.utils.TRTCConvertHelper;
import com.tencent.mobileqq.qqlive.trtc.utils.TRTCThreadHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trtc.TRTCCloud;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import com.tencent.trtc.TRTCCloudDef.TRTCSwitchRoomConfig;

public class TRTCRoomCtrl
  implements ITRTCRoomCtrl, ITRTCRoomListener
{
  private TRTCCloud a;
  private Handler b;
  private ITRTCRoomListener c;
  private ConfigData d;
  
  public TRTCRoomCtrl(TRTCEngineContext paramTRTCEngineContext)
  {
    this.a = paramTRTCEngineContext.a;
    this.d = paramTRTCEngineContext.c;
  }
  
  public void a()
  {
    if (this.c == null) {
      return;
    }
    TRTCThreadHelper.a(this.b, new TRTCRoomCtrl.7(this));
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onExitRoom ");
      localStringBuilder.append(paramInt);
      QLog.i("TRTCRoomCtrl", 2, localStringBuilder.toString());
    }
    if (this.c == null) {
      return;
    }
    TRTCThreadHelper.a(this.b, new TRTCRoomCtrl.2(this, paramInt));
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    if (this.c == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEvent, event ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", code: ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", msg: ");
      localStringBuilder.append(paramString);
      QLog.i("TRTCRoomCtrl", 2, localStringBuilder.toString());
    }
    TRTCThreadHelper.a(this.b, new TRTCRoomCtrl.8(this, paramInt1, paramInt2, paramString, paramBundle));
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.c == null) {
      return;
    }
    TRTCThreadHelper.a(this.b, new TRTCRoomCtrl.3(this, paramInt, paramString));
  }
  
  public void a(long paramLong, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onEnterRoom ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(", msg: ");
      localStringBuilder.append(paramString);
      QLog.i("TRTCRoomCtrl", 2, localStringBuilder.toString());
    }
    if (this.c == null) {
      return;
    }
    TRTCThreadHelper.a(this.b, new TRTCRoomCtrl.1(this, paramLong, paramString));
  }
  
  public void a(@NonNull Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  public void a(QQLiveRoomParams paramQQLiveRoomParams)
  {
    TRTCCloudDef.TRTCParams localTRTCParams;
    if ((paramQQLiveRoomParams != null) && (this.a != null)) {
      localTRTCParams = TRTCConvertHelper.a(paramQQLiveRoomParams);
    }
    try
    {
      int i = Integer.parseInt(this.d.getTrtcSDKAppId());
      localTRTCParams.sdkAppId = i;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("enterRoom userId:");
        localStringBuilder.append(localTRTCParams.userId);
        localStringBuilder.append(" role:");
        localStringBuilder.append(localTRTCParams.role);
        localStringBuilder.append(" roomId:");
        localStringBuilder.append(localTRTCParams.roomId);
        localStringBuilder.append(" scene:");
        localStringBuilder.append(paramQQLiveRoomParams.getScene());
        localStringBuilder.append(" sig:");
        localStringBuilder.append(localTRTCParams.userSig);
        QLog.i("TRTCRoomCtrl", 2, localStringBuilder.toString());
      }
      if (this.b == null) {
        this.b = new Handler(Looper.getMainLooper());
      }
      this.a.enterRoom(localTRTCParams, TRTCConvertHelper.c(paramQQLiveRoomParams.getScene()));
      return;
    }
    catch (Exception paramQQLiveRoomParams)
    {
      label185:
      break label185;
    }
    QLog.e("TRTCRoomCtrl", 1, "enterRoom error!, app id is not init!");
    throw new IllegalArgumentException("appId is not int!");
    throw new IllegalArgumentException("param or trtcCloud == null");
  }
  
  public void a(@Nullable ITRTCRoomListener paramITRTCRoomListener)
  {
    this.c = paramITRTCRoomListener;
  }
  
  public void a(String paramString)
  {
    if (this.c == null) {
      return;
    }
    TRTCThreadHelper.a(this.b, new TRTCRoomCtrl.4(this, paramString));
  }
  
  public void a(String paramString, int paramInt)
  {
    if (this.c == null) {
      return;
    }
    TRTCThreadHelper.a(this.b, new TRTCRoomCtrl.5(this, paramString, paramInt));
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TRTCRoomCtrl", 2, "exitRoom!");
    }
    TRTCCloud localTRTCCloud = this.a;
    if (localTRTCCloud != null) {
      localTRTCCloud.exitRoom();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.c == null) {
      return;
    }
    TRTCThreadHelper.a(this.b, new TRTCRoomCtrl.6(this, paramInt));
  }
  
  public void b(QQLiveRoomParams paramQQLiveRoomParams)
  {
    if (paramQQLiveRoomParams != null)
    {
      paramQQLiveRoomParams = TRTCConvertHelper.b(paramQQLiveRoomParams);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("switchRoom roomId:");
        ((StringBuilder)localObject).append(paramQQLiveRoomParams.roomId);
        ((StringBuilder)localObject).append(" userSig:");
        ((StringBuilder)localObject).append(paramQQLiveRoomParams.userSig);
        QLog.i("TRTCRoomCtrl", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.a;
      if (localObject != null)
      {
        ((TRTCCloud)localObject).switchRoom(paramQQLiveRoomParams);
        return;
      }
      QLog.e("TRTCRoomCtrl", 1, "switchRoom. trtcCloud == null");
      return;
    }
    QLog.e("TRTCRoomCtrl", 1, "switchRoom, param == null. ");
    throw new IllegalArgumentException("param == null");
  }
  
  public void c()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.room.TRTCRoomCtrl
 * JD-Core Version:    0.7.0.1
 */