package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IHuayangPluginLauncher
  extends QRouteApi
{
  public static final String TAG = "IHuayangPluginLauncher";
  
  public abstract void addLauncherListener(IHuayangPluginLauncher.HuayangPluginLauncherListener paramHuayangPluginLauncherListener);
  
  public abstract IHuayangPluginLauncher getInstance(Context paramContext, Object paramObject);
  
  public abstract boolean isStartPluginCalled();
  
  public abstract void launchPlugin(String paramString1, boolean paramBoolean1, boolean paramBoolean2, IVPluginInfo paramIVPluginInfo, String paramString2, String paramString3);
  
  public abstract void removeLauncherListener(IHuayangPluginLauncher.HuayangPluginLauncherListener paramHuayangPluginLauncherListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.IHuayangPluginLauncher
 * JD-Core Version:    0.7.0.1
 */