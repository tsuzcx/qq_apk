package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.biz.pubaccount.NativeAd.preload.NativeAdPreloadManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.ad.api.INativeAdPreloadService;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public class NativeAdPreloadServiceImpl
  implements INativeAdPreloadService
{
  private NativeAdPreloadManager preloadManager;
  
  public void addImageToPreload(String paramString)
  {
    this.preloadManager.a(paramString);
  }
  
  public void addImagesToPreload(ArrayList<String> paramArrayList)
  {
    this.preloadManager.a(paramArrayList);
  }
  
  public void clearPreloadList()
  {
    this.preloadManager.a();
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.preloadManager = ((NativeAdPreloadManager)paramAppRuntime.getManager(QQManagerFactory.KANDIAN_NATIVE_AD_PRELOAD_MANAGER));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.NativeAdPreloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */