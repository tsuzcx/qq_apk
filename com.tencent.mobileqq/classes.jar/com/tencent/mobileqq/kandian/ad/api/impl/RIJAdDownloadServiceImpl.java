package com.tencent.mobileqq.kandian.ad.api.impl;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GamesComponentAdDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.IUIDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.RIJAdDownloadCache;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.DownloadPercent;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.IDownloadEngine;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadLifeEvent;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateQueryUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadClickState;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadStateUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdGameGiftUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdUrlChangeUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJAdDownloadViewBase.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService;
import com.tencent.mobileqq.kandian.ad.api.entity.IADBaseAppDownloadManager;
import org.json.JSONObject;

public class RIJAdDownloadServiceImpl
  implements IRIJAdDownloadService
{
  public void addDownloadCache(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    RIJAdDownloadCache.a.a(paramADVideoAppDownloadData);
  }
  
  public void addReportCache(String paramString, DownloadPercent paramDownloadPercent)
  {
    RIJAdDownloadCache.a.a(paramString, paramDownloadPercent);
  }
  
  public void addViewCache(View paramView)
  {
    RIJAdDownloadCache.a.a((RIJDownloadView)paramView);
  }
  
  public void checkRealState(AdDownloadInfo paramAdDownloadInfo)
  {
    RIJAdDownloadExKt.a(paramAdDownloadInfo);
  }
  
  public void clearDownloadCache()
  {
    RIJAdDownloadCache.a.a();
  }
  
  public int convertToDownloadState(WadlResult paramWadlResult)
  {
    return RIJAdDownloadStateUtil.a.a(paramWadlResult);
  }
  
  public IADBaseAppDownloadManager createADBaseAppDownloadManager(Activity paramActivity)
  {
    return new ADBaseAppDownloadManager(paramActivity);
  }
  
  public ViewBase.IBuilder createAdDownloadViewBaseBuilder()
  {
    return new RIJAdDownloadViewBase.Builder();
  }
  
  public IUIDelegate createGamesComponentAdDelegate(Context paramContext, int paramInt)
  {
    return new GamesComponentAdDelegate(paramContext, paramInt);
  }
  
  public IUIDelegate createGoodsSoftAdAppDelegate(Context paramContext, int paramInt)
  {
    return new GoodsSoftAdAppDelegate(paramContext, paramInt);
  }
  
  public boolean doGameDownload(RIJDownloadView paramRIJDownloadView, AdvertisementInfo paramAdvertisementInfo, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    return RIJAdDownloadUtil.a.a(paramRIJDownloadView, paramAdvertisementInfo, paramADVideoAppDownloadData);
  }
  
  public boolean doNormalAppDownload(RIJDownloadView paramRIJDownloadView, AdvertisementInfo paramAdvertisementInfo, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    return RIJAdDownloadUtil.a.c(paramRIJDownloadView, paramAdvertisementInfo, paramADVideoAppDownloadData);
  }
  
  public boolean doSoftAppDownload(RIJDownloadView paramRIJDownloadView, AdvertisementInfo paramAdvertisementInfo, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    return RIJAdDownloadUtil.a.b(paramRIJDownloadView, paramAdvertisementInfo, paramADVideoAppDownloadData);
  }
  
  public void downloadEventOnAttachedToWindow(RIJDownloadView paramRIJDownloadView)
  {
    AdDownloadLifeEvent.OnAttachedToWindow.onEvent(paramRIJDownloadView);
  }
  
  public void downloadEventOnDetachedFromWindow(RIJDownloadView paramRIJDownloadView)
  {
    AdDownloadLifeEvent.OnDetachedFromWindow.onEvent(paramRIJDownloadView);
  }
  
  public void downloadViewOnPause(Object paramObject)
  {
    ((RIJDownloadView)paramObject).b();
  }
  
  public void downloadViewOnResume(Object paramObject)
  {
    ((RIJDownloadView)paramObject).a();
  }
  
  public ADVideoAppDownloadData getDownloadCache(String paramString)
  {
    return RIJAdDownloadCache.a.a(paramString);
  }
  
  public IDownloadEngine getDownloadEngine(ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    return RIJAdDownloadExKt.a(paramADVideoAppDownloadData);
  }
  
  public boolean hasReportCache(String paramString, DownloadPercent paramDownloadPercent)
  {
    return RIJAdDownloadCache.a.b(paramString, paramDownloadPercent);
  }
  
  public String parseApkDownloadUrl(JSONObject paramJSONObject)
  {
    return RIJAdUrlChangeUtil.a.a(paramJSONObject);
  }
  
  public void queryState(AdvertisementInfo paramAdvertisementInfo, ValueCallback<Integer> paramValueCallback)
  {
    AdDownloadStateQueryUtil.a(paramAdvertisementInfo, paramValueCallback);
  }
  
  public void removeReportCache(String paramString)
  {
    RIJAdDownloadCache.a.b(paramString);
  }
  
  public void reportAdDownloadClick(Context paramContext, DownloadClickState paramDownloadClickState, AdvertisementInfo paramAdvertisementInfo)
  {
    reportAdDownloadClick(paramContext, paramDownloadClickState, paramAdvertisementInfo, "2");
  }
  
  public void reportAdDownloadClick(Context paramContext, DownloadClickState paramDownloadClickState, AdvertisementInfo paramAdvertisementInfo, String paramString)
  {
    RIJAdDownloadReport.a.a(paramContext, paramDownloadClickState, paramAdvertisementInfo, paramString);
  }
  
  public void reportBeacon(String paramString, AdDownloadInfo paramAdDownloadInfo)
  {
    RIJAdDownloadReport.a.a(paramString, paramAdDownloadInfo);
  }
  
  public void reportDownloadFinish(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    reportDownloadFinish(paramContext, paramAdvertisementInfo, "2");
  }
  
  public void reportDownloadFinish(Context paramContext, AdvertisementInfo paramAdvertisementInfo, String paramString)
  {
    RIJAdDownloadReport.a.a(paramContext, paramAdvertisementInfo, paramString);
  }
  
  public void showGiftDialog(AdvertisementInfo paramAdvertisementInfo, Context paramContext, RIJDownloadView paramRIJDownloadView, ADVideoAppDownloadData paramADVideoAppDownloadData)
  {
    RIJAdGameGiftUtil.a.a(paramAdvertisementInfo, paramContext, paramRIJDownloadView, paramADVideoAppDownloadData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdDownloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */