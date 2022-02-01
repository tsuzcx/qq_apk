import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.NativeAd.fragment.NativeAdVideoFragment;
import com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdAppFragment;
import com.tencent.biz.pubaccount.VideoInfo.GameAdComData;
import com.tencent.biz.pubaccount.readinjoy.ad.fragment.ReadinjoyAdPKFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoCeilingFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.views.video.GdtVideoData;
import com.tencent.gdtad.views.videoceiling.GdtVideoCeilingData;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

public class oli
{
  private static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    switch (paramAdvertisementInfo.mAdJumpMode)
    {
    }
    do
    {
      do
      {
        return 2;
        return 3;
      } while (TextUtils.isEmpty(paramAdvertisementInfo.mAdAppJson));
      return 5;
      return 4;
      return 6;
    } while (TextUtils.isEmpty(paramAdvertisementInfo.mAdLandingPage));
    return 1;
  }
  
  private static String a(AdvertisementInfo paramAdvertisementInfo)
  {
    if (opz.a(paramAdvertisementInfo)) {
      return a(paramAdvertisementInfo.gameAdComData.p, paramAdvertisementInfo.gameAdComData.q, "");
    }
    if (paramAdvertisementInfo.isSoftAd()) {
      return a(paramAdvertisementInfo.mAdvertisementSoftInfo.f, paramAdvertisementInfo.mAdvertisementSoftInfo.h, "");
    }
    return paramAdvertisementInfo.mAdLandingPage;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      return ubb.a(paramString2);
      if (!TextUtils.isEmpty(paramString3)) {
        paramString2 = paramString3;
      } else {
        paramString2 = paramString1;
      }
    }
  }
  
  private static void a(Activity paramActivity, AdvertisementInfo paramAdvertisementInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("param_ad_info", paramAdvertisementInfo);
    ReadinjoyAdPKFragment.a(paramActivity, ReadinjoyAdPKFragment.class, localBundle);
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, int paramInt)
  {
    Bundle localBundle = new Bundle();
    pey.a(localBundle, paramAdvertisementInfo);
    localBundle.putLong("param_ad_app_info_video_playposition", paramInt);
    ubb.a(paramActivity);
    NativeAdVideoFragment.a(paramActivity, NativeAdVideoFragment.class, localBundle);
  }
  
  private static void a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, olj paramolj)
  {
    String str = paramAdvertisementInfo.mAdAppJson;
    Bundle localBundle = new Bundle();
    localBundle.putString("param_ad_json", str);
    localBundle.putString("param_ad_app_info_trace_id", paramAdvertisementInfo.mAdTraceId);
    localBundle.putLong("param_ad_app_info_pull_time", paramAdvertisementInfo.mAdFetchTime);
    localBundle.putString("param_ad_app_info_view_id", paramAdvertisementInfo.mAdViewId);
    localBundle.putLong("param_ad_app_info_pos_id", paramAdvertisementInfo.mAdPosID);
    localBundle.putInt("param_ad_app_info_kd_pos", paramAdvertisementInfo.mAdKdPos);
    localBundle.putString("param_ad_app_info_product_id", paramAdvertisementInfo.mAdProductId);
    localBundle.putInt("param_ad_app_info_product_type", paramAdvertisementInfo.mAdProductType);
    localBundle.putString("param_ad_app_info_ap_url", paramAdvertisementInfo.mAdApurl);
    localBundle.putLong("param_ad_app_info_video_playposition", paramolj.b);
    ubb.a(paramActivity);
    ReadInJoyNativeAdAppFragment.a(paramActivity, ReadInJoyNativeAdAppFragment.class, localBundle);
  }
  
  private static void a(String paramString, Activity paramActivity)
  {
    pha.d(paramActivity, paramString);
    oqh.a("ReadInJoyAdJumpUtils", "jumpUrl 。url = " + paramString);
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null)) {}
    while ((!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.h)) || (TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.g))) {
      return false;
    }
    return true;
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity)
  {
    return a(paramAdvertisementInfo, paramActivity, null, null);
  }
  
  private static boolean a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, GdtHandler.Params paramParams, olj paramolj)
  {
    boolean bool = false;
    if (paramParams == null) {
      return false;
    }
    if ((paramAdvertisementInfo.mChannelID == 0L) || (paramAdvertisementInfo.mChannelID == 2L) || (paramAdvertisementInfo.isCommentAd())) {
      bool = oqi.b(paramAdvertisementInfo);
    }
    paramParams.f = bool;
    return a(paramParams, paramActivity, paramAdvertisementInfo);
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, olj paramolj)
  {
    return a(paramAdvertisementInfo, paramActivity, paramolj, null);
  }
  
  public static boolean a(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, olj paramolj, olh paramolh)
  {
    ubb.a(paramActivity);
    int i = olf.a(paramAdvertisementInfo);
    oqh.a("ReadInJoyAdJumpUtils", "adType = " + i);
    boolean bool;
    switch (i)
    {
    case 5: 
    default: 
      a(a(paramAdvertisementInfo), paramActivity);
    case 2: 
    case 6: 
      do
      {
        return false;
      } while (paramolh == null);
      paramolh.a(paramAdvertisementInfo, paramActivity);
      return false;
    case 4: 
      if (a(paramAdvertisementInfo))
      {
        bool = a(paramAdvertisementInfo.mAdvertisementSoftInfo.g, paramActivity);
        oqh.a("ReadInJoyAdJumpUtils", "jumpScheme result = " + bool);
      }
      break;
    }
    while (!bool)
    {
      a(a(paramAdvertisementInfo), paramActivity);
      return false;
      a(paramActivity, paramAdvertisementInfo);
      return false;
      paramolh = paramolj;
      if (paramolj == null) {
        paramolh = new olj();
      }
      if (b(paramAdvertisementInfo, paramActivity, paramolh))
      {
        oqh.a("ReadInJoyAdJumpUtils", "jumpToGdt" + paramolh.toString());
        return true;
      }
      a(a(paramAdvertisementInfo), paramActivity);
      return false;
      bool = false;
    }
  }
  
  private static boolean a(GdtHandler.Params paramParams, Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramParams == null) || (paramAdvertisementInfo == null) || (paramContext == null)) {
      return false;
    }
    oqj.b(paramAdvertisementInfo);
    GdtHandler.a(paramParams);
    oqh.a("ReadInJoyAdJumpUtils", "jumpToGdtAdRealPage");
    return true;
  }
  
  private static boolean a(String paramString, Activity paramActivity)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setAction("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      localIntent.putExtra("big_brother_source_key", "biz_src_feeds_kandianads");
      localIntent.putExtra("big_brother_ref_source_key", "biz_src_feeds_kandian");
      paramString = localIntent.resolveActivityInfo(paramActivity.getPackageManager(), 0);
      if (paramString == null)
      {
        oqh.a("ReadInJoyAdJumpUtils", "jumpScheme: ActivityInfo = null");
        return false;
      }
      oqh.a("ReadInJoyAdJumpUtils", "jumpScheme: packageName = " + paramString.packageName);
      if (!TextUtils.isEmpty(paramString.packageName))
      {
        ubb.a(paramActivity);
        paramActivity.startActivity(localIntent);
        return true;
      }
    }
    catch (Exception paramString)
    {
      oqh.a("ReadInJoyAdJumpUtils", "jumpScheme: e = " + paramString.getMessage());
    }
    return false;
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, GdtHandler.Params paramParams, olj paramolj)
  {
    if (paramParams == null) {
      return false;
    }
    return a(paramParams, paramActivity, paramAdvertisementInfo);
  }
  
  private static boolean b(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, olj paramolj)
  {
    int i = a(paramAdvertisementInfo);
    oqh.a("ReadInJoyAdJumpUtils", "gdtType = " + i);
    olj localolj = paramolj;
    if (paramolj == null) {
      localolj = new olj();
    }
    paramolj = olg.a(paramAdvertisementInfo, paramActivity, localolj);
    switch (i)
    {
    default: 
      return false;
    case 2: 
      return b(paramAdvertisementInfo, paramActivity, paramolj, localolj);
    case 3: 
      return a(paramAdvertisementInfo, paramActivity, paramolj, localolj);
    case 4: 
      return c(paramAdvertisementInfo, paramActivity, paramolj, localolj);
    case 5: 
      a(paramAdvertisementInfo, paramActivity, localolj);
      return true;
    }
    a(paramAdvertisementInfo, paramActivity, localolj.b);
    return true;
  }
  
  private static boolean c(AdvertisementInfo paramAdvertisementInfo, Activity paramActivity, GdtHandler.Params paramParams, olj paramolj)
  {
    if (paramParams == null) {
      return false;
    }
    paramParams.d = true;
    paramParams.c = true;
    if (a(paramParams, paramActivity, paramAdvertisementInfo)) {
      return true;
    }
    paramolj = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo();
    paramolj.aid.set(paramAdvertisementInfo.mAdAid);
    paramolj.traceid.set(paramAdvertisementInfo.mAdTraceId);
    paramolj.view_id.set(paramAdvertisementInfo.mAdViewId);
    paramParams = new qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo();
    paramParams.exposure_url.set(paramAdvertisementInfo.mAdApurl);
    paramParams.click_url.set(paramAdvertisementInfo.mAdRl);
    paramParams.trace_info.set(paramolj);
    paramolj = new qq_ad_get.QQAdGetRsp.AdInfo();
    paramolj.report_info.set(paramParams);
    GdtAd localGdtAd = new GdtAd(paramolj);
    GdtVideoData localGdtVideoData = new GdtVideoData();
    localGdtVideoData.setLoop(true);
    localGdtVideoData.setAd(localGdtAd);
    localGdtVideoData.setStartPositionMillis(0L);
    localGdtVideoData.setUrl(paramAdvertisementInfo.mAdVideoUrl);
    paramolj = paramAdvertisementInfo.mAdLandingPage;
    paramParams = paramolj;
    if (AdvertisementInfo.isAppAdvertisementInfo(paramAdvertisementInfo))
    {
      paramParams = Uri.parse(paramolj).buildUpon();
      if ((bgnt.b(BaseApplicationImpl.getApplication()) != 1) || (paramAdvertisementInfo.mChannelID == 0L)) {
        break label295;
      }
      paramParams.appendQueryParameter("autodownload", "1");
    }
    for (;;)
    {
      paramParams = paramParams.toString();
      paramAdvertisementInfo = new GdtVideoCeilingData();
      paramAdvertisementInfo.setVideoData(localGdtVideoData);
      paramAdvertisementInfo.setAd(localGdtAd);
      paramAdvertisementInfo.setWebUrl(paramParams);
      if (paramAdvertisementInfo.getStyle() == -2147483648) {
        paramAdvertisementInfo.setStyle(1);
      }
      paramParams = new Bundle();
      paramParams.putString("big_brother_ref_source_key", "biz_src_feeds_kandian");
      ReadInJoyVideoCeilingFragment.a(paramActivity, ReadInJoyVideoCeilingFragment.class, paramAdvertisementInfo, paramParams);
      return false;
      label295:
      paramParams.appendQueryParameter("autodownload", "0");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oli
 * JD-Core Version:    0.7.0.1
 */