package cooperation.vip.impl;

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
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.aditem.GdtImageData;
import com.tencent.gdtad.aditem.GdtPreLoader;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment;
import com.tencent.gdtad.api.motivevideo.GdtMotiveVideoPageData;
import com.tencent.gdtad.jsbridge.GdtCanvasFragmentForArk;
import com.tencent.gdtad.jsbridge.GdtVideoCeilingFragmentForJS;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.statistics.GdtOriginalExposureReporter;
import com.tencent.gdtad.statistics.GdtReporter;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.LandingPageParams;
import cooperation.vip.VasAdvAppInterface;
import cooperation.vip.VasAdvGdtInterface;
import cooperation.vip.VasAdvSupport;
import cooperation.vip.VasAdvSupport.Companion;
import cooperation.vip.VasExposureReference;
import cooperation.vip.VasResultCallback;
import cooperation.vip.reward.VasProfitableCallback;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcooperation/vip/impl/VasAdvGdtImpl;", "Lcooperation/vip/VasAdvGdtInterface;", "appInterface", "Lcooperation/vip/VasAdvAppInterface;", "(Lcooperation/vip/VasAdvAppInterface;)V", "exposureCallback", "Lcom/tencent/ad/tangram/util/AdExposureChecker$ExposureCallback;", "gdtAppReceiver", "Lcom/tencent/gdtad/aditem/GdtAppReceiver;", "convertMotiveAdData", "Lcom/tencent/gdtad/api/motivevideo/GdtMotiveVideoPageData;", "adInfo", "Ltencent/gdt/qq_ad_get$QQAdGetRsp$AdInfo;", "rewardText", "", "bizSrc", "convertPbToJson", "T", "Lcom/tencent/mobileqq/pb/PBField;", "pbField", "(Lcom/tencent/mobileqq/pb/PBField;)Ljava/lang/String;", "createExposureCallback", "doCgiReport", "", "exposureUrl", "doExposure", "adView", "Landroid/view/View;", "pbAdInfo", "resultCallback", "Lcooperation/vip/VasResultCallback;", "", "doOriginalExposure", "context", "Landroid/content/Context;", "jsonGdtAdInfo", "getDeviceInfo", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "gdtBizId", "getDeviceInfoAsJson", "getGdtCountdownTime", "", "gdtTangramAdJson", "getIndustryLabels", "", "getMarketPendantImgUrl", "initGdtContext", "showMotiveAd", "activity", "Landroid/app/Activity;", "profitableCallback", "Lcooperation/vip/reward/VasProfitableCallback;", "toLandingPage", "params", "Lcooperation/vip/LandingPageParams;", "unregisterAppReceiver", "vasGdtBizId", "isBrowsingAd", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VasAdvGdtImpl
  implements VasAdvGdtInterface
{
  public static final VasAdvGdtImpl.Companion a;
  private AdExposureChecker.ExposureCallback jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback;
  private GdtAppReceiver jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver;
  private final VasAdvAppInterface jdField_a_of_type_CooperationVipVasAdvAppInterface;
  
  static
  {
    jdField_a_of_type_CooperationVipImplVasAdvGdtImpl$Companion = new VasAdvGdtImpl.Companion(null);
  }
  
  public VasAdvGdtImpl(@NotNull VasAdvAppInterface paramVasAdvAppInterface)
  {
    this.jdField_a_of_type_CooperationVipVasAdvAppInterface = paramVasAdvAppInterface;
  }
  
  private final AdExposureChecker.ExposureCallback a()
  {
    return (AdExposureChecker.ExposureCallback)new VasAdvGdtImpl.createExposureCallback.1(this);
  }
  
  private final GdtMotiveVideoPageData a(qq_ad_get.QQAdGetRsp.AdInfo paramAdInfo, String paramString1, String paramString2)
  {
    GdtAd localGdtAd = new GdtAd(paramAdInfo);
    GdtPreLoader.a().a(localGdtAd);
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
    if (localGdtAd.getImageData() == null)
    {
      paramAdInfo = "";
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
      if (paramAdInfo == null) {
        break label362;
      }
      paramAdInfo = paramAdInfo.toString();
      if (paramAdInfo == null) {
        break label362;
      }
    }
    for (;;)
    {
      localGdtMotiveVideoPageData.adsContent = paramAdInfo;
      localGdtMotiveVideoPageData.processId = BaseApplicationImpl.sProcessId;
      localGdtMotiveVideoPageData.refId = paramString2;
      localGdtMotiveVideoPageData.containerType = 1;
      if (paramString1 != null) {
        localGdtMotiveVideoPageData.setRewardText(paramString1);
      }
      return localGdtMotiveVideoPageData;
      paramAdInfo = localGdtAd.getImageData().a;
      break;
      label362:
      paramAdInfo = "";
    }
  }
  
  private final boolean a(@NotNull GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    return (paramGdtMotiveVideoPageData.vSize != 585) && (paramGdtMotiveVideoPageData.vSize != 185);
  }
  
  public int a(@Nullable String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("pos_ads_info").optJSONObject(0).optJSONArray("ads_info").optJSONObject(0).optString("ext_json");
      long l1;
      long l2;
      if (paramString != null)
      {
        paramString = new JSONObject(paramString).optString("countdown_end_time");
        if (paramString != null)
        {
          paramString = StringsKt.toIntOrNull(paramString);
          if (paramString != null)
          {
            l1 = ((Number)paramString).intValue();
            l2 = System.currentTimeMillis() / 1000;
          }
        }
      }
      for (int i = (int)(l1 - l2);; i = 0) {
        return i;
      }
      return 0;
    }
    catch (Throwable paramString)
    {
      QLog.e("VasAdvGdtImpl", 1, "fail to get count down time", paramString);
    }
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
    paramString = a(paramString);
    if (paramString != null)
    {
      paramString = GdtJsonPbUtil.a((PBField)paramString);
      if (paramString != null) {
        return paramString.toString();
      }
      return null;
    }
    return null;
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
      localObject = GdtDeviceInfoHelper.a(this.jdField_a_of_type_CooperationVipVasAdvAppInterface.a(), (GdtDeviceInfoHelper.Params)localObject);
      if (localObject != null) {}
      for (localObject = ((GdtDeviceInfoHelper.Result)localObject).a; localObject != null; localObject = null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("VasAdvGdtImpl", 2, "gdt device info init success, gdtBizId:" + paramString);
        }
        return localObject;
      }
      return null;
    }
    catch (Exception localException)
    {
      QLog.e("VasAdvGdtImpl", 1, "Error when get gdt device info, biz id " + paramString, (Throwable)localException);
    }
  }
  
  public void a(@NotNull Activity paramActivity, @NotNull LandingPageParams paramLandingPageParams)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Intrinsics.checkParameterIsNotNull(paramLandingPageParams, "params");
    Object localObject;
    if (this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver == null)
    {
      localObject = new GdtAppReceiver();
      ((GdtAppReceiver)localObject).register(VasAdvSupport.a.a().a());
      this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver = ((GdtAppReceiver)localObject);
    }
    try
    {
      localObject = new GdtHandler.Params();
      ((GdtHandler.Params)localObject).jdField_a_of_type_ComTencentGdtadAditemGdtAd = new GdtAd(paramLandingPageParams.a());
      ((GdtHandler.Params)localObject).jdField_a_of_type_Boolean = true;
      ((GdtHandler.Params)localObject).jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
      ((GdtHandler.Params)localObject).jdField_a_of_type_Int = paramLandingPageParams.a();
      ((GdtHandler.Params)localObject).jdField_b_of_type_Int = paramLandingPageParams.b();
      ((GdtHandler.Params)localObject).jdField_b_of_type_Boolean = paramLandingPageParams.a();
      ((GdtHandler.Params)localObject).jdField_c_of_type_Int = 1;
      ((GdtHandler.Params)localObject).jdField_c_of_type_Boolean = false;
      ((GdtHandler.Params)localObject).d = false;
      ((GdtHandler.Params)localObject).e = false;
      ((GdtHandler.Params)localObject).f = true;
      ((GdtHandler.Params)localObject).jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadAditemGdtAppReceiver);
      ((GdtHandler.Params)localObject).jdField_a_of_type_JavaLangClass = GdtVideoCeilingFragmentForJS.class;
      ((GdtHandler.Params)localObject).jdField_b_of_type_JavaLangClass = GdtCanvasFragmentForArk.class;
      paramActivity = new Bundle();
      paramActivity.putString("big_brother_ref_source_key", paramLandingPageParams.a());
      ((GdtHandler.Params)localObject).jdField_a_of_type_AndroidOsBundle = paramActivity;
      GdtHandler.a((GdtHandler.Params)localObject);
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
      GdtMotiveVideoFragment.a(paramActivity, GdtMotiveVideoFragment.class, paramAdInfo);
      return;
    }
    paramString1 = new Handler(Looper.getMainLooper());
    GdtMotiveVideoFragment.a(paramActivity, GdtMotiveVideoFragment.class, paramAdInfo, (ResultReceiver)new VasAdvGdtImpl.showMotiveAd.motiveAdReceiver.1(paramVasProfitableCallback, paramString1, paramString1));
  }
  
  public void a(@Nullable String paramString)
  {
    if (!TextUtils.isEmpty((CharSequence)paramString)) {
      GdtReporter.doCgiReport(paramString);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("VasAdvGdtImpl", 2, "originalExposureReport is empty");
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
    Object localObject2 = null;
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    try
    {
      String str = new JSONObject(paramString).optJSONArray("pos_ads_info").getJSONObject(0).optJSONArray("ads_info").getJSONObject(0).optJSONObject("report_info").optString("original_exposure_url");
      if (!TextUtils.isEmpty((CharSequence)str))
      {
        Object localObject1;
        if (paramAdInfo != null)
        {
          paramString = paramAdInfo.product_type;
          if (paramString != null)
          {
            paramString = Integer.valueOf(paramString.get());
            localObject1 = localObject2;
            if (paramAdInfo != null)
            {
              paramAdInfo = paramAdInfo.app_info;
              localObject1 = localObject2;
              if (paramAdInfo != null)
              {
                paramAdInfo = paramAdInfo.app_package_name;
                localObject1 = localObject2;
                if (paramAdInfo != null) {
                  localObject1 = paramAdInfo.get();
                }
              }
            }
            if (paramString == null) {
              break label211;
            }
          }
        }
        label211:
        for (int i = paramString.intValue();; i = -1)
        {
          paramContext = GdtOriginalExposureReporter.a(str, i, paramContext, (String)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("VasAdvGdtImpl", 2, "original exposure raw url: " + str + ", final exposure url: " + paramContext);
          }
          if (TextUtils.isEmpty((CharSequence)paramContext)) {
            break label229;
          }
          a(paramContext);
          return true;
          paramString = null;
          break;
        }
      }
      return false;
    }
    catch (Throwable paramContext)
    {
      QLog.e("VasAdvGdtImpl", 1, "getOriginalExposureUrl fail ", paramContext);
    }
  }
  
  @Nullable
  public String b(@Nullable String paramString)
  {
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("pos_ads_info").optJSONObject(0).optJSONArray("ads_info").optJSONObject(0).optJSONObject("display_info").optJSONObject("basic_info").optString("marketing_pendant");
        return paramString;
      }
      catch (JSONException paramString)
      {
        QLog.e("VasAdvGdtImpl", 1, "fail to get market pendant img url", (Throwable)paramString);
      }
      paramString = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.impl.VasAdvGdtImpl
 * JD-Core Version:    0.7.0.1
 */