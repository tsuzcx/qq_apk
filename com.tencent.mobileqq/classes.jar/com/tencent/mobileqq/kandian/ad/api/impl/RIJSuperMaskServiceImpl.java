package com.tencent.mobileqq.kandian.ad.api.impl;

import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialHandler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskDataMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.ad.api.ISuperMaskResPreloadService;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.widget.ListView;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

public class RIJSuperMaskServiceImpl
  implements IRIJSuperMaskService
{
  public void checkAdMaterialRefresh(Object paramObject)
  {
    AdMaterialResManager.a((QQAppInterface)paramObject);
  }
  
  public void close()
  {
    SuperMaskUIMgr.a.d();
  }
  
  public MaterialData findDataById(Object paramObject, String paramString)
  {
    return AdMaterialResManager.a((QQAppInterface)paramObject).a(paramString);
  }
  
  public Object getAdData()
  {
    return SuperMaskDataMgr.a.a();
  }
  
  public String getAdMaterialHandlerClassName()
  {
    return AdMaterialHandler.class.getName();
  }
  
  public ConcurrentHashMap<String, MaterialData> getAllDBData(Object paramObject)
  {
    return AdMaterialResManager.a((QQAppInterface)paramObject).a();
  }
  
  public int getChannelID()
  {
    return SuperMaskUIMgr.a.b();
  }
  
  public boolean getHasVolume()
  {
    return SuperMaskUIMgr.a.a();
  }
  
  public int getMaxReqCount()
  {
    return AdMaterialResManager.b();
  }
  
  public int getShowStatus()
  {
    return SuperMaskUIMgr.a.a();
  }
  
  public void initAdMaterialManager(Object paramObject)
  {
    ((ISuperMaskResPreloadService)((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getRuntimeService(ISuperMaskResPreloadService.class)).init();
  }
  
  public void initRes(Object paramObject)
  {
    ((ISuperMaskResPreloadService)((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getRuntimeService(ISuperMaskResPreloadService.class)).init();
  }
  
  public void isChannelRefreshing(int paramInt, boolean paramBoolean)
  {
    ReadInJoySuperMaskAdUtil.a().a(paramInt, paramBoolean);
  }
  
  public boolean isNormalMask()
  {
    return SuperMaskDataMgr.a.a();
  }
  
  public String obtainResPath(String paramString1, String paramString2, int paramInt)
  {
    return AdMaterialResManager.a(paramString1, paramString2, paramInt);
  }
  
  public void onPause()
  {
    SuperMaskUIMgr.a.c();
  }
  
  public void onResDownloadDone(Object paramObject, DownloadTask paramDownloadTask, MaterialData paramMaterialData, File paramFile)
  {
    ((ISuperMaskResPreloadService)((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getRuntimeService(ISuperMaskResPreloadService.class)).onResDownloadDone(paramDownloadTask, paramMaterialData, paramFile);
  }
  
  public void onResDownloadStart(Object paramObject, MaterialData paramMaterialData)
  {
    ((ISuperMaskResPreloadService)((QQAppInterface)((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime()).getRuntimeService(ISuperMaskResPreloadService.class)).onResDownloadStart(paramMaterialData);
  }
  
  public void onResume()
  {
    SuperMaskUIMgr.a.b();
  }
  
  public void receiveAd(Object paramObject)
  {
    SuperMaskDataMgr.a.a(paramObject);
  }
  
  public void refreshDailyReqAndRefreshNum()
  {
    SuperMaskConfigMgr.a.b();
  }
  
  public void refreshMainFeedsReqAndRefreshNum()
  {
    SuperMaskConfigMgr.a.a();
  }
  
  public void resetUIMgr()
  {
    SuperMaskUIMgr.a.e();
  }
  
  public void setChannelID(int paramInt)
  {
    SuperMaskUIMgr.a.b(paramInt);
  }
  
  public void setHasVolume(boolean paramBoolean)
  {
    SuperMaskUIMgr.a.a(paramBoolean);
  }
  
  public void setListView(SoftReference<ListView> paramSoftReference)
  {
    SuperMaskUIMgr.a.b(paramSoftReference);
  }
  
  public void setShowStatus(int paramInt)
  {
    SuperMaskUIMgr.a.a(paramInt);
  }
  
  public void setShowing(boolean paramBoolean)
  {
    SuperMaskUIMgr.a.b(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJSuperMaskServiceImpl
 * JD-Core Version:    0.7.0.1
 */