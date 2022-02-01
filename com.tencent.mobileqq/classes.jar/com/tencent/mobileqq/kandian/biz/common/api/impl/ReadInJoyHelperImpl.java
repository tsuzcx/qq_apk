package com.tencent.mobileqq.kandian.biz.common.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.ListAdapter;
import androidx.fragment.app.Fragment;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdHippyService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.feeds.ReadInJoyArticleAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.activity.ReadInJoyNewFeedsActivity;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyFragmentWithSubChannel;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoyRecommendFeedsFragment;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.ReadInJoySubChannelFragment;
import com.tencent.mobileqq.kandian.biz.follow.ReadInJoyBBCircleFragment;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.skin.GuideData;
import com.tencent.mobileqq.kandian.biz.viola.ReadInJoyViolaChannelFragment;
import com.tencent.mobileqq.kandian.glue.report.dau.ReadInJoyActivityDAUInfo;
import com.tencent.mobileqq.kandian.glue.utils.RIJPreParseData;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJMaybeInitializedAladdinConfig;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.RIJNewReportChannelConfigHandler;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJPersonalHomePageConfigSp;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJProteusOfflineBidSp;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoDynamicBufferConfigSp;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJVideoSdkConfigSp;
import com.tencent.mobileqq.kandian.repo.aladdin.sp.RIJViolaPicDetailConfigSp;
import com.tencent.mobileqq.kandian.repo.common.RIJShowKanDianTabSp;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.tab.KandianFrameStatus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/impl/ReadInJoyHelperImpl;", "Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoyHelper;", "()V", "adSuperMaskLog", "", "msg", "", "adSuperMaskServiceSetChannelId", "channelID", "", "addExtraInfoInJson", "r5", "Lorg/json/JSONObject;", "addKanDianChatSessionKey", "friendUin", "selfUin", "sig", "", "applySharedPreferences", "editor", "Landroid/content/SharedPreferences$Editor;", "applyFirst", "", "canFreeTimeRefreshPush", "canInMessageList", "uin", "checkIsVideoFeedsGameAdComBarLocalConfigToday", "checkLastScanTTDate", "findSocialFeedsWebUrlKey", "key", "forwardToReadInJoyFeed", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "requestCode", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "generateSocialCountLess99", "count", "getCameraCaptureMaxDuration", "getCanLoadStartWebRenderModeConfig", "getDynamicBufferConfig", "getDynamicBufferSwitch", "getFFProbesize", "", "getGuideDataClazz", "Ljava/lang/Class;", "getInnerVideoInfoShowSWitcher", "getKDSPValueWithKey", "T", "defaultValue", "isAccountRelated", "(Ljava/lang/String;Ljava/lang/Object;Z)Ljava/lang/Object;", "getKanDianChatSessionKey", "getKanDianReportTTSwitch", "getKandianConfigAdExposureThreshold", "app", "Lmqq/app/AppRuntime;", "getKandianConfigBadgeSwitch", "getKandianLebaViewItem", "", "getPersonalHomePageWebUrl", "getPreplayTimeLimit", "getProteusOfflineBid", "bidKey", "getReadInJoyActivityDAUInfo", "getReadInJoyMultiVideoChannelInfoVersion", "getReadInJoySP", "Landroid/content/SharedPreferences;", "isSupportMultiProcess", "getReadInJoySharedPreferences", "accessMode", "getReadInJoySpValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getReadInjoyShareToWxAtSwitch", "getReadinjoyStopFunctionSwitch", "getRemoveKandianFlag", "getSplasDebugSWitcher", "getUserConfigVersion", "()Ljava/lang/Integer;", "getVideoRealTimeLogDebug", "getVideoStructMsgPlaySwitch", "getViolaDebugSWitcher", "getViolaJsDebugBundleSwitcher", "getViolaJsLocalBundleSwitcher", "getViolaPicDetailConfig", "getViolaRecommendSwitcher", "getWebRenderConfig", "hideKandianTab", "isColorLevel", "isDailyChildFeeds", "isDownloadAsyncIo", "isEnableUseNewReportChannel", "isFFProbelistSwitch", "isFromVideoColumn", "videoFromType", "isInReadInJoyNewFeedsActivity", "isInReadinjoyFolderMergerStyle", "isInSplashActivity", "isKandianFavourite", "url", "forWhat", "isOSVersionSupportReadInJoy", "isRIJVideoEnableReprint", "isReadInJoyAdHippyFragment", "fragment", "Landroidx/fragment/app/Fragment;", "isReadInJoyArticleAdapter", "adapter", "Landroid/widget/ListAdapter;", "isReadInJoyBBCircleFragment", "isReadInJoyFragmentWithSubChannel", "isReadInJoyRecommendFeedsFragment", "isReadInJoySubChannelFragment", "isReadInJoyViolaChannelFragment", "isShowKandianRecommendArticleInSubscriptFeeds", "isShowKandianTab", "isShowKandianTabNew", "isShowMainRecommendTab", "isShowMainVideoTab", "isShowRecommendReasonInTitle", "isVideoFeedsTiktokStyle", "isViolaColumnEntryInTest", "isViolaMessageBoxInTest", "isWxArticle", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "articleUrl", "launchReadInJoyPlugin", "fromActivity", "maybeInitializedAladdin", "needUpdateKandianFrame", "kandianFrameStatus", "Lcom/tencent/mobileqq/kandian/repo/tab/KandianFrameStatus;", "currentIsShow", "onKandianFeedsConfigChanged", "config", "onMergeFeedsConfigChanged", "onShareToNewsConfigChanged", "onSynchronizeToQzoneConfigChanged", "preParseArticleJsonParam", "article", "reportArticleByWeb", "source", "sourceArticleId", "operation", "opsource", "setKanDianReportTTSwitch", "reportSwitch", "setLastScanTTDate", "date", "setOperationFlag", "context", "Landroid/content/Context;", "operationBitFlag", "setUserConfigVersion", "value", "synSwitchCache", "updateArkChannelConfig", "updateCUKingCardDlgSwitch", "updateFreeTimeRefreshPush", "can", "updateGallerySubChannelHidden", "updateGallerySubChannelWaterFallHidden", "updateHasSetSwitch", "hasSet", "updateInnerVideoInfoShowSwitcher", "show", "updateKandianConfigDefaultBitRate", "bitRateStr", "updateKandianConfigRedShowNum", "num", "updateKandianConfigRedThreshold", "updateKandianMyTabPage", "updateKandianTabConfigSwitchSp", "switchOpen", "updateKandianVideoSocialSwitch", "updateLocalCacheSwitch", "tabSwitch", "updateOpenSimpleSwitchFm", "updateProteusOfflineBid", "bid", "updateRIJVideoEnableReprint", "enableReprint", "updateReadInJoyFeedsGroupSetting", "setting", "updateReadInJoyIndividualPushSwitchSetting", "flag", "updateReadInJoyInterestedPushSwitch", "interestedSwitch", "updateReadInJoyMultiVideoChannelInfo", "channelName", "channelType", "updateReadInJoyPushMsgSwitch", "updateReadInJoySmartCropSetting", "updateReadInJoySpValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "(Ljava/lang/String;Ljava/lang/Object;Z)V", "updateReadInJoyVideoJumpDefaultValue", "updateReadinjoyFolderMergerConfig", "updateReadinjoyFolderMergerReal", "updateReadinjoyStopFunctionSwtichReal", "updateReadinjoySubscribeListPush", "enable", "updateSelfFragmentFeedBackConf", "updateShowRecommendReasonInTitle", "updateSocialFeedsWebJumpUrl", "updateSplashDebugSwitcher", "updateSupportMultiVideoSwitch", "enableSw", "updateVideoChannelAutoPlaySwitchDefaultValue", "updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow", "updateVideoChannelCoverStyle", "updateVideoChannelFeedsClickSwitchValue", "updateVideoColumnEntrySwitcher", "isTest", "updateVideoDynamicRecommendDurationPercent", "", "updateVideoDynamicRecommendOperator", "updateVideoDynamicRecommmendDurationLimit", "updateVideoDynamicRecommmendStrategy", "updateVideoMessageBoxSwitcher", "updateVideoRealTimeLogDebug", "updateVideoStructMsgPlaySwitch", "updateViolaDebugSwitcher", "updateViolaDiscoverConfig", "updateViolaDynamicConfig", "updateViolaJsDebugBundleSwitcher", "updateViolaJsLocalBundleSwitcher", "updateViolaMessageBoxConfig", "updateViolaRecommendSwitcher", "updateViolaWeishiAdConfig", "updateWebRenderConfig", "updateWebRenderModeConfig", "use0xcbaRefreshCmd", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyHelperImpl
  implements IReadInJoyHelper
{
  public void adSuperMaskLog(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "msg");
    ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", paramString);
  }
  
  public void adSuperMaskServiceSetChannelId(int paramInt)
  {
    QRouteApi localQRouteApi = QRoute.api(IRIJSuperMaskService.class);
    Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IRIJSuperMaskService::class.java)");
    ((IRIJSuperMaskService)localQRouteApi).setChannelID(paramInt);
  }
  
  public void addExtraInfoInJson(@Nullable JSONObject paramJSONObject)
  {
    ReadInJoyHelper.a(paramJSONObject);
  }
  
  public void addKanDianChatSessionKey(@Nullable String paramString1, @Nullable String paramString2, @Nullable byte[] paramArrayOfByte)
  {
    ReadInJoyHelper.a(paramString1, paramString2, paramArrayOfByte);
  }
  
  public void applySharedPreferences(@Nullable SharedPreferences.Editor paramEditor, boolean paramBoolean)
  {
    RIJSPUtils.a(paramEditor, true);
  }
  
  public boolean canFreeTimeRefreshPush()
  {
    return ReadInJoyHelper.A(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean canInMessageList(@Nullable String paramString)
  {
    return ReadInJoyHelper.d(paramString);
  }
  
  public boolean checkIsVideoFeedsGameAdComBarLocalConfigToday()
  {
    return ReadInJoyHelper.ay(RIJQQAppInterfaceUtil.e());
  }
  
  @Nullable
  public String checkLastScanTTDate()
  {
    return ReadInJoyHelper.B(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean findSocialFeedsWebUrlKey(@Nullable String paramString)
  {
    return ReadInJoyHelper.a(paramString);
  }
  
  public void forwardToReadInJoyFeed(@Nullable Activity paramActivity, @Nullable Intent paramIntent, int paramInt, @Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    ReadInJoyHelper.a(paramActivity, paramIntent, paramInt, paramOnDismissListener);
  }
  
  @Nullable
  public String generateSocialCountLess99(int paramInt)
  {
    return ReadInJoyHelper.e(paramInt);
  }
  
  public int getCameraCaptureMaxDuration()
  {
    return ReadInJoyHelper.y(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean getCanLoadStartWebRenderModeConfig()
  {
    return ReadInJoyHelper.W(RIJQQAppInterfaceUtil.e());
  }
  
  @Nullable
  public String getDynamicBufferConfig()
  {
    return RIJVideoDynamicBufferConfigSp.b();
  }
  
  public int getDynamicBufferSwitch()
  {
    return RIJVideoDynamicBufferConfigSp.a();
  }
  
  public long getFFProbesize()
  {
    return ReadInJoyHelper.H();
  }
  
  @NotNull
  public Class<?> getGuideDataClazz()
  {
    return GuideData.class;
  }
  
  public boolean getInnerVideoInfoShowSWitcher()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      return ReadInJoyHelper.o((AppRuntime)localAppRuntime);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  @Nullable
  public <T> T getKDSPValueWithKey(@NotNull String paramString, T paramT, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    return RIJSPUtils.d(paramString, paramT, paramBoolean);
  }
  
  @Nullable
  public byte[] getKanDianChatSessionKey(@Nullable String paramString1, @Nullable String paramString2)
  {
    return ReadInJoyHelper.a(paramString1, paramString2);
  }
  
  public boolean getKanDianReportTTSwitch()
  {
    return ReadInJoyHelper.C(RIJQQAppInterfaceUtil.e());
  }
  
  public int getKandianConfigAdExposureThreshold(@Nullable AppRuntime paramAppRuntime)
  {
    return ReadInJoyHelper.ax(paramAppRuntime);
  }
  
  public int getKandianConfigBadgeSwitch()
  {
    return ReadInJoyHelper.ah(RIJQQAppInterfaceUtil.e());
  }
  
  @Nullable
  public Object getKandianLebaViewItem()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      return ReadInJoyHelper.f((QQAppInterface)localAppRuntime);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  @Nullable
  public String getPersonalHomePageWebUrl()
  {
    return RIJPersonalHomePageConfigSp.b();
  }
  
  public int getPreplayTimeLimit()
  {
    return RIJVideoSdkConfigSp.a();
  }
  
  @Nullable
  public String getProteusOfflineBid(@Nullable String paramString)
  {
    return RIJProteusOfflineBidSp.a(paramString);
  }
  
  @NotNull
  public Class<?> getReadInJoyActivityDAUInfo()
  {
    return ReadInJoyActivityDAUInfo.class;
  }
  
  public int getReadInJoyMultiVideoChannelInfoVersion()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      return ReadInJoyHelper.h((QQAppInterface)localAppRuntime);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  @Nullable
  public SharedPreferences getReadInJoySP(boolean paramBoolean1, boolean paramBoolean2)
  {
    return RIJSPUtils.a(RIJQQAppInterfaceUtil.e(), paramBoolean1, paramBoolean2);
  }
  
  @Nullable
  public SharedPreferences getReadInJoySharedPreferences(int paramInt)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      return ReadInJoyHelper.a((QQAppInterface)localAppRuntime, paramInt);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public <T> T getReadInJoySpValue(@Nullable String paramString, T paramT)
  {
    return RIJSPUtils.b(paramString, paramT);
  }
  
  public <T> T getReadInJoySpValue(@Nullable String paramString, T paramT, boolean paramBoolean)
  {
    return RIJSPUtils.d(paramString, paramT, paramBoolean);
  }
  
  public int getReadInjoyShareToWxAtSwitch()
  {
    return ReadInJoyHelper.L(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean getReadinjoyStopFunctionSwitch()
  {
    return false;
  }
  
  public boolean getRemoveKandianFlag()
  {
    return ReadInJoyHelper.a();
  }
  
  public boolean getSplasDebugSWitcher()
  {
    return ReadInJoyHelper.w(RIJQQAppInterfaceUtil.e());
  }
  
  @Nullable
  public Integer getUserConfigVersion()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    if (localQQAppInterface != null)
    {
      Object localObject = localQQAppInterface.getApp();
      if (localObject != null)
      {
        localObject = ((BaseApplication)localObject).getSharedPreferences("HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION", 4);
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION");
          localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
          return Integer.valueOf(((SharedPreferences)localObject).getInt(localStringBuilder.toString(), 0));
        }
      }
    }
    return null;
  }
  
  public long getVideoRealTimeLogDebug()
  {
    return ReadInJoyHelper.h();
  }
  
  public boolean getVideoStructMsgPlaySwitch()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      return ReadInJoyHelper.i((QQAppInterface)localAppRuntime);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public boolean getViolaDebugSWitcher()
  {
    return ReadInJoyHelper.p(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean getViolaJsDebugBundleSwitcher()
  {
    return ReadInJoyHelper.q(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean getViolaJsLocalBundleSwitcher()
  {
    return ReadInJoyHelper.r(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean getViolaPicDetailConfig()
  {
    return RIJViolaPicDetailConfigSp.a(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean getViolaRecommendSwitcher()
  {
    return ReadInJoyHelper.az(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean getWebRenderConfig()
  {
    return ReadInJoyHelper.V(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean hideKandianTab()
  {
    return RIJShowKanDianTabSp.b();
  }
  
  public boolean isColorLevel()
  {
    return RIJAppSetting.j();
  }
  
  public boolean isDailyChildFeeds(long paramLong)
  {
    return RIJShowKanDianTabSp.a(paramLong);
  }
  
  public boolean isDownloadAsyncIo()
  {
    return ReadInJoyHelper.J();
  }
  
  public boolean isEnableUseNewReportChannel()
  {
    return RIJNewReportChannelConfigHandler.a();
  }
  
  public boolean isFFProbelistSwitch()
  {
    return ReadInJoyHelper.I();
  }
  
  public boolean isFromVideoColumn(int paramInt)
  {
    return ReadInJoyHelper.n(paramInt);
  }
  
  public boolean isInReadInJoyNewFeedsActivity(@Nullable Activity paramActivity)
  {
    return paramActivity instanceof ReadInJoyNewFeedsActivity;
  }
  
  public boolean isInReadinjoyFolderMergerStyle()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      return ReadInJoyHelper.a((AppInterface)localAppRuntime);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public boolean isInSplashActivity(@Nullable Activity paramActivity)
  {
    return paramActivity instanceof SplashActivity;
  }
  
  public boolean isKandianFavourite(@Nullable Activity paramActivity, @Nullable String paramString, int paramInt)
  {
    return ReadInJoyHelper.a(paramActivity, paramString, paramInt);
  }
  
  public boolean isOSVersionSupportReadInJoy()
  {
    return RIJAppSetting.i();
  }
  
  public boolean isRIJVideoEnableReprint()
  {
    return ReadInJoyHelper.u(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean isReadInJoyAdHippyFragment(@NotNull Fragment paramFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramFragment, "fragment");
    return ((IRIJAdHippyService)QRoute.api(IRIJAdHippyService.class)).instanceOfReadinjoyAdHippyFragment(paramFragment);
  }
  
  public boolean isReadInJoyArticleAdapter(@Nullable ListAdapter paramListAdapter)
  {
    return paramListAdapter instanceof ReadInJoyArticleAdapter;
  }
  
  public boolean isReadInJoyBBCircleFragment(@NotNull Fragment paramFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramFragment, "fragment");
    return paramFragment instanceof ReadInJoyBBCircleFragment;
  }
  
  public boolean isReadInJoyFragmentWithSubChannel(@NotNull Fragment paramFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramFragment, "fragment");
    return paramFragment instanceof ReadInJoyFragmentWithSubChannel;
  }
  
  public boolean isReadInJoyRecommendFeedsFragment(@NotNull Fragment paramFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramFragment, "fragment");
    return paramFragment instanceof ReadInJoyRecommendFeedsFragment;
  }
  
  public boolean isReadInJoySubChannelFragment(@NotNull Fragment paramFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramFragment, "fragment");
    return paramFragment instanceof ReadInJoySubChannelFragment;
  }
  
  public boolean isReadInJoyViolaChannelFragment(@NotNull Fragment paramFragment)
  {
    Intrinsics.checkParameterIsNotNull(paramFragment, "fragment");
    return paramFragment instanceof ReadInJoyViolaChannelFragment;
  }
  
  public boolean isShowKandianRecommendArticleInSubscriptFeeds()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      return ReadInJoyHelper.d((QQAppInterface)localAppRuntime);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public boolean isShowKandianTab()
  {
    return RIJShowKanDianTabSp.c();
  }
  
  public boolean isShowKandianTabNew()
  {
    return RIJShowKanDianTabSp.a();
  }
  
  public boolean isShowMainRecommendTab()
  {
    return ReadInJoyHelper.w();
  }
  
  public boolean isShowMainVideoTab()
  {
    return ReadInJoyHelper.v();
  }
  
  public boolean isShowRecommendReasonInTitle()
  {
    return ReadInJoyHelper.e(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean isVideoFeedsTiktokStyle()
  {
    return ReadInJoyHelper.b();
  }
  
  public boolean isViolaColumnEntryInTest()
  {
    return ReadInJoyHelper.t(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean isViolaMessageBoxInTest()
  {
    return ReadInJoyHelper.s(RIJQQAppInterfaceUtil.e());
  }
  
  public boolean isWxArticle(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyHelper.b(paramAbsBaseArticleInfo);
  }
  
  public boolean isWxArticle(@Nullable String paramString)
  {
    return ReadInJoyHelper.l(paramString);
  }
  
  public void launchReadInJoyPlugin(@Nullable Activity paramActivity, @Nullable Intent paramIntent)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.a((QQAppInterface)localAppRuntime, paramActivity, paramIntent);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void maybeInitializedAladdin() {}
  
  public boolean needUpdateKandianFrame(@Nullable KandianFrameStatus paramKandianFrameStatus, boolean paramBoolean)
  {
    return ReadInJoyHelper.a(paramKandianFrameStatus, paramBoolean);
  }
  
  public void onKandianFeedsConfigChanged(@Nullable String paramString)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.e(paramString, (QQAppInterface)localAppRuntime);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void onMergeFeedsConfigChanged(@Nullable String paramString)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.d(paramString, (QQAppInterface)localAppRuntime);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void onShareToNewsConfigChanged(@Nullable String paramString)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.a(paramString, (QQAppInterface)localAppRuntime);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void onSynchronizeToQzoneConfigChanged(@Nullable String paramString)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.b(paramString, (QQAppInterface)localAppRuntime);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void preParseArticleJsonParam(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    RIJPreParseData.b(paramAbsBaseArticleInfo);
  }
  
  public void reportArticleByWeb(int paramInt1, long paramLong, int paramInt2, int paramInt3)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.a((QQAppInterface)localAppRuntime, paramInt1, paramLong, paramInt2, paramInt3);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void setKanDianReportTTSwitch(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.t((AppRuntime)localAppRuntime, paramBoolean);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void setLastScanTTDate(@Nullable String paramString)
  {
    ReadInJoyHelper.d(RIJQQAppInterfaceUtil.e(), paramString);
  }
  
  public void setOperationFlag(@Nullable Context paramContext, int paramInt)
  {
    Context localContext = paramContext;
    if (!(paramContext instanceof ReadInJoyNewFeedsActivity)) {
      localContext = null;
    }
    paramContext = (ReadInJoyNewFeedsActivity)localContext;
    if (paramContext != null) {
      paramContext.e(8);
    }
  }
  
  public void setUserConfigVersion(int paramInt)
  {
    Object localObject1 = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    if (localObject1 != null)
    {
      Object localObject2 = ((QQAppInterface)localObject1).getApp();
      if (localObject2 != null)
      {
        localObject2 = ((BaseApplication)localObject2).getSharedPreferences("HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION", 4);
        if (localObject2 != null)
        {
          localObject2 = ((SharedPreferences)localObject2).edit();
          if (localObject2 != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION");
            localStringBuilder.append(((QQAppInterface)localObject1).getCurrentAccountUin());
            localObject1 = ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), paramInt);
            if (localObject1 != null) {
              ((SharedPreferences.Editor)localObject1).apply();
            }
          }
        }
      }
    }
  }
  
  public void synSwitchCache() {}
  
  public boolean updateArkChannelConfig(@Nullable String paramString)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      return ReadInJoyHelper.a((AppRuntime)localAppRuntime, paramString);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateCUKingCardDlgSwitch(int paramInt)
  {
    ReadInJoyHelper.g(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateFreeTimeRefreshPush(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.s((AppRuntime)localAppRuntime, paramBoolean);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateGallerySubChannelHidden(@Nullable String paramString)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.x((AppRuntime)localAppRuntime, paramString);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateGallerySubChannelWaterFallHidden(@Nullable String paramString)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.y((AppRuntime)localAppRuntime, paramString);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateHasSetSwitch(boolean paramBoolean)
  {
    RIJShowKanDianTabSp.b(paramBoolean);
  }
  
  public void updateInnerVideoInfoShowSwitcher(boolean paramBoolean)
  {
    ReadInJoyHelper.i(RIJQQAppInterfaceUtil.e(), paramBoolean);
  }
  
  public void updateKandianConfigDefaultBitRate(@Nullable String paramString)
  {
    ReadInJoyHelper.w(RIJQQAppInterfaceUtil.e(), paramString);
  }
  
  public void updateKandianConfigRedShowNum(int paramInt)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.j((AppRuntime)localAppRuntime, paramInt);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateKandianConfigRedThreshold(int paramInt)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.k((AppRuntime)localAppRuntime, paramInt);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public boolean updateKandianMyTabPage(@Nullable String paramString)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null) {
      return ReadInJoyHelper.H((AppRuntime)localAppRuntime, paramString);
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public boolean updateKandianTabConfigSwitchSp(boolean paramBoolean)
  {
    return RIJShowKanDianTabSp.a(paramBoolean);
  }
  
  public void updateKandianVideoSocialSwitch(boolean paramBoolean)
  {
    ReadInJoyHelper.r(RIJQQAppInterfaceUtil.e(), paramBoolean);
  }
  
  public void updateLocalCacheSwitch(int paramInt)
  {
    RIJShowKanDianTabSp.a(paramInt);
  }
  
  public void updateOpenSimpleSwitchFm(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.c((AppRuntime)localAppRuntime, paramBoolean);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateProteusOfflineBid(@Nullable String paramString1, @Nullable String paramString2)
  {
    RIJProteusOfflineBidSp.a(paramString1, paramString2);
  }
  
  public void updateRIJVideoEnableReprint(boolean paramBoolean)
  {
    ReadInJoyHelper.o(RIJQQAppInterfaceUtil.e(), paramBoolean);
  }
  
  public void updateReadInJoyFeedsGroupSetting(@Nullable String paramString)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.a((QQAppInterface)localAppRuntime, paramString);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateReadInJoyIndividualPushSwitchSetting(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.a((AppRuntime)localAppRuntime, paramBoolean);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateReadInJoyInterestedPushSwitch(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.c((QQAppInterface)localAppRuntime, paramBoolean);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateReadInJoyMultiVideoChannelInfo(int paramInt1, @Nullable String paramString, int paramInt2)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.a((QQAppInterface)localAppRuntime, paramInt1, paramString, paramInt2);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateReadInJoyPushMsgSwitch(@Nullable String paramString)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.b((QQAppInterface)localAppRuntime, paramString);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateReadInJoySmartCropSetting(@Nullable String paramString)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.c((QQAppInterface)localAppRuntime, paramString);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public <T> void updateReadInJoySpValue(@Nullable String paramString, T paramT)
  {
    RIJSPUtils.a(paramString, paramT);
  }
  
  public <T> void updateReadInJoySpValue(@Nullable String paramString, T paramT, boolean paramBoolean)
  {
    RIJSPUtils.c(paramString, paramT, paramBoolean);
  }
  
  public void updateReadInJoyVideoJumpDefaultValue(int paramInt)
  {
    ReadInJoyHelper.f(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateReadinjoyFolderMergerConfig(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "setting");
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.c(paramString, (QQAppInterface)localAppRuntime);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateReadinjoyFolderMergerReal()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.a((QQAppInterface)localAppRuntime);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateReadinjoyStopFunctionSwtichReal()
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.g((QQAppInterface)localAppRuntime);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateReadinjoySubscribeListPush(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.d((AppRuntime)localAppRuntime, paramBoolean);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateSelfFragmentFeedBackConf(@Nullable String paramString1, @Nullable String paramString2)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.b((AppRuntime)localAppRuntime, paramString1, paramString2);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateShowRecommendReasonInTitle(boolean paramBoolean)
  {
    ReadInJoyHelper.b(RIJQQAppInterfaceUtil.e(), paramBoolean);
  }
  
  public void updateSocialFeedsWebJumpUrl(@Nullable String paramString1, @Nullable String paramString2)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.a((AppRuntime)localAppRuntime, paramString1, paramString2);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateSplashDebugSwitcher(boolean paramBoolean)
  {
    ReadInJoyHelper.q(RIJQQAppInterfaceUtil.e(), paramBoolean);
  }
  
  public void updateSupportMultiVideoSwitch(int paramInt)
  {
    Object localObject = (QQAppInterface)RIJQQAppInterfaceUtil.e();
    if (localObject != null)
    {
      localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences(((QQAppInterface)localObject).getCurrentAccountUin(), 4).edit();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "appInterface.app.getShar…ODE_MULTI_PROCESS).edit()");
      ((SharedPreferences.Editor)localObject).putInt("hot_shortvideo_multi_video_support_799", paramInt);
      ((SharedPreferences.Editor)localObject).apply();
    }
  }
  
  public void updateSupportMultiVideoSwitch(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.b((QQAppInterface)localAppRuntime, paramBoolean);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateVideoChannelAutoPlaySwitchDefaultValue(int paramInt)
  {
    ReadInJoyHelper.b(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow(int paramInt)
  {
    ReadInJoyHelper.d(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateVideoChannelCoverStyle(int paramInt)
  {
    ReadInJoyHelper.n(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateVideoChannelFeedsClickSwitchValue(int paramInt)
  {
    ReadInJoyHelper.a(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateVideoColumnEntrySwitcher(boolean paramBoolean)
  {
    ReadInJoyHelper.n(RIJQQAppInterfaceUtil.e(), paramBoolean);
  }
  
  public void updateVideoDynamicRecommendDurationPercent(float paramFloat)
  {
    ReadInJoyHelper.a(RIJQQAppInterfaceUtil.e(), paramFloat);
  }
  
  public void updateVideoDynamicRecommendOperator(int paramInt)
  {
    ReadInJoyHelper.q(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateVideoDynamicRecommmendDurationLimit(int paramInt)
  {
    ReadInJoyHelper.p(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateVideoDynamicRecommmendStrategy(int paramInt)
  {
    ReadInJoyHelper.o(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateVideoMessageBoxSwitcher(boolean paramBoolean)
  {
    ReadInJoyHelper.m(RIJQQAppInterfaceUtil.e(), paramBoolean);
  }
  
  public void updateVideoRealTimeLogDebug() {}
  
  public void updateVideoStructMsgPlaySwitch(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = RIJQQAppInterfaceUtil.e();
    if (localAppRuntime != null)
    {
      ReadInJoyHelper.d((QQAppInterface)localAppRuntime, paramBoolean);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  public void updateViolaDebugSwitcher(boolean paramBoolean)
  {
    ReadInJoyHelper.j(RIJQQAppInterfaceUtil.e(), paramBoolean);
  }
  
  public void updateViolaDiscoverConfig(int paramInt)
  {
    ReadInJoyHelper.v(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateViolaDynamicConfig(int paramInt)
  {
    ReadInJoyHelper.t(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateViolaJsDebugBundleSwitcher(boolean paramBoolean)
  {
    ReadInJoyHelper.k(RIJQQAppInterfaceUtil.e(), paramBoolean);
  }
  
  public void updateViolaJsLocalBundleSwitcher(boolean paramBoolean)
  {
    ReadInJoyHelper.l(RIJQQAppInterfaceUtil.e(), paramBoolean);
  }
  
  public void updateViolaMessageBoxConfig(int paramInt)
  {
    ReadInJoyHelper.w(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateViolaRecommendSwitcher(boolean paramBoolean)
  {
    ReadInJoyHelper.A(RIJQQAppInterfaceUtil.e(), paramBoolean);
  }
  
  public void updateViolaWeishiAdConfig(int paramInt)
  {
    ReadInJoyHelper.u(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateWebRenderConfig(int paramInt)
  {
    ReadInJoyHelper.r(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public void updateWebRenderModeConfig(int paramInt)
  {
    ReadInJoyHelper.s(RIJQQAppInterfaceUtil.e(), paramInt);
  }
  
  public boolean use0xcbaRefreshCmd()
  {
    return RIJShowKanDianTabSp.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.impl.ReadInJoyHelperImpl
 * JD-Core Version:    0.7.0.1
 */