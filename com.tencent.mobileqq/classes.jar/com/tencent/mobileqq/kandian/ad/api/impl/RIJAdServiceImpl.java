package com.tencent.mobileqq.kandian.ad.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.webkit.ValueCallback;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.biz.pubaccount.NativeAd.fragment.NativeAdVideoFragment;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdAppFragment;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment;
import com.tencent.biz.pubaccount.NativeAd.preload.NativeAdPreloadManager;
import com.tencent.biz.pubaccount.NativeAd.report.AdReportManager;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.util.RIJAdReportManager;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJADSuperMaskPopupStep;
import com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.RecommendADVideoFeedsManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarController;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemDelegate;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDisLikeDialogViewForAd;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.AdDownloadStateQueryUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJAdDownloadViewBase.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdPKFragment;
import com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdConfigHandler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.AdHandler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.handlers.VideoSoftAdConfigHandler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdHippyEngine;
import com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdHippyViewCreator;
import com.tencent.biz.pubaccount.readinjoyAd.ad.hippy.TkdAdModuleImpl;
import com.tencent.biz.pubaccount.readinjoyAd.ad.home_watcher.ReadInJoyAdHomeWatcher;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.ReadInjoyADExposureManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialResManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.multiVideo.NegativeHelper;
import com.tencent.biz.pubaccount.readinjoyAd.ad.plugin.RIJAdWebViewPlugin;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdBigImageProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdBigVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdBrandOptimizationProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdExpandCardProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdLiveExpandCardProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdPKImageProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameHorizListProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameListProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameNewStyleProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameTripleImgProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdQQMiniGameVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdShakeVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdSmallImageProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdSmallVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdSurpriseVideoProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.proteus.AdTripleProteusItem;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskDataMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdSmallGameReportManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ExposureSupplementManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.InteraActionReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyMotiveAdModule;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadinjoyAdCache;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoFeedsGuideManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdExposureManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdStrategyReportManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdTimeLoadManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.strategy.VideoAdVVAdloadStrategyManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBrandOptimizationView.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBubbleView.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdCommonBlurImageView.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdExpandCardPic.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdInnerOperateView.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdPopSheetDialog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdVpngVideo.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyBlurImageView.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyIconText.Builder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyDoubleImageView.Builder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdService;
import com.tencent.mobileqq.kandian.ad.api.IRIJPatchAdUtilService;
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
import com.tencent.mobileqq.kandian.base.automator.RIJPopupAutomator;
import com.tencent.mobileqq.kandian.biz.ad.entity.IExposureSupplementManager;
import com.tencent.mobileqq.kandian.biz.common.baseui.IReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyXListView;
import com.tencent.mobileqq.kandian.biz.dislike.ReadInJoyDisLikeDialogView;
import com.tencent.mobileqq.kandian.biz.video.feeds.api.IVideoPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsAdapter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsRecommendPresenter;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.view.VideoFeedsRecyclerView;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseVideoItemHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RIJAdServiceImpl
  implements IRIJAdService
{
  public boolean checkSuperMaskVideoAdState()
  {
    boolean bool2 = SuperMaskDataMgr.a.d();
    boolean bool1 = true;
    if (!bool2)
    {
      if (SuperMaskUIMgr.a.a() == 1) {
        return bool1;
      }
      if (SuperMaskUIMgr.a.a() == 2) {
        return true;
      }
    }
    bool1 = false;
    return bool1;
  }
  
  public void clickAdUgcSocialOperationReport(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo, boolean paramBoolean)
  {
    InteraActionReportUtils.a(paramViewBase, paramAbsBaseArticleInfo, paramBoolean);
  }
  
  public IADVideoAppDownloadManager createADVideoAppDownloadManager(Context paramContext, boolean paramBoolean)
  {
    return new ADVideoAppDownloadManager(paramContext, paramBoolean);
  }
  
  public IADVideoFeedsGuideManager createADVideoFeedsGuideManager(Context paramContext)
  {
    return new ADVideoFeedsGuideManager(paramContext);
  }
  
  public Object createADVideoItemDelegate(Object paramObject1, Object paramObject2, Object paramObject3)
  {
    return new ADVideoItemDelegate((ADVideoItemHolder)paramObject1, (IVideoFeedsRecommendPresenter)paramObject2, (IVideoFeedsAdapter)paramObject3);
  }
  
  public BaseVideoItemHolder createADVideoItemHolder(View paramView, int paramInt)
  {
    return new ADVideoItemHolder(paramView, paramInt);
  }
  
  public SimpleConfigHandler createAdConfigHandler()
  {
    return new AdConfigHandler();
  }
  
  public Object createAdHandler()
  {
    return new AdHandler();
  }
  
  public IAdSmallGameReportManager createAdSmallGameReportManager()
  {
    return new AdSmallGameReportManager();
  }
  
  public IRIJAdvertisementInfoModule createAdvertisementInfoModule()
  {
    return new AdvertisementInfoModule();
  }
  
  public IExposureSupplementManager createExposureSupplementManager(int paramInt)
  {
    return new ExposureSupplementManager(paramInt);
  }
  
  public Object createHippyCustomViewCreator()
  {
    return new TkdAdHippyViewCreator();
  }
  
  public IHomeWatcher createHomeWatcher(Context paramContext)
  {
    return new ReadInJoyAdHomeWatcher(paramContext);
  }
  
  public INegativeHelper createNegativeHelper(Activity paramActivity, IAdapter paramIAdapter)
  {
    return new NegativeHelper(paramActivity, paramIAdapter);
  }
  
  public ViewBase.IBuilder createReadInJoyAdInnerOperateViewBuilder()
  {
    return new ReadInJoyAdInnerOperateView.Builder();
  }
  
  public IRIJAdPopSheetDialog createReadInJoyAdPopSheetDialog(Activity paramActivity, String paramString1, String paramString2, String paramString3)
  {
    return ReadInJoyAdPopSheetDialog.a(paramActivity, paramString1, paramString2, paramString3);
  }
  
  public ReadInJoyDisLikeDialogView createReadInJoyDisLikeDialogViewForAd(Context paramContext)
  {
    return new ReadInJoyDisLikeDialogViewForAd(paramContext);
  }
  
  public IRecommendADVideoFeedsManager createRecommendADVideoFeedsManager(Activity paramActivity, IReadInJoyBaseAdapter paramIReadInJoyBaseAdapter, IVideoPlayManager paramIVideoPlayManager, Object paramObject, int paramInt)
  {
    return new RecommendADVideoFeedsManager(paramActivity, paramIReadInJoyBaseAdapter, paramIVideoPlayManager, (ReadInJoyXListView)paramObject, paramInt);
  }
  
  public Object createSuperMaskPopupStep(Object paramObject, Activity paramActivity)
  {
    return new RIJADSuperMaskPopupStep((RIJPopupAutomator)paramObject, paramActivity);
  }
  
  public Object createTKDAdModule()
  {
    return new TkdAdModuleImpl();
  }
  
  public Object createTkdAdHippyEngine(Object paramObject, String paramString1, String paramString2)
  {
    return new TkdAdHippyEngine((QBaseFragment)paramObject, paramString1, paramString2);
  }
  
  public IVideoAdExposureManager createVideoAdExposureManager(IVideoFeedsAdapter paramIVideoFeedsAdapter, Object paramObject1, Object paramObject2, Handler paramHandler)
  {
    return new VideoAdExposureManager(paramIVideoFeedsAdapter, (List)paramObject1, (VideoFeedsRecyclerView)paramObject2, paramHandler);
  }
  
  public IVideoAdStrategyReportManager createVideoAdStrategyReportManager()
  {
    return new VideoAdStrategyReportManager();
  }
  
  public IVideoAdTimeLoadManager createVideoAdTimeLoadManager(IVideoFeedsAdapter paramIVideoFeedsAdapter, Object paramObject)
  {
    return new VideoAdTimeLoadManager(paramIVideoFeedsAdapter, (ArrayList)paramObject);
  }
  
  public IVideoAdVVAdloadStrategyManager createVideoAdVVAdloadStrategyManager(IVideoFeedsAdapter paramIVideoFeedsAdapter, Object paramObject, IVideoAdTimeLoadManager paramIVideoAdTimeLoadManager)
  {
    return new VideoAdVVAdloadStrategyManager(paramIVideoFeedsAdapter, (ArrayList)paramObject, paramIVideoAdTimeLoadManager);
  }
  
  public IVideoFeedsGameAdComManager createVideoFeedsGameAdComManager(Object paramObject, Activity paramActivity, View paramView)
  {
    return new VideoFeedsGameAdComManager((QQAppInterface)paramObject, paramActivity, (VideoFeedsRecyclerView)paramView);
  }
  
  public IVideoFeedsHardAdBarManager createVideoFeedsHardAdBarManager(Context paramContext, boolean paramBoolean, Activity paramActivity, Object paramObject)
  {
    return new VideoFeedsHardAdBarManager(paramContext, paramBoolean, paramActivity, (IVideoFeedsAdapter)paramObject);
  }
  
  public IVideoFeedsSoftAdBarController createVideoFeedsSoftAdBarController(Object paramObject, Activity paramActivity, View paramView)
  {
    return new VideoFeedsSoftAdBarController((QQAppInterface)paramObject, paramActivity, (VideoFeedsRecyclerView)paramView);
  }
  
  public SimpleConfigHandler createVideoSoftAdConfigHandler()
  {
    return new VideoSoftAdConfigHandler();
  }
  
  public Object createWebViewPlugin()
  {
    return new RIJAdWebViewPlugin();
  }
  
  public Object getAdCache(int paramInt)
  {
    return ReadinjoyAdCache.b(paramInt);
  }
  
  public Class getAdMaterialResManagerClz()
  {
    return AdMaterialResManager.class;
  }
  
  public Context getContext()
  {
    return BaseApplicationImpl.getContext();
  }
  
  public void getMotiveAd(Activity paramActivity, String paramString, long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject)
  {
    ReadInJoyMotiveAdModule.a().a(paramActivity, paramString, paramLong1, paramLong2, paramInt1, paramInt2, (GdtAdListener)paramObject);
  }
  
  public Object getMotiveAdInfo(Object paramObject)
  {
    return ReadInJoyMotiveAdModule.a((GdtAd)paramObject);
  }
  
  public Class getNativeAdPreloadManagerClz()
  {
    return NativeAdPreloadManager.class;
  }
  
  public Map<String, ViewBase.IBuilder> getProteusBuilders()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ReadInJoyAdDownloadView", new RIJAdDownloadViewBase.Builder());
    localHashMap.put("ReadInJoyIconText", new ReadInJoyIconText.Builder());
    localHashMap.put("ReadInjoyDoubleImageView", new ReadInjoyDoubleImageView.Builder());
    localHashMap.put("ReadInJoyBlurImageView", new ReadInJoyBlurImageView.Builder());
    localHashMap.put("ReadInJoyAdBubbleView", new ReadInJoyAdBubbleView.Builder());
    localHashMap.put("ReadInJoyAdCommonBlurImageView", new ReadInJoyAdCommonBlurImageView.Builder());
    localHashMap.put("ReadInJoyAdInnerOperateView", new ReadInJoyAdInnerOperateView.Builder());
    localHashMap.put("ReadInJoyAdBrandOptimizationView", new ReadInJoyAdBrandOptimizationView.Builder());
    localHashMap.put("ReadInJoyArticleBottomVideoView", new ReadInJoyArticleBottomVideoView.Builder());
    localHashMap.put("ReadInJoyAdExpandCardPic", new ReadInJoyAdExpandCardPic.Builder());
    localHashMap.put("ReadInJoyAdVpngVideo", new ReadInJoyAdVpngVideo.Builder());
    return localHashMap;
  }
  
  public Map<Integer, Object> getProteusItems()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(105), new AdTripleProteusItem());
    localHashMap.put(Integer.valueOf(66), new AdBigVideoProteusItem());
    localHashMap.put(Integer.valueOf(115), new AdBigVideoProteusItem());
    localHashMap.put(Integer.valueOf(39), new AdBigImageProteusItem());
    localHashMap.put(Integer.valueOf(116), new AdPKImageProteusItem());
    localHashMap.put(Integer.valueOf(106), new AdSmallImageProteusItem());
    localHashMap.put(Integer.valueOf(140), new AdQQMiniGameListProteusItem());
    localHashMap.put(Integer.valueOf(146), new AdQQMiniGameHorizListProteusItem());
    localHashMap.put(Integer.valueOf(141), new AdQQMiniGameVideoProteusItem());
    localHashMap.put(Integer.valueOf(143), new AdQQMiniGameVideoProteusItem());
    localHashMap.put(Integer.valueOf(144), new AdQQMiniGameTripleImgProteusItem());
    localHashMap.put(Integer.valueOf(145), new AdQQMiniGameNewStyleProteusItem());
    localHashMap.put(Integer.valueOf(127), new AdBrandOptimizationProteusItem());
    localHashMap.put(Integer.valueOf(148), new AdLiveExpandCardProteusItem());
    localHashMap.put(Integer.valueOf(149), new AdLiveExpandCardProteusItem());
    localHashMap.put(Integer.valueOf(150), new AdExpandCardProteusItem());
    localHashMap.put(Integer.valueOf(151), new AdSmallVideoProteusItem());
    localHashMap.put(Integer.valueOf(152), new AdSurpriseVideoProteusItem());
    localHashMap.put(Integer.valueOf(153), new AdShakeVideoProteusItem());
    return localHashMap;
  }
  
  public Class getRIJADExposureManagerClz()
  {
    return ReadInjoyADExposureManager.class;
  }
  
  public Class getReadInJoyNativeAdFragment()
  {
    return ReadInJoyNativeAdFragment.class;
  }
  
  public boolean initDebugInfo(boolean paramBoolean, long paramLong)
  {
    return paramBoolean;
  }
  
  public boolean instanceOfAdvertisementInfo(Object paramObject)
  {
    return paramObject instanceof AdvertisementInfo;
  }
  
  public void jumpToPkPage(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("param_ad_info", paramAdvertisementInfo);
    ReadinjoyAdPKFragment.a(paramActivity, ReadinjoyAdPKFragment.class, localBundle);
  }
  
  public boolean needReportNew()
  {
    return AdReportManager.a().b();
  }
  
  public boolean needReportSoftNew()
  {
    return AdReportManager.a().c();
  }
  
  public void preRequestPatchAd()
  {
    ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).preRequestPatchAd();
  }
  
  public void queryDownloadState(AdvertisementInfo paramAdvertisementInfo, ValueCallback<Integer> paramValueCallback)
  {
    AdDownloadStateQueryUtil.a(paramAdvertisementInfo, paramValueCallback);
  }
  
  public void report(ReportAction paramReportAction, Integer paramInteger, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    ReadInJoyAdReportUtils.a(paramReportAction, paramInteger, paramAdvertisementInfo, paramInt1, paramInt2, paramInt3);
  }
  
  public void report(AdReportData paramAdReportData)
  {
    RIJAdReportManager.a(paramAdReportData);
  }
  
  public void reportReadinjoyADEvent(Object paramObject, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    RIJAdReportManager.a((QQAppInterface)paramObject, paramString1, paramString2, paramInt1, paramInt2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void showMotiveAd(Activity paramActivity, int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3)
  {
    ReadInJoyMotiveAdModule.a().a(paramActivity, paramInt1, paramString1, paramInt2, paramString2, paramString3);
  }
  
  public void startNativeAdVideoFragment(Activity paramActivity, Bundle paramBundle)
  {
    NativeAdVideoFragment.a(paramActivity, NativeAdVideoFragment.class, paramBundle);
  }
  
  public void startReadInJoyNativeAdAppFragment(Activity paramActivity, Bundle paramBundle)
  {
    ReadInJoyNativeAdAppFragment.a(paramActivity, ReadInJoyNativeAdAppFragment.class, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdServiceImpl
 * JD-Core Version:    0.7.0.1
 */