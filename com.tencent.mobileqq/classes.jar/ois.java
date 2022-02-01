import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.NativeAd.report.ExposeMode;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportConstants.VideoEndType;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.3;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.5;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoAdInfo.NegFeedback;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AttachedAdData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdDislikeInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.mini.sdk.MiniAppLauncher;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ois
{
  public static int a;
  private static volatile String a;
  
  public static double a(BaseArticleInfo paramBaseArticleInfo, Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (!(paramBaseArticleInfo instanceof AdvertisementInfo))) {
      return 0.0D;
    }
    SosoInterface.SosoLbsInfo localSosoLbsInfo = LbsManagerService.getCachedLbsInfo("readinjoy_feed_ad_distance");
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (!TextUtils.isEmpty(paramBaseArticleInfo.mAdExtInfo)) {}
    }
    for (;;)
    {
      return 0.0D;
      try
      {
        paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.mAdExtInfo);
        double d1 = paramBaseArticleInfo.getDouble(paramString1);
        double d2 = paramBaseArticleInfo.getDouble(paramString2);
        double d3 = localSosoLbsInfo.mLocation.mLat02;
        double d4 = localSosoLbsInfo.mLocation.mLon02;
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition cached latitude =  " + d3 + " longitude = " + d4 + " adLatitude = " + d1 + " adLongitude = " + d2);
        }
        if ((d3 <= 0.0D) || (d3 >= 90.0D) || (d4 <= 0.0D) || (d4 >= 180.0D) || (d1 <= 0.0D) || (d1 >= 90.0D) || (d2 <= 0.0D) || (d2 >= 180.0D)) {
          continue;
        }
        return TencentLocationUtils.distanceBetween(d3, d4, d1, d2);
      }
      catch (Exception paramBaseArticleInfo) {}
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition not  cached ......");
      }
      if (a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition Permission PERMISSION_GRANTED");
        }
        a(paramContext);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("NativeAdUtils", 2, "getADPosition Permission DENY,need to permission ...");
      }
    }
  }
  
  public static double a(double[] paramArrayOfDouble, Context paramContext)
  {
    SosoInterface.SosoLbsInfo localSosoLbsInfo = LbsManagerService.getCachedLbsInfo("readinjoy_feed_ad_distance");
    double d1;
    double d2;
    double d3;
    double d4;
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
    {
      d1 = paramArrayOfDouble[0];
      d2 = paramArrayOfDouble[1];
      d3 = localSosoLbsInfo.mLocation.mLat02;
      d4 = localSosoLbsInfo.mLocation.mLon02;
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition cached latitude =  " + d3 + " longitude = " + d4 + " adLatitude = " + d1 + " adLongitude = " + d2);
      }
      if ((d3 > 0.0D) && (d3 < 90.0D) && (d4 > 0.0D) && (d4 < 180.0D) && (d1 > 0.0D) && (d1 < 90.0D) && (d2 > 0.0D) && (d2 < 180.0D)) {}
    }
    for (;;)
    {
      return 0.0D;
      return TencentLocationUtils.distanceBetween(d3, d4, d1, d2);
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition not  cached ......");
      }
      if (a())
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "getADPosition Permission PERMISSION_GRANTED");
        }
        a(paramContext);
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("NativeAdUtils", 2, "getADPosition Permission DENY,need to permission ...");
      }
    }
  }
  
  public static int a(Context paramContext, ohb paramohb)
  {
    if ((paramContext == null) || (paramohb == null)) {}
    do
    {
      DownloadInfo localDownloadInfo;
      do
      {
        do
        {
          return -1;
          paramContext = paramohb.jdField_f_of_type_JavaLangString;
          paramohb = paramohb.jdField_d_of_type_JavaLangString;
          if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(paramohb))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramohb + " false");
        return -1;
        localDownloadInfo = bjna.a().a(paramohb);
        if (localDownloadInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramohb + " false");
      return -1;
      if (localDownloadInfo.a() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramohb + " true");
        }
        return localDownloadInfo.jdField_f_of_type_Int;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramohb + " false");
    return -1;
  }
  
  public static int a(AdData paramAdData)
  {
    if (uki.a(paramAdData)) {
      return 25;
    }
    if (paramAdData.a()) {
      return 35;
    }
    return 1;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, String paramString3, View.OnClickListener paramOnClickListener2, String paramString4)
  {
    paramContext = new ReportDialog(paramContext, 2131755829);
    paramContext.setContentView(2131559019);
    TextView localTextView = (TextView)paramContext.findViewById(2131365648);
    if (localTextView != null)
    {
      if (paramString1 != null) {
        localTextView.setText(paramString1);
      }
    }
    else
    {
      paramString1 = (TextView)paramContext.findViewById(2131365644);
      if (paramString1 != null)
      {
        if (paramString4 == null) {
          break label148;
        }
        paramString1.setText(paramString4);
      }
      label68:
      paramString1 = (TextView)paramContext.findViewById(2131365633);
      if (paramString1 != null)
      {
        if (paramString2 == null) {
          break label157;
        }
        paramString1.setText(paramString2);
        if (paramOnClickListener1 != null) {
          paramString1.setOnClickListener(paramOnClickListener1);
        }
      }
    }
    for (;;)
    {
      paramString1 = (TextView)paramContext.findViewById(2131365639);
      if (paramString1 != null)
      {
        if (paramString3 == null) {
          break label166;
        }
        paramString1.setText(paramString3);
        if (paramOnClickListener2 != null) {
          paramString1.setOnClickListener(paramOnClickListener2);
        }
      }
      return paramContext;
      localTextView.setVisibility(8);
      break;
      label148:
      paramString1.setVisibility(8);
      break label68;
      label157:
      paramString1.setVisibility(8);
    }
    label166:
    paramString1.setVisibility(8);
    return paramContext;
  }
  
  public static VideoAdInfo a(AdvertisementInfo paramAdvertisementInfo)
  {
    VideoAdInfo localVideoAdInfo = new VideoAdInfo();
    if (paramAdvertisementInfo != null)
    {
      localVideoAdInfo.jdField_a_of_type_Long = paramAdvertisementInfo.mAdFetchTime;
      localVideoAdInfo.jdField_a_of_type_Int = paramAdvertisementInfo.mAdPosLayout;
      localVideoAdInfo.jdField_b_of_type_Long = paramAdvertisementInfo.mAdPosID;
      localVideoAdInfo.jdField_c_of_type_Long = paramAdvertisementInfo.mChannelID;
      localVideoAdInfo.jdField_b_of_type_Int = paramAdvertisementInfo.mAdKdPos;
      localVideoAdInfo.jdField_a_of_type_JavaLangString = paramAdvertisementInfo.mAdCl;
      localVideoAdInfo.jdField_b_of_type_JavaLangString = paramAdvertisementInfo.mAdImg;
      localVideoAdInfo.jdField_c_of_type_JavaLangString = paramAdvertisementInfo.mAdImgs;
      localVideoAdInfo.jdField_d_of_type_JavaLangString = paramAdvertisementInfo.mAdTxt;
      localVideoAdInfo.jdField_e_of_type_JavaLangString = paramAdvertisementInfo.mAdDesc;
      localVideoAdInfo.jdField_f_of_type_JavaLangString = paramAdvertisementInfo.mAdRl;
      localVideoAdInfo.jdField_g_of_type_JavaLangString = paramAdvertisementInfo.mAdApurl;
      localVideoAdInfo.jdField_h_of_type_JavaLangString = paramAdvertisementInfo.mAdTraceId;
      localVideoAdInfo.i = paramAdvertisementInfo.mAdProductId;
      localVideoAdInfo.jdField_c_of_type_Int = paramAdvertisementInfo.mAdProductType;
      localVideoAdInfo.jdField_d_of_type_Int = paramAdvertisementInfo.mAdType;
      localVideoAdInfo.jdField_j_of_type_JavaLangString = paramAdvertisementInfo.mAdLandingPage;
      localVideoAdInfo.k = paramAdvertisementInfo.mAdPrice;
      localVideoAdInfo.jdField_l_of_type_JavaLangString = paramAdvertisementInfo.mAdBtnTxt;
      localVideoAdInfo.jdField_m_of_type_JavaLangString = paramAdvertisementInfo.mAdViewId;
      localVideoAdInfo.jdField_n_of_type_JavaLangString = paramAdvertisementInfo.mAdCustomizedInvokeUrl;
      localVideoAdInfo.o = paramAdvertisementInfo.mAdCorporationName;
      localVideoAdInfo.jdField_p_of_type_JavaLangString = paramAdvertisementInfo.mAdCorporateImageName;
      localVideoAdInfo.jdField_q_of_type_JavaLangString = paramAdvertisementInfo.mAdCorporateLogo;
      localVideoAdInfo.jdField_d_of_type_Long = paramAdvertisementInfo.mAdUin;
      localVideoAdInfo.r = paramAdvertisementInfo.mAdExt;
      localVideoAdInfo.s = paramAdvertisementInfo.mAdVideoUrl;
      localVideoAdInfo.jdField_e_of_type_Int = paramAdvertisementInfo.mAdCostType;
      localVideoAdInfo.jdField_e_of_type_Long = paramAdvertisementInfo.mAdAid;
      localVideoAdInfo.jdField_f_of_type_Int = paramAdvertisementInfo.mAdLayout;
      localVideoAdInfo.jdField_g_of_type_Int = paramAdvertisementInfo.mAdMaterialId;
      localVideoAdInfo.t = paramAdvertisementInfo.mAdVia;
      localVideoAdInfo.v = paramAdvertisementInfo.mAdExtInfo;
      localVideoAdInfo.jdField_l_of_type_Int = paramAdvertisementInfo.mAdJumpMode;
      localVideoAdInfo.w = paramAdvertisementInfo.mAdAppJson;
      localVideoAdInfo.x = paramAdvertisementInfo.mAdAppDownLoadSchema;
      localVideoAdInfo.y = paramAdvertisementInfo.mAdCanvasJson;
      localVideoAdInfo.z = paramAdvertisementInfo.mAdLandingPageReportUrl;
      localVideoAdInfo.jdField_g_of_type_Long = paramAdvertisementInfo.mAdAdvertiseId;
      localVideoAdInfo.jdField_n_of_type_Int = paramAdvertisementInfo.mAdDestType;
      localVideoAdInfo.A = paramAdvertisementInfo.mAdEffectUrl;
      localVideoAdInfo.jdField_h_of_type_Long = paramAdvertisementInfo.mAdNocoId;
      localVideoAdInfo.B = paramAdvertisementInfo.mAdDownloadApiUrl;
      localVideoAdInfo.jdField_p_of_type_Int = paramAdvertisementInfo.mC2SSwitch;
      localVideoAdInfo.jdField_f_of_type_JavaUtilArrayList = paramAdvertisementInfo.mC2SClickUrl;
      localVideoAdInfo.jdField_g_of_type_JavaUtilArrayList = paramAdvertisementInfo.mC2SExposureUrl;
      localVideoAdInfo.jdField_q_of_type_Int = paramAdvertisementInfo.replay;
      paramAdvertisementInfo = paramAdvertisementInfo.mAdDislikeInfos;
      if ((paramAdvertisementInfo != null) && (!paramAdvertisementInfo.isEmpty()))
      {
        localVideoAdInfo.jdField_e_of_type_JavaUtilArrayList = new ArrayList(paramAdvertisementInfo.size());
        int i = 0;
        while (i < paramAdvertisementInfo.size())
        {
          AdDislikeInfo localAdDislikeInfo = (AdDislikeInfo)paramAdvertisementInfo.get(i);
          VideoAdInfo.NegFeedback localNegFeedback = new VideoAdInfo.NegFeedback();
          localNegFeedback.jdField_a_of_type_JavaLangString = localAdDislikeInfo.jdField_a_of_type_JavaLangString;
          localNegFeedback.jdField_a_of_type_Long = localAdDislikeInfo.jdField_a_of_type_Long;
          localVideoAdInfo.jdField_e_of_type_JavaUtilArrayList.add(localNegFeedback);
          i += 1;
        }
      }
      localVideoAdInfo.a(localVideoAdInfo.v);
      localVideoAdInfo.c(localVideoAdInfo.v);
      localVideoAdInfo.b(localVideoAdInfo.v);
    }
    return localVideoAdInfo;
  }
  
  public static AdvertisementInfo a(VideoAdInfo paramVideoAdInfo)
  {
    AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
    if (paramVideoAdInfo != null)
    {
      localAdvertisementInfo.mAdTraceId = paramVideoAdInfo.jdField_h_of_type_JavaLangString;
      localAdvertisementInfo.mAdFetchTime = paramVideoAdInfo.jdField_a_of_type_Long;
      localAdvertisementInfo.mAdViewId = paramVideoAdInfo.jdField_m_of_type_JavaLangString;
      localAdvertisementInfo.mAdPosID = paramVideoAdInfo.jdField_b_of_type_Long;
      localAdvertisementInfo.mAdKdPos = paramVideoAdInfo.jdField_b_of_type_Int;
      localAdvertisementInfo.mAdProductId = paramVideoAdInfo.i;
      localAdvertisementInfo.mAdProductType = paramVideoAdInfo.jdField_c_of_type_Int;
      localAdvertisementInfo.mAdRl = paramVideoAdInfo.jdField_f_of_type_JavaLangString;
      localAdvertisementInfo.mAdAdvertiseId = paramVideoAdInfo.jdField_g_of_type_Long;
      localAdvertisementInfo.mAdVideoUrl = paramVideoAdInfo.s;
      localAdvertisementInfo.mAdAid = paramVideoAdInfo.jdField_e_of_type_Long;
      localAdvertisementInfo.mAdTraceId = paramVideoAdInfo.jdField_h_of_type_JavaLangString;
      localAdvertisementInfo.mAdViewId = paramVideoAdInfo.jdField_m_of_type_JavaLangString;
      localAdvertisementInfo.mAdProductId = paramVideoAdInfo.i;
      localAdvertisementInfo.mAdVia = paramVideoAdInfo.t;
      localAdvertisementInfo.mAdNocoId = paramVideoAdInfo.jdField_h_of_type_Long;
      localAdvertisementInfo.mAdApurl = paramVideoAdInfo.jdField_g_of_type_JavaLangString;
      localAdvertisementInfo.mAdRl = paramVideoAdInfo.jdField_f_of_type_JavaLangString;
      localAdvertisementInfo.mAdEffectUrl = paramVideoAdInfo.A;
      localAdvertisementInfo.mAdLandingPageReportUrl = paramVideoAdInfo.z;
      localAdvertisementInfo.mAdLandingPage = paramVideoAdInfo.jdField_j_of_type_JavaLangString;
      localAdvertisementInfo.mAdCanvasJson = paramVideoAdInfo.y;
      localAdvertisementInfo.mAdDestType = paramVideoAdInfo.jdField_n_of_type_Int;
      localAdvertisementInfo.mAdExt = paramVideoAdInfo.r;
      localAdvertisementInfo.mAdExtInfo = paramVideoAdInfo.v;
      localAdvertisementInfo.mAdAppDownLoadSchema = paramVideoAdInfo.x;
      localAdvertisementInfo.mAdCustomizedInvokeUrl = paramVideoAdInfo.jdField_n_of_type_JavaLangString;
      localAdvertisementInfo.mAdProductType = paramVideoAdInfo.jdField_c_of_type_Int;
      VideoAdInfo.a(paramVideoAdInfo);
      localAdvertisementInfo.mC2SSwitch = paramVideoAdInfo.jdField_p_of_type_Int;
      localAdvertisementInfo.mC2SClickUrl = paramVideoAdInfo.jdField_f_of_type_JavaUtilArrayList;
      localAdvertisementInfo.mC2SExposureUrl = paramVideoAdInfo.jdField_g_of_type_JavaUtilArrayList;
      localAdvertisementInfo.mPopFormH5Url = paramVideoAdInfo.C;
      localAdvertisementInfo.mShowAdButton = paramVideoAdInfo.jdField_b_of_type_Boolean;
      localAdvertisementInfo.replay = paramVideoAdInfo.jdField_q_of_type_Int;
      localAdvertisementInfo.mRevisionVideoType = paramVideoAdInfo.jdField_m_of_type_Int;
      localAdvertisementInfo.isMultiyVideo = paramVideoAdInfo.jdField_a_of_type_Boolean;
      localAdvertisementInfo.processAdExt(paramVideoAdInfo.r);
    }
    return localAdvertisementInfo;
  }
  
  @Nullable
  private static AppInterface a(ufw paramufw)
  {
    paramufw = paramufw.a();
    if ((paramufw == null) && (BaseApplicationImpl.sProcessId == 1))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localAppRuntime instanceof QQAppInterface)) {
        return (QQAppInterface)localAppRuntime;
      }
    }
    return paramufw;
  }
  
  public static String a()
  {
    for (;;)
    {
      try
      {
        if (jdField_a_of_type_JavaLangString == null)
        {
          localObject1 = BaseApplicationImpl.getApplication().peekAppRuntime();
          if (localObject1 == null) {
            jdField_a_of_type_JavaLangString = "";
          }
        }
        else
        {
          b("getAdCookie cookie=", jdField_a_of_type_JavaLangString);
          localObject1 = jdField_a_of_type_JavaLangString;
          return localObject1;
        }
        Object localObject1 = bmhv.a((AppRuntime)localObject1, true, false);
        if (localObject1 != null) {
          jdField_a_of_type_JavaLangString = ((SharedPreferences)localObject1).getString("sp_key_ad_cookie", "");
        } else {
          jdField_a_of_type_JavaLangString = "";
        }
      }
      finally {}
    }
  }
  
  public static String a(double paramDouble)
  {
    if (paramDouble <= 0.0D) {
      return "";
    }
    paramDouble = Math.ceil(paramDouble);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramDouble < 1000.0D) {
      localStringBuilder.append((int)paramDouble).append('m');
    }
    for (;;)
    {
      return localStringBuilder.toString();
      long l = Math.round(paramDouble / 1000.0D);
      if (l < 1000L) {
        localStringBuilder.append(l).append("km");
      } else {
        localStringBuilder.append("999km");
      }
    }
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo, Context paramContext, String paramString1, String paramString2)
  {
    Object localObject = null;
    double d = a(paramBaseArticleInfo, paramContext, paramString1, paramString2);
    paramBaseArticleInfo = localObject;
    if (d > 0.0D) {
      paramBaseArticleInfo = a(d);
    }
    return paramBaseArticleInfo;
  }
  
  public static String a(String paramString)
  {
    return bjkp.a(paramString);
  }
  
  public static JSONObject a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ReportConstants.VideoEndType paramVideoEndType)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramVideoEndType, false);
  }
  
  public static JSONObject a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ReportConstants.VideoEndType paramVideoEndType, boolean paramBoolean)
  {
    return a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramInt9, paramInt10, paramVideoEndType, false, paramBoolean);
  }
  
  public static JSONObject a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, ReportConstants.VideoEndType paramVideoEndType, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0) && (paramInt1 == paramInt2)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("bt", paramInt1);
        localJSONObject.put("et", paramInt2);
        localJSONObject.put("bf", paramInt3);
        localJSONObject.put("ef", paramInt4);
        localJSONObject.put("pp", paramInt8);
        localJSONObject.put("pa", paramInt5);
        localJSONObject.put("pb", paramInt6);
        localJSONObject.put("duration", paramInt7);
        localJSONObject.put("ps", paramInt9);
        if (paramVideoEndType == null)
        {
          paramInt1 = ReportConstants.VideoEndType.NORMAL_COMPLETE.getValue();
          localJSONObject.put("videoEndType", paramInt1);
          localJSONObject.put("isVideoFeedsRecommend", paramBoolean2);
          localJSONObject.put("videoReplayCount", paramInt10);
          localJSONObject.put("isClickReplay", paramBoolean1);
          return localJSONObject;
        }
      }
      catch (JSONException paramVideoEndType)
      {
        paramVideoEndType.printStackTrace();
        return null;
      }
      paramInt1 = paramVideoEndType.getValue();
    }
  }
  
  /* Error */
  public static JSONObject a(Context paramContext)
  {
    // Byte code:
    //   0: new 37	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 606	org/json/JSONObject:<init>	()V
    //   7: astore 6
    //   9: invokestatic 656	ujw:a	()Ljava/lang/String;
    //   12: astore 5
    //   14: invokestatic 658	ujw:c	()Ljava/lang/String;
    //   17: astore 4
    //   19: aload 5
    //   21: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +328 -> 352
    //   27: aload 5
    //   29: invokevirtual 663	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   32: astore_3
    //   33: aload 6
    //   35: ldc_w 665
    //   38: aload_3
    //   39: invokestatic 670	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   42: invokevirtual 663	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   45: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   48: pop
    //   49: aload 6
    //   51: ldc_w 675
    //   54: iconst_1
    //   55: invokevirtual 612	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   58: pop
    //   59: aload 4
    //   61: astore 5
    //   63: aload_3
    //   64: astore 4
    //   66: aload 5
    //   68: astore_3
    //   69: new 677	com/tencent/gdtad/util/GdtDeviceInfoHelper$Params
    //   72: dup
    //   73: invokespecial 678	com/tencent/gdtad/util/GdtDeviceInfoHelper$Params:<init>	()V
    //   76: astore 5
    //   78: aload 5
    //   80: ldc_w 680
    //   83: putfield 683	com/tencent/gdtad/util/GdtDeviceInfoHelper$Params:businessIdForAidTicketAndTaidTicket	Ljava/lang/String;
    //   86: invokestatic 689	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   89: aload 5
    //   91: invokestatic 695	com/tencent/gdtad/util/GdtDeviceInfoHelper:create	(Landroid/content/Context;Lcom/tencent/gdtad/util/GdtDeviceInfoHelper$Params;)Lcom/tencent/gdtad/util/GdtDeviceInfoHelper$Result;
    //   94: astore 5
    //   96: aload 5
    //   98: ifnull +51 -> 149
    //   101: aload 5
    //   103: getfield 701	com/tencent/gdtad/util/GdtDeviceInfoHelper$Result:deviceInfo	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   106: ifnull +43 -> 149
    //   109: aload 6
    //   111: ldc_w 665
    //   114: aload 5
    //   116: getfield 701	com/tencent/gdtad/util/GdtDeviceInfoHelper$Result:deviceInfo	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   119: getfield 706	tencent/gdt/qq_ad_get$QQAdGet$DeviceInfo:muid	Lcom/tencent/mobileqq/pb/PBStringField;
    //   122: invokevirtual 710	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   125: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   128: pop
    //   129: aload 6
    //   131: ldc_w 675
    //   134: aload 5
    //   136: getfield 701	com/tencent/gdtad/util/GdtDeviceInfoHelper$Result:deviceInfo	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   139: getfield 713	tencent/gdt/qq_ad_get$QQAdGet$DeviceInfo:muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: invokevirtual 717	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   145: invokevirtual 612	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   148: pop
    //   149: aload 6
    //   151: ldc_w 719
    //   154: invokestatic 722	ofj:a	()I
    //   157: invokevirtual 612	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   160: pop
    //   161: aload 6
    //   163: ldc_w 724
    //   166: aload_0
    //   167: invokestatic 729	zei:c	(Landroid/content/Context;)Ljava/lang/String;
    //   170: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   173: pop
    //   174: iconst_0
    //   175: istore_1
    //   176: invokestatic 734	com/tencent/mobileqq/utils/DeviceInfoUtil:getCarrier	()I
    //   179: istore_2
    //   180: iload_2
    //   181: istore_1
    //   182: aload 6
    //   184: ldc_w 736
    //   187: iload_1
    //   188: invokevirtual 612	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   191: pop
    //   192: aload 6
    //   194: ldc_w 738
    //   197: invokestatic 741	com/tencent/mobileqq/utils/DeviceInfoUtil:getDeviceOSVersion	()Ljava/lang/String;
    //   200: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   203: pop
    //   204: aload 6
    //   206: ldc_w 743
    //   209: invokestatic 746	com/tencent/mobileqq/utils/DeviceInfoUtil:getQQVersion	()Ljava/lang/String;
    //   212: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   215: pop
    //   216: aload 6
    //   218: ldc_w 748
    //   221: invokestatic 751	com/tencent/common/config/AppSetting:a	()I
    //   224: invokestatic 755	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   227: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   230: pop
    //   231: aload 6
    //   233: ldc_w 757
    //   236: invokestatic 762	dw:a	()J
    //   239: invokestatic 765	dw:a	(J)Ljava/lang/String;
    //   242: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   245: pop
    //   246: aload 6
    //   248: ldc_w 767
    //   251: aload_0
    //   252: invokestatic 770	prb:c	(Landroid/content/Context;)Ljava/lang/String;
    //   255: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   258: pop
    //   259: aload 6
    //   261: ldc_w 772
    //   264: aload_3
    //   265: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   268: pop
    //   269: aload 6
    //   271: ldc_w 774
    //   274: iconst_2
    //   275: invokevirtual 612	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   278: pop
    //   279: aload 6
    //   281: ldc_w 776
    //   284: invokestatic 779	com/tencent/mobileqq/utils/DeviceInfoUtil:getManufacturer	()Ljava/lang/String;
    //   287: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   290: pop
    //   291: aload 6
    //   293: ldc_w 781
    //   296: invokestatic 784	com/tencent/mobileqq/utils/DeviceInfoUtil:getModel	()Ljava/lang/String;
    //   299: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   302: pop
    //   303: aload 6
    //   305: ldc_w 786
    //   308: invokestatic 789	com/tencent/mobileqq/utils/DeviceInfoUtil:getManufactureInfo	()Ljava/lang/String;
    //   311: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   314: pop
    //   315: aload 6
    //   317: ldc_w 791
    //   320: aload 4
    //   322: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   325: pop
    //   326: aload_0
    //   327: ifnull +22 -> 349
    //   330: aload 6
    //   332: ldc_w 793
    //   335: aload_0
    //   336: invokevirtual 799	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   339: ldc_w 801
    //   342: invokestatic 806	android/provider/Settings$Secure:getString	(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;
    //   345: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   348: pop
    //   349: aload 6
    //   351: areturn
    //   352: aload 4
    //   354: astore_3
    //   355: aload 4
    //   357: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   360: ifne +97 -> 457
    //   363: aload 4
    //   365: ldc_w 808
    //   368: ldc_w 540
    //   371: invokevirtual 811	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   374: invokevirtual 814	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   377: astore_3
    //   378: aload 6
    //   380: ldc_w 665
    //   383: aload_3
    //   384: invokestatic 670	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   387: invokevirtual 663	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   390: invokevirtual 673	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload 6
    //   396: ldc_w 675
    //   399: iconst_3
    //   400: invokevirtual 612	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   403: pop
    //   404: goto +53 -> 457
    //   407: astore_0
    //   408: ldc 62
    //   410: iconst_1
    //   411: new 64	java/lang/StringBuilder
    //   414: dup
    //   415: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   418: ldc_w 816
    //   421: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload_0
    //   425: invokevirtual 817	java/lang/Exception:toString	()Ljava/lang/String;
    //   428: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 90	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   437: aload 6
    //   439: areturn
    //   440: astore_0
    //   441: aload_0
    //   442: invokevirtual 818	java/lang/Exception:printStackTrace	()V
    //   445: aconst_null
    //   446: areturn
    //   447: astore 5
    //   449: goto -267 -> 182
    //   452: astore 5
    //   454: goto -208 -> 246
    //   457: aload 5
    //   459: astore 4
    //   461: goto -392 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	464	0	paramContext	Context
    //   175	13	1	i	int
    //   179	2	2	j	int
    //   32	352	3	localObject1	Object
    //   17	443	4	localObject2	Object
    //   12	123	5	localObject3	Object
    //   447	1	5	localException1	Exception
    //   452	6	5	localException2	Exception
    //   7	431	6	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   330	349	407	java/lang/Exception
    //   9	59	440	java/lang/Exception
    //   69	96	440	java/lang/Exception
    //   101	149	440	java/lang/Exception
    //   149	174	440	java/lang/Exception
    //   182	231	440	java/lang/Exception
    //   246	326	440	java/lang/Exception
    //   355	404	440	java/lang/Exception
    //   408	437	440	java/lang/Exception
    //   176	180	447	java/lang/Exception
    //   231	246	452	java/lang/Exception
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mBusiJson != null)) {
      return paramAdvertisementInfo.mBusiJson;
    }
    return new JSONObject();
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAdvertisementInfo != null) {}
    for (;;)
    {
      try
      {
        localJSONObject.put("traceid", paramAdvertisementInfo.mAdTraceId);
        localJSONObject.put("pull_time", paramAdvertisementInfo.mAdFetchTime);
        localJSONObject.put("apurl", paramAdvertisementInfo.mAdApurl);
        localJSONObject.put("rl", paramAdvertisementInfo.mAdRl);
        localJSONObject.put("viewid", paramAdvertisementInfo.mAdViewId);
        localJSONObject.put("posid", paramAdvertisementInfo.mAdPosID);
        localJSONObject.put("channel_id", paramAdvertisementInfo.mChannelID);
        localJSONObject.put("kd_pos", paramAdvertisementInfo.mAdKdPos);
        localJSONObject.put("cl", paramAdvertisementInfo.mAdCl);
        localJSONObject.put("pos_layout", paramAdvertisementInfo.mAdPosLayout);
        localJSONObject.put("product_id", paramAdvertisementInfo.mAdProductId);
        localJSONObject.put("product_type", paramAdvertisementInfo.mAdProductType);
        localJSONObject.put("ad_type", paramAdvertisementInfo.mAdType);
        localJSONObject.put("price", paramAdvertisementInfo.mAdPrice);
        localJSONObject.put("customized_invoke_url", paramAdvertisementInfo.mAdCustomizedInvokeUrl);
        localJSONObject.put("corporation_name", paramAdvertisementInfo.mAdCorporationName);
        localJSONObject.put("corporate_image_name", paramAdvertisementInfo.mAdCorporateImageName);
        localJSONObject.put("corporate_logo", paramAdvertisementInfo.mAdCorporateLogo);
        localJSONObject.put("ad_uin", paramAdvertisementInfo.mAdUin);
        localJSONObject.put("ext", paramAdvertisementInfo.mAdExt);
        localJSONObject.put("video_url", paramAdvertisementInfo.mVideoVid);
        localJSONObject.put("cost_type", paramAdvertisementInfo.mAdCostType);
        localJSONObject.put("aid", paramAdvertisementInfo.mAdAid);
        localJSONObject.put("img", paramAdvertisementInfo.mAdImg);
        localJSONObject.put("img_s", paramAdvertisementInfo.mAdImgs);
        localJSONObject.put("txt", paramAdvertisementInfo.mAdTxt);
        localJSONObject.put("desc", paramAdvertisementInfo.mAdDesc);
        localJSONObject.put("ad_layout", paramAdvertisementInfo.mAdLayout);
        localJSONObject.put("ad_material_id", paramAdvertisementInfo.mAdMaterialId);
        localJSONObject.put("algo_id", "" + paramAdvertisementInfo.mAlgorithmID);
        localJSONObject.put("replay", paramAdvertisementInfo.replay);
        a(localJSONObject, paramAdvertisementInfo);
        if (paramAdvertisementInfo.downloadState == 0)
        {
          localJSONObject.put("download_state", "0");
          if (paramVideoAdInfo != null)
          {
            if (localJSONObject.isNull("apurl")) {
              localJSONObject.put("apurl", paramVideoAdInfo.jdField_g_of_type_JavaLangString);
            }
            localJSONObject.put("via", paramVideoAdInfo.t);
            localJSONObject.put("dis_channel", paramVideoAdInfo.jdField_j_of_type_Int);
            localJSONObject.put("button_url", paramVideoAdInfo.u);
          }
          localJSONObject.put("cookie", a());
          if (paramInt <= 0) {
            break;
          }
          localJSONObject.put("click_pos", paramInt);
          return localJSONObject;
        }
        if (paramAdvertisementInfo.downloadState == 3)
        {
          localJSONObject.put("download_state", "1");
          continue;
        }
        if (paramAdvertisementInfo.downloadState != 4) {
          break label565;
        }
      }
      catch (JSONException paramAdvertisementInfo)
      {
        paramAdvertisementInfo.printStackTrace();
        return localJSONObject;
      }
      localJSONObject.put("download_state", "2");
      continue;
      label565:
      if ((paramAdvertisementInfo.downloadState == 5) || (paramAdvertisementInfo.downloadState == 1)) {
        localJSONObject.put("download_state", "3");
      }
    }
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.clickPos > 0)) {
      localJSONObject.put("click_pos", paramAdvertisementInfo.clickPos);
    }
    return localJSONObject;
  }
  
  public static JSONObject a(AdvertisementInfo paramAdvertisementInfo, HashMap<String, Object> paramHashMap)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAdvertisementInfo != null) {
      localJSONObject = a(paramAdvertisementInfo);
    }
    return oiy.a(new JSONObject[] { localJSONObject, a(paramHashMap) });
  }
  
  public static JSONObject a(AdData paramAdData)
  {
    if (paramAdData == null) {
      return new JSONObject();
    }
    if (paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null) {
      return a(paramAdData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo);
    }
    return a(ukt.a(paramAdData));
  }
  
  private static JSONObject a(QQAppInterface paramQQAppInterface, AdData paramAdData, int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramQQAppInterface.getAccount());
      localJSONObject.put("ts", NetConnInfoCenter.getServerTimeMillis());
      localJSONObject.put("dinfo", b(paramQQAppInterface.getApplication().getApplicationContext()));
      localJSONObject.put("ver", "8.4.10");
      localJSONObject.put("type", paramInt1);
      localJSONObject.put("stype", paramInt2);
      localJSONObject.put("isdpg", 1);
      if (paramAdData != null)
      {
        if (paramInt1 != 1) {
          break label184;
        }
        paramQQAppInterface = paramAdData.jdField_e_of_type_JavaLangString;
        localJSONObject.put("ext", paramQQAppInterface);
        localJSONObject.put("oudid", paramAdData.k);
        if (!(paramAdData instanceof AttachedAdData)) {
          break label192;
        }
        localJSONObject.put("aname", paramAdData.jdField_b_of_type_JavaLangString);
        localJSONObject.put("posid", paramAdData.jdField_c_of_type_Int);
      }
      for (;;)
      {
        if (paramJSONObject == null) {
          break label226;
        }
        localJSONObject.put("exposureExtraInfo", paramJSONObject);
        return localJSONObject;
        label184:
        paramQQAppInterface = paramAdData.jdField_g_of_type_JavaLangString;
        break;
        label192:
        localJSONObject.put("aname", paramAdData.i);
        localJSONObject.put("posid", paramAdData.jdField_a_of_type_JavaLangString);
      }
      return localJSONObject;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static JSONObject a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, HashMap<String, Object> paramHashMap)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put("article_id", paramString1);
      }
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("rowkey", paramString2);
      }
      if (!TextUtils.isEmpty(paramString3)) {
        localJSONObject.put("tags", paramString3);
      }
      if ((!TextUtils.isEmpty(paramString4)) && (!TextUtils.isEmpty(paramString5)))
      {
        localJSONObject.put("game_component_type", paramString4);
        localJSONObject.put("game_pkg", paramString5);
      }
      if ((paramHashMap != null) && (paramHashMap.size() > 0))
      {
        paramString1 = paramHashMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          paramString3 = paramHashMap.get(paramString2);
          if (paramString3 != null) {
            localJSONObject.put(paramString2, paramString3);
          }
        }
      }
      return localJSONObject;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
  }
  
  public static JSONObject a(HashMap<String, Object> paramHashMap)
  {
    localJSONObject = new JSONObject();
    if (paramHashMap != null) {
      try
      {
        if (paramHashMap.size() > 0)
        {
          Iterator localIterator = paramHashMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            Object localObject = paramHashMap.get(str);
            if (localObject != null) {
              localJSONObject.put(str, localObject);
            }
          }
        }
        return localJSONObject;
      }
      catch (Exception paramHashMap) {}
    }
  }
  
  public static void a(Activity paramActivity, ohb paramohb, DownloadListener paramDownloadListener)
  {
    if ((paramActivity == null) || (paramohb == null)) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return;
      str1 = paramohb.jdField_f_of_type_JavaLangString;
      str2 = paramohb.jdField_d_of_type_JavaLangString;
      str3 = paramohb.jdField_j_of_type_JavaLangString;
      paramohb = paramohb.i;
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(paramohb)));
    Bundle localBundle = new Bundle();
    localBundle.putString(bjmy.jdField_f_of_type_JavaLangString, str1);
    localBundle.putString(bjmy.jdField_b_of_type_JavaLangString, str2);
    localBundle.putString(bjmy.jdField_j_of_type_JavaLangString, str3);
    localBundle.putString(bjmy.jdField_l_of_type_JavaLangString, paramohb);
    localBundle.putInt(bjmy.k, 2);
    localBundle.putInt(bjmy.F, 0);
    localBundle.putBoolean(bjmy.x, false);
    localBundle.putInt(bjmy.I, 0);
    localBundle.putBoolean(bjmy.y, true);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "downloadApk pkg:" + str1 + ", appid:" + str2 + ", name:" + paramohb + ", url:" + str3);
    }
    if (paramDownloadListener != null) {
      bjna.a().a(paramDownloadListener);
    }
    bjmu.a(paramActivity, localBundle, "biz_src_yyb", null, 0);
  }
  
  private static void a(Context paramContext)
  {
    if (jdField_a_of_type_Int >= 3) {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition doStartADLocation retryLocationCount >= 3");
      }
    }
    while ((paramContext == null) || (!NetworkUtil.isNetworkAvailable(paramContext))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "getADPosition doStartADLocation network is Available...");
    }
    LbsManagerService.startLocation(new oiw("readinjoy_feed_ad_distance"));
    jdField_a_of_type_Int += 1;
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, int paramInt1, int paramInt2)
  {
    long l1 = 0L;
    if ((paramContext != null) && (paramBaseArticleInfo != null)) {}
    for (;;)
    {
      try
      {
        if (paramBaseArticleInfo.mSmallMiniGameInfo == null) {
          break label311;
        }
        Object localObject = paramBaseArticleInfo.mSmallMiniGameInfo.jdField_j_of_type_JavaLangString;
        if (uks.g(paramBaseArticleInfo))
        {
          l2 = 50404L;
          if (paramInt2 != 1) {
            break label312;
          }
          l1 = 5040402L;
          localObject = new ogz().a(504L).b(l2).c(l1).d((String)localObject);
          if (paramInt2 != 1) {
            break label352;
          }
          l1 = 3L;
          ogz localogz = ((ogz)localObject).d(l1).a(paramBaseArticleInfo.innerUniqueID).b(paramBaseArticleInfo.mTitle).i(String.valueOf(paramInt1));
          if (uks.i(paramBaseArticleInfo))
          {
            localObject = paramBaseArticleInfo.mSmallMiniGameInfo.o;
            localObject = localogz.c((String)localObject);
            if (!MiniAppLauncher.isMiniAppUrl(paramBaseArticleInfo.mArticleContentUrl)) {
              continue;
            }
            paramBaseArticleInfo = paramBaseArticleInfo.mArticleContentUrl;
            a(paramContext, ((ogz)localObject).g(paramBaseArticleInfo).a());
          }
        }
        else
        {
          if (uks.e(paramBaseArticleInfo))
          {
            l2 = 50403L;
            if (paramInt2 != 1) {
              break label320;
            }
            l1 = 5040302L;
            continue;
          }
          if (uks.h(paramBaseArticleInfo))
          {
            l2 = 50402L;
            if (paramInt2 != 1) {
              break label328;
            }
            l1 = 5040202L;
            continue;
          }
          if (uks.i(paramBaseArticleInfo))
          {
            l2 = 50406L;
            if (paramInt2 != 1) {
              break label336;
            }
            l1 = 5040602L;
            continue;
          }
          if (!uks.f(paramBaseArticleInfo)) {
            break label305;
          }
          l2 = 50401L;
          if (paramInt2 != 1) {
            break label344;
          }
          l1 = 5040104L;
          continue;
        }
        localObject = paramBaseArticleInfo.mSubscribeName;
        continue;
        paramBaseArticleInfo = paramBaseArticleInfo.mSmallMiniGameInfo.k;
        continue;
        long l2 = 0L;
      }
      catch (Exception paramContext)
      {
        b(" report mini game error :", paramContext.getMessage());
        return;
      }
      label305:
      continue;
      label311:
      return;
      label312:
      l1 = 5040401L;
      continue;
      label320:
      l1 = 5040301L;
      continue;
      label328:
      l1 = 5040201L;
      continue;
      label336:
      l1 = 5040601L;
      continue;
      label344:
      l1 = 5040103L;
      continue;
      label352:
      l1 = 6L;
    }
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramContext != null) && (paramBaseArticleInfo != null)) {}
    for (;;)
    {
      try
      {
        if ((paramBaseArticleInfo.mSmallMiniGameInfo == null) || (paramBaseArticleInfo.mSmallMiniGameInfo.a == null)) {
          break label210;
        }
        if (paramInt3 != 2) {
          break label211;
        }
        l = 5010103L;
        String str;
        if (paramBaseArticleInfo.mSmallMiniGameInfo.a())
        {
          str = "3";
          paramBaseArticleInfo = (ugf)paramBaseArticleInfo.mSmallMiniGameInfo.a.get(paramInt2);
          if (paramBaseArticleInfo == null) {
            break label205;
          }
          ogz localogz = new ogz().a(501L).b(50101L).c(l);
          if (paramInt3 == 1)
          {
            l = 3L;
            paramBaseArticleInfo = localogz.d(l).d(paramBaseArticleInfo.jdField_a_of_type_JavaLangString).i(String.valueOf(paramInt1)).c(paramBaseArticleInfo.jdField_d_of_type_JavaLangString).e(paramBaseArticleInfo.jdField_c_of_type_JavaLangString).f(String.valueOf(paramInt2 + 1)).g(paramBaseArticleInfo.jdField_b_of_type_JavaLangString).h(str).a();
            if (paramBaseArticleInfo == null) {
              break label210;
            }
            a(paramContext, paramBaseArticleInfo);
          }
        }
        else
        {
          str = "2";
          continue;
        }
        l = 6L;
        continue;
        paramBaseArticleInfo = null;
      }
      catch (Exception paramContext)
      {
        b(" report mini game error :", paramContext.getMessage());
        return;
      }
      label205:
      continue;
      label210:
      return;
      label211:
      long l = 5010104L;
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    boolean bool = uks.a(paramContext, paramString);
    ukq.a("NativeAdUtils", "launchResult = " + bool);
  }
  
  public static void a(Context paramContext, ogx paramogx)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("page_id", paramogx.jdField_a_of_type_Long);
      localJSONObject.put("oper_module", paramogx.jdField_b_of_type_Long);
      localJSONObject.put("oper_id", paramogx.jdField_c_of_type_Long);
      localJSONObject.put("oper_type", paramogx.jdField_d_of_type_Long);
      localJSONObject.put("obj_id", paramogx.jdField_a_of_type_JavaLangString);
      localJSONObject.put("obj_type", paramogx.jdField_b_of_type_JavaLangString);
      localJSONObject.put("game_pkg", paramogx.jdField_c_of_type_JavaLangString);
      localJSONObject.put("app_id", paramogx.jdField_d_of_type_JavaLangString);
      localJSONObject.put("ex1", paramogx.jdField_e_of_type_JavaLangString);
      localJSONObject.put("ex2", paramogx.jdField_f_of_type_JavaLangString);
      localJSONObject.put("ex3", paramogx.jdField_g_of_type_JavaLangString);
      localJSONObject.put("ex4", paramogx.jdField_h_of_type_JavaLangString);
      localJSONObject.put("loc_id", paramogx.i);
      paramogx = new JSONObject();
      paramogx.put("game_gift_report", String.valueOf(localJSONObject));
      a(new ufy().a(paramContext).a(119).b(39).a(JumpMode.MINIGAME).e(paramogx).a());
      return;
    }
    catch (Exception paramContext)
    {
      b("reportMiniGameAd error :", paramContext.getMessage());
    }
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mC2SSwitch == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, " C2S AD_EXPOSURE: advertisementInfo = " + paramAdvertisementInfo.toString() + " clickurl = " + paramAdvertisementInfo.mC2SClickUrl + " exposureUrl = " + paramAdvertisementInfo.mC2SExposureUrl);
      }
      achv.a(0, 1, uvp.a(paramAdvertisementInfo));
    }
    do
    {
      do
      {
        return;
      } while ((paramVideoAdInfo == null) || (paramVideoAdInfo.jdField_p_of_type_Int != 1));
      paramAdvertisementInfo = a(paramVideoAdInfo);
    } while (paramAdvertisementInfo == null);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, " C2S AD_EXPOSURE: advertisementInfo1 = " + paramAdvertisementInfo.toString() + " videoAdInfo = " + paramVideoAdInfo.toString() + " clickurl = " + paramAdvertisementInfo.mC2SClickUrl + " exposureUrl = " + paramAdvertisementInfo.mC2SExposureUrl);
    }
    achv.a(0, 1, uvp.a(paramAdvertisementInfo));
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, ArrayList<String> paramArrayList1, String paramString, ArrayList<String> paramArrayList2, int paramInt)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mC2SSwitch == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo = " + paramAdvertisementInfo.toString() + " clickurl = " + paramArrayList1 + paramString + paramArrayList2);
      }
      achv.a(paramInt, 1, uvp.a(paramAdvertisementInfo));
    }
    do
    {
      do
      {
        return;
      } while ((paramVideoAdInfo == null) || (paramVideoAdInfo.jdField_p_of_type_Int != 1));
      paramAdvertisementInfo = a(paramVideoAdInfo);
    } while ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mC2SSwitch != 1));
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo1 = " + paramAdvertisementInfo.toString() + " videoAdInfo = " + paramVideoAdInfo.toString() + " clickurl = " + paramArrayList1 + paramString + paramArrayList2);
    }
    achv.a(paramInt, 1, uvp.a(paramAdvertisementInfo));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    if (ukr.a(paramAdData))
    {
      a(new ufy().a(paramQQAppInterface).a(BaseApplication.getContext()).a(81).b(a(paramAdData)).a(ukt.a(paramAdData)).d(a(paramAdData)).a());
      return;
    }
    a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 81, 1, null).toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, float paramFloat, long paramLong, boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("exposureArea", paramFloat);
      localJSONObject.put("exposureTime", paramLong);
      if (ukr.a(paramAdData))
      {
        paramAdData = new ufy().a(paramQQAppInterface).a(BaseApplication.getContext()).a(2).b(a(paramAdData)).a(ukt.a(paramAdData)).c(localJSONObject).d(a(paramAdData));
        if (paramBoolean)
        {
          paramQQAppInterface = ExposeMode.LOOSE;
          a(paramAdData.a(paramQQAppInterface).b(paramBoolean).a());
          return;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      do
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          continue;
          paramQQAppInterface = ExposeMode.STRICT;
        }
      } while (paramBoolean);
      a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 5, 1, localJSONObject).toString());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, int paramInt, JumpMode paramJumpMode)
  {
    if (ukr.a(paramAdData, false))
    {
      a(new ufy().a(paramQQAppInterface).a(BaseApplication.getContext()).a(1).a(paramJumpMode).b(1).a(ukt.a(paramAdData)).d(a(paramAdData)).d(paramInt).a());
      return;
    }
    a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 1, 3, null).toString());
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, JumpMode paramJumpMode)
  {
    a(paramQQAppInterface, paramAdData, 0, paramJumpMode);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData, boolean paramBoolean)
  {
    if ((paramQQAppInterface == null) || (paramAdData == null)) {
      return;
    }
    if (ukr.a(paramAdData))
    {
      ufy localufy = new ufy().a(paramQQAppInterface).a(BaseApplication.getContext()).a(2).b(a(paramAdData)).a(ukt.a(paramAdData)).d(a(paramAdData));
      if (paramBoolean)
      {
        paramQQAppInterface = ExposeMode.LOOSE;
        label67:
        a(localufy.a(paramQQAppInterface).b(paramBoolean).a());
      }
    }
    for (;;)
    {
      QLog.d("Q.readinjoy.fast_web", 2, " reportNativeEngineAdExposure " + paramAdData.jdField_b_of_type_JavaLangString + "  : " + paramAdData.jdField_c_of_type_JavaLangString);
      return;
      paramQQAppInterface = ExposeMode.STRICT;
      break label67;
      if (paramBoolean) {
        break;
      }
      a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 5, 1, null).toString());
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      b("nativeEngineAdReport json:", paramString);
      if (!TextUtils.isEmpty(paramString))
      {
        WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
        localWebSsoRequestBody.data.set(paramString);
        paramString = new NewIntent(paramQQAppInterface.getApplication(), oln.class);
        paramString.putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_report");
        paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
        paramString.setObserver(new oiu());
        paramQQAppInterface.startServlet(paramString);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    bdla.b(paramQQAppInterface, "dc04719", "ad", "0", paramString1.toUpperCase(), paramString2.toUpperCase(), paramInt1, paramInt2, paramString3, paramString4, paramString5, paramString6);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramQQAppInterface.getCurrentUin());
      localJSONObject.put("adId", paramString1);
      localJSONObject.put("channelId", paramString2);
      localJSONObject.put("info", paramString3);
      localJSONObject.put("version", "8.4.10");
      localJSONObject.put("actionCode", paramInt1);
      localJSONObject.put("subType", paramInt2);
      if (paramInt1 == 4) {
        localJSONObject.put("extValue", paramInt3);
      }
      paramString2 = localJSONObject.toString();
      b("doAdReport json:", paramString2);
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = new WebSsoBody.WebSsoRequestBody();
        paramString1.data.set(paramString2);
        paramString2 = new NewIntent(paramQQAppInterface.getApplication(), oln.class);
        paramString2.putExtra("cmd", "KdAdReportSsoSvr.kandian_ad");
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(new oit());
        paramQQAppInterface.startServlet(paramString2);
      }
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public static void a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    try
    {
      jdField_a_of_type_JavaLangString = str;
      ThreadManager.executeOnFileThread(new NativeAdUtils.5(str));
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static void a(JSONObject paramJSONObject, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramJSONObject != null) && (paramAdvertisementInfo != null) && (paramAdvertisementInfo.gameAdComData != null)) {}
    while ((paramJSONObject == null) || (paramAdvertisementInfo == null) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdExtInfo))) {
      try
      {
        paramJSONObject.put("pkg_name", paramAdvertisementInfo.gameAdComData.jdField_d_of_type_JavaLangString);
        paramJSONObject.put("game_adtag", new JSONObject(paramAdvertisementInfo.gameAdComData.B).optString("ADTAG"));
        return;
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
    }
    try
    {
      paramJSONObject.put("extra_data", paramAdvertisementInfo.mAdExtInfo);
      paramAdvertisementInfo = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
      paramJSONObject.put("game_adtag", paramAdvertisementInfo.optString("game_adtag"));
      paramJSONObject.put("pkg_name", paramAdvertisementInfo.optString("game_pkg_name"));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public static void a(ufw paramufw)
  {
    if (paramufw == null) {}
    AppInterface localAppInterface;
    do
    {
      return;
      localAppInterface = a(paramufw);
    } while (localAppInterface == null);
    Context localContext = paramufw.a();
    int i = paramufw.a();
    int j = paramufw.b();
    AdvertisementInfo localAdvertisementInfo = paramufw.a();
    VideoAdInfo localVideoAdInfo = paramufw.a();
    long l = paramufw.a();
    String str1 = paramufw.a();
    JSONObject localJSONObject1 = paramufw.a();
    int k = paramufw.d();
    JSONObject localJSONObject2 = paramufw.b();
    Bundle localBundle = paramufw.a();
    JSONObject localJSONObject3 = paramufw.c();
    JSONObject localJSONObject4 = paramufw.d();
    JSONObject localJSONObject5 = paramufw.f();
    JSONObject localJSONObject6 = paramufw.e();
    int m = paramufw.c();
    boolean bool2 = paramufw.a();
    String str2 = localAppInterface.getAccount();
    if ((localAdvertisementInfo != null) && (localAdvertisementInfo.mSoftAdType != 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ThreadManager.post(new NativeAdUtils.3(localJSONObject3, str2, i, j, m, localContext, localAdvertisementInfo, localVideoAdInfo, k, localJSONObject1, localJSONObject2, localBundle, str1, l, localJSONObject4, localJSONObject6, paramufw, localJSONObject5, bool1, localAppInterface, bool2), 5, null, true);
      return;
    }
  }
  
  private static boolean a()
  {
    boolean bool2 = true;
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    boolean bool1;
    if (localBaseActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "getADPosition activity null");
      }
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (Build.VERSION.SDK_INT < 23);
      bool1 = bool2;
    } while (localBaseActivity.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0);
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool1;
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = bhfn.a(paramContext, paramString);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isAppInstall pkg:" + paramString + " " + bool2);
    return bool2;
  }
  
  public static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof AdvertisementInfo)) {}
    for (;;)
    {
      return false;
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (paramBaseArticleInfo.mLocalInfo != null) {
        try
        {
          String str1 = paramBaseArticleInfo.mLocalInfo.jdField_d_of_type_JavaLangString;
          double d = Double.parseDouble(paramBaseArticleInfo.mLocalInfo.jdField_e_of_type_JavaLangString);
          if ((Double.parseDouble(str1) != 0.0D) || (d != 0.0D))
          {
            str1 = paramBaseArticleInfo.mLocalInfo.jdField_c_of_type_JavaLangString;
            String str2 = paramBaseArticleInfo.mLocalInfo.jdField_f_of_type_JavaLangString;
            paramBaseArticleInfo = paramBaseArticleInfo.mLocalInfo.jdField_b_of_type_JavaLangString;
            if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
            {
              boolean bool = TextUtils.isEmpty(paramBaseArticleInfo);
              if (!bool)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("NativeAdUtils", 2, "hasAddLocationInfo is -> true");
                }
                return true;
              }
            }
          }
        }
        catch (Exception paramBaseArticleInfo) {}
      }
    }
    return false;
  }
  
  public static boolean a(ohb paramohb)
  {
    String str1 = paramohb.jdField_f_of_type_JavaLangString;
    String str2 = paramohb.jdField_d_of_type_JavaLangString;
    String str3 = paramohb.jdField_j_of_type_JavaLangString;
    paramohb = paramohb.i;
    Bundle localBundle = new Bundle();
    localBundle.putInt(bjmy.k, 5);
    localBundle.putString(bjmy.jdField_f_of_type_JavaLangString, str1);
    localBundle.putString(bjmy.jdField_b_of_type_JavaLangString, str2);
    localBundle.putString(bjmy.jdField_j_of_type_JavaLangString, str3);
    localBundle.putString(bjmy.jdField_l_of_type_JavaLangString, paramohb);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "installApk pkg:" + str1 + ", appid:" + str2 + ", name:" + paramohb + ", url:" + str3);
    }
    return bjmu.a(localBundle);
  }
  
  public static double[] a(BaseArticleInfo paramBaseArticleInfo)
  {
    if (!(paramBaseArticleInfo instanceof AdvertisementInfo)) {}
    for (;;)
    {
      return null;
      paramBaseArticleInfo = (AdvertisementInfo)paramBaseArticleInfo;
      if (paramBaseArticleInfo.mLocalInfo != null) {
        try
        {
          String str = paramBaseArticleInfo.mLocalInfo.jdField_d_of_type_JavaLangString;
          double d1 = oix.a(paramBaseArticleInfo.mLocalInfo.jdField_e_of_type_JavaLangString, 0.0D);
          double d2 = oix.a(str, 0.0D);
          if ((d2 != 0.0D) || (d1 != 0.0D)) {
            return new double[] { d1, d2 };
          }
        }
        catch (Exception paramBaseArticleInfo) {}
      }
    }
    return null;
  }
  
  private static JSONObject b(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("dma", ujw.c());
        localJSONObject.put("hwm", DeviceInfoUtil.getModel());
        localJSONObject.put("hwma", DeviceInfoUtil.getManufactureInfo());
        localJSONObject.put("osver", DeviceInfoUtil.getDeviceOSVersion());
        localJSONObject.put("imei", ujw.a());
        localJSONObject.put("brd", DeviceInfoUtil.getManufacturer());
        localJSONObject.put("ns", HttpUtil.getNetWorkTypeByStr());
        localJSONObject.put("andid", Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
        localJSONObject.put("mid", "mid");
        localJSONObject.put("pf", "android");
        localJSONObject.put("wn", zei.c(paramContext));
        str = "";
        switch (ankm.b())
        {
        case 1: 
          localJSONObject.put("mnc", str);
          localJSONObject.put("rma", prb.c(paramContext));
          return localJSONObject;
        }
      }
      catch (Exception paramContext)
      {
        String str;
        paramContext.printStackTrace();
        return localJSONObject;
      }
      str = anvx.a(2131706541);
      continue;
      str = anvx.a(2131706539);
      continue;
      str = anvx.a(2131706537);
    }
  }
  
  @NotNull
  private static JSONObject b(Bundle paramBundle, String paramString, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBundle != null)
    {
      localJSONObject.put("type_id", 2);
      localJSONObject.put("tel", paramBundle.getString("ad_complain_tel", ""));
      localJSONObject.put("txt", paramBundle.getString("ad_complain_txt", ""));
      return localJSONObject;
    }
    localJSONObject.put("type_id", 1);
    if (TextUtils.isEmpty(paramString))
    {
      localJSONObject.put("neg_ids", String.valueOf(paramLong));
      return localJSONObject;
    }
    localJSONObject.put("neg_ids", paramString);
    return localJSONObject;
  }
  
  @NotNull
  private static JSONObject b(JSONObject paramJSONObject, int paramInt, AdvertisementInfo paramAdvertisementInfo)
  {
    new JSONObject();
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    localJSONObject.put("type", ukj.a(paramInt));
    localJSONObject.put("interaction_report_url", paramAdvertisementInfo.mAdInteractionReportUrl);
    localJSONObject.put("effect_url", paramAdvertisementInfo.mAdEffectUrl);
    return localJSONObject;
  }
  
  private static void b(int paramInt, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    if (paramInt == 2) {
      a(paramAdvertisementInfo, paramVideoAdInfo);
    }
    if (paramInt == 1) {
      b(paramAdvertisementInfo, paramVideoAdInfo, paramAdvertisementInfo.mC2SClickUrl, " exposureUrl = ", paramAdvertisementInfo.mC2SExposureUrl, 1);
    }
    if (paramInt == 27) {
      a(paramAdvertisementInfo, paramVideoAdInfo, paramAdvertisementInfo.mC2SVideoPlayUrl, " videoClickUrl = ", paramAdvertisementInfo.mC2SVideoPlayUrl, 2);
    }
  }
  
  private static void b(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, ArrayList<String> paramArrayList1, String paramString, ArrayList<String> paramArrayList2, int paramInt)
  {
    if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.mC2SSwitch == 1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo = " + paramAdvertisementInfo.toString() + " clickurl = " + paramArrayList1 + paramString + paramArrayList2);
      }
      achv.a(paramInt, 1, uvp.a(paramAdvertisementInfo));
    }
    do
    {
      do
      {
        return;
      } while ((paramVideoAdInfo == null) || (paramVideoAdInfo.jdField_p_of_type_Int != 1));
      paramAdvertisementInfo = a(paramVideoAdInfo);
    } while ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mC2SSwitch != 1));
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, " C2S AD_CLICK: advertisementInfo1 = " + paramAdvertisementInfo.toString() + " videoAdInfo = " + paramVideoAdInfo.toString() + " clickurl = " + paramArrayList1 + paramString + paramArrayList2);
    }
    achv.a(paramInt, 1, uvp.a(paramAdvertisementInfo));
  }
  
  private static void b(String paramString, AppInterface paramAppInterface, AdvertisementInfo paramAdvertisementInfo, ufw paramufw, int paramInt)
  {
    WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
    localWebSsoRequestBody.data.set(paramString);
    paramString = new NewIntent(paramAppInterface.getApplication(), oln.class);
    paramString.putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_report_new");
    paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
    paramString.setObserver(new oiv(paramAdvertisementInfo, paramufw, paramInt));
    paramAppInterface.startServlet(paramString);
  }
  
  private static void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, paramString1 + paramString2);
    }
  }
  
  private static boolean b(int paramInt1, int paramInt2, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo)
  {
    if ((paramInt2 == 27) || (paramInt1 == 26)) {
      return true;
    }
    if ((uks.j(paramAdvertisementInfo)) && (paramInt1 == 2))
    {
      if (paramInt2 != 37)
      {
        ukq.a("ReadInJoySuperMaskAd", "inner mask, do not report c2s");
        return true;
      }
      if (uks.m(paramAdvertisementInfo))
      {
        ukq.a("ReadInJoySuperMaskAd", "wide mask expose, do not report c2s");
        return true;
      }
      return false;
    }
    return false;
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (uks.j(paramAdvertisementInfo)) {}
    while (paramInt == 37) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ois
 * JD-Core Version:    0.7.0.1
 */