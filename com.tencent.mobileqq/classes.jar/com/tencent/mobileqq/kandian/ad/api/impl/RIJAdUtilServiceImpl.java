package com.tencent.mobileqq.kandian.ad.api.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.data.AdReportExtData;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.NativeAd.data.BannerInfo;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.NativeAd.util.ADBaseAppDownloadManager;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHardAdBarManager;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemDelegate;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.ADVideoItemHolder;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdAppDownloadInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.GiftServiceBean;
import com.tencent.biz.pubaccount.readinjoyAd.ad.diversion.DiversionManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.diversion.DiversionUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.ext.AdRequestExtKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.manager.GiftPackageManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.SuperMaskExtKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdClickPosUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdDeviceInfoUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoButtonUIUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ProteusSupportAdUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdGradeUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSettingUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdSwitchUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.video.ADVideoAppDownloadData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdActionUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.biz.ad.entity.VideoAdInfo;
import com.tencent.mobileqq.kandian.biz.detail.web.api.IFastWebRequestUtil;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsItemUIDelegate;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.api.IVideoFeedsPlayManager;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.BaseItemHolder;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.viewholder.VideoItemHolder;
import com.tencent.mobileqq.kandian.repo.feeds.api.IVideoCardUIModelFactory;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.video.IVideoCardUIModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.HashMap;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.PhoneInfo;

public class RIJAdUtilServiceImpl
  implements IRIJAdUtilService
{
  public void addGameGift(String paramString, long paramLong)
  {
    GiftPackageManager.a(paramString, paramLong);
  }
  
  public void addGdtWebClickReport(AdvertisementInfo paramAdvertisementInfo)
  {
    ReadInJoyAdUtils.q(paramAdvertisementInfo);
  }
  
  public String addHeadForUrl(String paramString, boolean paramBoolean)
  {
    return ((IFastWebRequestUtil)QRoute.api(IFastWebRequestUtil.class)).addHeadForUrl(paramString, paramBoolean);
  }
  
  public void allowFastWebAdRequestToFormalNets() {}
  
  public void bindAdColorIcon(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    ReadInJoyAdUtils.h(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindAdSourceTag(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    ReadInJoyAdUtils.j(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindAdStatus(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    ReadInJoyAdUtils.g(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindAtmosphere(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    ReadInJoyAdUtils.c(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindBubble(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    ReadInJoyAdUtils.b(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindDownloadAdStar(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    ReadInJoyAdUtils.i(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindEducationAd(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    ReadInJoyAdUtils.f(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindLargeImgStyleID(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    ReadInJoyAdUtils.d(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindPkButton(JSONObject paramJSONObject, AdvertisementExtInfo paramAdvertisementExtInfo)
  {
    ReadInJoyAdUtils.a(paramJSONObject, paramAdvertisementExtInfo);
  }
  
  public void bindSourceText(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    ReadInJoyAdUtils.a(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public void bindVideoStyleID(AbsBaseArticleInfo paramAbsBaseArticleInfo, JSONObject paramJSONObject)
  {
    ReadInJoyAdUtils.e(paramAbsBaseArticleInfo, paramJSONObject);
  }
  
  public JSONObject buildAppFuncExtInfo(Context paramContext, AdvertisementInfo paramAdvertisementInfo, JSONObject paramJSONObject)
  {
    return ReadInJoyAdUtils.a(paramContext, paramAdvertisementInfo, paramJSONObject);
  }
  
  public boolean checkConditionForJumpToGdt(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    return ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).checkConditionForJumpToGdt(paramAdvertisementInfo, paramInt);
  }
  
  public void closeFilterPatchAdReq() {}
  
  public void closeRoundDownloadProgress() {}
  
  public void closeSuperMaskSwitch() {}
  
  public Dialog createDialog(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, String paramString3, View.OnClickListener paramOnClickListener2, String paramString4)
  {
    return NativeAdUtils.a(paramContext, paramString1, paramString2, paramOnClickListener1, paramString3, paramOnClickListener2, paramString4);
  }
  
  public void disAllowFastWebAdRequestToFormalNets() {}
  
  public String distance2String(double paramDouble)
  {
    return NativeAdUtils.a(paramDouble);
  }
  
  public void doADVideoItemDelegateOnResume(IVideoFeedsItemUIDelegate paramIVideoFeedsItemUIDelegate)
  {
    ((ADVideoItemDelegate)paramIVideoFeedsItemUIDelegate).b();
  }
  
  public void doADVideoItemHolderOnPause(VideoItemHolder paramVideoItemHolder)
  {
    paramVideoItemHolder = (ADVideoItemHolder)paramVideoItemHolder;
    if (paramVideoItemHolder.U != null) {
      paramVideoItemHolder.U.b();
    }
    if (paramVideoItemHolder.V != null) {
      paramVideoItemHolder.V.b();
    }
  }
  
  public void doADVideoItemHolderOnResume(VideoItemHolder paramVideoItemHolder)
  {
    paramVideoItemHolder = (ADVideoItemHolder)paramVideoItemHolder;
    if (paramVideoItemHolder.U != null) {
      paramVideoItemHolder.U.a();
    }
    if (paramVideoItemHolder.V != null) {
      paramVideoItemHolder.V.a();
    }
  }
  
  public void doAdReport(Object paramObject, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    NativeAdUtils.a((QQAppInterface)paramObject, paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3);
  }
  
  public void doGdtWebClickReport() {}
  
  public void downloadApk(Activity paramActivity, BannerInfo paramBannerInfo, Object paramObject)
  {
    NativeAdUtils.a(paramActivity, paramBannerInfo, (DownloadListener)paramObject);
  }
  
  public void fillPatchParams(AdRequestData paramAdRequestData, JSONObject paramJSONObject, int paramInt)
  {
    AdRequestExtKt.a(paramAdRequestData, paramJSONObject, paramInt);
  }
  
  public void fillSocialParams(AdRequestData paramAdRequestData, JSONObject paramJSONObject, int paramInt)
  {
    AdRequestExtKt.b(paramAdRequestData, paramJSONObject, paramInt);
  }
  
  public void fillSuperMaskFlag(AdRequestData paramAdRequestData, int paramInt)
  {
    SuperMaskExtKt.a(paramAdRequestData, paramInt);
  }
  
  public void fillSuperMaskParams(AdRequestData paramAdRequestData, JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    AdRequestExtKt.a(paramAdRequestData, paramJSONObject, paramInt1, paramInt2);
  }
  
  public void fillTimeLoadParams(AdRequestData paramAdRequestData, JSONObject paramJSONObject)
  {
    AdRequestExtKt.a(paramAdRequestData, paramJSONObject);
  }
  
  public String generateVid(String paramString)
  {
    return NativeAdUtils.b(paramString);
  }
  
  public double getADDistanceByPos(double[] paramArrayOfDouble, Context paramContext)
  {
    return NativeAdUtils.a(paramArrayOfDouble, paramContext);
  }
  
  public String getADPosition(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, String paramString1, String paramString2)
  {
    return NativeAdUtils.a(paramAbsBaseArticleInfo, paramContext, paramString1, paramString2);
  }
  
  public ADVideoAppDownloadData getADVideoAppDownloadData(Object paramObject)
  {
    paramObject = (AdData)paramObject;
    if ((paramObject != null) && (paramObject.an != null))
    {
      ADVideoAppDownloadData localADVideoAppDownloadData = new ADVideoAppDownloadData();
      if (paramObject.j())
      {
        Object localObject = paramObject.aE.opt("extendInfo");
        if ((localObject instanceof JSONObject))
        {
          localObject = (JSONObject)localObject;
          localADVideoAppDownloadData.a = ((JSONObject)localObject).optString("game_app_id");
          localADVideoAppDownloadData.b = ((JSONObject)localObject).optString("game_apk_url");
          localADVideoAppDownloadData.d = ((JSONObject)localObject).optString("game_pkg_name");
          localADVideoAppDownloadData.e = ((JSONObject)localObject).optString("game_app_name");
          localADVideoAppDownloadData.c = ((JSONObject)localObject).optString("game_apk_url");
          localADVideoAppDownloadData.q = paramObject.aE.optString("button");
        }
      }
      else
      {
        localADVideoAppDownloadData.a = paramObject.an.c;
        localADVideoAppDownloadData.b = paramObject.an.a;
        localADVideoAppDownloadData.d = paramObject.an.b;
        localADVideoAppDownloadData.e = paramObject.an.d;
        localADVideoAppDownloadData.c = paramObject.an.e;
        if (isGameComponentType(paramObject))
        {
          localADVideoAppDownloadData.l = true;
          if (paramObject.as != null) {
            localADVideoAppDownloadData.q = paramObject.as.m;
          }
        }
        else if (paramObject.j != null)
        {
          localADVideoAppDownloadData.q = paramObject.j.mAdBtnTxt;
        }
      }
      localADVideoAppDownloadData.g = 0;
      localADVideoAppDownloadData.f = 0;
      localADVideoAppDownloadData.o = paramObject;
      if (!TextUtils.isEmpty(paramObject.L)) {
        localADVideoAppDownloadData.h = paramObject.L;
      }
      localADVideoAppDownloadData.i = paramObject.au;
      localADVideoAppDownloadData.j = paramObject.at;
      localADVideoAppDownloadData.n = paramObject.aq;
      return localADVideoAppDownloadData;
    }
    return null;
  }
  
  public View getAdBottomRecommendFromADVideoItemHolder(Object paramObject)
  {
    return ((ADVideoItemHolder)paramObject).f;
  }
  
  public ShapeDrawable getAdBox(int paramInt, Context paramContext)
  {
    return ReadInJoyAdUtils.a(paramInt, paramContext);
  }
  
  public String getAdCookie()
  {
    return NativeAdUtils.b();
  }
  
  public JSONObject getAdDataBusiJson(Object paramObject)
  {
    return NativeAdUtils.b((AdData)paramObject);
  }
  
  public String getAdvertisementInfoNickName(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.a(paramAbsBaseArticleInfo);
  }
  
  public MobileQQ getApplication()
  {
    return BaseApplicationImpl.getApplication();
  }
  
  public int getBigAppAdStyle(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdUtils.s(paramAdvertisementInfo);
  }
  
  public int getBigPicAdapterType(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdUtils.p(paramAdvertisementInfo);
  }
  
  public Bitmap getBitmap(String paramString, int paramInt1, int paramInt2)
  {
    return ReadInJoyAdUtils.a(paramString, paramInt1, paramInt2);
  }
  
  public JSONObject getBusiJson(AdvertisementInfo paramAdvertisementInfo)
  {
    return NativeAdUtils.b(paramAdvertisementInfo);
  }
  
  public JSONObject getBusiJson(AdvertisementInfo paramAdvertisementInfo, HashMap<String, Object> paramHashMap)
  {
    return NativeAdUtils.a(paramAdvertisementInfo, paramHashMap);
  }
  
  public JSONObject getBusiJson(AdData paramAdData)
  {
    return NativeAdUtils.b(paramAdData);
  }
  
  public JSONObject getBusiJson(AdData paramAdData, HashMap<String, Object> paramHashMap)
  {
    return NativeAdUtils.a(paramAdData, paramHashMap);
  }
  
  public JSONObject getBusiJson(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap<String, Object> paramHashMap)
  {
    return NativeAdUtils.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramHashMap);
  }
  
  public JSONObject getBusiJson(HashMap<String, Object> paramHashMap)
  {
    return NativeAdUtils.a(paramHashMap);
  }
  
  public int getClickPos(int paramInt)
  {
    return AdClickPosUtil.a(paramInt);
  }
  
  public int getFeedsAdStyle(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdSwitchUtil.c(paramAdvertisementInfo);
  }
  
  public String getFormatNum(long paramLong, String paramString)
  {
    return ReadInJoyAdUtils.a(paramLong, paramString);
  }
  
  public String getGamePkgName(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdUtils.d(paramAdvertisementInfo);
  }
  
  public int getGameType(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdUtils.c(paramAdvertisementInfo);
  }
  
  public int getGdtCarrierCode()
  {
    return AdDeviceInfoUtil.f();
  }
  
  public String getGdtIMEI()
  {
    return AdDeviceInfoUtil.b();
  }
  
  public String getIMEI()
  {
    return AdDeviceInfoUtil.a();
  }
  
  public boolean getIfAllowFastWebAdRequestToFormalNets()
  {
    return ReadInJoyAdSettingUtil.c();
  }
  
  public boolean getIfOpenFilterPatchAdReq()
  {
    return ReadInJoyAdSettingUtil.l();
  }
  
  public boolean getIfOpenRoundDownloadProgress()
  {
    return ReadInJoyAdSettingUtil.i();
  }
  
  public boolean getIfOpenSuperMaskSwitch()
  {
    return ReadInJoyAdSettingUtil.f();
  }
  
  public double[] getLocationInfoPos(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return NativeAdUtils.b(paramAbsBaseArticleInfo);
  }
  
  public String getMAC()
  {
    return AdDeviceInfoUtil.d();
  }
  
  public int getNativeAdExposureOrigin(AdData paramAdData)
  {
    return NativeAdUtils.a(paramAdData);
  }
  
  public String getPatchAdButtonText(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdUtils.a(paramContext, paramAdvertisementInfo);
  }
  
  public int getSmallGameReportType(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.o(paramAbsBaseArticleInfo);
  }
  
  public String getStarUrl(float paramFloat, int paramInt)
  {
    return ReadInJoyAdGradeUtil.a(paramFloat, paramInt);
  }
  
  public IVideoCardUIModel getVideoCardUIModel(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ((IVideoCardUIModelFactory)QRoute.api(IVideoCardUIModelFactory.class)).createModel(paramAbsBaseArticleInfo);
  }
  
  public JSONObject getVideoInfoObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ReportConstants.VideoEndType paramVideoEndType)
  {
    return NativeAdUtils.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramVideoEndType);
  }
  
  public JSONObject getVideoInfoObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ReportConstants.VideoEndType paramVideoEndType, boolean paramBoolean)
  {
    return NativeAdUtils.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramVideoEndType, paramBoolean);
  }
  
  public JSONObject getVideoInfoObject(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ReportConstants.VideoEndType paramVideoEndType, boolean paramBoolean1, boolean paramBoolean2)
  {
    return NativeAdUtils.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramVideoEndType, paramBoolean1, paramBoolean2);
  }
  
  public boolean getVideoInfoRowKey(VideoAdInfo paramVideoAdInfo)
  {
    return ReadInJoyAdUtils.b(paramVideoAdInfo);
  }
  
  public String getVideoInfoSoftAdExpoStatKey(VideoInfo paramVideoInfo)
  {
    if ((paramVideoInfo != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo) != null) && (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo != null)) {
      return ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdvertisementSoftInfo.ad;
    }
    return "";
  }
  
  public String getWxVersionName(Context paramContext)
  {
    return AdDeviceInfoUtil.a(paramContext);
  }
  
  public boolean hasAddLocationInfo(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return NativeAdUtils.a(paramAbsBaseArticleInfo);
  }
  
  public boolean hasColorIcon(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.d(paramAbsBaseArticleInfo);
  }
  
  public boolean installApk(BannerInfo paramBannerInfo)
  {
    return NativeAdUtils.a(paramBannerInfo);
  }
  
  public boolean instanceOfADVideoItemDelegate(IVideoFeedsItemUIDelegate paramIVideoFeedsItemUIDelegate)
  {
    return paramIVideoFeedsItemUIDelegate instanceof ADVideoItemDelegate;
  }
  
  public boolean instanceOfADVideoItemHolder(Object paramObject)
  {
    return paramObject instanceof ADVideoItemHolder;
  }
  
  public boolean instanceOfRecommendAdData(Object paramObject)
  {
    return paramObject instanceof RecommendAdData;
  }
  
  public boolean isADVideoWithURL(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.p(paramAbsBaseArticleInfo);
  }
  
  public boolean isAdExpandLivePicCard(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.u(paramAbsBaseArticleInfo);
  }
  
  public boolean isAdExpandLiveVideoCard(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.t(paramAbsBaseArticleInfo);
  }
  
  public boolean isAdExpandPicCard(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.v(paramAbsBaseArticleInfo);
  }
  
  public boolean isAdInteractType(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdUtils.e(paramAdvertisementInfo);
  }
  
  public boolean isAdProteusView(int paramInt)
  {
    return ProteusSupportAdUtil.a(paramInt);
  }
  
  public boolean isAdShakeVideoCard(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.x(paramAbsBaseArticleInfo);
  }
  
  public boolean isAdSmallVideo(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.z(paramAbsBaseArticleInfo);
  }
  
  public boolean isAdSurpriseVideoCard(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.w(paramAbsBaseArticleInfo);
  }
  
  public boolean isAdvertisementInfo(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.r(paramAbsBaseArticleInfo);
  }
  
  public boolean isAmsSubscribeAd(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdUtils.b(paramAdvertisementInfo);
  }
  
  public boolean isAmsSubscribeAd(VideoAdInfo paramVideoAdInfo)
  {
    return VideoFeedsHardAdBarManager.a(paramVideoAdInfo);
  }
  
  public boolean isAppAdvertisementInfo(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.s(paramAbsBaseArticleInfo);
  }
  
  public boolean isAppExist(Context paramContext, String paramString)
  {
    return AdReportUtil.a(paramContext, paramString);
  }
  
  public boolean isAppInstall(Context paramContext, String paramString)
  {
    return NativeAdUtils.a(paramContext, paramString);
  }
  
  public boolean isAppInstall(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return isAppInstall(BaseApplicationImpl.getContext(), paramString);
  }
  
  public boolean isBrandOptimizationAdType(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdUtils.k(paramAdvertisementInfo);
  }
  
  public boolean isChannelCanRequstAd(int paramInt)
  {
    return ReadInJoyAdUtils.a(paramInt);
  }
  
  public boolean isClickBtn(int paramInt)
  {
    return NativeAdUtils.a(paramInt);
  }
  
  public boolean isClickStateInVideoMode(Object paramObject)
  {
    return ReadInJoyAdUtils.a((VideoPlayParam)paramObject);
  }
  
  public boolean isDownloadAd(AdvertisementInfo paramAdvertisementInfo)
  {
    return RIJAdDownloadExKt.b(paramAdvertisementInfo);
  }
  
  public boolean isEducationLargeImgAd(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.b(paramAbsBaseArticleInfo);
  }
  
  public boolean isEducationLargeVideoAd(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.c(paramAbsBaseArticleInfo);
  }
  
  public boolean isFromAms(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdUtils.r(paramAdvertisementInfo);
  }
  
  public boolean isGameComponentType(AdData paramAdData)
  {
    return FastWeqAdUtils.a(paramAdData);
  }
  
  public boolean isGameDownloadAd(AdvertisementInfo paramAdvertisementInfo)
  {
    return RIJAdDownloadExKt.e(paramAdvertisementInfo);
  }
  
  public boolean isGameGiftAd(AdvertisementInfo paramAdvertisementInfo)
  {
    return RIJAdDownloadExKt.g(paramAdvertisementInfo);
  }
  
  public boolean isGameSubscribeAd(AdvertisementInfo paramAdvertisementInfo)
  {
    return RIJAdDownloadExKt.f(paramAdvertisementInfo);
  }
  
  public boolean isMiniGame185(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.i(paramAbsBaseArticleInfo);
  }
  
  public boolean isMiniGame285(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.h(paramAbsBaseArticleInfo);
  }
  
  public boolean isMiniGame65(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.k(paramAbsBaseArticleInfo);
  }
  
  public boolean isMiniGameAdCardHorzi(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.g(paramAbsBaseArticleInfo);
  }
  
  public boolean isMiniGameAdCardType(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.f(paramAbsBaseArticleInfo);
  }
  
  public boolean isMiniGameArticleCard(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.n(paramAbsBaseArticleInfo);
  }
  
  public boolean isMiniGameDoubleVideo(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.l(paramAbsBaseArticleInfo);
  }
  
  public boolean isMiniGameDoubleVideoSingle(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.m(paramAbsBaseArticleInfo);
  }
  
  public boolean isMiniGameNewStyle(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.j(paramAbsBaseArticleInfo);
  }
  
  public boolean isNoXtabExpandAd(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyAdUtils.y(paramAbsBaseArticleInfo);
  }
  
  public boolean isPkAdType(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdUtils.i(paramAdvertisementInfo);
  }
  
  public int isPkgDownloading(Context paramContext, BannerInfo paramBannerInfo)
  {
    return NativeAdUtils.a(paramContext, paramBannerInfo);
  }
  
  public boolean isPkgExistSyn(Context paramContext, String paramString)
  {
    return ADBaseAppDownloadManager.a(paramContext, paramString);
  }
  
  public boolean isRepeatedValid(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdUtils.f(paramAdvertisementInfo);
  }
  
  public boolean isSoftDownloadAd(AdvertisementInfo paramAdvertisementInfo)
  {
    return RIJAdDownloadExKt.d(paramAdvertisementInfo);
  }
  
  public boolean isSuperBackgroundAdType(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyAdUtils.j(paramAdvertisementInfo);
  }
  
  public boolean isUgcAd(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).isUgcAd(paramAbsBaseArticleInfo);
  }
  
  public boolean isVisibleRect(Rect paramRect)
  {
    return ReadInJoyAdUtils.a(paramRect);
  }
  
  public void jumpToMiniGame(AbsBaseArticleInfo paramAbsBaseArticleInfo, Context paramContext, int paramInt)
  {
    ReadInJoyAdUtils.a(paramAbsBaseArticleInfo, paramContext, paramInt);
  }
  
  public boolean jumpToMiniGameHippyTab(Context paramContext, String paramString, int paramInt)
  {
    return ReadInJoyAdUtils.a(paramContext, paramString, paramInt);
  }
  
  public boolean launch(Context paramContext, String paramString)
  {
    return ReadInJoyAdUtils.a(paramContext, paramString);
  }
  
  public void launchApp(Context paramContext, String paramString)
  {
    NativeAdUtils.b(paramContext, paramString);
  }
  
  public void loadImage(URLImageView paramURLImageView, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, Activity paramActivity)
  {
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      if (paramInt4 != -1) {
        localURLDrawableOptions.mUseMemoryCache = false;
      }
      localURLDrawableOptions.mRequestWidth = AIOUtils.b(paramInt2, paramActivity.getResources());
      localURLDrawableOptions.mRequestHeight = AIOUtils.b(paramInt3, paramActivity.getResources());
      paramActivity = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      if (paramInt4 == 0)
      {
        paramActivity.setTag(URLDrawableDecodeHandler.a(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight));
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.k);
        paramActivity.setTag(new int[] { 0, 0, paramInt1, 1 });
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.k);
      }
      else if (paramInt4 == 1)
      {
        paramActivity.setTag(URLDrawableDecodeHandler.a(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight));
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.k);
        paramActivity.setTag(new int[] { 0, 0, paramInt1, 3 });
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.k);
      }
      else
      {
        paramActivity.setTag(URLDrawableDecodeHandler.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, paramInt1));
        paramActivity.setDecodeHandler(URLDrawableDecodeHandler.j);
      }
      paramURLImageView.setImageDrawable(paramActivity);
      return;
    }
    catch (Exception paramURLImageView)
    {
      label231:
      break label231;
    }
    if (QLog.isColorLevel())
    {
      paramURLImageView = new StringBuilder();
      paramURLImageView.append("后台下发的url格式有问题：");
      paramURLImageView.append(paramString);
      QLog.d("RIJAdUtilServiceImpl", 2, paramURLImageView.toString());
    }
  }
  
  public oidb_0x6cf.PhoneInfo makePhoneInfo()
  {
    return AdDeviceInfoUtil.g();
  }
  
  public boolean openApp(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    return RIJAdDownloadUtil.a.a(paramActivity, paramAdvertisementInfo);
  }
  
  public void openFilterPatchAdReq() {}
  
  public void openRoundDownloadProgress() {}
  
  public void openSuperMaskSwitch() {}
  
  public void preLoadAdForMiniProgram(AdvertisementInfo paramAdvertisementInfo)
  {
    ReadInJoyAdUtils.h(paramAdvertisementInfo);
  }
  
  public void preLoadAdForMiniProgramInVideos(VideoAdInfo paramVideoAdInfo)
  {
    ReadInJoyAdUtils.a(paramVideoAdInfo);
  }
  
  public void reportGameGiftClick(AdvertisementInfo paramAdvertisementInfo, int paramInt, String paramString)
  {
    GameComponentReport.a(paramAdvertisementInfo, paramInt, paramString);
  }
  
  public void reportGetPackage(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4)
  {
    GiftPackageManager.a(paramInt1, paramString1, paramString2, paramInt2, paramInt3, paramInt4);
  }
  
  public void reportMiniGameAd(Context paramContext, AdReportExtData paramAdReportExtData)
  {
    NativeAdUtils.a(paramContext, paramAdReportExtData);
  }
  
  public void reportMiniGameFromArticle(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2)
  {
    NativeAdUtils.a(paramContext, paramAbsBaseArticleInfo, paramInt1, paramInt2);
  }
  
  public void reportMiniGameFromRecommendCard(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    NativeAdUtils.a(paramContext, paramAbsBaseArticleInfo, paramInt1, paramInt2, paramInt3);
  }
  
  public void reportMiniGameGuideFollow(Context paramContext, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    NativeAdUtils.a(paramContext, paramAbsBaseArticleInfo, paramInt1, paramInt2, paramBoolean);
  }
  
  public void reportNativeEngineAdClick(Object paramObject, AdData paramAdData, Integer paramInteger)
  {
    NativeAdUtils.a((QQAppInterface)paramObject, paramAdData, paramInteger);
  }
  
  public void reportNativeEngineAdExposure(Object paramObject, AdData paramAdData, boolean paramBoolean)
  {
    NativeAdUtils.a((QQAppInterface)paramObject, paramAdData, paramBoolean);
  }
  
  public void reportNativeEngineAdExposureExtra(Object paramObject, int paramInt, AdvertisementInfo paramAdvertisementInfo, float paramFloat, long paramLong)
  {
    NativeAdUtils.a((QQAppInterface)paramObject, paramInt, paramAdvertisementInfo, paramFloat, paramLong);
  }
  
  public void reportNativeEngineAdExposureExtra(Object paramObject, AdData paramAdData, float paramFloat, long paramLong, boolean paramBoolean)
  {
    NativeAdUtils.a((QQAppInterface)paramObject, paramAdData, paramFloat, paramLong, paramBoolean);
  }
  
  public void reportNativeEngineInvalidAdExposure(Object paramObject, AdData paramAdData)
  {
    NativeAdUtils.a((QQAppInterface)paramObject, paramAdData);
  }
  
  public List<GiftServiceBean> requestRole(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return GiftPackageManager.a(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void resetClickStateInVideoMode(Object paramObject)
  {
    ReadInJoyAdUtils.b((VideoPlayParam)paramObject);
  }
  
  public void saveAdCookie(String paramString)
  {
    NativeAdUtils.a(paramString);
  }
  
  public Pair<Boolean, String> sendGiftPackage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return GiftPackageManager.a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public void setAdInfoClickPos(AdvertisementInfo paramAdvertisementInfo, int paramInt, Object paramObject)
  {
    ReadInJoyAdUtils.a(paramAdvertisementInfo, paramInt, (IVideoFeedsPlayManager)paramObject);
  }
  
  public boolean showDiversionBar()
  {
    return DiversionUtil.c();
  }
  
  public void showDiversionWindow(Activity paramActivity)
  {
    DiversionManager.a().a(paramActivity);
  }
  
  public void showVideoAdToast(BaseItemHolder paramBaseItemHolder, String paramString)
  {
    AdVideoButtonUIUtils.a((ADVideoItemHolder)paramBaseItemHolder, paramString);
  }
  
  public void unRegisterGDTReceiver()
  {
    ((IRIJAdActionUtilService)QRoute.api(IRIJAdActionUtilService.class)).unRegisterReceiver();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdUtilServiceImpl
 * JD-Core Version:    0.7.0.1
 */