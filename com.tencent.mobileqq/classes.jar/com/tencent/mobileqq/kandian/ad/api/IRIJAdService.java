package com.tencent.mobileqq.kandian.ad.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoAppDownloadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IADVideoFeedsGuideManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IAdSmallGameReportManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IHomeWatcher;
import com.tencent.mobileqq.kandian.ad.api.entity.INegativeHelper;
import com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdPopSheetDialog;
import com.tencent.mobileqq.kandian.ad.api.entity.IRIJAdvertisementInfoModule;
import com.tencent.mobileqq.kandian.ad.api.entity.IRecommendADVideoFeedsManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdExposureManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdStrategyReportManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdTimeLoadManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoAdVVAdloadStrategyManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsGameAdComManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsHardAdBarManager;
import com.tencent.mobileqq.kandian.ad.api.entity.IVideoFeedsSoftAdBarController;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.Map;

@QAPI(process={"all"})
public abstract interface IRIJAdService
  extends QRouteApi
{
  public abstract boolean checkSuperMaskVideoAdState();
  
  public abstract void clickAdUgcSocialOperationReport(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean);
  
  public abstract IADVideoAppDownloadManager createADVideoAppDownloadManager(Context paramContext, boolean paramBoolean);
  
  public abstract IADVideoFeedsGuideManager createADVideoFeedsGuideManager(Context paramContext);
  
  public abstract Object createADVideoItemDelegate(Object paramObject1, Object paramObject2, Object paramObject3);
  
  public abstract BaseVideoItemHolder createADVideoItemHolder(View paramView, int paramInt);
  
  public abstract SimpleConfigHandler createAdConfigHandler();
  
  public abstract Object createAdHandler();
  
  public abstract IAdSmallGameReportManager createAdSmallGameReportManager();
  
  public abstract IRIJAdvertisementInfoModule createAdvertisementInfoModule();
  
  public abstract IExposureSupplementManager createExposureSupplementManager(int paramInt);
  
  public abstract Object createHippyCustomViewCreator();
  
  public abstract IHomeWatcher createHomeWatcher(Context paramContext);
  
  public abstract INegativeHelper createNegativeHelper(Activity paramActivity, IAdapter paramIAdapter);
  
  public abstract ViewBase.IBuilder createReadInJoyAdInnerOperateViewBuilder();
  
  public abstract IRIJAdPopSheetDialog createReadInJoyAdPopSheetDialog(Activity paramActivity, String paramString1, String paramString2, String paramString3);
  
  public abstract ReadInJoyDisLikeDialogView createReadInJoyDisLikeDialogViewForAd(Context paramContext);
  
  public abstract IRecommendADVideoFeedsManager createRecommendADVideoFeedsManager(Activity paramActivity, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, IVideoPlayManager paramIVideoPlayManager, Object paramObject, int paramInt);
  
  public abstract Object createSuperMaskPopupStep(Object paramObject, Activity paramActivity);
  
  public abstract Object createTKDAdModule();
  
  public abstract Object createTkdAdHippyEngine(Object paramObject, String paramString1, String paramString2);
  
  public abstract IVideoAdExposureManager createVideoAdExposureManager(IVideoFeedsAdapter paramIVideoFeedsAdapter, Object paramObject1, Object paramObject2, Handler paramHandler);
  
  public abstract IVideoAdStrategyReportManager createVideoAdStrategyReportManager();
  
  public abstract IVideoAdTimeLoadManager createVideoAdTimeLoadManager(IVideoFeedsAdapter paramIVideoFeedsAdapter, Object paramObject);
  
  public abstract IVideoAdVVAdloadStrategyManager createVideoAdVVAdloadStrategyManager(IVideoFeedsAdapter paramIVideoFeedsAdapter, Object paramObject, IVideoAdTimeLoadManager paramIVideoAdTimeLoadManager);
  
  public abstract IVideoFeedsGameAdComManager createVideoFeedsGameAdComManager(Object paramObject, Activity paramActivity, View paramView);
  
  public abstract IVideoFeedsHardAdBarManager createVideoFeedsHardAdBarManager(Context paramContext, boolean paramBoolean, Activity paramActivity, Object paramObject);
  
  public abstract IVideoFeedsSoftAdBarController createVideoFeedsSoftAdBarController(Object paramObject, Activity paramActivity, View paramView);
  
  public abstract SimpleConfigHandler createVideoSoftAdConfigHandler();
  
  public abstract Object createWebViewPlugin();
  
  public abstract Object getAdCache(int paramInt);
  
  public abstract Class getAdMaterialResManagerClz();
  
  public abstract Context getContext();
  
  public abstract void getMotiveAd(Activity paramActivity, String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject);
  
  public abstract Object getMotiveAdInfo(Object paramObject);
  
  public abstract Class getNativeAdPreloadManagerClz();
  
  public abstract Map<String, ViewBase.IBuilder> getProteusBuilders();
  
  public abstract Map<Integer, Object> getProteusItems();
  
  public abstract Class getRIJADExposureManagerClz();
  
  public abstract Class getReadInJoyNativeAdFragment();
  
  public abstract boolean initDebugInfo(boolean paramBoolean, long paramLong);
  
  public abstract boolean instanceOfAdvertisementInfo(Object paramObject);
  
  public abstract void jumpToPkPage(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean needReportNew();
  
  public abstract boolean needReportSoftNew();
  
  public abstract void preRequestPatchAd();
  
  public abstract void queryDownloadState(AdvertisementInfo paramAdvertisementInfo, ValueCallback<Integer> paramValueCallback);
  
  public abstract void report(ReportAction paramReportAction, Integer paramInteger, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void report(AdReportData paramAdReportData);
  
  public abstract void reportReadinjoyADEvent(Object paramObject, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract void showMotiveAd(Activity paramActivity, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3);
  
  public abstract void startNativeAdVideoFragment(Activity paramActivity, Bundle paramBundle);
  
  public abstract void startReadInJoyNativeAdAppFragment(Activity paramActivity, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdService
 * JD-Core Version:    0.7.0.1
 */