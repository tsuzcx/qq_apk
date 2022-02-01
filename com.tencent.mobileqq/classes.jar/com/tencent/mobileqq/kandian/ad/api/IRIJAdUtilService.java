package com.tencent.mobileqq.kandian.ad.api;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.data.AdReportExtData;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.NativeAd.data.BannerInfo;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.IVideoCardUIModel;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PhoneInfo;

@QAPI(process={"all"})
public abstract interface IRIJAdUtilService
  extends QRouteApi
{
  public abstract void addGameGift(String paramString, long paramLong);
  
  public abstract void addGdtWebClickReport(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract String addHeadForUrl(String paramString, boolean paramBoolean);
  
  public abstract void allowFastWebAdRequestToFormalNets();
  
  public abstract void bindAdColorIcon(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject);
  
  public abstract void bindAdSourceTag(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject);
  
  public abstract void bindAdStatus(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject);
  
  public abstract void bindAtmosphere(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject);
  
  public abstract void bindBubble(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject);
  
  public abstract void bindDownloadAdStar(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject);
  
  public abstract void bindEducationAd(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject);
  
  public abstract void bindLargeImgStyleID(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject);
  
  public abstract void bindPkButton(JSONObject paramJSONObject, AdvertisementExtInfo paramAdvertisementExtInfo);
  
  public abstract void bindSourceText(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject);
  
  public abstract void bindVideoStyleID(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject);
  
  public abstract JSONObject buildAppFuncExtInfo(Context paramContext, AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject);
  
  public abstract boolean checkConditionForJumpToGdt(AdvertisementInfo paramAdvertisementInfo, int paramInt);
  
  public abstract void closeFilterPatchAdReq();
  
  public abstract void closeRoundDownloadProgress();
  
  public abstract void closeSuperMaskSwitch();
  
  public abstract Dialog createDialog(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, String paramString3, View.OnClickListener paramOnClickListener2, String paramString4);
  
  public abstract void disAllowFastWebAdRequestToFormalNets();
  
  public abstract String distance2String(double paramDouble);
  
  public abstract void doADVideoItemDelegateOnResume(IVideoFeedsItemUIDelegate paramIVideoFeedsItemUIDelegate);
  
  public abstract void doADVideoItemHolderOnPause(VideoItemHolder paramVideoItemHolder);
  
  public abstract void doADVideoItemHolderOnResume(VideoItemHolder paramVideoItemHolder);
  
  public abstract void doAdReport(Object paramObject, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void doGdtWebClickReport();
  
  public abstract void downloadApk(Activity paramActivity, BannerInfo paramBannerInfo, Object paramObject);
  
  public abstract void fillPatchParams(AdRequestData paramAdRequestData, JSONObject paramJSONObject, int paramInt);
  
  public abstract void fillSocialParams(AdRequestData paramAdRequestData, JSONObject paramJSONObject, int paramInt);
  
  public abstract void fillSuperMaskFlag(AdRequestData paramAdRequestData, int paramInt);
  
  public abstract void fillSuperMaskParams(AdRequestData paramAdRequestData, JSONObject paramJSONObject, int paramInt1, int paramInt2);
  
  public abstract void fillTimeLoadParams(AdRequestData paramAdRequestData, JSONObject paramJSONObject);
  
  public abstract String generateVid(String paramString);
  
  public abstract double getADDistanceByPos(double[] paramArrayOfDouble, Context paramContext);
  
  public abstract String getADPosition(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, String paramString1, String paramString2);
  
  public abstract Object getADVideoAppDownloadData(Object paramObject);
  
  public abstract View getAdBottomRecommendFromADVideoItemHolder(Object paramObject);
  
  public abstract ShapeDrawable getAdBox(int paramInt, Context paramContext);
  
  public abstract String getAdCookie();
  
  public abstract JSONObject getAdDataBusiJson(Object paramObject);
  
  public abstract String getAdvertisementInfoNickName(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract MobileQQ getApplication();
  
  public abstract int getBigAppAdStyle(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract int getBigPicAdapterType(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract Bitmap getBitmap(String paramString, int paramInt1, int paramInt2);
  
  public abstract JSONObject getBusiJson(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract JSONObject getBusiJson(AdvertisementInfo paramAdvertisementInfo, HashMap<String, Object> paramHashMap);
  
  public abstract JSONObject getBusiJson(AdData paramAdData);
  
  public abstract JSONObject getBusiJson(AdData paramAdData, HashMap<String, Object> paramHashMap);
  
  public abstract JSONObject getBusiJson(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap<String, Object> paramHashMap);
  
  public abstract JSONObject getBusiJson(HashMap<String, Object> paramHashMap);
  
  public abstract int getClickPos(int paramInt);
  
  public abstract int getFeedsAdStyle(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract String getFormatNum(long paramLong, String paramString);
  
  public abstract String getGamePkgName(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract int getGameType(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract int getGdtCarrierCode();
  
  public abstract String getIMEI();
  
  public abstract boolean getIfAllowFastWebAdRequestToFormalNets();
  
  public abstract boolean getIfOpenFilterPatchAdReq();
  
  public abstract boolean getIfOpenRoundDownloadProgress();
  
  public abstract boolean getIfOpenSuperMaskSwitch();
  
  public abstract double[] getLocationInfoPos(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract String getMAC();
  
  public abstract int getNativeAdExposureOrigin(AdData paramAdData);
  
  public abstract String getPatchAdButtonText(Context paramContext, AdvertisementInfo paramAdvertisementInfo);
  
  public abstract int getSmallGameReportType(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract String getStarUrl(float paramFloat, int paramInt);
  
  public abstract IVideoCardUIModel getVideoCardUIModel(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract JSONObject getVideoInfoObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ReportConstants.VideoEndType paramVideoEndType);
  
  public abstract JSONObject getVideoInfoObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ReportConstants.VideoEndType paramVideoEndType, boolean paramBoolean);
  
  public abstract JSONObject getVideoInfoObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ReportConstants.VideoEndType paramVideoEndType, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract boolean getVideoInfoRowKey(VideoAdInfo paramVideoAdInfo);
  
  public abstract String getVideoInfoSoftAdExpoStatKey(VideoInfo paramVideoInfo);
  
  public abstract boolean hasAddLocationInfo(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean hasColorIcon(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean installApk(BannerInfo paramBannerInfo);
  
  public abstract boolean instanceOfADVideoItemDelegate(IVideoFeedsItemUIDelegate paramIVideoFeedsItemUIDelegate);
  
  public abstract boolean instanceOfADVideoItemHolder(Object paramObject);
  
  public abstract boolean instanceOfRecommendAdData(Object paramObject);
  
  public abstract boolean isADVideoWithURL(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isAdExpandLivePicCard(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isAdExpandLiveVideoCard(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isAdExpandPicCard(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isAdInteractType(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean isAdProteusView(int paramInt);
  
  public abstract boolean isAdvertisementInfo(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isAmsSubscribeAd(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean isAmsSubscribeAd(VideoAdInfo paramVideoAdInfo);
  
  public abstract boolean isAppAdvertisementInfo(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isAppExist(Context paramContext, String paramString);
  
  public abstract boolean isAppInstall(Context paramContext, String paramString);
  
  public abstract boolean isAppInstall(String paramString);
  
  public abstract boolean isBrandOptimizationAdType(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean isChannelCanRequstAd(int paramInt);
  
  public abstract boolean isClickBtn(int paramInt);
  
  public abstract boolean isClickStateInVideoMode(Object paramObject);
  
  public abstract boolean isDownloadAd(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean isEducationLargeImgAd(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isEducationLargeVideoAd(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isFromAms(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean isGameComponentType(AdData paramAdData);
  
  public abstract boolean isGameDownloadAd(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean isGameGiftAd(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean isGameSubscribeAd(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean isMiniGame185(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isMiniGame285(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isMiniGame65(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isMiniGameAdCardHorzi(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isMiniGameAdCardType(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isMiniGameArticleCard(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isMiniGameDoubleVideo(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isMiniGameDoubleVideoSingle(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isMiniGameNewStyle(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isNoXtabExpandAd(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isPkAdType(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract int isPkgDownloading(Context paramContext, BannerInfo paramBannerInfo);
  
  public abstract boolean isPkgExistSyn(Context paramContext, String paramString);
  
  public abstract boolean isRepeatedValid(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean isSoftDownloadAd(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean isSuperBackgroundAdType(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract boolean isUgcAd(AbsBaseArticleInfo paramAbsBaseArticleInfo);
  
  public abstract boolean isVisibleRect(Rect paramRect);
  
  public abstract void jumpToMiniGame(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt);
  
  public abstract boolean jumpToMiniGameHippyTab(Context paramContext, String paramString, int paramInt);
  
  public abstract boolean launch(Context paramContext, String paramString);
  
  public abstract void launchApp(Context paramContext, String paramString);
  
  public abstract oidb_0x6cf.PhoneInfo makePhoneInfo();
  
  public abstract boolean openApp(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo);
  
  public abstract void openFilterPatchAdReq();
  
  public abstract void openRoundDownloadProgress();
  
  public abstract void openSuperMaskSwitch();
  
  public abstract void preLoadAdForMiniProgram(AdvertisementInfo paramAdvertisementInfo);
  
  public abstract void preLoadAdForMiniProgramInVideos(VideoAdInfo paramVideoAdInfo);
  
  public abstract void reportGameGiftClick(AdvertisementInfo paramAdvertisementInfo, int paramInt, String paramString);
  
  public abstract void reportGetPackage(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void reportMiniGameAd(Context paramContext, AdReportExtData paramAdReportExtData);
  
  public abstract void reportMiniGameFromArticle(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2);
  
  public abstract void reportMiniGameFromRecommendCard(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void reportMiniGameGuideFollow(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public abstract void reportNativeEngineAdClick(Object paramObject, AdData paramAdData, Integer paramInteger);
  
  public abstract void reportNativeEngineAdExposure(Object paramObject, AdData paramAdData, boolean paramBoolean);
  
  public abstract void reportNativeEngineAdExposureExtra(Object paramObject, int paramInt, AdvertisementInfo paramAdvertisementInfo, float paramFloat, long paramLong);
  
  public abstract void reportNativeEngineAdExposureExtra(Object paramObject, AdData paramAdData, float paramFloat, long paramLong, boolean paramBoolean);
  
  public abstract void reportNativeEngineInvalidAdExposure(Object paramObject, AdData paramAdData);
  
  public abstract List<GiftServiceBean> requestRole(String paramString1, String paramString2, String paramString3, String paramString4);
  
  public abstract void resetClickStateInVideoMode(Object paramObject);
  
  public abstract void saveAdCookie(String paramString);
  
  public abstract Pair<Boolean, String> sendGiftPackage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  public abstract void setAdInfoClickPos(AdvertisementInfo paramAdvertisementInfo, int paramInt, Object paramObject);
  
  public abstract void showVideoAdToast(BaseItemHolder paramBaseItemHolder, String paramString);
  
  public abstract void unRegisterGDTReceiver();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService
 * JD-Core Version:    0.7.0.1
 */