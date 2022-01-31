package com.tencent.wifisdk;

import android.support.annotation.NonNull;
import java.util.List;
import wf7.bn;

public abstract interface TMSDKWifiListUpdateListener
{
  public abstract void onScanResult(@NonNull List<bn> paramList);
  
  public abstract void onUpdateFinish(int paramInt, List<TMSDKFreeWifiInfo> paramList);
  
  public abstract void onUpdateStart();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.wifisdk.TMSDKWifiListUpdateListener
 * JD-Core Version:    0.7.0.1
 */