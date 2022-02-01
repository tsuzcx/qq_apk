package com.tencent.mobileqq.qqlive.trtc;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.trtc.audio.ITRTCAudioBaseSource;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCEngineContext;
import com.tencent.mobileqq.qqlive.trtc.engine.TRTCInitCallback;
import com.tencent.mobileqq.qqlive.trtc.render.ILocalRender;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomCtrl;
import com.tencent.mobileqq.qqlive.trtc.video.source.ITRTCVideoBaseSource;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.StatisticDataListener;

public abstract interface ITRTCEngine
{
  public abstract <T extends ITRTCVideoBaseSource> T a(@NonNull Class<T> paramClass);
  
  public abstract void a();
  
  public abstract void a(@NonNull Context paramContext, @NonNull ConfigData paramConfigData, TRTCInitCallback paramTRTCInitCallback);
  
  public abstract void a(ITRTCAudioBaseSource paramITRTCAudioBaseSource);
  
  public abstract void a(@Nullable ITRTCVideoBaseSource paramITRTCVideoBaseSource);
  
  public abstract void a(StatisticDataListener paramStatisticDataListener);
  
  public abstract int b();
  
  public abstract <T extends ITRTCAudioBaseSource> T b(@NonNull Class<T> paramClass);
  
  public abstract <T extends ITRTCAudioBaseSource> T c(@NonNull Class<T> paramClass);
  
  public abstract TRTCEngineContext c();
  
  public abstract ILocalRender d();
  
  public abstract <T extends ITRTCVideoBaseSource> T d(@NonNull Class<T> paramClass);
  
  public abstract ITRTCRoomCtrl e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.trtc.ITRTCEngine
 * JD-Core Version:    0.7.0.1
 */