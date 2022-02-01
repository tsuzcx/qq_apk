package com.tencent.mobileqq.vas.adv.base.support.gdt;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport;
import com.tencent.mobileqq.vas.adv.base.support.VasAdvSupport.Companion;
import com.tencent.mobileqq.vas.adv.base.support.app.VasAdvAppInterface;
import com.tencent.mobileqq.vas.adv.common.callback.VasResultCallback;
import com.tencent.mobileqq.vas.adv.common.data.LandingPageParams;
import com.tencent.mobileqq.vas.adv.reward.VasProfitableCallback;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/adv/base/support/gdt/VasAdvGdtImpl;", "Lcom/tencent/mobileqq/vas/adv/base/support/gdt/VasAdvGdtInterface;", "appInterface", "Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvAppInterface;", "(Lcom/tencent/mobileqq/vas/adv/base/support/app/VasAdvAppInterface;)V", "exposureCallback", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "gdtAppReceiver", "Lcom/tencent/gdtad/aditem/GdtAppReceiver;", "convertMotiveAdData", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoPageData;", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "rewardText", "", "bizSrc", "convertPbToJson", "T", "Lcom/tencent/mobileqq/pb/PBField;", "pbField", "(Lcom/tencent/mobileqq/pb/PBField;)Ljava/lang/String;", "createExposureCallback", "createGdtAdParams", "Lcom/tencent/gdtad/aditem/GdtHandler$Params;", "activity", "Landroid/app/Activity;", "params", "Lcom/tencent/mobileqq/vas/adv/common/data/LandingPageParams;", "createGdtAppReceiver", "doCgiReport", "", "exposureUrl", "doExposure", "adView", "Landroid/view/View;", "pbAdInfo", "resultCallback", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasResultCallback;", "", "doOriginalExposure", "context", "Landroid/content/Context;", "jsonGdtAdInfo", "getDeviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "gdtBizId", "getDeviceInfoAsJson", "getGdtCountdownTime", "", "gdtTangramAdJson", "getGdtDanmakuStrContents", "", "(Ljava/lang/String;)[Ljava/lang/String;", "getIndustryLabels", "", "getMarketPendantImgUrl", "initGdtContext", "showMotiveAd", "profitableCallback", "Lcom/tencent/mobileqq/vas/adv/reward/VasProfitableCallback;", "toLandingPage", "unregisterAppReceiver", "vasGdtBizId", "isBrowsingAd", "Companion", "vas-adv-impl_release"}, k=1, mv={1, 1, 16})
public final class VasAdvGdtImpl
  implements VasAdvGdtInterface
{
  public static final VasAdvGdtImpl.Companion a;
  private AdExposureChecker.ExposureCallback jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private final VasAdvAppInterface jdField_a_of_type_ComTencentMobileqqVasAdvBaseSupportAppVasAdvAppInterface;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasAdvBaseSupportGdtVasAdvGdtImpl$Companion = new VasAdvGdtImpl.Companion(null);
  }
  
  public VasAdvGdtImpl(@NotNull VasAdvAppInterface paramVasAdvAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasAdvBaseSupportAppVasAdvAppInterface = paramVasAdvAppInterface;
  }
  
  private final AdExposureChecker.ExposureCallback a()
  {
    return (AdExposureChecker.ExposureCallback)new VasAdvGdtImpl.createExposureCallback.1(this);
  }
  
  private final GdtAppReceiver a()
  {
    GdtAppReceiver localGdtAppReceiver = new GdtAppReceiver();
    localGdtAppReceiver.register(VasAdvSupport.a.a().a());
    return localGdtAppReceiver;
  }
  
  private final GdtHandler.Params a(Activity paramActivity, LandingPageParams paramLandingPageParams)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramLandingPageParams.getAdInfo());
    localParams.jdField_a_of_type_Boolean = true;
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    localParams.jdField_a_of_type_Int = paramLandingPageParams.getSceneId();
    localParams.jdField_b_of_type_Int = paramLandingPageParams.getComponentId();
    localParams.jdField_b_of_type_Boolean = paramLandingPageParams.getAutoDownloadApp();
    localParams.jdField_c_of_type_Int = 1;
    localParams.jdField_c_of_type_Boolean = false;
    localParams.d = false;
    localParams.e = false;
    localParams.f = true;
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
    paramActivity = new Bundle();
    paramActivity.putString("big_brother_ref_source_key", paramLandingPageParams.getSrcId());
    localParams.jdField_a_of_type_AndroidOsBundle = paramActivity;
    return localParams;
  }
  
  private final GdtMotiveVideoPageData a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, String paramString1, String paramString2)
  {
    GdtAd localGdtAd = new GdtAd(paramAdInfo);
    ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).preLoadAfterAdLoaded(this.jdField_a_of_type_ComTencentMobileqqVasAdvBaseSupportAppVasAdvAppInterface.a(), localGdtAd);
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = new GdtMotiveVideoPageData();
    localGdtMotiveVideoPageData.productType = localGdtAd.getProductType();
    localGdtMotiveVideoPageData.vSize = localGdtAd.getCreativeSize();
    localGdtMotiveVideoPageData.screenOrientation = 1;
    localGdtMotiveVideoPageData.adId = localGdtAd.getAdvertiserId();
    localGdtMotiveVideoPageData.vid = localGdtAd.getTencent_video_id();
    localGdtMotiveVideoPageData.url = localGdtAd.getVideoUrl();
    if (!TextUtils.isEmpty((CharSequence)localGdtMotiveVideoPageData.url))
    {
      paramAdInfo = localGdtMotiveVideoPageData.url;
      Intrinsics.checkExpressionValueIsNotNull(paramAdInfo, "url");
      if (StringsKt.startsWith$default(paramAdInfo, "https://", false, 2, null))
      {
        paramAdInfo = localGdtMotiveVideoPageData.url;
        Intrinsics.checkExpressionValueIsNotNull(paramAdInfo, "url");
        paramAdInfo = (CharSequence)paramAdInfo;
        localGdtMotiveVideoPageData.url = new Regex("https://").replaceFirst(paramAdInfo, "http://");
      }
    }
    if (localGdtAd.getImageData() == null) {
      paramAdInfo = "";
    } else {
      paramAdInfo = localGdtAd.getImageData().a;
    }
    localGdtMotiveVideoPageData.previewImgUrl = paramAdInfo;
    localGdtMotiveVideoPageData.bannerImgName = localGdtAd.getAdvertiser_corporate_image_name();
    localGdtMotiveVideoPageData.bannerBaseInfoText = localGdtAd.getText();
    localGdtMotiveVideoPageData.bannerLogo = localGdtAd.getAdvertiser_corporate_logo();
    localGdtMotiveVideoPageData.exposureUrl = localGdtAd.getUrlForImpression();
    localGdtMotiveVideoPageData.appScore = localGdtAd.getAppScore();
    localGdtMotiveVideoPageData.downloadNum = localGdtAd.getAppDownloadNum();
    localGdtMotiveVideoPageData.style = localGdtAd.getStyle();
    localGdtMotiveVideoPageData.endcardUrl = localGdtAd.getEndcardUrl();
    localGdtMotiveVideoPageData.endcardLoadTime = localGdtAd.getEndcardLoadTime();
    localGdtMotiveVideoPageData.bottomCardUrl = localGdtAd.getBottomCardUrl();
    localGdtMotiveVideoPageData.bottomCardLoadTime = localGdtAd.getBottomCardLoadTime();
    paramAdInfo = GdtJsonPbUtil.a((PBField)localGdtAd.info);
    if (paramAdInfo != null)
    {
      paramAdInfo = paramAdInfo.toString();
      if (paramAdInfo != null) {}
    }
    else
    {
      paramAdInfo = "";
    }
    localGdtMotiveVideoPageData.adsContent = paramAdInfo;
    localGdtMotiveVideoPageData.processId = MobileQQ.sProcessId;
    localGdtMotiveVideoPageData.refId = paramString2;
    localGdtMotiveVideoPageData.containerType = 1;
    if (paramString1 != null) {
      localGdtMotiveVideoPageData.setRewardText(paramString1);
    }
    return localGdtMotiveVideoPageData;
  }
  
  private final boolean a(@NotNull GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    return (paramGdtMotiveVideoPageData.vSize != 585) && (paramGdtMotiveVideoPageData.vSize != 185);
  }
  
  public int a(@Nullable String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("pos_ads_info").optJSONObject(0).optJSONArray("ads_info").optJSONObject(0).optString("ext_json");
        if (paramString != null)
        {
          paramString = new JSONObject(paramString).optString("countdown_end_time");
          if (paramString != null)
          {
            paramString = StringsKt.toIntOrNull(paramString);
            if (paramString != null)
            {
              long l1 = ((Number)paramString).intValue();
              long l2 = System.currentTimeMillis() / 1000;
              return (int)(l1 - l2);
            }
          }
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("VasAdvGdtImpl", 1, "fail to get count down time", paramString);
      }
    }
    return 0;
  }
  
  @NotNull
  public String a()
  {
    return "1018ec";
  }
  
  @Nullable
  public <T extends PBField<T>> String a(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "pbField");
    paramT = GdtJsonPbUtil.a(paramT);
    if (paramT != null) {
      return paramT.toString();
    }
    return null;
  }
  
  @Nullable
  public String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    Object localObject2 = a(paramString);
    Object localObject1 = null;
    paramString = localObject1;
    if (localObject2 != null)
    {
      localObject2 = GdtJsonPbUtil.a((PBField)localObject2);
      paramString = localObject1;
      if (localObject2 != null) {
        paramString = localObject2.toString();
      }
    }
    return paramString;
  }
  
  @Nullable
  public List<String> a(@Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    if (paramAdInfo != null)
    {
      paramAdInfo = paramAdInfo.display_info;
      if (paramAdInfo != null)
      {
        paramAdInfo = paramAdInfo.basic_info;
        if (paramAdInfo != null)
        {
          paramAdInfo = paramAdInfo.element_structure_content;
          if (paramAdInfo != null)
          {
            paramAdInfo = paramAdInfo.label;
            if (paramAdInfo != null)
            {
              paramAdInfo = paramAdInfo.get();
              if (paramAdInfo != null)
              {
                Object localObject = (Iterable)paramAdInfo;
                paramAdInfo = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
                localObject = ((Iterable)localObject).iterator();
                while (((Iterator)localObject).hasNext()) {
                  paramAdInfo.add(((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label)((qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label)((Iterator)localObject).next()).get()).content.get());
                }
                return (List)paramAdInfo;
              }
            }
          }
        }
      }
    }
    return null;
  }
  
  @Nullable
  public qq_ad_get.QQAdGet.DeviceInfo a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "gdtBizId");
    try
    {
      Object localObject = new GdtDeviceInfoHelper.Params();
      ((GdtDeviceInfoHelper.Params)localObject).a = paramString;
      localObject = GdtDeviceInfoHelper.a(this.jdField_a_of_type_ComTencentMobileqqVasAdvBaseSupportAppVasAdvAppInterface.a(), (GdtDeviceInfoHelper.Params)localObject);
      if (localObject != null)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("gdt device info init success, gdtBizId:");
          localStringBuilder.append(paramString);
          QLog.d("VasAdvGdtImpl", 2, localStringBuilder.toString());
        }
        localObject = ((GdtDeviceInfoHelper.Result)localObject).a;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error when get gdt device info, biz id ");
      localStringBuilder.append(paramString);
      QLog.e("VasAdvGdtImpl", 1, localStringBuilder.toString(), (Throwable)localException);
    }
    return null;
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull LandingPageParams paramLandingPageParams)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramLandingPageParams, "params");
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null) {
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = a();
    }
    try
    {
      paramActivity = a(paramActivity, paramLandingPageParams);
      ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).handleGdtAdClick(paramActivity);
      return;
    }
    catch (Throwable paramActivity)
    {
      QLog.e("VasAdvGdtImpl", 1, "fail to jump to landing page", paramActivity);
    }
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull VasProfitableCallback paramVasProfitableCallback, @Nullable String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramAdInfo, "adInfo");
    Intrinsics.checkParameterIsNotNull(paramVasProfitableCallback, "profitableCallback");
    Intrinsics.checkParameterIsNotNull(paramString2, "bizSrc");
    paramAdInfo = a(paramAdInfo, paramString1, paramString2);
    if (a(paramAdInfo))
    {
      paramAdInfo.motiveBrowsingKey = "cooperation.vip.impl.vas_browsing_ad_action#";
      paramActivity.registerReceiver((BroadcastReceiver)new VasAdvGdtImpl.showMotiveAd.browsingAdReceiver.1(paramActivity, paramVasProfitableCallback), new IntentFilter("cooperation.vip.impl.vas_browsing_ad_action"));
      ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(paramActivity, paramAdInfo));
      return;
    }
    paramString1 = new Handler(Looper.getMainLooper());
    paramVasProfitableCallback = new VasAdvGdtImpl.showMotiveAd.motiveAdReceiver.1(paramVasProfitableCallback, paramString1, paramString1);
    ((IGdtAPI)QRoute.api(IGdtAPI.class)).startGdtMotiveVideo(StartGdtMotiveVideoParams.a(paramActivity, paramAdInfo, (ResultReceiver)paramVasProfitableCallback));
  }
  
  public void a(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      GdtReporter.doCgiReport(paramString);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VasAdvGdtImpl", 2, "originalExposureReport is empty");
    }
  }
  
  public void a(@NotNull String paramString, @NotNull View paramView, @Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, @NotNull VasResultCallback<Boolean> paramVasResultCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "exposureUrl");
    Intrinsics.checkParameterIsNotNull(paramView, "adView");
    Intrinsics.checkParameterIsNotNull(paramVasResultCallback, "resultCallback");
    if (this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback == null) {
      this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback = a();
    }
    paramVasResultCallback = new WeakReference(paramVasResultCallback);
    paramView = new VasExposureReference(paramView);
    paramView.a(paramVasResultCallback);
    paramView.a(paramString);
    paramString = new AdExposureChecker((Ad)new GdtAd(paramAdInfo), (WeakReference)paramView);
    paramString.setCallback(new WeakReference(this.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
    paramString.startCheck();
  }
  
  public boolean a(@NotNull Context paramContext, @Nullable String paramString, @Nullable qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    for (;;)
    {
      try
      {
        String str = new JSONObject(paramString).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0).optJSONObject("report_info").optString("original_exposure_url");
        if (!TextUtils.isEmpty((CharSequence)str))
        {
          Object localObject = null;
          if (paramAdInfo == null) {
            break label286;
          }
          paramString = paramAdInfo.product_type;
          if (paramString == null) {
            break label286;
          }
          paramString = Integer.valueOf(paramString.get());
          break label288;
          if (paramString.intValue() != 12) {
            break label302;
          }
          paramAdInfo = paramAdInfo.app_info;
          paramString = localObject;
          if (paramAdInfo != null)
          {
            paramAdInfo = paramAdInfo.app_package_name;
            paramString = localObject;
            if (paramAdInfo != null) {
              paramString = paramAdInfo.get();
            }
          }
          if (!VasAdvSupport.a.a().a(paramContext, paramString)) {
            break label295;
          }
          paramContext = "2";
          Intrinsics.checkExpressionValueIsNotNull(str, "rawUrl");
          paramContext = StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(str, "__ACTION_TYPE__", paramContext, false, 4, null), "__VIEW_PERCENT__", "1", false, 4, null), "__VIEW_TIME__", "0", false, 4, null);
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("original exposure raw url: ");
            paramString.append(str);
            paramString.append(", final exposure url: ");
            paramString.append(paramContext);
            QLog.d("VasAdvGdtImpl", 2, paramString.toString());
          }
          boolean bool = TextUtils.isEmpty((CharSequence)paramContext);
          if (!bool) {
            try
            {
              a(paramContext);
              return true;
            }
            catch (Throwable paramContext) {}
          }
        }
        return false;
      }
      catch (Throwable paramContext)
      {
        QLog.e("VasAdvGdtImpl", 1, "getOriginalExposureUrl fail ", paramContext);
        return false;
      }
      label286:
      paramString = null;
      label288:
      if (paramString == null)
      {
        break label302;
        label295:
        paramContext = "1";
        continue;
        label302:
        paramContext = "0";
      }
    }
  }
  
  @Nullable
  public String[] a(@Nullable String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("pos_ads_info");
        int i = 0;
        paramString = paramString.optJSONObject(0).optJSONArray("ads_info").optJSONObject(0).optString("ext_json");
        if (paramString != null)
        {
          paramString = new JSONObject(paramString).optJSONArray("bullet_screen");
          if (paramString != null)
          {
            int j = paramString.length();
            String[] arrayOfString = new String[j];
            while (i < j)
            {
              arrayOfString[i] = paramString.get(i).toString();
              i += 1;
            }
            return arrayOfString;
          }
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("VasAdvGdtImpl", 1, "fail to get count down time", paramString);
      }
    }
    return null;
  }
  
  @Nullable
  public String b(@Nullable String paramString)
  {
    if (paramString != null) {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("pos_ads_info").optJSONObject(0).optJSONArray("ads_info").optJSONObject(0).optJSONObject("display_info").optJSONObject("basic_info").optString("marketing_pendant");
        return paramString;
      }
      catch (JSONException paramString)
      {
        QLog.e("VasAdvGdtImpl", 1, "fail to get market pendant img url", (Throwable)paramString);
      }
    }
    return null;
  }
  
  public void b()
  {
    GdtAppReceiver localGdtAppReceiver = this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
    if (localGdtAppReceiver != null) {
      localGdtAppReceiver.unregister(VasAdvSupport.a.a().a());
    }
    this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = ((GdtAppReceiver)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.adv.base.support.gdt.VasAdvGdtImpl
 * JD-Core Version:    0.7.0.1
 */