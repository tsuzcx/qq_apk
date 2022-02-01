package com.tencent.mobileqq.kandian.ad.api;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.IUIDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.AdDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.data.DownloadPercent;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.engine.IDownloadEngine;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadClickState;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.kandian.ad.api.entity.IADBaseAppDownloadManager;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import org.json.JSONObject;

@QAPI(process={"all"})
public abstract interface IRIJAdDownloadService
  extends QRouteApi
{
  public abstract void addDownloadCache(ADVideoAppDownloadData paramADVideoAppDownloadData);
  
  public abstract void addReportCache(String paramString, DownloadPercent paramDownloadPercent);
  
  public abstract void addViewCache(View paramView);
  
  public abstract void checkRealState(AdDownloadInfo paramAdDownloadInfo);
  
  public abstract void clearDownloadCache();
  
  public abstract int convertToDownloadState(WadlResult paramWadlResult);
  
  public abstract IADBaseAppDownloadManager createADBaseAppDownloadManager(Activity paramActivity);
  
  public abstract ViewBase.IBuilder createAdDownloadViewBaseBuilder();
  
  public abstract IUIDelegate createGamesComponentAdDelegate(Context paramContext, int paramInt);
  
  public abstract IUIDelegate createGoodsSoftAdAppDelegate(Context paramContext, int paramInt);
  
  public abstract boolean doGameDownload(RIJDownloadView paramRIJDownloadView, AdvertisementInfo paramAdvertisementInfo, ADVideoAppDownloadData paramADVideoAppDownloadData);
  
  public abstract boolean doNormalAppDownload(RIJDownloadView paramRIJDownloadView, AdvertisementInfo paramAdvertisementInfo, ADVideoAppDownloadData paramADVideoAppDownloadData);
  
  public abstract boolean doSoftAppDownload(RIJDownloadView paramRIJDownloadView, AdvertisementInfo paramAdvertisementInfo, ADVideoAppDownloadData paramADVideoAppDownloadData);
  
  public abstract void downloadEventOnAttachedToWindow(RIJDownloadView paramRIJDownloadView);
  
  public abstract void downloadEventOnDetachedFromWindow(RIJDownloadView paramRIJDownloadView);
  
  public abstract void downloadViewOnPause(Object paramObject);
  
  public abstract void downloadViewOnResume(Object paramObject);
  
  public abstract ADVideoAppDownloadData getDownloadCache(String paramString);
  
  public abstract IDownloadEngine getDownloadEngine(ADVideoAppDownloadData paramADVideoAppDownloadData);
  
  public abstract boolean hasReportCache(String paramString, DownloadPercent paramDownloadPercent);
  
  public abstract String parseApkDownloadUrl(JSONObject paramJSONObject);
  
  public abstract void queryState(AdvertisementInfo paramAdvertisementInfo, ValueCallback<Integer> paramValueCallback);
  
  public abstract void removeReportCache(String paramString);
  
  public abstract void reportAdDownloadClick(Context paramContext, DownloadClickState paramDownloadClickState, AdvertisementInfo paramAdvertisementInfo);
  
  public abstract void reportAdDownloadClick(Context paramContext, DownloadClickState paramDownloadClickState, AdvertisementInfo paramAdvertisementInfo, String paramString);
  
  public abstract void reportBeacon(String paramString, AdDownloadInfo paramAdDownloadInfo);
  
  public abstract void reportDownloadFinish(Context paramContext, AdvertisementInfo paramAdvertisementInfo);
  
  public abstract void reportDownloadFinish(Context paramContext, AdvertisementInfo paramAdvertisementInfo, String paramString);
  
  public abstract void showGiftDialog(AdvertisementInfo paramAdvertisementInfo, Context paramContext, RIJDownloadView paramRIJDownloadView, ADVideoAppDownloadData paramADVideoAppDownloadData);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdDownloadService
 * JD-Core Version:    0.7.0.1
 */