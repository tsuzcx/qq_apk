package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.io.File;
import java.util.Map;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IHuayangPluginNewDownloader
  extends QRouteApi
{
  public static final String TAG = "IHuayangPluginNewDownloader";
  
  public abstract void cancelDownload();
  
  public abstract void cancelLauncher();
  
  public abstract void download(String paramString1, String paramString2, String paramString3, Map<String, IVPluginInfo> paramMap);
  
  public abstract String getUin();
  
  public abstract IHuayangPluginNewDownloader init(Context paramContext, File paramFile, String paramString);
  
  public abstract void setDonwanlodPreloadListener(IHuayangPluginNewDownloader.HuayangPluginLoadStatusListener paramHuayangPluginLoadStatusListener);
  
  public abstract void setRunning(boolean paramBoolean);
  
  public abstract void setUin(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader
 * JD-Core Version:    0.7.0.1
 */