package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.Map;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IHuayangDowanloadHelper
  extends QRouteApi
{
  public abstract void canceLauncher();
  
  public abstract void downloadPlugin(String paramString1, String paramString2, String paramString3, String paramString4, Map<String, IVPluginInfo> paramMap);
  
  public abstract IHuayangDowanloadHelper init(Context paramContext, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.IHuayangDowanloadHelper
 * JD-Core Version:    0.7.0.1
 */