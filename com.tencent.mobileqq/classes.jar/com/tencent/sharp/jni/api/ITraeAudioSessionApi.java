package com.tencent.sharp.jni.api;

import android.net.Uri;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.sharp.jni.callback.ITraeAudioCallback;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface ITraeAudioSessionApi
  extends QRouteApi
{
  public abstract int connectDevice(long paramLong, String paramString);
  
  public abstract int connectHighestPriorityDevice();
  
  public abstract int getConnectedDevice(long paramLong);
  
  public abstract int getDeviceList();
  
  public abstract int getStreamType();
  
  public abstract void init(ITraeAudioCallback paramITraeAudioCallback);
  
  public abstract void release();
  
  public abstract int startRing(long paramLong, int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean1, int paramInt3, String paramString2, boolean paramBoolean2);
  
  public abstract int startService(long paramLong, String paramString1, String paramString2);
  
  public abstract int stopRing(long paramLong);
  
  public abstract int stopService();
  
  public abstract int voiceCallAudioParamChanged(int paramInt);
  
  public abstract int voiceCallPostProcess();
  
  public abstract int voiceCallPreProcess(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sharp.jni.api.ITraeAudioSessionApi
 * JD-Core Version:    0.7.0.1
 */