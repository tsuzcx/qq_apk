package com.tencent.mobileqq.kandian.biz.common.api;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.widget.ListAdapter;
import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.tab.KandianFrameStatus;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoyHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "adSuperMaskLog", "", "msg", "", "adSuperMaskServiceSetChannelId", "channelID", "", "addExtraInfoInJson", "r5", "Lorg/json/JSONObject;", "applySharedPreferences", "editor", "Landroid/content/SharedPreferences$Editor;", "applyFirst", "", "canFreeTimeRefreshPush", "canInMessageList", "uin", "checkIsVideoFeedsGameAdComBarLocalConfigToday", "checkLastScanTTDate", "findSocialFeedsWebUrlKey", "key", "forwardToReadInJoyFeed", "activity", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "requestCode", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "generateSocialCountLess99", "count", "getCameraCaptureMaxDuration", "getCanLoadStartWebRenderModeConfig", "getDynamicBufferConfig", "getDynamicBufferSwitch", "getFFProbesize", "", "getGuideDataClazz", "Ljava/lang/Class;", "getInnerVideoInfoShowSWitcher", "getKDSPValueWithKey", "T", "defaultValue", "isAccountRelated", "(Ljava/lang/String;Ljava/lang/Object;Z)Ljava/lang/Object;", "getKanDianReportTTSwitch", "getKandianConfigAdExposureThreshold", "app", "Lmqq/app/AppRuntime;", "getKandianConfigBadgeSwitch", "getKandianLebaViewItem", "", "getPersonalHomePageWebUrl", "getPreplayTimeLimit", "getProteusOfflineBid", "bidKey", "getReadInJoyActivityDAUInfo", "getReadInJoyMultiVideoChannelInfoVersion", "getReadInJoySP", "Landroid/content/SharedPreferences;", "isSupportMultiProcess", "getReadInJoySharedPreferences", "accessMode", "getReadInJoySpValue", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "getReadInjoyShareToWxAtSwitch", "getReadinjoyStopFunctionSwitch", "getRemoveKandianFlag", "getSplasDebugSWitcher", "getUserConfigVersion", "()Ljava/lang/Integer;", "getVideoRealTimeLogDebug", "getVideoStructMsgPlaySwitch", "getViolaDebugSWitcher", "getViolaJsDebugBundleSwitcher", "getViolaJsLocalBundleSwitcher", "getViolaPicDetailConfig", "getViolaRecommendSwitcher", "getWebRenderConfig", "hideKandianTab", "isColorLevel", "isDailyChildFeeds", "isDownloadAsyncIo", "isEnableUseNewReportChannel", "isFFProbelistSwitch", "isFromVideoColumn", "videoFromType", "isInReadInJoyNewFeedsActivity", "isInReadinjoyFolderMergerStyle", "isInSplashActivity", "isKandianFavourite", "url", "forWhat", "isOSVersionSupportReadInJoy", "isRIJVideoEnableReprint", "isReadInJoyAdHippyFragment", "fragment", "Landroidx/fragment/app/Fragment;", "isReadInJoyArticleAdapter", "adapter", "Landroid/widget/ListAdapter;", "isReadInJoyBBCircleFragment", "isReadInJoyFragmentWithSubChannel", "isReadInJoyRecommendFeedsFragment", "isReadInJoySubChannelFragment", "isReadInJoyViolaChannelFragment", "isShowKandianRecommendArticleInSubscriptFeeds", "isShowKandianTab", "isShowKandianTabNew", "isShowMainRecommendTab", "isShowMainVideoTab", "isShowRecommendReasonInTitle", "isVideoFeedsTiktokStyle", "isViolaColumnEntryInTest", "isViolaMessageBoxInTest", "isWxArticle", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "articleUrl", "launchReadInJoyPlugin", "fromActivity", "maybeInitializedAladdin", "needUpdateKandianFrame", "kandianFrameStatus", "Lcom/tencent/mobileqq/kandian/repo/tab/KandianFrameStatus;", "currentIsShow", "onKandianFeedsConfigChanged", "config", "onMergeFeedsConfigChanged", "onShareToNewsConfigChanged", "onSynchronizeToQzoneConfigChanged", "preParseArticleJsonParam", "article", "reportArticleByWeb", "source", "sourceArticleId", "operation", "opsource", "setKanDianReportTTSwitch", "reportSwitch", "setLastScanTTDate", "date", "setOperationFlag", "context", "Landroid/content/Context;", "operationBitFlag", "setUserConfigVersion", "value", "synSwitchCache", "updateArkChannelConfig", "updateCUKingCardDlgSwitch", "updateFreeTimeRefreshPush", "can", "updateGallerySubChannelHidden", "updateGallerySubChannelWaterFallHidden", "updateHasSetSwitch", "hasSet", "updateInnerVideoInfoShowSwitcher", "show", "updateKandianConfigDefaultBitRate", "bitRateStr", "updateKandianConfigRedShowNum", "num", "updateKandianConfigRedThreshold", "updateKandianMyTabPage", "updateKandianTabConfigSwitchSp", "switchOpen", "updateKandianVideoSocialSwitch", "updateLocalCacheSwitch", "tabSwitch", "updateOpenSimpleSwitchFm", "updateProteusOfflineBid", "bid", "updateRIJVideoEnableReprint", "enableReprint", "updateReadInJoyFeedsGroupSetting", "setting", "updateReadInJoyIndividualPushSwitchSetting", "flag", "updateReadInJoyInterestedPushSwitch", "interestedSwitch", "updateReadInJoyMultiVideoChannelInfo", "channelName", "channelType", "updateReadInJoyPushMsgSwitch", "updateReadInJoySmartCropSetting", "updateReadInJoySpValue", "(Ljava/lang/String;Ljava/lang/Object;)V", "(Ljava/lang/String;Ljava/lang/Object;Z)V", "updateReadInJoyVideoJumpDefaultValue", "updateReadinjoyFolderMergerConfig", "updateReadinjoyFolderMergerReal", "updateReadinjoyStopFunctionSwtichReal", "updateReadinjoySubscribeListPush", "enable", "updateSelfFragmentFeedBackConf", "updateShowRecommendReasonInTitle", "updateSocialFeedsWebJumpUrl", "updateSplashDebugSwitcher", "updateSupportMultiVideoSwitch", "enableSw", "updateVideoChannelAutoPlaySwitchDefaultValue", "updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow", "updateVideoChannelCoverStyle", "updateVideoChannelFeedsClickSwitchValue", "updateVideoColumnEntrySwitcher", "isTest", "updateVideoDynamicRecommendDurationPercent", "", "updateVideoDynamicRecommendOperator", "updateVideoDynamicRecommmendDurationLimit", "updateVideoDynamicRecommmendStrategy", "updateVideoMessageBoxSwitcher", "updateVideoRealTimeLogDebug", "updateVideoStructMsgPlaySwitch", "updateViolaDebugSwitcher", "updateViolaDiscoverConfig", "updateViolaDynamicConfig", "updateViolaJsDebugBundleSwitcher", "updateViolaJsLocalBundleSwitcher", "updateViolaMessageBoxConfig", "updateViolaRecommendSwitcher", "updateViolaWeishiAdConfig", "updateWebRenderConfig", "updateWebRenderModeConfig", "use0xcbaRefreshCmd", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyHelper
  extends QRouteApi
{
  public static final IReadInJoyHelper.Companion Companion = IReadInJoyHelper.Companion.a;
  @NotNull
  public static final String HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION = "HOT_SHORTVIDEO_MULTI_VIDEO_SUPPORT_799_VERSION";
  @NotNull
  public static final String HOT_SHORTVIDEO_MULTI_VIDEO_SWITCH_799 = "hot_shortvideo_multi_video_support_799";
  @NotNull
  public static final String READINJJOY_AD_SUPPLEMENT = "readinjjoy_ad_supplement_config";
  
  public abstract void adSuperMaskLog(@NotNull String paramString);
  
  public abstract void adSuperMaskServiceSetChannelId(int paramInt);
  
  public abstract void addExtraInfoInJson(@Nullable JSONObject paramJSONObject);
  
  public abstract void applySharedPreferences(@Nullable SharedPreferences.Editor paramEditor, boolean paramBoolean);
  
  public abstract boolean canFreeTimeRefreshPush();
  
  public abstract boolean canInMessageList(@Nullable String paramString);
  
  public abstract boolean checkIsVideoFeedsGameAdComBarLocalConfigToday();
  
  @Nullable
  public abstract String checkLastScanTTDate();
  
  public abstract boolean findSocialFeedsWebUrlKey(@Nullable String paramString);
  
  public abstract void forwardToReadInJoyFeed(@Nullable Activity paramActivity, @Nullable Intent paramIntent, int paramInt, @Nullable DialogInterface.OnDismissListener paramOnDismissListener);
  
  @Nullable
  public abstract String generateSocialCountLess99(int paramInt);
  
  public abstract int getCameraCaptureMaxDuration();
  
  public abstract boolean getCanLoadStartWebRenderModeConfig();
  
  @Nullable
  public abstract String getDynamicBufferConfig();
  
  public abstract int getDynamicBufferSwitch();
  
  public abstract long getFFProbesize();
  
  @NotNull
  public abstract Class<?> getGuideDataClazz();
  
  public abstract boolean getInnerVideoInfoShowSWitcher();
  
  @Nullable
  public abstract <T> T getKDSPValueWithKey(@NotNull String paramString, T paramT, boolean paramBoolean);
  
  public abstract boolean getKanDianReportTTSwitch();
  
  public abstract int getKandianConfigAdExposureThreshold(@Nullable AppRuntime paramAppRuntime);
  
  public abstract int getKandianConfigBadgeSwitch();
  
  @Nullable
  public abstract Object getKandianLebaViewItem();
  
  @Nullable
  public abstract String getPersonalHomePageWebUrl();
  
  public abstract int getPreplayTimeLimit();
  
  @Nullable
  public abstract String getProteusOfflineBid(@Nullable String paramString);
  
  @NotNull
  public abstract Class<?> getReadInJoyActivityDAUInfo();
  
  public abstract int getReadInJoyMultiVideoChannelInfoVersion();
  
  @Nullable
  public abstract SharedPreferences getReadInJoySP(boolean paramBoolean1, boolean paramBoolean2);
  
  @Nullable
  public abstract SharedPreferences getReadInJoySharedPreferences(int paramInt);
  
  public abstract <T> T getReadInJoySpValue(@Nullable String paramString, T paramT);
  
  public abstract <T> T getReadInJoySpValue(@Nullable String paramString, T paramT, boolean paramBoolean);
  
  public abstract int getReadInjoyShareToWxAtSwitch();
  
  public abstract boolean getReadinjoyStopFunctionSwitch();
  
  public abstract boolean getRemoveKandianFlag();
  
  public abstract boolean getSplasDebugSWitcher();
  
  @Nullable
  public abstract Integer getUserConfigVersion();
  
  public abstract long getVideoRealTimeLogDebug();
  
  public abstract boolean getVideoStructMsgPlaySwitch();
  
  public abstract boolean getViolaDebugSWitcher();
  
  public abstract boolean getViolaJsDebugBundleSwitcher();
  
  public abstract boolean getViolaJsLocalBundleSwitcher();
  
  public abstract boolean getViolaPicDetailConfig();
  
  public abstract boolean getViolaRecommendSwitcher();
  
  public abstract boolean getWebRenderConfig();
  
  public abstract boolean hideKandianTab();
  
  public abstract boolean isColorLevel();
  
  public abstract boolean isDailyChildFeeds(long paramLong);
  
  public abstract boolean isDownloadAsyncIo();
  
  public abstract boolean isEnableUseNewReportChannel();
  
  public abstract boolean isFFProbelistSwitch();
  
  public abstract boolean isFromVideoColumn(int paramInt);
  
  public abstract boolean isInReadInJoyNewFeedsActivity(@Nullable Activity paramActivity);
  
  public abstract boolean isInReadinjoyFolderMergerStyle();
  
  public abstract boolean isInSplashActivity(@Nullable Activity paramActivity);
  
  public abstract boolean isKandianFavourite(@Nullable Activity paramActivity, @Nullable String paramString, int paramInt);
  
  public abstract boolean isOSVersionSupportReadInJoy();
  
  public abstract boolean isRIJVideoEnableReprint();
  
  public abstract boolean isReadInJoyAdHippyFragment(@NotNull Fragment paramFragment);
  
  public abstract boolean isReadInJoyArticleAdapter(@Nullable ListAdapter paramListAdapter);
  
  public abstract boolean isReadInJoyBBCircleFragment(@NotNull Fragment paramFragment);
  
  public abstract boolean isReadInJoyFragmentWithSubChannel(@NotNull Fragment paramFragment);
  
  public abstract boolean isReadInJoyRecommendFeedsFragment(@NotNull Fragment paramFragment);
  
  public abstract boolean isReadInJoySubChannelFragment(@NotNull Fragment paramFragment);
  
  public abstract boolean isReadInJoyViolaChannelFragment(@NotNull Fragment paramFragment);
  
  public abstract boolean isShowKandianRecommendArticleInSubscriptFeeds();
  
  public abstract boolean isShowKandianTab();
  
  public abstract boolean isShowKandianTabNew();
  
  public abstract boolean isShowMainRecommendTab();
  
  public abstract boolean isShowMainVideoTab();
  
  public abstract boolean isShowRecommendReasonInTitle();
  
  public abstract boolean isVideoFeedsTiktokStyle();
  
  public abstract boolean isViolaColumnEntryInTest();
  
  public abstract boolean isViolaMessageBoxInTest();
  
  public abstract boolean isWxArticle(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isWxArticle(@Nullable String paramString);
  
  public abstract void launchReadInJoyPlugin(@Nullable Activity paramActivity, @Nullable Intent paramIntent);
  
  public abstract void maybeInitializedAladdin();
  
  public abstract boolean needUpdateKandianFrame(@Nullable KandianFrameStatus paramKandianFrameStatus, boolean paramBoolean);
  
  public abstract void onKandianFeedsConfigChanged(@Nullable String paramString);
  
  public abstract void onMergeFeedsConfigChanged(@Nullable String paramString);
  
  public abstract void onShareToNewsConfigChanged(@Nullable String paramString);
  
  public abstract void onSynchronizeToQzoneConfigChanged(@Nullable String paramString);
  
  public abstract void preParseArticleJsonParam(@Nullable AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract void reportArticleByWeb(int paramInt1, long paramLong, int paramInt2, int paramInt3);
  
  public abstract void setKanDianReportTTSwitch(boolean paramBoolean);
  
  public abstract void setLastScanTTDate(@Nullable String paramString);
  
  public abstract void setOperationFlag(@Nullable Context paramContext, int paramInt);
  
  public abstract void setUserConfigVersion(int paramInt);
  
  public abstract void synSwitchCache();
  
  public abstract boolean updateArkChannelConfig(@Nullable String paramString);
  
  public abstract void updateCUKingCardDlgSwitch(int paramInt);
  
  public abstract void updateFreeTimeRefreshPush(boolean paramBoolean);
  
  public abstract void updateGallerySubChannelHidden(@Nullable String paramString);
  
  public abstract void updateGallerySubChannelWaterFallHidden(@Nullable String paramString);
  
  public abstract void updateHasSetSwitch(boolean paramBoolean);
  
  public abstract void updateInnerVideoInfoShowSwitcher(boolean paramBoolean);
  
  public abstract void updateKandianConfigDefaultBitRate(@Nullable String paramString);
  
  public abstract void updateKandianConfigRedShowNum(int paramInt);
  
  public abstract void updateKandianConfigRedThreshold(int paramInt);
  
  public abstract boolean updateKandianMyTabPage(@Nullable String paramString);
  
  public abstract boolean updateKandianTabConfigSwitchSp(boolean paramBoolean);
  
  public abstract void updateKandianVideoSocialSwitch(boolean paramBoolean);
  
  public abstract void updateLocalCacheSwitch(int paramInt);
  
  public abstract void updateOpenSimpleSwitchFm(boolean paramBoolean);
  
  public abstract void updateProteusOfflineBid(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void updateRIJVideoEnableReprint(boolean paramBoolean);
  
  public abstract void updateReadInJoyFeedsGroupSetting(@Nullable String paramString);
  
  public abstract void updateReadInJoyIndividualPushSwitchSetting(boolean paramBoolean);
  
  public abstract void updateReadInJoyInterestedPushSwitch(boolean paramBoolean);
  
  public abstract void updateReadInJoyMultiVideoChannelInfo(int paramInt1, @Nullable String paramString, int paramInt2);
  
  public abstract void updateReadInJoyPushMsgSwitch(@Nullable String paramString);
  
  public abstract void updateReadInJoySmartCropSetting(@Nullable String paramString);
  
  public abstract <T> void updateReadInJoySpValue(@Nullable String paramString, T paramT);
  
  public abstract <T> void updateReadInJoySpValue(@Nullable String paramString, T paramT, boolean paramBoolean);
  
  public abstract void updateReadInJoyVideoJumpDefaultValue(int paramInt);
  
  public abstract void updateReadinjoyFolderMergerConfig(@NotNull String paramString);
  
  public abstract void updateReadinjoyFolderMergerReal();
  
  public abstract void updateReadinjoyStopFunctionSwtichReal();
  
  public abstract void updateReadinjoySubscribeListPush(boolean paramBoolean);
  
  public abstract void updateSelfFragmentFeedBackConf(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void updateShowRecommendReasonInTitle(boolean paramBoolean);
  
  public abstract void updateSocialFeedsWebJumpUrl(@Nullable String paramString1, @Nullable String paramString2);
  
  public abstract void updateSplashDebugSwitcher(boolean paramBoolean);
  
  public abstract void updateSupportMultiVideoSwitch(int paramInt);
  
  public abstract void updateSupportMultiVideoSwitch(boolean paramBoolean);
  
  public abstract void updateVideoChannelAutoPlaySwitchDefaultValue(int paramInt);
  
  public abstract void updateVideoChannelAutoPlaySwitchDefaultValueVideoFlow(int paramInt);
  
  public abstract void updateVideoChannelCoverStyle(int paramInt);
  
  public abstract void updateVideoChannelFeedsClickSwitchValue(int paramInt);
  
  public abstract void updateVideoColumnEntrySwitcher(boolean paramBoolean);
  
  public abstract void updateVideoDynamicRecommendDurationPercent(float paramFloat);
  
  public abstract void updateVideoDynamicRecommendOperator(int paramInt);
  
  public abstract void updateVideoDynamicRecommmendDurationLimit(int paramInt);
  
  public abstract void updateVideoDynamicRecommmendStrategy(int paramInt);
  
  public abstract void updateVideoMessageBoxSwitcher(boolean paramBoolean);
  
  public abstract void updateVideoRealTimeLogDebug();
  
  public abstract void updateVideoStructMsgPlaySwitch(boolean paramBoolean);
  
  public abstract void updateViolaDebugSwitcher(boolean paramBoolean);
  
  public abstract void updateViolaDiscoverConfig(int paramInt);
  
  public abstract void updateViolaDynamicConfig(int paramInt);
  
  public abstract void updateViolaJsDebugBundleSwitcher(boolean paramBoolean);
  
  public abstract void updateViolaJsLocalBundleSwitcher(boolean paramBoolean);
  
  public abstract void updateViolaMessageBoxConfig(int paramInt);
  
  public abstract void updateViolaRecommendSwitcher(boolean paramBoolean);
  
  public abstract void updateViolaWeishiAdConfig(int paramInt);
  
  public abstract void updateWebRenderConfig(int paramInt);
  
  public abstract void updateWebRenderModeConfig(int paramInt);
  
  public abstract boolean use0xcbaRefreshCmd();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyHelper
 * JD-Core Version:    0.7.0.1
 */